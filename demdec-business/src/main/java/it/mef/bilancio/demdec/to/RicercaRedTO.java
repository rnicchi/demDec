package it.mef.bilancio.demdec.to;

public class RicercaRedTO extends AbstractDemTO implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String idRed;
	private String protocolloRed;
	private String annoEse;
	private String amministrazione;
	private String stato;
	private String ufficioAssociatoRed;
	private String tipoFlusso;
	private String dataRedDa;
	private String dataRedA;	
	private String dataArrivoDa;
	private String dataArrivoA;
	
	
	public String getIdRed() {
		return idRed;
	}
	public void setIdRed(String idRed) {
		this.idRed = idRed;
	}
	public String getProtocolloRed() {
		return protocolloRed;
	}
	public void setProtocolloRed(String protocolloRed) {
		this.protocolloRed = protocolloRed;
	}
	public String getAnnoEse() {
		return annoEse;
	}
	public void setAnnoEse(String annoEse) {
		this.annoEse = annoEse;
	}
	public String getAmministrazione() {
		return amministrazione;
	}
	public void setAmministrazione(String amministrazione) {
		this.amministrazione = amministrazione;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getUfficioAssociatoRed() {
		return ufficioAssociatoRed;
	}
	public void setUfficioAssociatoRed(String ufficioAssociatoRed) {
		this.ufficioAssociatoRed = ufficioAssociatoRed;
	}
	public String getTipoFlusso() {
		return tipoFlusso;
	}
	public void setTipoFlusso(String tipoFlusso) {
		this.tipoFlusso = tipoFlusso;
	}
	public String getDataRedDa() {
		return dataRedDa;
	}
	public void setDataRedDa(String dataRedDa) {
		this.dataRedDa = dataRedDa;
	}
	public String getDataRedA() {
		return dataRedA;
	}
	public void setDataRedA(String dataRedA) {
		this.dataRedA = dataRedA;
	}
	public String getDataArrivoDa() {
		return dataArrivoDa;
	}
	public void setDataArrivoDa(String dataArrivoDa) {
		this.dataArrivoDa = dataArrivoDa;
	}
	public String getDataArrivoA() {
		return dataArrivoA;
	}
	public void setDataArrivoA(String dataArrivoA) {
		this.dataArrivoA = dataArrivoA;
	}
	
	
}
