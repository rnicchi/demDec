package it.mef.bilancio.demdec.web.spring.validator;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import static it.almavivaitalia.bsn.sh.utils.ValidationUtil.isIntegerNumber;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.validator.AbstractValidator;
import it.almavivaitalia.web.sh.validator.Validator;

import java.math.BigDecimal;
import java.util.List;



public abstract class AbstractDemValidator extends AbstractValidator implements Validator {

	protected boolean checkEmptyUserMessage(Context context, List<String> lista, String errorMessage) throws Throwable{
		//devono essere tutti valorizzati
		boolean res=true;
		int elements=0;
		for (int i=0;i<lista.size();i++)
			if (isEmpty(lista.get(i))) elements++;
		if (elements>0){
			try {
				context.addError(errorMessage);
				res=false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res; 
	}
	
	protected boolean checkOneEmptyUserMessage(Context context, List<String> lista, String errorMessage) throws Throwable{
		//almeno uno deve essere valorizzato
		boolean res=true;
		int elements=0;
		for (int i=0;i<lista.size();i++)
			if (isEmpty(lista.get(i))) elements++;
		if (elements==lista.size()){
			try {
				context.addError(errorMessage);
				res=false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res; 
	}


	protected boolean checkInteger(Context context, String value, String codeField) throws Throwable{
		if (!isIntegerNumber(value)){
			context.addError("error.numberFormat", getMessageSource().getMessage(codeField));
			return false;
		}else{
			return true;
		} 
	}

	protected boolean isImportoVuoto(BigDecimal importo){
		return importo==null||importo.equals(BigDecimal.ZERO);
	}
	/*
	 * verifica se il periodo "dal" "al" si incrocia con un'altro periodo 
	 */
	protected boolean isPeriodoNelRange(String dal, String al, String[] range){
		return (dal.compareTo(range[0]) >= 0 &&
				dal.compareTo(range[1]) <= 0)||
				(al.compareTo(range[0]) >= 0 &&
				al.compareTo(range[1]) <= 0);
	}
}
