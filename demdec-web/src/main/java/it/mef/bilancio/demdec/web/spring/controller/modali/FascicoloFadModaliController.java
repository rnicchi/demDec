package it.mef.bilancio.demdec.web.spring.controller.modali;

import it.almavivaitalia.bilancio.commons.bo.AmminRagDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBOId;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.dao.AmminRagDemDao;
import it.mef.bilancio.demdec.dao.AnagRagionerieDemDao;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.servizi.to.FascicoloSipatrTO;
import it.mef.bilancio.demdec.to.AnagRagionerieDemTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;



@RequestMapping(value = ConstantsRequestMapping.MODALI_FAD)
public class FascicoloFadModaliController  extends AbstractDemFormController {
	
	@Autowired
	private ListManager listManager;
	
	@Autowired
	private GestioneFadManager gestioneFadManager;
	
	@Autowired
	AmminRagDemDao amminRagDemDao;
	
	@Autowired
	AnagRagionerieDemDao anagRagionerieDemDao;
	
	@Override
	public String startController(Context context) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
	/****** metodo per visualizzare i metadati di un fascicolo FAD *****/
	public void modalemetadatiFascicoloFad(Context context) throws Throwable {
		
		FascicoliTO to = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		if(to==null){
			List<FascicoliTO> toList = (List<FascicoliTO>)context.getModel(LIST_FASCICOLI_FAD);
			String rowNum = context.getRequest().getParameter("idFad");
			to = (FascicoliTO) toList.get(Integer.parseInt(rowNum));
		}
		
		
		List<AnagRagionerieDemTO> listRag=new ArrayList<AnagRagionerieDemTO>();
		List<AnagRagionerieDemTO> listRag2=null;
		//questo ciclo permette che nella pagina modale le ragionerie corrispondano, nell'ordine, alle amministrazioni
		for (AnagAmminDemTO ammTo : to.getAnagAmminDemList()) {
			listRag2=listManager.findAnagRagDemByAnagAmminDem(ammTo);
			listRag.addAll(listRag2);
		}
		
		to.setAnagRagionerieDemList(listRag);
		
		List<FascicoliTO> listaDettFasc=new ArrayList<FascicoliTO>();
		
		to.setDescStato(to.getStatStato()!=null?(listManager.loadDecStatiFascicoliFad(to.getStatStato().toString()) ):"");
		
		listaDettFasc.add(to);

		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), listaDettFasc);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
		
	}
	
	
	/******metodo per visualizzare i metadati di un fascicolo RED*****/
	public void modalemetadatiFascicoloRed(Context context) throws Throwable {
		
		String rowNum = context.getRequest().getParameter("NumFasc");
		
		List<SottoFascicoliRedTO> list = context.getModel(LIST_SOTTO_FASCICOLI_RED);
		SottoFascicoliRedTO to = list.get(Integer.parseInt(rowNum));
		to.setAnagAmminDem(to.getAnagAmminDem()!=null?to.getAnagAmminDem():new AnagAmminDemTO());
		to.setAnagRagionerieDem(to.getAnagRagionerieDem() != null? to.getAnagRagionerieDem(): new AnagRagionerieDemTO());

		List<SottoFascicoliRedTO> listaDettFasc=new ArrayList<SottoFascicoliRedTO>();
		listaDettFasc.add(to);

		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), listaDettFasc);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
	}
	
	
	
	/******metodo per visualizzare i metadati di un fascicolo Patrimonio*****/

	public void modalemetadatiFascicoloPat(Context context) throws Throwable {
		
		String rowNum = context.getRequest().getParameter("rowNum");
		
		List<FascicoloSipatrTO> list = context.getModel(LIST_SOTTO_FASCICOLI_PAT);

		List<FascicoloSipatrTO> listaDettFasc=new ArrayList<FascicoloSipatrTO>();
		listaDettFasc.add(list.get(Integer.parseInt(rowNum)));

		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), listaDettFasc);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();

	}
	
	
	public void modaleListaAmministrazioni(Context context) throws Throwable {
		
		FascicoliTO fascicoliTO = gestioneFadManager.getFascicoloFad(Long.parseLong(context.getRequest().getParameter("idFad")));
		
		List<AnagAmminDemTO> amministrazioni = fascicoliTO.getAnagAmminDemList();
		
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), amministrazioni);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
		
	}
	
	
}
