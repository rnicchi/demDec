package it.almavivaitalia.bilancio.commons.to;

// Generated 25-gen-2010 16.15.19 by Hibernate Tools 3.2.4.GA



import java.util.ArrayList;
import java.util.List;

/**
 * Action generated by hbm2java
 */
public class ActionTO extends AbstractCommonTO implements java.io.Serializable {

	private Long id;
	private String codiAction;
	private List<ProfiloTO> profiloList = new ArrayList<ProfiloTO>(0);
	private List<ItemTO> itemList = new ArrayList<ItemTO>(0);
	private Short flagActive;
	private String descAction;

	
	public Short getFlagActive() {
		return flagActive==null?0:flagActive;
	}

	public void setFlagActive(Short flagActive) {
		this.flagActive = flagActive;
	}

	public ActionTO() {
	}

	public ActionTO(String codiAction) {
		this.codiAction = codiAction;
	}


	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodiAction() {
		return this.codiAction;
	}

	public void setCodiAction(String codiAction) {
		this.codiAction = codiAction;
	}

	

	public List<ProfiloTO> getProfiloList() {
		return profiloList;
	}

	public void setProfiloList(List<ProfiloTO> profiloList) {
		this.profiloList = profiloList;
	}

	public List<ItemTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemTO> itemList) {
		this.itemList = itemList;
	}

	public String getDescAction() {
		return this.descAction;
	}

	public void setDescAction(String descAction) {
		this.descAction = descAction;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(
				Integer.toHexString(hashCode())).append(" [");
		buffer.append("sequIdAction").append("='").append(getId())
				.append("' ");
		buffer.append("codiAction").append("='").append(getCodiAction())
				.append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ActionTO))
			return false;
		ActionTO castOther = (ActionTO) other;

		return ((this.getId() == castOther.getId()) || (this
				.getId() != null
				&& castOther.getId() != null && this
				.getId().equals(castOther.getId())))
				&& ((this.getCodiAction() == castOther.getCodiAction()) || (this
						.getCodiAction() != null
						&& castOther.getCodiAction() != null && this
						.getCodiAction().equals(castOther.getCodiAction())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getId() == null ? 0 : this.getId()
						.hashCode());
		result = 37
				* result
				+ (getCodiAction() == null ? 0 : this.getCodiAction()
						.hashCode());

		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}
