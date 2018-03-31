package it.almavivaitalia.bilancio.commons.web.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.manager.AdministratorManager;
import it.almavivaitalia.bilancio.commons.manager.MenuManager;
import it.almavivaitalia.bilancio.commons.manager.UtenteManager;
import it.almavivaitalia.bilancio.commons.to.ItemTO;
import it.almavivaitalia.bilancio.commons.to.MenuTO;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.almavivaitalia.web.sh.utils.PageMessages;
import it.almavivaitalia.web.sh.utils.navigator.NLink;
import it.almavivaitalia.web.sh.utils.navigator.NTree;
import it.almavivaitalia.bilancio.commons.web.security.Utente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping(value = CommonConstantsRequestMapping.LOGIN_URL)
public class LoginController extends LoginParentController {
	
	private MenuManager menuManager; 
	private UtenteManager utenteManager;
	private ResourceBundleMessageSource generalResources;
	private boolean loadMenuFromDb;
	private boolean loadNavigatorFromDb;
	
	public void setLoadNavigatorFromDb(boolean loadNavigatorFromDb) {
		this.loadNavigatorFromDb = loadNavigatorFromDb;
	}

	public void setLoadMenuFromDb(boolean loadMenuFromDb) {
		this.loadMenuFromDb = loadMenuFromDb;
	}

	public void setMenuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public void setGeneralResources(ResourceBundleMessageSource generalResources) {
		this.generalResources = generalResources;
	}

	public void setUtenteManager(UtenteManager utenteManager) {
		this.utenteManager = utenteManager;
	}

	public String onSubmit(HttpServletRequest request, HttpServletResponse response, Context context) throws Throwable{
		return gestisciUtente(request, response, context);
	}
	
	@Override
	public String startController(HttpServletRequest request, HttpServletResponse response, Context context) throws Throwable {
		return gestisciUtente(request, response, context);
	}

	@Override
	protected boolean checkEnabled(HttpServletRequest request) throws Throwable { 
		return true;
	}

	private String gestisciUtente(HttpServletRequest request, HttpServletResponse response, Context context) throws Throwable{
			String view = null;
			PageMessages pageMessages = new PageMessages(getMessageSource());
			ContextHelper.setSessionModel(OBJECT_PAGE_MESSAGES, pageMessages, request);
			Utente user = getUtenteInSessione(); 
			if (!isEmpty(user.getUtente())) {
	
				ContextHelper.setSessionModel(OBJECT_USER, user.getUtente(), request);
				ContextHelper.setSessionModel(OBJECT_PROFILO, user.getProfiloInUso(), request);
				ContextHelper.setSessionModel(OBJECT_UTENTEPROFILO, user.getUtente().getUtenteProfilo(user.getProfiloInUso().getCodiProfilo()), request);
				//INIZIALIZZAZIONE MENU
				initMenu(request);						
				
				//NAVIGATOR
				initNavigator(request);
				
				view = "gestioneMenuView";
				
			} else {
				context.addError("error.userNotAllowed");
				view = "errorView";
			}
	
	/*		SecurityTO securityTO = readParameters(context);
			
			if (!isEmpty(securityTO)) {
				boolean sCheck = checkSecurityParameters(securityTO);
				if (sCheck) {
					UserInfoTO userInfoTO = new UserInfoTO();
					userInfoTO.setSecurityTO(securityTO);
					userInfoTO = loadUserInfo(userInfoTO);
					if (!isEmpty(userInfoTO.getUtenteTO())) {
	
						//BEGIN salva i riferimenti della funzione chiamante
						if(!isEmpty( request.getParameter(CommonSessionAttributes.CONTEXT_PATH_SRC))){
							ContextHelper.setSessionModel(CommonSessionAttributes.CONTEXT_PATH_SRC, request.getParameter(CommonSessionAttributes.CONTEXT_PATH_SRC), request);						
						}
						if(!isEmpty( request.getParameter(CommonSessionAttributes.REQUEST_URI_SRC))){
							ContextHelper.setSessionModel(CommonSessionAttributes.REQUEST_URI_SRC,request.getParameter(CommonSessionAttributes.REQUEST_URI_SRC), request);						
						}
						if(!isEmpty( request.getParameter(CommonSessionAttributes.URI_SRC))){
							ContextHelper.setSessionModel(CommonSessionAttributes.URI_SRC,request.getParameter(CommonSessionAttributes.URI_SRC), request);						
						}					
						if(!isEmpty( request.getParameter(CommonSessionAttributes.APPLICATION_CODE_SRC))){
							ContextHelper.setSessionModel(CommonSessionAttributes.APPLICATION_CODE_SRC,request.getParameter(CommonSessionAttributes.APPLICATION_CODE_SRC), request);												
						}
						//END salva i riferimenti della funzione chiamante
						
						ContextHelper.setSessionModel(OBJECT_USER, userInfoTO.getUtenteTO(), request);
						ContextHelper.setSessionModel(CommonSessionAttributes.OBJECT_SECURITY,userInfoTO.getSecurityTO(), request);
						ContextHelper.setSessionModel(CommonSessionAttributes.ESERCIZIO_FORMAZIONE, utenteManager.loadAnnoEse(CommonSessionAttributes.STAT_TIPO_ESE_FORM),request);
						ContextHelper.setSessionModel(CommonSessionAttributes.ESERCIZIO_GESTIONE, utenteManager.loadAnnoEse(CommonSessionAttributes.STAT_TIPO_ESE_GEST), request);
						ContextHelper.setSessionModel(CommonSessionAttributes.ESERCIZIO_CONSUNTIVO, utenteManager.loadAnnoEse(CommonSessionAttributes.STAT_TIPO_ESE_CONS), request);
						
						if (!isEmpty(applicationParametersMap)){
							
							//CREO UNA NUOVA ISTANZA DELLA MAPPA
							Map<String,List<Map<String,String>>> _applicationParametersMap= new LinkedHashMap<String, List<Map<String,String>>>();
									
							for(Map.Entry<String, List<Map<String, String>>> outer:applicationParametersMap.entrySet()){
								
								List<Map<String,String>> lista=new ArrayList<Map<String,String>>();
								
								for(Map<String, String> inner:outer.getValue()){
									
									Map<String,String> mappa=new LinkedHashMap<String, String>();
									
									for(Entry<String, String> inner2:inner.entrySet()){
										mappa.put(inner2.getKey(), "");
									}
									
									lista.add(mappa);
								}
	
								_applicationParametersMap.put(outer.getKey(), lista);
							}
							//END CREO UNA NUOVA ISTANZA DELLA MAPPA
							
							//AGGIUNGO IN SESSIONE applicationParametersMap per passare i parametri alle applicazioni chiamanti
							for(Map.Entry<String, List<Map<String, String>>> outer:_applicationParametersMap.entrySet()){
								for(Map<String, String> inner:outer.getValue()){
									for(Entry<String, String> inner2:inner.entrySet()){
										if(!isEmpty(context.getQueryStringParameter(inner2.getKey()))){
											inner2.setValue(context.getQueryStringParameter(inner2.getKey()));
										}
									}
								}
							}
							
							ContextHelper.setSessionModel(CommonSessionAttributes.APPLICATION_PARAMETERS_MAP, _applicationParametersMap, request);
						}
						
						//INIZIALIZZAZIONE MENU
						initMenu(request);						
						
						//NAVIGATOR
						initNavigator(request);
						
						if(!isEmpty(request.getParameter(CommonSessionAttributes.REQUEST_URI_DEST))){
							//elaboro il valore di REQUEST_URI_DEST
							String requestUriDest=request.getParameter(CommonSessionAttributes.REQUEST_URI_DEST);
							requestUriDest=requestUriDest.replaceAll(request.getContextPath(), "");
							requestUriDest=requestUriDest.replaceAll("/", "");
							return CommonConstantsRequestMapping.REDIRECT +"/"+requestUriDest;
						}
						
						view = "gestioneMenuView";
						
					} else {
						context.addError("error.userNotAllowed");
						view = "errorView";
					}
				} else {
					context.addError("error.userUnknown");
					view = "errorView";
				}
			} else {
				context.addError("error.applicativo");
				view = "errorView";
			}*/
			return view;
		}

	private void initMenu(HttpServletRequest request) throws Throwable {
		List<MenuTO> menuList = getAdministratorManager().loadAllMenu();
		Map<String, MenuTO> menuMap = new HashMap<String, MenuTO>();
		
		if (!isEmpty(menuList)) {
			Map<String, String> descCodimenuMap = new HashMap<String, String>();
			
			for (MenuTO menuTO : menuList) {
				menuTO.buildProfiloList();
				menuMap.put(menuTO.getCodiMenu(), menuTO);
				
				if(!isEmpty(menuTO.getDescCodiMenu())){
					descCodimenuMap.put(menuTO.getCodiMenu(), menuTO.getDescCodiMenu());
				}
			}
			
			request.getSession().setAttribute(CommonSessionAttributes.DESC_CODI_MENU_MAP, descCodimenuMap);
			
		}
		
		request.getSession().setAttribute(CommonSessionAttributes.MAP_MENU, menuMap);
		
		if (loadMenuFromDb && !isEmpty(getApplicationCode())) {
			Utente utente=getUtenteInSessione();
	
			//carico menu
			menuList = menuManager.loadMenuByCodiMenu(getApplicationCode(), utente.getProfiloInUso().getId().toString());
			
			if(!isEmpty(menuList)){
				request.getSession().setAttribute(CommonSessionAttributes.LIST_MENU, menuList);
			}
			
		}
		
	}

	private void initNavigator(HttpServletRequest request) throws Exception{
			NTree tree= null;
			
	//		if(!loadNavigatorFromDb || isEmpty(applicationCode)){
	//			tree= NTree.getFromXML("navigator.xml");
	//		}else if(loadNavigatorFromDb && !isEmpty(applicationCode)){
				
				@SuppressWarnings("unchecked")
				Map<String, MenuTO> menuMap =(Map<String, MenuTO>)request.getSession().getAttribute(CommonSessionAttributes.MAP_MENU);
				MenuTO menu = menuMap.get(getApplicationCode());
				
				Utente utente=getUtenteInSessione();
	
				if (menu.checkPermission(utente.getProfiloInUso().getCodiProfilo())) {
	
					//costruisco il navigator
					tree=new NTree();
					
					//node application
					NLink root = new NLink(getApplicationCode(), null, null, tree);
					
						//node menu
	//					NLink nodeMenu = new NLink("menu", applicationCode.toUpperCase(), "menu.do");
						NLink nodeMenu = new NLink("menu", "Home", "private/menu.do");
					
						nodeMenu.setParent(root);
					
						nodeMenu.setId(nodeMenu.getAbsoluteId());
							
							//items
							setParentChain(root, nodeMenu, menu.getItemList());
							//end items
							
						//end node menu
				
					root.addChild(nodeMenu);
					//end node application
					
					root.clone(tree);				
					
				}
				
	//		}
			ContextHelper.setSessionModel(NAVIGATOR, tree, request);
		}

	//	private void setParentChain(NLink root, NLink parent, List<ItemTO> itemList){
	//		for(ItemTO item:itemList){
	//			
	//			NLink n=null;
	//			
	//			if(item.getItemList()!=null&&item.getItemList().size()>0){
	//				n=new NLink(item.getCodiItem(), item.getDescItem(), (item.getAction()!=null?item.getAction().getCodiAction()+".do":null)/*item.getCodiItem()*/);
	//			}else{
	//				n=new NLink(item.getCodiItem(), item.getDescItem(), null);
	//			}
	//			
	//			n.setParent(parent);
	//			n.setId(n.getAbsoluteId());
	//			
	//			parent.addChild(n);
	//			
	//			if(item.getItemList()!=null&&item.getItemList().size()>0){
	//				setParentChain(root, n, item.getItemList());
	//			}
	//		}
	//	}
		
		private void setParentChain(NLink root, NLink parent, List<ItemTO> itemList){
			for(ItemTO item:itemList){
				
				NLink n=null;
				
				if(item.getItemList()!=null&&item.getItemList().size()>0){
					setParentChain(root, parent, item.getItemList());
				}else{
					n=new NLink(item.getCodiItem(), item.getDescItem(), null);
					n.setParent(parent);
					n.setId(n.getAbsoluteId());
					
					parent.addChild(n);
				}
				
				
			}
		} 

	
	
	
//	private void setParentChain(NLink root, NLink parent, List<ItemTO> itemList){
//		for(ItemTO item:itemList){
//			
//			NLink n=null;
//			
//			if(item.getItemList()!=null&&item.getItemList().size()>0){
//				n=new NLink(item.getCodiItem(), item.getDescItem(), (item.getAction()!=null?item.getAction().getCodiAction()+".do":null)/*item.getCodiItem()*/);
//			}else{
//				n=new NLink(item.getCodiItem(), item.getDescItem(), null);
//			}
//			
//			n.setParent(parent);
//			n.setId(n.getAbsoluteId());
//			
//			parent.addChild(n);
//			
//			if(item.getItemList()!=null&&item.getItemList().size()>0){
//				setParentChain(root, n, item.getItemList());
//			}
//		}
//	}

}
