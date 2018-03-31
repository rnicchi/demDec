package it.almavivaitalia.web.sh.utils;

import javax.servlet.http.HttpServletRequest;

import it.almavivaitalia.web.sh.utils.BaseContextHelper;


public class ContextHelper extends BaseContextHelper{

	public static PageMessages getPageMessages(HttpServletRequest request){
		return (PageMessages)getModel(OBJECT_PAGE_MESSAGES, request);
	}
	public static void addError(HttpServletRequest request, String code, String... args){
		getPageMessages(request).addError(code, args);
	}
	public static void addWarning(HttpServletRequest request,String code, String... args){
		getPageMessages(request).addWarning(code, args);
	}
	public static void addInfo(HttpServletRequest request, String code, String... args){
		getPageMessages(request).addInfo(code, args);
	}
	
	
}
