package it.almavivaitalia.bilancio.commons.web.spring.controller;

import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.bilancio.commons.web.utils.CommonWebConstants;
import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public abstract class AbstractMultiActionController extends MultiActionController implements CommonWebConstants,  CommonSessionAttributes{

	private ResourceBundleMessageSource messageSource;

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	protected ResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}
	
	protected void setDataModel(String name, Object attribute, HttpServletRequest request){
		ContextHelper.setDataModel(name, attribute, request);
	}
	
	protected void removeSessionModel(String name, HttpServletRequest request){
		ContextHelper.removeDataModel(name, request);
	}

	protected Object getModel(String name, HttpServletRequest request){
		return ContextHelper.getModel(name, request);
	}
	
}
