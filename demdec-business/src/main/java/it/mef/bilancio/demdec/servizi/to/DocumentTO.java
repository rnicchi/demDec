package it.mef.bilancio.demdec.servizi.to;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;

public class DocumentTO extends AbstractDemTO implements java.io.Serializable  {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8344454719700836834L;
	
	private String idFascicolo;
	private String idSottoFascicolo;
	private String idDocumento;
	private String idDocumentoRaccoltaProvvisoria;
	private CodeDescriptionTO tipoDocumento;
	private CodeDescriptionTO tipoDocumentoRed;
	private CodeDescriptionTO descDocumento;
	private CodeDescriptionTO amministrazione;
	private CodeDescriptionTO ucbRts;
	private CodeDescriptionTO ufficioCreatoreRed;
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
	private String codiIdRed;
	private String tipoFlusso;
	
	
	/**
	 * Metadata
	 */
	
	private String dataDocumento;
	private String dataChiusura;
	private String dataAnnullamento;
	private String note;
	private ProtocolloTO protocollo;
	private ProtocolloTO protocolloRed;

	
	
	private String fascicoliAssociati;
	
	public String getFascicoliAssociati() {
		return fascicoliAssociati;
	}
	public void setFascicoliAssociati(String fascicoliAssociati) {
		this.fascicoliAssociati = fascicoliAssociati;
	}
	
	
	private DocumentContentTO documentoContent;
	/**
	 * DocumentContentTO
	 */
	/*private String idDocumento;
	private String descrizione;
	private String fileName;
	private byte[] hash;
	private String mimeType;
	private Boolean firmato;
	private String tipoCompressione;
	private Long length;
	private byte[] content;
	*/
	
	//Optional
	private DocumentFileTO documentoFileOrigine;
	
    //Optional
	private DocumentFileTO documentoFileOperazione;
	private String esitoOperazione;
	private String tipoOperazione;
	
	private String preView;
	
	private String rowClassStyle;
	

	
	public CodeDescriptionTO getUtenteCreatore() {
		return utenteCreatore;
	}
	public void setUtenteCreatore(CodeDescriptionTO utenteCreatore) {
		this.utenteCreatore = utenteCreatore;
	}
	public ProtocolloTO getProtocolloRed() {
		return protocolloRed;
	}
	public void setProtocolloRed(ProtocolloTO protocolloRed) {
		this.protocolloRed = protocolloRed;
	}
	public String getTipoFlusso() {
		return tipoFlusso;
	}
	public void setTipoFlusso(String tipoFlusso) {
		this.tipoFlusso = tipoFlusso;
	}
	public CodeDescriptionTO getUfficioCreatoreRed() {
		return ufficioCreatoreRed;
	}
	public void setUfficioCreatoreRed(CodeDescriptionTO ufficioCreatoreRed) {
		this.ufficioCreatoreRed = ufficioCreatoreRed;
	}
	public String getIdDocumentoRaccoltaProvvisoria() {
		return idDocumentoRaccoltaProvvisoria;
	}
	public void setIdDocumentoRaccoltaProvvisoria(
			String idDocumentoRaccoltaProvvisoria) {
		this.idDocumentoRaccoltaProvvisoria = idDocumentoRaccoltaProvvisoria;
	}
	public String getCodiIdRed() {
		return codiIdRed;
	}
	public void setCodiIdRed(String codiIdRed) {
		this.codiIdRed = codiIdRed;
	}
	public CodeDescriptionTO getTipoDocumentoRed() {
		return tipoDocumentoRed;
	}
	public void setTipoDocumentoRed(CodeDescriptionTO tipoDocumentoRed) {
		this.tipoDocumentoRed = tipoDocumentoRed;
	}
	public CodeDescriptionTO getDescDocumento() {
		return descDocumento;
	}
	public void setDescDocumento(CodeDescriptionTO descDocumento) {
		this.descDocumento = descDocumento;
	}
	public Integer getStatDocumento() {
		return statDocumento;
	}
	public void setStatDocumento(Integer statDocumento) {
		this.statDocumento = statDocumento;
	}
	public String getIdFascicolo() {
		return idFascicolo;
	}
	public void setIdFascicolo(String idFascicolo) {
		this.idFascicolo = idFascicolo;
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

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public String getTipoOperazione() {
		return tipoOperazione;
	}
	public void setTipoOperazione(String tipoOperazione) {
		this.tipoOperazione = tipoOperazione;
	}
	public String getEsitoOperazione() {
		return esitoOperazione;
	}
	public void setEsitoOperazione(String esitoOperazione) {
		this.esitoOperazione = esitoOperazione;
	}
	public ProtocolloTO getProtocollo() {
		return protocollo;
	}
	public void setProtocollo(ProtocolloTO protocollo) {
		this.protocollo = protocollo;
	}
	public String getIdSottoFascicolo() {
		return idSottoFascicolo;
	}
	public void setIdSottoFascicolo(String idSottoFascicolo) {
		this.idSottoFascicolo = idSottoFascicolo;
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
	public String getTicketArchiviazione() {
		return ticketArchiviazione;
	}
	public void setTicketArchiviazione(String ticketArchiviazione) {
		this.ticketArchiviazione = ticketArchiviazione;
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
	public Boolean getDaInviare() {
		return daInviare;
	}
	public void setDaInviare(Boolean daInviare) {
		this.daInviare = daInviare;
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
	
	public String getPreView() {
		return preView;
	}
	
	public void setPreView(String preView) {
		this.preView = preView;
	}
	
	public String getRowClassStyle() {
		return rowClassStyle;
	}
	
	public void setRowClassStyle(String rowClassStyle) {
		this.rowClassStyle = rowClassStyle;
	}
	
	@Override
	public String toString() {
		return "DocumentTO [idFascicolo=" + idFascicolo + ", idSottoFascicolo="
				+ idSottoFascicolo + ", idDocumento=" + idDocumento
				+ ", tipoDocumento=" + tipoDocumento + ", amministrazione="
				+ amministrazione + ", ucbRts=" + ucbRts + ", descrizione="
				+ descrizione + ", dataCreazione=" + dataCreazione
				+ ", condivisibile=" + condivisibile + ", attivo=" + attivo
				+ ", daInviare=" + daInviare + ", sistemaProduttore="
				+ sistemaProduttore + ", isDocumentoOriginale="
				+ isDocumentoOriginale + ", isDocumentoTrattato="
				+ isDocumentoTrattato + ", ticketArchiviazione="
				+ ticketArchiviazione + ", dataDocumento=" + dataDocumento
				+ ", dataChiusura=" + dataChiusura + ", dataAnnullamento="
				+ dataAnnullamento + ", note=" + note + ", protocollo="
				+ protocollo + ", documentoContent=" + documentoContent
				+ ", documentoFileOrigine=" + documentoFileOrigine
				+ ", documentoFileOperazione=" + documentoFileOperazione
				+ ", esitoOperazione=" + esitoOperazione + ", tipoOperazione="
				+ tipoOperazione + "]";
	}
	
}
