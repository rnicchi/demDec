package it.mef.bilancio.demdec.dao.impl;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import it.almavivaitalia.bilancio.commons.dao.impl.AbstractCommonDaoImpl;
import it.almavivaitalia.bsn.sh.bo.AbstractBO;
import it.mef.bilancio.demdec.dao.AbstractDemDao;

public class AbstractDemDaoImpl<T> extends AbstractCommonDaoImpl implements AbstractDemDao<T>{
	
	private Class<T> entityClass;
	
	public AbstractDemDaoImpl(){

	}
	
	public AbstractDemDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T loadById(Serializable id) throws Throwable {
		return (T)getHibernateTemplate().get(entityClass, id);
	}
	
	public void delete(AbstractBO bo) throws Throwable {
		getHibernateTemplate().delete(bo);
		getHibernateTemplate().flush();
	}
	
	protected  void addCreateEq(Criteria cri, String nomeProperty, Object value){
		if (value != null){
			cri.add(Restrictions.eq(nomeProperty, value));
		}
	}
	
	protected void addCreate(Criteria cri, String nomeProperty, Object value, String oper){
		if (value != null){
			if (oper.equalsIgnoreCase("ge")){
				cri.add(Restrictions.ge(nomeProperty, value));
			} else if (oper.equalsIgnoreCase("le")){
				cri.add(Restrictions.le(nomeProperty, value));
			}
		}
	}

	
	/**
	 * genera un id per gli oggetti che necessitano di sequence. Se la query torna null si sta facendo il primo inserimento
	 * nella tabella e setta il valore 1 all'oggetto che deve tornare.
	 */
	@Override
	public Object generaId(Class<T> clazz) throws Throwable {
		
		Object objToReturn = null;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		ClassMetadata hibernateMetadata = session.getSessionFactory().getClassMetadata(clazz);
		
		       if (hibernateMetadata instanceof AbstractEntityPersister){
		               AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
		              Query q = createQuery("select nvl(max(entity.id),0) + 1 from " + persister.getEntityName() + " entity");
		              objToReturn = q.uniqueResult();
		              
		       }
			return objToReturn;
	}

}
