package it.mef.bilancio.demdec.web.spring.form;

import it.almavivaitalia.web.sh.form.AbstractForm;

public class DocumentiRaccoltaProvvisorieForm extends AbstractForm {
	private String tipoAllegati;
	private String fascicoliAssociati;
	private String selezioniDocumentiFasc;

	public String getTipoAllegati() {
		return tipoAllegati;
	}

	public void setTipoAllegati(String tipoAllegati) {
		this.tipoAllegati = tipoAllegati;
	}

	public String getFascicoliAssociati() {
		return fascicoliAssociati;
	}

	public void setFascicoliAssociati(String fascicoliAssociati) {
		this.fascicoliAssociati = fascicoliAssociati;
	}

	public String getSelezioniDocumentiFasc() {
		return selezioniDocumentiFasc;
	}

	public void setSelezioniDocumentiFasc(String selezioniDocumentiFasc) {
		this.selezioniDocumentiFasc = selezioniDocumentiFasc;
	}
	
}
