package it.almavivaitalia.web.sh.taglib;






import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.getPropertyValue;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;








public class UseAttributeTag extends BaseTag{
	private static final long serialVersionUID = 1L;

	private String name;
	private String id;
	private String type;
	
	private Object object;
	private String property;
	

	
	public int doStartTag() throws JspException {
		try{
			object=null;
			if (name!=null){
				object = getAttribute(name);
				
				if (object!=null){
					if (property!=null){
						object = getPropertyValue(property, object).toString();
					}
				}
			}
			
		}catch(Exception ex){
			throw new JspException(ex);
		}

		if (object!=null){
			return SKIP_BODY;	
		}else {
			return EVAL_BODY_BUFFERED;
		}
	}
	
	
	
	
	
	public int doAfterBody() throws JspException {
		try {
			if (object==null){
				BodyContent bc= getBodyContent();
				object= (String)bc.getString();
				bc.clearBody();
			}
		}catch(Exception ex){
			throw new JspException(ex);
		}

		return SKIP_BODY;
	}
	
	
	
	public int doEndTag() throws JspException {
		try {
			if (object!=null){
				pageContext.setAttribute(getId(), object);
			}
		}catch(Exception ex){
			throw new JspException(ex);
		}

		return super.doEndTag();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}



	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
