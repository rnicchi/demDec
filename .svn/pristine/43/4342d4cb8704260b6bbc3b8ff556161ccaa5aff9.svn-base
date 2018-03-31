package it.almavivaitalia.bilancio.commons.dao.impl;


import it.almavivaitalia.bilancio.commons.dao.AbstractCommonDao;
import it.almavivaitalia.bsn.sh.bo.AbstractBO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;


public class AbstractCommonDaoImpl extends it.almavivaitalia.bsn.sh.dao.impl.AbstractDaoImpl implements AbstractCommonDao {

	public static String getHibernateClassNameFromTableName(String tableName) {
		return getHibernateClassNameFromTableName(tableName, "d_ssb_");
	}

	public static String getHibernateFieldNameFromTableFieldName(String fieldName) {
		return getHibernateFieldNameFromTableFieldName(fieldName,"d_ssb_");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractBO> listByExample(AbstractBO example) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(example.getClass());
		criteria.add(Example.create(example));
		return criteria.list();
	}

	// Utility per chiamare le procedure //
	public String makeProcedureCall(String functionName, Object ... parameters){
		StringBuilder prepareCall=new StringBuilder();
		StringBuilder placeHolders=new StringBuilder();
		for(@SuppressWarnings("unused") Object obj:parameters){
			if(placeHolders.length()!=0)
				placeHolders.append(", ");
			
			placeHolders.append("?");
		}		
		prepareCall.append("{ call "+functionName+"("+placeHolders+") }");	
		
		return prepareCall.toString();		
	}	

}
