package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;
import it.almavivaitalia.bilancio.commons.to.ItemTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoOperazione_type;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.servizi.to.FascicoloAttoDecretoTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.GestioneFadTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.form.GestioneFascicoloFadForm;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

//@RequestMapping(value = ConstantsRequestMapping.GESTIONE_FASCICOLO_F_A_D)
public class GestioneFascicoloFadParentController extends GestioneFascicoloFadGrandParentController {

	
	@Autowired
	private GestioneFadManager gestioneFadManager;
	

	public String onEliminaAllegatoFascicoloAttoDecreto(Context context) throws Throwable {
		FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		
		if(fascicoloTO.getSottoFascicoliRedList()!=null&&fascicoloTO.getSottoFascicoliRedList().size()>0){
			EsitoTO esito=getGestioneFadManager().eliminaAllegatoFAD(fascicoloTO);
			if(esito.getCodice().equals("OK")){
				context.addInfo("info.update.success", new String[]{});
			}else{
				context.addError("error.generic", new String[]{esito.getDescrizione()});
			}				
		}else{
			context.addError("error.cancellaDocumento.empty");
		}
		
		return getFascicoloFadView();
	}

	public String onEliminaDocumentoFascicoloAttoDecreto(Context context) throws Throwable {
		FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		
		if(fascicoloTO.getDocumentiList()!=null&&fascicoloTO.getDocumentiList().size()>0){
			EsitoTO esito=getGestioneFadManager().eliminaDocumentoFAD(fascicoloTO);
			if(esito.getCodice().equals("OK")){
				context.addInfo("info.update.success", new String[]{});
			}else{
				context.addError("error.generic", new String[]{esito.getDescrizione()});
			}				
		}else{
			context.addError("error.cancellaDocumento.empty");
		}
		
		return getFascicoloFadView();
	}

	public String onEliminaFad(Context context) throws Throwable {
		GestioneFascicoloFadForm form = context.getForm();
		if (form.isValid()) {
			FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
			EsitoTO esito=getGestioneFadManager().eliminaFAD(fascicoloTO);
			if(esito.getCodice().equals("OK")){
				context.addInfo("info.delete.success", new String[]{});
			}else{
				context.addError("error.generic", new String[]{esito.getDescrizione()});
			}
		}
		return onNuovaRicerca(context);  //getFascicoloFadView();
	}

	
	public String onCaricaUfficio(Context context) throws Throwable{
		GestioneFascicoloFadForm form = (GestioneFascicoloFadForm) context.getForm();
		if (form.isValid()){
			context.setDataModel(LIST_ANAG_UFF, getListManager().loadAnagUfficiAttivi());
		}
		return getFascicoloFadView();
	}
    
	public String onCaricaAmmin(Context context) throws Throwable {
		GestioneFascicoloFadForm form= (GestioneFascicoloFadForm) context.getForm();
		if (!form.isValid()) {
			return getFascicoloFadView();
		}
		
		String annoEsercizio=form.getAnnoDecreto();
		
		List<AnagAmminDemTO> listaAmm=getListManager().getAmminDemCentraliByAnnoEse(annoEsercizio);

		context.setDataModel(LIST_AMMIN_DEM, listaAmm);
//		String[] indexes=context.getModel(WebConstants.LIST_ROWS);
//
//		form.setAmmRows(indexes);
		
		return getStartView();
		
//		return selezioneAmmFadView;
	}
	
	


	@Override
	public String onNuovaRicerca(Context context)throws Throwable{
		GestioneFascicoloFadForm form = context.getForm();
		form.reset();
		context.removeDataModel(LIST_TIPOLOGIA_DECRETO);
		context.removeDataModel(LIST_AMMIN_DEM);
		context.removeDataModel(LIST_ANAG_CDR_DEM);
		return getStartView();
	}

	/*
		public String onApriDocumentiFad(Context context) throws Throwable{
			PaginatorUtil.removePaginator(context, LIST_DOCUMENTI_FAD,DOCUMENTI_FAD_PAGINATOR);
			FascicoliTO to = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
			
			if (!StringUtil.isEmpty(to.getDocumentiList())){
				PaginatorUtil.addPaginator(context, to.getDocumentiList(), LIST_DOCUMENTI_FAD, Paginator.PAGE_RANGE_5, DOCUMENTI_FAD_PAGINATOR);
				return documentiFadView;
			}
			context.addWarning("warning.empty");
			return fascicoloFadView;
		}
		
		@SuppressWarnings("unchecked")
		public String onApriDocumentiFascicoloRed(Context context) throws Throwable{
			PaginatorUtil.removePaginator(context, LIST_DOCUMENTI_RED, DOCUMENTI_RED_PAGINATOR);
	//		ConsultaFascicoloFadForm form = context.getForm();
			String rowNum = getParameter(context, "rowNum");
			if (rowNum==null){
				context.addError("error.generic" );
			}
			SottoFascicoliRedTO to = ((List<SottoFascicoliRedTO>)context.getModel(LIST_SOTTO_FASCICOLI_RED)).get(Integer.parseInt(rowNum)-1);
			
			if (!StringUtil.isEmpty(to.getDocumentiRedList())){
				PaginatorUtil.addPaginator(context, to.getDocumentiRedList(), LIST_DOCUMENTI_RED, Paginator.PAGE_RANGE_5, DOCUMENTI_RED_PAGINATOR);
				return documentiRedView;
			}
			context.addWarning("warning.empty");
			return fascicoloFadView;
		}
		
		@SuppressWarnings("unchecked")
		public String onApriDocumentiFascicoloPat(Context context) throws Throwable{
			PaginatorUtil.removePaginator(context, LIST_DOCUMENTI_PAT, DOCUMENTI_PAT_PAGINATOR);
	//		ConsultaFascicoloFadForm form = context.getForm();
			String rowNum = getParameter(context, "rowNum");
			if (rowNum==null){
				context.addError("error.generic" );
			}
			FascicoloSipatrTO to = ((List<FascicoloSipatrTO>)context.getModel(LIST_SOTTO_FASCICOLI_PAT)).get(Integer.parseInt(rowNum));
			if (!StringUtil.isEmpty(to.getDocumenti())){
				PaginatorUtil.addPaginator(context, to.getDocumenti(), LIST_DOCUMENTI_PAT, Paginator.PAGE_RANGE_5, DOCUMENTI_PAT_PAGINATOR);
				return documentiPatView;
			}
			return fascicoloFadView;
		}
		
		public String onBack(Context context)throws Throwable{
			return fascicoloFadView;
		}
		*/
		
		public String onPulisciMetadati(Context context) throws Throwable{
			onApriFascicoloFad(context);
			return getFascicoloFadView();
		}
        
		/*
		@Override
		public String onBackToFadInitialPageFromFad(Context context) throws Throwable{
			context.removeDataModel(WebConstants.CHK_MODIFICA_FAD);
			return super.onBackToFadInitialPage(context);
		}

		@Override
		public String onBackToFadInitialPageFromFad(Context context) throws Throwable{
			context.removeDataModel(WebConstants.CHK_MODIFICA_FAD);
			return super.onBackToFadInitialPage(context);
		}

		@Override
		public String onBackToFadInitialPageFromRed(Context context) throws Throwable{
			context.removeDataModel(WebConstants.CHK_MODIFICA_FAD);
			return super.onBackToFadInitialPage(context);
		}

		@Override
		public String onBackToFadInitialPageFromPatr(Context context) throws Throwable{
			context.removeDataModel(WebConstants.CHK_MODIFICA_FAD);
			return super.onBackToFadInitialPage(context);
		}
        */
		
	public String onSalvaMetadati (Context context) throws Throwable{
		GestioneFascicoloFadForm form = context.getForm();
		FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		
		boolean decrNormativo=false;
		if(form.getFlagNormativo()!=null && form.getFlagNormativo().equals("1")){
			GestioneFadTO gestFadTo=new GestioneFadTO();
			gestFadTo.setNumeroDec(fascicoloTO.getNumeNumDecreto());
			gestFadTo.setTipoDec(Integer.valueOf(fascicoloTO.getAnagTipoDecreto().getId()));
			gestFadTo.setAnnoDec(Integer.valueOf(fascicoloTO.getEserciziDem().getId()));
			
			decrNormativo=gestioneFadManager.controlloDecretoNormativo(gestFadTo);
			if(decrNormativo){
				context.addError("err.mod.decreto.exists", "");
				return getFascicoloFadView();
			}else {
				fascicoloTO.setFlagNormativo01(1);
			}
		}
		
//		if(form.getFlagNormativo()==null && fascicoloTO.getFlagNormativo01().compareTo(1)==0){
//			
//		}
		
		boolean modificaMetadatiBlocked = false;
		
		// IMPOSTO I CAMPI MODIFICABILI CHE SONO STATI IMPOSTATI
		
		/////////////////////////
		// DESCRIZIONE DECRETO //
		/////////////////////////
		if (!form.getDescrDecretoMod().equals(form.getDescDecreto())){
			//ho cambiato la descrizione
			fascicoloTO.setDescDecreto(form.getDescrDecretoMod());
		}
	
		///////////////////////
		// TIPOLOGIA DECRETO //
		///////////////////////
		//se il fascicolo è normativo la tipologia decreto arriva null poichè la combo è disabilitata. Per cui non viene cambiata.
		if (form.getTipologiaDecretoMod()!=null && !form.getTipologiaDecretoMod().equals(form.getTipologiaDecreto())){
			//ho cambiato la tipologia
			fascicoloTO.setAnagTipologiaDecreto(getGestioneFadManager().findTipologiaByCodi(form.getTipologiaDecretoMod()));
			modificaMetadatiBlocked = true;
		}
	
		/////////////////////
		// AMMINISTRAZIONI //
		/////////////////////
		List<AnagAmminDemTO> ammSelected = context.getModel(WebConstants.LIST_SELECTED_AMMS);
		
		if(fascicoloTO.getAnagAmminDemList().size() != ammSelected.size()){
			modificaMetadatiBlocked = true;
		}
		else {
			for(AnagAmminDemTO ammOld : fascicoloTO.getAnagAmminDemList()){
				
				if(!ammSelected.contains(ammOld)){
					modificaMetadatiBlocked = true;
				}
			}
		}
		
		fascicoloTO.setAnagAmminDemList(ammSelected);
		
		//////////////////////
		// UFFICIO CAPOFILA //
		//////////////////////
		if (!form.getUfficioMod().equals(form.getUfficio())){
			//ho cambiato l'ufficio capofila
			fascicoloTO.setUfficioCapofila(getGestioneFadManager().findUfficioByCodi(form.getUfficioMod()));
			modificaMetadatiBlocked = true;
		}
	
		///////////////////////
		// NUMERO PATRIMONIO //
		///////////////////////
//		if(form.getNumePatMod()==null||form.getNumePatMod().isEmpty()){
//			if (form.getNumePat()!=null&&!form.getNumePat().isEmpty()){
//				//ho cancellato il numero patrimonio
//				fascicoloTO.setNumePatrimonio(null);
//			}
//		}
//		
//		if(form.getNumePat()==null||form.getNumePat().isEmpty()){
//			if (form.getNumePatMod()!=null&&!form.getNumePatMod().isEmpty()){
//				//ho inserito il numero patrimonio
//				fascicoloTO.setNumePatrimonio(ParseUtil.getShort(form.getNumePatMod()));
//			}
//		}else{
//			if (form.getNumePatMod()!=null&&!form.getNumePatMod().isEmpty()&&form.getNumePatMod().compareTo(form.getNumePat())!=0){
//				//ho modificato il numero patrimonio
//				fascicoloTO.setNumePatrimonio(ParseUtil.getShort(form.getNumePatMod()));
//			}
//		}
		
		
		if(modificaMetadatiBlocked){
			
			// Controllo per blocco modifica metadati se il fascicolo è in firma
			if(!fascicoloTO.getStatStato().equals(Constants.STATO_FASCICOLO_APERTO)){
				context.addError("error.gestioneFad.modificaMetadati");
				return getFascicoloFadView();
			}
			
		}
		
		////////////////////
		// CAMPI DI AUDIT //
		////////////////////
		Utente u= getUtenteInSessione();
		
		fascicoloTO.setRowUpdatedUser(u.getUtente().getCodiUtente());
		fascicoloTO.setRowUpdatedDttm(Calendar.getInstance().getTime());
		fascicoloTO.setRowUpdatedForm(NomeFunzioneConstants.GESTIONE_FASCICOLO);
		
		///////////
		// ALTRO //
		///////////
		fascicoloTO.setDescUtenteModifica(u.getUtente().getCodiUtente());
		fascicoloTO.setDataModificaFascicolo(Calendar.getInstance().getTime());
		
		//////////////////////////////
		// CHIAMATA METODO MODIFICA //
		//////////////////////////////
		EsitoTO esito=getGestioneFadManager().modificaFAD(fascicoloTO);
		
		if(esito.getCodice().equals("OK")){
			context.addInfo("info.update.success", new String[]{});
			form.setFlagNormativo(fascicoloTO.getFlagNormativo01()!=null?String.valueOf(fascicoloTO.getFlagNormativo01()):null);
		}else{
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
		}
		return getFascicoloFadView();
	}

	@SuppressWarnings("unchecked")
	public String onUploadFile(Context context) throws Throwable {
		
			GestioneFascicoloFadForm form = (GestioneFascicoloFadForm) context.getForm();
			CommonsMultipartFile file = form.getUpFile();
			
			if (form.isValid()) {
				
				try {
					String contentType = getUploadDecManager().checkGuessedFileType( getAllowedContentType(), file.getOriginalFilename(), file.getInputStream());
	
					if (contentType.equals(Constants.NOT_ALLOWED)) {
						context.addError("error.contentType", "");
						return  getDocumentiFadView();
					} 
					
					if (contentType.equals(Constants.BAD_FILE)) {
						context.addError("error.contentType.badFile", "");
						return  getDocumentiFadView();
					} 
					String fileName=file.getOriginalFilename();
//					String fileName= getUploadDecManager().renameToMatchingFileExt(getContentTypeExtensions(),contentType, file.getOriginalFilename()); //configurazione con tika parsers
					
					// Prelevamento dell'id fascicolo
					FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
					FascicoliTO fascicoloToDelete = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
					
					
					int visibilita = 0; //2 == 0
					if(Integer.parseInt(form.getDescVisibilitaCdc()) == 1)
						visibilita = 1;
					
					fascicoloTO.setFlagVisibilitaCdc01(visibilita);
					fascicoloToDelete.setFlagVisibilitaCdc01(visibilita);
					
					// Controllo selezione amministrazione
					AnagAmminDemTO amm = new AnagAmminDemTO();
					if(form.getAmm() != null && !"".equals(form.getAmm())){
						amm = ((List<AnagAmminDemTO>)context.getModel(WebConstants.LIST_AMMIN_DEM)).get(Integer.parseInt(form.getAmm())-1);
					}
					else {
						amm = null;
					}
					
					
					//* code new per transaction
					DocumentTO docTO = popolaDocumentTO(context, fascicoloTO, amm, form, fileName, contentType);					
					EsitoTO esitoCancellazione = null;
					
					ResponseDEMBILClient resp = null;
					
					List<DescDocumentoTO> descDocumenti = context.getModel(WebConstants.LIST_DESC_DOCUMENTI);
					for(DescDocumentoTO descDoc :descDocumenti){
						if(descDoc.getId().equals(form.getDesc()) ){
							CodeDescriptionTO codeTo = new CodeDescriptionTO();
							codeTo.setCode(descDoc.getId());
							codeTo.setDescription(descDoc.getTextDescrizione());
							docTO.setDescDocumento(codeTo);
							docTO.setDescrizione(descDoc.getTextDescrizione());
							break;
						}
					}
					
					String tipoOperazione="";

					switch (Integer.parseInt(form.getTipoOperazione())) {
					case 1:
						tipoOperazione = TipoOperazione_type._CONVERSIONE;
						break;
					case 2:
						tipoOperazione = TipoOperazione_type._FIRMA_AUTOMATICA;
						break;
					case 3:
						tipoOperazione = TipoOperazione_type._FIRMA_IMMAGINE;
						break;
					case 4:
						tipoOperazione = TipoOperazione_type._PLACEHOLDER;
						break;
					default:
						tipoOperazione = "";
						break;
					}
					
					// Controllo documento TIPO_ATTO_DECRETO
					if (form.getTipoDoc().equalsIgnoreCase(Constants.TIPO_ATTO_DECRETO)){
						
						List<DocumentiTO> listDoc = getUploadDecManager().findDocumentiByTipoFascicolo(form.getTipoDoc(), Long.parseLong(fascicoloTO.getId().toString()));
						
						if(!listDoc.isEmpty()){
							
							// Se lo stato del documento presente è diverso 
							// da 0 si inibisce l'operazione di
							if( ((DocumentiTO)listDoc.get(0)).getStatDocumento().equals(Integer.parseInt(Constants.DOC_FAD_STAT_DOCUMENTO_ZERO)) ){
								
								// Eliminazione documento presente
								// e inserimento del nuovo
								fascicoloTO.setDocumentiList(listDoc);
								resp = getUploadDecManager().uploadDocumentoAttoDecreto(docTO, amm, fascicoloTO, fascicoloToDelete, tipoOperazione);
							}
							else {
								context.addError("error.upload.documenti.stato","");
								esitoCancellazione = new EsitoTO(DEMBILConstants.ESITO_KO, DEMBILConstants.ESITO_KO);
							}
						}
						else {
							resp = getUploadDecManager().uploadDocumento(docTO,amm,fascicoloTO, tipoOperazione);
						}						
						 
					}
					else{
						resp = getUploadDecManager().uploadDocumento(docTO,amm,fascicoloTO, tipoOperazione);
					}
					
					if(esitoCancellazione == null){
						if (resp.getEsitoTo() != null && resp.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){
							context.addInfo("info.upload.success","");
							
							// Si ripuliscono i campi digitati
							form.setAmm("");
							form.setTipoDoc("");
							form.setDesc("");
						}
						else{
							if (StringUtil.isEmpty(resp.getEsitoTo().getErrors())){
								context.addError("error.generic", resp.getEsitoTo().getDescrizione());
							} else {
								String detail = "";
								for(String error:resp.getEsitoTo().getErrors()){
									detail += detail.isEmpty()?": ":" - ";
									detail += error;
								}
								context.addError("error.generic1", resp.getEsitoTo().getDescrizione(),detail);
							}
						}
					}
				
					
					//***************************
					
					
	
					
				} 
				catch (Throwable e) {				
					context.addError("error.generic", e.getMessage());
				}
	
			}			
	
			// Viene ricaricata la lista documenti
			List<FascicoliTO> listTo = new ArrayList<FascicoliTO>();
			FascicoliTO to = getGestioneFadManager().getFascicoloFad(ParseUtil.getLong( ((FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO)).getId() ));
			listTo.add(to);
			context.setDataModel(FASCICOLO_SELEZIONATO, to);
			FascicoloAttoDecretoTO fascicoloDemBil = (FascicoloAttoDecretoTO) gestioneFadManager.getFascicoliPatrimonio(to.getCodiGuidFascicolo()).getOutputTO();
			if (fascicoloDemBil!=null){
				popolaPreview(to,fascicoloDemBil);
			}
			
			FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
			if (!StringUtil.isEmpty(fascicoloTO.getDocumentiList())){
				PaginatorUtil.addPaginator(context, fascicoloTO.getDocumentiList(), LIST_DOCUMENTI_FAD, Paginator.PAGE_RANGE_15, DOCUMENTI_FAD_PAGINATOR);
			}
			
			
			//impostazione della form di upload altrimenti non funzionano i JavaScript
			form.setTipoDoc("");
			form.setDesc("");
			form.setDescVisibilitaCdc("");
			form.setTipoOperazione("");
							
			return getDocumentiFadView();
		}

		
		
		@Override
		public String startController(Context context) throws Throwable {
			context.setCurrentNode("DemDec.menu.GestFAD");
			context.setDataModel(LIST_ANNO_ESE, getListManager().loadEserciziDemCG());
			context.setDataModel(LIST_ANAG_STATI_FASC, getListManager().loadStatiFascicoliFad());
			context.setDataModel(LIST_ANAG_STATI_FASC_MODIFICA, getListManager().loadStatiFascicoliModificaFad());
			context.setDataModel(LIST_TIPI_DECRETI, getListManager().loadAnagTipoDecreto());
			context.setDataModel(LIST_ANAG_UFF, getListManager().loadAnagUfficiAttivi());
			context.setDataModel(WebConstants.LIST_TIPO_DOC_RED, getListManager().loadTipoDocumentoIG());
			context.setDataModel(WebConstants.LIST_VISIBILITA_CDC, getListManager().loadVisibilitaCdc());
			
			return getStartView();
		}
    
		@Override
		public String onEseguiRicerca(Context context)throws Throwable{
			GestioneFascicoloFadForm form = context.getForm();
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
			
//			List<FascicoliTO> lista = getGestioneFadManager().getFascicoliFad(to);
			List<FascicoliTO> lista = getGestioneFadManager().getFascicoliGestioneFad(to);
			
			if (lista==null || lista.size()==0){
				  		if(!StringUtil.isEmpty(to.getNumeDecreto())) {
					  			lista =getGestioneFadManager().getFascicoliFad(to);
					 
							   if (lista!=null && lista.size()>0) {
								   for (int i = 0; i < lista.size(); i++) {
									   lista.get(i).setDescStato(listManager.loadDecStatiFascicoliFad(lista.get(i).getStatStato().toString()));
									   context.addWarning("warning.gestione.fad.stato.no", lista.get(i).getNumeNumDecreto().toString(), lista.get(i).getDescStato().trim());
								   }
							   }else{
								    PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
									context.addWarning("warning.empty");
									return getStartView();
							   }
					   }else {
						    PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
							context.addWarning("warning.empty");
							return getStartView();
					   }
					 
					 return getStartView();
			}
			
			
//			if (lista==null||lista.size()==0){
//				PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
//				context.addWarning("warning.empty");
//				return getStartView();
//			}
			PaginatorUtil.addPaginator(lista,LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);
			//context.setDataModel(SessionAttributes.LIST_FASCICOLI_FAD, lista);
			
			return getAfterRicercaView();
		}
		
		public String onCaricaDescrizioneDocumenti(Context context) throws Throwable{
			
			GestioneFascicoloFadForm form = (GestioneFascicoloFadForm)context.getForm();
			List<DescDocumentoTO> listaDescDocumenti = getListManager().loadDescDocumentoByTipo(form.getTipoDoc());
			context.setDataModel(WebConstants.LIST_DESC_DOCUMENTI, listaDescDocumenti);
			
			List<ItemTO> listaOperazione = new ArrayList<ItemTO>();
			List<ItemTO> listaVisibilita = new ArrayList<ItemTO>();
			
			ItemTO item = null;
			
			if(!form.getTipoDoc().equals(Constants.TIPO_ATTO_DECRETO)){
				item = new ItemTO();
				item.setCodiItem("0");
				item.setDescItem("Nessun trattamento");
				listaOperazione.add(item);
				item = new ItemTO();
				item = new ItemTO();
				item.setCodiItem("1");
				item.setDescItem("Conversione");
				listaOperazione.add(item);
				item = new ItemTO();
				item.setCodiItem("2");
				item.setDescItem("Firma Automatica");
				listaOperazione.add(item);
				item = new ItemTO();
				item.setCodiItem("3");
				item.setDescItem("Firma Immagine");
				listaOperazione.add(item);
//				item = new ItemTO();
//				item.setCodiItem("5");
//				item.setDescItem("Solo Originale");
//				listaOperazione.add(item);
				form.setDescVisibilitaCdc("");
			} else {
				form.setDesc(listaDescDocumenti.get(0).getId());
				item = new ItemTO();
				item.setCodiItem("4");
				item.setDescItem("File Temporaneo");
				listaOperazione.add(item);
				form.setTipoOperazione("4");
				item = new ItemTO();
				item.setCodiItem("1");
				item.setDescItem("Visibile");
				listaVisibilita.add(item);

				form.setDescVisibilitaCdc("1");
			}
			context.setDataModel(WebConstants.LIST_TIPO_OPERAZIONE, listaOperazione);
			
			context.setDataModel(WebConstants.LIST_VISIBILITA_DESC_DOCUMENTI, listaVisibilita);
			
			return getDocumentiFadView();
		}
		
		public String onCaricaVisibilitaDocumenti(Context context) throws Throwable{
			
			GestioneFascicoloFadForm form = (GestioneFascicoloFadForm)context.getForm();
			//List<DescDocumentoTO> listaDescDocumenti = getGestioneFadManager().findVisibilitaDocumentoByCodiDescDocumento(form.getDesc());
			DescDocumentoTO documentoVis = (DescDocumentoTO) getGestioneFadManager().findVisibilitaDocumentoByCodiDescDocumento(form.getDesc());
			if (documentoVis==null){
				return getDocumentiFadView();
			}

			context.setDataModel(WebConstants.DOCUMENTO_PER_VISIBILITA, documentoVis);
			
			List<ItemTO> listaVisibilita = new ArrayList<ItemTO>();
			ItemTO item = null;
			if(!form.getTipoDoc().equals(Constants.TIPO_ATTO_DECRETO)){
				item = new ItemTO();
				item.setCodiItem("0");
				item.setDescItem("Non visibile");
				listaVisibilita.add(item);
			}
			item = new ItemTO();
			item.setCodiItem("1");
			item.setDescItem("Visibile");
			listaVisibilita.add(item);
			form.setDescVisibilitaCdc(""+documentoVis.getFlagVisibilitaCdc());
			form.setDescVisibilitaCdcDisabled(""+documentoVis.getFlagVisibilitaCdc());
			context.setDataModel(WebConstants.LIST_VISIBILITA_DESC_DOCUMENTI, listaVisibilita);
			
			return getDocumentiFadView();
		}
		
		
		
		public String onModificaFad(Context context) throws Throwable {
			FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
			GestioneFascicoloFadForm form = context.getForm();
			context.setDataModel(WebConstants.CHK_MODIFICA_FAD, "SI");
			form.setDescDecreto(fascicoloTO.getDescDecreto());
			form.setTipologiaDecreto(fascicoloTO.getAnagTipologiaDecreto().getId().toString());
			form.setUfficio(fascicoloTO.getUfficioCapofila().getId());
			form.setFlagNormativo(String.valueOf(fascicoloTO.getFlagNormativo01()));
			//form.setTipologiaDecretoMod(fascicoloTO.getAnagTipologiaDecreto().getDescTipologia());
			return getFascicoloFadView();
		}
}
