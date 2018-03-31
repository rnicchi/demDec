package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.bo.IterFirmaDecretoBOId;

public class IterFirmaDecretoTOId extends AbstractDemTO implements java.io.Serializable {

	
	private static final long serialVersionUID = 2164233989199362001L;
	
	private Long fkNumeIdFascicolo;
	private Integer numeOrdineFirma;

	public IterFirmaDecretoTOId() {
	}

	public IterFirmaDecretoTOId(Long fkNumeIdFascicolo, Integer numeOrdineFirma) {
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
