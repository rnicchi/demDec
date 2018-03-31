package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.almavivaitalia.web.sh.utils.PageMessages;
import it.mef.bilancio.demdec.manager.DocumentiManager;
import it.mef.bilancio.demdec.manager.InvioPecPartecipazioneManager;
import it.mef.bilancio.demdec.manager.LetterePreRegManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.MailManager;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.PartecipazioniTO;
import it.mef.bilancio.demdec.to.PecMessaggiInviatiTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.InvioPecPartecipazioneForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.FileUtil;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;

//Read more: http://javarevisited.blogspot.com/2013/07/ile-upload-example-in-servlet-and-jsp-java-web-tutorial-example.html#ixzz3zaw5VerT



@RequestMapping(value = ConstantsRequestMapping.INVIO_PEC_PARTECIPAZIONE)
public class InvioPecPartecipazioneController  extends AbstractDemFormController implements WebConstants, SessionAttributes{

	 private static Logger _LOG = Logger.getLogger(InvioPecPartecipazioneController.class);
	
	 private String startView;	
	 
	 private String listaDecretiView;
	 
	 private String invioMailPecView;
	 
	 @Autowired
	 private JavaMailSenderImpl pec;
	 
	 @Autowired
	 private JavaMailSenderImpl peo;
	 
	 @Autowired
	 private InvioPecPartecipazioneManager invioPecPartecipazioneManager;
	 
	 @Autowired
	 private DocumentiManager documentiManager;
	 
	 
//	 private SimpleMailMessage simpleMailMessage;
//	 public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
//			this.simpleMailMessage = simpleMailMessage;
//		}

	 @Autowired
	 private ListManager listManager;
	
	 @Autowired
	 private LetterePreRegManager letterePreRegManager;
	 
	 @Autowired
	 private  MailManager mailManager;
	 
	 public void setStartView(String startView) {
			this.startView = startView;
	}

	public void setListaDecretiView(String listaDecretiView) {
			this.listaDecretiView = listaDecretiView;
	}
	
	public void setInvioMailPecView(String invioMailPecView) {
		this.invioMailPecView = invioMailPecView;
	}
	 
	@Override
	public String startController(Context context) throws Throwable {
		context.setCurrentNode("DemDec.menu.InvioPecPartecipazione");
		context.setDataModel(SessionAttributes.LIST_ANNO_ESE, listManager.loadEserciziDemCG());
		List<AnagTipoDecretoTO> listaTipiDecr=listManager.loadAnagTipoDecreto();
		context.setDataModel(SessionAttributes.LIST_TIPI_DECRETI, listaTipiDecr);
		context.setDataModel(SessionAttributes.LIST_ANAG_UFF, listManager.loadAnagUfficiAttivi());
		
		return startView;
	}
	
	
	public String onRicercaDecreti(Context context)throws Throwable{
		InvioPecPartecipazioneForm form=(InvioPecPartecipazioneForm) context.getForm();
		
		if(!form.isValid()){
			return startView;
		}
		
		FascicoliFadSearhTO to = new FascicoliFadSearhTO();
		to.setAmmin(form.getAmministrazione());
		to.setAnnoDecreto(form.getAnnoDecreto());
		to.setCdr(form.getCdr());
		to.setDataRegistrazioneCdcDa(form.getDataRegistrazioneCdcDa());
		to.setDataRegistrazioneCdcA(form.getDataRegistrazioneCdcA());
		to.setNumeDecreto(form.getNumeDecreto());
		to.setNumePat(form.getNumePat());
		to.setStato(Constants.STATO_FAD_APERTO); 
		to.setTipoDecreto(form.getTipoDecreto());
		to.setTipologiaDecreto(form.getTipologiaDecreto());
		to.setUfficio(form.getUfficio());
		
		java.util.List<FascicoliTO> lista = getGestioneFadManager().getFascicoliFadPecPartecipazione(to);
		
		//LettereIgbTO letteraTo=new LettereIgbTO();
		
		//controllo se un fascicolo ha già lettere associate
//		for (int i = 0; i < lista.size(); i++) {
//			letteraTo.setFascicoli(lista.get(i));
//			List<LettereIgbTO> listaLettere=letterePreRegManager.findByLettera(letteraTo);
//			lista.get(i).setFlagLetterePreReg((listaLettere!=null && listaLettere.size()>0)?1:0);
//		}
		
		if (lista==null || lista.size()==0){
			PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
			context.addWarning("warning.empty");
			return startView;
		}
		PaginatorUtil.addPaginator(lista, LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);
		//context.setDataModel(SessionAttributes.LIST_FASCICOLI_FAD, lista);
		
		return  listaDecretiView;
	}
	
	public String onBackFromPec(Context context)throws Throwable{
		List<FascicoliTO> listaFascicoli=context.getModel(LIST_FASCICOLI_FAD);
		PaginatorUtil.addPaginator(listaFascicoli, LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);
		return  listaDecretiView;
	}
	

	
	public String onComponiPec(Context context)throws Throwable{
		InvioPecPartecipazioneForm form=(InvioPecPartecipazioneForm) context.getForm();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		if(!form.isValid()){
			return listaDecretiView;
		}
		
		java.util.List<FascicoliTO> lista =context.getModel(LIST_FASCICOLI_FAD);
		String rowNum=context.getCommandParameter("componiPec");
		FascicoliTO fascTo=lista.get(Integer.valueOf(rowNum));
		
		List<PartecipazioniTO> listPart=invioPecPartecipazioneManager.findByIdFascicolo(new Integer(fascTo.getId().toString()));
	
		String message="";
		String oggetto="";
		PartecipazioniTO partTo=null;
		if (listPart!=null && listPart.size()>0){
		
			 partTo=listPart.get(0);
			
		/*	 message="SI COMUNICA CHE IN DATA "+(partTo.getDataDef()==null?"<b>***</b>":partTo.getDataDef())+"&nbsp;CON DECRETO n. "
					+(partTo.getNumeNumDecreto()==null?"<b>***</b>": partTo.getNumeNumDecreto())+"&nbsp;REGISTRATO DALLA CORTE DEI CONTI IN DATA "
					+(partTo.getDataReg()==null?"<b>***</b>":partTo.getDataReg() )+"&nbsp;REGISTRAZIONE N. "+ (partTo.getNumeRegistrazione()==null?"<b>***</b>":partTo.getNumeRegistrazione())+
					"&nbsp;DELL'UFFICIO "+(partTo.getNumeUfficioCdc()==null?"<b>***</b>":partTo.getNumeUfficioCdc())+"&nbsp;SONO STATE APPORTATE AL BILANCIO PER L'ESERCIZIO FINANZIARIO "
					+(partTo.getAnnoEse()==null?"<b>***</b>":partTo.getAnnoEse())+"&nbsp;LE VARIAZIONI COME DALL'UNITA COPIA DEL DECRETO STESSO.";
			*/ 
			
			 //	form.setMessage(message);
			 PageMessages messages= ContextHelper.getPageMessages(context.getRequest());
		    
			 String valoreMancante=messages.getMessageFromBundle("valoreMancante"); 
			 oggetto=messages.getMessageFromBundle("oggettoMailPec", partTo.getAnnoEse().toString());
			 valoreMancante=getMessageSource().getMessage("valoreMancante");
			 
			 String part1=partTo.getDataDef()==null?valoreMancante:sdf.format(partTo.getDataDef());
			 String part2=partTo.getNumeNumDecreto()==null?valoreMancante: partTo.getNumeNumDecreto().toString();
			 String part3=partTo.getDataReg()==null?valoreMancante:partTo.getDataReg().toString();
			 String part4=partTo.getNumeRegistrazione()==null?valoreMancante:partTo.getNumeRegistrazione().toString();
			 String part5=partTo.getNumeUfficioCdc()==null?valoreMancante:partTo.getNumeUfficioCdc().toString();
			 String part6=partTo.getAnnoEse()==null?valoreMancante:partTo.getAnnoEse().toString();
			 
			 message= messages.getMessageFromBundle("testoMailPec", part1, part2, part3, part4, part5, part6);
			 
			
		} 
		
		List<String> destinatari=invioPecPartecipazioneManager.findDestinatariMailPec(new BigDecimal(fascTo.getId().toString()));
		String dest="";
		
		for (int i = 0; i < destinatari.size(); i++) {
			if(i<(destinatari.size()-1)){
				dest+=destinatari.get(i)+", ";
			}else{
				dest+=destinatari.get(i);
			}
		}
		
		form.setRecipientTo(dest);
		context.setDataModel("testoMail", message);
		
		form.setOggetto(oggetto);
		
		
		/****** pezzo per l'allegato atto decreto automatico  *******/
		DocumentiTO docTo=invioPecPartecipazioneManager.loadDocumentoByGuidFascicoloETipo(fascTo.getCodiGuidFascicolo(),  Constants.TIPO_ATTO_DECRETO);
		if(docTo==null){
			context.addError("error.resourceNotFound");
			return listaDecretiView;
		}
		
		
		context.setDataModel(FASCICOLO_PEC_PARTECIPAZIONE, fascTo);
		
		
		 //TODO scommentare
		ResponseDEMBILClient res = documentiManager.wsDownloadDocumentoFascicoloAttoDecreto(docTo.getCodiGuidFascicolo(), docTo.getCodiGuidDocumento());
		DocumentContentTO docRespTo= null;
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			docRespTo= (DocumentContentTO)res.getOutputTO();
		}else{
			context.addError("error.ws.get.doc.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			return listaDecretiView;
		}
		
		context.setDataModel(NOME_FILE_ATTO_DECRETO, docRespTo.getFileName());
		/****** fine pezzo per l'allegato atto decreto automatico  *******/
		
		
		return invioMailPecView;
	}
	
	
	
	public String onApriPdf(Context context)throws Throwable{
					FascicoliTO fascTo=context.getModel(FASCICOLO_PEC_PARTECIPAZIONE);
		
					DocumentiTO docTo=invioPecPartecipazioneManager.loadDocumentoByGuidFascicoloETipo(fascTo.getCodiGuidFascicolo(),  Constants.TIPO_ATTO_DECRETO);
					if(docTo==null){
						context.addError("error.resourceNotFound");
						return invioMailPecView;
					}
					ResponseDEMBILClient res = documentiManager.wsDownloadDocumentoFascicoloAttoDecreto(docTo.getCodiGuidFascicolo(), docTo.getCodiGuidDocumento());
					
					if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
							FileUtil.downloadFromResponseWs(res, context);
					}else{
						context.addError("error.ws.get.doc.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
						return invioMailPecView;
					}
					return null;
	}
	
	
	
	
	public String onInvioPec(Context context) throws Throwable {
		FascicoliTO fascTo=context.getModel(FASCICOLO_PEC_PARTECIPAZIONE);
		InvioPecPartecipazioneForm form = (InvioPecPartecipazioneForm)context.getForm();
		
			if(form.isValid()){
					mailManager.popolaMailSender(FLAG_PEC);
			//		MimeMessage message = creaMessaggioPec(form, pec);
					MimeMessage message = creaMessaggioPecConAllegatoAttoDecreto(form, pec, fascTo);
					if(message!=null){
						this.pec.send(message);
						PecMessaggiInviatiTO messageToSave = mailManager.createMessageToSave(message, null);
						context.valorizeAudit(messageToSave, Constants.MAIL_FORM);
						mailManager.salvaMessaggioInviato(messageToSave, getUtenteInSessione());
						context.addInfo("info.msg.sent.succes", "");
					}else {
						context.addError("error.applicativo");
					}
				
			}
			
			context.setDataModel("testoMail", form.getMessage());
			return invioMailPecView;
	}


	
private MimeMessage creaMessaggioPec(InvioPecPartecipazioneForm form,  JavaMailSenderImpl mailSender) throws MessagingException, Exception {
	
	MimeMessage message = mailSender.createMimeMessage();
	
	MimeMessageHelper helper =null;
	
	/** caso con allegato **/
        File convFile =null;
    	if(form.getUpFile()!=null && !StringUtil.isEmpty(form.getUpFile().getOriginalFilename())){
    		convFile = new File(form.getUpFile().getOriginalFilename());
    	    convFile.createNewFile(); 
    	    FileOutputStream fos = new FileOutputStream(convFile); 
    	    fos.write(form.getUpFile().getBytes());
    	    fos.close(); 
    	    helper = new MimeMessageHelper(message, true);
    		helper.setText(form.getMessage(), true);
    		helper.setSubject(form.getOggetto()); 
    		helper.addAttachment(form.getUpFile().getOriginalFilename(), convFile);
		
		}else{
			helper = new MimeMessageHelper(message);
			helper.setText(form.getMessage(), true);
			helper.setSubject(form.getOggetto()); 
		}
    	helper.getMimeMessage().addRecipients(Message.RecipientType.TO, InternetAddress.parse(form.getRecipientTo()));
		if(form.getRecipientCc() != null && form.getRecipientCc() != ""){
			helper.getMimeMessage().addRecipients(Message.RecipientType.CC, InternetAddress.parse(form.getRecipientCc()));
		}
	
	
	helper.setFrom(new InternetAddress(mailSender.getUsername()));
	return message;
	
}



private MimeMessage creaMessaggioPecConAllegatoAttoDecreto(InvioPecPartecipazioneForm form,  JavaMailSenderImpl mailSender, FascicoliTO fascTo) throws MessagingException, Exception,  Throwable {
	
	MimeMessage message = mailSender.createMimeMessage();
	
	MimeMessageHelper helper =null;
	
	DocumentiTO docTo=invioPecPartecipazioneManager.loadDocumentoByGuidFascicoloETipo(fascTo.getCodiGuidFascicolo(),  Constants.TIPO_ATTO_DECRETO);
	ResponseDEMBILClient res = documentiManager.wsDownloadDocumentoFascicoloAttoDecreto(docTo.getCodiGuidFascicolo(), docTo.getCodiGuidDocumento());
	File convFile=null;
	if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
		DocumentContentTO dcTO= (DocumentContentTO)res.getOutputTO();
		
		convFile = new File(dcTO.getFileName());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(dcTO.getContent());
	    fos.close(); 
	
	/** caso con allegato **/
	    helper = new MimeMessageHelper(message, true);
		helper.setText(form.getMessage(), true);
		helper.setSubject(form.getOggetto()); 
		helper.addAttachment(dcTO.getFileName(), convFile);
		
    	helper.getMimeMessage().addRecipients(Message.RecipientType.TO, InternetAddress.parse(form.getRecipientTo()));
		if(form.getRecipientCc() != null && form.getRecipientCc() != ""){
			helper.getMimeMessage().addRecipients(Message.RecipientType.CC, InternetAddress.parse(form.getRecipientCc()));
		}
	
	
		helper.setFrom(new InternetAddress(mailSender.getUsername()));
	
	}else{
		//context.addError("error.ws.get.doc.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
		//return invioMailPecView;//TODO togliere
		return null;
	}
	
	return message;
	
}

	
	
	public String onNuovaRicerca(Context context)  {
		InvioPecPartecipazioneForm form=(InvioPecPartecipazioneForm) context.getForm();
	    	
	    	form.setAmministrazione(null);
	    	form.setAnnoDecreto(null);
	    	form.setCdr(null);
	    	form.setCreatoDa(null);
	    	form.setCdr(null);
	    	form.setDataRegistrazioneCdcDa(null);
	    	form.setDataRegistrazioneCdcA(null);
	    	form.setDataCreazione(null);
	    	form.setDataModifica(null);
	    	form.setDecTipoDecreto(null);
	    	form.setDescDecreto(null);
	    	form.setDescStato(null);
	    	form.setModificatoDa(null);
	    	form.setNumeDecreto(null);
	    	form.setNumePat(null);
	    	form.setRadioButtonDecreti(null);
	    	form.setDecTipoDecreto(null);
	    	form.setDescDecreto(null);
	    	form.setDescStato(null);
	    	form.setModificatoDa(null);
	    	form.setDataModifica(null);
	    	form.setDataCreazione(null);
	    	form.setStato(null);
	    	form.setUfficio(null);
	    	form.setUfficioCreatore(null);
	    	form.setTipoDecreto(null);
	    	form.setTipologiaDecreto(null);
	    	
		return startView;
		
	}
	
	
	public String onCaricaTipologiaDecretoFadPage(Context context)throws Throwable{
		InvioPecPartecipazioneForm form=(InvioPecPartecipazioneForm) context.getForm();
			if (form.isValid()){
				if(form.getTipoDecreto() != null && !"".equals(form.getTipoDecreto())){
					context.setDataModel(LIST_TIPOLOGIA_DECRETO, listManager.tipologiaDecretoList(Integer.parseInt(form.getTipoDecreto())));
				}
				else {
					context.setDataModel(LIST_TIPOLOGIA_DECRETO, listManager.tipologiaDecretoList(null));
				}
			}
			//return getFascicoloFadView();
			return startView;
	}
	
		
	public String onCaricaAmmin(Context context)throws Throwable{
		InvioPecPartecipazioneForm form = (InvioPecPartecipazioneForm) context.getForm();
		if (form.isValid()){
			context.setDataModel(SessionAttributes.LIST_AMMIN_DEM, listManager.getAmminDemByAnnoEse(form.getAnnoDecreto()));
		}
		return startView;
	}
		
		

}
