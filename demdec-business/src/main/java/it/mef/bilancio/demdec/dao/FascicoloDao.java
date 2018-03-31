package it.mef.bilancio.demdec.dao;

import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.to.GestioneFadTO;
import it.mef.bilancio.demdec.to.RiepilogoDatiAnagTO;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.AnagTipoRiepilogoBO;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.RiepilogoDatiAnagBO;

public interface FascicoloDao extends AbstractDemDao<FascicoliBO>{

	FascicoliBO findFascicoloByAnnoTipoNum(Integer anno, Integer tipo, Integer numDec);
	List<FascicoliViewTO> findFascicoloByTipoNumAnnoStato(Integer anno, Integer tipo, Integer numDec);
	List<FascicoliBO> findFascicoliFad(FascicoliFadSearhTO to) throws Throwable;
	List<FascicoliBO> findFascicoliGestioneFad(FascicoliFadSearhTO to) throws Throwable;
	void saveFascicolo(FascicoliBO bo, GestioneFadTO to) throws Throwable;
	List<FascicoliBO> findFascicoliFadStatusZero() throws Throwable;
	void updateFascicolo (FascicoliBO bo) throws Throwable;
	boolean esisteFascicoloConModelloIter(Short idIter) throws Throwable;
	List<?> findFascicoliByTipologiaDecreto(Integer anagTipologiaDecreto) throws Throwable;
	List<FascicoliBO> findFascicoliFadCdc(FascicoliFadSearhTO to) throws Throwable;
	public List<FascicoliBO> findFascicoliFadByAnno(String anno) throws Throwable;
	List<FascicoliViewTO> findFascicoloByTipoNumAnno(Integer anno, Integer tipo, Integer numDec) throws Throwable;
	List<FascicoliBO> findFascicoliFadPecPartecipazione(FascicoliFadSearhTO to) throws Throwable;
	List<FascicoliBO> findFascicoliFadLetterePreReg(FascicoliFadSearhTO to) throws Throwable;
	RiepilogoDatiAnagBO findFascicoloAggiornato(long id) throws Throwable;
	RiepilogoDatiAnagBO saveAggiornamentoFascicolo(RiepilogoDatiAnagBO bo) throws Throwable;
	RiepilogoDatiAnagBO saveAggiornamentoFascicoloTO(RiepilogoDatiAnagTO to, AnagTipoRiepilogoBO tipoBo) throws Throwable;
}
