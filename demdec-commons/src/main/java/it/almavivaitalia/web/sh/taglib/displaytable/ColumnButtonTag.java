package it.almavivaitalia.web.sh.taglib.displaytable;





import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
public class ColumnButtonTag extends BaseColumnTag{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String labelKey;
	private String action;
	private String parameter;
	private String titleKey;
	private boolean condition=true;
	private String imageKey;
	private String headerClass;
	private String clazz;
	private String headerScope;
	
	private String parameters;
	private String paramAlt;
	
	public void setParamAlt(String paramAlt) {
		this.paramAlt = paramAlt;
	}


	public void setHeaderScope(String headerScope) {
		this.headerScope = headerScope;
	}


	public void setClass(String clazz){
		this.clazz=clazz;
	}
	
	
	public void setHeaderClass(String headerClass) {
		this.headerClass = headerClass;
	}

	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}


	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public void setParameter(String parameter) {
		this.parameter = parameter;
	}


	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}


	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	
	
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}


//	private void initDefaults(){
//		
//		if (paramAlt==null){
//			setParamAlt("");
//		}
//		if (parameter==null){
//			setParameter("row");
//		}
//		if (headerClass==null){
//			setHeaderClass("commandsHeader");
//			super.setHeaderClass(headerClass);
//		}
//		if (clazz==null){
//			setClass("commandsRow");
//			super.setClass(clazz);
//		}
//		if (headerScope==null){
//			setHeaderScope("col");
//			super.setHeaderScope(headerScope);
//		}
//		super.setTitleKey(null);
//	}	
	
	public void release(){
		super.release();
		condition=true;
		titleKey=null;
		labelKey=null;
		imageKey=null;
		parameter=null;
		parameters=null;
		headerClass=null;
		clazz=null;
		headerScope=null;
		paramAlt=null;
	}		
	
//	public static void main(String [] args){
//		Pattern p=Pattern.compile("([a-zA-Z0-9]+[,]{1}[a-zA-Z0-9]+)");
//		Matcher m=p.matcher("stp,02,app,");
//		
//		while(m.find()){
//			System.out.println(m.group(1));
//		}
//		
//	}
	
	public int doStartTag() throws JspException {
//		initDefaults();
		
		if (paramAlt==null){
			setParamAlt("");
		}
		if (parameter==null){
			setParameter("row");
		}
		if (headerClass==null){
			setHeaderClass("commandsHeader");
			super.setHeaderClass(headerClass);
		}
		if (clazz==null){
			setClass("commandsRow");
			super.setClass(clazz);
		}
		if (headerScope==null){
			setHeaderScope("col");
			super.setHeaderScope(headerScope);
		}
		super.setTitleKey(null);
			
//			initDefaults(); end

		if (!isEmpty(titleKey)){
			setTitle(getMessageSource().getMessage(titleKey));
		}
		
		if (condition){
		
			StringBuffer sb = new StringBuffer();
			sb.append("<a href=\"");
			sb.append(getRequest().getContextPath());
			if (!action.startsWith("/")){
				sb.append("/");	
			}
			sb.append(action);
			if (action.indexOf("?")<0){
				sb.append("?");
			}else {
				sb.append("&amp;");
			}
			sb.append(COMMAND_BUTTON_PREFIX_GET+parameter);
			sb.append("=");
			sb.append(getCurrentRowIndex());
			
			//EXTRA PARAMETERS
			if(parameters!=null&&parameters.split(",").length>0){
				Pattern p=Pattern.compile("([a-zA-Z0-9]+[,]{1}[a-zA-Z0-9]+)");
				Matcher m=p.matcher(parameters);
				
				while(m.find()){
					String x=m.group(1);
					sb.append("&amp;"+x.split(",")[0]+"="+x.split(",")[1]);
				}
			}
			
			sb.append("\">");
			
			String label=getMessageSource().getMessage(labelKey);
			
			if (imageKey!=null){
				String imageRelPath=getMessageSource().getMessage(imageKey);
				sb.append("<img src=\"");
				sb.append(getRequest().getContextPath());
				if ((!imageRelPath.startsWith("\\")) && (!imageRelPath.startsWith("/")) ){sb.append("/");};
				sb.append(imageRelPath);
				sb.append("\" alt=\"");
				sb.append(label + paramAlt);
				/*if (paramAlt.equals("")){
					sb.append(" riga " + getCurrentRowIndex()+1);
				}*/
				sb.append("\" class=\"inline\" title=\"");
				sb.append(label + paramAlt);
				/*if (paramAlt.equals("")){
					sb.append(" riga " + getCurrentRowIndex()+1);
				}*/
				sb.append("\"/>");
			}else {
				sb.append(label);
			}
			sb.append("</a>");
			
			setValue(sb.toString());
			
			
		}else {
			setValue("");
		}
		
		return super.doStartTag();
		
	}

	
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	
}
