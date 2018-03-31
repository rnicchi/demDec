package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;
import it.almavivaitalia.bilancio.commons.utils.DateUtil;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.UploadDecManager;
import it.mef.bilancio.demdec.servizi.client.UtilRequestClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.to.AmminRagDemTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.form.GestioneFascicoloFadForm;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

//@RequestMapping(value = ConstantsRequestMapping.GESTIONE_FASCICOLO_F_A_D)
public class GestioneFascicoloFadGrandParentController extends ConsultaFascicoloFadController {
    
	@Autowired
	protected ListManager listManager; 
	
	@Autowired
	private GestioneFadManager gestioneFadManager;
	
	@Autowired
	private UploadDecManager uploadDecManager;

	private static ArrayList<String> allowedContentType;
	
	private String fascicoloFadView;
	private String selezioneAmmFadView;
	private String documentiFadView;
	private String documentiRedView;
	
	static{ // configurazione con tika parsers
		
		allowedContentType = new ArrayList<String>();
        allowedContentType.add("application/pdf");
        allowedContentType.add("application/jpeg");
        allowedContentType.add("application/pjpeg");
//      allowedContentType.add("application/xml");
        allowedContentType.add("application/x-tika-ooxml"); // nuovo office
        allowedContentType.add("application/x-tika-msoffice"); // vecchio office
        allowedContentType.add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        allowedContentType.add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        allowedContentType.add("application/msword");
        allowedContentType.add("application/vnd.ms-excel");
        allowedContentType.add("application/rtf");
        allowedContentType.add("image/x-ms-bmp");
        allowedContentType.add("image/tiff");
        allowedContentType.add("image/gif");
        allowedContentType.add("image/jpeg");
        
	}
	
	
	
	

	
	public void setDocumentiFadView(String documentiFadView) {
		this.documentiFadView = documentiFadView;
	}

	
	public void setFascicoloFadView(String fascicoloFadView) {
		this.fascicoloFadView = fascicoloFadView;
	}
	
	public void setSelezioneAmmFadView(String selezioneAmmFadView) {
		this.selezioneAmmFadView = selezioneAmmFadView;
	}
	
	public void setDocumentiRedView(String documentiRedView) {
		this.documentiRedView = documentiRedView;
	}



	public ListManager getListManager() {
		return listManager;
	}



	public GestioneFadManager getGestioneFadManager() {
		return gestioneFadManager;
	}



	public UploadDecManager getUploadDecManager() {
		return uploadDecManager;
	}



	public static ArrayList<String> getAllowedContentType() {
		return allowedContentType;
	}



//	public static HashMap<String, String> getContentTypeExtensions() {
//		return contentTypeExtensions;
//	}



	public String getFascicoloFadView() {
		return fascicoloFadView;
	}



	public String getSelezioneAmmFadView() {
		return selezioneAmmFadView;
	}



	public String getDocumentiFadView() {
		return documentiFadView;
	}



	public String getDocumentiRedView() {
		return documentiRedView;
	}


	protected DocumentTO popolaDocumentTO( Context context,FascicoliTO fascicoloTO,AnagAmminDemTO amm,GestioneFascicoloFadForm form,String fileName, String contentType) throws Throwable{
			
			DocumentTO docTo= new DocumentTO();
			
			docTo.setIdFascicolo(fascicoloTO.getCodiGuidFascicolo().toString());// me lo passa gestione FAD come querystring o lo prendo dalla combo
			
			TipoDocumentoTO descDocTo=uploadDecManager.loadTipoDocById(form.getTipoDoc()); //((List<TipoDocumentoTO>)listManager.loadTipoDocumentoAD()).get(Integer.parseInt(form.getTipoDoc()));//gestioneFadManager.loadDescDocById(Integer.parseInt(form.getTipoDoc()));
			CodeDescriptionTO descDoc= new CodeDescriptionTO();
			descDoc.setCode(descDocTo.getId());
			descDoc.setDescription(descDocTo.getDescDescrizioneDoc());
			docTo.setTipoDocumento(descDoc);
			docTo.setAttivo(true);
			docTo.setCondivisibile(true);
			
			//controllo su visibilità del documento
			if(fascicoloTO.getFlagVisibilitaCdc01() == 1)
				docTo.setDaInviare(true);
			else
				docTo.setDaInviare(false);
			
			DocumentContentTO dc= new DocumentContentTO();
			dc.setContent(form.getUpFile().getBytes());
			dc.setDescrizione(form.getDesc());
			dc.setFileName(fileName);
			dc.setMimeType(contentType);
			dc.setHash(UtilRequestClient.createHash(form.getUpFile().getBytes()));
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
	
	
	
	
	public String onModificaMetadatiDocFad(Context context) throws Throwable{
		
		GestioneFascicoloFadForm form = context.getForm();

		FascicoliTO to = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		EsitoTO esito = null;
		// Campi di audit
		Utente u= getUtenteInSessione();
		
		FascicoliTO fascicoloTO = new FascicoliTO();
		fascicoloTO.setId(to.getId());
		fascicoloTO.setCodiGuidFascicolo(to.getCodiGuidFascicolo());
		fascicoloTO.setDocumentiList(new ArrayList<DocumentiTO>());
		fascicoloTO.setRowUpdatedUser(u.getUtente().getCodiUtente());
		fascicoloTO.setRowUpdatedDttm(Calendar.getInstance().getTime());
		fascicoloTO.setRowUpdatedForm(NomeFunzioneConstants.GESTIONE_FASCICOLO);
		
		fascicoloTO.setDescUtenteModifica(u.getUtente().getCodiUtente());
		fascicoloTO.setDataModificaFascicolo(Calendar.getInstance().getTime());
		
		// Reperimento documento Selezionato
		DocumentiTO docSelezionatoTO = (DocumentiTO)context.getModel(DOCUMENTO_FAD);
		boolean modifica = false;
		
		// Controllo del tipo documento se di tipo AD01 e con
		// stato diverso da 0 si inibisce la cancellazione
		if( (docSelezionatoTO.getTipoDocumento().getId().equalsIgnoreCase(Constants.TIPO_ATTO_DECRETO) && 
		     docSelezionatoTO.getStatDocumento().equals(Integer.parseInt(Constants.DOC_FAD_STAT_DOCUMENTO_ZERO)) ) ||
		     (!docSelezionatoTO.getTipoDocumento().getId().equalsIgnoreCase(Constants.TIPO_ATTO_DECRETO))
		     
		  ){
		
			if (!form.getModaleUpdFadDesc().equals(docSelezionatoTO.getDescDocumento().getId()) ||
				!form.getModaleUpdFadVisibilita().equals(""+docSelezionatoTO.getFlagVisibilitaCdc01())	) {
					DescDocumentoTO descDocumentoTO = gestioneFadManager.findVisibilitaDocumentoByCodiDescDocumento(form.getModaleUpdFadDesc());
					docSelezionatoTO.setDescDocumento(descDocumentoTO);
					docSelezionatoTO.setFlagVisibilitaCdc01(Integer.parseInt(form.getModaleUpdFadVisibilita()));
					docSelezionatoTO.setTextDescrizione(descDocumentoTO.getTextDescrizione());
					
					modifica = true;
					
				}
			fascicoloTO.getDocumentiList().add(docSelezionatoTO);
			
			//aggiunto dopo modifica visibilitaCdc in modale
			fascicoloTO.setFlagVisibilitaCdc01(Integer.parseInt(form.getModaleUpdFadVisibilita()));
			
			if (modifica){
				esito = getGestioneFadManager().modificaDocumentoFAD(fascicoloTO);
			} else { //  nessuna variazione
					System.out.println("NON CI SONO MODIFICHE DA SALVARE");
					esito = new EsitoTO();
					esito.setCodice("NULL");
					esito.setDescrizione("Non ci sono modifiche da salvare.");
				}
				
			// Gestione messaggistica
			if(esito!=null && esito.getCodice().equals("OK")){
				//ricarico il fascicolo per vedere subito la modifica effettuata
				FascicoliTO toFasc= gestioneFadManager.getFascicoloFad(ParseUtil.getLong(fascicoloTO.getId()));
				if (!StringUtil.isEmpty(toFasc.getDocumentiList())){
					//imposto il nome del file trasformato
					for (DocumentiTO doc : toFasc.getDocumentiList()) {
						if(doc.getDescFilename()!=null){
							doc.setDescFilenameTrasf(doc.getDescFilename()+".pdf");
						}
					}
				}
				onRefreshLista(context);
				context.addInfo("info.update.success", new String[]{});
			}else if(esito!=null && esito.getCodice().equals("NULL")){
				context.addWarning("error.generic","Non ci sono modifiche da salvare.");
			}else if (esito!=null){
				if (StringUtil.isEmpty(esito.getErrors())){
					context.addError("error.generic",esito.getDescrizione());
				} else {
					String detail = "";
					for(String error:esito.getErrors()){
						detail += detail.isEmpty()?": ":" - ";
						detail += error;
					}
					context.addError("error.generic1", esito.getDescrizione(),detail);
				}
			} else {
				context.addError("error.generic", new String[]{"Errore in fase di salvataggio modifiche."});
			}
		
		}
		else {
			context.addError("error.upload.documenti.stato","");
		}
			
		return getDocumentiFadView();
	}

}
