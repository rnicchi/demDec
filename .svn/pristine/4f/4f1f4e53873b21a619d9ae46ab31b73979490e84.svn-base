package it.almavivaitalia.web.sh.taglib;

import javax.servlet.jsp.JspException;

public class PanelRowTag extends BaseAlmavivaHTMLTag{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelSectionTag parent;
	@SuppressWarnings("unused")
	private int cellsNum=0;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	protected boolean isEndSection(){
		return parent.isEndSection();
	}
	
	
	protected void addCellsNum(int cellsNum) {
		this.cellsNum += cellsNum;
	}
	protected boolean isUseDiv() {
		return parent.isUseDiv();
	}
	
	

	@Override
	public int doStartTag() throws JspException {
		
		//Object parentObj = getParent();
		
		Object parentObj =findAncestorWithClass(this, PanelSectionTag.class);
		
		//if ((parentObj==null) || !(parentObj instanceof PanelSectionTag)){
		if (parentObj==null){
			throw new JspException("PanelRowTag must be defined inside PanelSectionTag.");
		}else {
			parent = (PanelSectionTag)parentObj;
			StringBuffer sb = new StringBuffer();
			sb.append("<!-- PANEL ROW BEGIN -->\n");
			if (isUseDiv()){
				sb.append("<div>\n");
			}else {
				sb.append("<tr>\n"); 
			}
			write(sb.toString());
			return EVAL_BODY_INCLUDE;
		}
	}
	
	@Override
	public void release() {
		super.release();
		cellsNum=0;
	}

	@Override
	public int doEndTag() throws JspException {
		if (isUseDiv()){
			write("</div>\n");
		}else {
			write("</tr>\n");
		}
		write("<!-- PANEL ROW END -->\n");
		release();
		return super.doEndTag();
	}
}
