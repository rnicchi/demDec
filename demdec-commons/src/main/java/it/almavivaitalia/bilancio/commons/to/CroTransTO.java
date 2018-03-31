package it.almavivaitalia.bilancio.commons.to;

import it.almavivaitalia.bilancio.commons.utils.CroConstants;

public class CroTransTO extends AbstractCommonTO implements  java.io.Serializable,CroConstants {

	

	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files
    
	private Short id;
	private String descDescr;
	
	public CroTransTO() {

	}

	public CroTransTO(Short id, String descDescr) {
		this.id = id;
		this.descDescr = descDescr;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getDescDescr() {
		return descDescr;
	}

	public void setDescDescr(String descDescr) {
		this.descDescr = descDescr;
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
		String _id=id==null?"0":id.toString();
		String _descDescr=descDescr==null?"":descDescr;
		
		/*OTHER*/
		CroTransTO castOther = (CroTransTO) obj;
		String _idOther=castOther.id==null?"0":castOther.id.toString();
		String _descDescrOther=castOther.descDescr==null?"":castOther.descDescr;
		
		boolean eq= _id.equals(_idOther)&&_descDescr.equals(_descDescrOther);
		
		return eq;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result = 37 * result + (id==null?0:id.hashCode());
		
		return result;
	}
	
}
