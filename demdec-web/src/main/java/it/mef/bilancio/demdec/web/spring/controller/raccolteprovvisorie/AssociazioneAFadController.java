/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.controller.raccolteprovvisorie;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTOId;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Esito_type;
import it.mef.bilancio.demdec.crystal.CrystalReport;
import it.mef.bilancio.demdec.crystal.CrystalReportObjectTO;
import it.mef.bilancio.demdec.manager.CrystalManager;
import it.mef.bilancio.demdec.manager.InitManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.RicercaRedManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.AnagRagionerieDemTO;
import it.mef.bilancio.demdec.to.AnagRagionerieDemTOId;
import it.mef.bilancio.demdec.to.AnagStatoFascicoloTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.AnagTipoFlussoTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.to.InvioFadTO;
import it.mef.bilancio.demdec.to.RicercaRedTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTOId;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.utils.GerarchiaUtil;
import it.mef.bilancio.demdec.utils.MyComparatorRaccProvvRedToAnnoProtNumProt;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.DocumentiRaccoltaProvvisorieForm;
import it.mef.bilancio.demdec.web.spring.form.RicercaRedForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.RecuperoUtil;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crystaldecisions.sdk.occa.report.exportoptions.ReportExportFormat;




/**
 * @author utente
 *
 */
@RequestMapping(value = ConstantsRequestMapping.RICERCA_RACCOLTE_PROVVISORIE)
public class AssociazioneAFadController extends AbstractDemFormController implements WebConstants, SessionAttributes{
		
	private String startView;	
	private String raccolteProvvisorie;
	private String documentiFascicolo;
	
	@Autowired
	private RicercaRedManager ricercaRedManager;
	
	@Autowired
	private ListManager listManager;
	
	@Autowired
	private InitManager initManager;
	
	@Autowired
	private CrystalManager crystalManager;
	
	@Override
	public String startController(Context context) throws Throwable {
		
		context.setCurrentNode("DemDec.menu.RicercaProvv");
		
		List<EserciziTO> listaAnniEsercizio=listManager.loadEserciziDemCG();
		List<AnagUfficiTO> listaUfficiAssociatiRed=null;
		
		//TODO Verificare se deve essere caricata l'amministrazione alla partenza
		Utente user = getUtenteInSessione();
		 
		UtenteProfiloTO utProfTo=user.getUtenteProfiloInUso();
		
		if(utProfTo.getAnagUffici()!=null){
				String idUfficio=utProfTo.getAnagUffici().getId();
				
				/** se l'ufficio di appartenenza � 1 o 2 carico nella combo tutti gli uffici, altrimenti solo l'ufficio di appartenenza**/
				switch (Integer.valueOf(idUfficio)) {		
					case 1:
						listaUfficiAssociatiRed=listManager.loadAnagUffici();
						break;
					case 2:
						listaUfficiAssociatiRed=listManager.loadAnagUffici();
						break;				
					default:
						listaUfficiAssociatiRed=new ArrayList<AnagUfficiTO> ();
						AnagUfficiTO uffTo=new AnagUfficiTO();
						uffTo.setId(idUfficio);
						uffTo.setDescUfficio(utProfTo.getAnagUffici().getDescUfficio());
						listaUfficiAssociatiRed.add(uffTo);
						break;
				}
		
		}else{
			listaUfficiAssociatiRed=listManager.loadAnagUffici();
		}
		
		List<AnagStatoFascicoloTO> listaStatiFascRed=listManager.loadStatiFascicoliRed();
		List<AnagTipoFlussoTO> listAnagTipoFlusso=listManager.loadAnagTipoFlusso();
		
		List<AnagAmminDemTO> listaAmm=new ArrayList<AnagAmminDemTO>();
		
		context.setDataModel(WebConstants.LIST_ANNO_ESE, listaAnniEsercizio);
		context.setDataModel(WebConstants.LIST_ANAG_UFF, listaUfficiAssociatiRed);
		context.setDataModel(WebConstants.LIST_ANAG_STATI_FASC, listaStatiFascRed);
		context.setDataModel(WebConstants.LIST_AMMIN_DEM, listaAmm);
		context.setDataModel(WebConstants.LIST_ANAG_TIPO_FLUSSO, listAnagTipoFlusso);
		
		return startView;
		
	}
	
	public void setStartView(String startView) {
		this.startView = startView;
	}

	public void setRaccolteProvvisorie(String raccolteProvvisorie) {
		this.raccolteProvvisorie = raccolteProvvisorie;
	}
	
	public void setDocumentiFascicolo(String documentiFascicolo) {
		this.documentiFascicolo = documentiFascicolo;
	}

	
	public String onCaricaAmministrazioni(Context context) throws Throwable {
		RicercaRedForm form= (RicercaRedForm) context.getForm();
		String annoEsercizio=form.getAnnoEse();
		Utente ut=getUtenteInSessione();
		String idProfilo=ut.getProfiloInUso().getId().toString();
		List<AnagAmminDemTO> listaAmm=null;
		
		if (form.isValid()){
			if(idProfilo.equals(PROFILO_DIRIGENTE_UFFICIO) || idProfilo.equals(PROFILO_BILANCISTA)){
			     listaAmm=listManager.getAmminDemByAnnoEseUtenteAndProfilo(annoEsercizio, ut.getUtente().getId().toString(), ut.getProfiloInUso().getId().toString());
			}else{
				 listaAmm=listManager.getAmminDemByAnnoEse(annoEsercizio);
			}
			
			context.setDataModel(WebConstants.LIST_AMMIN_DEM, listaAmm);
			form.setAnnoEse(annoEsercizio);
		}
		return startView;
	}
	
	public String pulisciRicercaRed(Context context) throws Throwable {
		
		RicercaRedForm form= (RicercaRedForm) context.getForm();		
		form.setAmministrazione(null);
		form.setAnnoEse(null);
		form.setDataArrivoA(null);
		form.setDataArrivoDa(null);
		form.setDataRedA(null);
		form.setDataRedDa(null);
		form.setIdRed(null);
		form.setListaRedDaSospendere(null);
		form.setListaRedSospesi(null);
		form.setListaTipoAllegati(null);
		form.setNumero(null);
		form.setProtocolloRed(null);
		form.setRigaDoc(null);
		form.setRigaFasc(null);
		form.setSelezioniDocumentiFasc(null);
		form.setStato(null);
		form.setTipoAllegati(null);
		form.setTipoDownl(null);
		form.setTipoFlusso(null);
		form.setUfficioAssociatoRed(null);
		form.setValid(false);
				
		return startView;
	}
	
	
	public  String  pulisciRaccolteProvvisorie(Context context) throws Throwable {
		RicercaRedForm form= (RicercaRedForm) context.getForm();
		
		List<AbstractDemTO> respListTo=context.getModel( WebConstants.LIST_RACC_PROVV);
		if( respListTo.size()>0) {
		    PaginatorUtil.addPaginator(respListTo, SessionAttributes.LIST_RICERCA_RED, Paginator.PAGE_RANGE_15, context); 
		}else {
			  	PaginatorUtil.removePaginator(context, SessionAttributes.LIST_RICERCA_RED);
			  	ContextHelper.addWarning(context.getRequest(),"warning.noRecord.trovati");    
		}
		
		String origine=context.getRequest().getParameter("origine");
		
		if(origine==null || !origine.equalsIgnoreCase("documentiFascicolo")) {
			form.setTipoFlusso(null);
			form.setNumero(null);
			form.setAnnoEse(null);
		}
		
		return raccolteProvvisorie;
	}
	
	public String ricercaRed(Context context) throws Throwable {
		
		RicercaRedForm form= (RicercaRedForm) context.getForm();
		
		if(!form.isValid()){		
			return startView;
		}
		
		context.getRequest().getSession().removeAttribute("ricercaRedTo");
		
		RicercaRedTO ricercaRedTO=new RicercaRedTO();
	
		ricercaRedTO.setIdRed(form.getIdRed());
		ricercaRedTO.setAmministrazione(form.getAmministrazione());
		ricercaRedTO.setAnnoEse(form.getAnnoEse());
		ricercaRedTO.setDataArrivoA(form.getDataArrivoA());
		ricercaRedTO.setDataArrivoDa(form.getDataArrivoDa());
		ricercaRedTO.setDataRedDa(form.getDataRedDa());
		ricercaRedTO.setDataRedA(form.getDataRedA());
		ricercaRedTO.setProtocolloRed(form.getProtocolloRed());
		ricercaRedTO.setStato(form.getStato());
		ricercaRedTO.setTipoFlusso(form.getTipoFlusso());
		ricercaRedTO.setUfficioAssociatoRed(form.getUfficioAssociatoRed());
		
		context.getRequest().getSession().setAttribute("ricercaRedTo", ricercaRedTO);
	
		ResponseDEMBILClient respClient=ricercaRedManager.wsRicercaRed(ricercaRedTO); 
				
		String codiceEsito=respClient.getEsitoTo().getCodice();
		//if(true) {
		List<AbstractDemTO> respListTo=null;
		//if(true){
		if(codiceEsito.equalsIgnoreCase("OK")) { 
		
			respListTo=respClient.getListoutputTO();
			
	    	
	    	if (respListTo == null || respListTo.size() == 0) {
				context.addWarning("warning.empty");
				return startView; 
			}
	    	
	    	Collections.sort(respListTo, new  MyComparatorRaccProvvRedToAnnoProtNumProt());
	    	
	    	RaccoltaProvvisoriaRedTO rprTo=null;
	    	List<RaccoltaProvvisoriaRedTO> respListToNew=new ArrayList<RaccoltaProvvisoriaRedTO>();
	    	for (int i = 0; i < respListTo.size(); i++) {
	    		rprTo=(RaccoltaProvvisoriaRedTO)respListTo.get(i);
	    		if(rprTo.getCodiStatoFascicoloDocumentale()!=null){
					rprTo.setDescStatoFascicoloDocumentale(listManager.loadDescStatiFascicoliRed(rprTo.getCodiStatoFascicoloDocumentale()));
					respListToNew.add(rprTo);
				}
			}
	    	
		    List<AnagTipoDecretoTO> listaTipiDecreti=listManager.loadAnagTipoDecreto();
	
			context.setDataModel(WebConstants.LIST_TIPI_DECRETI, listaTipiDecreti );
		
			List<EserciziTO> listEsercizi=listManager.loadEserciziDemCG();
			context.setDataModel(WebConstants.LIST_ANNO_ESE, listEsercizi );
			
			context.setDataModel(WebConstants.LIST_RACC_PROVV, respListTo );
			
			form.setAnnoEse("");
			
			if( respListTo.size()>0) {
				    PaginatorUtil.addPaginator(respListToNew, SessionAttributes.LIST_RICERCA_RED, Paginator.PAGE_RANGE_15, context); 
			}else {
				  	PaginatorUtil.removePaginator(context, SessionAttributes.LIST_RICERCA_RED);
				  	ContextHelper.addWarning(context.getRequest(),"warning.noRecord.trovati"); 
			}
				
			return raccolteProvvisorie;
			
		}else if (codiceEsito.equalsIgnoreCase("ERRORE_DATI_NON_PRESENTI")){
			context.addWarning("warning.empty");
			return startView;
		}else {
			context.addError("error.generic", respClient.getEsitoTo().getDescrizione()); 
			return startView;
		}
		
	}
	
	public void scaricaReport (Context context)throws Throwable{
		CrystalReport report = initManager.initCrystalReport("u_bil_01", "10.121.11.12:6400", "cicciociccio");
		crystalManager.scheduleReport("0001_RIEPDECC", report);
		List<CrystalReportObjectTO>  reports = crystalManager.searchScheduledReport(report, null, "0001_RIEPDECC");
		InputStream io = crystalManager.makeFileForExport(report, ""+reports.get(0).getIdCr(), ReportExportFormat.MSExcel);
		String type="application/vnd.ms-excel";	
		context.getResponse().setContentType(type);
		context.getResponse().setHeader("Content-Disposition","attachment;filename=Prova.xls");

		ServletOutputStream out= context.getResponse().getOutputStream();
	 
		out.write(IOUtils.toByteArray(io));
		out.flush();
		out.close();
	}

	public String apriDocumentiFascicolo(Context context) throws Throwable{
		RicercaRedForm form= (RicercaRedForm) context.getForm();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		List<RaccoltaProvvisoriaRedTO> listaRaccolteProvv=context.getModel(SessionAttributes.LIST_RICERCA_RED);
		String idFascicoloRaccoltaProvvisoria = getParameter(context, "idRed");
		
		RaccoltaProvvisoriaRedTO rprto=RecuperoUtil.recuperaRaccProvvTo(listaRaccolteProvv, idFascicoloRaccoltaProvvisoria);
		
		context.setDataModel(WebConstants.ID_FASC_RACC_PROVV, idFascicoloRaccoltaProvvisoria);
		context.setDataModel(WebConstants.FASC_RACC_PROVV_SELECTED, rprto);
		
		String numDataProtocollo=rprto.getProtocollo().getNumeroProtocollo()+"/"+sdf.format(rprto.getProtocollo().getData());
		context.setDataModel("numDataProtocollo", numDataProtocollo);
		
		ResponseDEMBILClient resp= ricercaRedManager.wsDocumentiFascicolo(rprto);
		if (!resp.getEsitoTo().getCodice().equalsIgnoreCase(DEMBILConstants.ESITO_OK)){
			if (StringUtil.isEmpty(resp.getEsitoTo().getErrors())){
				context.addError("error.generic",resp.getEsitoTo().getDescrizione());
			} else {
				String detail = "";
				for(String error:resp.getEsitoTo().getErrors()){
					detail += detail.isEmpty()?": ":" - ";
					detail += error;
				}
				context.addError("error.generic1", resp.getEsitoTo().getDescrizione(),detail);
			}
			return raccolteProvvisorie;
		}
		RaccoltaProvvisoriaRedTO rp=(RaccoltaProvvisoriaRedTO)resp.getOutputTO();
		if (StringUtil.isEmpty(rp.getDocumenti())){
		  	PaginatorUtil.removePaginator(context, SessionAttributes.LIST_DOCUMENTI_FASCICOLO);
		  	ContextHelper.addWarning(context.getRequest(),"warning.noRecord.trovati");  
		  	return raccolteProvvisorie;
		}
		
		if(rp.getCodiStatoFascicoloDocumentale().equalsIgnoreCase("INSERITO")) {
			ContextHelper.addWarning(context.getRequest(),"warning.raccolteProvvisorie.statoInserito");
			return raccolteProvvisorie;
		}
		
		form.setDocumentiRaccoltaProvvisorieList(new ArrayList<DocumentiRaccoltaProvvisorieForm>());
		List<DocumentTO> documenti = GerarchiaUtil.ordinaGerarchia(rp.getDocumenti());
		for (int i = 0; i < documenti.size(); i++) {
			DocumentTO docTo = documenti.get(i);
			
			docTo.setAmministrazione(rp.getAmministrazione());
			docTo.setUcbRts(rp.getRagioneria());
			if(docTo.getTipoDocumento()!=null && docTo.getTipoDocumento().getDescription()!=null
					&& docTo.getTipoDocumento().getDescription().equalsIgnoreCase(Constants.DOC_PRINCIPALE)){
				docTo.setProtocollo(rp.getProtocollo());
			}
			
		}
			
		List<DescDocumentoTO> listDescDocumento=listManager.loadDescDocumentoByTipo("IG01");
		List<DescDocumentoTO> listDescDocumento2=listManager.loadDescDocumentoByTipo("IG02");
			
		List<AnagTipoDecretoTO> listaTipiDecreti=listManager.loadAnagTipoDecreto();
		context.setDataModel(WebConstants.LIST_TIPI_DECRETI, listaTipiDecreti );
		context.setDataModel(WebConstants.LIST_TIPO_ALLEGATI_RP01, listDescDocumento);
		context.setDataModel(WebConstants.LIST_TIPO_ALLEGATI_RP02, listDescDocumento2);
	
		List<EserciziTO> listEsercizi=listManager.loadEserciziDemCG();
		context.setDataModel(WebConstants.LIST_ANNO_ESE, listEsercizi );
		
		context.setDataModel(WebConstants.LIST_DOC_FASC, documenti );

    	PaginatorUtil.addPaginator( documenti, SessionAttributes.LIST_DOCUMENTI_FASCICOLO, Paginator.PAGE_RANGE_15, context);
    	
    	popolaForm(context);

    	return documentiFascicolo;
	
	}
	
	
	
	public String pulisciDocumentiFascicolo(Context context) throws Throwable{
		RicercaRedForm form= (RicercaRedForm) context.getForm();		
		
		List<AbstractDemTO> respListTo=context.getModel( WebConstants.LIST_DOC_FASC);
		if( respListTo.size()>0) {
		    PaginatorUtil.addPaginator(respListTo, SessionAttributes.LIST_DOCUMENTI_FASCICOLO, Paginator.PAGE_RANGE_15, context); 
		    popolaForm(context);
		}else {
			  	PaginatorUtil.removePaginator(context, SessionAttributes.LIST_DOCUMENTI_FASCICOLO);
			  	ContextHelper.addWarning(context.getRequest(),"warning.noRecord.trovati");    
		}
		
		form.setTipoFlusso(null);
		form.setNumero(null);
		form.setAnnoEse(null);
		
		return documentiFascicolo;
	}
	
	
	
	public String inviaAFad(Context context) throws Throwable {
	   RicercaRedForm form= (RicercaRedForm) context.getForm();
	
	   if (!form.isValid()){
		   return documentiFascicolo;
	   }
	   
       RaccoltaProvvisoriaRedTO raccProvvisoriaRedTO = context.getModel(WebConstants.FASC_RACC_PROVV_SELECTED);
	   SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
		
	   Integer anno2=Integer.valueOf(form.getAnnoEse());
	   Integer numero2=Integer.valueOf(form.getNumero());
	   Integer tipo2=Integer.valueOf(form.getTipoFlusso());
	   
	   List<FascicoliViewTO> fascicoli=ricercaRedManager.findFascicoloByTipoNumAnnoStato(anno2, tipo2, numero2);
	   //fascicoli
	   if(fascicoli==null || fascicoli.size()==0){
		   fascicoli=ricercaRedManager.findFascicoloByTipoNumAnno(anno2, tipo2, numero2);
		   if(fascicoli==null || fascicoli.size()==0){
			   context.addError("error.inviaAFad.inexistent");
			   return documentiFascicolo;
		   }else{
			   context.addError("error.stato.invioFad", ricercaRedManager.getTipoDecretoById(tipo2).getDescSigla()+" n."+numero2+" del "+anno2);
			   return documentiFascicolo;
		   }
		}
	   
	   List<DocumentTO> listDocTO=context.getModel(SessionAttributes.LIST_DOCUMENTI_FASCICOLO);
	   List<DocumentTO> listDocTOtoSend=new ArrayList<DocumentTO>();//sar� la lista dei documenti da inviare, selezionati sulla maschera dei documenti
			
		for (int j = 0; j < listDocTO.size(); j++) {
			DocumentiRaccoltaProvvisorieForm riga = form.getDocumentiRaccoltaProvvisorieList().get(j);
			if ("1".equalsIgnoreCase(riga.getSelezioniDocumentiFasc())){
				DocumentTO toSend = listDocTO.get(j);
				StringTokenizer st = new StringTokenizer(riga.getTipoAllegati(), "-");
				CodeDescriptionTO cDTO = new CodeDescriptionTO(st.nextToken(), st.nextToken());
				toSend.setDescDocumento(cDTO);
				listDocTOtoSend.add(toSend);
			}
		}
			
		SottoFascicoliRedTO sfRedTo=new SottoFascicoliRedTO();
		SottoFascicoliRedTOId sfRedToId =new SottoFascicoliRedTOId();
										
		int contSuccess=0;
		/**riempio il to del sottofascicolo da inserire**/
		sfRedToId.setCodiIdRed(raccProvvisoriaRedTO.getIdentificativoRaccoltaProvvisoria());
		if(raccProvvisoriaRedTO.getProtocollo()!=null) {
			sfRedTo.setNumeProtocollo(raccProvvisoriaRedTO.getProtocollo().getNumeroProtocollo());
			sfRedTo.setCodiAooProtocollo(raccProvvisoriaRedTO.getProtocollo().getAoo());
			sfRedTo.setDescTipoProtocollo(raccProvvisoriaRedTO.getProtocollo().getTipo());
			sfRedTo.setDataProtocollo(raccProvvisoriaRedTO.getProtocollo().getData());
		}
		sfRedTo.setDescTipoFlusso(raccProvvisoriaRedTO.getTipoFlusso());
		sfRedTo.setDataArrivo(sdf.parse(raccProvvisoriaRedTO.getDataCreazione()));
		sfRedTo.setDataRed(raccProvvisoriaRedTO.getProtocollo().getData());
		sfRedTo.setDescOggettoRed(raccProvvisoriaRedTO.getDescrizione());
		sfRedToId.setFkNumeIdFascicolo(fascicoli.get(0).getId());
		sfRedTo.setStatStato(0);
		sfRedTo.setId(sfRedToId);
		sfRedTo.setCodiGuidFascicolo(fascicoli.get(0).getCodiGuidFascicolo());
		sfRedTo.setCodiGuidSFascicolo(raccProvvisoriaRedTO.getIdFascicoloRaccoltaProvvisoria());
		sfRedTo.setDescUfficioAss(raccProvvisoriaRedTO.getUfficioCreatoreRED().getDescription());
		sfRedTo.setDescUtenteAss(raccProvvisoriaRedTO.getUtenteCreatore().getDescription());
		sfRedTo.setDescTipoFlusso(raccProvvisoriaRedTO.getTipoFlusso());
		
		AnagAmminDemTO anagAmmDemTo=new AnagAmminDemTO();
		anagAmmDemTo.setDescAmm(raccProvvisoriaRedTO.getAmministrazione().getDescription());
		anagAmmDemTo.setDescAmmR(raccProvvisoriaRedTO.getAmministrazione().getDescription());//TODO verificare se serve
		anagAmmDemTo.setId(new AnagAmminDemTOId(anno2.shortValue(), new Integer(raccProvvisoriaRedTO.getAmministrazione().getCode().substring(0, 2)), new Integer(raccProvvisoriaRedTO.getAmministrazione().getCode().substring(2, 3))));
		sfRedTo.setAnagAmminDem(anagAmmDemTo);
		
		AnagRagionerieDemTO anagRagDemTo=new AnagRagionerieDemTO((new AnagRagionerieDemTOId(anno2.shortValue(), new Short(raccProvvisoriaRedTO.getRagioneria().getCode()))));
		anagRagDemTo.setDescRag(raccProvvisoriaRedTO.getRagioneria().getDescription());
		sfRedTo.setAnagRagionerieDem(anagRagDemTo);
			//					sfRedTo.setFkNumeRag(new Short(raccProvvisoriaRedTO.getRagioneria().getCode()));
			
		/***assegnazione campi di audit***/
		context.valorizeAudit(sfRedTo, NomeFunzioneConstants.ASSOCIAZIONE_RED_FAD);
		sfRedTo.setRowUpdatedDttm(null);
		sfRedTo.setRowUpdatedUser(null);
		sfRedTo.setRowUpdatedForm(null);

		/**
		 * Eseguo il ciclo di associazione al fad e inserimento del Sottofascicolo e dei documenti
		 * nella nostra basedati calcolo i successi per verificare se aggiornare lo stato del
		 * fasciolo delle raccolte provvisorie su DEMBIL 
		 */
		for (DocumentTO documentTO : listDocTOtoSend) {
			InvioFadTO ifTo=null;
			ifTo=new InvioFadTO();
			ifTo.setIdDocumentoRaccoltaProvvisoria(documentTO.getDocumentoContent().getIdDocumento());
			ifTo.setIdFascicoloRaccoltaProvvisoria(documentTO.getIdFascicolo());
			ifTo.setIdFascicoloAttoDecreto(fascicoli.size()>0?fascicoli.get(0).getCodiGuidFascicolo():"" );
			ifTo.setIdDocumento(documentTO.getIdDocumento());
			ifTo.setIdDocumentoRaccoltaProvvisoria(documentTO.getIdDocumentoRaccoltaProvvisoria());
			ifTo.setTipoDocumento(documentTO.getTipoDocumento().getCode().equalsIgnoreCase("RP01")?"IG01":"IG02");
			ifTo.setDescrizione(documentTO.getDescDocumento().getDescription());
			documentTO.setIdSottoFascicolo(fascicoli.get(0).getId().toString());
			documentTO.setStatDocumento(0);
			documentTO.setCodiIdRed(raccProvvisoriaRedTO.getIdentificativoRaccoltaProvvisoria());
			context.valorizeAudit(documentTO, NomeFunzioneConstants.ASSOCIAZIONE_RED_FAD);
			ResponseDEMBILClient respClient=ricercaRedManager.wsInvioFAD(ifTo, sfRedTo,  documentTO); 
			if(respClient.getEsitoTo().getCodice().equalsIgnoreCase(Esito_type._OK)){
				contSuccess++;
			}else{
				context.addError("error.generic", respClient.getEsitoTo().getDescrizione());
			}
		}
		ResponseDEMBILClient respClientChangeStato=null;
		InvioFadTO toChange=new InvioFadTO();
		if(contSuccess>0) {
			toChange.setIdFascicoloRaccoltaProvvisoria(raccProvvisoriaRedTO.getIdFascicoloRaccoltaProvvisoria());
			toChange.setStatoFascicolo(Constants.STATO_FAD_IN_ELABORAZIONE);
			/**chiamo il servizio web per aggiornare lo stato fascicolo sul documentale**/
			respClientChangeStato=ricercaRedManager.wsCambioStatoFascicolo(toChange);
			if(!respClientChangeStato.getEsitoTo().getCodice().equalsIgnoreCase(Esito_type._OK)) {
				context.addError("error.generic", "Errore ws cambio stato fascicolo: "+respClientChangeStato.getEsitoTo().getDescrizione());
				return documentiFascicolo;
			}
		} else {
			/** l'errore � gi� stato aggiunto al context **/
			return documentiFascicolo;
		}

		/***inserisco, nella textarea dei fad a cui il documento � gi� associato, il fad a cui ho appena associato***/
		popolaForm(context);
			
		context.addInfo("info.update.success");
		context.addInfo("info.doc.sent", ""+contSuccess);
			
		return documentiFascicolo;
		
	} 
	
	
	public String download(Context context)  throws   Throwable{
		
		List<DocumentTO> listDocFsc=context.getModel(WebConstants.LIST_DOC_FASC);
		String tipoDownload=context.getRequest().getParameter("tipoDownl");
		//String rigaDocumento=context.getRequest().getParameter("rigaDoc");
		String idDocumento=context.getRequest().getParameter("idDocumento");
		
		DocumentTO to=RecuperoUtil.recuperaDocumentTo(listDocFsc, idDocumento, tipoDownload);
		
		String idDoc=tipoDownload.equals("1")?to.getIdDocumento():to.getIdDocumentoRaccoltaProvvisoria();
		ResponseDEMBILClient respClient=ricercaRedManager.wsDownloadDocumento(to.getIdFascicolo(), idDoc);
	
		String codiceEsito=respClient.getEsitoTo().getCodice();
		
		String type=null;
		DocumentContentTO docContent=null;
		if(codiceEsito.equalsIgnoreCase("OK")) {
			docContent=(DocumentContentTO)respClient.getOutputTO();
					
		}else {
			context.addError("error.generic", respClient.getEsitoTo().getDescrizione()); 
			return documentiFascicolo;
		}
		
		type=docContent.getMimeType();
	
		context.getResponse().setContentType(type);		
		context.getResponse().setHeader("Content-Disposition","attachment;filename="+docContent.getFileName());
 	
		ServletOutputStream out;	
		out = context.getResponse().getOutputStream();
		out.write(docContent.getContent());

		out.flush();
		out.close();
		
		return null;
 
	}
	
	private void popolaForm(Context context) throws Throwable{
		RicercaRedForm form = context.getForm();
		form.setDocumentiRaccoltaProvvisorieList(new ArrayList<DocumentiRaccoltaProvvisorieForm>());
    	List<DocumentTO> pagina = context.getModel(SessionAttributes.LIST_DOCUMENTI_FASCICOLO);
    	for(DocumentTO docTo:pagina){
    		/** inserimento, nelle righe del Form, dei fad a cui ogni documento � gi� associato **/
    		List<FascicoliViewTO> fascicoliAssociati = ricercaRedManager.findFascicoliAssociati(docTo.getIdDocumentoRaccoltaProvvisoria());
    		String fascAss="";
    		if(fascicoliAssociati!=null){
    			for (int w = 0; w < fascicoliAssociati.size(); w++) {
    				fascAss+=(fascicoliAssociati.get(w).getDescSigla() + " - " + fascicoliAssociati.get(w).getNumeNumDecreto() + " - " + fascicoliAssociati.get(w).getAnnoEse() + "\n");
    			}
    		}
    		DocumentiRaccoltaProvvisorieForm riga = new DocumentiRaccoltaProvvisorieForm();
    		riga.setFascicoliAssociati(fascAss);
    		form.getDocumentiRaccoltaProvvisorieList().add(riga);
    	}
	}

	@Override
	public String onPaginator(Context context) throws Throwable {
		String result = super.onPaginator(context);
		popolaForm(context);
		return result;
	}

	@Override
	public String onEnableDisablePagin(Context context) throws Throwable {
		String result = super.onEnableDisablePagin(context);
		popolaForm(context);
		return result;
	}
	
}