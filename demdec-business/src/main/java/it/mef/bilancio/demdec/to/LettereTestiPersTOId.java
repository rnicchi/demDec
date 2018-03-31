package it.mef.bilancio.demdec.to;

import java.math.BigDecimal;


public class LettereTestiPersTOId extends AbstractDemTO implements java.io.Serializable {

   // private String fkNumeIdFascicolo;
    private String fkSequIdLettereIgb;
    private String codiTipoLettera;
    private String codiSezione;
    private String numeRiga;
     
     

	public String getFkSequIdLettereIgb() {
		return fkSequIdLettereIgb;
	}
	public void setFkSequIdLettereIgb(String fkSequIdLettereIgb) {
		this.fkSequIdLettereIgb = fkSequIdLettereIgb;
	}
	public String getCodiTipoLettera() {
		return codiTipoLettera;
	}
	public void setCodiTipoLettera(String codiTipoLettera) {
		this.codiTipoLettera = codiTipoLettera;
	}
	public String getCodiSezione() {
		return codiSezione;
	}
	public void setCodiSezione(String codiSezione) {
		this.codiSezione = codiSezione;
	}
	public String getNumeRiga() {
		return numeRiga;
	}
	public void setNumeRiga(String numeRiga) {
		this.numeRiga = numeRiga;
	}

    


}


