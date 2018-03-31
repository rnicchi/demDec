package it.mef.bilancio.demdec.dao;

import it.mef.bilancio.demdec.to.RiepilogoAdDemTO;
import it.mef.bilancio.demdec.to.StrumentoTO;

import java.util.List;

public interface RiepilogoAdDemDao extends AbstractDemDao<RiepilogoAdDemTO>{

	List<RiepilogoAdDemTO> findRiepilogoAdDemByAnnoTipoNum(Short annoEse, String tipo,Integer num) throws Throwable;
	
	StrumentoTO findLeggeByRiepilogoAdDem(String eseAnnoEse, String attNumeTipo, String numeNum);

}
