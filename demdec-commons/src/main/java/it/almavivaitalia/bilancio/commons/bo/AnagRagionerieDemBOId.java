package it.almavivaitalia.bilancio.commons.bo;

// Generated 1-lug-2015 10.26.47 by Hibernate Tools 3.4.0.CR1

/**
 * AnagRagionerieDemBOId generated by hbm2java
 */
public class AnagRagionerieDemBOId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5237737771652888925L;
	private Short fkAnnoEse;
	private Short numeRag;

	public AnagRagionerieDemBOId() {
	}

	public AnagRagionerieDemBOId(Short fkAnnoEse, Short fkNumeRag) {
		this.fkAnnoEse = fkAnnoEse;
		this.numeRag = fkNumeRag;
	}

	public Short getFkAnnoEse() {
		return this.fkAnnoEse;
	}

	public void setFkAnnoEse(Short fkAnnoEse) {
		this.fkAnnoEse = fkAnnoEse;
	}

	

	public Short getNumeRag() {
		return numeRag;
	}

	public void setNumeRag(Short numeRag) {
		this.numeRag = numeRag;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AnagRagionerieDemBOId))
			return false;
		AnagRagionerieDemBOId castOther = (AnagRagionerieDemBOId) other;

		return ((this.getFkAnnoEse() == castOther.getFkAnnoEse()) || (this
				.getFkAnnoEse() != null && castOther.getFkAnnoEse() != null && this
				.getFkAnnoEse().equals(castOther.getFkAnnoEse())))
				&& ((this.getNumeRag() == castOther.getNumeRag()) || (this
						.getNumeRag() != null && castOther.getNumeRag() != null && this
						.getNumeRag().equals(castOther.getNumeRag())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFkAnnoEse() == null ? 0 : this.getFkAnnoEse().hashCode());
		result = 37 * result
				+ (getNumeRag() == null ? 0 : this.getNumeRag().hashCode());
		return result;
	}

}