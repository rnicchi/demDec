package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.EserciziDemBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;
import it.almavivaitalia.bilancio.commons.dao.UtenteDao;
import it.almavivaitalia.bilancio.commons.to.EmailUtenteTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;


public class UtenteDaoImpl extends UtenteParentDaoImpl implements UtenteDao{


	@Override
	public List<UtenteBO> loadAll() {
		return (List<UtenteBO>)getHibernateTemplate().loadAll(UtenteBO.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UtenteBO> loadAllOrdById() {
		Query query=createQuery("from UtenteBO order by id");
		
		List<UtenteBO> list=query.list(); 
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<UtenteBO> loadAllOrdByCodiUtente() {
		Query query=createQuery("from UtenteBO order by codiUtente");
		
		List<UtenteBO> list=query.list(); 
		return list;
	}
	

	@Override
	public UtenteBO loadByPrimaryKey(Long id) {
		
		int idBO = (int) (long) id;
		
		return (UtenteBO)getHibernateTemplate().load(UtenteBO.class, idBO);
	}

	@Override
	public UtenteBO saveOrUpdate(UtenteBO o) {
		getHibernateTemplate().saveOrUpdate(o);
		return o;
	}
	@Override
	public UtenteBO loadByCodiUtente(String codi)throws Throwable  {
		return (UtenteBO)findUniqueByNamedParam("select o from UtenteBO o where UPPER(o.codiUtente)=UPPER(:codi)", "codi",codi);
	}
	@Override
	public UtenteBO loadByCodiUtenteNsbf(String codi)throws Throwable  {
		return (UtenteBO)findUniqueByNamedParam("select o from UtenteBO o where UPPER(o.codiUtenteNsbf)=UPPER(:codi)", "codi",codi);
	}
	
	@Override
	public Short loadAnnoEse(String statTipoEse) throws Throwable {
		Query query=createQuery("select e from EserciziBO e where e.statTipoEse=:tipoEse");
		query.setString("tipoEse", statTipoEse);
		
		EserciziDemBO eseBO = (EserciziDemBO)query.uniqueResult();
		if (eseBO != null && eseBO.getId() != null)
		{
			return eseBO.getId();
		}
		else
		{
			return null;
		}
	}

	
	@Override
	public Integer newId() {
		
		List<UtenteBO> listaUtenteBO = loadAllOrdById();
		return (listaUtenteBO == null || listaUtenteBO.size() == 0 ? 0: listaUtenteBO.get(listaUtenteBO.size()-1).getId()) + 1;
	}

	@Override
	public void deleteProfili(UtenteBO utenteBo) throws Throwable {

		for (UtenteProfiloBO bo: utenteBo.getUtenteProfiloList()) 
				delete(bo);
		flush();	//necessario!!! in caso si debba inserire un altro oggetto
	}
	@Override
	public void insertProfili(UtenteBO utenteBo, List<UtenteProfiloBO> lista) throws Throwable {

		for (UtenteProfiloBO bo: lista)
			saveOrUpdate(bo);
	}

	@Override
	public void delete(String codiUtente) throws Throwable {

	//	UtenteBO utenteBo = loadByCodiUtente(codiUtente.toString());
		Long id = Long.parseLong(codiUtente);
		UtenteBO utenteBo = loadByPrimaryKey(id);
		
		
		for (UtenteProfiloBO bo: utenteBo.getUtenteProfiloList()) 
				delete(bo);
		flush();	//necessario!!! altrimenti la delete successiva tenta di eseguire una update su Utente-Profilo con id NULL
		delete(utenteBo);
	}
	
}
