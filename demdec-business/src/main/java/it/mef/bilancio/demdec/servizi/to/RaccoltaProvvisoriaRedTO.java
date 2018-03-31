package it.mef.bilancio.demdec.servizi.to;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;

import java.util.List;



public class RaccoltaProvvisoriaRedTO extends AbstractDemTO implements  java.io.Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 6571241506803488460L;
//INIZIO METODO
	
	private String idFascicoloRaccoltaProvvisoria;
	private String descrizione;//oggetto
	private List<DocumentTO> documenti;
	private String codiStatoFascicoloDocumentale;
	private String descStatoFascicoloDocumentale;
	private String dataCreazione;//data arrivo
	private String dataAggiornamento;
	private boolean daInviare;
	private String sistemaProduttore;
	private boolean attivo;
	private String title;
	private String numeIdFascicolo;

	
	//Metadata
	private String  identificativoRaccoltaProvvisoria;
	private CodeDescriptionTO ragioneria;
	private CodeDescriptionTO amministrazione;
	private CodeDescriptionTO ufficioCreatoreRED;
	private String tipoFlusso;
	private CodeDescriptionTO utenteCreatore;
	private String statoFascicoloRaccoltaProvvisoria;
	private ProtocolloTO protocollo;
	
	private String Metadata;
	private String versioneMetadata;
	
	private String preView;
	
	
	public String getPreView() {
		return preView;
	}
	public void setPreView(String preView) {
		this.preView = preView;
	}
	public String getDescStatoFascicoloDocumentale() {
		return descStatoFascicoloDocumentale;
	}
	public void setDescStatoFascicoloDocumentale(
			String descStatoFascicoloDocumentale) {
		this.descStatoFascicoloDocumentale = descStatoFascicoloDocumentale;
	}
	public String getNumeIdFascicolo() {
		return numeIdFascicolo;
	}
	public void setNumeIdFascicolo(String numeIdFascicolo) {
		this.numeIdFascicolo = numeIdFascicolo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIdFascicoloRaccoltaProvvisoria() {
		return idFascicoloRaccoltaProvvisoria;
	}
	public void setIdFascicoloRaccoltaProvvisoria(
			String idFascicoloRaccoltaProvvisoria) {
		this.idFascicoloRaccoltaProvvisoria = idFascicoloRaccoltaProvvisoria;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<DocumentTO> getDocumenti() {
		return documenti;
	}
	public void setDocumenti(List<DocumentTO> documenti) {
		this.documenti = documenti;
	}
	public String getCodiStatoFascicoloDocumentale() {
		return codiStatoFascicoloDocumentale;
	}
	public void setCodiStatoFascicoloDocumentale(
			String codiStatoFascicoloDocumentale) {
		this.codiStatoFascicoloDocumentale = codiStatoFascicoloDocumentale;
	}
	public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public String getDataAggiornamento() {
		return dataAggiornamento;
	}
	public void setDataAggiornamento(String dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
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
	public String getIdentificativoRaccoltaProvvisoria() {
		return identificativoRaccoltaProvvisoria;
	}
	public void setIdentificativoRaccoltaProvvisoria(
			String identificativoRaccoltaProvvisoria) {
		this.identificativoRaccoltaProvvisoria = identificativoRaccoltaProvvisoria;
	}
	public CodeDescriptionTO getRagioneria() {
		return ragioneria;
	}
	public void setRagioneria(CodeDescriptionTO ragioneria) {
		this.ragioneria = ragioneria;
	}
	public CodeDescriptionTO getAmministrazione() {
		return amministrazione;
	}
	public void setAmministrazione(CodeDescriptionTO amministrazione) {
		this.amministrazione = amministrazione;
	}
	public CodeDescriptionTO getUfficioCreatoreRED() {
		return ufficioCreatoreRED;
	}
	public void setUfficioCreatoreRED(CodeDescriptionTO ufficioCreatoreRED) {
		this.ufficioCreatoreRED = ufficioCreatoreRED;
	}
	public CodeDescriptionTO getUtenteCreatore() {
		return utenteCreatore;
	}
	public void setUtenteCreatore(CodeDescriptionTO utenteCreatore) {
		this.utenteCreatore = utenteCreatore;
	}
	public String getMetadata() {
		return Metadata;
	}
	public void setMetadata(String metadata) {
		Metadata = metadata;
	}
	public String getVersioneMetadata() {
		return versioneMetadata;
	}
	public void setVersioneMetadata(String versioneMetadata) {
		this.versioneMetadata = versioneMetadata;
	}
	public String getStatoFascicoloRaccoltaProvvisoria() {
		return statoFascicoloRaccoltaProvvisoria;
	}
	public void setStatoFascicoloRaccoltaProvvisoria(
			String statoFascicoloRaccoltaProvvisoria) {
		this.statoFascicoloRaccoltaProvvisoria = statoFascicoloRaccoltaProvvisoria;
	}
	public String getTipoFlusso() {
		return tipoFlusso;
	}
	public void setTipoFlusso(String tipoFlusso) {
		this.tipoFlusso = tipoFlusso;
	}
	public ProtocolloTO getProtocollo() {
		return protocollo;
	}
	public void setProtocollo(ProtocolloTO protocollo) {
		this.protocollo = protocollo;
	}
	@Override
	public String toString() {
		return "RaccoltaProvvisoriaRedTO [idFascicoloRaccoltaProvvisoria="
				+ idFascicoloRaccoltaProvvisoria + ", descrizione="
				+ descrizione + ", documenti=" + documenti
				+ ", codiStatoFascicoloDocumentale="
				+ codiStatoFascicoloDocumentale
				+ ", descStatoFascicoloDocumentale="
				+ descStatoFascicoloDocumentale + ", dataCreazione="
				+ dataCreazione + ", dataAggiornamento=" + dataAggiornamento
				+ ", daInviare=" + daInviare + ", sistemaProduttore="
				+ sistemaProduttore + ", attivo=" + attivo + ", title=" + title
				+ ", numeIdFascicolo=" + numeIdFascicolo
				+ ", identificativoRaccoltaProvvisoria="
				+ identificativoRaccoltaProvvisoria + ", ragioneria="
				+ ragioneria + ", amministrazione=" + amministrazione
				+ ", ufficioCreatoreRED=" + ufficioCreatoreRED
				+ ", tipoFlusso=" + tipoFlusso + ", utenteCreatore="
				+ utenteCreatore + ", statoFascicoloRaccoltaProvvisoria="
				+ statoFascicoloRaccoltaProvvisoria + ", protocollo="
				+ protocollo + ", Metadata=" + Metadata + ", versioneMetadata="
				+ versioneMetadata + "]";
	}
	
	

	//Metadata
	
	
	


}//END
