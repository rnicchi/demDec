/**
 * 
 */
package it.mef.bilancio.demdec.dao.impl;


import it.almavivaitalia.bilancio.commons.bo.AnagTipoDecretoBO;
import it.mef.bilancio.demdec.dao.AnagTipoDecretoDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;



/**
 * @author utente
 *
 */
public class AnagTipoDecretoDaoImpl  extends AbstractDemDaoImpl<AnagTipoDecretoBO> implements AnagTipoDecretoDao{
	

	AnagTipoDecretoDaoImpl() {
		super(AnagTipoDecretoBO.class);
	}
	@SuppressWarnings("unchecked")
	public List<AnagTipoDecretoBO> loadAnagTipoDecreto() {

			String q="FROM AnagTipoDecretoBO";
			Query query = createQuery(q);
			return(List<AnagTipoDecretoBO>)query.list();
			 
	
	}
	
	
	
	public AnagTipoDecretoBO loadAnagTipoDecretoById(Integer id) {
		
			Criteria cri = getSession().createCriteria(AnagTipoDecretoBO.class);
			cri.add(Restrictions.eq("id", id));
			
			return(AnagTipoDecretoBO)cri.uniqueResult();
	
	}
	
	
	
	
	
	
}
