package it.almavivaitalia.bilancio.commons.dao;


import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.ProfiloActionBO;
import it.almavivaitalia.bilancio.commons.bo.ProfiloBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;


public interface ProfiloDao extends AbstractCommonDao{

	public ProfiloBO saveOrUpdate(ProfiloBO o);
	
	public ProfiloBO loadByPrimaryKey(Long id);
	
	public ProfiloBO loadByPrimaryKeyInt(Long id);
	
	public ProfiloBO loadByCodiProfilo(String codi);
	
	public  List<ProfiloBO> findAll();
	
	public Integer newId();

	public List<ProfiloBO> loadAll();
	
	public List<ProfiloBO> loadAllOrdById();
	
	public List<ProfiloBO> loadAllOrdByDescrProf();
	
	
	//void deleteAction(ProfiloBO profiloBo) throws Throwable;
	void insertAction(ProfiloBO profiloBo, List<ProfiloActionBO> lista) throws Throwable;
	void delete(String codiProfilo) throws Throwable;

	public List<ProfiloBO> loadAllOrdByCodiProf()  throws Throwable;

	
}
