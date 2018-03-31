package it.mef.bilancio.demdec.servizi.client;

import java.util.Hashtable;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.databinding.types.URI;
import org.apache.axis2.Constants;
import org.xmlsoap.schemas.soap.envelope.MustUnderstand_type0;

import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL;
import it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBILStub;
import it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo;
import it.mef.bilancio.demdec.to.AbstractDemTO;


public class RequestDEMBILClient implements DEMBILConstants {

	private AbstractDemTO inputTO;
	private List<AbstractDemTO> listInputTO;
	private ParametriInput parametriInput;
	private AccessoApplicativo accessoApplicativo;
	private InterfacciaAttoDecretoDEMBIL stub;
	
	//upload documento
	private String tipoOperazioneDocumento;
	private Hashtable<String, String> parametriOperazione;
	private String IdDocumentoOperazione;

	//estrazione fascicoli/documenti
	private String tipoEstrazioneFascicolo;
	private String tipoEstrazioneDocumenti;
	private String idFascicolo;
	private String idDocumento;
	private String idSottofascicolo;
	
	private String statoFascicoloAttoDecreto;
	
	//Copy Fascicolo
	private String idFascicoloDestinazione;

	public  RequestDEMBILClient(ParametriInput oParametriInput) throws Throwable{	
		TraceLogger.infoLog("create RequestDEMBILClient", this.getClass());
		this.parametriInput=oParametriInput;
		this.stub = getService(oParametriInput);
		this.accessoApplicativo= buildAccessoApplicativo(oParametriInput);
		TraceLogger.infoLog("create RequestDEMBILClient", this.getClass());
	}
	
	
	
	public  RequestDEMBILClient(ParametriInput oParametriInput,AbstractDemTO oInputTO,List<AbstractDemTO> oListInputTO) throws Throwable{	
		TraceLogger.infoLog("create RequestDEMBILClient", this.getClass());
		this.parametriInput=oParametriInput;
		this.stub = getService(oParametriInput);
		this.accessoApplicativo= buildAccessoApplicativo(oParametriInput);
		this.listInputTO=oListInputTO;
		this.inputTO=oInputTO;
		TraceLogger.infoLog("create RequestDEMBILClient", this.getClass());
	}
	
	public  RequestDEMBILClient(ParametriInput oParametriInput,AbstractDemTO oInputTO) throws Throwable{
		this(oParametriInput,oInputTO,null);
		}
	
	
	
	public  void cleanData() throws Throwable{	
		TraceLogger.infoLog("clean RequestDEMBILClient", this.getClass());
		this.listInputTO=null;
		this.inputTO=null;
		this.tipoEstrazioneFascicolo=null;
		this.tipoEstrazioneDocumenti=null;
		this.tipoOperazioneDocumento=null;
		this.parametriOperazione=null;
		this.idFascicolo=null;
		this.idDocumento=null;
		this.idSottofascicolo=null;
		TraceLogger.infoLog("clean RequestDEMBILClient", this.getClass());
	}
		

	public InterfacciaAttoDecretoDEMBIL getService(ParametriInput parametri) throws Throwable{
		
		try {
			TraceLogger.debugLog("Inizializzo lo stub con urlWS che vale "+parametri.getUrlWS(), this.getClass());
			InterfacciaAttoDecretoDEMBILStub stub = new InterfacciaAttoDecretoDEMBILStub(parametri.getUrlWS());
		    Options options = stub._getServiceClient().getOptions();
		    options.setProperty(Constants.Configuration.ENABLE_MTOM, Constants.VALUE_TRUE);
		    options.setManageSession(true);
			options.setTimeOutInMilliSeconds(parametri.getTimeOutWS()*1000);
		    return stub;
		  } catch (AxisFault e) {
				TraceLogger.errorLog("Inizializzo lo stub con urlWS che vale "+parametri.getUrlWS(), this.getClass(),e);
		     throw e;
		  }
		     
	}

	private AccessoApplicativo buildAccessoApplicativo (ParametriInput paramtri) throws Throwable {
		TraceLogger.infoLog("Client.buildAccessoApplicativo.inizio", this.getClass());
		/* SOAP HEADER */
		
		
	
		AccessoApplicativo ac= new AccessoApplicativo();
		ac.setActor(new URI(paramtri.getActorWS()));
		ac.setApplicazione(paramtri.getApplicazioneWS());
		ac.setClient(paramtri.getClientWS());
		MustUnderstand_type0 mustUnderstand =new MustUnderstand_type0();
		mustUnderstand.setMustUnderstand_type0(Boolean.valueOf(paramtri.getMustUnderstandWS()));
		ac.setOrgID(paramtri.getOrgIDWS());
		ac.setPassword(paramtri.getPasswdWS());
		ac.setUtente(paramtri.getUtenteWS());
		ac.setTipoUtente(paramtri.getTipoUtenteWS());
		ac.setServizio(paramtri.getServizioWS());
		ac.setMustUnderstand(mustUnderstand);

		TraceLogger.infoLog("Client.buildAccessoApplicativo.fine", this.getClass());
		return ac;

	}

	
	
	/*	
	private AccessoApplicativo buildAccessoApplicativo () throws Throwable {
		TraceLogger.infoLog("Client.buildAccessoApplicativo.inizio", this.getClass());
		
		
		
		String actorWS="http://mef.gov.it/servizi/Common/HeaderAccessoApplicativo";
		String applicazioneWS="DEMDEC";
		String clientWS="DEMDEC";
		String mustUnderstandWS="true";
		String orgIDWS="1";
		String tipoUtenteWS="1";
		String utenteWS=tabServDaoImpl.searchPropertyValueFromTabServ(DEMBIL_UTENTE_WS);
		String passwdWS=tabServDaoImpl.searchPropertyValueFromTabServ(DEMBIL_PASS_WS);
		String servizioWS="1";
		
		AccessoApplicativo ac= new AccessoApplicativo();
		ac.setActor(new URI(actorWS));
		ac.setApplicazione(applicazioneWS);
		ac.setClient(clientWS);
		MustUnderstand_type0 mustUnderstand =new MustUnderstand_type0();
		mustUnderstand.setMustUnderstand_type0(Boolean.valueOf(mustUnderstandWS));
		
		ac.setMustUnderstand(mustUnderstand);
		ac.setOrgID(orgIDWS);
		ac.setPassword(tipoUtenteWS);
		ac.setUtente(utenteWS);
		ac.setTipoUtente(tipoUtenteWS);
		ac.setServizio(servizioWS);

		TraceLogger.infoLog("Client.buildAccessoApplicativo.fine", this.getClass());
		return ac;

	}
	
	*/

	

	public AbstractDemTO getInputTO() {
		return inputTO;
	}


	public void setInputTO(AbstractDemTO inputTO) {
		this.inputTO = inputTO;
	}


	public List<AbstractDemTO> getListInputTO() {
		return listInputTO;
	}


	public void setListInputTO(List<AbstractDemTO> listInputTO) {
		this.listInputTO = listInputTO;
	}


	public ParametriInput getParametriInput() {
		return parametriInput;
	}


	public void setParametriInput(ParametriInput parametriInput) {
		this.parametriInput = parametriInput;
	}


	public AccessoApplicativo getAccessoApplicativo() {
		return accessoApplicativo;
	}


	public void setAccessoApplicativo(AccessoApplicativo accessoApplicativo) {
		this.accessoApplicativo = accessoApplicativo;
	}


	public InterfacciaAttoDecretoDEMBIL getStub() {
		return stub;
	}


	public void setStub(InterfacciaAttoDecretoDEMBIL stub) {
		this.stub = stub;
	}

	public String getTipoEstrazioneFascicolo() {
		return tipoEstrazioneFascicolo;
	}

	public void setTipoEstrazioneFascicolo(String tipoEstrazioneFascicolo) {
		this.tipoEstrazioneFascicolo = tipoEstrazioneFascicolo;
	}

	public String getTipoEstrazioneDocumenti() {
		return tipoEstrazioneDocumenti;
	}

	public void setTipoEstrazioneDocumenti(String tipoEstrazioneDocumenti) {
		this.tipoEstrazioneDocumenti = tipoEstrazioneDocumenti;
	}

	public String getTipoOperazioneDocumento() {
		return tipoOperazioneDocumento;
	}

	public void setTipoOperazioneDocumento(String tipoOperazioneDocumento) {
		this.tipoOperazioneDocumento = tipoOperazioneDocumento;
	}

	public String getIdFascicolo() {
		return idFascicolo;
	}

	public void setIdFascicolo(String idFascicolo) {
		this.idFascicolo = idFascicolo;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getIdSottofascicolo() {
		return idSottofascicolo;
	}

	public void setIdSottofascicolo(String idSottofascicolo) {
		this.idSottofascicolo = idSottofascicolo;
	}



	public Hashtable<String, String> getParametriOperazione() {
		return parametriOperazione;
	}



	public void setParametriOperazione(Hashtable<String, String> parametriOperazione) {
		this.parametriOperazione = parametriOperazione;
	}



	public String getIdDocumentoOperazione() {
		return IdDocumentoOperazione;
	}



	public void setIdDocumentoOperazione(String idDocumentoOperazione) {
		IdDocumentoOperazione = idDocumentoOperazione;
	}



	public String getStatoFascicoloAttoDecreto() {
		return statoFascicoloAttoDecreto;
	}



	public void setStatoFascicoloAttoDecreto(String statoFascicoloAttoDecreto) {
		this.statoFascicoloAttoDecreto = statoFascicoloAttoDecreto;
	}



	public String getIdFascicoloDestinazione() {
		return idFascicoloDestinazione;
	}



	public void setIdFascicoloDestinazione(String idFascicoloDestinazione) {
		this.idFascicoloDestinazione = idFascicoloDestinazione;
	}
	
	
	
	
}
