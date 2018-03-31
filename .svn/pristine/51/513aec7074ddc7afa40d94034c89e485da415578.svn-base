package it.mef.bilancio.demdec.web.spring.validator;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.getString;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.IntCronologicoForm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IntCronologicoValidator extends AbstractDemValidator{
	public boolean onSelectorCategoria (Context context) throws Throwable {
		IntCronologicoForm form = (IntCronologicoForm) context.getForm();
		checkEmpty(context, getString(form.getCodiApplicazione()),"label.cronologicoApplicazione" );
		return !context.hasErrors();	
	}
	public boolean onSelectorFunzione (Context context) throws Throwable {
		IntCronologicoForm form = (IntCronologicoForm) context.getForm();
		checkEmpty(context, getString(form.getCodiApplicazione()),"label.cronologicoApplicazione" );		
		checkEmpty(context, getString(form.getCodiCategoria()),"label.cronologicoCategoria" );
		return !context.hasErrors();	
	}
	public boolean onEseguiRicercaCrono(Context context) throws Throwable {
		IntCronologicoForm form = (IntCronologicoForm) context.getForm();
		checkEmpty(context, getString(form.getDataDa()),"label.cronologicoDataDaMsg" );
		if(!context.hasErrors()){
		  if (!form.getDataDa().isEmpty()){
			  checkDate(context, form.getDataDa(), "label.cronologicoDataDaMsg");
		  }		
		  if (!form.getDataA().isEmpty()){
 			  checkDate(context, form.getDataA(),  "label.cronologicoDataAMsg");	
		  }
		}
		// Controllo Data Da minore data A //
		if(!context.hasErrors()){
		  if (!(form.getDataDa().isEmpty())){	
			  if (!(form.getDataA().isEmpty())){
				 SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
				 Date dataDa =  fromUser.parse(form.getDataDa());
				 Date dataA  =  fromUser.parse(form.getDataA());
		           if ((dataDa.getTime()>dataA.getTime())){
				      context.addError("error.dataDaMaggDataA");
		           }		  
			  }
		  }
		}
		// Controllo Data Da minore data A //
		if(!context.hasErrors()){
		  if (!(form.getOraDa().isEmpty())){	
			  if (!(form.getOraA().isEmpty())){
				 SimpleDateFormat df1 = new SimpleDateFormat("HH:mm");
				 Date oraDa =  df1.parse(form.getOraDa());
				 Date oraA  =  df1.parse(form.getOraA());
	             if ((oraDa.getTime()>oraA.getTime())){
				     context.addError("error.oraDaMaggOraA");
				 }		  
			  }
		 }
		}		
		return !context.hasErrors();	
	}
}
