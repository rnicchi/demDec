package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.utils.Constants;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public abstract class FascicoloParentDaoImpl  extends AbstractDemDaoImpl<FascicoliBO>   {

	

	public FascicoloParentDaoImpl(Class<FascicoliBO> class1) {
		super(FascicoliBO.class);
	}

	@SuppressWarnings("unchecked")
	public List<FascicoliBO> findFascicoliFadLetterePreReg(FascicoliFadSearhTO to)
			throws Throwable {
		
		Criteria cri = getSession().createCriteria(FascicoliBO.class);
		cri.add(Restrictions.eq("eserciziDem.id", to.getAnnoDecreto()));
		addCreateEq(cri,"anagTipoDecreto.id", to.getTipoDecreto());
		addCreateEq(cri,"numeNumDecreto", to.getNumeDecreto());
		addCreateEq(cri,"anagTipologiaDecreto.id", to.getTipologiaDecreto());
		addCreateEq(cri, "ufficioCapofila.id", to.getUfficio());
		//addCreateEq(cri,"numePatrimonio", to.getNumePat());
		cri.add(Restrictions.isNull("numePatrimonio"));
		
		//Integer[] arrayInteger={2,4,6};  
		Integer[] arrayInteger={Constants.STATO_FASCICOLO_IN_FIRMA, Constants.STATO_FASCICOLO_FIRMATO, Constants.STATO_FASCICOLO_6};  
		
		cri.add(Restrictions.in("statStato", arrayInteger));
	//	addCreateEq(cri, "statStato", to.getStato());
		addCreate(cri,"dataCreazioneFascicolo", to.getDataArrivoDa(),"ge");
		addCreate(cri,"dataCreazioneFascicolo", to.getDataArrivoA(),"le");
		addCreateEq(cri,"flagVisibilitaCdc01", to.getFlagVisibilitaCdc01());
		
		if (to.getNumeStp()!=null){
			cri.createCriteria("anagAmminDemList")
			    .add(Restrictions.eq("id.fkAnnoEse", to.getAnnoDecreto()))
			    .add(Restrictions.eq("id.numeStp", to.getNumeStp()))
			    .add(Restrictions.eq("id.numeApp", to.getNumeApp()));
		}
		
		// AGGIUNGO ORDINAMENTO LISTA
		cri.addOrder(Order.desc("eserciziDem.id"))
			.addOrder(Order.asc("numeNumDecreto"))
			.addOrder(Order.asc("anagTipoDecreto.id"));
		
		return cri.list();
	}
	
}
