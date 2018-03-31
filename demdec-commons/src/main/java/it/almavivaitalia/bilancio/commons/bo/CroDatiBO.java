package it.almavivaitalia.bilancio.commons.bo;

// Generated 20-lug-2010 15.50.55 by Hibernate Tools 3.2.4.GA

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CroDatiBO generated by hbm2java
 */
public class CroDatiBO extends AbstractCommonBO implements java.io.Serializable {

	private CroDatiBOId id;
	private CroTransBO croTrans;
	private ActionBO action;
	private Short annoEseCap;
	private Integer numeStpCap;
	private Integer numeAppCap;
	private Integer numeEosCap;
	private Short numeNumCap;
	private Short annoEseAut;
	private Integer numeTipoAut;
	private Integer numeNumAut;
	private Integer numeArtAut;
	private Integer numeCommaAut;
	private String codiPuntoAut;
	private Short annoEseStr;
	private Integer numeTipoStr;
	private Integer numeNumStr;
	private Short annoPrimaiscPar;
	private Integer numePrimaiscPar;
	private Short annoPlPle;
	private Short numePlPle;
	private String descUtente;
	private String textNote;
	private Date orarOperaz;
	private Short annoEsePar;
	private Date dataOperaz;
	private Integer numePg;
	private Short numeSubArtAut;
	private Short numeSubCommaAut;
	private Short numeSubPuntoAut;
	private Short annoEseSst;
	private Integer numeTipoSst;
	private Integer numeNumSst;
	private List<CroValoriBO> croValoriList = new ArrayList<CroValoriBO>(0);

	public CroDatiBO() { // BEGIN
	}

	public CroDatiBOId getId() { // BEGIN
		return this.id;
	}

	public void setId(CroDatiBOId id) { // BEGIN
		this.id = id;
	}

	public CroTransBO getCroTrans() { // BEGIN
		return this.croTrans;
	}

	public void setCroTrans(CroTransBO croTrans) { // BEGIN
		this.croTrans = croTrans;
	}

	public ActionBO getAction() {
		return action;
	}

	public void setAction(ActionBO action) {
		this.action = action;
	}

	public Short getAnnoEseCap() { // BEGIN
		return this.annoEseCap;
	}

	public void setAnnoEseCap(Short annoEseCap) { // BEGIN
		this.annoEseCap = annoEseCap;
	}

	public Integer getNumeStpCap() { // BEGIN
		return this.numeStpCap;
	}

	public void setNumeStpCap(Integer numeStpCap) { // BEGIN
		this.numeStpCap = numeStpCap;
	}

	public Integer getNumeAppCap() { // BEGIN
		return this.numeAppCap;
	}

	public void setNumeAppCap(Integer numeAppCap) { // BEGIN
		this.numeAppCap = numeAppCap;
	}

	public Integer getNumeEosCap() { // BEGIN
		return this.numeEosCap;
	}

	public void setNumeEosCap(Integer numeEosCap) { // BEGIN
		this.numeEosCap = numeEosCap;
	}

	public Short getNumeNumCap() { // BEGIN
		return this.numeNumCap;
	}

	public void setNumeNumCap(Short numeNumCap) { // BEGIN
		this.numeNumCap = numeNumCap;
	}

	public Short getAnnoEseAut() { // BEGIN
		return this.annoEseAut;
	}

	public void setAnnoEseAut(Short annoEseAut) { // BEGIN
		this.annoEseAut = annoEseAut;
	}

	public Integer getNumeTipoAut() { // BEGIN
		return this.numeTipoAut;
	}

	public void setNumeTipoAut(Integer numeTipoAut) { // BEGIN
		this.numeTipoAut = numeTipoAut;
	}

	public Integer getNumeNumAut() { // BEGIN
		return this.numeNumAut;
	}

	public void setNumeNumAut(Integer numeNumAut) { // BEGIN
		this.numeNumAut = numeNumAut;
	}

	public Integer getNumeArtAut() { // BEGIN
		return this.numeArtAut;
	}

	public void setNumeArtAut(Integer numeArtAut) { // BEGIN
		this.numeArtAut = numeArtAut;
	}

	public Integer getNumeCommaAut() { // BEGIN
		return this.numeCommaAut;
	}

	public void setNumeCommaAut(Integer numeCommaAut) { // BEGIN
		this.numeCommaAut = numeCommaAut;
	}

	public String getCodiPuntoAut() { // BEGIN
		return this.codiPuntoAut;
	}

	public void setCodiPuntoAut(String codiPuntoAut) { // BEGIN
		this.codiPuntoAut = codiPuntoAut;
	}

	public Short getAnnoEseStr() { // BEGIN
		return this.annoEseStr;
	}

	public void setAnnoEseStr(Short annoEseStr) { // BEGIN
		this.annoEseStr = annoEseStr;
	}

	public Integer getNumeTipoStr() { // BEGIN
		return this.numeTipoStr;
	}

	public void setNumeTipoStr(Integer numeTipoStr) { // BEGIN
		this.numeTipoStr = numeTipoStr;
	}

	public Integer getNumeNumStr() { // BEGIN
		return this.numeNumStr;
	}

	public void setNumeNumStr(Integer numeNumStr) { // BEGIN
		this.numeNumStr = numeNumStr;
	}

	public Short getAnnoPrimaiscPar() { // BEGIN
		return this.annoPrimaiscPar;
	}

	public void setAnnoPrimaiscPar(Short annoPrimaiscPar) { // BEGIN
		this.annoPrimaiscPar = annoPrimaiscPar;
	}

	public Integer getNumePrimaiscPar() { // BEGIN
		return this.numePrimaiscPar;
	}

	public void setNumePrimaiscPar(Integer numePrimaiscPar) { // BEGIN
		this.numePrimaiscPar = numePrimaiscPar;
	}

	public Short getAnnoPlPle() { // BEGIN
		return this.annoPlPle;
	}

	public void setAnnoPlPle(Short annoPlPle) { // BEGIN
		this.annoPlPle = annoPlPle;
	}

	public Short getNumePlPle() { // BEGIN
		return this.numePlPle;
	}

	public void setNumePlPle(Short numePlPle) { // BEGIN
		this.numePlPle = numePlPle;
	}

	public String getDescUtente() { // BEGIN
		return this.descUtente;
	}

	public void setDescUtente(String descUtente) { // BEGIN
		this.descUtente = descUtente;
	}

	public String getTextNote() { // BEGIN
		return this.textNote;
	}

	public void setTextNote(String textNote) { // BEGIN
		this.textNote = textNote;
	}

	public Date getOrarOperaz() { // BEGIN
		return this.orarOperaz;
	}

	public void setOrarOperaz(Date orarOperaz) { // BEGIN
		this.orarOperaz = orarOperaz;
	}

	public Short getAnnoEsePar() { // BEGIN
		return this.annoEsePar;
	}

	public void setAnnoEsePar(Short annoEsePar) { // BEGIN
		this.annoEsePar = annoEsePar;
	}

	public Date getDataOperaz() { // BEGIN
		return this.dataOperaz;
	}

	public void setDataOperaz(Date dataOperaz) { // BEGIN
		this.dataOperaz = dataOperaz;
	}

	public List<CroValoriBO> getCroValoriList() { // BEGIN
		return this.croValoriList;
	}

	public void setCroValoriList(List<CroValoriBO> croValoriList) { // BEGIN
		this.croValoriList = croValoriList;
	}

	public Integer getNumePg() {
		return numePg;
	}

	public void setNumePg(Integer numePg) {
		this.numePg = numePg;
	}

	public Short getNumeSubArtAut() {
		return numeSubArtAut;
	}

	public void setNumeSubArtAut(Short numeSubArtAut) {
		this.numeSubArtAut = numeSubArtAut;
	}

	public Short getNumeSubCommaAut() {
		return numeSubCommaAut;
	}

	public void setNumeSubCommaAut(Short numeSubCommaAut) {
		this.numeSubCommaAut = numeSubCommaAut;
	}

	public Short getNumeSubPuntoAut() {
		return numeSubPuntoAut;
	}

	public void setNumeSubPuntoAut(Short numeSubPuntoAut) {
		this.numeSubPuntoAut = numeSubPuntoAut;
	}

	public Short getAnnoEseSst() {
		return annoEseSst;
	}

	public void setAnnoEseSst(Short annoEseSst) {
		this.annoEseSst = annoEseSst;
	}

	public Integer getNumeTipoSst() {
		return numeTipoSst;
	}

	public void setNumeTipoSst(Integer numeTipoSst) {
		this.numeTipoSst = numeTipoSst;
	}

	public Integer getNumeNumSst() {
		return numeNumSst;
	}

	public void setNumeNumSst(Integer numeNumSst) {
		this.numeNumSst = numeNumSst;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() { // BEGIN
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@")
				.append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("id").append("='").append(getId()).append("' ");
		buffer.append("croTrans").append("='").append(getCroTrans())
				.append("' ");
		buffer.append("action").append("='").append(getAction())
				.append("' ");
		buffer.append("annoEseCap").append("='").append(getAnnoEseCap())
				.append("' ");
		buffer.append("numeStpCap").append("='").append(getNumeStpCap())
				.append("' ");
		buffer.append("numeAppCap").append("='").append(getNumeAppCap())
				.append("' ");
		buffer.append("numeEosCap").append("='").append(getNumeEosCap())
				.append("' ");
		buffer.append("numeNumCap").append("='").append(getNumeNumCap())
				.append("' ");
		buffer.append("annoEseAut").append("='").append(getAnnoEseAut())
				.append("' ");
		buffer.append("numeTipoAut").append("='").append(getNumeTipoAut())
				.append("' ");
		buffer.append("numeNumAut").append("='").append(getNumeNumAut())
				.append("' ");
		buffer.append("numeArtAut").append("='").append(getNumeArtAut())
				.append("' ");
		buffer.append("numeCommaAut").append("='").append(getNumeCommaAut())
				.append("' ");
		buffer.append("codiPuntoAut").append("='").append(getCodiPuntoAut())
				.append("' ");
		buffer.append("annoEseStr").append("='").append(getAnnoEseStr())
				.append("' ");
		buffer.append("numeTipoStr").append("='").append(getNumeTipoStr())
				.append("' ");
		buffer.append("numeNumStr").append("='").append(getNumeNumStr())
				.append("' ");
		buffer.append("annoPrimaiscPar").append("='")
				.append(getAnnoPrimaiscPar()).append("' ");
		buffer.append("numePrimaiscPar").append("='")
				.append(getNumePrimaiscPar()).append("' ");
		buffer.append("annoPlPle").append("='").append(getAnnoPlPle())
				.append("' ");
		buffer.append("numePlPle").append("='").append(getNumePlPle())
				.append("' ");
		buffer.append("descUtente").append("='").append(getDescUtente())
				.append("' ");
		buffer.append("textNote").append("='").append(getTextNote())
				.append("' ");
		buffer.append("orarOperaz").append("='").append(getOrarOperaz())
				.append("' ");
		buffer.append("annoEsePar").append("='").append(getAnnoEsePar())
				.append("' ");
		buffer.append("dataOperaz").append("='").append(getDataOperaz())
				.append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) { // BEGIN
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CroDatiBO))
			return false;
		CroDatiBO castOther = (CroDatiBO) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCroTrans() == castOther.getCroTrans()) || (this
						.getCroTrans() != null
						&& castOther.getCroTrans() != null && this
						.getCroTrans().equals(castOther.getCroTrans())))
				&& ((this.getAction() == castOther.getAction()) || (this
						.getAction() != null
						&& castOther.getAction() != null && this
						.getAction().equals(castOther.getAction())))
				&& ((this.getAnnoEseCap() == castOther.getAnnoEseCap()) || (this
						.getAnnoEseCap() != null
						&& castOther.getAnnoEseCap() != null && this
						.getAnnoEseCap().equals(castOther.getAnnoEseCap())))
				&& ((this.getNumeStpCap() == castOther.getNumeStpCap()) || (this
						.getNumeStpCap() != null
						&& castOther.getNumeStpCap() != null && this
						.getNumeStpCap().equals(castOther.getNumeStpCap())))
				&& ((this.getNumeAppCap() == castOther.getNumeAppCap()) || (this
						.getNumeAppCap() != null
						&& castOther.getNumeAppCap() != null && this
						.getNumeAppCap().equals(castOther.getNumeAppCap())))
				&& ((this.getNumeEosCap() == castOther.getNumeEosCap()) || (this
						.getNumeEosCap() != null
						&& castOther.getNumeEosCap() != null && this
						.getNumeEosCap().equals(castOther.getNumeEosCap())))
				&& ((this.getNumeNumCap() == castOther.getNumeNumCap()) || (this
						.getNumeNumCap() != null
						&& castOther.getNumeNumCap() != null && this
						.getNumeNumCap().equals(castOther.getNumeNumCap())))
				&& ((this.getAnnoEseAut() == castOther.getAnnoEseAut()) || (this
						.getAnnoEseAut() != null
						&& castOther.getAnnoEseAut() != null && this
						.getAnnoEseAut().equals(castOther.getAnnoEseAut())))
				&& ((this.getNumeTipoAut() == castOther.getNumeTipoAut()) || (this
						.getNumeTipoAut() != null
						&& castOther.getNumeTipoAut() != null && this
						.getNumeTipoAut().equals(castOther.getNumeTipoAut())))
				&& ((this.getNumeNumAut() == castOther.getNumeNumAut()) || (this
						.getNumeNumAut() != null
						&& castOther.getNumeNumAut() != null && this
						.getNumeNumAut().equals(castOther.getNumeNumAut())))
				&& ((this.getNumeArtAut() == castOther.getNumeArtAut()) || (this
						.getNumeArtAut() != null
						&& castOther.getNumeArtAut() != null && this
						.getNumeArtAut().equals(castOther.getNumeArtAut())))
				&& ((this.getNumeCommaAut() == castOther.getNumeCommaAut()) || (this
						.getNumeCommaAut() != null
						&& castOther.getNumeCommaAut() != null && this
						.getNumeCommaAut().equals(castOther.getNumeCommaAut())))
				&& ((this.getCodiPuntoAut() == castOther.getCodiPuntoAut()) || (this
						.getCodiPuntoAut() != null
						&& castOther.getCodiPuntoAut() != null && this
						.getCodiPuntoAut().equals(castOther.getCodiPuntoAut())))
				&& ((this.getAnnoEseStr() == castOther.getAnnoEseStr()) || (this
						.getAnnoEseStr() != null
						&& castOther.getAnnoEseStr() != null && this
						.getAnnoEseStr().equals(castOther.getAnnoEseStr())))
				&& ((this.getNumeTipoStr() == castOther.getNumeTipoStr()) || (this
						.getNumeTipoStr() != null
						&& castOther.getNumeTipoStr() != null && this
						.getNumeTipoStr().equals(castOther.getNumeTipoStr())))
				&& ((this.getNumeNumStr() == castOther.getNumeNumStr()) || (this
						.getNumeNumStr() != null
						&& castOther.getNumeNumStr() != null && this
						.getNumeNumStr().equals(castOther.getNumeNumStr())))
				&& ((this.getAnnoPrimaiscPar() == castOther
						.getAnnoPrimaiscPar()) || (this.getAnnoPrimaiscPar() != null
						&& castOther.getAnnoPrimaiscPar() != null && this
						.getAnnoPrimaiscPar().equals(
								castOther.getAnnoPrimaiscPar())))
				&& ((this.getNumePrimaiscPar() == castOther
						.getNumePrimaiscPar()) || (this.getNumePrimaiscPar() != null
						&& castOther.getNumePrimaiscPar() != null && this
						.getNumePrimaiscPar().equals(
								castOther.getNumePrimaiscPar())))
				&& ((this.getAnnoPlPle() == castOther.getAnnoPlPle()) || (this
						.getAnnoPlPle() != null
						&& castOther.getAnnoPlPle() != null && this
						.getAnnoPlPle().equals(castOther.getAnnoPlPle())))
				&& ((this.getNumePlPle() == castOther.getNumePlPle()) || (this
						.getNumePlPle() != null
						&& castOther.getNumePlPle() != null && this
						.getNumePlPle().equals(castOther.getNumePlPle())))
				&& ((this.getDescUtente() == castOther.getDescUtente()) || (this
						.getDescUtente() != null
						&& castOther.getDescUtente() != null && this
						.getDescUtente().equals(castOther.getDescUtente())))
				&& ((this.getTextNote() == castOther.getTextNote()) || (this
						.getTextNote() != null
						&& castOther.getTextNote() != null && this
						.getTextNote().equals(castOther.getTextNote())))
				&& ((this.getOrarOperaz() == castOther.getOrarOperaz()) || (this
						.getOrarOperaz() != null
						&& castOther.getOrarOperaz() != null && this
						.getOrarOperaz().equals(castOther.getOrarOperaz())))
				&& ((this.getAnnoEsePar() == castOther.getAnnoEsePar()) || (this
						.getAnnoEsePar() != null
						&& castOther.getAnnoEsePar() != null && this
						.getAnnoEsePar().equals(castOther.getAnnoEsePar())))
				&& ((this.getDataOperaz() == castOther.getDataOperaz()) || (this
						.getDataOperaz() != null
						&& castOther.getDataOperaz() != null && this
						.getDataOperaz().equals(castOther.getDataOperaz())));
	}

	public int hashCode() { // BEGIN
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getCroTrans() == null ? 0 : this.getCroTrans().hashCode());
		result = 37 * result
				+ (getAction() == null ? 0 : this.getAction().hashCode());
		result = 37
				* result
				+ (getAnnoEseCap() == null ? 0 : this.getAnnoEseCap()
						.hashCode());
		result = 37
				* result
				+ (getNumeStpCap() == null ? 0 : this.getNumeStpCap()
						.hashCode());
		result = 37
				* result
				+ (getNumeAppCap() == null ? 0 : this.getNumeAppCap()
						.hashCode());
		result = 37
				* result
				+ (getNumeEosCap() == null ? 0 : this.getNumeEosCap()
						.hashCode());
		result = 37
				* result
				+ (getNumeNumCap() == null ? 0 : this.getNumeNumCap()
						.hashCode());
		result = 37
				* result
				+ (getAnnoEseAut() == null ? 0 : this.getAnnoEseAut()
						.hashCode());
		result = 37
				* result
				+ (getNumeTipoAut() == null ? 0 : this.getNumeTipoAut()
						.hashCode());
		result = 37
				* result
				+ (getNumeNumAut() == null ? 0 : this.getNumeNumAut()
						.hashCode());
		result = 37
				* result
				+ (getNumeArtAut() == null ? 0 : this.getNumeArtAut()
						.hashCode());
		result = 37
				* result
				+ (getNumeCommaAut() == null ? 0 : this.getNumeCommaAut()
						.hashCode());
		result = 37
				* result
				+ (getCodiPuntoAut() == null ? 0 : this.getCodiPuntoAut()
						.hashCode());
		result = 37
				* result
				+ (getAnnoEseStr() == null ? 0 : this.getAnnoEseStr()
						.hashCode());
		result = 37
				* result
				+ (getNumeTipoStr() == null ? 0 : this.getNumeTipoStr()
						.hashCode());
		result = 37
				* result
				+ (getNumeNumStr() == null ? 0 : this.getNumeNumStr()
						.hashCode());
		result = 37
				* result
				+ (getAnnoPrimaiscPar() == null ? 0 : this.getAnnoPrimaiscPar()
						.hashCode());
		result = 37
				* result
				+ (getNumePrimaiscPar() == null ? 0 : this.getNumePrimaiscPar()
						.hashCode());
		result = 37 * result
				+ (getAnnoPlPle() == null ? 0 : this.getAnnoPlPle().hashCode());
		result = 37 * result
				+ (getNumePlPle() == null ? 0 : this.getNumePlPle().hashCode());
		result = 37
				* result
				+ (getDescUtente() == null ? 0 : this.getDescUtente()
						.hashCode());
		result = 37 * result
				+ (getTextNote() == null ? 0 : this.getTextNote().hashCode());
		result = 37
				* result
				+ (getOrarOperaz() == null ? 0 : this.getOrarOperaz()
						.hashCode());
		result = 37
				* result
				+ (getAnnoEsePar() == null ? 0 : this.getAnnoEsePar()
						.hashCode());
		result = 37
				* result
				+ (getDataOperaz() == null ? 0 : this.getDataOperaz()
						.hashCode());

		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM1 = "LOCM";
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM2 = "LOCM";
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM3 = "LOCM";
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM4 = "LOCM";
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM5 = "LOCM";
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM6 = "LOCM";

}
