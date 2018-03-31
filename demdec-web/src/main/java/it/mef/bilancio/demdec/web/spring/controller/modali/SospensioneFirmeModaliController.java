package it.mef.bilancio.demdec.web.spring.controller.modali;

import static it.almavivaitalia.bsn.sh.utils.ValidationUtil.isNumber;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.SospensioneFirmeForm;
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


@RequestMapping(value = ConstantsRequestMapping.SOSPENSIONE_FIRME_MODALI)
public class SospensioneFirmeModaliController  extends AbstractDemFormController implements WebConstants, SessionAttributes{
	
	private String startView;	
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ListManager listManager;
	
	public ServletContext getServletContext() {
		return servletContext;
	}
	
	
	@Override
	public String startController(Context context) throws Throwable {
		return startView;
	}
	
	/******metodo per visualizzare i decreti per Sospensione firme*****/
	public void modaleSospensioneFirme(Context context) throws Throwable {
		
		SospensioneFirmeForm form= (SospensioneFirmeForm) context.getForm();

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
				   anno2=new Integer(anno);
				  
			   }catch (NumberFormatException exc){
				  
			   }
			   try{
				   numero2=new Integer(numero);
			   }catch (NumberFormatException exc){
				   numero2=(numero==null || numero.trim().equals(""))?null:-1;
			   }
			   try{
				   tipoFlusso2=new Integer(tipoFlusso);
			   }catch (NumberFormatException exc){
				   
			   }
			    
//			    FascicoliViewTO fascTo=null;
//			    
//			    context.getResponse().setContentType("application/json");   
//				
//				HttpServletResponse resp=context.getResponse();
//				List<FascicoliViewTO> articles=null;
				
			   try {
				   articles=listManager.findSospFirmeListaDecretiByTipoNumAnno(anno2, tipoFlusso2, numero2);
				   if (articles==null || articles.size()==0){
					   fascTo=new FascicoliViewTO();
					   fascTo.setDescSigla("NO RECORD");
					   articles.add(fascTo);
				   }
			   }catch (Exception ex){
				  // errors=new ArrayList<String>() ; 
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

	public void setStartView(String startView) {
		this.startView = startView;
	}
	
}
