package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.dao.AbstractCommonDao;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.to.CronologicoSearchTO;
import it.mef.bilancio.demdec.to.CronologicoTO;
import it.mef.bilancio.demdec.to.CronologicoTransExcelTO;
import it.mef.bilancio.demdec.to.CronologicoTransTO;
import it.mef.bilancio.demdec.to.CronologicoValoriTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public interface IntCronologicoDao extends AbstractCommonDao {	
	List<CodeDescriptionTO> loadUtente() throws Throwable;
	List<CronologicoSearchTO> loadApplication() throws Throwable;
	List<CronologicoSearchTO> loadCategoria(Integer idAppl) throws Throwable;
	List<CronologicoSearchTO> loadFunzione(Integer idAppl,Integer idCat) throws Throwable;
	List<CronologicoTO> loadCapitoli (Short annoCap) throws Throwable;
	List<CronologicoTO> loadStrumento() throws Throwable;
	List<CronologicoTO> loadSottoStrumento() throws Throwable;
	List<CronologicoTransTO> caricaRisultati(CronologicoTO to,Date dataA,String oraDa,String oraA) throws Throwable;
	BigDecimal loadCodiId(String menu,String funzione) throws Throwable;	
	List<CronologicoValoriTO> loadValori (BigDecimal code,BigDecimal trans) throws Throwable;
	List<CronologicoTO> loadAutor () throws Throwable;
	List<CronologicoTransExcelTO> caricaExcel(CronologicoTO to,Date dataA,String oraDa,String oraA) throws Throwable;
}
