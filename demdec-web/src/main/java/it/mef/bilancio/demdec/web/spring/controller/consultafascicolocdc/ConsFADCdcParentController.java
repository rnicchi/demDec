package it.mef.bilancio.demdec.web.spring.controller.consultafascicolocdc;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.utils.DateUtil;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoOperazione_type;
import it.mef.bilancio.demdec.manager.ConsFADCdcManager;
import it.mef.bilancio.demdec.manager.DocumentiManager;
import it.mef.bilancio.demdec.manager.InvioAlleFirmeManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.UploadDecManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.UtilRequestClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.to.DocumentiRedTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.form.ConsFADCdcForm;
import it.mef.bilancio.demdec.web.spring.utils.FileUtil;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


//@RequestMapping(value = ConstantsRequestMapping.CONSULTA_FASCICOLO_CDC)
public class ConsFADCdcParentController extends ConsFADCdcGrandParentController implements WebConstants, SessionAttributes{
	private static ArrayList<String> allowedContentType;
	static{ // configurazione con tika parsers
		allowedContentType = new ArrayList<String>();
        allowedContentType.add("application/pdf");
	}
	
	@Autowired
	private ListManager listManager; 
	
	@Autowired
	private ConsFADCdcManager consFADCdcManager;
	
	@Autowired 
	private DocumentiManager documentiManager;
	
	@Autowired
	private UploadDecManager uploadDecManager;
	
	@Autowired
	private InvioAlleFirmeManager invioAlleFirmeManager;
	
	@Override
	public String startController(Context context) throws Throwable {
		
		context.setDataModel(SessionAttributes.LIST_ANNO_ESE, listManager.loadEserciziDemCG());
		context.setDataModel(SessionAttributes.LIST_TIPI_DECRETI, listManager.loadAnagTipoDecreto());
		
		context.setCurrentNode("DemDec.menu.ConsFADCdc");
		
		context.removeDataModel(OPEN_DETT_FAD);
		context.removeDataModel(OPEN_DETT_RED);
		context.removeDataModel(OPEN_DETT_PATR);
		return getStartView();
	}

	public ListManager getListManager() {
		return listManager;
	}

	public void setListManager(ListManager listManager) {
		this.listManager = listManager;
	}

	public ConsFADCdcManager getConsFADCdcManager() {
		return consFADCdcManager;
	}

//	public void setConsFADCdcManager(ConsFADCdcManager consFADCdcManager) {
//		this.consFADCdcManager = consFADCdcManager;
//	}
//
	public DocumentiManager getDocumentiManager() {
		return documentiManager;
	}

//	public void setDocumentiManager(DocumentiManager documentiManager) {
//		this.documentiManager = documentiManager;
//	}
//	
	
	
	public String onEseguiRicerca(Context context) throws Throwable{
		ConsFADCdcForm form = context.getForm();
		
		if(!form.isValid()){
			return getStartView();
		}
		
		FascicoliFadSearhTO to = new FascicoliFadSearhTO();
		to.setAmmin(form.getAmministrazione());
		to.setAnnoDecreto(form.getAnnoDecreto());
		to.setCdr(form.getCdr());
		to.setDataArrivoA(form.getDataArrivoA());
		to.setDataArrivoDa(form.getDataArrivoDa());
		to.setNumeDecreto(form.getNumeDecreto());
		to.setNumePat(form.getNumePat());
		to.setStato(form.getStato());
		to.setTipoDecreto(form.getTipoDecreto());
		to.setTipologiaDecreto(form.getTipologiaDecreto());
		to.setUfficio(form.getUfficio());
		to.setFlagVisibilitaCdc01(1);
		to.setNumeProtEntrataCdc(form.getNumeProtEntrata());
		to.setDataProtEntrataCdc(form.getDataProtEntrata());
		to.setDataPresaInCaricoCdc(form.getDataPresaInCarico());
		to.setNumeProtUscitaCdc(form.getNumeProtUscita());
		to.setDataProtUscitaCdc(form.getDataProtUscita());
		
		
		List<FascicoliTO> lista = getConsFADCdcManager().getFascicoliFadCdc(to);
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).setDescStato((String)getListManager().loadDecStatiFascicoliFad(lista.get(i).getStatStato().toString()));
		}
			
		
		if (lista==null||lista.size()==0){
			PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD_CDC);
			context.addWarning("warning.empty");
			return getStartView();
		}
		PaginatorUtil.addPaginator(lista,LIST_FASCICOLI_FAD_CDC, Paginator.PAGE_RANGE_15, context);
		//context.setDataModel(SessionAttributes.LIST_FASCICOLI_FAD, lista);
		
		return getAfterRicercaView();
	}

	
	public String onNuovaRicercaCdc(Context context)throws Throwable{
		ConsFADCdcForm form = context.getForm();
		form.reset();
		context.removeDataModel(LIST_TIPOLOGIA_DECRETO);
		context.removeDataModel(SessionAttributes.LIST_AMMIN_DEM);
		context.removeDataModel(LIST_ANAG_CDR_DEM);
		context.removeDataModel(OPEN_DETT_FAD);
		context.removeDataModel(OPEN_DETT_RED);
		context.removeDataModel(OPEN_DETT_PATR);
		return getStartView();
	}
	
	public String onBackToFadSearchCdc(Context context)throws Throwable{
		context.removeDataModel(OPEN_DETT_FAD);
		context.removeDataModel(OPEN_DETT_RED);
		context.removeDataModel(OPEN_DETT_PATR);
		context.removeDataModel(FASCICOLO_SELEZIONATO);
		return getAfterRicercaView();
	}
	
	public String onBack(Context context)throws Throwable{
		context.removeDataModel(OPEN_DETT_FAD);
		context.removeDataModel(OPEN_DETT_RED);
		context.removeDataModel(OPEN_DETT_PATR);
		return getFascicoloFadView();
	}

	public String onScaricaPdfPatCdc(Context context) throws Throwable{
		ResponseDEMBILClient res = null;
		DocumentTO doc = null;
		FascicoliTO to = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		String rowNum = context.getCommandParameter("scaricaPdfPatCdc");
		List<DocumentTO> listDocAttoDecreto = context.getModel(LIST_DOCUMENTI_PAT);
		
		if(!listDocAttoDecreto.isEmpty() && rowNum != null && rowNum != "" ){
			doc = listDocAttoDecreto.get(Integer.parseInt(rowNum)-1);
		}
		res = getDocumentiManager().wsDownloadDocumentoFascicoloSIPATRAttoDecreto(to.getCodiGuidFascicolo(), doc.getIdSottoFascicolo(), doc.getIdDocumento());
		
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			FileUtil.downloadFromResponseWs(res, context);
			
		}else{
			context.addError("error.ws.download.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			return getDocumentiPatView();
		}
	
		return null;
	}

	public String onScaricaPdfRedCdc(Context context) throws Throwable{
		ResponseDEMBILClient res = null;
		DocumentiRedTO doc = null;
		FascicoliTO to = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		String rowNum = context.getCommandParameter("scaricaPdfRedCdc");
		List<DocumentiRedTO> listDocAttoDecreto = context.getModel(LIST_DOCUMENTI_RED);
		
		if(!listDocAttoDecreto.isEmpty() && rowNum != null && rowNum != "" ){
			doc = listDocAttoDecreto.get(Integer.parseInt(rowNum)-1);
		}
		res = getDocumentiManager().wsDownloadDocumentoFascicoloAllegatoIGB(to.getCodiGuidFascicolo(), doc.getCodiGuidDocumentoTrasf());
		
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			FileUtil.downloadFromResponseWs(res, context);
			
		}else{
			context.addError("error.ws.download.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			return getDocumentiRedView();
		}
	
		return null;
	}
	
	public String onUploadFile(Context context) throws Throwable {
		
		ConsFADCdcForm form =context.getForm();
		CommonsMultipartFile file = form.getUpFile();
		// Prelevamento dell'id fascicolo
		FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		
		if (form.isValid()) {
			
			try {
				String contentType = uploadDecManager.checkGuessedFileType( allowedContentType, file.getOriginalFilename(), file.getInputStream());

				if (contentType.equals(Constants.NOT_ALLOWED)) {
					context.addError("error.contentType", "");
					return  getDocumentiFadView();
				} 
				
				if (contentType.equals(Constants.BAD_FILE)) {
					context.addError("error.contentType.badFile", "");
					return  getDocumentiFadView();
				} 
				String fileName=file.getOriginalFilename();
//				String fileName= getUploadDecManager().renameToMatchingFileExt(getContentTypeExtensions(),contentType, file.getOriginalFilename()); //configurazione con tika parsers
				
				
				if (!invioAlleFirmeManager.wsChangeStatoFascicoloAttoDecreto(fascicoloTO.getCodiGuidFascicolo(), StatoFascicoloDocumentale_type._IN_ELABORAZIONE).getEsitoTo().getCodice().equalsIgnoreCase("OK")){
					context.addError("error.contentType.badFile", "");
					return  getDocumentiFadView(); 
				}
				
				//* code new per transaction
				DocumentTO docTO = popolaDocumentTO(context, fascicoloTO, form, fileName, contentType);					
				
				ResponseDEMBILClient resp = null;
				
//				List<DescDocumentoTO> descDocumenti = context.getModel(WebConstants.LIST_DESC_DOCUMENTI);
//				for(DescDocumentoTO descDoc :descDocumenti){
//					if(descDoc.getId().equals(form.getDesc()) ){
//						CodeDescriptionTO codeTo = new CodeDescriptionTO();
//						codeTo.setCode(descDoc.getId());
//						codeTo.setDescription(descDoc.getTextDescrizione());
//						docTO.setDescDocumento(codeTo);
//						docTO.setDescrizione(descDoc.getTextDescrizione());
//						break;
//					}
//				}
				
				String tipoOperazione="";

				resp = uploadDecManager.uploadDocumento(docTO,null,fascicoloTO, tipoOperazione);
			
				if (resp.getEsitoTo() != null && resp.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){
					context.addInfo("info.upload.success","");
				}
				else{
					context.addError("error.generic", resp.getEsitoTo().getDescrizione());
				}
		
				
				//***************************
				
				

//				AnagAmminDemTO amm= ((List<AnagAmminDemTO>)context.getModel(WebConstants.LIST_AMMIN_DEM)).get(Integer.parseInt(form.getAmm()));
				
//				DocumentTO docTO = popolaDocumentTO(context, fascicoloTO, amm, form, fileName, contentType);					
//				EsitoTO esitoCancellazione = null;
//				
//				// Controllo documento TIPO_ATTO_DECRETO
//				if (form.getTipoDoc().equalsIgnoreCase(Constants.TIPO_ATTO_DECRETO)){
//					List<DocumentiTO> listDoc = getUploadDecManager().findDocumentiByTipoFascicolo(form.getTipoDoc(), Long.parseLong(fascicoloTO.getId().toString()));
//					
//					if(!listDoc.isEmpty()){
//						
//						// Se lo stato del documento presente è diverso 
//						// da 0 si inibisce l'operazione di
//						if( ((DocumentiTO)listDoc.get(0)).getStatDocumento().equals(Integer.parseInt(Constants.DOC_FAD_STAT_DOCUMENTO_ZERO)) ){
//							
//							// Eliminazione documento presente
//							fascicoloTO.setDocumentiList(listDoc);
//							esitoCancellazione = getGestioneFadManager().eliminaDocumentoFAD(fascicoloTO);
//						}
//						else {
//							context.addError("error.upload.documenti.stato","");
//							esitoCancellazione = new EsitoTO(DEMBILConstants.ESITO_KO, DEMBILConstants.ESITO_KO);
//						}
//					}
//				}
//				
//				// PER TEST
//				//esitoCancellazione.setCodice(DEMBILConstants.ESITO_OK);
//				
//				// Se esitoCancellazione è NULL o OK per la cancellazione del documento 
//				// di tipo atto decreto si esegue l'inserimento 
//				if(esitoCancellazione == null || esitoCancellazione.getCodice().equals(DEMBILConstants.ESITO_OK)){
//					
//					ResponseDEMBILClient resp = getUploadDecManager().uploadDocumento(docTO,amm,fascicoloTO);
//					
//					if (resp.getEsitoTo()!=null&&resp.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){
//						context.addInfo("info.upload.success","");
//						
//						// Si ripuliscono i campi digitati
//						form.setAmm("");
//						form.setTipoDoc("");
//						form.setDesc("");
//					}
//					else{
//						context.addError("error.generic", resp.getEsitoTo().getDescrizione());
//					}
//					
//				}
				
			} 
			catch (Throwable e) {				
				context.addError("error.generic", e.getMessage());
			}finally {
				if (fascicoloTO!=null){
					invioAlleFirmeManager.wsChangeStatoFascicoloAttoDecreto(fascicoloTO.getCodiGuidFascicolo(), StatoFascicoloDocumentale_type._CHIUSO);
				}
			}

		}			

		// Viene ricaricata la lista documenti
		List<FascicoliTO> listTo = new ArrayList<FascicoliTO>();
		FascicoliTO to = getGestioneFadManager().getFascicoloFad(ParseUtil.getLong( ((FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO)).getId() ));
		listTo.add(to);
		context.setDataModel(FASCICOLO_SELEZIONATO, to);
		
//		FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		if (!StringUtil.isEmpty(to.getDocumentiList())){
			PaginatorUtil.addPaginator(context, to.getDocumentiList(), LIST_DOCUMENTI_FAD, Paginator.PAGE_RANGE_15, DOCUMENTI_FAD_PAGINATOR);
		}
						
		return getDocumentiFadView();
	}

	protected DocumentTO popolaDocumentTO( Context context,FascicoliTO fascicoloTO,ConsFADCdcForm form,String fileName, String contentType) throws Throwable{
		
		DocumentTO docTo= new DocumentTO();

		
		docTo.setIdFascicolo(fascicoloTO.getCodiGuidFascicolo());
		
		TipoDocumentoTO descDocTo=uploadDecManager.loadTipoDocById(Constants.TIPO_ALLEGATI_DECRETO); //((List<TipoDocumentoTO>)listManager.loadTipoDocumentoAD()).get(Integer.parseInt(form.getTipoDoc()));//gestioneFadManager.loadDescDocById(Integer.parseInt(form.getTipoDoc()));
		CodeDescriptionTO descDoc= new CodeDescriptionTO();
		descDoc.setCode(descDocTo.getId());
		descDoc.setDescription(descDocTo.getDescDescrizioneDoc());
		docTo.setTipoDocumento(descDoc);
		docTo.setAttivo(true);
		docTo.setCondivisibile(true);
		docTo.setDaInviare(true);
//		DescDocumentoTO descDocTo = 
		docTo.setDescDocumento(new CodeDescriptionTO("20", "Atto Decreto CDC"));//TODO correggere con lettura DB
		DocumentContentTO dc= new DocumentContentTO();
		dc.setContent(form.getUpFile().getBytes());
		dc.setDescrizione("Atto Decreto CDC");//TODO correggere con lettura DB
		dc.setFileName(fileName);
		dc.setMimeType(contentType);
		dc.setHash(UtilRequestClient.createHash(form.getUpFile().getBytes()));
		docTo.setDocumentoContent(dc);
		
		
		CodeDescriptionTO ammDescTo= new CodeDescriptionTO(Constants.CODI_MULTI_AMMIN,Constants.CODI_MULTI_AMMIN);
		
		docTo.setAmministrazione(ammDescTo);
		docTo.setDataDocumento(DateUtil.getSysDate(Constants.DATE_SEPARATOR));
		
		CodeDescriptionTO ucbRts= new CodeDescriptionTO("","");
		
		
		docTo.setUcbRts(ucbRts);
		
		context.valorizeAudit(docTo, NomeFunzioneConstants.CONSULTAZIONE_CDC);
		return docTo;
	}

}
