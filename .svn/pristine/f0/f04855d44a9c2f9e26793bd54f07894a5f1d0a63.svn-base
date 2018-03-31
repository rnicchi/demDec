package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.to.AnagCdrDemTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.web.spring.form.ModLetterePreRegForm;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import java.util.List;

public class ModLetterePreRegValidator extends AbstractDemValidator {
	
		@SuppressWarnings("unchecked")
		public boolean onRicercaDecreti(Context context) throws Throwable {
			ModLetterePreRegForm form = context.getForm();
			if(!StringUtil.isEmpty(form.getNumeDecreto())){
				checkNumeric(context, form.getNumeDecreto(), "label.numeroDecreto");
			}
			if(!StringUtil.isEmpty(form.getNumePat())){
				checkNumeric(context, form.getNumePat(), "label.numeroPatrimonio");
			}
			if(!StringUtil.isEmpty(form.getCdr())){
				AnagCdrDemTO cdr = ((List<AnagCdrDemTO>) context.getModel(SessionAttributes.LIST_ANAG_CDR_DEM)).get(0);
				if (!cdr.getAnagAmminDem().getId().getAmmin().equalsIgnoreCase(form.getAmministrazione())){
					context.addError("error.cdr.no.ammin");
				}
				if (!form.getAnnoDecreto().equalsIgnoreCase(""+cdr.getId().getFkAnnoEse())){
					context.addError("error.cdr.no.anno");
				}
			}
	
			if (!StringUtil.isEmpty(form.getAmministrazione())){
				AnagAmminDemTO amm = ((List<AnagAmminDemTO>)context.getModel(SessionAttributes.LIST_AMMIN_DEM)).get(0);
				if (!form.getAnnoDecreto().equalsIgnoreCase(""+amm.getId().getFkAnnoEse())){
					context.addError("error.amm.no.anno");
				}
			}
	
			if (!StringUtil.isEmpty(form.getTipologiaDecreto())){
				AnagTipologiaDecretoTO tipo = ((List<AnagTipologiaDecretoTO>)context.getModel(SessionAttributes.LIST_TIPOLOGIA_DECRETO)).get(0);
				if (!form.getTipoDecreto().equalsIgnoreCase(tipo.getAnagTipoDecreto().getId())){
					context.addError("error.tipologia.no.tipo");
				}
			}
	
			
			return  !context.hasErrors();
		}
		
		public boolean onCaricaTipologiaDecretoFadPage(Context context)throws Throwable{
			ModLetterePreRegForm form = context.getForm();
			checkEmpty(context, form.getTipoDecreto(), "label.tipoDecreto");
			return !context.hasErrors();
		}

		public boolean onCaricaAmmin(Context context)throws Throwable{
			ModLetterePreRegForm form = context.getForm();
			checkEmpty(context, form.getAnnoDecreto(), "label.anno.dec");
			return !context.hasErrors();
		}
		
		public boolean onSalvaPersonalizza(Context context)throws Throwable{
			ModLetterePreRegForm form = context.getForm();
			checkEmpty(context, form.getTextContenuto(), "label.testiPers.testo");
			return !context.hasErrors();
		}
		
}
