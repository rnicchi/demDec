package it.almavivaitalia.web.sh.validator;

import static it.almavivaitalia.bsn.sh.utils.DateUtil.isDate;
import static it.almavivaitalia.bsn.sh.utils.ValidationUtil.isValidImporto;
import java.util.HashMap;
import java.util.List;
import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.web.sh.form.AbstractForm;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
public abstract class AbstractParentValidator implements BaseSessionAttributes{
	
	private ResourceBundleMessageSource messageSource;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	/*END LOCM*/

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public boolean onSubmit(Context context) throws Throwable{
		return true;
	}	
	
	protected ResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}
	
	protected <T extends AbstractForm> boolean checkRequired(Context context, List<String> fieldNames, HashMap<String, String> codeFields, T form) throws Throwable{
		boolean res=true;
		return res; 
	}
	
	protected boolean checkDate(Context context, String value, String codeField) throws Throwable{
		boolean res=true;
		if (!isDate(value)){
			context.addError("error.dateFormat", getMessageSource().getMessage(codeField));
			res=false;
		}
		return res; 
	}

	protected boolean correctFormat(Context context, String value, String codeField, String nCifreInt, String nCifreDec) throws Throwable{
		boolean correct=true;
		if(!isValidImporto(value, nCifreInt, nCifreDec)){
			context.addError(
							"errors.number.format", getMessageSource().getMessage(codeField), 
							String.valueOf(Integer.parseInt(nCifreInt)+Integer.parseInt(nCifreDec)), 
							nCifreDec);
			correct=false;
		}		
		return correct; 
	}
	
}
