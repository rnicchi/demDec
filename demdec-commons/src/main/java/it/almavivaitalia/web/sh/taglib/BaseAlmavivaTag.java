package it.almavivaitalia.web.sh.taglib;

import javax.servlet.jsp.JspException;


/**
 * Contiene i metodi base per le taglib
 * @author 
 *
 */
public class BaseAlmavivaTag extends BaseTag  {

	private static final long serialVersionUID = 1L;

	

	protected void write(String s) throws JspException{
		try {
			pageContext.getOut().write(s);
		}catch (Exception e) {
			throw new JspException(e);
		}
	}
	


	

}
