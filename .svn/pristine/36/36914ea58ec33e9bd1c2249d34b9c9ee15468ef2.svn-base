package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.AnagUfficiBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiBOId;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBOId;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.IterFirmaDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.IterFirmaDecretoBOId;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBOId;
import it.almavivaitalia.bilancio.commons.dao.UtenteDao;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bilancio.commons.to.EmailUtenteTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.manager.exception.ObjectNotFoundException;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.mef.bilancio.demdec.dao.IterFirmaDecretoDao;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.IterFirmaDecretoManager;
import it.mef.bilancio.demdec.manager.MailManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.to.AmminRagDemTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.to.DocumentiRedTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.utils.ErrorCode;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class GestioneFadParentManagerImpl extends GestioneFadGrandParentManagerImpl 	implements GestioneFadManager  {
	
	
	
	@Autowired
	private UtenteDao utenteDao;

	@Autowired 
	private MailManager mailManager;

	@Autowired
	private IterFirmaDecretoManager iterFirmaDecretoManager;
	
	@Autowired
	private IterFirmaDecretoDao iterFirmaDecretoDao;
	
	
	public UtenteDao getUtenteDao() {
		return utenteDao;
	}

	public MailManager getMailManager() {
		return mailManager;
	}


	

	public EsitoTO eliminaAllegatoFAD(FascicoliTO to) throws Throwable {
		ParametriInput parametri = leggiParametriInputDemBil();
		InterfacciaAttoDecretoDEMBILClient interfaccia=new InterfacciaAttoDecretoDEMBILClient();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(parametri);
		requestDEMBILClient.setIdFascicolo(to.getCodiGuidFascicolo());
		EsitoTO esitoTo=null;
		
		if(to.getSottoFascicoliRedList()!=null&&to.getSottoFascicoliRedList().size()>0){
			for(SottoFascicoliRedTO doc:to.getSottoFascicoliRedList()){
				// CANCELLAZIONE D_SOTTO_FASCICOLI_RED
				SottoFascicoliRedBOId sottoBoId = new SottoFascicoliRedBOId();
				sottoBoId.setFkNumeIdFascicolo(doc.getId().getFkNumeIdFascicolo());
				sottoBoId.setCodiIdRed(doc.getId().getCodiIdRed());
				SottoFascicoliRedBO sottoBo = getSottoFascicoliRedDao().loadById(SottoFascicoliRedBO.class, sottoBoId);
				
				if(doc.getDocumentiRedList()!=null && doc.getDocumentiRedList().size()>0){
					for(DocumentiRedTO docRed:doc.getDocumentiRedList()){
						requestDEMBILClient.setIdDocumento(docRed.getId().getCodiGuidDocumento());
						ResponseDEMBILClient resp= interfaccia.removeDocumentoAllegatoDecretoIGB(requestDEMBILClient);
						esitoTo=resp.getEsitoTo();
						
						if (esitoTo.getCodice().equals(DEMBILConstants.ESITO_OK)){
							// CANCELLAZIONE D_DOCUMENTI_RED
							DocumentiRedBOId boId = new DocumentiRedBOId();
							boId.setFkNumeIdFascicolo(docRed.getId().getFkNumeIdFascicolo());
							boId.setCodiGuidDocumento(docRed.getId().getCodiGuidDocumento());
							DocumentiRedBO bo = getDocumentiRedDao().loadById(DocumentiRedBO.class, boId);
							if (bo!=null){
								getDocumentiRedDao().delete(bo);
								// Richiamo cronologico
								getCronologicoManager().salvaCronologico(bo,//old
															null,//new
															null,
															null,
															CroTransTO.CRO_TRANS_CANCELLAZIONE_DOCUMENTO_RED,
															to.getRowUpdatedForm()==null?to.getRowCreatedForm():to.getRowUpdatedForm(), 
															to.getRowUpdatedUser()==null?to.getRowCreatedUser():to.getRowUpdatedUser());
							}
						}
					}
				}
				// SE DOPO LA CANCELLAZIONE DEL DOCUMENTO NON HO PIU' DOCUMENTI NEL SOTTOFASCICOLO CANCELLO
				List<DocumentiRedBO> lista = sottoBo.getDocumentiRedList();
				if (lista.size()==0){
					getSottoFascicoliRedDao().delete(sottoBo);
					// Set stato fascicolo aperto
					changeStatoFascicoloRaccoltaProvvisoria(sottoBo.getCodiGuidFascicolo(), Constants.STATO_FASCICOLO_APERTO.toString());
				}
				
			}
		}
		
		return esitoTo;
	}

	public EsitoTO eliminaDocumentoFAD(FascicoliTO to) throws Throwable {
		ParametriInput parametri = leggiParametriInputDemBil();
		InterfacciaAttoDecretoDEMBILClient interfaccia=new InterfacciaAttoDecretoDEMBILClient();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(parametri);
		requestDEMBILClient.setIdFascicolo(to.getCodiGuidFascicolo());
		EsitoTO esitoTo=null;
		
		if(to.getDocumentiList()!=null&&to.getDocumentiList().size()>0){
			for(DocumentiTO doc:to.getDocumentiList()){
				requestDEMBILClient.setIdDocumento(doc.getCodiGuidDocumentoOrig());
				ResponseDEMBILClient resp= interfaccia.removeDocumentoFascicoloAttoDecreto(requestDEMBILClient);
				esitoTo=resp.getEsitoTo();
				
				if (esitoTo.getCodice().equals(DEMBILConstants.ESITO_OK)){
					// CANCELLAZIONE D_DOCUMENTI
					DocumentiBOId boId = new DocumentiBOId();
					boId.setFkNumeIdFascicolo(doc.getId().getFkNumeIdFascicolo());
					boId.setNumeIdDocumento(doc.getId().getNumeIdDocumento());
					DocumentiBO bo = getDocumentiDao().loadById(boId);
					getDocumentiDao().delete(bo);
				}
			}
		}
		
		return esitoTo;
	}

	public EsitoTO eliminaFAD(FascicoliTO to) throws Throwable {
		EsitoTO esitoTo=null;
		// CANCELLAZIONE DELLA D_SOTTO_FASCICOLI_RED e D_DOCUMENTI_RED CON RICHIAMO SERVIZIO
		esitoTo=eliminaAllegatoFAD(to);
		if (esitoTo==null||esitoTo.getCodice().equals(DEMBILConstants.ESITO_OK)){
			// CANCELLAZIONE DELLA D_DOCUMENTI CON RICHIAMO SERVIZIO
			esitoTo=eliminaDocumentoFAD(to);
		}
		if (esitoTo==null||esitoTo.getCodice().equals(DEMBILConstants.ESITO_OK)){
			// CANCELLAZIONE DELLA D_FASCICOLI E TABELLE DIPENDENTI CON RICHIAMO SERVIZIO
			esitoTo=eliminaFascicoloFAD(to);
		}		
		return esitoTo;
	}

	public EsitoTO eliminaFascicoloFAD(FascicoliTO to) throws Throwable {
		ParametriInput parametri = leggiParametriInputDemBil();
		InterfacciaAttoDecretoDEMBILClient interfaccia=new InterfacciaAttoDecretoDEMBILClient();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(parametri);
		requestDEMBILClient.setIdFascicolo(to.getCodiGuidFascicolo());
		ResponseDEMBILClient resp= interfaccia.removeFascicoloAttoDecreto(requestDEMBILClient);
		if (resp.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){
			// CANCELLAZIONE D_FASCICOLI, D_FASCICOLI_AMM, D_FASCICOLI_CDR, D_FASCICOLI_RAG, D_ITER_FIRMA_DECRETO
			// CANCELLAZIONE D_ITER_FIRMA_DECRETO
			IterFirmaDecretoBOId iterId = new IterFirmaDecretoBOId();
			iterId.setFkNumeIdFascicolo(to.getId());
			IterFirmaDecretoBO iter = getFascicoloDao().loadById(IterFirmaDecretoBO.class, iterId);
			if (iter!=null){
				getFascicoloDao().delete(iter);
			}
			
			// CANCELLAZIONE D_FASCICOLI, D_FASCICOLI_AMM, D_FASCICOLI_CDR, D_FASCICOLI_RAG
			FascicoliBO bo = getFascicoloDao().loadById(to.getId());
			getFascicoloDao().delete(bo);
		}
		return resp.getEsitoTo();
	}

	public AmminRagDemTO findAmminRagDemByAnagAmminDemTO( AnagAmminDemTO anagAmminDemTO) throws Throwable {
		return getDozerDriver().map(getAmminRagDemDao().findAmminRagDemByAnagAmminDemTO(anagAmminDemTO), AmminRagDemTO.class, "AmmRag");
	}

	public FascicoliTO findFascicoloByAnnoTipoNum(Integer anno, Integer tipo, Integer numDec) throws Throwable {	
		FascicoliBO bo=getFascicoloDao().findFascicoloByAnnoTipoNum(anno, tipo, numDec);
		FascicoliTO to=null;
		if(bo!=null){
			to=getDozerDriver().map(bo, FascicoliTO.class, "FascicoloFad");	
		}else{
			throw new ObjectNotFoundException("Fascicolo non trovato", ErrorCode.OBJECT_NOT_FOUND_EXCEPTION);
		}
		return to;	
	}

	public AnagTipologiaDecretoTO findTipologiaByCodi(String codi)
			throws Throwable {
		AnagTipologiaDecretoBO bo = getAnagTipologiaDecretoDao().loadById(ParseUtil.getInteger(codi));
		return (AnagTipologiaDecretoTO) getDozerDriver().map(bo, AnagTipologiaDecretoTO.class, "AnagTipologiaDecreto");
	}

	public AnagUfficiTO findUfficioByCodi(String codi)
			throws Throwable {
		AnagUfficiBO bo = getAnagUfficiDao().loadById(codi);
		return (AnagUfficiTO) getDozerDriver().map(bo, AnagUfficiTO.class, "AnagUffici");
	}

	
	
	public EsitoTO revocaSospensioneFascicolo(FascicoliTO src) throws Throwable {
		
		final int RISULTATO_NO_RECORD = 0;
		final int RISULTATO_MAX_3 = 3;
		final int RISULTATO_RECORD_1 = 2;
		final int RISULTATO_TUTTI_2 = 4;
		
		String stato = null;
		EsitoTO esito = null;
		
		FascicoliBO fascicoloBo = getFascicoloDao().loadById(src.getId());
		
		// Se la visibilità CDC del fascicolo è 1
		if(fascicoloBo.getFlagVisibilitaCdc01().equals(new Integer(1))){
			
			// Set dello stato del fascicolo a 6
			fascicoloBo.setStatStato(Constants.STATO_FASCICOLO_6);
			stato = Constants.STATO_FAD_IN_ELABORAZIONE;
			
//			getFascicoloDao().saveOrUpdate(fascicoloBo);
//			esito = changeStatoFascicoloAttoDecreto(src.getCodiGuidFascicolo(), stato);
		}
		else {
			
			String risultato = iterFirmaDecretoManager.findStatoIterFirmaDecretoByIdFascicolo(new Integer(src.getId().toString()));
			
			if(!"error".equalsIgnoreCase(risultato)){
			
				switch (Integer.parseInt(risultato)) {
				
					case RISULTATO_NO_RECORD:
						fascicoloBo.setStatStato(Constants.STATO_FASCICOLO_APERTO);
						stato = Constants.STATO_FAD_APERTO;
						break;
					
					case RISULTATO_MAX_3:
						fascicoloBo.setStatStato(Constants.STATO_FASCICOLO_FIRMA_SOSPESA);
						stato = Constants.STATO_FAD_APERTO;
						break;
						
					case RISULTATO_RECORD_1:
						fascicoloBo.setStatStato(Constants.STATO_FASCICOLO_IN_FIRMA);
						stato = Constants.STATO_FAD_IN_ELABORAZIONE;
						break; 
						
					case RISULTATO_TUTTI_2:
						fascicoloBo.setStatStato(Constants.STATO_FASCICOLO_FIRMATO);
						stato = Constants.STATO_FAD_CHIUSO;
						break;
						
					default:
						
						break;
				}				
				
			}
			else{
				// NOTIFICA ERRORE BASE DATI
				esito = new EsitoTO(DEMBILConstants.ESITO_KO, "Errore nella base dati");
			}
			
		}
		
		if(stato != null ){
			
			// Variazione stato
			fascicoloBo.setRowUpdatedDttm(Calendar.getInstance().getTime());
			fascicoloBo.setRowUpdatedUser(Constants.USER_NSBF_AMM);
			
			getFascicoloDao().saveOrUpdate(fascicoloBo);
			esito = changeStatoFascicoloAttoDecreto(src.getCodiGuidFascicolo(), stato);
			
			if(esito.equals(DEMBILConstants.ESITO_OK)){
				
				// Invio email PEC
				List<EmailUtenteTO> addressEmailList = utenteDao.findEmailUserPecRichSospensioneByIdFascicolo(new Integer(src.getId().toString()).longValue());
				Utente utente = new Utente(Constants.USER_NSBF_AMM);
				
				for(EmailUtenteTO address : addressEmailList){
					if(address.getFlagEmailPec().equals(new Integer(1))) {
						mailManager.invioPecDaFunzione(Constants.FUNZIONE_REVOCA_RICHIESTA_SOSPENSIONE, utente, address.getEmailUtente());
					}
					else {
						mailManager.invioPeoDaFunzione(Constants.FUNZIONE_REVOCA_RICHIESTA_SOSPENSIONE, utente, address.getEmailUtente());
					}							
				}
			}					
		}
		else{
			esito = new EsitoTO(DEMBILConstants.ESITO_KO, "Errore nella base dati");
		}
		
		return esito;
	}

	public EsitoTO riaperturaFascicolo(FascicoliTO src) throws Throwable {
		
		EsitoTO esito = null;
		FascicoliBO fascicoloBo = getFascicoloDao().loadById(src.getId());
		
		// Set dello stato a aperto(0)
		fascicoloBo.setStatStato(Constants.STATO_FASCICOLO_APERTO);
		fascicoloBo.setRowUpdatedDttm(Calendar.getInstance().getTime());
		fascicoloBo.setRowUpdatedUser(Constants.USER_NSBF_AMM);
		getFascicoloDao().saveOrUpdate(fascicoloBo);
		
		// ChangeStatoFascicolo
		esito = changeStatoFascicoloAttoDecreto(src.getCodiGuidFascicolo(), Constants.STATO_FAD_APERTO);
		
		// Controllo esito
		if(esito.getCodice().equals(DEMBILConstants.ESITO_OK)){
			
			// Lettura documenti di tipo AD01 associato al fascicolo
			List<DocumentiBO> docList = getDocumentiDao().findDocumentiByTipoFascicolo(Constants.TIPO_ATTO_DECRETO, src.getId());
			
			if(docList.size() > 0){					
				
				DocumentiBO docAttDecreto = docList.get(0);
				
				// Eliminazione del documento atto decreto
				ParametriInput parametri = leggiParametriInputDemBil();
				InterfacciaAttoDecretoDEMBILClient interfaccia = new InterfacciaAttoDecretoDEMBILClient();
				RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(parametri);
				requestDEMBILClient.setIdDocumento(docAttDecreto.getCodiGuidDocumentoOrig());
				requestDEMBILClient.setIdFascicolo(src.getCodiGuidFascicolo());
				ResponseDEMBILClient resp = interfaccia.removeDocumentoFascicoloAttoDecreto(requestDEMBILClient);
				
				EsitoTO esitoRemoveDocumento = resp.getEsitoTo();
				
				if(esitoRemoveDocumento.getCodice().equals(DEMBILConstants.ESITO_OK)){
					
					// Si provvede ad eliminare il documento atto decreto dalla base dati
//					DocumentiBOId boId = new DocumentiBOId();
//					boId.setFkNumeIdFascicolo(docAttDecreto.getId().getFkNumeIdFascicolo());
//					boId.setNumeIdDocumento(docAttDecreto.getId().getNumeIdDocumento());
//					DocumentiBO bo = getDocumentiDao().loadById(boId);
					getDocumentiDao().delete(docAttDecreto);
				}		
			}
			
			// Selezione iter firma da eliminare se presente
			List<IterFirmaDecretoBO> iters = iterFirmaDecretoDao.getListIterFirmaDecretoByNumeIdFascicolo(fascicoloBo.getId());
			
			if (iters != null){
				for (IterFirmaDecretoBO iter:iters){
					iterFirmaDecretoDao.delete(iter);
				}
			}
			
			
			// Invio email PEC
			List<EmailUtenteTO> addressEmailList = utenteDao.findEmailUserPecRichSospensioneByIdFascicolo(src.getId());
			Utente utente = new Utente(Constants.USER_NSBF_AMM);
			
			for(EmailUtenteTO address : addressEmailList){
				if(address.getFlagEmailPec().equals(new Integer(1))) {
					mailManager.invioPecDaFunzione(Constants.FUNZIONE_SOSPENSIONE_DECRETO, utente, address.getEmailUtente());
				}
				else {
					mailManager.invioPeoDaFunzione(Constants.FUNZIONE_RIAPERTURA_DECRETO, utente, address.getEmailUtente());
				}
				
			}
		}
		
//		return changeStatoFascicoloAttoDecreto(src.getCodiGuidFascicolo(), Constants.STATO_FAD_APERTO);
		return esito;
	}
	
	protected EsitoTO changeStatoFascicoloAttoDecreto(String guidFascicolo, String stato) throws Throwable {
		ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		requestDEMBILClient.setIdFascicolo(guidFascicolo);
		requestDEMBILClient.setStatoFascicoloAttoDecreto(stato);
		
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.changeStatoFascicoloAttoDecreto(requestDEMBILClient);
		
		return resp.getEsitoTo();
	}
	
	protected EsitoTO changeStatoFascicoloRaccoltaProvvisoria(String guidFascicolo, String stato) throws Throwable {
		ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		requestDEMBILClient.setIdFascicolo(guidFascicolo);
		requestDEMBILClient.setStatoFascicoloAttoDecreto(stato);
		
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.changeStatoFascicoloRacoltaProvvisoria(requestDEMBILClient);
		
		return resp.getEsitoTo();
	}



	
}
