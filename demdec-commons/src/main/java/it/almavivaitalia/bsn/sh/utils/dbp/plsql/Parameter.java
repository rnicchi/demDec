package it.almavivaitalia.bsn.sh.utils.dbp.plsql;


public class Parameter {
	/* PARAM TYPE */
	private final static int IN = 1;
	private final static int OUT = 2;
	private final static int INOUT = 3;
	
	private int type;
	private int paramType;
	private Object value;
	
	public int getParamType() {
		return paramType;
	}

	public Parameter(Object value) {
		this.value = value;
		this.paramType = IN;
	}
	
	public Parameter(Object value,  int type) {
		this.value = value;
		this.type=type;
		this.paramType = IN;
	}

	public Parameter(Object value, int type, int paramType) {
		this.value = value;
		this.type = type;
		this.paramType = paramType;
	}
	
	/* GETTERS */
	public Object getValue() {
		return value;
	}
	
	public int getType() {
		return type;
	}
	
	public boolean isOutParameter() {
		return this.paramType == (OUT) || this.paramType == (INOUT);
	}

	public boolean isInParameter() {
		return this.paramType == (IN) || this.paramType == (INOUT);
	}

	public static int getIn() {
		return IN;
	}

	public static int getOut() {
		return OUT;
	}

	public static int getInout() {
		return INOUT;
	}
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	/*END LOCM*/	
}
