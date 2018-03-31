package it.almavivaitalia.bsn.sh.aop;

import it.almavivaitalia.bsn.sh.manager.exception.DuplicateKeyException;
import it.almavivaitalia.bsn.sh.manager.exception.ManagerException;
import it.almavivaitalia.bsn.sh.utils.TraceLogger;

import java.lang.reflect.InvocationTargetException;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.MessageSource;


public class ExceptionManager {

	private MessageSource resources;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	public void setResources(MessageSource resources){
		this.resources=resources;
	}
	
	
	// rilancio come manager exeption
	// NOTA il parametro JoinPoint jp (implicito e opzionale) dev'essere il primo dichiarato
	
	/*
	public void manageManagerException(JoinPoint jp, Throwable throwable) throws ManagerException{
		
		if (throwable instanceof ObjectNotFoundException){
			throw (ObjectNotFoundException)throwable;
		}else {
			throwable.printStackTrace();
			Object[] params = {jp.getTarget().getClass().getName(), jp.getSignature().getName(), throwable.toString()};
			//String message = resources.getMessage("exception.log",  params, null);
			throw new ManagerException(throwable);
		}
	}
	
	*/

	
	// rilancio come manager exeption
	// NOTA il parametro JoinPoint jp (implicito e opzionale) dev'essere il primo dichiarato
	public void newManageManagerException(JoinPoint jp, Throwable throwable) throws Throwable{
	//	throwable.printStackTrace();
		Object[] params = {jp.getTarget().getClass().getName(), jp.getSignature().getName(), throwable.toString()};
		String message = resources.getMessage("exception.log",  params, null);
		sendException(throwable,message,jp.getTarget().getClass());
	}

	
	private void sendException(Throwable throwable,String message,Class<?> classe)throws Throwable{
		
		Throwable original = throwable;
		if (throwable instanceof InvocationTargetException){
			original=((InvocationTargetException) throwable).getTargetException();
		}
		if (original instanceof ManagerException){
			throw original;
		}else if (original instanceof org.springframework.dao.DataIntegrityViolationException  ||
				original instanceof org.hibernate.exception.ConstraintViolationException){
			throw new DuplicateKeyException(original);
		}else {
			TraceLogger.errorLog(message,classe,original);
			throw new ManagerException(message,original);
		}
	}
	
/*	
	public Object log(ProceedingJoinPoint pjp) throws Throwable{
		String callerId = " - "+ pjp.getTarget().getClass().getName()+"."+ pjp.getSignature().getName();
		Object[] o=	pjp.getArgs();
		StringBuffer argsInfo=null;
		if (o!=null){
			argsInfo = new StringBuffer();
			for(int i=0; i<o.length; i++){
				Object arg = o[i];
				argsInfo.append(arg.getClass().getName());
				argsInfo.append(" : ");
				argsInfo.append(arg.toString());
				argsInfo.append("\n");
			}
		}
		String startMessage = resources.getMessage("log.start", null, "Default", null);
		System.out.println(startMessage+callerId);
		if (argsInfo!=null){
			String argsMessage = resources.getMessage("log.args", null, "Default", null);
			System.out.println(argsMessage);
			System.out.println(argsInfo);
		}
		Object ret=null;
		try {
			ret = pjp.proceed();
			
			String successMessage = resources.getMessage("log.success", null, "Default", null);
			System.out.println(successMessage);
			if (ret!=null){
				String retMessage = resources.getMessage("log.ret", null, "Default", null);
				System.out.println(retMessage);
				System.out.println(ret.getClass().getName()+" : "+ret.toString());
			}
			
			
			
		}catch (Throwable t) {
			String[] params = {t.getMessage()};
			String throwMessage = resources.getMessage("log.throw", params, "Default", null);
			System.out.println(throwMessage);
			throw t;
		}
		String endMessage = resources.getMessage("log.end", null, "Default", null);
		System.out.println(endMessage+callerId);
		return ret;
	}
*/
	
	
}
