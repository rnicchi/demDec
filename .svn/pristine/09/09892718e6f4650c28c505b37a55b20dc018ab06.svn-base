package it.almavivaitalia.bilancio.commons.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import it.almavivaitalia.bilancio.commons.bo.AnagFirmatariBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;
import it.almavivaitalia.bilancio.commons.dao.UtenteProfiloDao;
import it.almavivaitalia.bsn.sh.utils.StringUtil;

public class UtenteProfiloDaoImpl extends AbstractCommonDaoImpl implements UtenteProfiloDao{
	
	@Override
	public UtenteProfiloBO saveOrUpdate(UtenteProfiloBO o) {
		getHibernateTemplate().saveOrUpdate(o);
		return o;
	}

	@Override
	public List<UtenteProfiloBO> loadAll() {
		return getHibernateTemplate().loadAll(UtenteProfiloBO.class);
	}

	@Override
	public List<UtenteProfiloBO> loadBySequIdUtente(Integer sequIdUtente) throws Throwable  {
		Query query = createQuery("from UtenteProfiloBO where id.sequIdUtente=:sequIdUtente");
		query.setInteger("sequIdUtente", sequIdUtente);
		
		return query.list();
	}
	
	@Override
	public List<UtenteProfiloBO> loadBySequIdProfilo(Integer sequIdProfilo) throws Throwable  {
		Query query = createQuery("from UtenteProfiloBO where id.sequIdProfilo=:sequIdProfilo");
		query.setInteger("sequIdProfilo", sequIdProfilo);
		
		return query.list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<UtenteProfiloBO> loadDeleghe() throws Throwable {
		Criteria cri = getSession().createCriteria(UtenteProfiloBO.class);
		cri.add(Restrictions.eq("flagDelega01", 1));
		return (List<UtenteProfiloBO>)cri.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UtenteProfiloBO> loadDelegheByUtenteId(int utenteId) throws Throwable {
		
		Criteria cri = getSession().createCriteria(UtenteProfiloBO.class);
		cri.add(Restrictions.eq("id.sequIdUtente", new BigDecimal(utenteId)));
		cri.add(Restrictions.eq("flagDelega01", 1));
		return (List<UtenteProfiloBO>)cri.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UtenteProfiloBO> findByUtenteProfiloFlagDelega(int utenteId, int profiloId, int flagDelega01) throws Throwable {
		
		Criteria cri = getSession().createCriteria(UtenteProfiloBO.class);
		cri.add(Restrictions.eq("id.sequIdUtente", new BigDecimal(utenteId)));
		cri.add(Restrictions.eq("id.sequIdProfilo", new BigDecimal(profiloId)));
		cri.add(Restrictions.eq("flagDelega01", flagDelega01));
		return (List<UtenteProfiloBO>)cri.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UtenteProfiloBO> findByProfiloUfficioFlagDelega(BigDecimal idProfilo, String idUfficio, int flagDelega01) throws Throwable {
		
		Criteria cri = getSession().createCriteria(UtenteProfiloBO.class);
 		cri.add(Restrictions.eq("id.sequIdProfilo",idProfilo));
		if(!StringUtil.isEmpty(idUfficio)) {
			cri.add(Restrictions.eq("anagUffici.id", idUfficio));
		}
		cri.add(Restrictions.eq("flagDelega01", flagDelega01));
		return (List<UtenteProfiloBO>)cri.list();
	}
	
	
}
