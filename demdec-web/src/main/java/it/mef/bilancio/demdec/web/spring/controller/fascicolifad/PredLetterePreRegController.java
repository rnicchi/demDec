package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;



import it.almavivaitalia.bilancio.commons.bo.LettereIgbBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.dao.LettereTestiDao;
import it.mef.bilancio.demdec.manager.LettereTestiPersManager;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.LettereIgbTO;
import it.mef.bilancio.demdec.to.LettereTestiPersTO;
import it.mef.bilancio.demdec.to.LettereTestiPersTOId;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.form.PredLetterePreRegForm;
import it.mef.bilancio.demdec.web.spring.form.PredLettereTestiForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.List;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author utente
 *
 */


@RequestMapping(value = ConstantsRequestMapping.PRED_LETTERE_PRE_REG)
public class PredLetterePreRegController extends PredLetterePreRegParentController {
	
	private static Logger _LOG = Logger.getLogger(PredLetterePreRegController.class);
	
	private String predLetteraConf;
	
	private String modLettereView;

	 
	@Autowired
	private LettereTestiPersManager lettereTestiPersManager;	
 
	@Autowired
	LettereTestiDao lettereTestiDao;
	 

	public void setModLettereView(String modLettereView) {
		this.modLettereView = modLettereView;
	}
	
	 
	public void setPredLetteraConf(String predLetteraConf) {
		this.predLetteraConf = predLetteraConf;
	}


	    
	    public String onDeleteLetteraDecreto(Context context) throws Throwable {

	    	java.util.List<LettereIgbTO> listaLettere=context.getModel(LIST_LETTERE_PRE_REG);
	    	//String rowNum = context.getCommandParameter("deleteLetteraDecreto");
	    	
	    	String rowNum =  getParameter(context, "selectedLettera");
	    	
	    	LettereIgbTO lettera=listaLettere.get(new Integer(rowNum));
	    	
	    	letterePreRegManager.deleteLettera(lettera, Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	    	
	    	java.util.List<LettereIgbTO> listaLettereNew=letterePreRegManager.findLettereByIdDecreto(lettera.getFascicoli().getId()) ;
	    	if (listaLettereNew==null || listaLettereNew.size()==0){
				PaginatorUtil.removePaginator(context, LIST_LETTERE_PRE_REG);
			}else {
				PaginatorUtil.addPaginator(listaLettereNew, LIST_LETTERE_PRE_REG, Paginator.PAGE_RANGE_15, context);
			}
	    	
	    	context.addInfo("info.delete.success");
		    return listaLettereView;
			
	    }
	    
	    
	    public String onPersonalizza(Context context) throws Throwable {
    		PredLetterePreRegForm form = (PredLetterePreRegForm) context.getForm();
    		form.setPredLettereTestiFormList(null);
    		
    		//java.util.List<FascicoliTO> listaFascicoli = context.getModel(LIST_FASCICOLI_FAD);
    		java.util.List<LettereIgbTO> listaLettere = context.getModel(LIST_LETTERE_PRE_REG);
    		
        	
    		//String rowNum = context.getCommandParameter("personalizza");    
        	String rowNum=getParameter(context, "personalizza");
        	
        	LettereIgbTO lettera=listaLettere.get(new Integer(rowNum));
        	
        	FascicoliTO fascicolo = lettera.getFascicoli();
        	form.setIdFascicolo(fascicolo.getId());
        	
        //	List<SottoFascicoliRedTO> listSottoFascicoliRed=letterePreRegManager.getSottoFascicoliRedByIdFad(fascicolo.getId());
        	
        //	List<LettereTestiTO> testiPers = lettereTestiPersManager.findActualTestoFasc(fascicolo.getId(), Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE, Constants.CODI_SEZIONE_CORPO_LETTERA_PREREGISTRAZIONE);
        	List<LettereTestiPersTO> testiPers = lettereTestiPersManager.findTestoPersByIdLettera(new Long(lettera.getId().toString()), Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	        
        	List<PredLettereTestiForm> testiFormList=new ArrayList<PredLettereTestiForm>();
        	
        	PredLettereTestiForm predForm=null;
        	String prot=null;
        	for (int i = 0;  i<testiPers.size(); i++) {
        		if(   (testiPers.get(i).getId().getCodiSezione().equals(Constants.SEZIONE_5) &&  testiPers.get(i).getId().getNumeRiga().equals("1") )
        		  ||  (testiPers.get(i).getId().getCodiSezione().equals(Constants.SEZIONE_3) &&  testiPers.get(i).getId().getNumeRiga().equals("1") )
        		  ||  (testiPers.get(i).getId().getCodiSezione().equals(Constants.SEZIONE_7) &&  testiPers.get(i).getId().getNumeRiga().equals("2") )
        		  ||  (testiPers.get(i).getId().getCodiSezione().equals(Constants.SEZIONE_8) &&  testiPers.get(i).getId().getNumeRiga().equals("1") )  
        		  ||  (testiPers.get(i).getId().getCodiSezione().equals(Constants.SEZIONE_4) &&  testiPers.get(i).getId().getNumeRiga().equals("3") )
        		  ||  (testiPers.get(i).getId().getCodiSezione().equals(Constants.SEZIONE_1) &&  testiPers.get(i).getId().getNumeRiga().equals("4") )
        		  ||  (testiPers.get(i).getId().getCodiSezione().equals(Constants.SEZIONE_9) &&  testiPers.get(i).getId().getNumeRiga().equals("1") )
        				)   {
        						  
	        		predForm=new PredLettereTestiForm();
	        		predForm.setIdLettera(new Long(lettera.getId().toString()));
	        		predForm.setNumRiga(testiPers.get(i).getId().getNumeRiga());
	        		predForm.setSezione(testiPers.get(i).getId().getCodiSezione());
	        		
	        		//nel caso del protocollo nella combo devo visualizzare solo il numero, quindi tolgo la parte da non far vedere
	        		if(   (testiPers.get(i).getId().getCodiSezione().equals(Constants.SEZIONE_5) &&  testiPers.get(i).getId().getNumeRiga().equals("1") ) ){
		        			prot=testiPers.get(i).getTextContenuto().replace(Constants.PROTOCOLLO, "").trim();
		        			if(StringUtil.isEmpty(prot)){
		        				predForm.setContenuto("Selezione");
		        			}else{
			        			boolean flagAltro=true;
			        			//se c'è qualche sottofascicolo red verifico se il protocollo di uno di questi corrisponde al protocollo della lettera
			        			if(!(fascicolo.getSottoFascicoliRedList().size()==0) ){
				        			for (int j = 0; j < fascicolo.getSottoFascicoliRedList().size(); j++) {
				        				if(fascicolo.getSottoFascicoliRedList().get(j).getNumeProtocollo().equalsIgnoreCase(prot)) {
				        					flagAltro=false;
				        					break;
				        				}
									}
			        			}
			        			if(flagAltro){
			        				predForm.setContenuto("Altro");
			        				form.setAltroProtocolloEntrata(prot);
			        			}else{
			        				predForm.setContenuto(prot);
			        			}
		        			}
	        		}else {
	        			predForm.setContenuto(testiPers.get(i).getTextContenuto());
	        		}
	        		testiFormList.add(predForm);
        		}
			}
        	
        	
        	form.setPredLettereTestiFormList((ArrayList<PredLettereTestiForm>)testiFormList);
        	//attualmente gestisce solo un testo
  //      	form.setTextContenuto(testiPers.get(0).getTextContenuto());
        	
        	context.setDataModel(LIST_TESTI_PERS, testiFormList);
        	
        	context.setDataModel(LETTERA_SELEZIONATA, lettera);
        	
        	context.setDataModel(LIST_SOTTO_FASCICOLI_RED, fascicolo.getSottoFascicoliRedList());
        	
    		return modLettereView;
    	}
    	
	    
	    
	    public String  onSalvaPersonalizza (Context context) throws Throwable {
			PredLetterePreRegForm form=(PredLetterePreRegForm) context.getForm();
			
			if(form.isValid()){
			
				LettereIgbTO letteraIgb=context.getModel(LETTERA_SELEZIONATA);
	
				//java.util.List<FascicoliTO> listFascicoli=context.getModel(LIST_FASCICOLI_FAD);
				FascicoliTO fascicolo=letteraIgb.getFascicoli();
	//			List<AnagAmminDemTO> listaAmm=letterePreRegManager.findAmministrazioniByIdFascicolo(fascicolo.getId());
				
				List<LettereTestiPersTO> testiLettere=lettereTestiPersManager.findTestoPersByIdLettera(new Long(letteraIgb.getId().toString()), Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		        		
		        List<LettereTestiPersTO> lettPersToList= creaElementiLetteraModifica(fascicolo, testiLettere, form);
		        for (LettereTestiPersTO lettereTestiPersTO : lettPersToList) {
		        	   context.valorizeAuditUpdated(lettereTestiPersTO, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		        }
	      
	           String realPath=context.getRealPath("/public/img/");
	           letteraIgb.setStatusLettera("1");
	           letterePreRegManager.modificaDatiPersELettera(letteraIgb, Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE, fascicolo, lettPersToList, null,  letteraIgb.getAnagAmminDem().getDescAmm(), realPath);
		        
		        form.setConferma(null);
		        
		        java.util.List<FascicoliTO> lista = context.getModel(LIST_FASCICOLI_FAD);
				
				LettereIgbTO letteraTo=new LettereIgbTO();
				
				//controllo se un fascicolo ha già lettere associate
				List<LettereIgbTO> listaLettere=null;
				for (int i = 0; i < lista.size(); i++) {
					letteraTo.setFascicoli(lista.get(i));
					listaLettere=letterePreRegManager.findByLettera(letteraTo);
					lista.get(i).setFlagLetterePreReg((listaLettere!=null && listaLettere.size()>0)?1:0);
				}
				
				PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
				PaginatorUtil.addPaginator(lista, LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);
				context.addInfo("info.update.success");
			}
	        return modLettereView;
}

		
	    
		
		
		
		public String  onStampa (Context context) throws Throwable {
			PredLetterePreRegForm form=(PredLetterePreRegForm) context.getForm();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			
			if(!form.isValid()){
				return listaDecretiView;
			}
			//String radButtDecr=form.getRadioButtonDecreti();
			java.util.List<FascicoliTO> listFascicoli=context.getModel(LIST_FASCICOLI_FAD);
			
	//		String rowNum0 = context.getCommandParameter("stampa");
			String rowNum =null;
			try {
				rowNum =getParameter(context, "stampa");
			}catch(Exception exc){
				rowNum=form.getRadioButtonDecreti();
			}
//			if( StringUtil.isEmpty(rowNum)){
//				rowNum=form.getRadioButtonDecreti();
//			}
			form.setRadioButtonDecreti(rowNum);
			
			FascicoliTO fascicolo=listFascicoli.get(Integer.valueOf(rowNum));
			
			
			List<AnagAmminDemTO> listaAmm=letterePreRegManager.findAmministrazioniByIdFascicolo(fascicolo.getId());
			
	        
	        String [] testiLettere=letterePreRegManager.getLettereTestiByTipo("L-IGB");
	     
	        String dest=null;
	        LettereIgbTO lettera=null;
	        
	        
	        List<LettereTestiPersTO> lettPersToList=null;
	        
	        
	        for (AnagAmminDemTO amminDemTo : listaAmm) {
		           dest= amminDemTo.getDescAmm();

		           String realPath=context.getRealPath("/public/img/");
		        	
		         //  pdfBytes= createPdf(new Integer(12), fascicolo.getEserciziDem().getId().toString()/* "2015"*/, fascicolo.getNumeNumDecreto(), "Tit prova", idAmm, dest,  new Long[5], testiLettere, realPath);
	        	   
		           lettPersToList=creaElementiLetteraInserimento(fascicolo, testiLettere, dest);
		           for (LettereTestiPersTO lettereTestiPersTO : lettPersToList) {
		        	   context.valorizeAudit(lettereTestiPersTO, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           }
		           Date data=new Date();
	        	   lettera=new LettereIgbTO();
	        	   
			       lettera.setAnagAmminDem(amminDemTo);
			       lettera.setFascicoli(fascicolo);
			     //  Blob blob = Hibernate.createBlob(pdfBytes);
			       lettera.setBinaIntLettera(null);  
			       lettera.setDataLettera( sdf.parse( sdf.format(data)));
			       lettera.setStatusLettera("0");
		           
		          
			       LettereIgbBO old = letterePreRegManager.findByUK(lettera);
			       if(old != null && form.getConferma() == null){
			    	   context.addWarning("warning.sovrascrittura.lettera");
			    	   form.setConferma("true");
			    	   return predLetteraConf;
			       }
			       
			       context.valorizeAudit(lettera, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
			       letterePreRegManager.inserisciDatiPersELettera(lettera, Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE, fascicolo, lettPersToList, null, dest, realPath);
	        	  
			     //  form.setConferma(null);
			       
			      
			   //    lettera.setNumeroProgLettera(new Long(1));
			       //questa operazione effettua una insert o una update
			     //  letterePreRegManager.aggiornaLettere(lettera, blob, lettPersToList);
			}
	        
	        form.setConferma(null);
	        
	        java.util.List<FascicoliTO> lista = context.getModel(LIST_FASCICOLI_FAD);
			
			LettereIgbTO letteraTo=new LettereIgbTO();
			
			//controllo se un fascicolo ha già lettere associate
			List<LettereIgbTO> listaLettere=null;
			for (int i = 0; i < lista.size(); i++) {
				letteraTo.setFascicoli(lista.get(i));
				listaLettere=letterePreRegManager.findByLettera(letteraTo);
				lista.get(i).setFlagLetterePreReg((listaLettere!=null && listaLettere.size()>0)?1:0);
			}
			
			PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
			PaginatorUtil.addPaginator(lista, LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);
			context.addInfo("info.update.success");
	        return  listaDecretiView;
}

		
		
	    	

	   
	    	
	 	    public String onNuovaRicerca(Context context)  {
	 	    	PredLetterePreRegForm form=(PredLetterePreRegForm) context.getForm();
	 	    	
	 	    	form.setAmministrazione(null);
	 	    	form.setAnnoDecreto(null);
	 	    	form.setCdr(null);
	 	    	form.setCreatoDa(null);
	 	    	form.setDataArrivoA(null);
	 	    	form.setCdr(null);
	 	    	form.setDataArrivoA(null);
	 	    	form.setDataArrivoDa(null);
	 	    	form.setDataCreazione(null);
	 	    	form.setDataModifica(null);
	 	    	form.setDecTipoDecreto(null);
	 	    	form.setDescDecreto(null);
	 	    	form.setDescStato(null);
	 	    	form.setModificatoDa(null);
	 	    	form.setNumeDecreto(null);
	 	    	form.setNumePat(null);
	 	    	form.setRadioButtonDecreti(null);
	 	    	form.setDecTipoDecreto(null);
	 	    	form.setDescDecreto(null);
	 	    	form.setDescStato(null);
	 	    	form.setModificatoDa(null);
	 	    	form.setDataModifica(null);
	 	    	form.setDataCreazione(null);
	 	    	form.setStato(null);
	 	    	form.setUfficio(null);
	 	    	form.setUfficioCreatore(null);
	 	    	form.setTipoDecreto(null);
	 	    	form.setTipologiaDecreto(null);
	 	    	
    			return startView;
    			
    		}
	 	    
	    	
	    	
	    	public void onApriLettera(Context context) throws Throwable{
	     			SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
	     			List<LettereIgbTO> toList = context.getModel(LIST_LETTERE_PRE_REG);
	     			String rowNum = context.getCommandParameter("apriLettera");
	 	    		LettereIgbTO letteraIgb=toList.get(new Integer(rowNum));
	 	    		
	 	    	//	LettereIgbTO letteraIgbWithBlob=letterePreRegManager.getLetteraById(new Long(letteraIgb.getId().toString()));
	 	    		
	 	    		 Blob blob=letterePreRegManager.getBlobByIdLettera(letteraIgb.getId());
	 	    		
	 		 		String nomeFile=null;
	 		 		//	letteraIgb=predLettereManager.findById(new Long(filtro.getLetteraIgb()));
	 		 		//	letteraIgb=letterePreRegManager.getLetteraById(new Long(filtro.getLetteraIgb())); TODO scommentare
 			 		nomeFile=letteraIgb.getFascicoli().getEserciziDem().getId()+"_"+letteraIgb.getAnagAmminDem().getId().getNumeStpFormatted()+letteraIgb.getAnagAmminDem().getId().getNumeAppFormatted()+"_"+sdf.format(letteraIgb.getDataLettera())+".pdf";
 			    	HttpHeaders responseHeaders = new HttpHeaders();
 			        responseHeaders.set("Content-Disposition", "attachment; filename="+nomeFile);
 			        responseHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
 			        
// 			        Blob blob=letteraIgbWithBlob.getBinaIntLettera();
 			        int blobLength = (int) blob.length();  
 			        byte[] blobAsBytes = blob.getBytes(1, blobLength);
 			        //release the blob and free up memory. (since JDBC 4.0)
 			        
 			       context.getResponse().setContentType("multipart/form-data");
					context.getResponse().setHeader("Content-Disposition","attachment;filename="+nomeFile);
					ServletOutputStream out;
					
					out = context.getResponse().getOutputStream();
					out.write(blobAsBytes);
					out.flush();
					out.close();
 			        
 			        
 			      //  return new ResponseEntity<byte[]>(blobAsBytes, responseHeaders, HttpStatus.OK); 
 		 			
	     	}
	 		 		
	     	

	    	
	    	
	    	
	    	
	    	public String onInvioAlleFirme(Context context) throws Throwable {
	    		LettereIgbTO lettera=new LettereIgbTO();
		    	java.util.List<FascicoliTO> listaFascicoli=context.getModel(LIST_FASCICOLI_FAD);

		    	String rowNum=getParameter(context, "invioAlleFirme");
		    	FascicoliTO fascicolo=listaFascicoli.get(new Integer(rowNum));
		    	lettera.setFascicoli(fascicolo);
		    	
		    	//java.util.List<LettereIgbTO> listaLettere=letterePreRegManager.findByLettera(lettera) ;
		    	java.util.List<LettereIgbTO> listaLettere=letterePreRegManager.findLettereByIdDecreto(fascicolo.getId());
		    	
		    	String user=getUtenteInSessione().getUtente().getCodiUtente();
		    	
		    	for (int i = 0; i < listaLettere.size(); i++) {
		    		context.valorizeAuditUpdated(listaLettere.get(i), NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
				}
		    	
		    	letterePreRegManager.invioAllefirme(listaLettere, user, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		    	
		    	listaFascicoli.remove(fascicolo);
		    	context.addInfo("info.update.success");
		    	
		    	
		    	if (listaFascicoli==null || listaFascicoli.size()==0){
					PaginatorUtil.removePaginator(context, LIST_FASCICOLI_FAD);
					context.addWarning("warning.empty");
					return listaDecretiView;
				}else {
					PaginatorUtil.addPaginator(listaFascicoli,LIST_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, context);
				}
				
				context.setDataModel(LIST_DECRETI_LETTERE_PRE_REG, listaFascicoli);
		    	
	    		return listaDecretiView;
	    	}
	    	
	    	
	    	

	 		public String onCaricaTipologiaDecretoFadPage(Context context)throws Throwable{
	 			PredLetterePreRegForm form=(PredLetterePreRegForm) context.getForm();
	 			if (form.isValid()){
	 				if(form.getTipoDecreto() != null && !"".equals(form.getTipoDecreto())){
	 					context.setDataModel(LIST_TIPOLOGIA_DECRETO, listManager.tipologiaDecretoList(Integer.parseInt(form.getTipoDecreto())));
	 				}
	 				else {
	 					context.setDataModel(LIST_TIPOLOGIA_DECRETO, listManager.tipologiaDecretoList(null));
	 				}
	 			}
	 			//return getFascicoloFadView();
	 			return startView;
	 		}
	 		
	 		public String onCaricaAmmin(Context context) throws Throwable{
	 			PredLetterePreRegForm form = context.getForm();
	 			if (form.isValid()){
	 				context.setDataModel(SessionAttributes.LIST_AMMIN_DEM, listManager.getAmminDemByAnnoEse(form.getAnnoDecreto()));
	 			}
	 			return startView;
	 		}


	 		//creo gli elementi per la tabella d_lettere_testi_pers, per il caso di modifica di una lettera 
	 		private List<LettereTestiPersTO> creaElementiLetteraModifica(FascicoliTO fascicolo, List<LettereTestiPersTO> testiLettere, PredLetterePreRegForm form)  throws Throwable{
	 			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				List<LettereTestiPersTO> lettPersToList=new ArrayList<LettereTestiPersTO>();
				LettereTestiPersTO lettPersTo=null;
				LettereTestiPersTOId testiPersId=null;
				
	 			  lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_1);
		           testiPersId.setNumeRiga("1");
		           lettPersTo.setId(testiPersId);
		           lettPersTo.setTextContenuto(Constants.LOGO);//logo
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		      //     testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);//L-IGB
		           testiPersId.setCodiSezione(Constants.SEZIONE_1); //01-INT
		           testiPersId.setNumeRiga("2");
		           lettPersTo.setId(testiPersId);
		           lettPersTo.setTextContenuto(Constants.DIP_RGS);
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		     //      testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);//L-IGB
		           testiPersId.setCodiSezione(Constants.SEZIONE_1); //01-INT
		           testiPersId.setNumeRiga("3");
		           lettPersTo.setId(testiPersId);
		           lettPersTo.setTextContenuto(Constants.ISP_BIL);
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		        
		        lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		       //    testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_1);
		           testiPersId.setNumeRiga("4");
		           lettPersTo.setId(testiPersId);
		           lettPersTo.setTextContenuto(testiLettere.get(3).getTextContenuto());//ufficio
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_2);
		           testiPersId.setNumeRiga("1");
		           lettPersTo.setId(testiPersId);
		           Date data = new Date();
		         //  lettPersTo.setTextContenuto("Roma, "+ sdf.format(data));//Luogo, data creazione
		           lettPersTo.setTextContenuto(sdf.format(data));//Luogo, data creazione
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           
		           
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_3);
		           testiPersId.setNumeRiga("1");
		           lettPersTo.setId(testiPersId);
		           lettPersTo.setTextContenuto(testiLettere.get(5).getTextContenuto());//Amministrazioni Destinatarie
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_4);
		           testiPersId.setNumeRiga("3");
		           lettPersTo.setId(testiPersId);
		           lettPersTo.setTextContenuto(Constants.UFF_CENTR_BIL);//Ufficio Centrale Bilancio
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           
		           
		           
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_5);
		           testiPersId.setNumeRiga("1");
		           lettPersTo.setId(testiPersId);
		           
		        //   String prot=(fascicolo.getSottoFascicoliRedList()!=null && fascicolo.getSottoFascicoliRedList().size()>0)? fascicolo.getSottoFascicoliRedList().get(0).getNumeProtocollo().toString():"";
		           String prot=null;
		           if(form.getPredLettereTestiFormList().get(3).getContenuto().equalsIgnoreCase("Altro")){
		        	   prot= Constants.PROTOCOLLO+" "+form.getAltroProtocolloEntrata();
		           }else{
		        	   prot= Constants.PROTOCOLLO+" "+form.getPredLettereTestiFormList().get(3).getContenuto();
		           }
		           lettPersTo.setTextContenuto(prot);//protocollo
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           
		           
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_6);
		           testiPersId.setNumeRiga("2");
		           lettPersTo.setId(testiPersId);
		           lettPersTo.setTextContenuto( testiLettere.get(8).getTextContenuto());
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		          
		        
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_7);
		           testiPersId.setNumeRiga("2");
		           lettPersTo.setId(testiPersId);
		           String oggetto=form.getPredLettereTestiFormList().get(4).getContenuto();
		           lettPersTo.setTextContenuto( oggetto);//oggetto
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_8);
		           testiPersId.setNumeRiga("1");
		           lettPersTo.setId(testiPersId);
		           String testo=form.getPredLettereTestiFormList().get(5).getContenuto();
		           lettPersTo.setTextContenuto( testo);//corpo
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           
		           /***note***/
		           lettPersTo=new LettereTestiPersTO();
		           testiPersId=new LettereTestiPersTOId();
		           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
		           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
		           testiPersId.setCodiSezione(Constants.SEZIONE_9);
		           testiPersId.setNumeRiga("1");
		           lettPersTo.setId(testiPersId);
		           String note=form.getPredLettereTestiFormList().get(6).getContenuto(); //note
		           lettPersTo.setTextContenuto(note);//note
		           lettPersTo.setFascicoli(fascicolo);
		          // context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
		           lettPersToList.add(lettPersTo);
		           /***fine note***/
		           
		           return lettPersToList;
	 			
	 		}
	    
	 		
	 	//creo gli elementi per la tabella d_lettere_testi_pers, per il caso di inserimento di una lettera
		private List<LettereTestiPersTO> creaElementiLetteraInserimento(FascicoliTO fascicolo, String[] testiLettere, String dest)  throws Throwable{
			
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			List<LettereTestiPersTO> lettPersToList=new ArrayList<LettereTestiPersTO>();
			LettereTestiPersTO lettPersTo=null;
			LettereTestiPersTOId testiPersId=null;
			
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_1);
	           testiPersId.setNumeRiga("1");
	           lettPersTo.setId(testiPersId);
	           lettPersTo.setTextContenuto(Constants.LOGO);//logo
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	      //     testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);//L-IGB
	           testiPersId.setCodiSezione(Constants.SEZIONE_1); //01-INT
	           testiPersId.setNumeRiga("2");
	           lettPersTo.setId(testiPersId);
	           lettPersTo.setTextContenuto(Constants.DIP_RGS);
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	     //      testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);//L-IGB
	           testiPersId.setCodiSezione(Constants.SEZIONE_1); //01-INT
	           testiPersId.setNumeRiga("3");
	           lettPersTo.setId(testiPersId);
	           lettPersTo.setTextContenuto(Constants.ISP_BIL);
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	       //    testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_1);
	           testiPersId.setNumeRiga("4");
	           lettPersTo.setId(testiPersId);
	           lettPersTo.setTextContenuto(fascicolo.getUfficioCapofila().getDescUfficio());//ufficio
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           
	           
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_2);
	           testiPersId.setNumeRiga("1");
	           lettPersTo.setId(testiPersId);
	           Date data = new Date();
	         //  lettPersTo.setTextContenuto("Roma, "+ sdf.format(data));//Luogo, data creazione
	         //  lettPersTo.setTextContenuto(testiLettere[5].replace("$data", sdf.format(data)));//Luogo, data creazione
	           lettPersTo.setTextContenuto("");//Luogo, data creazione
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           
	           
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_3);
	           testiPersId.setNumeRiga("1");
	           lettPersTo.setId(testiPersId);
	           lettPersTo.setTextContenuto(dest);//Amministrazioni Destinatarie
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           
	           
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_4);
	           testiPersId.setNumeRiga("3");
	           lettPersTo.setId(testiPersId);
	           lettPersTo.setTextContenuto(Constants.UFF_CENTR_BIL);//Ufficio Centrale Bilancio
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           
	           
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_5);
	           testiPersId.setNumeRiga("1");
	           lettPersTo.setId(testiPersId);
	           String prot=(fascicolo.getSottoFascicoliRedList()!=null && fascicolo.getSottoFascicoliRedList().size()>0)? fascicolo.getSottoFascicoliRedList().get(0).getNumeProtocollo().toString():"";
	           lettPersTo.setTextContenuto( testiLettere[10].replace("$PRO", prot));//protocollo
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           
	           
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_6);
	           testiPersId.setNumeRiga("2");
	           lettPersTo.setId(testiPersId);
	           lettPersTo.setTextContenuto( testiLettere[11]);
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	          
	           
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_7);
	           testiPersId.setNumeRiga("2");
	           lettPersTo.setId(testiPersId);
	           String oggetto=testiLettere[12].replace("$ANNO", fascicolo.getEserciziDem().getId().toString()).replace("$NUMERO", fascicolo.getNumeNumDecreto().toString()).replace("$DESCRIZIONE", fascicolo.getDescDecreto()).substring(9);
	           lettPersTo.setTextContenuto( oggetto);//oggetto
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	          
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_8);
	           testiPersId.setNumeRiga("1");
	           lettPersTo.setId(testiPersId);
	           String testo0="             "+testiLettere[13];
    	        String testo=null;
    	        String testo1=null;
    	        	//testo=testo0.replace("codesto", "questo");
    	        	testo=testo0;
//    	        if(arrayFascicoli.length==1){		    	        
    	        testo1=testo.replace("nei fascicoli", "nel fascicolo");
//    	        }else{
//    	        	testo1=testo;
//    	        }
	           lettPersTo.setTextContenuto( testo1);//corpo
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           

	           /***NOTE***/
	           lettPersTo=new LettereTestiPersTO();
	           testiPersId=new LettereTestiPersTOId();
	           //testiPersId.setFkNumeIdFascicolo(fascicolo.getId().toString());
	           testiPersId.setCodiTipoLettera(Constants.CODI_TIPO_LETTERA_PREREGISTRAZIONE);
	           testiPersId.setCodiSezione(Constants.SEZIONE_9);
	           testiPersId.setNumeRiga("1");
	           lettPersTo.setId(testiPersId);
	           String note=testiLettere[14];
	           lettPersTo.setTextContenuto( note);//note
	           lettPersTo.setFascicoli(fascicolo);
	          //context.valorizeAudit(lettPersTo, NomeFunzioneConstants.PRED_LETTERE_PRE_REG);
	           lettPersToList.add(lettPersTo);
	           /***fine NOTE***/
	           
	           
	           return lettPersToList;
		}
		
		
		
	
}

