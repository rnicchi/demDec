package it.almavivaitalia.bilancio.commons.to;

// Generated 25-gen-2010 16.15.19 by Hibernate Tools 3.2.4.GA


import java.util.ArrayList;
import java.util.List;

/**
 * Profilo generated by hbm2java
 */
public class ProfiloTO extends AbstractCommonTO implements java.io.Serializable {

	// aggiunto commento del cavolo per fregare cma 
	private Integer id;
	private String codiProfilo;
	private String descProfilo;
	private List<UtenteTO> utenteList = new ArrayList<UtenteTO>(0);
	private List<ActionTO> actionList = new ArrayList<ActionTO>(0);
	private List<ProfiloActionTO> profiloActionList = new ArrayList<ProfiloActionTO>(0);
	private String[] actionAssociate;
	
	

	public String[] getActionAssociate() {
		return actionAssociate;
	}

	public void setActionAssociate(String[] actionAssociate) {
		this.actionAssociate = actionAssociate;
	}

	public ProfiloTO() {
	}

	public ProfiloTO(String codiProfilo) {
		this.codiProfilo = codiProfilo;
	}

	public ProfiloTO(String codiProfilo, String descProfilo) {
		this.codiProfilo = codiProfilo;
		this.descProfilo = descProfilo;
	}
	
	public ProfiloTO(String codiProfilo, String descProfilo, String [] actionAssociate) {
		this.codiProfilo = codiProfilo;
		this.descProfilo = descProfilo;
		this.actionAssociate = actionAssociate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodiProfilo() {
		return this.codiProfilo;
	}

	public void setCodiProfilo(String codiProfilo) {
		this.codiProfilo = codiProfilo;
	}


	public List<UtenteTO> getUtenteList() {
		return utenteList;
	}

	public void setUtenteList(List<UtenteTO> utenteList) {
		this.utenteList = utenteList;
	}

	public List<ActionTO> getActionList() {
		return actionList;
	}

	public void setActionList(List<ActionTO> actionList) {
		this.actionList = actionList;
	}
	
	public String getDescProfilo() {
		return descProfilo;
	}

	public void setDescProfilo(String descProfilo) {
		this.descProfilo = descProfilo;
	}
	
	

	public List<ProfiloActionTO> getProfiloActionList() {
		return profiloActionList;
	}

	public void setProfiloActionList(List<ProfiloActionTO> profiloActionList) {
		this.profiloActionList = profiloActionList;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(
				Integer.toHexString(hashCode())).append(" [");
		buffer.append("sequIdProfilo").append("='").append(getId())
				.append("' ");
		buffer.append("codiProfilo").append("='").append(getCodiProfilo())
				.append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProfiloTO))
			return false;
		ProfiloTO castOther = (ProfiloTO) other;

		return  ( (this.getId()!=null) && (castOther.getId()!=null) && (this.getId() == castOther.getId() ) )
				|| ( (this.getCodiProfilo()!=null) && (castOther.getCodiProfilo()!=null) && (this.getCodiProfilo().equals(castOther.getCodiProfilo()) ) );
		
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getId() == null ? 0 : this.getId()
						.hashCode());
		result = 37
				* result
				+ (getCodiProfilo() == null ? 0 : this.getCodiProfilo()
						.hashCode());

		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}
