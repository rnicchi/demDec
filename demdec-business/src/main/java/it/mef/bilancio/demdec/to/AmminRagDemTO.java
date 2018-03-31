package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;

public class AmminRagDemTO extends AbstractCommonTO implements		java.io.Serializable {

	private AmminRagDemTOId id;

	public AmminRagDemTO() {
	}

	public AmminRagDemTO(AmminRagDemTOId id) {
		this.id = id;
	}

	public AmminRagDemTOId getId() {
		return this.id;
	}

	public void setId(AmminRagDemTOId id) {
		this.id = id;
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
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AmminRagDemTO))
			return false;
		AmminRagDemTO castOther = (AmminRagDemTO) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}
