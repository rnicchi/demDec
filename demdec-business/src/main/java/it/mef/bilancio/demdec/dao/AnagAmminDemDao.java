/**
 * 
 */
package it.mef.bilancio.demdec.dao;


import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;

import java.util.List;

/**
 * @author utente
 *
 */
public interface AnagAmminDemDao extends AbstractDemDao<AnagAmminDemBO> {
	
	public List<AnagAmminDemBO> getAmminDemByAnnoEse(String annoEse) throws Throwable ;

	List<AnagAmminDemBO> getAmminDemCentraliByAnnoEse(String annoEse)
			throws Throwable;

	List<AnagAmminDemBO> getAmminDemByAnnoEseUtenteAndProfilo(String annoEse, String idUtente, String idProfilo) throws Throwable;

	List<AnagAmminDemTO> findAmministrazioniByIdFascicolo(Long idFascicolo) throws Throwable;

}
