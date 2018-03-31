package it.almavivaitalia.bilancio.commons.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import it.almavivaitalia.bilancio.commons.bo.ProfiloActionBO;
import it.almavivaitalia.bilancio.commons.bo.ProfiloBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;
import it.almavivaitalia.bilancio.commons.dao.ProfiloActionDao;
import it.almavivaitalia.bilancio.commons.dao.UtenteProfiloDao;

public class ProfiloActionDaoImpl extends AbstractCommonDaoImpl implements ProfiloActionDao{
	
	@Override
	public ProfiloActionBO saveOrUpdate(ProfiloActionBO o) {
		getHibernateTemplate().saveOrUpdate(o);
		return o;
	}

	@Override
	public List<ProfiloActionBO> loadAll() {
		return getHibernateTemplate().loadAll(ProfiloActionBO.class);
	}
	
	
	//@Override
	public void delete(String codiProfilo) {

		String q="Delete U_NSBF_DEM.D_J_MM_ACTION_PROFILO where SEQU_ID_PROFILO = ?";
		 
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);

		 query.setParameter(0, codiProfilo);
		 
		 query.executeUpdate();
	}
	

	@Override
	public void salvaAssoActionProfilo(String idActionAssociato, String codiProfilo) {
		
		
		
		String q="Insert into U_NSBF_DEM.D_J_MM_ACTION_PROFILO "+
				"(SEQU_ID_ACTION, SEQU_ID_PROFILO) " +	
						" Values (?,?)";
		
		
		 
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);
		 query.setParameter(0, idActionAssociato);
		 query.setParameter(1, codiProfilo);
		 
		 query.executeUpdate();
		
	}

}
