/**
 * 
 */
package it.mef.bilancio.demdec.dao.impl;


import it.almavivaitalia.bilancio.commons.bo.AnagTipoRiepilogoBO;
//import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaDecretoBO;
import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaTagliaBO;
import it.mef.bilancio.demdec.dao.AnagTipoRiepilogoDao;
//import it.mef.bilancio.demdec.dao.AnagTipologiaDecretoDao;
import it.mef.bilancio.demdec.dao.AnagTipologiaTagliaDao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;



/**
 * @author utente
 *
 */
public class AnagTipoRiepilogoDaoImpl  extends AbstractDemDaoImpl<AnagTipoRiepilogoBO> implements AnagTipoRiepilogoDao {
	

	AnagTipoRiepilogoDaoImpl() {
		super(AnagTipoRiepilogoBO.class);
	}

	
	

	
	@Override
	public List<AnagTipoRiepilogoBO> loadAnagTipoRiepilogo() {

		return getHibernateTemplate().loadAll(AnagTipoRiepilogoBO.class);
	}
	
	@Override
	public AnagTipoRiepilogoBO loadTipoRiepilogoByDesc(String descTipo) {
		
		return (AnagTipoRiepilogoBO)findUniqueByNamedParam("select o from AnagTipoRiepilogoBO o where o.descTipoRiepilogo=:descTipo", "descTipo", descTipo);

	}


	
}
