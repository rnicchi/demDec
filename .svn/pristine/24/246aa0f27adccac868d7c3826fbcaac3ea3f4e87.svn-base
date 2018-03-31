package it.mef.bilancio.demdec.web.spring.controller.workflowfirma;

import it.almavivaitalia.bilancio.commons.manager.UtenteManager;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.manager.exception.ObjectNotFoundException;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.mef.bilancio.demdec.manager.GestioneWorkflowFirmeManager;
import it.mef.bilancio.demdec.manager.LetterePreRegManager;
import it.mef.bilancio.demdec.manager.MailManager;
import it.mef.bilancio.demdec.to.LettereIgbTO;
import it.mef.bilancio.demdec.to.PecMessaggiInviatiTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.FirmaLetterePreRegForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = ConstantsRequestMapping.FIRMA_LETTERE_PRE_REG)
public class FirmaLetterePreRegController extends AbstractDemFormController{
	
	
	private String startView;
	 
    @Autowired
	LetterePreRegManager letterePreRegManager;
    
    @Autowired
	private UtenteManager utenteManager;
    
    @Autowired
	private MailManager mailManager;
	
    @Autowired
    GestioneWorkflowFirmeManager gestioneWorkflowFirmeManager;
    
    @Autowired
    private JavaMailSenderImpl pec;//TODO scommentare

	@Override
	public String startController(Context context) throws Throwable {
		context.setCurrentNode("DemDec.menu.FirmaLettPreReg");
		List<LettereIgbTO> signedLettere = letterePreRegManager.findLettereByStatus(Constants.LETTERA_FIRMATA);
		context.setDataModel(SessionAttributes.LIST_LETTERE_SIGNED, signedLettere);
		
		 Utente user=getUtenteInSessione();
		 AnagUfficiTO ufficio= user.getUtenteProfiloInUso().getAnagUffici();
		
		java.util.List<LettereIgbTO> listaLettere=letterePreRegManager.findLettereByCodiUfficioAndStatus(ufficio.getId(), Constants.LETTERA_INVIATA_ALLA_FIRMA);
    	
    	if (  listaLettere==null || listaLettere.size()==0   ){
				PaginatorUtil.removePaginator(context, LIST_LETTERE_TO_SIGN);
				if  (signedLettere==null || signedLettere.size()==0){
					context.addWarning("warning.empty");
				}
		}else {
			PaginatorUtil.addPaginator(listaLettere, LIST_LETTERE_TO_SIGN, Paginator.PAGE_RANGE_15, context);
		}
    
		return startView;
	}
	
	
	public void onApriLettera(Context context) throws Throwable{
		
		SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
		List<LettereIgbTO> toList = context.getModel(LIST_LETTERE_TO_SIGN);
		List<LettereIgbTO> toListSigned = context.getModel(LIST_LETTERE_SIGNED);
		String rowNum=context.getRequest().getParameter("rowNum");
		String tipo=context.getRequest().getParameter("tipo");
		
		LettereIgbTO letteraIgb=null;
		if(tipo.equalsIgnoreCase("toSign")){
			 letteraIgb=toList.get(new Integer(rowNum));
		}else{
			letteraIgb=toListSigned.get(new Integer(rowNum));
		}
 		
 		
 		 Blob blob=letterePreRegManager.getBlobByIdLettera(letteraIgb.getId());
 		
 		String nomeFile=null;
 		nomeFile=letteraIgb.getFascicoli().getEserciziDem().getId()+"_"+letteraIgb.getAnagAmminDem().getId().getNumeStpFormatted()+letteraIgb.getAnagAmminDem().getId().getNumeAppFormatted()+"_"+sdf.format(letteraIgb.getDataLettera())+".pdf";
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Disposition", "attachment; filename="+nomeFile);
        responseHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        
        int blobLength = (int) blob.length();  
        byte[] blobAsBytes = blob.getBytes(1, blobLength);
	        
	       context.getResponse().setContentType("multipart/form-data");
		context.getResponse().setHeader("Content-Disposition","attachment;filename="+nomeFile);
		ServletOutputStream out;
		
		out = context.getResponse().getOutputStream();
		out.write(blobAsBytes);
		out.flush();
		out.close();
	        
	}
	
	
	public String onFirma(Context context) throws Throwable{
		
		SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
		FirmaLetterePreRegForm form = (FirmaLetterePreRegForm)context.getForm();
		context.setDataModel("invioPec", "false");
		if(form.isValid()){
			List<LettereIgbTO> list = context.getModel(SessionAttributes.LIST_LETTERE_TO_SIGN);
			List<LettereIgbTO> signedDocuments = context.getModel(SessionAttributes.LIST_LETTERE_SIGNED);
			String nomeFile=null;
			 LettereIgbTO toResult=null;
			 Blob blob=null;
			for (int i = 0; i < form.getSelezioni().length; i++) {
				String selezione = form.getSelezioni()[i];
				LettereIgbTO selectedDocument = null; //list.get(Integer.valueOf(selezione));
				LettereIgbTO letteraTo =null;
				for (Iterator<LettereIgbTO> iterator = list.iterator(); iterator.hasNext();) {
					letteraTo = (LettereIgbTO) iterator.next();
					if(letteraTo.getId().compareTo(new BigDecimal(selezione))==0){
						selectedDocument = letteraTo;
					}
				}
				context.valorizeAudit(selectedDocument, NomeFunzioneConstants.FIRMA_LETTERE_PRE_REG);
				try {
					 blob=letterePreRegManager.getBlobByIdLettera(selectedDocument.getId());
					 selectedDocument.setBinaIntLettera(blob);
					 toResult=letterePreRegManager.firmaLettera(selectedDocument, form.getPin(), getUtenteInSessione(), NomeFunzioneConstants.FIRMA_LETTERE_PRE_REG, context.getRequest(), context.getResponse(), form.getSelezioni().length);
					 if(toResult!=null) {
						 nomeFile=selectedDocument.getFascicoli().getEserciziDem().getId()+"_"+selectedDocument.getAnagAmminDem().getId().getNumeStpFormatted()+selectedDocument.getAnagAmminDem().getId().getNumeAppFormatted()+"_"+sdf.format(selectedDocument.getDataLettera())+".pdf";
						 context.addInfo("info.lettera.signed", nomeFile);
						 signedDocuments.add(selectedDocument);
					 }else {
						 context.addError("error.lettera", nomeFile);
					 }
				} catch ( ObjectNotFoundException onfe) {
					
					switch (onfe.getCode()) {
						case 100:
							context.addError("error.empty.recipient.to");
							break;
						case 777:
							context.addError("error.ws.download.fascicolo.atto.decreto", onfe.getObject().toString());
							break;
						case 888:
							context.addError("error.ws.pkbox.firma.fascicolo.atto.decreto", onfe.getObject().toString());
							break;
						case 999:
							context.addError("error.ws.upload.fascicolo.atto.decreto", onfe.getObject().toString());
							break;
						default:
							context.addError("error.generic", onfe.getObject().toString());
							break;
					}
				//	setFirst(false);
					return startController(context);
				}
				
			}
			context.setDataModel(LIST_LETTERE_SIGNED, signedDocuments);
			context.setDataModel("invioPec", "true");
			
			
		}else{
		//	setFirst(false);
			return startController(context);
		}
//		setFirst(false);
		form.clear();
		return startController(context);
	}
	
	
	
	/**
	 * Metodo che mostra la lista di tutte le lettere firmate (status 2).
	 * @return
	 * @throws Throwable
	 */
	public String findMyLettereSigned(Context context) throws Throwable{
		
		List<LettereIgbTO> listMyLettereSigned = letterePreRegManager.findLettereByStatus(Constants.LETTERA_FIRMATA);
		
		if(listMyLettereSigned != null && !listMyLettereSigned.isEmpty()){
			context.setDataModel(SessionAttributes.LIST_LETTERE_SIGNED, listMyLettereSigned);
			PaginatorUtil.addPaginator(listMyLettereSigned, SessionAttributes.LIST_LETTERE_SIGNED, Paginator.PAGE_RANGE_15, context);
		}else{
			PaginatorUtil.removePaginator(context, SessionAttributes.LIST_LETTERE_SIGNED);
			ContextHelper.addWarning(context.getRequest(),"warning.noRecord.trovati");
		}
		
		
		return startController(context);
	}
	
	
	
	
	public String onInvioPec(Context context) throws Throwable{
		List<LettereIgbTO> signedDocuments = context.getModel(SessionAttributes.LIST_LETTERE_SIGNED);
		SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
		
		String nomeFile = "";
		String email = "";
		String oggetto = "";
		String testo = "";
		MimeMessage message = null;
		MimeMessageHelper helper =null;
		FileOutputStream fos = null;
 	    Blob blob=null;
 	    int blobLength =0;
 	    byte[] blobAsBytes =null;
 	    File convFile =null;
 	    PecMessaggiInviatiTO messageToSave=null;
		
	//	MailTestiTO mailTestiTo=mailManager.findMailTestiByCodiFunzione(NomeFunzioneConstants.FIRMA_LETTERE_PRE_REG);
		for (LettereIgbTO lettereIgbTO : signedDocuments) {
				oggetto=lettereIgbTO.getFascicoli().getEstremiStr()+"-"+lettereIgbTO.getFascicoli().getDescDecreto()+"-"+lettereIgbTO.getFascicoli().getEserciziDem().getId();
				testo=getMessageSource().getMessage("info.lettera.testoMailPec");
				nomeFile=lettereIgbTO.getFascicoli().getEserciziDem().getId()+"_"+lettereIgbTO.getAnagAmminDem().getId().getNumeStpFormatted()+lettereIgbTO.getAnagAmminDem().getId().getNumeAppFormatted()+"_"+sdf.format(lettereIgbTO.getDataLettera())+".pdf";
				email=letterePreRegManager.findDestinatariMailPec(lettereIgbTO.getId());
		//		email="entrate_test2@pec.almaviva.it"; //TODO mail di test, togliere
				if(email==null){
					context.addError("error.lettera.pec.not.sent", nomeFile, getMessageSource().getMessage( "error.serverTechnicalError"));
					return startController(context);
				}
				
				mailManager.popolaMailSender(FLAG_PEC);
				/*MimeMessage*/
				message = pec.createMimeMessage();
				/** caso con allegato **/
	    		convFile = new File(nomeFile);
	    	    convFile.createNewFile(); 
	    	    fos = new FileOutputStream(convFile); 
	    	    
	    	    blob=letterePreRegManager.getBlobByIdLettera(lettereIgbTO.getId());
	    	    
	    	  // blob=lettereIgbTO.getBinaIntLettera();
	    	    blobLength = (int) blob.length();  
			    blobAsBytes = blob.getBytes(1, blobLength);
	    	    fos.write(blobAsBytes);
	    	    fos.close(); 
	    	    helper = new MimeMessageHelper(message, true);
	    		helper.setText(testo, true);
	    		helper.setSubject(oggetto); 
	    		helper.addAttachment(nomeFile, convFile);//allegato
		    	helper.getMimeMessage().addRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		    	helper.setFrom(new InternetAddress(pec.getUsername()));
				
		    	this.pec.send(message);
//				MimeMessage message = null;
			//	message = mailManager.invioPecDaFunzione(NomeFunzioneConstants.FIRMA_LETTERE_PRE_REG, getUtenteInSessione(), email, oggetto, testo);
				
				if(message != null){
					messageToSave = mailManager.createMessageToSave(message, NomeFunzioneConstants.FIRMA_LETTERE_PRE_REG);
					context.valorizeAuditCreated(messageToSave, NomeFunzioneConstants.FIRMA_LETTERE_PRE_REG);
					//context.valorizeAuditUpdated(messageToSave, NomeFunzioneConstants.FIRMA_LETTERE_PRE_REG);
					mailManager.salvaMessaggioInviato(messageToSave, getUtenteInSessione());
					
					//TODO verificare se il nome file è approvato da Sogei
					context.addInfo("info.lettera.signed.and.msg.sent", nomeFile, mailManager.recipientsToString( message.getAllRecipients()));
					letterePreRegManager.aggiornaStatusLettera(lettereIgbTO.getId(), Constants.PEC_LETTERA_INVIATA, getUtenteInSessione().getUtente().getCodiUtente(), NomeFunzioneConstants.FIRMA_LETTERE_PRE_REG);
				}else{
					//context.addWarning("warning.email.not.sent");
					context.addError("error.lettera.pec.not.sent", nomeFile, getMessageSource().getMessage( "error.serverTechnicalError"));
				}
		
		  }
		
		  return startController(context);
	}
	
	
	 public String onReinviaAPredisposizione(Context context) throws Throwable {
		  java.util.List<LettereIgbTO> listaLettere=context.getModel(LIST_LETTERE_TO_SIGN);
	    	//String rowNum = context.getCommandParameter("deleteLetteraDecreto");
	    	
	       String rowNum =  getParameter(context, "selectedLettera");
	    	
	       LettereIgbTO lettera=listaLettere.get(new Integer(rowNum));
		   letterePreRegManager.aggiornaStatusLettera(lettera.getId(), "1", getUtenteInSessione().getUtente().getCodiUtente(), NomeFunzioneConstants.FIRMA_LETTERE_PRE_REG);
		   
		   context.addInfo("info.update.success");
		   return startController(context);
		  
	  }
	 
	
	  public String onDeleteLetteraDecreto(Context context) throws Throwable {

	    	java.util.List<LettereIgbTO> listaLettere=context.getModel(LIST_LETTERE_TO_SIGN);
	    	//String rowNum = context.getCommandParameter("deleteLetteraDecreto");
	    	
	    	String rowNum =  getParameter(context, "selectedLettera");
	    	
	    	LettereIgbTO lettera=listaLettere.get(new Integer(rowNum));
	    	
	    	letterePreRegManager.deleteLettera(lettera, Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	    	
	    	java.util.List<LettereIgbTO> listaLettereNew=letterePreRegManager.findLettereByIdDecreto(lettera.getFascicoli().getId()) ;
	    	if (listaLettereNew==null || listaLettereNew.size()==0){
				PaginatorUtil.removePaginator(context, LIST_LETTERE_TO_SIGN);
			}else {
				PaginatorUtil.addPaginator(listaLettereNew, LIST_LETTERE_TO_SIGN, Paginator.PAGE_RANGE_15, context);
			}
	    	
	    	context.addInfo("info.delete.success");
	    	return startController(context);
			
	    }
	  
	  
	  
	
/*		public String onInvioPec(Context context) throws Throwable {
		
		
					
					mailManager.popolaMailSender(FLAG_PEC);
					MimeMessage message = creaMessaggioPec( pec);
					this.pec.send(message);
					PecMessaggiInviatiTO messageToSave = mailManager.createMessageToSave(message, null);
					context.valorizeAudit(messageToSave, Constants.MAIL_FORM);
					mailManager.salvaMessaggioInviato(messageToSave, getUtenteInSessione());
					context.addInfo("info.msg.sent.succes", "");
				
			
			context.setDataModel("testoMail", form.getMessage());
			return invioMailPecView;
	}

	
	private MimeMessage creaMessaggioPec( JavaMailSenderImpl mailSender) throws MessagingException, Exception {
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper =null;
		
		/** caso con allegato **
	        File convFile =null;
    		convFile = new File(nomeFileAllegato);
    	    convFile.createNewFile(); 
    	    FileOutputStream fos = new FileOutputStream(convFile); 
    	    fos.write(form.getUpFile().getBytes());
    	    fos.close(); 
    	    helper = new MimeMessageHelper(message, true);
    		helper.setText(form.getMessage(), true);
    		helper.setSubject(form.getOggetto()); 
    		helper.addAttachment(form.getUpFile().getOriginalFilename(), convFile);
			
	    	helper.getMimeMessage().addRecipients(Message.RecipientType.TO, InternetAddress.parse(form.getRecipientTo()));
			if(form.getRecipientCc() != null && form.getRecipientCc() != ""){
				helper.getMimeMessage().addRecipients(Message.RecipientType.CC, InternetAddress.parse(form.getRecipientCc()));
			}
		
		
		helper.setFrom(new InternetAddress(mailSender.getUsername()));
		return message;
		
	}*/
	
	
	
	
	
	
	
	
	 
	 
	public void setStartView(String startView) {
		this.startView = startView;
	}
		 
		 
		 
	 

}
