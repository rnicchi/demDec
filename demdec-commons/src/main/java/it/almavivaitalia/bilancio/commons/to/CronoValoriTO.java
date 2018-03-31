package it.almavivaitalia.bilancio.commons.to;


public class CronoValoriTO extends AbstractCommonTO implements
		java.io.Serializable {// INIZIO METODO

	private static final long serialVersionUID = 1L;
	private Integer codice;
	private String oldValue;
	private String newValue;
	private Short numeOrdiVisu;

	public CronoValoriTO() {

	}

	public CronoValoriTO(Integer codice, Short numeOrdiVisu) {
		this.codice = codice;
		this.numeOrdiVisu = numeOrdiVisu;
	}

	public Short getNumeOrdiVisu() {// INIZIO METODO
		return numeOrdiVisu;
	}

	public void setNumeOrdiVisu(Short numeOrdiVisu) {// INIZIO METODO
		this.numeOrdiVisu = numeOrdiVisu;
	}

	public void setCodice(Integer codice) {// INIZIO METODO
		this.codice = codice;
	}

	public int getCodice() {// INIZIO METODO
		return codice;
	}

	public void setCodice(int codice) {// INIZIO METODO
		this.codice = codice;
	}

	public String getOldValue() {// INIZIO METODO
		return oldValue;
	}

	public void setOldValue(String oldValue) {// INIZIO METODO
		this.oldValue = oldValue;
	}

	public String getNewValue() {// INIZIO METODO
		return newValue;
	}

	public void setNewValue(String newValue) {// INIZIO METODO
		this.newValue = newValue;
	}
	
	@Override
	public boolean equals(Object obj){
		if ((this == obj)){
			return true;
		}
		if ((obj == null)){
			return false;
		}
		if (!(obj instanceof CronoValoriTO)){
			return false;		
		}
		
		/*THIS*/
		String _codice=codice==null?"0":codice.toString();
		String _oldValue=oldValue==null?"":oldValue;
		String _newValue=newValue==null?"":newValue;
		
		/*OTHER*/
		CronoValoriTO castOther = (CronoValoriTO) obj;
		String _codiceOther=castOther.codice==null?"0":castOther.codice.toString();
		String _oldValueOther=castOther.oldValue==null?"":castOther.oldValue;
		String _newValueOther=castOther.newValue==null?"":castOther.newValue;
		
		boolean eq= _codice.equals(_codiceOther)&&_oldValue.equals(_oldValueOther)&&_newValue.equals(_newValueOther);
		
		return eq;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result = 37 * result + (codice==null?0:codice.hashCode());
		
		return result;
	}
}
