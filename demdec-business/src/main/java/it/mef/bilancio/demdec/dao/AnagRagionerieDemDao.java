package it.mef.bilancio.demdec.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;

public interface AnagRagionerieDemDao extends AbstractDemDao<AnagRagionerieDemBO> {

	List<AnagRagionerieDemBO> findAnagRagDemByAnagAmminDem(AnagAmminDemTO anagAmminDemTo) throws Throwable;

	
	
}
