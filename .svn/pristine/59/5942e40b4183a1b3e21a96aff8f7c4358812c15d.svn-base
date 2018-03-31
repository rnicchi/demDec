package it.mef.bilancio.demdec.manager;

import java.util.List;

import it.almavivaitalia.bilancio.commons.to.ActionTO;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.mef.bilancio.demdec.to.ManagerResponseTO;

public interface GestioneProfiliManager extends AbstractDemManager {
	
	//metodi effettivamente utilizzati
	List<ProfiloTO> caricaTuttiProfili() throws Throwable;
	List<ProfiloTO> caricaTuttiProfiliOrdByCodiProf() throws Throwable; 
	ActionTO findActionById(String idAssociato) throws Throwable;
	public ManagerResponseTO<ProfiloTO> creaNuovoProfilo(ProfiloTO profiloTo) throws Throwable ;
	ManagerResponseTO<ProfiloTO> caricaProfiloByIdSelezionato(String selectedProfilo) throws Throwable;
	void deleteProfiloAssociatoByID(String codiProfilo) throws Throwable;
	void salvaAssociazioniActionProfilo(String idActionAssociato, String codiProfilo) throws Throwable;
	ManagerResponseTO<UtenteProfiloTO> findUtenteProfiloByProfiloId(String idProfilo) throws Throwable;
	ProfiloTO loadProfiloByIdProfilo(String idProfilo) throws Throwable;
	ManagerResponseTO<ProfiloTO> eliminaProfilo(String selectedCodiProfilo);
	
	//metodi da usare all'occorrenza
	ManagerResponseTO<ProfiloTO> creaProfilo(ProfiloTO profiloTo) throws Throwable;
	//ProfiloTO salvaProfilo(ProfiloTO profiloTo) throws Throwable;
	ManagerResponseTO<ProfiloTO> caricaProfiloByCodiceProfilo(String codiceProfilo) throws Throwable;
	ManagerResponseTO<ProfiloTO> salvaProfilo(ProfiloTO profiloTo) throws Throwable;
	ProfiloTO loadProfiloByCodiceProfilo(String codiceProfilo) throws Throwable;
	void deleteProfiloByID(String codiProfilo) throws Throwable;
	
	

}
