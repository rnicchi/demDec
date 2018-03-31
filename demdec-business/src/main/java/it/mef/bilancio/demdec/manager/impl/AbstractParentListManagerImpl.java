package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.AnagTipoRiepilogoBO;
import it.almavivaitalia.bilancio.commons.dao.ActionDao;
import it.almavivaitalia.bilancio.commons.to.ActionTO;
import it.almavivaitalia.bilancio.commons.to.AnagTipoRiepilogoTO;
import it.almavivaitalia.bilancio.commons.to.AnagTipologiaTagliaTO;
import it.mef.bilancio.demdec.dao.AnagFirmatariDao;
import it.mef.bilancio.demdec.dao.AnagTipoRiepilogoDao;
import it.mef.bilancio.demdec.dao.AnagTipologiaTagliaDao;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class  AbstractParentListManagerImpl extends StaticListManagerImpl implements ListManager {
	
	@Autowired
	private ActionDao actionDao;

	@Autowired
	private AnagTipologiaTagliaDao anagTipologiaTagliaDao;
	
	@Autowired
	private AnagTipoRiepilogoDao anagTipoRiepilogoDao;
	
	@Autowired
	AnagFirmatariDao anagFirmatariDao;
	
	//@Override
	public List<ActionTO> findAllAction() throws Throwable {
		return getDozerDriver().mapList(actionDao.findAll(),ActionTO.class,"Action");
	}

	public List<ActionTO> findAllActionByProfilo(Integer sequIdProfilo) throws Throwable {
		return getDozerDriver().mapList(actionDao.loadByProfilo(sequIdProfilo),ActionTO.class,"Action");
	}
	
	
	@Override
	public List<AnagTipologiaTagliaTO> loadAnagTipologiaTaglia() throws Throwable{
		return getDozerDriver().mapList(anagTipologiaTagliaDao.loadAnagTipologiaTaglia(),AnagTipologiaTagliaTO.class,"AnagTipologiaTaglia");
	}
	
	@Override
	public List<AnagTipoRiepilogoTO> loadAnagTipoRiepilogo() throws Throwable{
		return getDozerDriver().mapList(anagTipoRiepilogoDao.loadAnagTipoRiepilogo(),AnagTipoRiepilogoTO.class,"AnagTipoRiepilogo");
	}
	
	
	@Override
	public AnagTipoRiepilogoBO loadTipoRiepilogoByDesc(String descTipo)throws Throwable{
		
		return anagTipoRiepilogoDao.loadTipoRiepilogoByDesc(descTipo);
	}
	
	@Override
	public AnagTipoRiepilogoTO loadTipoRiepilogoTOByDesc(String descTipo)throws Throwable{
		
		return getDozerDriver().map(anagTipoRiepilogoDao.loadTipoRiepilogoByDesc(descTipo), AnagTipoRiepilogoTO.class,"AnagTipoRiepilogo");
	//	return anagTipoRiepilogoDao.loadTipoRiepilogoByDesc(descTipo);
	}
	
	
	
	
	@Override
	public List<AnagFirmatariTO> loadFirmatari() throws Throwable{
		return getDozerDriver().mapList(anagFirmatariDao.loadFirmatari(), AnagFirmatariTO.class, "AnagFirmatari");
	}
	
	
}
