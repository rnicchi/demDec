package it.mef.bilancio.demdec.servizi.client;


import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.gov.mef.demdec.servizi.dembil.InterfacciaOperazioniDocumentali;
import it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ConversioneContent_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoContent_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Esito_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_convertiDocumento;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_convertiDocumento_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_convertiDocumento;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_convertiDocumento_type;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class InterfacciaOperazioniDocumentaliClient implements DEMBILConstants{
	
	public  ResponseOpeDocuClient convertiDocumento(RequestOpeDocuClient requestOpeDocuClient){
		ResponseOpeDocuClient responseDEMBILClient = new ResponseOpeDocuClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.convertiDocumento.inizio", this.getClass());
			InterfacciaOperazioniDocumentali stub = requestOpeDocuClient.getStub();
			AccessoApplicativo accessoApplicativo= requestOpeDocuClient.getAccessoApplicativo();
			TraceLogger.infoLog("Client.convertiDocumento.creaRequest", this.getClass());
			Richiesta_convertiDocumento richiesta = new Richiesta_convertiDocumento();
			Richiesta_convertiDocumento_type richiestaType = new Richiesta_convertiDocumento_type();
			richiestaType.setTipoConversione(requestOpeDocuClient.getTipoOperazioneDocumento());
			
			ConversioneContent_type content = new ConversioneContent_type();
			DocumentoContent_type to = UtilRequestClient.createDocumentContentType((DocumentContentTO) requestOpeDocuClient.getInputTO());
			content.setFileName(to.getFileName());
			content.setContent(to.getContent());
			richiestaType.setDatiDocumento(content);
			
			richiesta.setRichiesta_convertiDocumento(richiestaType);
			
			Risposta_convertiDocumento risposta=stub.convertiDocumento(richiesta, accessoApplicativo);
			Risposta_convertiDocumento_type response_type=risposta.getRisposta_convertiDocumento();
			
			responseDEMBILClient.setEsitoTo(new EsitoTO(response_type.getEsito().getValue(),ERRORI.get(response_type.getEsito().getValue())));
			TraceLogger.infoLog("Client.convertiDocumento " + response_type.getEsito().getValue(),  UtilResponseClient.class);
			if (response_type.getEsito().equals(Esito_type.OK)){
				responseDEMBILClient.setOutputTO(convertiDocument(response_type.getDocument()));
			} else {
			 	List<String> errorsList = new ArrayList<String>();
				if (response_type.getErrorList() != null && response_type.getErrorList().length>0){
				 	for (int i = 0; i < response_type.getErrorList().length; i++) {
						errorsList.add((response_type.getErrorList()[i].getErrorMessageString()));
						TraceLogger.infoLog("SERVIZIO DEMBIL ERRORE " + "setEsito " , UtilResponseClient.class);
						TraceLogger.infoLog("SERVIZIO DEMBIL ERRORE " + "setEsito:"+ response_type.getErrorList()[i].getErrorCode() +" msg:" + response_type.getErrorList()[i].getErrorMessageString(), UtilResponseClient.class);
				 	} 	 	
				} 	

				responseDEMBILClient.getEsitoTo().setErrors(errorsList);
			}
			
		} catch(ClassCastException ccE){
			TraceLogger.errorLog("Errore nella creazione della Risposta o della richiesta " + "convertiDocumento "+"Remote exception", this.getClass(),ccE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,ccE.getMessage()));
		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "convertiDocumento "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "convertiDocumento ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		
		return responseDEMBILClient;
		
	}
	
	private DocumentContentTO convertiDocument(ConversioneContent_type type) throws Throwable{
		DocumentContentTO result = new DocumentContentTO();
		result.setFileName(type.getFileName());
		result.setContent(IOUtils.toByteArray(type.getContent().getDataSource().getInputStream()));
		return result;
	}
	
}



