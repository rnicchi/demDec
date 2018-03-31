package it.almavivaitalia.bilancio.commons.web.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.manager.RedirectManager;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.bilancio.commons.web.utils.CommonWebConstants;
import it.almavivaitalia.bilancio.commons.web.utils.ConstantsSecurity;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.UtilParameter;
import it.almavivaitalia.bilancio.commons.web.security.Utente;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = CommonConstantsRequestMapping.REDIRECT_URL)
public class RedirectController extends AbstractCommonFormAdminController {

	private ResourceBundleMessageSource generalResources;
	private RedirectManager redirectManager;
	
	public void setRedirectManager(RedirectManager redirectManager) {
		this.redirectManager = redirectManager;
	}

	public void setGeneralResources(ResourceBundleMessageSource generalResources) {
		this.generalResources = generalResources;
	}

	public String onSubmit(HttpServletRequest request, HttpServletResponse response, Context context) throws Throwable{
		return null;
	}
	/*
	 * Chiamato dal menu
	 * (non-Javadoc)
	 * @see it.almavivaitalia.web.sh.spring.controller.AbstractFormAdminController#startController(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, it.almavivaitalia.web.sh.utils.Context)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String startController(HttpServletRequest request, HttpServletResponse response, Context sbfjContext) throws Throwable {
		HttpSession session=sbfjContext.getRequest().getSession();
		
		Utente utente=getUtenteInSessione();
		
		//viene usato nella jsp navigator.jsp per la costruzione della briciola di pane
		//viene settato dal MenuController, metodo onActionSelected
		//sarebbe il codi_menu dell'applicazione chiamante
		String applicationCode=request.getParameter(APPLICATION_CODE);
		
		//sarebbe il codi_menu dell'applicazione richiesta che MenuController setta nel metodo onActionSelected
		String actionSelected=(String)sbfjContext.getModel(CommonWebConstants.ACTION_SELECTED);
		
		//se l'applicazione è stata a sua volta chiamata allora avrà nel context il codi_menu chiamante
		String applicationCodeSrc=(String)sbfjContext.getModel(APPLICATION_CODE_SRC);
		
		if(!isEmpty(applicationCodeSrc)){
			applicationCode=applicationCodeSrc+","+applicationCode;
		}
		
		String ipAddress=redirectManager.searchPropertyValueFromTabServ(actionSelected.toUpperCase());
		String maxInactiveInterval=redirectManager.searchPropertyValueFromTabServ(MAX_INACTIVE_INTERVAL_REDIRECT);
		
		if(isEmpty(ipAddress)){
			//segnalo la mancata configurazione dell'applicazione da invocare
			try {
				sbfjContext.addError("error.resourceNotFound", new String[]{});
			} catch (Exception e) {
				e.printStackTrace();
			}
			return CommonConstantsRequestMapping.REDIRECT + CommonConstantsRequestMapping.MENU_SBFJ;
		}
		
		String view = CommonConstantsRequestMapping.REDIRECT + (
						prepareUrl(
							utente.getUtente().getCodiUtente(),
							ipAddress,
							applicationCode
							));
		
		//LEGGO I PARAMETRI DA PASSARE ALLE APPLICAZIONI DA CHIAMARE
		view=readApplicationParameters((Map<String,List<Map<String,String>>>)sbfjContext.getModel(CommonSessionAttributes.APPLICATION_PARAMETERS_MAP), actionSelected, view);
		
		//session.invalidate();
				
		session.setMaxInactiveInterval(maxInactiveInterval==null?1:new Integer(maxInactiveInterval));
		
		return view;
	}
	
	private String readApplicationParameters(Map<String,List<Map<String,String>>> applicationParametersMap, String actionSelected, String view){
		StringBuffer url = new StringBuffer(view);
		//LEGGO I PARAMETRI DA PASSARE ALLE APPLICAZIONI DA CHIAMARE
		if(!isEmpty(applicationParametersMap)){
			if(applicationParametersMap.containsKey(actionSelected)){
				List<Map<String,String>> listParametri=applicationParametersMap.get(actionSelected);
				for(Map<String,String> parametri:listParametri){
					for(Entry<String, String> parametri2:parametri.entrySet()){
						url.append(E_COMMERCIALE + parametri2.getKey() + UGUALE + parametri2.getValue());
					}
				}
			}
		}
		
		return url.toString();
	}

	@SuppressWarnings("unchecked")
	public String onCallApp(Context sbfjContext) throws Throwable {
		//HttpSession session=sbfjContext.getRequest().getSession();
		HttpServletRequest request=sbfjContext.getRequest();
		
		Utente utente=getUtenteInSessione();
		
		//viene usato nella jsp navigator.jsp per la costruzione della briciola di pane
		String applicationCode=request.getParameter(APPLICATION_CODE);
		String skipAuth=request.getParameter(SKIP_AUTH);
		
		String ipAddress=redirectManager.searchPropertyValueFromTabServ(applicationCode.toUpperCase());
		
		return CommonConstantsRequestMapping.REDIRECT + (
				prepareUrl(
						utente==null?"":utente.getUtente().getCodiUtente(),
						ipAddress,								//ipAddressDest
						request.getRequestURL().toString(),		//urlSrc
						request.getContextPath(),
						request.getRequestURI(),
						applicationCode,
						"true".equals(skipAuth),
						request.getParameterMap()
						));
	}
	
	private String prepareUrl(
					String user, 
					String ipAddress, 
					String urlSrc,
					String contextPathSrc,
					String requestUriSrc, 
					String applicationCode,
					boolean skipAuth,
					Map<String,String[]> userParametersMap
					)
			throws Throwable {

		StringBuilder url = new StringBuilder();

		if(!ipAddress.contains(CommonSessionAttributes.HTTP_PROTOCOL)){
			ipAddress=CommonSessionAttributes.HTTP_PROTOCOL+CommonSessionAttributes.COLON+CommonSessionAttributes.SLASH+CommonSessionAttributes.SLASH+ipAddress;
		}
		
		if(!ipAddress.endsWith(CommonSessionAttributes.P_INTERROGATIVO)){
			ipAddress=ipAddress+CommonSessionAttributes.P_INTERROGATIVO;	
		}
		
		
		try {
			url.append(ipAddress);
			
			//AUTENTICAZIONE
			if(!skipAuth){
				addAuthenticationInfos(url, user);
			}
			//AUTENTICAZIONE
			
			//INFO CALLER
			if(!userParametersMap.containsKey(CONTEXT_PATH_SRC)){
				addParameter(url, CONTEXT_PATH_SRC, contextPathSrc);
			}
			if(!userParametersMap.containsKey(REQUEST_URI_SRC)){
				addParameter(url, REQUEST_URI_SRC, requestUriSrc);
			}
			if(!userParametersMap.containsKey(URI_SRC)){
				addParameter(url, URI_SRC, urlSrc);
			}
			if(!userParametersMap.containsKey(APPLICATION_CODE_SRC)){
				addParameter(url, APPLICATION_CODE_SRC, applicationCode);
			}
			//END INFO CALLER
			
			//ADD EXTRA PARAMETERS
			for(Map.Entry<String, String[]> e:userParametersMap.entrySet()){
				String values="";
				for(String value:e.getValue()){
					if(!"".equals(values)){
						values=values+",";
					}
					values=values+value;
				}
				addParameter(url, e.getKey(), values);
			}
			//END ADD EXTRA PARAMETERS

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return url.toString();
	}
	
	private void addParameter(StringBuilder url,String name, String value){
		if(!StringUtil.isEmpty(value)){
			if(url.charAt(url.length()-1)=='?'){
				url.append(name + UGUALE + value);
			}else{
				url.append(E_COMMERCIALE +name + UGUALE + value);
			}
		}
	}
	
	private String prepareUrl(
								String user, 
								String ipAddress,
								String applicationCode
								) throws Throwable {
		
		StringBuilder url = new StringBuilder();
		
		try {
			
			if(!ipAddress.contains(CommonSessionAttributes.HTTP_PROTOCOL)){
				ipAddress=CommonSessionAttributes.HTTP_PROTOCOL+CommonSessionAttributes.COLON+CommonSessionAttributes.SLASH+CommonSessionAttributes.SLASH+ipAddress;
			}
			
			if(!ipAddress.endsWith(CommonSessionAttributes.P_INTERROGATIVO)){
				ipAddress=ipAddress+CommonSessionAttributes.P_INTERROGATIVO;	
			}
			
			url.append(ipAddress);
			
			//AUTENTICAZIONE
			addAuthenticationInfos(url, user);
			//AUTENTICAZIONE
			
			if(!isEmpty(applicationCode)){
				url.append(E_COMMERCIALE + APPLICATION_CODE_SRC + UGUALE + applicationCode);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return url.toString();
	}
	
	private void addAuthenticationInfos(StringBuilder url, String user) throws Throwable{
		String _url=url.toString();
		
//		Pattern p =Pattern.compile("" +
//				"(http://)?"+										//PROTOCOL
//				"(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})?" +	//IP
//				"([a-zA-Z0-9\\-\\.]*)?"+							//HOSTNAME
//				":?(\\d{2,4})?" +									//PORT
//				"(/[a-zA-Z\\-]*/?)?" +								//CONTEXT
//				"");
//		
//		Matcher m=p.matcher(_url);
//		m.find();
//		
//		String contextPathDest=m.group(5);
//		
//		
//		if(!_url.endsWith(contextPathDest)){
//			String extra=_url.substring(_url.indexOf(contextPathDest)+contextPathDest.length());
//			url.delete(url.indexOf(extra), url.indexOf(extra)+extra.length());
//			url.append(CommonConstantsRequestMapping.LOGIN_URL.substring(1));
//		}else{
//			if(contextPathDest.endsWith(BaseSessionAttributes.SLASH)){
//				url.append(CommonConstantsRequestMapping.LOGIN_URL.substring(1));
//			}else{
//				url.append(CommonConstantsRequestMapping.LOGIN_URL);
//			}
//		}
		
		String sData = redirectManager.getSystemDate();
		
		if(_url.contains(CommonSessionAttributes.P_INTERROGATIVO)){
			if(_url.endsWith(CommonSessionAttributes.P_INTERROGATIVO)){
				url.append(ConstantsSecurity.DATE_COLL + UGUALE + sData);
			}else{
				url.append(E_COMMERCIALE+ConstantsSecurity.DATE_COLL + UGUALE + sData);
			}
		}else{
			url.append(P_INTERROGATIVO+ConstantsSecurity.DATE_COLL + UGUALE + sData);
		}

		SimpleDateFormat formatter = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER);

		Format formatterKey = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER_KEY);
		
		String formattedKey = formatterKey.format(formatter.parse(sData));

		Boolean bCifratura = new Boolean(generalResources.getMessage("sec.cipher", null, null));
		
		String utenteSb = generalResources.getMessage("sb.user", null, null);
		String pswdSb = generalResources.getMessage("sb.password", null, null);
		
		if (bCifratura) {
			url.append(E_COMMERCIALE + ConstantsSecurity.UTENTE 	+ UGUALE+ UtilParameter.encode(user, formattedKey));
			url.append(E_COMMERCIALE + ConstantsSecurity.UTENTE_SB 	+ UGUALE + UtilParameter.encode(utenteSb, formattedKey));
			url.append(E_COMMERCIALE + ConstantsSecurity.PSWD_SB + UGUALE	+ UtilParameter.encode(pswdSb, formattedKey));
		} else {
			url.append(E_COMMERCIALE + ConstantsSecurity.UTENTE + UGUALE + user);
			url.append(E_COMMERCIALE + ConstantsSecurity.UTENTE_SB + UGUALE
					+ utenteSb);
			url.append(E_COMMERCIALE + ConstantsSecurity.PSWD_SB + UGUALE
					+ pswdSb);
		}
	}
	
	@SuppressWarnings("unchecked")
	public String backFrom(Context sbfjContext) throws Throwable {
		HttpSession session=sbfjContext.getRequest().getSession();
		HttpServletRequest request=sbfjContext.getRequest();
		Utente utente=getUtenteInSessione();
		String view=null;
		String appCodeSrc=(String)session.getAttribute(CommonSessionAttributes.APPLICATION_CODE_SRC);
		String appCode=request.getParameter(CommonSessionAttributes.APPLICATION_CODE);
		
		//from logout button
		//in questo caso faccio il redirect sull'ultima applicazione
		if(isEmpty(appCode)){
			appCode=appCodeSrc.split(",")[appCodeSrc.split(",").length-1];
		}
		
		//viene usato nella jsp navigator.jsp per la costruzione della briciola di pane
		String applicationCode=isEmpty(appCode)?appCodeSrc:appCode;
		
		String ipAddress=redirectManager.searchPropertyValueFromTabServ(applicationCode.toUpperCase());
		String maxInactiveInterval=redirectManager.searchPropertyValueFromTabServ(MAX_INACTIVE_INTERVAL_REDIRECT);
		
		StringBuilder url = new StringBuilder();

		if(!ipAddress.contains(CommonSessionAttributes.HTTP_PROTOCOL)){
			ipAddress=CommonSessionAttributes.HTTP_PROTOCOL+CommonSessionAttributes.COLON+CommonSessionAttributes.SLASH+CommonSessionAttributes.SLASH+ipAddress;
		}
		
		if(!ipAddress.endsWith(CommonSessionAttributes.P_INTERROGATIVO)){
			ipAddress=ipAddress+CommonSessionAttributes.P_INTERROGATIVO;	
		}
		
		url.append(ipAddress);
		
		//AUTENTICAZIONE
		addAuthenticationInfos(url, utente.getUtente().getCodiUtente());
		//AUTENTICAZIONE

		view = CommonConstantsRequestMapping.REDIRECT + url.toString();			
		
		if(!isEmpty(session.getAttribute(CommonSessionAttributes.APPLICATION_CODE_SRC))){
			String[] appo=((String)session.getAttribute(CommonSessionAttributes.APPLICATION_CODE_SRC)).split(",");
			String xxx="";
			
			for(String a:appo){
				if(!a.equals(applicationCode)){
					xxx=xxx+a+",";
				}else{
					break;
				}
			}
					
			view+=
					CommonSessionAttributes.E_COMMERCIALE+
					CommonSessionAttributes.APPLICATION_CODE_SRC+
					CommonSessionAttributes.UGUALE+
					xxx;	
		}
		
		view=readApplicationParameters((Map<String,List<Map<String,String>>>)sbfjContext.getModel(CommonSessionAttributes.APPLICATION_PARAMETERS_MAP), applicationCode, view);
		
		//session.invalidate();
		
		session.setMaxInactiveInterval(maxInactiveInterval==null?1:new Integer(maxInactiveInterval));
		
		return view;
		
	}
	
	@Override
	public String startController(Context sbfjContext) throws Throwable {
		return null;
	}
	
	
	@Override
	protected boolean checkEnabled(HttpServletRequest request) throws Throwable {
		return true;
	}
}