package it.mef.bilancio.demdec.manager;

import java.util.List;

import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.mef.bilancio.demdec.to.ManagerResponseTO;

public interface GestioneUtentiManager extends AbstractDemManager {
	ManagerResponseTO<UtenteTO> creaUtente(UtenteTO utenteTo) throws Throwable;
	ManagerResponseTO<UtenteTO> salvaUtente(UtenteTO utenteTo) throws Throwable;
	List<UtenteTO> caricaTuttiUtenti() throws Throwable;
	ManagerResponseTO<UtenteTO> eliminaUtente(String selectedCodiUtente);
	ManagerResponseTO<UtenteTO> caricaUtenteByCodiceUtente(String codiceUtente) throws Throwable;
}
