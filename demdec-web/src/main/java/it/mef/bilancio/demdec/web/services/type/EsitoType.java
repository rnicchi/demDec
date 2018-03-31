package it.mef.bilancio.demdec.web.services.type;

import it.mef.bilancio.demdec.servizi.to.EsitoTO;

import java.util.ArrayList;
import java.util.List;

public class EsitoType  implements java.io.Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codice;
	private String descrizione;
	private List<String> errors;

	public EsitoType(){
	}
	
	
	public EsitoType(String esito1,String descrizioneEsito1){
		this.codice=esito1;
		this.descrizione=descrizioneEsito1;
	}

	
	public EsitoType(String codice, String descrizione, String error) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.errors = new ArrayList<String>();
		this.errors.add(error);
	}

	
	public EsitoType(EsitoTO to) {
		this.codice = to.getCodice();
		this.descrizione = to.getDescrizione();
		this.errors = to.getErrors();
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
