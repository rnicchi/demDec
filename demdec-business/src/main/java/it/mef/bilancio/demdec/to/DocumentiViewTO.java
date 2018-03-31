package it.mef.bilancio.demdec.to;


public class DocumentiViewTO  extends AbstractDemTO implements java.io.Serializable{

	private Integer numeIdDocumento;
	private Long numeIdFascicolo;
	private String codiGuidFascicolo;
	private String codiGuidDocumento;
	private String descNomeDocumento;
	private String codiTipoDocumento;
	private String statFirma;
	private String descAmm;
	private FascicoliTO fascicoli;
	private String descFilename;
	
	//Dati del fascicolo da mostrare nella lista dei documenti da firmare
	private String descSigla;
	private Long annoEse;
	private Long numeNumDecreto;
	private String decreto;
	
	

	public DocumentiViewTO() {
		super();
	}


	public DocumentiViewTO(Integer numeIdDocumento, Long numeIdFascicolo,
			String descNomeDocumento, String codiTipoDocumento,
			String statFirma, String descAmm) {
		super();
		this.numeIdDocumento = numeIdDocumento;
		this.numeIdFascicolo = numeIdFascicolo;
		this.descNomeDocumento = descNomeDocumento;
		this.codiTipoDocumento = codiTipoDocumento;
		this.statFirma = statFirma;
		this.descAmm = descAmm;
	}




	public Integer getNumeIdDocumento() {
		return numeIdDocumento;
	}


	public void setNumeIdDocumento(Integer numeIdDocumento) {
		this.numeIdDocumento = numeIdDocumento;
	}


	public Long getNumeIdFascicolo() {
		return numeIdFascicolo;
	}


	public void setNumeIdFascicolo(Long numeIdFascicolo) {
		this.numeIdFascicolo = numeIdFascicolo;
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


	public String getDescAmm() {
		return descAmm;
	}


	public void setDescAmm(String descAmm) {
		this.descAmm = descAmm;
	}




	public String getCodiGuidFascicolo() {
		return codiGuidFascicolo;
	}


	public void setCodiGuidFascicolo(String codiGuidFascicolo) {
		this.codiGuidFascicolo = codiGuidFascicolo;
	}




	public String getCodiGuidDocumento() {
		return codiGuidDocumento;
	}


	public void setCodiGuidDocumento(String codiGuidDocumento) {
		this.codiGuidDocumento = codiGuidDocumento;
	}

	
	public String getDescSigla() {
		return descSigla;
	}


	public void setDescSigla(String descSigla) {
		this.descSigla = descSigla;
	}

	public Long getAnnoEse() {
		return annoEse;
	}


	public void setAnnoEse(Long annoEse) {
		this.annoEse = annoEse;
	}


	public Long getNumeNumDecreto() {
		return numeNumDecreto;
	}


	public void setNumeNumDecreto(Long numeNumDecreto) {
		this.numeNumDecreto = numeNumDecreto;
	}

	public String getDecreto() {
		return this.getDescSigla()+ " " + this.getNumeNumDecreto().toString()+ " " + this.getAnnoEse().toString();
	}


	public void setDecreto(String decreto) {
		this.decreto = decreto;
	}

	public void setFascicoli(FascicoliTO fascicoli) {
		this.fascicoli = fascicoli;
	}


	public FascicoliTO getFascicoli() {
		return fascicoli;
	}

	public void setDescFilename(String descFilename) {
		this.descFilename = descFilename;
	}


	public String getDescFilename() {
		return descFilename;
	}

	private static final long serialVersionUID = 1L;

}
