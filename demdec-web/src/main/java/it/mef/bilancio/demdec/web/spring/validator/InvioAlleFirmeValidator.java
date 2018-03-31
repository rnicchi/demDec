package it.mef.bilancio.demdec.web.spring.validator;

import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.InvioAlleFirmeForm;

public class InvioAlleFirmeValidator extends AbstractDemValidator{
	
	public boolean ricercaFirmatari(Context context) throws Throwable {
		
		InvioAlleFirmeForm form= (InvioAlleFirmeForm) context.getForm();
		
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
	
//	public boolean modaleInvioAFirme(Context context) throws Throwable {
//		InvioAlleFirmeForm form= (InvioAlleFirmeForm) context.getForm();
//		if(!StringUtil.isEmpty(form.getNumero())){
//			checkNumeric(context, form.getNumero(), "label.numeroDecreto");
//		}
//		return  !context.hasErrors();
//		
//	}
	

}
