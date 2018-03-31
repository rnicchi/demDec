package it.almavivaitalia.bilancio.commons.dao.impl;

import java.util.List;

import org.hibernate.Query;

import it.almavivaitalia.bilancio.commons.bo.ActionBO;
import it.almavivaitalia.bilancio.commons.bo.ProfiloBO;
import it.almavivaitalia.bilancio.commons.dao.ActionDao;


public class ActionDaoImpl extends AbstractCommonDaoImpl implements ActionDao{

	public ActionBO saveOrUpdate(ActionBO o) {
		getHibernateTemplate().saveOrUpdate(o);
		return o;
	}

	
	public ActionBO loadByPrimaryKey(Long id) {
		return (ActionBO)getHibernateTemplate().load(ActionBO.class, id);
	}

	public ActionBO loadByCodiAction(String codi) {
		return (ActionBO)findUniqueByNamedParam("select o from ActionBO o where o.codiAction=:codi","codi",codi);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> loadByProfilo(Integer sequIdProfilo) {
		return (List<String>)getNamedQuery("Action.getByProfilo").setInteger("sequIdProfilo", sequIdProfilo).list();
	}

	//@Override
	public List<ActionBO> findAll() {
		
		Query query=createQuery("from ActionBO order by id");
		
		List<ActionBO> list=query.list(); 
		return list;
	}

}
