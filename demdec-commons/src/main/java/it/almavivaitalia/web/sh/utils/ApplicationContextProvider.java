package it.almavivaitalia.web.sh.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {
	
	private static ApplicationContext context;
	
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		// Wiring the ApplicationContext into a static method
		context=ctx;
	}

	public static ApplicationContext getApplicationContext() throws BeansException {
		return context;
	}
	
	public static void switchApplicationContext(ApplicationContext ctx) throws BeansException {
		context=ctx;
	}
	


}