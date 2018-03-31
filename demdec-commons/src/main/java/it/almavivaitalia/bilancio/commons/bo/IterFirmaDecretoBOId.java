package it.almavivaitalia.bilancio.commons.bo;

// Generated 22-lug-2015 15.41.08 by Hibernate Tools 3.4.0.CR1

/**
 * IterFirmaDecretoBOId generated by hbm2java
 */
public class IterFirmaDecretoBOId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7022560922416357405L;
	private Long fkNumeIdFascicolo;
	private Integer numeOrdineFirma;

	public IterFirmaDecretoBOId() {
	}

	public IterFirmaDecretoBOId(Long fkNumeIdFascicolo, Integer numeOrdineFirma) {
		this.fkNumeIdFascicolo = fkNumeIdFascicolo;
		this.numeOrdineFirma = numeOrdineFirma;
	}

	public Long getFkNumeIdFascicolo() {
		return this.fkNumeIdFascicolo;
	}

	public void setFkNumeIdFascicolo(Long fkNumeIdFascicolo) {
		this.fkNumeIdFascicolo = fkNumeIdFascicolo;
	}

	public Integer getNumeOrdineFirma() {
		return this.numeOrdineFirma;
	}

	public void setNumeOrdineFirma(Integer numeOrdineFirma) {
		this.numeOrdineFirma = numeOrdineFirma;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IterFirmaDecretoBOId))
			return false;
		IterFirmaDecretoBOId castOther = (IterFirmaDecretoBOId) other;

		return ((this.getFkNumeIdFascicolo() == castOther
				.getFkNumeIdFascicolo()) || (this.getFkNumeIdFascicolo() != null
				&& castOther.getFkNumeIdFascicolo() != null && this
				.getFkNumeIdFascicolo()
				.equals(castOther.getFkNumeIdFascicolo())))
				&& ((this.getNumeOrdineFirma() == castOther
						.getNumeOrdineFirma()) || (this.getNumeOrdineFirma() != null
						&& castOther.getNumeOrdineFirma() != null && this
						.getNumeOrdineFirma().equals(
								castOther.getNumeOrdineFirma())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getFkNumeIdFascicolo() == null ? 0 : this
						.getFkNumeIdFascicolo().hashCode());
		result = 37
				* result
				+ (getNumeOrdineFirma() == null ? 0 : this.getNumeOrdineFirma()
						.hashCode());
		return result;
	}

}
