package it.mef.bilancio.demdec.web.spring.controller.funzionidiservizio;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.enums.TipoResponse;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;
import it.mef.bilancio.demdec.to.ManagerResponseTO;
import it.mef.bilancio.demdec.web.spring.form.GestioneUtentiForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = ConstantsRequestMapping.GESTIONE_UTENTI)
public class GestioneUtentiController extends GestioneUtentiLiv2Controller implements WebConstants, SessionAttributes {

	

//	@Autowired
//	private ListManager listManager;
//	@Autowired
//	private GestioneUtentiManager gestioneUtentiManager;

	@Override
	public String startController(Context context) throws Throwable {
		
		context.setCurrentNode("DemDec.menu.GestioneUtenti");

		List<UtenteTO> listUtenti = getGestioneUtentiManager().caricaTuttiUtenti();
		
		/***metto in sessione i profili dei firmatari***/
		List<AnagFirmatariTO> firmatari=listManager.loadFirmatari();
		Map<String, Integer> mapProfiliFirmatari=new HashMap<String, Integer>();
		for (int i = 0; i < firmatari.size(); i++) {
			mapProfiliFirmatari.put(firmatari.get(i).getFkSequIdProfilo().toString(), firmatari.get(i).getFkSequIdProfilo());
		}		
		context.setDataModel(SessionAttributes.LIST_PROFILI_FIRMATARI, mapProfiliFirmatari);
		
		context.setDataModel(WebConstants.ASSOCIA_PROFILO, false);
		
		
		if (listUtenti.size()>0)
			PaginatorUtil.addPaginator(context, listUtenti, SessionAttributes.LIST_UTENTI, Paginator.PAGE_RANGE_15, SessionAttributes.OBJECT_PAGINATOR);
		else
			PaginatorUtil.removePaginator(context, SessionAttributes.LIST_UTENTI, SessionAttributes.OBJECT_PAGINATOR);
		return getStartView();
	}

	public String onGestioneNuovoUtente(Context context) throws Throwable {

		context.setDataModel(WebConstants.LIST_PROF_UFF_AMM, new ArrayList<UtenteProfiloTO>());
		context.setDataModel(WebConstants.ASSOCIA_PROFILO, false);
		loadElenchiRicerca(context);
		return getUtenteView();
	}


	public String onCreaUtente(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		if (!form.isValid()) return getUtenteView();

		
		
		List<UtenteProfiloTO> listaUtProf = context.getModel(WebConstants.LIST_PROF_UFF_AMM);
		int rigaProfiloPrincipale=-1;
		
		//recupero la riga del profilo scelto come principale
		if(form.getRadioButtonProfili()!=null) {
			rigaProfiloPrincipale=Integer.parseInt(form.getRadioButtonProfili())-1;
		}
	
		UtenteTO utenteTO = form.getTransferObject();

		utenteTO.setUtenteProfiloList(new ArrayList<UtenteProfiloTO>());
		for (int i = 0; i < listaUtProf.size(); i++) {
			listaUtProf.get(i).setFlagDefault01(rigaProfiloPrincipale==i?1:0);
			listaUtProf.get(i).setFlagDelega01(0);
			addProfilo(utenteTO, listaUtProf.get(i));
		}
//		for (UtenteProfiloTO utenteProfiloTo: listaUtProf){
//			addProfilo(utenteTO, utenteProfiloTo);
//		}

		//imposta valori di Audit
		context.valorizeAuditCreated(utenteTO, NomeFunzioneConstants.GESTIONE_UTENTI);
		for (UtenteProfiloTO utenteProfiloTo: utenteTO.getUtenteProfiloList())
			context.valorizeAuditCreated(utenteProfiloTo, NomeFunzioneConstants.GESTIONE_UTENTI);

		ManagerResponseTO<UtenteTO> risposta = getGestioneUtentiManager().creaUtente(utenteTO);

		predisponiStartView(context, risposta);
		return getStartView();
	}

	public String onGestioneModificaUtente(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		if(!form.isValid()) return getStartView();

		String selectedCodiUtente =  getParameter(context, "selectedCodiUtente");

		ManagerResponseTO<UtenteTO> risposta = getGestioneUtentiManager().caricaUtenteByCodiceUtente(selectedCodiUtente);
		if (risposta.getCodice() == TipoResponse.INFO) {
			UtenteTO utenteTO = (UtenteTO) risposta.getListaTo().get(0);
			
			int y = 1;
			
			for(int i=0; i< utenteTO.getUtenteProfiloList().size();i++)
			{		
				utenteTO.getUtenteProfiloList().get(i).setIdCheckBox(y++);	
			}
			
			if(utenteTO.getUtenteProfiloList()!=null && utenteTO.getUtenteProfiloList().size()>0) {
				context.setDataModel(WebConstants.ASSOCIA_PROFILO, true);
			}else{
				context.setDataModel(WebConstants.ASSOCIA_PROFILO, false);
			}
			
			
		//	fillFormByTo(form, utenteTO);
			form.setCodiUtente(utenteTO.getCodiUtente());
			form.setPersCognome(utenteTO.getPersCognome());
			form.setPersNome(utenteTO.getPersNome());
			form.setIndiEmail(utenteTO.getIndiEmail());
			form.setCodiUtenteNsbf(utenteTO.getCodiUtenteNsbf());
			form.setCodiCodiceFiscale(utenteTO.getCodiCodiceFiscale());
			form.setCodiCodiceFisFirma(utenteTO.getCodiCodiceFisFirma());
			form.setCodiPinFirma(utenteTO.getCodiPinFirma());
			form.setSelectedCodiUtente(selectedCodiUtente);
			
			
			context.setDataModel(WebConstants.LIST_PROF_UFF_AMM, utenteTO.getUtenteProfiloList());
		}
		loadElenchiRicerca(context);
		return getUtenteView();
	}


	public String onModificaUtente(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		if (!form.isValid()) return getUtenteView();

		List<UtenteProfiloTO> listaUtProf = context.getModel(WebConstants.LIST_PROF_UFF_AMM);
		UtenteTO utenteTO = form.getTransferObject();

		utenteTO.setUtenteProfiloList(new ArrayList<UtenteProfiloTO>());
//		for (UtenteProfiloTO utenteProfiloTo: listaUtProf)
//			addProfilo(utenteTO, utenteProfiloTo);
		
		int rigaProfiloPrincipale=-1;
		//recupero la riga del profilo scelto come principale
		if(form.getRadioButtonProfili()!=null) {
			rigaProfiloPrincipale=Integer.parseInt(form.getRadioButtonProfili())-1;
		}
		for (int i = 0; i < listaUtProf.size(); i++) {
			listaUtProf.get(i).setFlagDefault01(rigaProfiloPrincipale==i?1:0);
			addProfilo(utenteTO, listaUtProf.get(i));
		}
		

		//imposta valori di Audit
		context.valorizeAuditUpdated(utenteTO, NomeFunzioneConstants.GESTIONE_UTENTI);
		for (UtenteProfiloTO utenteProfiloTo: utenteTO.getUtenteProfiloList())
			context.valorizeAuditCreated(utenteProfiloTo, NomeFunzioneConstants.GESTIONE_UTENTI);

		ManagerResponseTO<UtenteTO> risposta = getGestioneUtentiManager().salvaUtente(utenteTO);

		addMessage(context, risposta.getCodice(), risposta.getDescrizione());
//		predisponiStartView(context, risposta);
//		return getStartView();
		
		return getUtenteView();
	}

	public String onEliminaUtente(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		if(!form.isValid()) return getStartView();
	//	String selectedCodiUtente = form.getSelectedCodiUtente();
		String selectedCodiUtente =  getParameter(context, "selectedCodiUtente");

		ManagerResponseTO<UtenteTO> risposta = getGestioneUtentiManager().eliminaUtente(selectedCodiUtente);
		predisponiStartView(context, risposta);
		return getStartView();
	}


	public String onEliminaProfili(Context context) throws Throwable {
		
//		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		List<UtenteProfiloTO> listProfiliUfficiAmm = context.getModel(WebConstants.LIST_PROF_UFF_AMM);
		
		String rigaProfiloDaEliminare= getParameter(context, "rigaProfiloDaEliminare");
		
		listProfiliUfficiAmm.remove(Integer.valueOf(rigaProfiloDaEliminare)-1);
		
//		if(idProfDaEliminare.length == 0)
//		{
//			context.addError("errore.profilo.selezionato");
//			
//		}
//		
//		for(int i=0; i<listProfiliUfficiAmm.size();i++)
//		{
//			
//			for(int y=0; y<idProfDaEliminare.length;y++)
//			{
//				if(listProfiliUfficiAmm.get(i).getIdCheckBox() == idProfDaEliminare[y])
//				{
//					
//					listProfiliUfficiAmm.remove(i);
//				}
//			}
//				
//		}
		
		context.setDataModel(WebConstants.LIST_PROF_UFF_AMM, listProfiliUfficiAmm);
		
		return getUtenteView();
	}

	


	//
	//Metodi private
	//
	

	

	

//	private List<AnagAmminDemTO> getListaAmministrazioniOdierna() throws Throwable {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//		return listManager.getAmminDemByAnnoEse(sdf.format(new Date()));
//	}


	
	//
	//gestione della response
	//
//	private ResponseManager responseManager = new ResponseManager();
//	private class ResponseManager {
		//set dati per la pagina startView
		private void predisponiStartView(Context context, ManagerResponseTO<UtenteTO> risposta) throws Throwable {

			List<UtenteTO> listUtenti = getGestioneUtentiManager().caricaTuttiUtenti();
//			context.setDataModel(SessionAttributes.LIST_UTENTI, listUtenti);
			if (listUtenti.size()>0)
				PaginatorUtil.addPaginator(context, listUtenti, SessionAttributes.LIST_UTENTI, Paginator.PAGE_RANGE_15, SessionAttributes.OBJECT_PAGINATOR);
			else
				PaginatorUtil.removePaginator(context, SessionAttributes.LIST_UTENTI, SessionAttributes.OBJECT_PAGINATOR);
			addMessage(context, risposta.getCodice(), risposta.getDescrizione());
		}
//		private void predisponiUtenteView(Context context, ManagerResponseTO<UtenteTO> risposta) throws Throwable {
//
//			loadElenchiRicerca(context);
//			responseManager.addMessage(context, risposta.getCodice(), risposta.getDescrizione());
//		}
		private void addMessage(Context context, TipoResponse tipoMessaggio, String info) {
			if (info != null && !info.equals(""))
				switch (tipoMessaggio) {
					case INFO: context.addInfo(info); break;
					case WARN: context.addWarning(info); break;
					case ERROR: context.addError(info); break;
				}
		}
//	}
	
	public String onCaricaAmministrazioniProfili(Context context) throws Throwable{
		
		GestioneUtentiForm form = (GestioneUtentiForm)context.getForm();
		/*List<DescDocumentoTO> listaDescDocumenti = getGestioneFadManager().findDescDocumentoByTipoDocumento(form.getTipoDoc());
		context.setDataModel(WebConstants.LIST_DESC_DOCUMENTI, listaDescDocumenti);*/
		/*List<AnagAmminDemTO> listAmm = getListaAmministrazioniUltimoAnno();
		context.setDataModel(WebConstants.LIST_AMMIN_DEM, listAmm);*/
		
		List<AnagAmminDemTO> listAmm = new ArrayList<AnagAmminDemTO>();
	//	AnagAmminDemTO amm = null;
		
		if(form.getProfilo().equals("8-Ministro MEF")){
		//	amm = new AnagAmminDemTO();
			
		//	try {
				
				/*
				AnagAmminDemTOId idAmm = new AnagAmminDemTOId();
				short annoEse = Short.parseShort(form.getAnnoEse());
				idAmm.setFkAnnoEse(annoEse);
				idAmm.setNumeStp(2);
				idAmm.setNumeApp(0);
				amm.setId(idAmm);
				*/
				listAmm = getListaAmministrazioniUltimoAnno();
				Iterator<AnagAmminDemTO> itr = listAmm.iterator();
			      while(itr.hasNext()) {
			    	  AnagAmminDemTO anagAmminDemTO=itr.next();
			    	  if(!(anagAmminDemTO.getId().getNumeStp() == 2 & anagAmminDemTO.getId().getNumeApp() == 0))
						{
			    		  itr.remove();
						}
			      }
				
				
				
		//	} catch (Exception e) {
		//		e.printStackTrace();
		//	}
			
		//	amm.setDescAmm("MINISTERO DELL'ECONOMIA E DELLE FINANZE");
		//	listAmm.add(amm);
		}
		else
		{
			listAmm = getListaAmministrazioniUltimoAnno();
			Iterator<AnagAmminDemTO> itr = listAmm.iterator();
		      while(itr.hasNext()) {
		    	  AnagAmminDemTO anagAmminDemTO=itr.next();
		    	  if(anagAmminDemTO.getId().getNumeStp() == 0 & anagAmminDemTO.getId().getNumeApp() == 0)
					{
		    		  itr.remove();
					}
		      }
			
		}
		
		
		
		context.setDataModel(WebConstants.LIST_AMMIN_DEM, listAmm);
		
		return getUtenteView();
	}
	
	
/*	protected void fillFormByTo(GestioneUtentiForm form, UtenteTO utenteTO){
	
			form.setCodiUtente(utenteTO.getCodiUtente());
			form.setPersCognome(utenteTO.getPersCognome());
			form.setPersNome(utenteTO.getPersNome());
			form.setIndiEmail(utenteTO.getIndiEmail());
			form.setCodiUtenteNsbf(utenteTO.getCodiUtenteNsbf());
			form.setCodiCodiceFiscale(utenteTO.getCodiCodiceFiscale());
			form.setCodiCodiceFisFirma(utenteTO.getCodiCodiceFisFirma());
			form.setCodiPinFirma(utenteTO.getCodiPinFirma());
	//		form.setProfilo(utenteTO.getUtenteProfiloList());
	//		form.setAnnoEse(utenteTO.get);
	//		form.setUfficio(utenteTO.get);
	//		form.setAmministrazione(utenteTO.get);
	//		form.setSelectedCodiUtente(utenteTO.get);
	
		}*/
	
	
	protected void addProfilo(UtenteTO utenteTO, UtenteProfiloTO utenteProfiloTO) {
	
		ProfiloTO profiloTo = new ProfiloTO();
		profiloTo.setId(utenteProfiloTO.getProfilo().getId());
	
		UtenteProfiloTO utProfTo = new UtenteProfiloTO();
		utProfTo.setUtente(utenteTO);
		utProfTo.setProfilo(profiloTo);
		utProfTo.setAnagAmminDem(utenteProfiloTO.getAnagAmminDem());
		utProfTo.setAnagUffici(utenteProfiloTO.getAnagUffici());
		utProfTo.setFlagFirma01(new Integer(1));
		utProfTo.setFlagModifica01(new Integer(1));
		utProfTo.setFlagDelega01(utenteProfiloTO.getFlagDelega01());
		utProfTo.setFlagDefault01(utenteProfiloTO.getFlagDefault01());
	
		utenteTO.getUtenteProfiloList().add(utProfTo);
	}
	//
		//Metodi private
		//
		
	
		
	
		@SuppressWarnings("unchecked")
		protected void loadElenchiRicerca(Context context) throws Throwable {
	
			List<ProfiloTO> listProfili = getListManager().findAllProfili();
			context.setDataModel(WebConstants.LIST_PROFILI, listProfili);
	
			//filtering ... deleting Direttore e Ministro Proponente (codice 99)//TODO verificare se vanno realmente tolti
		/*	Iterator<ProfiloTO> itProfili = listProfili.iterator();
			while (itProfili.hasNext()) {
				ProfiloTO to = itProfili.next();
				if (to.getCodiProfilo().equals("1") || to.getCodiProfilo().equals("99"))
					itProfili.remove();
			}*/
	
			List<AnagUfficiTO> listUffici = getListManager().loadAnagUffici();
			context.setDataModel(WebConstants.LIST_UFFICI, listUffici);
	
	//		List<EserciziTO> listaAnniEsercizio = listManager.loadEserciziDemCG();
	//		context.setDataModel(WebConstants.LIST_ANNO_ESE, listaAnniEsercizio);
	
	//		List<AnagAmminDemTO> listAmm = getListaAmministrazioniOdierna();
			List<AnagAmminDemTO> listAmm = getListaAmministrazioniUltimoAnno();
			context.setDataModel(WebConstants.LIST_AMMIN_DEM, listAmm);
			/**/
			Iterator<AnagAmminDemTO> itr = listAmm.iterator();
		      while(itr.hasNext()) {
		    	  AnagAmminDemTO anagAmminDemTO=itr.next();
		    	  if(anagAmminDemTO.getId().getNumeStp() == 0 & anagAmminDemTO.getId().getNumeApp() == 0)
					{
		    		  itr.remove();
					}
		      }
		      
		      //listAmm = (List<AnagAmminDemTO>) itr;
		  //   listAmm = IteratorUtils.toList(itr);
		     /**/
			
		//	context.setDataModel(WebConstants.LIST_AMMIN_DEM, listAmm);
	
	//		List<UtenteProfiloTO> listProfiliUfficiAmm = new ArrayList<UtenteProfiloTO>();
	//		context.setDataModel(WebConstants.LIST_PROF_UFF_AMM, listProfiliUfficiAmm);
		}
	public String onPulisci(Context context) throws Throwable {
	
		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		String selectedCodiUtente = form.getSelectedCodiUtente();
	
		form.clean();
		setDefaultCampiAmministrazione(context, form);
	
		if (selectedCodiUtente != null && !selectedCodiUtente.equals("")) {
				form.setCodiUtente(selectedCodiUtente);
				form.setSelectedCodiUtente(selectedCodiUtente);
		}
		context.setDataModel(WebConstants.LIST_PROF_UFF_AMM, new ArrayList<UtenteProfiloTO>());
	
		return getUtenteView();
	}
	
}
