package it.almavivaitalia.bsn.sh.manager.exception;

public class ObjectNotFoundException extends ApplicationException{

	private static final long serialVersionUID = 1L;

	private Object object;
	private int code;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	/*END LOCM*/
	
	public ObjectNotFoundException(Object object, int code) {
		super();
		this.object=object;
		this.code=code;
	}

	public int getCode() {
		return code;
	}

	public Object getObject() {
		return object;
	}


	
	
}
