package it.mef.bilancio.demdec.servizi.client;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bsn.sh.utils.DateUtil;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoContent_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloSIPATR_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFile_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Esito_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloAttoDecreto_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataAttoDecreto_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.OperazioneDocumentale_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Protocollo_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ServiceErrorType;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentFileTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.servizi.to.FadDemBilTO;
import it.mef.bilancio.demdec.servizi.to.FascicoloAttoDecretoTO;
import it.mef.bilancio.demdec.servizi.to.FascicoloSipatrTO;
import it.mef.bilancio.demdec.servizi.to.ProtocolloTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class UtilResponseClient implements DEMBILConstants{
	

	public static CodeDescriptionTO createCodiceDescrizione (String codi,String descrizione) {
		
		CodeDescriptionTO codiDesc = null;
		if (!StringUtil.isEmpty(codi)){
		codiDesc = new CodeDescriptionTO();
		codiDesc.setCode(codi);
		codiDesc.setDescription(descrizione);
		}
		return codiDesc;
		}	


	public static CodeDescriptionTO createCodiceDescrizione (CodiceDescrizione_type  codeDescription){
		
		return codeDescription!=null?createCodiceDescrizione(codeDescription.getCodice(),codeDescription.getDescrizione()):null;
		}	

	
	public static String createFormattedDate (Date date){
		String SDate = "";
		if (!StringUtil.isEmpty(date)) {
			SDate=DateUtil.getDateString(date,"dd/MM/yyyy");
		}	
		return SDate;
		}	
	
	public static DocumentContentTO createDocumentContent (DocumentoContent_type documentoContent_type){
		DocumentContentTO documentContent = null;
		
		if (!StringUtil.isEmpty(documentoContent_type)&&!StringUtil.isEmpty(documentoContent_type.getContent())) {
			
			try {
				byte[] bcontent=null;
				bcontent = IOUtils.toByteArray(documentoContent_type.getContent().getDataSource().getInputStream());
				documentContent = new DocumentContentTO();
				documentContent.setContent(bcontent);
				documentContent.setDescrizione(documentoContent_type.getDescrizione());
				documentContent.setFileName(documentoContent_type.getFileName());
				documentContent.setFirmato(documentoContent_type.getFirmato());
				byte[] bhash=null;
				bhash = IOUtils.toByteArray(documentoContent_type.getHash().getDataSource().getInputStream());
				documentContent.setHash(bhash);
				documentContent.setIdDocumento(documentoContent_type.getIdDocumento().getGuid());
				documentContent.setLength(documentoContent_type.getLength());
				documentContent.setMimeType(documentoContent_type.getMimeType());
				documentoContent_type.getContent().getInputStream().close();
				documentoContent_type.getHash().getInputStream().close();
				
			} catch (IOException e) {
				TraceLogger.errorLog("CreateDocumentContent errore nella lettura del content", UtilResponseClient.class, e);
			}
			//documentoContent_type.;
		}	
		return documentContent;
		}	


	public static DocumentFileTO createDocumentFile (DocumentoFile_type documentoFile_type){
		DocumentFileTO documentFile = null;
		
		if (!StringUtil.isEmpty(documentoFile_type)&&!StringUtil.isEmpty(documentoFile_type.getFileName())) {
			
			try {
				documentFile = new DocumentFileTO();
				documentFile.setDescrizione(documentoFile_type.getDescrizione());
				documentFile.setFileName(documentoFile_type.getFileName());
				documentFile.setFirmato(documentoFile_type.getFirmato());
				byte[] bhash=null;
				bhash = IOUtils.toByteArray(documentoFile_type.getHash().getInputStream());
				documentFile.setHash(bhash);
				documentFile.setIdDocumento(documentoFile_type.getIdDocumento().getGuid());
				documentFile.setLength(documentoFile_type.getLength());
				documentFile.setMimeType(documentoFile_type.getMimeType());
				documentoFile_type.getHash().getInputStream().close();
			} catch (IOException e) {
				TraceLogger.errorLog("CreateDocumentContent errore nella lettura del content", UtilResponseClient.class, e);
			}
			//documentoContent_type.;
		}	
		return documentFile;
		}	

	public static DocumentTO createDocument(DocumentoFascicoloAttoDecreto_type type){
		DocumentTO to = null;
		if (!StringUtil.isEmpty(type)&&!StringUtil.isEmpty(type.getIdDocumento())){
			to = new DocumentTO();
			try {
				to.setDocumentoFileOrigine(UtilResponseClient.createDocumentFile(type.getDocumentoOrigine()));
				to.setDocumentoFileOperazione(UtilResponseClient.createDocumentFile(type.getOperazione().getDocumentoOperazione()));
				to.setAmministrazione(UtilResponseClient.createCodiceDescrizione(type.getMetadatiDocumento().getAmministrazione()));
				to.setAttivo(type.getAttivo());
				to.setCondivisibile(type.getCondivisibile());
				to.setDataAnnullamento(DateUtil.getDateString(type.getMetadatiDocumento().getDataAnnullamento(),"dd/MM/yyyy"));
				to.setDataChiusura(DateUtil.getDateString(type.getMetadatiDocumento().getDataChiusura(),"dd/MM/yyyy"));
				to.setDataCreazione(DateUtil.getDateString(type.getDataCreazione(),"dd/MM/yyyy"));
				to.setDataDocumento(DateUtil.getDateString(type.getMetadatiDocumento().getDataDocumento(),"dd/MM/yyyy"));
				to.setDescrizione(type.getDescrizione());
				//to.setDocumentoContent(UtilResponseClient.createDocumentContent(type.getDocumentoOrigine()));
				to.setEsitoOperazione(type.getOperazione().getEsitoOperazione().getValue());
				to.setIdDocumento(type.getIdDocumento().getGuid());
//				to.setIdFascicolo(type.getMetadatiDocumento().);
				to.setIsDocumentoOriginale(type.getIsDocumentoOriginale());
				to.setIsDocumentoTrattato(type.getIsDocumentoTrattato());
				to.setNote(type.getMetadatiDocumento().getNote());
				to.setProtocollo(UtilResponseClient.createProocollo(type.getMetadatiDocumento().getProtocollo()));
				to.setSistemaProduttore(type.getSistemaProduttore());
				//to.setStatDocumento(type.getMetadatiDocumento().);
				to.setTipoDocumento(UtilResponseClient.createCodiceDescrizione(type.getTipoDocumento().getCodice(),type.getTipoDocumento().getDescrizione()));
				to.setTipoOperazione(type.getOperazione().getTipoOperazione().getValue());
//				to.setUtenteCreatore(UtilResponseClient.createCodiceDescrizione(type.getMetadatiDocumento().get));
				to.setPreView(UtilResponseClient.createPreview(type.getPreviewPng()));
			}catch (Exception e){
				TraceLogger.errorLog("CreateDocument errore nella lettura del content", UtilResponseClient.class, e);
				
			}
		}
		return to;
	}
/*
	public static byte[]  toByteArray (DataHandler  dh){

		
		if (dh!=null){
		byte[] file = null;
		try {
			InputStream is=dh.getInputStream();
			file = new byte [is.available()];
			is.read(file);
			TraceLogger.infoLog("*-->###<--* file ---> byte[] size: "+file.length, UtilResponseClient.class);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			TraceLogger.errorLog("errore lettura flusso ", UtilResponseClient.class,e);
		}
		}}
*/	
	public static ProtocolloTO  createProocollo (Protocollo_type  protocollo_type){
		ProtocolloTO protocollo = null;
		if (!StringUtil.isEmpty(protocollo_type)) {
			protocollo = new ProtocolloTO(protocollo_type.getAoo(),protocollo_type.getData(),protocollo_type.getTipo().getTipo_type0(),protocollo_type.getNumeroProtocollo());
		}	
		return protocollo;
		}
	
	public static String createPreview(DataHandler preView){
		try {
			return new Base64().encodeToString(IOUtils.toByteArray(preView.getInputStream()));
		} catch(Exception e){
			return null;
		}
	}


	//TODO verificare la gestione degli Errori
	public static void  setEsito (Esito_type esitoType, ServiceErrorType[] errors,ResponseDEMBILClient responseDEMBILClient){
		responseDEMBILClient.setEsitoTo(new EsitoTO(esitoType.getValue(),ERRORI.get(esitoType.getValue())));
		TraceLogger.infoLog("Client.UtilResponseClient " + esitoType.getValue(),  UtilResponseClient.class);
//		if (esitoType.equals(Esito_type.OK)){
//			responseDEMBILClient.setEsitoTo(new EsitoTO(ESITO_OK,DESC_ESITO_OK));
//			TraceLogger.infoLog("Client.UtilResponseClient ESITO OK", UtilResponseClient.class);
//		} else {
//			responseDEMBILClient.setEsitoTo(new EsitoTO(esitoType.getValue(), esitoType.getValue()));
		 	List<String> errorsList = new ArrayList<String>();
			if (errors != null && errors.length>0){
			 	for (int i = 0; i < errors.length; i++) {
					errorsList.add((errors[i].getErrorMessageString().substring(0, errors[i].getErrorMessageString().indexOf("DETAILED"))));
					TraceLogger.infoLog("SERVIZIO DEMBIL ERRORE " + "setEsito " , UtilResponseClient.class);
					TraceLogger.infoLog("SERVIZIO DEMBIL ERRORE " + "setEsito:"+ errors[i].getErrorCode() +" msg:" + errors[i].getErrorMessageString(), UtilResponseClient.class);
			 	} 	 	
//			}else{
//				errorsList.add(DESC_ESITO_KO_NO_DETAIL_DEMBIL);
			} 	

		responseDEMBILClient.getEsitoTo().setErrors(errorsList);
//		}
	}

	public static FascicoloAttoDecretoTO createDettaglioFasicolo(FascicoloAttoDecreto_type type){
		FascicoloAttoDecretoTO to = null;
		if (!StringUtil.isEmpty(type)){
			to = new FascicoloAttoDecretoTO();
			try {
				if (!StringUtil.isEmpty(type.getAllegatiDecretoIGB())){
					ArrayList<DocumentTO> allegatiDecretoIGB = new ArrayList<DocumentTO>(); 
					for (int i=0; i<type.getAllegatiDecretoIGB().length;i++){
						allegatiDecretoIGB.add(UtilResponseClient.createAllegatoIGB(type.getAllegatiDecretoIGB()[i]));
					}
					to.setAllegatiDecretoIGB(allegatiDecretoIGB);
				}
				to.setIdFascicoloAttoDecreto(type.getIdFascicoloAttoDecreto().getGuid());
				to.setAttivo(type.getAttivo());
				to.setDaInviare(type.getDaInviare());
				to.setDataAggiornamentoAttoDecreto(type.getDataAggiornamentoAttoDecreto());
				to.setDataAggiornamentoFascicoloIGB(to.getDataAggiornamentoFascicoloIGB());
				to.setDataAggiornamentoSIPATR(type.getDataAggiornamentoSIPATR());
				to.setDataChiusura(type.getDataChiusura());
				to.setDataCreazione(type.getDataCreazione());
				to.setDescrizione(type.getDescrizione());
				if (type.getDocumenti()!=null){
					ArrayList<DocumentTO> list = new ArrayList<DocumentTO>();
					for(int i=0; i<type.getDocumenti().length;i++){
						list.add(UtilResponseClient.createDocument(type.getDocumenti()[i]));
					}
					to.setDocumenti(list);
				}
				if (type.getFascicoliSIPATR()!=null){
					ArrayList<FascicoloSipatrTO> list = new ArrayList<FascicoloSipatrTO>();
					for (int i=0;i<type.getFascicoliSIPATR().length;i++){
						list.add(UtilResponseClient.createFascicoloPatrimonio(type.getFascicoliSIPATR()[i]));
					}
					to.setFascicoliSIPATR(list);
				}
				to.setIdFascicoloAttoDecretoParent(type.getIdFascicoloAttoDecretoParent()!=null?type.getIdFascicoloAttoDecretoParent().getGuid():null);
				to.setMetadati(UtilResponseClient.createFadDembil(type.getDatiFascicolo()));
				to.getMetadati().setAttivo(type.getAttivo());
				to.getMetadati().setDaInviare(type.getDaInviare());
				to.getMetadati().setDescDec(type.getDescrizione());
				to.getMetadati().setGuid(type.getIdFascicoloAttoDecreto().getGuid());
				to.setSistemaProduttore(type.getSistemaProduttore());
				to.setStatoFascicoloDocumentale(type.getStatoFascicoloDocumentale().getValue());
			}catch (Exception e){
				TraceLogger.errorLog("CreateDocument errore nella lettura del content", UtilResponseClient.class, e);
				
			}
		}
		return to;
	}
	public static FascicoloSipatrTO createFascicoloPatrimonio(FascicoloSIPATR_type type){
		FascicoloSipatrTO to = new FascicoloSipatrTO();
		to.setAmministrazione(UtilResponseClient.createCodiceDescrizione(type.getDatiFascicolo().getAmministrazione()));
		to.setAttivo(type.getAttivo());
		to.setStatoFascicoloDocumentale(type.getStatoFascicoloDocumentale().getValue());
		to.setDaInviare(type.getDaInviare());
		to.setDataCreazione(UtilResponseClient.createFormattedDate(type.getDataCreazione()));
		if(type.getDataChiusura()!=null){
			to.setDataChiusura(UtilResponseClient.createFormattedDate(type.getDataChiusura().getTime()));
		}
		if(type.getDataAggiornamento()!=null){
			to.setDataAggiornamento(UtilResponseClient.createFormattedDate(type.getDataAggiornamento().getTime()));
		}
		to.setDescrizione(type.getDescrizione());
		to.setIdentificativoSIPATR(type.getDatiFascicolo().getIdentificativoSIPATR());
		to.setIdFascicoloSipatr(type.getIdFascicoloSIPATR().toString());
		
		to.setRagioneria(UtilResponseClient.createCodiceDescrizione(type.getDatiFascicolo().getRagioneria()));
		to.setSistemaProduttore(type.getSistemaProduttore());
		to.setStatoFascicoloSIPATR(type.getDatiFascicolo().getStatoFascicoloSIPATR());
		to.setTitolo(type.getDatiFascicolo().getTitolo()!=null?type.getDatiFascicolo().getTitolo().getDescrizione():"");
		if (type.getDocumenti()!=null){
			ArrayList<DocumentTO> list = new ArrayList<DocumentTO>();
			for (int i=0; i<type.getDocumenti().length;i++){
				list.add(UtilResponseClient.createDocument(type.getDocumenti()[i]));
			}
			to.setDocumenti(list);
		}
		return to;
	}
	
	public static DocumentTO createDocument(DocumentoFascicoloSIPATR_type type){
		DocumentTO to = new DocumentTO();
//		to.setIdFascicolo(fsipatr.getIdFascicoloFAD());
//		to.setIdSottoFascicolo(fsipatr.getIdFascicoloSipatr());
		to.setIdDocumento(type.getIdDocumento().getGuid());
		to.setTipoDocumento(UtilResponseClient.createCodiceDescrizione(type.getTipoDocumento().getCodice(),type.getTipoDocumento().getDescrizione()));
		to.setDescrizione(type.getDescrizione());
		to.setDataCreazione(UtilResponseClient.createFormattedDate(type.getDataCreazione()));
		to.setCondivisibile(type.getCondivisibile());
		to.setAttivo(type.getAttivo());
		to.setSistemaProduttore(type.getSistemaProduttore());
		to.setIsDocumentoOriginale(type.getIsDocumentoOriginale());
		to.setIsDocumentoTrattato(type.getIsDocumentoTrattato());
		to.setTicketArchiviazione(type.getTicketArchiviazione());
		//Metadata
		to.setNote(type.getMetadatiDocumento().getNote());
		to.setDataAnnullamento(UtilResponseClient.createFormattedDate(type.getMetadatiDocumento().getDataAnnullamento()));
		to.setDataChiusura(UtilResponseClient.createFormattedDate(type.getMetadatiDocumento().getDataChiusura()));
		to.setDataDocumento(UtilResponseClient.createFormattedDate(type.getMetadatiDocumento().getDataDocumento()));
		to.setProtocollo(UtilResponseClient.createProocollo(type.getMetadatiDocumento().getProtocollo()));
		//to.setStatDocumento(type.getMetadatiDocumento().getMetadata().get);
		to.setNote(type.getMetadatiDocumento().getNote());
		//Metadata
		
		try {
			//Documento File
			DocumentContentTO documentContent = new DocumentContentTO();
			documentContent.setDescrizione(type.getDescrizione());
			documentContent.setFileName(type.getFileName());
			documentContent.setFirmato(type.getFirmato());
			byte[] bhash=null;
			bhash = IOUtils.toByteArray(type.getHash().getInputStream());
			documentContent.setHash(bhash);
			documentContent.setIdDocumento(type.getIdDocumento().getGuid());
			documentContent.setLength(type.getLength());
			documentContent.setMimeType(type.getMimeType());
			to.setDocumentoContent(documentContent);
		}catch (IOException ioe){
			
		}
		
		//Documento File
		
		//Documento Origine
		if (to.getIsDocumentoTrattato()){
			to.setDocumentoFileOrigine(UtilResponseClient.createDocumentFile(type.getDocumentoOrigine()));
		}
		//Documento Trattato
		
		//if (to.getIsDocumentoOriginale()){
			OperazioneDocumentale_type opDoc =type.getOperazione();
			if (opDoc != null){
				to.setTipoOperazione(opDoc.getTipoOperazione().getValue());
				to.setEsitoOperazione(opDoc.getEsitoOperazione().getValue());
				to.setDocumentoFileOperazione(UtilResponseClient.createDocumentFile(opDoc.getDocumentoOperazione()));
			}
		//}
		to.setPreView(UtilResponseClient.createPreview(type.getPreviewPng()));
		return to;
	}
	
	public static FadDemBilTO createFadDembil(FascicoloMetadataAttoDecreto_type type){
		FadDemBilTO to = new FadDemBilTO();
		if (type!=null){
			to.setAmm(UtilResponseClient.createCodiceDescrizione(type.getAmministrazione()));
			to.setAnnoDec(type.getAnno());
			to.setNumeroDec(type.getNumeroDecreto());
			to.setGuidSiPatr(type.getIdFascicoloDecretoSIPATR()!=null?type.getIdFascicoloDecretoSIPATR().getGuid():null);
			to.setSiglaTipoDec(UtilResponseClient.createCodiceDescrizione(type.getTipoDecreto()));//TODO verificare se non è tipologia
			to.setStatoFascicolo(type.getStatoFascicoloAttoDecreto());
			try {
				to.setNumPatr(ParseUtil.getInteger(type.getNumeroDecretoSIPATR()));
			} catch(Exception e){
				to.setNumPatr(null);
			}
			try {
				to.setTipoDec(ParseUtil.getInteger(to.getSiglaTipoDec().getCode()));
			} catch(Exception e){
				to.setTipoDec(null);
			}
			to.setTipologiaDec(UtilResponseClient.createCodiceDescrizione(type.getTipologiaDecreto()));
			to.setTitolo(UtilResponseClient.createCodiceDescrizione(type.getTitolo()));
			to.setUcbRts(UtilResponseClient.createCodiceDescrizione(type.getRagioneria()));
			to.setUfficioCapofila(UtilResponseClient.createCodiceDescrizione(type.getUfficioCapofila()));
			to.setUfficioCreatore(UtilResponseClient.createCodiceDescrizione(type.getUfficioCreatore()));
			to.setUtenteCreatore(UtilResponseClient.createCodiceDescrizione(type.getUtenteCreatore()));
		}
		return to;
	}
	public static DocumentTO createAllegatoIGB (DocumentoFascicoloAllegatoDecretoIGB_type type){
		DocumentTO documento = new DocumentTO();
		
		documento.setIdDocumento(type.getIdDocumento().getGuid());   
		documento.setTipoDocumentoRed(UtilResponseClient.createCodiceDescrizione(type.getMetadatiDocumento().getTipoDocumentoRED().getCodice(), type.getMetadatiDocumento().getTipoDocumentoRED().getDescrizione()));
		documento.setDescrizione(type.getDescrizione());
		documento.setDataCreazione(UtilResponseClient.createFormattedDate(type.getDataCreazione()));
		documento.setCondivisibile(type.getCondivisibile());
		documento.setAttivo(type.getAttivo());
		documento.setSistemaProduttore(type.getSistemaProduttore());
		documento.setIsDocumentoOriginale(type.getIsDocumentoOriginale());
		documento.setIsDocumentoTrattato(type.getIsDocumentoTrattato());
		documento.setTicketArchiviazione(type.getTicketArchiviazione());
		documento.setTipoDocumento(UtilResponseClient.createCodiceDescrizione(type.getTipoDocumento().getCodice(),type.getTipoDocumento().getDescrizione()));
		
		//Metadata  TODO verificare i metadati
		documento.setIdFascicolo(type.getMetadatiDocumento().getIdFascicoloRaccoltaProvvisoria().getGuid());
		documento.setIdDocumentoRaccoltaProvvisoria(type.getMetadatiDocumento().getIdDocumentoRaccoltaProvvisoria().getGuid());
		documento.setAmministrazione(UtilResponseClient.createCodiceDescrizione(type.getMetadatiDocumento().getAmministrazione()));
		documento.setUcbRts(UtilResponseClient.createCodiceDescrizione(type.getMetadatiDocumento().getRagioneria()));
		documento.setUfficioCreatoreRed(UtilResponseClient.createCodiceDescrizione(type.getMetadatiDocumento().getUfficioCreatoreRED()));
		documento.setUtenteCreatore(UtilResponseClient.createCodiceDescrizione(type.getMetadatiDocumento().getUtenteCreatore()));
		documento.setTipoFlusso(type.getMetadatiDocumento().getTipoFlusso().getValue());
		documento.setNote(type.getMetadatiDocumento().getNote());
		documento.setDataAnnullamento(UtilResponseClient.createFormattedDate(type.getMetadatiDocumento().getDataAnnullamento()));
		documento.setDataChiusura(UtilResponseClient.createFormattedDate(type.getMetadatiDocumento().getDataChiusura()));
		documento.setCodiIdRed(type.getMetadatiDocumento().getIdentificativoRaccoltaProvvisoria());
		documento.setIdSottoFascicolo(type.getMetadatiDocumento().getIdFascicoloRaccoltaProvvisoria().getGuid());
		
		documento.setDataDocumento(UtilResponseClient.createFormattedDate(type.getMetadatiDocumento().getDataDocumento()));
		
		documento.setProtocollo(UtilResponseClient.createProocollo(type.getMetadatiDocumento().getProtocollo()));
		documento.setProtocolloRed(UtilResponseClient.createProocollo(type.getMetadatiDocumento().getProtocolloRed()));
		
		//Metadata  
		try{
			//Documento File
			DocumentContentTO documentContent = new DocumentContentTO();
			documentContent.setDescrizione(type.getDescrizione());
			documentContent.setFileName(type.getFileName());
			documentContent.setFirmato(type.getFirmato());
			documentContent.setTipoCompressione(type.getTipoCompressione());
			byte[] bHash=IOUtils.toByteArray(type.getHash().getInputStream());
			documentContent.setHash(bHash);
			documentContent.setIdDocumento(type.getIdDocumento().getGuid());
			documentContent.setLength(type.getLength());
			documentContent.setMimeType(type.getMimeType());
			
			documento.setDocumentoContent(documentContent);  
			
			
			//Documento File
		}catch(IOException ioException){
			
		}
		
		//Documento Origine
		//if (documento.getDocumentoFileOrigine()!=null){
		if (type.getDocumentoOrigine()!=null){
			documento.setDocumentoFileOrigine(UtilResponseClient.createDocumentFile(type.getDocumentoOrigine())); 
		}
		//Documento Trattato
			
		OperazioneDocumentale_type opDoc =type.getOperazione();
		if (opDoc != null){ 
			documento.setTipoOperazione(opDoc.getTipoOperazione().getValue());
			documento.setEsitoOperazione(opDoc.getEsitoOperazione().getValue());
			documento.setDocumentoFileOperazione(UtilResponseClient.createDocumentFile(opDoc.getDocumentoOperazione()));
		} 
		documento.setPreView(UtilResponseClient.createPreview(type.getPreviewPng()));
		return documento;
	}
}