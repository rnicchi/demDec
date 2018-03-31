package it.almavivaitalia.web.sh.taglib.displaytable.extraheader;

import javax.servlet.jsp.JspException;

import it.almavivaitalia.web.sh.taglib.BaseTag;

@SuppressWarnings("serial")
public class HeaderRowTag extends BaseTag{

	@Override
	public int doStartTag() throws JspException {
		
		
		try {
			pageContext.getOut().write("<tr>");
		}catch(Throwable th){
			throw new JspException(th);
		}
		
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().write("</tr>");
		}catch(Throwable th){
			throw new JspException(th);
		}
		return EVAL_PAGE;
	}
}
