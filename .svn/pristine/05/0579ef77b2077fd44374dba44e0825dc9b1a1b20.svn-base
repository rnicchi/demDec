package it.mef.bilancio.demdec.web.spring.controller.funzionidiservizio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.enums.TipoResponse;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;
import it.mef.bilancio.demdec.to.AnagModelliIterTO;
import it.mef.bilancio.demdec.to.IterFirmaTO;
import it.mef.bilancio.demdec.to.IterFirmaTOId;
import it.mef.bilancio.demdec.web.spring.form.GestioneWorkflowFirmeForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;


@RequestMapping(value = ConstantsRequestMapping.GESTIONE_WORKFLOW_FIRME)
public class GestioneWorkflowFirmeController extends GestioneWorkflowFirmeParentController {


	public String onNuovoModelloIter(Context context) throws Throwable {

		List<AnagFirmatariTO> listaAnagFirmatari = gestioneWorkflowFirmeManager.elencoAnagraficaFirmatari();
		context.setDataModel(SessionAttributes.LIST_ANAG_FIRMATARI, listaAnagFirmatari);

		return creaView;
	}
	

	public String onConfermaModelloIter(Context context) throws Throwable {

		GestioneWorkflowFirmeForm form = context.getForm();
		if(!form.isValid()) return creaView;

		String nuovoModello = form.getNuovoModello().toUpperCase().trim();
		String selectedAnagFirmatario = form.getAnagFirmatario();

		List<AnagModelliIterTO> listaModelliIter = context.getModel(SessionAttributes.LIST_ANAG_MODELLI_ITER);
		for (AnagModelliIterTO to: listaModelliIter) 
			if (to.getDescIter().equals(nuovoModello)) {
					context.addError("errore.modello.iter.presente");
					return creaView;
			}

		//inserimento nuovo modello Iter
		AnagModelliIterTO anagModelliIterTO = new AnagModelliIterTO();
		anagModelliIterTO.setDescIter(nuovoModello);
		context.valorizeAuditCreated(anagModelliIterTO, NomeFunzioneConstants.FUNZIONE_GEST_WORKFLOW_FIRME);
		short idNewModelloIter = gestioneWorkflowFirmeManager.creaModelloIter(anagModelliIterTO);

		creazioneIterFirma(context, idNewModelloIter, new Integer(1), selectedAnagFirmatario);

	//	getResponseManager().predisponiStartView(context, TipoResponse.INFO, "info.create.modello.iter.success");
		predisponiModDettaglioView(context, TipoResponse.INFO, "info.create.modello.iter.success", String.valueOf(idNewModelloIter) /*selectedModello*/);
		
		form.setDescIter(nuovoModello);
		form.setAnagFirmatario(null);
		form.setSelectedModello(String.valueOf(idNewModelloIter));
		
		return modDettaglioView;
	}

	
	public String onBack(Context context) throws Throwable {
		List<AnagModelliIterTO> listaModelliIter = gestioneWorkflowFirmeManager.elencoModelliIter();
		context.setDataModel(SessionAttributes.LIST_ANAG_MODELLI_ITER, listaModelliIter);
		return  startView;
	}

	
	public String onConfermaIterFirma(Context context) throws Throwable {

		GestioneWorkflowFirmeForm form = context.getForm();
		if(!form.isValid()) return startView;

		String selectedModello = form.getSelectedModello();
		String descrIter = form.getDescIter().toUpperCase().trim();
		String selectedAnagFirmatario = form.getAnagFirmatario();
		boolean modified = false;

		//check aggiunto Firmatario
		if (selectedAnagFirmatario != null && !selectedAnagFirmatario.equals("")) {
			List<IterFirmaTO> listaIterFirmaTO = gestioneWorkflowFirmeManager.elencoFirmatariPerModelloIter(selectedModello);
			form.setAnagFirmatario("");
			for (IterFirmaTO to: listaIterFirmaTO)
				if (to.getAnagFirmatari().getId().equals(selectedAnagFirmatario)) {
					//context.addError("errore.iter.firma.presente");
					predisponiModDettaglioView(context, TipoResponse.ERROR, "errore.iter.firma.presente", selectedModello);
					return modDettaglioView;
				}

			creazioneIterFirma(context, Short.valueOf(selectedModello), listaIterFirmaTO.size()+1, selectedAnagFirmatario);
			modified = true;
		}
		//check modifica descrizione Modello Iter
		List<AnagModelliIterTO> listaModelliIter = context.getModel(SessionAttributes.LIST_ANAG_MODELLI_ITER);
		for (AnagModelliIterTO to: listaModelliIter) {
			if (to.getId().equals(Short.valueOf(selectedModello))) {
				if (!to.getDescIter().equals(descrIter)) {
					//aggiornamento modello Iter
					AnagModelliIterTO anagModelliIterTO = gestioneWorkflowFirmeManager.loadAnagModelliIter(Short.valueOf(selectedModello));
					anagModelliIterTO.setDescIter(descrIter);
					context.valorizeAuditUpdated(anagModelliIterTO, NomeFunzioneConstants.FUNZIONE_GEST_WORKFLOW_FIRME);
					gestioneWorkflowFirmeManager.salvaModelloIter(anagModelliIterTO);
					modified = true;
				}
			}
			else if (to.getDescIter().equals(descrIter)) {
//					context.addError("errore.modello.iter.presente");
				predisponiModDettaglioView(context, TipoResponse.ERROR, "errore.modello.iter.presente", selectedModello);
					return modDettaglioView;
			}
		}

		if (modified) 
			predisponiModDettaglioView(context, TipoResponse.INFO, "info.update.modello.iter.success", selectedModello);
		
		return modDettaglioView;
	}

	public String onSalvaOrderIterFirma(Context context) throws Throwable {

		GestioneWorkflowFirmeForm form = context.getForm();
		String selectedModello = form.getSelectedModello();
		String nuovoOrdineFirmatari = form.getListaNuovoOrdineFirmatari();

		List<IterFirmaTO> listaIterFirme = context.getModel(SessionAttributes.LIST_ITER_FIRMA);
		Map<Integer, IterFirmaTO> iterFirmaFinder = new HashMap<Integer, IterFirmaTO>();
		for (IterFirmaTO to: listaIterFirme)
			iterFirmaFinder.put(to.getId().getNumeOrdine(), to);

		List<IterFirmaTO> nuovaListaIterFirme = new ArrayList<IterFirmaTO>(listaIterFirme.size());
		for (String s: nuovoOrdineFirmatari.split(","))
			nuovaListaIterFirme.add(iterFirmaFinder.get(Integer.valueOf(s)));

		gestioneWorkflowFirmeManager.salvaOrdineFirmatari(selectedModello, nuovaListaIterFirme);

		predisponiModDettaglioView(context, TipoResponse.INFO, "info.save.ordine.iter.success", selectedModello);
		return modDettaglioView;
	}


	//inserimento associazione primo firmatario per nuovo modello Iter
	private void creazioneIterFirma(Context context, short idModelloIter, Integer numeOrdine, String codiceFirmatario) 
			throws Throwable {

		IterFirmaTO iterFirmaTO = 
					new IterFirmaTO(new IterFirmaTOId(idModelloIter, numeOrdine));

		AnagModelliIterTO anagModelliIterTO = gestioneWorkflowFirmeManager.loadAnagModelliIter(idModelloIter);
		iterFirmaTO.setAnagModelliIter(anagModelliIterTO);
		AnagFirmatariTO anagFirmatariTO = gestioneWorkflowFirmeManager.loadAnagFirmatari(codiceFirmatario);
		iterFirmaTO.setAnagFirmatari(anagFirmatariTO);
		context.valorizeAuditCreated(iterFirmaTO, NomeFunzioneConstants.FUNZIONE_GEST_WORKFLOW_FIRME);
		gestioneWorkflowFirmeManager.creaIterFirma(iterFirmaTO);
	}

	public String onModificaModelloIter(Context context) throws Throwable {
		GestioneWorkflowFirmeForm form = context.getForm();
		
		String rowNum =  getParameter(context, "rowNum");
		
		List<AnagModelliIterTO> listaModelliIter =context.getModel(SessionAttributes.LIST_ANAG_MODELLI_ITER);
		AnagModelliIterTO modelloIterTo=listaModelliIter.get(Integer.valueOf(rowNum));
		
		//se esiste iter inviato a firme non posso permettere modifiche
		boolean esisteIterInviatoAFirme = gestioneWorkflowFirmeManager.esisteIterInviatoAFirme(modelloIterTo.getId().toString());
		if(esisteIterInviatoAFirme ){
//				iterInviato = "ok";
				context.addWarning("label.info.modello.iter.inviato.firme");
				return startView;
		}
		
		List<IterFirmaTO> listaIterFirme = gestioneWorkflowFirmeManager.elencoFirmatariPerModelloIter(modelloIterTo.getId().toString());
		context.setDataModel(SessionAttributes.LIST_ITER_FIRMA, listaIterFirme);
		List<AnagFirmatariTO> listaAnagFirmatari = gestioneWorkflowFirmeManager.elencoAnagraficaFirmatari();
		context.setDataModel(SessionAttributes.LIST_ANAG_FIRMATARI, listaAnagFirmatari);
		
		form.setSelectedModello(modelloIterTo.getId().toString());
		form.setDescIter(modelloIterTo.getDescIter());
		return modDettaglioView;
	}
	
	
	
	@Override
	public String startController(Context context) throws Throwable {

		context.setCurrentNode("DemDec.menu.WorkflowFirme");

		List<AnagModelliIterTO> listaModelliIter = gestioneWorkflowFirmeManager.elencoModelliIter();
		context.setDataModel(SessionAttributes.LIST_ANAG_MODELLI_ITER, listaModelliIter);

		return startView;
		
	}
	

}
