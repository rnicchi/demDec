package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiBOId;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.IterFirmaDecretoBO;
import it.almavivaitalia.bilancio.commons.manager.UtenteManager;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.manager.exception.ObjectNotFoundException;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoConversione_type;
import it.mef.bilancio.demdec.dao.DocumentiDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.dao.InvioAlleFirmeDao;
import it.mef.bilancio.demdec.dao.IterFirmaDecretoDao;
import it.mef.bilancio.demdec.manager.DocumentiManager;
import it.mef.bilancio.demdec.manager.IterFirmaDecretoManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.InterfacciaOperazioniDocumentaliClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.RequestOpeDocuClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseOpeDocuClient;
import it.mef.bilancio.demdec.servizi.pkbox.PKBoxParameter;
import it.mef.bilancio.demdec.servizi.pkbox.SignDocument;
import it.mef.bilancio.demdec.servizi.pkbox.SignerParameter;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.to.CampoFirmaTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.DocumentiTOId;
import it.mef.bilancio.demdec.to.DocumentiViewTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.utils.PdfAttoDecretoAddFirme;
import it.mef.bilancio.demdec.utils.PdfAttoDecretoConFirme;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
//


public class DocumentiManagerImpl extends AbstractDemManagerImpl implements
		DocumentiManager {
	
	@Autowired
	private DocumentiDao documentiDao;
	
	@Autowired
	private IterFirmaDecretoDao iterFirmaDecretoDao;
	
	@Autowired
	private IterFirmaDecretoManager iterFirmaDecretoManager;
	
	@Autowired
	private InvioAlleFirmeDao invioAlleFirmeDao;
	
	@Autowired 
	private UtenteManager utenteManager;
	
	@Autowired
	private FascicoloDao fascicoloDao;

	/**
	 * Il metodo restituisce la lista degli Atto Decreto nello stato IN FIRMA in carico all'utente loggato
	 * per FIRMA e BOLLINATURA
	 */
	@Override
	public List<DocumentiViewTO> listADToSignByLoggedUser(Utente utenteInSessione) throws Throwable {

		return (List<DocumentiViewTO>) getDozerDriver().mapList(documentiDao.loadADToSignByLoggedUser(utenteInSessione), DocumentiViewTO.class, "Documenti");
	}
	
	/**
	 * Il metodo restituisce la lista degli Atto Decreto nello stato IN FIRMA in carico all'utente loggato
	 * per SIGLA o VERIFICA
	 */
	@Override
	public List<DocumentiViewTO> listADToSignOrVerifyByLoggedUser(Utente utenteInSessione, String signOrVerify) throws Throwable {
			
		return (List<DocumentiViewTO>) getDozerDriver().mapList(documentiDao.loadADToSignOrVerifyByLoggedUser(utenteInSessione, signOrVerify), DocumentiViewTO.class, "Documenti");
	}


	@Override
	public ResponseDEMBILClient wsDownloadDocumentoFascicoloAttoDecreto(String guidFascicolo, String guidDocumento) throws Throwable {
		ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		requestDEMBILClient.setIdFascicolo(guidFascicolo);
		requestDEMBILClient.setIdDocumento(guidDocumento);
		
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.downloadDocumentoFascicoloAttoDecreto(requestDEMBILClient);
		
		return resp;
	}

	@Override
	public ResponseDEMBILClient wsDownloadDocumentoFascicoloAllegatoIGB(
			String idFascicolo, String idDocumento) throws Throwable {
		ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		requestDEMBILClient.setIdFascicolo(idFascicolo);
		requestDEMBILClient.setIdDocumento(idDocumento);
		
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.downloadDocumentoFascicoloAllegatoDecretoIGB(requestDEMBILClient);
		
		return resp;
	}

	@Override
	public ResponseDEMBILClient wsDownloadDocumentoFascicoloSIPATRAttoDecreto(
			String idFascicolo, String idFascicoloSIPATR, String idDocumento)
			throws Throwable {
		ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		requestDEMBILClient.setIdFascicolo(idFascicolo);
		requestDEMBILClient.setIdSottofascicolo(idFascicoloSIPATR);
		requestDEMBILClient.setIdDocumento(idDocumento);
		
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.downloadDocumentoFascicoloSIPATRAttoDecreto(requestDEMBILClient);
		
		return resp;
	}


	/**
	 * 1 - chiama wsDownloadDocumentoFascicoloAttoDecreto per scaricare il documento da firmare
	 * 2 - chiama getCurrentIFDByIdFascicolo(documentiViewTO.getNumeIdFascicolo()) per avere l'oggetto IterFirmaDecretoCorrente dal quale ricavo il "tag della frima"
	 * 3 - istanzia i due oggetti della libreria PkBOX per eseguire la firma del documento e setta i parmaetri necessari
	 * 4 - chiama il metodo di firma  digestVisibleSign(signerParam) che torna un oggetto di tipo SignerParameter con all'interno l'esito dell'operazione, il vecchio file e il file firmato
	 * 5 - chiama wsupload che fa l'upload del file firmato 
	 */
	@Override
	public IterFirmaDecretoTO firma(DocumentiViewTO documentiViewTO, String tkPin, Utente utenteInSessione,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Integer maxTranSize) throws Throwable {
		ResponseDEMBILClient responseDownload = wsDownloadDocumentoFascicoloAttoDecreto(documentiViewTO.getCodiGuidFascicolo(), documentiViewTO.getCodiGuidDocumento());
		if((responseDownload.getEsitoTo().getCodice().equalsIgnoreCase(DEMBILConstants.ESITO_OK))){
				
					//mi serve per il tag della firma
					IterFirmaDecretoBO ifd = iterFirmaDecretoDao.getCurrentIFDByIdFascicolo(documentiViewTO.getNumeIdFascicolo());
				
					String tagFirma = ifd.getAnagFirmatari().getCodiTagFirma();
					if (ifd.getAnagFirmatari().getId().equalsIgnoreCase(Constants.TAG_UFFICIO)){
						tagFirma += "_"+utenteInSessione.getUtenteProfiloInUso().getAnagUffici().getId();
					}else if (ifd.getAnagFirmatari().getId().equalsIgnoreCase(Constants.TAG_MINISTRO)){
						tagFirma += "_"+utenteInSessione.getUtenteProfiloInUso().getAnagAmminDem().getId().getAmmin();
					}

					PKBoxParameter pkBoxParam = leggiParametriInputPkbox();
				    
					/* La chiamata al metodo di firma con utilizzo OTP deve essere effettuata nel seguente modo: */
					/* recupero dalla sessione le variabili relative all'utente (alias, name, pin) */
					SignerParameter signerParam = SignDocument.getSignerByOAMVariables(httpServletRequest, httpServletResponse);
					/* es: https://pkcubecoll.tesoro.it:8443/pkserver/servlet/Deliberahandler */
					signerParam.getPkBoxParameter().setPkBoxHandler(pkBoxParam.getPkBoxHandler());
					/* es: /SECURE_PIN/securepin-col-sogei.crt*/
					signerParam.getPkBoxParameter().setSecurePinFilePath(pkBoxParam.getSecurePinFilePath());
					/* es: /SECURE_PIN/opt-col-sogei.properties*/
					signerParam.getPkBoxParameter().setOtpPropertiesFilePath(pkBoxParam.getOtpPropertiesFilePath());
					/* es: otp-rgs*/
					signerParam.getPkBoxParameter().setFirmaBaseKey(pkBoxParam.getFirmaBaseKey());
					/* es: 12345678 */
					signerParam.getPkBoxParameter().setFirmaBaseKeyPin(pkBoxParam.getFirmaBaseKeyPin());
					/* es: totp*/
					signerParam.getPkBoxParameter().setProvider(pkBoxParam.getProvider());
					
					String signLayout = "<Text>%cn% \r\n FIRMATO DIGITALMENTE </Text><FontStyle>1</FontStyle><TextAlign>1</TextAlign>";
					if (iterFirmaDecretoDao.ultimaFirma(documentiViewTO.getNumeIdFascicolo())){
						signLayout = "<Text>%cn% \r\n FIRMATO DIGITALMENTE \r\n %date%</Text><FontStyle>1</FontStyle><TextAlign>1</TextAlign>";
					}
					signerParam.setSignLayout(signLayout);
					DocumentContentTO docContent=(DocumentContentTO)responseDownload.getOutputTO();
					/* file da firmare */
					signerParam.setFileToBeSigned(docContent.getContent());
					/* tag */
					signerParam.setTag(tagFirma);
					/* pin digitato */
					signerParam.setTokenPin(tkPin);
//					signerParam.setAlias(signerParam.getAlias().substring(0, 16).concat("_FR"));
					/* Genero l'OTP con l'oggetto signerParam */
					signerParam = SignDocument.generateOTP(signerParam);
					/* start transaction per stabilire il numero di firme massime */
				
					signerParam = SignDocument.startTrans(signerParam, maxTranSize);
					signerParam = SignDocument.digestVisibleSign(signerParam);
						
					/* metodo di firma invisibile */
					//signerParam = SignDocument.digestInvisibleSign(signerParam);
					/* oppure metodo di firma visibile */
					
					
					if(signerParam.getReturnCode() != 0){
						
						String errore = signerParam.getDecodedErrorMessage();
						throw new ObjectNotFoundException(errore, Constants.ERROR_WS_FIRMA_DOCUMENT);
					}else{
						if (searchPropertyValueFromTabServ(Constants.SCRIVI_FILE).equalsIgnoreCase("1")){
							FileOutputStream file = new FileOutputStream("/appoggio/firmaRemota.pdf");
							file.write(signerParam.getSignedFile());
							file.flush();
							file.close();
						}
						
						docContent.setContent(signerParam.getSignedFile());
						
						ResponseDEMBILClient responseUpload = wsUpdateDocument(docContent, documentiViewTO.getCodiGuidFascicolo(), documentiViewTO.getCodiGuidDocumento());
						if(responseUpload.getEsitoTo().getCodice().equalsIgnoreCase(DEMBILConstants.ESITO_OK)){
							
							IterFirmaDecretoTO ifdTO = iterFirmaDecretoManager.updateIterFirma(documentiViewTO, CroTransTO.CRO_TRANS_FIRMA_DOCUMENTI);
							return ifdTO;
							
						}else{
							String errore = responseUpload.getEsitoTo().getDescrizione();
							throw new ObjectNotFoundException(errore, Constants.ERROR_WS_UPLOAD_DOCUMENT);
						}
						
					}
		
		}else{
			String errore = responseDownload.getEsitoTo().getDescrizione();
			throw new ObjectNotFoundException(errore, Constants.ERROR_WS_DOWNLOAD_DOCUMENT);
			
		}
	}

	
	
	/**
	 * Viene prodotto l'atto decreto con i campi firma:
	 * -lettura da tabella della lista dei campi firma 
	 * -richiamo al ws DEMBIL per il download dell'atto decreto
	 * -richiamo alla funzione che genera la pagina della firma e la concatena all'atto decreto
	 * -richiamo al ws adobe per la trasformazione in pdf/a
	 * -richiamo a pkbox  per la firma tecnica
	 * @return DocumentContentTO contenente il documento attodecreto con pagina della firma, PDF/A e con firma Tecnica pronto per 
	 * -update content sul documentale
	 * -aggiornare la tabella d_documenti e inserire i record dei firmatari su d_iter_decreto_firma
	 * -inviare e-mail
	 */
	@Override
	public DocumentContentTO generaAttoDecretoConFirma(String guidFascicolo,  String guidDocumento, Long numeIdFascicolo, Utente utenteInSessione) throws Throwable {
		
		ResponseDEMBILClient res= wsDownloadDocumentoFascicoloAttoDecreto(guidFascicolo, guidDocumento);
		
		DocumentContentTO dcTO= null;
		
		if (res.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){ 
		
			List<CampoFirmaTO> listFields = invioAlleFirmeDao.findListFirme(numeIdFascicolo);
			
			dcTO= (DocumentContentTO)res.getOutputTO();
			
			FascicoliBO fascicolo = fascicoloDao.loadById(numeIdFascicolo);
			String headerPaginaFirma = null;
			if(fascicolo != null){
				headerPaginaFirma = fascicolo.getDescSigla()+ " " + fascicolo.getNumeNumDecreto()+ " " + fascicolo.getEserciziDem().getId();
			}
			
			ResponseOpeDocuClient resp = convertToPDF(dcTO);
			if (resp.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){ 
				FileOutputStream out = new FileOutputStream("/appoggio/ConvertitoPDF.pdf");
				out.write(((DocumentContentTO)resp.getOutputTO()).getContent());
				out.flush();
				out.close();
				String metodoFirma = searchPropertyValueFromTabServ(Constants.TAB_SERV_METODO_FIRMA);
				ByteArrayInputStream isADPaginaFirme = null;
				if (metodoFirma.equalsIgnoreCase(Constants.OLD_METODO_FIRMA)){
					isADPaginaFirme = PdfAttoDecretoConFirme.createAttoDecretoConFirma(headerPaginaFirma, new ByteArrayInputStream(((DocumentContentTO)resp.getOutputTO()).getContent()), listFields);
				} else {
					isADPaginaFirme = PdfAttoDecretoAddFirme.createPdfConFirma(headerPaginaFirma, new ByteArrayInputStream(((DocumentContentTO)resp.getOutputTO()).getContent()), listFields);
				}
				
				dcTO.setFileName(dcTO.getFileName()+".pdf");
				dcTO.setMimeType("application/pdf");
				dcTO.setContent(IOUtils.toByteArray(isADPaginaFirme));
				dcTO.setFirmato(false);
				dcTO.setHash(null);
				dcTO.setLength(null);
				dcTO.setTipoCompressione(null);	
			} else {
				dcTO=new DocumentContentTO();
				dcTO.setErrore(" "+resp.getEsitoTo().getDescrizione());
			}
					
		}else{
			dcTO=new DocumentContentTO();
			dcTO.setErrore(" "+res.getEsitoTo().getDescrizione());
		}
		return dcTO;

	}

	

	@Override
	public ResponseDEMBILClient wsUpdateDocument(DocumentContentTO dcTO, String guidFascicolo, String guidDocumento) throws Throwable {
		ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		requestDEMBILClient.setIdFascicolo(guidFascicolo);
		requestDEMBILClient.setIdDocumento(guidDocumento);
		requestDEMBILClient.setInputTO(dcTO);
		ResponseDEMBILClient resp= client.updateContentDocumentoFascicoloAttoDecreto(requestDEMBILClient);
		
		return resp;
	}

	@Override
	public IterFirmaDecretoTO verifica(DocumentiViewTO documentiViewTO, Utente utenteInSessione) throws Throwable {
					
		IterFirmaDecretoTO ifdTO = iterFirmaDecretoManager.updateIterFirma(documentiViewTO, CroTransTO.CRO_TRANS_VERIFICA_DOCUMENTI);
		return ifdTO;
	}
	
	@Override
	public IterFirmaDecretoTO sigla(DocumentiViewTO documentiViewTO, Utente utenteInSessione, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Integer maxTranSize, Short croTransTo) throws Throwable {
		
		
		ResponseDEMBILClient responseDownload = wsDownloadDocumentoFascicoloAttoDecreto(documentiViewTO.getCodiGuidFascicolo(), documentiViewTO.getCodiGuidDocumento());
		if((responseDownload.getEsitoTo().getCodice().equalsIgnoreCase(DEMBILConstants.ESITO_OK))){
			
			//mi serve per il tag della firma
			IterFirmaDecretoBO ifd = iterFirmaDecretoDao.getCurrentIFDByIdFascicolo(documentiViewTO.getNumeIdFascicolo());
			
			//creo i due oggetti per la firma del documento
			SignerParameter signerParam = SignDocument.getSignerByOAMVariables(httpServletRequest, httpServletResponse);
			PKBoxParameter pkBoxParam = leggiParametriInputPkbox();// oggetto per la connessione pkbox
			String tagFirma = ifd.getAnagFirmatari().getCodiTagFirma();
			if (ifd.getAnagFirmatari().getId().equalsIgnoreCase(Constants.TAG_UFFICIO)){
				tagFirma += "_"+utenteInSessione.getUtenteProfiloInUso().getAnagUffici().getId();
			}else if (ifd.getAnagFirmatari().getId().equalsIgnoreCase(Constants.TAG_MINISTRO)){
				tagFirma += "_"+utenteInSessione.getUtenteProfiloInUso().getAnagAmminDem().getId().getAmmin();
			}else if(ifd.getAnagFirmatari().getId().equalsIgnoreCase(Constants.TAG_RAGIONIERE)){
				//ifd.getAnagFirmatari().setCodiTagFirma(ifd.getAnagFirmatari().getCodiTagFirma()+"_"+utenteInSessione.getUtenteProfiloInUso().getAnagAmminDem().getId().getAmmin());
//				String signLayout = "<Text>%g% %sn% \r\n Bollinato dal Ragioniere Generale dello Stato </Text><FontStyle>1</FontStyle><TextAlign>1</TextAlign>";
				String signLayout = "<Text>Bollinato dal Ragioniere Generale dello Stato</Text><FontStyle>1</FontStyle><TextAlign>1</TextAlign>";
				signerParam.setSignLayout(signLayout);
			}
			
			
			DocumentContentTO docContent=(DocumentContentTO)responseDownload.getOutputTO();
			signerParam.setFileToBeSigned(docContent.getContent());
			signerParam.setTag(tagFirma);
			signerParam.setTokenPin(utenteManager.findDeencryptedPinbyId(utenteInSessione.getUtente().getId()));
			
			signerParam.getPkBoxParameter().setPkBoxHandler(pkBoxParam.getPkBoxHandler());
			signerParam.getPkBoxParameter().setSecurePinFilePath(pkBoxParam.getSecurePinFilePath());
			signerParam.getPkBoxParameter().setProvider(pkBoxParam.getProvider());
			signerParam.getPkBoxParameter().setOtpPropertiesFilePath(pkBoxParam.getOtpPropertiesFilePath());
			signerParam.setAlias(signerParam.getAlias().substring(0, 16).concat("_AUTO"));
			signerParam = SignDocument.remoteInvisibleSign(signerParam);
			/* Genero l'OTP con l'oggetto signerParam */
//			signerParam = SignDocument.generateOTP(signerParam);
//			signerParam = SignDocument.startTrans(signerParam, maxTranSize);	
//			signerParam = SignDocument.digestInvisibleSign(signerParam);
		
			if(signerParam.getReturnCode() != 0){
				
				String errore = signerParam.getDecodedErrorMessage();
				throw new ObjectNotFoundException(errore, Constants.ERROR_WS_FIRMA_DOCUMENT);
			}else{
				
				if (searchPropertyValueFromTabServ(Constants.SCRIVI_FILE).equalsIgnoreCase("1")){
					FileOutputStream fo = new FileOutputStream("/appoggio/firmaAutomatica.pdf");
			    	fo.write(signerParam.getSignedFile());
			    	fo.flush();
			    	fo.close();
				}
		    	
				docContent.setContent(signerParam.getSignedFile());
				
				ResponseDEMBILClient responseUpload = wsUpdateDocument(docContent, documentiViewTO.getCodiGuidFascicolo(), documentiViewTO.getCodiGuidDocumento());
				
				if(responseUpload.getEsitoTo().getCodice().equalsIgnoreCase(DEMBILConstants.ESITO_OK)){
					
					IterFirmaDecretoTO ifdTO = iterFirmaDecretoManager.updateIterFirma(documentiViewTO, croTransTo);
					return ifdTO;
					
				}else{
					String errore = responseUpload.getEsitoTo().getDescrizione();
					throw new ObjectNotFoundException(errore, Constants.ERROR_WS_UPLOAD_DOCUMENT);
				}
				
			}
			
		}else{
			String errore = responseDownload.getEsitoTo().getDescrizione();
			throw new ObjectNotFoundException(errore, Constants.ERROR_WS_DOWNLOAD_DOCUMENT);
			
		}
	}
	
	
	private ResponseOpeDocuClient convertToPDF(DocumentContentTO to) throws Throwable {
		
		ParametriInput paramInput = leggiParametriInputDocConverter();
		RequestOpeDocuClient requestOpeDocuClient = new RequestOpeDocuClient(paramInput); 
		requestOpeDocuClient.setInputTO(to);
		requestOpeDocuClient.setTipoOperazioneDocumento(TipoConversione_type.PDF);
		InterfacciaOperazioniDocumentaliClient client = new InterfacciaOperazioniDocumentaliClient();
		return client.convertiDocumento(requestOpeDocuClient);
	}

	@Override
	public DocumentiTO getDocumentByIdDocumento(DocumentiTOId idDocumento) throws Throwable {
		DocumentiBOId boId = new DocumentiBOId(idDocumento.getFkNumeIdFascicolo(), idDocumento.getNumeIdDocumento());
		DocumentiBO doc = documentiDao.loadById(boId);
		return getDozerDriver().map(doc, DocumentiTO.class, "Documenti");
		
	}

	
	/**
	 * Il metodo restituisce la lisat dei documenti firmati, siglati, bollinati o verificati dall'utente loggato in base al parametro signOrVerify
	 */
	@Override
	public List<DocumentiViewTO> listSignedADByLoggedUser(Utente utenteInSessione, String signOrVerify) throws Throwable {
		
		return (List<DocumentiViewTO>) getDozerDriver().mapList(documentiDao.loadSignedOrVerifyedADByLoggedUser(utenteInSessione, signOrVerify), DocumentiViewTO.class, "Documenti");
	}

	@Override
	public ResponseDEMBILClient wsGetDocumentoFascicoloAttoDecreto(
			String guidFascicolo, String guidDocumento) throws Throwable {
		ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		requestDEMBILClient.setIdFascicolo(guidFascicolo);
		requestDEMBILClient.setIdDocumento(guidDocumento);
		
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		ResponseDEMBILClient resp= client.getDocumentoFascicoloAttoDecreto(requestDEMBILClient);
		
		return resp;
	}
	
}
