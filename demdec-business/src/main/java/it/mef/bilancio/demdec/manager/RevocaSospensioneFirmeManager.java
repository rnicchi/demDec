package it.mef.bilancio.demdec.manager;

import it.almavivaitalia.bsn.sh.manager.AbstractManager;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;

public interface RevocaSospensioneFirmeManager extends AbstractManager {

	public IterFirmaDecretoTO aggiornaStati(Long numeIdFascicolo, String utente, String funzione) throws Throwable;
//	public void aggiornaStatoIterFirmaDecreto(Integer numeIdFascicolo, String utente, String funzione) throws Throwable;
	public FascicoliTO findFascicoloByAnnoTipoNum(Integer anno, Integer tipo, Integer numDec) throws Throwable;
	public EsitoTO riaperturaFascicolo(FascicoliTO src) throws Throwable;
	
}
