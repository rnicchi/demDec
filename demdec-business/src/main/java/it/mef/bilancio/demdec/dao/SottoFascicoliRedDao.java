package it.mef.bilancio.demdec.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBO;

public interface SottoFascicoliRedDao extends AbstractDemDao<SottoFascicoliRedBO> {

	boolean insertSottoFascDocumenti(SottoFascicoliRedBO sfRedBo, DocumentiRedBO docRedBo) throws Throwable;
		 
	void deleteByNumeIdFascicolo(Long numeIdFascicolo) throws Throwable;
	
	List<SottoFascicoliRedBO>findByNumeIdFascicolo(Long numeIdFascicolo) throws Throwable;

}
