package it.almavivaitalia.web.sh.taglib;

import javax.servlet.jsp.JspException;

public class PanelCellTag extends BaseAlmavivaHTMLTag{

	private static final long serialVersionUID = 1L;
	
	private PanelRowTag parent;
	private String colspan="1";
	private String titleKey;
	private String labelFor;
	private String title;
	
	
	private final static String LABEL_SEPARATOR="&nbsp;";
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	protected boolean isUseDiv() {
		return parent.isUseDiv();
	}
	
	
	public String getTitle(){
		return title;
	}
	public String getLabelFor() {
		return labelFor;
	}

	public void setLabelFor(String labelFor) {
		this.labelFor = labelFor;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	public void setColspan(String colspan) {
		this.colspan = colspan;
	}

	
	
	
	

	@Override
	public int doStartTag() throws JspException {
		
		Object parentObj = findAncestorWithClass(this, PanelRowTag.class);
		if ((parentObj==null) || !(parentObj instanceof PanelRowTag)){
			throw new JspException("PanelCellTag must be defined inside PanelRowTag.");
		}else {
			parent = (PanelRowTag)parentObj;
			
			StringBuffer sb = new StringBuffer();
			sb.append("<!-- PANEL CELL BEGIN -->\n");
			


			if (isUseDiv()){
				sb.append("<div");
				if (getStyleClass()!=null){
					sb.append(" class=\""+getStyleClass()+"\"");
				}			
				sb.append(">");
			}else {
				
				sb.append("<td align=\"left\" ");
				if (!colspan.equals("1")){
					sb.append("colspan=\""+colspan+"\" ");
				}
				parent.addCellsNum(Integer.parseInt(colspan));
				
				if (getStyleClass()==null){
					setStyleClass("paddingtop10 nowrap");
				}			
				
				sb.append("class=\""+getStyleClass()+"\" ");				
				
				if(getStyle()!=null&&!"".equals(getStyle())){
					sb.append(" style=\""+getStyle()+"\" ");
				}
				
				sb.append(">");
			}
			
			if (titleKey!=null){
				title=getMessageSource().getMessage(titleKey);
				if (labelFor==null){
					sb.append("<label class=\"testo11 bold\">"+title+"</label>");	
				}else {
					sb.append("<label for=\""+labelFor+"\" class=\"testo11 bold\">"+title+"</label>");	
				}
				sb.append(LABEL_SEPARATOR);
			}
			write(sb.toString());
			return EVAL_BODY_INCLUDE;
		}
	}
	
	@Override
	public void release() {
		super.release();
		colspan="1";
		labelFor=null;
		titleKey=null;
		title=null;
	}

	@Override
	public int doEndTag() throws JspException {
		if (isUseDiv()){
			write("</div>\n");
		}else {
			write("</td>\n");
		}
		write("<!-- PANEL CELL END -->\n");
		release();
		return super.doEndTag();
	}
}
