package it.almavivaitalia.bilancio.commons.to;
// Generated 12-gen-2016 10.35.26 by Hibernate Tools 3.4.0.CR1



/**
 * AnagTipologiaTagliaBO generated by hbm2java
 */
public class AnagTipologiaTagliaTO extends AbstractCommonTO implements java.io.Serializable {


     private Integer id;
     private String descTipologiaTaglia;
     private String codiAggr;

    public AnagTipologiaTagliaTO() {
    }

	
    public AnagTipologiaTagliaTO(String descTipologiaTaglia) {
        this.descTipologiaTaglia = descTipologiaTaglia;
    }
    public AnagTipologiaTagliaTO(String descTipologiaTaglia, String codiAggr) {
       this.descTipologiaTaglia = descTipologiaTaglia;
       this.codiAggr = codiAggr;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescTipologiaTaglia() {
        return this.descTipologiaTaglia;
    }
    
    public void setDescTipologiaTaglia(String descTipologiaTaglia) {
        this.descTipologiaTaglia = descTipologiaTaglia;
    }
    public String getCodiAggr() {
        return this.codiAggr;
    }
    
    public void setCodiAggr(String codiAggr) {
        this.codiAggr = codiAggr;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("id").append("='").append(getId()).append("' ");			
      buffer.append("descTipologiaTaglia").append("='").append(getDescTipologiaTaglia()).append("' ");			
      buffer.append("codiAggr").append("='").append(getCodiAggr()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AnagTipologiaTagliaTO) ) return false;
		 AnagTipologiaTagliaTO castOther = ( AnagTipologiaTagliaTO ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getDescTipologiaTaglia()==castOther.getDescTipologiaTaglia()) || ( this.getDescTipologiaTaglia()!=null && castOther.getDescTipologiaTaglia()!=null && this.getDescTipologiaTaglia().equals(castOther.getDescTipologiaTaglia()) ) )
 && ( (this.getCodiAggr()==castOther.getCodiAggr()) || ( this.getCodiAggr()!=null && castOther.getCodiAggr()!=null && this.getCodiAggr().equals(castOther.getCodiAggr()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getDescTipologiaTaglia() == null ? 0 : this.getDescTipologiaTaglia().hashCode() );
         result = 37 * result + ( getCodiAggr() == null ? 0 : this.getCodiAggr().hashCode() );
         return result;
   }   

  // The following is extra code specified in the hbm.xml files
private static final long serialVersionUID = 1L;
  // end of extra code specified in the hbm.xml files

}


