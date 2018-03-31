package it.almavivaitalia.bilancio.commons.web.security.spring;


import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class LoggingInterceptor implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

	private static Logger logger = null;

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		logger = Logger.getLogger("interceptor");
		logger.log(Level.DEBUG, arg2.getClass().getName() + " - Inizio metodo: "+arg0.getName());
	}

	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		logger = Logger.getLogger("interceptor");
		logger.log(Level.DEBUG, arg3.getClass().getName() + " - Fine metodo: "+arg1.getName());
	}

	public void afterThrowing(Method m, Object[] args, Object target, Throwable ex) {
		logger = Logger.getLogger("interceptor");
		logger.log(Level.DEBUG, target.getClass().getName() + " - Eccezione nel metodo: "+m.getName()+" Exception is: "+ex.getMessage());
	}
	
	/*@Pointcut("execution(* it.cdc.sicr..*.*(..))")
    private void anyOperationInSicrPackage() {

    }

    @Before("anyOperationInSicrPackage()")
    public void logBefore(ProceedingJoinPoint joinPoint) {
    	init();

    	logger = Logger.getLogger("interceptor");
    	
    	logger.log(Level.DEBUG, "Inizio metodo " + joinPoint.getSignature().getDeclaringTypeName() + "#" + joinPoint.getSignature().getName() + "()" );

    }*/


}