package it.almavivaitalia.bilancio.commons.manager;

import it.almavivaitalia.bilancio.commons.to.MenuTO;
import it.almavivaitalia.bsn.sh.manager.AbstractManager;

import java.util.List;

public interface MenuManager extends AbstractManager {
	public List<MenuTO> loadMenuByCodiMenu(String codiMenu) throws Throwable; 
	public List<MenuTO> loadMenuByCodiMenu(String codiMenu, String idProfilo) throws Throwable;
	public Boolean isUserEnabled(String codiMenu, String idProfilo) throws Throwable;
}
