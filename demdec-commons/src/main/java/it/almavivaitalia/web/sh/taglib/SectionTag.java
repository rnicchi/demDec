package it.almavivaitalia.web.sh.taglib;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;

import javax.servlet.jsp.JspException;
public class SectionTag extends BaseAlmavivaHTMLTag{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titleKey;
	private String freeText;
	private String sectionName;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	/*END LOCM*/
	
	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}
	
	
	@Override
	public int doStartTag() throws JspException {
		if (getStyleClass()==null){
			setStyleClass("titolo");
		}
		sectionName=getMessageSource().getMessage(titleKey);
		StringBuffer sb = new StringBuffer();
		sb.append("<!-- SECTION " + sectionName + " BEGIN -->\n");
		sb.append("<div class=\"");
		sb.append(getStyleClass());
		sb.append("\">");
		sb.append(sectionName);
		if(!isEmpty(freeText)){
			sb.append(freeText);
		}
		sb.append("</div>\n");
		
		write(sb.toString());
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public void release() {
		super.release();
		titleKey=null;
		sectionName=null;
	}

	@Override
	public int doEndTag() throws JspException {
		write("\n<br/>");
		write("<!-- SECTION " + sectionName + " END -->\n");
		release();
		return super.doEndTag();
	}
}
