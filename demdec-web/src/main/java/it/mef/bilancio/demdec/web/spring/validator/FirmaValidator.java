package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.FirmaDocumentiForm;

public class FirmaValidator extends AbstractDemValidator{
	
	public boolean firma(Context context) throws Throwable{
		
		FirmaDocumentiForm form = context.getForm();
		checkEmpty(context, form.getPin(), "label.pin");
		//checkFixedLength(context, form.getPin(), 6, "label.pin");//TODO si aspetta di sapere se ci sono restrizioni sulla lunghezza del pin
		checkEmpty(context, form.getSelezioni(), null, "error.selection.null");
		return !context.hasErrors();
		
	}
	
	public boolean sigla(Context context) throws Throwable{
		
		FirmaDocumentiForm form = context.getForm();
		checkEmpty(context, form.getSelezioni(), null, "error.selection.null");
		return !context.hasErrors();
		
	}
	
	public boolean verifica(Context context) throws Throwable{
		
		FirmaDocumentiForm form = context.getForm();
		checkEmpty(context, form.getSelezioni(), null, "error.selection.null");
		return !context.hasErrors();
		
	}
	
	public boolean bollina(Context context) throws Throwable{
		
		FirmaDocumentiForm form = context.getForm();
		checkEmpty(context, form.getSelezioni(), null, "error.selection.null");
		return !context.hasErrors();
		
	}
	
	public boolean onDigestTagVisibile(Context context) throws Throwable{
		
		FirmaDocumentiForm form = context.getForm();
		checkEmpty(context, form.getPin(), "label.pin");
		//checkFixedLength(context, form.getPin(), 8, "label.pin");//TODO si aspetta di sapere se ci sono restrizioni sulla lunghezza del pin
		return !context.hasErrors();
		
	}

}
