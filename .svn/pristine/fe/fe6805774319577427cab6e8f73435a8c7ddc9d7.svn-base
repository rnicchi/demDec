package it.almavivaitalia.web.sh.taglib;





import it.almavivaitalia.web.sh.utils.PageMessage;
import it.almavivaitalia.web.sh.utils.PageMessages;

import java.util.List;

import javax.servlet.jsp.JspException;

public abstract class AbstractPageMessagesTag extends BaseAlmavivaTag{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	protected abstract String getMessagePrincipale();
	protected abstract String getStyleClass();
	protected abstract void clear();
	protected abstract List<? extends PageMessage> getMessages();
	
	protected PageMessages getPageMessages(){
		return (PageMessages)getAttribute(OBJECT_PAGE_MESSAGES);
	}
	
	@Override
	public int doStartTag() throws JspException {
		if ((getMessages()!=null)&&(!getMessages().isEmpty())){
			
			write("<div class=\""+getStyleClass()+"\">\n");
			write("<strong>"+ getMessagePrincipale()+"</strong>\n");
			write("<ul>\n");
			for (PageMessage message : getMessages()) {
				write("<li>- "+message.getMessage()+"</li>\n");
			}
			write("</ul>\n");
			write("</div>\n");
			clear();
		}
		return SKIP_BODY;
	}



}
