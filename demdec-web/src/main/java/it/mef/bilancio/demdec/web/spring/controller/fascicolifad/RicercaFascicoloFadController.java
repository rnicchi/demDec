package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTOId;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.ConsultaFascicoloFadForm;

public abstract class RicercaFascicoloFadController extends
		AbstractDemFormController {

	@Autowired
	private GestioneFadManager gestioneFadManager;
	@Autowired
	private ListManager listManager; 
	
	private String startView;
	
	private String afterRicercaView;
	
	public void setStartView(String startView) {
		this.startView = startView;
	}
	
	public String getStartView(){
		return this.startView;
	}
	
	public void setAfterRicercaView(String afterRicercaView) {
		this.afterRicercaView = afterRicercaView;
	}
	
	public String getAfterRicercaView(){
		return this.afterRicercaView;
	}
	
	public String onCaricaTipologiaDecreto(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		if (form.isValid()){
			if(form.getTipoDecreto() != null && !"".equals(form.getTipoDecreto())){
				context.setDataModel(LIST_TIPOLOGIA_DECRETO, listManager.tipologiaDecretoList(Integer.parseInt(form.getTipoDecreto())));
			}
			else {
				context.setDataModel(LIST_TIPOLOGIA_DECRETO, listManager.tipologiaDecretoList(null));
			}
		}
		return startView;
	}

	public String onCaricaAmmin(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		if (form.isValid()){
			context.setDataModel(LIST_AMMIN_DEM, listManager.getAmminDemByAnnoEse(form.getAnnoDecreto()));
		}
		return startView;
	}

	public String onCaricaCdr(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		if (form.isValid()){
			AnagAmminDemTOId id = new AnagAmminDemTOId();
			id.setFkAnnoEse(Short.valueOf(form.getAnnoDecreto()));
			id.setAmmin(form.getAmministrazione());
			context.setDataModel(LIST_ANAG_CDR_DEM, listManager.getCdrByAdmin(id));
		}
		return startView;
	}

	public String onNuovaRicerca(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		form.reset();
		context.removeDataModel(LIST_TIPOLOGIA_DECRETO);
		context.removeDataModel(LIST_AMMIN_DEM);
		context.removeDataModel(LIST_ANAG_CDR_DEM);
		context.removeDataModel(OPEN_DETT_FAD);
		context.removeDataModel(OPEN_DETT_RED);
		context.removeDataModel(OPEN_DETT_PATR);
		return startView;
	}
	
	public String onEseguiRicerca(Context context)throws Throwable{
		ConsultaFascicoloFadForm form = context.getForm();
		if(!form.isValid()){
			return startView;
		}
		FascicoliFadSearhTO to = new FascicoliFadSearhTO();
		to.setAmmin(form.getAmministrazione());
		to.setAnnoDecreto(form.getAnnoDecreto());
		to.setCdr(form.getCdr());
		to.setDataArrivoA(form.getDataArrivoA());
		to.setDataArrivoDa(form.getDataArrivoDa());
		to.setNumeDecreto(form.getNumeDecreto());
		to.setNumePat(form.getNumePat());
		to.setStato(form.getStato());
		to.setTipoDecreto(form.getTipoDecreto());
		to.setTipologiaDecreto(form.getTipologiaDecreto());
		to.setUfficio(form.getUfficio());
		
		List<FascicoliTO> lista = gestioneFadManager.getFascicoliFad(to);
		
		if (lista==null||lista.size()==0){
			PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
			context.addWarning("warning.empty");
			return startView;
		}
		PaginatorUtil.addPaginator(lista,LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);
		//context.setDataModel(SessionAttributes.LIST_FASCICOLI_FAD, lista);
		
		return afterRicercaView;
	}
	
}
