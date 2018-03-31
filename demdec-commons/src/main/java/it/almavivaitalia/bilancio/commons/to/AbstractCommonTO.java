package it.almavivaitalia.bilancio.commons.to;


import java.util.Collection;
import java.util.Date;

public abstract class AbstractCommonTO {
	private Date rowCreatedDttm;
	private String rowCreatedUser;
	private Date rowUpdatedDttm;
	private String rowUpdatedUser;
	private String rowCreatedForm;
	private String rowUpdatedForm;
	private int numeVersion;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeVersion;
		result = prime * result
				+ ((rowCreatedDttm == null) ? 0 : rowCreatedDttm.hashCode());
		result = prime * result
				+ ((rowCreatedForm == null) ? 0 : rowCreatedForm.hashCode());
		result = prime * result
				+ ((rowCreatedUser == null) ? 0 : rowCreatedUser.hashCode());
		result = prime * result
				+ ((rowUpdatedDttm == null) ? 0 : rowUpdatedDttm.hashCode());
		result = prime * result
				+ ((rowUpdatedForm == null) ? 0 : rowUpdatedForm.hashCode());
		result = prime * result
				+ ((rowUpdatedUser == null) ? 0 : rowUpdatedUser.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractCommonTO other = (AbstractCommonTO) obj;
		if (numeVersion != other.numeVersion)
			return false;
		if (rowCreatedDttm == null) {
			if (other.rowCreatedDttm != null)
				return false;
		} else if (!rowCreatedDttm.equals(other.rowCreatedDttm))
			return false;
		if (rowCreatedForm == null) {
			if (other.rowCreatedForm != null)
				return false;
		} else if (!rowCreatedForm.equals(other.rowCreatedForm))
			return false;
		if (rowCreatedUser == null) {
			if (other.rowCreatedUser != null)
				return false;
		} else if (!rowCreatedUser.equals(other.rowCreatedUser))
			return false;
		if (rowUpdatedDttm == null) {
			if (other.rowUpdatedDttm != null)
				return false;
		} else if (!rowUpdatedDttm.equals(other.rowUpdatedDttm))
			return false;
		if (rowUpdatedForm == null) {
			if (other.rowUpdatedForm != null)
				return false;
		} else if (!rowUpdatedForm.equals(other.rowUpdatedForm))
			return false;
		if (rowUpdatedUser == null) {
			if (other.rowUpdatedUser != null)
				return false;
		} else if (!rowUpdatedUser.equals(other.rowUpdatedUser))
			return false;
		return true;
	}

	public Date getRowCreatedDttm() {
		return rowCreatedDttm;
	}
	public void setRowCreatedDttm(Date rowCreatedDttm) {
		this.rowCreatedDttm = rowCreatedDttm;
	}
	public String getRowCreatedUser() {
		return rowCreatedUser;
	}
	public void setRowCreatedUser(String rowCreatedUser) {
		this.rowCreatedUser = rowCreatedUser;
	}
	public Date getRowUpdatedDttm() {
		return rowUpdatedDttm;
	}
	public void setRowUpdatedDttm(Date rowUpdatedDttm) {
		this.rowUpdatedDttm = rowUpdatedDttm;
	}
	public String getRowUpdatedUser() {
		return rowUpdatedUser;
	}
	public void setRowUpdatedUser(String rowUpdatedUser) {
		this.rowUpdatedUser = rowUpdatedUser;
	}
	public String getRowCreatedForm() {
		return rowCreatedForm;
	}
	public void setRowCreatedForm(String rowCreatedForm) {
		this.rowCreatedForm = rowCreatedForm;
	}
	public String getRowUpdatedForm() {
		return rowUpdatedForm;
	}
	public void setRowUpdatedForm(String rowUpdatedForm) {
		this.rowUpdatedForm = rowUpdatedForm;
	}
	public int getNumeVersion() {
		return numeVersion;
	}
	public void setNumeVersion(int numeVersion) {
		this.numeVersion = numeVersion;
	}
	
	
	public String getTODescription(){
		return "";
	}

	protected static boolean isEmpty(Object o){
		if (o==null){
			return true;
		}else if (o instanceof Collection<?>){
			return ((Collection<?>)o).isEmpty();
		}else {
			return o.toString().trim().equals("");
		}
	}
	
}
