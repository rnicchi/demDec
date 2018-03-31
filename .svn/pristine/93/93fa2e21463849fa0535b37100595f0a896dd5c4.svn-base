package it.almavivaitalia.bilancio.commons.manager.impl;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.MenuBO;
import it.almavivaitalia.bilancio.commons.manager.MenuManager;
import it.almavivaitalia.bilancio.commons.to.MenuTO;

public class MenuManagerImpl extends AdministratorManagerImpl implements MenuManager {

	@Override
	public List<MenuTO> loadMenuByCodiMenu(String codiMenu) throws Throwable {
		List<MenuBO> boList = getMenuDao().loadMenuByCodiMenu(codiMenu);
		if(boList!=null&&!boList.isEmpty()){
			return getDozerDriver().mapList(boList, MenuTO.class, "Menu");
		}else{
			return null;
		}
		
	}

	@Override
	public List<MenuTO> loadMenuByCodiMenu(String codiMenu, String idProfilo)
			throws Throwable {
		List<MenuBO> boList = getMenuDao().loadMenuByCodiMenu(codiMenu, idProfilo);
		if(boList!=null&&!boList.isEmpty()){
			return getDozerDriver().mapList(boList, MenuTO.class, "Menu");
		}else{
			return null;
		}
	}

	@Override
	public Boolean isUserEnabled(String codiMenu, String idProfilo)
			throws Throwable {
		return getMenuDao().isUserEnabled(codiMenu, idProfilo);
	}

}
