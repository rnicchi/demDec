package it.mef.bilancio.demdec.servizi.to;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;

public class DocumentoSipatrTO extends AbstractDemTO implements java.io.Serializable{
	
	private static final long serialVersionUID = 1847073845836417888L;
	
	
	private String idFascicolo;
	private String idSottoFascicolo;
	private String idDocumento;
	private CodeDescriptionTO tipoDocumento;
	private CodeDescriptionTO descDocumento;
	private CodeDescriptionTO amministrazione;
	private CodeDescriptionTO ucbRts;
	private CodeDescriptionTO ufficioCreatore;
	private CodeDescriptionTO utenteCreatore;
	private String descrizione;
	private String dataCreazione;
	private Boolean condivisibile;
	private Boolean attivo;
	private Boolean daInviare;
	private String sistemaProduttore;
	private Boolean isDocumentoOriginale;
	private Boolean isDocumentoTrattato;
	private String ticketArchiviazione;
	private Integer statDocumento;
	private String tipoFlusso;
	private String titolo;
	
	
	/**
	 * Metadata
	 */
	
	private String dataDocumento;
	private String dataChiusura;
	private String dataAnnullamento;
	private String note;
	private ProtocolloTO protocollo;
	
	private DocumentContentTO documentoContent;
		
	//Optional
	private DocumentFileTO documentoFileOrigine;
	
    //Optional
	private DocumentFileTO documentoFileOperazione;
	private String esitoOperazione;
	private String tipoOperazione;
	public String getIdFascicolo() {
		return idFascicolo;
	}
	public void setIdFascicolo(String idFascicolo) {
		this.idFascicolo = idFascicolo;
	}
	public String getIdSottoFascicolo() {
		return idSottoFascicolo;
	}
	public void setIdSottoFascicolo(String idSottoFascicolo) {
		this.idSottoFascicolo = idSottoFascicolo;
	}
	public String getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}
	public CodeDescriptionTO getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(CodeDescriptionTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public CodeDescriptionTO getDescDocumento() {
		return descDocumento;
	}
	public void setDescDocumento(CodeDescriptionTO descDocumento) {
		this.descDocumento = descDocumento;
	}
	public CodeDescriptionTO getAmministrazione() {
		return amministrazione;
	}
	public void setAmministrazione(CodeDescriptionTO amministrazione) {
		this.amministrazione = amministrazione;
	}
	public CodeDescriptionTO getUcbRts() {
		return ucbRts;
	}
	public void setUcbRts(CodeDescriptionTO ucbRts) {
		this.ucbRts = ucbRts;
	}
	public CodeDescriptionTO getUfficioCreatore() {
		return ufficioCreatore;
	}
	public void setUfficioCreatore(CodeDescriptionTO ufficioCreatore) {
		this.ufficioCreatore = ufficioCreatore;
	}
	public CodeDescriptionTO getUtenteCreatore() {
		return utenteCreatore;
	}
	public void setUtenteCreatore(CodeDescriptionTO utenteCreatore) {
		this.utenteCreatore = utenteCreatore;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public Boolean getCondivisibile() {
		return condivisibile;
	}
	public void setCondivisibile(Boolean condivisibile) {
		this.condivisibile = condivisibile;
	}
	public Boolean getAttivo() {
		return attivo;
	}
	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}
	public Boolean getDaInviare() {
		return daInviare;
	}
	public void setDaInviare(Boolean daInviare) {
		this.daInviare = daInviare;
	}
	public String getSistemaProduttore() {
		return sistemaProduttore;
	}
	public void setSistemaProduttore(String sistemaProduttore) {
		this.sistemaProduttore = sistemaProduttore;
	}
	public Boolean getIsDocumentoOriginale() {
		return isDocumentoOriginale;
	}
	public void setIsDocumentoOriginale(Boolean isDocumentoOriginale) {
		this.isDocumentoOriginale = isDocumentoOriginale;
	}
	public Boolean getIsDocumentoTrattato() {
		return isDocumentoTrattato;
	}
	public void setIsDocumentoTrattato(Boolean isDocumentoTrattato) {
		this.isDocumentoTrattato = isDocumentoTrattato;
	}
	public String getTicketArchiviazione() {
		return ticketArchiviazione;
	}
	public void setTicketArchiviazione(String ticketArchiviazione) {
		this.ticketArchiviazione = ticketArchiviazione;
	}
	public Integer getStatDocumento() {
		return statDocumento;
	}
	public void setStatDocumento(Integer statDocumento) {
		this.statDocumento = statDocumento;
	}

	public String getTipoFlusso() {
		return tipoFlusso;
	}
	public void setTipoFlusso(String tipoFlusso) {
		this.tipoFlusso = tipoFlusso;
	}
	public String getDataDocumento() {
		return dataDocumento;
	}
	public void setDataDocumento(String dataDocumento) {
		this.dataDocumento = dataDocumento;
	}
	public String getDataChiusura() {
		return dataChiusura;
	}
	public void setDataChiusura(String dataChiusura) {
		this.dataChiusura = dataChiusura;
	}
	public String getDataAnnullamento() {
		return dataAnnullamento;
	}
	public void setDataAnnullamento(String dataAnnullamento) {
		this.dataAnnullamento = dataAnnullamento;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public ProtocolloTO getProtocollo() {
		return protocollo;
	}
	public void setProtocollo(ProtocolloTO protocollo) {
		this.protocollo = protocollo;
	}
	public DocumentContentTO getDocumentoContent() {
		return documentoContent;
	}
	public void setDocumentoContent(DocumentContentTO documentoContent) {
		this.documentoContent = documentoContent;
	}
	public DocumentFileTO getDocumentoFileOrigine() {
		return documentoFileOrigine;
	}
	public void setDocumentoFileOrigine(DocumentFileTO documentoFileOrigine) {
		this.documentoFileOrigine = documentoFileOrigine;
	}
	public DocumentFileTO getDocumentoFileOperazione() {
		return documentoFileOperazione;
	}
	public void setDocumentoFileOperazione(DocumentFileTO documentoFileOperazione) {
		this.documentoFileOperazione = documentoFileOperazione;
	}
	public String getEsitoOperazione() {
		return esitoOperazione;
	}
	public void setEsitoOperazione(String esitoOperazione) {
		this.esitoOperazione = esitoOperazione;
	}
	public String getTipoOperazione() {
		return tipoOperazione;
	}
	public void setTipoOperazione(String tipoOperazione) {
		this.tipoOperazione = tipoOperazione;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	
	
}
