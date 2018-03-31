package it.almavivaitalia.bilancio.commons.dao;

import java.util.List;

import org.hibernate.Query;

import it.almavivaitalia.bilancio.commons.bo.ActionBO;
import it.almavivaitalia.bilancio.commons.bo.ProfiloBO;


public interface ActionDao extends AbstractCommonDao{

	public ActionBO saveOrUpdate(ActionBO o);
	
	public ActionBO loadByPrimaryKey(Long id);
	
	public ActionBO loadByCodiAction(String codi);
	
	List<String> loadByProfilo(Integer sequIdProfilo);
	
//	public Integer newId();
	

	public List<ActionBO> findAll(); 

	
}
