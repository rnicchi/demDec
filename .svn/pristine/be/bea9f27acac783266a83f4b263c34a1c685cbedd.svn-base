package it.almavivaitalia.web.sh.taglib;

import javax.servlet.jsp.JspException;

public class SelectorParentTag extends BaseAlmavivaHTMLTag{

	
  		/**
	     * The name of the generated input field.
	     */
	    private String controllerCode = null;
	    private String keyValue = null;
	    private boolean image = false;
	    private boolean hide = false;
	    private String altPrefix;
		private String altSuffix;
	    

	    public void setHide(boolean hide) {
			this.hide = hide;
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
	/*	public int doStartTag() throws JspException {
	        if (getStyleClass()==null){
	        	setStyleClass("pulsante");
	        }

	        return (SKIP_BODY);
	    }*/

	   

	    public String getControllerCode() {
			return controllerCode;
		}



		public void setControllerCode(String controllerCode) {
			this.controllerCode = controllerCode;
		}



		public String getAltPrefix() {
		return altPrefix;
	}

	public void setAltPrefix(String altPrefix) {
		this.altPrefix = altPrefix;
	}

	public String getAltSuffix() {
		return altSuffix;
	}

	public void setAltSuffix(String altSuffix) {
		this.altSuffix = altSuffix;
	}

	public boolean isImage() {
		return image;
	}



	public boolean isHide() {
		return hide;
	}

	
//	@Override
//	public void release() {
//		super.release();
//		altSuffix=null;
//		altPrefix=null;
//	}
	
	
	  public void release() {
	        super.release();
	        controllerCode = null;
	        keyValue=null;
	        image=false;
	        altSuffix=null;
			altPrefix=null;
	    }


}
