package it.mef.bilancio.demdec.manager;

import it.almavivaitalia.bilancio.commons.bo.AnagTipoRiepilogoBO;
import it.almavivaitalia.bilancio.commons.to.ActionTO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTOId;
import it.almavivaitalia.bilancio.commons.to.AnagTipoRiepilogoTO;
import it.almavivaitalia.bilancio.commons.to.AnagTipologiaTagliaTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.mef.bilancio.demdec.to.AnagCdrDemTO;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;
import it.mef.bilancio.demdec.to.AnagRagionerieDemTO;
import it.mef.bilancio.demdec.to.AnagStatoFascicoloTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.AnagTipoFlussoTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.to.FirmatarioTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;

import java.util.List;

public interface ListManager extends StaticListManager {

	List<CroTransTO> loadFunzioni() throws Throwable;
	
	List<UtenteTO> loadAllUtenti() throws Throwable;
	
	List<EserciziTO> loadEserciziDemCG() throws Throwable;

	List<AnagAmminDemTO> getAmminDemByAnnoEse(String annoEse) throws Throwable;

	List<AnagUfficiTO> loadAnagUffici() throws Throwable;

	List<AnagStatoFascicoloTO> loadStatiFascicoliRed() throws Throwable;

	List<AnagTipoDecretoTO> loadAnagTipoDecreto() throws Throwable;

	List<AnagStatoFascicoloTO> loadStatiFascicoliFad() throws Throwable;
	
	List<AnagStatoFascicoloTO> loadStatiFascicoliModificaFad() throws Throwable;
	
	String loadDecStatiFascicoliFad(String id) throws Throwable; //TODO Non deve stare qui 

	List<AnagTipologiaDecretoTO> tipologiaDecretoList(Integer codiTipoDecreto) throws Throwable;

	List<AnagCdrDemTO> getCdrByAdmin(AnagAmminDemTOId amminId) throws Throwable;

	List<AnagAmminDemTO> getAmminDemCentraliByAnnoEse(String annoEse)
			throws Throwable;

	List<AnagUfficiTO> loadAnagUfficiAttivi() throws Throwable;
	
	List<FirmatarioTO> findFirmatari(Long idNumeFascicolo) throws Throwable;

	List<FascicoliViewTO> findListaDecretiByTipoNumAnnoUfficio(Integer anno, Integer tipo, Integer numDec, Integer ufficio ) throws Throwable;
	
	AnagTipoDecretoTO loadAnagTipoDecretoById(Integer id) throws Throwable;
	
	List<AnagTipoFlussoTO> loadAnagTipoFlusso() throws Throwable;

	List<AnagAmminDemTO> getAmminDemByAnnoEseUtenteAndProfilo(String annoEse, String idUtente, String idProfilo) throws Throwable;

//	AmminRagDemTO getRagByEse(AnagAmminDemTOId amminId)		throws Throwable;

	List<TipoDocumentoTO> loadTipoDocumentoIG() throws Throwable;

	List<TipoDocumentoTO> loadTipoDocumentoAD() throws Throwable;
    
	List<FascicoliViewTO> findSospFirmeListaDecretiByTipoNumAnno(Integer anno, Integer tipo, Integer numDec) throws Throwable;
	
	List<FascicoliViewTO> findRevSospFirmeListaDecretiByTipoNumAnno(Integer anno, Integer tipo, Integer numDec) throws Throwable;

	List<ProfiloTO> findAllProfili() throws Throwable;

	String loadDescStatiFascicoliRed(String id) throws Throwable;
	
	List<ActionTO> findAllAction() throws Throwable;
	
	List<ActionTO> findAllActionByProfilo(Integer sequIdProfilo) throws Throwable;

	List<DescDocumentoTO> loadDescDocumentoByTipo(String tipo) throws Throwable;

	List<AnagStatoFascicoloTO> loadStatiFascicoloMonitoraggio() throws Throwable;
	
	List<AnagTipologiaTagliaTO> loadAnagTipologiaTaglia() throws Throwable;
	
	List<AnagTipoRiepilogoTO> loadAnagTipoRiepilogo() throws Throwable;
	
	AnagTipoRiepilogoBO loadTipoRiepilogoByDesc(String descTipo)throws Throwable;
	
	AnagTipoRiepilogoTO loadTipoRiepilogoTOByDesc(String descTipo)throws Throwable;

	List<AnagRagionerieDemTO> findAnagRagDemByAnagAmminDem(AnagAmminDemTO anagAmminDemTO) throws Throwable;

	List<AnagFirmatariTO> loadFirmatari() throws Throwable;
}
