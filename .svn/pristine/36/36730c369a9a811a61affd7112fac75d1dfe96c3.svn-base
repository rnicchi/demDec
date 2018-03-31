package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.LetterePreRegManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.LettereIgbTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.PredLetterePreRegForm;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;


public class PredLetterePreRegParentController extends AbstractDemFormController implements WebConstants, SessionAttributes{

	 protected String startView;
	 
	 protected String listaDecretiView;
		
	 protected String listaLettereView;
		
	 @Autowired
	 protected ListManager listManager;
	 
	 @Autowired
	 protected LetterePreRegManager letterePreRegManager;
	
	
	 
	@Override
	public String startController(Context context) throws Throwable {
		context.setCurrentNode("DemDec.menu.PredLetterePreReg");
		context.setDataModel(SessionAttributes.LIST_ANNO_ESE, listManager.loadEserciziDemCG());
		context.setDataModel(SessionAttributes.LIST_TIPI_DECRETI, listManager.loadAnagTipoDecreto());
		context.setDataModel(SessionAttributes.LIST_ANAG_UFF, listManager.loadAnagUfficiAttivi());
		
		return startView;
	}
	
	
	public String onRicercaDecreti(Context context)throws Throwable{
		PredLetterePreRegForm form=(PredLetterePreRegForm) context.getForm();
		if(!form.isValid()){
			return startView;
		}
		
		form.setConferma(null);
		
		FascicoliFadSearhTO to = new FascicoliFadSearhTO();
		to.setAmmin(form.getAmministrazione());
		to.setAnnoDecreto(form.getAnnoDecreto());
		to.setCdr(form.getCdr());
		to.setDataArrivoA(form.getDataArrivoA());
		to.setDataArrivoDa(form.getDataArrivoDa());
		to.setNumeDecreto(form.getNumeDecreto());
		to.setNumePat(form.getNumePat());
		to.setStato(Constants.STATO_FAD_APERTO); 
		to.setTipoDecreto(form.getTipoDecreto());
		to.setTipologiaDecreto(form.getTipologiaDecreto());
		to.setUfficio(form.getUfficio());
		
		//java.util.List<FascicoliTO> lista = getGestioneFadManager().getFascicoliFad(to);//TODO togliere
		java.util.List<FascicoliTO> lista2 =new ArrayList<FascicoliTO>();
		java.util.List<FascicoliTO> lista =letterePreRegManager.findFascicoliFadLetterePreReg(to);//TODO scommentare
		LettereIgbTO letteraTo=new LettereIgbTO();
		
		
		
		boolean flag;
		//controllo se un fascicolo ha già lettere associate
		for (int i = 0; i < lista.size(); i++) {
			letteraTo.setFascicoli(lista.get(i));
			List<LettereIgbTO> listaLettere=letterePreRegManager.findByLettera(letteraTo);
			lista.get(i).setFlagLetterePreReg((listaLettere!=null && listaLettere.size()>0)?1:0);
			
			/*flag=true;
			//devo visualizzare solo i decreti che non hanno lettere con status >= 2
			for (int j = 0; j < listaLettere.size(); j++) {
				try {
					if(Integer.valueOf(listaLettere.get(j).getStatusLettera())>=2){
						flag=false;
						break;
					}
				}catch(NumberFormatException exc){
					
				}
			}
			if(flag){
				lista2.add(lista.get(i));
			}*/
			
			flag=true;
			if(listaLettere.size()>0){//se il decreto non ha lettere associate devo inserirlo nei risultati di ricerca
				flag=false;
				//devo visualizzare solo i decreti che hanno almeno una lettera con status < 2
				for (int j = 0; j < listaLettere.size(); j++) {
					try {
						if(Integer.valueOf(listaLettere.get(j).getStatusLettera())<2){
							flag=true;
							break;
						}
					}catch(NumberFormatException exc){
						
					}
				}
			}
			if(flag){
				lista2.add(lista.get(i));
			}
			
			
		}
		
		
		if (lista2==null || lista2.size()==0){
			PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
			context.addWarning("warning.empty");
			return startView;
		}else {
			PaginatorUtil.addPaginator(lista2,LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);
		}
		
		context.setDataModel(LIST_DECRETI_LETTERE_PRE_REG, lista2);
		
		return  listaDecretiView;
	}
	
	
	
	 public String onVisualizzaLettereDecreto(Context context) throws Throwable {
	    	LettereIgbTO lettera=new LettereIgbTO();
	    	java.util.List<FascicoliTO> listaFascicoli=context.getModel(LIST_FASCICOLI_FAD);
	    	//String rowNum = context.getCommandParameter("visualizzaLettereDecreto");
	    	String rowNum=getParameter(context, "visualizzaLettereDecreto");
	    	FascicoliTO fascicolo=listaFascicoli.get(new Integer(rowNum));
	    	lettera.setFascicoli(fascicolo);
	    	
	    	java.util.List<LettereIgbTO> listaLettere=letterePreRegManager.findByLettera(lettera) ;
	    	
	    	if (listaLettere==null || listaLettere.size()==0){
				PaginatorUtil.removePaginator(context, LIST_LETTERE_PRE_REG);
				context.addWarning("warning.empty");
				return listaDecretiView;
			}else {
				
				PaginatorUtil.addPaginator(listaLettere, LIST_LETTERE_PRE_REG, Paginator.PAGE_RANGE_15, context);
		    
		    	return listaLettereView;
			}
	    
	  }
	 
	  public String onBackFromLettere(Context context) throws Throwable{
			
			List<FascicoliTO>  lista=context.getModel(LIST_DECRETI_LETTERE_PRE_REG);
			
			if (lista==null || lista.size()==0){
				PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD, SessionAttributes.OBJECT_PAGINATOR);
				context.addWarning("warning.empty");
			}else {
				PaginatorUtil.addPaginator(context, lista, LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15,  SessionAttributes.OBJECT_PAGINATOR);
			}
			
			return  listaDecretiView;
			
	 }
	  
	  
	  public String onBackFromPersonalizza(Context context) throws Throwable{
			
			List<LettereIgbTO>  listaLettere=context.getModel(LIST_LETTERE_PRE_REG);
			
			if (listaLettere==null || listaLettere.size()==0){
				PaginatorUtil.removePaginator(context, LIST_LETTERE_PRE_REG, SessionAttributes.OBJECT_PAGINATOR);
				context.addWarning("warning.empty");
			}else {
				PaginatorUtil.addPaginator(context, listaLettere, LIST_LETTERE_PRE_REG, Paginator.PAGE_RANGE_15,  SessionAttributes.OBJECT_PAGINATOR);
			}
			
			return  listaLettereView;
			
	 }
	
	
	
	public void setStartView(String startView) {
			this.startView = startView;
	}
	 
	public void setListaDecretiView(String listaDecretiView) {
		this.listaDecretiView = listaDecretiView;
	}

	public void setListaLettereView(String listaLettereView) {
		this.listaLettereView = listaLettereView;
	}
	
	
	

}
