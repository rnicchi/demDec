package it.mef.bilancio.demdec.web.spring.controller.funzionidiservizio;

import java.util.List;

import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.mef.bilancio.demdec.manager.GestioneTipologiaDecretoManager;
import it.mef.bilancio.demdec.to.AnagModelliIterTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.GestioneTipologiaDecretoForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = ConstantsRequestMapping.GESTIONE_TIPOLOGIA_DECRETO)
public class GestioneTipologiaDecretoController extends AbstractDemFormController {

	private String startView;
	private String creaView;
	private String modificaView;

	public void setStartView(String startView) {
		this.startView = startView;
	}
	public void setCreaView(String creaView) {
		this.creaView = creaView;
	}
	public void setModificaView(String modificaView) {
		this.modificaView = modificaView;
	}
	
	@Autowired
	private GestioneTipologiaDecretoManager gestioneTipologiaDecretoManager;

	/**
	 * Il metodo restituisce la tipologica dei decreti
	 */
	@Override
	public String startController(Context context) throws Throwable {

		context.setCurrentNode("DemDec.menu.Workflow");

		List<AnagTipologiaDecretoTO> listaTipologiaDecreto = gestioneTipologiaDecretoManager.elencoTipologiaDecreto();
		context.setDataModel(SessionAttributes.LIST_ANAG_TIPOLOGIA_DECRETO, listaTipologiaDecreto);

		//Paginator: devo inserirlo ?
		if (listaTipologiaDecreto.size() > 0){
//			PaginatorUtil.addPaginator(listaTipologiaDecreto, SessionAttributes.LIST_ANAG_TIPOLOGIA_DECRETO, Paginator.PAGE_RANGE_5, context);
		} else {
			PaginatorUtil.removePaginator(context, SessionAttributes.LIST_ANAG_TIPOLOGIA_DECRETO);
			ContextHelper.addWarning(context.getRequest(),"warning.noRecord.trovati");           
		}


		return startView;
	}

	public String onGestioneCreazioneDecreto(Context context) throws Throwable {

		List<AnagTipoDecretoTO> listaTipoDecreto = gestioneTipologiaDecretoManager.elencoTipoDecreto();
		context.setDataModel(SessionAttributes.LIST_TIPI_DECRETI, listaTipoDecreto);
		List<AnagModelliIterTO> listaModelliIter = gestioneTipologiaDecretoManager.elencoModelliIter();
		context.setDataModel(SessionAttributes.LIST_ANAG_MODELLI_ITER, listaModelliIter);

		return creaView;
	}

	public String onConfermaDecreto(Context context) throws Throwable {

		GestioneTipologiaDecretoForm form = (GestioneTipologiaDecretoForm) context.getForm();
		if(!form.isValid()) return creaView;

		AnagTipologiaDecretoTO anagTipologiaDecretoTO = 
				new AnagTipologiaDecretoTO(
						null, 
						new AnagModelliIterTO(Short.valueOf(form.getModelloIter())), 
						new AnagTipoDecretoTO(form.getTipoDecreto()), 
						form.getDescTipologia().trim()
		);
		context.valorizeAuditCreated(anagTipologiaDecretoTO, NomeFunzioneConstants.FUNZIONE_GEST_TIPOLOGIA_DECRETO);

		boolean result = gestioneTipologiaDecretoManager.creaDecretoTipologia(anagTipologiaDecretoTO);
		if (!result) { 
			context.addError("errore.tipologia.decreto.presente");
			return creaView;
		}

		predisponiStartView(context, TipoResponse.INFO, "info.create.tipologia.decreto.success");
		return startView;
	}

	public String onModificaDecreto(Context context) throws Throwable {
		
		GestioneTipologiaDecretoForm form = (GestioneTipologiaDecretoForm) context.getForm();
		
		if(!form.isValid()) return startView;
		
		List<AnagTipoDecretoTO> listaTipoDecreto = gestioneTipologiaDecretoManager.elencoTipoDecreto();
		context.setDataModel(SessionAttributes.LIST_TIPI_DECRETI, listaTipoDecreto);

		List<AnagModelliIterTO> listaModelliIter = gestioneTipologiaDecretoManager.elencoModelliIter();
		context.setDataModel(SessionAttributes.LIST_ANAG_MODELLI_ITER, listaModelliIter);
		
		List<AnagTipologiaDecretoTO> list=  context.getModel(SessionAttributes.LIST_ANAG_TIPOLOGIA_DECRETO);

		String rowNum=getParameter(context, "rowNum");
		
		AnagTipologiaDecretoTO to=list.get(Integer.valueOf(rowNum));
		
		form.setSelectedTipologia(to.getId().toString());
		form.setDescTipologia(to.getDescTipologia());
		form.setTipoDecreto(to.getAnagTipoDecreto().getId());
		form.setModelloIter(to.getAnagModelliIter().getId().toString());
		
		return modificaView;
	}

	public String onConfermaModificaDecreto(Context context) throws Throwable {

		GestioneTipologiaDecretoForm form = (GestioneTipologiaDecretoForm) context.getForm();
		if(!form.isValid()) return modificaView;

		AnagTipologiaDecretoTO anagTipologiaDecretoTO = 
				new AnagTipologiaDecretoTO(
												Integer.valueOf(form.getSelectedTipologia()), 
												new AnagModelliIterTO(Short.valueOf(form.getModelloIter())), 
												new AnagTipoDecretoTO(form.getTipoDecreto()), 
												form.getDescTipologia().trim()
										  );
		
		context.valorizeAuditUpdated(anagTipologiaDecretoTO, NomeFunzioneConstants.FUNZIONE_GEST_TIPOLOGIA_DECRETO);

		gestioneTipologiaDecretoManager.modificaDecretoTipologia(anagTipologiaDecretoTO);

		predisponiStartView(context, TipoResponse.INFO, "info.update.tipologia.decreto.success");

		return startView;
	}

	public String onEliminaDecreto(Context context) throws Throwable {

		GestioneTipologiaDecretoForm form = (GestioneTipologiaDecretoForm) context.getForm();
		if(!form.isValid()) return startView;

		String selectedTipologia =  getParameter(context, "selectedTipologia");
		if (gestioneTipologiaDecretoManager.eliminaDecretoTipologia(Integer.valueOf(selectedTipologia)))
			predisponiStartView(context, TipoResponse.INFO, "info.delete.tipologia.decreto.success");
		else
			predisponiStartView(context, TipoResponse.ERROR, "error.delete.tipologia.decreto.failed");
		
		return startView;
	}

	public String onBack(Context context) throws Throwable {
		return startView;
	}

	//classes per la preparazione delle view successive
	private enum TipoResponse {
		INFO, WARN, ERROR
	}
	//set dati per la pagina startView
	private void predisponiStartView(Context context, TipoResponse tipoMessaggio, String info) throws Throwable {
		List<AnagTipologiaDecretoTO> listaTipologiaDecreto = gestioneTipologiaDecretoManager.elencoTipologiaDecreto();
		context.setDataModel(SessionAttributes.LIST_ANAG_TIPOLOGIA_DECRETO, listaTipologiaDecreto);

		if (info != null && !info.equals(""))
			switch (tipoMessaggio) {
				case INFO: context.addInfo(info); break;
				case WARN: context.addWarning(info); break;
				case ERROR: context.addError(info); break;
			}
	}
}
