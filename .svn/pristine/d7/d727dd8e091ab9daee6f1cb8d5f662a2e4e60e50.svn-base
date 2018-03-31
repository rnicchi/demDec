package it.mef.bilancio.demdec.to;
// Generated 6-mag-2015 14.23.06 by Hibernate Tools 3.4.0.CR1



import java.util.Date;


public class PecMessaggiInviatiTO extends AbstractDemTO implements java.io.Serializable {


     private String id;
     private String textMessaggio;
     private String codiFunzione;
     private Date dataInvio;
     private String statInvio;

    public PecMessaggiInviatiTO() {
    }

    public PecMessaggiInviatiTO(String textMessaggio, String codiFunzione, Date dataInvio, String statInvio) {
       this.textMessaggio = textMessaggio;
       this.codiFunzione = codiFunzione;
       this.dataInvio = dataInvio;
       this.statInvio = statInvio;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getTextMessaggio() {
        return this.textMessaggio;
    }
    
    public void setTextMessaggio(String textMessaggio) {
        this.textMessaggio = textMessaggio;
    }
    public String getCodiFunzione() {
        return this.codiFunzione;
    }
    
    public void setCodiFunzione(String codiFunzione) {
        this.codiFunzione = codiFunzione;
    }
    public Date getDataInvio() {
        return this.dataInvio;
    }
    
    public void setDataInvio(Date dataInvio) {
        this.dataInvio = dataInvio;
    }
    public String getStatInvio() {
        return this.statInvio;
    }
    
    public void setStatInvio(String statInvio) {
        this.statInvio = statInvio;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("id").append("='").append(getId()).append("' ");			
      buffer.append("textMessaggio").append("='").append(getTextMessaggio()).append("' ");			
      buffer.append("codiFunzione").append("='").append(getCodiFunzione()).append("' ");			
      buffer.append("dataInvio").append("='").append(getDataInvio()).append("' ");			
      buffer.append("statInvio").append("='").append(getStatInvio()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PecMessaggiInviatiTO) ) return false;
		 PecMessaggiInviatiTO castOther = ( PecMessaggiInviatiTO ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getTextMessaggio()==castOther.getTextMessaggio()) || ( this.getTextMessaggio()!=null && castOther.getTextMessaggio()!=null && this.getTextMessaggio().equals(castOther.getTextMessaggio()) ) )
 && ( (this.getCodiFunzione()==castOther.getCodiFunzione()) || ( this.getCodiFunzione()!=null && castOther.getCodiFunzione()!=null && this.getCodiFunzione().equals(castOther.getCodiFunzione()) ) )
 && ( (this.getDataInvio()==castOther.getDataInvio()) || ( this.getDataInvio()!=null && castOther.getDataInvio()!=null && this.getDataInvio().equals(castOther.getDataInvio()) ) )
 && ( (this.getStatInvio()==castOther.getStatInvio()) || ( this.getStatInvio()!=null && castOther.getStatInvio()!=null && this.getStatInvio().equals(castOther.getStatInvio()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getTextMessaggio() == null ? 0 : this.getTextMessaggio().hashCode() );
         result = 37 * result + ( getCodiFunzione() == null ? 0 : this.getCodiFunzione().hashCode() );
         result = 37 * result + ( getDataInvio() == null ? 0 : this.getDataInvio().hashCode() );
         result = 37 * result + ( getStatInvio() == null ? 0 : this.getStatInvio().hashCode() );
         
         return result;
   }   

  // The following is extra code specified in the hbm.xml files
private static final long serialVersionUID = 1L;
  // end of extra code specified in the hbm.xml files

}


