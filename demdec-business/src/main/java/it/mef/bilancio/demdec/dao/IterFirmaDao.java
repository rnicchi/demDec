package it.mef.bilancio.demdec.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.IterFirmaBO;

public interface IterFirmaDao extends AbstractDemDao<IterFirmaBO> {

	List<IterFirmaBO> loadIterFirma() throws Throwable;

	List<IterFirmaBO> loadByIdIter(short idIter) throws Throwable;

	Integer generaId(Short fkSequIdIter) throws Throwable;

	void deleteByIter(short idIter) throws Throwable;
	void delete(short idIter, int numeroOrdine) throws Throwable;

	void addAll(short idIter, List<IterFirmaBO> listaIterFirmaBO) throws Throwable;
}
