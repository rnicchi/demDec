package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.EserciziDemBO;
import it.almavivaitalia.bilancio.commons.dao.EserciziDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

public class EserciziDaoImpl extends AbstractCommonDaoImpl implements EserciziDao {//BEGIN
	public List<EserciziDemBO> loadEsercizi() throws Throwable {
		Query query=createSQLQuery("select * from d_j_action");
		query.list();
		return new ArrayList<EserciziDemBO>();
	}
}
