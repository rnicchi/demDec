package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.bo.AnagUfficiBO;

import java.util.List;

public interface AnagUfficiDao extends AbstractDemDao<AnagUfficiBO> {

	List<AnagUfficiBO> loadAnagUffici();

	List<AnagUfficiBO> loadAnagUfficiAttivi();
	
}
