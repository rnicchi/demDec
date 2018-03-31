package it.almavivaitalia.bilancio.commons.bo;
// Generated 13-nov-2015 15.35.22 by Hibernate Tools 3.4.0.CR1



/**
 * DescDocumentoBOId generated by hbm2java
 */
public class DescDocumentoBOId  implements java.io.Serializable {


     private String codiDescDocumento;
     private String textDescrizione;
     private String codiTipoDocumento;

    public DescDocumentoBOId() {
    }

	
    public DescDocumentoBOId(String codiDescDocumento) {
        this.codiDescDocumento = codiDescDocumento;
    }
    public DescDocumentoBOId(String codiDescDocumento, String textDescrizione, String codiTipoDocumento) {
       this.codiDescDocumento = codiDescDocumento;
       this.textDescrizione = textDescrizione;
       this.codiTipoDocumento = codiTipoDocumento;
    }
   
    public String getCodiDescDocumento() {
        return this.codiDescDocumento;
    }
    
    public void setCodiDescDocumento(String codiDescDocumento) {
        this.codiDescDocumento = codiDescDocumento;
    }
    public String getTextDescrizione() {
        return this.textDescrizione;
    }
    
    public void setTextDescrizione(String textDescrizione) {
        this.textDescrizione = textDescrizione;
    }
    public String getCodiTipoDocumento() {
        return this.codiTipoDocumento;
    }
    
    public void setCodiTipoDocumento(String codiTipoDocumento) {
        this.codiTipoDocumento = codiTipoDocumento;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DescDocumentoBOId) ) return false;
		 DescDocumentoBOId castOther = ( DescDocumentoBOId ) other; 
         
		 return ( (this.getCodiDescDocumento()==castOther.getCodiDescDocumento()) || ( this.getCodiDescDocumento()!=null && castOther.getCodiDescDocumento()!=null && this.getCodiDescDocumento().equals(castOther.getCodiDescDocumento()) ) )
 && ( (this.getTextDescrizione()==castOther.getTextDescrizione()) || ( this.getTextDescrizione()!=null && castOther.getTextDescrizione()!=null && this.getTextDescrizione().equals(castOther.getTextDescrizione()) ) )
 && ( (this.getCodiTipoDocumento()==castOther.getCodiTipoDocumento()) || ( this.getCodiTipoDocumento()!=null && castOther.getCodiTipoDocumento()!=null && this.getCodiTipoDocumento().equals(castOther.getCodiTipoDocumento()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodiDescDocumento() == null ? 0 : this.getCodiDescDocumento().hashCode() );
         result = 37 * result + ( getTextDescrizione() == null ? 0 : this.getTextDescrizione().hashCode() );
         result = 37 * result + ( getCodiTipoDocumento() == null ? 0 : this.getCodiTipoDocumento().hashCode() );
         return result;
   }   


}


