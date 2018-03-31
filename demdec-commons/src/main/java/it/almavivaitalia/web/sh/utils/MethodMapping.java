package it.almavivaitalia.web.sh.utils;

public class MethodMapping {

	private String methodName;
	private String controllerCode;
	private String codeAction;
	private boolean toValidate;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	/*END LOCM*/
	
	public MethodMapping(String methodName, String controllerCode,
			String codeAction, boolean toValidate) {
		super();
		this.methodName = methodName;
		this.controllerCode = controllerCode;
		this.codeAction = codeAction;
		this.toValidate = toValidate;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getControllerCode() {
		return controllerCode;
	}
	public void setControllerCode(String controllerCode) {
		this.controllerCode = controllerCode;
	}
	public String getCodeAction() {
		return codeAction;
	}
	public void setCodeAction(String codeAction) {
		this.codeAction = codeAction;
	}
	public boolean isToValidate() {
		return toValidate;
	}
	public void setToValidate(boolean toValidate) {
		this.toValidate = toValidate;
	}
	
	
	
}
