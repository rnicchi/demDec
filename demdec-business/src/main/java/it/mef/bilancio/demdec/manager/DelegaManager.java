package it.mef.bilancio.demdec.manager;

import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTOId;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface DelegaManager extends AbstractDemManager {
	
//	Map<Integer, String> findDeleganti(String tipoFirma) throws Throwable;
	List<UtenteProfiloTO> findDeleganti(String tipoFirma) throws Throwable;
	Map<Integer, String> findDelegati(String tipoFirma) throws Throwable;
	void saveDelega(UtenteProfiloTO utenteProfilo,Short croTransTo) throws Throwable;
	Map<Integer, String> findDelegatiAttivi() throws Throwable;
	List<UtenteProfiloTO> findDelegheByIdUtente(int utenteId) throws Throwable;
	List<UtenteProfiloTO> findAllDeleghe() throws Throwable;
	void deleteDelega(UtenteProfiloTOId delega) throws Throwable;
	List<UtenteProfiloTO> findByUtenteProfiloFlagDelega(int idUtente, int idProfilo, int flagDelega01) throws Throwable;
	List<UtenteProfiloTO> findByProfiloUfficioFlagDelega(BigDecimal sequIdProfilo, String idUfficio, int flagDelega01) throws Throwable;

}
