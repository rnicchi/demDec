package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBO;
import it.mef.bilancio.demdec.dao.SottoFascicoliRedDao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SottoFascicoliRedDaoImpl  extends AbstractDemDaoImpl<SottoFascicoliRedBO> implements SottoFascicoliRedDao{

	SottoFascicoliRedDaoImpl() {
		super(SottoFascicoliRedBO.class);
	}

	@Override
	public boolean insertSottoFascDocumenti (SottoFascicoliRedBO sfRedBo, DocumentiRedBO docRedBo) throws Throwable{
		
		boolean result=false;
		 
		Session session = getSession();
		try {
			
	        Transaction tx = session.beginTransaction();
	        session.saveOrUpdate(sfRedBo);
	        session.saveOrUpdate(docRedBo);      
	        tx.commit();
	       
		}finally{
			 session.close();
		}
		
		 result=true;
		 
		 return result;
		 
		 
	}
	
	
	@Override
	public void deleteByNumeIdFascicolo(Long numeIdFascicolo) throws Throwable {
		String q="DELETE FROM SottoFascicoliRedBO bo where bo.id.fkNumeIdFascicolo=:numeIdFascicolo";
		Query query = createQuery(q);
		query.setLong("numeIdFascicolo", numeIdFascicolo);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SottoFascicoliRedBO> findByNumeIdFascicolo(Long numeIdFascicolo) throws Throwable {
		/*String querySql="select * from d_sotto_fascicoli_red where fk_nume_id_fascicolo=:numeIdFascicolo";
		Query query=createSQLQuery(querySql);
		query.setInteger("numeIdFascicolo", numeIdFascicolo);
	//	List<SottoFascicoliRedTO> result=(List<SottoFascicoliRedTO>)query.setResultTransformer(Transformers.aliasToBean(SottoFascicoliRedTO.class )).setCacheMode(CacheMode.GET).list();
		List<SottoFascicoliRedBO> resultList=	(List<SottoFascicoliRedBO>) query.list();
		return resultList;*/
			
		String q="FROM SottoFascicoliRedBO bo where bo.id.fkNumeIdFascicolo=:numeIdFascicolo";
		Query query = createQuery(q);
		query.setLong("numeIdFascicolo", numeIdFascicolo);
		return (List<SottoFascicoliRedBO>)query.list();
		
	}
	
	
/*	private void startSession() {

        getSession().beginTransaction();
    }

    private void closeSession() {
        getSession().getTransaction().commit();
      //  getSession().close();
    }*/

//    public void addObject() {
//        startSession();
//        getSession().save(this);
//        closeSession();
//    }

    
    /*
    Progetto  di Applicazioni  Software
    Anno  accademico 2008-2009
Interfacce  Hibernate  -  Esempio  d'uso
File
Bid.java
package bid;
import java.util.
*
;
import org.hibernate.
*
;
import persistence.HibernateUtil;
public class Bid {
public static void main(String[] args) {
//First unit of work
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
User user = new User("pippo");
String userId = (String) session.save(user);
tx.commit();
session.close();*/
    
    
	
}
