package it.almavivaitalia.bilancio.commons.bo;

// Generated 1-lug-2015 10.26.47 by Hibernate Tools 3.4.0.CR1


/**
 * EserciziDemBO generated by hbm2java
 */
public class EserciziDemBO extends AbstractCommonBO implements
		java.io.Serializable {

	private Short id;
	private String statTipoEse;
	private String statStatus;

	public EserciziDemBO() {
	}

	public EserciziDemBO(Short id) {
		this.id = id;
	}

	public EserciziDemBO(Short id, String statTipoEse, String statStatus) {
		this.id = id;
		this.statTipoEse = statTipoEse;
		this.statStatus = statStatus;
	}

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getStatTipoEse() {
		return this.statTipoEse;
	}

	public void setStatTipoEse(String statTipoEse) {
		this.statTipoEse = statTipoEse;
	}

	public String getStatStatus() {
		return this.statStatus;
	}

	public void setStatStatus(String statStatus) {
		this.statStatus = statStatus;
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
		buffer.append("statTipoEse").append("='").append(getStatTipoEse())
				.append("' ");
		buffer.append("statStatus").append("='").append(getStatStatus())
				.append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EserciziDemBO))
			return false;
		EserciziDemBO castOther = (EserciziDemBO) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getStatTipoEse() == castOther.getStatTipoEse()) || (this
						.getStatTipoEse() != null
						&& castOther.getStatTipoEse() != null && this
						.getStatTipoEse().equals(castOther.getStatTipoEse())))
				&& ((this.getStatStatus() == castOther.getStatStatus()) || (this
						.getStatStatus() != null
						&& castOther.getStatStatus() != null && this
						.getStatStatus().equals(castOther.getStatStatus())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getStatTipoEse() == null ? 0 : this.getStatTipoEse()
						.hashCode());
		result = 37
				* result
				+ (getStatStatus() == null ? 0 : this.getStatStatus()
						.hashCode());

		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}