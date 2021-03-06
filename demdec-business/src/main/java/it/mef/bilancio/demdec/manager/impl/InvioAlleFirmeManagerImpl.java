package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiBOId;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.IterFirmaDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBO;
import it.almavivaitalia.bilancio.commons.dao.TabServDao;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.bilancio.commons.manager.UtenteManager;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.manager.exception.ObjectNotFoundException;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Esito_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoConversione_type;
import it.mef.bilancio.demdec.dao.DocumentiDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.dao.InvioAlleFirmeDao;
import it.mef.bilancio.demdec.dao.IterFirmaDecretoDao;
import it.mef.bilancio.demdec.dao.SottoFascicoliRedDao;
import it.mef.bilancio.demdec.manager.DocumentiManager;
import it.mef.bilancio.demdec.manager.InvioAlleFirmeManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.InterfacciaOperazioniDocumentaliClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.RequestOpeDocuClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseOpeDocuClient;
import it.mef.bilancio.demdec.servizi.docconverter.DocConverterServiceServiceStub;
import it.mef.bilancio.demdec.servizi.docconverter.DocConverterServiceServiceStub.BLOB;
import it.mef.bilancio.demdec.servizi.pkbox.PKBoxParameter;
import it.mef.bilancio.demdec.servizi.pkbox.SignDocument;
import it.mef.bilancio.demdec.servizi.pkbox.SignerParameter;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.DocumentiViewTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;
import it.mef.bilancio.demdec.utils.Constants;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axiom.attachments.ByteArrayDataSource;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class InvioAlleFirmeManagerImpl extends AbstractDemManagerImpl implements InvioAlleFirmeManager {
	
	@Autowired
	private FascicoloDao fascicoloDao;
	
	@Autowired
	private SottoFascicoliRedDao sottoFascicoliRedDao;
	
	@Autowired
	private DocumentiDao documentiDao;
	
	@Autowired
	private IterFirmaDecretoDao iterFirmaDecretoDao;
	
	@Autowired
	private InvioAlleFirmeDao invioAlleFirmeDao;

	@Autowired
	private TabServDao tabServDao;
	
	@Autowired
	private DocumentiManager  documentiManager;
	
	@Autowired
	private CronologicoManager cronologicoManager;
	
	@Autowired 
	private UtenteManager utenteManager;
	
    @Override
	public DocumentContentTO toPdfA(String nomeFile, byte[] file)  throws Throwable{
    	ParametriInput paramInp= leggiParametriInputDocConverter();
    	
    	RequestOpeDocuClient requestOpeDocuClient = new RequestOpeDocuClient(paramInp);
    	
    	requestOpeDocuClient.setTipoOperazioneDocumento(TipoConversione_type.PDF1B);
    	DocumentContentTO inTO = new DocumentContentTO();
    	inTO.setContent(file);
    	inTO.setFileName(nomeFile);
    	requestOpeDocuClient.setInputTO(inTO);
    	InterfacciaOperazioniDocumentaliClient client = new InterfacciaOperazioniDocumentaliClient();
    	
    	ResponseOpeDocuClient resp = client.convertiDocumento(requestOpeDocuClient);
    	
    	if (!resp.getEsitoTo().getCodice().equalsIgnoreCase(Esito_type._OK)){
    		throw new ObjectNotFoundException(resp.getEsitoTo(), 10);
    	}
    	if (getPropertyFromTabServ(Constants.SCRIVI_FILE).equalsIgnoreCase("1")){
        	FileOutputStream fo = new FileOutputStream("/appoggio/PdfAConADLib.pdf");
        	fo.write(((DocumentContentTO)resp.getOutputTO()).getContent());
        	fo.flush();
        	fo.close();
    	}
    	
    	return (DocumentContentTO)resp.getOutputTO();
    }
    
    @Override
	public DocumentContentTO toPdfA( byte[] file)  throws Throwable{
    	/* 	it.consip.rpp.web.webservices.ParametriInput pi = new it.consip.rpp.web.webservices.ParametriInput();
    	  pi.setUrlWS(utilityManager.getPropertyByKey(IPropertyKeys.WS_ADOBE_ACCESS_URL));
    	  pi.setUserWS(utilityManager.getPropertyByKey(IPropertyKeys.WS_ADOBE_USER));
    	  pi.setPasswdWS(utilityManager.getPropertyByKey(IPropertyKeys.WS_ADOBE_PSW));
    	  pi.setTimeOutWS(Integer.parseInt(utilityManager.getPropertyByKey(IPropertyKeys.WS_ADOBE_TIMEOUT))*1000); */
    	
    	ParametriInput paramInp= leggiParametriInputDocConverterAdobe();
    	
    	DocConverterServiceServiceStub stub = new DocConverterServiceServiceStub(paramInp.getUrlWS());
    	DocConverterServiceServiceStub.ToPDFA toPdfa = new DocConverterServiceServiceStub.ToPDFA();
    	
    	HttpTransportProperties.Authenticator basicAuthentication = new HttpTransportProperties.Authenticator();
    	basicAuthentication.setPreemptiveAuthentication(false);
    	basicAuthentication.setUsername(paramInp.getUtenteWS());
    	basicAuthentication.setPassword(paramInp.getPasswdWS());
    	
    	stub._getServiceClient().getOptions().setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);
    	stub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuthentication);
    	stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(paramInp.getTimeOutWS());
    	
    	BLOB blob = new BLOB();
    	DataHandler dataHandler = new DataHandler(new ByteArrayDataSource(file));
    	blob.setBinaryData(dataHandler);
    	
    	toPdfa.setInDoc(blob);
    	
    	DocConverterServiceServiceStub.ToPDFAResponse resp = stub.toPDFA(toPdfa);
    	InputStream io = resp.getResult().getPDFADocument().getBinaryData().getInputStream();
    	file = IOUtils.toByteArray(io);

    	if (getPropertyFromTabServ(Constants.SCRIVI_FILE).equalsIgnoreCase("1")){
        	FileOutputStream fo = new FileOutputStream("/appoggio/PdfAConAdobe.pdf");
        	fo.write(file);
        	fo.flush();
        	fo.close();
        	
        	FileOutputStream fo1 = new FileOutputStream("/appoggio/Conversion.log");
        	fo1.write(IOUtils.toByteArray(resp.getResult().getConversionLog().getBinaryData().getInputStream()));
        	fo1.flush();
        	fo1.close();
        	
        	FileOutputStream fo2 = new FileOutputStream("/appoggio/Job.log");
        	fo2.write(IOUtils.toByteArray(resp.getResult().getJobLog().getBinaryData().getInputStream()));
        	fo2.flush();
        	fo2.close();
    	}
    	
    	DocumentContentTO dcTO=new DocumentContentTO();
    	dcTO.setContent(file);
    	dcTO.setFirmato(false);
    	dcTO.setHash(null);
    	dcTO.setLength(null);
    	dcTO.setTipoCompressione(null);
    	return dcTO;
    }
	/**
	 * 1 - Viene chiamato il getSignerByOAMVariables(httpServletRequest, httpServletResponse) che imposta nell'oggetto signerParam 
	 * 		i valori trovati nella request header (tali valori sono impostati da OAM).
	 * 
	 * 2 - Viene chiamato il leggiParametriInputPkbox() che restituisce un obj di tipo PKBoxParameter con i parametri
	 * 		per la connessione al server pkbox impostati (presi dalla tabella D_TAB_SERV).
	 * 
	 * 3 - Vengono settate le propriet� dell'ojb signerParam.
	 * 
	 * 4 - Viene chiamato il metodo remoteInvisibleSign(signerParam) che � il metodo per la firma tecnica.
	 * 
	 * NB: la firma tecnica non � un tipo di firma legato ad un utente utilizzatore del software DEMDEC viene infatti settato
	 * 		all'obj signerParam il tokenPin e l'alias di un utente di sistema chimato "FIRMA_TECNICA" presente nella tabella D_J_UTENTE.
	 */
    @Override
	public DocumentContentTO firmaTecnica(DocumentiViewTO documentiViewTO, Utente utenteInSessione, ByteArrayInputStream bais, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Integer maxTranSize) throws Throwable {

		//creo i due oggetti per la firma del documento
		SignerParameter signerParam = SignDocument.getSignerByOAMVariables(httpServletRequest, httpServletResponse);
		
		PKBoxParameter pkBoxParam = leggiParametriInputPkbox();
		
		/* file da firmare */
		byte[] arrayBytesDocumento = IOUtils.toByteArray(bais);
		signerParam.setFileToBeSigned(arrayBytesDocumento);
		
		/* tag se previsto */
		signerParam.setTag(Constants.TAG_FIRMA_TEC1);
		/*
		 * Setto il tokenPin e l'alias del signerParam presi dall'utente di sistema "FIRMA_TECNICA"   
		 */
		UtenteTO uto = utenteManager.loadByCodiUtente(searchPropertyValueFromTabServ(Constants.ID_FIRMA_TECNICA));
		signerParam.setTokenPin(utenteManager.findDeencryptedPinbyId(uto.getId()));
		signerParam.getPkBoxParameter().setPkBoxHandler(pkBoxParam.getPkBoxHandler());
		/* es: /SECURE_PIN/securepin-col-sogei.crt */
		signerParam.getPkBoxParameter().setSecurePinFilePath(pkBoxParam.getSecurePinFilePath());
		
		signerParam.getPkBoxParameter().setProvider(pkBoxParam.getProvider());
		signerParam.setAlias(uto.getCodiCodiceFisFirma());
		
		signerParam = SignDocument.remoteInvisibleSign(signerParam);
//		signerParam.setReturnCode(0);
//		signerParam.setSignedFile(arrayBytesDocumento);
		
		DocumentContentTO dcTO = null;
		if (signerParam.getReturnCode() != 0) {
			String errore = signerParam.getDecodedErrorMessage();
			throw new ObjectNotFoundException(errore, Constants.ERROR_WS_FIRMA_DOCUMENT);
		}
    	if (getPropertyFromTabServ(Constants.SCRIVI_FILE).equalsIgnoreCase("1")){
    		FileOutputStream fo = new FileOutputStream("/appoggio/FirmaTecnica.pdf");
        	fo.write(signerParam.getSignedFile());
        	fo.flush();
        	fo.close();
    	}

		// richiamo di nuovo il servizio di download del documento
		ResponseDEMBILClient res = documentiManager.wsDownloadDocumentoFascicoloAttoDecreto(documentiViewTO.getCodiGuidFascicolo(), documentiViewTO.getCodiGuidDocumento());
		if (!res.getEsitoTo().getCodice().equalsIgnoreCase("OK")) {
			String errore = res.getEsitoTo().getDescrizione();
			throw new Exception(errore);
		}

		dcTO = (DocumentContentTO) res.getOutputTO();
		
		dcTO.setContent(signerParam.getSignedFile());

		/** -update content sul documentale **/
		ResponseDEMBILClient responseUpdateContent = documentiManager.wsUpdateDocument(dcTO, documentiViewTO.getCodiGuidFascicolo(), documentiViewTO.getCodiGuidDocumento());
		if (!responseUpdateContent.getEsitoTo().getCodice()
				.equalsIgnoreCase(DEMBILConstants.ESITO_OK)) {
			String errore = responseUpdateContent.getEsitoTo()
					.getDescrizione();
			throw new Exception(errore);
		}

		/**
		 * -cambio stato fascicolo atto decreto, lo setto a
		 * "in elaborazione"
		 **/
		ResponseDEMBILClient responseChangeStatoFascicolo = wsChangeStatoFascicoloAttoDecreto(documentiViewTO.getCodiGuidFascicolo(), Constants.STATO_FAD_IN_ELABORAZIONE);
		if (!responseChangeStatoFascicolo.getEsitoTo().getCodice()
				.equalsIgnoreCase(DEMBILConstants.ESITO_OK)) {
			String errore = responseChangeStatoFascicolo.getEsitoTo()
					.getDescrizione();
			throw new Exception(errore);
		}
		return dcTO;

	}
    
    

	@Override
	public IterFirmaDecretoTO inserisciIterDecreto(
			DocumentiViewTO documentiViewTO, Utente utenteInSessione)
			throws Throwable {
		/**
		 * -aggiornarmento tabella d_documenti e inserimento dei
		 * record dei firmatari su d_iter_decreto_firma
		 **/
		aggiornaStatiDocumenti(documentiViewTO.getCodiGuidFascicolo(), Long.valueOf(documentiViewTO.getNumeIdDocumento()), documentiViewTO.getNumeIdFascicolo(), utenteInSessione.getUtente().getCodiUtente(), documentiViewTO.getRowCreatedForm());
		IterFirmaDecretoTO ifdTo = insertIterFirmaDecreto(String.valueOf(documentiViewTO.getNumeIdFascicolo()), documentiViewTO.getRowCreatedUser(), documentiViewTO.getRowCreatedForm());
		return ifdTo;
	}

	
	private void aggiornaStatiDocumenti(String guidFascicolo, Long numeIdDocumento, Long numeIdFascicolo, String utente, String funzione) throws Throwable{
		FascicoliBO boFascOld=fascicoloDao.loadById(Long.valueOf(numeIdFascicolo));
		FascicoliBO boFascNew=fascicoloDao.loadById(Long.valueOf(numeIdFascicolo));
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
									CroTransTO.CRO_TRANS_INVIO_ALLE_FIRME,
									boFascNew.getRowUpdatedForm()==null?boFascNew.getRowCreatedForm():boFascNew.getRowUpdatedForm(), 
									boFascNew.getRowUpdatedUser()==null?boFascNew.getRowCreatedUser():boFascNew.getRowUpdatedUser());
		
		DocumentiBO boDocOld=documentiDao.loadById(DocumentiBO.class, new DocumentiBOId(numeIdFascicolo,numeIdDocumento));
		DocumentiBO boDocNew=documentiDao.loadById(DocumentiBO.class, new DocumentiBOId(numeIdFascicolo,numeIdDocumento));
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
									CroTransTO.CRO_TRANS_INVIO_ALLE_FIRME,
									boDocNew.getRowUpdatedForm()==null?boDocNew.getRowCreatedForm():boDocNew.getRowUpdatedForm(), 
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
										CroTransTO.CRO_TRANS_INVIO_ALLE_FIRME,
										boNew.getRowUpdatedForm()==null?boNew.getRowCreatedForm():boNew.getRowUpdatedForm(), 
										boNew.getRowUpdatedUser()==null?boNew.getRowCreatedUser():boNew.getRowUpdatedUser());
		}
		
		//aggiorniamo tutti i record che hanno questo numeIdFascicolo
//		for (SottoFascicoliRedBO sottoFascicoliRedBO : boSottoFascList) {
//			sottoFascicoliRedBO.setRowUpdatedDttm(Calendar.getInstance().getTime());
//			sottoFascicoliRedBO.setRowUpdatedUser(utente);
//			sottoFascicoliRedBO.setRowUpdatedForm(funzione);
//			sottoFascicoliRedBO.setStatStato(1);
//			sottoFascicoliRedDao.update(sottoFascicoliRedBO);
//		}

	}

	public DocumentiTO loadDocumentoByGuidFascicoloETipo(String guidFascicolo, String tipoDocumento) throws Throwable {
		return getDozerDriver().map(invioAlleFirmeDao.loadDocumentoByGuidFascicoloETipo(guidFascicolo, tipoDocumento), DocumentiTO.class, "Documenti");
	}

	@Override
	public ResponseDEMBILClient wsChangeStatoFascicoloAttoDecreto(String guidFascicolo, String stato) throws Throwable {
		ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		requestDEMBILClient.setIdFascicolo(guidFascicolo);
		requestDEMBILClient.setStatoFascicoloAttoDecreto(stato);

		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp = client.changeStatoFascicoloAttoDecreto(requestDEMBILClient);

		return resp;
	}

	
	private IterFirmaDecretoTO insertIterFirmaDecreto(String idFascicolo, String utente, String funzione) throws Throwable {
		 Integer res=invioAlleFirmeDao.insertIterFirmaDecreto( idFascicolo,  utente,  funzione);
		 if(res>0){
			 IterFirmaDecretoBO bo=iterFirmaDecretoDao.getCurrentIFDByIdFascicolo(Long.valueOf(idFascicolo));
			 
			// Richiamo cronologico
				cronologicoManager.salvaCronologico(null,//old
													bo,//new
											null,
											null,
											CroTransTO.CRO_TRANS_INVIO_ALLE_FIRME,
											bo.getRowUpdatedForm()==null?bo.getRowCreatedForm():bo.getRowUpdatedForm(), 
											bo.getRowUpdatedUser()==null?bo.getRowCreatedUser():bo.getRowUpdatedUser());
			 
			 return getDozerDriver().map(bo, IterFirmaDecretoTO.class, "IterFirmaDecreto");
		 }else{
			 return null;
		 }
		
	}

	@Override
	public String getPropertyFromTabServ(String codiParametro) throws Throwable {
		return tabServDao.searchPropertyValueFromTabServ(codiParametro);

	}

	@Override
	public String getEsitoOperazione(String guidFascicolo, String guidDocumento) throws Throwable {
		ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		requestDEMBILClient.setIdFascicolo(guidFascicolo);
		requestDEMBILClient.setIdDocumento(guidDocumento);

		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		String resp = client.getEsitoOperazione(requestDEMBILClient);

		return resp;
	}

}
