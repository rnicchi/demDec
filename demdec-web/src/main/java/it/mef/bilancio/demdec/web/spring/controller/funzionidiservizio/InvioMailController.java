package it.mef.bilancio.demdec.web.spring.controller.funzionidiservizio;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.MailManager;
import it.mef.bilancio.demdec.to.PecMessaggiInviatiTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.MailForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = ConstantsRequestMapping.MAIL)
public class InvioMailController  extends AbstractDemFormController{
	
	private String startView;
	
	@Autowired
	private JavaMailSenderImpl pec;
	@Autowired
	private JavaMailSenderImpl peo;
	@Autowired
	private MailManager mailManager;
	
	public String getStartView() {
		return startView;
	}

	public void setStartView(String startView) {
		this.startView = startView;
	}
	
	@Override
	public String startController(Context context) throws Throwable {
		context.setCurrentNode("DemDec.menu.InvMail");
		return startView;
	}
	
	/**
	 * Il metodo viene utilizzato per inviare una PEC da una vista tramite un form. Viene eseguita prima di tutto la validazione del form e nel caso in sia positiva
	 * viene eseguito l'invio della mail e il relativo salvatggio di alcuni dati del messaggio inviato nella tabella D_PEC_MESSAGGI_INVIATI, tale messaggio viene popolato
	 * con i relativi campi del form.
	 * 
	 * NOTE:  i parametri di connessione sono impostati nel bean pec e vengono presi dalla tabella D_TAB_SERV_DEM
	 * 
	 * @param context
	 * @return
	 * @throws Throwable
	 */
	public String invioPecDaForm(Context context) throws Throwable {
		
		MailForm form = (MailForm)context.getForm();

		if(form.isValid()){
				
				mailManager.popolaMailSender(FLAG_PEC);
				MimeMessage message = creaMessaggioDaForm(form, pec);
				this.pec.send(message);
				PecMessaggiInviatiTO messageToSave = mailManager.createMessageToSave(message, null);
				context.valorizeAudit(messageToSave, Constants.MAIL_FORM);
				mailManager.salvaMessaggioInviato(messageToSave, getUtenteInSessione());
				context.addInfo("info.msg.sent.succes", "");
			
		}
		return startView;
	}
	
	/**
	 * Il metodo viene utilizzato per inviare una e-amil standard da una vista tramite un form. Viene eseguita prima di tutto la validazione del form e nel caso in sia positiva
	 * viene eseguito l'invio della mail e il relativo salvatggio di alcuni dati del messaggio inviato nella tabella D_PEC_MESSAGGI_INVIATI, tale messaggio viene popolato
	 * con i relativi campi del form.
	 * 
	 * NOTE:  i parametri di connessione sono impostati nel bean standardMail e vengono presi dalla tabella D_TAB_SERV_DEM
	 * 
	 * @param context
	 * @return
	 * @throws Throwable
	 */
	public String invioMailNoPecDaForm(Context context) throws Throwable{
		
		MailForm form = (MailForm)context.getForm();

		if(form.isValid()){
			mailManager.popolaMailSender(FLAG_NO_PEC);
			MimeMessage message = creaMessaggioDaForm(form, peo);
			this.peo.send(message);
			PecMessaggiInviatiTO messageToSave = mailManager.createMessageToSave(message, null);
			context.valorizeAudit(messageToSave, Constants.MAIL_FORM);
			mailManager.salvaMessaggioInviato(messageToSave, getUtenteInSessione());
			context.addInfo("info.msg.sent.succes", "");
		}
		
		return startView;
		
	}
	

	/**
	 * Il metodo viene utilizzato per la creazione del messaggio nell'invio da form.
	 * @param form
	 * @return MimeMessage
	 * @throws MessagingException
	 * @throws Exception
	 */
	private MimeMessage creaMessaggioDaForm(MailForm form, JavaMailSenderImpl mailSender) throws MessagingException, Exception {
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.getMimeMessage().addRecipients(Message.RecipientType.TO, InternetAddress.parse(form.getRecipientTo()));
			if(form.getRecipientCc() != null && form.getRecipientCc() != ""){
				helper.getMimeMessage().addRecipients(Message.RecipientType.CC, InternetAddress.parse(form.getRecipientCc()));
			}
		helper.setText(form.getMessage());
		helper.setSubject(form.getOggetto());
		helper.setFrom((new InternetAddress(mailSender.getUsername())));
		return message;
	}
	
}
