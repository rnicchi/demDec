package it.almavivaitalia.bilancio.commons.bo;

// Generated 22-lug-2015 15.41.08 by Hibernate Tools 3.4.0.CR1

/**
 * IterFirmaDecretoBO generated by hbm2java
 */
public class IterFirmaDecretoBO extends AbstractCommonBO implements
		java.io.Serializable {

	private IterFirmaDecretoBOId id;
	private AnagUfficiBO anagUffici;
	private AnagAmminDemBO anagAmminDem;
	private AnagModelliIterBO anagModelliIter;
	private FascicoliBO fascicoli;
	private AnagCdrDemBO anagCdrDem;
	private AnagFirmatariBO anagFirmatari;
	private Integer numeOrdineIter;
	private String codiTipoFirma;
	private String statFirma;

	public IterFirmaDecretoBO() {
	}

	public IterFirmaDecretoBO(IterFirmaDecretoBOId id,
			AnagModelliIterBO anagModelliIter, FascicoliBO fascicoli,
			AnagFirmatariBO anagFirmatari, Integer numeOrdineIter) {
		this.id = id;
		this.anagModelliIter = anagModelliIter;
		this.fascicoli = fascicoli;
		this.anagFirmatari = anagFirmatari;
		this.numeOrdineIter = numeOrdineIter;
	}

	public IterFirmaDecretoBO(IterFirmaDecretoBOId id, AnagUfficiBO anagUffici,
			AnagAmminDemBO anagAmminDem, AnagModelliIterBO anagModelliIter,
			FascicoliBO fascicoli, AnagCdrDemBO anagCdrDem,
			AnagFirmatariBO anagFirmatari, 
			Integer numeOrdineIter, String codiTipoFirma, String statFirma) {
		this.id = id;
		this.anagUffici = anagUffici;
		this.anagAmminDem = anagAmminDem;
		this.anagModelliIter = anagModelliIter;
		this.fascicoli = fascicoli;
		this.anagCdrDem = anagCdrDem;
		this.anagFirmatari = anagFirmatari;
		this.numeOrdineIter = numeOrdineIter;
		this.codiTipoFirma = codiTipoFirma;
		this.statFirma = statFirma;
	}

	public IterFirmaDecretoBOId getId() {
		return this.id;
	}

	public void setId(IterFirmaDecretoBOId id) {
		this.id = id;
	}

	public AnagUfficiBO getAnagUffici() {
		return this.anagUffici;
	}

	public void setAnagUffici(AnagUfficiBO anagUffici) {
		this.anagUffici = anagUffici;
	}

	public AnagAmminDemBO getAnagAmminDem() {
		return this.anagAmminDem;
	}

	public void setAnagAmminDem(AnagAmminDemBO anagAmminDem) {
		this.anagAmminDem = anagAmminDem;
	}

	public AnagModelliIterBO getAnagModelliIter() {
		return this.anagModelliIter;
	}

	public void setAnagModelliIter(AnagModelliIterBO anagModelliIter) {
		this.anagModelliIter = anagModelliIter;
	}

	public FascicoliBO getFascicoli() {
		return this.fascicoli;
	}

	public void setFascicoli(FascicoliBO fascicoli) {
		this.fascicoli = fascicoli;
	}

	public AnagCdrDemBO getAnagCdrDem() {
		return this.anagCdrDem;
	}

	public void setAnagCdrDem(AnagCdrDemBO anagCdrDem) {
		this.anagCdrDem = anagCdrDem;
	}

	public AnagFirmatariBO getAnagFirmatari() {
		return this.anagFirmatari;
	}

	public void setAnagFirmatari(AnagFirmatariBO anagFirmatari) {
		this.anagFirmatari = anagFirmatari;
	}

	public Integer getNumeOrdineIter() {
		return this.numeOrdineIter;
	}

	public void setNumeOrdineIter(Integer numeOrdineIter) {
		this.numeOrdineIter = numeOrdineIter;
	}

	public String getCodiTipoFirma() {
		return this.codiTipoFirma;
	}

	public void setCodiTipoFirma(String codiTipoFirma) {
		this.codiTipoFirma = codiTipoFirma;
	}

	public String getStatFirma() {
		return this.statFirma;
	}

	public void setStatFirma(String statFirma) {
		this.statFirma = statFirma;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@")
				.append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("id").append("='").append(getId()).append("' ");
		buffer.append("anagUffici").append("='").append(getAnagUffici())
				.append("' ");
		buffer.append("anagAmminDem").append("='").append(getAnagAmminDem())
				.append("' ");
		buffer.append("anagModelliIter").append("='")
				.append(getAnagModelliIter()).append("' ");
		buffer.append("fascicoli").append("='").append(getFascicoli())
				.append("' ");
		buffer.append("anagCdrDem").append("='").append(getAnagCdrDem())
				.append("' ");
		buffer.append("anagFirmatari").append("='").append(getAnagFirmatari())
				.append("' ");
		buffer.append("numeVersion").append("='").append(getNumeVersion())
				.append("' ");
		buffer.append("numeOrdineIter").append("='")
				.append(getNumeOrdineIter()).append("' ");
		buffer.append("codiTipoFirma").append("='").append(getCodiTipoFirma())
				.append("' ");
		buffer.append("statFirma").append("='").append(getStatFirma())
				.append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IterFirmaDecretoBO))
			return false;
		IterFirmaDecretoBO castOther = (IterFirmaDecretoBO) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getAnagUffici() == castOther.getAnagUffici()) || (this
						.getAnagUffici() != null
						&& castOther.getAnagUffici() != null && this
						.getAnagUffici().equals(castOther.getAnagUffici())))
				&& ((this.getAnagAmminDem() == castOther.getAnagAmminDem()) || (this
						.getAnagAmminDem() != null
						&& castOther.getAnagAmminDem() != null && this
						.getAnagAmminDem().equals(castOther.getAnagAmminDem())))
				&& ((this.getAnagModelliIter() == castOther
						.getAnagModelliIter()) || (this.getAnagModelliIter() != null
						&& castOther.getAnagModelliIter() != null && this
						.getAnagModelliIter().equals(
								castOther.getAnagModelliIter())))
				&& ((this.getFascicoli() == castOther.getFascicoli()) || (this
						.getFascicoli() != null
						&& castOther.getFascicoli() != null && this
						.getFascicoli().equals(castOther.getFascicoli())))
				&& ((this.getAnagCdrDem() == castOther.getAnagCdrDem()) || (this
						.getAnagCdrDem() != null
						&& castOther.getAnagCdrDem() != null && this
						.getAnagCdrDem().equals(castOther.getAnagCdrDem())))
				&& ((this.getAnagFirmatari() == castOther.getAnagFirmatari()) || (this
						.getAnagFirmatari() != null
						&& castOther.getAnagFirmatari() != null && this
						.getAnagFirmatari()
						.equals(castOther.getAnagFirmatari())))
				&& ((this.getNumeVersion() == castOther.getNumeVersion()))
				&& ((this.getNumeOrdineIter() == castOther.getNumeOrdineIter()) || (this
						.getNumeOrdineIter() != null
						&& castOther.getNumeOrdineIter() != null && this
						.getNumeOrdineIter().equals(
								castOther.getNumeOrdineIter())))
				&& ((this.getCodiTipoFirma() == castOther.getCodiTipoFirma()) || (this
						.getCodiTipoFirma() != null
						&& castOther.getCodiTipoFirma() != null && this
						.getCodiTipoFirma()
						.equals(castOther.getCodiTipoFirma())))
				&& ((this.getStatFirma() == castOther.getStatFirma()) || (this
						.getStatFirma() != null
						&& castOther.getStatFirma() != null && this
						.getStatFirma().equals(castOther.getStatFirma())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getAnagUffici() == null ? 0 : this.getAnagUffici()
						.hashCode());
		result = 37
				* result
				+ (getAnagAmminDem() == null ? 0 : this.getAnagAmminDem()
						.hashCode());
		result = 37
				* result
				+ (getAnagModelliIter() == null ? 0 : this.getAnagModelliIter()
						.hashCode());
		result = 37 * result
				+ (getFascicoli() == null ? 0 : this.getFascicoli().hashCode());
		result = 37
				* result
				+ (getAnagCdrDem() == null ? 0 : this.getAnagCdrDem()
						.hashCode());
		result = 37
				* result
				+ (getAnagFirmatari() == null ? 0 : this.getAnagFirmatari()
						.hashCode());
		result = 37
				* result
				+ (getNumeVersion());
		result = 37
				* result
				+ (getNumeOrdineIter() == null ? 0 : this.getNumeOrdineIter()
						.hashCode());
		result = 37
				* result
				+ (getCodiTipoFirma() == null ? 0 : this.getCodiTipoFirma()
						.hashCode());
		result = 37 * result
				+ (getStatFirma() == null ? 0 : this.getStatFirma().hashCode());
		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}
