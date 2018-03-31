package it.mef.bilancio.demdec.to;



public class CodeDescriptionTitleTO extends AbstractDemTO{//INIZIO METODO

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
	private String title;
	
	public CodeDescriptionTitleTO(){//INIZIO METODO
		super();
	}//END
	
	public CodeDescriptionTitleTO(String code, String description) {//INIZIO METODO
		super();
		this.code = code;
		this.description = description;
	}//END

	public CodeDescriptionTitleTO(String code, String description,String title) {//INIZIO METODO
		super();
		this.code = code;
		this.description = description;
		this.title = title;
	}//END

	public String getCode() {//INIZIO METODO
		return code;
	}//END

	public void setCode(String code) {//INIZIO METODO
		this.code = code;
	}//END

	public String getDescription() {//INIZIO METODO
		return description;
	}//END

	public void setDescription(String description) {//INIZIO METODO
		this.description = description;
	}//END

	public String getTitle() {//INIZIO METODO
		return title;
	}//END

	public void setTitle(String title) {//INIZIO METODO
		this.title = title;
	}//END

	public boolean equals(Object obj){
		CodeDescriptionTitleTO other=(CodeDescriptionTitleTO)obj;
		if(other.getCode().equals(this.getCode())){
			return true;
		}//END
		return false;
	}//END
}//END
