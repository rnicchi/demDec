package it.almavivaitalia.bilancio.commons.bo;
// Generated 23-dic-2015 15.03.23 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;

/**
 * LettereTestiBO generated by hbm2java
 */
public class LettereTestiBO extends AbstractCommonBO implements java.io.Serializable {


     private BigDecimal id;
     private String codiTipoLettera;
     private String codiSezione;
     private Short numeRiga;
     private String textContenuto;

    public LettereTestiBO() {
    }

	
    public LettereTestiBO(String codiTipoLettera, String codiSezione) {
        this.codiTipoLettera = codiTipoLettera;
        this.codiSezione = codiSezione;
    }
    public LettereTestiBO(Integer numeVersion, String codiTipoLettera, String codiSezione, Short numeRiga, String textContenuto) {
       this.codiTipoLettera = codiTipoLettera;
       this.codiSezione = codiSezione;
       this.numeRiga = numeRiga;
       this.textContenuto = textContenuto;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCodiTipoLettera() {
        return this.codiTipoLettera;
    }
    
    public void setCodiTipoLettera(String codiTipoLettera) {
        this.codiTipoLettera = codiTipoLettera;
    }
    public String getCodiSezione() {
        return this.codiSezione;
    }
    
    public void setCodiSezione(String codiSezione) {
        this.codiSezione = codiSezione;
    }
    public Short getNumeRiga() {
        return this.numeRiga;
    }
    
    public void setNumeRiga(Short numeRiga) {
        this.numeRiga = numeRiga;
    }
    public String getTextContenuto() {
        return this.textContenuto;
    }
    
    public void setTextContenuto(String textContenuto) {
        this.textContenuto = textContenuto;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("id").append("='").append(getId()).append("' ");			
      buffer.append("numeVersion").append("='").append(getNumeVersion()).append("' ");			
      buffer.append("codiTipoLettera").append("='").append(getCodiTipoLettera()).append("' ");			
      buffer.append("codiSezione").append("='").append(getCodiSezione()).append("' ");			
      buffer.append("numeRiga").append("='").append(getNumeRiga()).append("' ");			
      buffer.append("textContenuto").append("='").append(getTextContenuto()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LettereTestiBO) ) return false;
		 LettereTestiBO castOther = ( LettereTestiBO ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getCodiTipoLettera()==castOther.getCodiTipoLettera()) || ( this.getCodiTipoLettera()!=null && castOther.getCodiTipoLettera()!=null && this.getCodiTipoLettera().equals(castOther.getCodiTipoLettera()) ) )
 && ( (this.getCodiSezione()==castOther.getCodiSezione()) || ( this.getCodiSezione()!=null && castOther.getCodiSezione()!=null && this.getCodiSezione().equals(castOther.getCodiSezione()) ) )
 && ( (this.getNumeRiga()==castOther.getNumeRiga()) || ( this.getNumeRiga()!=null && castOther.getNumeRiga()!=null && this.getNumeRiga().equals(castOther.getNumeRiga()) ) )
 && ( (this.getTextContenuto()==castOther.getTextContenuto()) || ( this.getTextContenuto()!=null && castOther.getTextContenuto()!=null && this.getTextContenuto().equals(castOther.getTextContenuto()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getCodiTipoLettera() == null ? 0 : this.getCodiTipoLettera().hashCode() );
         result = 37 * result + ( getCodiSezione() == null ? 0 : this.getCodiSezione().hashCode() );
         result = 37 * result + ( getNumeRiga() == null ? 0 : this.getNumeRiga().hashCode() );
         result = 37 * result + ( getTextContenuto() == null ? 0 : this.getTextContenuto().hashCode() );
         return result;
   }   

  // The following is extra code specified in the hbm.xml files
private static final long serialVersionUID = 1L;
  // end of extra code specified in the hbm.xml files

}


