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
public abstract class AbstractCommonFormController extends AbstractCommonFormParentController{

	
	
	
	
	
	
	
	
	private String capitalizeFirstLetter(String in){
		String out="";
		if(!isEmpty(in)&&in.length()>0){
			String firstChar=String.valueOf(in.toCharArray()[0]).toUpperCase();
			out=firstChar+in.substring(1);
		}
		return out;
	}
	
	private boolean validate(DataType datatype, Context context) throws Exception{
		HttpServletRequest request=context.getRequest();
		boolean valid=true;
		
		if(datatype.getRequiredParameters()!=null && datatype.getRequiredParameters().length>0){
			
			Validator validator=getValidator();
			
			String controllerCode=request.getParameter(WebConstants.PARAMETER_SELECTOR_VALIDATOR_METHOD_NAME);
			
			if(!isEmpty(controllerCode)){
				controllerCode="on"+capitalizeFirstLetter(controllerCode);
			}
			
			Method method = validator.getClass().getMethod(StringUtil.isEmpty(controllerCode)?"on"+capitalizeFirstLetter(datatype.getControllerCode()):controllerCode, new Class[] { Context.class });
			
			valid = (Boolean) method.invoke(validator, new Object[] { context });

		}
		
		return valid;
	}
	
	public String onSelector(Context context) throws Throwable{			
		HttpServletRequest request=context.getRequest();
		
		String action= null;	
		String dataType=null;
		String dataTypeName=null;
		String dataTypeClass=null;
		
		//devo recuperare il parametro che inizia con cmdPOST___
		for(@SuppressWarnings("unchecked")Enumeration<String> enumm=request.getParameterNames(); enumm.hasMoreElements();){
			String key=enumm.nextElement();
			
			if(key.contains(COMMAND_BUTTON_PREFIX_POST)){
				Pattern pAction=Pattern.compile("([a-zA-Z_0-9?]*)(action=)(/[a-zA-Z]*\\.do)(.)*");
				
				Matcher m=pAction.matcher(key);
				
				if(m.matches()){
					action=m.group(3);
				}
				
				Pattern pDataType=Pattern.compile("([a-zA-Z_0-9?=/\\.&]*)(dataType=)([a-zA-Z0-9]*)&(.)*");
				
				m=pDataType.matcher(key);
				
				if(m.matches()){
					dataType=m.group(3);
				}
				
				Pattern pDataTypeClass=Pattern.compile("([a-zA-Z_0-9?=/\\.&]*)(dataTypeClass=)([ \\.a-zA-Z_0-9]*)(.)*");
				
				m=pDataTypeClass.matcher(key);
				
				if(m.matches()){
					dataTypeClass=m.group(3).replace("class ", "");
				}	
				
				Pattern pDataTypeName=Pattern.compile("([a-zA-Z_0-9?=/\\.& ]*)(dataTypeName=)([a-zA-Z_0-9]*)(.)*");
				
				m=pDataTypeName.matcher(key);
				
				if(m.matches()){
					dataTypeName=m.group(3);
				}					
				
				break;
			}
		}
		
		//VALIDAZIONE INPUT
		DataType type=SelectorUtils.getDataType(dataTypeClass, dataTypeName);
		
		if(!validate(type, context)){
			return context.getModel(PREV_VIEW);
		}
		
		context.setDataModel("dataTypeName",	dataTypeName);
		context.setDataModel("dataTypeClass",	dataTypeClass);
		context.setDataModel("dataType", 		dataType);
		
		//SALVATAGGIO IN CONTEXT DEI NOMI DEI PARAMETRI DI OUTPUT
		for(String fieldName:type.getOutputFields()){
			String output=request.getParameter(WebConstants.OUTPUT + type.name() + WebConstants.UNDERSCORE + fieldName);
			if(!StringUtil.isEmpty(output)){
				context.setDataModel(WebConstants.OUTPUT + type.name() +WebConstants.UNDERSCORE  + fieldName, output);
			}
		}
		
		StringBuilder inputParameters=new StringBuilder();
		for(String fieldName:type.getInputParameters()){
			String input=request.getParameter(WebConstants.INPUT + type.name() + WebConstants.UNDERSCORE + fieldName);
			
			if(!StringUtil.isEmpty(input)){
				inputParameters.append(WebConstants.E_COMMERCIALE+fieldName+WebConstants.UGUALE+request.getParameter(input));
			}
		}		
		
		/*BUILD QUERY STRING*/
		StringBuilder queryString=new StringBuilder();
		queryString.append(CommonSessionAttributes.P_INTERROGATIVO);		
		for(@SuppressWarnings("unchecked")Enumeration<String> enumm=request.getParameterNames(); enumm.hasMoreElements();){
			String key=enumm.nextElement();
			
			if(BooleanUtil.testORCondition(
											COMMAND_BACK_SELECTOR_REQUEST_PARAMETER.equals(key), 
											key.contains(COMMAND_BUTTON_PREFIX_POST),
											key.contains(COMMAND_BUTTON_PREFIX_GET))){
				continue;
			}
			
			//skip output
			if(key.startsWith(WebConstants.OUTPUT + type.name())){
				continue;
			}
			
			queryString.append(getParameters(request, key));
		}		
		
		//aggiungo alla request i parametri
		queryString.append(inputParameters);
		
		/*BUILD QUERY STRING*/
		
		context.setDataModel(FORM, context.getForm());
		context.setDataModel(OBJECT_INCOMING_REQUEST_URI_FOR_SELECTOR, context.getRequest().getRequestURI());
		return  CommonConstantsRequestMapping.REDIRECT + action + queryString;
	}		
	
	private String getParameters(HttpServletRequest request, String key){
		StringBuilder queryString=new StringBuilder();

		if(request.getParameterValues(key)==null||request.getParameterValues(key).length<=1){
			queryString.append(key+ CommonSessionAttributes.UGUALE + request.getParameter(key) + CommonSessionAttributes.E_COMMERCIALE);
		}else{
			for(String x:request.getParameterValues(key)){
				queryString.append(key+ CommonSessionAttributes.UGUALE + x + CommonSessionAttributes.E_COMMERCIALE);
			}			
		}
		
		return queryString.toString();
	}
	
	public String backFromSelector(Context context) throws Throwable{
		return context.getModel(BACK_VIEW_FOR_SELECTOR);
	}
	
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Throwable {
		return super.onSubmit(request, response, model);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public String onInit(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Throwable {
		return super.onInit(request, response, model);
	}

	@Override
	protected boolean checkEnabled(HttpServletRequest request) throws Throwable {
		return true;
	}

	@Override
	protected void setUserNameInLog(HttpServletRequest request) {
		Utente o = getUtenteInSessione();
		if (!isEmpty(o)) {
			//UtenteTO utente = (UtenteTO) o;
			MDC.put(ConstantsSecurity.USER_NAME, o.getUtente().getCodiUtente());
		}
	}

	public String onHelp(Context context) throws Throwable {
		String out = null;

		if(!StringUtils.isEmpty(getNewHelpVersion())&&Boolean.valueOf(getNewHelpVersion())){
			
			String pathHelpApp=context.getModel(BaseSessionAttributes.PATH_HELP_APP);
			
			if(!pathHelpApp.contains(CommonSessionAttributes.HTTP_PROTOCOL)){
				pathHelpApp=CommonSessionAttributes.HTTP_PROTOCOL+CommonSessionAttributes.COLON+CommonSessionAttributes.SLASH+CommonSessionAttributes.SLASH+pathHelpApp;
			}
			
			String code = getMessageSource().getMessage(getClassName(this));
			
			StringBuffer url = new StringBuffer(CommonConstantsRequestMapping.REDIRECT + pathHelpApp);
			
			if(!pathHelpApp.endsWith(CommonSessionAttributes.P_INTERROGATIVO)){
				url.append(CommonSessionAttributes.P_INTERROGATIVO);	
			}
			
			url.append(CommonSessionAttributes.OBJECT_HELP_CODE_KEY+CommonSessionAttributes.UGUALE+code);
			url.append(CommonSessionAttributes.E_COMMERCIALE + CommonSessionAttributes.ID_APPLICATION_RIF+CommonSessionAttributes.UGUALE+getIdApplication());
			url.append(CommonSessionAttributes.E_COMMERCIALE + CommonSessionAttributes.CODI_APPLICATION_RIF+CommonSessionAttributes.UGUALE+getCodiApplication());
			url.append(CommonSessionAttributes.E_COMMERCIALE + CommonSessionAttributes.OBJECT_HELP_BACK_URI+CommonSessionAttributes.UGUALE+context.getModel(CommonSessionAttributes.OBJECT_INCOMING_REQUEST_URI));
			url.append(CommonSessionAttributes.E_COMMERCIALE + CommonSessionAttributes.VIEW_CACHED+CommonSessionAttributes.UGUALE+getPreviousView(context));
			url.append(CommonSessionAttributes.E_COMMERCIALE + CommonSessionAttributes.REQUEST_URI_SRC+CommonSessionAttributes.UGUALE+context.getRequest().getRequestURI());
			url.append(CommonSessionAttributes.E_COMMERCIALE + CommonSessionAttributes.URI_SRC + CommonSessionAttributes.UGUALE + context.getRequest().getRequestURL().toString());
			
			context.setDataModel(VIEW_CACHED, getPreviousView(context));
			
			Object form = context.getForm();
			
			if (form != null) {
				context.setDataModel(BaseSessionAttributes.FORM_CACHED, form);
			}
			
			out=url.toString();
		}else{
			
			if (context.getModel(BaseSessionAttributes.FLAG_IS_NEW_HELP_VERSION) != null
				&& ((Boolean) context.getModel(BaseSessionAttributes.FLAG_IS_NEW_HELP_VERSION)).compareTo(new Boolean(true)) == 0) {
				// out = "redirect:/newHelp.do";
				out = "redirect:" + CommonConstantsRequestMapping.NEW_HELP_URL;
				String code = getClassName(this);
	
				context.setDataModel(BaseSessionAttributes.OBJECT_HELP_CODE_KEY, code);
				context.setDataModel(BaseSessionAttributes.OBJECT_HELP_VIEW, "helpView");
				context.setDataModel(BaseSessionAttributes.OBJECT_HELP_BACK_URI, context.getModel(OBJECT_INCOMING_REQUEST_URI));
				context.setDataModel(VIEW_CACHED, getPreviousView(context));
	
				Object form = context.getForm();
				
				if (form != null) {
					context.setDataModel(BaseSessionAttributes.FORM_CACHED, form);
				}
			} else {
				// out = "redirect:/help.do";
				out = "redirect:" + CommonConstantsRequestMapping.HELP_URL;
				String str;
	
				try {
					str = getMessageSource().getMessage(getClassName(this));
	
					context.setDataModel(BaseSessionAttributes.OBJECT_HELP_VIEW, str);
					context.setDataModel(BaseSessionAttributes.OBJECT_HELP_BACK_URI, context.getModel(OBJECT_INCOMING_REQUEST_URI));
					context.setDataModel(VIEW_CACHED, getPreviousView(context));
	
					Object form = context.getForm();
					
					if (form != null) {
						context.setDataModel(BaseSessionAttributes.FORM_CACHED, form);
					}
				} catch (Exception e) {
					str = null;
					out = (String) context.getModel(PREV_VIEW);
					context.addError("help.error.pageNotPresent");
				}
	
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
			String nomeFile="Manuale" + getApplicationName() + ".pdf";
			context.setResponseContentType("application/pdf", nomeFile);	
			getDownloadFileManager().downloadFile(nomeFile, context.getOutputStream());
		}
		
		return view;
	}
	
	

	@Override
	public void init() {
		getMethodMappings().add("onHelp#help##false");
		getMethodMappings().add("onRichiestaManuale#richiestaManuale##false");
		getMethodMappings().add("onSelector#selector##false");
		getMethodMappings().add("onSelectAllRows#selectAllRows##false");
		super.init();
	}
	

	public String onSelectAllRows(Context context) throws Throwable {
		Boolean selectAllProiezioni = context.getModel(CommonSessionAttributes.SELECT_ALL_ROWS)==null?Boolean.TRUE:!((Boolean)context.getModel(CommonSessionAttributes.SELECT_ALL_ROWS));
		context.setDataModel(CommonSessionAttributes.SELECT_ALL_ROWS, selectAllProiezioni);
		return (String)context.getModel(PREV_VIEW);
	}
}
