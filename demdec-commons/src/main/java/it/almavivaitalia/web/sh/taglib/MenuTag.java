package it.almavivaitalia.web.sh.taglib;

import it.almavivaitalia.bilancio.commons.to.MenuTO;
import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.web.sh.utils.BaseContextHelper;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

public class MenuTag extends SimpleTagSupport {
	
	private ResourceBundleMessageSource messageSource;
	private String menuAttrName;
	private String flagMenuPrincipale;
	private String styleClass;
	

	public void setFlagMenuPrincipale(String flagMenuPrincipale) {
		this.flagMenuPrincipale = flagMenuPrincipale;
	}

	public void setMenuAttrName(String menuAttrName) {
		this.menuAttrName = menuAttrName;
	}
	
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
	protected String getMenuAttrName() {
		return menuAttrName;
	}

	protected String getStyleClass() {
		return styleClass;
	}

	protected List<MenuTO> filterMenu(List<MenuTO> listMenu){
		List<MenuTO> listMenu_=new ArrayList<MenuTO>();
		if(listMenu!=null&&!listMenu.isEmpty()){
			for(MenuTO menu:listMenu){
				if(	StringUtils.isEmpty(flagMenuPrincipale)
					||
					(
							
							(flagMenuPrincipale.equals("1") && menu.getFlagMenuPrincipale().equals("1"))
							||
							(flagMenuPrincipale.equals("0") && menu.getFlagMenuPrincipale().equals("0"))
							)
						){
					listMenu_.add(menu);
				}
			}
		}
		return listMenu_;
	}
	
	protected ResourceBundleMessageSource getMessageSource(){
		if (this.messageSource==null){
			this.messageSource=(ResourceBundleMessageSource)getAttribute(BaseSessionAttributes.DEFAULT_MESSAGE_SOURCE);
			if (this.messageSource==null){
				throw new RuntimeException("No attribute found for ResourceBundleMessageSource under key "+BaseSessionAttributes.DEFAULT_MESSAGE_SOURCE);
			}
		}
		return this.messageSource;
	}	
	
	protected Object getAttribute(String name){
		PageContext pageContext = (PageContext) getJspContext();		
		// find in pageContext
		Object object = pageContext.getAttribute(name); 
		if (object==null){
			// find in others scope request
			object = BaseContextHelper.getModel(name, (HttpServletRequest)pageContext.getRequest());
		}
		return object;
	}
		

}
