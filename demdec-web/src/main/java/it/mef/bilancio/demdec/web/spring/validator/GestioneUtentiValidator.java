/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.validator;

import java.util.List;
import java.util.Map;

import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.*;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.form.GestioneUtentiForm;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;


public class GestioneUtentiValidator extends AbstractDemValidator {

	public boolean onCreaUtente(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		//String codiceFiscale = form.getCodiCodiceFiscale();

		checkEmpty(context, form.getCodiUtente(), "label.oam");
		checkEmpty(context, form.getPersCognome(), "label.persCognome");
		checkEmpty(context, form.getPersNome(), "label.persNome");
		
	/*	if (codiceFiscale!=null && !codiceFiscale.equals(""))
			checkFixedLength(context, codiceFiscale, 16, "label.codice.fiscale");
	*/
		//List<UtenteProfiloTO> listaUtProf = context.getModel(WebConstants.LIST_PROF_UFF_AMM);
//		if (listaUtProf == null || listaUtProf.size() == 0)
//			context.addError("errore.profilo.utente.mancante");
		
		if(!isEmpty(form.getIndiEmail())) {
			checkEmailValida(context, form.getIndiEmail(), "label.indiEmail");
		}

		return !context.hasErrors();
	}

	public boolean onGestioneModificaUtente(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();

		if(isEmpty(form.getSelectedCodiUtente()))
			context.addError("errore.utente.null");

		return !context.hasErrors();
	}

	public boolean onModificaUtente(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
	//	String codiceFiscale = form.getCodiCodiceFiscale();

	/*	if (codiceFiscale!=null && !codiceFiscale.equals(""))
			checkFixedLength(context, codiceFiscale, 16, "label.codice.fiscale");
	*/
		List<UtenteProfiloTO> listaUtProf = context.getModel(WebConstants.LIST_PROF_UFF_AMM);
		// � obbligatorio selezionare il profilo principale, se c'� almno un profilo aggiunto
		if(listaUtProf!=null && listaUtProf.size()>0 && form.getRadioButtonProfili()==null) {
			context.addError("errore.profilo.principale.mancante");
		}
		
		if(!isEmpty(form.getIndiEmail())){
			checkEmailValida(context, form.getIndiEmail(), "label.indiEmail");
		}

		return !context.hasErrors();
	}

	public boolean onEliminaUtente(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();

		if(isEmpty(form.getSelectedCodiUtente()))
			context.addError("errore.utente.null");

		return !context.hasErrors();
	}

	public boolean onConfermaProfilo(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		Map<String,Integer> mapProfiliFirmatari=context.getModel(SessionAttributes.LIST_PROFILI_FIRMATARI);
		String profilo=null;
		if(form.getProfilo()!=null && form.getProfilo().length()>0){
			profilo=form.getProfilo().substring(0,1);
		}
		
		checkEmpty(context, form.getProfilo(), "label.profilo");
	
		checkEmpty(context, form.getCodiUtente(), "label.oam");
		checkEmpty(context, form.getPersCognome(), "label.persCognome");
		checkEmpty(context, form.getPersNome(), "label.persNome");
		if(!isEmpty(form.getIndiEmail())){
			checkEmailValida(context, form.getIndiEmail(), "label.indiEmail");
		}
		
		if (!context.hasErrors()) checkDatiMancantiAlProfilo(context);
		if (!context.hasErrors()) checkCombinazioneDatiProfilo(context);
		if (!context.hasErrors()) checkValoriDatiProfilo(context);
		
		if(profilo!=null && mapProfiliFirmatari.get(profilo)!=null && isEmpty(form.getIndiEmail()) ){
			context.addError("errore.utente.profilo.email");
		}
		

		return !context.hasErrors();
	}
	
	
	public boolean onAssociaProfilo(Context context) throws Throwable {

		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		
//		if(form.getProfilo()!=null && form.getProfilo().length()>0){
//			profilo=form.getProfilo().substring(0,1);
//		}
		
	
		checkEmpty(context, form.getCodiUtente(), "label.oam");
		checkEmpty(context, form.getPersCognome(), "label.persCognome");
		checkEmpty(context, form.getPersNome(), "label.persNome");
		if(!isEmpty(form.getIndiEmail())){
			checkEmailValida(context, form.getIndiEmail(), "label.indiEmail");
		}
		
//		if (!context.hasErrors()) checkDatiMancantiAlProfilo(context);
//		if (!context.hasErrors()) checkCombinazioneDatiProfilo(context);
//		if (!context.hasErrors()) checkValoriDatiProfilo(context);
		
		return !context.hasErrors();
	}
	

	private boolean checkDatiMancantiAlProfilo(Context context) throws Throwable {

		boolean empty = false;
		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		String idProfiloSelected = form.getProfilo().split("-")[0];
		switch (Integer.parseInt(idProfiloSelected)) {
			
			case  8:			//Ministro
			case 10:			//Ministro Proponente
				//abilitare solo Amministrazione
				//empty = checkEmpty(context, form.getAmministrazione(), "label.raccolteProvvisorie.amministrazione");
				empty = checkCampoValorizzato(context, form.getAmministrazione(), "label.raccolteProvvisorie.amministrazione");
				break;
			
			case  2:			//Dirigente Ufficio
			case  3:			//Coordinamento Bilancisti
			case  9:			//Bilancista
				//abilitare solo Ufficio
				//empty = checkEmpty(context, form.getUfficio(), "label.ufficio");
				empty = checkCampoValorizzato(context, form.getUfficio(), "label.ufficio");
				break;
			case  1:			//Direttore
			case  5:			//Ispettore Generale
			case  6:			//Segreteria Ragioniere
			case  7:			//Ragioniere Generale 
				//disabilitare tutto
				break;
		}

		return empty;
	}

	private boolean checkCombinazioneDatiProfilo(Context context) throws Throwable {

		boolean wrongCombination = false;
		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		String message = "";
		String idProfiloSelected = form.getProfilo().split("-")[0];
		switch (Integer.parseInt(idProfiloSelected)) {

			
			case  8:			//Ministro
			case 10:			//Ministro Proponente
				//abilitare solo Amministrazione
				wrongCombination = !isEmpty(form.getUfficio()) || isEmpty(form.getAmministrazione());
				message = "errore.utente.profilo.ammin.only";
				break;
			
			case  2:			//Dirigente Ufficio
			case  3:			//Coordinamento Bilancisti
			case  9:			//Bilancista
				//abilitare solo Ufficio
				wrongCombination = isEmpty(form.getUfficio()) || !isEmpty(form.getAmministrazione());
				message = "errore.utente.profilo.ufficio.only";
				break;
			case  1:			//Direttore
			case  5:			//Ispettore Generale
			case  6:			//Segreteria Ragioniere
			case  7:			//Ragioniere Generale 
				//disabilitare tutto
				wrongCombination = !isEmpty(form.getUfficio()) || !isEmpty(form.getAmministrazione());
				message = "errore.utente.profilo.nothing";
				break;
		}
		if (wrongCombination)
			context.addError(message);
		return wrongCombination;
	}

	private boolean checkValoriDatiProfilo(Context context) throws Throwable {

		boolean wrongValue = false;
		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		String message = "";
		String idProfiloSelected = form.getProfilo().split("-")[0];
		switch (Integer.parseInt(idProfiloSelected)) {

			case  3:			//Coordinamento Bilancisti
				//solo Ufficio I
				wrongValue = isEmpty(form.getUfficio()) || !form.getUfficio().split("-")[0].equals("1");
				message = "errore.utente.profilo.ufficio.coorBilancisti";
				break;
			case  8:			//Ministro
				//solo MINISTERO DELL'ECONOMIA E DELLE FINANZE
				
				String annoEse;
				
				String controlloAmm = form.getAmministrazione().substring(4, 10);
				
			//	for(int i=2014; i<2030;i++)
				//{
				//	annoEse = ""+i;
					
					wrongValue = //isEmpty(form.getAnnoEse()) || !form.getAnnoEse().equals("2014") ||
							isEmpty(form.getAmministrazione()) ||
							!form.getAmministrazione().contains(controlloAmm);// startsWith(controlloAmm)
							;							
						//	!form.getAmministrazione().startsWith("02-0-")
							//!form.getAmministrazione().startsWith(annoEse+"-02-0-")	//annoEse = 2014; STP=2; APP=0
						//	;
					//message = "errore.utente.profilo.ufficio.ministro";
					
				//	if(wrongValue == false)
			//		{
			//			break;
				//	}
					
			//	}
				
				
				
				/*wrongValue = //isEmpty(form.getAnnoEse()) || !form.getAnnoEse().equals("2014") ||
						isEmpty(form.getAmministrazione()) ||
						!form.getAmministrazione().startsWith("2014-02-0-")	//annoEse = 2014; STP=2; APP=0
						;
				*/
					
				message = "errore.utente.profilo.ufficio.ministro";
				break;
			case 10:			//Ministro Proponente
				//eccetto MINISTERO DELL'ECONOMIA E DELLE FINANZE
				
				
				//String annoEser;
				
			//	for(int i=2014; i<2030;i++)
			//	{
				//	annoEser = ""+i;
				
				String controlloAmmin = "-02-0-";
					
					wrongValue = 
							isEmpty(form.getAmministrazione()) ||
							form.getAmministrazione().contains(controlloAmmin);//
							;
							
						//	form.getAmministrazione().startsWith("02-0-")	//annoEser = 2014; STP=2; APP=0
							//form.getAmministrazione().startsWith(annoEser+"-02-0-")	//annoEser = 2014; STP=2; APP=0
					//		;
					
				//	if(wrongValue == true)
					//{
				//		break;
				//	}
					
				//}
								
				/*
				wrongValue = //isEmpty(form.getAnnoEse()) || !form.getAnnoEse().equals("2014") ||
						isEmpty(form.getAmministrazione()) ||
						form.getAmministrazione().startsWith("2014-02-0-")	//annoEse = 2014; STP=2; APP=0
						;
				*/
				message = "errore.utente.profilo.ufficio.ministro.proponente";
			
				break;
			case  1:			//Direttore
			case  2:			//Dirigente Ufficio
			case  5:			//Ispettore Generale
			case  6:			//Segreteria Ragioniere
			case  7:			//Ragioniere Generale 
			case  9:			//Bilancista
		}
		if (wrongValue)
			context.addError(message);
		return wrongValue;
	}
		
}
