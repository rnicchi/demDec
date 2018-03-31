package it.almavivaitalia.bsn.sh.tagparser;


public class Type {


	
	private String markerStart;
	private String markerStop;
	
	 /* LOCM */
    @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM4 = 80L;
    @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM2 = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM3 = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM1 = 80L;
	 @SuppressWarnings("unused")
		private static final long serialVersionUIDLOCM5 = 80L;
    /* end LOCM */
	
	
	public Type(String markerStart, String markerStop){
		this.markerStart=markerStart;
		this.markerStop=markerStop;
	}


	public String getMarkerStart() {
		return markerStart;
	}


	public String getMarkerStop() {
		return markerStop;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null){
			return false;
		}else if (!(obj instanceof Type)){
			return false;
		}else {
			Type type = (Type)obj;
			return this.markerStart.equalsIgnoreCase(type.getMarkerStart()) && this.markerStop.equalsIgnoreCase(type.getMarkerStop());
		}
	}
	
	@Override
	public String toString() {
		return this.getMarkerStart();
	}
}
