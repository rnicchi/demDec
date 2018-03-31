package it.almavivaitalia.web.sh.validator;


import static it.almavivaitalia.bsn.sh.utils.ParseUtil.getBigDecimal;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import static it.almavivaitalia.bsn.sh.utils.ValidationUtil.isMinorThenZero;
import static it.almavivaitalia.bsn.sh.utils.ValidationUtil.isNumber;
import static it.almavivaitalia.bsn.sh.utils.ValidationUtil.isValidImporto;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.Util;

import java.math.BigDecimal;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractValidator extends AbstractParentValidator implements BaseSessionAttributes{

//	private ResourceBundlegetMessageSource() getMessageSource();
//
//	public void setgetMessageSource()(ResourceBundlegetMessageSource() getMessageSource()) {
//		this.getMessageSource() = getMessageSource();
//	}

//	protected ResourceBundlegetMessageSource() getgetMessageSource()() {
//		return getMessageSource();
//	}
	/*public boolean onSubmit(Context context) throws Throwable{
		return true;
	}*/
	
	protected boolean checkFixedLength(Context context, String value, int length, String codeField) throws Throwable{
		boolean res=true;
		if (Util.blank(value).trim().length()!=length){
			context.addError("error.fixedLength", getMessageSource().getMessage(codeField), ""+length);
			res=false;
		}
		return res; 
	}

	protected boolean checkMaxLength(
			Context context, 
			String value,
			int maxLength, 
			String codeField) throws Throwable {
		boolean res = true;
		if (Util.blank(value).trim().length() > maxLength) {
			context.addError("error.maxLength", getMessageSource().getMessage(codeField), "" + maxLength);
			res = false;
		}
		return res;
	}	
	protected boolean checkNumeric(Context context, String value, String codeField) throws Throwable{
		if (!isNumber(value)){
			context.addError("error.numberFormat", getMessageSource().getMessage(codeField));
			return false;
		}else{
			return true;
		} 
	}
	
	protected boolean checkMinorThenZero(Context context, String value, String codeField) throws Throwable{
		boolean res=true;
		if (isMinorThenZero(getBigDecimal(value))){
			context.addError("error.number.minor.then.zero", getMessageSource().getMessage(codeField));
			res=false;
		}
		return res; 
	}
	
	protected boolean checkEmpty(Context context, String value, String codeField) throws Throwable{
		boolean res=true;
		if (isEmpty(value)){
			try {
				context.addError("error.empty", getMessageSource().getMessage(codeField));
			} catch (Exception e) {
				e.printStackTrace();
			}
			res=false;
		}
		return res; 
	}	
	
	
	protected boolean checkEmpty(Context context, Object value, String codeField) throws Throwable{
		boolean res=true;
		if (isEmpty(value)){
			try {
				context.addError("error.objext.null", getMessageSource().getMessage(codeField));
			} catch (Exception e) {
				e.printStackTrace();
			}
			res=false;
		}
		return res; 
	}
	
	protected boolean checkEmpty(Context context, Object value, String codeField, String error) throws Throwable{
		boolean res=true;
		if (isEmpty(value)){
			try {
				context.addError(error, getMessageSource().getMessage(codeField));
			} catch (Exception e) {
				e.printStackTrace();
			}
			res=false;
		}
		return res; 
	}
	
	protected boolean checkEmpty(Context context, List<String> lista, String codeField) throws Throwable{
		boolean res=true;
		int elements=0;
		for (int i=0;i<lista.size();i++)
			if (isEmpty(lista.get(i))) elements++;
		if (elements==lista.size()){
			try {
				context.addError("error.objext.null", getMessageSource().getMessage(codeField));
				res=false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res; 
	}
	
	protected boolean checkImporto(Context context, String string, String codeField, int numeroCifre) throws Throwable{
		boolean res=true;
		
		try{
			BigDecimal importo = getBigDecimal(string);
			res=isValidImporto(importo, numeroCifre);
			if(!res){
				context.addError("error.importo.over", getMessageSource().getMessage(codeField));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return res; 
	}
	/**
	 * 
	 * @param context
	 * @param value, Valore da testare
	 * @param numeroCifre, Max numero cifre
	 * @param codeError, Codice errore
	 * @param args, eventuali codici da aggiungere al messaggio
	 * @return
	 * @throws Throwable
	 */
	protected boolean checkImporto(
									Context context, 
									String value,
									String numeroCifre,
									String codeError, 
									String ... args
									) throws Throwable{
			
		boolean res=isValidImporto(value,numeroCifre);
		
		if(!res){				
			if(!isEmpty(args)){
				int x=0;
				for(String arg:args){
					args[x++]=getMessageSource().getMessage(arg);
				}
			}
			context.addError(codeError, args);
		}
		
		return res; 
	}	
	
	/*protected <T extends AbstractForm> boolean checkRequired(Context context, List<String> fieldNames, HashMap<String, String> codeFields, T form) throws Throwable{
		boolean res=true;
		return res; 
	}*/
	
	/**
	 * 
	 * @param context
	 * @param value, Valore da testare
	 * @param numeroCifre, Max numero cifre
	 * @param codeError, Codice errore
	 * @param args, eventuali codici da aggiungere al messaggio
	 * @return
	 * @throws Throwable
	 */
	protected boolean checkImporto(
									Context context, 
									String value,
									int nCitreInt,
									int nCifreDec,
									String codeError, 
									String ... args
									) throws Throwable{
			
		boolean res=true;
		if (!isEmpty(value)){
			Pattern p = Pattern.compile("^[-,+]?((([1-9]\\d{0,2})(\\.?\\d{3})*)|0)(,\\d{1,2})?$");
			Matcher m = p.matcher(value);
			res = m.matches();
			StringTokenizer token = new StringTokenizer(value, ",");
			res = res && nCitreInt>=token.nextToken().replace(".", "").trim().length();
			if (token.hasMoreTokens()){
				res = res&&nCifreDec==token.nextToken().trim().length();
			}
		}

		
		if(!res){				
			if(!isEmpty(args)){
				int x=0;
				for(String arg:args){
					args[x++]=getMessageSource().getMessage(arg);
				}
			}
			context.addError(codeError, args);
		}
		
		return res; 
	}	
	
	/**
	 * Da utilizzare nel caso in cui nella jsp ci siano le chackbox per verificare se almeno un elemento � stato selezionato 
	 * @param context
	 * @param array
	 * @param codeField
	 * @param error
	 * @return true nel caso in cui lo String[] in ingresso non sia vuoto altrimenti false
	 * @throws Throwable
	 */
	protected boolean checkEmpty(Context context, String[] array, String codeField, String error) throws Throwable{
		boolean res=true;
		int elements=0;
		for (int i=0;i<array.length;i++)
			if (isEmpty(array[i])) elements++;
		if (elements==array.length){
			try {
				if(error != null && error != ""){
					context.addError("error.selection.null", error);
				}else{
					context.addError("error.objext.null", getMessageSource().getMessage(codeField));
				}
				res=false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res; 
	}
	
	protected boolean checkCampoValorizzato(Context context, String value, String codeField) throws Throwable{
		boolean res=true;
		if (isEmpty(value)){
			try {
				context.addError("error.campo.valorizzato", getMessageSource().getMessage(codeField));
			} catch (Exception e) {
				e.printStackTrace();
			}
			res=false;
		}
		return res; 
	}	
	
	protected boolean checkEmailValida(Context context, String value, String codeField) throws Throwable{
		boolean correct=true;
		
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		if (!value.matches(emailPattern)) { 

			context.addError("error.formato.email", getMessageSource().getMessage(codeField));
			
			correct=false;
		}
		
			
		return correct; 
	}
	
	
	
	
}
