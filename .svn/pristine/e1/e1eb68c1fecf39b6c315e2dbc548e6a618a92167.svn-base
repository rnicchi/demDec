package it.almavivaitalia.bsn.sh.utils;

import java.io.Serializable;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TraceCommonLogger implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(TraceCommonLogger.class);

	public static void traceLog(Level livello, String messaggio, Class<?> classe) {
		logger = Logger.getLogger(classe);
		logger.log(livello, messaggio);
	}

	public static void traceLog(String messaggio, Class<?> classe) {
		logger = Logger.getLogger(classe);
		logger.log(Level.DEBUG, messaggio);
	}

	public static Level getDEBUG() {
		return Level.DEBUG;
	}

	public static Level getINFO() {
		return Level.INFO;
	}

	public static Level getWARNING() {
		return Level.WARN;
	}

	public static Level getERROR() {
		return Level.ERROR;
	}
}
