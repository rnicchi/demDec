package it.almavivaitalia.bilancio.commons.manager.impl;

import it.almavivaitalia.bilancio.commons.dao.TabServDao;
import it.almavivaitalia.bilancio.commons.manager.AbstractCommonManager;
import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;
import it.almavivaitalia.bsn.sh.bo.AbstractBO;
import it.almavivaitalia.bsn.sh.utils.DozerDriver;

public abstract class AbstractCommonManagerImpl extends it.almavivaitalia.bsn.sh.manager.impl.AbstractManagerImpl implements AbstractCommonManager{
	
	
	private TabServDao tabServDao;
	
	
	public String searchPropertyValueFromTabServ(String propertyName)
			throws Throwable {
		return tabServDao.searchPropertyValueFromTabServ(propertyName);
	}

	public void setTabServDao(TabServDao tabServDao) {
		this.tabServDao = tabServDao;
	}	
	
	private DozerDriver dozerDriver;

	protected DozerDriver getDozerDriver() {
		return dozerDriver;
	}

	public void setDozerDriver(DozerDriver dozerDriver) {
		this.dozerDriver = dozerDriver;
	}
	
	
	public String getSystemDate() throws Throwable {
		return tabServDao.getSysdate();
	}	
	
	protected void copyAudit(AbstractCommonTO source, AbstractBO dest){
			
		if (	dest.getRowCreatedDttm()== null	
				&& dest.getRowCreatedForm() == null
				&& dest.getRowCreatedUser() == null
			)
		{
			
			dest.setRowCreatedDttm(source.getRowCreatedDttm());
			dest.setRowCreatedForm(source.getRowCreatedForm());
			dest.setRowCreatedUser(source.getRowCreatedUser());
			
			dest.setRowUpdatedDttm(null);
			dest.setRowUpdatedForm(null);
			dest.setRowUpdatedUser(null);
					
		}
		else 
		{	
			dest.setRowUpdatedDttm(source.getRowUpdatedDttm());
			dest.setRowUpdatedForm(source.getRowUpdatedForm());
			dest.setRowUpdatedUser(source.getRowUpdatedUser());
			
			
		}
	}
	
	protected void copyAllAudit(AbstractCommonTO source, AbstractBO dest){
		dest.setRowCreatedDttm(source.getRowCreatedDttm());
		dest.setRowCreatedForm(source.getRowCreatedForm());
		dest.setRowCreatedUser(source.getRowCreatedUser());		
		dest.setRowUpdatedDttm(source.getRowUpdatedDttm());
		dest.setRowUpdatedForm(source.getRowUpdatedForm());
		dest.setRowUpdatedUser(source.getRowUpdatedUser());		
	}
	
	protected void copyAllAudit(AbstractBO source, AbstractCommonTO dest){
		dest.setRowCreatedDttm(source.getRowCreatedDttm());
		dest.setRowCreatedForm(source.getRowCreatedForm());
		dest.setRowCreatedUser(source.getRowCreatedUser());		
		dest.setRowUpdatedDttm(source.getRowUpdatedDttm());
		dest.setRowUpdatedForm(source.getRowUpdatedForm());
		dest.setRowUpdatedUser(source.getRowUpdatedUser());		
	}
	
	protected void copyAudit(AbstractBO source, AbstractBO dest){
		
		if (	dest.getRowCreatedDttm()!=null
				&& dest.getRowCreatedForm() != null
				&& dest.getRowCreatedUser() != null
			)
		{
			dest.setRowUpdatedDttm(source.getRowUpdatedDttm());
			dest.setRowUpdatedForm(source.getRowUpdatedForm());
			dest.setRowUpdatedUser(source.getRowUpdatedUser());
		
			dest.setRowUpdatedDttm(null);
			dest.setRowUpdatedForm(null);
			dest.setRowUpdatedUser(null);
		}
		else 
		{
			dest.setRowCreatedDttm(source.getRowCreatedDttm());
			dest.setRowCreatedForm(source.getRowCreatedForm());
			dest.setRowCreatedUser(source.getRowCreatedUser());
		}
	}
	
	// Esempio di come riempire CRODATIBO
		// Con * i Campi Obbligatori
		//
		// * CroDatiBOId id;              Sequence
		// * CroTransBO croTransBO;       Codice Transazione Ins/upd/del tabella D_CRO_TRANS 
		// * VociMenuBO vociMenuBO;       Codice Della Form su D_VOCI_MENU
		//   Short annoEseCap;            Estremi Capitolo
		//   Integer numeStpCap;          Estremi Capitolo
		//   Integer numeAppCap;          Estremi Capitolo
		//   Integer numeEosCap;          Estremi Capitolo
		//   Short numeNumCap;            Estremi Capitolo
		//   Short annoEseAut;            Estremi Autorizzazione 
		//   Integer numeTipoAut;         Estremi Autorizzazione 
		//   Integer numeNumAut;          Estremi Autorizzazione 
		//   Integer numeArtAut;          Estremi Autorizzazione
		//   Integer numeCommaAut;        Estremi Autorizzazione
		//   String codiPuntoAut;         Estremi Autorizzazione
		//   Short annoEseStr;            Estremi Strumento
		//   Integer numeTipoStr;         Estremi Strumento
		//   Integer numeNumStr;          Estremi Strumento
		//   Short annoPrimaiscPar;       Estremi Partite (Opzionale)
		//   Integer numePrimaiscPar;     Estremi Partite (Opzionale)
		//   Short annoEsePar;            Estremi Partite (Opzionale)
		//   Short annoPlPle;             Estremi Provvedimento legisltivo (Opzionale)
		//   Short numePlPle;             Estremi Provvedimento legisltivo (Opzionale)
		// * String descUtente;           NOME UTENTE
		//   String textNote;             NOTE (Opzionale)
		// * Date orarOperaz;             Ora Operazione	
		// * Date dataOperaz;             Data Operazione
		//
		//
		// Esempio di come riempire List<CronoValoriTO>
		// 4 Valori da inserire in loop
		// codice      Codice che deve essere presente dulla D_CRO_CODICI (Rappresenta la descrizione del Campo toccato)
	 	// oldValue    Vecchio Valore del Campo 
		// newValue    Nuovo Valore del Campo
		// numeOrdiVisu Ordine di Visualizzazione nel Cronologico (Ovviamente parte da 1 per il primo e poi si incrementa di 1)
		//
		// NB : in Caso di inserimento il campo oldValue è sempre nulll
		// NB : in Caso di cancellazione il campo newValue è sempre nulll
/*		protected CronoValoriReturnTO inserisciCro(CroDatiBO croDatiBO,List<CronoValoriTO> list) throws Throwable{
			CronoValoriReturnTO rt = new CronoValoriReturnTO();
			// Imposto Valori Di Default Per il Ritorno
			rt.setCodice(0);
			rt.setMessage("");
			// Controllo esistenza codice transazione //		
			CroTransBO bo = croTransDao.existsCroTrans(croDatiBO.getCroTrans().getId());
			if (bo==null){
				// Errore codice Transazione
			  rt.setCodice(1);
			  rt.setMessage("Attenzione il codice transazione per il cronologico non e valido."+""+croDatiBO.getCroTrans().getId());
			}else{
				// Ok codice Transazione
				Integer idCroDati = croDatiDao.getNextSequenceVal();
				CroDatiBOId id = new CroDatiBOId(); 
				id.setCodiId(idCroDati);
				id.setTraCodiCodice(croDatiBO.getCroTrans().getId());
				croDatiBO.setId(id);
				croDatiDao.saveOrUpdate(croDatiBO);
				// Inserimento Valori ...
				Short j = 0;
				for (CronoValoriTO elem : list){
					// controllo esistenza Cro Dati
					j++;
					CroCodiciBO codiciBO = croCodiciDao.existsCodici(elem.getCodice());
					if (codiciBO == null){
						rt.setCodice(1);
						rt.setMessage("Attenzione il codice valore per il cronologico non e valido."+""+elem.getCodice());
					}else{
						CroValoriBO valoriBO = new CroValoriBO();
						CroValoriBOId valoriBOId = new CroValoriBOId();
						valoriBOId.setCrtTraCodiCodice(croDatiBO.getCroTrans().getId());
						valoriBOId.setCrtCodiId(idCroDati);					
						valoriBOId.setCcrCodiCodice((short) elem.getCodice());	
						valoriBOId.setNumeOrdiVisu(elem.getNumeOrdiVisu());
						
						valoriBO.setId(valoriBOId);
						valoriBO.setTextOldVal(elem.getOldValue());
						valoriBO.setTextNewVal(elem.getNewValue());
						
						/* audit */
//						copyAllAudit(elem, valoriBO);
						/* audit */
/*						croValoriDao.saveOrUpdate(valoriBO);
					} // controllo esistenza Cro Dati					
				}	// Chiusura FOR	
			} 	  // Controllo esistenza codice transazione //		
			return rt;
		} // Chiusura Metodo
*/
	
}
