package it.almavivaitalia.bilancio.commons.bo;
// Generated 27-ago-2015 11.40.14 by Hibernate Tools 3.4.0.CR1



/**
 * AnagAmminUfficiBOId generated by hbm2java
 */
public class AnagAmminUfficiBOId  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Short fkAnnoEse;
     private Integer fkNumeStp;
     private Integer fkNumeApp;
     private String fkCodiUfficio;

    public AnagAmminUfficiBOId() {
    }

    public AnagAmminUfficiBOId(Short fkAnnoEse, Integer fkNumeStp, Integer fkNumeApp, String fkCodiUfficio) {
       this.fkAnnoEse = fkAnnoEse;
       this.fkNumeStp = fkNumeStp;
       this.fkNumeApp = fkNumeApp;
       this.fkCodiUfficio = fkCodiUfficio;
    }
   
    public Short getFkAnnoEse() {
        return this.fkAnnoEse;
    }
    
    public void setFkAnnoEse(Short fkAnnoEse) {
        this.fkAnnoEse = fkAnnoEse;
    }
    public Integer getFkNumeStp() {
        return this.fkNumeStp;
    }
    
    public void setFkNumeStp(Integer fkNumeStp) {
        this.fkNumeStp = fkNumeStp;
    }
    public Integer getFkNumeApp() {
        return this.fkNumeApp;
    }
    
    public void setFkNumeApp(Integer fkNumeApp) {
        this.fkNumeApp = fkNumeApp;
    }
    public String getFkCodiUfficio() {
        return this.fkCodiUfficio;
    }
    
    public void setFkCodiUfficio(String fkCodiUfficio) {
        this.fkCodiUfficio = fkCodiUfficio;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AnagAmminUfficiBOId) ) return false;
		 AnagAmminUfficiBOId castOther = ( AnagAmminUfficiBOId ) other; 
         
		 return ( (this.getFkAnnoEse()==castOther.getFkAnnoEse()) || ( this.getFkAnnoEse()!=null && castOther.getFkAnnoEse()!=null && this.getFkAnnoEse().equals(castOther.getFkAnnoEse()) ) )
 && ( (this.getFkNumeStp()==castOther.getFkNumeStp()) || ( this.getFkNumeStp()!=null && castOther.getFkNumeStp()!=null && this.getFkNumeStp().equals(castOther.getFkNumeStp()) ) )
 && ( (this.getFkNumeApp()==castOther.getFkNumeApp()) || ( this.getFkNumeApp()!=null && castOther.getFkNumeApp()!=null && this.getFkNumeApp().equals(castOther.getFkNumeApp()) ) )
 && ( (this.getFkCodiUfficio()==castOther.getFkCodiUfficio()) || ( this.getFkCodiUfficio()!=null && castOther.getFkCodiUfficio()!=null && this.getFkCodiUfficio().equals(castOther.getFkCodiUfficio()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFkAnnoEse() == null ? 0 : this.getFkAnnoEse().hashCode() );
         result = 37 * result + ( getFkNumeStp() == null ? 0 : this.getFkNumeStp().hashCode() );
         result = 37 * result + ( getFkNumeApp() == null ? 0 : this.getFkNumeApp().hashCode() );
         result = 37 * result + ( getFkCodiUfficio() == null ? 0 : this.getFkCodiUfficio().hashCode() );
         return result;
   }   


}


