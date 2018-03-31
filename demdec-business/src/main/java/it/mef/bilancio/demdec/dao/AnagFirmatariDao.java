package it.mef.bilancio.demdec.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.AnagFirmatariBO;

public interface AnagFirmatariDao extends AbstractDemDao<AnagFirmatariBO> {

	List<AnagFirmatariBO> loadFirmatari() throws Throwable;
	AnagFirmatariBO loadById(String id)  throws Throwable;
	List<AnagFirmatariBO> loadDestinatariMail(Integer flag) throws Throwable;
	List<AnagFirmatariBO> loadDeleganti(String tipoFirma) throws Throwable;
	List<AnagFirmatariBO> loadDelegati(String tipoFirma) throws Throwable;
}
