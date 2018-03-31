package it.mef.bilancio.demdec.manager.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.mef.bilancio.demdec.dao.InvioAlleFirmeDao;
import it.mef.bilancio.demdec.dao.PartecipazioniDao;
import it.mef.bilancio.demdec.manager.InvioPecPartecipazioneManager;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.PartecipazioniTO;

public class InvioPecPartecipazioneManagerImpl extends AbstractDemManagerImpl implements InvioPecPartecipazioneManager {
	
	
	@Autowired
	private PartecipazioniDao partecipazioniDao;
	
	@Autowired
	private InvioAlleFirmeDao invioAlleFirmeDao;

	@Override
	public List<PartecipazioniTO> findByIdFascicolo(Integer idFascicolo) throws Throwable {

		return partecipazioniDao.findByIdFascicolo(idFascicolo);
	}

	@Override
	public List<String> findDestinatariMailPec(BigDecimal idFascicolo)
			throws Throwable {
			return partecipazioniDao.findDestinatariMailPec(idFascicolo);
	}
	
	
	public DocumentiTO loadDocumentoByGuidFascicoloETipo(String guidFascicolo, String tipoDocumento) throws Throwable {
		DocumentiBO docBo=invioAlleFirmeDao.loadDocumentoByGuidFascicoloETipo(guidFascicolo, tipoDocumento);
		if(docBo!=null){
			return getDozerDriver().map(docBo, DocumentiTO.class, "Documenti");
		}else {
			return null;
		}
	}
	
	
	
}
