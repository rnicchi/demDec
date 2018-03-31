package it.almavivaitalia.web.sh.taglib;

import it.almavivaitalia.web.sh.utils.PageMessage;

import java.util.List;

public class PageInfosTag extends AbstractPageMessagesTag{

	
	
	private static final long serialVersionUID = 1L;


	

	@Override
	protected void clear() {
		if (getPageMessages()!=null) getPageMessages().clearInfos();
	}

	@Override
	protected  List<? extends PageMessage> getMessages() {
		return (getPageMessages()!=null)?getPageMessages().getInfos():null;
	}

	@Override
	protected String getStyleClass() {
		return "success";
	}
	
	@Override
	protected String getMessagePrincipale(){
		return getMessageSource().getMessage("info.msgPrincipale");
		
	}

	
}
