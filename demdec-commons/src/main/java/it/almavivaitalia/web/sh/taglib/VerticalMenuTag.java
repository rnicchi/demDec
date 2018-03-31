package it.almavivaitalia.web.sh.taglib;

import it.almavivaitalia.bilancio.commons.to.ItemTO;
import it.almavivaitalia.bilancio.commons.to.MenuTO;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.ConstantsRequestMapping;
import it.almavivaitalia.web.sh.utils.WebConstants;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

public class VerticalMenuTag extends MenuTag {
	private String codiProfilo;
	@SuppressWarnings("unused")
	private String selectedItemId;
	@SuppressWarnings("unused")
	private String listStyleClass;
	
	private String getText(String codiItem, String descItem){
		String text="Label not Found!!!";
		try{
			text=descItem==null?getMessageSource().getMessage("item."+codiItem):descItem;
		}catch(Throwable thr){
			//thr.printStackTrace();
		}
		return text;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		
		String contextPath=((HttpServletRequest)pageContext.getRequest()).getContextPath();
		
		MenuTO menu=(MenuTO) pageContext.findAttribute(getMenuAttrName());
		
//		NTree tree= (NTree) pageContext.findAttribute(BaseSessionAttributes.NAVIGATOR);;

		List<ItemTO> itemList=menu.getItemList();
		
		if(itemList!=null&&!itemList.isEmpty()){
			JspWriter writer = pageContext.getOut();
			writer.print("<!-- MENU LATERALE -->");
			writer.print("<nav class=\"top-bar\">");
			writer.print("<ul class=\"title-area\">");
			writer.print("<!-- Title Area -->");
			writer.print("<li class=\"name\">");
			writer.print("<h1 id=\"logo\" class=\"hide-text\"><a href=\"#\">MEF - Ragioneria Generale dello Stato</a></h1>");
			writer.print("</li>");
			writer.print("<!-- Icona e testo per il menu su mobile. Rimuovere la classe \"menu-icon\" per eliminare l'icona. Rimuovere il testo \"Menu\" per avere solo l'icona -->");
			writer.print("<li class=\"toggle-topbar menu-icon\"><a href=\"#\"><span>Menu</span></a></li>");
			writer.print("</ul>");
			writer.print("<section style=\"left: 0%;\" class=\"top-bar-section\">");
			writer.print("<ul class=\"left\">");
			
/*			writer.print("<div class=\""+getStyleClass()+"\">");
			writer.print("<map title=\"Menu\" id=\"Menu\">");
			writer.print("<div class=\"nascosto\">");
			writer.print("<a href=\"#contenuto\">");
			writer.print(getMessageSource().getMessage("acc.menuHidden"));
			writer.print("</a>");
			writer.print("</div>");
			
			writer.print("<ul class=\""+listStyleClass+"\">");
*/			
			for(ItemTO item:itemList){
				boolean contains=false;
				//verifico se l'utente � abilitato
				for(ProfiloTO profilo:item.getProfiloList()){
					//verifico se l'utente � abilitato
					if(profilo.getCodiProfilo().equals(codiProfilo)){
						contains=true;
						break;
					}
				}			
				if(contains){
					writer.print(scriviVoce(item,contextPath));
					
/*					if(item.getId().equals(selectedItemId)){
						writer.print("<li class=\"basemenu_on\">");
						writer.print("<img src=\""+contextPath+"/img/pelenco_menu.png\" class=\"inline\" alt=\"\"/>"+getText(item.getCodiItem(), item.getDescItem()));
						writer.print("</li>");
					}else{
						writer.print("<li class=\"basemenu_off\">");
						writer.print("<img src=\""+contextPath+"/img/pelenco_menu.png\" class=\"inline\" alt=\"\"/>");
						
						//action abilitata
						if(item.getAction()!=null && item.getAction().getFlagActive().equals(Short.valueOf("1"))){
							
							ATag a=new ATag();
							a.setHref(contextPath+ConstantsRequestMapping.MENU_SBFJ);
							a.addParameter(BaseSessionAttributes.COMMAND_BUTTON_PREFIX_GET+WebConstants.PARAMETER_MENU_ACTION_SELECTED, item.getAction().getCodiAction());
							a.setText(getText(item.getCodiItem(), item.getDescItem()));
							
							writer.print(a);							
							
						}
						//end action abilitata
						
						//action NON abilitata
						if(item.getAction()!=null && item.getAction().getFlagActive().equals(Short.valueOf("0"))){
							writer.print("<nssb:label labelKey=\""+
									getText(item.getCodiItem(), item.getDescItem())+"\" styleClass=\"inactive\"/>");
						}	
						//end action NON abilitata
						
						if(item.getMenu()!=null){
							ATag a=new ATag();
							a.setHref(contextPath+ConstantsRequestMapping.MENU_SBFJ);
							a.addParameter(BaseSessionAttributes.COMMAND_BUTTON_PREFIX_GET+WebConstants.PARAMETER_MENU_MENU_SELECTED, menu.getCodiMenu());
							a.setText(getText(item.getCodiItem(), item.getDescItem()));
							
							writer.print(a);
							
						}
						
						if(item.getMenu()==null && item.getAction()==null ){
							
							ATag a=new ATag();
							a.setHref(contextPath+ConstantsRequestMapping.MENU_SBFJ);
							a.addParameter(BaseSessionAttributes.COMMAND_BUTTON_PREFIX_GET+WebConstants.PARAMETER_MENU_ITEM_SELECTED, item.getId().toString());
							a.setText(getText(item.getCodiItem(), item.getDescItem()));
							
							writer.print(a);							
						}						
						
						writer.print("</li>");					
					}
*/				}
			}
			
			
	
			writer.print("<li class=\"divider\"></li>");
			
			writer.print("<li><a href=\"help.htm\" target=\"_blank\">Manuale</a></li>");
			   
			writer.print("</ul>");
			writer.print("</section>");
			
			writer.print("</nav>");
			
/*			writer.print("</ul>");
			writer.print("</map>");
			writer.print("<a id=\"contenuto\"></a>");
			writer.print("</div>");
*/		}
		
	}
	
	private String scriviVoce(ItemTO item, String contextPath){
		String result = "";
		if (item.getItemList()!=null&&item.getItemList().size()>0){
			result += "<li class=\"has-dropdown\">";
			ATag a=new ATag();
			a.setHref("#");
			//a.addParameter("");
			a.setText(getText(item.getCodiItem(), item.getDescItemEstesa()));
			result += a;
			
			result += "<ul class=\"dropdown\"><li class=\"title back js-generated\"><h5><a href=\"#\">� Indietro</a></h5></li>";
			for(ItemTO to: item.getItemList()){
				result += scriviVoce(to,contextPath);
			}
			
			
			
			result +="</ul>";
			
			/*****start screen reader****/
			result +="<div class='reader'><ul>";
			for(ItemTO to: item.getItemList()){
				for (ProfiloTO profilo: to.getProfiloList()){
					if (profilo.getCodiProfilo().equals(codiProfilo)){
						result += scriviVoce(to,contextPath);				
					}
				}
			}
			result +="</ul></div>";
			/*****end screen reader*****/
			
			result +="</li>";
			
		} else {
			for (ProfiloTO to:item.getAction().getProfiloList()){
				//verifico se l'utente � abilitato
				if(to.getCodiProfilo().equals(codiProfilo)){
					result += "<li>";
					ATag a=new ATag();
					a.setHref(contextPath+ConstantsRequestMapping.MENU_SBFJ);
					a.addParameter(BaseSessionAttributes.COMMAND_BUTTON_PREFIX_GET+WebConstants.PARAMETER_MENU_ACTION_SELECTED, item.getAction().getCodiAction());
					a.setText(getText(item.getCodiItem(), item.getDescItemEstesa()));
					result += a;
					result +="</li>";
					break;
				}
			}
		}
		
		return result;
	}
	
	public void setCodiProfilo(String codiProfilo) {
		this.codiProfilo = codiProfilo;
	}

	public void setSelectedItemId(String selectedItemId) {
		this.selectedItemId = selectedItemId;
	}

	public void setListStyleClass(String listStyleClass) {
		this.listStyleClass = listStyleClass;
	}
}
