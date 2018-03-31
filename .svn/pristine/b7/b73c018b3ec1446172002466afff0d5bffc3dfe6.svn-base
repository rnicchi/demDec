package it.almavivaitalia.web.sh.taglib;

import it.almavivaitalia.web.sh.utils.PageMessage;

import java.util.List;

public class PageErrorsTag extends AbstractPageMessagesTag{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@Override
	protected void clear() {
		if (getPageMessages()!=null) getPageMessages().clearErrors();
	}

	@Override
	protected  List<? extends PageMessage> getMessages() {
		return (getPageMessages()!=null)?getPageMessages().getErrors():null;
	}

	@Override
	protected String getStyleClass() {
		return "error";
	}

	@Override
	protected String getMessagePrincipale(){
		return getMessageSource().getMessage("error.msgPrincipale");
		
	}


}
