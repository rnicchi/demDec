package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;

public class AnagFirmatariTO extends AbstractCommonTO implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String descFirmatario;
	private String codiTagFirma;
	private Integer fkSequIdProfilo;
	private String codiTipoFirma;
	private String descTipoFirma;
	private Integer flagPec01;
	private Integer flagAbilitaMail01;
	
	public AnagFirmatariTO() {
		super();
	}

	public AnagFirmatariTO(String id) {
	}
	
	public String getDescPec(){
		return flagPec01==0?"PEO":"PEC";
	}
	
	public String getDescStato(){
		return flagAbilitaMail01==0?"Disabilitato":"Abilitato";
	}

	public AnagFirmatariTO(String descFirmatario, String codiTagFirma,
			Integer fkSequIdProfilo, String codiTipoFirma,
			String descTipoFirma, Integer flagPec01) {
		super();
		this.descFirmatario = descFirmatario;
		this.codiTagFirma = codiTagFirma;
		this.fkSequIdProfilo = fkSequIdProfilo;
		this.codiTipoFirma = codiTipoFirma;
		this.descTipoFirma = descTipoFirma;
		this.flagPec01 = flagPec01;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getDescFirmatario() {
		return descFirmatario;
	}


	public void setDescFirmatario(String descFirmatario) {
		this.descFirmatario = descFirmatario;
	}


	public String getCodiTagFirma() {
		return codiTagFirma;
	}


	public void setCodiTagFirma(String codiTagFirma) {
		this.codiTagFirma = codiTagFirma;
	}


	public Integer getFkSequIdProfilo() {
		return fkSequIdProfilo;
	}


	public void setFkSequIdProfilo(Integer fkSequIdProfilo) {
		this.fkSequIdProfilo = fkSequIdProfilo;
	}


	public String getCodiTipoFirma() {
		return codiTipoFirma;
	}


	public void setCodiTipoFirma(String codiTipoFirma) {
		this.codiTipoFirma = codiTipoFirma;
	}


	public String getDescTipoFirma() {
		return descTipoFirma;
	}


	public void setDescTipoFirma(String descTipoFirma) {
		this.descTipoFirma = descTipoFirma;
	}


	public Integer getFlagPec01() {
		return flagPec01;
	}


	public void setFlagPec01(Integer flagPec01) {
		this.flagPec01 = flagPec01;
	}
	
	
	@Override
	public String toString() {
		return "AnagFirmatariTO [id=" + id + ", descFirmatario="
				+ descFirmatario + ", codiTagFirma=" + codiTagFirma
				+ ", fkSequIdProfilo=" + fkSequIdProfilo + ", codiTipoFirma="
				+ codiTipoFirma + ", descTipoFirma=" + descTipoFirma
				+ ", flagPec01=" + flagPec01 + "]";
	}

	public Integer getFlagAbilitaMail01() {
		return flagAbilitaMail01;
	}

	public void setFlagAbilitaMail01(Integer flagAbilitaMail01) {
		this.flagAbilitaMail01 = flagAbilitaMail01;
	}

}
