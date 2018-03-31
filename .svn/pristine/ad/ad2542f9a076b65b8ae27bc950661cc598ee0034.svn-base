package it.almavivaitalia.bilancio.commons.dao;

import it.almavivaitalia.bilancio.commons.bo.MenuBO;


import java.util.List;

public interface MenuDao extends AbstractCommonDao {

	public MenuBO saveOrUpdate(MenuBO o);

	public MenuBO loadByPrimaryKey(Long id);

	public List<MenuBO> loadAllMenu();

	public List<MenuBO> loadMenuByCodiMenu(String codiMenu);
	
	public List<MenuBO> loadMenuByCodiMenu(String codiMenu, String idProfilo);
	
	public Boolean isUserEnabled(String codiMenu, String idProfilo);
}
