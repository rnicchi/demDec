package it.almavivaitalia.bilancio.commons.manager.impl;

import it.almavivaitalia.bilancio.commons.dao.ActionDao;
import it.almavivaitalia.bilancio.commons.manager.ActionManager;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ActionManagerImpl extends AbstractCommonManagerImpl implements
		ActionManager {
	
	@Autowired
	private ActionDao actionDao;

	@Override
	public List<String> findFunzioniByProfiloApp(ProfiloTO profilo)
			throws Throwable {
	//	List<ActionBO> 
		return actionDao.loadByProfilo(profilo.getId());
	}

}
