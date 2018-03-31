package it.almavivaitalia.web.sh.taglib.displaytable;

import javax.servlet.http.HttpServletRequest;

import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.web.sh.utils.BaseContextHelper;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;

public abstract class BaseTableTag extends org.displaytag.tags.el.ELTableTag implements BaseSessionAttributes{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ResourceBundleMessageSource messageSource;
	
	protected ResourceBundleMessageSource getMessageSource(){
		if (this.messageSource==null){
			this.messageSource=(ResourceBundleMessageSource)getAttribute(DEFAULT_MESSAGE_SOURCE);
			if (this.messageSource==null){
				throw new RuntimeException("No attribute found for ResourceBundleMessageSource under key "+DEFAULT_MESSAGE_SOURCE);
			}
		}
		return this.messageSource;
	}
	
	public BaseTableTag(){
	
	}
	
	


	protected Object getAttribute(String name){
		// find in pageContext
		Object object = pageContext.getAttribute(name); 
		if (object==null){
			// find in others scope request
			object = BaseContextHelper.getModel(name, (HttpServletRequest)pageContext.getRequest());
		}
		return object;
	}

	protected HttpServletRequest getRequest(){
		return ((HttpServletRequest)(pageContext.getRequest()));
	}
	
}
