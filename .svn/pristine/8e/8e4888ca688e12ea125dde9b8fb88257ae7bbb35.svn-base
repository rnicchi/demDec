package it.almavivaitalia.bsn.sh.aop;

import it.almavivaitalia.bsn.sh.utils.TraceLogger;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.MessageSource;



public class LogManager {

	private MessageSource resources;
	
	public void setResources(MessageSource resources){
		this.resources=resources;
	}
	
	
	// NOTA il parametro JoinPoint jp (implicito e opzionale) dev'essere il primo dichiarato
	public void debugInizio(JoinPoint jp) {
		Object[] params = {jp.getTarget().getClass().getName(), jp.getSignature().getName()};
		String message = resources.getMessage("inizio.method.log",  params, null);
		TraceLogger.debugLog(message, jp.getTarget().getClass());
	}

	// NOTA il parametro JoinPoint jp (implicito e opzionale) dev'essere il primo dichiarato
	public void debugFine(JoinPoint jp) {
		Object[] params = {jp.getTarget().getClass().getName(), jp.getSignature().getName()};
		String message = resources.getMessage("fine.method.log",  params, null);
		TraceLogger.debugLog(message, jp.getTarget().getClass());
	}

	// NOTA il parametro JoinPoint jp (implicito e opzionale) dev'essere il primo dichiarato
	public void infoInizio(JoinPoint jp) {
		Object[] params = {jp.getTarget().getClass().getName(), jp.getSignature().getName()};
		String message = resources.getMessage("inizio.method.log",  params, null);
		TraceLogger.infoLog(message, jp.getTarget().getClass());
	}

	// NOTA il parametro JoinPoint jp (implicito e opzionale) dev'essere il primo dichiarato
	public void infoFine(JoinPoint jp) {
		Object[] params = {jp.getTarget().getClass().getName(), jp.getSignature().getName()};
		String message = resources.getMessage("fine.method.log",  params, null);
		TraceLogger.infoLog(message, jp.getTarget().getClass());
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
