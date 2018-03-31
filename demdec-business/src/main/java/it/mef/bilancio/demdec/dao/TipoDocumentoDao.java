package it.mef.bilancio.demdec.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.TipoDocumentoBO;

public interface TipoDocumentoDao extends AbstractDemDao<TipoDocumentoBO>{

	
	List<TipoDocumentoBO> loadTipoDocumentoIG() throws Throwable;

	List<TipoDocumentoBO> loadTipoDocumentoAD();

	TipoDocumentoBO loadbyTipoDocumento(String codi);

}
