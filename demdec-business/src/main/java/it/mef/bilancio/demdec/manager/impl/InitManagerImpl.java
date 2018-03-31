package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.EserciziDemBO;
import it.almavivaitalia.bilancio.commons.dao.EserciziDao;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.commons.crystal.utils.CrystalConstants;
import it.mef.bilancio.demdec.crystal.CrystalReport;
import it.mef.bilancio.demdec.manager.InitManager;

import java.util.List;

import com.crystaldecisions.sdk.framework.CrystalEnterprise;
import com.crystaldecisions.sdk.framework.IEnterpriseSession;
import com.crystaldecisions.sdk.framework.ISessionMgr;
import com.crystaldecisions.sdk.framework.ITrustedPrincipal;
import com.crystaldecisions.sdk.occa.infostore.IInfoStore;
import com.crystaldecisions.sdk.occa.managedreports.IReportAppFactory;
import com.crystaldecisions.sdk.occa.security.ILogonTokenMgr;



public class InitManagerImpl extends AbstractDemManagerImpl implements InitManager {
     
	private EserciziDao eserciziDao;

	public void setEserciziDao(EserciziDao eserciziDao) {
		this.eserciziDao = eserciziDao;
	}

	@Override
	public List<EserciziTO> loadEsercizi() throws Throwable {
		
		List<EserciziDemBO> lista= eserciziDao.loadEsercizi();
		List<EserciziTO> listaTO=null;

		if(lista!=null){
			listaTO=getDozerDriver().mapList(lista, EserciziTO.class, "Esercizi");
		}		
		
		return listaTO;
	}
	
	@Override
	public CrystalReport initCrystalReport(String userName, String cmsName, String cmsSecret) throws Throwable {
		CrystalReport crystalReport=new CrystalReport();
		
		//CRYSTAL REPORT OBJECTS------------------------------------------------------------------------------->
		IEnterpriseSession enterpriseSession = null;

		ISessionMgr sessionMgr = CrystalEnterprise.getSessionMgr();
			ITrustedPrincipal trustedPrincipal = sessionMgr.createTrustedPrincipal(userName,cmsName,cmsSecret);
			// Attempt logon.
			enterpriseSession = sessionMgr.logon(trustedPrincipal);
			// If the login failed, redirect the user to the logon page.					
			// Store the IEnterpriseSession object in the session.
			crystalReport.setEnterpriseSession(enterpriseSession);
			// Create the IInfoStore object.
			IInfoStore iStore = (IInfoStore) enterpriseSession.getService(CrystalConstants.INFO_STORE);
			// Store the IInfoStore object in the session using the helper
			// functions.
			crystalReport.setiStore(iStore);
			// Retrieve the logon token manager.
			ILogonTokenMgr logonTokenMgr = enterpriseSession.getLogonTokenMgr();
			crystalReport.setLogonTokenMgr(logonTokenMgr);
			
			IReportAppFactory reportAppFactory = (IReportAppFactory) enterpriseSession.getService(CrystalConstants.RAS_REPORT_FACTORY);
			crystalReport.setReportAppFactory(reportAppFactory);
		//CRYSTAL REPORT OBJECTS------------------------------------------------------------------------------->

		return crystalReport;
	}
	
}
