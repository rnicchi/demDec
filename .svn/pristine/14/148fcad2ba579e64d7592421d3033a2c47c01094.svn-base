package it.almavivaitalia.web.sh.utils;

public class PropertyKey {

	private String value;
	private String descValue;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	public String getDescValue() {
		return descValue;
	}
	public void setDescValue(String descValue) {
		this.descValue = descValue;
	}

	private Boolean key=new Boolean(false);
	
	
	public Boolean isKey() {
		return (key==null)?new Boolean(false):key;
	}
	public void setKey(Boolean key) {
		this.key = key;
	}
	public PropertyKey(String value){
		this.value=value;
	}
	public PropertyKey(){
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj==null){
			return false;
		}else if (obj instanceof String){
			return value.equals(obj);
		}else if (obj instanceof PropertyKey){
			return value.equals(((PropertyKey)obj).getValue());
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
