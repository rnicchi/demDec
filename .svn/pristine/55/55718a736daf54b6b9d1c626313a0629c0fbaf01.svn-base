package it.almavivaitalia.bilancio.commons.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.ItemBO;
import it.almavivaitalia.bilancio.commons.dao.ActionDao;
import it.almavivaitalia.bilancio.commons.dao.ItemDao;
import it.almavivaitalia.bilancio.commons.dao.MenuDao;
import it.almavivaitalia.bilancio.commons.dao.ProfiloDao;
import it.almavivaitalia.bilancio.commons.dao.UtenteDao;
import it.almavivaitalia.bilancio.commons.manager.AdministratorManager;
import it.almavivaitalia.bilancio.commons.to.ItemTO;

import java.util.Iterator;


public abstract class AbstractCommonAdministratorManagerImpl extends	AbstractCommonManagerImpl  implements AdministratorManager{
	
	//Data Fields
	private ItemDao itemDao;
	private MenuDao menuDao;
	private ActionDao actionDao;
	private UtenteDao utenteDao;
	private ProfiloDao profiloDao;
	
	//Setter Methods
	public void setActionDao(ActionDao actionDao) {
		this.actionDao = actionDao;
	}
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	public void setUtenteDao(UtenteDao utenteDao) {
		this.utenteDao = utenteDao;
	}

	public void setProfiloDao(ProfiloDao profiloDao) {
		this.profiloDao = profiloDao;
	}
	
	//Getter Methods
	public ItemDao getItemDao() {
		return itemDao;
	}
	
	public MenuDao getMenuDao() {
		return menuDao;
	}
	
	public ActionDao getActionDao() {
		return actionDao;
	}
	
	public UtenteDao getUtenteDao() {
		return utenteDao;
	}
	
	public ProfiloDao getProfiloDao() {
		return profiloDao;
	}
	
	
	//NOTA solo l'id più alto viene asseganto al TO
	public ItemTO storeItem(ItemTO to) throws Throwable {
		ItemBO bo = doStoreItem((ItemBO)getDozerDriver().map(to, ItemBO.class, "ItemBO"));
		to.setId(bo.getId());
		return (ItemTO)getDozerDriver().map(bo, ItemTO.class, "ItemBO");
	}
	
	private ItemBO doStoreItem(ItemBO bo) throws Throwable{
		bo = getItemDao().saveOrUpdate(bo);
		if (bo.getItemList()!=null){
			for (Iterator<ItemBO> iterator = bo.getItemList().iterator(); iterator.hasNext();) {
				ItemBO child = iterator.next();
				doStoreItem(child);
			}
		}
		return bo;
	}

}
