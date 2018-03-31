package it.mef.bilancio.demdec.manager;

import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.manager.AbstractManager;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.DocumentiViewTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface InvioAlleFirmeManager extends AbstractManager{
	
//	void aggiornaStatiDocumenti(String guidFascicolo, Long numeIdDocumento, Long numeIdFascicolo, String utente, String funzione) throws Throwable;
	DocumentContentTO toPdfA(String nomeFile, byte[] file)  throws Throwable;
	DocumentContentTO toPdfA(byte[] file)  throws Throwable;
	DocumentiTO loadDocumentoByGuidFascicoloETipo(String guidFascicolo, String tipoDocumento) throws Throwable;
	DocumentContentTO firmaTecnica( DocumentiViewTO documentiViewTO, Utente utenteInSessione, ByteArrayInputStream bais, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Integer maxTranSize) throws Throwable;
	IterFirmaDecretoTO inserisciIterDecreto( DocumentiViewTO documentiViewTO, Utente utenteInSessione) throws Throwable;
	ResponseDEMBILClient wsChangeStatoFascicoloAttoDecreto(String guidFascicolo, String stato) throws Throwable;
//	IterFirmaDecretoTO insertIterFirmaDecreto (String idFascicolo, String utente, String funzione) throws Throwable;
	String getPropertyFromTabServ(String codiParametro) throws Throwable;
	String getEsitoOperazione(String guidFascicolo, String guidDocumento)throws Throwable;
	
}
