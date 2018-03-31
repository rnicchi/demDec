package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.mef.bilancio.demdec.dao.DocumentiDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.dao.SottoFascicoliRedDao;
import it.mef.bilancio.demdec.manager.ConsFADCdcManager;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ConsFADCdcManagerImpl extends AbstractDemManagerImpl implements ConsFADCdcManager{
	
	@Autowired
	private FascicoloDao fascicoloDao;
	
	@Autowired
	private DocumentiDao documentiDao; 
	
	@Autowired
	private SottoFascicoliRedDao sottoFascicoliRedDao;
	
	
	
	@Override
	public List<FascicoliTO> getFascicoliFadCdc(FascicoliFadSearhTO to)
			throws Throwable {
		List<FascicoliTO> ret = getDozerDriver().mapList(fascicoloDao.findFascicoliFadCdc(to), FascicoliTO.class, "FascicoliFad");
/*		for (int i=0; i < ret.size(); i++){
			ret.get(i).aggiornaEstremiStr();
		}*/
		return ret;
		
	}

	@Override
	public List<DocumentiTO> getDocumentiByIdFadFlgVisCdc(Long idFad, Long flgVisibilitaCdc)
			throws Throwable {
		return getDozerDriver().mapList(documentiDao.getDocumentiByIdFadFlgVisCdc( idFad,  flgVisibilitaCdc), DocumentiTO.class, "Documenti");
		
	}
	
	
	@Override
	public List<SottoFascicoliRedTO> getSottoFascicoliRedByIdFad(Long idFad)
			throws Throwable {
		return getDozerDriver().mapList(sottoFascicoliRedDao.findByNumeIdFascicolo(idFad), SottoFascicoliRedTO.class, "SottoFascicoliRed");
		
	}
	
	@Override
	public boolean salvaDatiProtEntrataCdc(FascicoliTO fascicoloTo) throws Throwable {
	
		FascicoliBO bo=fascicoloDao.loadById(FascicoliBO.class, fascicoloTo.getId());
		FascicoliBO boRes=null;
		if(bo!=null){
			copyAudit(fascicoloTo, bo);
			bo.setNumeProtRicezioneCdc(fascicoloTo.getNumeProtRicezioneCdc().toString());
			bo.setDataRicezioneCdc(fascicoloTo.getDataRicezioneCdc());
			
			boRes=(FascicoliBO)fascicoloDao.saveOrUpdate(bo);
		}
		return (boRes!=null?true:false);
	}
	
	
	@Override
	public boolean salvaDatiRegistrazioneCdc(FascicoliTO fascicoloTo) throws Throwable {
	
		FascicoliBO bo=fascicoloDao.loadById(FascicoliBO.class, fascicoloTo.getId());
		FascicoliBO boRes=null;
		if(bo!=null){
			copyAudit(fascicoloTo, bo);
			bo.setNumeRgistrazioneCdc(fascicoloTo.getNumeRgistrazioneCdc());
			bo.setDataRegistrazioneCdc(fascicoloTo.getDataRegistrazioneCdc());
			bo.setNumeUfficioCdc(fascicoloTo.getNumeUfficioCdc());
			
			boRes=(FascicoliBO)fascicoloDao.saveOrUpdate(bo);
		}
		return (boRes!=null?true:false);
	}
	
	
	@Override
	public boolean salvaDatiProtUscitaCdc(FascicoliTO fascicoloTo) throws Throwable {
	
		FascicoliBO bo=fascicoloDao.loadById(FascicoliBO.class, fascicoloTo.getId());
		FascicoliBO boRes=null;
		if(bo!=null){
			copyAudit(fascicoloTo, bo);
			bo.setNumeProtRegistrazioneCdc(fascicoloTo.getNumeProtRegistrazioneCdc().toString());
			bo.setDataRegistrazioneCdc(fascicoloTo.getDataRegistrazioneCdc());
			
			boRes=(FascicoliBO)fascicoloDao.saveOrUpdate(bo);
		}
		return (boRes!=null?true:false);
	}
	
	@Override
	public boolean salvaDataPresaCaricoCdc(FascicoliTO fascicoloTo) throws Throwable {
	
		FascicoliBO bo=fascicoloDao.loadById(FascicoliBO.class, fascicoloTo.getId());
		FascicoliBO boRes=null;
		if(bo!=null){
			copyAudit(fascicoloTo, bo);
			bo.setDataPresaCaricoCdc(fascicoloTo.getDataPresaCaricoCdc());		
			boRes=(FascicoliBO)fascicoloDao.saveOrUpdate(bo);
		}
		return (boRes!=null?true:false);
	}
	

}
