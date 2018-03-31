package it.almavivaitalia.bilancio.commons.bo;

// Generated 11-ago-2015 10.58.32 by Hibernate Tools 3.4.0.CR1

/**
 * AmminRagDemBOId generated by hbm2java
 */
public class AmminRagDemBOId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Short annoEse;
	private Integer numeStp;
	private Integer numeApp;
	private Short numeRag;

	public AmminRagDemBOId() {
	}

	public AmminRagDemBOId(Short annoEse, Integer numeStp, Integer numeApp,
			Short numeRag) {
		this.annoEse = annoEse;
		this.numeStp = numeStp;
		this.numeApp = numeApp;
		this.numeRag = numeRag;
	}

	public Short getAnnoEse() {
		return this.annoEse;
	}

	public void setAnnoEse(Short annoEse) {
		this.annoEse = annoEse;
	}

	public Integer getNumeStp() {
		return this.numeStp;
	}

	public void setNumeStp(Integer numeStp) {
		this.numeStp = numeStp;
	}

	public Integer getNumeApp() {
		return this.numeApp;
	}

	public void setNumeApp(Integer numeApp) {
		this.numeApp = numeApp;
	}

	public Short getNumeRag() {
		return this.numeRag;
	}

	public void setNumeRag(Short numeRag) {
		this.numeRag = numeRag;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AmminRagDemBOId))
			return false;
		AmminRagDemBOId castOther = (AmminRagDemBOId) other;

		return ((this.getAnnoEse() == castOther.getAnnoEse()) || (this
				.getAnnoEse() != null && castOther.getAnnoEse() != null && this
				.getAnnoEse().equals(castOther.getAnnoEse())))
				&& ((this.getNumeStp() == castOther.getNumeStp()) || (this
						.getNumeStp() != null && castOther.getNumeStp() != null && this
						.getNumeStp().equals(castOther.getNumeStp())))
				&& ((this.getNumeApp() == castOther.getNumeApp()) || (this
						.getNumeApp() != null && castOther.getNumeApp() != null && this
						.getNumeApp().equals(castOther.getNumeApp())))
				&& ((this.getNumeRag() == castOther.getNumeRag()) || (this
						.getNumeRag() != null && castOther.getNumeRag() != null && this
						.getNumeRag().equals(castOther.getNumeRag())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAnnoEse() == null ? 0 : this.getAnnoEse().hashCode());
		result = 37 * result
				+ (getNumeStp() == null ? 0 : this.getNumeStp().hashCode());
		result = 37 * result
				+ (getNumeApp() == null ? 0 : this.getNumeApp().hashCode());
		result = 37 * result
				+ (getNumeRag() == null ? 0 : this.getNumeRag().hashCode());
		return result;
	}

}
