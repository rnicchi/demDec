package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.bo.LettereTestiPersBO;
import it.mef.bilancio.demdec.to.LettereTestiTO;

import java.math.BigDecimal;
import java.util.List;

public interface LettereTestiPersDao extends AbstractDemDao<LettereTestiPersBO>  {

	List<LettereTestiPersBO> findTestoPersFasc(Long fkNumeIdFascicolo, String codiTipoLettera) throws Throwable;

	List<LettereTestiTO> findActualTestoFasc(Long fkNumeIdFascicolo, String codiTipoLettera, String codiSezione) throws Throwable;

	List<LettereTestiPersBO> findTestoPersByIdLettera(Long fkSequIdLettera, String codiTipoLettera) throws Throwable;

	List<LettereTestiPersBO> findContenutiPersByIdLettera(String idLettera) throws Throwable;

//	List<LettereTestiTO> findContenutiLetteraByFascTipo(Long fkNumeIdFascicolo, String codiTipoLettera) throws Throwable;

}
