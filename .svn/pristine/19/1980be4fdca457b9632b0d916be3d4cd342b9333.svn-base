package it.almavivaitalia.bilancio.commons.manager;

import it.almavivaitalia.bilancio.commons.to.ActionTO;
import it.almavivaitalia.bilancio.commons.to.ItemTO;
import it.almavivaitalia.bilancio.commons.to.MenuTO;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;

import java.util.List;

public interface AdministratorManager extends AbstractCommonManager{

	public ItemTO storeItem(ItemTO to) throws Throwable;
	
	public MenuTO storeMenu(MenuTO to) throws Throwable;
	
	public MenuTO loadMenuByPrimaryKey(Long id) throws Throwable;
	
	public ActionTO loadActionByCodiAction(String codi) throws Throwable;
	
	public ActionTO loadActionByPrimaryKey(Long id) throws Throwable;
	
	public ActionTO storeAction(ActionTO to) throws Throwable;

	public List<MenuTO> loadAllMenu() throws Throwable;
	
	public ProfiloTO loadProfiloByPrimaryKey(Long id) throws Throwable;
	
	public UtenteTO loadUtenteByPrimaryKey(Long id) throws Throwable;

	public ProfiloTO storeProfilo(ProfiloTO to) throws Throwable;

	public UtenteTO storeUtente(UtenteTO to) throws Throwable;
	
	public ProfiloTO loadProfiloByCodiProfilo(String codi) throws Throwable;

	public UtenteTO loadUtenteByCodiUtente(String codi) throws Throwable;
	
	
	
}