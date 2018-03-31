package it.mef.bilancio.demdec.web.spring.form;

import java.util.List;

import it.almavivaitalia.web.sh.form.AbstractForm;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CreaFadForm extends AbstractForm {

	private String tipoDec;
	private String numDec;
	private String annoDec;
	private String descDec;
	private String tipologiaDec;
	private String flagNormativo;
	private String norm;
	private String ucbRts;
	private String numPatr;
	private String[] cdrRows;
	private String[] cdrRowsToDelete;
	private String[] ammRows;
	private String[] ammRowsToDelete;
	private String ammForCdr;
	private String titolo;
	private String ufficio;
	
	
	public String getNorm() {
		return norm;
	}
	public void setNorm(String norm) {
		this.norm = norm;
	}
	public String getUfficio() {
		return ufficio;
	}
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	public String getTipoDec() {
		return tipoDec;
	}
	public String[] getCdrRowsToDelete() {
		return cdrRowsToDelete;
	}
	public void setCdrRowsToDelete(String[] cdrRowsToDelete) {
		this.cdrRowsToDelete = cdrRowsToDelete;
	}
	public void setTipoDec(String tipoDec) {
		this.tipoDec = tipoDec;
	}
	public String getNumDec() {
		return numDec;
	}
	public void setNumDec(String numDec) {
		this.numDec = numDec;
	}
	public String getAnnoDec() {
		return annoDec;
	}
	public void setAnnoDec(String annoDec) {
		this.annoDec = annoDec;
	}
	public String getDescDec() {
		return descDec;
	}
	public void setDescDec(String descDec) {
		this.descDec = descDec;
	}
	public String getTipologiaDec() {
		return tipologiaDec;
	}
	public void setTipologiaDec(String tipologiaDec) {
		this.tipologiaDec = tipologiaDec;
	}
	public String getFlagNormativo() {
		return flagNormativo;
	}
	public void setFlagNormativo(String flagNormativo) {
		this.flagNormativo = flagNormativo;
	}
	public String getUcbRts() {
		return ucbRts;
	}
	public void setUcbRts(String ucbRts) {
		this.ucbRts = ucbRts;
	}
	public String getNumPatr() {
		return numPatr;
	}
	public void setNumPatr(String numPatr) {
		this.numPatr = numPatr;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String[] getCdrRows() {
		return cdrRows;
	}
	public void setCdrRows(String[] cdrRows) {
		this.cdrRows = cdrRows;
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
	public String getAmmForCdr() {
		return ammForCdr;
	}
	public void setAmmForCdr(String ammForCdr) {
		this.ammForCdr = ammForCdr;
	}

}
