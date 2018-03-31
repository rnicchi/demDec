/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.controller.raccolteprovvisorie;

import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.RicercaRedSospesiManager;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.SospesiRedTO;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Pietro
 *
 */
//@RequestMapping(value = ConstantsRequestMapping.RICERCA_SOSPESI_RED)
public abstract class ChiusuraRaccolteSospeseRedLiv2Controller extends AssociazioneAFadController implements WebConstants, SessionAttributes{

	@Autowired
	private RicercaRedSospesiManager ricercaRedSospesiManager;
	@Autowired
	private ListManager listManager;
	
	
	
	public RicercaRedSospesiManager getRicercaRedSospesiManager() {
		return ricercaRedSospesiManager;
	}

	public ListManager getListManager() {
		return listManager;
	}

	//metodo per suddividere la lista di Raccolte Provvisorie proveniente da WS in due liste: 
	//	1) Raccolte da valutare per una evntuale sospensione;
	//	2) Raccolte precedentemente valutate e inserite nel DB per la successiva elaborazione
	protected void differenziaRaccolteProvvDaWS(List<? extends AbstractDemTO> listaRaccoltaTO, 
				List<AbstractDemTO> listaSuperiore,
				List<AbstractDemTO> listaInferiore
				) throws Throwable {
	
	
		List<SospesiRedTO> listaSospesiRed = (List<SospesiRedTO>) ricercaRedSospesiManager.getListaSospesiRed();
	
		Set<String> set = new HashSet<String>();
		for (SospesiRedTO sr: listaSospesiRed)
			set.add(sr.getId());
	
	
		for (AbstractDemTO raccoltaAbs: listaRaccoltaTO) {
			RaccoltaProvvisoriaRedTO raccolta = (RaccoltaProvvisoriaRedTO) raccoltaAbs; 
			if (set.contains(raccolta.getIdFascicoloRaccoltaProvvisoria()))
				listaInferiore.add(raccolta);
			else
				listaSuperiore.add(raccolta);
		}
	
	}

	protected List<AnagUfficiTO> getListaUfficiAssociatiRed(Context context) throws Throwable {
	
		List<AnagUfficiTO> listaUfficiAssociatiRed;
	
		Utente user = getUtenteInSessione();
		UtenteProfiloTO utProfTo = ((UtenteTO) ContextHelper.getModel(OBJECT_USER, context.getRequest()))
							.getUtenteProfilo(user.getProfiloInUso().getCodiProfilo());
	
		//		String idUfficio = utProfTo.getAnagUffici().getId();
		if(utProfTo.getAnagUffici()!=null){
			String idUfficio = utProfTo.getAnagUffici().getId();
	
			/** se l'ufficio di appartenenza è 1 o 2 carico nella combo tutti gli uffici, altrimenti solo l'ufficio di appartenenza**/
			switch (Integer.valueOf(idUfficio)) {		
				case 1:
				case 2:
					listaUfficiAssociatiRed = listManager.loadAnagUffici();
					break;
				default:
					listaUfficiAssociatiRed = new ArrayList<AnagUfficiTO> ();
					AnagUfficiTO uffTo = new AnagUfficiTO();
					uffTo.setId(idUfficio);
					uffTo.setDescUfficio(utProfTo.getAnagUffici().getDescUfficio());
					listaUfficiAssociatiRed.add(uffTo);
			}
		} else {
			listaUfficiAssociatiRed = listManager.loadAnagUffici();
		}
	
		return listaUfficiAssociatiRed;
	}

	//metodo per filtrare i dati del Ws, escludendo quelli presenti su DB
	protected List<AbstractDemTO> getListaWsFiltered(List<AbstractDemTO> listaWS, List<SospesiRedTO> listaSospesiRed) throws Throwable {
	
		if (listaSospesiRed == null || listaSospesiRed.size()==0)
			return listaWS;
	
		List<AbstractDemTO> listaOut = new ArrayList<AbstractDemTO>();
	
		//lista id sospesi red
		List<String> listaIdSospesiRed = new ArrayList<String>();
		for (SospesiRedTO rs: listaSospesiRed)
			listaIdSospesiRed.add(rs.getId());
	
		for (AbstractDemTO to: listaWS)
			if (!listaIdSospesiRed.contains(((RaccoltaProvvisoriaRedTO)to).getIdFascicoloRaccoltaProvvisoria()))
					listaOut.add(to);
	
		return listaOut;
	}
	
	protected DocumentTO recuperaDocumentTo(List<DocumentTO> listaDocumenti, String idDocumento, String flagTipo){
		String idDoc=null;
		DocumentTO result=null;
		for (int i=0; i<listaDocumenti.size(); i++) {
			idDoc=flagTipo.equals("1")?((DocumentTO)listaDocumenti.get(i)).getIdDocumento():((DocumentTO)listaDocumenti.get(i)).getIdDocumentoRaccoltaProvvisoria();
			
			if (idDocumento.equals(idDoc)) {	
				result= (DocumentTO)listaDocumenti.get(i);
			    break;
			}
		}
		return result;
	}


}