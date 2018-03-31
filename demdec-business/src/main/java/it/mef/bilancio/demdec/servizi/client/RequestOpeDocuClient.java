package it.mef.bilancio.demdec.servizi.client;

import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.gov.mef.demdec.servizi.dembil.InterfacciaOperazioniDocumentaliStub;
import it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoConversione_type;
import it.mef.bilancio.demdec.to.AbstractDemTO;

import java.util.List;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.client.Options;
import org.apache.axis2.databinding.types.URI;
import org.xmlsoap.schemas.soap.envelope.MustUnderstand_type0;


public class RequestOpeDocuClient implements DEMBILConstants {

	private AbstractDemTO inputTO;
	private ParametriInput parametriInput;
	private AccessoApplicativo accessoApplicativo;
	private InterfacciaOperazioniDocumentaliStub stub;
	
	//upload documento
	private TipoConversione_type tipoOperazioneDocumento;

	public  RequestOpeDocuClient(ParametriInput oParametriInput) throws Throwable{	
		TraceLogger.infoLog("create RequestDEMBILClient", this.getClass());
		this.parametriInput=oParametriInput;
		this.stub = getService(oParametriInput);
		this.accessoApplicativo= buildAccessoApplicativo(oParametriInput);
		TraceLogger.infoLog("create RequestDEMBILClient", this.getClass());
	}
	
	
	
	public  RequestOpeDocuClient(ParametriInput oParametriInput,AbstractDemTO oInputTO,List<AbstractDemTO> oListInputTO) throws Throwable{	
		TraceLogger.infoLog("create RequestDEMBILClient", this.getClass());
		this.parametriInput=oParametriInput;
		this.stub = getService(oParametriInput);
		this.accessoApplicativo= buildAccessoApplicativo(oParametriInput);
		this.inputTO=oInputTO;
		TraceLogger.infoLog("create RequestDEMBILClient", this.getClass());
	}
	
	public  RequestOpeDocuClient(ParametriInput oParametriInput,AbstractDemTO oInputTO) throws Throwable{
		this(oParametriInput,oInputTO,null);
		}
	
	
	
	public  void cleanData() throws Throwable{	
		TraceLogger.infoLog("clean RequestDEMBILClient", this.getClass());
		this.inputTO=null;
		this.tipoOperazioneDocumento=null;
		TraceLogger.infoLog("clean RequestDEMBILClient", this.getClass());
	}
		

	public InterfacciaOperazioniDocumentaliStub getService(ParametriInput parametri) throws Throwable{
		
		try {
			TraceLogger.debugLog("Inizializzo lo stub con urlWS che vale "+parametri.getUrlWS(), this.getClass());
			InterfacciaOperazioniDocumentaliStub stub = new InterfacciaOperazioniDocumentaliStub(parametri.getUrlWS());
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

	public AbstractDemTO getInputTO() {
		return inputTO;
	}


	public void setInputTO(AbstractDemTO inputTO) {
		this.inputTO = inputTO;
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


	public InterfacciaOperazioniDocumentaliStub getStub() {
		return stub;
	}


	public void setStub(InterfacciaOperazioniDocumentaliStub stub) {
		this.stub = stub;
	}

	public TipoConversione_type getTipoOperazioneDocumento() {
		return tipoOperazioneDocumento;
	}

	public void setTipoOperazioneDocumento(TipoConversione_type tipoOperazioneDocumento) {
		this.tipoOperazioneDocumento = tipoOperazioneDocumento;
	}

}
