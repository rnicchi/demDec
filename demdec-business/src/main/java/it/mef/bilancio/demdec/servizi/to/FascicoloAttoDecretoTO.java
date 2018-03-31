package it.mef.bilancio.demdec.servizi.to;

import java.util.ArrayList;

import it.mef.bilancio.demdec.to.AbstractDemTO;
            


public  class FascicoloAttoDecretoTO extends AbstractDemTO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9211436485564453565L;

	private String idFascicoloAttoDecreto ;
                                
	private String idFascicoloAttoDecretoParent ;

	private String descrizione ;
	
	private FadDemBilTO metadati;

	private  ArrayList<DocumentTO> documenti ;
	
	private ArrayList<FascicoloSipatrTO> fascicoliSIPATR ;
	
	private ArrayList<DocumentTO> allegatiDecretoIGB ;
                                
	private String statoFascicoloDocumentale ;

	private java.util.Date dataCreazione ;

	private java.util.Calendar dataAggiornamentoAttoDecreto ;

	private java.util.Calendar dataAggiornamentoSIPATR ;

	private java.util.Calendar dataAggiornamentoFascicoloIGB ;
                                

	private java.util.Calendar dataChiusura ;

	private boolean daInviare;

	private boolean attivo;

	private String sistemaProduttore ;

	public String getIdFascicoloAttoDecreto() {
		return idFascicoloAttoDecreto;
	}

	public void setIdFascicoloAttoDecreto(String idFascicoloAttoDecreto) {
		this.idFascicoloAttoDecreto = idFascicoloAttoDecreto;
	}

	public String getIdFascicoloAttoDecretoParent() {
		return idFascicoloAttoDecretoParent;
	}

	public void setIdFascicoloAttoDecretoParent(String idFascicoloAttoDecretoParent) {
		this.idFascicoloAttoDecretoParent = idFascicoloAttoDecretoParent;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public FadDemBilTO getMetadati() {
		return metadati;
	}

	public void setMetadati(FadDemBilTO metadati) {
		this.metadati = metadati;
	}

	public ArrayList<DocumentTO> getDocumenti() {
		return documenti;
	}

	public void setDocumenti(ArrayList<DocumentTO> documenti) {
		this.documenti = documenti;
	}

	public ArrayList<FascicoloSipatrTO> getFascicoliSIPATR() {
		return fascicoliSIPATR;
	}

	public void setFascicoliSIPATR(ArrayList<FascicoloSipatrTO> fascicoliSIPATR) {
		this.fascicoliSIPATR = fascicoliSIPATR;
	}

	public ArrayList<DocumentTO> getAllegatiDecretoIGB() {
		return allegatiDecretoIGB;
	}

	public void setAllegatiDecretoIGB(ArrayList<DocumentTO> allegatiDecretoIGB) {
		this.allegatiDecretoIGB = allegatiDecretoIGB;
	}

	public String getStatoFascicoloDocumentale() {
		return statoFascicoloDocumentale;
	}

	public void setStatoFascicoloDocumentale(String statoFascicoloDocumentale) {
		this.statoFascicoloDocumentale = statoFascicoloDocumentale;
	}

	public java.util.Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(java.util.Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public java.util.Calendar getDataAggiornamentoAttoDecreto() {
		return dataAggiornamentoAttoDecreto;
	}

	public void setDataAggiornamentoAttoDecreto(
			java.util.Calendar dataAggiornamentoAttoDecreto) {
		this.dataAggiornamentoAttoDecreto = dataAggiornamentoAttoDecreto;
	}

	public java.util.Calendar getDataAggiornamentoSIPATR() {
		return dataAggiornamentoSIPATR;
	}

	public void setDataAggiornamentoSIPATR(
			java.util.Calendar dataAggiornamentoSIPATR) {
		this.dataAggiornamentoSIPATR = dataAggiornamentoSIPATR;
	}

	public java.util.Calendar getDataAggiornamentoFascicoloIGB() {
		return dataAggiornamentoFascicoloIGB;
	}

	public void setDataAggiornamentoFascicoloIGB(
			java.util.Calendar dataAggiornamentoFascicoloIGB) {
		this.dataAggiornamentoFascicoloIGB = dataAggiornamentoFascicoloIGB;
	}

	public java.util.Calendar getDataChiusura() {
		return dataChiusura;
	}

	public void setDataChiusura(java.util.Calendar dataChiusura) {
		this.dataChiusura = dataChiusura;
	}

	public boolean isDaInviare() {
		return daInviare;
	}

	public void setDaInviare(boolean daInviare) {
		this.daInviare = daInviare;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public String getSistemaProduttore() {
		return sistemaProduttore;
	}

	public void setSistemaProduttore(String sistemaProduttore) {
		this.sistemaProduttore = sistemaProduttore;
	}
                                

}
           
          