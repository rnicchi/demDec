package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.CroTransBO;
import it.almavivaitalia.bilancio.commons.dao.CroTransDao;
import it.almavivaitalia.bsn.sh.utils.FlexibleQuery;
import it.almavivaitalia.bsn.sh.utils.QueryBuilder;

import java.util.List;

import org.hibernate.Query;



public class CroTransDaoImpl extends AbstractCommonDaoImpl implements CroTransDao{

	@Override
	public List<CroTransBO> loadAll() {
		return (List<CroTransBO>)getHibernateTemplate().loadAll(CroTransBO.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CroTransBO> loadAllOrdById() {
		Query query=createQuery("from CroTransBO order by descDescr");
		
		List<CroTransBO> list=query.list(); 
		return list;
	}

	public CroTransBO existsCroTrans(Short id){
		QueryBuilder queryBuilder = new QueryBuilder();	
		queryBuilder.append(" SELECT croTrans from CroTransBO croTrans ");	    
	    queryBuilder.append(" WHERE croTrans.id = :id",id);
		FlexibleQuery query = createFlexibleQuery(queryBuilder);
		query.setShort("id",id);
		return (CroTransBO)query.uniqueResult();
	}

}
