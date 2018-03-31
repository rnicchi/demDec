/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.DocumentiRaccoltaProvvisorieForm;
import it.mef.bilancio.demdec.web.spring.form.RicercaRedForm;

/**
 * @author utente
 *
 */
public class RicercaRedValidator extends AbstractDemValidator {

	public boolean ricercaRed(Context context) throws Throwable {
		
		RicercaRedForm form = (RicercaRedForm)context.getForm();
//		boolean res=true;
		
//		String annoEsercizio=form.getAnnoEse();
//		String protocolloRed=form.getProtocolloRed();
//		String amministrazione=form.getAmministrazione();
		String dataRedDa=form.getDataRedDa();
		String dataRedA=form.getDataRedA();
		String dataArrivoDa=form.getDataArrivoDa();
		String dataArrivoA=form.getDataArrivoA();
		
		
		if(	!dataRedDa.equals("")){
			checkDate(context, dataRedDa, "label.dataRedDa");
		}
		if(	!dataRedA.equals("")){
			checkDate(context, dataRedA, "label.dataRedA");
		}
		if(dataArrivoDa!=null &&	!dataArrivoDa.equals("")){
			checkDate(context, dataArrivoDa, "label.dataArrivoDa");
		}
		if(dataArrivoA!=null &&	!dataArrivoA.equals("")){
			checkDate(context, dataArrivoA, "label.dataArrivoA");
		}
		
		return  !context.hasErrors();
	}
	
	
	public boolean inviaAFad(Context context) throws Throwable {
		RicercaRedForm form= (RicercaRedForm) context.getForm();
		
		
/*		String [] checkboxes=form.getSelezioniDocumentiFasc();
		
		if(checkboxes!=null && checkboxes.length==0){
			context.addError("error.selection.doc");
		}
		
		
//		String  tipoAllegato=null;
		if(checkboxes!=null) {
			for (int i = 0; i < checkboxes.length; i++) {
				if (StringUtil.isEmpty(form.getDocumentiRaccoltaProvvisorieList().get(Integer.parseInt(checkboxes[i])).getTipoAllegati())){
					context.addError( "error.selection.tipoAllegato");
				}*/
/*				    tipoAllegato=context.getRequest().getParameter("tipoAllegati"+checkboxes[i]);			
					if (tipoAllegato==null || tipoAllegato.equals("")){
						//context.addError("error.generic", "Per gli elementi selezionati il tipo allegato deve essere valorizzato");	
						context.addError( "error.selection.tipoAllegato");	
						break;				
					}			*/
/*			}
		}*/
		
		boolean selezionati = false;
		
		for (DocumentiRaccoltaProvvisorieForm riga: form.getDocumentiRaccoltaProvvisorieList()){
			if (!StringUtil.isEmpty(riga.getSelezioniDocumentiFasc())){
				selezionati=true;
				if (StringUtil.isEmpty(riga.getTipoAllegati())){
					context.addError( "error.selection.tipoAllegato");
				}
			} else if (!StringUtil.isEmpty(riga.getTipoAllegati())){
				context.addError( "error.selection.tipoAllegato");
			}
		}

		if (!selezionati){
			context.addError("error.selection.doc");
		}
		checkEmpty(context, form.getTipoFlusso(), "label.raccolteProvvisorie.tipo", "error.campo.valorizzato");
		
/*		if (checkEmpty(context, form.getTipoFlusso(), "label.raccolteProvvisorie.tipo", "error.campo.valorizzato")){
			checkNumeric(context, form.getTipoFlusso(), "label.raccolteProvvisorie.tipo");
		}*/
		if (checkEmpty(context, form.getNumero(), "label.numero", "error.campo.valorizzato")){
			checkNumeric(context, form.getNumero(), "label.numero");
		}

		if (checkEmpty(context, form.getAnnoEse(), "label.anno", "error.campo.valorizzato")){
			checkNumeric(context, form.getAnnoEse(), "label.anno");
		}
		
/*		String tipo=form.getTipoFlusso();
		String numero=form.getNumero();
		String annoEse=form.getAnnoEse();
		Integer anno2=null;
		   Integer numero2=null;
		   Integer tipo2=null;		   
		   if(tipo==null || tipo.equals("")){
			   tipo2=null;
		   }
		   if(annoEse==null || annoEse.equals("")){
			   anno2=null;
		   }
		   if(numero==null || numero.equals("")){
			   numero2=null;
		   }		   
		   try{
			   anno2=new Integer(annoEse);
			  
		   }catch (NumberFormatException exc){			   
		   }
		   try{
			   numero2=new Integer(numero);
		   }catch (NumberFormatException exc){			   
		   }
		   try{
			   tipo2=new Integer(tipo);
		   }catch (NumberFormatException exc){			   
		   }*/
		   
/*		AnagTipoDecretoTO tipoDecreto=null;
		if(   StringUtil.isEmpty(tipo)   ||  StringUtil.isEmpty(numero) || StringUtil.isEmpty(annoEse) ) {			
			context.addError( "error.inviaAFad.invalid");
		} else { 
			 List<FascicoliViewTO> fascicoli=ricercaRedManager.findFascicoloByTipoNumAnnoStato(anno2, tipo2, numero2);
				//fascicoli
			 if(fascicoli==null || fascicoli.size()==0){
				 	fascicoli=ricercaRedManager.findFascicoloByTipoNumAnno(anno2, tipo2, numero2);
				 	if(fascicoli==null || fascicoli.size()==0){
				 		context.addError("error.inviaAFad.inexistent");
				 	}else{
				 		tipoDecreto=ricercaRedManager.getTipoDecretoById(tipo2);
				 		context.addError("error.stato.invioFad", tipoDecreto.getDescSigla()+" n."+numero2+" del "+anno2);
				 	}
			 }
		} 
		
		if(context.hasErrors()){
		 	//String [] selezioniDocumentiFascicolo=form.getSelezioniDocumentiFasc();
			List<DocumentTO> listDocTO=context.getModel(SessionAttributes.LIST_DOCUMENTI_FASCICOLO);
			int indexSeparator=0;
			String tipoDoc=null;
			String descrDoc=null;
			CodeDescriptionTO codDesTo=null;
			for (int i = 0; i < listDocTO.size(); i++) {
			    //qui recupero il tipo di allegato scelto nella combo box della riga selezionata nella tabella dei documenti
				tipoAllegato=context.getRequest().getParameter("tipoAllegati"+listDocTO.get(i).getIdDocumentoRaccoltaProvvisoria());
				indexSeparator=tipoAllegato.indexOf("-");
				if(indexSeparator>-1){
					tipoDoc=tipoAllegato.substring(0,indexSeparator);
					descrDoc=tipoAllegato.substring(indexSeparator+1);
					codDesTo=new CodeDescriptionTO();
					codDesTo.setCode(tipoDoc);
					codDesTo.setDescription(descrDoc);
					listDocTO.get(i).setDescDocumento(codDesTo);	
				}
			}
			
			if( listDocTO.size()>0) {
		    	PaginatorUtil.addPaginator(listDocTO, SessionAttributes.LIST_DOCUMENTI_FASCICOLO, Paginator.PAGE_RANGE_15, context); 
			}else {
				  	PaginatorUtil.removePaginator(context, SessionAttributes.LIST_DOCUMENTI_FASCICOLO);
				  	ContextHelper.addWarning(context.getRequest(),"warning.noRecord.trovati");  
				  //	return raccolteProvvisorie;
			}
		}*/
		
//		
//		Enumeration enumer=context.getRequest().getParameterNames();
//		String nomePar=null;
//		while(enumer.hasMoreElements()){
//		 nomePar=(String)enumer.nextElement();
//		 System.out.println(nomePar);
//		}
//		
//		int indice=0;
//		String valCheckbox=context.getRequest().getParameter("selezioniDocumentiFasc"+indice);
//		String tipoAllegato=null;
//		while(valCheckbox!=null){
//			tipoAllegato=context.getRequest().getParameter("tipoAllegati"+valCheckbox);
//			if (tipoAllegato==null || tipoAllegato.equals("")){
//				//context.addError("error.generic", "Per gli elementi selezionati il tipo allegato deve essere valorizzato");	
//				context.addError( "error.selection.tipoAllegato");	
//				break;				
//			}	
//			indice++;
//			valCheckbox=context.getRequest().getParameter("selezioniDocumentiFasc"+indice);
//			
//		}
		
		return  !context.hasErrors();
	
	}
	
	@SuppressWarnings("unused")
	private void foo(){
	}
	@SuppressWarnings("unused")
	private void foo2(){
	}
	@SuppressWarnings("unused")
	private void foo3(){
	}
	@SuppressWarnings("unused")
	private void foo4(){
	}
	@SuppressWarnings("unused")
	private void foo5(){
	}
	@SuppressWarnings("unused")
	private void foo6(){
	}
	
	
	public boolean onCaricaAmministrazioni(Context context) throws Throwable {
		RicercaRedForm form= (RicercaRedForm) context.getForm();
		String annoEse=form.getAnnoEse();
		if(annoEse==null || annoEse.equalsIgnoreCase("") ){
			context.addError( "error.annoNull");	
		}
		
		return  !context.hasErrors();
	}
	
	
}
