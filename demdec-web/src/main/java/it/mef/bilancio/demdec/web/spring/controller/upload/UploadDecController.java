package it.mef.bilancio.demdec.web.spring.controller.upload;


import it.almavivaitalia.bilancio.commons.bo.EserciziDemBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.bilancio.commons.utils.DateUtil;
import it.almavivaitalia.bilancio.commons.web.spring.controller.AbstractCommonFormController;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoMetadataAttoDecreto_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoOperazione_type;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.mime.MimeTypesFactory;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.itextpdf.text.log.SysoLogger;

import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.InitManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.UploadDecManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.UtilRequestClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentFileTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.servizi.to.FadDemBilTO;
import it.mef.bilancio.demdec.to.AmminRagDemTO;
import it.mef.bilancio.demdec.to.AmminTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.DocumentiViewTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.GestioneFadTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.UploadDecForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

@RequestMapping(value = ConstantsRequestMapping.UPLOAD_DEC)
public class UploadDecController extends AbstractDemFormController
		implements WebConstants, SessionAttributes {

	private String startView;
	private String uploadFileView;
	@Autowired
	private UploadDecManager uploadDecManager;
	@Autowired
	private ListManager listManager;
	
	private static ArrayList<String> allowedContentType;
	private static HashMap<String, String> contentTypeExtensions;
	
	static{
		allowedContentType = new ArrayList<String>();
        allowedContentType.add("application/pdf");
        allowedContentType.add("application/jpeg");
        allowedContentType.add("application/pjpeg");
//        allowedContentType.add("application/xml");
        allowedContentType.add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        allowedContentType.add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        allowedContentType.add("application/msword");
        allowedContentType.add("application/vnd.ms-excel");
        allowedContentType.add("image/x-ms-bmp");
        allowedContentType.add("image/tiff");
        allowedContentType.add("image/gif");
        allowedContentType.add("application/rtf");
        allowedContentType.add("image/jpeg");
        
        contentTypeExtensions= new HashMap<String, String>();
        contentTypeExtensions.put("application/pdf",".pdf");
        contentTypeExtensions.put("image/jpeg",".jpg");
        contentTypeExtensions.put("application/jpeg",".jpg");
        contentTypeExtensions.put("application/pjpeg",".jpg");
//        contentTypeExtensions.put("application/xml",".xml");
        contentTypeExtensions.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document",".docx");
        contentTypeExtensions.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",".xlsx");
        contentTypeExtensions.put("application/msword",".doc");
        contentTypeExtensions.put("application/rtf",".doc");
        contentTypeExtensions.put("application/vnd.ms-excel",".xls");
        contentTypeExtensions.put("image/x-ms-bmp",".bmp");
        contentTypeExtensions.put("image/tiff",".tif");
        contentTypeExtensions.put("image/gif",".gif");
        
	}

	@Override
	public String startController(Context context) throws Throwable {
//		context.setCurrentNode("DemDec.menu.Upload");
		UploadDecForm form = (UploadDecForm) context.getForm();
//		form.reset();
		Short eseGest=null;
		List<EserciziTO> eseList=listManager.loadEserciziDemCG();
		
		for (EserciziTO eserciziTO : eseList) {
			if(eserciziTO.getStatTipoEse().equals(CommonSessionAttributes.STAT_TIPO_ESE_GEST)){
				eseGest=eserciziTO.getId();
			}
		}
		
		context.setDataModel(WebConstants.LIST_TIPO_DOC, listManager.loadTipoDocumentoAD());
		context.setDataModel(WebConstants.LIST_AMMIN_DEM, listManager.getAmminDemCentraliByAnnoEse(eseGest.toString()));
		//label.tipo.doc=Tipo Documento
		//label.descr.doc=Descrizione Documento
		
		return startView;
	}


		
	public String onCaricaFascicoli(Context context) throws Throwable {
		UploadDecForm form = (UploadDecForm) context.getForm();
		
//		AnagAmminDemTO amm= ((List<AnagAmminDemTO>)context.getModel(WebConstants.LIST_AMMIN_DEM)).get(Integer.parseInt(form.getAmm()));
//		FascicoliFadSearhTO to = new FascicoliFadSearhTO();
//		to.setNumStp(amm.getId().getNumeStpFormatted());
//		to.setNumeApp(amm.getId().getNumeApp());	
//		to.setTipoDecreto(form.getTipoDoc());
		List<FascicoliTO>fascList= uploadDecManager.findFascicoliFadStatusZero();
		context.setDataModel(WebConstants.LIST_DOCUMENTI_FASCICOLO, fascList);
		return startView;
	}
	
	
	public String onUploadFile(Context context) throws Throwable {
		UploadDecForm form = (UploadDecForm) context.getForm();
		CommonsMultipartFile file = form.getUpFile();
		
		if (form.isValid()) {
			try {
				String contentType = uploadDecManager.checkGuessedFileType( allowedContentType, file.getOriginalFilename(), file.getInputStream());

				if (contentType.equals(Constants.NOT_ALLOWED)) {
					
					context.addError("error.contentType", "");
					return  uploadFileView;
				} 
				
				if (contentType.equals(Constants.BAD_FILE)) {
					context.addError("error.contentType.badFile", "");
					return  uploadFileView;
				} 
				// invece di fare l upload su FTP_NBF chiamare il servizio  
//				uploadDecManager.caricaPdf(uploadDecManager.renameToMatchingFileExt(contentTypeExtensions,contentType, file.getOriginalFilename()), file.getInputStream());
				
				//configurazione ocn tika parsers
//				String fileName=uploadDecManager.renameToMatchingFileExt(contentTypeExtensions,contentType, file.getOriginalFilename()); 
				String fileName= file.getOriginalFilename();
				
				FascicoliTO fascicoloTO= uploadDecManager.findFascicoliById(Long.parseLong(form.getIdFasc()));
				AnagAmminDemTO amm= ((List<AnagAmminDemTO>)context.getModel(WebConstants.LIST_AMMIN_DEM)).get(Integer.parseInt(form.getAmm()));
				
				if (form.getTipoDoc().equalsIgnoreCase(Constants.TIPO_ATTO_DECRETO)){
					List<DocumentiTO> listDoc=uploadDecManager.findDocumentiByTipoFascicolo(form.getTipoDoc(), Long.parseLong(form.getIdFasc()));
					if (!listDoc.isEmpty()){
						context.addError("error.ad01.already.exists", "");
						return  uploadFileView;
					}
				}
				
				DocumentTO docTO = popolaDocumentTO(context, fascicoloTO, amm, form, fileName, contentType);
				
//				MessageDigest md = MessageDigest.getInstance("MD5");
//				System.out.println("SHA "+md.digest(file.getBytes()));
//				
//				System.out.println("hash:"+file.hashCode());//TODO non genera gli stessi hascode
//				System.out.println(contentType);
//				System.out.println(file.getSize());
				
//				System.out.println(UtilRequestClient.createGuid(to.getIdDocumento()));
				
				ResponseDEMBILClient resp =uploadDecManager.uploadDocumento(docTO,amm,fascicoloTO, TipoOperazione_type._CONVERSIONE);
				
				if (resp.getEsitoTo()!=null&&resp.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)){
					context.addInfo("info.upload.success","");
				}
				else{
					context.addError("error.generic", resp.getEsitoTo().getDescrizione());
				}

			} 
			catch (Throwable e) {				
				context.addError("error.generic", e.getMessage());
			}

		}

		return uploadFileView;
	}
	
	public void setStartView(String startView) {
		this.startView = startView;
	}

	public void setUploadFileView(String uploadFileView) {
		this.uploadFileView = uploadFileView;
	}
	
	private DocumentTO popolaDocumentTO( Context context,FascicoliTO fascicoloTO,AnagAmminDemTO amm,UploadDecForm form,String fileName, String contentType) throws Throwable{
		
		DocumentTO docTo= new DocumentTO();
//		DocumentFileTO docFile= new DocumentFileTO();
//		docTo.setIdDocumento("2");// potrebbero restituirlo loro il GUID
		
		docTo.setIdFascicolo(fascicoloTO/*.getId()*/.getCodiGuidFascicolo().toString());// me lo passa gestione FAD come querystring o lo prendo dalla combo
		
		TipoDocumentoTO descDocTo=uploadDecManager.loadTipoDocById(form.getTipoDoc()); //((List<TipoDocumentoTO>)listManager.loadTipoDocumentoAD()).get(Integer.parseInt(form.getTipoDoc()));//gestioneFadManager.loadDescDocById(Integer.parseInt(form.getTipoDoc()));
		CodeDescriptionTO descDoc= new CodeDescriptionTO();
		descDoc.setCode(descDocTo.getId());
		descDoc.setDescription(descDocTo.getDescDescrizioneDoc());
		docTo.setTipoDocumento(descDoc);
		docTo.setAttivo(true);
		docTo.setCondivisibile(true);
		docTo.setDaInviare(true);
		DocumentContentTO dc= new DocumentContentTO();
		dc.setContent(form.getUpFile().getBytes());
		dc.setDescrizione(form.getDesc());//TODO
		dc.setFileName(fileName);
		dc.setMimeType(contentType);
		dc.setHash(UtilRequestClient.createHash(form.getUpFile().getBytes()));
		docTo.setDocumentoContent(dc);
		
		
		CodeDescriptionTO ammDescTo= new CodeDescriptionTO();
		ammDescTo.setCode(amm.getId().getAmmin());
		ammDescTo.setDescription(amm.getDescAmm());
		docTo.setAmministrazione(ammDescTo);
		docTo.setDataDocumento(DateUtil.getSysDate(Constants.DATE_SEPARATOR));
		
		CodeDescriptionTO ucbRts= new CodeDescriptionTO();
		AmminRagDemTO rag = getGestioneFadManager().findAmminRagDemByAnagAmminDemTO(amm);
		String r=StringUtils.leftPad(rag.getId().getNumeRag(), 4,Constants.PADDING_CHAR );
		ucbRts.setCode(r);
		ucbRts.setDescription(r);
		docTo.setUcbRts(ucbRts);
//		docTo.setDescrizione("upload");
		
		context.valorizeAudit(docTo, "Upload File");
		return docTo;
	}

	
}
