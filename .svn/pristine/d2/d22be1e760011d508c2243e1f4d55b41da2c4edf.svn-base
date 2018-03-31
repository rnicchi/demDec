package it.almavivaitalia.web.sh.taglib;

import it.almavivaitalia.web.sh.utils.WebConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ATag extends SimpleTagSupport {
	private String href;
	private String text;
	private Map<String,String> parameters = new HashMap<String,String>();
	private Map<String,String> tagAttrs = new HashMap<String,String>();
	
	public ATag(){
		
	}
	
	public ATag(String href){
		this.href=href;
	}
	
	public ATag(String href, String text){
		this.href=href;
		this.text=text;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext=(PageContext)getJspContext();
		
		JspWriter writer=pageContext.getOut();
		
		writer.print(toString());
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void addTagAttr(String key, String value){
		tagAttrs.put(key,value);
	}
	
	public void setTagAttrs(Map<String,String> tagAttrs){
		this.tagAttrs=tagAttrs;
	}
	
	public void addParameter(String key, String value){
		this.parameters.put(key,value);
	}
	
	public void setParameters(Map<String,String> tagAttrs){
		this.parameters=tagAttrs;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();

		sb.append("<a href"+WebConstants.UGUALE+"\""+href);
		
		if(parameters.size()>0){
			sb.append(WebConstants.P_INTERROGATIVO);
		}
		
		for(Map.Entry<String, String> entry:parameters.entrySet()){
			sb.append(entry.getKey()+WebConstants.UGUALE+entry.getValue());
			sb.append(WebConstants.AMPERSAND_ENTITY);
		}
		
		//chiudo href
		sb.append("\" ");
		
		for(Map.Entry<String, String> entry:tagAttrs.entrySet()){
			sb.append(entry.getKey()+WebConstants.UGUALE+"\""+entry.getValue()+"\" ");
		}
		
		//chiudo apertura tag
		sb.append(">");
		
		//add text
		sb.append(text);
		
		//chiudo tag
		sb.append("</a>");
		
		return sb.toString();			
	}	
}
