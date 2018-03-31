package it.almavivaitalia.web.sh.taglib;
import javax.servlet.jsp.JspException;

public class SubmitTag extends BaseAlmavivaHTMLTag{

	
	private static final long serialVersionUID = 1L;

		/**
	     * The name of the generated input field.
	     */
	    private String controllerCode = null;
	    private String keyValue = null;
	    private boolean image = false;
	   
	    /*LOCM*/
		@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
		/*END LOCM*/

	    

	    // ------------------------------------------------------------- Properties


	  


	    // --------------------------------------------------------- Public Methods

	    protected boolean isImage() {
			return image;
		}



		public void setImage(boolean image) {
			this.image = image;
		}



		public String getKeyValue() {
			return keyValue;
		}



		public void setKeyValue(String keyValue) {
			this.keyValue = keyValue;
		}



		/**
	     * Process the start of this tag.
	     *
	     * @throws JspException if a JSP exception has occurred
	     */
		public int doStartTag() throws JspException {
	        if (getStyleClass()==null){
	        	setStyleClass("button small");
	        }

	        return (SKIP_BODY);
	    }

	   
//	    public String getControllerCode() { //TODO commentato per metriche 
//			return controllerCode;
//		}


		public void setControllerCode(String controllerCode) {
			this.controllerCode = controllerCode;
		}



		/**
	     * Process the end of this tag. <p> Support for Indexed property since
	     * Struts 1.1
	     *
	     * @throws JspException if a JSP exception has occurred
	     */
	    public int doEndTag() throws JspException {
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
	        return image?"<input type=\"image\"":"<input type=\"submit\"";
	    }

	    /**
	     * Prepare the name element
	     *
	     * @return The element name.
	     */
	    protected String prepareName()
	        throws JspException {
	        
	        return COMMAND_BUTTON_PREFIX_POST+controllerCode;
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
	        if (image) {
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
	    	String imageRelPath = getMessageSource().getMessage(keyValue);
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
	        String label = getMessageSource().getMessage(keyValue);

//	        if ((label == null) || (label.length() < 1)) {
	        if (label == null) {
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
	        controllerCode = null;
	        keyValue=null;
	        image=false;
	    }
	
}
