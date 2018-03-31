package it.almavivaitalia.web.sh.taglib;

import javax.servlet.jsp.JspException;

public class PanelSectionTag extends BaseAlmavivaHTMLTag{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titleKey;
	private PanelTag parent;
	private String sectionName;
	private int rowNum=0;
	private int maxRowNum=0;
	private boolean useSeparator=true;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	/*END LOCM*/
	
	public boolean isUseSeparator() {
		return useSeparator;
	}


	public void setUseSeparator(boolean useSeparator) {
		this.useSeparator = useSeparator;
	}


	protected boolean isUseDiv() {
		return parent.isUseDiv();
	}
	

	protected boolean isEndSection(){
		return rowNum==(maxRowNum-1);
	}
	
	public void setMaxRowNum(String maxRowNum) {
		this.maxRowNum = Integer.parseInt(maxRowNum);
	}


	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}
	
	
	@Override
	public int doStartTag() throws JspException {
		
		//Object parentObj = getParent();
		Object parentObj =findAncestorWithClass(this, PanelTag.class);
		//if ((parentObj==null) || !(parentObj instanceof PanelTag)){
		if (parentObj==null){
			throw new JspException("PanelSectionTag must be inside PanelTag.");
		}else {
			parent = (PanelTag)parentObj;
			StringBuffer sb = new StringBuffer();
			if (titleKey!=null){
				
				if (getStyleClass()==null){
					setStyleClass("testo11tit paddingtop10");
				}
				sectionName=getMessageSource().getMessage(titleKey);
				
				sb.append("<!-- PANEL SECTION " + sectionName + " BEGIN -->\n");
				if (isUseDiv()){
					sb.append("<div class=\""+getStyleClass()+"\">"+sectionName+"</div>");	
				}else {
					sb.append("<tr><td colspan=\""+parent.getMaxCellsNum()+"\" class=\""+getStyleClass()+"\">"+sectionName+"</td></tr>");
				}
				
				
			}else {
				sb.append("<!-- PANEL SECTION BEGIN -->\n");
			}
			write(sb.toString());	
			return EVAL_BODY_INCLUDE;
		
		}
	}
	
	@Override
	public void release() {
		super.release();
		titleKey=null;
		sectionName=null;
		rowNum=0;
		maxRowNum=0;
		useSeparator=true;
		
	}

	@Override
	public int doEndTag() throws JspException {
		if (useSeparator){
		
			if (isUseDiv()){
				write("<div class=\"sectionSeparator\">&nbsp;</div>");	
			}else {
				write("<tr><td colspan=\""+parent.getMaxCellsNum()+"\" class=\"lineabianca paddingbottom10\">&nbsp;</td></tr>");
			}
		}
		write("<!-- PANEL SECTION " + sectionName + " END -->\n");
		release();
		return super.doEndTag();
	}
}
