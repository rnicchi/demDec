package it.mef.bilancio.demdec.to;

import java.sql.Blob;

// Generated 1-lug-2015 10.26.47 by Hibernate Tools 3.4.0.CR1

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;
import it.almavivaitalia.bilancio.commons.to.AnagTipoRiepilogoTO;

/**
 * FascicoliBO generated by hbm2java
 */
public class RiepilogoDatiAnagTO extends AbstractCommonTO implements
		java.io.Serializable {

    private Long id;
    private FascicoliTO fascicoli;
    private AnagTipoRiepilogoTO anagTipoRiepilogo;
    private String descRiepilogo;
    private String flagIndebitamentoSn;

    private String descTipoAltro;
    private Blob binaIntReport;

   public RiepilogoDatiAnagTO() {
   }

	
   public RiepilogoDatiAnagTO(FascicoliTO fascicoli, String descRiepilogo, String flagIndebitamento01) {
       this.fascicoli = fascicoli;
       this.descRiepilogo = descRiepilogo;
       this.flagIndebitamentoSn = flagIndebitamento01;
   }
   public RiepilogoDatiAnagTO(FascicoliTO fascicoli, AnagTipoRiepilogoTO anagTipoRiepilogo, String descRiepilogo, String flagIndebitamento01) {
      this.fascicoli = fascicoli;
      this.anagTipoRiepilogo = anagTipoRiepilogo;
      this.descRiepilogo = descRiepilogo;
      this.flagIndebitamentoSn = flagIndebitamento01;
   }
  
   public Long getId() {
       return this.id;
   }
   
   public void setId(Long id) {
       this.id = id;
   }
   public FascicoliTO getFascicoli() {
       return this.fascicoli;
   }
   
   public void setFascicoli(FascicoliTO fascicoli) {
       this.fascicoli = fascicoli;
   }
   public AnagTipoRiepilogoTO getAnagTipoRiepilogo() {
       return this.anagTipoRiepilogo;
   }
   
   public void setAnagTipoRiepilogo(AnagTipoRiepilogoTO anagTipoRiepilogo) {
       this.anagTipoRiepilogo = anagTipoRiepilogo;
   }
   public String getDescRiepilogo() {
       return this.descRiepilogo;
   }
   
   public void setDescRiepilogo(String descRiepilogo) {
       this.descRiepilogo = descRiepilogo;
   }
  

   public String getFlagIndebitamentoSn() {
	return flagIndebitamentoSn;
}


public void setFlagIndebitamentoSn(String flagIndebitamentoSn) {
	this.flagIndebitamentoSn = flagIndebitamentoSn;
}



public String getDescTipoAltro() {
	return descTipoAltro;
}


public void setDescTipoAltro(String descTipoAltro) {
	this.descTipoAltro = descTipoAltro;
}


public Blob getBinaIntReport() {
	return binaIntReport;
}


public void setBinaIntReport(Blob binaIntReport) {
	this.binaIntReport = binaIntReport;
}


/**
    * toString
    * @return String
    */
    public String toString() {
	  StringBuffer buffer = new StringBuffer();

     buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
     buffer.append("id").append("='").append(getId()).append("' ");			
     buffer.append("fascicoli").append("='").append(getFascicoli()).append("' ");			
     buffer.append("anagTipoRiepilogo").append("='").append(getAnagTipoRiepilogo()).append("' ");			
     buffer.append("descRiepilogo").append("='").append(getDescRiepilogo()).append("' ");			
     buffer.append("flagIndebitamento01").append("='").append(getFlagIndebitamentoSn()).append("' ");			
     buffer.append("]");
     
     return buffer.toString();
    }

  public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RiepilogoDatiAnagTO) ) return false;
		 RiepilogoDatiAnagTO castOther = ( RiepilogoDatiAnagTO ) other; 
        
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
&& ( (this.getFascicoli()==castOther.getFascicoli()) || ( this.getFascicoli()!=null && castOther.getFascicoli()!=null && this.getFascicoli().equals(castOther.getFascicoli()) ) )
&& ( (this.getAnagTipoRiepilogo()==castOther.getAnagTipoRiepilogo()) || ( this.getAnagTipoRiepilogo()!=null && castOther.getAnagTipoRiepilogo()!=null && this.getAnagTipoRiepilogo().equals(castOther.getAnagTipoRiepilogo()) ) )
&& ( (this.getDescRiepilogo()==castOther.getDescRiepilogo()) || ( this.getDescRiepilogo()!=null && castOther.getDescRiepilogo()!=null && this.getDescRiepilogo().equals(castOther.getDescRiepilogo()) ) )
&& ( (this.getFlagIndebitamentoSn()==castOther.getFlagIndebitamentoSn()) || ( this.getFlagIndebitamentoSn()!=null && castOther.getFlagIndebitamentoSn()!=null && this.getFlagIndebitamentoSn().equals(castOther.getFlagIndebitamentoSn()) ) );
  }
  
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
        result = 37 * result + ( getFascicoli() == null ? 0 : this.getFascicoli().hashCode() );
        result = 37 * result + ( getAnagTipoRiepilogo() == null ? 0 : this.getAnagTipoRiepilogo().hashCode() );
        result = 37 * result + ( getDescRiepilogo() == null ? 0 : this.getDescRiepilogo().hashCode() );
        result = 37 * result + ( getFlagIndebitamentoSn() == null ? 0 : this.getFlagIndebitamentoSn().hashCode() );
        return result;
  }   

 // The following is extra code specified in the hbm.xml files
private static final long serialVersionUID = 1L;
 // end of extra code specified in the hbm.xml files

	

}