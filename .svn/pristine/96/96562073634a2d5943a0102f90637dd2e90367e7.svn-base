package it.almavivaitalia.web.sh.taglib;

import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RedirectTag extends SimpleTagSupport {
	private String controllerCode;
	private String applicationCode;
	private String skipAuthentication;
	private String codeMessageKey;

	private Map<String, String> tagAttrs = new HashMap<String, String>();

	@Override
	public void doTag() throws JspException, IOException {
		
		JspFragment body = getJspBody();
		body.invoke(null);
		
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		
		ResourceBundleMessageSource messageSource=(ResourceBundleMessageSource)pageContext.findAttribute(BaseSessionAttributes.DEFAULT_MESSAGE_SOURCE);
		JspWriter writer = pageContext.getOut();

		StringBuilder href=new StringBuilder();
		href.append(request.getContextPath()+"/public/redirect.do?");
		href.append(BaseSessionAttributes.APPLICATION_CODE+BaseSessionAttributes.UGUALE+applicationCode);
		href.append(BaseSessionAttributes.AMPERSAND_ENTITY+BaseSessionAttributes.SKIP_AUTH+BaseSessionAttributes.UGUALE+skipAuthentication);

		for(Map.Entry<String, String> entry:tagAttrs.entrySet()){
			href.append(BaseSessionAttributes.AMPERSAND_ENTITY+entry.getKey()+BaseSessionAttributes.UGUALE+entry.getValue());
		}
		
		if(!StringUtil.isEmpty(controllerCode)){
			href.append(BaseSessionAttributes.AMPERSAND_ENTITY+"cmdGET___"+controllerCode);
		}else{
			href.append(BaseSessionAttributes.AMPERSAND_ENTITY+"cmdGET___callApp");
		}
		
		
		writer.print("<a href=\""+href.toString()+"\">");
		writer.print(messageSource.getMessage(codeMessageKey));
		writer.print("</a>");

	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public void setSkipAuthentication(String skipAuthentication) {
		this.skipAuthentication = skipAuthentication;
	}

	public void setCodeMessageKey(String codeMessageKey) {
		this.codeMessageKey = codeMessageKey;
	}

	public void setControllerCode(String controllerCode) {
		this.controllerCode = controllerCode;
	}

	public void addAttribute(String name, String value) throws JspException {
		tagAttrs.put(name, (String) value);
	}

}
