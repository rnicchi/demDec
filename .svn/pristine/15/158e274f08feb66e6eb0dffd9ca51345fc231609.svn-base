/**
 * 
 */
package it.mef.bilancio.demdec.dao.impl;



import it.almavivaitalia.bilancio.commons.bo.EserciziDemBO;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.mef.bilancio.demdec.dao.EserciziDemDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

/**
 * @author utente
 *
 */

public class EserciziDemDaoImpl extends AbstractDemDaoImpl<EserciziDemBO> implements EserciziDemDao{
	
	
	@SuppressWarnings("unchecked")
	public List<EserciziDemBO> loadEserciziDemCG() throws Throwable {
		Query query=createQuery("from EserciziDemBO where statTipoEse in ('C','G') order by id desc");
		
		List<EserciziDemBO> list=query.list(); 
		return list;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<EserciziTO> loadEserciziDemCG_old() throws Throwable {
		Query query=createQuery("from EserciziDemBO where statTipoEse in ('C','G') order by id desc");
		
		List<EserciziDemBO> list=query.list(); 
		List<EserciziTO> listaTO=new ArrayList<EserciziTO>();
		
		Iterator<EserciziDemBO> iter=list.iterator();
		EserciziTO to=null;
		EserciziDemBO bo=null;
		
		while (iter.hasNext()) {
			to=new EserciziTO();
			
			bo=(EserciziDemBO)iter.next();
			
			to.setId( bo.getId());
			listaTO.add(to);
		}
		
		return listaTO;
	}

}
