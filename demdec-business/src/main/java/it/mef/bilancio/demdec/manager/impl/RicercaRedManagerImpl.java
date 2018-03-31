package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBOId;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBOId;
import it.almavivaitalia.bilancio.commons.bo.DescDocumentoBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBOId;
import it.almavivaitalia.bilancio.commons.bo.EserciziDemBO;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBOId;
import it.almavivaitalia.bilancio.commons.bo.TipoDocumentoBO;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bsn.sh.utils.DateUtil;
import it.mef.bilancio.demdec.dao.AnagAmminDemDao;
import it.mef.bilancio.demdec.dao.AnagRagionerieDemDao;
import it.mef.bilancio.demdec.dao.AnagTipoDecretoDao;
import it.mef.bilancio.demdec.dao.DescDocumentoDao;
import it.mef.bilancio.demdec.dao.DocumentiRedDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.dao.SottoFascicoliRedDao;
import it.mef.bilancio.demdec.manager.RicercaRedManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.to.InvioFadTO;
import it.mef.bilancio.demdec.to.RicercaRedTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public class RicercaRedManagerImpl extends AbstractDemManagerImpl implements RicercaRedManager{
	
		@Autowired
		private FascicoloDao fascicoloDao;
		
		
		@Autowired
		private SottoFascicoliRedDao sottoFascicoliRedDao;
		
		@Autowired
		private DocumentiRedDao documentiRedDao;
		
		@Autowired
		private AnagAmminDemDao anagAmminDemDao;
		
		@Autowired
		private AnagRagionerieDemDao anagRagionerieDemDao;

		@Autowired
		private CronologicoManager cronologicoManager;
		
		@Autowired
		private AnagTipoDecretoDao anagTipoDecretoDao;
		
		@Autowired
		private DescDocumentoDao descDocumentoDao;
		
		@Override
		public AnagTipoDecretoTO getTipoDecretoById(Integer tipo)  throws Throwable{
			
			return getDozerDriver().map(anagTipoDecretoDao.loadAnagTipoDecretoById(tipo), AnagTipoDecretoTO.class, "AnagTipoDecreto");
			//return anagTipoDecretoDao.loadAnagTipoDecretoById(tipo);
		 
		}
		
		
		@Override
		public List<FascicoliViewTO> findFascicoloByTipoNumAnnoStato(Integer anno, Integer tipo, Integer numDec)  throws Throwable{
			return fascicoloDao.findFascicoloByTipoNumAnnoStato(anno, tipo, numDec);
		 
		}
		
		@Override
		public ResponseDEMBILClient wsCambioStatoFascicolo(InvioFadTO ifTo) throws Throwable{
			ParametriInput paramInput = leggiParametriInputDemBil();
			InterfacciaAttoDecretoDEMBILClient serviceClient= new InterfacciaAttoDecretoDEMBILClient();
			RequestDEMBILClient reqClient=new RequestDEMBILClient(paramInput, ifTo, null);
			ResponseDEMBILClient respClient=serviceClient.changeStatoFascicoloRacoltaProvvisoria(reqClient);
			return respClient;
		}
		
		

	
		@Override
		public ResponseDEMBILClient wsRicercaRed(RicercaRedTO ricercaRedTO) throws Throwable {
			
			ParametriInput paramInput = leggiParametriInputDemBil();
					
			InterfacciaAttoDecretoDEMBILClient serviceClient= new InterfacciaAttoDecretoDEMBILClient();
			
			RequestDEMBILClient reqClient=new RequestDEMBILClient(paramInput, ricercaRedTO, null);
			reqClient.setTipoEstrazioneFascicolo(DEMBILConstants.TIPO_ESTRAZIONE_METADATA);
			reqClient.setTipoEstrazioneDocumenti(DEMBILConstants.TIPO_ESTRAZIONE_NONE);
			ResponseDEMBILClient respClient=serviceClient.searchFascicoliRaccolteProvvisorie(reqClient);
			
    		return respClient;
		
		}
		
	
		
		 @Override
		 public ResponseDEMBILClient wsDownloadDocumento(String idFascicolo, String idDocumento) throws Throwable {
			 ParametriInput paramInput = leggiParametriInputDemBil();
			 
			 	RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
	//			requestDEMBILClient.setIdFascicolo("159a0230-1b26-11e5-b939-0800200c9a65");
	//			requestDEMBILClient.setIdDocumento("159a0230-1b26-11e5-b939-0800200c9a66");
			 	
				requestDEMBILClient.setIdFascicolo(idFascicolo);
				requestDEMBILClient.setIdDocumento(idDocumento);
	
				InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
				ResponseDEMBILClient resp= client.downloadDocumentoRaccoltaProvvisoria(requestDEMBILClient);
			
				return resp;
			
		}
		 
		 
		 
		@Override
		public ResponseDEMBILClient wsDocumentiFascicolo(RaccoltaProvvisoriaRedTO to) throws Throwable {
			ParametriInput paramInput= leggiParametriInputDemBil();
			RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient( paramInput,to,null);
			requestDEMBILClient.setTipoEstrazioneFascicolo(DEMBILConstants.TIPO_ESTRAZIONE_DATA);
			InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
			ResponseDEMBILClient resp= client.getFascicoloRaccoltaProvvisoria(requestDEMBILClient);
			return resp;
	
		}
		
		

		@Override
		public ResponseDEMBILClient wsInvioFAD(InvioFadTO ifTo, SottoFascicoliRedTO sfRedTo, DocumentTO docTo) throws Throwable {

			ParametriInput paramInput = leggiParametriInputDemBil();
				RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient( paramInput, ifTo, null);
				requestDEMBILClient.setTipoEstrazioneFascicolo(DEMBILConstants.TIPO_ESTRAZIONE_METADATA);
				InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
				
				ResponseDEMBILClient resp= client.addDocumentoFascicoloAllegatoDecretoIGB(requestDEMBILClient); 
				String codiceEsito=resp.getEsitoTo().getCodice();
				DocumentTO docToWs=null;
				
				if(codiceEsito.equalsIgnoreCase("OK")) { 
				//if(true) { 
					 docToWs=(DocumentTO) resp.getOutputTO();   
					 docToWs.setRowCreatedDttm(docTo.getRowCreatedDttm());
					 docToWs.setRowCreatedUser(docTo.getRowCreatedUser());
					 docToWs.setRowCreatedForm(docTo.getRowCreatedForm());
					 					 
					 CodeDescriptionTO tipoDoc=new CodeDescriptionTO();
					 tipoDoc.setCode(ifTo.getTipoDocumento());
					 docToWs.setTipoDocumentoRed(tipoDoc);
					 
					 docToWs.setDescDocumento(docTo.getDescDocumento());
					 
					 inserisciSottoFascicoloRedEDocumento(sfRedTo, docToWs, ifTo); //TODO aggiungere i campi mancanti al docToWs
				}
			
				return resp;
		}
		
		
		private void inserisciSottoFascicoloRedEDocumento(SottoFascicoliRedTO sfRedTo, DocumentTO documentTO, InvioFadTO invFadTo)
				throws Throwable {
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
						
			AnagAmminDemBO anagAmmDemBo;
			AnagAmminDemBOId anagAmmDemBoId=new AnagAmminDemBOId();
			EserciziDemBO esDemBo=new EserciziDemBO();
			esDemBo.setId(sfRedTo.getAnagAmminDem().getId().getFkAnnoEse());
			
			anagAmmDemBoId.setFkAnnoEse(sfRedTo.getAnagAmminDem().getId().getFkAnnoEse());		
			anagAmmDemBoId.setNumeApp(sfRedTo.getAnagAmminDem().getId().getNumeApp() );
			anagAmmDemBoId.setNumeStp(sfRedTo.getAnagAmminDem().getId().getNumeStp() );	
					
			anagAmmDemBo = anagAmminDemDao.loadById(anagAmmDemBoId);
//			if(anagAmmDemBo==null) { //TODO verificare, togliere
//				anagAmmDemBo=new AnagAmminDemBO();
//				anagAmmDemBoId.setNumeStp(2);
//				anagAmmDemBo.setId(anagAmmDemBoId);
//			}
			
			AnagRagionerieDemBO ragBo = null;
			if(sfRedTo.getAnagRagionerieDem()!=null) {
				ragBo=new AnagRagionerieDemBO();
				AnagRagionerieDemBOId ragBoId=new AnagRagionerieDemBOId();
				
				ragBoId.setFkAnnoEse(sfRedTo.getAnagRagionerieDem().getId().getFkAnnoEse());
				ragBoId.setNumeRag(sfRedTo.getAnagRagionerieDem().getId().getNumeRag());
				
				ragBo=anagRagionerieDemDao.loadById(ragBoId);

			}
			
		
			SottoFascicoliRedBOId boId=new SottoFascicoliRedBOId();
			boId.setCodiIdRed(sfRedTo.getId().getCodiIdRed());
			boId.setFkNumeIdFascicolo(sfRedTo.getId().getFkNumeIdFascicolo());
			SottoFascicoliRedBO	sfRedBo = sottoFascicoliRedDao.loadById(boId);
			
			FascicoliBO fascBo=null;
			
			if (sfRedBo==null){
				sfRedBo=new SottoFascicoliRedBO();
				sfRedBo.setDescUfficioAss(sfRedTo.getDescUfficioAss());
				sfRedBo.setDescUtenteAss(sfRedTo.getDescUtenteAss());
				sfRedBo.setCodiGuidFascicolo(sfRedTo.getCodiGuidFascicolo());
				sfRedBo.setCodiGuidSFascicolo(sfRedTo.getCodiGuidSFascicolo());
				
				sfRedBo.setCodiAooProtocollo(sfRedTo.getCodiAooProtocollo());
				sfRedBo.setNumeProtocollo(sfRedTo.getNumeProtocollo());
				sfRedBo.setDescTipoProtocollo(sfRedTo.getDescTipoProtocollo());
				sfRedBo.setDataProtocollo(sfRedTo.getDataProtocollo());
				
				sfRedBo.setDescTipoFlusso(sfRedTo.getDescTipoFlusso());
				sfRedBo.setDataAggiornamento(sfRedTo.getRowCreatedDttm());
				sfRedBo.setDataArrivo(DateUtil.getDate(documentTO.getDataCreazione()));
				sfRedBo.setDataRed(sfRedTo.getDataRed());
				sfRedBo.setDescOggettoRed(sfRedTo.getDescOggettoRed());	 
				sfRedBo.setStatStato(sfRedTo.getStatStato());
				
				sfRedBo.setAnagAmminDem(anagAmmDemBo);
				
				sfRedBo.setAnagRagionerieDem(ragBo);
				sfRedBo.setNumeRag(ragBo!=null?ragBo.getId().getNumeRag().intValue():null);
//				if(ragBo.getId().getNumeRag() != null){
//					sfRedBo.setNumeRag(ragBo.getId().getNumeRag().intValue());
//				}
				
				sfRedBo.setCodiGuidFascicolo(sfRedTo.getCodiGuidFascicolo());
				sfRedBo.setCodiGuidSFascicolo(sfRedTo.getCodiGuidSFascicolo());
				sfRedBo.setDescUfficioAss(sfRedTo.getDescUfficioAss());
				sfRedBo.setDescUtenteAss(sfRedTo.getDescUtenteAss());
				
				sfRedBo.setNumeVersion(sfRedTo.getNumeVersion());
				sfRedBo.setId(boId);
				
				copyAudit(sfRedTo, sfRedBo);
				
			}else {
				sfRedBo.setDataAggiornamento(new Date());
				sfRedBo.setRowUpdatedDttm(new Date());
				sfRedBo.setRowUpdatedUser(sfRedTo.getRowUpdatedUser());
				sfRedBo.setRowUpdatedForm(sfRedTo.getRowUpdatedForm());
				
			}
			
			fascBo=fascicoloDao.loadById(FascicoliBO.class, sfRedTo.getId().getFkNumeIdFascicolo());
			fascBo.setDataModificaFascicolo(new Date());
			fascBo.setRowUpdatedDttm(new Date());
			fascBo.setRowUpdatedUser(sfRedTo.getRowUpdatedUser());
			fascBo.setRowUpdatedForm(sfRedTo.getRowUpdatedForm());
			sfRedBo.setFascicoli(fascBo);
			
			sottoFascicoliRedDao.saveOrUpdate(sfRedBo);		
			
			/**inserimento del documento**/
			 DocumentiRedBOId docBoId=new DocumentiRedBOId();  
			 docBoId.setFkNumeIdFascicolo(sfRedTo.getId().getFkNumeIdFascicolo());//TODO verificare
//			 docBoId.setCodiGuidDocumento(documentTO.getIsDocumentoTrattato()?documentTO.getIdDocumento():null);//TODO verificare cosa va inserito in questo campo
		//	 docBoId.setCodiGuidDocumento(documentTO.getIdDocumento());//TODO verificare cosa va inserito in questo campo
			// docBoId.setCodiGuidDocumento(documentTO.getDocumentoFileOperazione()!=null?documentTO.getDocumentoFileOperazione().getIdDocumento():documentTO.getIdDocumento());
//			 docBoId.setCodiGuidDocumento(documentTO.getDocumentoFileOrigine().getIdDocumento());
			 docBoId.setCodiGuidDocumento(documentTO.getIdDocumento());
			// 	 docBoId.setCodiGuidDocumento("a2295678-ce7e-4587-9bea-24f3a1dwec3e5");//TODO togliere
					
	
			DocumentiRedBO  docRedBo=documentiRedDao.loadById(docBoId);
		//	DocumentiRedBO old= getDozerDriver().map(docRedBo, DocumentiRedBO.class, "DocumentiRedBOBO");
			
			if (docRedBo==null){
				docRedBo=new DocumentiRedBO();
				docRedBo.setId(docBoId);
			}
			
		//	docRedBo.setCodiGuidDocumentoOrig("a2295678-ce7e-4587-9bea-24f3a1dwec3e5");//TODO togliere
			docRedBo.setCodiGuidDocumentoTrasf(documentTO.getDocumentoFileOperazione()!=null?documentTO.getDocumentoFileOperazione().getIdDocumento():null);
			
			DocumentiRedBO old= getDozerDriver().map(docRedBo, DocumentiRedBO.class, "DocumentiRedBOBO");
			copyAudit(documentTO, docRedBo);	

			docRedBo.setCodiIdRed(sfRedBo.getId().getCodiIdRed());
			docRedBo.setAnagAmminDem(anagAmmDemBo);

			//docRedBo.setCodiGuidDocProv(documentTO.getIdDocumentoRaccoltaProvvisoria());
			docRedBo.setCodiGuidDocProv(invFadTo.getIdDocumento());
	//		docRedBo.setCodiGuidDocProv("a2295678-ce7e-4587-9bea-24f3a1dec3e5");//TODO togliere
			
			//docRedBo.setCodiGuidDocOrigProv(documentTO.getIdDocumentoRaccoltaProvvisoria()); 
			docRedBo.setCodiGuidDocOrigProv(invFadTo.getIdDocumentoRaccoltaProvvisoria());
			if(documentTO.getDocumentoFileOrigine()!=null){
				docRedBo.setCodiMimeTypeOrig(documentTO.getDocumentoFileOrigine().getMimeType());
			}
			if(documentTO.getProtocolloRed()!=null){
				docRedBo.setCodiProtocollo(documentTO.getProtocolloRed().getNumeroProtocollo());
			}
			if(documentTO.getDataCreazione()!=null && !documentTO.getDataCreazione().equalsIgnoreCase("")){
				docRedBo.setDataAggiornamento(sdf.parse( documentTO.getDataCreazione()));
			}
			if(documentTO.getDataAnnullamento()!=null && !documentTO.getDataAnnullamento().equalsIgnoreCase("")){
				docRedBo.setDataAnnullamento(sdf.parse(documentTO.getDataAnnullamento()));
			}
		//	docRedBo.setDataArrivo(sdf.parse(documentTO.get ));//TODO verificare quale data è
			if(documentTO.getDataChiusura()!=null && !documentTO.getDataChiusura().equalsIgnoreCase("")){
				docRedBo.setDataChiusura(sdf.parse(documentTO.getDataChiusura())); 
			}
			if(documentTO.getDataDocumento()!=null && !documentTO.getDataDocumento().equalsIgnoreCase("")){
				docRedBo.setDataDocumento(sdf.parse(documentTO.getDataDocumento()));
			}
			
			if(documentTO.getDataCreazione()!=null && !documentTO.getDataCreazione().equalsIgnoreCase("")){
				docRedBo.setDataArrivo(sdf.parse( documentTO.getDataCreazione()));
			}
		
			if(documentTO.getDocumentoContent()!=null){
				docRedBo.setDescFilename(documentTO.getDocumentoContent().getFileName());
			}
		
			docRedBo.setDescTipoFlusso(documentTO.getTipoFlusso());
		
			
			docRedBo.setNumeVersion(documentTO.getNumeVersion());

			
			TipoDocumentoBO	tipoDocBo=new TipoDocumentoBO();
				
			if(documentTO.getTipoDocumentoRed()!=null){
				tipoDocBo.setId(documentTO.getTipoDocumentoRed().getCode());				
				tipoDocBo.setDescDescrizioneDoc(documentTO.getTipoDocumentoRed().getDescription());
				copyAudit(documentTO, tipoDocBo);	
				docRedBo.setTipoDocumento(tipoDocBo);
			}
			
			docRedBo.setFlagVisibilitaCdc01(0);
			DescDocumentoBO	descDocBo=new DescDocumentoBO();
			DescDocumentoBO boDescDoc=null;
			if(documentTO.getDescDocumento()!=null){
				descDocBo.setId(documentTO.getDescDocumento().getCode());			
				descDocBo.setCodiTipoDocumento(documentTO.getTipoDocumentoRed().getCode());
				descDocBo.setTextDescrizione(documentTO.getDescDocumento().getDescription());
				copyAudit(documentTO, descDocBo);	
				docRedBo.setDescDocumento(descDocBo);
				
				//setto il flag visibilità cdc con quello corrispondente nella tabella d_desc_documento
				boDescDoc=descDocumentoDao.loadById(DescDocumentoBO.class, documentTO.getDescDocumento().getCode());
				docRedBo.setFlagVisibilitaCdc01(boDescDoc.getFlagVisibilitaCdc());
			}
					
			
			docRedBo.setAnagAmminDem(anagAmmDemBo);
			
			docRedBo.setAnagRagionerieDem(ragBo);
			if(ragBo.getId().getNumeRag() != null){
				docRedBo.setNumeRag(ragBo.getId().getNumeRag().intValue());
			}
		
			docRedBo.setStatDocumento(0);
			
			documentiRedDao.saveOrUpdate(docRedBo); 
			
			// Richiamo cronologico
			cronologicoManager.salvaCronologico(old,//old
										docRedBo,//new
										null,
										null,
										CroTransTO.CRO_TRANS_ASSOCIAZIONE_RED_A_FAD,
										docRedBo.getRowUpdatedForm()==null?docRedBo.getRowCreatedForm():docRedBo.getRowUpdatedForm(), 
										docRedBo.getRowUpdatedUser()==null?docRedBo.getRowCreatedUser():docRedBo.getRowUpdatedUser());
			
		}

		@Override
		public List<FascicoliViewTO> findFascicoliAssociati(String guidDocumento) throws Throwable {
			return documentiRedDao.findFascicoliAssociati(guidDocumento);
		}

		@Override
		public List<FascicoliViewTO> findFascicoloByTipoNumAnno(Integer anno, Integer tipo, Integer numero) throws Throwable {
			// TODO Auto-generated method stub
			return fascicoloDao.findFascicoloByTipoNumAnno(anno, tipo, numero);
		}
		
	 
		 
		 
	 
}
