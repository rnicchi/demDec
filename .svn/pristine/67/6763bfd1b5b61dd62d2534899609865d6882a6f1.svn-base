package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.ItemBO;
import it.almavivaitalia.bilancio.commons.dao.ItemDao;


public class ItemDaoImpl extends AbstractCommonDaoImpl implements ItemDao{

	public ItemBO saveOrUpdate(ItemBO o) {
		getHibernateTemplate().saveOrUpdate(o);
		return o;
	}

}
