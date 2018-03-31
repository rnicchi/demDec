package it.mef.bilancio.demdec.to;

public class MonitoraggioFirmaTO extends AbstractDemTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private Long id;
	 private Long numeIdFascicolo;
     private String codiDecreto;
     private String descDecreto;
     private Integer statStato;
     private String descFirmato;
     private String descInFirma;
     private String descSigla;
     private Short annoEse;
     private Integer numeNumDecreto;
     private Integer numeTipoDecreto;
	
     
     public MonitoraggioFirmaTO() {
		super();
		// TODO Auto-generated constructor stub
     }



	public MonitoraggioFirmaTO(Long id, Long numeIdFascicolo, String codiDecreto,
			String descDecreto, Integer statStato, String descFirmato,
			String descInFirma, String descSigla, Short annoEse,
			Integer numeNumDecreto, Integer numeTipoDecreto) {
		super();
		this.id = id;
		this.numeIdFascicolo = numeIdFascicolo;
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


	public Long getNumeIdFascicolo() {
		return id;
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


	public String getDescSigla() {
		return descSigla;
	}

	
	public void setDescSigla(String descSigla) {
		this.descSigla = descSigla;
	}
     

}
