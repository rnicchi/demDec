package it.mef.bilancio.demdec.manager.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bilancio.commons.bo.AnagFirmatariBO;
import it.mef.bilancio.demdec.dao.AnagFirmatariDao;
import it.mef.bilancio.demdec.manager.AttivazioneMailManager;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;

public class AttivazioneMailManagerImpl extends AbstractDemManagerImpl implements AttivazioneMailManager	{
	
	@Autowired
	private AnagFirmatariDao  anagFirmatariDao;
	
	
	
	@Override
	public List<AnagFirmatariTO> loadDestinatariMail(Integer flag)  throws Throwable {
		
		return getDozerDriver().mapList(anagFirmatariDao.loadDestinatariMail(flag) ,AnagFirmatariTO.class,"AnagFirmatari");
	}
	
	
	
	@Override
	public void modificaAbilitazioneMail(AnagFirmatariTO to,Integer flag)  throws Throwable {
		
		AnagFirmatariBO bo= getDozerDriver().map( to,AnagFirmatariBO.class,"AnagFirmatari");
		bo.setFlagAbilitaMail01(flag);
		anagFirmatariDao.saveOrUpdate(bo);
	}
}
