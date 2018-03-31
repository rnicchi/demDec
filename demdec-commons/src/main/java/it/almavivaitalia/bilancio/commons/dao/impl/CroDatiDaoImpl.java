package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.dao.CroDatiDao;
import it.almavivaitalia.bsn.sh.utils.SqlFlexibleQuery;
import it.almavivaitalia.bsn.sh.utils.SqlQueryBuilder;

import org.hibernate.Hibernate;

public class CroDatiDaoImpl extends AbstractCommonDaoImpl implements CroDatiDao {

	public Integer getNextSequenceVal() {
		SqlQueryBuilder queryBuilder = new SqlQueryBuilder();
		queryBuilder.append(" SELECT s_cro_dati.nextval as risultato from dual ");
		SqlFlexibleQuery query = createSQLFlexibleQuery(queryBuilder);
		query.addScalar("risultato", Hibernate.INTEGER);
		Integer ret = (Integer) query.uniqueResult();
		return ret;
	}
}
