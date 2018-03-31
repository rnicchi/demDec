package it.mef.bilancio.demdec.web.spring.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import it.almavivaitalia.web.sh.form.AbstractForm;

public class ConsFADCdcForm extends AbstractForm{
	
	private String idFascicolo;
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
	private String dataInvioCdc;
	private String creatoDa;
	private String dataModifica;
	private String modificatoDa;
	private String numeProtEntrata;
	private String numeProtEntrataMod;
	private String dataProtEntrata;
	private String dataProtEntrataMod;	
	private String dataPresaInCarico;
	private String numeProtUscita;
	private String numeProtUscitaMod;
	private String dataProtUscita;
	private String dataProtUscitaMod;
	private String estremiCdc;
	private String numeRegistrazioneCdc;
	private String dataRegistrazioneCdc;
	private String numeUfficioCdc;
	private String[] ammRows;
	private String[] ammRowsToDelete;
	private CommonsMultipartFile upFile;
	private String tipoDoc;
	private String amm;
	private String desc;
	
	


	public String getNumeRegistrazioneCdc() {
		return numeRegistrazioneCdc;
	}
	public void setNumeRegistrazioneCdc(String numeRegistrazioneCdc) {
		this.numeRegistrazioneCdc = numeRegistrazioneCdc;
	}
	public String getNumeUfficioCdc() {
		return numeUfficioCdc;
	}
	public void setNumeUfficioCdc(String numeUfficioCdc) {
		this.numeUfficioCdc = numeUfficioCdc;
	}
	public String getDataRegistrazioneCdc() {
		return dataRegistrazioneCdc;
	}
	public void setDataRegistrazioneCdc(String dataRegistrazioneCdc) {
		this.dataRegistrazioneCdc = dataRegistrazioneCdc;
	}
	public String getNumeProtEntrataMod() {
		return numeProtEntrataMod;
	}
	public void setNumeProtEntrataMod(String numeProtEntrataMod) {
		this.numeProtEntrataMod = numeProtEntrataMod;
	}
	public String getDataProtEntrataMod() {
		return dataProtEntrataMod;
	}
	public void setDataProtEntrataMod(String dataProtEntrataMod) {
		this.dataProtEntrataMod = dataProtEntrataMod;
	}
	public String getNumeProtUscitaMod() {
		return numeProtUscitaMod;
	}
	public void setNumeProtUscitaMod(String numeProtUscitaMod) {
		this.numeProtUscitaMod = numeProtUscitaMod;
	}
	public String getDataProtUscitaMod() {
		return dataProtUscitaMod;
	}
	public void setDataProtUscitaMod(String dataProtUscitaMod) {
		this.dataProtUscitaMod = dataProtUscitaMod;
	}
	public String getDataPresaInCarico() {
		return dataPresaInCarico;
	}
	public void setDataPresaInCarico(String dataPresaInCarico) {
		this.dataPresaInCarico = dataPresaInCarico;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAmm() {
		return amm;
	}
	public void setAmm(String amm) {
		this.amm = amm;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public CommonsMultipartFile getUpFile() {
		return upFile;
	}
	public void setUpFile(CommonsMultipartFile upFile) {
		this.upFile = upFile;
	}
	public String getNumeProtEntrata() {
		return numeProtEntrata;
	}
	public void setNumeProtEntrata(String numeProtEntrata) {
		this.numeProtEntrata = numeProtEntrata;
	}
	public String getDataProtEntrata() {
		return dataProtEntrata;
	}
	public void setDataProtEntrata(String dataProtEntrata) {
		this.dataProtEntrata = dataProtEntrata;
	}
	public String getNumeProtUscita() {
		return numeProtUscita;
	}
	public void setNumeProtUscita(String numeProtUscita) {
		this.numeProtUscita = numeProtUscita;
	}
	public String getDataProtUscita() {
		return dataProtUscita;
	}
	public void setDataProtUscita(String dataProtUscita) {
		this.dataProtUscita = dataProtUscita;
	}
	public String getEstremiCdc() {
		return estremiCdc;
	}
	public void setEstremiCdc(String estremiCdc) {
		this.estremiCdc = estremiCdc;
	}
	public String getDataInvioCdc() {
		return dataInvioCdc;
	}
	public void setDataInvioCdc(String dataInvioCdc) {
		this.dataInvioCdc = dataInvioCdc;
	}
	public String getIdFascicolo() {
		return idFascicolo;
	}
	public void setIdFascicolo(String idFascicolo) {
		this.idFascicolo = idFascicolo;
	}
	public String getTipoDecreto() {
		return tipoDecreto;
	}
	public void setTipoDecreto(String tipoDecreto) {
		this.tipoDecreto = tipoDecreto;
	}
	public String getDecTipoDecreto() {
		return decTipoDecreto;
	}
	public void setDecTipoDecreto(String decTipoDecreto) {
		this.decTipoDecreto = decTipoDecreto;
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
	public String getDescDecreto() {
		return descDecreto;
	}
	public void setDescDecreto(String descDecreto) {
		this.descDecreto = descDecreto;
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
	public String getDescStato() {
		return descStato;
	}
	public void setDescStato(String descStato) {
		this.descStato = descStato;
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
		
		this.idFascicolo="";
		this.tipoDecreto="";
		this.decTipoDecreto="";
		this.numeDecreto="";
		this.annoDecreto="";
		this.descDecreto="";
		this.tipologiaDecreto="";
		this.amministrazione="";
		this.ufficio="";
		this.cdr="";
		this.numePat="";
		this.stato="";
		this.descStato="";
		this.dataArrivoDa="";
		this.dataArrivoA="";
		this.ufficioCreatore="";
		this.dataCreazione="";
		this.dataInvioCdc="";
		this.creatoDa="";
		this.dataModifica="";
		this.modificatoDa="";
		this.numeProtEntrata="";
		this.dataProtEntrata="";
		this.numeProtUscita="";
		this.dataProtUscita="";
		this.estremiCdc="";
		this.ammRows=null;
		this.ammRowsToDelete=null;
		this.upFile=null;
		this.tipoDoc="";
		this.amm="";
		this.desc="";
		
	}
	
	

}
