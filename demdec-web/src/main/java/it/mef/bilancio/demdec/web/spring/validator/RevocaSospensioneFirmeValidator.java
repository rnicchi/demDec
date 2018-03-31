package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.RevocaSospensioneFirmeForm;

public class RevocaSospensioneFirmeValidator extends AbstractDemValidator {

	public boolean revocaSospensioneFirme(Context context) throws Throwable {

		RevocaSospensioneFirmeForm form= (RevocaSospensioneFirmeForm) context.getForm();

		String tipo=form.getTipoFlusso();
		String numero=form.getNumero();
		String annoEse=form.getAnnoEse();

		if(   (tipo==null || tipo.trim().equalsIgnoreCase("")) ||  (numero==null || numero.trim().equalsIgnoreCase("")) 
				|| (annoEse==null || annoEse.trim().equalsIgnoreCase("")) ) {

			context.addError( "error.DecretoSospeso.required");
		} 

		if(!StringUtil.isEmpty(numero)){
			checkNumeric(context, numero, "label.numeroDecreto");
		}


		return  !context.hasErrors();
	}
	
	public boolean riapriFascicolo(Context context) throws Throwable {

		RevocaSospensioneFirmeForm form= (RevocaSospensioneFirmeForm) context.getForm();

		String tipo=form.getTipoFlusso();
		String numero=form.getNumero();
		String annoEse=form.getAnnoEse();

		if(   (tipo==null || tipo.trim().equalsIgnoreCase("")) ||  (numero==null || numero.trim().equalsIgnoreCase("")) 
				|| (annoEse==null || annoEse.trim().equalsIgnoreCase("")) ) {

			context.addError( "error.DecretoInFirma.required");
		} 

		if(!StringUtil.isEmpty(numero)){
			checkNumeric(context, numero, "label.numeroDecreto");
		}

		return  !context.hasErrors();
	}
	
	@SuppressWarnings("unused")
	private void foo(){
	}
	@SuppressWarnings("unused")
	private void foo2(){
	}

}
