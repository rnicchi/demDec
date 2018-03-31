package it.mef.bilancio.demdec.web.spring.controller.modali;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTOId;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.ConsFADCdcManager;
import it.mef.bilancio.demdec.manager.DocumentiManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.RicercaRedManager;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.FascicoloSipatrTO;
import it.mef.bilancio.demdec.servizi.to.ProtocolloTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AnagRagionerieDemTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.to.DocumentiRedTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.ConsFADCdcForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value = ConstantsRequestMapping.CONSULTA_FASCICOLO_CDC_MODALI)
public class ConsFADCdcModaliController extends AbstractDemFormController implements WebConstants, SessionAttributes {
	
	private String startView;	
	
	@Autowired
	private DocumentiManager documentiManager;
	
	@Autowired
	private RicercaRedManager ricercaRedManager;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ListManager listManager;
	
	@Autowired
	private ConsFADCdcManager consFadCdcManager;
	
	public ServletContext getServletContext() {
		return servletContext;
	}
	

	public void setStartView(String startView) {
		this.startView = startView;
	}



	@Override
	public String startController(Context context) throws Throwable {
		
		context.setCurrentNode("DemDec.menu.ConsFADCdc");
	
		
		return startView;
		
	}
	
	/******metodo per visualizzare i metadati di un fascicolo*****/

	//public ResponseEntity<List<RaccoltaProvvisoriaRedTO>> modaleDettaglioFascicolo(Context context) throws IOException {
	public void modaleDettaglioFascicolo(Context context) throws Throwable {
		ConsFADCdcForm form= (ConsFADCdcForm) context.getForm();
		
		String idFascicolo=form.getIdFascicolo();		//idFascicoloRaccoltaProvvisoria

		
		List<FascicoliTO> listaDettFasc=new ArrayList<FascicoliTO>();

		FascicoliTO errorTo=null;
		
		try {
			FascicoliTO to = getGestioneFadManager().getFascicoloFad(ParseUtil.getLong(idFascicolo));
			
			if(to.getStatStato()!=null){
				to.setDescStato((String)listManager.loadDecStatiFascicoliFad(to.getStatStato().toString()));
			}else{
				to.setDescStato("");
			}
			
			if(to.getDescDecreto()==null){
				to.setDescDecreto("");
			}
				
			List<AnagTipologiaDecretoTO> listaTipologiaCurr = new ArrayList<AnagTipologiaDecretoTO>();
			List<AnagTipologiaDecretoTO> listaTipologia = listManager.tipologiaDecretoList(Integer.parseInt(to.getAnagTipoDecreto().getId()));
			
			for (AnagTipologiaDecretoTO elem : listaTipologia){
				if (elem.getId().equals(to.getAnagTipologiaDecreto().getId())){
					listaTipologiaCurr.add(elem);
					break;
				}
			}
			
			List<AnagUfficiTO> listaUfficiCurr = new ArrayList<AnagUfficiTO>();
			List<AnagUfficiTO> listaUffici = listManager.loadAnagUfficiAttivi();
			for (AnagUfficiTO uff : listaUffici){
				if (uff.getId().equals(to.getUfficioCapofila().getId())){
					listaUfficiCurr.add(uff);
					break;
				}
			}
			
			
			
			to.getUfficioCapofila().setDescUfficio((listaUfficiCurr.get(0).getDescUfficio()));
			
			to.getAnagTipologiaDecreto().setDescTipologia(listaTipologiaCurr.get(0).getDescTipologia());
			
			listaDettFasc.add(to);


		}catch (Exception ex){
			listaDettFasc=new ArrayList<FascicoliTO> ();
			errorTo=new FascicoliTO();
			errorTo.setEstremiStr("ERRORE");
			listaDettFasc.add(errorTo);
		
		}
		  
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), listaDettFasc);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
		
	}
	
public void modaleDocumentiFadCdc(Context context) throws Throwable {
		
		// Form
	//ConsFADCdcForm form= (ConsFADCdcForm) context.getForm();
		
		FascicoliTO to = context.getModel(SessionAttributes.FASCICOLO_SELEZIONATO);
		
		List<DocumentiTO> toList = context.getModel(SessionAttributes.LIST_DOCUMENTI_FAD);
		List<DocumentiTO> toListNew = new ArrayList<DocumentiTO>();
		// Reperimento indice docuemento selezionato
		String idFad = context.getRequest().getParameter("idDoc");		
		
		DocumentiTO doc = toList.get(Integer.valueOf(idFad)-1);
		
		if (toList!=null){			
			
			// Set del form per informazioni da visualizzare
			
			DocumentiTO docSelezionato = documentiManager.getDocumentByIdDocumento(doc.getId());
			if(docSelezionato.getFascicoli()!=null){
				docSelezionato.getFascicoli().setAnagAmminDemList(to.getAnagAmminDemList());
				docSelezionato.getFascicoli().setAnagRagionerieDemList(to.getAnagRagionerieDemList());
			}
		//	docSelezionato.setFascicoli(to);
			List<DescDocumentoTO> listaDescDocumenti = listManager.loadDescDocumentoByTipo(docSelezionato.getTipoDocumento().getId());
//			context.removeDataModel(WebConstants.LIST_DESC_DOCUMENTI);
			docSelezionato.setListaDescDocumenti(listaDescDocumenti);
			
		//	docSelezionato.setAnagAmminDem(to.getAnagAmminDemList());			
			docSelezionato.setDescStatDocumento(docSelezionato.getStatDocumento()!=null?listManager.loadDecStatiFascicoliFad(docSelezionato.getStatDocumento().toString()):null);
	//		toListNew.add((DocumentiTO)toList.get(Integer.valueOf(idFad)));
			toListNew.add(docSelezionato);
//			context.setDataModel(WebConstants.LIST_DESC_DOCUMENTI, listaDescDocumenti);
		//	form.setListaDescDocumenti(listaDescDocumenti);
			context.setDataModel(SessionAttributes.DOCUMENTO_FAD, docSelezionato);
		}
		
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), toListNew);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
		
	}

	public void modaleDocumentiFadCdcOld(Context context) throws Throwable {
//		ConsFADCdcForm form= (ConsFADCdcForm) context.getForm();
		List<DocumentiTO> toList = context.getModel(SessionAttributes.LIST_DOCUMENTI_FAD);
		List<DocumentiTO> toListNew = new ArrayList<DocumentiTO>();
		DocumentiTO errorTo=null;
		try {
			// Reperimento indice docuemento selezionato
			String idDoc = context.getRequest().getParameter("idDoc");		
			DocumentiTO docToNew=null;
			if (toList!=null){			
					for (DocumentiTO documentiTO : toList) {
						if(documentiTO.getId().getNumeIdDocumento().compareTo(Long.valueOf(idDoc))==0) {
							docToNew=new DocumentiTO();
							docToNew.setAnagAmminDem(new AnagAmminDemTO());
							docToNew.getAnagAmminDem().setId(new AnagAmminDemTOId());
							docToNew.getAnagAmminDem().setEserciziDem(new EserciziTO());
							if(documentiTO.getAnagAmminDem()!=null) {
								docToNew.getAnagAmminDem().getEserciziDem().setId(documentiTO.getAnagAmminDem().getEserciziDem().getId());								
								docToNew.getAnagAmminDem().getId().setAmmin(documentiTO.getAnagAmminDem().getId().getAmmin());
								docToNew.getAnagAmminDem().getId().setFkAnnoEse(documentiTO.getAnagAmminDem().getId().getFkAnnoEse());
								docToNew.getAnagAmminDem().getId().setNumeApp(documentiTO.getAnagAmminDem().getId().getNumeApp());
								docToNew.getAnagAmminDem().getId().setNumeStp(documentiTO.getAnagAmminDem().getId().getNumeStp());								
								docToNew.getAnagAmminDem().setDescAmm(documentiTO.getAnagAmminDem()==null?"":documentiTO.getAnagAmminDem().getDescAmm());
							}
													
							docToNew.setAnagRagionerieDem(new AnagRagionerieDemTO());
							docToNew.getAnagRagionerieDem().setDescRag(documentiTO.getAnagRagionerieDem()==null?"":documentiTO.getAnagRagionerieDem().getDescRag());
							
							docToNew.setDataArrivo(documentiTO.getDataArrivo());
							docToNew.setTipoDocumento(new TipoDocumentoTO());
							docToNew.getTipoDocumento().setDescDescrizioneDoc(documentiTO.getTipoDocumento()==null?"":documentiTO.getTipoDocumento().getDescDescrizioneDoc());
							docToNew.setDescFilename(documentiTO.getDescFilename());
							docToNew.setDescNomeDocumento(documentiTO.getDescNomeDocumento());
							
							documentiTO.setFascicoli(null);
							toListNew.add(docToNew);
							break;
						}
					}

			}
		

		}catch (Exception ex){
			toListNew=new ArrayList<DocumentiTO> ();
			errorTo=new DocumentiTO();
			errorTo.setDescNomeDocumento("ERRORE");
			toListNew.add(errorTo);
		
		}
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), toListNew);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
	}
	
	
	public void modaleDocumentiRedCdc(Context context) throws Throwable {
		
		List<DocumentiRedTO> toList = context.getModel(SessionAttributes.LIST_DOCUMENTI_RED);
		List<DocumentiRedTO> toListNew = new ArrayList<DocumentiRedTO>();
		DocumentiRedTO errorTo=null;
		try {
			// Reperimento indice documento selezionato
			String rowNum = context.getRequest().getParameter("rowNum");		
			DocumentiRedTO docToNew=null;
			if (toList!=null){			
					   
						    DocumentiRedTO documentiRedTO=toList.get(Integer.valueOf(rowNum)-1);
						
							docToNew=new DocumentiRedTO();
							docToNew.setAnagAmminDem(new AnagAmminDemTO());
							docToNew.getAnagAmminDem().setId(new AnagAmminDemTOId());
							docToNew.getAnagAmminDem().setEserciziDem(new EserciziTO());
							if(documentiRedTO.getAnagAmminDem()!=null) {
								docToNew.getAnagAmminDem().getEserciziDem().setId(documentiRedTO.getAnagAmminDem().getEserciziDem().getId());								
								docToNew.getAnagAmminDem().getId().setAmmin(documentiRedTO.getAnagAmminDem().getId().getAmmin());
								docToNew.getAnagAmminDem().getId().setFkAnnoEse(documentiRedTO.getAnagAmminDem().getId().getFkAnnoEse());
								docToNew.getAnagAmminDem().getId().setNumeApp(documentiRedTO.getAnagAmminDem().getId().getNumeApp());
								docToNew.getAnagAmminDem().getId().setNumeStp(documentiRedTO.getAnagAmminDem().getId().getNumeStp());								
								docToNew.getAnagAmminDem().setDescAmm(documentiRedTO.getAnagAmminDem()==null?"":documentiRedTO.getAnagAmminDem().getDescAmm());
							}
								
							docToNew.setDescFilename(documentiRedTO.getDescFilename());
							docToNew.setAnagRagionerieDem(new AnagRagionerieDemTO());
							docToNew.getAnagRagionerieDem().setDescRag(documentiRedTO.getAnagRagionerieDem()==null?"":documentiRedTO.getAnagRagionerieDem().getDescRag());
							docToNew.setCodiProtocollo(documentiRedTO.getCodiProtocollo());
							docToNew.setDataArrivo(documentiRedTO.getDataArrivo());
							docToNew.setTipoDocumento(new TipoDocumentoTO());
							docToNew.getTipoDocumento().setDescDescrizioneDoc(documentiRedTO.getTipoDocumento()==null?"":documentiRedTO.getTipoDocumento().getDescDescrizioneDoc());
							//docToNew.setDescDocumento(new DescDocumentoTO());
							//docToNew.getDescDocumento().setDescDescrizioneDoc(documentiRedTO.getDescDocumento()==null?"":documentiRedTO.getDescDocumento().getDescDescrizioneDoc());
							documentiRedTO.setSottoFascicoliRed(null);
							docToNew.setFlagVisibilitaCdc01(documentiRedTO.getFlagVisibilitaCdc01());
							toListNew.add(docToNew);
			}
		
		}catch (Exception ex){
			toListNew=new ArrayList<DocumentiRedTO> ();
			errorTo=new DocumentiRedTO();
			errorTo.setWarningCode("ERRORE");
			toListNew.add(errorTo);
		
		}
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), toListNew);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
	}
	
	
	
	
	public void modaleDocumentiPatCdc(Context context) throws Throwable {
		ConsFADCdcForm form= (ConsFADCdcForm) context.getForm();
		List<DocumentTO> toList = context.getModel(SessionAttributes.LIST_DOCUMENTI_PAT);
			
			DocumentiTO errorTo=null;
		/*List<DocumentTO> toListNew = new ArrayList<DocumentTO>();
		DocumentiTO errorTo=null;
		
			// Reperimento indice docuemento selezionato
			String rowNum = context.getRequest().getParameter("rowNum");		
			DocumentTO docToNew=null;
			if (toList!=null){			
				DocumentTO documentTO=toList.get(Integer.valueOf(rowNum)-1);
							docToNew=new DocumentiTO();
							docToNew.setAnagAmminDem(new AnagAmminDemTO());
							docToNew.getAnagAmminDem().setId(new AnagAmminDemTOId());
							docToNew.getAnagAmminDem().setEserciziDem(new EserciziTO());
							if(documentTO.getAmministrazione()!=null) {
								docToNew.getAnagAmminDem().getEserciziDem().setId(documentTO.getAmministrazione().getEserciziDem().getId());								
								docToNew.getAnagAmminDem().getId().setAmmin(documentTO.getAnagAmminDem().getId().getAmmin());
								docToNew.getAnagAmminDem().getId().setFkAnnoEse(documentTO.getAnagAmminDem().getId().getFkAnnoEse());
								docToNew.getAnagAmminDem().getId().setNumeApp(documentTO.getAnagAmminDem().getId().getNumeApp());
								docToNew.getAnagAmminDem().getId().setNumeStp(documentTO.getAnagAmminDem().getId().getNumeStp());								
								docToNew.getAnagAmminDem().setDescAmm(documentTO.getAnagAmminDem()==null?"":documentTO.getAnagAmminDem().getDescAmm());
							}
													
							docToNew.setAnagRagionerieDem(new AnagRagionerieDemTO());
							docToNew.getAnagRagionerieDem().setDescRag(documentTO.getAnagRagionerieDem()==null?"":documentTO.getAnagRagionerieDem().getDescRag());
							
							docToNew.setDataArrivo(documentTO.getDataArrivo());
							docToNew.setTipoDocumento(new TipoDocumentoTO());
							docToNew.getTipoDocumento().setDescDescrizioneDoc(documentTO.getTipoDocumento()==null?"":documentTO.getTipoDocumento().getDescDescrizioneDoc());
							docToNew.setDescFilename(documentTO.getDescFilename());
							docToNew.setDescNomeDocumento(documentTO.getDescNomeDocumento());
							
							documentTO.setFascicoli(null);
							toListNew.add(docToNew);
			}*/
		

		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), toList);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
	}
	

	
	public void  modaleMetadatiRedCdc(Context context) throws Throwable {
		
		List<RaccoltaProvvisoriaRedTO> listaDettFasc=new ArrayList<RaccoltaProvvisoriaRedTO>();
		RaccoltaProvvisoriaRedTO errorTo=null;
	
		List<SottoFascicoliRedTO> list = context.getModel(LIST_SOTTO_FASCICOLI_RED);
		try {
			String rowNum = context.getRequest().getParameter("NumFasc");
				
			SottoFascicoliRedTO to = list.get(Integer.parseInt(rowNum)-1);
			to.setAnagAmminDem(to.getAnagAmminDem()!=null?to.getAnagAmminDem():new AnagAmminDemTO());
		
			RaccoltaProvvisoriaRedTO rpRedTo=new RaccoltaProvvisoriaRedTO();
			rpRedTo.setAmministrazione(new CodeDescriptionTO("",to.getAnagAmminDem().getDescAmm()));
			rpRedTo.setCodiStatoFascicoloDocumentale(to.getStatStato().toString());
			rpRedTo.setDataAggiornamento(to.getDataRedFormatted());
			rpRedTo.setDataCreazione(to.getDataArrivoFormatted());
			rpRedTo.setDescrizione(to.getDescOggettoRed());
			rpRedTo.setIdentificativoRaccoltaProvvisoria(to.getId()!=null?to.getId().getCodiIdRed():"");
			if(to.getCodiAooProtocollo()==null)
				rpRedTo.setProtocollo(new ProtocolloTO("", null, "",""));
			else
				rpRedTo.setProtocollo(new ProtocolloTO("", null, "",to.getCodiAooProtocollo()));
			if(to.getAnagRagionerieDem()!=null && to.getAnagRagionerieDem().getDescRag()!=null)
				rpRedTo.setRagioneria(new CodeDescriptionTO("",to.getAnagRagionerieDem().getDescRag()));				
			else
				rpRedTo.setRagioneria(new CodeDescriptionTO("",""));
			
			if(to.getDescUtenteAss()==null)
				rpRedTo.setUtenteCreatore(new CodeDescriptionTO("",""));
			else
				rpRedTo.setUtenteCreatore(new CodeDescriptionTO("",to.getDescUtenteAss()));
			rpRedTo.setTipoFlusso(to.getDescTipoFlusso());
			if(to.getDescUfficioAss()==null)
				rpRedTo.setUfficioCreatoreRED(new CodeDescriptionTO("",""));
			else
				rpRedTo.setUfficioCreatoreRED(new CodeDescriptionTO("",to.getDescUfficioAss()));			
			 	
	    	if(rpRedTo.getAmministrazione()==null)
	    		rpRedTo.setAmministrazione(new CodeDescriptionTO("",""));
	    	if(rpRedTo.getCodiStatoFascicoloDocumentale()==null)
	    		rpRedTo.setCodiStatoFascicoloDocumentale("");
	    	if(rpRedTo.getDataAggiornamento()==null)
	    		rpRedTo.setDataAggiornamento("");
			if(rpRedTo.getDataCreazione()==null)
	    		rpRedTo.setDataCreazione("");
	    	if(rpRedTo.getDescrizione()==null)
	    		rpRedTo.setDescrizione("");
	    	if(rpRedTo.getIdentificativoRaccoltaProvvisoria()==null)
	    		rpRedTo.setIdentificativoRaccoltaProvvisoria("");
			if(rpRedTo.getProtocollo()==null)
	    		rpRedTo.setProtocollo(new ProtocolloTO("", null, "", ""));
	    	if(rpRedTo.getRagioneria()==null)
	    		rpRedTo.setRagioneria(new CodeDescriptionTO("",""));
	    	if(rpRedTo.getSistemaProduttore()==null)
	    		rpRedTo.setSistemaProduttore("");
	    	if(rpRedTo.getUtenteCreatore()==null)
	    		rpRedTo.setUtenteCreatore(new CodeDescriptionTO("",""));
	    	if(rpRedTo.getTipoFlusso()==null)
	    		rpRedTo.setTipoFlusso("");
	    	if(rpRedTo.getUfficioCreatoreRED()==null)
	    		rpRedTo.setUfficioCreatoreRED(new CodeDescriptionTO("",""));
	    	if(rpRedTo.getStatoFascicoloRaccoltaProvvisoria()==null)
	    		rpRedTo.setStatoFascicoloRaccoltaProvvisoria("");
	      	
		   	listaDettFasc.add(rpRedTo);			
			   
		}catch (Exception ex){
			listaDettFasc=new ArrayList<RaccoltaProvvisoriaRedTO> ();
			errorTo=new RaccoltaProvvisoriaRedTO();
			errorTo.setTitle("ERRORE");
			listaDettFasc.add(errorTo);
		}
		  
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), listaDettFasc);
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
	}
	
	
	
	public void  modaleMetadatiPatCdc(Context context) throws Throwable {
		
			List<FascicoloSipatrTO> list = context.getModel(LIST_SOTTO_FASCICOLI_PAT);
		
			String rowNum = context.getRequest().getParameter("rowNum");
				
			FascicoloSipatrTO to = list.get(Integer.parseInt(rowNum)-1); 
			
			/** simulazione to**/  //TODO togliere
	/*		FascicoloSipatrTO toMock=new FascicoloSipatrTO();
			toMock.setAmministrazione(new CodeDescriptionTO("","amm prova pat"));
			toMock.setDescrizione("descr prova pat");
			toMock.setRagioneria(new CodeDescriptionTO("","ragionerai prova pat"));
			toMock.setDataCreazione("11/11/2005");
			toMock.setIdentificativoSIPATR("ident. sipatr prova");
			toMock.setTitolo("titolo sipatr prova");
			toMock.setStatoFascicoloDocumentale("stato fascic documentale sipatr prova");
			toMock.setStatoFascicoloSIPATR("statoFascicoloSIPATR sipatr prova");
			toMock.setSistemaProduttore("sistemaProduttore sipatr prova");*/
			/** fine simulazione to**/
			
			List<FascicoloSipatrTO> listaDettFasc=new ArrayList<FascicoloSipatrTO>();
			listaDettFasc.add(to);//TODO scommentare
		//	listaDettFasc.add(toMock);//TODO togliere
			
			context.getResponse().setContentType("application/json");  
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(context.getResponse().getOutputStream(), listaDettFasc);
			   
			context.getResponse().getOutputStream().flush();
			context.getResponse().getOutputStream().close();
	}
	
	


	/*
	public void modaleMetadatiRedCdcOld(Context context) throws Throwable {
		String rowNum = context.getRequest().getParameter("NumFasc");
		
		List<SottoFascicoliRedTO> list = context.getModel(LIST_SOTTO_FASCICOLI_RED);
		SottoFascicoliRedTO to = list.get(Integer.parseInt(rowNum)-1);
		to.setAnagAmminDem(to.getAnagAmminDem()!=null?to.getAnagAmminDem():new AnagAmminDemTO());
		to.setAnagRagionerieDem(to.getAnagRagionerieDem() != null? to.getAnagRagionerieDem(): new AnagRagionerieDemTO());

		List<SottoFascicoliRedTO> listaDettFasc=new ArrayList<SottoFascicoliRedTO>();
		listaDettFasc.add(to);

		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), listaDettFasc);
		   
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
		
	}*/
	
	
}
