package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;
import it.mef.bilancio.demdec.dao.AnagAmminDemDao;
import it.mef.bilancio.demdec.dao.AnagRagionerieDemDao;
import it.mef.bilancio.demdec.dao.AnagTipoDecretoDao;
import it.mef.bilancio.demdec.dao.AnagTipoFlussoDao;
import it.mef.bilancio.demdec.dao.AnagUfficiDao;
import it.mef.bilancio.demdec.dao.DescDocumentoDao;
import it.mef.bilancio.demdec.dao.InvioAlleFirmeDao;
import it.mef.bilancio.demdec.dao.TipoDocumentoDao;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.to.AnagRagionerieDemTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.AnagTipoFlussoTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class  AbstractListManagerImpl extends AbstractParentListManagerImpl implements ListManager {
	
	
	@Autowired
	private AnagTipoDecretoDao anagTipoDecretoDao;
	
	@Autowired
	private InvioAlleFirmeDao invioAlleFirmeDao;
	
	@Autowired
	private AnagTipoFlussoDao anagTipoFlussoDao;
	
	@Autowired
	private TipoDocumentoDao tipoDocumentoDao;
	
	@Autowired
	private DescDocumentoDao descDocumentoDao;
	
	@Autowired
	private AnagAmminDemDao anagAmminDemDao;
	
	@Autowired
	private AnagUfficiDao anagUfficiDao;
	
	@Autowired
	private AnagRagionerieDemDao anagRagionerieDemDao;
	
	
	
	@Override
	public List<FascicoliViewTO> findListaDecretiByTipoNumAnnoUfficio(Integer anno, Integer tipo, Integer numDec, Integer ufficio )  throws Throwable{
		return invioAlleFirmeDao.findListaDecretiByTipoNumAnnoUfficio(anno, tipo, numDec,  ufficio );
	 
	}

	@Override
	public AnagTipoDecretoTO loadAnagTipoDecretoById(Integer id) throws Throwable {
		return getDozerDriver().map(anagTipoDecretoDao.loadAnagTipoDecretoById(id), AnagTipoDecretoTO.class, "AnagTipoDecreto");
	}
	
	@Override
	public List<AnagTipoFlussoTO> loadAnagTipoFlusso() throws Throwable {
		return getDozerDriver().mapList(anagTipoFlussoDao.loadAnagTipoFlusso(),AnagTipoFlussoTO.class,"AnagTipoFlusso");
	}
	
	
	@Override
	public List<TipoDocumentoTO> loadTipoDocumentoIG() throws Throwable{
		
		return getDozerDriver().mapList(tipoDocumentoDao.loadTipoDocumentoIG(),TipoDocumentoTO.class,"TipoDocumento");
		
	}
	
	@Override
	public List<DescDocumentoTO> loadDescDocumentoByTipo(String tipo) throws Throwable{
		
		return getDozerDriver().mapList(descDocumentoDao.loadByTipoDocumento(tipo), DescDocumentoTO.class, "DescDocumento");
		
	}
	
	@Override
	public List<TipoDocumentoTO> loadTipoDocumentoAD() throws Throwable{
		
		return getDozerDriver().mapList(tipoDocumentoDao.loadTipoDocumentoAD(),TipoDocumentoTO.class,"TipoDocumento");
		
	}

	@Override
	public List<FascicoliViewTO> findSospFirmeListaDecretiByTipoNumAnno(Integer anno, Integer tipo, Integer numDec) throws Throwable {	
		return invioAlleFirmeDao.findSospFirmeListaDecretiByTipoNumAnno(anno, tipo, numDec);
	}
	
	
	@Override
	public List<FascicoliViewTO> findRevSospFirmeListaDecretiByTipoNumAnno(Integer anno, Integer tipo, Integer numDec) throws Throwable {	
		return invioAlleFirmeDao.findRevSospFirmeListaDecretiByTipoNumAnno(anno, tipo, numDec);
	}
	
	@Override
	public List<AnagAmminDemTO> getAmminDemByAnnoEse(String annoEse) throws Throwable {
		return getDozerDriver().mapList(anagAmminDemDao.getAmminDemByAnnoEse(annoEse), AnagAmminDemTO.class, "AnagAmmin");
	}
	
	@Override
	public List<AnagAmminDemTO> getAmminDemByAnnoEseUtenteAndProfilo(String annoEse, String idUtente, String idProfilo) throws Throwable {
		return getDozerDriver().mapList(anagAmminDemDao.getAmminDemByAnnoEseUtenteAndProfilo(annoEse, idUtente, idProfilo), AnagAmminDemTO.class, "AnagAmmin");
	}
	
	@Override
	public List<AnagAmminDemTO> getAmminDemCentraliByAnnoEse(String annoEse) throws Throwable {
		return getDozerDriver().mapList(anagAmminDemDao.getAmminDemCentraliByAnnoEse(annoEse), AnagAmminDemTO.class, "AnagAmmin");
	}
	
	@Override
	public List<AnagUfficiTO> loadAnagUfficiAttivi() throws Throwable{
		return getDozerDriver().mapList(anagUfficiDao.loadAnagUfficiAttivi(),AnagUfficiTO.class,"AnagUffici");
	}
	

	@Override
	public List<AnagUfficiTO> loadAnagUffici() throws Throwable{
		return getDozerDriver().mapList(anagUfficiDao.loadAnagUffici(),AnagUfficiTO.class,"AnagUffici");
	}
	
	@Override
	public List<AnagRagionerieDemTO> findAnagRagDemByAnagAmminDem(AnagAmminDemTO anagAmminDemTO) throws Throwable {
		return getDozerDriver().mapList(anagRagionerieDemDao.findAnagRagDemByAnagAmminDem(anagAmminDemTO), AnagRagionerieDemTO.class, "AnagRag");
	}
	
}
