package it.almavivaitalia.bilancio.commons.dao;

import java.math.BigDecimal;
import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;

public interface UtenteProfiloDao extends AbstractCommonDao{
	
	public UtenteProfiloBO saveOrUpdate(UtenteProfiloBO o);
	List<UtenteProfiloBO> loadAll();
	List<UtenteProfiloBO> loadBySequIdUtente(Integer sequIdUtente) throws Throwable;
	List<UtenteProfiloBO> loadBySequIdProfilo(Integer sequIdProfilo) throws Throwable;
	List<UtenteProfiloBO> loadDeleghe() throws Throwable;
	List<UtenteProfiloBO> loadDelegheByUtenteId(int utenteId) throws Throwable;
	List<UtenteProfiloBO> findByUtenteProfiloFlagDelega(int utenteId, int profiloId, int flagDelega01) throws Throwable;
	List<UtenteProfiloBO> findByProfiloUfficioFlagDelega(BigDecimal idProfilo, String idUfficio, int flagDelega01) throws Throwable;
}
