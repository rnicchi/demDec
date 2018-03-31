package it.mef.bilancio.demdec.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;


import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
//import it.mef.bilancio.demdec.dao.Iterator;
import it.mef.bilancio.demdec.dao.LettereTestiDao;
//import it.mef.bilancio.demdec.dao.List;
//import it.mef.bilancio.demdec.dao.NoResultException;
//import it.mef.bilancio.demdec.dao.Query;
import it.mef.bilancio.demdec.to.DocumentiViewTO;
import it.mef.bilancio.demdec.to.LettereTestiTO;

public class LettereTestiDaoImpl extends AbstractDemDaoImpl implements LettereTestiDao{
	
	@Override
	public String[] getLettereTestiByTipo(String tipoLettera) throws Throwable{
		//public	List<LettereTestiBO> getLettereTestiByTipo(String tipoLettera) throws Throwable{
//		
//		Criteria cri = getSession().createCriteria(LettereTestiBO.class);
//		addCreateEq(cri, "codiTipoLettera", tipoLettera);
//		List<LettereTestiBO> listLettereTesti=cri.list();
//		
//		return listLettereTesti;
		
		
		
		
		  	
		String queryString = "select a.text_contenuto as textContenuto "+
					 "from d_lettere_testi a "
					 + "where a.codi_tipo_lettera=:tipo ";   
		
		String queryString2 = "from LettereTesti a where a.codiTipoLettera=:tipo ";   
					 
			 
		
		
		 SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		 
		//	query.setLong("idFascicolo", idFascicolo);
			
		//	List<AnagAmminDemBO> list=query.list(); 
		 query.addScalar("textContenuto", Hibernate.STRING);
		
					//Query query = getEntityManager().createNativeQuery(queryString);		 
					if(tipoLettera!=null){
						query.setParameter("tipo", tipoLettera);
					}
			//	//	List<String> lista=query.getResultList();
				//	query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().setResultTransformer(Transformers.TO_LIST);
					
					List<Object> list = query.setResultTransformer(Transformers.aliasToBean(LettereTestiTO.class )).setCacheMode(CacheMode.GET).list();
					
					//return list;
			      //  List<Object> lista =query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().list();
					
					
					String[] arrayTestiLettere=new String[list.size()+1];
					
					Iterator<Object>  iter=list.iterator();
					int i=1;
					while (iter.hasNext()) {
						//Object[] arrayObject=(Object [] ) iter.next();					
						arrayTestiLettere[i]=((LettereTestiTO)iter.next()).getTextContenuto();						
						i++;
					}
					
					return arrayTestiLettere;
						 					 
		
	}

	@Override
	public String[] getLettereTestiByTipoBalanced(String tipoLettera) throws Throwable{

		String queryString = " SELECT distinct LTRIM(RTRIM(DECODE(textContenuto2, null, textContenuto, textContenuto2))) as textContenuto, " +
				" codiSezione as codiSezione, numeRiga as numeRiga " +
				" FROM ( " +
				" SELECT MAX(textContenuto) as textContenuto, MAX(textContenuto2) as textContenuto2, codiSezione, numeRiga  " +
				" FROM (" +
				" select a.text_contenuto as textContenuto, null as textContenuto2,  a.CODI_SEZIONE as codiSezione , a.NUME_RIGA as numeRiga "+
					 " from d_lettere_testi a "
					 + " where a.codi_tipo_lettera=:tipo " +
					 "  UNION " +
					 " select null as textContenuto, b.text_contenuto as textContenuto2, b.CODI_SEZIONE as codiSezione, b.NUME_RIGA as numeRiga "+
					 " from d_lettere_testi_PERS b "
					 + " where b.codi_tipo_lettera=:tipo " +
					 " ) GROUP BY codiSezione, numeRiga ) " +
					 " ORDER BY codiSezione, numeRiga ";   
		

		 SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		
		 query.addScalar("textContenuto", Hibernate.STRING);
		
					
		if(tipoLettera!=null){
			query.setParameter("tipo", tipoLettera);
		}
						
		List<Object> list = query.setResultTransformer(Transformers.aliasToBean(LettereTestiTO.class )).setCacheMode(CacheMode.GET).list();
			
				
		String[] arrayTestiLettere=new String[list.size()+1];
					
		Iterator<Object>  iter=list.iterator();
		int i=1;
		while (iter.hasNext()) {					
			arrayTestiLettere[i]=((LettereTestiTO)iter.next()).getTextContenuto();						
			i++;
		}
					
		return arrayTestiLettere;						 					 
		
	}
	
}
