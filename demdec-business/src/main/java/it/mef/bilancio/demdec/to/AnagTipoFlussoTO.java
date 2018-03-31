package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;

public class AnagTipoFlussoTO  extends AbstractCommonTO implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String descTipoFlusso;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescTipoFlusso() {
		return descTipoFlusso;
	}
	public void setDescTipoFlusso(String descTipoFlusso) {
		this.descTipoFlusso = descTipoFlusso;
	}
	
	
}
