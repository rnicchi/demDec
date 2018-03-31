package it.mef.bilancio.demdec.web.spring.validator;



import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.bsn.sh.utils.ValidationUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.ListMsgSentForm;
import it.mef.bilancio.demdec.web.spring.form.MailForm;

public class MailValidator extends AbstractDemValidator {
	
	public boolean invioPecDaForm(Context context) throws Throwable{

		MailForm form = (MailForm)context.getForm();
		
		if(checkEmpty(context, form.getRecipientTo(), "label.destinatari.TO")){
			String [] indirizziTo = form.getRecipientTo().split("\\,");
			checkEmail(context, indirizziTo, "label.destinatari.TO");
		}
		if(!StringUtil.isEmpty(form.getRecipientCc())){
			String [] indirizziCc = form.getRecipientCc().split("\\,");
			checkEmail(context, indirizziCc, "label.destinatari.Cc");
		}
		checkEmpty(context, form.getOggetto(), "label.oggetto");
		return !context.hasErrors();
	}
	
	public boolean invioMailNoPecDaForm(Context context) throws Throwable{

		MailForm form = (MailForm)context.getForm();
		if(checkEmpty(context, form.getRecipientTo(), "label.destinatari.TO")){
			String [] indirizziTo = form.getRecipientTo().split("\\,");
			checkEmail(context, indirizziTo, "label.destinatari.TO");
		}
		if(!StringUtil.isEmpty(form.getRecipientCc())){
			String [] indirizziCc = form.getRecipientCc().split("\\,");
			checkEmail(context, indirizziCc, "label.destinatari.Cc");
		}
		checkEmpty(context, form.getOggetto(), "label.oggetto");
		return !context.hasErrors();
	}

	public boolean filteredListByDate(Context context) throws Throwable{
		ListMsgSentForm form = (ListMsgSentForm)context.getForm();
		if(form.getFilterDate() != null &&  form.getFilterDate() != ""){
			checkDate(context, form.getFilterDate(), "label.data.invio");
		}
		return !context.hasErrors();
	}
	
	protected boolean checkEmail(Context context, String[] indirizzi, String codeField) throws Throwable{
		boolean res=true;
		for (String indirizzo : indirizzi) {
			if(!ValidationUtil.isEmail(indirizzo.trim())){
				context.addError("error.invalidAddress", indirizzo);
				res=false;
			}
		}
		return res;
	}
	

}
