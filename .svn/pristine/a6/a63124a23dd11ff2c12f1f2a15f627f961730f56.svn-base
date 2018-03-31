package it.almavivaitalia.web.sh.taglib;

import javax.servlet.jsp.JspException;

public class LabelTag extends BaseAlmavivaHTMLTag{

	private static final long serialVersionUID = 1L;
	private String path;
	private String labelKey;
	private String label;
	private String labelParam;
	private String mandatoryLabelKey;
	private boolean hidden=false;
	private String value;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	
	public void setLabelParam(String labelParam) {
		this.labelParam = labelParam;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public String getMandatoryLabelKey() {
		return mandatoryLabelKey;
	}
	public void setMandatoryLabelKey(String mandatoryLabelKey) {
		this.mandatoryLabelKey = mandatoryLabelKey;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}

	@Override
	public int doStartTag() throws JspException {
		if (getStyleClass()==null){
			if (hidden){
				setStyleClass("nascosto");
			}else {
				setStyleClass("");
			}
			
		}
		StringBuffer sb = new StringBuffer();
		
		if(labelKey!=null){
			try {
				label=getMessageSource().getMessage(labelKey);
			} catch (Exception e) {
				e.printStackTrace();
				label="Label not found!!!";
			}
		}		
		
		if (labelParam!=null){
			label+=" "+ labelParam;
		}		
		
		if (mandatoryLabelKey!=null){
			label+=getMessageSource().getMessage(mandatoryLabelKey);
		}
		
		if (path!=null){
			sb.append("<label for=\""+path+"\" class=\""+getStyleClass()+"\" style=\""+getStyle()+"\">"+  label +"</label>");	
		}else if(value!=null){
			sb.append("<span class=\""+getStyleClass()+"\" style=\""+getStyle()+"\">"+value+"</span>");
		}else{
			sb.append("<span class=\""+getStyleClass()+"\" style=\""+getStyle()+"\">"+label+"</span>");
		}
		write(sb.toString());
		if (!hidden){write(HTML_LABEL_FOR_SPACING);};
		return EVAL_BODY_INCLUDE;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void release() {
		super.release();
		path=null;
		hidden=false;
		labelKey=null;
		mandatoryLabelKey=null;
	}
	
	@Override
	public int doEndTag() throws JspException {
		release();
		write(HTML_INPUT_SPACING);
		return super.doEndTag();
	}
}
