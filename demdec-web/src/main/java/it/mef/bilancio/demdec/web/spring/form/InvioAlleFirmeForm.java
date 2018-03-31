package it.mef.bilancio.demdec.web.spring.form;

import it.almavivaitalia.web.sh.form.AbstractForm;

public class InvioAlleFirmeForm extends AbstractForm{

	private String tipoFlusso;
	private String numero;
	private String annoEse;
	
	

	public String getTipoFlusso() {
		return tipoFlusso;
	}
	public void setTipoFlusso(String tipoFlusso) {
		this.tipoFlusso = tipoFlusso;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getAnnoEse() {
		return annoEse;
	}
	public void setAnnoEse(String annoEse) {
		this.annoEse = annoEse;
	}
	
	
	
}
