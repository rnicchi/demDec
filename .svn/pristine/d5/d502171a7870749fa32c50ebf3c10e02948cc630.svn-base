package it.almavivaitalia.bilancio.commons.dao;

import it.almavivaitalia.bilancio.commons.bo.AbstractCommonBO;
import it.almavivaitalia.bilancio.commons.to.CroFunzCampiTO;

import java.util.List;


public interface CroFunzCampiDao extends AbstractCommonDao{
	/**
	 * recupera dalla tabella d_cro_funz_campi i campi da gestire
	 * 
	 * @param nomeFunzione
	 * @param tableName
	 * @param fkCroTrans
	 * @return
	 * @throws Throwable
	 */
	public List<CroFunzCampiTO> loadListByNomeFunzioneTableNameCroTrans(String nomeFunzione, String tableName, String fkCroTrans) throws Throwable;
	
	public String decode(String queryString, String paramName, String paramValue) throws Throwable ;
	
	public List<String> getColumnNamesByClass(Class<? extends AbstractCommonBO> persistentClass) throws Throwable;
	
	public String getTableNameByClass(Class<? extends AbstractCommonBO> persistentClass) throws Throwable;

	public List<String> getKeyColumnNamesByClass(Class<? extends AbstractCommonBO> persistentClass) throws Throwable;		
}
