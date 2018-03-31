package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.mef.bilancio.demdec.enums.TipoResponse;
import it.mef.bilancio.demdec.manager.LettereTestiPersManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.LettereTestiTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.ModLetterePreRegForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = ConstantsRequestMapping.MOD_LETTERE_PRE_REG)
public class ModLetterePreRegController extends AbstractDemFormController
		implements WebConstants, SessionAttributes {

	private static Logger _LOG = Logger
			.getLogger(ModLetterePreRegController.class);

	private String startView;

	private String listaDecretiView;

	private String modLettereView;

	@Autowired
	private ListManager listManager;

	@Autowired
	private LettereTestiPersManager lettereTestiPersManager;	

	public void setStartView(String startView) {
		this.startView = startView;
	}

	public void setListaDecretiView(String listaDecretiView) {
		this.listaDecretiView = listaDecretiView;
	}

	public void setModLettereView(String modLettereView) {
		this.modLettereView = modLettereView;
	}

	@Override
	public String startController(Context context) throws Throwable {

		context.setCurrentNode("DemDec.menu.modLetterePreReg");
		context.setDataModel(SessionAttributes.LIST_ANNO_ESE, listManager.loadEserciziDemCG());
		context.setDataModel(SessionAttributes.LIST_TIPI_DECRETI, listManager.loadAnagTipoDecreto());
		context.setDataModel(SessionAttributes.LIST_ANAG_UFF, listManager.loadAnagUfficiAttivi());

		return startView;
	}

	public String onCaricaTipologiaDecretoFadPage(Context context)
			throws Throwable {
		ModLetterePreRegForm form = (ModLetterePreRegForm) context.getForm();
		if (form.isValid()) {
			if (form.getTipoDecreto() != null
					&& !"".equals(form.getTipoDecreto())) {
				context.setDataModel(LIST_TIPOLOGIA_DECRETO, listManager
						.tipologiaDecretoList(Integer.parseInt(form
								.getTipoDecreto())));
			} else {
				context.setDataModel(LIST_TIPOLOGIA_DECRETO,
						listManager.tipologiaDecretoList(null));
			}
		}
		// return getFascicoloFadView();
		return startView;
	}

	public String onCaricaAmmin(Context context) throws Throwable {
		ModLetterePreRegForm form = context.getForm();
		if (form.isValid()) {
			context.setDataModel(SessionAttributes.LIST_AMMIN_DEM,
					listManager.getAmminDemByAnnoEse(form.getAnnoDecreto()));
		}
		return startView;
	}
	
	public String onRicercaDecreti(Context context) throws Throwable {
		ModLetterePreRegForm form = (ModLetterePreRegForm) context.getForm();
		if (!form.isValid()) {
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
		to.setStato(Constants.STATO_FAD_APERTO);
		to.setTipoDecreto(form.getTipoDecreto());
		to.setTipologiaDecreto(form.getTipologiaDecreto());
		to.setUfficio(form.getUfficio());

		java.util.List<FascicoliTO> lista = getGestioneFadManager().getFascicoliFad(to);

		if (lista == null || lista.size() == 0) {
			PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
			context.addWarning("warning.empty");
			return startView;
		}

		PaginatorUtil.addPaginator(lista, LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);

		return listaDecretiView;
	}

	

	public String onNuovaRicerca(Context context) {
		ModLetterePreRegForm form = (ModLetterePreRegForm) context.getForm();

		form.setAmministrazione(null);
		form.setAnnoDecreto(null);
		form.setCdr(null);
		form.setCreatoDa(null);
		form.setDataArrivoA(null);
		form.setCdr(null);
		form.setDataArrivoA(null);
		form.setDataArrivoDa(null);
		form.setDataCreazione(null);
		form.setDataModifica(null);
		form.setDecTipoDecreto(null);
		form.setDescDecreto(null);
		form.setDescStato(null);
		form.setModificatoDa(null);
		form.setNumeDecreto(null);
		form.setNumePat(null);
		form.setRadioButtonDecreti(null);
		form.setDecTipoDecreto(null);
		form.setDescDecreto(null);
		form.setDescStato(null);
		form.setModificatoDa(null);
		form.setDataModifica(null);
		form.setDataCreazione(null);
		form.setStato(null);
		form.setUfficio(null);
		form.setUfficioCreatore(null);
		form.setTipoDecreto(null);
		form.setTipologiaDecreto(null);

		return startView;

	}

	public String onBackFromLettere(Context context) throws Throwable {

		return listaDecretiView;

	}
	
	public String onPersonalizza(Context context) throws Throwable {
		ModLetterePreRegForm form = (ModLetterePreRegForm) context.getForm();
		
		java.util.List<FascicoliTO> listaFascicoli = context.getModel(LIST_FASCICOLI_FAD);
    	
		//String rowNum = context.getCommandParameter("personalizza");    
    	String rowNum=getParameter(context, "personalizza");
    	
    	FascicoliTO fascicolo = listaFascicoli.get(new Integer(rowNum));
    	form.setIdFascicolo(fascicolo.getId());
    	
    	List<LettereTestiTO> testiPers = lettereTestiPersManager.findActualTestoFasc(fascicolo.getId(), Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE, Constants.CODI_SEZIONE_CORPO_LETTERA_PREREGISTRAZIONE);
    	
    	//attualmente gestisce solo un testo
    	form.setTextContenuto(testiPers.get(0).getTextContenuto());
    	
    	context.setDataModel(LIST_TESTI_PERS, testiPers);
    	
		
    	
		return modLettereView;
	}

	public String onSalvaPersonalizza(Context context) throws Throwable {
		ModLetterePreRegForm form = (ModLetterePreRegForm) context.getForm();				
		if (!form.isValid()) {
			return listaDecretiView;
		}
		
		FascicoliTO fascicolo = getGestioneFadManager().getFascicoloFad(form.getIdFascicolo());		
		
		lettereTestiPersManager.salvaTestoPers(fascicolo.getId(), Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE, Constants.CODI_SEZIONE_CORPO_LETTERA_PREREGISTRAZIONE, new Short("1"), form.getTextContenuto(), NomeFunzioneConstants.MOD_LETTERE_PRE_REG, ((UtenteTO) ContextHelper.getModel(OBJECT_USER, context.getRequest())).getCodiUtente());
		
		context.addInfo("info.update.success");
				
		return startView;
	}
	
	public String onRimuoviPersonalizza(Context context) throws Throwable {
		ModLetterePreRegForm form = (ModLetterePreRegForm) context.getForm();	
		FascicoliTO fascicolo = getGestioneFadManager().getFascicoloFad(form.getIdFascicolo());
		
		lettereTestiPersManager.rimuoviTestoPers(fascicolo.getId(), Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE, Constants.CODI_SEZIONE_CORPO_LETTERA_PREREGISTRAZIONE, new Short("1"));
		
		context.addInfo("info.delete.success");
		
		return startView;
	}
}
