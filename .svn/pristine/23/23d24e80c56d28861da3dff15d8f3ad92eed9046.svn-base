package it.almavivaitalia.web.sh.taglib;


import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.ConstantsRequestMapping;
import it.almavivaitalia.web.sh.utils.navigator.NLink;
import it.almavivaitalia.web.sh.utils.navigator.NTree;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class NavigatorTag extends BaseTag{

	private String navigatorAttrName;
	private boolean writeFullPath;
	private String styleClass;
	
	public int doStartTag() throws JspException {
		
		
		try{
			StringBuffer sb = new StringBuffer();
			
/*			if(writeFullPath){
				//se l'applicazione è stata invocata da un'altra app sarà presente in sessione l'eventuale percorso
				String applicationCodeSrc=(String)pageContext.getAttribute(BaseSessionAttributes.APPLICATION_CODE_SRC, PageContext.SESSION_SCOPE);
				
				if(applicationCodeSrc!=null){
					@SuppressWarnings("unchecked")
					Map<String, String> descCodimenuMap=(Map<String, String>)pageContext.getAttribute(BaseSessionAttributes.DESC_CODI_MENU_MAP, PageContext.SESSION_SCOPE);;
					for(String appCode:applicationCodeSrc.split(",")){
						
						ATag a=new ATag(((HttpServletRequest)pageContext.getRequest()).getContextPath()+ConstantsRequestMapping.LOGOUT_URL);
						a.addParameter(APPLICATION_CODE, appCode);
						a.addTagAttr("style", "text-transform:uppercase;");
						
						if(descCodimenuMap!=null&&descCodimenuMap.containsKey(appCode)){
							a.setText(descCodimenuMap.get(appCode));
						}else{
							a.setText(appCode);
						}
						
						sb.append(a);
						
						sb.append(" > ");
					}
				}
			}
*/			
			NLink nodeIdObject=(NLink)getAttribute(NODE_NAVIGATOR_CURRENT);
			
			if (nodeIdObject!=null){
				Object treeObject = getAttribute(navigatorAttrName);
				if (treeObject!=null){
					String contextPath = ((HttpServletRequest)pageContext.getRequest()).getContextPath();
					NTree tree = (NTree)treeObject;
					sb.append(tree.renderHTMLNodePath((String)nodeIdObject.getId(), contextPath));
				}else {
					pageContext.getOut().write("Navigator: ??? "+navigatorAttrName+" ???");
				}
			}
			if(sb.length()>0){
				pageContext.getOut().write("<div class=\""+styleClass+"\">&nbsp;</div>");
				pageContext.getOut().write("<span class=\"nascosto\">Ti trovi in:</span>");
				pageContext.getOut().write("<span class=\"path_N\">");
				pageContext.getOut().write(sb.toString());
				pageContext.getOut().write("</span>");
			}
			
		}catch(Exception ex){
			throw new JspException(ex);
		}
		
		return SKIP_BODY;	
	}

	public void setNavigatorAttrName(String navigatorAttrName) {
		this.navigatorAttrName = navigatorAttrName;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public void setWriteFullPath(boolean writeFullPath) {
		this.writeFullPath = writeFullPath;
	}
	
	/*LOCM*/
								private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	/*END LOCM*/	
}
