package it.almavivaitalia.bilancio.commons.to;


// Generated 5-giu-2015 12.17.04 by Hibernate Tools 3.4.0.CR1

/**
 * UtenteProfiloBO generated by hbm2java
 */
public class UtenteProfiloTO extends AbstractCommonTO implements java.io.Serializable {

	private UtenteProfiloTOId id;
	private AnagUfficiTO anagUffici;
	private ProfiloTO profilo;
	private AnagAmminDemTO anagAmminDem;
	private UtenteTO utente;
	private Integer flagFirma01;
	private Integer flagModifica01;
	private Integer flagDefault01=0;
	private Integer idCheckBox;
	private Integer FlagDelega01;
	private String persCognomeDelegante;
	private String perNomeDelegante;

	
	public Integer getIdCheckBox() {
		return idCheckBox;
	}

	public void setIdCheckBox(Integer idCheckBox) {
		this.idCheckBox = idCheckBox;
	}

	public UtenteProfiloTO() {
	}

	public UtenteProfiloTO(UtenteProfiloTOId id, ProfiloTO profilo,
			UtenteTO utente, Integer flagFirma01, Integer flagModifica01) {
		this.id = id;
		this.profilo = profilo;
		this.utente = utente;
		this.flagFirma01 = flagFirma01;
		this.flagModifica01 = flagModifica01;
	}

	public UtenteProfiloTO(UtenteProfiloTOId id, AnagUfficiTO anagUffici,
			ProfiloTO profilo, AnagAmminDemTO anagAmminDem, UtenteTO utente,
			Integer flagFirma01, Integer flagModifica01) {
		this.id = id;
		this.anagUffici = anagUffici;
		this.profilo = profilo;
		this.anagAmminDem = anagAmminDem;
		this.utente = utente;
		this.flagFirma01 = flagFirma01;
		this.flagModifica01 = flagModifica01;
	}

	public UtenteProfiloTOId getId() {
		return this.id;
	}

	public void setId(UtenteProfiloTOId id) {
		this.id = id;
	}

	public AnagUfficiTO getAnagUffici() {
		return this.anagUffici;
	}

	public void setAnagUffici(AnagUfficiTO anagUffici) {
		this.anagUffici = anagUffici;
	}

	public ProfiloTO getProfilo() {
		return this.profilo;
	}

	public void setProfilo(ProfiloTO profilo) {
		this.profilo = profilo;
	}

	public AnagAmminDemTO getAnagAmminDem() {
		return this.anagAmminDem;
	}

	public void setAnagAmminDem(AnagAmminDemTO anagAmminDem) {
		this.anagAmminDem = anagAmminDem;
	}

	public UtenteTO getUtente() {
		return this.utente;
	}

	public void setUtente(UtenteTO utente) {
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

	public Integer getFlagDefault01() {
		return flagDefault01;
	}

	public void setFlagDefault01(Integer flagDefault01) {
		this.flagDefault01 = flagDefault01;
	}
	
	public Integer getFlagDelega01() {
		return FlagDelega01;
	}

	public void setFlagDelega01(Integer flagDelega01) {
		FlagDelega01 = flagDelega01;
	}

	public String getDescProfilo(){
		String appendice = "" +(this.anagAmminDem!=null?(" - "+this.anagAmminDem.getDescAmmR()):"") + (this.anagUffici!=null?(" - " + this.anagUffici.getDescUfficio()):"");
		return this.profilo.getDescProfilo() + appendice;
	}
	
	public String getPersCognomeDelegante() {
		return persCognomeDelegante;
	}

	public void setPersCognomeDelegante(String persCognomeDelegante) {
		this.persCognomeDelegante = persCognomeDelegante;
	}

	public String getPerNomeDelegante() {
		return perNomeDelegante;
	}

	public void setPerNomeDelegante(String perNomeDelegante) {
		this.perNomeDelegante = perNomeDelegante;
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
		buffer.append("flagDelega01").append("='")
				.append(getFlagDelega01()).append("' ");
		buffer.append("flagDefault01").append("='")
				.append(getFlagDefault01()).append("' ");
		buffer.append("persCognomeDelegante").append("='")
				.append(getPersCognomeDelegante()).append("' ");
		buffer.append("perNomeDelegante").append("='")
				.append(getPerNomeDelegante()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UtenteProfiloTO))
			return false;
		UtenteProfiloTO castOther = (UtenteProfiloTO) other;

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
								castOther.getFlagModifica01())))
				&& ((this.getFlagDefault01() == castOther.getFlagDefault01()) || (this
						.getFlagDefault01() != null
						&& castOther.getFlagDefault01() != null && this
						.getFlagDefault01().equals(
								castOther.getFlagDefault01())))
				&& ((this.getPerNomeDelegante() == castOther.getPerNomeDelegante()) || (this
						.getPerNomeDelegante() != null
						&& castOther.getPerNomeDelegante() != null && this
						.getPerNomeDelegante().equals(
								castOther.getPerNomeDelegante())))
				&& ((this.getPersCognomeDelegante() == castOther.getPersCognomeDelegante()) || (this
						.getPersCognomeDelegante() != null
						&& castOther.getPersCognomeDelegante() != null && this
						.getPersCognomeDelegante().equals(
								castOther.getPersCognomeDelegante())))
				&& ((this.getFlagDelega01() == castOther.getFlagDelega01()) || (this
						.getFlagDelega01() != null
						&& castOther.getFlagDelega01() != null && this
						.getFlagDelega01().equals(
								castOther.getFlagDelega01())));
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
		result = 37
				* result
				+ (getFlagDefault01() == null ? 0 : this.getFlagDefault01()
						.hashCode());
		result = 37
				* result
				+ (getFlagDelega01() == null ? 0 : this.getFlagDelega01()
						.hashCode());
		result = 37
				* result
				+ (getPerNomeDelegante() == null ? 0 : this.getPerNomeDelegante()
						.hashCode());
		result = 37
				* result
				+ (getPersCognomeDelegante() == null ? 0 : this.getPersCognomeDelegante()
						.hashCode());
		return result;
	}

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}
