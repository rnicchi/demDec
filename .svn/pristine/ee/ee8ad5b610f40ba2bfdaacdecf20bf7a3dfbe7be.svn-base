package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.to.AnagCdrDemTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.web.spring.form.PredLetterePreRegForm;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import java.util.List;

public class PredLetterePreRegValidator extends AbstractDemValidator {
	
		@SuppressWarnings("unchecked")
		public boolean onRicercaDecreti(Context context) throws Throwable {
			PredLetterePreRegForm form = context.getForm();
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
		
		
		public boolean onStampa (Context context) throws Throwable {
			
			PredLetterePreRegForm form=(PredLetterePreRegForm) context.getForm();
			if(StringUtil.isEmpty(form.getRadioButtonDecreti())){
				context.addError("error.decreto.notSelected");
			}
//		    checkEmpty(context, radio, "error.decreto.notSelected");
			return  !context.hasErrors();
			
		}
		
		public boolean onCaricaTipologiaDecretoFadPage(Context context)throws Throwable{
			PredLetterePreRegForm form = context.getForm();
			checkEmpty(context, form.getTipoDecreto(), "label.tipoDecreto");
			return !context.hasErrors();
		}

		public boolean onCaricaAmmin(Context context)throws Throwable{
			PredLetterePreRegForm form = context.getForm();
			checkEmpty(context, form.getAnnoDecreto(), "label.anno.dec");
			return !context.hasErrors();
		}
		
		public boolean onSalvaPersonalizza(Context context)throws Throwable{
			PredLetterePreRegForm form = context.getForm();
			if(form.getAltroProtocolloEntrata()!=null){
					checkEmpty(context, form.getAltroProtocolloEntrata(), "label.raccolteProvvisorie.protocollo");
					checkNumeric(context, form.getAltroProtocolloEntrata(), "label.raccolteProvvisorie.protocollo");
			}else{
					checkEmpty(context, form.getPredLettereTestiFormList().get(3).getContenuto(), "label.raccolteProvvisorie.protocollo");
			}
			
			checkEmpty(context, form.getPredLettereTestiFormList().get(4).getContenuto(), "label.raccolteProvvisorie.oggetto");
			checkEmpty(context, form.getPredLettereTestiFormList().get(5).getContenuto(), "label.text");
			
			return !context.hasErrors();
		}
		

}
