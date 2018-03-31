package it.almavivaitalia.bilancio.commons.manager;

import it.almavivaitalia.bilancio.commons.bo.AbstractCommonBO;
import it.almavivaitalia.bilancio.commons.bo.CroDatiBO;
import it.almavivaitalia.bilancio.commons.to.CronoValoriTO;

import java.util.List;
import java.util.Set;

public interface CronologicoManager extends AbstractCommonManager {
	public void salvaCronologico(
			CroDatiBO croDatiBO,
			List<CronoValoriTO> listCronoValori,
			Short codiceTransazione,
			String nomeFunzione, 
			String codiUtente
	) throws Throwable;
	
	public void salvaCronologico(
			AbstractCommonBO vecchio,
			AbstractCommonBO nuovo,
			CroDatiBO croDatiBO,
			List<CronoValoriTO> listCronoValori,
			Short codiceTransazione,
			String nomeFunzione, 
			String codiUtente
	) throws Throwable;	
	
	public boolean addCronoValoriToList(
			Set<CronoValoriTO> listCronoValori,
			int codiCodice, 
			short numeOrdiVisu, 
			Object old, 
			Object _new,
			boolean checkEquality);
	
	public boolean addCronoValoriToList(
			Set<CronoValoriTO> listCronoValori,
			int codiCodice, 
			short numeOrdiVisu, 
			Object old, 
			Object _new,
			boolean checkEquality,
			boolean insert);
	
}
