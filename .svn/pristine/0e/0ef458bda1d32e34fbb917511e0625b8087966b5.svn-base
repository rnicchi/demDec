package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.ProfiloBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBOId;
import it.almavivaitalia.bilancio.commons.dao.ProfiloDao;
import it.almavivaitalia.bilancio.commons.dao.UtenteDao;
import it.almavivaitalia.bilancio.commons.dao.UtenteProfiloDao;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTOId;
import it.mef.bilancio.demdec.dao.AnagFirmatariDao;
import it.mef.bilancio.demdec.manager.DelegaManager;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;

public class DelegaManagerImpl extends AbstractDemManagerImpl implements DelegaManager{
	
	@Autowired
	AnagFirmatariDao anagFirmatariDao;
	
	@Autowired
	ProfiloDao profiloDao;
	
	@Autowired
	UtenteDao utenteDao;
	
	@Autowired
	UtenteProfiloDao utenteProfiloDao;
	
	@Autowired
	CronologicoManager cronologicoManager;
	
	//@Override
	public Map<Integer,String> findDelegantiOld(String tipoFirma) throws Throwable {
		
		Map<Integer,String> deleganti = new LinkedHashMap<Integer,String>();
		String fullName = null;
		Integer idUtente = null;
		 
		List<AnagFirmatariTO> listaDeleganti = getDozerDriver().mapList(anagFirmatariDao.loadDeleganti(tipoFirma), AnagFirmatariTO.class, "AnagFirmatari");
		List<UtenteProfiloBO> listaUtentiProfilo = new ArrayList<UtenteProfiloBO>();
		for (Iterator<AnagFirmatariTO> anagFirmatari = listaDeleganti.iterator(); anagFirmatari.hasNext();) {
			AnagFirmatariTO anagFirmatariTO = (AnagFirmatariTO) anagFirmatari.next();
			listaUtentiProfilo.addAll(profiloDao.loadById(ProfiloBO.class, anagFirmatariTO.getFkSequIdProfilo()).getUtenteProfiloList());
			
		}
		
		Collections.sort(listaUtentiProfilo);
		for (UtenteProfiloBO utenteProfiloBO : listaUtentiProfilo) {
			idUtente = utenteProfiloBO.getUtente().getId();
			fullName =  utenteProfiloBO.getUtente().getPersCognome()+ " " + utenteProfiloBO.getUtente().getPersNome();
			
			if(!deleganti.containsKey(idUtente)){
				deleganti.put(idUtente,fullName);
			}
			
		}
		
		return deleganti;
	}
	

	
	@Override
	public List<UtenteProfiloTO> findDeleganti(String tipoFirma) throws Throwable {
		
		Map<Integer,String> deleganti = new LinkedHashMap<Integer,String>();
		String fullName = null;
		Integer idUtente = null;
		 
		List<AnagFirmatariTO> listaDeleganti = getDozerDriver().mapList(anagFirmatariDao.loadDeleganti(tipoFirma), AnagFirmatariTO.class, "AnagFirmatari");
		List<UtenteProfiloBO> listaUtentiProfilo = new ArrayList<UtenteProfiloBO>();
		for (Iterator<AnagFirmatariTO> anagFirmatari = listaDeleganti.iterator(); anagFirmatari.hasNext();) {
			AnagFirmatariTO anagFirmatariTO = (AnagFirmatariTO) anagFirmatari.next();
			listaUtentiProfilo.addAll(profiloDao.loadById(ProfiloBO.class, anagFirmatariTO.getFkSequIdProfilo()).getUtenteProfiloList());
			
		}
		
		
		Set<UtenteProfiloBO> listaUtentiProfiloNoDupl=new TreeSet<UtenteProfiloBO>(listaUtentiProfilo);
		List<UtenteProfiloBO> listBo= new ArrayList<UtenteProfiloBO>(listaUtentiProfiloNoDupl); 
		
		List<UtenteProfiloBO> listBo2= new ArrayList<UtenteProfiloBO>();
		 
		for (int i = 0; i < listBo.size(); i++) {
			if(listBo.get(i).getFlagDelega01()==0){
				listBo2.add(listBo.get(i));
			}
		}
		
	//	Collections.sort(listaUtentiProfilo);
		
	//	List<UtenteProfiloTO> listaDelegantiTo = getDozerDriver().mapList(listaUtentiProfilo, UtenteProfiloTO.class, "UtenteProfilo");
		List<UtenteProfiloTO> listaDelegantiTo = getDozerDriver().mapList(listBo2, UtenteProfiloTO.class, "UtenteProfilo");
		
		return listaDelegantiTo;
		
		
	}

	

	@Override
	public Map<Integer,String>  findDelegati(String tipoFirma) throws Throwable {
		
		Map<Integer,String> delegati = new LinkedHashMap<Integer,String>();
		String fullName = null;
		Integer idUtente = null;
		
		List<AnagFirmatariTO> listaDelegati = getDozerDriver().mapList(anagFirmatariDao.loadDelegati(tipoFirma), AnagFirmatariTO.class, "AnagFirmatari");
		List<UtenteProfiloBO> listaUtentiProfilo = new ArrayList<UtenteProfiloBO>();
		for (Iterator<AnagFirmatariTO> anagFirmatari = listaDelegati.iterator(); anagFirmatari.hasNext();) {
			AnagFirmatariTO anagFirmatariTO = (AnagFirmatariTO) anagFirmatari.next();
			listaUtentiProfilo.addAll(profiloDao.loadById(ProfiloBO.class, anagFirmatariTO.getFkSequIdProfilo()).getUtenteProfiloList());
			
		}
		Collections.sort(listaUtentiProfilo);
		
		for (UtenteProfiloBO utenteProfiloBO : listaUtentiProfilo) {
			idUtente = utenteProfiloBO.getUtente().getId();
			fullName =  utenteProfiloBO.getUtente().getPersCognome()+ " " + utenteProfiloBO.getUtente().getPersNome();
			
			if(!delegati.containsKey(idUtente)){
				delegati.put(idUtente,fullName);
			}
			
		}
		return delegati;
	}

	@Override
	public void saveDelega(UtenteProfiloTO utenteProfilo, Short croTransTo) throws Throwable {
		UtenteProfiloBO bo = getDozerDriver().map(utenteProfilo, UtenteProfiloBO.class, "UtenteProfilo");
		utenteProfiloDao.saveOrUpdate(bo);
		cronologicoManager.salvaCronologico(null, bo, null, null, croTransTo, utenteProfilo.getRowUpdatedForm(), utenteProfilo.getRowUpdatedUser());
		
	}

	@Override
	public Map<Integer, String> findDelegatiAttivi() throws Throwable {
		
		Map<Integer,String> delegatiAttivi = new LinkedHashMap<Integer,String>();
		String fullName = null;
		Integer idUtente = null;
		
		List<UtenteProfiloBO> listaDeleghe = utenteProfiloDao.loadDeleghe();
		for (UtenteProfiloBO utenteProfiloBO : listaDeleghe) {
			idUtente = utenteProfiloBO.getId().getSequIdUtente().intValue();
			fullName =  utenteProfiloBO.getUtente().getPersCognome()+ " " + utenteProfiloBO.getUtente().getPersNome();
			delegatiAttivi.put(idUtente, fullName);
		}
		
		return delegatiAttivi;
	}

	@Override
	public List<UtenteProfiloTO> findDelegheByIdUtente(int utenteId) throws Throwable {
		
		List<UtenteProfiloTO> listaDeleghe =  getDozerDriver().mapList(utenteProfiloDao.loadDelegheByUtenteId(utenteId), UtenteProfiloTO.class, "UtenteProfilo");
		return listaDeleghe;
	}

	@Override
	public List<UtenteProfiloTO> findAllDeleghe() throws Throwable {
		List<UtenteProfiloTO> listaDeleghe =  getDozerDriver().mapList(utenteProfiloDao.loadDeleghe(), UtenteProfiloTO.class, "UtenteProfilo");
		return listaDeleghe;
	}

	@Override
	public void deleteDelega(UtenteProfiloTOId delega) throws Throwable {
		
		UtenteProfiloBOId delegaToDelete = getDozerDriver().map(delega, UtenteProfiloBOId.class, "UtenteProfilo");
		utenteProfiloDao.delete(utenteProfiloDao.loadById(UtenteProfiloBO.class, delegaToDelete));
	}

	@Override
	public List<UtenteProfiloTO> findByUtenteProfiloFlagDelega(int idUtente, int idProfilo, int flagDelega01) throws Throwable {
		
		List<UtenteProfiloTO> listaUtenteProfiloTO =  getDozerDriver().mapList(utenteProfiloDao.findByUtenteProfiloFlagDelega(idUtente, idProfilo, flagDelega01), UtenteProfiloTO.class, "UtenteProfilo");
		return listaUtenteProfiloTO;
	}



	@Override
	public List<UtenteProfiloTO> findByProfiloUfficioFlagDelega(BigDecimal idProfilo, String idUfficio, int flagDelega01) throws Throwable {
		List<UtenteProfiloTO> listaUtenteProfiloTO =  getDozerDriver().mapList(utenteProfiloDao.findByProfiloUfficioFlagDelega(idProfilo, idUfficio, flagDelega01), UtenteProfiloTO.class, "UtenteProfilo");
		return listaUtenteProfiloTO;
	}
	

}
