package it.mef.bilancio.demdec.manager;

import it.almavivaitalia.bsn.sh.manager.AbstractManager;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.to.InvioFadTO;
import it.mef.bilancio.demdec.to.RicercaRedTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;

import java.util.List;



public interface RicercaRedManager extends AbstractManager{
		
     List<FascicoliViewTO> findFascicoloByTipoNumAnnoStato(Integer anno, Integer tipo, Integer numDec) throws Throwable;
     List<FascicoliViewTO> findFascicoliAssociati(String guidDocumento) throws Throwable;
	 ResponseDEMBILClient wsRicercaRed(RicercaRedTO ricercaRedTO) throws Throwable;
	 ResponseDEMBILClient wsDownloadDocumento(String idFascicolo, String idDocumento) throws Throwable;
	 ResponseDEMBILClient wsDocumentiFascicolo(RaccoltaProvvisoriaRedTO to) throws Throwable;
	 ResponseDEMBILClient wsInvioFAD (InvioFadTO ifTo, SottoFascicoliRedTO sfRedTo, DocumentTO docTo) throws Throwable;
	 ResponseDEMBILClient wsCambioStatoFascicolo(InvioFadTO ifTo) throws Throwable;
	List<FascicoliViewTO> findFascicoloByTipoNumAnno(Integer anno, Integer tipo, Integer numero) throws Throwable;
	AnagTipoDecretoTO getTipoDecretoById(Integer tipo) throws Throwable;
	

}

