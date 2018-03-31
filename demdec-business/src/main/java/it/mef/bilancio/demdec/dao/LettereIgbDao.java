package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.bo.LettereIgbBO;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

public interface LettereIgbDao extends AbstractDemDao<LettereIgbBO>{

	List<LettereIgbBO> findByLettera(LettereIgbBO lettera) throws Throwable;

	LettereIgbBO getLetteraById(Long idLettera) throws Throwable;

	Blob getBlobByIdLettera(BigDecimal id) throws Throwable;

	LettereIgbBO findByUK(Long fkNumeIdFascicolo, Short annoEse, Integer codiStp, Integer numeApp);

	List<LettereIgbBO> findLettereByIdDecreto(Long idDecreto) throws Throwable;

	List<LettereIgbBO> findLettereByCodiUfficioAndStatus(String codiUfficio, String status) throws Throwable;

	String findDestinatariMailPec(BigDecimal idLetteraIgb) throws Throwable;

	String getFlagSemaforoIpa() throws Throwable;

	List<LettereIgbBO> findLettereByStatus(String status) throws Throwable;

	Integer  aggiornaStatus(BigDecimal idLetteraIgb, String status) throws Throwable;
	
}
