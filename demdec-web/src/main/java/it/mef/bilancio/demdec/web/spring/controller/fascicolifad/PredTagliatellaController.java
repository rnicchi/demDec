package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.apache.poi.hssf.util.HSSFColor.BLUE;
//import org.apache.poi.hssf.util.HSSFColor.BLUE_GREY;
//import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.crystaldecisions.sdk.occa.report.formatteddefinition.model.Blob;
import java.sql.Blob;

import it.almavivaitalia.bilancio.commons.bo.AnagTipoRiepilogoBO;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.RiepilogoDatiAnagBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagTipoRiepilogoTO;

/**
 * 
 */

//import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagTipologiaTagliaTO;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.utils.DateUtil;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
//import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.DozerDriver;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
//import it.consip.pat.common.constants.ICommonWebConstants;
//import it.consip.pat.common.model.Decreto;
//import it.consip.pat.common.model.DecretoAmministrazione;
//import it.consip.pat.common.model.LetteraIgb;
//import it.consip.pat.common.model.bilancio.CentroResponsabilita;
//import it.consip.pat.common.model.type.NumeroTitolo;
//import it.consip.rpp.core.constants.IFunzioniConstants;
//import it.consip.rpp.core.constants.IHelpConstants;
//import it.consip.rpp.core.decreto.business.manager.DecretoManager;
//import it.consip.rpp.core.decreto.business.manager.letterePreRegManager;
//import it.consip.rpp.web.common.constants.ISessionConstants;
//import it.consip.rpp.web.common.constants.IWebConstants;
//import it.consip.rpp.web.common.controllers.AbstractController;
import it.mef.bilancio.demdec.manager.LetterePreRegManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.RiepilogoAdDemManager;
import it.mef.bilancio.demdec.manager.UploadDecManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.UtilRequestClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.to.AmminRagDemTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.LettereIgbTO;
//import it.mef.bilancio.demdec.to.LettereIgbTO;
import it.mef.bilancio.demdec.to.RiepilogoAdDemTO;
import it.mef.bilancio.demdec.to.RiepilogoDatiAnagTO;
import it.mef.bilancio.demdec.to.StrumentoTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;
import it.mef.bilancio.demdec.utils.Constants;
//import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.GestioneFascicoloFadForm;
import it.mef.bilancio.demdec.web.spring.form.PredTagliatellaForm;
//import it.mef.bilancio.demdec.web.spring.form.ConsultaFascicoloFadForm;
//import it.mef.bilancio.demdec.web.spring.form.PredLetterePreRegForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
//import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;
//import javax.persistence.criteria.JoinType;
/**
 * @author RNicchi
 *
 */


@RequestMapping(value = ConstantsRequestMapping.PREDISPOSIZIONE_TAGLIATELLA)
public class PredTagliatellaController extends AbstractDemFormController implements WebConstants, SessionAttributes{
	

	
	private static Logger _LOG = Logger.getLogger(PredTagliatellaController.class);
	
	private String startView;	
	 
	private String listaDecretiView;
	
	private String predDecretoPerTagliatellaView;
		
	 @Autowired
	 private ListManager listManager;

	 @Autowired
	 private LetterePreRegManager letterePreRegManager;
	 
	 @Autowired
	 private RiepilogoAdDemManager riepilogoAdDemManager;
	 
	@Autowired 
	private GestioneFadManager gestioneFadManager;
		
	public GestioneFadManager getGestioneFadManager() {
		return gestioneFadManager;
	}
	
	@Autowired 
	private UploadDecManager uploadDecManager;
	 
	 
	 public void setStartView(String startView) {
			this.startView = startView;
	}
	 
 
	 public void setListaDecretiView(String listaDecretiView) {
			this.listaDecretiView = listaDecretiView;
		}


	public void setPredDecretoPerTagliatellaView(String predDecretoPerTagliatellaView) {
		this.predDecretoPerTagliatellaView = predDecretoPerTagliatellaView;
	}


	

	@Override
		public String startController(Context context) throws Throwable {
			
			context.removeDataModel(SessionAttributes.LIST_FASCICOLI_FAD);	
		
			context.setCurrentNode("DemDec.menu.PredisposizioneTagliatella");
			context.setDataModel(SessionAttributes.LIST_ANNO_ESE, listManager.loadEserciziDemCG());
			context.setDataModel(SessionAttributes.LIST_TIPI_DECRETI, listManager.loadAnagTipoDecreto());
			context.setDataModel(SessionAttributes.LIST_ANAG_UFF, listManager.loadAnagUfficiAttivi());
			
			
			
			return startView;
	 }
	 
	 	

	 public String onRicercaDecreti(Context context)throws Throwable{
		 PredTagliatellaForm form=(PredTagliatellaForm) context.getForm();
			if(!form.isValid()){
				return startView;
			}
			
			FascicoliFadSearhTO to = new FascicoliFadSearhTO();

			to.setAnnoDecreto(form.getAnnoDecreto());
			to.setNumeDecreto(form.getNumeDecreto());
			to.setTipoDecreto(form.getTipoDecreto());
			
			if(!form.getAmministrazione().isEmpty()){
				to.setNumStp(form.getAmministrazione().substring(0,2));
				to.setNumeApp(form.getAmministrazione().substring(2));
			}
			
			if(!form.getUfficio().isEmpty()){
			to.setUfficio(form.getUfficio());
			}
			
			//java.util.
			List<FascicoliTO> lista = getGestioneFadManager().getFascicoliFad(to);
			
			List<FascicoliTO> listaAggiornata = new ArrayList<FascicoliTO>();
			
			
			for(int i = 0; i < lista.size(); i++)
			{
				FascicoliTO fto = lista.get(i);
				
				long id = fto.getId();
				
				
					
					RiepilogoDatiAnagTO riepilogoTO = getGestioneFadManager().findFascicoloAggiornatoTO(id);
					
					if(riepilogoTO!= null)
					{
						String desc = riepilogoTO.getDescRiepilogo();
						fto.setDescDecreto(desc);
						fto.setFlagRiepilogoInvioFad(riepilogoTO.getBinaIntReport() == null? 0 : 1);
						
						listaAggiornata.add(fto);
					}
					else
					{
						listaAggiornata.add(fto);
					}
				
		
			//	FascicoliTO ftoAggiornato = getGestioneFadManager().findFascicoloAggiornato(fto);
				
			/*	String descrizioneAggiornata = getGestioneFadManager().findDescFascicoloAggiornata(fto);
				if(fto.getDescDecreto().equals(descrizioneAggiornata))*/
				
				
				
			}
			
			context.setDataModel(SessionAttributes.LIST_FASCICOLI_FAD, listaAggiornata);
			
			
			//prima era solo "lista"
			if (listaAggiornata==null || listaAggiornata.size()==0){
				PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
				context.addWarning("warning.empty");
				return startView;
			}
			PaginatorUtil.addPaginator(listaAggiornata, LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);
			
			return  listaDecretiView;
		}
	 
	 public String onPredisponi(Context context)throws Throwable{
		 PredTagliatellaForm form=(PredTagliatellaForm) context.getForm();
			if(!form.isValid()){
				return listaDecretiView;
			}
			
			form.getNumeDecreto();
			
			java.util.List<FascicoliTO> listFascicoli=context.getModel(LIST_FASCICOLI_FAD);
			
			
			String rowNum =null;
			rowNum=getParameter(context, "predisponi");
			form.setRadioButtonDecreti(rowNum);
			
			FascicoliTO fascicolo=listFascicoli.get(Integer.valueOf(form.getRadioButtonDecreti()));//-1
						
			context.setDataModel(SessionAttributes.FASCICOLO_PER_TAGLIATELLA, fascicolo);
			
			form.setDescDecreto(fascicolo.getDescDecreto());
			
			RiepilogoDatiAnagTO riepilogoTO = getGestioneFadManager().findFascicoloAggiornatoTO(fascicolo.getId());
			
			if(riepilogoTO != null)
			{
				form.setTipologiaDecreto(riepilogoTO.getAnagTipoRiepilogo().getDescTipoRiepilogo());
				form.setImpattoIndebitamento(riepilogoTO.getFlagIndebitamentoSn());
			}
								
		//	List<AnagTipologiaTagliaTO> listTipologiaTaglia = listManager.loadAnagTipologiaTaglia();	
			List<AnagTipoRiepilogoTO> listTipologiaTaglia = listManager.loadAnagTipoRiepilogo();
			context.setDataModel(SessionAttributes.LIST_TIPOLOGIA_TAGLIA, listTipologiaTaglia);

			
			return  predDecretoPerTagliatellaView;
		}
			
	 

	/*		if( StringUtil.isEmpty(radButtDecr)){
				rowNum=getParameter(context, "stampa");
			}else {
				rowNum=form.getRadioButtonDecreti();
			}
//		}else {
//			rowNum=rowNum0;
//		}
		form.setRadioButtonDecreti(rowNum);
		
		FascicoliTO fascicolo=listFascicoli.get(Integer.valueOf(rowNum));
		*/

	 public String onNuovaRicerca(Context context)  {
		 
		 context.removeDataModel(SessionAttributes.LIST_FASCICOLI_FAD);
		 PredTagliatellaForm form=(PredTagliatellaForm) context.getForm();

	    	form.setAnnoDecreto(null);
	    	form.setNumeDecreto(null);
	    	form.setTipoDecreto(null);
	    	
			return startView;
			
		}
	 
	 public String onBack(Context context)  {
		 
		 PredTagliatellaForm form=(PredTagliatellaForm) context.getForm(); 
		 
		 List<FascicoliTO> lista = context.getModel(SessionAttributes.LIST_FASCICOLI_FAD);
		 
		 List<FascicoliTO> listaAggiornata = new ArrayList<FascicoliTO>();
		 
		 
		 FascicoliTO fascTO2 = context.getModel(FASCICOLO_PER_TAGLIATELLA);
			
			RiepilogoDatiAnagTO riepilogoTO = new RiepilogoDatiAnagTO();
			
			try {
				
				riepilogoTO = getGestioneFadManager().findFascicoloAggiornatoTO(fascTO2.getId());
				
				for(int i = 0; i < lista.size(); i++)
				{
					FascicoliTO fto = lista.get(i);
					
				//	long id = fto.getId();
					
				//	RiepilogoDatiAnagTO riepilogoTO = getGestioneFadManager().findFascicoloAggiornatoTO(id);
					
					if(riepilogoTO!= null)
					{
						String desc = riepilogoTO.getDescRiepilogo();
						
						if(fto.getId().equals(riepilogoTO.getId()))	
						{
							fto.setDescDecreto(desc);
							fto.setFlagRiepilogoInvioFad(riepilogoTO.getBinaIntReport() == null? 0 : 1);
							listaAggiornata.add(fto);
						}
						else
						{
							listaAggiornata.add(fto);
						}
			
				//	FascicoliTO ftoAggiornato = getGestioneFadManager().findFascicoloAggiornato(fto);
					
				/*	String descrizioneAggiornata = getGestioneFadManager().findDescFascicoloAggiornata(fto);
					if(fto.getDescDecreto().equals(descrizioneAggiornata))*/
					
					}
					
				}
				return listaDecretiView;
			
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		 return listaDecretiView;
			
		}
	 
	 
/*	 public String onSalva(Context context) throws Throwable {
		 
		 PredTagliatellaForm form=(PredTagliatellaForm) context.getForm();
			if(!form.isValid()){
				
				form.setTipologiaDecreto("");
				
				return predDecretoPerTagliatellaView;
			}
			
			FascicoliTO fascTO2 = context.getModel(FASCICOLO_PER_TAGLIATELLA);
			
			RiepilogoDatiAnagTO to = new RiepilogoDatiAnagTO();
			
			//al momento funziona solo con i record effettivamente presenti sul db
			//bisogna inserire un controllo per fare solo aggiornamento o inserimento in caso non sia un dato presente
			
			//per il blob prendere array di byte passato dalal creazione del .pdf
			
			to = getGestioneFadManager().findFascicoloAggiornatoTO(fascTO2.getId());
			
			AnagTipoRiepilogoTO anagTipoTO = listManager.loadTipoRiepilogoTOByDesc(form.getTipologiaDecreto());
			
			
			
			// CAMPI DI AUDIT //
			Utente ut= getUtenteInSessione();
						
			to.setRowCreatedUser(ut.getUtente().getCodiUtente());
			to.setRowCreatedDttm(Calendar.getInstance().getTime());
			to.setRowCreatedForm(NomeFunzioneConstants.PRED_TAGLIATELLA);
			// FINE CAMPI DI AUDIT //
			
			to.setId(fascTO2.getId());

			to.setDescRiepilogo(form.getDescDecreto());
			to.setFlagIndebitamentoSn(form.getImpattoIndebitamento());//Integer.parseInt(form.getImpattoIndebitamento())
			to.setAnagTipoRiepilogo(anagTipoTO);
			to.setNumeVersion(0);
			to.setFascicoli(fascTO2);
			
			RiepilogoDatiAnagTO toResult = getGestioneFadManager().saveAggiornamentoFascicoloTO(to);
			
			if(toResult != null)
			{
				context.addInfo("info.update.success");
			}
			else
			{
				context.addError("Errore nel salvataggio dei dati.");
			}	  		 
			
			return  predDecretoPerTagliatellaView;
			
	 }
	 
	*/ 
	 
 		public String onCaricaTipologiaDecretoFadPage(Context context)throws Throwable{
 			PredTagliatellaForm form=(PredTagliatellaForm) context.getForm();
 			if (form.isValid()){
 				if(form.getTipoDecreto() != null && !"".equals(form.getTipoDecreto())){
 					context.setDataModel(LIST_TIPOLOGIA_DECRETO, listManager.tipologiaDecretoList(Integer.parseInt(form.getTipoDecreto())));
 				}
 				else {
 					context.setDataModel(LIST_TIPOLOGIA_DECRETO, listManager.tipologiaDecretoList(null));
 				}
 			}
 			return startView;
 		}
	 		
 		public String onCaricaAmmin(Context context)throws Throwable{
 			PredTagliatellaForm form = context.getForm();
 			if (form.isValid()){
 				context.setDataModel(SessionAttributes.LIST_AMMIN_DEM, listManager.getAmminDemByAnnoEse(form.getAnnoDecreto()));
 			}
 			return startView;
 		}
 		
 		
 		
 		public String creaTestoLegge(List<RiepilogoAdDemTO> listaRiepilogo) throws Throwable{

 			StrumentoTO strumLegge = 
 					riepilogoAdDemManager.findLeggeByRiepilogoAdDem(listaRiepilogo.get(0).getEseAnnoEse(), 
 							listaRiepilogo.get(0).getAttNumeTipo(), listaRiepilogo.get(0).getNumeNum());
 			
         	//INIZIO COSTRUZIONE TESTO LEGGE
         	String descLegge = "";
         	
         	if(strumLegge.getSigla() != null)
         		descLegge = descLegge +  strumLegge.getSigla() + " ";
         			
         	if(strumLegge.getNumeLeg() != null)
         		descLegge = descLegge + strumLegge.getNumeLeg() + "/";
         	
         	if(strumLegge.getAnnoLeg() != null)
         		descLegge = descLegge + strumLegge.getAnnoLeg();
         	 	
         	if(strumLegge.getNumeArt() != null)		
         		descLegge = descLegge + " art. " + strumLegge.getNumeArt();
         	
         	if(strumLegge.getDescSubArt() != null)	
         		descLegge = descLegge + " " + strumLegge.getDescSubArt();
         	  
         	if(strumLegge.getNumeComma() != null)	 
         		descLegge = descLegge +  ", comma " + strumLegge.getNumeComma();
         	  
         	if(strumLegge.getDescSubComma() != null)
         		descLegge = descLegge + " " + strumLegge.getDescSubComma();
         	
         	if(strumLegge.getCodiPunto() != null)
         		descLegge = descLegge + ", punto " + strumLegge.getCodiPunto();
         	
         	if(strumLegge.getDescSubPunto() != null)
         		descLegge = descLegge + " " + strumLegge.getDescSubPunto();
         	
         	//FINE COSTRUZIONE TESTO LEGGE
 			
			return descLegge;
 		}

    	public String onInvioAlFad(Context context) throws Throwable {		
    		
	    	java.util.List<FascicoliTO> listaFascicoli=context.getModel(LIST_FASCICOLI_FAD);

	    	String rowNum=getParameter(context, "invioAlFad");
	    	FascicoliTO fascicoloTO=listaFascicoli.get(new Integer(rowNum));
			
			long id = fascicoloTO.getId();
			
			RiepilogoDatiAnagTO riepilogo = getGestioneFadManager().findFascicoloAggiornatoTO(id);
	    	
	    	String user=getUtenteInSessione().getUtente().getCodiUtente();
	    	
	    	String fileName= "Predisposizione Tagliatella";
	    	String contentType="multipart/form-data";
	    	
	    	DocumentTO documentoTO = popolaDocumentTO(context, fascicoloTO, riepilogo, null, fileName, contentType);
	    	    	
	    	//String tipoOperazione = Constants.ID_FIRMA_TECNICA;  
	    	String tipoOperazione = DEMBILConstants.TIPO_OP_DOC_FIRMA_AUTOMATICA; 
	    	
	    	ResponseDEMBILClient response = uploadDecManager.uploadDocumento(documentoTO, null, fascicoloTO, tipoOperazione);
			
				if (response.getEsitoTo()!=null&&response.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){
					context.addInfo("info.upload.success","");
				}
				else{
					context.addError("error.generic", response.getEsitoTo().getDescrizione());
				}

    		return listaDecretiView;
    	}
	
    	
    	protected DocumentTO popolaDocumentTO( Context context,FascicoliTO fascicoloTO,RiepilogoDatiAnagTO to, AnagAmminDemTO amm,String fileName, String contentType) throws Throwable{
			
			DocumentTO docTo= new DocumentTO();
			
			docTo.setIdFascicolo(fascicoloTO.getCodiGuidFascicolo().toString());// me lo passa gestione FAD come querystring o lo prendo dalla combo
			
			String codiTipoDoc = Constants.TIPO_ALLEGATI_DECRETO;
			
			TipoDocumentoTO descDocTo=uploadDecManager.loadTipoDocById(codiTipoDoc); //((List<TipoDocumentoTO>)listManager.loadTipoDocumentoAD()).get(Integer.parseInt(form.getTipoDoc()));//gestioneFadManager.loadDescDocById(Integer.parseInt(form.getTipoDoc()));
			CodeDescriptionTO descDoc= new CodeDescriptionTO();
			descDoc.setCode(descDocTo.getId());
			descDoc.setDescription(descDocTo.getDescDescrizioneDoc());
			docTo.setTipoDocumento(descDoc);
			docTo.setAttivo(true);
			docTo.setCondivisibile(true);
			
			//controllo su visibilitÓ del documento
			if(fascicoloTO.getFlagVisibilitaCdc01() == 1)
				docTo.setDaInviare(true);
			else
				docTo.setDaInviare(false);
			
			Blob bl = (Blob) to.getBinaIntReport();
			
			int blobLength = (int) bl.length();  
			
			byte[] blob =  bl.getBytes(1,blobLength);
			
			DocumentContentTO dc= new DocumentContentTO();
			//dc.setContent(form.getUpFile().getBytes());
			dc.setContent(blob);
	//		dc.setDescrizione(form.getDesc());
			dc.setDescrizione(descDoc.getDescription());
			
			dc.setFileName(fileName);
			dc.setMimeType(contentType);
			
		//	dc.setHash(UtilRequestClient.createHash(form.getUpFile().getBytes()));
			dc.setHash(UtilRequestClient.createHash(blob));
			docTo.setDocumentoContent(dc);
			
			
			CodeDescriptionTO ammDescTo= new CodeDescriptionTO();
			
			if(amm != null){
				ammDescTo.setCode(amm.getId().getAmmin());
				ammDescTo.setDescription(amm.getDescAmm());
			}
			else {
				ammDescTo.setCode("999");
				ammDescTo.setDescription("999");
			}
			docTo.setAmministrazione(ammDescTo);
			docTo.setDataDocumento(DateUtil.getSysDate(Constants.DATE_SEPARATOR));
			
			CodeDescriptionTO ucbRts= new CodeDescriptionTO();
			
			if(amm != null){
				AmminRagDemTO rag = gestioneFadManager.findAmminRagDemByAnagAmminDemTO(amm);
				String r=StringUtils.leftPad(rag.getId().getNumeRag(), 4,Constants.PADDING_CHAR );
				ucbRts.setCode(r);
				ucbRts.setDescription(r);
			}
			else{
				ucbRts.setCode("");
				ucbRts.setDescription("");
			}
			
			docTo.setUcbRts(ucbRts);
			
			context.valorizeAudit(docTo, "gestioneFascicoloFAD");
			return docTo;
		}
	
}

