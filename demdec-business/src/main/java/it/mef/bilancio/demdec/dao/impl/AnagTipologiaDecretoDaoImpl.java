/**
 * 
 */
package it.mef.bilancio.demdec.dao.impl;


import it.almavivaitalia.bilancio.commons.bo.AnagTipologiaDecretoBO;
import it.mef.bilancio.demdec.dao.AnagTipologiaDecretoDao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;



/**
 * @author utente
 *
 */
public class AnagTipologiaDecretoDaoImpl  extends AbstractDemDaoImpl<AnagTipologiaDecretoBO> implements AnagTipologiaDecretoDao {
	

	AnagTipologiaDecretoDaoImpl() {
		super(AnagTipologiaDecretoBO.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnagTipologiaDecretoBO> tiplogiaDecretoList(
			Integer codiTipoDecreto) throws Throwable {
		String q="FROM AnagTipologiaDecretoBO where anagTipoDecreto.id = :tipoDec order by descTipologia";
		Query query = createQuery(q);
		query.setInteger("tipoDec", codiTipoDecreto);
		return(List<AnagTipologiaDecretoBO>)query.list();
//		return getSession().createCriteria(AnagTipologiaDecretoBO.class).add(Restrictions.eq( "id", codiTipoDecreto)).list();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AnagTipologiaDecretoBO> tiplogiaDecretoFullList() throws Throwable {
		String q="FROM AnagTipologiaDecretoBO order by descTipologia";
		Query query = createQuery(q);
		
		return(List<AnagTipologiaDecretoBO>)query.list();
//		return getSession().createCriteria(AnagTipologiaDecretoBO.class).add(Restrictions.eq( "id", codiTipoDecreto)).list();

	}

	@Override
	public List<AnagTipologiaDecretoBO> loadAnagTipologiaDecreto() {

		return getHibernateTemplate().loadAll(AnagTipologiaDecretoBO.class);
	}


	@Override
	public AnagTipologiaDecretoBO findAnagTipologiaDecretoByDesc(String descTipologia) {

		AnagTipologiaDecretoBO bo = (AnagTipologiaDecretoBO) 
				getSession().createCriteria(AnagTipologiaDecretoBO.class).add(Restrictions.eq( "descTipologia", descTipologia)).uniqueResult();

		return bo;
	}


	@Override
	public void saveTipologiaDecreto(AnagTipologiaDecretoBO anagTipologiaDecreto) throws Throwable {

		anagTipologiaDecreto.setId((Integer) generaId(AnagTipologiaDecretoBO.class));

		saveOrUpdate(anagTipologiaDecreto);
	}

	@Override
	public void deleteTipologiaDecreto(AnagTipologiaDecretoBO anagTipologiaDecreto) throws Throwable {
		delete(anagTipologiaDecreto);
	}

	@Override
	public void updateTipologiaDecreto(AnagTipologiaDecretoBO anagTipologiaDecreto) throws Throwable {

		update(anagTipologiaDecreto);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AnagTipologiaDecretoBO> loadAnagTipologiaDecretoByIter(short idIter)
			throws Throwable {
        Query q = createQuery("from AnagTipologiaDecretoBO where anagModelliIter.id=:idIter order by descTipologia");
        q.setShort("idIter", idIter);
        return q.list();
	}
}
