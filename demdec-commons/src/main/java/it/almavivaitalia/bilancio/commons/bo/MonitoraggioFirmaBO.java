package it.almavivaitalia.bilancio.commons.bo;

/**
 * MonitoraggioFirmaBO generated by hbm2java
 */
public class MonitoraggioFirmaBO extends AbstractCommonBO implements java.io.Serializable {


	 private Long id; // numeIdFascicolo
     private String codiDecreto;
     private String descDecreto;
     private Integer statStato;
     private String descFirmato;
     private String descInFirma;
     private String descSigla;
     private Short annoEse;
     private Integer numeNumDecreto;
     private Integer numeTipoDecreto;
     
     

   
  public MonitoraggioFirmaBO() {
		super();
		// TODO Auto-generated constructor stub
	}




public MonitoraggioFirmaBO(Long id, String codiDecreto, String descDecreto,
		Integer statStato, String descFirmato, String descInFirma,
		String descSigla, Short annoEse, Integer numeNumDecreto,
		Integer numeTipoDecreto) {
	this.id = id;
	this.codiDecreto = codiDecreto;
	this.descDecreto = descDecreto;
	this.statStato = statStato;
	this.descFirmato = descFirmato;
	this.descInFirma = descInFirma;
	this.descSigla = descSigla;
	this.annoEse = annoEse;
	this.numeNumDecreto = numeNumDecreto;
	this.numeTipoDecreto = numeTipoDecreto;
}




public Long getId() {
	return id;
}




public void setId(Long id) {
	this.id = id;
}




public String getCodiDecreto() {
	return codiDecreto;
}




public void setCodiDecreto(String codiDecreto) {
	this.codiDecreto = codiDecreto;
}




public String getDescDecreto() {
	return descDecreto;
}




public void setDescDecreto(String descDecreto) {
	this.descDecreto = descDecreto;
}




public Integer getStatStato() {
	return statStato;
}




public void setStatStato(Integer statStato) {
	this.statStato = statStato;
}




public String getDescFirmato() {
	return descFirmato;
}




public void setDescFirmato(String descFirmato) {
	this.descFirmato = descFirmato;
}




public String getDescInFirma() {
	return descInFirma;
}




public void setDescInFirma(String descInFirma) {
	this.descInFirma = descInFirma;
}




public String getDescSigla() {
	return descSigla;
}




public void setDescSigla(String descSigla) {
	this.descSigla = descSigla;
}




public Short getAnnoEse() {
	return annoEse;
}




public void setAnnoEse(Short annoEse) {
	this.annoEse = annoEse;
}




public Integer getNumeNumDecreto() {
	return numeNumDecreto;
}




public void setNumeNumDecreto(Integer numeNumDecreto) {
	this.numeNumDecreto = numeNumDecreto;
}




public Integer getNumeTipoDecreto() {
	return numeTipoDecreto;
}




public void setNumeTipoDecreto(Integer numeTipoDecreto) {
	this.numeTipoDecreto = numeTipoDecreto;
}




// The following is extra code specified in the hbm.xml files
private static final long serialVersionUID = 1L;
  // end of extra code specified in the hbm.xml files

}


