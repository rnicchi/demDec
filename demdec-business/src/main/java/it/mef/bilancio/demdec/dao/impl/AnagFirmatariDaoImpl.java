package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.AnagFirmatariBO;
import it.mef.bilancio.demdec.dao.AnagFirmatariDao;
import it.mef.bilancio.demdec.utils.Constants;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AnagFirmatariDaoImpl extends AbstractDemDaoImpl<AnagFirmatariBO> implements
		AnagFirmatariDao {

	@SuppressWarnings("unchecked")
	public List<AnagFirmatariBO> loadFirmatari() throws Throwable {
		String q="FROM AnagFirmatariBO";
		Query query = createQuery(q);
		return (List<AnagFirmatariBO>) query.list();
	}

	@Override
	public AnagFirmatariBO loadById(String id)  throws Throwable {

		Criteria cri = getSession().createCriteria(AnagFirmatariBO.class);
		cri.add(Restrictions.eq("id", id));

		return (AnagFirmatariBO) cri.uniqueResult();
	}
	
	@Override
	public List<AnagFirmatariBO> loadDestinatariMail(Integer flag)  throws Throwable {

		Criteria cri = getSession().createCriteria(AnagFirmatariBO.class);
		cri.add(Restrictions.eq("flagPec01", flag));
		cri.add(Restrictions.ne("id", "DIR"));
		
		cri.addOrder(Order.desc("id"));

		return (List<AnagFirmatariBO>) cri.list();
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<AnagFirmatariBO> loadDeleganti(String tipoFirma) throws Throwable {
		
		Criteria cri = getSession().createCriteria(AnagFirmatariBO.class);
		cri.add(Restrictions.eq("codiTipoFirma", tipoFirma));
		return (List<AnagFirmatariBO>)  cri.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnagFirmatariBO> loadDelegati(String tipoFirma) throws Throwable {
		Criteria cri = getSession().createCriteria(AnagFirmatariBO.class);
		
		if(tipoFirma.equalsIgnoreCase(Constants.BOLLINATURA)){//Se ho selezionato bollinatura devo cercare per sigla
			cri.add(Restrictions.eq("codiTipoFirma", Constants.SIGLA));
		}else {
			cri.add(Restrictions.eq("codiTipoFirma", tipoFirma));
		}
		return (List<AnagFirmatariBO>)  cri.list();
	}
	
}
