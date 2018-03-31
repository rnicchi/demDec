package it.mef.bilancio.demdec.servizi.to;

import it.mef.bilancio.demdec.to.AbstractDemTO;

import java.util.Date;



public class ProtocolloTO extends AbstractDemTO implements java.io.Serializable{//INIZIO METODO

	private static final long serialVersionUID = 2944608766548829032L;

	private final static String DEFAULT_AOO="RED";
	
	private String aoo;
	private Date data;//data red
	private String tipo;
	private String numeroProtocollo;
	private String descrizioneProtocollo;
	
	public ProtocolloTO(String paoo, Date pdata,String ptipo, String pnumeroProtocollo ){//INIZIO METODO
		this.aoo=paoo;
		this.data=pdata;
		this.tipo=ptipo;
		this.numeroProtocollo=pnumeroProtocollo;
		this.descrizioneProtocollo=tipo+pdata+numeroProtocollo;
		
	}//END

	public ProtocolloTO(Date pdata,String ptipo, String pnumeroProtocollo ){//INIZIO METODO
		this(DEFAULT_AOO, pdata,ptipo, pnumeroProtocollo );
		
	}//END

	public String getAoo() {
		return aoo;
	}

	public void setAoo(String aoo) {
		this.aoo = aoo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}

	public void setNumeroProtocollo(String numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}

	public String getDescrizioneProtocollo() {
		return descrizioneProtocollo;
	}

	public void setDescrizioneProtocollo(String descrizioneProtocollo) {
		this.descrizioneProtocollo = descrizioneProtocollo;
	}
	

}//END
