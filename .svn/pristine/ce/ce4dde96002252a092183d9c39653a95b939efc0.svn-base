package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.FirmaLetterePreRegForm;

public class FirmaLetterePreRegValidator extends AbstractDemValidator{
	
	
			public boolean onFirma(Context context) throws Throwable{
				FirmaLetterePreRegForm form = context.getForm();
				checkEmpty(context, form.getPin(), "label.pin");
				//checkFixedLength(context, form.getPin(), 8, "label.pin"); //TODO si aspetta di sapere se ci sono restrizioni sulla lunghezza del pin
				checkEmpty(context, form.getSelezioni(), null, "error.selection.null");
				return !context.hasErrors();
			}
	
	
}
