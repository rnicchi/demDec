package it.mef.bilancio.demdec.web.spring.controller.modali;

import static it.almavivaitalia.bsn.sh.utils.ValidationUtil.isNumber;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.RicercaRedManager;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.AnagStatoFascicoloTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.RicercaRedForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;


@RequestMapping(value = ConstantsRequestMapping.RICERCA_RED_MODALI)
public class AssociazioneAFadModaliController  extends AbstractDemFormController implements WebConstants, SessionAttributes {
	
	private String startView;	
	
	@Autowired
	private RicercaRedManager ricercaRedManager;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ListManager listManager;
	
	public ServletContext getServletContext() {
		return servletContext;
	}
	

	@Override
	public String startController(Context context) throws Throwable {
		
		context.setCurrentNode("DemDec.menu.RicercaProvv");
		
		List<EserciziTO> listaAnniEsercizio=listManager.loadEserciziDemCG();
		List<AnagUfficiTO> listaUfficiAssociatiRed=listManager.loadAnagUffici();
		List<AnagStatoFascicoloTO> listaStatiFascRed=listManager.loadStatiFascicoliRed();
		List<AnagAmminDemTO> listaAmm=new ArrayList<AnagAmminDemTO>();
		
		context.setDataModel(WebConstants.LIST_ANNO_ESE, listaAnniEsercizio);
		context.setDataModel(WebConstants.LIST_ANAG_UFF, listaUfficiAssociatiRed);
		context.setDataModel(WebConstants.LIST_ANAG_STATI_FASC, listaStatiFascRed);
		context.setDataModel(WebConstants.LIST_AMMIN_DEM, listaAmm);
		
		return startView;
		
	}
	
	/******metodo per visualizzare i metadati di un fascicolo*****/

	public void modaleDettaglioFascicolo(Context context) throws Throwable {
		RicercaRedForm form= (RicercaRedForm) context.getForm();
		
		String idFascicolo=form.getIdRed();		//idFascicoloRaccoltaProvvisoria
		List<RaccoltaProvvisoriaRedTO> listaDettFasc=new ArrayList<RaccoltaProvvisoriaRedTO>();

		RaccoltaProvvisoriaRedTO errorTo=null;
		try {
			List<AbstractDemTO>  listaDettFascWs=context.getModel(SessionAttributes.LIST_RICERCA_RED);

			RaccoltaProvvisoriaRedTO rprTo=null;
			for (int i=0; i<listaDettFascWs.size(); i++){
				if (idFascicolo.equals( ((RaccoltaProvvisoriaRedTO)listaDettFascWs.get(i)).getIdFascicoloRaccoltaProvvisoria()) ) {
					rprTo=(RaccoltaProvvisoriaRedTO)listaDettFascWs.get(i);
					if(rprTo.getCodiStatoFascicoloDocumentale()!=null){
						rprTo.setDescStatoFascicoloDocumentale(listManager.loadDescStatiFascicoliRed(rprTo.getCodiStatoFascicoloDocumentale()));
					}
					listaDettFasc.add(rprTo);
					
				    break;
				}
			}

		}catch (Exception ex){
			listaDettFasc=new ArrayList<RaccoltaProvvisoriaRedTO> ();
			errorTo=new RaccoltaProvvisoriaRedTO();
			errorTo.setTitle("ERRORE");
			errorTo.setWarningCode("ERRORE");
			listaDettFasc.add(errorTo);
		}
		  
		context.getResponse().setContentType("application/json");  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(context.getResponse().getOutputStream(), listaDettFasc);
		context.getResponse().getOutputStream().flush();
		context.getResponse().getOutputStream().close();
	}
	
	
	/******metodo per visualizzare i decreti*****/
	public void modaleListaDecreti(Context context) throws Throwable {
		RicercaRedForm form= (RicercaRedForm) context.getForm();

		String tipoFlusso=form.getTipoFlusso();
		String anno=form.getAnnoEse();
		String numero=form.getNumero();
		
		ObjectMapper mapper = new ObjectMapper();
		context.getResponse().setContentType("application/json");   
		HttpServletResponse resp=context.getResponse();
		
		List<FascicoliViewTO> articles=null;
		FascicoliViewTO fascTo=null;
		if (!isNumber(numero)){
			   articles=new ArrayList<FascicoliViewTO> ();
			   fascTo=new FascicoliViewTO();
			   fascTo.setDescSigla("ERRORE NUM DECRETO");
			   fascTo.setNumeNumDecreto(numero);
			   articles.add(fascTo);
		}else {
		
			   Integer anno2=null;
			   Integer numero2=null;
			   Integer tipoFlusso2=null;
			   
			   if(tipoFlusso==null || tipoFlusso.equals("")){
				   tipoFlusso2=null;
			   }
			   if(anno==null || anno.equals("")){
				   anno2=null;
			   }
			   if(numero==null || numero.equals("")){
				   numero2=null;
			   }
			   
			   try{
				   anno2=new Integer(anno.trim());
				  
			   }catch (NumberFormatException exc){
				   
			   }
			   try{
				   numero2=new Integer(numero.trim());
			   }catch (NumberFormatException exc){
				   
			   }
			   try{
				   tipoFlusso2=new Integer(tipoFlusso.trim());
			   }catch (NumberFormatException exc){
				   
			   }
			   
			   try {
					   articles=ricercaRedManager.findFascicoloByTipoNumAnnoStato(anno2, tipoFlusso2, numero2);
					   if (articles==null || articles.size()==0) {
							   articles= ricercaRedManager.findFascicoloByTipoNumAnno(anno2, tipoFlusso2, numero2);
							   if (articles!=null && articles.size()>0) {
								   for (int i = 0; i < articles.size(); i++) {
									   articles.get(i).setDescSigla("ERRORE STATO FASCICOLO");
									   articles.get(i).setDescStato(listManager.loadDecStatiFascicoliFad(articles.get(i).getStatStato()).trim());
								   }
							   }else {
								   fascTo=new FascicoliViewTO();
								   fascTo.setDescSigla("NO RECORD");
								   articles.add(fascTo);
							   }
					   }
			   }catch (Exception ex){
				   articles=new ArrayList<FascicoliViewTO> ();
				   fascTo=new FascicoliViewTO();
				   fascTo.setDescSigla("ERRORE");
				   articles.add(fascTo);
			   }
	   
	}
	   
	   mapper.writeValue(resp.getOutputStream(), articles);
	   
	    resp.getOutputStream().flush();
	    resp.getOutputStream().close();

	}
	
	
	public void modaleDettaglioDocumento(Context context) throws Throwable {
		List<DocumentTO> listDocTO=null;
		List<DocumentTO> listDoc=null;
		DocumentTO docto=null;
		HttpServletResponse resp=null;
		ObjectMapper mapper = new ObjectMapper();
		context.getResponse().setContentType("application/json");    		
		resp=context.getResponse();
		 
		try {
			
			listDocTO=context.getModel(WebConstants.LIST_DOC_FASC);
			String rowNum = context.getRequest().getParameter("idRigaDoc");
			
			DocumentTO toDoc=listDocTO.get(Integer.parseInt(rowNum)-1);
			listDoc=new ArrayList<DocumentTO> ();
			listDoc.add(toDoc);
			
		 }catch (Exception ex){
			 listDoc=new ArrayList<DocumentTO> ();
			 docto=new DocumentTO();
			 docto.setWarningCode("ERRORE");
			 listDoc.add(docto);
		   }
		
		mapper.writeValue(resp.getOutputStream(), listDoc);
	    resp.getOutputStream().flush();
	    resp.getOutputStream().close();

	}
	
	
	public void setStartView(String startView) {
		this.startView = startView;
	}
	
	
}
