package it.mef.bilancio.demdec.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.AnagCdrDemBO;

public interface AnagCdrDemDao extends AbstractDemDao<AnagCdrDemBO> {

	List<AnagCdrDemBO> anagCdrList(Short annoEse, Integer numeStp, Integer numeApp) throws Throwable;

}
