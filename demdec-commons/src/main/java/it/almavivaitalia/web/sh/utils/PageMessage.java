package it.almavivaitalia.web.sh.utils;


public class PageMessage {

	private final static String DEFALULT_CODE="-1"; 
	
	private String message;
	private String code;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	/*END LOCM*/
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public PageMessage(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}
	
	public PageMessage(String message) {
		super();
		this.message = message;
		this.code = DEFALULT_CODE;
	}
	public static String getDefalultCode() {
		return DEFALULT_CODE;
	}
	
}
