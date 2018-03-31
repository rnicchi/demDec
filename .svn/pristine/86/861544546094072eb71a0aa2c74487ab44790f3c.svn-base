package it.almavivaitalia.bsn.sh.dao;

import it.almavivaitalia.bsn.sh.bo.AbstractBO;

import java.io.Serializable;






public interface AbstractDao {

	public void delete(AbstractBO bo) throws Throwable ;
	public AbstractBO saveOrUpdate(AbstractBO o) throws Throwable;
	public <T extends AbstractBO> T loadById(Class<T> cls, Number id);
	public <T extends AbstractBO> T loadById(Class<T> cls, Serializable id) throws Throwable;
	public <T extends AbstractBO> void update(T bo);
	public String getSysdate() throws Throwable;	
	public void flush();
	
}
