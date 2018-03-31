package it.almavivaitalia.bilancio.commons.manager;



import java.util.List;

import it.almavivaitalia.bilancio.commons.to.EmailUtenteTO;
import it.almavivaitalia.bilancio.commons.to.UserInfoTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.bsn.sh.manager.AbstractManager;

 public interface UtenteManager extends AbstractManager{

	UserInfoTO loadUserInfo(UserInfoTO userInfoTO) throws Throwable;
	String getSystemDate() throws Throwable;
	Short loadAnnoEse(String statTipoEse) throws Throwable;
	UtenteTO loadByCodiUtente(String codi) throws Throwable;
	List<String> findEmailSignatoryNextByStatFirmaAndIdFascicolo(String statFirma, Long idFascicolo) throws Throwable;
	UtenteTO loadByCodiUtenteNsbf(String codi) throws Throwable;
	void saveUserPin(Integer id, String pin) throws Throwable;
	String findDeencryptedPinbyId(Integer id) throws Throwable;
	Boolean checkCodFiscaleUtente(Integer id, String cf) throws Throwable;
	List<EmailUtenteTO> findEmailUserFlgPecStatIdFasc(String statFirma,Long idFascicolo) throws Throwable;
	UtenteTO loadById(Integer idUtente) throws Throwable;
	
}
