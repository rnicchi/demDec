package it.almavivaitalia.bilancio.commons.web.spring.controller;

import it.almavivaitalia.bilancio.commons.web.form.TestLoginForm;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.bilancio.commons.web.utils.ConstantsSecurity;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.UtilParameter;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = CommonConstantsRequestMapping.ROBOT_LOGIN_URL)
public class RobotLoginController extends AbstractCommonFormController {

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
		String utenteRobot = generalResources.getMessage("sb.robot.user", null, null);
		String pswdRobot = generalResources.getMessage("sb.robot.password", null, null);
		if (form.getTextUtente().toLowerCase().equals(utenteRobot) &&
			form.getPassUtente().equals(pswdRobot)){
			return CommonConstantsRequestMapping.REDIRECT
					+ (prepareUrl(form.getTextUtente()));
		}else{
			sbfjContext.setRequestModel("error.notEnabled", "Utente o password errati");
			return "robotLoginView";
		}
	}

	@Override
	public String startController(Context sbfjContext) throws Throwable {
		sbfjContext.setCurrentNode(getCurrentNode());
		return "robotLoginView";
	}

	private String prepareUrl(String user) throws Throwable {
		@SuppressWarnings("unused")
		String sProtocolloWeb = "http";
		@SuppressWarnings("unused")
		String sServerWeb = "localhost:8080";
		@SuppressWarnings("unused")
		String sContextWeb = "sbfj-dls";
		String sPageWeb = CommonConstantsRequestMapping.LOGIN_URL;

		StringBuffer url = new StringBuffer();
		String utenteSb = generalResources.getMessage("sb.user", null, null);
		
		String pswdSb = generalResources.getMessage("sb.password", null, null);

		try {
			url.append(CommonConstantsRequestMapping.SLASH + sPageWeb);
			// url.append(sProtocolloWeb+"://"+sServerWeb+"/"+sContextWeb+sPageWeb);
			url.append(CommonSessionAttributes.P_INTERROGATIVO);
			// byte [] key = ConstantsSecurity.UTENTE.getBytes("UTF-8");
			Date data = new Date();
			Format formatter = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER);
			String formattedDate = formatter.format(data);
			url.append(ConstantsSecurity.DATE_COLL + CommonSessionAttributes.UGUALE + formattedDate);
			Format formatterKey = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER_KEY);
			String formattedKey = formatterKey.format(data);

			Boolean bCifratura = new Boolean(generalResources.getMessage("sec.cipher", null, null));
			if (bCifratura) {
				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE + CommonSessionAttributes.UGUALE + UtilParameter.encode(user, formattedKey));
				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE_SB + CommonSessionAttributes.UGUALE + UtilParameter.encode(utenteSb, formattedKey));
				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.PSWD_SB + CommonSessionAttributes.UGUALE + UtilParameter.encode(pswdSb, formattedKey));
			} else {
				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE + CommonSessionAttributes.UGUALE + user);
				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE_SB + CommonSessionAttributes.UGUALE + utenteSb);
				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.PSWD_SB + CommonSessionAttributes.UGUALE + pswdSb);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return url.toString();
	}

}
