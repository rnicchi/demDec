package it.mef.bilancio.demdec.dao;


import it.almavivaitalia.bilancio.commons.bo.AnagTipoRiepilogoBO;
import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaTagliaBO;

import java.util.List;

public interface AnagTipologiaTagliaDao extends AbstractDemDao<AnagTipologiaTagliaBO>{

	List<AnagTipologiaTagliaBO> loadAnagTipologiaTaglia();
//	List<AnagTipoRiepilogoBO> loadAnagTipoRiepilogo();
	//AnagTipologiaTagliaBO loadAnagTipoDecretoById(Integer id);
}
