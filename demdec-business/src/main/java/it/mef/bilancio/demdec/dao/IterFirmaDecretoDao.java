package it.mef.bilancio.demdec.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.IterFirmaDecretoBO;


public interface IterFirmaDecretoDao extends AbstractDemDao<IterFirmaDecretoBO> {

	IterFirmaDecretoBO getCurrentIFDByIdFascicolo(long idFascicolo) throws Throwable;
	IterFirmaDecretoBO getNextIFDByIdFascicoloAndNumeOrderIter(long idFascicolo, Integer numeOrdineFirma);
	IterFirmaDecretoBO getCurrentIFDByIdFascicoloEStato(long idFascicolo, String stato) throws Throwable;
	boolean esisteDecretoConModelloIter(Short idIter) throws Throwable;
	boolean ultimaFirma(long idFascicolo) throws Throwable;
	String findStatoIterFirmaDecretoByIdFascicolo(Integer idFascicolo) throws Throwable;
	List<IterFirmaDecretoBO> getListIterFirmaDecretoByNumeIdFascicolo(long idFascicolo) throws Throwable;

}
