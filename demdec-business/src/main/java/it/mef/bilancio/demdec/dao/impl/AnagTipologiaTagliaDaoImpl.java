/**
 * 
 */
package it.mef.bilancio.demdec.dao.impl;


import it.almavivaitalia.bilancio.commons.bo.AnagTipoRiepilogoBO;
//import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaTagliaBO;
//import it.mef.bilancio.demdec.dao.AnagTipologiaDecretoDao;
import it.mef.bilancio.demdec.dao.AnagTipologiaTagliaDao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;



/**
 * @author utente
 *
 */
public class AnagTipologiaTagliaDaoImpl  extends AbstractDemDaoImpl<AnagTipologiaTagliaBO> implements AnagTipologiaTagliaDao {
	

	AnagTipologiaTagliaDaoImpl() {
		super(AnagTipologiaTagliaBO.class);
	}

	
	
	

	@Override
	public List<AnagTipologiaTagliaBO> loadAnagTipologiaTaglia() {

		return getHibernateTemplate().loadAll(AnagTipologiaTagliaBO.class);
	}
	


	
}
