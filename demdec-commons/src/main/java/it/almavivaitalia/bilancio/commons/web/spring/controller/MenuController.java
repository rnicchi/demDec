package it.almavivaitalia.bilancio.commons.web.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.ParseUtil.getLong;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.manager.MenuManager;
import it.almavivaitalia.bilancio.commons.to.ItemTO;
import it.almavivaitalia.bilancio.commons.to.MenuTO;
import it.almavivaitalia.bilancio.commons.utils.StringUtil;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.bilancio.commons.web.utils.CommonWebConstants;
import it.almavivaitalia.bsn.sh.utils.TableMap;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.almavivaitalia.bilancio.commons.web.security.Utente;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping(value = CommonConstantsRequestMapping.MENU_SBFJ)
public class MenuController extends AbstractCommonFormAdminController {
	private MenuManager menuManager; 
	
	@SuppressWarnings("unused")
	private TableMap codiActionScenarioMap;
	private String constantsClassName;
	private String applicationCode;
	
	public void setMenuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
	}
	
	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public void setConstantsClassName(String constantsClassName) {
		this.constantsClassName = constantsClassName;
	}

	public void setCodiActionScenarioMap(TableMap codiActionScenarioMap) {
		this.codiActionScenarioMap = codiActionScenarioMap;
	}

	

	private String getCurrentNode(){
		return (applicationCode==null?"sbfj":applicationCode)+".menu";
	}
	
	

	
	
	public String onMenuExtSelected(HttpServletRequest request, HttpServletResponse response, Context context) throws Throwable {
		
		ContextHelper.clearDataTable(request);
		
		context.setDataModel(OBJECT_ANCHOR, CommonWebConstants.ANCHOR_START_TITOLO);

		String actionSelected = context.getCommandParameter(CommonWebConstants.PARAMETER_MENU_EXT_MENU_SELECTED);
		
		Utente utente = getUtenteInSessione();
		
		//verifico se l'utente è abilitato ad effettuare l'operazione richiesta
		if(!menuManager.isUserEnabled(actionSelected, utente.getProfiloInUso().getId().toString())){
			context.addError("error.functionNotAllowed", new String[]{});
			return "menuView";
		}
		
		context.setDataModel(CommonWebConstants.ACTION_SELECTED, actionSelected);
		
		actionSelected=StringUtil.camelCaseTranslater(actionSelected.toLowerCase());
		
		StringBuilder actionUrl=new StringBuilder();
		
		//actionUrl.append(StringUtil.fieldValue(constantsClassName, actionSelected));
		actionUrl.append(REDIRECT_URL);
		
		if(actionUrl.indexOf(CommonSessionAttributes.P_INTERROGATIVO)!=-1){
			actionUrl.append(CommonSessionAttributes.E_COMMERCIALE);
		}else{
			actionUrl.append(CommonSessionAttributes.P_INTERROGATIVO);
		}
		actionUrl.append(CommonSessionAttributes.APPLICATION_CODE+ CommonSessionAttributes.UGUALE+getApplicationCode());
		
		String requestUriSrc=request.getRequestURI();
		
		actionUrl.append(CommonSessionAttributes.E_COMMERCIALE + CommonSessionAttributes.REQUEST_URI_SRC + CommonSessionAttributes.UGUALE+requestUriSrc);
		
		return REDIRECT + actionUrl;
	}
	
	public String onItemSelected(HttpServletRequest request,
			HttpServletResponse response, Context sbfjContext) throws Throwable {
		
		ItemTO item = null;
		MenuTO menu = sbfjContext.getModel(CommonSessionAttributes.OBJECT_MENU);

		Long selectedItemId = getLong(sbfjContext.getCommandParameter(CommonWebConstants.PARAMETER_MENU_ITEM_SELECTED));
		if(selectedItemId == null)
		{	
			selectedItemId = getLong(request.getAttribute(CommonSessionAttributes.ID_ITEM_FROM_SUB_ITEM));
			request.removeAttribute(CommonSessionAttributes.ID_ITEM_FROM_SUB_ITEM);
			
			if (selectedItemId == null)
			{
				selectedItemId = getLong(ContextHelper.getModel(CommonSessionAttributes.OBJECT_SELECTED_ITEM_ID, request));
			}	
		}	
		
		
		if (!isEmpty(selectedItemId)) 
		{
			for (Iterator<ItemTO> iterator = menu.getItemList().iterator(); iterator.hasNext();) 
			{
				item = (ItemTO) iterator.next();
				if (item.getId().equals(selectedItemId)) 
				{
					ContextHelper.setSessionModel(	CommonSessionAttributes.OBJECT_SELECTED_ITEM_ID,
													item.getId(), 
													request
												);
					
					ContextHelper.setSessionModel(	CommonSessionAttributes.OBJ_SELECTED_CODI_ITEM_I_LEV,
													item.getCodiItem(), 
													request
												);
					
					if (!isEmpty(item.getItemList())) 
					{	//Con la gestione dell'Apertura/Chiusura delle voci di menu,
						//cliccando su una voce di primo livello occorre resettare
						//eventuali Aperture fatte sulla stessa voce in precedenza,
						//in modo da presentare solo le voci di menu di secondo livello.
						//Allo scopo si invoca il metodo elaboraVoceMenu() passando 
						//come II argomento (che rappresenta l'id della voce di menu
						//da aprire/chiudere) un valore negativo, ovvero un id
						//inesistente.
						//NB: Valutare se mantenere l'invocazione in caso
						//si voglia una gestione del menu con 'MEMORIA'
						elaboraVoceMenu(item, new Long(-999), CommonWebConstants.PARAMETER_MENU_ITEM_SELECTED, null, new Long(-999), false, sbfjContext);
						
						ContextHelper.setSessionModel(	CommonSessionAttributes.LIST_MENU_ITEM,
														item.getItemList(), 
														request
													);
					}

					sbfjContext.setCurrentNodeWithUri(	getCurrentNode()+"." + item.getCodiItem(),
														sbfjContext.buildUri(CommonConstantsRequestMapping.MENU_SBFJ, CommonWebConstants.PARAMETER_MENU_ITEM_SELECTED, "" + selectedItemId),
														getText(item.getCodiItem(), item.getDescItem())
													 );
				}
			}
		}

		return "menuView";
	}
	
	/**************************************************************
	//INIZIO PARTE OK CON MEMORIA:
	//I due metodi seguenti, cosi' definiti, gestiscono l'apertura/chiusura delle voci di menu
	//con 'MEMORIA', nel senso che agendo (aprendo/chiudendo) su una voce di menu questa restera'
	//in tale stato finche' o non si agisce direttamente su di essa modificandolo, o non si
	//cambia definitivamente menu (selezionando un menu di primo livello - un cosiddetto
	//cerottone - che abbia figli e non un'action direttamente associata).
	@SuppressWarnings("unchecked")
	public String onSubItemSelected(HttpServletRequest request,	HttpServletResponse response, Context sbfjContext) throws Throwable 
	{
		List<ItemTO> listItem = (List<ItemTO>)ContextHelper.getModel(CommonSessionAttributes.LIST_MENU_ITEM, request);		
		Long selectedSubItemId = Util.getLong(sbfjContext.getCommandParameter(CommonWebConstants.PARAMETER_MENU_SUB_ITEM_SELECTED));

		for (Iterator<ItemTO> iterator = listItem.iterator(); iterator.hasNext();) 
		{
			//item di secondo livello 
			ItemTO item = (ItemTO) iterator.next();
			elaboraVoceMenu(item, selectedSubItemId, sbfjContext);
		}	
	
		return "menuView";
	}	
	
	
	
	private void elaboraVoceMenu(ItemTO item, Long selectedSubItemId, Context sbfjContext) throws Throwable 
	{
		if(	item.getId().compareTo(selectedSubItemId) == 0)
		{
			//reinserire e agire sui nodi di navigazione 
			//sbfjContext.setCurrentNodeWithUri(	getCurrentNode()+"." + item.getCodiItem(),
			//										sbfjContext.buildUri(CommonConstantsRequestMapping.MENU_SBFJ, "itemSelected", "" + selectedSubItemId),
			//										getMessageSource().getMessage("item." + item.getCodiItem())
			//								 );
			item.setShowChild(!item.isShowChild());
		}
		else
		{	if (	item.getItemList() != null	)
			{
				for ( ItemTO otherItem: item.getItemList() )
				{	
					elaboraVoceMenu(otherItem, selectedSubItemId, sbfjContext);
				}	
			}
		}
		
		return;
		
	}
	//FINE PARTE OK CON MEMORIA: 
	 *****************************************************************/	

	
	//Metodo che si attiva al click su una voce di menu di livello maggiore uguale a 2
	//e che non presenti un'action diretta bensi' un insieme di sottovoci di menu.
	@SuppressWarnings("unchecked")
	public String onSubItemSelected(HttpServletRequest request,	HttpServletResponse response, Context sbfjContext) throws Throwable 
	{
		//######################################################################################
		//##	INIZIO RECUPERO VALORI DI INTERESSE DALLA SESSION O DALLA REQUEST			  ##
		//######################################################################################
		//Nel seguito saranno reperite dalla sessione dati riferiti alla voce di menu di I livello 
		//selezionata in precedenza (sul metodo onItemSelected), item questo genitore di tutte le voci di menu
		//di livello maggiore-uguale a 2 gestite da questo metodo. Nel dettaglio avremo:
		//-- listItem, tutti gli item figli della voce di menu di I livello in questione;
		//-- codiItemEleFirstLev, codiItem della voce di menu di I livello in trattazione;
		//-- idItemEleFirstLev, id della voce di menu di I livello di interesse.  
		List<ItemTO> listItem = (List<ItemTO>)ContextHelper.getModel(CommonSessionAttributes.LIST_MENU_ITEM, request);		
		String codiItemEleFirstLev = ContextHelper.getModel(CommonSessionAttributes.OBJ_SELECTED_CODI_ITEM_I_LEV, request) != null?
											((String)ContextHelper.getModel(CommonSessionAttributes.OBJ_SELECTED_CODI_ITEM_I_LEV, request)).trim() :	
											null;
		Long idItemEleFirstLev = getLong(ContextHelper.getModel(CommonSessionAttributes.OBJECT_SELECTED_ITEM_ID, request));		

		//Valore del parametro subItemSelected passato dall'interfaccia web. Esso puo' assumere due forme:
		//-- o un numerico indicante l'id della voce di menu (di livello maggiore-uguale a 2) che si intende 
		//	 aprire/chiudere;
		//-- o, nel formato selectedSubItemId#forceOpen presentare due informazioni separate da '*'. Il primo,
		//	 'selectedSubItemId', rappresenta ancora l'id della voce di menu (di livello maggiore-uguale a 2) che 
		//	 si intende aprire/chiudere, il secondo invece ('forceOpen'), nel seguito dell'elaborazione,
		//	 permette di decidere forza l'apertura del nodo di interesse o, per esse, adottare il comportamento
		//	 di default (se il nodo e' chiuso si apre, se e' aperto si chiude).		
		String paraValu = sbfjContext.getCommandParameter(CommonWebConstants.PARAMETER_MENU_SUB_ITEM_SELECTED);
		Long selectedSubItemId = null;
		String forceOpen = "";
		StringTokenizer stkz = new StringTokenizer(paraValu, CommonSessionAttributes.STR_INTERPUNZIONE);
		int k = 0; 
		while (stkz.hasMoreTokens()) 
		{	
			if (k == 0)
			{
				selectedSubItemId = getLong(stkz.nextToken().trim()); 
			}	
			else if (k == 1)
			{	
				forceOpen = stkz.nextToken();
				forceOpen = forceOpen != null? forceOpen.trim() : "";
			}	
			k++;
		}		
		//######################################################################################
		//##	FINE RECUPERO VALORI DI INTERESSE DALLA SESSION O DALLA REQUEST			  	  ##
		//######################################################################################		
		
		
		
		//######################################################################################
		//##	INIZIO LOGICA ELABORAZIONE													  ##								
		//######################################################################################		
		if (	!isEmpty(selectedSubItemId)	)
		{
			//Aggiornando le 'briciole di pane', puo' capitare di associare a menu
			//di primo livello il codiAction 'subItemSelected' anziche' 'itemSelected'.
			//Ne cosegue che agendo poi sulla voce delle 'briciole di pane' che referenzia
			//voce di menu di I livello si richiama questo metodo anziche' onItemSelected,
			//il che causa un'errato aggiornamento delle 'briciole di pane' stesse.
			//Avendo in sessione l'id della voce di primo livello, con il test a seguire
			//si evita l'inconveniente.
			if(		!isEmpty(idItemEleFirstLev)
					&& selectedSubItemId.compareTo(idItemEleFirstLev)==0
				)
			{
				//sbfjContext.setRequestModel(CommonWebConstants.PARAMETER_MENU_ITEM_SELECTED, selectedSubItemId);
				request.setAttribute(CommonSessionAttributes.ID_ITEM_FROM_SUB_ITEM, selectedSubItemId);
				return onItemSelected(request, response, sbfjContext);
			}	
				
	
			//Il boolean forzaAperturaNodo a seguire, nell'invocazione del metodo elaboraVoceMenu(),
			//permette di indicare se forzare l'apertura del nodo selezionato (caso true) o, per esso,
			//attuare la logica di default (se era chiuso si apre, se era aperto si chiude).
			//La decisione viene presa in base al valore di forceOpen recuperato dalla request
			boolean forzaAperturaNodo = (forceOpen.length() > 0 && forceOpen.equalsIgnoreCase(CommonSessionAttributes.FORCE_OPEN))? true : false; 
		
			for (Iterator<ItemTO> iterator = listItem.iterator(); iterator.hasNext();) 
			{	//item di secondo livello 
				ItemTO item = (ItemTO) iterator.next();
				elaboraVoceMenu(item, selectedSubItemId, CommonWebConstants.PARAMETER_MENU_SUB_ITEM_SELECTED, codiItemEleFirstLev, idItemEleFirstLev, forzaAperturaNodo, sbfjContext);
			}	
		}	
		else
		{
			sbfjContext.addError("error.generico", "impossibile determinare l&#39;id della voce di menu");
		}	
	
		return "menuView";
	}	
	
	
	/**
	 * Il metodo setta opportunamente il campo booleano showChild che, sull'interfaccia web, regola
	 * la visualizzazione (caso true) o meno (caso false) di eventuali nodi figli dell'elemento item
	 * passato come primo argomento. Il metodo cerca di settare anche le briciole di pane sfruttando
	 * i parametri di input codiAction e parentCodiItem. Nel caso in cui non si voglia agire in tal senso,
	 * e' sufficiente passare uno o entrambi dei suddetti parametri a null
	 * @param item, istanza di ItemTO da analizzare
	 * @param selectedSubItemId, id del nodo su cui si e' agito sull'interfaccia web
	 * @param codiAction, codiAction da sfruttare per settare le briciole di pane
	 * @param parentCodiItem, codiItem del nodo genitore da sfruttare per settare le briciole di pane
	 * @param parentIdItem, id del nodo genitore da sfruttare per settare le briciole di pane 
	 * 						(in fase di chiusura di un nodo) 
	 * @param forceOpen, booleano che se vale true forza l'apertura del un nodo di riferimento, altrimenti si
	 * 					 si agisce sullo stesso nodo secondo il comportamento di default (cambio stato rispetto
	 * 					 alla situazione precedente, cioe' se era chiuso si apre, se era aperto si chiude).		 
	 * @param sbfjContext, contesto
	 * @throws Throwable
	 */
	private void elaboraVoceMenu(ItemTO item, Long selectedSubItemId, String codiAction, String parentCodiItem, Long parentIdItem, boolean forceOpen, Context sbfjContext) throws Throwable 
	{
		if(	item.getId().compareTo(selectedSubItemId) == 0)
		{	//se forceOpen vale true si forza l'apertura del nodo di interesse
			//e si prosegue con l'analisi degli eventuali sotto-nodi.
			//In caso contrario invece si procede secondo la logica di default 
			//(si apre il nodo se era chiuso, ovvero si chiude se era aperto)
			//evitando di agire sui sottonodi in quanto in questo caso, 
			//venendo sicuramente dall'interfaccia del menu, si e' sicuri
			//che non si debb gestire la visualizzazione o meno di
			//eventuali nodi figli.
			if(forceOpen)
			{	
				item.setShowChild(forceOpen);
				
				if (	item.getItemList() != null	)
				{
					for ( ItemTO otherItem: item.getItemList() )
					{	
						elaboraVoceMenu(	otherItem, selectedSubItemId, codiAction
											, parentCodiItem + (item.getCodiItem()!=null? "."+item.getCodiItem().trim() : "")
											, item.getId()
											, forceOpen
											, sbfjContext
										);
			
					}	
				}
			}	
			else
			{
				item.setShowChild(!item.isShowChild());	
			}	

			
			//se dopo l'invocazione di setShowChild() item.isShowChild() = true,
			//significa che prima di tale set valeva false, ovvero si sta aprendo
			//una voce di menu. In tali casi occorre solo gestire le cosiddette 
			//'briciole di pane' (sempre che codiAction e parentCodiItem siano 
			//diversi da null).
			if(item.isShowChild())
			{	
				if (	codiAction != null
						&& parentCodiItem != null
					)
				{	
					sbfjContext.setCurrentNodeWithUri(	getCurrentNode()+"."+parentCodiItem+"." + item.getCodiItem(),
														sbfjContext.buildUri(CommonConstantsRequestMapping.MENU_SBFJ, codiAction, "" + selectedSubItemId + CommonSessionAttributes.STR_INTERPUNZIONE + CommonSessionAttributes.FORCE_OPEN),
														getText(item.getCodiItem(), item.getDescItem())
													 );
				}	
			}	
			//Begin reset reset 'MEMORIA' sui nodi figli in caso di chiusura di un elemento genitore.
			//Se dopo il set dovuto all'istruzione item.setShowChild(!item.isShowChild())
			//item.isShowChild() = false, significa che prima di tale set valeva true, ovvero si 
			//sta chiudendo una voce di menu. In tali casi, occorre resettare eventuali aperture/chiusure
			//fatte in precedenza su eventuali nodi figli, gestendo opportunamente le briciole di pane.
			//Il blocco sottostante implementa proprio questo.
			else
			{
				
				if (	codiAction != null
						&& parentCodiItem != null
					)
				{	
					sbfjContext.setCurrentNodeWithUri(	getCurrentNode()+"."+parentCodiItem,
														sbfjContext.buildUri(CommonConstantsRequestMapping.MENU_SBFJ, codiAction, "" + parentIdItem + CommonSessionAttributes.STR_INTERPUNZIONE + CommonSessionAttributes.FORCE_OPEN),
														getText(item.getCodiItem(), item.getDescItem())
													 );
				}				
				
				if (	item.getItemList() != null	)
				{
					for ( ItemTO otherItem: item.getItemList() )
					{	
						elaboraVoceMenu(	otherItem, selectedSubItemId, codiAction 
											, parentCodiItem + (item.getCodiItem()!=null? "."+item.getCodiItem().trim() : "")
											, item.getId()
											, forceOpen
											, sbfjContext
										);
					}	
				}
			}
			//End reset 'MEMORIA' sui nodi figli in caso di chiusura di un elemento genitore

		}
		else
		{	
			if (isParentNode(item, selectedSubItemId))
			{	item.setShowChild(true);	}
			else
			{	item.setShowChild(false);	}
			
			if (	item.getItemList() != null	)
			{
				for ( ItemTO otherItem: item.getItemList() )
				{	
					elaboraVoceMenu(	otherItem, selectedSubItemId, codiAction
										, parentCodiItem + (item.getCodiItem()!=null? "."+item.getCodiItem().trim() : "")
										, item.getId()
										, forceOpen
										, sbfjContext
									);

				}	
			}
		}
		
		return;
		
	}
	
	/**
	 * Il metodo permette di capire se il nodo candidateItem passato da input e' un
	 * genitore del nodo di id idChildNode passato come II argomento.
	 * @param candidateItem, ItemTO di cui si vuole verificare la 'paternita''
	 * 						del nodo il cui id e' rappresentato dal valore idChildNode 
	 * @param idChildNode, id del papabile nodo figlio
	 * @return true se candidateItem e' genitore del nodo con id idChildNode, false altrimenti
	 * @throws Throwable
	 */
	private boolean isParentNode(ItemTO candidateItem, Long idChildNode) throws Throwable
	{	boolean out = false;
		
		//Se il nodo e' una foglia non si entra nell'if seguente e si restituisce false
		//(possibile passo base della ricorsione), altrimenti si cicla sui figli e per 
		//ciasucuno di essi si verifica se trattasi del nodo figlio. In caso positivo
		//si restituisce true (altro possibile passo base), altrimenti si invoca
		//isParentNode passando come candidateItem il nodo in esame stesso.
	
		if (	candidateItem.getItemList() != null
				&& !candidateItem.getItemList().isEmpty()
			)
		{
			for (ItemTO item : candidateItem.getItemList())
			{
				if (item.getId().compareTo(idChildNode) == 0)
				{
					out = true;
					break;
				}	
				else
				{	
					return (out || isParentNode(item, idChildNode));
				}	
			}	
		}	
	
		return out;
	}


	
	public String onActionSelected(HttpServletRequest request,
			HttpServletResponse response, Context context) throws Throwable {
		ContextHelper.clearDataTable(request);
		context.setDataModel(OBJECT_ANCHOR, CommonWebConstants.ANCHOR_START_TITOLO);

		String actionSelected = context.getCommandParameter(CommonWebConstants.PARAMETER_MENU_ACTION_SELECTED);
		
		context.setDataModel(CommonWebConstants.ACTION_SELECTED, actionSelected);
		
		actionSelected=StringUtil.camelCaseTranslater(actionSelected);
		
		StringBuilder actionUrl=new StringBuilder();
		actionUrl.append(StringUtil.fieldValue(constantsClassName, actionSelected));

		if(actionUrl.indexOf(CommonSessionAttributes.P_INTERROGATIVO)!=-1){
			actionUrl.append(CommonSessionAttributes.E_COMMERCIALE);
		}else{
			actionUrl.append(CommonSessionAttributes.P_INTERROGATIVO);
		}
		actionUrl.append(CommonSessionAttributes.APPLICATION_CODE+ CommonSessionAttributes.UGUALE+getApplicationCode());
		
		String requestUriSrc=request.getRequestURI();
		
		actionUrl.append(CommonSessionAttributes.E_COMMERCIALE + CommonSessionAttributes.REQUEST_URI_SRC + CommonSessionAttributes.UGUALE+requestUriSrc);
		
		return REDIRECT + actionUrl;
	}

	
	@Override
	public String startController(HttpServletRequest request,
			HttpServletResponse response, Context context) throws Throwable {
		return onInit(request, response, context);
	}
	
	
	@SuppressWarnings("unchecked")
	public String onInit(HttpServletRequest request,
			HttpServletResponse response, Context sbfjContext) throws Throwable {
		
		sbfjContext.setCurrentNode(getCurrentNode());

		Map<String, MenuTO> menuMap = (Map<String, MenuTO>) sbfjContext.getModel(CommonSessionAttributes.MAP_MENU);
		MenuTO menu = menuMap.get(applicationCode==null?CommonWebConstants.MENU_SBFJ:applicationCode/*CommonWebConstants.MENU_SBFJ*/);
		request.getSession().removeAttribute(CommonSessionAttributes.OBJECT_SELECTED_ITEM_ID);
		request.getSession().removeAttribute(CommonSessionAttributes.OBJ_SELECTED_CODI_ITEM_I_LEV);
		request.getSession().removeAttribute(CommonSessionAttributes.LIST_MENU_ITEM);

		Utente utente = getUtenteInSessione();

		if (menu.checkPermission(utente.getProfiloInUso().getCodiProfilo())) {
			ContextHelper.setSessionModel(CommonSessionAttributes.OBJECT_MENU, menu, request);
		}

		return "menuView";
	}
	
	
}
