package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.form.GestioneTipologiaDecretoForm;

public class GestioneTipologiaDecretoValidator extends AbstractDemValidator  {

	public boolean onConfermaDecreto(Context context) throws Throwable {
		GestioneTipologiaDecretoForm form = context.getForm();

		checkEmpty(context, form.getDescTipologia(), "label.nuova.tipologia.decreto");
		checkEmpty(context, form.getTipoDecreto(), "label.tipo.decreto");
		checkEmpty(context, form.getModelloIter(), "label.modello.iter");
		checkMaxLength(context, form.getDescTipologia(), Constants.LUNGHEZZA_MASSIMA_DESCR_TIPOLOGIA_DECRETO, "label.tipologia.decreto");
		return !context.hasErrors();
	}

//	public boolean onModificaDecreto(Context context) throws Throwable {
//		GestioneTipologiaDecretoForm form = context.getForm();
//
//		if(StringUtil.isEmpty(form.getSelectedTipologia()))
//			context.addError("error.tipologia.decreto.null");
//		return !context.hasErrors();
//	}
	public boolean onConfermaModificaDecreto(Context context) throws Throwable {
		GestioneTipologiaDecretoForm form = context.getForm();

		checkEmpty(context, form.getDescTipologia(), "label.descr.tipologia.decreto");
		checkEmpty(context, form.getTipoDecreto(), "label.tipo.decreto");
		checkEmpty(context, form.getModelloIter(), "label.modello.iter");
		checkMaxLength(context, form.getDescTipologia(), Constants.LUNGHEZZA_MASSIMA_DESCR_TIPOLOGIA_DECRETO, "label.tipologia.decreto");

		return !context.hasErrors();
	}
//	public boolean onEliminaDecreto(Context context) throws Throwable {
//		GestioneTipologiaDecretoForm form = context.getForm();
//
//		if(StringUtil.isEmpty(form.getSelectedTipologia()))
//			context.addError("error.tipologia.decreto.null");
//		return !context.hasErrors();
//	}

}
