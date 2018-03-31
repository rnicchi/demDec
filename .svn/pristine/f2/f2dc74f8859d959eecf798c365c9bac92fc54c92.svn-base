package it.mef.bilancio.demdec.manager;

import it.almavivaitalia.bsn.sh.manager.AbstractManager;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.RicercaRedTO;
import it.mef.bilancio.demdec.to.SospesiRedTO;

import java.util.Collection;


public interface RicercaRedSospesiManager extends AbstractManager{

	ResponseDEMBILClient wsRicercaRed(ParametriInput paramInput, RicercaRedTO ricercaRedTO) throws Throwable;
	ResponseDEMBILClient wsDocumentiFascicolo(ParametriInput paramInput, RaccoltaProvvisoriaRedTO to) throws Throwable;

	void saveSospesiRed(Collection<SospesiRedTO> listaSospesiRed) throws Throwable;
	Collection<SospesiRedTO> getListaSospesiRed() throws Throwable;
	void deleteSospesiRed(Collection<String> listaIdSospesiRed) throws Throwable;
	
	ResponseDEMBILClient wsDownloadDocumento(ParametriInput paramInput, String idFascicolo, String idDocumento) throws Throwable;
}
