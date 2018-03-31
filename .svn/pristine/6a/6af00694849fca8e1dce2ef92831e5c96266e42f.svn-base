package it.almavivaitalia.web.sh.taglib.displaytable;

import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.web.sh.utils.BaseContextHelper;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;

import javax.servlet.http.HttpServletRequest;



public abstract class BaseColumnTag extends org.displaytag.tags.el.ELColumnTag implements BaseSessionAttributes{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResourceBundleMessageSource messageSource;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	protected ResourceBundleMessageSource getMessageSource(){
		if (this.messageSource==null){
			this.messageSource=(ResourceBundleMessageSource)getAttribute(DEFAULT_MESSAGE_SOURCE);
			if (this.messageSource==null){
				throw new RuntimeException("No attribute found for ResourceBundleMessageSource under key "+DEFAULT_MESSAGE_SOURCE);
			}
		}
		return this.messageSource;
	}
	
	
	public BaseColumnTag(){
	
	}
	
	

	
	protected String getRowNumAttributeName(){
		return getTableTag().getUid()+"_rowNum";
	}
	
	// starts from 0
	protected Integer getCurrentRowIndex(){
		Integer rowNum = (Integer)pageContext.getAttribute(getRowNumAttributeName());
		if (rowNum!=null){
			return new Integer(rowNum.intValue()-1);
		}else {
			return new Integer(-1);
		}
	}
	// starts from 0
	protected Object getCurrentRow(){
		return pageContext.getAttribute(getTableTag().getUid());
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
