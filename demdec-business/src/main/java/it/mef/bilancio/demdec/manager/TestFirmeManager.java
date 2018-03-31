package it.mef.bilancio.demdec.manager;

import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.mef.bilancio.demdec.servizi.pkbox.SignerParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TestFirmeManager extends AbstractDemManager{

	public SignerParameter firma(String tkPin, Utente utenteInSessione,  HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Throwable;
	public SignerParameter sigla(String tkPin, Utente utenteInSessione,  HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Throwable;
	public SignerParameter bollina(String tkPin, Utente utenteInSessione,  HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Throwable;
}
