package it.mef.bilancio.demdec.servizi.to;

import it.mef.bilancio.demdec.to.AbstractDemTO;

import java.util.Arrays;
import java.util.List;

public class DocumentFileTO extends AbstractDemTO implements java.io.Serializable  {
	private String idDocumento;
	private String descrizione;
	private String fileName;
	private byte[] hash;
	private String mimeType;
	private Boolean firmato;
	private String tipoCompressione;
	private Long length;
//	private byte[] content;
	public String getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getHash() {
		return hash;
	}
	public void setHash(byte[] hash) {
		this.hash = hash;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getTipoCompressione() {
		return tipoCompressione;
	}
	public void setTipoCompressione(String tipoCompressione) {
		this.tipoCompressione = tipoCompressione;
	}
//	public byte[] getContent() {
//		return content;
//	}
//	public void setContent(byte[] content) {
//		this.content = content;
//	}
	public Boolean getFirmato() {
		return firmato;
	}
	public void setFirmato(Boolean firmato) {
		this.firmato = firmato;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "DocumentFileTO [idDocumento=" + idDocumento + ", descrizione="
				+ descrizione + ", fileName=" + fileName + ", hash="
				+ Arrays.toString(hash) + ", mimeType=" + mimeType
				+ ", firmato=" + firmato + ", tipoCompressione="
				+ tipoCompressione + ", length=" + length + ", content="
				+ "]";
//				+ Arrays.toString(content) + "]";
	}
	


}
