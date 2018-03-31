package it.mef.bilancio.demdec.manager.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bilancio.commons.bo.ActionBO;
import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBOId;
import it.almavivaitalia.bilancio.commons.bo.AnagUfficiBO;
import it.almavivaitalia.bilancio.commons.bo.ProfiloActionBO;
import it.almavivaitalia.bilancio.commons.bo.ProfiloActionBOId;
import it.almavivaitalia.bilancio.commons.bo.ProfiloBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBOId;
import it.almavivaitalia.bilancio.commons.dao.ActionDao;
import it.almavivaitalia.bilancio.commons.dao.ProfiloActionDao;
import it.almavivaitalia.bilancio.commons.dao.ProfiloDao;
import it.almavivaitalia.bilancio.commons.dao.UtenteDao;
import it.almavivaitalia.bilancio.commons.dao.UtenteProfiloDao;
import it.almavivaitalia.bilancio.commons.to.ActionTO;
import it.almavivaitalia.bilancio.commons.to.ProfiloActionTO;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTOId;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.mef.bilancio.demdec.enums.TipoResponse;
import it.mef.bilancio.demdec.manager.GestioneProfiliManager;
import it.mef.bilancio.demdec.manager.GestioneUtentiManager;
import it.mef.bilancio.demdec.to.ManagerResponseTO;

public class GestioneProfiliParentManagerImpl extends AbstractDemManagerImpl{

	@Autowired
	private UtenteProfiloDao utenteProfiloDao;
	@Autowired
	private ProfiloActionDao profiloActionDao;
	@Autowired
	private ActionDao actionDao;
	
	
	public UtenteProfiloDao getUtenteProfiloDao() {
		return utenteProfiloDao;
	}

	
	public void deleteProfiloAssociatoByID(String codiProfilo) throws Throwable{
		
		profiloActionDao.delete(codiProfilo);
	}
	
	
	
	public void salvaAssociazioniActionProfilo(String idActionAssociato, String codiProfilo) throws Throwable{
		

		profiloActionDao.salvaAssoActionProfilo(idActionAssociato, codiProfilo);
		
	}

	//@Override ---> levo l'Override se no dovrei far diventare questa classe una classe astratta
	public ActionTO findActionById(String idAssociato) throws Throwable {
		
		int idAss = Integer.parseInt(idAssociato);
		
		ActionBO actionBo = actionDao.loadById(ActionBO.class, idAss);
		
		ActionTO toResp = getDozerDriver().map(actionBo, ActionTO.class, "Action");
		
		
		return toResp;
	}
	
	
	


}
