package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBOId;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBOId;
import it.almavivaitalia.bilancio.commons.bo.DescDocumentoBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBOId;
import it.almavivaitalia.bilancio.commons.bo.EserciziDemBO;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBOId;
import it.almavivaitalia.bilancio.commons.bo.TipoDocumentoBO;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bsn.sh.utils.DateUtil;
import it.mef.bilancio.demdec.dao.AnagAmminDemDao;
import it.mef.bilancio.demdec.dao.AnagRagionerieDemDao;
import it.mef.bilancio.demdec.dao.AnagTipoDecretoDao;
import it.mef.bilancio.demdec.dao.DocumentiRedDao;
import it.mef.bilancio.demdec.dao.FascicoloDao;
import it.mef.bilancio.demdec.dao.RiepilogoAdDemDao;
import it.mef.bilancio.demdec.dao.SottoFascicoliRedDao;
import it.mef.bilancio.demdec.manager.RicercaRedManager;
import it.mef.bilancio.demdec.manager.RiepilogoAdDemManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.FascicoliViewTO;
import it.mef.bilancio.demdec.to.InvioFadTO;
import it.mef.bilancio.demdec.to.RicercaRedTO;
import it.mef.bilancio.demdec.to.RiepilogoAdDemTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;
import it.mef.bilancio.demdec.to.StrumentoTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public class RiepilogoAdDemManagerImpl extends AbstractDemManagerImpl implements RiepilogoAdDemManager{
	
		@Autowired
		private RiepilogoAdDemDao riepilogoAdDemDao;
		
		@Override
		public List<RiepilogoAdDemTO> findRiepilogoAdDemByAnnoTipoNum(Short annoEse, String tipo,Integer num) throws Throwable {
			List<RiepilogoAdDemTO> listBO=riepilogoAdDemDao.findRiepilogoAdDemByAnnoTipoNum(annoEse, tipo, num);
			return listBO;
		}

		@Override
		public StrumentoTO findLeggeByRiepilogoAdDem(String eseAnnoEse, String attNumeTipo, String numeNum) throws Throwable {
				StrumentoTO to = riepilogoAdDemDao.findLeggeByRiepilogoAdDem(eseAnnoEse, attNumeTipo, numeNum);
					return to;
		}
		 
		 
	 
}
