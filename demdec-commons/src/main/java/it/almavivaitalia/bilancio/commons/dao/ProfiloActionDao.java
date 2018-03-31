package it.almavivaitalia.bilancio.commons.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.ProfiloActionBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;

public interface ProfiloActionDao extends AbstractCommonDao{
	
	public ProfiloActionBO saveOrUpdate(ProfiloActionBO o);
	List<ProfiloActionBO> loadAll();
	
	public void salvaAssoActionProfilo(String idActionAssociato, String codiProfilo);
	void delete(String codiProfilo) throws Throwable;

}
