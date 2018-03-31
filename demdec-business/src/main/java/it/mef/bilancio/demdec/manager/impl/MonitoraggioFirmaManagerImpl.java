package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.IterFirmaDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.MonitoraggioFirmaBO;
import it.mef.bilancio.demdec.dao.IterFirmaDecretoDao;
import it.mef.bilancio.demdec.dao.MonitoraggioFirmaDao;
import it.mef.bilancio.demdec.manager.MonitoraggioFirmaManager;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;
import it.mef.bilancio.demdec.to.MonitoraggioFirmaTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class MonitoraggioFirmaManagerImpl extends AbstractDemManagerImpl implements MonitoraggioFirmaManager{

	@Autowired
	private MonitoraggioFirmaDao monitoraggioFirmaDao;
	
	@Autowired
	private IterFirmaDecretoDao iterFirmaDecretoDao;
	
	@Override
	public List<MonitoraggioFirmaTO> caricaListaDecreti(MonitoraggioFirmaTO monitoraggioFirmaTO) throws Throwable {
		
		List<MonitoraggioFirmaBO> listaDecretiBO = monitoraggioFirmaDao.findByExample(monitoraggioFirmaTO);
		return getDozerDriver().mapList(listaDecretiBO, MonitoraggioFirmaTO.class, "MonitoraggioFirma");
	}

	@Override
	public List<IterFirmaDecretoTO> caricaListaIterFirmaDecreto(long idFascicolo) throws Throwable {

		List<IterFirmaDecretoBO> listaIterFirmaDecretiBO = iterFirmaDecretoDao.getListIterFirmaDecretoByNumeIdFascicolo(idFascicolo);
		return getDozerDriver().mapList(listaIterFirmaDecretiBO, IterFirmaDecretoTO.class, "IterFirmaDecreto");
	}


}
