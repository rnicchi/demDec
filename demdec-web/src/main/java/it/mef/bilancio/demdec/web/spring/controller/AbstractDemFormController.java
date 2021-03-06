package it.mef.bilancio.demdec.web.spring.controller;

import it.almavivaitalia.bilancio.commons.web.spring.controller.AbstractCommonFormController;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.WebConstants;
import it.mef.bilancio.demdec.manager.DocumentiManager;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.to.DocumentiViewTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.utils.FileUtil;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public abstract class AbstractDemFormController extends
		AbstractCommonFormController 
			implements 
				CommonSessionAttributes,
				SessionAttributes, 
				Constants {
	
	@Autowired 
	private DocumentiManager documentiManager;
	@Autowired 
	private GestioneFadManager gestioneFadManager;
	
	public GestioneFadManager getGestioneFadManager() {
		return gestioneFadManager;
	}


	@Override
	public void init() {
		getMethodMappings().add(
				"onPaginator#" + Paginator.PARAMETER_PAGINATOR + "##false");
		getMethodMappings().add(
				"onEnableDisablePagin#"
						+ Paginator.PARAMETER_ENABLE_DISABLE_PAGIN + "##false");
		super.init();
	}


	@SuppressWarnings("unchecked")
	protected String getParameter(Context context, String paramName){
		for(Enumeration<String> en =context.getRequest().getParameterNames(); en.hasMoreElements();){
			String param = en.nextElement();
			if (param.startsWith(WebConstants.COMMAND_BUTTON_PREFIX_POST)&&(param.indexOf(paramName)>0)){
				int endIndex=param.length()-(param.endsWith(".x")||param.endsWith(".y")?2:0);
				return param.substring(param.indexOf(paramName)+paramName.length()+1,endIndex);
			}
//			if (param.startsWith(WebConstants.COMMAND_BUTTON_PREFIX_GET)&&(param.indexOf(paramName)>0)){
//				String[] parameter =  (String[]) context.getRequest().getParameterMap().get(param);
//				return parameter[0];
//			}
		}
		return null;
	}
	
	public String downloadAD(Context context) throws Throwable {
		
		DocumentiViewTO doc = null;
		ResponseDEMBILClient res = null;
		
		String rigaDoc = context.getCommandParameter("download");
		List<DocumentiViewTO> listAttoDecretoToSign = context.getModel(SessionAttributes.LIST_AD_TO_SIGN);
		
		if(!listAttoDecretoToSign.isEmpty() && rigaDoc != null && rigaDoc != "" ){
			doc = listAttoDecretoToSign.get(Integer.parseInt(rigaDoc));
		}
		res = documentiManager.wsDownloadDocumentoFascicoloAttoDecreto(doc.getCodiGuidFascicolo(), doc.getCodiGuidDocumento());
		
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			FileUtil.downloadFromResponseWs(res, context);
			
		}else{
			context.addError("error.ws.download.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			return startController(context);
		}
		return null;
	}
	
	public String downloadADSigned(Context context) throws Throwable {
		
		DocumentiViewTO doc = null;
		ResponseDEMBILClient res = null;
		
		String rigaDoc = context.getCommandParameter("downloadAD");
		List<DocumentiViewTO> listADSigned = context.getModel(SessionAttributes.LIST_AD_SIGNED);
		
		if(!listADSigned.isEmpty() && rigaDoc != null && rigaDoc != "" ){
			doc = listADSigned.get(Integer.parseInt(rigaDoc));
		}
		res = documentiManager.wsDownloadDocumentoFascicoloAttoDecreto(doc.getCodiGuidFascicolo(), doc.getCodiGuidDocumento());
		
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			FileUtil.downloadFromResponseWs(res, context);
			
		}else{
			context.addError("error.ws.download.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			return startController(context);
		}
		return null;
	}
}
