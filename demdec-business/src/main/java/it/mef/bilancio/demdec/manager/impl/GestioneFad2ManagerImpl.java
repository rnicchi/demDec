package it.mef.bilancio.demdec.manager.impl;

import static it.mef.bilancio.demdec.utils.Constants.FAD_EXISTS;
import static it.mef.bilancio.demdec.utils.Constants.PATR_EXISTS;
import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBOId;
import it.almavivaitalia.bilancio.commons.bo.AnagCdrDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagCdrDemBOId;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.AnagUfficiBO;
import it.almavivaitalia.bilancio.commons.bo.DescDocumentoBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBOId;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bilancio.commons.to.CronoValoriTO;
import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.mef.bilancio.demdec.dao.AnagAmminDemDao;
import it.mef.bilancio.demdec.dao.AnagCdrDemDao;
import it.mef.bilancio.demdec.dao.AnagTipoDecretoDao;
import it.mef.bilancio.demdec.dao.DescDocumentoDao;
import it.mef.bilancio.demdec.dao.StrumentoDemDao;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.servizi.to.FadDemBilTO;
import it.mef.bilancio.demdec.to.AmminRagDemTO;
import it.mef.bilancio.demdec.to.CroCodiciTO;
import it.mef.bilancio.demdec.to.DocumentiRedTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.GestioneFadTO;
import it.mef.bilancio.demdec.to.StrumentoTO;
import it.mef.bilancio.demdec.utils.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GestioneFad2ManagerImpl extends GestioneFadParentManagerImpl implements GestioneFadManager 	 {

	@Autowired
	private StrumentoDemDao strumentoDemDao;
	@Autowired
	private AnagAmminDemDao anagAmminDemDao;
	@Autowired
	private AnagTipoDecretoDao anagTipoDecretoDao;
	@Autowired
	private AnagCdrDemDao anagCdrDemDao;
	@Autowired 
	private DescDocumentoDao descDocumentoDao;
	

/*	public List<DescDocumentoTO> findDescDocumentoByTipoDocumento(String tipoDocumento) throws Throwable {
				
		List<DescDocumentoBO>boList = getDocumentiDao().getDescDocumentiByTipoDocumento(tipoDocumento);		
		return getDozerDriver().mapList(boList, DescDocumentoTO.class, "DescDocumento");
		
	}*/
	
	@Override
	public DescDocumentoTO findVisibilitaDocumentoByCodiDescDocumento(String codiDescDocumento) throws Throwable
	{
		
		DescDocumentoBO bo = descDocumentoDao.loadById(codiDescDocumento);
		if (bo != null){
			return getDozerDriver().map(bo, DescDocumentoTO.class, "DescDocumento");
		} else {
			return null;
		}
		
	}
	
	/*
	public List<DescDocumentoTO> findVisibilitaDocumentoByCodiDescDocumento(String codiDescDocumento) throws Throwable
	{
		
		List<DescDocumentoBO>boList = getDocumentiDao().getVisibilitaDocumentoByCodiDescDocumento(codiDescDocumento);		
		return getDozerDriver().mapList(boList, DescDocumentoTO.class, "DescDocumento");
		
	}
	*/

	@Override
	public DocumentiRedTO getDocumentoRedById(String guidDocumento, Long idFascicolo) throws Throwable {
		
		DocumentiRedBOId boId=new DocumentiRedBOId();
		boId.setCodiGuidDocumento(guidDocumento);
		boId.setFkNumeIdFascicolo(idFascicolo);
		
		DocumentiRedBO dRedBo=getDocumentiRedDao().loadById(DocumentiRedBO.class, boId);
		
		return getDozerDriver().map(dRedBo, DocumentiRedTO.class, "DocumentiRed"); 
		
	}
	
	@Override
	public void saveFascicolo( List<AmminRagDemTO> ragList ,GestioneFadTO to, ResponseDEMBILClient resp) throws Throwable {
		List<AnagAmminDemBO> ammBoList=getDozerDriver().mapList(to.getAmmList(), AnagAmminDemBO.class, "AnagAmmin");
		List<AnagCdrDemBO> cdrBoList= getDozerDriver().mapList(to.getCdrList(), AnagCdrDemBO.class, "AnagCdr");
		List<AnagRagionerieDemBO> ragBoList= getDozerDriver().mapList(ragList/*to.getRagList()*/, AnagRagionerieDemBO.class, "AmminRagDem2AnagRagionerieDemBO");
		
//		List<AnagRagionerieDemBO> boList= getDozerDriver().mapList(to.getRagList(), AnagRagionerieDemBO.class, "AmminRagDemBO2AnagRagionerieDemBO");
		
		//non genero il guid al servizio per non avere differenti GUID sul documentale e sulla nostra base 
//		to.setCodiGuid(UtilRequestClient.createGuid().toString());
		
		FascicoliBO fascicolo = new FascicoliBO();
		fascicolo.setAnagAmminDemList(ammBoList);
		fascicolo.setAnagCdrDemList(cdrBoList);
		fascicolo.setAnagRagionerieDemList(ragBoList);
		fascicolo.setCodiGuidFascicolo(to.getCodiGuid()); 
		fascicolo.setStatStato(Constants.STATO_FASCICOLO_APERTO);
		fascicolo.setNumeNumDecreto(to.getNumeroDec());
//		fascicolo.setNumeTitolo(to.getTitolo().shortValue());
		fascicolo.setNumeTitolo(Constants.CODI_TITOLO_DEFAULT.shortValue());
		fascicolo.setNumePatrimonio(to.getNumPatr()==null?null:to.getNumPatr().shortValue());
		fascicolo.setDescDecreto(to.getDescDec());
		fascicolo.setFlagNormativo01(to.getFlagNormativo());
		fascicolo.setDescUtenteCreatore(to.getCodiUtente());
		fascicolo.setDataCreazioneFascicolo(new Date());
		fascicolo.setFlagVisibilitaCdc01(Constants.VISIBILE_CDC_NON_VISIBILE);
		FadDemBilTO demBilTO=(FadDemBilTO) resp.getOutputTO();
		fascicolo.setCodiGuidFascicolo(demBilTO.getGuid());
		

		StringBuilder cronoAmmin=new StringBuilder();
		/* STRINGA PER NUOVE AMMINISTRAZIONI */
		if (ammBoList!=null){
			for(AnagAmminDemTO ammin : to.getAmmList()){
				if(cronoAmmin.length()>0){
					cronoAmmin.append(";");	
				}
				cronoAmmin.append(ammin.getId().getAmmin());
			}
		}

		Set<CronoValoriTO> cronoValori = new HashSet<CronoValoriTO>();
		getCronologicoManager().addCronoValoriToList(
				cronoValori,
				CroCodiciTO.CODI_CODICE_AMMINISTRAZIONE, 
				Short.valueOf("8"),
				null, 
				cronoAmmin, 
				false);		
		List<CronoValoriTO> listCronoValori=new ArrayList<CronoValoriTO>(cronoValori);


		copyAudit(to, fascicolo);
		
		getFascicoloDao().saveFascicolo(fascicolo, to);
		
		//cronologico
		getCronologicoManager()
						.salvaCronologico(
								null,//old
								fascicolo,//new
								null,
								listCronoValori,
								CroTransTO.CRO_TRANS_INSERISCI_METADATI_FASCICOLO,
								to.getRowCreatedForm(), 
								to.getRowCreatedUser());
		
		
	}
	
	protected ResponseDEMBILClient invocaCreaFadWs( GestioneFadTO to,ParametriInput parametri) throws Throwable{
		
		Integer titolo=Constants.CODI_TITOLO_DEFAULT; //TODO chiedere il valore da usare
		List<AmminRagDemTO> ragList= new ArrayList<AmminRagDemTO>();
		for (AnagAmminDemTO amm : to.getAmmList()) {
			AmminRagDemTO rag= getDozerDriver().map(getAmminRagDemDao().findAmminRagDemByAnagAmminDemTO(amm), AmminRagDemTO.class, "AmmRag");
			ragList.add(rag);
		}

		// faccio query corrispondenza utente demdec e NSBF se non esiste scrivo NSBF-utente, altrimenti se DEMDEC le info sono già nel TO
		if (to.getChiamante().equalsIgnoreCase(Constants.CREAZIONE_GESTIONE_FAD_CHIAMANTE_NSBF)){
			UtenteTO utNsbf=getUtenteManager().loadByCodiUtenteNsbf(to.getCodiUtente());
			if (utNsbf==null){
				to.setCodiUtente("NSBF-"+to.getCodiUtente());
				to.setUfficioCreatore(Constants.UFFICIO_CREATORE_COORDINAMENTO);
			}
			else{
				to.setCodiUtente(utNsbf.getCodiUtente());
				to.setUfficioCreatore(utNsbf.getUtenteProfiloPrincipale().getAnagUffici().getId());
			}
		}else{
			to.setCodiUtente(to.getCodiUtente());
			to.setUfficioCreatore(to.getUfficioCreatore());
		}
		
		//  chiamo il servizio createFascicoloAttoDecreto e ottengo il GUID
		FadDemBilTO demTo= popolaFadDemTO(to, titolo, ragList);
		InterfacciaAttoDecretoDEMBILClient interfaccia=new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= interfaccia.createFascicoloAttoDecreto(new RequestDEMBILClient(parametri, demTo,null));
		
		// PER FARLO ANDARE AVANTI 
		//resp.getEsitoTo().setCodice("OK");
		
		if (resp.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){
			saveFascicolo(ragList, to, resp);
		}
		
		return resp;
	}

	protected FadDemBilTO popolaFadDemTO (GestioneFadTO to,Integer titolo,List<AmminRagDemTO> ragList ) throws Throwable{
		FadDemBilTO demTO= new FadDemBilTO();
		
		CodeDescriptionTO ufficioCapofila= new CodeDescriptionTO();
		ufficioCapofila.setCode(to.getUfficio());
		ufficioCapofila.setDescription(getAnagUfficiDao().loadById(AnagUfficiBO.class, to.getUfficio()).getDescUfficio()); 
		demTO.setUfficioCapofila(ufficioCapofila);
		
		CodeDescriptionTO ufficioCreatore= new CodeDescriptionTO();
		ufficioCreatore.setCode(to.getUfficioCreatore());
		AnagUfficiBO uffcreatore= getAnagUfficiDao().loadById(AnagUfficiBO.class, to.getUfficioCreatore());
		ufficioCreatore.setDescription(uffcreatore!=null?uffcreatore.getDescUfficio():"");
		demTO.setUfficioCreatore(ufficioCreatore);
		
		CodeDescriptionTO tipologia= new CodeDescriptionTO();
		tipologia.setCode(to.getTipologiaDec().toString());
		tipologia.setDescription(getAnagTipologiaDecretoDao().loadById(AnagTipologiaDecretoBO.class, to.getTipologiaDec()).getDescTipologia());
		demTO.setTipologiaDec(tipologia);
		
		
		CodeDescriptionTO amm= new CodeDescriptionTO();
		if (CollectionUtils.isEmpty(to.getAmmList()) || to.getAmmList().size() > 1){
			amm.setCode(Constants.CODI_MULTI_AMMIN);
			amm.setDescription(Constants.DESC_MULTI_AMMIN);
		}
		else{
			AnagAmminDemBOId ammId= new AnagAmminDemBOId();
			ammId.setNumeApp((to.getAmmList().get(0).getId().getNumeApp()));
			ammId.setNumeStp((to.getAmmList().get(0).getId().getNumeStp()));
			ammId.setFkAnnoEse(to.getAnnoDec().shortValue());
			amm.setCode(to.getAmmList().get(0).getId().getAmmin());
			amm.setDescription(anagAmminDemDao.loadById(ammId).getDescAmm());
		}
		demTO.setAmm(amm);
		
		
		
		CodeDescriptionTO ucbRTS= new CodeDescriptionTO();
		
		if (ragList.size()>1){
			ucbRTS.setCode(Constants.CODI_MULTI_RAG);
			ucbRTS.setDescription(Constants.DESC_MULTI_RAG);
		}
		else{
			ucbRTS.setCode(ragList.get(0).getId().getNumeRag().toString());
			ucbRTS.setDescription(ragList.get(0).getId().getNumeRag().toString());
		}
		demTO.setUcbRts(ucbRTS);
	
		
		CodeDescriptionTO titoloDesc= new CodeDescriptionTO();
		titoloDesc.setCode(titolo.toString());
		titoloDesc.setDescription(titolo.toString());
		demTO.setTitolo(titoloDesc);
		
		CodeDescriptionTO cdr= new CodeDescriptionTO();
		AnagCdrDemBOId cdrId= new AnagCdrDemBOId();
		if (to.getCdrList() == null || to.getCdrList().size() == 0){
			cdr.setCode(Constants.CODI_NO_CDR);
			cdr.setDescription(Constants.DESC_NO_CDR);
		}else if (to.getCdrList().size()>1){
			cdr.setCode(Constants.CODI_MULTI_CDR);
			cdr.setDescription(Constants.DESC_MULTI_CDR);
			
		}else{
			cdrId.setFkNumeApp((to.getAmmList().get(0).getId().getNumeApp()));
			cdrId.setFkNumeStp((to.getAmmList().get(0).getId().getNumeStp()));
			cdrId.setFkAnnoEse(to.getAnnoDec().shortValue());
			cdrId.setNumeCdr(to.getCdrList().get(0).getId().getNumeCdr().shortValue());
			cdr.setCode(cdrId.getNumeCdr().toString());
			cdr.setDescription(anagCdrDemDao.loadById(cdrId).getDescCdr());
		}
		
		demTO.setCdr(cdr);
		
		
		CodeDescriptionTO utenteCreatore= new CodeDescriptionTO();
		utenteCreatore.setCode(to.getCodiUtente());
		utenteCreatore.setDescription(to.getCodiUtente());
		demTO.setUtenteCreatore(utenteCreatore);
		
		demTO.setChiamante(to.getChiamante());
		demTO.setTipoDec(to.getTipoDec()); // DMT o DIM
		demTO.setNumeroDec(to.getNumeroDec());
		demTO.setDescDec(to.getDescDec());
		demTO.setAnnoDec(to.getAnnoDec());
		demTO.setStatoFascicolo(Constants.STATO_FASCICOLO_APERTO.toString());
		demTO.setFlagNormativo(to.getFlagNormativo());
		demTO.setGuid(UUID.randomUUID().toString());
		
		
		CodeDescriptionTO siglaTipoDec= new CodeDescriptionTO();
		siglaTipoDec.setCode(to.getTipoDec().toString());
		siglaTipoDec.setDescription(anagTipoDecretoDao.loadById(to.getTipoDec()).getDescSigla());
		
		demTO.setSiglaTipoDec(siglaTipoDec);
		Integer numPatr= to.getNumPatr();
		demTO.setNumPatr(numPatr);
		
		if (numPatr!=null){
			String guidPatr=getvBilDecretiDao().findGuidSiPatrBynumPatr(numPatr,to.getAnnoDec());
			demTO.setGuidSiPatr(guidPatr);
		}
		
		return demTO;
	}

	@Override
	public EsitoTO creaFAD( GestioneFadTO to ) throws Throwable{
		
		ParametriInput parametri = leggiParametriInputDemBil();
		FascicoliBO fascicolo = getFascicoloDao().findFascicoloByAnnoTipoNum(to.getAnnoDec(), to.getTipoDec(), to.getNumeroDec());
		if (fascicolo!=null && fascicolo.getId()!=null ){
			// esite già un fascicolo per il decreto 
			return new EsitoTO(DEMBILConstants.ESITO_KO_ERR, FAD_EXISTS) ;
		}
		
		
		boolean decrExists=controlloDecretoNormativo(to);
		//se il numero decreto già esiste sul gestionale non posso usarlo
		if (decrExists){
			if (to.getFlagNormativo()!=null && to.getFlagNormativo()==1){
				return new EsitoTO(DEMBILConstants.ESITO_KO_ERR, "err.decreto.exists") ;
//				context.addError("err.decreto.exists", "");
//				return startView;
			}else{
				//return new EsitoTO(DEMBILConstants.ESITO_OK, "") ;
				//creazioneFad=true;
			}
		} else {
			if (to.getFlagNormativo()!=null && to.getFlagNormativo()==1){
				//creazioneFad=true;
				//return new EsitoTO(DEMBILConstants.ESITO_OK, "") ;
			}else {
				return new EsitoTO(DEMBILConstants.ESITO_KO_ERR, "err.decreto.gestionale") ;
//				context.addError("err.decreto.gestionale", "");
//				return startView;
			}
		}
		
		
		
		
		
		if (to.getChiamante().equalsIgnoreCase(Constants.CREAZIONE_GESTIONE_FAD_CHIAMANTE_DEMDEC)){
			StrumentoTO strum = getStrumentoDemDao().findDecretoByAnnoTipoNum(to.getAnnoDec(), to.getTipoDec(), to.getNumeroDec());
			if (strum.getNumeNum()!=null && !it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(to.getNumPatr()) && !to.getNumPatr().equals(strum.getNumePatr()) ){
				//esiste già un decreto sul sistema gestionale collegato a un diverso numero di prelevamento patrimonio.
				return new EsitoTO(DEMBILConstants.ESITO_KO_ERR, PATR_EXISTS) ;
			}
	
		}
		ResponseDEMBILClient resp= invocaCreaFadWs(to, parametri);
		
		return resp.getEsitoTo();
	}
	
	
	
	@SuppressWarnings("static-access")
	@Override
	public EsitoTO modificaFAD(FascicoliTO to) throws Throwable {
		
		
		InterfacciaAttoDecretoDEMBILClient interfaccia=new InterfacciaAttoDecretoDEMBILClient();
		
		FadDemBilTO fad=new FadDemBilTO();
		fad.setGuid(to.getCodiGuidFascicolo()); 
		fad.setDescDec(to.getDescDecreto());
		//#########################################################################Tipologia Decreto
		CodeDescriptionTO tipologiaDec = new CodeDescriptionTO(to.getAnagTipologiaDecreto().getId().toString(), to.getAnagTipologiaDecreto().getDescTipologia());
		fad.setTipologiaDec(tipologiaDec);
		//#########################################################################Tipologia Decreto
		
		//#########################################################################Amministrazione
		CodeDescriptionTO amm= new CodeDescriptionTO();
		
		if (CollectionUtils.isEmpty(to.getAnagAmminDemList()) || to.getAnagAmminDemList().size()>1){
			amm.setCode(Constants.CODI_MULTI_AMMIN);
			amm.setDescription(Constants.DESC_MULTI_AMMIN);
		}
		else{
			AnagAmminDemBOId ammId= new AnagAmminDemBOId();
			ammId.setNumeApp((to.getAnagAmminDemList().get(0).getId().getNumeApp()));
			ammId.setNumeStp((to.getAnagAmminDemList().get(0).getId().getNumeStp()));
			ammId.setFkAnnoEse(to.getEserciziDem().getId());
			
			amm.setCode(to.getAnagAmminDemList().get(0).getId().getNumeStpFormatted()+""+to.getAnagAmminDemList().get(0).getId().getNumeApp());
			amm.setDescription((getFascicoloDao().loadById(AnagAmminDemBO.class, ammId).getDescAmm()));
		}
		
		fad.setAmm(amm);
		//#########################################################################Amministrazione
		
		//#########################################################################Ufficio Capofila
		CodeDescriptionTO ufficioCapofila= new CodeDescriptionTO();
		ufficioCapofila.setCode(to.getUfficioCapofila().getId());
		ufficioCapofila.setDescription(getFascicoloDao().loadById(AnagUfficiBO.class, to.getUfficioCapofila().getId()).getDescUfficio());
		fad.setUfficioCapofila(ufficioCapofila);
		//#########################################################################Ufficio Capofila
		
		//#########################################################################CDR 
		
		//#########################################################################CDR 
		
		//#########################################################################Numero Patrimonio
		if(to.getNumePatrimonio()!=null){
			fad.setNumPatr(to.getNumePatrimonio().intValue());
			String guidPatr=getvBilDecretiDao().findGuidSiPatrBynumPatr(to.getNumePatrimonio().intValue(),to.getEserciziDem().getId().intValue());
			fad.setGuidSiPatr(guidPatr);
		} else{
			fad.setNumPatr(null);
			fad.setGuidSiPatr(null);
		}
		//#########################################################################Numero Patrimonio
		
		//#########################################################################Ragionerie
		
		List<AmminRagDemTO> ragList= new ArrayList<AmminRagDemTO>();
		
		if(to.getAnagAmminDemList()!=null){
			for (AnagAmminDemTO anagAmminDemTO : to.getAnagAmminDemList()) {
				AmminRagDemTO rag= getDozerDriver().map(getAmminRagDemDao().findAmminRagDemByAnagAmminDemTO(anagAmminDemTO), AmminRagDemTO.class, "AmmRag");
				ragList.add(rag);
			}		
		}
		
		CodeDescriptionTO ucbRTS= new CodeDescriptionTO();
		
		if (ragList.size()==0||ragList.size()>1){
			ucbRTS.setCode(Constants.CODI_MULTI_RAG);
			ucbRTS.setDescription(Constants.DESC_MULTI_RAG);
		}
		else{
			ucbRTS.setCode(ragList.get(0).getId().getNumeRag().toString());
			ucbRTS.setDescription(ragList.get(0).getId().getNumeRag().toString());
		}
		fad.setUcbRts(ucbRTS);
		//#########################################################################Ragionerie
		fad.setChiamante("NsbfGestioneFascicoli".equalsIgnoreCase(to.getRowUpdatedForm())?Constants.CREAZIONE_GESTIONE_FAD_CHIAMANTE_NSBF:Constants.CREAZIONE_GESTIONE_FAD_CHIAMANTE_DEMDEC);
		
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(leggiParametriInputDemBil());
		requestDEMBILClient.setIdFascicolo(to.getCodiGuidFascicolo());
		requestDEMBILClient.setInputTO(fad);
		
		
		ResponseDEMBILClient resp=interfaccia.modifyMetadatiFascicoloAttoDecreto(requestDEMBILClient);
		//ResponseDEMBILClient resp=new ResponseDEMBILClient("","");
		// PER FARLO ANDARE AVANTI 
	//	resp.getEsitoTo().setCodice("OK");
		
		if (resp.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){
			
			List<AnagAmminDemBO> ammBoList=null;
			List<AnagCdrDemBO> cdrBoList=null;
			List<AnagRagionerieDemBO> ragBoList=null;
			if (to.getAnagAmminDemList()!=null){
				ammBoList=getDozerDriver().mapList(to.getAnagAmminDemList(), AnagAmminDemBO.class, "AnagAmmin");
				cdrBoList= getDozerDriver().mapList(to.getAnagCdrDemList(), AnagCdrDemBO.class, "AnagCdr");
				ragBoList= getDozerDriver().mapList(ragList/*to.getRagList()*/, AnagRagionerieDemBO.class, "AmminRagDem2AnagRagionerieDemBO");
			}
			
//			List<AnagRagionerieDemBO> boList= getDozerDriver().mapList(to.getRagList(), AnagRagionerieDemBO.class, "AmminRagDemBO2AnagRagionerieDemBO");
			
			//non genero il guid al servizio per non avere differenti GUID sul documentale e sulla nostra base 
//			to.setCodiGuid(UtilRequestClient.createGuid().toString());
			
			FascicoliBO fascicolo = getFascicoloDao().loadById(FascicoliBO.class, to.getId());
			
			/* PER IL CRONOLOGICO */
			StringBuilder cronoAmmin=new StringBuilder();
			StringBuilder cronoAmminOld=new StringBuilder();
			FascicoliBO old= getDozerDriver().map(fascicolo, FascicoliBO.class, "FascicoloFad");
			
			/* STRINGA PER VECCHIE AMMINISTRAZIONI */
			if (old.getAnagAmminDemList()!=null){
				for(AnagAmminDemBO amminOld : old.getAnagAmminDemList()){
					if(cronoAmminOld.length()>0){
						cronoAmminOld.append(";");	
					}
					cronoAmminOld.append(amminOld.getId().getNumeStp().SIZE==2?
							amminOld.getId().getNumeStp()+amminOld.getId().getNumeApp():
								"0"+amminOld.getId().getNumeStp()+amminOld.getId().getNumeApp());
				}
			}
			
			/* STRINGA PER NUOVE AMMINISTRAZIONI */
			if (ammBoList!=null){
				for(AnagAmminDemBO ammin : ammBoList){
					if(cronoAmmin.length()>0){
						cronoAmmin.append(";");	
					}
					cronoAmmin.append(ammin.getId().getNumeStp().SIZE==2?
							ammin.getId().getNumeStp()+ammin.getId().getNumeApp():
								"0"+ammin.getId().getNumeStp()+ammin.getId().getNumeApp());
				}
			}
			
			fascicolo.setDescDecreto(to.getDescDecreto());
			fascicolo.setAnagAmminDemList(ammBoList);
			fascicolo.setAnagCdrDemList(cdrBoList);
			fascicolo.setAnagRagionerieDemList(ragBoList);
			fascicolo.setNumePatrimonio(to.getNumePatrimonio());
			fascicolo.setUfficioCapofila(getFascicoloDao().loadById(AnagUfficiBO.class, to.getUfficioCapofila().getId()));
            fascicolo.setAnagTipologiaDecreto(getFascicoloDao().loadById(AnagTipologiaDecretoBO.class, to.getAnagTipologiaDecreto().getId()));
			fascicolo.setDataModificaFascicolo(to.getDataModificaFascicolo());
			fascicolo.setDescUtenteModifica(to.getDescUtenteModifica());
			fascicolo.setFlagNormativo01(to.getFlagNormativo01());
            
//			FadDemBilTO demBilTO=(FadDemBilTO) resp.getOutputTO();
//			fascicolo.setCodiGuidFascicolo(demBilTO.getGuid());
			copyAudit(to, fascicolo);
			
			getFascicoloDao().updateFascicolo(fascicolo);
			
			Set<CronoValoriTO> cronoValori = new HashSet<CronoValoriTO>();
			getCronologicoManager().addCronoValoriToList(
					cronoValori,
					CroCodiciTO.CODI_CODICE_AMMINISTRAZIONE, 
	                Short.valueOf("3"),
	                cronoAmminOld, 
	                cronoAmmin, 
	                false);		
			List<CronoValoriTO> listCronoValori=new ArrayList<CronoValoriTO>(cronoValori);
			
			// Richiamo cronologico
			getCronologicoManager().salvaCronologico(
									old,//old
									fascicolo,//new
									null,
									listCronoValori,
									CroTransTO.CRO_TRANS_MODIFICA_METADATI_FASCICOLO,
									to.getRowUpdatedForm(), 
									to.getRowUpdatedUser());
			
		}
		
		return resp.getEsitoTo();
	}
	
	
	//controllo se il numero decreto già esiste su NSBF
	@Override
		public boolean controlloDecretoNormativo( GestioneFadTO to)  throws Throwable {
			boolean flag=false;
			
			StrumentoTO toRes=strumentoDemDao.findDecretoByAnnoTipoNum(to.getAnnoDec(), to.getTipoDec(), to.getNumeroDec());
			if(toRes!=null && toRes.getAttNumeTipo()!=null && toRes.getAnnoEse()!=null && toRes.getNumeNum()!=null){
				flag=true;
			}
			
			return flag;
		}
	
	
}
