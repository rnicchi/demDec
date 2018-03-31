package it.almavivaitalia.bilancio.commons.web.spring.controller.exception;

public class SecurityException extends Exception{

	private static final long serialVersionUID = 1L;

	public SecurityException() {
		super();
	}

	public SecurityException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecurityException(String message) {
		super(message);
	}

	public SecurityException(Throwable cause) {
		super(cause);
	}

	
	
}
