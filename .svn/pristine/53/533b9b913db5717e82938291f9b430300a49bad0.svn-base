package it.mef.bilancio.demdec.web.services;

import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.web.services.type.EsitoType;
import it.mef.bilancio.demdec.web.services.type.GestioneFadType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService(serviceName = "nsbfGestioneFascicoliWS", 
			targetNamespace = "http://services.demdec.bilancio.mef.it/")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class NsbfGestioneFascicoliWS extends SpringBeanAutowiringSupport {

	@Autowired
	private NsbfGestioneFascicoli nsbfGestioneFascicoli;

	@WebMethod
	public @WebResult(name = "Esito", partName = "Esito") EsitoType 
		creaFascicolo(
			@WebParam(	name = "HeaderNsbf", 
						header = true, 
						targetNamespace = "http://services.demdec.bilancio.mef.it/", 
						partName = "HeaderNsbf") Holder<HeaderNsbf> headerApplicativoHolder,
			@WebParam(
						name = "CreaFascicoloRequest", 
						partName = "CreaFascicoloRequest") GestioneFadType gestioneFadType)
			throws NsbfGestioneFascicoliServiceException {

		EsitoType esito = null;
		
		try {

			TraceLogger.infoLog("call NsbfGestioneFascicoliWS.creaFascicolo() ", this.getClass());
			
			esito = nsbfGestioneFascicoli.creaFascicolo(headerApplicativoHolder.value, gestioneFadType);
			
			TraceLogger.infoLog("fine call NsbfGestioneFascicoliWS.creaFascicolo() ",this.getClass());
		} catch (NsbfGestioneFascicoliServiceException t) {
			throw t;
		}catch (Throwable t) {
			TraceLogger.errorLog(
					"errore call NsbfGestioneFascicoliWS.creaFascicolo() ",
					this.getClass(), t);
		}finally{
			if(esito==null||!DEMBILConstants.ESITO_OK.equals(esito.getCodice())){
				throw buildNsbfGestioneFascicoliServiceException(esito);
			}			
		}
		return new EsitoType(NsbfGestioneFascicoliConstants.ESITO_OK, NsbfGestioneFascicoliConstants.DESC_ESITO_OK);
	}
	
	private NsbfGestioneFascicoliServiceException buildNsbfGestioneFascicoliServiceException(EsitoType esito){
		NsbfGestioneFascicoliServiceFault fault=new NsbfGestioneFascicoliServiceFault();
		fault.setFaultCode(esito.getCodice());
		
		String decode="Si è verificato un errore di sistema";
		
		if(esito.getDescrizione().equals(it.mef.bilancio.demdec.utils.Constants.DECRETO_EXISTS)){
			decode="Esiste già un decreto sul sistema gestionale";
		}else if(esito.getDescrizione().equals(it.mef.bilancio.demdec.utils.Constants.FAD_EXISTS)){
			decode="Esite già un fascicolo per il decreto.";
		}else if(esito.getDescrizione().equals(it.mef.bilancio.demdec.utils.Constants.PATR_EXISTS)){
			decode="Esiste già un decreto sul sistema gestionale collegato a un diverso numero di prelevamento patrimonio.";
		}
		
		fault.setFaultDescription(decode);
		
		return new NsbfGestioneFascicoliServiceException(fault);
	}
	
	@WebMethod
	public @WebResult(name = "Esito", partName = "Esito") EsitoType 
		modificaFascicolo(
			@WebParam(	name = "HeaderNsbf", 
						header = true, 
						targetNamespace = "http://services.demdec.bilancio.mef.it/", 
						partName = "HeaderNsbf") Holder<HeaderNsbf> headerApplicativoHolder,
			@WebParam(
						name = "ModificaFascicoloRequest", 
						partName = "ModificaFascicoloRequest") GestioneFadType gestioneFadType)
			throws NsbfGestioneFascicoliServiceException {

		EsitoType esito = null;
		
		try {

			TraceLogger.infoLog("call NsbfGestioneFascicoliWS.modificaFascicolo() ", this.getClass());
			
			esito = nsbfGestioneFascicoli.modificaFascicolo(headerApplicativoHolder.value, gestioneFadType);
			
			TraceLogger.infoLog("fine call NsbfGestioneFascicoliWS.modificaFascicolo() ",this.getClass());
		} catch (Throwable t) {
			TraceLogger.errorLog(
					"errore call NsbfGestioneFascicoliWS.modificaFascicolo() ",
					this.getClass(), t);
		}finally{
			if(esito==null||!DEMBILConstants.ESITO_OK.equals(esito.getCodice())){
				throw buildNsbfGestioneFascicoliServiceException(esito);
			}				
		}
		
		return new EsitoType(NsbfGestioneFascicoliConstants.ESITO_OK, NsbfGestioneFascicoliConstants.DESC_ESITO_OK);
	}	
	
	@WebMethod
	public @WebResult(name = "Esito", partName = "Esito") EsitoType 
		eliminaFascicolo(
			@WebParam(	name = "HeaderNsbf", 
						header = true, 
						targetNamespace = "http://services.demdec.bilancio.mef.it/", 
						partName = "HeaderNsbf") Holder<HeaderNsbf> headerApplicativoHolder,
			@WebParam(
						name = "EliminaFascicoloRequest", 
						partName = "EliminaFascicoloRequest") GestioneFadType gestioneFadType)
			throws NsbfGestioneFascicoliServiceException {

		EsitoType esito = null;
		
		try {

			TraceLogger.infoLog("call NsbfGestioneFascicoliWS.eliminaFascicolo() ", this.getClass());
			
			esito = nsbfGestioneFascicoli.eliminaFascicolo(headerApplicativoHolder.value, gestioneFadType);
			
			TraceLogger.infoLog("fine call NsbfGestioneFascicoliWS.eliminaFascicolo() ",this.getClass());
		} catch (NsbfGestioneFascicoliServiceException t) {
			throw t;
		}catch (Throwable t) {
			TraceLogger.errorLog(
					"errore call NsbfGestioneFascicoliWS.eliminaFascicolo() ",
					this.getClass(), t);
		}finally{
			if(esito==null||!DEMBILConstants.ESITO_OK.equals(esito.getCodice())){
				throw buildNsbfGestioneFascicoliServiceException(esito);
			}			
		}
		
		return new EsitoType(NsbfGestioneFascicoliConstants.ESITO_OK, NsbfGestioneFascicoliConstants.DESC_ESITO_OK);
	}		
	
	@WebMethod
	public @WebResult(name = "Esito", partName = "Esito") EsitoType trasportoVariazioniFascicolo(
			@WebParam(	name = "HeaderNsbf", 
						header = true, 
						targetNamespace = "http://services.demdec.bilancio.mef.it/", 
						partName = "HeaderNsbf") Holder<HeaderNsbf> headerApplicativoHolder,
			@WebParam(
						name = "TrasportoVariazioniFascicoloRequest", 
						partName = "TrasportoVariazioniFascicoloRequest") GestioneFadType gestioneFadType)
			throws NsbfGestioneFascicoliServiceException {

		EsitoType esito = null;
		
		try {

			TraceLogger.infoLog("call NsbfGestioneFascicoliWS.trasportoVariazioniFascicolo() ", this.getClass());
			
			esito = nsbfGestioneFascicoli.trasportoVariazioniFascicolo(headerApplicativoHolder.value, gestioneFadType);
			
			TraceLogger.infoLog("fine call NsbfGestioneFascicoliWS.trasportoVariazioniFascicolo() ",this.getClass());
		} catch (NsbfGestioneFascicoliServiceException t) {
			throw t;
		}catch (Throwable t) {
			TraceLogger.errorLog(
					"errore call NsbfGestioneFascicoliWS.trasportoVariazioniFascicolo() ",
					this.getClass(), t);
		}finally{
			if(esito==null||!DEMBILConstants.ESITO_OK.equals(esito.getCodice())){
				throw buildNsbfGestioneFascicoliServiceException(esito);
			}			
		}
		
		return new EsitoType(NsbfGestioneFascicoliConstants.ESITO_OK, NsbfGestioneFascicoliConstants.DESC_ESITO_OK);
	}	
	
	@WebMethod
	public @WebResult(name = "Esito", partName = "Esito") EsitoType 
		sospensioneFascicolo(
			@WebParam(	name = "HeaderNsbf", 
						header = true, 
						targetNamespace = "http://services.demdec.bilancio.mef.it/", 
						partName = "HeaderNsbf") Holder<HeaderNsbf> headerApplicativoHolder,
			@WebParam(
						name = "SospensioneFascicoloRequest", 
						partName = "SospensioneFascicoloRequest") GestioneFadType gestioneFadType)
			throws NsbfGestioneFascicoliServiceException {

		EsitoType esito = null;
		
		try {

			TraceLogger.infoLog("call NsbfGestioneFascicoliWS.sospensioneFascicolo() ", this.getClass());
			
			esito = nsbfGestioneFascicoli.sospensioneFascicolo(headerApplicativoHolder.value, gestioneFadType);
			
			TraceLogger.infoLog("fine call NsbfGestioneFascicoliWS.sospensioneFascicolo() ",this.getClass());
		} catch (NsbfGestioneFascicoliServiceException t) {
			throw t;
		}catch (Throwable t) {
			TraceLogger.errorLog(
					"errore call NsbfGestioneFascicoliWS.sospensioneFascicolo() ",
					this.getClass(), t);
		}finally{
			if(esito==null||!DEMBILConstants.ESITO_OK.equals(esito.getCodice())){
				throw buildNsbfGestioneFascicoliServiceException(esito);
			}				
		}
		
		return new EsitoType(NsbfGestioneFascicoliConstants.ESITO_OK, NsbfGestioneFascicoliConstants.DESC_ESITO_OK);
	}
	
	@WebMethod
	public @WebResult(name = "Esito", partName = "Esito") EsitoType 
		revocaSospensioneFascicolo(
			@WebParam(	name = "HeaderNsbf", 
						header = true, 
						targetNamespace = "http://services.demdec.bilancio.mef.it/", 
						partName = "HeaderNsbf") Holder<HeaderNsbf> headerApplicativoHolder,
			@WebParam(
						name = "RevocaSospensioneFascicoloRequest", 
						partName = "RevocaSospensioneFascicoloRequest") GestioneFadType gestioneFadType)
			throws NsbfGestioneFascicoliServiceException {

		EsitoType esito = null;
		
		try {

			TraceLogger.infoLog("call NsbfGestioneFascicoliWS.revocaSospensioneFascicolo() ", this.getClass());
			
			esito = nsbfGestioneFascicoli.revocaSospensioneFascicolo(headerApplicativoHolder.value, gestioneFadType);
			
			TraceLogger.infoLog("fine call NsbfGestioneFascicoliWS.revocaSospensioneFascicolo() ",this.getClass());
		} catch (NsbfGestioneFascicoliServiceException t) {
			throw t;
		}catch (Throwable t) {
			TraceLogger.errorLog(
					"errore call NsbfGestioneFascicoliWS.revocaSospensioneFascicolo() ",
					this.getClass(), t);
		}finally{
			if(esito==null||!DEMBILConstants.ESITO_OK.equals(esito.getCodice())){
				throw buildNsbfGestioneFascicoliServiceException(esito);
			}				
		}
		
		return new EsitoType(NsbfGestioneFascicoliConstants.ESITO_OK, NsbfGestioneFascicoliConstants.DESC_ESITO_OK);
	}	
	
	@WebMethod
	public @WebResult(name = "Esito", partName = "Esito") EsitoType 
		riaperturaFascicolo(
			@WebParam(	name = "HeaderNsbf", 
						header = true, 
						targetNamespace = "http://services.demdec.bilancio.mef.it/", 
						partName = "HeaderNsbf") Holder<HeaderNsbf> headerApplicativoHolder,
			@WebParam(
						name = "RiaperturaFascicoloRequest", 
						partName = "RiaperturaFascicoloRequest") GestioneFadType gestioneFadType)
			throws NsbfGestioneFascicoliServiceException {

		EsitoType esito = null;
		
		try {

			TraceLogger.infoLog("call NsbfGestioneFascicoliWS.riaperturaFascicolo() ", this.getClass());
			
			esito = nsbfGestioneFascicoli.riaperturaFascicolo(headerApplicativoHolder.value, gestioneFadType);
			
			TraceLogger.infoLog("fine call NsbfGestioneFascicoliWS.riaperturaFascicolo() ",this.getClass());
		} catch (NsbfGestioneFascicoliServiceException t) {
			throw t;
		}catch (Throwable t) {
			TraceLogger.errorLog(
					"errore call NsbfGestioneFascicoliWS.riaperturaFascicolo() ",
					this.getClass(), t);
		}finally{
			if(esito==null||!DEMBILConstants.ESITO_OK.equals(esito.getCodice())){
				throw buildNsbfGestioneFascicoliServiceException(esito);
			}				
		}
		
		return new EsitoType(NsbfGestioneFascicoliConstants.ESITO_OK, NsbfGestioneFascicoliConstants.DESC_ESITO_OK);
	}		
	

}
