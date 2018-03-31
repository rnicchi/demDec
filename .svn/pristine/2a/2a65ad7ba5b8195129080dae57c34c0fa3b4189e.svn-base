package it.almavivaitalia.web.sh.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.to.ActionTO;
import it.almavivaitalia.bsn.sh.manager.exception.DuplicateKeyException;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.almavivaitalia.web.sh.form.AbstractForm;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.almavivaitalia.web.sh.utils.MethodMapping;
import it.almavivaitalia.web.sh.utils.WebConstants;
import it.almavivaitalia.web.sh.utils.navigator.NLink;
import it.almavivaitalia.web.sh.utils.navigator.NTree;
import it.almavivaitalia.web.sh.validator.Validator;
import it.almavivaitalia.bilancio.commons.web.security.Utente;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//@Controller
public abstract class AbstractFormParentController extends AbstractFormGrandParentController implements BaseSessionAttributes{

	private Validator validator;
	
	protected boolean checkPermission(HttpServletRequest request, String methodName) throws Throwable{
		boolean res = true;
		// SCOMMENTARE QUANDO SIA STATA IMPLEMENTATA LA SICUREZZA
		if (getMethodMappings()!=null){
			MethodMapping mm = getMethodMappingMap().get(methodName);
			if ((mm!=null)&&(!isEmpty(mm.getCodeAction()))){
				ActionTO action = new ActionTO();
				action.setCodiAction(mm.getCodeAction());
				//UtenteTO user = (UtenteTO)ContextHelper.getModel(OBJECT_USER, request);
				Utente user = getUtenteInSessione();
				if(user.getProfiloInUso().getActionList()!=null&&user.getProfiloInUso().getActionList().size()>0){
					for(ActionTO x:user.getProfiloInUso().getActionList()){
						if(res=x.getCodiAction().equals(mm.getCodeAction())){
							break;
						}
					}
				}
			}
		}	
		return res;
	}

	protected String decodeActionMethodName(String controllerCode, String defaultMethodName) throws Throwable{
		String methodName=null;
		if (controllerCode==null){
			methodName=defaultMethodName;
		}else {
			try {
				methodName=getControllerCodeMappingMap().get(controllerCode).getMethodName();
			}catch (Exception e) {
				throw new Exception("No method name configured under key "+controllerCode);
			}
		}
		return methodName;
	}

	protected boolean executeValidationMethod(Validator validator, String methodName, Context context) throws Throwable{
		boolean res = true;
		
		Method method=validator.getClass().getMethod(methodName, new Class[]{Context.class});
		res = (Boolean)method.invoke(validator, new Object[]{context});
		
		return res;
	}

	protected String getExceptionView(Throwable th, HttpServletRequest request){
		String view= null; 
		if (th instanceof SecurityException){
		   	ContextHelper.addError(request,"error.actionNotAllowed");
			view = (String)ContextHelper.getModel(PREV_VIEW, request);
		}else if (th instanceof DuplicateKeyException){
			ContextHelper.addError(request,"error.duplicateKey");
			view = (String)ContextHelper.getModel(PREV_VIEW, request);
		}else{
			TraceLogger.errorLog(th.getMessage(), AbstractFormController.class, th);
			ContextHelper.addError(request, "error.applicativo.dettaglio", th.toString());
			view = "errorView";
		}
		return view;
	}



	protected String getPreviousView(Context context){
	return (String) context.getModel(PREV_VIEW);
	}

	//public abstract String onInit(Context context) throws Throwable;
		
	//	public abstract String startController(Context context) throws Throwable;
		
		protected void updateNavigatorList(HttpServletRequest request){
			NLink currentNode = (NLink)ContextHelper.getModel(NODE_NAVIGATOR_CURRENT, request);
			if (currentNode!=null){
				NTree navigator = (NTree)ContextHelper.getModel(NAVIGATOR, request);
		 		List<NLink> nodes = navigator.getNodePath(currentNode.getId());
		 		for (NLink nLink : nodes) {
		 			try {
		 				if(isEmpty(nLink.getLabel())){
		 					String label =getMessageSource().getMessage("node."+nLink.getId(), nLink.getLabelParams());
		 					nLink.setLabel(label);
		 				}
					} catch (Exception e) {
						nLink.setLabel("Label not Found!!!");
					} 	 			
				}
		 		ContextHelper.setDataModel(LIST_NODE_NAVIGATOR, nodes, request);
			}
		}
	
		public final boolean validate(String methodName, Context context) throws Throwable{
			if (getValidator()!=null){
				MethodMapping mm = getMethodMappingMap().get(methodName);
				return	(mm==null)	||
						( (mm!=null) && (!mm.isToValidate()) ) ||
						( (mm!=null) && mm.isToValidate() && executeValidationMethod(getValidator(), methodName, context));
			}else {
				return true;
			}
		}

		
		

		//Metodo che si attiva al click su uno degli elementi sensibili (num di pag, 
			//pag precedente/successiva, gruppo precedente/successivo) relativi alla paginazione
			@SuppressWarnings("rawtypes")
			public String onPaginator(Context context) throws Throwable
			{ 
				Enumeration pippo = context.getRequest().getParameterNames();
				String paramNames = "";
				while (pippo.hasMoreElements()){
					paramNames = (String)pippo.nextElement(); 
					if (paramNames.indexOf(context.getControllerCode())> -1){
						break;
					}
				}
					
				
				StringTokenizer token = new StringTokenizer(paramNames, "?");
				token.nextToken();
				String page = context.getRequest().getParameter(paramNames);
				String paginatorName = token.nextToken(); 
				Paginator paginator = context.getModel(paginatorName);
		//		Paginator paginator = context.getModel(OBJECT_PAGINATOR);
				if (page.equals(getMessageSource().getMessage("paginator.keyBackValue")))
				{
					paginator.setCurrentPage(paginator.getCurrentPage()-1);
				}
				else if (page.equals(getMessageSource().getMessage("paginator.keyNextValue")))
				{
					paginator.setCurrentPage(paginator.getCurrentPage()+1);
				}
				else if (page.equals(getMessageSource().getMessage("paginator.keyBackRangeValue")))
				{
					paginator.setPrevPageRange();
				}
				else if (page.equals(getMessageSource().getMessage("paginator.keyNextRangeValue")))
				{
					paginator.setNextPageRange();
				}
				else 
				{
					paginator.setCurrentPage(Integer.parseInt(page)-1);
				}
				context.setDataModel(paginator.getNameSessionList(), paginator.update());
				return getPreviousView(context);
			}

		//Metodo che si attiva agendo sul tasto posto in fondo alla tabella
			//delle pagine per gestire la paginazione
			@SuppressWarnings("rawtypes")
			public String onEnableDisablePagin(Context context) throws Throwable {
		
				Enumeration pippo = context.getRequest().getParameterNames();
				String paramNames = "";
				while (pippo.hasMoreElements()){
					paramNames = (String)pippo.nextElement(); 
					if (paramNames.indexOf(context.getControllerCode())> -1){
						break;
					}
				}
					
				
				StringTokenizer token = new StringTokenizer(paramNames, "?");
				token.nextToken();
				String paginatorName = token.nextToken(); 
				Paginator paginator = context.getModel(paginatorName);
		//		Paginator paginator = context.getModel(OBJECT_PAGINATOR);
				if (	paginator != null
						&& paginator instanceof Paginator
					)
				{
					if (	paginator.getPaginationEnabled() != null
							&& paginator.getPaginationEnabled().booleanValue()
						)
					{
						paginator.setPaginationEnabled(Boolean.FALSE);
					}
					else
					{
						paginator.setPaginationEnabled(Boolean.TRUE);
					}	
					
					context.setDataModel(paginator.getNameSessionList(), paginator.update());
				}	
				
				return getPreviousView(context);
			}
			
			public Utente getUtenteInSessione() {
		        SecurityContext securityContext = SecurityContextHolder.getContext();

		        Utente user = null;
		        if (securityContext != null && securityContext.getAuthentication() != null) {
		            user = (Utente) securityContext.getAuthentication().getPrincipal();
		        }

//		        if(_LOG.isDebugEnabled() && user!=null){
//		            _LOG.debug("Utente in sessione: " + user.getUsername());
//		        }
		        
		        return user;

			}
			
			public Validator getValidator() {
				return validator;
			}
			

			public final void setValidator(Validator validator) {
				this.validator = validator;
			}


}
