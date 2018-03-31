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
public abstract class AbstractFormGrandParentController implements BaseSessionAttributes{

	
	private List<String> methodMappings;
	private ResourceBundleMessageSource messageSource;
	private String itemSelectorRequest;
	private Map<String, MethodMapping> controllerCodeMappingMap;
	private Map<String, MethodMapping> methodMappingMap;
	private Class<AbstractForm> formObjectClass;
	
//	public List<String> getMethodMappings() {
//		return methodMappings;
//	}
	
	
	public void init(){
		
		// controllerCode#methodName#codeAction#validation(true/false)
		if (methodMappings!=null){
			controllerCodeMappingMap=new HashMap<String, MethodMapping>();
			methodMappingMap=new HashMap<String, MethodMapping>();
			for (String mapping : methodMappings) {
				String[] split = mapping.split("#");
				boolean toValidate = false;
				String methodName = split[0].trim();
				String controllerCode = null;
				String codeAction = null;
				if (split.length>1){
					controllerCode = split[1].trim();
					if (split.length>2){
						codeAction=split[2].trim();
						if (split.length>3){
							toValidate=split[3].trim().equals("true");
						}
					}
					MethodMapping mm= new MethodMapping(methodName, controllerCode, codeAction, toValidate);
					if (!isEmpty(controllerCode)){controllerCodeMappingMap.put(controllerCode, mm);};
	
				methodMappingMap.put(methodName, mm);
				}
			}
		
		
			getMethodMappings().add("onPaginator#"+Paginator.PARAMETER_PAGINATOR+"##false");
			getMethodMappings().add("onEnableDisablePagin#"+Paginator.PARAMETER_ENABLE_DISABLE_PAGIN+"##false");
		}
	}



	public Class<AbstractForm> getFormObjectClass() {
		return formObjectClass;
	}


	public final void setFormObjectClass(Class<AbstractForm> formObjectClass) {
		this.formObjectClass = formObjectClass;
	}


	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public ResourceBundleMessageSource getMessageSource() {
		return this.messageSource;
	}
	
	protected List<String> getMethodMappings() {
		
		if (methodMappings == null)
		{	methodMappings = new ArrayList<String>(0);	}	
		
		return methodMappings;
	}

	
	
	
	//public abstract String onInit(Context context) throws Throwable;
	
//	public abstract String startController(Context context) throws Throwable;
	
	public Map<String, MethodMapping> getControllerCodeMappingMap() {
		return controllerCodeMappingMap;
	}
	public void setControllerCodeMappingMap(
			Map<String, MethodMapping> controllerCodeMappingMap) {
		this.controllerCodeMappingMap = controllerCodeMappingMap;
	}
	public Map<String, MethodMapping> getMethodMappingMap() {
		return methodMappingMap;
	}
	public void setMethodMappingMap(Map<String, MethodMapping> methodMappingMap) {
		this.methodMappingMap = methodMappingMap;
	}
	public String getItemSelectorRequest() {
		return itemSelectorRequest;
	}
	public void setMethodMappings(List<String> methodMappings) {
		this.methodMappings = methodMappings;
	}
	public void setItemSelectorRequest(String itemSelectorRequest) {
		this.itemSelectorRequest = itemSelectorRequest;
	}
	
}
