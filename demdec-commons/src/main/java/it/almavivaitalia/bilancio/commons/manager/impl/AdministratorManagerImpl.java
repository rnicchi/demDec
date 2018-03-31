package it.almavivaitalia.bilancio.commons.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.ActionBO;
import it.almavivaitalia.bilancio.commons.bo.MenuBO;
import it.almavivaitalia.bilancio.commons.bo.ProfiloBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteBO;
import it.almavivaitalia.bilancio.commons.to.ActionTO;
import it.almavivaitalia.bilancio.commons.to.MenuTO;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;

import java.util.List;

public class AdministratorManagerImpl extends AbstractCommonAdministratorManagerImpl{
	
	public MenuTO storeMenu(MenuTO to) throws Throwable {
		MenuBO bo = (MenuBO)getDozerDriver().map(to, MenuBO.class, "Menu");
		/*
		if (bo.getItems()!=null){
			for (Iterator<Item> iterator = bo.getItems().iterator(); iterator.hasNext();) {
				Item item = iterator.next();
				doStoreItem(item);
			}
		}
		*/
		bo = getMenuDao().saveOrUpdate(bo);
		to.setId(bo.getId());
		return to;
	}
	
	public MenuTO loadMenuByPrimaryKey(Long id) throws Throwable{
		MenuBO bo = getMenuDao().loadByPrimaryKey(id);
		MenuTO to = (MenuTO)getDozerDriver().map(bo, MenuTO.class, "Menu");
		to.buildProfiloList();
		return to;
	}
	
	

	
	
	@Override
	public ActionTO storeAction(ActionTO to) throws Throwable {
		ActionBO bo = getActionDao().saveOrUpdate((ActionBO)getDozerDriver().map(to, ActionBO.class, "Action"));
		return (ActionTO)getDozerDriver().map(bo, ActionTO.class, "Action");
	}

	
	@Override
	public ActionTO loadActionByPrimaryKey(Long id) throws Throwable{
		ActionBO bo = getActionDao().loadByPrimaryKey(id);
		return (ActionTO)getDozerDriver().map(bo, ActionTO.class, "Action");
	}

	@Override
	public ActionTO loadActionByCodiAction(String codi) throws Throwable{
		ActionBO bo = getActionDao().loadByCodiAction(codi);
		return (ActionTO)getDozerDriver().map(bo, ActionTO.class, "Action");
	}
	
	@Override
	public List<MenuTO> loadAllMenu() throws Throwable{
		List<MenuBO> boList = getMenuDao().loadAllMenu();
		return getDozerDriver().mapList(boList, MenuTO.class, "Menu");
	}
	

	@Override
	public ProfiloTO loadProfiloByPrimaryKey(Long id) throws Throwable {
		return (ProfiloTO)getDozerDriver().map(getProfiloDao().loadByPrimaryKey(id), ProfiloTO.class, "Profilo");
	}

	@Override
	public UtenteTO loadUtenteByPrimaryKey(Long id) throws Throwable {
		return (UtenteTO)getDozerDriver().map(getUtenteDao().loadByPrimaryKey(id), UtenteTO.class, "Utente");
	}

	@Override
	public ProfiloTO storeProfilo(ProfiloTO to) throws Throwable {
		ProfiloBO bo = getProfiloDao().saveOrUpdate((ProfiloBO)getDozerDriver().map(to, ProfiloBO.class, true, "Profilo"));
		return (ProfiloTO)getDozerDriver().map(bo, ProfiloTO.class, true, "Profilo");
	}

	@Override
	public UtenteTO storeUtente(UtenteTO to) throws Throwable {
		UtenteBO bo = getUtenteDao().saveOrUpdate((UtenteBO)getDozerDriver().map(to, UtenteBO.class, "Utente"));
		UtenteTO utenteTO = (UtenteTO)getDozerDriver().map(bo, UtenteTO.class, "Utente");
		return utenteTO;
	}
	
	@Override
	public ProfiloTO loadProfiloByCodiProfilo(String codi) throws Throwable{
		return (ProfiloTO)getDozerDriver().map(getProfiloDao().loadByCodiProfilo(codi), ProfiloTO.class, "Profilo");
	}
	
	@Override
	public UtenteTO loadUtenteByCodiUtente(String codi) throws Throwable{
		UtenteTO utenteTO=null;
		UtenteBO utente = getUtenteDao().loadByCodiUtente(codi);
	 	if (utente != null){
			utenteTO =(UtenteTO)getDozerDriver().map(utente, UtenteTO.class, true, "Utente");
/*		} else{
			throw new ObjectNotFoundException("ORRORE");*/
		} 
		return utenteTO;
		
	}


	
}
