package it.mef.bilancio.demdec.web.spring.validator;



import java.util.List;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.to.AnagCdrDemTO;
import it.mef.bilancio.demdec.web.spring.form.CreaFadForm;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

public class CreaFadValidator extends AbstractDemValidator {
	
	public boolean onCaricaAmministrazioni(Context context) throws Throwable{

		CreaFadForm form = (CreaFadForm)context.getForm();
		checkEmpty(context, form.getAnnoDec(), "label.anno.dec");
		
		return !context.hasErrors();
	}
	
	@SuppressWarnings("unchecked")
	public boolean onCaricaCdr(Context context) throws Throwable{
		CreaFadForm form = (CreaFadForm)context.getForm();
		checkEmpty(context, form.getAnnoDec(), "label.anno.dec");
		List<AnagAmminDemTO> ammSelected	=(List<AnagAmminDemTO>) context.getModel(WebConstants.LIST_SELECTED_AMMS);
		
		if (ammSelected==null|| ammSelected.isEmpty()){
			context.addError("error.empty", getMessageSource().getMessage("label.selected.amm"));
		}
		
		
		return !context.hasErrors();
	}
	
	public boolean onCaricaTipologia(Context context) throws Throwable{
	
	CreaFadForm form= (CreaFadForm) context.getForm();
	if(form.getFlagNormativo()==null || !form.getFlagNormativo().equals("1")){
		checkEmpty(context, form.getTipoDec(), "label.decreto.tipo");
	}
	
	return !context.hasErrors();
	}
	
	 public boolean onCaricaCdrFromAmm(Context context) throws Throwable{
		 CreaFadForm form= (CreaFadForm) context.getForm();
		 checkEmpty(context, form.getAmmForCdr(), "label.amministrazione");
		 return !context.hasErrors();
	 }
	
	
	@SuppressWarnings("unchecked")
	public boolean onCreaFad(Context context) throws Throwable {
		CreaFadForm form = (CreaFadForm)context.getForm();
		checkEmpty(context, form.getTipoDec(), "label.decreto.tipo");
		checkEmpty(context, form.getAnnoDec(), "label.anno.dec");
		checkNumeric(context, form.getAnnoDec(), "label.anno.dec");
		checkEmpty(context, form.getNumDec(), "label.decreto.numero");
		checkNumeric(context, form.getNumDec(), "label.decreto.numero");
		checkEmpty(context, form.getDescDec(), "label.decreto.descr");
		checkEmpty(context, form.getTipologiaDec(), "label.decreto.tipologia");

		List<AnagCdrDemTO> cdrSelectedList= context.getModel(WebConstants.LIST_SELECTED_CDRS);
		List<AnagAmminDemTO> ammSelected	=(List<AnagAmminDemTO>) context.getModel(WebConstants.LIST_SELECTED_AMMS); 
		
//		checkEmpty(context, cdrSelectedList, "label.cdr.list");
		checkEmpty(context, form.getUfficio(), "label.ufficio.capofila");
		checkEmpty(context, ammSelected, "label.amministrazione");
		if (ammSelected!=null){
			for (AnagAmminDemTO amm : ammSelected) {
				if (!amm.getId().getFkAnnoEse().toString().equals(form.getAnnoDec())){
					context.addError("error.anno.amm", "");
				}
			}
		}
		
		if (cdrSelectedList!=null){
			for (AnagCdrDemTO cdr : cdrSelectedList) {
				if (!cdr.getId().getFkAnnoEse().toString().equals(form.getAnnoDec())){
					context.addError("error.anno.cdr", "");
				}
			}
		}
		
		return !context.hasErrors();
	}

}
