package it.almavivaitalia.bilancio.commons.web.security.spring;

import it.almavivaitalia.bilancio.commons.utils.PropertyConfigurer;
import it.almavivaitalia.bilancio.commons.web.security.AuthenticationService;

public class SpringCommonBeanFactory {
	/**
	 * Return the singleton instance of ${entity.name}Service. Service returned
	 * is a proxy to the implementation service bean and inherit transaction
	 * management support and technology implementation injected by the
	 * container. Use this method if you want to keep decoupled from the
	 * technology configured by the container (POJO, EJB, etc...). Instead, if
	 * you are sure that the service is local, then use the syntax
	 * <code>LocalContext.getBean("${entity.nameParam}ServiceImpl")</code> that
	 * give you performance enhancement.
	 * 
	 * @return ${entity.name}Service implementation ready to operate.
	 */
	public static PropertyConfigurer getPropertyConfigurer() {
		return (PropertyConfigurer) LocalContext.getBean("propertyConfigurer-common");
	}

	public static AuthenticationService getUtenteService() {
		return (AuthenticationService) LocalContext.getBean("userService");
	}

}
