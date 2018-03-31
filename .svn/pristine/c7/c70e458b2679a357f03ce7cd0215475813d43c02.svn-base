package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.mef.bilancio.demdec.to.CampoFirmaTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.to.FirmatarioTO;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface InvioAlleFirmeDao extends AbstractDemDao {
	
	
	
	List<FascicoliViewTO> findListaDecretiByTipoNumAnnoUfficio(Integer anno, Integer tipo, Integer numDec, Integer ufficio ) throws Throwable;
	
	List<FirmatarioTO> findFirmatari(Long numeIdFascicolo) throws Throwable;

	List<CampoFirmaTO> findListFirme(Long numeIdFascicolo) throws Throwable;

	DocumentiBO loadDocumentoByGuidFascicoloETipo(String guidFascicolo, String tipoDocumento) throws Throwable;

	Integer insertIterFirmaDecreto(String idFascicolo, String utente, String funzione) throws Throwable;

	List<FascicoliViewTO> findSospFirmeListaDecretiByTipoNumAnno(Integer anno,Integer tipo, Integer numDec) throws Throwable;
	
	List<FascicoliViewTO> findRevSospFirmeListaDecretiByTipoNumAnno(Integer anno,Integer tipo, Integer numDec) throws Throwable;

}
