package it.mef.bilancio.demdec.manager;

import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;
import it.mef.bilancio.demdec.to.AnagModelliIterTO;
import it.mef.bilancio.demdec.to.IterFirmaTO;

import java.util.List;

public interface GestioneWorkflowFirmeManager extends AbstractDemManager {

	//inserimento nuovo Modello Iter
	List<AnagModelliIterTO> elencoModelliIter() throws Throwable;
	List<IterFirmaTO> elencoFirmatariPerModelloIter(String modelloIter) throws Throwable;
	List<AnagFirmatariTO> elencoAnagraficaFirmatari() throws Throwable;
	short creaModelloIter(AnagModelliIterTO anagModelliIterTO) throws Throwable;
	void creaIterFirma(IterFirmaTO iterFirmaTO) throws Throwable;
	AnagModelliIterTO loadAnagModelliIter(short id) throws Throwable;
	AnagFirmatariTO loadAnagFirmatari(String codiceFirmatario) throws Throwable;

	//cancellazione Modello Iter
	byte eliminaModelloIter(String idIter) throws Throwable;

	//modifica Modello Iter
	boolean esisteIterInviatoAFirme(String modelloIter) throws Throwable;
	void salvaModelloIter(AnagModelliIterTO anagModelliIterTO) throws Throwable;
	byte eliminaIterFirma(String idIter, String numeroOrdine) throws Throwable;

	//salva numero d'ordine
	void salvaOrdineFirmatari(String modelloIter, List<? extends AbstractDemTO> listaIterFirme) throws Throwable;
}
