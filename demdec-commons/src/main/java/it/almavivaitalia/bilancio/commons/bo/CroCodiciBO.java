package it.almavivaitalia.bilancio.commons.bo;

// Generated 20-lug-2010 15.50.55 by Hibernate Tools 3.2.4.GA

import java.util.ArrayList;
import java.util.List;

/**
 * CroCodiciBO generated by hbm2java
 */
public class CroCodiciBO extends AbstractCommonBO implements  java.io.Serializable {

	private Short id;
	private String descDescr;
	private List<CroValoriBO> croValoriList = new ArrayList<CroValoriBO>(0);

	public CroCodiciBO() { //BEGIN
	}

	public CroCodiciBO(String descDescr) { //BEGIN
		this.descDescr = descDescr;
	}

	public Short getId() { //BEGIN
		return this.id;
	}

	public void setId(Short id) { //BEGIN
		this.id = id;
	}

	public String getDescDescr() { //BEGIN
		return this.descDescr;
	}

	public void setDescDescr(String descDescr) { //BEGIN
		this.descDescr = descDescr;
	}

	public List<CroValoriBO> getCroValoriList() { //BEGIN
		return this.croValoriList;
	}

	public void setCroValoriList(List<CroValoriBO> croValoriList) { //BEGIN
		this.croValoriList = croValoriList;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() { //BEGIN
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(
				Integer.toHexString(hashCode())).append(" [");
		buffer.append("id").append("='").append(getId()).append("' ");
		buffer.append("descDescr").append("='").append(getDescDescr()).append(
				"' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) { //BEGIN
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CroCodiciBO))
			return false;
		CroCodiciBO castOther = (CroCodiciBO) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getDescDescr() == castOther.getDescDescr()) || (this
						.getDescDescr() != null
						&& castOther.getDescDescr() != null && this
						.getDescDescr().equals(castOther.getDescDescr())));
	}

	public int hashCode() { //BEGIN
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getDescDescr() == null ? 0 : this.getDescDescr().hashCode());

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
