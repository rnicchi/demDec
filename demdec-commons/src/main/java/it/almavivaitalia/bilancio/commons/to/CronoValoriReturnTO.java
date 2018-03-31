package it.almavivaitalia.bilancio.commons.to;

public class CronoValoriReturnTO extends AbstractCommonTO implements java.io.Serializable {//INIZIO METODO
	
	/* LOCM*/
	@SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM = 80L;
	@SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM2 = 80L;
	/*END LOCM*/
	
	private static final long serialVersionUID = 1L;
	private int codice;
 	private String message;
 	
	 
	public int getCodice() {//INIZIO METODO
		return codice;
	}
	public void setCodice(int codice) {//INIZIO METODO
		this.codice = codice;
	}
	public String getMessage() {//INIZIO METODO
		return message;
	}
	public void setMessage(String message) {//INIZIO METODO
		this.message = message;
	}		 
}
