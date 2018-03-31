package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.LettereTestiPersBO;
import it.almavivaitalia.bilancio.commons.bo.LettereTestiPersBOId;
import it.mef.bilancio.demdec.dao.LettereTestiPersDao;
import it.mef.bilancio.demdec.manager.LettereTestiPersManager;
import it.mef.bilancio.demdec.to.LettereTestiPersTO;
import it.mef.bilancio.demdec.to.LettereTestiTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class LettereTestiPersManagerImpl extends AbstractDemManagerImpl implements LettereTestiPersManager {
	
	@Autowired
	private LettereTestiPersDao lettereTestiPersDao;

	@Override
	public List<LettereTestiPersTO> findTestoPersFasc(Long fkNumeIdFascicolo,
			String codiTipoLettera) throws Throwable {
		List<LettereTestiPersBO> boList = lettereTestiPersDao.findTestoPersFasc(fkNumeIdFascicolo, codiTipoLettera);
		
		return getDozerDriver().mapList(boList, LettereTestiPersTO.class, "LettereTestiPers");
	}
	
	
	@Override
	public List<LettereTestiPersTO> findTestoPersByIdLettera(Long fkSequIdLettera, String codiTipoLettera) throws Throwable {
		List<LettereTestiPersBO> boList = lettereTestiPersDao.findTestoPersByIdLettera(fkSequIdLettera, codiTipoLettera);
		
		return getDozerDriver().mapList(boList, LettereTestiPersTO.class, "LettereTestiPers");
	}
	
	

	@Override
	public List<LettereTestiTO> findActualTestoFasc(Long fkNumeIdFascicolo,
			String codiTipoLettera, String codiSezione) throws Throwable {
		List<LettereTestiTO> boList = lettereTestiPersDao.findActualTestoFasc(fkNumeIdFascicolo, codiTipoLettera, codiSezione);
		return boList;
		//return getDozerDriver().mapList(boList, LettereTestiTO.class, false);
	}
	
	@Override
	public void salvaTestoPers(Long fkNumeIdFascicolo, String codiTipoLettera, String codiSezione, Short numeRiga, String textContenuto, 
			String nomeFunzione, String user) throws Throwable {
		
		List<LettereTestiPersBO> boList = lettereTestiPersDao.findTestoPersFasc(fkNumeIdFascicolo, codiTipoLettera);		
		//attualmente si gestisce un solo record quindi il controllo è basilare, in futuro potrebbero esserci più righe o più sezioni
		LettereTestiPersBO item = null;
		if(boList != null && boList.size() > 0){
			item = boList.get(0);
			
			item.setTextContenuto(textContenuto);
			
			item.setRowUpdatedDttm(new Date());
			item.setRowUpdatedForm(nomeFunzione);
			item.setRowUpdatedUser(user);
			
			lettereTestiPersDao.update(item);
		}else{
			item = new LettereTestiPersBO();
			LettereTestiPersBOId id = new LettereTestiPersBOId();
			id.setCodiSezione(codiSezione);
			id.setCodiTipoLettera(codiTipoLettera);
		//	id.setFkNumeIdFascicolo(fkNumeIdFascicolo);
			id.setNumeRiga(numeRiga);
									
			item.setId(id);
			item.setTextContenuto(textContenuto);
						
			item.setRowCreatedDttm(new Date());
			item.setRowCreatedForm(nomeFunzione);
			item.setRowCreatedUser(user);
			
			lettereTestiPersDao.saveOrUpdate(item);
		}
		
	}
	
	@Override
	public void rimuoviTestoPers(Long fkNumeIdFascicolo, String codiTipoLettera, String codiSezione, Short numeRiga) throws Throwable {
		LettereTestiPersBOId id = new LettereTestiPersBOId();
		id.setCodiSezione(codiSezione);
		id.setCodiTipoLettera(codiTipoLettera);
	//	id.setFkNumeIdFascicolo(fkNumeIdFascicolo);
		id.setNumeRiga(numeRiga);
		
		LettereTestiPersBO item = lettereTestiPersDao.loadById(LettereTestiPersBO.class, id);
		
		lettereTestiPersDao.delete(item);
		
	}

}
