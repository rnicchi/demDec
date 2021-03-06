package it.mef.bilancio.demdec.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiBOId;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.IterFirmaDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.SospesiRedBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBO;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.web.sh.utils.Util;
import it.mef.bilancio.demdec.dao.DocumentiDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.dao.IterFirmaDecretoDao;
import it.mef.bilancio.demdec.dao.SospesoRedDao;
import it.mef.bilancio.demdec.dao.SottoFascicoliRedDao;
import it.mef.bilancio.demdec.manager.IterFirmaDecretoManager;
import it.mef.bilancio.demdec.to.DocumentiViewTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;
import it.mef.bilancio.demdec.utils.Constants;



public class IterFirmaDecretoManagerImpl extends AbstractDemManagerImpl implements IterFirmaDecretoManager {
	
	@Autowired
	private IterFirmaDecretoDao iterFirmaDecretoDao;
	
	@Autowired
	private FascicoloDao fascicoloDao;
	
	@Autowired
	private DocumentiDao documentiDao;
	
	@Autowired
	private SottoFascicoliRedDao sottoFascicoliRedDao;
	
	@Autowired
	private SospesoRedDao sospesoRedDao;
	
	@Autowired
	private CronologicoManager cronologicoManager;


	/**
	 * Viene aggiornato il campo STAT_FIRMA della tabella D_ITER_FIRMA con uno dei seguenti valori e lo stato del fascicolo e del documento nel caso in cui non ci siano firmatari successivi
	 * vine settato a 4 "FIRMATO" 
	 * DA_FIRMARE = "0" - ststo iter firma decreto
	 * IN_FIRMA = "1" - ststo iter firma decreto
	 * FIRMATO = "2" - ststo iter firma decreto
	 * @return IterFirmaDecretoTO nel caso in cui ci sia un firmatario successivo altrimenti l'iter di firma � concluso
	 */
	@Override
	public IterFirmaDecretoTO updateIterFirma(DocumentiViewTO to, Short croTransTo) throws Throwable {
		
		IterFirmaDecretoBO nextIFD= null;
			IterFirmaDecretoBO currentIFD = iterFirmaDecretoDao.getCurrentIFDByIdFascicolo(to.getNumeIdFascicolo());
			IterFirmaDecretoBO currentIFDOld = (IterFirmaDecretoBO) Util.copyBean(currentIFD);
			
			if(currentIFD != null){
				currentIFD.setRowUpdatedDttm(to.getRowUpdatedDttm());
				currentIFD.setRowUpdatedForm(to.getRowUpdatedForm());
				currentIFD.setRowUpdatedUser(to.getRowUpdatedUser());
				currentIFD.setStatFirma(Constants.STATO_FIRMA_FIRMATO);
				iterFirmaDecretoDao.saveOrUpdate(currentIFD);
				
				nextIFD = iterFirmaDecretoDao.getNextIFDByIdFascicoloAndNumeOrderIter(currentIFD.getFascicoli().getId(), currentIFD.getId().getNumeOrdineFirma()+1);
				
				if(nextIFD != null){
					nextIFD.setRowUpdatedDttm(to.getRowUpdatedDttm());
					nextIFD.setRowUpdatedForm(to.getRowUpdatedForm());
					nextIFD.setRowUpdatedUser(to.getRowUpdatedUser());
					nextIFD.setStatFirma(Constants.STATO_FIRMA_IN_FIRMA);
					iterFirmaDecretoDao.saveOrUpdate(nextIFD);
					
					return getDozerDriver().map(nextIFD, IterFirmaDecretoTO.class, "IterFirmaDecreto");
				}else{
					//operazini che vengono eseguite nel caso in cui non ci sia un firmatario successivo
					List<SottoFascicoliRedBO> sottofascicoli = sottoFascicoliRedDao.findByNumeIdFascicolo(to.getNumeIdFascicolo());
					
					for (SottoFascicoliRedBO sottoFascicoliRedBO : sottofascicoli) {
						
						SospesiRedBO sospesoRedEsistente = sospesoRedDao.loadById(sottoFascicoliRedBO.getId().getCodiIdRed());
						if(sospesoRedEsistente == null){
							SospesiRedBO sospesoRed = new SospesiRedBO(sottoFascicoliRedBO.getCodiGuidSFascicolo(), sottoFascicoliRedBO.getId().getCodiIdRed(), Constants.SOSPESI_RED_CHIUSURA, null);
							sospesoRed.setCodiAooProtocollo(sottoFascicoliRedBO.getCodiAooProtocollo());
							sospesoRed.setNumeProtocollo(sottoFascicoliRedBO.getNumeProtocollo());
							sospesoRed.setDescTipoProtocollo(sottoFascicoliRedBO.getDescTipoProtocollo());
							sospesoRed.setDataProtocollo(sottoFascicoliRedBO.getDataProtocollo());
							sospesoRed.setStatEsito("0");
							copyAllAudit(to, sospesoRed);
							sospesoRedDao.saveOrUpdate(sospesoRed);
						}else{
							if(sospesoRedEsistente.getStatEsito() == null){
								sospesoRedEsistente.setStatEsito("0");
								copyAllAudit(to, sospesoRedEsistente);
								sospesoRedDao.saveOrUpdate(sospesoRedEsistente);
							}
						}
					}
					FascicoliBO fdao = fascicoloDao.loadById(to.getNumeIdFascicolo());
					fdao.setStatStato(Constants.STATO_FASCICOLO_FIRMATO);
					copyAllAudit(to, fdao);
					fascicoloDao.saveOrUpdate(fdao);
					
					DocumentiBOId boId = new DocumentiBOId(to.getNumeIdFascicolo(), to.getNumeIdDocumento().longValue());
					DocumentiBO dbo = documentiDao.loadById(DocumentiBO.class, boId);
					dbo.setStatDocumento(Constants.STATO_DOCUMENTO_FIRMATO);
					copyAllAudit(to, dbo);
					documentiDao.saveOrUpdate(dbo);
				}
				cronologicoManager.salvaCronologico(currentIFDOld, currentIFD, null, null, croTransTo, to.getRowUpdatedForm(), to.getRowUpdatedUser());
			}
		return null;
	}

	
	/**
	 * Viene aggiornato il campo STAT_FIRMA della tabella D_ITER_FIRMA con il valore IN_FIRMA = "1" 
	 *
	 * @return  IterFirmaDecretoTO con la quale si verifica se esiste un firmatario successivo o se (nel caso in cui la lista sia vuta ) l'iter di firma � concluso
	 */
	@Override
	public IterFirmaDecretoTO updateIterFirmaInFirma(DocumentiViewTO to) throws Throwable {
		
	
			IterFirmaDecretoBO currentIFD =  iterFirmaDecretoDao.getCurrentIFDByIdFascicolo(to.getNumeIdFascicolo());
			if(currentIFD != null){
				currentIFD.setRowUpdatedDttm(to.getRowUpdatedDttm());
				currentIFD.setRowUpdatedForm(to.getRowUpdatedForm());
				currentIFD.setRowUpdatedUser(to.getRowUpdatedUser());
				currentIFD.setStatFirma(Constants.STATO_FIRMA_IN_FIRMA);
				iterFirmaDecretoDao.saveOrUpdate(currentIFD);
				
			}
		return getDozerDriver().map(currentIFD, IterFirmaDecretoTO.class, "IterFirmaDecreto");
	}


	@Override
	public String findStatoIterFirmaDecretoByIdFascicolo(Integer idFascicolo) throws Throwable {


		String risultato = iterFirmaDecretoDao.findStatoIterFirmaDecretoByIdFascicolo(idFascicolo);
		
		return risultato;
	}

	
}
