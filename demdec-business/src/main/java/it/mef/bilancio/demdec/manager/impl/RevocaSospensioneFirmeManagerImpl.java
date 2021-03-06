package it.mef.bilancio.demdec.manager.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.IterFirmaDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBO;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.mef.bilancio.demdec.dao.DocumentiDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.dao.IterFirmaDecretoDao;
import it.mef.bilancio.demdec.dao.SottoFascicoliRedDao;
import it.mef.bilancio.demdec.manager.RevocaSospensioneFirmeManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;
import it.mef.bilancio.demdec.utils.Constants;


public class RevocaSospensioneFirmeManagerImpl extends AbstractDemManagerImpl implements RevocaSospensioneFirmeManager {
	
	@Autowired
	private FascicoloDao fascicoloDao;
	
	@Autowired
	private IterFirmaDecretoDao iterFirmaDecretoDao;
	
	@Autowired
	private DocumentiDao documentiDao;
		
	@Autowired
	private SottoFascicoliRedDao sottoFascicoliRedDao;
	
	@Autowired
	private CronologicoManager cronologicoManager;
	
	@Override
	public IterFirmaDecretoTO aggiornaStati(Long numeIdFascicolo, String utente, String funzione) throws Throwable {
		
		FascicoliBO boFascOld=fascicoloDao.loadById(numeIdFascicolo);
		FascicoliBO boFascNew=fascicoloDao.loadById(numeIdFascicolo);
		boFascNew.setRowUpdatedDttm(Calendar.getInstance().getTime());
		boFascNew.setRowUpdatedUser(utente);
		boFascNew.setRowUpdatedForm(funzione);
		boFascNew.setStatStato(2);
		fascicoloDao.saveOrUpdate(boFascNew);
		
		// Richiamo cronologico
		cronologicoManager.salvaCronologico(boFascOld,//old
									boFascNew,//new
									null,
									null,
									CroTransTO.CRO_TRANS_REVOCA_SOSPENSIONE_FIRME,
									Constants.FUNZIONE_REVOCA_SOSPENSIONE_FIRME,  
									boFascNew.getRowUpdatedUser()==null?boFascNew.getRowCreatedUser():boFascNew.getRowUpdatedUser());
		

		
		List<DocumentiBO> docBoList=documentiDao.findDocumentiByTipoFascicolo(Constants.TIPO_ATTO_DECRETO, Long.valueOf(numeIdFascicolo));
		List<DocumentiBO> docBoList2=documentiDao.findDocumentiByTipoFascicolo(Constants.TIPO_ATTO_DECRETO, Long.valueOf(numeIdFascicolo));
		DocumentiBO boDocOld=docBoList.get(0);
		DocumentiBO boDocNew=docBoList2.get(0);
		boDocNew.setRowUpdatedDttm(Calendar.getInstance().getTime());
		boDocNew.setRowUpdatedUser(utente);
		boDocNew.setRowUpdatedForm(funzione);
		boDocNew.setStatDocumento(2);
		documentiDao.saveOrUpdate(boDocNew);
		
		// Richiamo cronologico
		cronologicoManager.salvaCronologico(boDocOld,//old
									boDocNew,//new
									null,
									null,
									CroTransTO.CRO_TRANS_REVOCA_SOSPENSIONE_FIRME,
									Constants.FUNZIONE_REVOCA_SOSPENSIONE_FIRME, 
									boDocNew.getRowUpdatedUser()==null?boDocNew.getRowCreatedUser():boDocNew.getRowUpdatedUser());
		
		
		
		List<SottoFascicoliRedBO> boSottoFascListOld=sottoFascicoliRedDao.findByNumeIdFascicolo(numeIdFascicolo);
		List<SottoFascicoliRedBO> boSottoFascListNew=sottoFascicoliRedDao.findByNumeIdFascicolo(numeIdFascicolo);
		
		SottoFascicoliRedBO boOld=null;
		SottoFascicoliRedBO boNew=null;
		//aggiorniamo tutti i record che hanno questo numeIdFascicolo
		for (int i = 0; i < boSottoFascListNew.size(); i++) {
			boOld=boSottoFascListOld.get(i);
			boNew=boSottoFascListNew.get(i);
			boNew.setRowUpdatedDttm(Calendar.getInstance().getTime());
			boNew.setRowUpdatedUser(utente);
			boNew.setRowUpdatedForm(funzione);
			boNew.setStatStato(1);
			sottoFascicoliRedDao.update(boNew);
			
			// Richiamo cronologico
			cronologicoManager.salvaCronologico(boOld,//old
												boNew,//new
										null,
										null,
										CroTransTO.CRO_TRANS_REVOCA_SOSPENSIONE_FIRME,
										Constants.FUNZIONE_REVOCA_SOSPENSIONE_FIRME, 
										boNew.getRowUpdatedUser()==null?boNew.getRowCreatedUser():boNew.getRowUpdatedUser());
		}
		

		
		//IterFirmaDecretoBO boIfd=iterFirmaDecretoDao.getCurrentIFDByIdFascicolo(Long.valueOf(numeIdFascicolo));
		IterFirmaDecretoBO boIfd=iterFirmaDecretoDao.getCurrentIFDByIdFascicoloEStato(Long.valueOf(numeIdFascicolo), "3");
		boIfd.setRowUpdatedDttm(Calendar.getInstance().getTime());
		boIfd.setRowUpdatedUser(utente);
		boIfd.setRowUpdatedForm(funzione);
		boIfd.setStatFirma("1");
		IterFirmaDecretoBO bo2=(IterFirmaDecretoBO)iterFirmaDecretoDao.saveOrUpdate(boIfd);
		
		// Richiamo cronologico
		cronologicoManager.salvaCronologico(null,//old
											bo2,//new
									null,
									null,
									CroTransTO.CRO_TRANS_REVOCA_SOSPENSIONE_FIRME,
									Constants.FUNZIONE_REVOCA_SOSPENSIONE_FIRME, 
									bo2.getRowUpdatedUser()==null?bo2.getRowCreatedUser():bo2.getRowUpdatedUser());
		
		
		return getDozerDriver().map(bo2, IterFirmaDecretoTO.class, "IterFirmaDecreto");
		
	}
	
	

	@Override
	public FascicoliTO findFascicoloByAnnoTipoNum(Integer anno, Integer tipo, Integer numDec) throws Throwable {		
		FascicoliBO fascBo=fascicoloDao.findFascicoloByAnnoTipoNum(anno, tipo, numDec);
		if(fascBo!=null){
			return getDozerDriver().map(fascBo, FascicoliTO.class, "FascicoliFad");
		}else{
			return null;
		}
	}
	
	
	@Override
	public EsitoTO riaperturaFascicolo(FascicoliTO src) throws Throwable {
		
		EsitoTO esito = null;
		FascicoliBO fascicoloBo =fascicoloDao.loadById(src.getId());
		
		// Set dello stato a aperto(0)
		fascicoloBo.setStatStato(Constants.STATO_FASCICOLO_APERTO);
		fascicoloBo.setRowUpdatedDttm(Calendar.getInstance().getTime());
		fascicoloBo.setRowUpdatedUser(Constants.USER_NSBF_AMM);
		fascicoloDao.saveOrUpdate(fascicoloBo);
		
		// ChangeStatoFascicolo
		esito = changeStatoFascicoloAttoDecreto(src.getCodiGuidFascicolo(), Constants.STATO_FAD_APERTO);
		
		// Controllo esito
		if(esito.getCodice().equals(DEMBILConstants.ESITO_OK)){
			
			// Lettura documenti di tipo AD01 associato al fascicolo
			List<DocumentiBO> docList = documentiDao.findDocumentiByTipoFascicolo(Constants.TIPO_ATTO_DECRETO, src.getId());
			
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
					documentiDao.delete(docAttDecreto);
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
//			List<EmailUtenteTO> addressEmailList = utenteDao.findEmailUserPecRichSospensioneByIdFascicolo(src.getId());
//			Utente utente = new Utente(Constants.USER_NSBF_AMM);
//			
//			for(EmailUtenteTO address : addressEmailList){
//				if(address.getFlagEmailPec().equals(new Integer(1))) {
//					mailManager.invioPecDaFunzione(Constants.FUNZIONE_SOSPENSIONE_DECRETO, utente, address.getEmailUtente());
//				}
//				else {
//					mailManager.invioPeoDaFunzione(Constants.FUNZIONE_RIAPERTURA_DECRETO, utente, address.getEmailUtente());
//				}
//				
//			}
		}
		
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

	
}
