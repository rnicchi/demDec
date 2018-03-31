package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;




public class IterFirmaDecretoTO extends AbstractDemTO implements java.io.Serializable {

	
	private static final long serialVersionUID = -8473765820254369466L;
	
	private IterFirmaDecretoTOId id;
	private FascicoliTO fascicoli;
	private AnagFirmatariTO anagFirmatari;
	private AnagAmminDemTO anagAmminDem;
	private AnagUfficiTO anagUffici;
	private Integer numeOrdineIter;
	private String codiTipoFirma;
	private String fkCodiUfficio;
	private String statFirma;

	public IterFirmaDecretoTO() {
	}

	public IterFirmaDecretoTO(IterFirmaDecretoTOId id,
			FascicoliTO fascicoli, AnagFirmatariTO anagFirmatari, Integer numeOrdineIter) {
		this.id = id;
		this.fascicoli = fascicoli;
		this.numeOrdineIter = numeOrdineIter;
	}

	public IterFirmaDecretoTO(IterFirmaDecretoTOId id,
			FascicoliTO fascicoli, AnagFirmatariTO anagFirmatari, AnagUfficiTO anagUffici, AnagAmminDemTO anagAmminDem, Integer numeOrdineIter, String codiTipoFirma, String fkCodiUfficio,
			String statFirma) {
		this.id = id;
		this.fascicoli = fascicoli;
		this.numeOrdineIter = numeOrdineIter;
		this.codiTipoFirma = codiTipoFirma;
		this.fkCodiUfficio = fkCodiUfficio;
		this.statFirma = statFirma;
		this.anagFirmatari = anagFirmatari;
		this.anagUffici = anagUffici;
		this.anagAmminDem = anagAmminDem;
	}

	public IterFirmaDecretoTOId getId() {
		return id;
	}

	public void setId(IterFirmaDecretoTOId id) {
		this.id = id;
	}

	public FascicoliTO getFascicoli() {
		return fascicoli;
	}

	public void setFascicoli(FascicoliTO fascicoli) {
		this.fascicoli = fascicoli;
	}

	public Integer getNumeOrdineIter() {
		return numeOrdineIter;
	}

	public void setNumeOrdineIter(Integer numeOrdineIter) {
		this.numeOrdineIter = numeOrdineIter;
	}

	public String getCodiTipoFirma() {
		return codiTipoFirma;
	}

	public void setCodiTipoFirma(String codiTipoFirma) {
		this.codiTipoFirma = codiTipoFirma;
	}

	public String getFkCodiUfficio() {
		return fkCodiUfficio;
	}

	public void setFkCodiUfficio(String fkCodiUfficio) {
		this.fkCodiUfficio = fkCodiUfficio;
	}

	public String getStatFirma() {
		return statFirma;
	}

	public void setStatFirma(String statFirma) {
		this.statFirma = statFirma;
	}

	public AnagFirmatariTO getAnagFirmatari() {
		return anagFirmatari;
	}

	public void setAnagFirmatari(AnagFirmatariTO anagFirmatari) {
		this.anagFirmatari = anagFirmatari;
	}

	public AnagUfficiTO getAnagUffici() {
		return anagUffici;
	}

	public void setAnagUffici(AnagUfficiTO anagUffici) {
		this.anagUffici = anagUffici;
	}

	public AnagAmminDemTO getAnagAmminDem() {
		return anagAmminDem;
	}

	public void setAnagAmminDem(AnagAmminDemTO anagAmminDem) {
		this.anagAmminDem = anagAmminDem;
	}

	
	
	

}
