package it.mef.bilancio.demdec.manager;

import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.mef.bilancio.demdec.crystal.CrystalReport;

import java.util.List;


public interface InitManager extends AbstractDemManager {
	public List<EserciziTO> loadEsercizi() throws Throwable;
	public CrystalReport initCrystalReport(String userName, String cmsName, String cmsSecret) throws Throwable;

}