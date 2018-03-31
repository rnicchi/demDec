package it.almavivaitalia.bsn.sh.utils;

import java.util.Locale;



public class ResourceBundleMessageSource {

	 private org.springframework.context.support.ResourceBundleMessageSource messageSource;
	 
	 public org.springframework.context.support.ResourceBundleMessageSource getMessageSource() {
			return messageSource;
		}
	
	//private static ResourceBundleMessageSource nssbMessageSource;
	/*
	private ResourceBundleMessageSource(org.springframework.context.support.ResourceBundleMessageSource messageSource){
		this.messageSource=messageSource;
	}
	
	
	
	
	
	public static ResourceBundleMessageSource getInstance(org.springframework.context.support.ResourceBundleMessageSource messageSource){
		nssbMessageSource=new ResourceBundleMessageSource(messageSource);
		return nssbMessageSource;
	}
	public static ResourceBundleMessageSource getInstance(){
		return nssbMessageSource;
	}	*/
	
	public void setMessageSource(
			org.springframework.context.support.ResourceBundleMessageSource msgSrc) {
		messageSource = msgSrc;
//		System.out.println("++++++++++++++++++++++"+messageSource);
	}
	// messaggio senza argomenti con locale default
	public String getMessage(String code){
		return getMessageSource().getMessage(code, null, null);
	}
	// messaggio con argomenti con locale default
	public String getMessage(String code, String args[]){
		return getMessageSource().getMessage(code, args, null);
	}
	
	// messaggio senza argomenti con locale 
	public String getMessage(String code, Locale locale){
		return getMessageSource().getMessage(code, null, locale);
	}
	// messaggio con argomenti con locale
	public String getMessage(String code, String args[], Locale locale){
		return getMessageSource().getMessage(code, args, locale);
	}
	
	
}
