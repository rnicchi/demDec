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
//@RequestMapping(value = CommonConstantsRequestMapping.LOGIN_URL)
public  abstract class LoginParentController extends AbstractCommonFormAdminController {


	private AdministratorManager administratorManager;
	private String applicationCode;
	private Map<String,List<Map<String,String>>> applicationParametersMap;
	
	public void setAdministratorManager(AdministratorManager administratorManager) {
		this.administratorManager = administratorManager;
	}
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}
	public void setApplicationParametersMap(
			Map<String, List<Map<String, String>>> applicationParametersMap) {
		this.applicationParametersMap = applicationParametersMap;
	}
	public AdministratorManager getAdministratorManager() {
		return administratorManager;
	}
	public String getApplicationCode() {
		return applicationCode;
	}
	public Map<String, List<Map<String, String>>> getApplicationParametersMap() {
		return applicationParametersMap;
	} 
		
		 	
}
