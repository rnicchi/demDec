package it.mef.bilancio.demdec.web.spring.controller.modali;

import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.GestioneWorkflowFirmeManager;
import it.mef.bilancio.demdec.to.IterFirmaTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.GestioneTipologiaDecretoForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value = ConstantsRequestMapping.GEST_TIPOLOGIA_DECRETO_MODALI)
public class GestTipologiaDecretoModaliController extends AbstractDemFormController implements WebConstants, SessionAttributes{
	
	@Autowired
	private GestioneWorkflowFirmeManager gestioneWorkflowFirmeManager;
	
	public void modaleDettaglioModelloIter(Context context) throws Throwable {
		
		GestioneTipologiaDecretoForm form = context.getForm();
		
		List<IterFirmaTO> listaIterFirme=null;
		IterFirmaTO to=null;
		try {
			String selectedModello=form.getSelectedTipologia();
			

			 listaIterFirme = gestioneWorkflowFirmeManager.elencoFirmatariPerModelloIter(selectedModello);
			context.setDataModel(SessionAttributes.LIST_ITER_FIRMA, listaIterFirme);
			
	  }catch (Exception ex){
		  // errors=new ArrayList<String>() ; 
		  listaIterFirme=new ArrayList<IterFirmaTO> ();
		  to=new IterFirmaTO();
		  to.setWarningCode("ERRORE");
		   listaIterFirme.add(to);
	
	   }

		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), listaIterFirme);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
	}

	@Override
	public String startController(Context context) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
