package it.mef.bilancio.demdec.web.spring.validator;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.getString;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.RielaborazioneFascicoloForm;

public class RielaborazioneFascicoloValidator extends AbstractDemValidator{
	
	public boolean onEseguiRielaborazione(Context context) throws Throwable {
		
		RielaborazioneFascicoloForm form = (RielaborazioneFascicoloForm) context.getForm();
		//checkEmpty(context, getString(form.getIdFascicolo()),"label.rielabFascicolo.numDecreto" );
		checkEmpty(context, getString(form.getTipoElab()),"label.rielabFascicolo.tipoElaborazione" );
		
		checkEmpty(context, getString(form.getTipoDecreto()),"label.decreto.tipo" );
		checkEmpty(context, getString(form.getNumDecreto()),"label.decreto.numero" );
		checkNumeric(context,getString(form.getNumDecreto()),"label.decreto.numero" );
		checkEmpty(context, getString(form.getAnnoDecreto()),"label.decreto.anno" );
		
		
		if(form.getTipoElab().equals("4")){
			checkEmpty(context, getString(form.getTipoDecretoArrivo()),"label.rielabFascicolo.tipoDecretoArrivo" );
			checkEmpty(context, getString(form.getNumDecretoArrivo()),"label.rielabFascicolo.numDecretoArrivo" );
			checkNumeric(context,getString(form.getNumDecretoArrivo()),"label.rielabFascicolo.numDecretoArrivo" );
			checkEmpty(context, getString(form.getAnnoDecretoArrivo()),"label.rielabFascicolo.annoDecretoArrivo" );
		}
		
		return !context.hasErrors();	
	}
	
	public boolean onLoadListaDecreti(Context context) throws Throwable {
		
//		RielaborazioneFascicoloForm form = (RielaborazioneFascicoloForm) context.getForm();
//		checkEmpty(context, getString(form.getAnnoDecreto()),"label.decreto.anno" );
		return !context.hasErrors();
	}

}
