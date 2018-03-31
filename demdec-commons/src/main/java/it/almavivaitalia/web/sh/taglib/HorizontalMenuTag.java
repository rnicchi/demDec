package it.almavivaitalia.web.sh.taglib;

import it.almavivaitalia.bilancio.commons.to.MenuTO;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.ConstantsRequestMapping;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

public class HorizontalMenuTag extends MenuTag {

	@Override
	public void doTag() throws JspException, IOException {
		
		PageContext pageContext = (PageContext) getJspContext();
		
		@SuppressWarnings("unchecked")
		List<MenuTO> listMenu=filterMenu((List<MenuTO>)pageContext.findAttribute(getMenuAttrName()));
		
		JspWriter writer = pageContext.getOut();
		
		if(listMenu!=null&&!listMenu.isEmpty()){
			writer.print("<div class=\""+getStyleClass()+"\">");
			
			int i=0;
			
			for(MenuTO menu:listMenu){
					
				StringBuilder sb=new StringBuilder();
				sb.append("<strong>");
				
				ATag a=new ATag(((HttpServletRequest)pageContext.getRequest()).getContextPath()+ConstantsRequestMapping.MENU_SBFJ);
				a.addParameter(BaseSessionAttributes.COMMAND_BUTTON_PREFIX_GET+BaseSessionAttributes.PARAMETER_MENU_EXT_MENU_SELECTED, menu.getCodiMenu());

				if(menu.getDescCodiMenu()!=null&&!menu.getDescCodiMenu().equals("")){
					a.setText(menu.getDescCodiMenu());
				}else{
					a.setText(menu.getCodiMenu());
				}
				
				sb.append(a);
				
				sb.append("</strong>");
				
				if(i>=0&&i<listMenu.size()-1){
					sb.append("<strong> | </strong>");
				}
				
				writer.print(sb);	
				
				i++;
			}
			writer.print("</div>");
		}
		
	}
	
	@SuppressWarnings("unused")
	private void foo(){
	}
	@SuppressWarnings("unused")
	private void foo2(){
	}
	@SuppressWarnings("unused")
	private void foo3(){
	}
	@SuppressWarnings("unused")
	private void foo4(){
	}
	@SuppressWarnings("unused")
	private void foo5(){
	}
	@SuppressWarnings("unused")
	private void foo6(){
	}

}
