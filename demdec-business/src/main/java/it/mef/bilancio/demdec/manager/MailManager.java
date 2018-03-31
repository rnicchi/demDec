package it.mef.bilancio.demdec.manager;

import java.util.Date;
import java.util.List;

import javax.mail.Address;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.mef.bilancio.demdec.to.DocumentiViewTO;
import it.mef.bilancio.demdec.to.MailTestiTO;
import it.mef.bilancio.demdec.to.PecMessaggiInviatiTO;


public interface MailManager extends AbstractDemManager{
	
	public void salvaMessaggioInviato(PecMessaggiInviatiTO messaggioInviato, Utente utenteInSessione) throws Throwable;
	public void popolaMailSender(int pecFlag) throws Throwable;
	public MimeMessage invioPecDaFunzione(String codiFunzione, Utente utenteInSessione, String address) throws Throwable;
	public MimeMessage invioPeoDaFunzione(String codiFunzione, Utente utenteInSessione, String address) throws Throwable;
	public MimeMessage invioPeoUltimaFirma(String codiFunzione, Utente utenteInSessione, String address, DocumentiViewTO documentiViewTO) throws Throwable;
	public MimeMessage creaMessaggioStandard(MailTestiTO mailTestiTO, JavaMailSenderImpl mailSender, String address) throws Throwable;
	public PecMessaggiInviatiTO createMessageToSave(MimeMessage messaggio, String codiFunzione) throws Throwable;
	public List<PecMessaggiInviatiTO> listaMessaggiInviati() throws Throwable;
	public List<PecMessaggiInviatiTO> listSentMessageByDate(Date date)throws Throwable;
	public String recipientsToString (Address[] allRecipients) throws Throwable;
	public MimeMessage invioPecDaFunzione(String codiFunzione,Utente utenteInSessione, String address, String textMailPlus) throws Throwable;
	public MimeMessage invioPeoDaFunzione(String codiFunzione,Utente utenteInSessione, String address, String textMailPlus) throws Throwable;
	public MimeMessage invioPecDaFunzione(String codiFunzione, Utente utenteInSessione, String address, String textOggetto, String textMail) throws Throwable;
	public MailTestiTO findMailTestiByCodiFunzione(String codiFunzione) throws Throwable;
	
}
