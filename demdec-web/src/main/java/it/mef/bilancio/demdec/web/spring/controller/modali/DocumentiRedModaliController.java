package it.mef.bilancio.demdec.web.spring.controller.modali;

import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.RicercaRedManager;
import it.mef.bilancio.demdec.to.DocumentiRedTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
//import it.mef.bilancio.intgen.web.util.editor.TabellaEditor;


@RequestMapping(value = ConstantsRequestMapping.MODALI_DOCUMENTI_RED)
public class DocumentiRedModaliController  extends AbstractDemFormController implements WebConstants, SessionAttributes {
	
	private String startView;	
	
	@Autowired
	private RicercaRedManager ricercaRedManager;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ListManager listManager;
	
	@Autowired
	private GestioneFadManager gestioneFadManager;
	
	public ServletContext getServletContext() {
		return servletContext;
	}
	

	@Override
	public String startController(Context context) throws Throwable {
		context.setCurrentNode("DemDec.menu.GestFAD");
		return startView;
		
	}
	
	
	/******metodo per visualizzare i metadati di un documento RED *****/
	public void modaleMetadatiDocumentiRed(Context context) throws Throwable {
//		FascicoliTO fascicolo=(FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
//		SottoFascicoliRedTO sfRedTo = (SottoFascicoliRedTO)context.getModel(SOTTO_FASCICOLO_RED);
		List<DocumentiRedTO> toList = context.getModel(SessionAttributes.LIST_DOCUMENTI_RED);
		List<DocumentiRedTO> toListNew = new ArrayList<DocumentiRedTO>();
		
		String idRed = context.getRequest().getParameter("idRed");		//idRed
		
		if (toList!=null){			
			DocumentiRedTO docSelezionato = (DocumentiRedTO)toList.get(Integer.valueOf(idRed));
			
			
			DocumentiRedTO docNew=gestioneFadManager.getDocumentoRedById(docSelezionato.getId().getCodiGuidDocumento(), docSelezionato.getId().getFkNumeIdFascicolo());

			context.setDataModel(SessionAttributes.DOCUMENTO_RED, docSelezionato);
			toListNew.add(docNew);
		}
		
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), toListNew);
		
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
		
	}
	
	
	/******metodo per modificare i metadati di un documento RED *****/

	//public ResponseEntity<List<RaccoltaProvvisoriaRedTO>> modaleDettaglioFascicolo(Context context) throws IOException {
	public void modaleModMetadatiDocumentiRed(Context context) throws Throwable {
		List<DocumentiRedTO> toList = context.getModel(SessionAttributes.LIST_DOCUMENTI_RED);
		List<DocumentiRedTO> toListNew = new ArrayList<DocumentiRedTO>();
		
		String idRed = context.getRequest().getParameter("idRed");		//idRed
//		DocumentiRedTO docRedTo= (DocumentiRedTO)toList.get(Integer.valueOf(idRed));
		
		if (toList!=null){			
			
			// Set del form per informazioni da visualizzare
			DocumentiRedTO docSelezionato = (DocumentiRedTO)toList.get(Integer.valueOf(idRed));
			
			List<DescDocumentoTO> listaDescDocumenti = listManager.loadDescDocumentoByTipo(docSelezionato.getTipoDocumento().getId());
			docSelezionato.setListaDescDocumenti(listaDescDocumenti);
			
			toListNew.add(docSelezionato);
			
			context.setDataModel(SessionAttributes.DOCUMENTO_RED, docSelezionato);
		}
				
		
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), toListNew);
		
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();

	}
	
	
	public void setStartView(String startView) {
		this.startView = startView;
	}
	
}
