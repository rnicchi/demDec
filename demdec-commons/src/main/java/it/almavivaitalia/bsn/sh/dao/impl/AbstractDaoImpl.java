package it.almavivaitalia.bsn.sh.dao.impl;

import java.io.Serializable;

import it.almavivaitalia.bsn.sh.bo.AbstractBO;
import it.almavivaitalia.bsn.sh.dao.AbstractDao;
import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.bsn.sh.utils.SqlQueryBuilder;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;

public class AbstractDaoImpl extends AbstractParentDaoImpl implements AbstractDao {
	
	private ResourceBundleMessageSource businessMessageSource;

	protected ResourceBundleMessageSource getBusinessMessageSource() {
		return businessMessageSource;
	}

	public void setBusinessMessageSource(
			ResourceBundleMessageSource businessMessageSource) {
		this.businessMessageSource = businessMessageSource;
	}
	
	public AbstractDaoImpl() {
	}

	/*protected static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		} else if (o instanceof Collection<?>) {
			return ((Collection<?>) o).isEmpty();
		} else {
			return o.toString().trim().equals("");
		}
	}*/
	
	public AbstractBO saveOrUpdate(AbstractBO o) throws Throwable {
		o.setNumeVersion(o.getNumeVersion()+1);
		getHibernateTemplate().saveOrUpdate(o);
		getHibernateTemplate().flush();
		return o;
	}
	
	/*protected AbstractBO findUniqueByNamedParam(String hql, String paramName,
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
	}*/
	
	public static String getHibernateClassNameFromTableName(String tableName, String tablePrefix) {
		return getHibernateClassNameFromTableNameorFieldName(tableName,tablePrefix, true);
	}

	public static String getHibernateFieldNameFromTableFieldName(String fieldName, String tablePrefix) {
		return getHibernateClassNameFromTableNameorFieldName(fieldName, tablePrefix, false);
	}
	
	// può ricevere nomi di tabella o di campo scritti in uppercase o lowercase indifferentemente
	private static String getHibernateClassNameFromTableNameorFieldName(String strToConvert, String tablePrefix, boolean isTableName){
		String tp = tablePrefix;
		if (tp==null){
			tp="";
		}
		String res=strToConvert;
		
//		se la stringa da convertire non contiene "_" non necessita conversione
		/*if (!strToConvert.contains("_")) {
			return strToConvert;
		}*/
		
		/*if (isTableName)res= res.replace("D_SSB_", "");
		res= res.toLowerCase();*/
		
		res= res.toLowerCase();
		if (isTableName)res= res.replace(tp, "");
		 
		char[] charTable = res.toCharArray();
		
		for (int index= 0 ; index<charTable.length; index++) {
			if (charTable[index]=='_'){
			charTable[index+1]=Character.toUpperCase(charTable[index+1]);
			}
		}
		if (isTableName)  charTable[0]= Character.toUpperCase(charTable[0]);
		
		res= new String(charTable);
		res= res.replace("_", "");
		
		return res;	
	}

	@Override
	public <T extends AbstractBO> T loadById(Class<T> cls, Number id) {
		return (T)getHibernateTemplate().load(cls, id);
	}

	public <T extends AbstractBO> T loadById(Class<T> cls, Serializable id) throws Throwable{//BEGIN
		return (T)getHibernateTemplate().get(cls, id);
	}//END
		
	@Override
	public <T extends AbstractBO> void update(T bo) {
		getHibernateTemplate().update(bo);
	}
	
	@Override
	public void delete(AbstractBO bo) throws Throwable {
		getHibernateTemplate().delete(bo);
	}
	
	@Override
	public String getSysdate() throws Throwable {
		SqlQueryBuilder queryBuilder = new SqlQueryBuilder();	  
		queryBuilder.append(" SELECT to_char(sysdate,'yyyy.mm.dd.hh24.mi.ss') as data from dual ");
		SQLQuery query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createSQLQuery((queryBuilder.toString()));
		query.addScalar("data", Hibernate.STRING);
		String ret= (String)query.uniqueResult();	   
		return ret;
	}
	
	public void flush(){
		getHibernateTemplate().flush();
	}
	
}
