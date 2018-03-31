package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.CroCodiciBO;
import it.almavivaitalia.bilancio.commons.dao.CroCodiciDao;
import it.almavivaitalia.bsn.sh.utils.FlexibleQuery;
import it.almavivaitalia.bsn.sh.utils.QueryBuilder;

public class CroCodiciDaoImpl extends AbstractCommonDaoImpl implements
		CroCodiciDao {

	public CroCodiciBO existsCodici(Integer id) {
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.append(" SELECT croCodici from CroCodiciBO croCodici ");
		queryBuilder.append(" WHERE croCodici.id = :id", id);
		FlexibleQuery query = createFlexibleQuery(queryBuilder);
		query.setInteger("id", id);
		return (CroCodiciBO) query.uniqueResult();
	}

}
