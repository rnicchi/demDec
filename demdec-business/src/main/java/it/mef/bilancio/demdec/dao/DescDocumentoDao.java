package it.mef.bilancio.demdec.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.DescDocumentoBO;


public interface DescDocumentoDao extends AbstractDemDao<DescDocumentoBO>{
	
	 List<DescDocumentoBO> loadByTipoDocumento(String tipo) throws Throwable;
	 List<DescDocumentoBO> loadByTipoDocumentoDescrizione(String tipo, String descrizione) throws Throwable;
	
}
