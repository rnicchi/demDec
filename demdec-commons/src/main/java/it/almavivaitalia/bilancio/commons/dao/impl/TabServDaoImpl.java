package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.dao.TabServDao;

import org.hibernate.Query;

public class TabServDaoImpl extends AbstractCommonDaoImpl implements TabServDao {
	@Override
	public String searchPropertyValueFromTabServ(String propertyName)
			throws Throwable {
		Query query=getNamedQuery("TabServBO.searchPropertyValueFromTabServ");
		query.setString("propertyName", propertyName);
		return (String)query.uniqueResult();
		
	}
}
