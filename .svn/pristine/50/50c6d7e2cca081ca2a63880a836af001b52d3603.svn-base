package it.mef.bilancio.demdec.web.spring.controller.modali;

import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.DocumentiRedTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value = ConstantsRequestMapping.MODALI__ANTEPRIMA_DOCUMENTI)
public class AnteprimaDocumentoModaliController extends AbstractDemFormController implements WebConstants, SessionAttributes {

	
	private String startView;	
	
	public void setStartView(String startView) {
		this.startView = startView;
	}
	
	@Override
	public String startController(Context context) throws Throwable {
		return startView;
	}
	
	public void modaleAnteprimaDocumenti(Context context) throws Throwable {
		
		List<String> toListNew = new ArrayList<String>();
		// Reperimento indice docuemento selezionato
		String index = context.getRequest().getParameter("index");
		String listName = context.getRequest().getParameter("listName");
		List<AbstractDemTO> toList = context.getModel(listName);
		
		
		if (toList!=null){			
			AbstractDemTO doc = toList.get(Integer.valueOf(index));
			if (doc instanceof DocumentTO){
				toListNew.add(((DocumentTO)doc).getPreView());
			} else if (doc instanceof RaccoltaProvvisoriaRedTO) {
				toListNew.add(((RaccoltaProvvisoriaRedTO)doc).getPreView());
			} else if (doc instanceof DocumentiRedTO){
				toListNew.add(((DocumentiRedTO)doc).getPreView());
			} else if (doc instanceof DocumentiTO){
				toListNew.add(((DocumentiTO)doc).getPreView());
			}
		}
		
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), toListNew);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
		
	}
	
	
	


}
