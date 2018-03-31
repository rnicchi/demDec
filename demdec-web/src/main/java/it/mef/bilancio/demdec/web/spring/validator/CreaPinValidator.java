package it.mef.bilancio.demdec.web.spring.validator;



import java.util.List;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.utils.ValidationUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.to.AnagCdrDemTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.form.CreaFadForm;
import it.mef.bilancio.demdec.web.spring.form.CreaPinForm;
import it.mef.bilancio.demdec.web.spring.form.ListMsgSentForm;
import it.mef.bilancio.demdec.web.spring.form.MailForm;
import it.mef.bilancio.demdec.web.spring.form.UploadDecForm;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

public class CreaPinValidator extends AbstractDemValidator {
	

	
//	public boolean onUploadFile(Context context) throws Throwable {
//		UploadDecForm form = (UploadDecForm)context.getForm();
//		checkEmpty(context, form.getUpFile(), "label.title.uploadDec");
//		checkEmpty(context, form.getTipoDoc(), "label.tipo.doc");
//		checkEmpty(context, form.getAmm(), "label.amministrazione");
//		checkEmpty(context, form.getDesc(), "label.descr.doc");
//		checkEmpty(context, form.getIdFasc(), "label.decreto.fascicolo.id");
//		
//		return !context.hasErrors();
//	}
	
	public boolean onCreaPin(Context context) throws Throwable {
		CreaPinForm form = (CreaPinForm)context.getForm();
		//checkEmpty(context, form.getCodiceFiscale(), "label.codice.fiscale");
		checkEmpty(context, form.getPin(), "label.pin");
		if (!context.hasErrors()&&form.getPin()!=null&&form.getPin().length()<Constants.LUNGHEZZA_MINIMA_PIN_FIRMA){
			context.addError("error.codice.too.short", ""+Constants.LUNGHEZZA_MINIMA_PIN_FIRMA);
		}
		return !context.hasErrors();
	}

}
