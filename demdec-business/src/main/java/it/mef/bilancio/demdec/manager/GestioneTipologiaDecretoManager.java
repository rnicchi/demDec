package it.mef.bilancio.demdec.manager;

import it.mef.bilancio.demdec.to.AnagModelliIterTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;

import java.util.List;

public interface GestioneTipologiaDecretoManager extends AbstractDemManager {

	List<AnagTipologiaDecretoTO> elencoTipologiaDecreto() throws Throwable;
	List<AnagTipoDecretoTO> elencoTipoDecreto() throws Throwable;
	List<AnagModelliIterTO> elencoModelliIter() throws Throwable;
	boolean creaDecretoTipologia(AnagTipologiaDecretoTO to) throws Throwable;
	boolean eliminaDecretoTipologia(Integer to) throws Throwable;
	void modificaDecretoTipologia(AnagTipologiaDecretoTO anagTipologiaDecretoTO) throws Throwable;
	List<AnagTipologiaDecretoTO> loadTipologieDecretoByIter(short idIter) throws Throwable;
}
