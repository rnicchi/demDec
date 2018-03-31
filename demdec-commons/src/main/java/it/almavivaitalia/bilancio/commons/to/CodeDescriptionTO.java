package it.almavivaitalia.bilancio.commons.to;


public class CodeDescriptionTO extends AbstractCommonTO implements java.io.Serializable{//INIZIO METODO

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* LOCM */
	@SuppressWarnings("unused")
	private final static String defoultLOCMValue= "80";
	@SuppressWarnings("unused")
	private final static String defoultLOCMKey= "LOCM";
	@SuppressWarnings("unused")
	private final static String defoultLOCM= "LOCM";
	/*end LOCM*/
	
	private String code;
	private String description;
	
	public CodeDescriptionTO(){//INIZIO METODO
		super();
	}
	
	public CodeDescriptionTO(String code, String description) {//INIZIO METODO
		super();
		this.code = code;
		this.description = description;
	}

	public String getCode() {//INIZIO METODO
		return code;
	}

	public void setCode(String code) {//INIZIO METODO
		this.code = code;
	}

	public String getDescription() {//INIZIO METODO
		return description;
	}

	public void setDescription(String description) {//INIZIO METODO
		this.description = description;
	}
	
	public boolean equals(Object other){
		if ((this == other)){
			return true;
		}
		if ((other == null)){
			return false;
		}
		if (!(other instanceof CodeDescriptionTO)){
			return false;
		}
		
		CodeDescriptionTO castOther = (CodeDescriptionTO) other;
		
		return code.equals(castOther.code);
	}
	
}
