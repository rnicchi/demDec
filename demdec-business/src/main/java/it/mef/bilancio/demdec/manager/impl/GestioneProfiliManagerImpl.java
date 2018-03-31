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

public class GestioneProfiliManagerImpl extends GestioneProfiliParentManagerImpl implements GestioneProfiliManager{

	@Autowired
	private ProfiloDao profiloDao;
	@Autowired
	private UtenteDao utenteDao;
	
	/*
	@Autowired
	private UtenteProfiloDao utenteProfiloDao;
	@Autowired
	private ProfiloActionDao profiloActionDao;
	@Autowired
	private ActionDao actionDao;
	*/
	
	//@Override
	public ManagerResponseTO<ProfiloTO> caricaProfiloByCodiceProfilo(String codiceProfilo) throws Throwable {

		ProfiloBO profiloBO = profiloDao.loadByCodiProfilo(codiceProfilo);
		if (profiloBO == null)
			return new ManagerResponseTO<ProfiloTO>(TipoResponse.ERROR, "errore.profilo.codice.presente");
		return new ManagerResponseTO<ProfiloTO>(TipoResponse.INFO, "info.utente.codice.presente", (ProfiloTO) getDozerDriver().map(profiloBO, ProfiloTO.class, "Profilo"));
	}
	
	public ManagerResponseTO<ProfiloTO> caricaProfiloByIdSelezionato(String selectedProfilo) throws Throwable {

		Long id = Long.parseLong(selectedProfilo);
		
		ProfiloBO profiloBO = profiloDao.loadByPrimaryKeyInt(id);
		if (profiloBO == null)
			return new ManagerResponseTO<ProfiloTO>(TipoResponse.ERROR, "errore.profilo.codice.presente");
		return new ManagerResponseTO<ProfiloTO>(TipoResponse.INFO, "info.utente.codice.presente", (ProfiloTO) getDozerDriver().map(profiloBO, ProfiloTO.class, "Profilo"));
	}

	
//	@Override
	public ManagerResponseTO<ProfiloTO> creaNuovoProfilo(ProfiloTO profiloTo) throws Throwable {
		
		ProfiloBO controlloProfilo = new ProfiloBO();
		
		controlloProfilo = profiloDao.loadByCodiProfilo(profiloTo.getCodiProfilo());
		
		if(controlloProfilo != null){
			return new ManagerResponseTO<ProfiloTO>(TipoResponse.ERROR, "errore.profilo.codice.presente");
		}
		
		profiloTo.setId(profiloDao.newId());
		
		ProfiloBO profiloBo = (ProfiloBO) getDozerDriver().map(profiloTo, ProfiloBO.class, "Profilo");
		
		ProfiloBO profBoNew = new ProfiloBO();	
			
		profBoNew = profiloDao.saveOrUpdate(profiloBo);

		if (profBoNew != null) {
			
			return	new ManagerResponseTO<ProfiloTO>(TipoResponse.INFO, "info.insert.success", (ProfiloTO) getDozerDriver().map(profBoNew, ProfiloTO.class, "Profilo"));
		}
		
	//	return null;
		return new ManagerResponseTO<ProfiloTO>(TipoResponse.WARN, "warning.noinsert");
	
	}
	
	
	@Override
	public ManagerResponseTO<ProfiloTO> creaProfilo(ProfiloTO profiloTO) throws Throwable {

		ProfiloBO profiloBO = profiloDao.loadByCodiProfilo(profiloTO.getCodiProfilo());
		ProfiloTO to=null;
		if (profiloBO != null)
			;
			//return new ProfiloTO(TipoResponse.ERROR, "errore.profilo.codice.presente", profiloTO);
		
			
		//	ProfiloBO profiloBo = getProfiloBO(profiloTO);
	/*	ProfiloBO profiloBOnuovo = new ProfiloBO();
		profiloBOnuovo.setCodiProfilo("11");
		profiloBOnuovo.setDescProfilo("provaDesc");
		copyAllAudit(profiloTO, profiloBOnuovo);*/
		
		//ProfiloBO profBoNew = profiloDao.saveOrUpdate(profiloBOnuovo);
	/*		ProfiloBO profBoNew = profiloDao.saveOrUpdate(profiloBo);

		if (profBoNew != null) {
			for (ProfiloActionBO profiloActionBo: profBoNew.getProfiloActionList())
				profiloActionDao.saveOrUpdate(profiloActionBo);
			
			ProfiloTO toResp = getDozerDriver().map(profBoNew, ProfiloTO.class, "Profilo");
			
			

			//return toResp;
					new ManagerResponseTO<ProfiloTO>(TipoResponse.INFO, "info.insert.success", (ProfiloTO) getDozerDriver().map(profBoNew, ProfiloTO.class, "Profilo"));
		}*/
		return null;
		// to=salvaProfilo(profiloTO);
		 
		// return to;
	}

	
	@Override
	public ManagerResponseTO<ProfiloTO> salvaProfilo(ProfiloTO profiloTO) throws Throwable {

		ProfiloBO profiloBO = profiloDao.loadByCodiProfilo(profiloTO.getCodiProfilo());

		try {
			profiloBO = saveProfiloBO(profiloBO, profiloTO);
		}
		catch (Throwable t) {
			return new ManagerResponseTO<ProfiloTO>(TipoResponse.WARN, "warning.noinsert");
		}
		return  new ManagerResponseTO<ProfiloTO>(TipoResponse.INFO, "info.update.success", 
							(ProfiloTO) getDozerDriver().map(profiloBO, ProfiloTO.class, "Profilo"));
	}


	//@Override
	public List<ProfiloTO> caricaTuttiProfili() throws Throwable {
		return getDozerDriver().mapList(profiloDao.loadAllOrdByDescrProf(), ProfiloTO.class, "Profilo");
	}											//.loadAll()

	
	//metodo che carica tutti i profili ma ordinati in base al codice
	public List<ProfiloTO> caricaTuttiProfiliOrdByCodiProf() throws Throwable {
		return getDozerDriver().mapList(profiloDao.loadAllOrdByCodiProf(), ProfiloTO.class, "Profilo");
	}	
	
	//copia i campi del TO nel BO, mantenendo inalterato id; e aggiorna la lista dei Profili
	private ProfiloBO saveProfiloBO(ProfiloBO profiloBO, ProfiloTO profiloTo) throws Throwable {

		profiloBO.setCodiProfilo(profiloTo.getCodiProfilo());
		profiloBO.setDescProfilo(profiloTo.getDescProfilo());
		
		//non posso cancellare associazioni Utente-Profilo tramite UtenteBo, perch� Hibernate esegue un Update a null della chiave
		//Decido di cancellare prima i profili e poi inserire i nuovi (altra opzione � modificare i valori dei profili gi� presenti: oneroso)
	//	profiloDao.deleteAction(profiloBO);

		//creo una nuova lista associazione Utente-Profilo dal TO
	/*	List<ProfiloActionBO> lista = getListaAssociazioneProfiloActionBO(profiloBO, profiloTo);
		profiloDao.insertAction(profiloBO, lista);
		profiloDao.saveOrUpdate(profiloBO);
*/
		return profiloBO;
	}

	
	@Override
	public ManagerResponseTO<ProfiloTO> eliminaProfilo(String selectedCodiProfilo) {

		try {
			profiloDao.delete(selectedCodiProfilo.toString());
		} catch (Throwable t) {
			return new ManagerResponseTO<ProfiloTO>(TipoResponse.ERROR, "errore.delete.profilo.failed");
		}
		return new ManagerResponseTO<ProfiloTO>(TipoResponse.INFO, "info.delete.profilo.success");
	}


	
	public ManagerResponseTO<UtenteProfiloTO> findUtenteProfiloByProfiloId(String idProfilo) throws Throwable{
		
		//ProfiloTO profTO = loadProfiloByCodiceProfilo(idProfilo);
		
		ProfiloTO profTO = loadProfiloByIdProfilo(idProfilo);
		
		
		//faccio "getUtenteProfiloDao()." perch� questo Dao 
		//� stato spostato nella Class: GestioneProfiliParentManagerImpl.java
		
		
		
		List<UtenteProfiloBO> utProfBo = getUtenteProfiloDao().loadBySequIdProfilo(profTO.getId());
			
		UtenteProfiloTO toResp = new UtenteProfiloTO();
				
		int size = utProfBo.size();
				//utProfBo.get(0) ;
		
		if(size == 0)
			toResp = null;
		
		if(size != 0){
			toResp.setNumeVersion(utProfBo.get(0).getNumeVersion());
		
				return new ManagerResponseTO<UtenteProfiloTO>(TipoResponse.ERROR, "errore.profilo.utente.presente");
			
		}
		
		return	new ManagerResponseTO<UtenteProfiloTO>(TipoResponse.INFO, "info.insert.success");
	}
	
	public ProfiloTO loadProfiloByCodiceProfilo(String codiceProfilo) throws Throwable{
		
		int idAss = Integer.parseInt(codiceProfilo);
		
		ProfiloBO profBo = profiloDao.loadById(ProfiloBO.class, idAss);
		
		ProfiloTO toResp = getDozerDriver().map(profBo, ProfiloTO.class, "Profilo");
		
		
		//ProfiloTO profTo = profiloDao.loadByCodiProfilo(codiceProfilo);
		
		return toResp;
	}
	
	public ProfiloTO loadProfiloByIdProfilo(String idProfilo) throws Throwable{
		
		long idAss = Long.parseLong(idProfilo);
		
		ProfiloBO profBo = profiloDao.loadByPrimaryKeyInt(idAss);
		
		ProfiloTO toResp = getDozerDriver().map(profBo, ProfiloTO.class, "Profilo");
		
		return toResp;
	}
	
	public void deleteProfiloByID(String codiProfilo) throws Throwable{
		
		profiloDao.delete(codiProfilo);
	}

}
