package it.mef.bilancio.demdec.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


//import edu.emory.mathcs.backport.java.util.Collections;
import it.almavivaitalia.bilancio.commons.bo.AbstractCommonBO;
import it.almavivaitalia.bilancio.commons.bo.AnagModelliIterBO;
import it.almavivaitalia.bilancio.commons.bo.AnagTipoDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaDecretoBO;
import it.mef.bilancio.demdec.dao.AnagModelliIterDao;
import it.mef.bilancio.demdec.dao.AnagTipoDecretoDao;
import it.mef.bilancio.demdec.dao.AnagTipologiaDecretoDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.manager.GestioneTipologiaDecretoManager;
import it.mef.bilancio.demdec.to.AnagModelliIterTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import static it.almavivaitalia.bilancio.commons.to.CroTransTO.*;


public class GestioneTipologiaDecretoManagerImpl extends AbstractDemManagerImpl
		implements GestioneTipologiaDecretoManager {

	@Autowired
	private AnagTipologiaDecretoDao anagTipologiaDecretoDao;
	@Autowired
	private AnagTipoDecretoDao anagTipoDecretoDao;
	@Autowired
	private AnagModelliIterDao anagModelliIterDao;
	@Autowired
	private FascicoloDao fascicoloDao;
	@Autowired
	private CronologicoManager cronologicoManager;

	@Override
	public List<AnagTipologiaDecretoTO> elencoTipologiaDecreto()
			throws Throwable {

		List<AnagTipologiaDecretoBO> listaBO = anagTipologiaDecretoDao.loadAnagTipologiaDecreto();
		List<AnagTipologiaDecretoTO> listaTO = new ArrayList<AnagTipologiaDecretoTO>();
		AnagTipoDecretoTO tipoDecrTo=null;
		for (AnagTipologiaDecretoBO bo: listaBO){
			tipoDecrTo=new AnagTipoDecretoTO(bo.getAnagTipoDecreto().getId().toString());
		
			tipoDecrTo.setDescSigla(bo.getAnagTipoDecreto().getDescSigla());
			
			listaTO.add(new AnagTipologiaDecretoTO(bo.getId(),
													new AnagModelliIterTO(bo.getAnagModelliIter().getId(), bo.getAnagModelliIter().getDescIter()),
													tipoDecrTo,
													bo.getDescTipologia()
												  )
			);
		}

		Collections.sort(listaTO, new Comparator<AnagTipologiaDecretoTO>() {

			//@Override
//			public int compare(AnagTipologiaDecretoTO o1, AnagTipologiaDecretoTO o2) {
//				return o1.getAnagModelliIter().getId() - 
//						o2.getAnagModelliIter().getId();
//			}
			
			 @Override
			 public int compare(AnagTipologiaDecretoTO o1, AnagTipologiaDecretoTO o2) {
			        return o1.getDescTipologia().compareToIgnoreCase(o2.getDescTipologia());
			    }

			
		});

		return listaTO;
	}


	@Override
	public List<AnagTipoDecretoTO> elencoTipoDecreto()
			throws Throwable {
		
		List<AnagTipoDecretoBO> listaBO = anagTipoDecretoDao.loadAnagTipoDecreto();

		return
				getDozerDriver().mapList(listaBO, AnagTipoDecretoTO.class, "AnagTipoDecreto");
		
	}

	@Override
	public List<AnagModelliIterTO> elencoModelliIter()
			throws Throwable {
		
		List<AnagModelliIterBO> listaBO = anagModelliIterDao.loadAnagModelliIter();

		return
				getDozerDriver().mapList(listaBO, AnagModelliIterTO.class, "AnagModelliIter");
		
	}

	@Override
	public boolean creaDecretoTipologia(AnagTipologiaDecretoTO anagTipologiaDecretoTO) throws Throwable {

		AnagTipologiaDecretoBO tipologiaDecretoBO = anagTipologiaDecretoDao.findAnagTipologiaDecretoByDesc(anagTipologiaDecretoTO.getDescTipologia());
		if (tipologiaDecretoBO != null) return false;

		AnagModelliIterBO anagModelliIter = anagModelliIterDao.loadById(AnagModelliIterBO.class, anagTipologiaDecretoTO.getAnagModelliIter().getId());
		AnagTipoDecretoBO anagTipoDecreto = anagTipoDecretoDao.loadAnagTipoDecretoById(Integer.valueOf(anagTipologiaDecretoTO.getAnagTipoDecreto().getId()));

		AnagTipologiaDecretoBO anagTipologiaDecretoBO = 
				new AnagTipologiaDecretoBO(
						null, 
						anagModelliIter, 
						anagTipoDecreto, 
						anagTipologiaDecretoTO.getDescTipologia())
		;
		copyAllAudit(anagTipologiaDecretoTO, anagTipologiaDecretoBO);

		anagTipologiaDecretoDao.saveTipologiaDecreto(anagTipologiaDecretoBO);
		salvaNelCronologico(CRO_TRANS_INSERIMENTO_TIPOLOGIA_DECRETO, null, anagTipologiaDecretoBO);

		return true;
	}

	@Override
	public boolean eliminaDecretoTipologia(Integer idAnagTipologiaDecreto) throws Throwable {

		if (fascicoloDao.findFascicoliByTipologiaDecreto(idAnagTipologiaDecreto).size()>0) 
				return false;

		AnagTipologiaDecretoBO anagTipologiaDecretoBO = anagTipologiaDecretoDao.loadById(idAnagTipologiaDecreto);
		anagTipologiaDecretoDao.deleteTipologiaDecreto(anagTipologiaDecretoBO);
		salvaNelCronologico(CRO_TRANS_CANCELLAZIONE_TIPOLOGIA_DECRETO, anagTipologiaDecretoBO, null);
		return true;
	}

	@Override
	public void modificaDecretoTipologia(AnagTipologiaDecretoTO anagTipologiaDecretoTO) throws Throwable {

		AnagTipologiaDecretoBO anagTipologiaDecretoBO = anagTipologiaDecretoDao.loadById(anagTipologiaDecretoTO.getId());

		//solo 2 possibili variazioni: desc tipologia e tipo Modello Iter
		if (anagTipologiaDecretoBO != null) {
			//AnagTipologiaDecretoBO origAnagTipologiaDecretoBO = getDozerDriver().map(anagTipologiaDecretoBO, AnagTipologiaDecretoBO.class, "AnagTipologiaDecreto");
			
			anagTipologiaDecretoBO.setDescTipologia(anagTipologiaDecretoTO.getDescTipologia());

			AnagModelliIterBO anagModelliIter = anagModelliIterDao.loadById(anagTipologiaDecretoTO.getAnagModelliIter().getId());
			anagTipologiaDecretoBO.setAnagModelliIter(anagModelliIter);
			
			AnagTipoDecretoBO anagTipoDecreto=anagTipoDecretoDao.loadById(new Integer(anagTipologiaDecretoTO.getAnagTipoDecreto().getId()));
			anagTipologiaDecretoBO.setAnagTipoDecreto(anagTipoDecreto);

			copyAudit(anagTipologiaDecretoTO, anagTipologiaDecretoBO);

			anagTipologiaDecretoDao.updateTipologiaDecreto(anagTipologiaDecretoBO);
			salvaNelCronologico(CRO_TRANS_MODIFICA_TIPOLOGIA_DECRETO, null, anagTipologiaDecretoBO);
		}
	}
	
	@Override
	public List<AnagTipologiaDecretoTO> loadTipologieDecretoByIter(short idIter) throws Throwable {

		return	getDozerDriver().mapList(anagTipologiaDecretoDao.loadAnagTipologiaDecretoByIter(idIter), AnagTipologiaDecretoTO.class, "AnagTipologiaDecreto");
			
	}
	

	//utility per gestire il cronologico
	private void salvaNelCronologico(Short croTrans, AbstractCommonBO oldBo, AbstractCommonBO newBo) throws Throwable {

		String nomeFunzione, codiUtente;
		if ((oldBo != null)) {
			nomeFunzione = oldBo.getRowUpdatedForm() != null ? oldBo.getRowUpdatedForm() : oldBo.getRowCreatedForm();
			codiUtente = oldBo.getRowUpdatedUser() != null ? oldBo.getRowUpdatedUser() : oldBo.getRowCreatedUser();
		}
		else {
			nomeFunzione = newBo.getRowUpdatedForm() != null ? newBo.getRowUpdatedForm() : newBo.getRowCreatedForm();
			codiUtente = newBo.getRowUpdatedUser() != null ? newBo.getRowUpdatedUser() : newBo.getRowCreatedUser();
		}
		
		cronologicoManager.salvaCronologico(oldBo, newBo, null, null, croTrans, nomeFunzione, codiUtente);
	}
}
