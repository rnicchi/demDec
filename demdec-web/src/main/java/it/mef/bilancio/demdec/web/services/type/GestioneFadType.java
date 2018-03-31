package it.mef.bilancio.demdec.web.services.type;

import java.util.List;

public class GestioneFadType implements java.io.Serializable {

	private Integer tipoDec;
	private Integer numeroDec;
	private Integer numeroDecDest;
	private Integer annoDec;
	private String descDec;
	private Integer tipologiaDec;
	private List<AnagAmminDemType> ammList;
	private String ufficio;
	private Integer titolo;
	private Integer numPatr;
	private String ufficioCreatore;
	private String codiUtente;
	private String codiGuid;

	public Integer getTipoDec() {
		return tipoDec;
	}

	public void setTipoDec(Integer tipoDec) {
		this.tipoDec = tipoDec;
	}

	public Integer getNumeroDec() {
		return numeroDec;
	}

	public void setNumeroDec(Integer numeroDec) {
		this.numeroDec = numeroDec;
	}

	public Integer getAnnoDec() {
		return annoDec;
	}

	public void setAnnoDec(Integer annoDec) {
		this.annoDec = annoDec;
	}

	public String getDescDec() {
		return descDec;
	}

	public void setDescDec(String descDec) {
		this.descDec = descDec;
	}

	public Integer getTipologiaDec() {
		return tipologiaDec;
	}

	public void setTipologiaDec(Integer tipologiaDec) {
		this.tipologiaDec = tipologiaDec;
	}

	public List<AnagAmminDemType> getAmmList() {
		return ammList;
	}

	public void setAmmList(List<AnagAmminDemType> ammList) {
		this.ammList = ammList;
	}

	public String getUfficio() {
		return ufficio;
	}

	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}

	public Integer getTitolo() {
		return titolo;
	}

	public void setTitolo(Integer titolo) {
		this.titolo = titolo;
	}

	public Integer getNumPatr() {
		return numPatr;
	}

	public void setNumPatr(Integer numPatr) {
		this.numPatr = numPatr;
	}

	public String getUfficioCreatore() {
		return ufficioCreatore;
	}

	public void setUfficioCreatore(String ufficioCreatore) {
		this.ufficioCreatore = ufficioCreatore;
	}

	public String getCodiUtente() {
		return codiUtente;
	}

	public void setCodiUtente(String codiUtente) {
		this.codiUtente = codiUtente;
	}

	public String getCodiGuid() {
		return codiGuid;
	}

	public void setCodiGuid(String codiGuid) {
		this.codiGuid = codiGuid;
	}

	public Integer getNumeroDecDest() {
		return numeroDecDest;
	}

	public void setNumeroDecDest(Integer numeroDecDest) {
		this.numeroDecDest = numeroDecDest;
	}



	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}
