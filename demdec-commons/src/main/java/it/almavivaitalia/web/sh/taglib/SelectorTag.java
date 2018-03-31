package it.almavivaitalia.web.sh.taglib;

import javax.servlet.jsp.JspException;

public class SelectorTag extends SelectorParentTag {
	


		/**
	     * Process the start of this tag.
	     *
	     * @throws JspException if a JSP exception has occurred
	     */
	/*	public int doStartTag() throws JspException {
	        if (getStyleClass()==null){
	        	setStyleClass("pulsante");
	        }

	        return (SKIP_BODY);
	    }*/

	   
		/**
	     * Process the end of this tag. <p> Support for Indexed property since
	     * Struts 1.1
	     *
	     * @throws JspException if a JSP exception has occurred
	     */
	    public int doEndTag() throws JspException {
	    	
	    	if(isHide()){
				return EVAL_PAGE;
			}
	    	
	        // Generate an HTML element
	        StringBuffer results = new StringBuffer();

	        results.append(getElementOpen());
	        prepareAttribute(results, "name", prepareName());
	        prepareButtonAttributes(results);
	        results.append(prepareEventHandlers());
	        results.append(prepareStyles());
	        prepareOtherAttributes(results);
	        results.append(getElementClose());
	        try {
	        	pageContext.getOut().print(results.toString());
	        }catch(Exception e){
	        	throw new JspException(e);
	        }
	        release();
	        return (EVAL_PAGE);
	    }

	    /**
	     * Render the opening element.
	     *
	     * @return The opening part of the element.
	     */
	    protected String getElementOpen() {
	        return isImage()?"<input type=\"image\"":"<input type=\"submit\"";
	    }

	    /**
	     * Prepare the name element
	     *
	     * @return The element name.
	     */
	    protected String prepareName()
	        throws JspException {
	        
	        return COMMAND_BUTTON_PREFIX_POST+getControllerCode();
	    }

	    /**
	     * Render the button attributes
	     *
	     * @param results The StringBuffer that output will be appended to.
	     */
	    protected void prepareButtonAttributes(StringBuffer results)
	        throws JspException {
	        prepareAttribute(results, "accesskey", getAccesskey());
	        prepareAttribute(results, "tabindex", getTabindex());
	        prepareValue(results);
	        if (isImage()) {
	        	prepareSrc(results);
	        }
	    }

	    
	    /**
	     * Render the src element
	     *
	     * @param results The StringBuffer that output will be appended to.
	     */
	    protected void prepareSrc(StringBuffer results) {
	        // Acquire the label value we will be generating
	    	String imageRelPath = getMessageSource().getMessage(getKeyValue());
	    	  if ((imageRelPath == null) || (imageRelPath.length() < 1)) {
	    		  imageRelPath = getDefaultValue();
		        }
	    	StringBuffer sb = new StringBuffer();
	    	
			sb.append(getRequest().getContextPath());
			if ((!imageRelPath.startsWith("\\")) && (!imageRelPath.startsWith("/")) ){sb.append("/");};
			sb.append(imageRelPath);
	        prepareAttribute(results, "src", sb.toString());
	    }
	    
	    
	    /**
	     * Render the value element
	     *
	     * @param results The StringBuffer that output will be appended to.
	     */
	    protected void prepareValue(StringBuffer results) {
	        // Acquire the label value we will be generating	
	        String label = getMessageSource().getMessage(getKeyValue());

	        if ((label == null) || (label.length() < 1)) {
	            label = getDefaultValue();
	        }

	        prepareAttribute(results, "value", label);
	    }

	    /**
	     * Return the default value.
	     *
	     * @return The default value if none supplied.
	     */
	    protected String getDefaultValue() {
	        return "Submit";
	    }

	    /**
	     * Release any acquired resources.
	     */
	    public void release() {
	        super.release();
	     
	    }
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		
		setImage(true);
		
		if ( getAltPrefix()!=null || getAltSuffix()!=null )
		{
			StringBuffer alt = new StringBuffer(""); 
			try
			{	String pref = "";
				String suff = "";
				
				if (getAltPrefix()!=null)
				{
					pref = getMessageSource().getMessage(getAltPrefix()) != null? getMessageSource().getMessage(getAltPrefix()).trim() : ""  ;
				}
				
				if (getAltSuffix()!=null)
				{
					suff = getMessageSource().getMessage(getAltSuffix()) != null? getMessageSource().getMessage(getAltSuffix()).trim() : ""  ;
				}
				
				alt.append(pref).append(" ").append(suff);
			}
			catch (Exception e)
			{
				alt = new StringBuffer("Scelta");
			}
			setAlt(alt.toString().trim());
		}
		
		if (getKeyValue()==null){
			setKeyValue("ico.openList");
		}
		if (getStyleClass()==null){
			setStyleClass("");
		}
		setStyleClass(getStyleClass()+" inline vmiddle");
		
		return EVAL_BODY_INCLUDE;
	}

	
//	@Override
//	public void release() {
//		super.release();
//		altSuffix=null;
//		altPrefix=null;
//	}


}
