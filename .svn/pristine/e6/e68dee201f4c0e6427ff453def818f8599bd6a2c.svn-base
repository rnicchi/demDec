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
@Controller
public abstract class AbstractFormController  extends AbstractFormParentController implements BaseSessionAttributes{

	
	
	
	@ModelAttribute(FORM)
	public AbstractForm createNewFormObject() throws Throwable{
		if (getFormObjectClass()!=null){
			return getFormObjectClass().newInstance();
		}else {
			return null;
		}
		
	}

	public AbstractForm getFormModel(ModelMap model) throws Throwable{
		Object form = model.get(FORM);
		if (form!=null){
			return (AbstractForm)form; 
		}else {
			return null;
		}
		
	}
	
	
	
	private static String getControllerCode(String param, String prefix) throws Throwable{
		String keyMethod =param.substring(param.indexOf(prefix)+prefix.length(),param.length());
		// image button
		//inserito da spring automaticamente
		if (param.endsWith(".x")||param.endsWith(".y")){
			keyMethod=keyMethod.substring(0, keyMethod.length()-2);
			
		}
		
		//se ho aggiunto un parametro nel bottone
		if(keyMethod.contains(WebConstants.P_INTERROGATIVO)){
			keyMethod=keyMethod.substring(0, keyMethod.indexOf(WebConstants.P_INTERROGATIVO));
		}
		return keyMethod;
	}
	
	
	protected String executeActionMethod(String methodName, HttpServletRequest request, HttpServletResponse response,Context context) 
	throws Throwable{
		return executeActionMethod( methodName,  context);
	}

	private String executeActionMethod(String methodName, Context context) throws Throwable{
		Method method=null;
		try {
			method=getClass().getMethod(methodName, new Class[]{Context.class});
		}catch (Exception e) {
			throw new Exception("No method found with name "+methodName);
		}
		String res = null;
		try {
			res = (String)method.invoke(this, new Object[]{context});
		}catch (InvocationTargetException e) {
			throw(e.getTargetException());
		}	
		
		return res;
	}

	

	
	private static void enableValidationForNextRequest(HttpServletRequest request){
		ContextHelper.setDataModel(FLAG_IGNORE_VALIDATION, new Boolean(false), request);
	}
	
	private static boolean isIgnoreValidation(HttpServletRequest request){
		Object ignore = ContextHelper.getModel(FLAG_IGNORE_VALIDATION, request);
		return (ignore!=null)&&((Boolean)ignore);
	}		
	@SuppressWarnings("unchecked")
	private String decodeControllerCode(HttpServletRequest request, boolean post) throws Throwable{
		String prefix =post?COMMAND_BUTTON_PREFIX_POST:COMMAND_BUTTON_PREFIX_GET;
		String controllerCode = null;
		for (Enumeration<String> en = request.getParameterNames(); en.hasMoreElements();){
			String param = en.nextElement();
			if (param.startsWith(prefix)){
				controllerCode = getControllerCode(param, prefix);
				break;
			}
		}		
		return controllerCode;
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Throwable{
		setUserNameInLog(request);
		
		if(!StringUtil.isEmpty(request.getParameter(BaseSessionAttributes.SAVE_VIEW_FOR_SELECTOR))){
			ContextHelper.setSessionModel(PREV_VIEW_FOR_SELECTOR,request.getSession().getAttribute(PREV_VIEW),request);
		}
		
		String view = null;
		
		try {
			ContextHelper.setSessionModel(IGNORE_VIEW_CACHING, new Boolean(false),request);
			if(checkEnabled(request)){
				// controller Code
				String controllerCode = decodeControllerCode(request, true);
				// method name
				String methodName = decodeActionMethodName(controllerCode, DEFAULT_POST_FORM_CONTROLLER_METHOD_NAME);
				
				if (checkPermission(request, methodName)){
					Context context =null;
					// form binding
					AbstractForm form = getFormModel(model);
					if (form!=null){
						ServletRequestDataBinder binder = new ServletRequestDataBinder(form);
						binder.bind(request);
						context = new Context(request, response, form, controllerCode, getItemSelectorRequest());
						// validation
						boolean isFormValid=true;
						if (isIgnoreValidation(request)){
							enableValidationForNextRequest(request);
						}else {
							isFormValid=validate(methodName, context);
						}
						form.setValid(isFormValid);
					}else {
						context = new Context(request, response, null, controllerCode, getItemSelectorRequest());
					}
					view=executeActionMethod(methodName, request, response, context);
					updateNavigatorList(request);
				}else {
					throw new SecurityException();
				}
			}else {
				view=(String)ContextHelper.getModel(PREV_VIEW, request);
			}
		}catch (Throwable th) {
			view=getExceptionView(th, request);
			request.setAttribute(ERROR_PAGE_STATUS, "1");
		}
		if (view!=null){
			Object ignoreViewCaching = ContextHelper.getModel(IGNORE_VIEW_CACHING, request);
			if ((ignoreViewCaching==null) || (!(Boolean)ignoreViewCaching)){
				ContextHelper.setSessionModel(PREV_VIEW, view, request);
				
				ContextHelper.setSessionModel(	OBJECT_INCOMING_REQUEST_URI, 
											(request.getRequestURI()).substring((request.getRequestURI()).lastIndexOf("/")),
											request);
			}
		}
		return view;
		
	}
	
	public String onSubmit(Context context) throws Throwable{
		boolean b = true;
		if (b) throw new Exception("you must override onSubmit");
		return null;
	}


	// abilita la request
	protected abstract boolean checkEnabled(HttpServletRequest request) throws Throwable;
	
	@RequestMapping(method = RequestMethod.GET)
	public String onInit(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Throwable{
		setUserNameInLog(request);
		String view = null;
		try 
		{		
			ContextHelper.setSessionModel(IGNORE_VIEW_CACHING, new Boolean(false),request);
			if(checkEnabled(request)){	
				String helpBackParameter = request.getParameter(COMMAND_BACK_HELP_PARAMETER);
				Boolean backFromSelector=(Boolean)request.getSession().getAttribute(BACK_FROM_SELECTOR);
				
				if (!isEmpty(helpBackParameter) || (!isEmpty(backFromSelector) && backFromSelector)){
					
					request.getSession().removeAttribute(BACK_FROM_SELECTOR);
					
					Object oldForm = ContextHelper.getModel(FORM_CACHED, request);
					ContextHelper.removeDataModel(FORM_CACHED, request);
					
					if (oldForm!=null){
						model.put(FORM, oldForm);
					}
					
					view=(String)ContextHelper.getModel(VIEW_CACHED, request);
					
				}
				else {
					String methodName = request.getParameter(COMMAND_BACK_SELECTOR_REQUEST_PARAMETER);
					
					if(isEmpty(methodName)){
						methodName =(String) request.getSession().getAttribute(COMMAND_BACK_SELECTOR_CONTEXT_ATTRIBUTE);
						request.getSession().removeAttribute(COMMAND_BACK_SELECTOR_CONTEXT_ATTRIBUTE);
					}
										
					// elimina eventuali ancore #
					if (methodName!=null){
						int pos = methodName.indexOf("#");
						if (pos>=0){
							methodName=methodName.substring(0, pos);
						}
					}
					
					String controllerCode=null;
	
					if (!isEmpty(methodName)){
						Object oldForm = ContextHelper.getModel(FORM_CACHED, request);
						ContextHelper.removeDataModel(FORM_CACHED, request);
						if (oldForm!=null){
							model.put(FORM, oldForm);
						}
					}
					else {
						// controller Code
						controllerCode = decodeControllerCode(request, false);
					
						// method name
						methodName = decodeActionMethodName(controllerCode, DEFAULT_GET_FORM_CONTROLLER_METHOD_NAME);
					}
				
					if (checkPermission(request, methodName)){
						AbstractForm form = getFormModel(model);
						if (form!=null){
							form.setValid(true);	
						}
	
						Context context = new Context(request, response, form, controllerCode, getItemSelectorRequest());
	
						view= executeActionMethod(methodName,request,response, context);
						updateNavigatorList(request);
					}
					else {
						throw new SecurityException(getMessageSource().getMessage("error.actionNotAllowed"));
					}
				}
			}
			else {
				view=(String)ContextHelper.getModel(PREV_VIEW, request);
			}
		}catch (Throwable th) {
			view=getExceptionView(th, request);
		}
		if (view!=null){
			
			Object ignoreViewCaching = ContextHelper.getModel(IGNORE_VIEW_CACHING, request);
			if ((ignoreViewCaching==null) || (!(Boolean)ignoreViewCaching)){
			
				ContextHelper.setSessionModel(PREV_VIEW, view, request);
			
				ContextHelper.setSessionModel(	OBJECT_INCOMING_REQUEST_URI, 
										(request.getRequestURI()).substring((request.getRequestURI()).lastIndexOf("/")),
										request);
			}
		}
		return view;		
	}
	
	
	//public abstract String onInit(Context context) throws Throwable;
	
	protected abstract void setUserNameInLog(HttpServletRequest request);		
	public abstract String startController(Context context) throws Throwable;
	

}
