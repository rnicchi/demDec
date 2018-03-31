package it.almavivaitalia.web.sh.taglib;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.web.sh.utils.ContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
public class LinkButtonTag extends BaseAlmavivaHTMLTag{

	
	private String action;
	private String parameter;
	private String parameterValue;
	private String labelKey;	
	private String imageKey;
	private String styleClass;
	private String target;
	private String label;
	private String title;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}


	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}


	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}


	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}


	public void setParameter(String parameter) {
		this.parameter = parameter;
	}


	public void setAction(String action) {
		this.action = action;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public int doStartTag() throws JspException {
		StringBuffer sb = new StringBuffer();
		sb.append("<a href=\"");
		
		
		
		if (!isEmpty(action)){
			sb.append(getRequest().getContextPath());
			if (!action.startsWith("/")){
				sb.append("/");	
			}
			sb.append(action);
			if (action.indexOf("?")<0){
				sb.append("?");
			}else {
				sb.append("&");
			}			
		}else {
			sb.append(getRequest().getContextPath());
			String requestUri = (String)ContextHelper.getModel(OBJECT_INCOMING_REQUEST_URI, (HttpServletRequest)pageContext.getRequest()); 
			if (!requestUri.startsWith("/")){
				sb.append("/");	
			}
			sb.append(requestUri);
			if (requestUri.indexOf("?")<0){
				sb.append("?");
			}else {
				sb.append("&");
			}	
		}
		
	
	
		


		if (parameter != null )
		{	
			sb.append(COMMAND_BUTTON_PREFIX_GET+parameter);
			sb.append("=");
			sb.append(parameterValue);

		}

		sb.append("\"");
		if (target!=null){
			sb.append(" target=\""+target+"\" ");
		}

		
		sb.append(">");
		
		if(labelKey!=null){
			try {
				label=getMessageSource().getMessage(labelKey);
			} catch (Exception e) {
				e.printStackTrace();
				label="Label not found!!!";
			}
		}
		
		if (imageKey!=null){
			String imageRelPath=getMessageSource().getMessage(imageKey);
			sb.append("<img src=\"");
			sb.append(getRequest().getContextPath());
			if ((!imageRelPath.startsWith("\\")) && (!imageRelPath.startsWith("/")) ){sb.append("/");};
			sb.append(imageRelPath);
			sb.append("\" alt=\"");
			sb.append(label);
			
//			if(!isEmpty(styleClass)){
//				sb.append("\" class=\""+styleClass+"\" title=\"");
//			}else{			
//				sb.append("\" class=\"inline\" title=\"");
//			}
			
			
			if(!isEmpty(styleClass)){
				if (title!=null){
					sb.append("\" class=\""+styleClass+"\"  title=\""+title+"\" ");
				}else{
					sb.append("\" class=\""+styleClass+"\" title=\"");
				}
			}else{			
				if (title!=null){
					sb.append("\" class=\"inline\" title=\""+title+"\" ");
				}else{
					sb.append("\" class=\"inline\" title=\"");
				}
			}
			
			
			
			sb.append(label);
			sb.append("\"/>");
		}else {
			sb.append(label);
		}
		sb.append("</a>");	
		
		write(sb.toString());
		 
		
		return SKIP_BODY;
	}
	
	
	  public void release() {
	        super.release();
	        action=null;
			parameter=null;
			parameterValue=null;
			labelKey=null;	
	    }
	  
	 @Override
	public int doEndTag() throws JspException {
		release();
		return EVAL_PAGE;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	 
   
}
