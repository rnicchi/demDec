package it.mef.bilancio.demdec.manager.impl;

import it.mef.bilancio.demdec.dao.VBilDecretiDao;
import it.mef.bilancio.demdec.manager.VBilDecretiManager;

import org.springframework.beans.factory.annotation.Autowired;
//


public class VBilDecretiManagerImpl extends AbstractDemManagerImpl implements	VBilDecretiManager {
	
	@Autowired
	private VBilDecretiDao vBilDecretiDao;
	
	@Override
	public String findGuidSiPatrBynumPatr(Integer numPatr, Integer annoDec){
		
		return vBilDecretiDao.findGuidSiPatrBynumPatr(numPatr, annoDec);
		
	}
	
}
