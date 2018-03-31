package it.mef.bilancio.demdec.manager.impl;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bilancio.commons.manager.UtenteManager;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.manager.exception.ObjectNotFoundException;
import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.mef.bilancio.demdec.manager.TestFirmeManager;
import it.mef.bilancio.demdec.servizi.pkbox.PKBoxParameter;
import it.mef.bilancio.demdec.servizi.pkbox.SignDocument;
import it.mef.bilancio.demdec.servizi.pkbox.SignerParameter;
import it.mef.bilancio.demdec.utils.Constants;

public class TestFirmeManagerImpl extends AbstractDemManagerImpl implements TestFirmeManager{
	
	@Autowired
	UtenteManager utenteManager;

	
	
	@Override
	public SignerParameter firma(String tkPin, Utente utenteInSessione, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Throwable {
		
		PKBoxParameter pkBoxParam = leggiParametriInputPkbox();
		
		/* recupero dalla sessione le variabili relative all'utente (alias, name, pin) */
		TraceLogger.infoLog("TEST FIRME: RECUPERO PARAMETRI OAM",TestFirmeManager.class);
		SignerParameter signerParam = SignDocument.getSignerByOAMVariables(httpServletRequest, httpServletResponse);
		if(signerParam == null){
			throw new ObjectNotFoundException("Eccezione nel recuperare dalla sessione le variabili relative all'utente", Constants.ERROR_WS_FIRMA_DOCUMENT);
		}
		TraceLogger.infoLog("TEST FIRME: FINE RECUPERO PARAMETRI OAM",TestFirmeManager.class);
	   
		TraceLogger.infoLog("TEST FIRME: POPOLO SIGNER PARAM",TestFirmeManager.class);
		popolaSignerParam(signerParam, pkBoxParam, tkPin, Constants.METODO_FIRMA_CON_PIN_TAG_VISIBILE);
		TraceLogger.infoLog("TEST FIRME: FINE SIGNER PARAM",TestFirmeManager.class);
		
		TraceLogger.infoLog("TEST FIRME: GENERAZIONE OTP",TestFirmeManager.class);
		/* Genero l'OTP con l'oggetto signerParam */
		signerParam = SignDocument.generateOTP(signerParam);
		if(signerParam.getReturnCode() != null && signerParam.getReturnCode() != 0 ){
			throw new ObjectNotFoundException(signerParam.getDecodedErrorMessage(), Constants.ERROR_WS_FIRMA_DOCUMENT);
		}
		TraceLogger.infoLog("TEST FIRME: FINE GENERAZIONE OTP",TestFirmeManager.class);
		
		TraceLogger.infoLog("TEST FIRME: TRANSAZIONE",TestFirmeManager.class);
		/* start transaction per stabilire il numero di firme massime */
		signerParam = SignDocument.startTrans(signerParam, 1);
		if(signerParam.getReturnCode() != null && signerParam.getReturnCode() != 0 ){
			throw new ObjectNotFoundException(signerParam.getDecodedErrorMessage(), Constants.ERROR_WS_FIRMA_DOCUMENT);
		}
		TraceLogger.infoLog("TEST FIRME: FINE TRANSAZIONE",TestFirmeManager.class);
		
		TraceLogger.infoLog("TEST FIRME: FIRMA ",TestFirmeManager.class);
		signerParam = SignDocument.digestVisibleSign(signerParam);
		if(signerParam.getReturnCode() != null && signerParam.getReturnCode() != 0){
			throw new ObjectNotFoundException(signerParam.getDecodedErrorMessage(), Constants.ERROR_WS_FIRMA_DOCUMENT);
		}
		TraceLogger.infoLog("TEST FIRME: FINE FIRMA",TestFirmeManager.class);
		return signerParam;
	}
	
	
	
	
	
	/*
	 * Vengono settati all'oggetto SignerParameter: 
	 * - i parametri di connessione al server PKBOX 
	 * - il file che deve essere firmato
	 * - il tag dove deve essere apposta la firma (visibile o invisibile)
	 * - il pin digitato dall'utente
	 * in base al tipo di metodoFirma che deve essere eseguito
	 */
	private void popolaSignerParam(SignerParameter signerParam, PKBoxParameter pkBoxParam, String tkPin, Integer metodoFirma) throws Throwable{
		
		FileInputStream fileTestFirme = new FileInputStream(searchPropertyValueFromTabServ(Constants.TAB_SERV_FILEPATH_TEST_FIRME));
		signerParam.getPkBoxParameter().setPkBoxHandler(pkBoxParam.getPkBoxHandler());
		signerParam.getPkBoxParameter().setSecurePinFilePath(pkBoxParam.getSecurePinFilePath());
		signerParam.getPkBoxParameter().setOtpPropertiesFilePath(pkBoxParam.getOtpPropertiesFilePath());
		signerParam.getPkBoxParameter().setFirmaBaseKey(pkBoxParam.getFirmaBaseKey());
		signerParam.getPkBoxParameter().setFirmaBaseKeyPin(pkBoxParam.getFirmaBaseKeyPin());
		signerParam.getPkBoxParameter().setProvider(pkBoxParam.getProvider());
		signerParam.setFileToBeSigned(IOUtils.toByteArray(fileTestFirme));
		signerParam.setTokenPin(tkPin);
		
		switch (metodoFirma) {
		case 0:
			signerParam.setTag(Constants.TAG_TEST_VISIBILE);
			signerParam.setSignLayout("<Text>%cn% \r\n FIRMATO DIGITALMENTE </Text><FontStyle>1</FontStyle><TextAlign>1</TextAlign>");
			break;
		case 1:
			signerParam.setAlias(signerParam.getAlias().substring(0, 16).concat("_AUTO"));
			signerParam.setTag(Constants.TAG_TEST_INVISIBILE);
			break;
		case 2:
			signerParam.setAlias(signerParam.getAlias().substring(0, 16).concat("_AUTO"));
			signerParam.setTag(Constants.TAG_TEST_VISIBILE);
			signerParam.setSignLayout("<Text>Bollinato dal Ragioniere Generale dello Stato </Text><FontStyle>1</FontStyle><TextAlign>1</TextAlign>");
			break;
		default:
			break;
		}
	}



	@Override
	public SignerParameter sigla(String tkPin, Utente utenteInSessione, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Throwable {
		
		PKBoxParameter pkBoxParam = leggiParametriInputPkbox();
		
		/* recupero dalla sessione le variabili relative all'utente (alias, name, pin) */
		SignerParameter signerParam = SignDocument.getSignerByOAMVariables(httpServletRequest, httpServletResponse);
		if(signerParam == null){
			throw new ObjectNotFoundException("Eccezione nel recuperare dalla sessione le variabili relative all'utente", Constants.ERROR_WS_FIRMA_DOCUMENT);
		}
		tkPin = utenteManager.findDeencryptedPinbyId(utenteInSessione.getUtente().getId());
		popolaSignerParam(signerParam, pkBoxParam, tkPin, Constants.METODO_FIRMA_AUTOMATICA_TAG_INVISIBILE);
		
		signerParam = SignDocument.remoteInvisibleSign(signerParam);
		
		if(signerParam.getReturnCode() != null && signerParam.getReturnCode() != 0){
			throw new ObjectNotFoundException(signerParam.getDecodedErrorMessage(), Constants.ERROR_WS_FIRMA_DOCUMENT);
		}
		return signerParam;
	}





	@Override
	public SignerParameter bollina(String tkPin, Utente utenteInSessione, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Throwable {
		
		PKBoxParameter pkBoxParam = leggiParametriInputPkbox();
		
		/* recupero dalla sessione le variabili relative all'utente (alias, name, pin) */
		SignerParameter signerParam = SignDocument.getSignerByOAMVariables(httpServletRequest, httpServletResponse);
		if(signerParam == null){
			throw new ObjectNotFoundException("Eccezione nel recuperare dalla sessione le variabili relative all'utente", Constants.ERROR_WS_FIRMA_DOCUMENT);
		}
		tkPin = utenteManager.findDeencryptedPinbyId(utenteInSessione.getUtente().getId());
		popolaSignerParam(signerParam, pkBoxParam, tkPin, Constants.METODO_FIRMA_AUTOMATICA_TAG_VISIBILE);
		
		signerParam = SignDocument.remoteInvisibleSign(signerParam);
		
		if(signerParam.getReturnCode() != null && signerParam.getReturnCode() != 0){
			throw new ObjectNotFoundException(signerParam.getDecodedErrorMessage(), Constants.ERROR_WS_FIRMA_DOCUMENT);
		}
		return signerParam;
	}

}
