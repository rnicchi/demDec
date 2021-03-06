package it.almavivaitalia.bilancio.commons.manager.impl;

import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.UtenteBO;
import it.almavivaitalia.bilancio.commons.dao.UtenteDao;
import it.almavivaitalia.bilancio.commons.manager.UtenteManager;
import it.almavivaitalia.bilancio.commons.to.EmailUtenteTO;
import it.almavivaitalia.bilancio.commons.to.UserInfoTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;

public class UtenteManagerImpl extends AbstractCommonManagerImpl implements
		UtenteManager {

	private UtenteDao utenteDao;
	public void setUtenteDao(UtenteDao utenteDao) {
		this.utenteDao = utenteDao;
	}


	@Override
	public UserInfoTO loadUserInfo(UserInfoTO userInfoTO) throws Throwable {
		UtenteTO utenteTO = null;
		UtenteBO utente = utenteDao.loadByCodiUtente(userInfoTO.getSecurityTO()
				.getCodiUtenteSbfj());
		if (utente != null) {
			utenteTO = (UtenteTO) getDozerDriver().map(utente, UtenteTO.class,
					"Utente");
			userInfoTO.setUtenteTO(utenteTO);			
		}
		return userInfoTO;
	}



	@Override
	public UtenteTO loadByCodiUtente(String codi) throws Throwable {
		UtenteTO utenteTO = null;
		UtenteBO utente = utenteDao.loadByCodiUtente(codi);
		if (utente != null) {
			utenteTO = (UtenteTO) getDozerDriver().map(utente, UtenteTO.class,
					"Utente");
		}
		return utenteTO;
	}
	
	@Override
	public UtenteTO loadByCodiUtenteNsbf(String codi) throws Throwable {
		UtenteTO utenteTO = null;
		UtenteBO utente = utenteDao.loadByCodiUtenteNsbf(codi);
		if (utente != null) {
			utenteTO = (UtenteTO) getDozerDriver().map(utente, UtenteTO.class,
					"Utente");
		}
		return utenteTO;
	}


	@Override
	public String getSystemDate() throws Throwable {
		String sData;
		sData=utenteDao.getSysdate();
		return sData;
	}
	
	@Override
	public Short loadAnnoEse(String statTipoEse) throws Throwable {
		
		return utenteDao.loadAnnoEse(statTipoEse);
	}


	/**
	 * Il metodo restituisce gli indirizzi e-mail dei firmatari successivi ai quali verr� comunicata la presenza di documenti a loro carico pronti per essere firmati
	 */
	@Override
	public List<String> findEmailSignatoryNextByStatFirmaAndIdFascicolo(
			String statFirma, Long idFascicolo) throws Throwable {
		
		return utenteDao.findEmailSignatoryNextByStatFirmaAndIdFascicolo(statFirma, idFascicolo);
	}
	
	@Override
	public List<EmailUtenteTO> findEmailUserFlgPecStatIdFasc(
			String statFirma, Long idFascicolo) throws Throwable {
		
		return utenteDao.findEmailUserFlgPecStatIdFasc(statFirma, idFascicolo);
	}
	
	
	@Override
	//public void saveUserPin(Integer id , String cf, String pin) throws Throwable {
	public void saveUserPin(Integer id , String pin) throws Throwable {
		
		UtenteBO utente = utenteDao.loadById(UtenteBO.class, id);
		utente.setCodiPinFirma(pin);
		utenteDao.saveOrUpdate(utente);
	}
	
	@Override
	public Boolean checkCodFiscaleUtente(Integer id , String cf) throws Throwable {
		
		UtenteBO utente = utenteDao.loadById(UtenteBO.class, id);
		
		if (cf!=null&& cf.equalsIgnoreCase(utente.getCodiCodiceFiscale())){
			return true;
		}
		return false;
	}
	
	@Override
	public String findDeencryptedPinbyId(Integer id) throws Throwable{
		return utenteDao.findDeencryptedPinbyId(id);
	}


	@Override
	public UtenteTO loadById(Integer idUtente) throws Throwable {
		UtenteTO utenteTO = null;
		UtenteBO utente = utenteDao.loadById(UtenteBO.class, idUtente);
		if (utente != null) {
			utenteTO = (UtenteTO) getDozerDriver().map(utente, UtenteTO.class,
					"Utente");
		}
		return utenteTO;
	}


	
	
	
}
