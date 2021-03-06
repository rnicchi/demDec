package it.almavivaitalia.bilancio.commons.bo;

// Generated 5-giu-2015 12.17.04 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * UtenteProfiloBOId generated by hbm2java
 */
public class ProfiloActionBOId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5132645780721292842L;
	private BigDecimal sequIdUtente;
	private BigDecimal sequIdProfilo;
	private BigDecimal sequIdAction;
	private BigDecimal progressivo;

	public ProfiloActionBOId() {
	}

	public ProfiloActionBOId(BigDecimal sequIdUtente, BigDecimal sequIdProfilo,BigDecimal sequIdAction,
			BigDecimal progressivo) {
		this.sequIdUtente = sequIdUtente;
		this.sequIdProfilo = sequIdProfilo;
		this.progressivo = progressivo;
		this.sequIdAction = sequIdAction;
	}
	
	public ProfiloActionBOId(BigDecimal sequIdProfilo,BigDecimal sequIdAction,
			BigDecimal progressivo) {
		this.sequIdProfilo = sequIdProfilo;
		this.progressivo = progressivo;
		this.sequIdAction = sequIdAction;
	}

	
	
	public BigDecimal getSequIdAction() {
		return sequIdAction;
	}

	public void setSequIdAction(BigDecimal sequIdAction) {
		this.sequIdAction = sequIdAction;
	}

	public BigDecimal getSequIdUtente() {
		return this.sequIdUtente;
	}

	public void setSequIdUtente(BigDecimal sequIdUtente) {
		this.sequIdUtente = sequIdUtente;
	}

	public BigDecimal getSequIdProfilo() {
		return this.sequIdProfilo;
	}

	public void setSequIdProfilo(BigDecimal sequIdProfilo) {
		this.sequIdProfilo = sequIdProfilo;
	}

	public BigDecimal getProgressivo() {
		return this.progressivo;
	}

	public void setProgressivo(BigDecimal progressivo) {
		this.progressivo = progressivo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProfiloActionBOId))
			return false;
		ProfiloActionBOId castOther = (ProfiloActionBOId) other;

		return ((this.getSequIdUtente() == castOther.getSequIdUtente()) || (this
				.getSequIdUtente() != null
				&& castOther.getSequIdUtente() != null && this
				.getSequIdUtente().equals(castOther.getSequIdUtente())))
				&& ((this.getSequIdProfilo() == castOther.getSequIdProfilo()) || (this
						.getSequIdProfilo() != null
						&& castOther.getSequIdProfilo() != null && this
						.getSequIdProfilo()
						.equals(castOther.getSequIdProfilo())))
				&& ((this.getProgressivo() == castOther.getProgressivo()) || (this
						.getProgressivo() != null
						&& castOther.getProgressivo() != null && this
						.getProgressivo().equals(castOther.getProgressivo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSequIdUtente() == null ? 0 : this.getSequIdUtente()
						.hashCode());
		result = 37
				* result
				+ (getSequIdProfilo() == null ? 0 : this.getSequIdProfilo()
						.hashCode());
		result = 37
				* result
				+ (getProgressivo() == null ? 0 : this.getProgressivo()
						.hashCode());
		return result;
	}

}
