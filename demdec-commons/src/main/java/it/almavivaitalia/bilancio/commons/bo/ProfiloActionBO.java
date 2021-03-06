package it.almavivaitalia.bilancio.commons.bo;


// Generated 5-giu-2015 12.17.04 by Hibernate Tools 3.4.0.CR1

/**
 * UtenteProfiloBO generated by hbm2java
 */
public class ProfiloActionBO extends AbstractCommonBO implements java.io.Serializable {

	private ProfiloActionBOId id;
	private AnagUfficiBO anagUffici;
	private ProfiloBO profilo;
	private AnagAmminDemBO anagAmminDem;
	private UtenteBO utente;
	private ActionBO action;
	private Integer flagFirma01;
	private Integer flagModifica01;

	public ProfiloActionBO() {
	}

	public ProfiloActionBO(ProfiloActionBOId id, ProfiloBO profilo,
			ActionBO action, Integer flagFirma01, Integer flagModifica01) {
		this.id = id;
		this.profilo = profilo;
		this.action = action;
		this.flagFirma01 = flagFirma01;
		this.flagModifica01 = flagModifica01;
	}
	
	public ProfiloActionBO(ProfiloActionBOId id, ProfiloBO profilo,
			UtenteBO utente,ActionBO action, Integer flagFirma01, Integer flagModifica01) {
		this.id = id;
		this.profilo = profilo;
		this.utente = utente;
		this.action = action;
		this.flagFirma01 = flagFirma01;
		this.flagModifica01 = flagModifica01;
	}

	public ProfiloActionBO(ProfiloActionBOId id, AnagUfficiBO anagUffici,
			ProfiloBO profilo,ActionBO action, AnagAmminDemBO anagAmminDem, UtenteBO utente,
			Integer flagFirma01, Integer flagModifica01) {
		this.id = id;
		this.anagUffici = anagUffici;
		this.profilo = profilo;
		this.action = action;
		this.anagAmminDem = anagAmminDem;
		this.utente = utente;
		this.flagFirma01 = flagFirma01;
		this.flagModifica01 = flagModifica01;
	}

	public ProfiloActionBOId getId() {
		return this.id;
	}

	public void setId(ProfiloActionBOId id) {
		this.id = id;
	}

	public AnagUfficiBO getAnagUffici() {
		return this.anagUffici;
	}

	public void setAnagUffici(AnagUfficiBO anagUffici) {
		this.anagUffici = anagUffici;
	}

	public ProfiloBO getProfilo() {
		return this.profilo;
	}

	public void setProfilo(ProfiloBO profilo) {
		this.profilo = profilo;
	}

	public AnagAmminDemBO getAnagAmminDem() {
		return this.anagAmminDem;
	}

	public void setAnagAmminDem(AnagAmminDemBO anagAmminDem) {
		this.anagAmminDem = anagAmminDem;
	}

	public UtenteBO getUtente() {
		return this.utente;
	}

	public void setUtente(UtenteBO utente) {
		this.utente = utente;
	}

	public Integer getFlagFirma01() {
		return this.flagFirma01;
	}

	public void setFlagFirma01(Integer flagFirma01) {
		this.flagFirma01 = flagFirma01;
	}

	public Integer getFlagModifica01() {
		return this.flagModifica01;
	}

	public void setFlagModifica01(Integer flagModifica01) {
		this.flagModifica01 = flagModifica01;
	}
	
	

	public ActionBO getAction() {
		return action;
	}

	public void setAction(ActionBO action) {
		this.action = action;
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
		buffer.append("profilo").append("='").append(getProfilo()).append("' ");
		buffer.append("anagAmminDem").append("='").append(getAnagAmminDem())
				.append("' ");
		buffer.append("utente").append("='").append(getUtente()).append("' ");
		buffer.append("flagFirma01").append("='").append(getFlagFirma01())
				.append("' ");
		buffer.append("flagModifica01").append("='")
				.append(getFlagModifica01()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UtenteProfiloBO))
			return false;
		ProfiloActionBO castOther = (ProfiloActionBO) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getAnagUffici() == castOther.getAnagUffici()) || (this
						.getAnagUffici() != null
						&& castOther.getAnagUffici() != null && this
						.getAnagUffici().equals(castOther.getAnagUffici())))
				&& ((this.getProfilo() == castOther.getProfilo()) || (this
						.getProfilo() != null && castOther.getProfilo() != null && this
						.getProfilo().equals(castOther.getProfilo())))
				&& ((this.getAnagAmminDem() == castOther.getAnagAmminDem()) || (this
						.getAnagAmminDem() != null
						&& castOther.getAnagAmminDem() != null && this
						.getAnagAmminDem().equals(castOther.getAnagAmminDem())))
				&& ((this.getUtente() == castOther.getUtente()) || (this
						.getUtente() != null && castOther.getUtente() != null && this
						.getUtente().equals(castOther.getUtente())))
				&& ((this.getFlagFirma01() == castOther.getFlagFirma01()) || (this
						.getFlagFirma01() != null
						&& castOther.getFlagFirma01() != null && this
						.getFlagFirma01().equals(castOther.getFlagFirma01())))
				&& ((this.getFlagModifica01() == castOther.getFlagModifica01()) || (this
						.getFlagModifica01() != null
						&& castOther.getFlagModifica01() != null && this
						.getFlagModifica01().equals(
								castOther.getFlagModifica01())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getAnagUffici() == null ? 0 : this.getAnagUffici()
						.hashCode());
		result = 37 * result
				+ (getProfilo() == null ? 0 : this.getProfilo().hashCode());
		result = 37
				* result
				+ (getAnagAmminDem() == null ? 0 : this.getAnagAmminDem()
						.hashCode());
		result = 37 * result
				+ (getUtente() == null ? 0 : this.getUtente().hashCode());
		result = 37
				* result
				+ (getFlagFirma01() == null ? 0 : this.getFlagFirma01()
						.hashCode());
		result = 37
				* result
				+ (getFlagModifica01() == null ? 0 : this.getFlagModifica01()
						.hashCode());
		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}
