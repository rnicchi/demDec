package it.mef.bilancio.demdec.to;

public class AttoDecretoTO extends AbstractDemTO implements java.io.Serializable {

	
	private String descNomeDocumento;
	private String codiTipoDocumento;
	private String statFirma;
	private Integer numeIdDocumento;
	private String descAmm;
	
	
	
	public AttoDecretoTO() {
		super();
	}
	

	public AttoDecretoTO(String descNomeDocumento, String codiTipoDocumento,
			String codiUfficio, String statFirma,
			Integer numeIdDocumento) {
		super();
		this.descNomeDocumento = descNomeDocumento;
		this.codiTipoDocumento = codiTipoDocumento;
		this.statFirma = statFirma;
		this.numeIdDocumento = numeIdDocumento;
	}


	public String getDescNomeDocumento() {
		return descNomeDocumento;
	}


	public void setDescNomeDocumento(String descNomeDocumento) {
		this.descNomeDocumento = descNomeDocumento;
	}




	public String getCodiTipoDocumento() {
		return codiTipoDocumento;
	}


	public void setCodiTipoDocumento(String codiTipoDocumento) {
		this.codiTipoDocumento = codiTipoDocumento;
	}




	public String getStatFirma() {
		
		return statFirma;
	}


	public void setStatFirma(String statFirma) {
		this.statFirma = statFirma;
	}


	public Integer getNumeIdDocumento() {
		return numeIdDocumento;
	}


	public void setNumeIdDocumento(Integer numeIdDocumento) {
		this.numeIdDocumento = numeIdDocumento;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescAmm() {
		return descAmm;
	}


	public void setDescAmm(String descAmm) {
		this.descAmm = descAmm;
	}
	

	private static final long serialVersionUID = 1L;
	
	

}
