package it.almavivaitalia.bsn.sh.utils;

import java.io.Serializable;

import org.apache.log4j.Logger;
public class TraceLogger implements Serializable {

    private static final long serialVersionUID = 1L;
    
  
      public static void errorLog(String messaggio , Class<?> classe, Throwable t) {
          Logger logger = Logger.getLogger(classe);
          logger.error(messaggio,t);
       }


      public static void infoLog(String messaggio , Class<?> classe) {
          Logger logger = Logger.getLogger(classe);
          logger.info(messaggio);
       }


      
    public static void debugLog(String messaggio, Class<?> classe) {
    	Logger logger = Logger.getLogger(classe);
        logger.debug(messaggio);
    }


    public static void warnLog(String messaggio, Class<?> classe) {
    	Logger logger = Logger.getLogger(classe);
        logger.warn(messaggio);
    }

}
	