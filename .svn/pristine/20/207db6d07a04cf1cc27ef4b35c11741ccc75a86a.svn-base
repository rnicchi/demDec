package it.almavivaitalia.web.sh.taglib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;

public class AbbreviationTag extends BaseAlmavivaHTMLTag implements
		DynamicAttributes{
	
	private static final long serialVersionUID = 1L;

	private Map<String,Object> tagAttrs = new HashMap<String,Object>();

	private String titleCode;
	private String abbrCode;
	private String title;
	private String abbr;

	
	private static final String ATTR_TEMPLATE = "%s='%s' ";
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;

	/*END LOCM*/
	
	public void setTitleCode(String titleCode) {
		this.titleCode = titleCode;
	}

	public void setAbbrCode(String abbrCode) {
		this.abbrCode = abbrCode;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	@Override
	public void setDynamicAttribute(String uri, String name, Object value)
			throws JspException {
		tagAttrs.put(name, value);		
	}
	
		// generate the <abbr> tag
		public int doStartTag() throws JspException {
			
			try {
				JspWriter out = pageContext.getOut();
				
				// Start the HTML <abbr> tag
				out.print("<abbr ");
				// add mandatory attributes
				
				String abbr =this.abbr==null?getMessageSource().getMessage(abbrCode):this.abbr;
				String title =this.title==null?getMessageSource().getMessage(titleCode):this.title;
				
				out.print("title=\""+title+"\" ");
				
				// add dynamic attributes
				for ( String attrName : tagAttrs.keySet() ) {
					String attrDefinition= String.format(ATTR_TEMPLATE, attrName, tagAttrs.get(attrName));
					out.print(attrDefinition);
				}
				
				out.println(">");

				//add abbreviation
				out.println(abbr);
				
				// End the HTML </abbr> tag
				out.println(" </abbr>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return SKIP_BODY;
		} 


	} // END of AbbreviationTag	
	
