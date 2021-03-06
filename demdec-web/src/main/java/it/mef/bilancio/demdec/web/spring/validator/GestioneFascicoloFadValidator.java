package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.to.AnagCdrDemTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.web.spring.form.ConsultaFascicoloFadForm;
import it.mef.bilancio.demdec.web.spring.form.GestioneFascicoloFadForm;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import java.util.List;

public class GestioneFascicoloFadValidator extends AbstractDemValidator  {

	public boolean onCaricaTipologiaDecreto(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		checkEmpty(context, form.getTipoDecreto(), "label.tipoDecreto");
		return !context.hasErrors();
	}

	public boolean onCaricaTipologiaDecretoFadPage(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		checkEmpty(context, form.getTipoDecreto(), "label.tipoDecreto");
		return !context.hasErrors();
	}

	public boolean onCaricaAmmin(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		checkEmpty(context, form.getAnnoDecreto(), "label.anno.dec");
		return !context.hasErrors();
	}

	public boolean onCaricaAmminModifica(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		checkEmpty(context, form.getAnnoDecreto(), "label.anno.dec");
		return !context.hasErrors();
	}

	public boolean onCaricaCdr(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		checkEmpty(context, form.getAmministrazione(), "label.amministrazione");
		return !context.hasErrors();
	}
	
	@SuppressWarnings("unchecked")
	public boolean onEseguiRicerca(Context context) throws Throwable {
		ConsultaFascicoloFadForm form = context.getForm();
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
//		if(	!StringUtil.isEmpty(form.getDataArrivoDa())){
//			checkDate(context, form.getDataArrivoDa(), "label.dataArrivoDa");
//		}
//		if(	!StringUtil.isEmpty(form.getDataArrivoA())){
//			checkDate(context, form.getDataArrivoA(), "label.dataArrivoA");
//		}
		
		return  !context.hasErrors();
	}
	
	public boolean onUploadFile(Context context) throws Throwable {
		GestioneFascicoloFadForm form = (GestioneFascicoloFadForm)context.getForm();
//		checkEmpty(context, form.getUpFile(), "label.title.uploadDec");
		
		if ( form.getUpFile().isEmpty()) {
			context.addError("error.empty", "Documento");
		}
		checkEmpty(context, form.getTipoDoc(), "label.tipo.doc");
//		checkEmpty(context, form.getAmm(), "label.amministrazione");
		checkEmpty(context, form.getDesc(), "label.descr.doc");
		checkEmpty(context, form.getTipoOperazione(), "label.upload.operazione");
		
		checkMaxLength(context, form.getUpFile().getOriginalFilename(), 255, "label.title.uploadDec");
		
		return !context.hasErrors();
	}
	
	public boolean onEliminaFad(Context context) throws Throwable {
		GestioneFascicoloFadForm form = (GestioneFascicoloFadForm)context.getForm();
		FascicoliTO fascicoloTO = (FascicoliTO)context.getModel(SessionAttributes.FASCICOLO_SELEZIONATO);
		try { 
			if (!form.getStato().equals("0")){
			
				context.addError("error.stato.cancellazioneFad",fascicoloTO.getEstremiStr());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return !context.hasErrors();
	}
	
}
