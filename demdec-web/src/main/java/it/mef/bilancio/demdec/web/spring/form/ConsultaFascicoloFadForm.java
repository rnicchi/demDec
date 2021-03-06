/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.form;

import it.almavivaitalia.web.sh.form.AbstractForm;

/**
 * @author utente
 *
 */
public class ConsultaFascicoloFadForm extends AbstractForm {
	
	private String tipoDecreto;
	private String decTipoDecreto;
	private String numeDecreto;
	private String annoDecreto;
	private String descDecreto;
	private String tipologiaDecreto;
	private String amministrazione;
	private String ufficio;
	private String cdr;
	private String numePat;
	private String stato;
	private String descStato;
	private String dataArrivoDa;
	private String dataArrivoA;
	private String ufficioCreatore;
	private String dataCreazione;
	private String creatoDa;
	private String dataModifica;
	private String modificatoDa;
	private String[] ammRows;
	private String[] ammRowsToDelete;
	private String flagNormativo;
	
	
	
	public String getFlagNormativo() {
		return flagNormativo;
	}

	public void setFlagNormativo(String flagNormativo) {
		this.flagNormativo = flagNormativo;
	}

	public String getUfficioCreatore() {
		return ufficioCreatore;
	}
	public void setUfficioCreatore(String ufficioCreatore) {
		this.ufficioCreatore = ufficioCreatore;
	}
	public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public String getCreatoDa() {
		return creatoDa;
	}
	public void setCreatoDa(String creatoDa) {
		this.creatoDa = creatoDa;
	}
	public String getDataModifica() {
		return dataModifica;
	}
	public void setDataModifica(String dataModifica) {
		this.dataModifica = dataModifica;
	}
	public String getModificatoDa() {
		return modificatoDa;
	}
	public void setModificatoDa(String modificatoDa) {
		this.modificatoDa = modificatoDa;
	}
	public String getTipoDecreto() {
		return tipoDecreto;
	}
	public void setTipoDecreto(String tipoDecreto) {
		this.tipoDecreto = tipoDecreto;
	}
	public String getNumeDecreto() {
		return numeDecreto;
	}
	public void setNumeDecreto(String numeDecreto) {
		this.numeDecreto = numeDecreto;
	}
	public String getAnnoDecreto() {
		return annoDecreto;
	}
	public void setAnnoDecreto(String annoDecreto) {
		this.annoDecreto = annoDecreto;
	}
	public String getTipologiaDecreto() {
		return tipologiaDecreto;
	}
	public void setTipologiaDecreto(String tipologiaDecreto) {
		this.tipologiaDecreto = tipologiaDecreto;
	}
	public String getAmministrazione() {
		return amministrazione;
	}
	public void setAmministrazione(String amministrazione) {
		this.amministrazione = amministrazione;
	}
	public String getUfficio() {
		return ufficio;
	}
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	public String getCdr() {
		return cdr;
	}
	public void setCdr(String cdr) {
		this.cdr = cdr;
	}
	public String getNumePat() {
		return numePat;
	}
	public void setNumePat(String numePat) {
		this.numePat = numePat;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getDataArrivoDa() {
		return dataArrivoDa;
	}
	public void setDataArrivoDa(String dataArrivoDa) {
		this.dataArrivoDa = dataArrivoDa;
	}
	public String getDataArrivoA() {
		return dataArrivoA;
	}
	public void setDataArrivoA(String dataArrivoA) {
		this.dataArrivoA = dataArrivoA;
	}
	
	public String[] getAmmRows() {
		return ammRows;
	}
	public void setAmmRows(String[] ammRows) {
		this.ammRows = ammRows;
	}
	public String[] getAmmRowsToDelete() {
		return ammRowsToDelete;
	}
	public void setAmmRowsToDelete(String[] ammRowsToDelete) {
		this.ammRowsToDelete = ammRowsToDelete;
	}

	public void reset(){
		this.tipoDecreto = "";
		this.decTipoDecreto = "";
		this.numeDecreto = "";
		this.annoDecreto = "";
		this.tipologiaDecreto = "";
		this.amministrazione = "";
		this.ufficio = "";
		this.cdr = "";
		this.numePat = "";
		this.stato = "";
		this.descStato = "";
		this.dataArrivoDa = "";
		this.dataArrivoA = "";
		this.ammRows = null;
		this.ammRowsToDelete = null;
	}
	public String getDecTipoDecreto() {
		return decTipoDecreto;
	}
	public void setDecTipoDecreto(String decTipoDecreto) {
		this.decTipoDecreto = decTipoDecreto;
	}
	public String getDescStato() {
		return descStato;
	}
	public void setDescStato(String descStato) {
		this.descStato = descStato;
	}
	public String getDescDecreto() {
		return descDecreto;
	}
	public void setDescDecreto(String descDecreto) {
		this.descDecreto = descDecreto;
	}
	
}
