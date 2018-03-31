package it.mef.bilancio.demdec.dao;

import it.mef.bilancio.demdec.utils.Constants;

import java.io.Serializable;

public interface AbstractDemDao<T> extends it.almavivaitalia.bsn.sh.dao.AbstractDao, Constants {
	
	public T loadById(Serializable id) throws Throwable;
	public Object generaId(Class<T> clazz) throws Throwable;
}
