package it.mef.bilancio.demdec.to;


// Generated 20-lug-2010 15.50.55 by Hibernate Tools 3.2.4.GA


public class CampoFirmaTO extends AbstractDemTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	

	public CampoFirmaTO() {
		
	}
	public CampoFirmaTO(String dicitura, String tagFirma, String tipoFirma, Integer numeOrdineIter) {
		setDicitura(dicitura);
		setTagFirma(tagFirma);
		setTipoFirma(tipoFirma);
		setNumeOrdineIter(numeOrdineIter);
		//metriche 
		//this.dicitura = dicitura;
		//this.tagFirma = tagFirma;
		//this.tipoFirma = tipoFirma;
	}


	private String dicitura;
	private String tagFirma;
	private String tipoFirma;
	private Integer numeOrdineIter;
	
	
	public String getDicitura() {
		return dicitura;
	}
	public void setDicitura(String dicitura) {
		this.dicitura = dicitura;
	}
	public String getTagFirma() {
		return tagFirma;
	}
	public void setTagFirma(String tagFirma) {
		this.tagFirma = tagFirma;
	}
	public String getTipoFirma() {
		return tipoFirma;
	}
	public void setTipoFirma(String tipoFirma) {
		this.tipoFirma = tipoFirma;
	}
	
	public void setNumeOrdineIter(Integer numeOrdineIter) {
		this.numeOrdineIter = numeOrdineIter;
	}
	public Integer getNumeOrdineIter() {
		return numeOrdineIter;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dicitura == null) ? 0 : dicitura.hashCode());
		result = prime * result
				+ ((tagFirma == null) ? 0 : tagFirma.hashCode());
		result = prime * result
				+ ((tipoFirma == null) ? 0 : tipoFirma.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampoFirmaTO other = (CampoFirmaTO) obj;
		if (dicitura == null) {
			if (other.dicitura != null)
				return false;
		} else if (!dicitura.equals(other.dicitura))
			return false;
		if (tagFirma == null) {
			if (other.tagFirma != null)
				return false;
		} else if (!tagFirma.equals(other.tagFirma))
			return false;
		if (tipoFirma == null) {
			if (other.tipoFirma != null)
				return false;
		} else if (!tipoFirma.equals(other.tipoFirma))
			return false;
		return true;
	}
	
	
}
