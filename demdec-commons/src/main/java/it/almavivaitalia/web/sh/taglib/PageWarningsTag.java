package it.almavivaitalia.web.sh.taglib;

import it.almavivaitalia.web.sh.utils.PageMessage;

import java.util.List;

public class PageWarningsTag extends AbstractPageMessagesTag{


	private static final long serialVersionUID = 1L;
	

	@Override
	protected void clear() {
		if (getPageMessages()!=null) getPageMessages().clearWarnings();
	}

	@Override
	protected  List<? extends PageMessage> getMessages() {
		return (getPageMessages()!=null)?getPageMessages().getWarnings():null;
	}

	@Override
	protected String getStyleClass() {
		return "warning";
	}


	
	@Override
	protected String getMessagePrincipale(){
		return getMessageSource().getMessage("warninig.msgPrincipale");
		
	}


}
