package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;

public class AnagTipoDecretoTO extends AbstractCommonTO implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String descSigla;
	private String descTesto;
	
	public AnagTipoDecretoTO() {};
	public AnagTipoDecretoTO(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescSigla() {
		return descSigla;
	}
	public void setDescSigla(String descSigla) {
		this.descSigla = descSigla;
	}
	public String getDescTesto() {
		return descTesto;
	}
	public void setDescTesto(String descTesto) {
		this.descTesto = descTesto;
	}

	
	

}
