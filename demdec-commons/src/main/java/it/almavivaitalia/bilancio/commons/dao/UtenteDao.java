package it.almavivaitalia.bilancio.commons.dao;


import java.util.List;

import it.almavivaitalia.bilancio.commons.bo.UtenteBO;
import it.almavivaitalia.bilancio.commons.bo.UtenteProfiloBO;
import it.almavivaitalia.bilancio.commons.to.EmailUtenteTO;

public interface UtenteDao extends AbstractCommonDao{

	public List<UtenteBO> loadAll();
	
	public List<UtenteBO> loadAllOrdById();
	
	public List<UtenteBO> loadAllOrdByCodiUtente();
	
	public UtenteBO saveOrUpdate(UtenteBO o);
	
	public UtenteBO loadByPrimaryKey(Long id);
	
	public UtenteBO loadByCodiUtente(String codi)throws Throwable ;
	
	public Short loadAnnoEse(String statTipoEse) throws Throwable ;

	public List<String> findEmailSignatoryNextByStatFirmaAndIdFascicolo(
			String statFirma, Long idFascicolo) throws Throwable;
	
	public List<EmailUtenteTO> findEmailUserPecRichSospensioneByIdFascicolo(Long idFascicolo) throws Throwable;

	public UtenteBO loadByCodiUtenteNsbf(String codi) throws Throwable;

	public String findDeencryptedPinbyId(Integer id) throws Throwable;

	public Integer newId();

	void deleteProfili(UtenteBO utenteBo) throws Throwable;
	void insertProfili(UtenteBO utenteBo, List<UtenteProfiloBO> lista) throws Throwable;
	void delete(String codiUtente) throws Throwable;

	public List<EmailUtenteTO> findEmailUserFlgPecStatIdFasc(String statFirma, Long idFascicolo) throws Throwable;
}
