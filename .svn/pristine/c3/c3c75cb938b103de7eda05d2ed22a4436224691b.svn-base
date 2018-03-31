package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;


public abstract class AbstractDemTO extends AbstractCommonTO {//INIZIO METODO
	

	
	private String warningCode;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((warningCode == null) ? 0 : warningCode.hashCode());
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
		AbstractDemTO other = (AbstractDemTO) obj;
		if (warningCode == null) {
			if (other.warningCode != null)
				return false;
		} else if (!warningCode.equals(other.warningCode))
			return false;
		return true;
	}
	public String getWarningCode() {//INIZIO METODO
		return warningCode;
	}
	public void setWarningCode(String warningCode) {//INIZIO METODO
		this.warningCode = warningCode;
	}


}
