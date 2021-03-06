package it.mef.bilancio.demdec.to;

// Generated 15-lug-2015 14.08.10 by Hibernate Tools 3.4.0.CR1

/**
 * DocumentiBOId generated by hbm2java
 */
public class DocumentiTOId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 680072377418160278L;
	
	private Long fkNumeIdFascicolo;
	private Long numeIdDocumento;

	public DocumentiTOId() {
	}

	public DocumentiTOId(Long fkNumeIdFascicolo, Long numeIdDocumento) {
		this.fkNumeIdFascicolo = fkNumeIdFascicolo;
		this.numeIdDocumento = numeIdDocumento;
	}

	public Long getFkNumeIdFascicolo() {
		return this.fkNumeIdFascicolo;
	}

	public void setFkNumeIdFascicolo(Long fkNumeIdFascicolo) {
		this.fkNumeIdFascicolo = fkNumeIdFascicolo;
	}

	public Long getNumeIdDocumento() {
		return this.numeIdDocumento;
	}

	public void setNumeIdDocumento(Long numeIdDocumento) {
		this.numeIdDocumento = numeIdDocumento;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DocumentiTOId))
			return false;
		DocumentiTOId castOther = (DocumentiTOId) other;

		return ((this.getFkNumeIdFascicolo() == castOther
				.getFkNumeIdFascicolo()) || (this.getFkNumeIdFascicolo() != null
				&& castOther.getFkNumeIdFascicolo() != null && this
				.getFkNumeIdFascicolo()
				.equals(castOther.getFkNumeIdFascicolo())))
				&& ((this.getNumeIdDocumento() == castOther
						.getNumeIdDocumento()) || (this.getNumeIdDocumento() != null
						&& castOther.getNumeIdDocumento() != null && this
						.getNumeIdDocumento().equals(
								castOther.getNumeIdDocumento())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getFkNumeIdFascicolo() == null ? 0 : this
						.getFkNumeIdFascicolo().hashCode());
		result = 37
				* result
				+ (getNumeIdDocumento() == null ? 0 : this.getNumeIdDocumento()
						.hashCode());
		return result;
	}

}
