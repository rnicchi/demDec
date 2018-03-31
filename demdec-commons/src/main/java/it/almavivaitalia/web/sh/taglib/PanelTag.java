package it.almavivaitalia.web.sh.taglib;

import javax.servlet.jsp.JspException;

public class PanelTag extends BaseAlmavivaHTMLTag{

	
	private static final long serialVersionUID = 1L;
	
	
	private String maxCellsNum;
	private String width;
	private boolean useDiv=false;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	/*END LOCM*/
	
	public void setUseDiv(boolean useDiv) {
		this.useDiv = useDiv;
	}
	
	protected boolean isUseDiv() {
		return useDiv;
	}

	public void setWidth(String width) {
		this.width = width;
	}


	protected String getMaxCellsNum() {
		return maxCellsNum;
	}


	public void setMaxCellsNum(String maxCellsNum) {
		this.maxCellsNum = maxCellsNum;
	}


	@Override
	public int doStartTag() throws JspException {
		if (getStyleClass()==null){
			setStyleClass("paddingtop20");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<!-- PANEL BEGIN -->\n");
		if (isUseDiv()){
			sb.append("<div class=\""+getStyleClass()+"\">\n");
		}else {
			sb.append("<div><table "+(width!=null?"width=\""+width+"\"":"")+" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\""+getStyleClass()+"\">\n");			
		}
			
		
		write(sb.toString());
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public void release() {
		super.release();
		useDiv=false;
	}

	@Override
	public int doEndTag() throws JspException {
		if (useDiv){
			write("</div>\n");
		}else {
			write("</table></div>\n");
		}
		
		//write("<br/>");
		write("<!-- PANEL END -->\n");
		release();
		return super.doEndTag();
	}
}
