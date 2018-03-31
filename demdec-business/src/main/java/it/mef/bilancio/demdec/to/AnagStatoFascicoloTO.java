package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;

public class AnagStatoFascicoloTO extends AbstractCommonTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String statStato;
	private String descStato;
	private String codiTipoFascicolo;
	
	public String getStatStato() {
		return statStato;
	}
	public void setStatStato(String statStato) {
		this.statStato = statStato;
	}
	public String getDescStato() {
		return descStato;
	}
	public void setDescStato(String descStato) {
		this.descStato = descStato;
	}
	public String getCodiTipoFascicolo() {
		return codiTipoFascicolo;
	}
	public void setCodiTipoFascicolo(String codiTipoFascicolo) {
		this.codiTipoFascicolo = codiTipoFascicolo;
	}
	
	
}
