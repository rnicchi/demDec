package it.almavivaitalia.web.sh.taglib.displaytable.extraheader;

import javax.servlet.jsp.JspException;

import it.almavivaitalia.web.sh.taglib.BaseTag;

@SuppressWarnings("serial")
public class HeaderCellTag extends BaseTag{

	private String labelKey;
	private String colspan;
	private String rowspan;
	private String clazz;
	private String style;	
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
			
	
	public String getRowspan() {
		return rowspan;
	}
	public void setRowspan(String rowspan) {
		this.rowspan = rowspan;
	}
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
	public String getLabelKey() {
		return labelKey;
	}
	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}
	public String getColspan() {
		return colspan;
	}
	public void setColspan(String colspan) {
		this.colspan = colspan;
	}
	
	@Override
	public int doStartTag() throws JspException {
		
		String label = getMessageSource().getMessage(labelKey);
		StringBuffer sb = new StringBuffer();
		sb.append("<th");
		sb.append(clazz==null?"":"  class=\""+clazz+"\"");
		sb.append(style==null?"":"  style=\""+style+"\"");
		sb.append(colspan==null?"":"  colspan=\""+colspan+"\"");
		sb.append(rowspan==null?"":"  rowspan=\""+rowspan+"\"");
		sb.append(">");
		sb.append("<abbr title=\"");
		sb.append(label);
		sb.append("\">");
		sb.append(label);
		sb.append("</abbr></th>");
		try {
			pageContext.getOut().write(sb.toString());
		}catch(Throwable th){
			throw new JspException(th);
		}
		
		
		return SKIP_BODY;
	}
	
	
}
