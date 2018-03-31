package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.DelegaForm;

public class DelegaValidator extends AbstractDemValidator {
	
	public boolean onLoadDeleganti(Context context) throws Throwable{
		
		DelegaForm form = context.getForm();
		checkEmpty(context, form.getTipoFirma(),"label.tipo.firma");
		return !context.hasErrors();
	}
	
	public boolean onLoadDelegati(Context context) throws Throwable{
		
		DelegaForm form = context.getForm();
		checkEmpty(context, form.getTipoFirma(), "label.tipo.firma");
		checkEmpty(context, form.getDelegante(), "label.delegante");
		return !context.hasErrors();
	}
	
	public boolean onDelega(Context context) throws Throwable{
		DelegaForm form = context.getForm();
		checkEmpty(context, form.getTipoFirma(), "label.tipo.firma");
		checkEmpty(context, form.getDelegante(), "label.delegante");
		checkEmpty(context, form.getDelegato(), "label.delegato");
		return !context.hasErrors();
	}

}
