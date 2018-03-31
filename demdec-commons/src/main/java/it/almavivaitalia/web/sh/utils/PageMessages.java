package it.almavivaitalia.web.sh.utils;

import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;

public class PageMessages{

	
	private List<PageError> errors;
	private List<PageWarning> warnings;
	private List<PageInfo> infos;
	
	
	private ResourceBundleMessageSource messageSource;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	public List<PageError> getErrors() {
		return errors;
	}

	public List<PageWarning> getWarnings() {
		return warnings;
	}

	public List<PageInfo> getInfos() {
		return infos;
	}

	public PageMessages(ResourceBundleMessageSource messageSource){
		this.messageSource=messageSource;
		errors=new ArrayList<PageError>();
		warnings=new ArrayList<PageWarning>();
		infos=new ArrayList<PageInfo>();
	}

	public String getMessageFromBundle(String code, String... args){
		if (this.messageSource==null){
			throw new RuntimeException("No ResourceBundleMessageSource in property MessageSource");
		}
		return messageSource.getMessage(code, args);
	}
	public void addError(String code, String... args){
		errors.add(new PageError(getMessageFromBundle(code, args)));
	}
	public void addWarning(String code, String... args){
		warnings.add(new PageWarning(getMessageFromBundle(code, args)));
	}
	public void addInfo(String code, String... args){
		infos.add(new PageInfo(getMessageFromBundle(code, args)));
	}

	public void clearAll(){
		clearInfos();
		clearErrors();
		clearWarnings();
	}
	public void clearInfos(){
		infos.clear();
	}
	public void clearErrors(){
		errors.clear();
	}
	public void clearWarnings(){
		warnings.clear();
	}

}
