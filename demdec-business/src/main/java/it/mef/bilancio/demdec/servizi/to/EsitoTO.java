package it.mef.bilancio.demdec.servizi.to;

import java.util.List;

public class EsitoTO  implements java.io.Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codice;
	private String descrizione;
	private List<String> errors;

	public EsitoTO(){
	}
	
	
	public EsitoTO(String esito1,String descrizioneEsito1){
		this.codice=esito1;
		this.descrizione=descrizioneEsito1;
	}
	
	public EsitoTO(String codice, String descrizione, List<String> errors) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.errors = errors;
	}

	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
