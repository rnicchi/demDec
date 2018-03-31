package it.mef.bilancio.demdec.web.spring.validator;

import java.util.List;

import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.to.IterFirmaTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.form.GestioneWorkflowFirmeForm;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

public class GestioneWorkflowFirmeValidator extends AbstractDemValidator  {

	public boolean onDettaglioModelloIter(Context context) throws Throwable {

		GestioneWorkflowFirmeForm form = context.getForm();

		if(StringUtil.isEmpty(form.getSelectedModello()))
			context.addError("error.modello.iter.null");
		return !context.hasErrors();

	}
	public boolean onConfermaModelloIter(Context context) throws Throwable {

		GestioneWorkflowFirmeForm form = context.getForm();

		if(StringUtil.isEmpty(form.getAnagFirmatario()))
			context.addError("error.anag.firmatario.null");
		checkEmpty(context, form.getNuovoModello(), "label.workflow.firme.nuovo.modello");
		checkMaxLength(context, form.getNuovoModello(), Constants.LUNGHEZZA_MASSIMA_DESCR_MODELLO_ITER, "label.workflow.firme.nuovo.modello");
		return !context.hasErrors();
	}
	public boolean onConfermaIterFirma(Context context) throws Throwable {

		GestioneWorkflowFirmeForm form = context.getForm();

		checkEmpty(context, form.getDescIter(), "label.modello.iter");
		checkMaxLength(context, form.getDescIter(), Constants.LUNGHEZZA_MASSIMA_DESCR_MODELLO_ITER, "label.modello.iter");
		return !context.hasErrors();
	}
//	public boolean onEliminaModelloIter(Context context) throws Throwable {
//		GestioneWorkflowFirmeForm form = context.getForm();
//
//		if(StringUtil.isEmpty(form.getSelectedModello()))
//			context.addError("error.modello.iter.null");
//		return !context.hasErrors();
//	}
	public boolean onEliminaIterFirma(Context context) throws Throwable {
		GestioneWorkflowFirmeForm form = context.getForm();

		if(StringUtil.isEmpty(form.getSelectedIterFirma()))
			context.addError("error.anag.firmatario.null");
		else {
			List<IterFirmaTO> listaIterFirme = context.getModel(SessionAttributes.LIST_ITER_FIRMA);
			if (listaIterFirme.size()==1)
				context.addError("error.delete.firmatario.unico");
		}
		return !context.hasErrors();
	}

}
