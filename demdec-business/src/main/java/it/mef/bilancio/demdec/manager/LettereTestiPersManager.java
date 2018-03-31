package it.mef.bilancio.demdec.manager;

import it.mef.bilancio.demdec.to.LettereTestiPersTO;
import it.mef.bilancio.demdec.to.LettereTestiTO;

import java.math.BigDecimal;
import java.util.List;

public interface LettereTestiPersManager extends AbstractDemManager {

	List<LettereTestiPersTO> findTestoPersFasc(Long fkNumeIdFascicolo, String codiTipoLettera) throws Throwable;
	List<LettereTestiTO> findActualTestoFasc(Long fkNumeIdFascicolo, String codiTipoLettera, String codiSezione) throws Throwable;
	void salvaTestoPers(Long fkNumeIdFascicolo, String codiTipoLettera,
			String codiSezione, Short numeRiga, String textContenuto,
			String nomeFunzione, String user) throws Throwable;
	void rimuoviTestoPers(Long fkNumeIdFascicolo, String codiTipoLettera,
			String codiSezione, Short numeRiga) throws Throwable;
	List<LettereTestiPersTO> findTestoPersByIdLettera(Long fkSequIdLettera, String codiTipoLettera) throws Throwable;
	
	
}
