package it.mef.bilancio.demdec.web.spring.validator;



import java.util.List;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.utils.ValidationUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.to.AnagCdrDemTO;
import it.mef.bilancio.demdec.web.spring.form.CreaFadForm;
import it.mef.bilancio.demdec.web.spring.form.ListMsgSentForm;
import it.mef.bilancio.demdec.web.spring.form.MailForm;
import it.mef.bilancio.demdec.web.spring.form.UploadDecForm;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

public class UploadValidator extends AbstractDemValidator {
	

	
	public boolean onUploadFile(Context context) throws Throwable {
		UploadDecForm form = (UploadDecForm)context.getForm();
//		checkEmpty(context, form.getUpFile(), "label.title.uploadDec");
		
		checkEmpty(context, form.getTipoDoc(), "label.tipo.doc");
		checkEmpty(context, form.getAmm(), "label.amministrazione");
		checkEmpty(context, form.getDesc(), "label.descr.doc");
		checkEmpty(context, form.getIdFasc(), "label.decreto.fascicolo.id");
		
		if ( form.getUpFile().isEmpty()) {
			context.addError("error.empty", "Upload Documenti");
		}
		
		return !context.hasErrors();
	}
	
	
	public boolean onCaricaFascicoli(Context context) throws Throwable {
//		UploadDecForm form = (UploadDecForm)context.getForm();
//		checkEmpty(context, form.getTipoDoc(), "label.tipo.doc");
//		checkEmpty(context, form.getAmm(), "label.amministrazione");
		
		return !context.hasErrors();
	}

}
