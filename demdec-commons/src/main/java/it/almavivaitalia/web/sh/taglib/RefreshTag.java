package it.almavivaitalia.web.sh.taglib;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;

import java.io.IOException;

import javax.servlet.jsp.JspException;
public class RefreshTag extends SubmitTag{

		private static final long serialVersionUID = 1L;

    	//------------------------------------------------------------- Properties
	    private String refreshTimeout = "15000";
	    private boolean autoRefresh = false;

		public void setRefreshTimeout(String refreshTimeout) {
			this.refreshTimeout = refreshTimeout;
		}

		public void setAutoRefresh(boolean autoRefresh) {
			this.autoRefresh = autoRefresh;
		}
	    // ------------------------------------------------------------- Properties
		
		/**
	     * Process the end of this tag. <p> Support for Indexed property since
	     * Struts 1.1
	     *
	     * @throws JspException if a JSP exception has occurred
	     */
	    public int doEndTag() throws JspException {
	    	if(isEmpty(getId())){
	    		setId("refreshButtonId");
	    	}
	     // Generate an HTML element
	        StringBuffer results = new StringBuffer();
	        results.append(getElementOpen());
	        prepareAttribute(results, "name", prepareName());
	        prepareButtonAttributes(results);
	        results.append(prepareEventHandlers());
	        results.append(prepareStyles());
	        prepareOtherAttributes(results);
	        
	        //add id attribute
	        results.append(" id='"+getId()+"' ");
	        
	        //close tag
	        results.append(getElementClose());
	        
	        if(autoRefresh){
		    	//add script element
		    	prepareRefreshScript(results);
	        }
        	
	        try {
				pageContext.getOut().print(results.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        	release();
	        
        	return (EVAL_PAGE);
	        
	        
	    }

	    /**
	     * Render the value element
	     *
	     * @param results The StringBuffer that output will be appended to.
	     */
	    protected void prepareRefreshScript(StringBuffer results) throws JspException {
	    	results.append("<script type=\"text/javascript\">");
	    	results.append("setTimeout(\"document.getElementById('"+getId()+"').click()\",'"+refreshTimeout+"');");
	    	results.append("document.getElementById('refreshMessage').style.display='block';");
	    	results.append("</script>");
	    }
	    
	    public void release() {
	        super.release();
	        refreshTimeout = "15000";
		    autoRefresh = false;
	    }	    

}
