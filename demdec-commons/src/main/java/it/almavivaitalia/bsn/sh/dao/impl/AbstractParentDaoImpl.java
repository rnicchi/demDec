package it.almavivaitalia.bsn.sh.dao.impl;

import it.almavivaitalia.bsn.sh.bo.AbstractBO;
import it.almavivaitalia.bsn.sh.utils.FlexibleQuery;
import it.almavivaitalia.bsn.sh.utils.QueryBuilder;
import it.almavivaitalia.bsn.sh.utils.SqlFlexibleQuery;
import it.almavivaitalia.bsn.sh.utils.SqlQueryBuilder;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AbstractParentDaoImpl extends HibernateDaoSupport{
	
	protected static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		} else if (o instanceof Collection<?>) {
			return ((Collection<?>) o).isEmpty();
		} else {
			return o.toString().trim().equals("");
		}
	}
	
	protected AbstractBO findUniqueByNamedParam(String hql, String paramName,
			Object param) {
		List<?> list = getHibernateTemplate().findByNamedParam(hql, paramName,
				param);
		if ((list != null) && (!list.isEmpty())) {
			return (AbstractBO) list.get(0);
		} else {
			return null;
		}
	}

	protected Query getNamedQuery(String queryName) {
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.getNamedQuery(queryName);
	}

	protected Query createQuery(String queryString) {
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery(queryString);
	}
	
	protected Query createSQLQuery(String queryString) {
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createSQLQuery(queryString);
	}	

	protected FlexibleQuery createFlexibleQuery(QueryBuilder query) {
		return new FlexibleQuery(getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(query.toString()));
	}
	
	protected SqlFlexibleQuery createSQLFlexibleQuery(SqlQueryBuilder query) {
		return new SqlFlexibleQuery(getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createSQLQuery(query.toString()));
	}
	
}
