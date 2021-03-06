package it.almavivaitalia.bilancio.commons.bo;

// Generated 20-lug-2010 15.50.55 by Hibernate Tools 3.2.4.GA

/**
 * CroValoriBOId generated by hbm2java
 */
public class CroValoriBOId implements  java.io.Serializable {
    private Integer crtCodiId;
	private Short crtTraCodiCodice;
	private Short ccrCodiCodice;
	private Short numeOrdiVisu;

	public CroValoriBOId() {
	}

	public CroValoriBOId(Integer crtCodiId, Short crtTraCodiCodice,
			Short ccrCodiCodice, Short numeOrdiVisu) {
		this.crtCodiId = crtCodiId;
		this.crtTraCodiCodice = crtTraCodiCodice;
		this.ccrCodiCodice = ccrCodiCodice;
		this.numeOrdiVisu = numeOrdiVisu;
	}

	public Integer getCrtCodiId() {
		return this.crtCodiId;
	}

	public void setCrtCodiId(Integer crtCodiId) {
		this.crtCodiId = crtCodiId;
	}

	public Short getCrtTraCodiCodice() {
		return this.crtTraCodiCodice;
	}

	public void setCrtTraCodiCodice(Short crtTraCodiCodice) {
		this.crtTraCodiCodice = crtTraCodiCodice;
	}

	public Short getCcrCodiCodice() {
		return this.ccrCodiCodice;
	}

	public void setCcrCodiCodice(Short ccrCodiCodice) {
		this.ccrCodiCodice = ccrCodiCodice;
	}

	public Short getNumeOrdiVisu() {
		return this.numeOrdiVisu;
	}

	public void setNumeOrdiVisu(Short numeOrdiVisu) {
		this.numeOrdiVisu = numeOrdiVisu;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CroValoriBOId))
			return false;
		CroValoriBOId castOther = (CroValoriBOId) other;

		return ((this.getCrtCodiId() == castOther.getCrtCodiId()) || (this
				.getCrtCodiId() != null
				&& castOther.getCrtCodiId() != null && this.getCrtCodiId()
				.equals(castOther.getCrtCodiId())))
				&& ((this.getCrtTraCodiCodice() == castOther
						.getCrtTraCodiCodice()) || (this.getCrtTraCodiCodice() != null
						&& castOther.getCrtTraCodiCodice() != null && this
						.getCrtTraCodiCodice().equals(
								castOther.getCrtTraCodiCodice())))
				&& ((this.getCcrCodiCodice() == castOther.getCcrCodiCodice()) || (this
						.getCcrCodiCodice() != null
						&& castOther.getCcrCodiCodice() != null && this
						.getCcrCodiCodice()
						.equals(castOther.getCcrCodiCodice())))
				&& ((this.getNumeOrdiVisu() == castOther.getNumeOrdiVisu()) || (this
						.getNumeOrdiVisu() != null
						&& castOther.getNumeOrdiVisu() != null && this
						.getNumeOrdiVisu().equals(castOther.getNumeOrdiVisu())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCrtCodiId() == null ? 0 : this.getCrtCodiId().hashCode());
		result = 37
				* result
				+ (getCrtTraCodiCodice() == null ? 0 : this
						.getCrtTraCodiCodice().hashCode());
		result = 37
				* result
				+ (getCcrCodiCodice() == null ? 0 : this.getCcrCodiCodice()
						.hashCode());
		result = 37
				* result
				+ (getNumeOrdiVisu() == null ? 0 : this.getNumeOrdiVisu()
						.hashCode());
		return result;
	}


    /*METRICHE*/

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
