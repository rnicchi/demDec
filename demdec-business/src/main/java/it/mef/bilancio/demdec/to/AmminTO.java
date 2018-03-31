package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;

// Generated 20-lug-2010 15.50.55 by Hibernate Tools 3.2.4.GA



/**
 * AmminTO generated by hbm2java
 */
public class AmminTO extends AbstractCommonTO implements java.io.Serializable { //INIZIO METODO


	private String descAmm;
	private String numeStp;
	private String numeApp;
	
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;



	public String getDescAmm() { //INIZIO METODO
		return descAmm;
	}



	public void setDescAmm(String descAmm) { //INIZIO METODO
		this.descAmm = descAmm;
	}



	public String getNumeStp() { //INIZIO METODO
		return numeStp;
	}



	public void setNumeStp(String numeStp) { //INIZIO METODO
		this.numeStp = numeStp;
	}



	public String getNumeApp() { //INIZIO METODO
		return numeApp;
	}



	public void setNumeApp(String numeApp) { //INIZIO METODO
		this.numeApp = numeApp;
	}



	public AmminTO() { //INIZIO METODO
	}



	public AmminTO(String descAmm, String numeStp, String numeApp) 
	{ //INIZIO METODO
		this.descAmm = descAmm;
		this.numeStp = numeStp;
		this.numeApp = numeApp;
	}


	/**
	 * toString
	 * @return String
	 */
	public String toString() { //INIZIO METODO
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(
				Integer.toHexString(hashCode())).append(" [");
		buffer.append("descAmm").append("='").append(getDescAmm()).append("' ");
		buffer.append("numeStp").append("='").append(getNumeStp()).append("' ");
		buffer.append("numeAppp").append("='").append(getNumeApp()).append("' ");

		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) { //INIZIO METODO
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AmminTO))
			return false;
		AmminTO castOther = (AmminTO) other;

		return ((this.getDescAmm() == castOther.getDescAmm()) || (this.getDescAmm() != null
				&& castOther.getDescAmm() != null && this.getDescAmm().equals(
				castOther.getDescAmm())))

				&& ((this.getNumeStp() == castOther.getNumeStp()) || (this
						.getNumeStp() != null
						&& castOther.getNumeStp() != null && this
						.getNumeStp()
						.equals(castOther.getNumeStp())))
				&& ((this.getNumeApp() == castOther.getNumeApp()) || (this
						.getNumeApp() != null
						&& castOther.getNumeApp() != null && this.getNumeApp()
						.equals(castOther.getNumeApp())));
	}

	public int hashCode() { //INIZIO METODO
		int result = 17;

		result = 37 * result + (getDescAmm() == null ? 0 : this.getDescAmm().hashCode());

		result = 37
				* result
				+ (getNumeStp() == null ? 0 : this.getNumeStp()
						.hashCode());
		result = 37 * result
				+ (getNumeApp() == null ? 0 : this.getNumeApp().hashCode());

		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}