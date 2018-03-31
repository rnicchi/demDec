package it.mef.bilancio.demdec.dao;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaDecretoBO;

public interface AnagTipologiaDecretoDao extends
		AbstractDemDao<AnagTipologiaDecretoBO> {

	List<AnagTipologiaDecretoBO> tiplogiaDecretoList(Integer codiTipoDecreto) throws Throwable;
	List<AnagTipologiaDecretoBO> tiplogiaDecretoFullList() throws Throwable;

	public List<AnagTipologiaDecretoBO> loadAnagTipologiaDecreto() throws Throwable;
	List<AnagTipologiaDecretoBO> loadAnagTipologiaDecretoByIter(short idIter) throws Throwable;

	AnagTipologiaDecretoBO findAnagTipologiaDecretoByDesc(String descTipologia) throws Throwable;

	void saveTipologiaDecreto(AnagTipologiaDecretoBO anagTipologiaDecreto) throws Throwable;
	void deleteTipologiaDecreto(AnagTipologiaDecretoBO anagTipologiaDecreto) throws Throwable;
	void updateTipologiaDecreto(AnagTipologiaDecretoBO anagTipologiaDecreto) throws Throwable;
}
