package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagFirmatariBO;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBOId;
import it.almavivaitalia.bilancio.commons.bo.DescDocumentoBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiBOId;
import it.almavivaitalia.bilancio.commons.bo.LettereIgbBO;
import it.almavivaitalia.bilancio.commons.bo.TipoDocumentoBO;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bilancio.commons.to.CronoValoriTO;
import it.almavivaitalia.bilancio.commons.utils.DateUtil;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.manager.exception.ObjectNotFoundException;
import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.almavivaitalia.web.sh.utils.Context;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.EsitoOperazione_type;
import it.mef.bilancio.demdec.dao.AmminRagDemDao;
import it.mef.bilancio.demdec.dao.AnagAmminDemDao;
import it.mef.bilancio.demdec.dao.AnagFirmatariDao;
import it.mef.bilancio.demdec.dao.AnagRagionerieDemDao;
import it.mef.bilancio.demdec.dao.DocumentiDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.dao.LettereIgbDao;
import it.mef.bilancio.demdec.dao.LettereTestiDao;
import it.mef.bilancio.demdec.dao.LettereTestiPersDao;
import it.mef.bilancio.demdec.dao.TipoDocumentoDao;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.LetterePreRegManager;
import it.mef.bilancio.demdec.manager.UploadDecManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.UtilRequestClient;
import it.mef.bilancio.demdec.servizi.pkbox.PKBoxParameter;
import it.mef.bilancio.demdec.servizi.pkbox.SignDocument;
import it.mef.bilancio.demdec.servizi.pkbox.SignerParameter;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentFileTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.to.AmminRagDemTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;
import it.mef.bilancio.demdec.to.LettereIgbTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;
import it.mef.bilancio.demdec.utils.Constants;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;



public abstract class LetterePreRegParentManagerImpl extends AbstractDemManagerImpl implements LetterePreRegManager{
	
	@Autowired
	FascicoloDao fascicoloDao;
	
	@Autowired
	AnagAmminDemDao anagAmminDemDao;
	
	@Autowired
	LettereTestiDao lettereTestiDao;
	
	@Autowired
	LettereIgbDao lettereIgbDao;
	
	@Autowired
	LettereTestiPersDao lettereTestiPersDao;
	
	@Autowired
	AnagFirmatariDao anagFirmatariDao;
	
	@Autowired
	UploadDecManager uploadDecManager;
	
	@Autowired 
	GestioneFadManager  gestioneFadManager;
	
	@Autowired
	private CronologicoManager cronologicoManager;
	
	@Autowired
	private DocumentiDao documentiDao;
	
	@Autowired
	private TipoDocumentoDao tipoDocumentoDao;
	
	@Autowired
	private AnagRagionerieDemDao anagRagionerieDemDao;
	
	@Autowired
	private AmminRagDemDao amminRagDemDao;
	
	@Override
	public List<FascicoliTO> findFascicoliFadLetterePreReg(FascicoliFadSearhTO to) throws Throwable {
		List<FascicoliTO> ret = getDozerDriver().mapList(fascicoloDao.findFascicoliFadLetterePreReg(to), FascicoliTO.class, "FascicoliFad");
		return ret;

	}
	
	@Override
	public List<AnagAmminDemTO> findAmministrazioniByIdFascicolo(Long idFascicolo)  throws Throwable{
		List<AnagAmminDemTO> listBO=anagAmminDemDao.findAmministrazioniByIdFascicolo(idFascicolo);
		return listBO;
		
	}

	@Override
	public String[] getLettereTestiByTipo(String tipoLettera) throws Throwable {
		return lettereTestiDao.getLettereTestiByTipo(tipoLettera);
	}

	@Override
	public String[] getLettereTestiByTipoBalanced(String tipoLettera) throws Throwable {
		return lettereTestiDao.getLettereTestiByTipoBalanced(tipoLettera);
	}
	
	@Override
	public LettereIgbTO getLetteraById(Long idLettera)  throws Throwable {
		
		LettereIgbBO bo=lettereIgbDao.loadById(idLettera);
		LettereIgbTO to=getDozerDriver().map(bo, LettereIgbTO.class, "LettereIgb");
		return to;
	}
	
	
	@Override
	public Blob getBlobByIdLettera(BigDecimal id) throws Throwable {
		// TODO Auto-generated method stub
		return lettereIgbDao.getBlobByIdLettera(id);
	}

	@Override
	public LettereIgbBO findByUK(LettereIgbTO lettera){
		LettereIgbBO bo=getDozerDriver().map(lettera, LettereIgbBO.class, "LettereIgb");
		
		LettereIgbBO old = lettereIgbDao.findByUK(bo.getFascicoli().getId(), bo.getAnagAmminDem().getId().getFkAnnoEse(), bo.getAnagAmminDem().getId().getNumeStp(), bo.getAnagAmminDem().getId().getNumeApp());
		
		return old;
	}
	
	
	@Override
	public List<LettereIgbTO> findLettereByCodiUfficioAndStatus(String codiUfficio, String status)  throws Throwable{
		
		List<LettereIgbBO> boList= lettereIgbDao.findLettereByCodiUfficioAndStatus(codiUfficio, status);
		List<LettereIgbTO> toList=getDozerDriver().mapList(boList, LettereIgbTO.class, "LettereIgb");
		
		return toList;
	}
	
	
	
	
	
	
	/**
	 * 1 - istanzia i due oggetti della libreria PkBOX per eseguire la firma del documento e setta i parmaetri necessari
	 * 2 - chiama il metodo di firma  digestVisibleSign(signerParam) che torna un oggetto di tipo SignerParameter con all'interno l'esito dell'operazione, il vecchio file e il file firmato
	 * 3 - chiama wsupload che fa l'upload della lettera firmata 
	 * 4 - aggiorna lo stato della lettera a 3, lettera firmata
	 */
	@Override
	public LettereIgbTO firmaLettera(LettereIgbTO letteraTo, String tkPin, Utente utenteInSessione, String nomeFunzione, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Integer maxTranSize) throws Throwable {
					SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
					
					//mi serve per il tag della firma
					AnagFirmatariBO firmatariBo=anagFirmatariDao.loadById(AnagFirmatariBO.class, Constants.TAG_UFFICIO);
					String tagFirma =firmatariBo.getCodiTagFirma();
					tagFirma += "_"+utenteInSessione.getUtenteProfiloInUso().getAnagUffici().getId();

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
					
//					if (iterFirmaDecretoDao.ultimaFirma(documentiViewTO.getNumeIdFascicolo())){//TODO chiedere se ci vuole la data
//						signLayout = "<Text>%cn% \r\n FIRMATO DIGITALMENTE \r\n %date%</Text><FontStyle>1</FontStyle><TextAlign>1</TextAlign>";
//					}
					signerParam.setSignLayout(signLayout);
					
				//	DocumentContentTO docContent=(DocumentContentTO)responseDownload.getOutputTO();
					/* file da firmare */
					//signerParam.setFileToBeSigned(docContent.getContent());
					Blob blob=letteraTo.getBinaIntLettera();
					int blobLength = (int) blob.length();  
	 			    byte[] blobAsBytes = blob.getBytes(1, blobLength);
					signerParam.setFileToBeSigned(blobAsBytes);
					
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
					
					DocumentContentTO docContent=null;
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
						
						docContent=new DocumentContentTO();
						docContent.setContent(signerParam.getSignedFile());
						
						String nomeFile=letteraTo.getFascicoli().getEserciziDem().getId()+"_"+letteraTo.getAnagAmminDem().getId().getNumeStpFormatted()+letteraTo.getAnagAmminDem().getId().getNumeAppFormatted()+"_"+sdf.format(letteraTo.getDataLettera())+".pdf";
						
						DocumentTO dcTo=popolaDocumentTO( letteraTo.getFascicoli(), docContent.getContent(), letteraTo.getAnagAmminDem(), nomeFile, "application/pdf");
						
						ResponseDEMBILClient responseUpload =uploadDecManager.uploadDocumento(dcTo, letteraTo.getAnagAmminDem(), letteraTo.getFascicoli(), "" );
						
						//ResponseDEMBILClient responseUpload = wsUpdateLetteraDocument(dcTo, letteraTo);
						
						if (responseUpload.getEsitoTo().getCodice().equalsIgnoreCase(DEMBILConstants.ESITO_OK)) {
							LettereIgbBO bo=aggiornaStatusLettera(letteraTo.getId(), Constants.LETTERA_FIRMATA, utenteInSessione.getUtente().getCodiUtente(),  nomeFunzione);
							if(bo!=null){
								return getDozerDriver().map(bo, LettereIgbTO.class, "LettereIgb");
							}
						}
						
					}
		
			        return null;
	}

	
	/*	//Servizio che salva su DemBil la lettera firmata
	@Override
	public ResponseDEMBILClient wsUpdateLetteraDocument(DocumentTO dcTO, LettereIgbTO letteraTo) throws Throwable {
			ParametriInput paramInput = leggiParametriInputDemBil();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		
		Hashtable<String, String> par = new Hashtable<String, String>();
		requestDEMBILClient.setParametriOperazione(par);
		
		requestDEMBILClient.setIdDocumentoOperazione(UtilRequestClient.createGuid().getGuid());
		
		requestDEMBILClient.setTipoOperazioneDocumento("0"); //nessun trattamento			
		
		InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
		requestDEMBILClient.setIdFascicolo(letteraTo.getFascicoli().getCodiGuidFascicolo());
		requestDEMBILClient.setIdDocumento(UtilRequestClient.createGuid().getGuid());
		requestDEMBILClient.setInputTO(dcTO);
		
		
		ResponseDEMBILClient resp= client.addDocumentoFascicoloAttoDecreto(requestDEMBILClient);
		
		if(resp.getEsitoTo().getCodice().equalsIgnoreCase(DEMBILConstants.ESITO_OK)){
			
			DocumentTO outObj=(DocumentTO) resp.getOutputTO();
			outObj.setDocumentoFileOperazione(new DocumentFileTO());
			
			
			outObj.getDocumentoFileOperazione().setIdDocumento(requestDEMBILClient.getIdDocumentoOperazione());
			
			saveDocumento ( outObj,  dcTO, letteraTo.getAnagAmminDem(), letteraTo.getFascicoli());
			
		}else{
			String errore = resp.getEsitoTo().getDescrizione();
			throw new ObjectNotFoundException(errore, Constants.ERROR_WS_UPLOAD_DOCUMENT);
		} 
		
		
		
		return resp;
		
	}*/
	
	
	protected DocumentTO popolaDocumentTO(FascicoliTO fascicoloTO, byte[] docContent, AnagAmminDemTO amm,  String fileName, String contentType) throws Throwable{
		
		DocumentTO docTo= new DocumentTO();
		
		docTo.setIdFascicolo(fascicoloTO.getCodiGuidFascicolo().toString());
		
		TipoDocumentoTO descDocTo=uploadDecManager.loadTipoDocById(Constants.TIPO_ALLEGATI_DECRETO); //((List<TipoDocumentoTO>)listManager.loadTipoDocumentoAD()).get(Integer.parseInt(form.getTipoDoc()));//gestioneFadManager.loadDescDocById(Integer.parseInt(form.getTipoDoc()));
		
		
		CodeDescriptionTO descDoc= new CodeDescriptionTO();
		descDoc.setCode(descDocTo.getId());
		descDoc.setDescription(descDocTo.getDescDescrizioneDoc());
		
		docTo.setTipoDocumento(descDoc);
		docTo.setAttivo(true);
		docTo.setCondivisibile(true);
		
		//controllo su visibilità del documento
		if(fascicoloTO.getFlagVisibilitaCdc01() == 1)
			docTo.setDaInviare(true);
		else
			docTo.setDaInviare(false);
		
		DocumentContentTO dc= new DocumentContentTO();
		dc.setContent(docContent);
	//	dc.setDescrizione(form.getDesc());
		dc.setFileName(fileName);
		dc.setMimeType(contentType);
		dc.setHash(UtilRequestClient.createHash(docContent));
		docTo.setDocumentoContent(dc);
		
		
		CodeDescriptionTO ammDescTo= new CodeDescriptionTO();
		
		if(amm != null){
			ammDescTo.setCode(amm.getId().getAmmin());
			ammDescTo.setDescription(amm.getDescAmm());
		}
		else {
			ammDescTo.setCode("999");
			ammDescTo.setDescription("999");
		}
		docTo.setAmministrazione(ammDescTo);
		docTo.setDataDocumento(DateUtil.getSysDate(Constants.DATE_SEPARATOR));
		
		CodeDescriptionTO ucbRts= new CodeDescriptionTO();
		
		if(amm != null){
			AmminRagDemTO rag = gestioneFadManager.findAmminRagDemByAnagAmminDemTO(amm);
			String r=StringUtils.leftPad(rag.getId().getNumeRag(), 4,Constants.PADDING_CHAR );
			ucbRts.setCode(r);
			ucbRts.setDescription(r);
		}
		else{
			ucbRts.setCode("");
			ucbRts.setDescription("");
		}
		
		docTo.setUcbRts(ucbRts);
		
		CodeDescriptionTO descDocumentoTo=new CodeDescriptionTO("8",null);
		docTo.setDescDocumento(descDocumentoTo);
		
	//	context.valorizeAudit(docTo, "gestioneFascicoloFAD");
		return docTo;
	}

	
	


}
