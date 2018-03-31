package it.mef.bilancio.demdec.servizi.client;


import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL;
import it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.*;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.servizi.to.FadDemBilTO;
import it.mef.bilancio.demdec.servizi.to.FascicoloSipatrTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.DocumentiRedTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.InvioFadTO;
import it.mef.bilancio.demdec.to.RicercaRedTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.utils.UtilityApplication;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;





public class InterfacciaAttoDecretoDEMBILClient implements DEMBILConstants{
	
	
	
	public  ResponseDEMBILClient changeStatoFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.changeStatoFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			TraceLogger.infoLog("Client.changeStatoFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_changeStatoFascicoloAttoDecreto richiesta = new Richiesta_changeStatoFascicoloAttoDecreto();
			Richiesta_changeStatoFascicoloAttoDecreto_type richiestaType = new Richiesta_changeStatoFascicoloAttoDecreto_type();
			Guid [] arrayGuid=new Guid[1] ;
			arrayGuid[0]=UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo());
			richiestaType.setIdFascicoloAttoDecreto(arrayGuid);
			
/*			StatoFascicoloDocumentale_type sfdType=null;
			
			if(requestDEMBILClient.getStatoFascicoloAttoDecreto().equalsIgnoreCase(Constants.STATO_FAD_IN_ELABORAZIONE)){
				sfdType=StatoFascicoloDocumentale_type.IN_ELABORAZIONE;
			}else if (requestDEMBILClient.getStatoFascicoloAttoDecreto().equalsIgnoreCase(Constants.STATO_FAD_APERTO)){
				sfdType=StatoFascicoloDocumentale_type.APERTO;
			}else if (requestDEMBILClient.getStatoFascicoloAttoDecreto().equalsIgnoreCase(Constants.STATO_FAD_CHIUSO)){
				sfdType=StatoFascicoloDocumentale_type.CHIUSO;
			}
			
			richiestaType.setStatoFascicoloDocumentale(sfdType);*/
			richiestaType.setStatoFascicoloDocumentale(UtilRequestClient.createStatoFascicoloDocumentale(requestDEMBILClient.getStatoFascicoloAttoDecreto()));
			TraceLogger.infoLog("Client.changeStatoFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			richiesta.setRichiesta_changeStatoFascicoloAttoDecreto(richiestaType);
			
			Risposta_changeStatoFascicoloAttoDecreto risposta=stub.changeStatoFascicoloAttoDecreto(richiesta, accessoApplicativo);
			Risposta_changeStatoFascicoloAttoDecreto_type response_type=risposta.getRisposta_changeStatoFascicoloAttoDecreto();
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			
		} catch(ClassCastException ccE){
			TraceLogger.errorLog("Errore nella creazione della Risposta o della richiesta " + "changeStatoFascicoloAttoDecreto "+"Remote exception", this.getClass(),ccE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,ccE.getMessage()));
		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "changeStatoFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "changeStatoFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		
		return responseDEMBILClient;
		
	}
	
	
	public  ResponseDEMBILClient changeStatoFascicoloRacoltaProvvisoria(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.changeStatoFascicoloRacoltaProvvisoria.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			
			InvioFadTO reqTo=(InvioFadTO)requestDEMBILClient.getInputTO();
			TraceLogger.infoLog("Client.changeStatoFascicoloRacoltaProvvisoria.creaRequest", this.getClass());
			Richiesta_changeStatoFascicoloRaccoltaProvvisoria richiesta = new Richiesta_changeStatoFascicoloRaccoltaProvvisoria();
			Richiesta_changeStatoFascicoloRaccoltaProvvisoria_type richiestaType = new Richiesta_changeStatoFascicoloRaccoltaProvvisoria_type();
			richiestaType.setIdFascicoloRaccoltaProvvisoria(UtilRequestClient.createGuid(reqTo.getIdFascicoloRaccoltaProvvisoria()));
			InvioFadTO ifTo=(InvioFadTO) requestDEMBILClient.getInputTO();
			
/*			StatoFascicoloDocumentale_type sfdType=null;
			if ( ifTo.getStatoFascicolo().equalsIgnoreCase("IN ELABORAZIONE") )  {
				 sfdType=StatoFascicoloDocumentale_type.IN_ELABORAZIONE;
			}else if ( ifTo.getStatoFascicolo().equalsIgnoreCase("APERTO") ) {
				 sfdType=StatoFascicoloDocumentale_type.APERTO;
			}else if ( ifTo.getStatoFascicolo().equalsIgnoreCase("CHIUSO") ) {
				 sfdType=StatoFascicoloDocumentale_type.CHIUSO;
			}*/
			
			richiestaType.setStatoFascicoloDocumentale(UtilRequestClient.createStatoFascicoloDocumentale(ifTo.getStatoFascicolo()));
			richiesta.setRichiesta_changeStatoFascicoloRaccoltaProvvisoria(richiestaType);
			TraceLogger.infoLog("Client.changeStatoFascicoloRacoltaProvvisoria.fine.creaRequest", this.getClass());
			
			Risposta_changeStatoFascicoloRaccoltaProvvisoria risposta=stub.changeStatoFascicoloRaccoltaProvvisoria(richiesta, accessoApplicativo);
			Risposta_changeStatoFascicoloRaccoltaProvvisoria_type response_type=risposta.getRisposta_changeStatoFascicoloRaccoltaProvvisoria();
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			
		} catch(ClassCastException ccE){
			TraceLogger.errorLog("Errore nella creazione della Risposta o della richiesta " + "changeStatoFascicoloRacoltaProvvisoria "+"Remote exception", this.getClass(),ccE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,ccE.getMessage()));
		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "changeStatoFascicoloRacoltaProvvisoria "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "changeStatoFascicoloRacoltaProvvisoria ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		
		return responseDEMBILClient;
		
	}

	
	
	
	
	
	/*INIZIO RACCOLTE PROVVISORIE*/
	
	public  ResponseDEMBILClient searchFascicoliRaccolteProvvisorie(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.searchFascicoliRaccolteProvvisorie.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			
			
			RicercaRedTO ricercaRedTO = (RicercaRedTO)requestDEMBILClient.getInputTO();

			TraceLogger.infoLog("Client.searchFascicoliRaccolteProvvisorie.creaRequest", this.getClass());
			Richiesta_searchFascicoliRaccolteProvvisorie richiesta = new Richiesta_searchFascicoliRaccolteProvvisorie();
			
			Richiesta_searchFascicoliRaccolteProvvisorie_type  richiestaType = new Richiesta_searchFascicoliRaccolteProvvisorie_type();
			richiestaType.setTipoEstrazioneElenco(TipoEstrazione_type.DATA);
			richiestaType.setTipoEstrazioneFascicolo(TipoEstrazione_type.METADATA);
					
			
			//Creazione Metadati Funzionali Fascicolo
			richiestaType.setIdentificativoRaccoltaProvvisoria(ricercaRedTO.getIdRed());
			
			if(!StringUtil.isEmpty(ricercaRedTO.getTipoFlusso())){
				if(ricercaRedTO.getTipoFlusso().equalsIgnoreCase("MANUALE")){
					richiestaType.setTipoFlusso(TipoFlusso_type.MANUALE);
				}else if(ricercaRedTO.getTipoFlusso().equalsIgnoreCase("AUTOMATICO")){
					richiestaType.setTipoFlusso(TipoFlusso_type.AUTOMATICO);
				}
			}
					
											
			//int indiceDescAmm=0;
			if(!StringUtil.isEmpty(ricercaRedTO.getAmministrazione())){
				//indiceDescAmm=ricercaRedTO.getAmministrazione().indexOf("-");								
				//richiestaType.setAmministrazione(UtilRequestClient.createCodiceDescrizione(ricercaRedTO.getAmministrazione().substring(0,indiceDescAmm), ricercaRedTO.getAmministrazione().substring(indiceDescAmm+1)));
				richiestaType.setDataCreazioneFascicolo(UtilRequestClient.createDataRange("01/01/"+ricercaRedTO.getAnnoEse(), "31/12/"+ricercaRedTO.getAnnoEse()));
				//richiestaType.setAmministrazione(UtilRequestClient.createCodiceDescrizione(ricercaRedTO.getAmministrazione().substring(0,indiceDescAmm), ""));
				richiestaType.setAmministrazione(UtilRequestClient.createCodiceDescrizione(ricercaRedTO.getAmministrazione(), ""));
				
			}
			
			
			richiestaType.setDataProtocollo(UtilRequestClient.createDataRange(ricercaRedTO.getDataRedDa(),ricercaRedTO.getDataRedA()));
			
			int indiceDescUff=0;
			
			if(!StringUtil.isEmpty(ricercaRedTO.getUfficioAssociatoRed())) {
				indiceDescUff=ricercaRedTO.getUfficioAssociatoRed().indexOf("-");	
				CodiceDescrizione_type codiDescType=new CodiceDescrizione_type();
				codiDescType.setCodice("");
				codiDescType.setDescrizione(ricercaRedTO.getUfficioAssociatoRed().substring(indiceDescUff+1).trim());
				richiestaType.setUfficioCreatoreRED(codiDescType);
				//richiestaType.setUfficioCreatoreRED(UtilRequestClient.createCodiceDescrizione("",ricercaRedTO.getUfficioAssociatoRed().substring(indiceDescUff+1)));
			}
			
			if (!StringUtil.isEmpty(ricercaRedTO.getProtocolloRed())){
				ProtocolloSearch_type pst= new ProtocolloSearch_type();
				Tipo_type3 t3= new Tipo_type3();
				t3.setTipo_type2(TIPO_PROTOCOLLO_ALL);
				pst.setTipo(t3) ;
				pst.setNumeroProtocollo(ricercaRedTO.getProtocolloRed());
				richiestaType.setProtocollo(pst);
			}
			
			if(!StringUtil.isEmpty(ricercaRedTO.getStato())) {
				richiestaType.setStatoFascicoloRaccoltaProvvisoria(UtilRequestClient.createStatoFascicoloDocumentale(ricercaRedTO.getStato().trim()));
			}
				
			CriteriaDocumentiRaccoltaProvvisoria_type docType = new CriteriaDocumentiRaccoltaProvvisoria_type();
			docType.setShowPreview(true);
			docType.setTipoElenco(TipoElenco_type.ALL);
			docType.setTipoEstrazioneElenco(TipoEstrazione_type.METADATA);
			TipoDocumento_type tipoDocumento_type = new TipoDocumento_type();
			tipoDocumento_type.setCodice("RP01");
			docType.setTipoDocumento(tipoDocumento_type);
			richiestaType.setDocumentCriteria(docType);
		
			TraceLogger.infoLog("Client.searchFascicoliRaccolteProvvisorie.fine.creaRequest", this.getClass());
			
			richiesta.setRichiesta_searchFascicoliRaccolteProvvisorie(richiestaType);
			Risposta_searchFascicoliRaccolteProvvisorie  response= stub.searchFascicoliRaccolteProvvisorie(richiesta, accessoApplicativo);
			Risposta_searchFascicoliRaccoltaProvvisoria_type response_type=response.getRisposta_searchFascicoliRaccolteProvvisorie();
			  
			TraceLogger.infoLog("Client.searchFascicoliRaccolteProvvisorie.fine.crea.Risposta", this.getClass());
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);

			if (response_type.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.searchFascicoliRaccolteProvvisorie ESITO OK", this.getClass());
				FascicoloRaccoltaProvvisoria_type[] rf=response_type.getFascicoli();
				List<AbstractDemTO> listaFascicoli = new ArrayList<AbstractDemTO>();
				if (rf!=null){
					for (int i = 0; i < rf.length; i++) {
						FascicoloRaccoltaProvvisoria_type raccoltaProvvisoria_type = rf[i];
						RaccoltaProvvisoriaRedTO rpRed= new RaccoltaProvvisoriaRedTO();
						rpRed.setAmministrazione(UtilResponseClient.createCodiceDescrizione(raccoltaProvvisoria_type.getDatiFascicolo().getAmministrazione()));
						rpRed.setAttivo(raccoltaProvvisoria_type.getAttivo());
						rpRed.setCodiStatoFascicoloDocumentale(raccoltaProvvisoria_type.getStatoFascicoloDocumentale().getValue());
						rpRed.setDaInviare(raccoltaProvvisoria_type.getDaInviare());
						rpRed.setDataCreazione(UtilResponseClient.createFormattedDate(raccoltaProvvisoria_type.getDataCreazione()));
						rpRed.setDescrizione(raccoltaProvvisoria_type.getDescrizione());
						rpRed.setIdentificativoRaccoltaProvvisoria(raccoltaProvvisoria_type.getDatiFascicolo().getIdentificativoRaccoltaProvvisoria());
						rpRed.setIdFascicoloRaccoltaProvvisoria(raccoltaProvvisoria_type.getIdFascicoloRaccoltaProvvisoria().toString());
						rpRed.setRagioneria(UtilResponseClient.createCodiceDescrizione(raccoltaProvvisoria_type.getDatiFascicolo().getRagioneria()));
						rpRed.setSistemaProduttore(raccoltaProvvisoria_type.getSistemaProduttore());
						rpRed.setStatoFascicoloRaccoltaProvvisoria(raccoltaProvvisoria_type.getDatiFascicolo().getStatoFascicoloRaccoltaProvvisoria());
						rpRed.setTipoFlusso(raccoltaProvvisoria_type.getDatiFascicolo().getTipoFlusso().getValue());
						rpRed.setUfficioCreatoreRED(UtilResponseClient.createCodiceDescrizione(raccoltaProvvisoria_type.getDatiFascicolo().getUfficioCreatoreRED()));																			
						rpRed.setUtenteCreatore(UtilResponseClient.createCodiceDescrizione(raccoltaProvvisoria_type.getDatiFascicolo().getUtenteCreatore()));	
						rpRed.setProtocollo(UtilResponseClient.createProocollo(raccoltaProvvisoria_type.getDatiFascicolo().getProtocollo()));
						if (!StringUtil.isEmpty(raccoltaProvvisoria_type.getDocumenti())){
							rpRed.setPreView(UtilResponseClient.createPreview(raccoltaProvvisoria_type.getDocumenti()[0].getPreviewPng()));
						}
						listaFascicoli.add(rpRed);
					}
				}
				responseDEMBILClient.setListoutputTO(listaFascicoli);
			}else  { 
				responseDEMBILClient.getEsitoTo().setCodice(response_type.getEsito().getValue());
				responseDEMBILClient.getEsitoTo().setDescrizione( (response_type.getErrorList()!=null && response_type.getErrorList().length>0)?response_type.getErrorList()[0].getErrorMessageString():response_type.getEsito().getValue());
			}
			TraceLogger.debugLog("Client.searchFascicoliRaccolteProvvisorie.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(ClassCastException ccE){
			TraceLogger.errorLog("Errore nella creazione della Risposta o della richiesta " + "searchFascicoliRaccolteProvvisorie "+"Remote exception", this.getClass(),ccE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,ccE.getMessage()));
		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "searchFascicoliRaccolteProvvisorie "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "searchFascicoliRaccolteProvvisorie ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}

	public  ResponseDEMBILClient getFascicoloRaccoltaProvvisoria(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.getFascicoloRaccoltaProvvisoria.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			
			
			RaccoltaProvvisoriaRedTO raccoltaProvvisoria = (RaccoltaProvvisoriaRedTO)requestDEMBILClient.getInputTO();
			
			TraceLogger.infoLog("Client.getFascicoloRaccoltaProvvisoria.creaRequest", this.getClass());
			Richiesta_getFascicoloRaccoltaProvvisoria richiesta = new Richiesta_getFascicoloRaccoltaProvvisoria();
			Richiesta_getFascicoloRaccoltaProvvisoria_type  richiestaType = new Richiesta_getFascicoloRaccoltaProvvisoria_type();
			richiestaType.setIdFascicoloRaccoltaProvvisoria(UtilRequestClient.createGuid(raccoltaProvvisoria.getIdFascicoloRaccoltaProvvisoria()));
			richiestaType.setTipoEstrazioneFascicolo(UtilRequestClient.createTipoEstrazioneType(requestDEMBILClient.getTipoEstrazioneFascicolo()));
			CriteriaDocumentiRaccoltaProvvisoria_type type = new CriteriaDocumentiRaccoltaProvvisoria_type();
			type.setTipoEstrazioneElenco(TipoEstrazione_type.DATA);
			type.setTipoElenco(TipoElenco_type.ALL);
			type.setShowPreview(true);
			richiestaType.setDocumentCriteria(type);
			richiesta.setRichiesta_getFascicoloRaccoltaProvvisoria(richiestaType);
			Risposta_getFascicoloRaccoltaProvvisoria  response= stub.getFascicoloRaccoltaProvvisoria(richiesta, accessoApplicativo);
			FascicoloRaccoltaProvvisoria_type dettaglioFascicolo=response.getDettaglioFascicolo();
			  
			TraceLogger.infoLog("Client.getFascicoloRaccoltaProvvisoria.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response.getEsito(), response.getErrorList(), responseDEMBILClient);
			if (response.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.getFascicoloRaccolteProvvisorie ESITO OK", this.getClass());
				DocumentoFascicoloRaccoltaProvvisoria_type[] rf=dettaglioFascicolo.getDocumenti();
				List<DocumentTO> listaDocumenti = new ArrayList<DocumentTO>();
				if(rf!=null) {
					for (int i = 0; (rf!=null && i < rf.length); i++) {
						DocumentoFascicoloRaccoltaProvvisoria_type documentoRaccoltaProvvisoria_type = rf[i];
						DocumentTO documento = new DocumentTO();
						documento.setIdFascicolo(raccoltaProvvisoria.getIdFascicoloRaccoltaProvvisoria());
						
						/** se l'id del documento trasformato arriva vuoto prendo quello dell'originale **/
						if( documentoRaccoltaProvvisoria_type.getOperazione()!=null && documentoRaccoltaProvvisoria_type.getOperazione().getDocumentoOperazione()!=null 
								&& documentoRaccoltaProvvisoria_type.getOperazione().getDocumentoOperazione().getIdDocumento()!=null) {
							documento.setIdDocumento(documentoRaccoltaProvvisoria_type.getOperazione().getDocumentoOperazione().getIdDocumento().getGuid());
//						}else {
//							documento.setIdDocumento(documentoRaccoltaProvvisoria_type.getIdDocumento().getGuid());
						}
						//documento.setIdDocumento(documentoRaccoltaProvvisoria_type.getOperazione()!=null?documentoRaccoltaProvvisoria_type.getOperazione().getDocumentoOperazione().getIdDocumento().getGuid():documentoRaccoltaProvvisoria_type.getIdDocumento().getGuid());
						
						documento.setIdDocumentoRaccoltaProvvisoria(documentoRaccoltaProvvisoria_type.getIdDocumento().getGuid());
						documento.setTipoDocumento(UtilResponseClient.createCodiceDescrizione(documentoRaccoltaProvvisoria_type.getTipoDocumento().getCodice(),documentoRaccoltaProvvisoria_type.getTipoDocumento().getDescrizione()));
						documento.setDescrizione(documentoRaccoltaProvvisoria_type.getDescrizione());
						documento.setDataCreazione(UtilResponseClient.createFormattedDate(documentoRaccoltaProvvisoria_type.getDataCreazione()));
						documento.setCondivisibile(documentoRaccoltaProvvisoria_type.getCondivisibile());
						documento.setAttivo(documentoRaccoltaProvvisoria_type.getAttivo());
						documento.setSistemaProduttore(documentoRaccoltaProvvisoria_type.getSistemaProduttore());
						documento.setIsDocumentoOriginale(documentoRaccoltaProvvisoria_type.getIsDocumentoOriginale());
						documento.setIsDocumentoTrattato(documentoRaccoltaProvvisoria_type.getIsDocumentoTrattato());
						documento.setTicketArchiviazione(documentoRaccoltaProvvisoria_type.getTicketArchiviazione());
						//Metadata
						documento.setNote(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getNote());
						documento.setDataAnnullamento(UtilResponseClient.createFormattedDate(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getDataAnnullamento()));
						documento.setDataChiusura(UtilResponseClient.createFormattedDate(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getDataChiusura()));
						documento.setDataDocumento(UtilResponseClient.createFormattedDate(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getDataDocumento()));
						documento.setProtocollo(UtilResponseClient.createProocollo(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getProtocollo()));
						documento.setNote(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getNote());
						//Metadata
						
						//Documento File
						DocumentContentTO documentContent = new DocumentContentTO();
						documentContent.setDescrizione(documentoRaccoltaProvvisoria_type.getDescrizione());
						documentContent.setFileName(documentoRaccoltaProvvisoria_type.getFileName());
						documentContent.setFirmato(documentoRaccoltaProvvisoria_type.getFirmato());
						byte[] bhash=null;
						bhash = IOUtils.toByteArray(documentoRaccoltaProvvisoria_type.getHash().getInputStream());
						documentContent.setHash(bhash);
						documentContent.setIdDocumento(documentoRaccoltaProvvisoria_type.getIdDocumento().getGuid());
						documentContent.setLength(documentoRaccoltaProvvisoria_type.getLength());
						documentContent.setMimeType(documentoRaccoltaProvvisoria_type.getMimeType());
						documento.setDocumentoContent(documentContent);
						
						//Documento File
						
						//Documento Origine
//						if (documento.getIsDocumentoTrattato()){
						if(documentoRaccoltaProvvisoria_type.getDocumentoOrigine()!=null){
							documento.setDocumentoFileOrigine(UtilResponseClient.createDocumentFile(documentoRaccoltaProvvisoria_type.getDocumentoOrigine()));
						}
						//Documento Trattato
						
//						if (documento.getIsDocumentoOriginale()){
						if(documentoRaccoltaProvvisoria_type.getOperazione()!=null){
								OperazioneDocumentale_type opDoc =documentoRaccoltaProvvisoria_type.getOperazione();
								documento.setTipoOperazione(opDoc.getTipoOperazione()!=null?opDoc.getTipoOperazione().getValue():null);
								documento.setEsitoOperazione(opDoc.getEsitoOperazione()!=null?opDoc.getEsitoOperazione().getValue():null);
								if(opDoc.getDocumentoOperazione()!=null){
									documento.setDocumentoFileOperazione(UtilResponseClient.createDocumentFile(opDoc.getDocumentoOperazione()));
									documento.setIdDocumento(opDoc.getDocumentoOperazione().getIdDocumento()!=null?opDoc.getDocumentoOperazione().getIdDocumento().getGuid():null);
								}
						}
//						
						documento.setPreView(UtilResponseClient.createPreview(documentoRaccoltaProvvisoria_type.getPreviewPng()));
						listaDocumenti.add(documento);
						
					}
				}
				
				if(dettaglioFascicolo.getDatiFascicolo()!=null ) {
					raccoltaProvvisoria.setStatoFascicoloRaccoltaProvvisoria(dettaglioFascicolo.getDatiFascicolo().getStatoFascicoloRaccoltaProvvisoria());
					raccoltaProvvisoria.setCodiStatoFascicoloDocumentale(dettaglioFascicolo.getStatoFascicoloDocumentale().getValue());
				}
				
				raccoltaProvvisoria.setDocumenti(listaDocumenti);
				responseDEMBILClient.setOutputTO(raccoltaProvvisoria);
			}
			TraceLogger.debugLog("Client.getFascicoloRaccoltaProvvisoria.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(ClassCastException ccE){
			TraceLogger.errorLog("Errore nella creazione della Risposta o della richiesta " + "getFascicoloRaccoltaProvvisoria ", this.getClass(),ccE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,ccE.getMessage()));
		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getFascicoloRaccoltaProvvisoria "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getFascicoloRaccoltaProvvisoria ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}
	
	
	
	public  ResponseDEMBILClient getDocumentoRaccoltaProvvisoria(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.getDocumentoRaccoltaProvvisoria.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.getDocumentoRaccoltaProvvisoria.creaRequest", this.getClass());
			Richiesta_getDocumentoFascicoloRaccoltaProvvisoria richiesta = new Richiesta_getDocumentoFascicoloRaccoltaProvvisoria();
			Richiesta_getDocumentoFascicoloRaccoltaProvvisoria_type  richiestaType = new Richiesta_getDocumentoFascicoloRaccoltaProvvisoria_type();
			richiestaType.setIdDocumento(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento()));
			richiestaType.setIdFascicoloRaccoltaProvvisoria(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiestaType.setTipoEstrazioneDocumento(UtilRequestClient.createTipoEstrazioneType(requestDEMBILClient.getTipoEstrazioneDocumenti()));
			richiesta.setRichiesta_getDocumentoFascicoloRaccoltaProvvisoria(richiestaType);
						
			TraceLogger.infoLog("Client.getDocumentoRaccoltaProvvisoria.fine.creaRequest", this.getClass());
			
			Risposta_getDocumentoFascicoloRaccoltaProvvisoria response= stub.getDocumentoFascicoloRaccoltaProvvisoria(richiesta, accessoApplicativo);
			  
			TraceLogger.infoLog("Client.getDocumentoRaccoltaProvvisoria.fine.crea.Risposta", this.getClass());
			Risposta_getDocumentoFascicoloRaccoltaProvvisoria_type response_type = response.getRisposta_getDocumentoFascicoloRaccoltaProvvisoria();
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			if (response_type.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.getDocumentoRaccoltaProvvisoria ESITO OK", this.getClass());
				DocumentoFascicoloRaccoltaProvvisoria_type documentoRaccoltaProvvisoria_type = response_type.getDettaglioDocumento();
				DocumentTO documento = new DocumentTO();
				
				documento.setIdFascicolo(requestDEMBILClient.getIdFascicolo());
				documento.setIdDocumento(documentoRaccoltaProvvisoria_type.getIdDocumento().getGuid());
				documento.setTipoDocumento(UtilResponseClient.createCodiceDescrizione(documentoRaccoltaProvvisoria_type.getTipoDocumento().getCodice(),documentoRaccoltaProvvisoria_type.getTipoDocumento().getDescrizione()));
				documento.setDescrizione(documentoRaccoltaProvvisoria_type.getDescrizione());
				documento.setDataCreazione(UtilResponseClient.createFormattedDate(documentoRaccoltaProvvisoria_type.getDataCreazione()));
				documento.setCondivisibile(documentoRaccoltaProvvisoria_type.getCondivisibile());
				documento.setAttivo(documentoRaccoltaProvvisoria_type.getAttivo());
				documento.setSistemaProduttore(documentoRaccoltaProvvisoria_type.getSistemaProduttore());
				documento.setIsDocumentoOriginale(documentoRaccoltaProvvisoria_type.getIsDocumentoOriginale());
				documento.setIsDocumentoTrattato(documentoRaccoltaProvvisoria_type.getIsDocumentoTrattato());
				documento.setTicketArchiviazione(documentoRaccoltaProvvisoria_type.getTicketArchiviazione());
				//Metadata
				documento.setNote(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getNote());
				documento.setDataAnnullamento(UtilResponseClient.createFormattedDate(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getDataAnnullamento()));
				documento.setDataChiusura(UtilResponseClient.createFormattedDate(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getDataChiusura()));
				documento.setDataDocumento(UtilResponseClient.createFormattedDate(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getDataDocumento()));
				documento.setProtocollo(UtilResponseClient.createProocollo(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getProtocollo()));
				documento.setNote(documentoRaccoltaProvvisoria_type.getMetadatiDocumento().getNote());
				//Metadata
				
				//Documento File
				DocumentContentTO documentContent = new DocumentContentTO();
				documentContent.setDescrizione(documentoRaccoltaProvvisoria_type.getDescrizione());
				documentContent.setFileName(documentoRaccoltaProvvisoria_type.getFileName());
				documentContent.setFirmato(documentoRaccoltaProvvisoria_type.getFirmato());
				byte[] bhash=null;
				bhash = IOUtils.toByteArray(documentoRaccoltaProvvisoria_type.getHash().getInputStream());
				documentContent.setHash(bhash);
				documentContent.setIdDocumento(documentoRaccoltaProvvisoria_type.getIdDocumento().getGuid());
				documentContent.setLength(documentoRaccoltaProvvisoria_type.getLength());
				documentContent.setMimeType(documentoRaccoltaProvvisoria_type.getMimeType());
				documento.setDocumentoContent(documentContent);
				
				//Documento File
				
				//Documento Origine
				if (documento.getIsDocumentoTrattato()){
					documento.setDocumentoFileOrigine(UtilResponseClient.createDocumentFile(documentoRaccoltaProvvisoria_type.getDocumentoOrigine()));
				}

				//Documento Trattato
				
				if (documento.getIsDocumentoOriginale()){
					OperazioneDocumentale_type opDoc =documentoRaccoltaProvvisoria_type.getOperazione();
					if (opDoc != null){
					documento.setTipoOperazione(opDoc.getTipoOperazione().getValue());
					documento.setEsitoOperazione(opDoc.getEsitoOperazione().getValue());
					documento.setDocumentoFileOperazione(UtilResponseClient.createDocumentFile(opDoc.getDocumentoOperazione()));
					}
				}
				documento.setPreView(UtilResponseClient.createPreview(documentoRaccoltaProvvisoria_type.getPreviewPng()));
				responseDEMBILClient.setOutputTO(documento);

				
				
			}
			TraceLogger.debugLog("Client.getDocumentoRaccoltaProvvisoria.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getDocumentoRaccoltaProvvisoria "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getDocumentoRaccoltaProvvisoria ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}


	public  ResponseDEMBILClient downloadDocumentoRaccoltaProvvisoria(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.downloadDocumentoRaccolteProvvisorie.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.downloadDocumentoRaccolteProvvisorie.creaRequest", this.getClass());
			Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria richiesta = new Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria();
			Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria_type  richiestaType = new Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria_type();
			richiestaType.setIdDocumento(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento()));
			richiestaType.setIdFascicoloRaccoltaProvvisoria(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiesta.setRichiesta_downloadDocumentoFascicoloRaccoltaProvvisoria(richiestaType);
						
			TraceLogger.infoLog("Client.downloadDocumentoRaccolteProvvisorie.fine.creaRequest", this.getClass());
			
			Risposta_downloadDocumentoFascicoloRaccoltaProvvisoria response= stub.downloadDocumentoFascicoloRaccoltaProvvisoria(richiesta, accessoApplicativo);
			  
			TraceLogger.infoLog("Client.downloadDocumentoRaccolteProvvisorie.fine.crea.Risposta", this.getClass());
			Risposta_downloadDocumentoFascicoloRaccoltaProvvisoria_type response_type = response.getRisposta_downloadDocumentoFascicoloRaccoltaProvvisoria();
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			if (response_type.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.downloadDocumentoRaccolteProvvisorie ESITO OK", this.getClass());
				DocumentoContent_type documentoContent_type=response_type.getDocumentoContent();
				if (documentoContent_type!= null){
					responseDEMBILClient.setOutputTO(UtilResponseClient.createDocumentContent(documentoContent_type));
				}
			}
			TraceLogger.debugLog("Client.downloadDocumentoRaccolteProvvisorie.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoRaccolteProvvisorie "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoRaccolteProvvisorie ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}

	
	
	
	
	/*FINE RACCOLTE PROVVISORIE*/
	
	
	

	/*INIZIO FASCICOLI ALLEGATI IGB*/
	
	/*FINE FASCICOLI ALLEGATI IGB*/
	
	
	
	
	
	/*INIZIO FASCICOLO ATTO DECRETO*/
	
	
	public ResponseDEMBILClient createFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);

		try {
			TraceLogger.infoLog("Client.createFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			
			
			FadDemBilTO fad=(FadDemBilTO)requestDEMBILClient.getInputTO();
			

			TraceLogger.infoLog("Client.createFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_createFascicoloAttoDecreto richiestaCreateFascicoloAttoDecreto = new Richiesta_createFascicoloAttoDecreto();
			Richiesta_createFascicoloAttoDecreto_type  richiestaCreateFascicoloAttoDecretoType = new Richiesta_createFascicoloAttoDecreto_type();
			
			//Creazione Metadati Funzionali FAscicolo
			
			FascicoloMetadataAttoDecreto_type fascicoloMetadataAttoDecreto_type = new FascicoloMetadataAttoDecreto_type();
			fascicoloMetadataAttoDecreto_type.setAmministrazione(UtilRequestClient.createCodiceDescrizione(fad.getAmm()));
			fascicoloMetadataAttoDecreto_type.setAnno(fad.getAnnoDec());
			fascicoloMetadataAttoDecreto_type.setIdentificativoAttoDecreto(UtilityApplication.creaIdentificativoAttoDecreto(fad));
			fascicoloMetadataAttoDecreto_type.setNumeroDecreto(fad.getNumeroDec());
			fascicoloMetadataAttoDecreto_type.setRagioneria(UtilRequestClient.createCodiceDescrizione(fad.getUcbRts()));
			fascicoloMetadataAttoDecreto_type.setStatoFascicoloAttoDecreto(Constants.STATO_FAD_APERTO);
			fascicoloMetadataAttoDecreto_type.setTipoDecreto(UtilRequestClient.createCodiceDescrizione(fad.getSiglaTipoDec()));
			fascicoloMetadataAttoDecreto_type.setTipologiaDecreto(UtilRequestClient.createCodiceDescrizione(fad.getTipologiaDec()));
			fascicoloMetadataAttoDecreto_type.setTitolo(UtilRequestClient.createCodiceDescrizione(fad.getTitolo()));
			fascicoloMetadataAttoDecreto_type.setUfficioCapofila(UtilRequestClient.createCodiceDescrizione(fad.getUfficioCapofila()));
			fascicoloMetadataAttoDecreto_type.setUfficioCreatore(UtilRequestClient.createCodiceDescrizione(fad.getUfficioCreatore()));
			fascicoloMetadataAttoDecreto_type.setUtenteCreatore(UtilRequestClient.createCodiceDescrizione(fad.getUtenteCreatore()));
			fascicoloMetadataAttoDecreto_type.setVersioneMetadata(fad.getVersioneMetadata());
			
			if (fad.getNumPatr()!=null){
			fascicoloMetadataAttoDecreto_type.setIdFascicoloDecretoSIPATR(UtilRequestClient.createGuid(fad.getGuidSiPatr()));
			fascicoloMetadataAttoDecreto_type.setNumeroDecretoSIPATR(""+fad.getNumPatr());
			}
			
			
			richiestaCreateFascicoloAttoDecretoType.setDatiFascicolo(fascicoloMetadataAttoDecreto_type);
			richiestaCreateFascicoloAttoDecretoType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(fad.getGuid()));
		
		
			//Creazione Metadati Funzionali FAscicolo
			
			richiestaCreateFascicoloAttoDecretoType.setAttivo(true);
			richiestaCreateFascicoloAttoDecretoType.setDaInviare(false);
			richiestaCreateFascicoloAttoDecretoType.setDescrizione(fad.getDescDec());
			
			TraceLogger.infoLog("Client.createFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			richiestaCreateFascicoloAttoDecreto.setRichiesta_createFascicoloAttoDecreto(richiestaCreateFascicoloAttoDecretoType);
			Risposta_createFascicoloAttoDecreto  response= stub.createFascicoloAttoDecreto(richiestaCreateFascicoloAttoDecreto, accessoApplicativo);
	
			TraceLogger.infoLog("Client.createFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			UtilResponseClient.setEsito(response.getEsito(), response.getErrorList(), responseDEMBILClient);
			if (response.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.createFascicoloAttoDecreto ESITO OK", this.getClass());
//				fad.setGuid(response.getDettaglioFascicolo().getIdFascicoloAttoDecreto().getGuid());
				responseDEMBILClient.setOutputTO(fad);
				 
			}
			TraceLogger.debugLog("Client.createFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "createFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "createFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
				}
		return responseDEMBILClient;
	}


	public  ResponseDEMBILClient downloadDocumentoFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_downloadDocumentoFascicoloAttoDecreto richiesta = new Richiesta_downloadDocumentoFascicoloAttoDecreto();
			Richiesta_downloadDocumentoFascicoloAttoDecreto_type  richiestaType = new Richiesta_downloadDocumentoFascicoloAttoDecreto_type();
			richiestaType.setIdDocumento(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento()));
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiesta.setRichiesta_downloadDocumentoFascicoloAttoDecreto(richiestaType);
						
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_downloadDocumentoFascicoloAttoDecreto  response= stub.downloadDocumentoFascicoloAttoDecreto(richiesta, accessoApplicativo);
			  
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response.getEsito(), response.getErrorList(), responseDEMBILClient);
			if (response.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto ESITO OK", this.getClass());
				DocumentoContent_type documentoContent_type=response.getDocumentoContent();
				if (documentoContent_type!= null){
					
					responseDEMBILClient.setOutputTO(UtilResponseClient.createDocumentContent(documentoContent_type));
				}
			}
			TraceLogger.debugLog("Client.downloadDocumentoFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}


	
	
	
	
	public  ResponseDEMBILClient addDocumentoFascicoloAllegatoDecretoIGB(RequestDEMBILClient requestDEMBILClient){
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.addDocumentoFascicoloAllegatoDecretoIGB.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			InvioFadTO ifTO = (InvioFadTO) requestDEMBILClient.getInputTO();
			
			TraceLogger.infoLog("Client.addDocumentoFascicoloAllegatoDecretoIGB.creaRequest", this.getClass());
			Richiesta_addDocumentoFascicoloAllegatoDecretoIGB   richiesta = new Richiesta_addDocumentoFascicoloAllegatoDecretoIGB();
			Richiesta_addDocumentoFascicoloAllegatoDecretoIGB_type richiestaType=new Richiesta_addDocumentoFascicoloAllegatoDecretoIGB_type();
			
			richiestaType.setIdDocumento(null);
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(ifTO.getIdFascicoloAttoDecreto())); 
			richiestaType.setIdDocumentoRaccoltaProvvisoria(UtilRequestClient.createGuid(ifTO.getIdDocumentoRaccoltaProvvisoria()));
			richiestaType.setIdFascicoloRaccoltaProvvisoria(UtilRequestClient.createGuid(ifTO.getIdFascicoloRaccoltaProvvisoria())); 
			
//			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid()); //TODO togliere
//			richiestaType.setIdDocumentoRaccoltaProvvisoria(UtilRequestClient.createGuid());//TODO togliere
//			richiestaType.setIdFascicoloRaccoltaProvvisoria(UtilRequestClient.createGuid()); //TODO togliere
		
			richiestaType.setDescrizione(ifTO.getDescrizione());
		
			TipoDocumento_type tdType=new TipoDocumento_type();
			tdType.setCodice(ifTO.getTipoDocumento());
			richiestaType.setTipoDocumento(tdType);// � quella che scegliamo nella combo degli allegati,  documentTO.getDescDocumento());
			
			richiesta.setRichiesta_addDocumentoFascicoloAllegatoDecretoIGB(richiestaType);
			TraceLogger.infoLog("Client.addDocumentoFascicoloAllegatoDecretoIGB.fine.creaRequest", this.getClass());
			Risposta_addDocumentoFascicoloAllegatoDecretoIGB  response= stub.addDocumentoFascicoloAllegatoDecretoIGB(richiesta, accessoApplicativo);
			TraceLogger.infoLog("Client.addDocumentoFascicoloAllegatoDecretoIGB.fine.crea.Risposta", this.getClass());
			Risposta_addDocumentoFascicoloAllegatoDecretoIGB_type responseType=response.getRisposta_addDocumentoFascicoloAllegatoDecretoIGB();
			UtilResponseClient.setEsito(responseType.getEsito(),responseType.getErrorList(), responseDEMBILClient);
			
			if (responseType.getEsito().getValue().equals(ESITO_OK)){
				responseDEMBILClient.setEsitoTo(new EsitoTO(ESITO_OK,DESC_ESITO_OK));
				TraceLogger.infoLog("Client.addDocumentoFascicoloAllegatoDecretoIGB ESITO OK", this.getClass());
				
				Richiesta_getDocumentoFascicoloAllegatoDecretoIGB requestGet = new Richiesta_getDocumentoFascicoloAllegatoDecretoIGB();
				Richiesta_getDocumentoFascicoloAllegatoDecretoIGB_type requestGetType = new Richiesta_getDocumentoFascicoloAllegatoDecretoIGB_type();
				requestGetType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(ifTO.getIdFascicoloAttoDecreto()));
				requestGetType.setTipoEstrazioneDocumento(TipoEstrazione_type.METADATA);
				requestGetType.setIdDocumento(responseType.getDati().getDatiDocumento().getIdDocumento());
				
				requestGet.setRichiesta_getDocumentoFascicoloAllegatoDecretoIGB(requestGetType);
				Risposta_getDocumentoFascicoloAllegatoDecretoIGB responseGet = stub.getDocumentoFascicoloAllegatoDecretoIGB(requestGet, accessoApplicativo);
				if (!responseGet.getRisposta_getDocumentoFascicoloAllegatoDecretoIGB().getEsito().getValue().equals(ESITO_OK)){
					Risposta_getDocumentoFascicoloAllegatoDecretoIGB_type respTypeGet=responseGet.getRisposta_getDocumentoFascicoloAllegatoDecretoIGB();
					responseDEMBILClient.getEsitoTo().setCodice(respTypeGet.getEsito().getValue());
					responseDEMBILClient.getEsitoTo().setDescrizione( (respTypeGet.getErrorList()!=null && respTypeGet.getErrorList().length>0)?respTypeGet.getErrorList()[0].getErrorMessageString():respTypeGet.getEsito().getValue());
			
				}else {
					DocumentoFascicoloAllegatoDecretoIGB_type docType= responseGet.getRisposta_getDocumentoFascicoloAllegatoDecretoIGB().getDettaglioDocumento();
				
/*					DocumentTO documento = new DocumentTO();
					
					documento.setIdDocumento(docType.getIdDocumento().getGuid());   
					documento.setTipoDocumentoRed(UtilResponseClient.createCodiceDescrizione(docType.getMetadatiDocumento().getTipoDocumentoRED().getCodice(), docType.getMetadatiDocumento().getTipoDocumentoRED().getDescrizione()));
					documento.setDescrizione(docType.getDescrizione());
					documento.setDataCreazione(UtilResponseClient.createFormattedDate(docType.getDataCreazione()));
					documento.setCondivisibile(docType.getCondivisibile());
					documento.setAttivo(docType.getAttivo());
					documento.setSistemaProduttore(docType.getSistemaProduttore());
					documento.setIsDocumentoOriginale(docType.getIsDocumentoOriginale());
					documento.setIsDocumentoTrattato(docType.getIsDocumentoTrattato());
					documento.setTicketArchiviazione(docType.getTicketArchiviazione());
					documento.setTipoDocumento(UtilResponseClient.createCodiceDescrizione(docType.getTipoDocumento().getCodice(),docType.getTipoDocumento().getDescrizione()));
					
					//Metadata  TODO verificare i metadati
					documento.setIdFascicolo(docType.getMetadatiDocumento().getIdFascicoloRaccoltaProvvisoria().getGuid());
					documento.setIdDocumentoRaccoltaProvvisoria(docType.getMetadatiDocumento().getIdDocumentoRaccoltaProvvisoria().getGuid());
					documento.setAmministrazione(UtilResponseClient.createCodiceDescrizione(docType.getMetadatiDocumento().getAmministrazione()));
					documento.setUcbRts(UtilResponseClient.createCodiceDescrizione(docType.getMetadatiDocumento().getRagioneria()));
					documento.setUfficioCreatoreRed(UtilResponseClient.createCodiceDescrizione(docType.getMetadatiDocumento().getUfficioCreatoreRED()));
					documento.setUtenteCreatore(UtilResponseClient.createCodiceDescrizione(docType.getMetadatiDocumento().getUtenteCreatore()));
					documento.setTipoFlusso(docType.getMetadatiDocumento().getTipoFlusso().getValue());
					documento.setNote(docType.getMetadatiDocumento().getNote());
					documento.setDataAnnullamento(UtilResponseClient.createFormattedDate(docType.getMetadatiDocumento().getDataAnnullamento()));
					documento.setDataChiusura(UtilResponseClient.createFormattedDate(docType.getMetadatiDocumento().getDataChiusura()));
					
					documento.setDataDocumento(UtilResponseClient.createFormattedDate(docType.getMetadatiDocumento().getDataDocumento()));
					
					documento.setProtocollo(UtilResponseClient.createProocollo(docType.getMetadatiDocumento().getProtocollo()));
					documento.setProtocolloRed(UtilResponseClient.createProocollo(docType.getMetadatiDocumento().getProtocolloRed()));
					
					//Metadata  
					
					//Documento File
					DocumentContentTO documentContent = new DocumentContentTO();
					documentContent.setDescrizione(docType.getDescrizione());
					documentContent.setFileName(docType.getFileName());
					documentContent.setFirmato(docType.getFirmato());
					documentContent.setTipoCompressione(docType.getTipoCompressione());
					byte[] bHash=IOUtils.toByteArray(docType.getHash().getInputStream());
					documentContent.setHash(bHash);
					documentContent.setIdDocumento(docType.getIdDocumento().getGuid());
					documentContent.setLength(docType.getLength());
					documentContent.setMimeType(docType.getMimeType());
					
					documento.setDocumentoContent(documentContent);  
					
					
					//Documento File
					
					//Documento Origine
					if (documento.getIsDocumentoTrattato()){
						documento.setDocumentoFileOrigine(UtilResponseClient.createDocumentFile(docType.getDocumentoOrigine())); 
					}
					//Documento Trattato
					
					if (documento.getIsDocumentoOriginale()){
						OperazioneDocumentale_type opDoc =docType.getOperazione();
						if (opDoc != null){ 
							documento.setTipoOperazione(opDoc.getTipoOperazione().getValue());
							documento.setEsitoOperazione(opDoc.getEsitoOperazione().getValue());
							documento.setDocumentoFileOperazione(UtilResponseClient.createDocumentFile(opDoc.getDocumentoOperazione()));
						} 
					}*/
					DocumentTO toRespGet=UtilResponseClient.createAllegatoIGB(docType);  
				
					
					
/*					if(responseType.getDati()!=null && responseType.getDati().getDocumentiTrattati()!=null &&  responseType.getDati().getDocumentiTrattati().length>0
							&& responseType.getDati().getDocumentiTrattati()[0].getIdDocumento()!=null){
						toRespGet.setIdDocumento(responseType.getDati().getDocumentiTrattati()[0].getIdDocumento().toString());
					}
					
					
					
					if(toRespGet.getDocumentoFileOrigine()==null){
						toRespGet.setDocumentoFileOrigine(new DocumentFileTO());
						
					}
					toRespGet.getDocumentoFileOrigine().setIdDocumento(responseType.getDati().getDatiDocumento().getIdDocumento().toString());*/
					
					responseDEMBILClient.setOutputTO(toRespGet);
				}
				TraceLogger.debugLog("Client.addDocumentoFascicoloAllegatoDecretoIGB.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

				
			}else { 
				responseDEMBILClient.getEsitoTo().setCodice(responseType.getEsito().getValue());
				responseDEMBILClient.getEsitoTo().setDescrizione( (responseType.getErrorList()!=null && responseType.getErrorList().length>0)?responseType.getErrorList()[0].getErrorMessageString():responseType.getEsito().getValue());
			}
			
			
		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "addDocumentoFascicoloAllegatoDecretoIGB "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "addDocumentoFascicoloAllegatoDecretoIGB ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
		
	}
	
	
	
	public  ResponseDEMBILClient addDocumentoFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.addDocumentoFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			DocumentTO documentTO = (DocumentTO) requestDEMBILClient.getInputTO();

			TraceLogger.infoLog("Client.addDocumentoFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_addDocumentoFascicoloAttoDecreto richiesta = new Richiesta_addDocumentoFascicoloAttoDecreto();
			Richiesta_addDocumentoFascicoloAttoDecreto_type  richiestaType = new Richiesta_addDocumentoFascicoloAttoDecreto_type();
					richiestaType.setIdDocumento(UtilRequestClient.createGuid(documentTO.getIdDocumento())); // creo io il guid 
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(documentTO.getIdFascicolo())); // me lo passa gestione FAD come querystring 
			
			richiestaType.setTipoDocumento(UtilRequestClient.createTipoDocumento(documentTO.getTipoDocumento().getCode(),documentTO.getTipoDocumento().getCode())); //V
			richiestaType.setDocumentoContent(UtilRequestClient.createDocumentContentType(documentTO.getDocumentoContent()));	// V
			richiestaType.setAttivo(documentTO.getAttivo());	// attivo 
			richiestaType.setCondivisibile(documentTO.getCondivisibile());	// true 
			richiestaType.setDaInviare(documentTO.getDaInviare());//true
			richiestaType.setDatiDocumento(UtilRequestClient.createDocumentoMetadataAttoDecretoType(documentTO));
			richiestaType.setOperazione(UtilRequestClient.createRichiestaOperazioneDocumentaleType(requestDEMBILClient.getIdDocumentoOperazione(),
											requestDEMBILClient.getTipoOperazioneDocumento(),requestDEMBILClient.getParametriOperazione())); // firma automatica 
							
		
			//add richiesta type
			richiesta.setRichiesta_addDocumentoFascicoloAttoDecreto(richiestaType);
			
			TraceLogger.infoLog("Client.addDocumentoFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_addDocumentoFascicoloAttoDecreto  response= stub.addDocumentoFascicoloAttoDecreto(richiesta, accessoApplicativo);
			  
			TraceLogger.infoLog("Client.addDocumentoFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response.getEsito(), response.getErrorList(), responseDEMBILClient);
			if (response.getEsito().getValue().equals(ESITO_OK)){
				responseDEMBILClient.setEsitoTo(new EsitoTO(ESITO_OK,DESC_ESITO_OK));
				TraceLogger.infoLog("Client.addDocumentoFascicoloAttoDecreto ESITO OK", this.getClass());
				DocumentoFile_type documentoFile_type=response.getDati().getDatiDocumento();
				if (documentoFile_type!= null){
					
					//gestione response
					documentTO.getDocumentoContent().setLength(documentoFile_type.getLength());
					documentTO.getDocumentoContent().setFirmato(documentoFile_type.getFirmato());
					documentTO.getDocumentoContent().setDescrizione(documentoFile_type.getDescrizione());
					documentTO.getDocumentoContent().setFirmato(documentoFile_type.getFirmato());
					documentTO.getDocumentoContent().setHash(org.apache.commons.io.IOUtils.toByteArray(documentoFile_type.getHash().getInputStream()));
					documentTO.getDocumentoContent().setIdDocumento(documentoFile_type.getIdDocumento().getGuid());
					documentTO.getDocumentoContent().setLength(documentoFile_type.getLength());
					documentTO.getDocumentoContent().setMimeType(documentoFile_type.getMimeType());
					documentTO.getDocumentoContent().setTipoCompressione(documentoFile_type.getTipoCompressione());
					responseDEMBILClient.setOutputTO(documentTO);
				}	
			}
			TraceLogger.debugLog("Client.addDocumentoFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "addDocumentoFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "addDocumentoFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}
	
	
	
	public  ResponseDEMBILClient updateContentDocumentoFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.updateContentDocumentoFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			DocumentContentTO documentContentTO = (DocumentContentTO) requestDEMBILClient.getInputTO();

			TraceLogger.infoLog("Client.updateContentDocumentoFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_updateContentDocumentoFascicoloAttoDecreto richiesta = new Richiesta_updateContentDocumentoFascicoloAttoDecreto();
			Richiesta_updateContentDocumentoFascicoloAttoDecreto_type  richiestaType = new Richiesta_updateContentDocumentoFascicoloAttoDecreto_type();
			richiestaType.setIdDocumentoAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento()));
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiestaType.setDocumentoContent(UtilRequestClient.createDocumentContentType(documentContentTO));
			
							
		
			//add richiesta type
			richiesta.setRichiesta_updateContentDocumentoFascicoloAttoDecreto(richiestaType);
			
			TraceLogger.infoLog("Client.updateContentDocumentoFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_updateContentDocumentoFascicoloAttoDecreto  response= stub.updateContentDocumentoFascicoloAttoDecreto(richiesta, accessoApplicativo);
			Risposta_updateContentDocumentoFascicoloAttoDecreto_type  response_type= response.getRisposta_updateContentDocumentoFascicoloAttoDecreto();
			TraceLogger.infoLog("Client.updateContentDocumentoFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			if (response_type.getEsito().getValue().equals(ESITO_OK)){
				responseDEMBILClient.setEsitoTo(new EsitoTO(ESITO_OK,DESC_ESITO_OK));
				TraceLogger.infoLog("Client.updateContentDocumentoFascicoloAttoDecreto ESITO OK", this.getClass());
				DocumentoFile_type documentoFile_type=response_type.getDatiDocumento();
				if (documentoFile_type!= null){
					//gestione response
					documentContentTO.setLength(documentoFile_type.getLength());
					documentContentTO.setFirmato(documentoFile_type.getFirmato());
					documentContentTO.setMimeType(documentoFile_type.getMimeType());
								
				}	
			}
			TraceLogger.debugLog("Client.updateContentDocumentoFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "updateContentDocumentoFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "updateContentDocumentoFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}
	

	//TODO
/*	public  ResponseDEMBILClient getFascicoloAttoDecretoMetadata(RequestDEMBILClient requestDEMBILClient){ //ESTRAZIONE DATA/METADATI FAD
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.getFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.getFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_getFascicoloAttoDecreto richiesta = new Richiesta_getFascicoloAttoDecreto();
			Richiesta_getFascicoloAttoDecreto_type  richiestaType = new Richiesta_getFascicoloAttoDecreto_type();
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiestaType.setTipoEstrazioneFascicolo(UtilRequestClient.createTipoEstrazioneType(requestDEMBILClient.getTipoEstrazioneFascicolo()));
								
			TraceLogger.infoLog("Client.getFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_getFascicoloAttoDecreto  response= stub.getFascicoloAttoDecreto(richiesta, accessoApplicativo);
			  
			TraceLogger.infoLog("Client.getFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response.getEsito(), response.getErrorList(), responseDEMBILClient);
			if (response.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.getFascicoloAttoDecreto ESITO OK", this.getClass());
				FascicoloAttoDecreto_type fascicoloAttoDecreto_type=response.getDettaglioFascicolo();
				FadDemBilTO fadTo = 
				
				
				}
			TraceLogger.debugLog("Client.getFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}
*/

	public ResponseDEMBILClient modifyMetadatiFascicoloAttoDecreto(
			RequestDEMBILClient requestDEMBILClient) { // ESTRAZIONE DATA/METADATI FAD

		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient(ESITO_KO, DESC_ESITO_KO);

		try {
			TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.inizio",	this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo = requestDEMBILClient.getAccessoApplicativo();
			FadDemBilTO fad = (FadDemBilTO) requestDEMBILClient.getInputTO();

			// Lettura Metadati Fascicolo da dembil

			TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.creaRequest lettura Metadati ",this.getClass());
			Richiesta_getFascicoloAttoDecreto richiestaMetaData = new Richiesta_getFascicoloAttoDecreto();
			Richiesta_getFascicoloAttoDecreto_type richiestaMetaDataType = new Richiesta_getFascicoloAttoDecreto_type();
			richiestaMetaDataType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(fad.getGuid()));
			richiestaMetaDataType.setTipoEstrazioneFascicolo(UtilRequestClient.createTipoEstrazioneType(DEMBILConstants.TIPO_ESTRAZIONE_METADATA));
			richiestaMetaData.setRichiesta_getFascicoloAttoDecreto(richiestaMetaDataType);// FAD

			TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.fine.creaRequest lettura Metadati ",	this.getClass());

			Risposta_getFascicoloAttoDecreto responseMetadata = stub.getFascicoloAttoDecreto(richiestaMetaData,	accessoApplicativo);

			if (responseMetadata.getEsito().getValue().equals(ESITO_OK)) {
				// Se la lettura Metadati Fascicolo da dembil � andata a buon fine
				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto lettura Metadati ESITO OK", this.getClass());
				FascicoloAttoDecreto_type fascicoloAttoDecreto_type = responseMetadata.getDettaglioFascicolo();
				FascicoloMetadataAttoDecreto_type fascicoloMetadataAttoDecreto_type = fascicoloAttoDecreto_type.getDatiFascicolo();

				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto aggiorno metadati", this.getClass());
				Richiesta_modifyMetadatiFascicoloAttoDecreto richiesta = new Richiesta_modifyMetadatiFascicoloAttoDecreto();
				Richiesta_modifyMetadataFascicoloAttoDecreto_type richiestaType = new Richiesta_modifyMetadataFascicoloAttoDecreto_type();
				richiesta.setRichiesta_modifyMetadatiFascicoloAttoDecreto(richiestaType);// FAD

				fascicoloMetadataAttoDecreto_type.setAmministrazione(UtilRequestClient.createCodiceDescrizione(fad.getAmm()));
				// non modificabile fascicoloMetadataAttoDecreto_type.setAnno(fad.getAnnoDec());
				// non modificabile fascicoloMetadataAttoDecreto_type.setIdentificativoAttoDecreto(UtilityApplication.creaIdentificativoAttoDecreto(fad));
				// non modificabile fascicoloMetadataAttoDecreto_type.setNumeroDecreto(fad.getNumeroDec());
				fascicoloMetadataAttoDecreto_type.setRagioneria(UtilRequestClient.createCodiceDescrizione(fad.getUcbRts()));
				// fascicoloMetadataAttoDecreto_type.setStatoFascicoloAttoDecreto(fad.getStatoFascicolo());
				// non modificabile fascicoloMetadataAttoDecreto_type.setTipoDecreto(UtilRequestClient.createCodiceDescrizione(fad.getSiglaTipoDec()));
				fascicoloMetadataAttoDecreto_type.setTipologiaDecreto(UtilRequestClient.createCodiceDescrizione(fad.getTipologiaDec()));
				// fascicoloMetadataAttoDecreto_type.setTitolo(UtilRequestClient.createCodiceDescrizione(fad.getTitolo()));
				fascicoloMetadataAttoDecreto_type.setUfficioCapofila(UtilRequestClient.createCodiceDescrizione(fad.getUfficioCapofila()));
				// non modificabile fascicoloMetadataAttoDecreto_type.setUfficioCreatore(UtilRequestClient.createCodiceDescrizione(fad.getUfficioCreatore()));
				// non modificabile fascicoloMetadataAttoDecreto_type.setUtenteCreatore(UtilRequestClient.createCodiceDescrizione(fad.getUtenteCreatore()));
				// non modificabile fascicoloMetadataAttoDecreto_type.setVersioneMetadata(fad.getVersioneMetadata());
				
				if (fad.getChiamante().equalsIgnoreCase(Constants.CREAZIONE_GESTIONE_FAD_CHIAMANTE_NSBF)){
					if (fad.getNumPatr() != null) {
						fascicoloMetadataAttoDecreto_type.setIdFascicoloDecretoSIPATR(UtilRequestClient.createGuid(fad.getGuidSiPatr()));
						fascicoloMetadataAttoDecreto_type.setNumeroDecretoSIPATR(""	+ fad.getNumPatr());
					} else {
						fascicoloMetadataAttoDecreto_type.setIdFascicoloDecretoSIPATR(null);
						fascicoloMetadataAttoDecreto_type.setNumeroDecretoSIPATR(null);
					}
				}

				richiestaType.setFascicoloMetadata(fascicoloMetadataAttoDecreto_type);
				richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(fad.getGuid()));
				richiestaType.setAttivo(true);
				richiestaType.setDescrizione(fad.getDescDec());

				if (fad.getDaInviare() != null) {
					richiestaType.setDaInviare(fad.getDaInviare());
				}

				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.fine.creaRequest", this.getClass());

				Risposta_modifyMetadatiFascicoloAttoDecreto response = stub.modifyMetadatiFascicoloAttoDecreto(richiesta, accessoApplicativo);
				Risposta_modifyMetadataFascicoloAttoDecreto_type response_type = response.getRisposta_modifyMetadatiFascicoloAttoDecreto();

				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.fine.crea.Risposta",	this.getClass());

				UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.fine esito:"	+ responseDEMBILClient.getEsitoTo().getCodice()	+ "-" + responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());
			} else {
				// Se la lettura Metadati Fascicolo da dembil � andata malee
				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto lettura Metadati ESITO KO", this.getClass());
				UtilResponseClient.setEsito(responseMetadata.getEsito(), responseMetadata.getErrorList(), responseDEMBILClient);
				TraceLogger.infoLog( "Client.modifyMetadatiFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-" + responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

			}

		} catch (RemoteException rE) {
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "modifyMetadatiFascicoloAttoDecreto " + "Remote exception", this.getClass(), rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL, rE.getMessage()));
		} catch (Throwable t) {
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "modifyMetadatiFascicoloAttoDecreto ",	this.getClass(), t);
			responseDEMBILClient.setEsitoTo(new EsitoTO( CODI_FAUL_GENERICO_DEMBIL, t.getMessage()));
		}
		return responseDEMBILClient;
	}
	
	public ResponseDEMBILClient modifyVisibilitaFascicoloAttoDecreto(
			RequestDEMBILClient requestDEMBILClient) { // ESTRAZIONE DATA/METADATI FAD

		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient(ESITO_KO, DESC_ESITO_KO);

		try {
			TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.inizio",	this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo = requestDEMBILClient.getAccessoApplicativo();
			FadDemBilTO fad = (FadDemBilTO) requestDEMBILClient.getInputTO();

			// Lettura Metadati Fascicolo da dembil

			TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.creaRequest lettura Metadati ",this.getClass());
			Richiesta_getFascicoloAttoDecreto richiestaMetaData = new Richiesta_getFascicoloAttoDecreto();
			Richiesta_getFascicoloAttoDecreto_type richiestaMetaDataType = new Richiesta_getFascicoloAttoDecreto_type();
			richiestaMetaDataType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(fad.getGuid()));
			richiestaMetaDataType.setTipoEstrazioneFascicolo(UtilRequestClient.createTipoEstrazioneType(DEMBILConstants.TIPO_ESTRAZIONE_METADATA));
			richiestaMetaData.setRichiesta_getFascicoloAttoDecreto(richiestaMetaDataType);// FAD

			TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.fine.creaRequest lettura Metadati ",	this.getClass());

			Risposta_getFascicoloAttoDecreto responseMetadata = stub.getFascicoloAttoDecreto(richiestaMetaData,	accessoApplicativo);

			if (responseMetadata.getEsito().getValue().equals(ESITO_OK)) {
				// Se la lettura Metadati Fascicolo da dembil � andata a buon fine
				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto lettura Metadati ESITO OK", this.getClass());
				FascicoloAttoDecreto_type fascicoloAttoDecreto_type = responseMetadata.getDettaglioFascicolo();
				FascicoloMetadataAttoDecreto_type fascicoloMetadataAttoDecreto_type = fascicoloAttoDecreto_type.getDatiFascicolo();

				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto aggiorno metadati", this.getClass());
				Richiesta_modifyMetadatiFascicoloAttoDecreto richiesta = new Richiesta_modifyMetadatiFascicoloAttoDecreto();
				Richiesta_modifyMetadataFascicoloAttoDecreto_type richiestaType = new Richiesta_modifyMetadataFascicoloAttoDecreto_type();
				richiesta.setRichiesta_modifyMetadatiFascicoloAttoDecreto(richiestaType);// FAD


				richiestaType.setFascicoloMetadata(fascicoloMetadataAttoDecreto_type);
				richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(fad.getGuid()));

				if (fad.getDaInviare() != null) {
					richiestaType.setDaInviare(fad.getDaInviare());
				}

				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.fine.creaRequest", this.getClass());

				Risposta_modifyMetadatiFascicoloAttoDecreto response = stub.modifyMetadatiFascicoloAttoDecreto(richiesta, accessoApplicativo);
				Risposta_modifyMetadataFascicoloAttoDecreto_type response_type = response.getRisposta_modifyMetadatiFascicoloAttoDecreto();

				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.fine.crea.Risposta",	this.getClass());

				UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto.fine esito:"	+ responseDEMBILClient.getEsitoTo().getCodice()	+ "-" + responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());
			} else {
				// Se la lettura Metadati Fascicolo da dembil � andata malee
				TraceLogger.infoLog("Client.modifyMetadatiFascicoloAttoDecreto lettura Metadati ESITO KO", this.getClass());
				UtilResponseClient.setEsito(responseMetadata.getEsito(), responseMetadata.getErrorList(), responseDEMBILClient);
				TraceLogger.infoLog( "Client.modifyMetadatiFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-" + responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

			}

		} catch (RemoteException rE) {
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "modifyMetadatiFascicoloAttoDecreto " + "Remote exception", this.getClass(), rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL, rE.getMessage()));
		} catch (Throwable t) {
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "modifyMetadatiFascicoloAttoDecreto ",	this.getClass(), t);
			responseDEMBILClient.setEsitoTo(new EsitoTO( CODI_FAUL_GENERICO_DEMBIL, t.getMessage()));
		}
		return responseDEMBILClient;
	}
	
	public  ResponseDEMBILClient removeFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.removeFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.removeFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_removeFascicoloAttoDecreto richiesta = new Richiesta_removeFascicoloAttoDecreto();
			Richiesta_removeFascicoloAttoDecreto_type  richiestaType = new Richiesta_removeFascicoloAttoDecreto_type();
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			
			richiesta.setRichiesta_removeFascicoloAttoDecreto(richiestaType);//FAD
			TraceLogger.infoLog("Client.removeFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_removeFascicoloAttoDecreto  response= stub.removeFascicoloAttoDecreto(richiesta, accessoApplicativo);
			Risposta_removeFascicoloAttoDecreto_type   response_type = response.getRisposta_removeFascicoloAttoDecreto();
			TraceLogger.infoLog("Client.removeFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			TraceLogger.debugLog("Client.removeFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "removeFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "removeFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}


	public  ResponseDEMBILClient removeDocumentoFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.removeDocumentoFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.removeDocumentoFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_removeDocumentoFascicoloAttoDecreto richiesta = new Richiesta_removeDocumentoFascicoloAttoDecreto();
			Richiesta_removeDocumentoFascicoloAttoDecreto_type  richiestaType = new Richiesta_removeDocumentoFascicoloAttoDecreto_type();
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo())); //FAD
			richiestaType.setIdDocumento(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento())); //FAD
			richiesta.setRichiesta_removeDocumentoFascicoloAttoDecreto(richiestaType);//FAD

			
			TraceLogger.infoLog("Client.removeDocumentoFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			Risposta_removeDocumentoFascicoloAttoDecreto  response= stub.removeDocumentoFascicoloAttoDecreto(richiesta, accessoApplicativo);
			Risposta_removeDocumentoFascicoloAttoDecreto_type   response_type = response.getRisposta_removeDocumentoFascicoloAttoDecreto();
			TraceLogger.infoLog("Client.removeDocumentoFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			TraceLogger.debugLog("Client.removeDocumentoFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "removeDocumentoFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "removeDocumentoFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}

	
	public  ResponseDEMBILClient modifyMetadatiDocumentoFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			DocumentiTO documentiTO=(DocumentiTO)requestDEMBILClient.getInputTO();
			
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAttoDecreto.creaRequest lettura Metadati ", this.getClass());
			Richiesta_getDocumentoFascicoloAttoDecreto richiestaMetaData = new Richiesta_getDocumentoFascicoloAttoDecreto();
			Richiesta_getDocumentoFascicoloAttoDecreto_type  richiestaMetaDataType = new Richiesta_getDocumentoFascicoloAttoDecreto_type();
			richiestaMetaDataType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(documentiTO.getCodiGuidFascicolo()));
			richiestaMetaDataType.setIdDocumento(UtilRequestClient.createGuid(documentiTO.getCodiGuidDocumentoOrig()));
			richiestaMetaDataType.setTipoEstrazioneDocumento(UtilRequestClient.createTipoEstrazioneType(DEMBILConstants.TIPO_ESTRAZIONE_METADATA));
			richiestaMetaData.setRichiesta_getDocumentoFascicoloAttoDecreto(richiestaMetaDataType);//FAD
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAttoDecreto.fine.creaRequest lettura Metadati ", this.getClass());
			
			Risposta_getDocumentoFascicoloAttoDecreto  responseMetadata= stub.getDocumentoFascicoloAttoDecreto(richiestaMetaData, accessoApplicativo);
			Risposta_getDocumentoFascicoloAttoDecreto_type  responseMetadataType= responseMetadata.getRisposta_getDocumentoFascicoloAttoDecreto();
						
			if (responseMetadataType.getEsito().getValue().equals(ESITO_OK)){

			DocumentoFascicoloAttoDecreto_type dettaglio = responseMetadataType.getDettaglioDocumento();
	
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto richiesta = new Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto();
			Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto_type  richiestaType = new Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto_type();
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(documentiTO.getCodiGuidFascicolo())); 
			richiestaType.setIdDocumento(UtilRequestClient.createGuid(documentiTO.getCodiGuidDocumentoOrig())); 
			richiestaType.setAttivo(dettaglio.getAttivo());
			richiestaType.setCondivisibile(dettaglio.getCondivisibile());
			if (documentiTO.getFlagVisibilitaCdc01().intValue()==0){
				richiestaType.setDaInviare(DEMBILConstants.FLAG_DAINVIARE_NO_VISIBILITA_CORTE);
			}
			else{
				richiestaType.setDaInviare(DEMBILConstants.FLAG_DAINVIARE_VISIBILITA_CORTE);
			}
			richiestaType.setCondivisibile(dettaglio.getCondivisibile());
			

			richiestaType.setDocumentoMetadata(dettaglio.getMetadatiDocumento());
			richiestaType.setCondivisibile(dettaglio.getCondivisibile());
			DocumentoMetadataAttoDecreto_type metadati =dettaglio.getMetadatiDocumento();
			
			if(documentiTO.getAnagAmminDem()!=null && documentiTO.getAnagAmminDem().getId()!=null){
				metadati.setAmministrazione(UtilRequestClient.createCodiceDescrizione(documentiTO.getAnagAmminDem().getId().getAmmin(),documentiTO.getAnagAmminDem().getDescAmm()));
			}
			
			if(documentiTO.getAnagRagionerieDem()!=null && documentiTO.getAnagRagionerieDem().getId()!=null){
				metadati.setRagioneria(UtilRequestClient.createCodiceDescrizione(documentiTO.getAnagRagionerieDem().getId().getCodiRag(),documentiTO.getAnagRagionerieDem().getDescRag()));
			}
			
			richiestaType.setDocumentoMetadata(metadati);
			richiesta.setRichiesta_modifyMetadatiDocumentoFascicoloAttoDecreto(richiestaType);


			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			Risposta_modifyMetadatiDocumentoFascicoloAttoDecreto  response= stub.modifyMetadatiDocumentoFascicoloAttoDecreto(richiesta, accessoApplicativo);
			Risposta_modifyMetadatiDocumentoFascicoloAttoDecreto_type   response_type = response.getRisposta_modifyMetadatiDocumentoFascicoloAttoDecreto();
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			TraceLogger.debugLog("Client.modifyMetadatiDocumentoFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());
			}
		 else {
			//Se la lettura  Metadati Documento da dembil � andata male 
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAttoDecreto lettura Metadati ESITO KO", this.getClass());
			UtilResponseClient.setEsito(responseMetadataType.getEsito(), responseMetadataType.getErrorList(), responseDEMBILClient);
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAttoDecreto	.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());
			
		}


		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "modifyMetadatiDocumentoFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "modifyMetadatiDocumentoFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}

	
	
	


	
	
	
	
	public  ResponseDEMBILClient removeDocumentoAllegatoDecretoIGB(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.removeDocumentoAllegatoDecretoIGB.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.removeDocumentoAllegatoDecretoIGB.creaRequest", this.getClass());
			Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB richiesta = new Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB();
			Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB_type  richiestaType = new Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB_type();
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo())); //FAD
			richiestaType.setIdDocumentoFascicoloAllegatoDecretoIGB(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento())); //FAD
			richiesta.setRichiesta_removeDocumentoFascicoloAllegatoDecretoIGB(richiestaType);//FAD

			TraceLogger.infoLog("Client.removeDocumentoAllegatoDecretoIGB.fine.creaRequest", this.getClass());
			
			Risposta_removeDocumentoFascicoloAllegatoDecretoIGB  response= stub.removeDocumentoAllegatoDecretoIGB(richiesta, accessoApplicativo);
			Risposta_removeDocumentoFascicoloAllegatoDecretoIGB_type   response_type = response.getRisposta_removeDocumentoFascicoloAllegatoDecretoIGB();
			TraceLogger.infoLog("Client.removeDocumentoAllegatoDecretoIGB.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			TraceLogger.debugLog("Client.removeDocumentoAllegatoDecretoIGB.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "removeDocumentoAllegatoDecretoIGB "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "removeDocumentoAllegatoDecretoIGB ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}



	public  ResponseDEMBILClient modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			DocumentiRedTO doc = (DocumentiRedTO) requestDEMBILClient.getInputTO();
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.creaRequest", this.getClass());

			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.creaRequest lettura Metadati ", this.getClass());
			Richiesta_getDocumentoFascicoloAllegatoDecretoIGB richiestaMetaData = new Richiesta_getDocumentoFascicoloAllegatoDecretoIGB();
			Richiesta_getDocumentoFascicoloAllegatoDecretoIGB_type  richiestaMetaDataType = new Richiesta_getDocumentoFascicoloAllegatoDecretoIGB_type();
			richiestaMetaDataType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiestaMetaDataType.setIdDocumento(UtilRequestClient.createGuid(doc.getId().getCodiGuidDocumento()));
			richiestaMetaDataType.setTipoEstrazioneDocumento(UtilRequestClient.createTipoEstrazioneType(DEMBILConstants.TIPO_ESTRAZIONE_METADATA));
			richiestaMetaData.setRichiesta_getDocumentoFascicoloAllegatoDecretoIGB(richiestaMetaDataType);//FAD
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.fine.creaRequest lettura Metadati ", this.getClass());
			
			Risposta_getDocumentoFascicoloAllegatoDecretoIGB  responseMetadata= stub.getDocumentoFascicoloAllegatoDecretoIGB(richiestaMetaData, accessoApplicativo);
			Risposta_getDocumentoFascicoloAllegatoDecretoIGB_type  responseMetadataType= responseMetadata.getRisposta_getDocumentoFascicoloAllegatoDecretoIGB();
						
			if (responseMetadataType.getEsito().getValue().equals(ESITO_OK)){
				DocumentoFascicoloAllegatoDecretoIGB_type dettaglio = responseMetadataType.getDettaglioDocumento();
				
				Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB richiesta = new Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB();
				Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB_type  richiestaType = new Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB_type();
				richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo())); 
				richiestaType.setIdDocumento(UtilRequestClient.createGuid(doc.getId().getCodiGuidDocumento()));
				richiestaType.setAttivo(dettaglio.getAttivo());
				if (doc.getFlagVisibilitaCdc01().intValue()==0){
					richiestaType.setDaInviare(DEMBILConstants.FLAG_DAINVIARE_NO_VISIBILITA_CORTE);
				}
				else{
					richiestaType.setDaInviare(DEMBILConstants.FLAG_DAINVIARE_VISIBILITA_CORTE);
				}
				richiestaType.setCondivisibile(dettaglio.getCondivisibile());
				richiestaType.setDocumentoMetadata(dettaglio.getMetadatiDocumento());
				
				richiesta.setRichiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB(richiestaType);
				
				TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.fine.creaRequest", this.getClass());
				
				Risposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB  response= stub.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB(richiesta, accessoApplicativo);
				Risposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB_type   response_type = response.getRisposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB();
				TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.fine.crea.Risposta", this.getClass());
				
				UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
				TraceLogger.debugLog("Client.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

			}
		 else {
			//Se la lettura  Metadati Documento da dembil � andata male 
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB lettura Metadati ESITO KO", this.getClass());
			UtilResponseClient.setEsito(responseMetadataType.getEsito(), responseMetadataType.getErrorList(), responseDEMBILClient);
			TraceLogger.infoLog("Client.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());
			
		}

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}

	
	/*FINE FASCICOLO ATTO DECRETO*/


	/*INIZIO FASCICOLI SIPATR*/

	
	public  ResponseDEMBILClient getFascicoloAttoAllFascicoliSipatr(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.getFascicoliSipatr.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.getFascicoliSipatr.creaRequest", this.getClass());
			Richiesta_getFascicoloAttoDecreto richiesta = new Richiesta_getFascicoloAttoDecreto();
			Richiesta_getFascicoloAttoDecreto_type  richiestaType = new Richiesta_getFascicoloAttoDecreto_type();
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo())); //FAD
			richiestaType.setTipoEstrazioneFascicolo(UtilRequestClient.createTipoEstrazioneType(TIPO_ESTRAZIONE_DATA));  //NESSUNA ESTRAZIONE METADATI FAD
			CriteriaFascicoliSIPATR_type criteriaFascicoliSIPATR_type = new CriteriaFascicoliSIPATR_type();
			criteriaFascicoliSIPATR_type.setTipoEstrazioneFascicolo(UtilRequestClient.createTipoEstrazioneType(TIPO_ESTRAZIONE_METADATA));  //ESTRAZIONE DATA E METADATI FASCICOLI SIPATR
			richiestaType.setFascicoliSIPATRCriteria(criteriaFascicoliSIPATR_type);
			CriteriaDocumentiAttoDecreto_type param = new CriteriaDocumentiAttoDecreto_type();
			param.setShowPreview(true);
			param.setTipoElenco(TipoElenco_type.ALL);
			param.setTipoEstrazioneElenco(TipoEstrazione_type.METADATA);
			CriteriaDocumentiFascicoloIGB_type param1 = new CriteriaDocumentiFascicoloIGB_type();
			param1.setShowPreview(true);
			param1.setTipoElenco(TipoElenco_type.ALL);
			param1.setTipoEstrazioneElenco(TipoEstrazione_type.METADATA);
			richiestaType.setAttoDecretoDocumentCriteria(param);
			richiestaType.setDecretoIGBDocumentCriteria(param1);
			richiesta.setRichiesta_getFascicoloAttoDecreto(richiestaType);
			
			TraceLogger.infoLog("Client.getFascicoliSipatr.fine.creaRequest", this.getClass());
			
			Risposta_getFascicoloAttoDecreto  response= stub.getFascicoloAttoDecreto(richiesta, accessoApplicativo);
			  
			TraceLogger.infoLog("Client.getFascicoliSipatr.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response.getEsito(), response.getErrorList(), responseDEMBILClient);
			if (response.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.getFascicoliSipatr ESITO OK", this.getClass());
				responseDEMBILClient.setOutputTO(UtilResponseClient.createDettaglioFasicolo(response.getDettaglioFascicolo()));
/*				FascicoloAttoDecreto_type fascicoloAttoDecreto_type=response.getDettaglioFascicolo();
				FascicoloSIPATR_type[] rf= fascicoloAttoDecreto_type.getFascicoliSIPATR();
				
				List<AbstractDemTO> listaFascicoli = new ArrayList<AbstractDemTO>();
				if (rf!=null){
					for (int i = 0; i < rf.length; i++) {
						FascicoloSIPATR_type fascicoloSIPATR_type = rf[i];
						FascicoloSipatrTO fsipatr= UtilResponseClient.createFascicoloPatrimonio(fascicoloSIPATR_type);
//						fsipatr.setAmministrazione(UtilResponseClient.createCodiceDescrizione(fascicoloSIPATR_type.getDatiFascicolo().getAmministrazione()));
//						fsipatr.setAttivo(fascicoloSIPATR_type.getAttivo());
//						fsipatr.setStatoFascicoloDocumentale(fascicoloSIPATR_type.getStatoFascicoloDocumentale().getValue());
//						fsipatr.setDaInviare(fascicoloSIPATR_type.getDaInviare());
//						fsipatr.setDataCreazione(UtilResponseClient.createFormattedDate(fascicoloSIPATR_type.getDataCreazione()));
//						fsipatr.setDescrizione(fascicoloSIPATR_type.getDescrizione());
//						fsipatr.setIdentificativoSIPATR(fascicoloSIPATR_type.getDatiFascicolo().getIdentificativoSIPATR());
//						fsipatr.setIdentificativoSIPATR(fascicoloSIPATR_type.getIdFascicoloSIPATR().toString());
//						fsipatr.setRagioneria(UtilResponseClient.createCodiceDescrizione(fascicoloSIPATR_type.getDatiFascicolo().getRagioneria()));
//						fsipatr.setSistemaProduttore(fascicoloSIPATR_type.getSistemaProduttore());
//						fsipatr.setStatoFascicoloSIPATR(fascicoloSIPATR_type.getDatiFascicolo().getStatoFascicoloSIPATR());
						listaFascicoli.add(fsipatr);
					}
				}
				responseDEMBILClient.setListoutputTO(listaFascicoli);*/

				}
			TraceLogger.debugLog("Client.getFascicoliSipatr.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getFascicoliSipatr "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getFascicoliSipatr ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}

	
	
	
	public  ResponseDEMBILClient getFascicoloSipatr(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.getFascicoloSipatr.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
			
			
			FascicoloSipatrTO fsipatr = (FascicoloSipatrTO)requestDEMBILClient.getInputTO();
			
			TraceLogger.infoLog("Client.getFascicoloSipatr.creaRequest", this.getClass());
			Richiesta_getFascicoloSIPATRAttoDecreto richiesta = new Richiesta_getFascicoloSIPATRAttoDecreto();
			Richiesta_getFascicoloSIPATRAttoDecreto_type  richiestaType = new Richiesta_getFascicoloSIPATRAttoDecreto_type();
			
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(fsipatr.getIdFascicoloFAD()));
			richiestaType.setIdFascicoloSIPATR(UtilRequestClient.createGuid(fsipatr.getIdFascicoloSipatr()));
			richiestaType.setTipoEstrazioneFascicolo(UtilRequestClient.createTipoEstrazioneType(requestDEMBILClient.getTipoEstrazioneFascicolo()));
			CriteriaDocumentiSIPATR_type criteria = new CriteriaDocumentiSIPATR_type();
			criteria.setShowPreview(true);
			criteria.setTipoEstrazioneElenco(TipoEstrazione_type.DATA);
			criteria.setTipoElenco(TipoElenco_type.ALL);
			richiestaType.setDocumentCriteria(criteria);
			richiesta.setRichiesta_getFascicoloSIPATRAttoDecreto(richiestaType);
			
			Risposta_getFascicoloSIPATRAttoDecreto  response= stub.getFascicoloSIPATRAttoDecreto(richiesta, accessoApplicativo);
			Risposta_getFascicoloSIPATRAttoDecreto_type response_type=response.getRisposta_getFascicoloSIPATRAttoDecreto();
			  
			TraceLogger.infoLog("Client.getFascicoloSipatr.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			if (response_type.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.getFascicoloSipatr ESITO OK", this.getClass());
				FascicoloSIPATR_type dettaglioFascicolo = response_type.getDettaglioFascicolo(); 
				DocumentoFascicoloSIPATR_type[] dsipatr =  dettaglioFascicolo.getDocumenti();
				List<DocumentTO> listaDocumenti = new ArrayList<DocumentTO>();
				for (int i = 0; i < dsipatr.length; i++) {
					DocumentoFascicoloSIPATR_type documentoFascicoloSIPATR_type = dsipatr[i];
					DocumentTO documento = UtilResponseClient.createDocument(documentoFascicoloSIPATR_type);
					documento.setIdFascicolo(fsipatr.getIdFascicoloFAD());
					documento.setIdSottoFascicolo(fsipatr.getIdFascicoloSipatr());
//					documento.setIdDocumento(documentoFascicoloSIPATR_type.getIdDocumento().getGuid());
//					documento.setTipoDocumento(UtilResponseClient.createCodiceDescrizione(documentoFascicoloSIPATR_type.getTipoDocumento().getCodice(),documentoFascicoloSIPATR_type.getTipoDocumento().getDescrizione()));
//					documento.setDescrizione(documentoFascicoloSIPATR_type.getDescrizione());
//					documento.setDataCreazione(UtilResponseClient.createFormattedDate(documentoFascicoloSIPATR_type.getDataCreazione()));
//					documento.setCondivisibile(documentoFascicoloSIPATR_type.getCondivisibile());
//					documento.setAttivo(documentoFascicoloSIPATR_type.getAttivo());
//					documento.setSistemaProduttore(documentoFascicoloSIPATR_type.getSistemaProduttore());
//					documento.setIsDocumentoOriginale(documentoFascicoloSIPATR_type.getIsDocumentoOriginale());
//					documento.setIsDocumentoTrattato(documentoFascicoloSIPATR_type.getIsDocumentoTrattato());
//					documento.setTicketArchiviazione(documentoFascicoloSIPATR_type.getTicketArchiviazione());
//					//Metadata
//					documento.setNote(documentoFascicoloSIPATR_type.getMetadatiDocumento().getNote());
//					documento.setDataAnnullamento(UtilResponseClient.createFormattedDate(documentoFascicoloSIPATR_type.getMetadatiDocumento().getDataAnnullamento()));
//					documento.setDataChiusura(UtilResponseClient.createFormattedDate(documentoFascicoloSIPATR_type.getMetadatiDocumento().getDataChiusura()));
//					documento.setDataDocumento(UtilResponseClient.createFormattedDate(documentoFascicoloSIPATR_type.getMetadatiDocumento().getDataDocumento()));
//					documento.setProtocollo(UtilResponseClient.createProocollo(documentoFascicoloSIPATR_type.getMetadatiDocumento().getProtocollo()));
//					documento.setNote(documentoFascicoloSIPATR_type.getMetadatiDocumento().getNote());
//					//Metadata
//					
//					//Documento File
//					DocumentContentTO documentContent = new DocumentContentTO();
//					documentContent.setDescrizione(documentoFascicoloSIPATR_type.getDescrizione());
//					documentContent.setFileName(documentoFascicoloSIPATR_type.getFileName());
//					documentContent.setFirmato(documentoFascicoloSIPATR_type.getFirmato());
//					byte[] bhash=null;
//					bhash = IOUtils.toByteArray(documentoFascicoloSIPATR_type.getHash().getInputStream());
//					documentContent.setHash(bhash);
//					documentContent.setIdDocumento(documentoFascicoloSIPATR_type.getIdDocumento().getGuid());
//					documentContent.setLength(documentoFascicoloSIPATR_type.getLength());
//					documentContent.setMimeType(documentoFascicoloSIPATR_type.getMimeType());
//					documento.setDocumentoContent(documentContent);
//					
//					//Documento File
//					
//					//Documento Origine
//					if (documento.getIsDocumentoTrattato()){
//						documento.setDocumentoFileOrigine(UtilResponseClient.createDocumentFile(documentoFascicoloSIPATR_type.getDocumentoOrigine()));
//					}
//					//Documento Trattato
//					
//					if (documento.getIsDocumentoOriginale()){
//						OperazioneDocumentale_type opDoc =documentoFascicoloSIPATR_type.getOperazione();
//						if (opDoc != null){
//						documento.setTipoOperazione(opDoc.getTipoOperazione().getValue());
//						documento.setEsitoOperazione(opDoc.getEsitoOperazione().getValue());
//						documento.setDocumentoFileOperazione(UtilResponseClient.createDocumentFile(opDoc.getDocumentoOperazione()));
//						}
//					}
					
					listaDocumenti.add(documento);
					
				}
				fsipatr.setDocumenti(listaDocumenti);
				responseDEMBILClient.setOutputTO(fsipatr);
			}
			TraceLogger.debugLog("Client.getFascicoloSipatr.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(ClassCastException ccE){
			TraceLogger.errorLog("Errore nella creazione della Risposta o della richiesta " + "getFascicoloSipatr ", this.getClass(),ccE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,ccE.getMessage()));
		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getFascicoloSipatr "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "getFascicoloSipatr ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}
	
	

	
	public  ResponseDEMBILClient downloadDocumentoFascicoloSIPATRAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.creaRequest", this.getClass());
			Richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto richiesta = new Richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto();
			Richiesta_downloadDocumentoFascicoloDecretoSIPATR_type richiestaType = new Richiesta_downloadDocumentoFascicoloDecretoSIPATR_type();
			richiestaType.setIdDocumento(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento()));
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiestaType.setIdFascicoloSIPATR(UtilRequestClient.createGuid(requestDEMBILClient.getIdSottofascicolo()));
			richiesta.setRichiesta_downloadDocumentoFascicoloSIPATRAttoDecreto(richiestaType);
						
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_downloadDocumentoFascicoloSIPATRAttoDecreto  response= stub.downloadDocumentoFascicoloSIPATRAttoDecreto(richiesta, accessoApplicativo);
			  
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.fine.crea.Risposta", this.getClass());

			Risposta_downloadDocumentoFascicoloDecretoSIPATR_type  response_type= response.getRisposta_downloadDocumentoFascicoloSIPATRAttoDecreto();

			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			if (response_type.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto ESITO OK", this.getClass());
				DocumentoContent_type documentoContent_type=response_type.getDocumentoContent();				if (documentoContent_type!= null){
					responseDEMBILClient.setOutputTO(UtilResponseClient.createDocumentContent(documentoContent_type));
				}
			}
			TraceLogger.debugLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloSIPATRAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloSIPATRAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}



	public  ResponseDEMBILClient downloadDocumentoFascicoloAllegatoDecretoIGB(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.creaRequest", this.getClass());
			Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB richiesta = new Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB();
			Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB_type richiestaType = new Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB_type();
			richiestaType.setIdDocumento(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento()));
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiesta.setRichiesta_downloadDocumentoFascicoloAllegatoDecretoIGB(richiestaType);
						
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_downloadDocumentoFascicoloAllegatoDecretoIGB  response= stub.downloadDocumentoFascicoloAllegatoDecretoIGB(richiesta, accessoApplicativo);
			  
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.fine.crea.Risposta", this.getClass());

			Risposta_downloadDocumentoFascicoloAllegatoDecretoIGB_type  response_type= response.getRisposta_downloadDocumentoFascicoloAllegatoDecretoIGB();

			UtilResponseClient.setEsito(response_type.getEsito(), response_type.getErrorList(), responseDEMBILClient);
			if (response_type.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto ESITO OK", this.getClass());
				DocumentoContent_type documentoContent_type=response_type.getDocumentoContent();
				if (documentoContent_type!= null){
					responseDEMBILClient.setOutputTO(UtilResponseClient.createDocumentContent(documentoContent_type));
				}
			}
			TraceLogger.debugLog("Client.downloadDocumentoFascicoloSIPATRAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloSIPATRAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloSIPATRAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}


	
	
	
	/*FINE FASCICOLO ATTO DECRETO*/
	
	
	public  ResponseDEMBILClient getDocumentoFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_getDocumentoFascicoloAttoDecreto richiesta = new Richiesta_getDocumentoFascicoloAttoDecreto();
			Richiesta_getDocumentoFascicoloAttoDecreto_type  richiestaType = new Richiesta_getDocumentoFascicoloAttoDecreto_type();
			richiestaType.setIdDocumento(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento()));
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiestaType.setTipoEstrazioneDocumento(TipoEstrazione_type.DATA);
			richiestaType.setShowPreview(true);
			richiesta.setRichiesta_getDocumentoFascicoloAttoDecreto(richiestaType);
						
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_getDocumentoFascicoloAttoDecreto_type response= stub.getDocumentoFascicoloAttoDecreto(richiesta, accessoApplicativo).getRisposta_getDocumentoFascicoloAttoDecreto();
			
			  
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response.getEsito(), response.getErrorList(), responseDEMBILClient);
			if (response.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto ESITO OK", this.getClass());
				responseDEMBILClient.setOutputTO(UtilResponseClient.createDocument(response.getDettaglioDocumento()));
	//			return response.getDettaglioDocumento().getOperazione().getEsitoOperazione().getValue();
			}
			TraceLogger.debugLog("Client.downloadDocumentoFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}



	public  String getEsitoOperazione(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_getDocumentoFascicoloAttoDecreto richiesta = new Richiesta_getDocumentoFascicoloAttoDecreto();
			Richiesta_getDocumentoFascicoloAttoDecreto_type  richiestaType = new Richiesta_getDocumentoFascicoloAttoDecreto_type();
			richiestaType.setIdDocumento(UtilRequestClient.createGuid(requestDEMBILClient.getIdDocumento()));
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));
			richiestaType.setTipoEstrazioneDocumento(TipoEstrazione_type.METADATA);
			richiesta.setRichiesta_getDocumentoFascicoloAttoDecreto(richiestaType);
						
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_getDocumentoFascicoloAttoDecreto_type response= stub.getDocumentoFascicoloAttoDecreto(richiesta, accessoApplicativo).getRisposta_getDocumentoFascicoloAttoDecreto();
			
			  
			TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response.getEsito(), response.getErrorList(), responseDEMBILClient);
			if (response.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto ESITO OK", this.getClass());
				TraceLogger.infoLog("Client.downloadDocumentoFascicoloAttoDecreto Esito Operazione" + response.getDettaglioDocumento().getOperazione().getEsitoOperazione().getValue(), this.getClass());
				return response.getDettaglioDocumento().getOperazione().getEsitoOperazione().getValue();
			}
			TraceLogger.debugLog("Client.downloadDocumentoFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "downloadDocumentoFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return "KO";
	}



	public  ResponseDEMBILClient copyFascicoloAttoDecreto(RequestDEMBILClient requestDEMBILClient){
		
		ResponseDEMBILClient responseDEMBILClient = new ResponseDEMBILClient (ESITO_KO,DESC_ESITO_KO);
		
		try {
			TraceLogger.infoLog("Client.copyFascicoloAttoDecreto.inizio", this.getClass());
			InterfacciaAttoDecretoDEMBIL stub = requestDEMBILClient.getStub();
			AccessoApplicativo accessoApplicativo= requestDEMBILClient.getAccessoApplicativo();
	
			TraceLogger.infoLog("Client.copyFascicoloAttoDecreto.creaRequest", this.getClass());
			Richiesta_copyFascicoloAttoDecreto richiesta = new Richiesta_copyFascicoloAttoDecreto();
			Richiesta_copyFascicoloAttoDecreto_type  richiestaType = new Richiesta_copyFascicoloAttoDecreto_type();
			richiestaType.setIdFascicoloAttoDecreto(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicoloDestinazione()));
			richiestaType.setIdFascicoloAttoDecretoOrigine(UtilRequestClient.createGuid(requestDEMBILClient.getIdFascicolo()));;
			richiesta.setRichiesta_copyFascicoloAttoDecreto(richiestaType);
						
			TraceLogger.infoLog("Client.copyFascicoloAttoDecreto.fine.creaRequest", this.getClass());
			
			Risposta_copyFascicoloAttoDecreto_type response= stub.copyFascicoloAttoDecreto(richiesta, accessoApplicativo).getRisposta_copyFascicoloAttoDecreto();
			
			  
			TraceLogger.infoLog("Client.copyFascicoloAttoDecreto.fine.crea.Risposta", this.getClass());
			
			UtilResponseClient.setEsito(response.getEsito(), response.getErrorList(), responseDEMBILClient);
			if (response.getEsito().getValue().equals(ESITO_OK)){
				TraceLogger.infoLog("Client.copyFascicoloAttoDecreto ESITO OK", this.getClass());
				responseDEMBILClient.setOutputTO(UtilResponseClient.createDettaglioFasicolo(response.getDettaglioFascicolo()));
	//			return response.getDettaglioDocumento().getOperazione().getEsitoOperazione().getValue();
			}
			TraceLogger.debugLog("Client.copyFascicoloAttoDecreto.fine esito:" + responseDEMBILClient.getEsitoTo().getCodice() + "-"+ responseDEMBILClient.getEsitoTo().getDescrizione(), this.getClass());

		} catch(RemoteException rE){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "copyFascicoloAttoDecreto "+"Remote exception", this.getClass(),rE);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,rE.getMessage()));
		} catch(Throwable t){
			TraceLogger.errorLog("SERVIZIO DEMBIL ERRORE " + "copyFascicoloAttoDecreto ", this.getClass(),t);
			responseDEMBILClient.setEsitoTo(new EsitoTO(CODI_FAUL_GENERICO_DEMBIL,t.getMessage()));
		}
		return responseDEMBILClient;
	}




}



