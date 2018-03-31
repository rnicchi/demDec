package it.mef.bilancio.demdec.manager;

import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.DocumentiTOId;
import it.mef.bilancio.demdec.to.DocumentiViewTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DocumentiManager extends AbstractDemManager {
	
	public List<DocumentiViewTO> listADToSignByLoggedUser(Utente utenteInSessione) throws Throwable;
	public List<DocumentiViewTO> listADToSignOrVerifyByLoggedUser(Utente utenteInSessione, String signOrVerify) throws Throwable;
	public ResponseDEMBILClient wsDownloadDocumentoFascicoloAttoDecreto(String idFascicolo, String idDocumento) throws Throwable;
	public ResponseDEMBILClient wsDownloadDocumentoFascicoloAllegatoIGB(String idFascicolo, String idDocumento) throws Throwable;
	public ResponseDEMBILClient wsDownloadDocumentoFascicoloSIPATRAttoDecreto(String idFascicolo,String idFascicoloSIPATR, String idDocumento) throws Throwable;
	public IterFirmaDecretoTO firma(DocumentiViewTO documentiViewTO, String pin, Utente utenteInSessione,  HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Integer maxTranSize) throws Throwable;
	public DocumentContentTO generaAttoDecretoConFirma(String guidFascicolo, String guidDocumento, Long numeIdFascicolo, Utente utenteInSessione) throws Throwable ;
	public ResponseDEMBILClient wsUpdateDocument(DocumentContentTO dcTO, String guidFascicolo, String guidDocumento) throws Throwable;
	public IterFirmaDecretoTO verifica(DocumentiViewTO documentiViewTO, Utente utenteInSessione) throws Throwable;
	public IterFirmaDecretoTO sigla(DocumentiViewTO documentiViewTO, Utente utenteInSessione, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Integer maxTranSize, Short croTransTo) throws Throwable;
	public DocumentiTO getDocumentByIdDocumento(DocumentiTOId idDocumento) throws Throwable;
	public List<DocumentiViewTO> listSignedADByLoggedUser(Utente utenteInSessione, String signOrVerify) throws Throwable;
	public ResponseDEMBILClient wsGetDocumentoFascicoloAttoDecreto(String codiGuidFascicolo, String string) throws Throwable;
}
