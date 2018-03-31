package it.almavivaitalia.bilancio.commons.web.form;

import it.almavivaitalia.web.sh.form.AbstractForm;

public class CambioProfiloForm extends AbstractForm{

	
	private String codiProfilo;


	public CambioProfiloForm(){
		
	}


	public String getCodiProfilo() {
		return codiProfilo;
	}


	public void setCodiProfilo(String codiProfilo) {
		this.codiProfilo = codiProfilo;
	}
	
}
