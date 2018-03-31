package it.almavivaitalia.bilancio.commons.web.spring.controller;

import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value=CommonConstantsRequestMapping.HELP_URL)
public class HelpController extends AbstractCommonFormController{
	private String startView;	
	
	public String getStartView() {
		return startView;
	}

	public void setStartView(String startView) {
		this.startView = startView;
	}

	@Override
	public String startController(Context context) throws Throwable {
		String out = (String)context.getModel(BaseSessionAttributes.OBJECT_HELP_VIEW);

		if (out == null)
		{	out = onBack(context); }
		
		return out;
	}
	
	public String onBack(Context context) throws Throwable {
		String requestURI = context.getModel(BaseSessionAttributes.OBJECT_HELP_BACK_URI);
		String action = requestURI.substring(requestURI.lastIndexOf(CommonConstantsRequestMapping.SLASH), requestURI.length());
		return CommonConstantsRequestMapping.REDIRECT+(action + CommonSessionAttributes.P_INTERROGATIVO + COMMAND_BACK_HELP_PARAMETER + "=1");
	}
	

}
