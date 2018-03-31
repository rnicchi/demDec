package it.mef.bilancio.demdec.web.spring.form;

import it.almavivaitalia.web.sh.form.AbstractForm;

public class RielaborazioneFascicoloForm extends AbstractForm{

	private String annoDecreto;
	private String tipoDecreto;
	private String numDecreto;
	private String annoDecretoArrivo;
	private String tipoDecretoArrivo;
	private String numDecretoArrivo;
	private String idFascicolo;
	private String idFascicoloArrivo;
	private String tipoElab;


	public String getAnnoDecretoArrivo() {
		return annoDecretoArrivo;
	}

	public void setAnnoDecretoArrivo(String annoDecretoArrivo) {
		this.annoDecretoArrivo = annoDecretoArrivo;
	}

	public String getTipoDecretoArrivo() {
		return tipoDecretoArrivo;
	}

	public void setTipoDecretoArrivo(String tipoDecretoArrivo) {
		this.tipoDecretoArrivo = tipoDecretoArrivo;
	}

	public String getNumDecretoArrivo() {
		return numDecretoArrivo;
	}

	public void setNumDecretoArrivo(String numDecretoArrivo) {
		this.numDecretoArrivo = numDecretoArrivo;
	}

	public String getNumDecreto() {
		return numDecreto;
	}

	public void setNumDecreto(String numDecreto) {
		this.numDecreto = numDecreto;
	}

	public String getTipoDecreto() {
		return tipoDecreto;
	}

	public void setTipoDecreto(String tipoDecreto) {
		this.tipoDecreto = tipoDecreto;
	}

	public String getAnnoDecreto() {
		return annoDecreto;
	}

	public void setAnnoDecreto(String annoDecreto) {
		this.annoDecreto = annoDecreto;
	}

	public String getIdFascicolo() {
		return idFascicolo;
	}

	public void setIdFascicolo(String idFascicolo) {
		this.idFascicolo = idFascicolo;
	}

	public String getIdFascicoloArrivo() {
		return idFascicoloArrivo;
	}

	public void setIdFascicoloArrivo(String idFascicoloArrivo) {
		this.idFascicoloArrivo = idFascicoloArrivo;
	}

	public String getTipoElab() {
		return tipoElab;
	}

	public void setTipoElab(String tipoElab) {
		this.tipoElab = tipoElab;
	}
	
	
}
