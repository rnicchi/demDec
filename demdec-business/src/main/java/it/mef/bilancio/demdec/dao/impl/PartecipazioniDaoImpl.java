package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.mef.bilancio.demdec.dao.PartecipazioniDao;
import it.mef.bilancio.demdec.to.PartecipazioniTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;

public class PartecipazioniDaoImpl extends AbstractDemDaoImpl implements PartecipazioniDao {
	
	
	@Override
	public List<PartecipazioniTO> findByIdFascicolo(Integer idFascicolo)  throws Throwable {
		//SQLQuery q = createSQLQuery("select * from D_PARTECIPAZIONI dp where dp.nume_id_fascicolo = :idFascicolo");
		
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().
				createSQLQuery("select * from D_PARTECIPAZIONI dp where dp.nume_id_fascicolo = :idFascicolo");
		
		
		//query.addScalar("numeIdFascicolo", Hibernate.INTEGER);
		query.setParameter("idFascicolo", idFascicolo);
		List<Object> listResQuery=(List<Object>)query.list();
		
		PartecipazioniTO to=null;
		 List<PartecipazioniTO> lista=new ArrayList<PartecipazioniTO>();
		for (int i = 0; i < listResQuery.size(); i++) {
			to=new PartecipazioniTO();
			to.setNumeIdFascicolo( ((BigDecimal)( (Object[])listResQuery.get(i) )[0])==null?null: ((BigDecimal)( (Object[])listResQuery.get(i) )[0]).intValue());
			to.setAnnoEse( ((BigDecimal)( (Object[])listResQuery.get(i) )[1])==null?null: ((BigDecimal)( (Object[])listResQuery.get(i) )[1]).intValue());
			to.setNumeTipoDecreto( ((BigDecimal)( (Object[])listResQuery.get(i) )[2])==null?null: ((BigDecimal)( (Object[])listResQuery.get(i) )[2]).intValue());
			to.setNumeNumDecreto( ((BigDecimal)( (Object[])listResQuery.get(i) )[3])==null?null: ((BigDecimal)( (Object[])listResQuery.get(i) )[3]).intValue());
			to.setNumeRag( ((BigDecimal)( (Object[])listResQuery.get(i) )[4])==null?null: ((BigDecimal)( (Object[])listResQuery.get(i) )[4]).intValue());
			to.setDescRag( (String) ( (Object[])listResQuery.get(i) )[5]);
			to.setDataDef( (Date) ( (Object[])listResQuery.get(i) )[6]);
			to.setDataReg( (Date) ( (Object[])listResQuery.get(i) )[7]);
			to.setNumeRegistrazione( ((BigDecimal)( (Object[])listResQuery.get(i) )[8])==null?null:((BigDecimal)( (Object[])listResQuery.get(i) )[8]).intValue());
			to.setNumeUfficioCdc( ((BigDecimal)( (Object[])listResQuery.get(i) )[9])==null?null: ((BigDecimal)( (Object[])listResQuery.get(i) )[9]).intValue());
			to.setDescUfficioCdc( (String) ( (Object[])listResQuery.get(i) )[10]);
			
			lista.add(to);
		}	
		
		return lista;
		
	}
	
	
	@Override
	public List<String> findDestinatariMailPec(BigDecimal idFascicolo) throws Throwable {
	
		
		 String q=  " SELECT text_email "+
					" FROM d_unita_organizzativa a, d_amm_ucb_ipa b, d_fascicoli_amm c "+
					" where a.codi_ldap_ou = b.codi_ldap_ou "+ 
					" and b.codi_categoria_ipa = 'OU' "+
					" and b.nume_stp = c.fk_nume_stp "+
					" and b.nume_app = c.fk_nume_app "+ 
					" AND c.fk_nume_id_fascicolo = :PARAM ";
		
		 SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);
		 
		 query.addScalar("text_email", Hibernate.STRING);
		 query.setParameter("PARAM", idFascicolo);
		 
		 List<String> dest= (List<String>)query.list();
		  
		 return dest;
	}

	
}
