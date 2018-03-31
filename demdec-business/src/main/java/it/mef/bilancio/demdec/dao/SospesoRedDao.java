package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.bo.SospesiRedBO;

import java.util.Collection;


public interface SospesoRedDao extends AbstractDemDao<SospesiRedBO> {

	void saveSospesiRed(Collection<SospesiRedBO> listaSospesiRed) throws Throwable;
	Collection<SospesiRedBO> getListaSospesiRed() throws Throwable;
}
