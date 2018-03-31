package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.to.AnagCdrDemTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.web.spring.form.ConsFADCdcForm;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ConsFADCdcValidator extends AbstractDemValidator  {

	public boolean onCaricaTipologiaDecreto(Context context)throws Throwable{
		ConsFADCdcForm form = context.getForm();
		checkEmpty(context, form.getTipoDecreto(), "label.tipoDecreto");
		return !context.hasErrors();
	}

	public boolean onCaricaAmmin(Context context)throws Throwable{
		ConsFADCdcForm form = context.getForm();
		checkEmpty(context, form.getAnnoDecreto(), "label.anno.dec");
		return !context.hasErrors();
	}

	public boolean onCaricaCdr(Context context)throws Throwable{
		ConsFADCdcForm form = context.getForm();
		checkEmpty(context, form.getAmministrazione(), "label.amministrazione");
		return !context.hasErrors();
	}
	
	
	public boolean onSalvaDatiProtEntrataCdc(Context context) throws Throwable {
		ConsFADCdcForm form = context.getForm();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
		
		if(StringUtil.isEmpty(form.getNumeProtEntrataMod())){	
			context.addError("error.required", getMessageSource().getMessage("label.consFadCdc.numeProtEntrata"));
		}
				
		if(!StringUtil.isEmpty(form.getDataProtEntrataMod())){		
			try{
				sdf.parse(form.getDataProtEntrataMod());
			}catch(ParseException exc){			
				try{
					sdf2.parse(form.getDataProtEntrataMod());				
				}catch(ParseException exc2){
					context.addError("error.dateFormat", getMessageSource().getMessage("label.consFadCdc.dataProtEntrata"));
				}
			}		
		}else{
			context.addError("error.required", getMessageSource().getMessage("label.consFadCdc.dataProtEntrata"));
		}
		
		return  !context.hasErrors();
	}
	
	public boolean onSalvaDatiProtUscitaCdc(Context context) throws Throwable {
		ConsFADCdcForm form = context.getForm();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
		
		if(StringUtil.isEmpty(form.getNumeProtUscitaMod())){
			context.addError("error.required", getMessageSource().getMessage("label.consFadCdc.numeProtUscita"));
		}
				
		if(!StringUtil.isEmpty(form.getDataProtUscitaMod())){		
			try{
				sdf.parse(form.getDataProtUscitaMod());
			}catch(ParseException exc){			
				try{
					sdf2.parse(form.getDataProtUscitaMod());				
				}catch(ParseException exc2){
					context.addError("error.dateFormat", getMessageSource().getMessage("label.consFadCdc.dataProtUscita"));
				}
			}		
		}else{
			context.addError("error.required", getMessageSource().getMessage("label.consFadCdc.dataProtUscita"));
		}
		
		return  !context.hasErrors();
	}
	
	
	
	public boolean onSalvaDatiRegistrazioneCdc(Context context) throws Throwable {
		ConsFADCdcForm form = context.getForm();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
		
		if(StringUtil.isEmpty(form.getNumeRegistrazioneCdc())){
			context.addError("error.required", getMessageSource().getMessage("label.consFadCdc.numeRegistrazione"));
		} else {
			checkNumeric(context, form.getNumeRegistrazioneCdc(), "label.consFadCdc.numeRegistrazione");
		}
		
				
		if(!StringUtil.isEmpty(form.getDataRegistrazioneCdc())){		
			try{
				sdf.parse(form.getDataRegistrazioneCdc());
			}catch(ParseException exc){			
				try{
					sdf2.parse(form.getDataRegistrazioneCdc());				
				}catch(ParseException exc2){
					context.addError("error.dateFormat", getMessageSource().getMessage("label.consFadCdc.dataRegistrazione"));
				}
			}		
		}else{
			context.addError("error.required", getMessageSource().getMessage("label.consFadCdc.dataRegistrazione"));
		}
		
		if(StringUtil.isEmpty(form.getNumeUfficioCdc())){
			context.addError("error.required", getMessageSource().getMessage("label.consFadCdc.numeUfficio"));
		} else if(form.getNumeUfficioCdc().length()>2){
			context.addError("error.maxLength", getMessageSource().getMessage("label.consFadCdc.numeUfficio"), "2");
		} else {
			checkNumeric(context, form.getNumeUfficioCdc(), "label.consFadCdc.numeUfficio");
		}
		
		return  !context.hasErrors();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public boolean onEseguiRicerca(Context context) throws Throwable {
		ConsFADCdcForm form = context.getForm();
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
		if(	!StringUtil.isEmpty(form.getDataArrivoDa())){
			checkDate(context, form.getDataArrivoDa(), "label.dataArrivoDa");
		}
		if(	!StringUtil.isEmpty(form.getDataArrivoA())){
			checkDate(context, form.getDataArrivoA(), "label.dataArrivoA");
		}
		
		return  !context.hasErrors();
	}
	
	public boolean onUploadFile(Context context) throws Throwable {
		ConsFADCdcForm form = context.getForm();
//		checkEmpty(context, form.getUpFile(), "label.title.uploadDec");
		
		if ( form.getUpFile().isEmpty()) {
			context.addError("error.empty", "Documento");
		}
		
		checkMaxLength(context, form.getUpFile().getOriginalFilename(), 255, "label.title.uploadDec");
		
		return !context.hasErrors();
	}
	
}
