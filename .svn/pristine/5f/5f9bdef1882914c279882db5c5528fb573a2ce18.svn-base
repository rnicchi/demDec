package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.LettereTestiPersBO;
import it.mef.bilancio.demdec.dao.LettereTestiPersDao;
import it.mef.bilancio.demdec.to.LettereTestiPersTO;
import it.mef.bilancio.demdec.to.LettereTestiTO;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

public class LettereTestiPersDaoImpl extends AbstractDemDaoImpl<LettereTestiPersBO> implements LettereTestiPersDao {

	@Override
	public List<LettereTestiPersBO> findTestoPersFasc(Long fkNumeIdFascicolo, String codiTipoLettera)  throws Throwable{
		
		String q=
			     " FROM LettereTestiPersBO item  "+
			     " WHERE item.fascicoli.id = :fkNumeIdFascicolo " +
			     " AND item.id.codiTipoLettera = :codiTipoLettera " +
			     " ORDER BY id.codiSezione, id.numeRiga ";
		
		Query query = createQuery(q);
		
		query.setParameter("fkNumeIdFascicolo", fkNumeIdFascicolo)
		.setParameter("codiTipoLettera", codiTipoLettera);
		
		return query.list();
				
	}
	
	
//	@Override
//	public List<LettereTestiTO> findContenutiLetteraByFascTipo(Long fkNumeIdFascicolo, String codiTipoLettera)  throws Throwable{
//		String q = "  SELECT  textContenuto,  codiSezione as codiSezione, numeRiga as numeRiga  from FROM D_LETTERE_TESTI_PERS  "
//				+ " WHERE FK_NUME_ID_FASCICOLO = :fkNumeIdFascicolo " +
//				 " AND CODI_TIPO_LETTERA = :codiTipoLettera ";
//		
//		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);
//		
//		query.setParameter("fkNumeIdFascicolo", fkNumeIdFascicolo)
//		.setParameter("codiTipoLettera", codiTipoLettera);
//		
//		query.addScalar("textContenuto", Hibernate.STRING)
//	      .addScalar("codiSezione", Hibernate.STRING)			  
//		  .addScalar("numeRiga", Hibernate.STRING)
//		  .addScalar("personalizzato", Hibernate.STRING);
//		
//		return (List<LettereTestiTO>)query.setResultTransformer(Transformers.aliasToBean(LettereTestiTO.class )).setCacheMode(CacheMode.GET).list();
//				
//	}
	
	
	@Override
	public List<LettereTestiTO> findActualTestoFasc(Long fkNumeIdFascicolo, String codiTipoLettera, String codiSezione)  throws Throwable{
		
		String q = "  SELECT distinct LTRIM(RTRIM(DECODE(textContenuto, null, textContenuto2, textContenuto))) as textContenuto, " + 
		" codiSezione as codiSezione, numeRiga as numeRiga, DECODE(textContenuto, null, 'N', 'S') as personalizzato  " + 
		" FROM ( " +
		" SELECT MAX(textContenuto) as textContenuto, MAX(textContenuto2) as textContenuto2, codiSezione, numeRiga " +
				" FROM  " +
				" (SELECT TEXT_CONTENUTO as textContenuto, null as textContenuto2, CODI_SEZIONE as codiSezione, NUME_RIGA as numeRiga  "+  
  			    " FROM D_LETTERE_TESTI_PERS  "+
  			    " WHERE FK_NUME_ID_FASCICOLO = :fkNumeIdFascicolo " +
			    " AND CODI_TIPO_LETTERA = :codiTipoLettera ";
		
		if(StringUtils.isNotBlank(codiSezione)){
			q += " AND CODI_SEZIONE = :codiSezione ";
		}
		
		
		q += " UNION " +
			    " SELECT null as textContenuto, TEXT_CONTENUTO as textContenuto2, CODI_SEZIONE as codiSezione, NUME_RIGA as numeRiga  "+  
  			    " FROM D_LETTERE_TESTI  "+
  			    " WHERE CODI_TIPO_LETTERA = :codiTipoLettera ";
		
		if(StringUtils.isNotBlank(codiSezione)){
			q += " AND CODI_SEZIONE = :codiSezione ";
		}
		
		q += ") GROUP BY codiSezione, numeRiga ) " +
				" ORDER BY codiSezione, numeRiga ";
		
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);
		
		query.setParameter("fkNumeIdFascicolo", fkNumeIdFascicolo)
		.setParameter("codiTipoLettera", codiTipoLettera)
		.setParameter("codiSezione", codiSezione);
		
		query.addScalar("textContenuto", Hibernate.STRING)
		      .addScalar("codiSezione", Hibernate.STRING)			  
			  .addScalar("numeRiga", Hibernate.STRING)
			  .addScalar("personalizzato", Hibernate.STRING);
		
		
		return (List<LettereTestiTO>)query.setResultTransformer(Transformers.aliasToBean(LettereTestiTO.class )).setCacheMode(CacheMode.GET).list();
				
	}


	@Override
	public List<LettereTestiPersBO> findTestoPersByIdLettera(
			Long fkSequIdLettera, String codiTipoLettera) throws Throwable {
		String q=
			     " FROM LettereTestiPersBO item  "+
			     " WHERE item.id.fkSequIdLettereIgb = :fkSequIdLettera " +
			     " AND item.id.codiTipoLettera = :codiTipoLettera " +
			     " ORDER BY id.codiSezione, id.numeRiga ";
		
		Query query = createQuery(q);
		
		query.setParameter("fkSequIdLettera", new BigDecimal(fkSequIdLettera.toString()) )
		.setParameter("codiTipoLettera", codiTipoLettera);
		
		return query.list();
	}
	
	
	
	@Override
	public List<LettereTestiPersBO> findContenutiPersByIdLettera(String idLettera) {
					String queryString = " select a.text_contenuto as textContenuto "+
										 " from d_lettere_testi_pers a " +
										 " where a.fk_sequ_id_lettere_igb=:idLettera ";   
		
					SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
	 
					query.addScalar("textContenuto", Hibernate.STRING);
		
					//Query query = getEntityManager().createNativeQuery(queryString);		 
					if(idLettera!=null){
						query.setParameter("idLettera", idLettera);
					}
			//	//	List<String> lista=query.getResultList();
				//	query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().setResultTransformer(Transformers.TO_LIST);
					
					List<Object> list = query.setResultTransformer(Transformers.aliasToBean(LettereTestiPersTO.class )).setCacheMode(CacheMode.GET).list();
					
					//return list;
			      //  List<Object> lista =query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().list();
					
					
					String[] arrayTestiLettere=new String[list.size()+1];
					
					Iterator<Object>  iter=list.iterator();
					int i=1;
					while (iter.hasNext()) {
						//Object[] arrayObject=(Object [] ) iter.next();					
						arrayTestiLettere[i]=((LettereTestiPersTO)iter.next()).getTextContenuto();						
						i++;
					}
					
					
					return null;
	}		 
	
	
}
