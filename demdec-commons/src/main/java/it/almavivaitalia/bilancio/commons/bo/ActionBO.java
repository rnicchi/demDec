package it.almavivaitalia.bilancio.commons.bo;

// Generated 5-giu-2015 12.17.04 by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.List;

/**
 * ActionBO generated by hbm2java
 */
public class ActionBO extends AbstractCommonBO implements java.io.Serializable {

	private Integer id;
	private String codiAction;
	private String descAction;
	private Integer flagActive;
	private List<ProfiloBO> profiloList = new ArrayList<ProfiloBO>(0);
	private List<ItemBO> itemList = new ArrayList<ItemBO>(0);

	public ActionBO() {
	}

	public ActionBO(String codiAction) {
		this.codiAction = codiAction;
	}

	public ActionBO(String codiAction, String descAction, Integer flagActive,
			List<ProfiloBO> profiloList, List<ItemBO> itemList) {
		this.codiAction = codiAction;
		this.descAction = descAction;
		this.flagActive = flagActive;
		this.profiloList = profiloList;
		this.itemList = itemList;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodiAction() {
		return this.codiAction;
	}

	public void setCodiAction(String codiAction) {
		this.codiAction = codiAction;
	}

	public String getDescAction() {
		return this.descAction;
	}

	public void setDescAction(String descAction) {
		this.descAction = descAction;
	}

	public Integer getFlagActive() {
		return this.flagActive;
	}

	public void setFlagActive(Integer flagActive) {
		this.flagActive = flagActive;
	}

	public List<ProfiloBO> getProfiloList() {
		return this.profiloList;
	}

	public void setProfiloList(List<ProfiloBO> profiloList) {
		this.profiloList = profiloList;
	}

	public List<ItemBO> getItemList() {
		return this.itemList;
	}

	public void setItemList(List<ItemBO> itemList) {
		this.itemList = itemList;
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
		buffer.append("codiAction").append("='").append(getCodiAction())
				.append("' ");
		buffer.append("descAction").append("='").append(getDescAction())
				.append("' ");
		buffer.append("flagActive").append("='").append(getFlagActive())
				.append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ActionBO))
			return false;
		ActionBO castOther = (ActionBO) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCodiAction() == castOther.getCodiAction()) || (this
						.getCodiAction() != null
						&& castOther.getCodiAction() != null && this
						.getCodiAction().equals(castOther.getCodiAction())))
				&& ((this.getDescAction() == castOther.getDescAction()) || (this
						.getDescAction() != null
						&& castOther.getDescAction() != null && this
						.getDescAction().equals(castOther.getDescAction())))
				&& ((this.getFlagActive() == castOther.getFlagActive()) || (this
						.getFlagActive() != null
						&& castOther.getFlagActive() != null && this
						.getFlagActive().equals(castOther.getFlagActive())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getCodiAction() == null ? 0 : this.getCodiAction()
						.hashCode());
		result = 37
				* result
				+ (getDescAction() == null ? 0 : this.getDescAction()
						.hashCode());
		result = 37
				* result
				+ (getFlagActive() == null ? 0 : this.getFlagActive()
						.hashCode());

		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}
