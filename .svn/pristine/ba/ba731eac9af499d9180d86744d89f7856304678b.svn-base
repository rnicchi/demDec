package it.mef.bilancio.demdec.web.spring.controller.modali;

import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.GestioneTipologiaDecretoManager;
import it.mef.bilancio.demdec.manager.GestioneWorkflowFirmeManager;
import it.mef.bilancio.demdec.to.AnagModelliIterTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.to.IterFirmaTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.GestioneWorkflowFirmeForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value = ConstantsRequestMapping.GEST_WORKFLOW_FIRME_MODALI)
public class GestWorkflowFirmeModaliController extends AbstractDemFormController implements WebConstants, SessionAttributes {
	
	@Autowired
	private GestioneWorkflowFirmeManager gestioneWorkflowFirmeManager;
	
	@Autowired
	private GestioneTipologiaDecretoManager gestioneTipologiaDecretoManager;
	
	
	public void modaleDettaglioModelloIter(Context context) throws Throwable {
		
		GestioneWorkflowFirmeForm form = context.getForm();
		
		List<IterFirmaTO> listaIterFirme=null;
		IterFirmaTO to=null;
		try {
			String selectedModello=form.getSelectedModello();
			
		/*	List<AnagModelliIterTO> listaModelliIter =context.getModel(SessionAttributes.LIST_ANAG_MODELLI_ITER);
			AnagModelliIterTO modelloIterTo=listaModelliIter.get(Integer.valueOf(rowNum));
	
			String selectedModello = modelloIterTo.getId().toString();*/
			
	//		boolean esisteIterInviatoAFirme = gestioneWorkflowFirmeManager.esisteIterInviatoAFirme(selectedModello);
	//		
	//		String iterInviato = "no";
	//		
	//		if(esisteIterInviatoAFirme == true){
	//				iterInviato = "ok";
	//				context.addWarning("label.info.modello.iter.inviato.firme");
	//		}
	//		context.setDataModel(SessionAttributes.ITER_INVIATO_A_FIRME, iterInviato);
			
			
	/*
			//recupera descrizione del modello Iter
			List<AnagModelliIterTO> listaModelliIter = gestioneWorkflowFirmeManager.elencoModelliIter();
	//		List<AnagModelliIterTO> listaModelliIter = context.getModel(SessionAttributes.LIST_ANAG_MODELLI_ITER);
			for (AnagModelliIterTO to: listaModelliIter) {
				if (selectedModello.equals(to.getId().toString())) {
					form.setDescIter(to.getDescIter());
					break;
				}
			}
	*/
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
	
	
public void modaleTipologieAssociate(Context context) throws Throwable {
		
		GestioneWorkflowFirmeForm form = context.getForm();
		List<AnagTipologiaDecretoTO> listaTipologie=null;
		AnagTipologiaDecretoTO to=null;
		
		try {
			String rowNum=form.getSelectedModello();
			
			List<AnagModelliIterTO> listaModelliIter =context.getModel(SessionAttributes.LIST_ANAG_MODELLI_ITER);
			AnagModelliIterTO modelloIterTo=listaModelliIter.get(Integer.valueOf(rowNum));
			
		    listaTipologie=gestioneTipologiaDecretoManager.loadTipologieDecretoByIter(modelloIterTo.getId());
		
		}catch (Exception ex){
			listaTipologie=new ArrayList<AnagTipologiaDecretoTO> ();
			  to=new AnagTipologiaDecretoTO();
			  to.setDescTipologia("ERRORE");
			  listaTipologie.add(to);
		
		   }

			context.getResponse().setContentType("application/json");  
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(context.getResponse().getOutputStream(), listaTipologie);
			   
			context.getResponse().getOutputStream().flush();
			context.getResponse().getOutputStream().close();
}


	@Override
	public String startController(Context context) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
