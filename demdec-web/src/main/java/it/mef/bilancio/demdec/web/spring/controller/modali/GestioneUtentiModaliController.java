package it.mef.bilancio.demdec.web.spring.controller.modali;

import it.almavivaitalia.bilancio.commons.to.UtenteProfiloViewTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.enums.TipoResponse;
import it.mef.bilancio.demdec.manager.GestioneUtentiManager;
import it.mef.bilancio.demdec.to.ManagerResponseTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.GestioneUtentiForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value = ConstantsRequestMapping.MODALI_GESTIONE_UTENTI)
public class GestioneUtentiModaliController extends AbstractDemFormController{
	
	
	@Autowired
	GestioneUtentiManager gestioneUtentiManager;

	private String startView;	
	
	public void setStartView(String startView) {
		this.startView = startView;
	}


	@Override
	public String startController(Context context) throws Throwable {
		return null;
	}
	
	
	/****** metodo per visualizzare i profili di un utente *****/
	public void modaleProfiliUtente(Context context) throws Throwable {
		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		String selectedCodiUtente =  form.getSelectedCodiUtente();
		UtenteProfiloViewTO to=null;
		List<UtenteProfiloViewTO> listaProfUffAmmView=null;
		
		try {
		
			ManagerResponseTO<UtenteTO> risposta = gestioneUtentiManager.caricaUtenteByCodiceUtente(selectedCodiUtente);
			if (risposta.getCodice() == TipoResponse.INFO) {
				UtenteTO utenteTO = (UtenteTO) risposta.getListaTo().get(0);
				
				listaProfUffAmmView=new ArrayList<UtenteProfiloViewTO>();
				UtenteProfiloViewTO utProfViewTO=null;
				for (int i=0; i<utenteTO.getUtenteProfiloList().size(); i++) {
					
					utProfViewTO=new UtenteProfiloViewTO();
					utProfViewTO.setDescProfilo(utenteTO.getUtenteProfiloList().get(i).getProfilo()==null?"":utenteTO.getUtenteProfiloList().get(i).getProfilo().getDescProfilo());
					utProfViewTO.setDescUfficio(utenteTO.getUtenteProfiloList().get(i).getAnagUffici()==null?"":utenteTO.getUtenteProfiloList().get(i).getAnagUffici().getDescUfficio());
					utProfViewTO.setDescAmministrazione(utenteTO.getUtenteProfiloList().get(i).getAnagAmminDem()==null?"":utenteTO.getUtenteProfiloList().get(i).getAnagAmminDem().getDescAmm());
					utProfViewTO.setFlagDefault01(utenteTO.getUtenteProfiloList().get(i).getFlagDefault01());
					listaProfUffAmmView.add(utProfViewTO);
				}
				
			}
		
		}catch (Exception ex) {
			listaProfUffAmmView=new ArrayList<UtenteProfiloViewTO> ();
			  to=new UtenteProfiloViewTO();
			  to.setWarningCode("ERRORE");
			  listaProfUffAmmView.add(to);
		
		}

		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), listaProfUffAmmView);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
		
	}

}
