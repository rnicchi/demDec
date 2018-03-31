package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.bo.AnagTipoDecretoBO;

import java.util.List;

public interface AnagTipoDecretoDao extends AbstractDemDao<AnagTipoDecretoBO>{

	List<AnagTipoDecretoBO> loadAnagTipoDecreto();
	AnagTipoDecretoBO loadAnagTipoDecretoById(Integer id);
}
