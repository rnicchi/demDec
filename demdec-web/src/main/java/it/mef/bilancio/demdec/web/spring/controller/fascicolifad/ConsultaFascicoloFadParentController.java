package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.DocumentiManager;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.web.spring.form.ConsultaFascicoloFadForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.FileUtil;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = ConstantsRequestMapping.CONSULTA_FASCICOLO_F_A_D)
public abstract class ConsultaFascicoloFadParentController extends RicercaFascicoloFadController {

	@Autowired 
	private DocumentiManager documentiManager;
	
	private String fascicoloFadView;
	
	private String documentiPatView;
	
	private String documentiRedView;
	
	private String documentiFadView;
	
	public DocumentiManager getDocumentiManager() {
		return documentiManager;
	}
	
	public void setFascicoloFadView(String fascicoloFadView) {
		this.fascicoloFadView = fascicoloFadView;
	}
	

	public String getFascicoloFadView() {
		return fascicoloFadView;
	}


	public String getDocumentiPatView() {
		return documentiPatView;
	}


	public String getDocumentiFadView() {
		return documentiFadView;
	}


	public void setDocumentiPatView(String documentiPatView) {
		this.documentiPatView = documentiPatView;
	}

	public void setDocumentiRedView(String documentiRedView) {
		this.documentiRedView = documentiRedView;
	}

	public String getDocumentiRedView() {
		return this.documentiRedView;
	}

	public void setDocumentiFadView(String documentiFadView) {
		this.documentiFadView = documentiFadView;
	}


	public String onBack(Context context)throws Throwable{
		return getFascicoloFadView();
	}
	
	

	
	public String onApriDocumentiFad(Context context) throws Throwable{
		PaginatorUtil.removePaginator(context, LIST_DOCUMENTI_FAD,DOCUMENTI_FAD_PAGINATOR);
		FascicoliTO to = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		
		if (!StringUtil.isEmpty(to.getDocumentiList())){
			//imposto il nome del file trasformato
			for (DocumentiTO doc : to.getDocumentiList()) {
				if(doc.getDescFilename()!=null){
					doc.setDescFilenameTrasf(doc.getDescFilename()+".pdf");
				}
			}
			
			PaginatorUtil.addPaginator(context, to.getDocumentiList(), LIST_DOCUMENTI_FAD, Paginator.PAGE_RANGE_15, DOCUMENTI_FAD_PAGINATOR);
			return getDocumentiFadView();
		}
		context.addWarning("warning.empty");
		return getFascicoloFadView();
	}
	
	
	public String onBackToFadSearch(Context context)throws Throwable{
		
		/*** Aggiorno la lista dei fad con quello in sessione perchè potrebbe essere stato modificato ***/
		FascicoliTO fadTo=context.getModel(FASCICOLO_SELEZIONATO);
		List<FascicoliTO> listaFad=context.getModel(LIST_FASCICOLI_FAD);
		for (int i = 0; (listaFad!=null && i <listaFad.size()); i++) {
			if(fadTo.getId().compareTo(listaFad.get(i).getId())==0){
				listaFad.set(i, fadTo);
				break;
			}
		}
		
		context.removeDataModel(FASCICOLO_SELEZIONATO);
		context.removeDataModel(OPEN_DETT_FAD);
		context.removeDataModel(OPEN_DETT_RED);
		context.removeDataModel(OPEN_DETT_PATR);

		return getAfterRicercaView();
	}
	
	public String onScaricaPdfFad(Context context) throws Throwable{
		ResponseDEMBILClient res = null;
		DocumentiTO doc = null;
		String rowNum = context.getCommandParameter("scaricaPdfFad");
		List<DocumentiTO> listDocAttoDecreto = context.getModel(LIST_DOCUMENTI_FAD);
		
		if(!listDocAttoDecreto.isEmpty() && rowNum != null && rowNum != "" ){
			doc = listDocAttoDecreto.get(Integer.parseInt(rowNum));
		}
		res = documentiManager.wsDownloadDocumentoFascicoloAttoDecreto(doc.getCodiGuidFascicolo(), doc.getCodiGuidDocumento());
		
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			FileUtil.downloadFromResponseWs(res, context);
			
		}else{
			
			if(res.getEsitoTo().getErrors().contains(new String("Il documento non esiste"))){
				context.addError("error.ws.download.fascicolo.nonPresente");
			}
			else{
				context.addError("error.ws.download.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			}
			return getDocumentiFadView();
		}
	
		return null;
	}

	

	
}
