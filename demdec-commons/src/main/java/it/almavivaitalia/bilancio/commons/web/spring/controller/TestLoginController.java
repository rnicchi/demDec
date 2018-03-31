package it.almavivaitalia.bilancio.commons.web.spring.controller;

import it.almavivaitalia.bilancio.commons.web.form.TestLoginForm;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = CommonConstantsRequestMapping.TEST_LOGIN_URL)
public class TestLoginController extends AbstractCommonFormController {

	private ResourceBundleMessageSource generalResources;
	
	private String applicationCode;
	

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}
	
	private String getCurrentNode(){
		return (applicationCode==null?"sbfj":applicationCode)+".menu";
	}
	
	public void setGeneralResources(ResourceBundleMessageSource generalResources) {
		this.generalResources = generalResources;
	}

	@Override
	public String onSubmit(Context sbfjContext) throws Throwable {
		TestLoginForm form = (TestLoginForm) sbfjContext.getForm();
        sbfjContext.getRequest().getSession().getServletContext().setAttribute(AMBIENTE,AMBIENTE_SVIL);
        /*HttpServletResponse resp = sbfjContext.getResponse();
		resp.addHeader(CommonWebConstants.OAM_HEADER_NAME, form.getTextUtente());
		resp.sendRedirect("http://localhost:8080/demdec-web");*/
	//	HttpServletRequest req = sbfjContext.getRequest();
		return CommonConstantsRequestMapping.REDIRECT
				+ prepareUrl(form.getTextUtente());
	}

	@Override
	public String startController(Context sbfjContext) throws Throwable {
		sbfjContext.setCurrentNode(getCurrentNode());
		TestLoginForm form = sbfjContext.getForm();
		form.setTextUtente("paperino");
		return "testLoginView";
	}

	private String prepareUrl(String user) throws Throwable {
		@SuppressWarnings("unused")
		String sProtocolloWeb = "http";
		@SuppressWarnings("unused")
		String sServerWeb = "localhost:8080";
		@SuppressWarnings("unused")
		String sContextWeb = "demdec-web";
		String sPageWeb =  "private/login.do";// CommonConstantsRequestMapping.LOGIN_URL;

		StringBuffer url = new StringBuffer();
//		String utenteSb = generalResources.getMessage("sb.user", null, null);
//		
//		String pswdSb = generalResources.getMessage("sb.password", null, null);

		try {
			url.append(CommonConstantsRequestMapping.SLASH + sPageWeb);
			// url.append(sProtocolloWeb+"://"+sServerWeb+"/"+sContextWeb+sPageWeb);
			//url.append(CommonSessionAttributes.P_INTERROGATIVO);
			url.append(CommonSessionAttributes.P_INTERROGATIVO + "oam-user" + CommonSessionAttributes.UGUALE + user);
			// byte [] key = ConstantsSecurity.UTENTE.getBytes("UTF-8");
//			Date data = new Date();
//			Format formatter = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER);
//			String formattedDate = formatter.format(data);
//			url.append(ConstantsSecurity.DATE_COLL + CommonSessionAttributes.UGUALE + formattedDate);
//			Format formatterKey = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER_KEY);
//			String formattedKey = formatterKey.format(data);
//
//			Boolean bCifratura = new Boolean(generalResources.getMessage("sec.cipher", null, null));
//			if (bCifratura) {
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE + CommonSessionAttributes.UGUALE + UtilParameter.encode(user, formattedKey));
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE_SB + CommonSessionAttributes.UGUALE + UtilParameter.encode(utenteSb, formattedKey));
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.PSWD_SB + CommonSessionAttributes.UGUALE + UtilParameter.encode(pswdSb, formattedKey));
//			} else {
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE + CommonSessionAttributes.UGUALE + user);
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE_SB + CommonSessionAttributes.UGUALE + utenteSb);
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.PSWD_SB + CommonSessionAttributes.UGUALE + pswdSb);
//			}
//
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return url.toString();
	}

}
