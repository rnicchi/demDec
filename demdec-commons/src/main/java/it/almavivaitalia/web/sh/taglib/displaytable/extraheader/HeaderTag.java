package it.almavivaitalia.web.sh.taglib.displaytable.extraheader;

import javax.servlet.jsp.JspException;

import it.almavivaitalia.web.sh.taglib.BaseTag;

@SuppressWarnings("serial")
public class HeaderTag extends BaseTag{

	
	
	@Override
	public int doStartTag() throws JspException {
		
		
		try {
			pageContext.getOut().write("<thead>");
		}catch(Throwable th){
			throw new JspException(th);
		}
		
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			//pageContext.getOut().write("</THEAD>");
		}catch(Throwable th){
			throw new JspException(th);
		}
		return EVAL_PAGE;
	}
}
