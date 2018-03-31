package it.almavivaitalia.bilancio.commons.web.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.getClassName;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.manager.DownloadFileManager;
import it.almavivaitalia.bilancio.commons.to.MenuTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.bilancio.commons.web.utils.CommonWebConstants;
import it.almavivaitalia.web.sh.spring.controller.AbstractFormAdminController;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
public abstract class AbstractCommonFormAdminController extends AbstractFormAdminController implements CommonConstantsRequestMapping {

	
	private DownloadFileManager downloadFileManager;
	private String applicationName;
	
	public DownloadFileManager getDownloadFileManager() 
	{	return downloadFileManager;	}
	public void setDownloadFileManager(DownloadFileManager downloadFileManager) 
	{	this.downloadFileManager = downloadFileManager; }
	
	
	
	public String getApplicationName() 
	{	return applicationName;	}
	public void setApplicationName(String applicationName) 
	{	this.applicationName = applicationName;	}	
	
	
	@Override
	protected void setUserNameInLog(HttpServletRequest request) {
		Utente o = getUtenteInSessione();
		if (!isEmpty(o)) {
			//UtenteTO utente = (UtenteTO) o;
			MDC.put("userName", o.getUtente().getCodiUtente());
		}
	}
	

	public String onHelp(Context context)throws Throwable 
	{	String out = null;
		
		if (	context.getModel(BaseSessionAttributes.FLAG_IS_NEW_HELP_VERSION) != null
				&& ((Boolean)context.getModel(BaseSessionAttributes.FLAG_IS_NEW_HELP_VERSION)).compareTo(new Boolean(true)) == 0
			) 
		{	
			//out = "redirect:/newHelp.do";
			out = "redirect:" + CommonConstantsRequestMapping.NEW_HELP_URL;
			String code = getClassName(this);
			 
			context.setDataModel(BaseSessionAttributes.OBJECT_HELP_CODE_KEY, code);
			context.setDataModel(BaseSessionAttributes.OBJECT_HELP_VIEW, "helpView");
			context.setDataModel(BaseSessionAttributes.OBJECT_HELP_BACK_URI, context.getModel(OBJECT_INCOMING_REQUEST_URI));
			context.setDataModel(VIEW_CACHED, getPreviousView(context));
			
			Object form = context.getForm();
			if (form != null){	
				context.setDataModel(BaseSessionAttributes.FORM_CACHED, form); 
			}
		}
		else
		{	
			//out = "redirect:/help.do";
			out = "redirect:" + CommonConstantsRequestMapping.HELP_URL;
			String str;
		
			try
			{	str = getMessageSource().getMessage(getClassName(this));
	
				context.setDataModel(BaseSessionAttributes.OBJECT_HELP_VIEW, str);
				context.setDataModel(BaseSessionAttributes.OBJECT_HELP_BACK_URI, context.getModel(OBJECT_INCOMING_REQUEST_URI));
				context.setDataModel(VIEW_CACHED, getPreviousView(context));
	
				Object form = context.getForm();
				if (form != null){	
					context.setDataModel(BaseSessionAttributes.FORM_CACHED, form);
				}
			}
			catch(Exception e)
			{	str = null;	
				out = (String)context.getModel(PREV_VIEW);
				context.addError("help.error.pageNotPresent");
			}
			
		}	
		return out;

	}	
	
	
	public String onRichiestaManuale(Context context)throws Throwable 
	{	
		String view = null;
		if (	context.getModel(BaseSessionAttributes.FLAG_IS_NEW_HELP_VERSION) != null
				&& ((Boolean)context.getModel(BaseSessionAttributes.FLAG_IS_NEW_HELP_VERSION)).compareTo(new Boolean(true)) == 0
			)
		{ 
			//view = "redirect: /newHelpManual.do";
			view = "redirect:" + CommonConstantsRequestMapping.NEW_HELP_MANUAL_URL;
		}
		else
		{	
			String nomeFile="Manuale" + applicationName + ".pdf";
			context.setResponseContentType("application/pdf", nomeFile);	
			downloadFileManager.downloadFile(nomeFile, context.getOutputStream());
		}
		
		return view;
	}		

	protected List<String> getMethodMappings(){
		return super.getMethodMappings();
	}

	@Override
	public void init() {
		getMethodMappings().add("onHelp#help##false");
		getMethodMappings().add("onRichiestaManuale#richiestaManuale##false");
		getMethodMappings().add("onSelector#selector##false");
		super.init();
	}
	//MENU CONTROLLER 
	@Override
	protected boolean checkEnabled(HttpServletRequest request) throws Throwable {
		return true;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public String onMenuSelected(HttpServletRequest request,
			HttpServletResponse response, Context sbfjContext) throws Throwable {
		Map<String, MenuTO> menuMap = (Map<String, MenuTO>) sbfjContext.getModel(CommonSessionAttributes.MAP_MENU);
		String menuSelected = sbfjContext.getCommandParameter(CommonWebConstants.PARAMETER_MENU_MENU_SELECTED);
		MenuTO menu = menuMap.get(menuSelected.toLowerCase());
		Utente utente = getUtenteInSessione();

		if (menu.checkPermission(utente.getProfiloInUso().getCodiProfilo())) {
			sbfjContext.setDataModel(CommonSessionAttributes.OBJECT_MENU, menu);
		}
		return "menuView";
	}
	
	protected String getText(String codiItem, String descItem){
		String text="Label not Found!!!";
		try{
			text=descItem==null?getMessageSource().getMessage("item."+codiItem):descItem;
		}catch(Throwable thr){
			//thr.printStackTrace();
		}
		return text;
	}
	//MENU CONTROLLER END
	
}
