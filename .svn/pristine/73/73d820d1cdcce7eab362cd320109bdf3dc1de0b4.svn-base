package it.almavivaitalia.bilancio.commons.web.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.getClassName;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.manager.DownloadFileManager;
import it.almavivaitalia.bilancio.commons.utils.BooleanUtil;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.bilancio.commons.web.utils.ConstantsSecurity;
import it.almavivaitalia.bilancio.commons.web.utils.SelectorUtils;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.datatype.DataType;
import it.almavivaitalia.web.sh.spring.controller.AbstractFormController;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.WebConstants;
import it.almavivaitalia.web.sh.validator.Validator;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public abstract class AbstractCommonFormParentController extends AbstractFormController{

	
	private DownloadFileManager downloadFileManager;
	private String applicationName;
	
	private String idApplication;
	private String codiApplication;
	private String newHelpVersion;
	
	public String getIdApplication() {
		return idApplication;
	}

	/**
	 * 
	 * Valorizza la variabile come da D_APPLICATION (SEQU_ID_APPLICATION)
	 * 
	 * @param idApplication
	 */
	public void setIdApplication(String idApplication) {
		this.idApplication = idApplication;
	}

	public String getCodiApplication() {
		return codiApplication;
	}

	/**
	 * 
	 * Valorizza la variabile come da D_APPLICATION (CODI_APPLICATION)
	 * 
	 * @param codiApplication
	 */
	public void setCodiApplication(String codiApplication) {
		this.codiApplication = codiApplication;
	}

	public String getNewHelpVersion() {
		return newHelpVersion;
	}

	public void setNewHelpVersion(String newHelpVersion) {
		this.newHelpVersion = newHelpVersion;
	}

	public DownloadFileManager getDownloadFileManager() {
		return downloadFileManager;
	}

	public void setDownloadFileManager(DownloadFileManager downloadFileManager) {
		this.downloadFileManager = downloadFileManager;
	}
	
	public String getApplicationName() 	{
		return applicationName;	}
	public void setApplicationName(String applicationName) 	{
		this.applicationName = applicationName;	}
	
}
