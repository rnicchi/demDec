package it.mef.bilancio.demdec.web.spring.controller.funzionidiservizio;

import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.enums.TipoResponse;
import it.mef.bilancio.demdec.manager.GestioneWorkflowFirmeManager;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;
import it.mef.bilancio.demdec.to.AnagModelliIterTO;
import it.mef.bilancio.demdec.to.IterFirmaTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.GestioneWorkflowFirmeForm;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


//@RequestMapping(value = ConstantsRequestMapping.GESTIONE_WORKFLOW_FIRME)
public abstract class GestioneWorkflowFirmeParentController extends AbstractDemFormController {
	
	protected String startView;
	protected String creaView;
	protected String dettaglioView;
	protected String modDettaglioView;
	
	@Autowired
	protected GestioneWorkflowFirmeManager gestioneWorkflowFirmeManager;
	


	public void setStartView(String startView) {
		this.startView = startView;
	}
	public void setCreaView(String creaView) {
		this.creaView = creaView;
	}
//	public GestioneWorkflowFirmeManager getGestioneWorkflowFirmeManager() {
//		return gestioneWorkflowFirmeManager;
//	}
//	public void setGestioneWorkflowFirmeManager(GestioneWorkflowFirmeManager gestioneWorkflowFirmeManager) {
//		this.gestioneWorkflowFirmeManager = gestioneWorkflowFirmeManager;
//	}
//	public String getStartView() {
//		return startView;
//	}
//	public String getCreaView() {
//		return creaView;
//	}
//	public String getDettaglioView() {
//		return dettaglioView;
//	}
//	public String getModDettaglioView() {
//		return modDettaglioView;
//	}
	public void setDettaglioView(String dettaglioView) {
		this.dettaglioView = dettaglioView;
	}
	public void setModDettaglioView(String modDettaglioView) {
		this.modDettaglioView = modDettaglioView;
	}
	
	
	

/*	public String onDettaglioModelloIter(Context context) throws Throwable {
	
			GestioneWorkflowFirmeForm form = context.getForm();
			if(!form.isValid()) return startView;
	
			String selectedModello = form.getSelectedModello();
			
			boolean esisteIterInviatoAFirme = gestioneWorkflowFirmeManager.esisteIterInviatoAFirme(selectedModello);
			
			String iterInviato = "no";
			
			if(esisteIterInviatoAFirme == true){
					iterInviato = "ok";
					context.addWarning("label.info.modello.iter.inviato.firme");
			}
			context.setDataModel(SessionAttributes.ITER_INVIATO_A_FIRME, iterInviato);
			
			
	
			//recupera descrizione del modello Iter
			List<AnagModelliIterTO> listaModelliIter = gestioneWorkflowFirmeManager.elencoModelliIter();
	//		List<AnagModelliIterTO> listaModelliIter = context.getModel(SessionAttributes.LIST_ANAG_MODELLI_ITER);
			for (AnagModelliIterTO to: listaModelliIter) {
				if (selectedModello.equals(to.getId().toString())) {
					form.setDescIter(to.getDescIter());
					break;
				}
			}
	
			List<IterFirmaTO> listaIterFirme = gestioneWorkflowFirmeManager.elencoFirmatariPerModelloIter(selectedModello);
			context.setDataModel(SessionAttributes.LIST_ITER_FIRMA, listaIterFirme);
	
			return dettaglioView;
		}*/

	public String onEliminaIterFirma(Context context) throws Throwable {
		GestioneWorkflowFirmeForm form = context.getForm();
		if(!form.isValid()) return modDettaglioView;
	
		String idIterFirma = form.getSelectedIterFirma();
		String selectedModello = form.getSelectedModello();
	
		switch (gestioneWorkflowFirmeManager.eliminaIterFirma(selectedModello, idIterFirma)) {
			case -1: predisponiModDettaglioView(context, TipoResponse.ERROR, "errore.delete.firmatario.iter.failed", selectedModello); break;
			case 0: predisponiModDettaglioView(context, TipoResponse.INFO, "info.delete.firmatario.iter.success", selectedModello); break;
			default: predisponiModDettaglioView(context, TipoResponse.WARN, "warning.delete.firmatario.iter.failed", selectedModello); break;
		}
	
		return modDettaglioView;
	}

	public String onEliminaModelloIter(Context context) throws Throwable {
	
	//	GestioneWorkflowFirmeForm form = context.getForm();
//		if(!form.isValid()) return startView;
		
		String selectedModelloIter =  getParameter(context, "selectedModello");
		
		List<AnagModelliIterTO> listaModelliIter =context.getModel(SessionAttributes.LIST_ANAG_MODELLI_ITER);
		AnagModelliIterTO modelloIterTo=listaModelliIter.get(Integer.valueOf(selectedModelloIter));
	
		//String selectedModelloIter = form.getSelectedModello();
	
		switch (gestioneWorkflowFirmeManager.eliminaModelloIter(modelloIterTo.getId().toString())) {
			case -1: predisponiStartView(context, TipoResponse.ERROR, "errore.delete.modello.iter.failed"); break;
			case 0: predisponiStartView(context, TipoResponse.INFO, "info.delete.modello.iter.success"); break;
			default: predisponiStartView(context, TipoResponse.WARN, "warning.delete.modello.iter.failed"); break;
		}
	
		return startView;
	}

	//private  ResponseManager responseManager = new ResponseManager();
//	protected class ResponseManager {
		//set dati per la pagina startView
		protected void predisponiStartView(Context context, TipoResponse tipoMessaggio, String info) throws Throwable {

			List<AnagModelliIterTO> listaModelliIter = gestioneWorkflowFirmeManager.elencoModelliIter();
			context.setDataModel(SessionAttributes.LIST_ANAG_MODELLI_ITER, listaModelliIter);

			addMessage(context, tipoMessaggio, info);
		}
		//set dati per la pagina dettaglioView
		protected void predisponiDettaglioView(Context context, TipoResponse tipoMessaggio, String info, String selectedModello) throws Throwable {

			List<IterFirmaTO> listaIterFirme = gestioneWorkflowFirmeManager.elencoFirmatariPerModelloIter(selectedModello);
			context.setDataModel(SessionAttributes.LIST_ITER_FIRMA, listaIterFirme);

			addMessage(context, tipoMessaggio, info);
		}
		//set dati per la pagina modDettaglioView
		protected void predisponiModDettaglioView(Context context, TipoResponse tipoMessaggio, String info, String selectedModello) throws Throwable {

			List<IterFirmaTO> listaIterFirme = gestioneWorkflowFirmeManager.elencoFirmatariPerModelloIter(selectedModello);
			context.setDataModel(SessionAttributes.LIST_ITER_FIRMA, listaIterFirme);
			List<AnagFirmatariTO> listaAnagFirmatari = gestioneWorkflowFirmeManager.elencoAnagraficaFirmatari();
			context.setDataModel(SessionAttributes.LIST_ANAG_FIRMATARI, listaAnagFirmatari);

			addMessage(context, tipoMessaggio, info);
		}

		private void addMessage(Context context, TipoResponse tipoMessaggio, String info) {
			if (info != null && !info.equals(""))
				switch (tipoMessaggio) {
					case INFO: context.addInfo(info); break;
					case WARN: context.addWarning(info); break;
					case ERROR: context.addError(info); break;
				}
		}
//	}
	
//	public ResponseManager getResponseManager() {
//		return responseManager;
//	}
	
}
