package it.almavivaitalia.web.sh.taglib.displaytable.extraheader;

import javax.servlet.jsp.JspException;

import it.almavivaitalia.web.sh.taglib.BaseTag;

@SuppressWarnings("serial")
public class TableMultiHeaderTag extends BaseTag{

	private String clazz;
	private String style;		
	
	 /* LOCM */
    @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM4 = 80L;
    @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM2 = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM3 = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM1 = 80L;
	 @SuppressWarnings("unused")
		private static final long serialVersionUIDLOCM5 = 80L;
    /* end LOCM */
	
	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public int doStartTag() throws JspException {
		
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<table ");
			sb.append(clazz==null?"":" class=\""+clazz+"\"");
			sb.append(style==null?"":" style=\""+style+"\"");
			sb.append(" >");
			pageContext.getOut().write(sb.toString());
		}catch(Throwable th){
			throw new JspException(th);
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().write("</table>");
		}catch(Throwable th){
			throw new JspException(th);
		}
		return EVAL_PAGE;
	}
}
