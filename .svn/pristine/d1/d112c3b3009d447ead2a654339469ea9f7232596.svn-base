package it.almavivaitalia.bilancio.commons.dao.impl;

import java.util.List;

import org.hibernate.Query;

import it.almavivaitalia.bilancio.commons.bo.ProfiloActionBO;
import it.almavivaitalia.bilancio.commons.bo.ProfiloBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;
import it.almavivaitalia.bilancio.commons.dao.ProfiloDao;



public class ProfiloDaoImpl extends AbstractCommonDaoImpl implements ProfiloDao{


	@Override
	public ProfiloBO loadByPrimaryKey(Long id) {
		return (ProfiloBO)getHibernateTemplate().load(ProfiloBO.class, id);
	}
	
	public ProfiloBO loadByPrimaryKeyInt(Long id) {
		
		int idBO = id.intValue();
		
		return (ProfiloBO)getHibernateTemplate().load(ProfiloBO.class, idBO);
	}

	@Override
	public ProfiloBO saveOrUpdate(ProfiloBO o) {
		try {
			getHibernateTemplate().saveOrUpdate(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return o;
	}

	public ProfiloBO loadByCodiProfilo(String codi) {
		return (ProfiloBO)findUniqueByNamedParam("select o from ProfiloBO o where o.codiProfilo=:codi", "codi", codi);
	}

	@Override
	public List<ProfiloBO> findAll() {
		
		Query query=createQuery("from ProfiloBO order by id");
		
		List<ProfiloBO> list=query.list(); 
		return list;
	}

	
	@Override
	public Integer newId() {
		
		List<ProfiloBO> listaProfiloBO = loadAllOrdById();
		return (listaProfiloBO == null || listaProfiloBO.size() == 0 ? 0: listaProfiloBO.get(listaProfiloBO.size()-1).getId()) + 1;
	}


	@Override
	public List<ProfiloBO> loadAll() {
		return (List<ProfiloBO>)getHibernateTemplate().loadAll(ProfiloBO.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProfiloBO> loadAllOrdById() {
		Query query=createQuery("from ProfiloBO order by id");
		
		List<ProfiloBO> list=query.list(); 
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProfiloBO> loadAllOrdByDescrProf() {
		Query query=createQuery("from ProfiloBO order by descProfilo");
		
		List<ProfiloBO> list=query.list(); 
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProfiloBO> loadAllOrdByCodiProf() {
		Query query=createQuery("from ProfiloBO order by cast(codiProfilo as integer)");
		
		List<ProfiloBO> list=query.list(); 
		return list;
	}
	
/*	@Override
	public void deleteAction(ProfiloBO profiloBo) throws Throwable {

		for (ProfiloActionBO bo: profiloBo.getProfiloActionList()) 
				delete(bo);
		flush();	//necessario!!! in caso si debba inserire un altro oggetto
	}*/
	@Override
	public void insertAction(ProfiloBO profiloBo, List<ProfiloActionBO> lista) throws Throwable {

		for (ProfiloActionBO bo: lista)
			saveOrUpdate(bo);
	}

	@Override
	public void delete(String idProfilo) throws Throwable {
		
		long id = Long.parseLong(idProfilo);

		ProfiloBO profiloBo = loadByPrimaryKeyInt(id);
		
		flush();	//necessario!!! altrimenti la delete successiva tenta di eseguire una update su Utente-Profilo con id NULL
		delete(profiloBo);
	}
}
