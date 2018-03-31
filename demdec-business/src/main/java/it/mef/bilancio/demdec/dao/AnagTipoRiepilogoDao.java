package it.mef.bilancio.demdec.dao;


import it.almavivaitalia.bilancio.commons.bo.AnagTipoRiepilogoBO;
import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaTagliaBO;
import it.almavivaitalia.bilancio.commons.to.AnagTipoRiepilogoTO;

import java.util.List;

public interface AnagTipoRiepilogoDao extends AbstractDemDao<AnagTipoRiepilogoBO>{

	List<AnagTipoRiepilogoBO> loadAnagTipoRiepilogo();
	public AnagTipoRiepilogoBO loadTipoRiepilogoByDesc(String descTipo);

}
