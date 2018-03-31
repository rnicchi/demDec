package it.mef.bilancio.demdec.servizi.to;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;

import java.util.Date;
import java.util.List;



public class FascicoloSipatrTO extends AbstractDemTO implements java.io.Serializable{//INIZIO METODO

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		private String idFascicoloFAD;
		private String idFascicoloSipatr;
		private String descrizione;
		private List <DocumentTO>  documenti;
		private String statoFascicoloDocumentale;
		private String dataCreazione;
		private String dataChiusura;
		private String dataAggiornamento;
		private Boolean daInviare;
		private Boolean attivo;
		private String sistemaProduttore;
	
		
		
		//metadati
	
		private String identificativoSIPATR;
		private CodeDescriptionTO amministrazione;
		private CodeDescriptionTO ragioneria;
		private String titolo;
		private String statoFascicoloSIPATR;
		private Date dataChiusuraFascicoloSIPATR;
		public String getIdFascicoloFAD() {
			return idFascicoloFAD;
		}
		public void setIdFascicoloFAD(String idFascicoloFAD) {
			this.idFascicoloFAD = idFascicoloFAD;
		}
		public String getIdFascicoloSipatr() {
			return idFascicoloSipatr;
		}
		public void setIdFascicoloSipatr(String idFascicoloSipatr) {
			this.idFascicoloSipatr = idFascicoloSipatr;
		}
		public String getDescrizione() {
			return descrizione;
		}
		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}
		public String getStatoFascicoloDocumentale() {
			return statoFascicoloDocumentale;
		}
		public void setStatoFascicoloDocumentale(String statoFascicoloDocumentale) {
			this.statoFascicoloDocumentale = statoFascicoloDocumentale;
		}
		public Boolean getDaInviare() {
			return daInviare;
		}
		public void setDaInviare(Boolean daInviare) {
			this.daInviare = daInviare;
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
		public String getIdentificativoSIPATR() {
			return identificativoSIPATR;
		}
		public void setIdentificativoSIPATR(String identificativoSIPATR) {
			this.identificativoSIPATR = identificativoSIPATR;
		}
		public CodeDescriptionTO getAmministrazione() {
			return amministrazione;
		}
		public void setAmministrazione(CodeDescriptionTO amministrazione) {
			this.amministrazione = amministrazione;
		}
		public CodeDescriptionTO getRagioneria() {
			return ragioneria;
		}
		public void setRagioneria(CodeDescriptionTO ragioneria) {
			this.ragioneria = ragioneria;
		}
		public String getTitolo() {
			return titolo;
		}
		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}
		public String getStatoFascicoloSIPATR() {
			return statoFascicoloSIPATR;
		}
		public void setStatoFascicoloSIPATR(String statoFascicoloSIPATR) {
			this.statoFascicoloSIPATR = statoFascicoloSIPATR;
		}
		public Date getDataChiusuraFascicoloSIPATR() {
			return dataChiusuraFascicoloSIPATR;
		}
		public void setDataChiusuraFascicoloSIPATR(Date dataChiusuraFascicoloSIPATR) {
			this.dataChiusuraFascicoloSIPATR = dataChiusuraFascicoloSIPATR;
		}
		public String getDataCreazione() {
			return dataCreazione;
		}
		public void setDataCreazione(String dataCreazione) {
			this.dataCreazione = dataCreazione;
		}
		public String getDataChiusura() {
			return dataChiusura;
		}
		public void setDataChiusura(String dataChiusura) {
			this.dataChiusura = dataChiusura;
		}
		public String getDataAggiornamento() {
			return dataAggiornamento;
		}
		public void setDataAggiornamento(String dataAggiornamento) {
			this.dataAggiornamento = dataAggiornamento;
		}
		public List<DocumentTO> getDocumenti() {
			return documenti;
		}
		public void setDocumenti(List<DocumentTO> documenti) {
			this.documenti = documenti;
		}


	

}//END
