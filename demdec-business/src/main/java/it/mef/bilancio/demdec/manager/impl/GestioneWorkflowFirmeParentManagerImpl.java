package it.mef.bilancio.demdec.manager.impl;

import static it.almavivaitalia.bilancio.commons.to.CroTransTO.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bilancio.commons.bo.AbstractCommonBO;
import it.almavivaitalia.bilancio.commons.bo.AnagFirmatariBO;
import it.almavivaitalia.bilancio.commons.bo.AnagModelliIterBO;
import it.almavivaitalia.bilancio.commons.bo.IterFirmaBO;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.mef.bilancio.demdec.dao.AnagFirmatariDao;
import it.mef.bilancio.demdec.dao.AnagModelliIterDao;
import it.mef.bilancio.demdec.dao.AnagTipologiaDecretoDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.dao.IterFirmaDao;
import it.mef.bilancio.demdec.dao.IterFirmaDecretoDao;
import it.mef.bilancio.demdec.manager.GestioneWorkflowFirmeManager;
import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;
import it.mef.bilancio.demdec.to.AnagModelliIterTO;
import it.mef.bilancio.demdec.to.IterFirmaTO;

public class GestioneWorkflowFirmeParentManagerImpl extends AbstractDemManagerImpl{

	@Autowired
	private AnagFirmatariDao anagFirmatariDao;

	
	
	public AnagFirmatariDao getAnagFirmatariDao() {
		return anagFirmatariDao;
	}


	
	public List<AnagFirmatariTO> elencoAnagraficaFirmatari() throws Throwable {

		List<AnagFirmatariBO> listaBO = anagFirmatariDao.loadFirmatari();

		return
				getDozerDriver().mapList(listaBO, AnagFirmatariTO.class, "AnagFirmatari");
	}


	public 	AnagFirmatariTO loadAnagFirmatari(String codiceFirmatario) throws Throwable {

		AnagFirmatariBO anagFirmatariBO = anagFirmatariDao.loadById(codiceFirmatario);

		return getDozerDriver().map(anagFirmatariBO, AnagFirmatariTO.class, "AnagFirmatari");

	}


}
