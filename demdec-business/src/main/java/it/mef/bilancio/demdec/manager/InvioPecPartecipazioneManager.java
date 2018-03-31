package it.mef.bilancio.demdec.manager;

import java.math.BigDecimal;
import java.util.List;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.manager.AbstractManager;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.PartecipazioniTO;

public interface InvioPecPartecipazioneManager extends AbstractManager {

	List<PartecipazioniTO>  findByIdFascicolo(Integer idFascicolo ) throws Throwable;
	

	List<String> findDestinatariMailPec( BigDecimal idFascicolo) throws Throwable;


	DocumentiTO loadDocumentoByGuidFascicoloETipo(String codiGuidFascicolo, String string) throws Throwable;

	
}
