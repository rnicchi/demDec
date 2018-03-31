package it.mef.bilancio.demdec.dao;


import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;

import java.util.List;

public interface DocumentiRedDao  extends AbstractDemDao<DocumentiRedBO>{

	List<FascicoliViewTO> findFascicoliAssociati(String guid) throws Throwable;
	
//	void updateFascicolo (DocumentiRedBO bo) throws Throwable;
//
//	public Integer insertDocumentoRed(DocumentiRedBO bo ) throws Throwable;
	
	void deleteByFascicolo(Long idFascicolo) throws Throwable;
	
}
