package it.almavivaitalia.bilancio.commons.manager.impl;

import it.almavivaitalia.bilancio.commons.dao.TabServDao;
import it.almavivaitalia.bilancio.commons.manager.RedirectManager;

public class RedirectManagerImpl extends AbstractCommonManagerImpl implements
		RedirectManager {
	
	private TabServDao tabServDao;
	
	@Override
	public String searchPropertyValueFromTabServ(String propertyName)
			throws Throwable {
		return tabServDao.searchPropertyValueFromTabServ(propertyName);
	}

	public void setTabServDao(TabServDao tabServDao) {
		this.tabServDao = tabServDao;
	}	
	
	@Override
	public String getSystemDate() throws Throwable {
		return tabServDao.getSysdate();
	}	
}
