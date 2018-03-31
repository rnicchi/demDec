/**
 * 
 */
package it.mef.bilancio.demdec.dao.impl;


import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTOId;
import it.almavivaitalia.bilancio.commons.to.EmailUtenteTO;
import it.mef.bilancio.demdec.dao.AnagAmminDemDao;
import it.mef.bilancio.demdec.to.LettereTestiTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;



/**
 * @author utente
 *
 */
public class AnagAmminDemDaoImpl extends AbstractDemDaoImpl<AnagAmminDemBO> implements AnagAmminDemDao {

	
	AnagAmminDemDaoImpl() {
		super(AnagAmminDemBO.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnagAmminDemBO> getAmminDemByAnnoEse(String annoEse) throws Throwable {
		
		Query query=createQuery("FROM AnagAmminDemBO a Where a.id.fkAnnoEse =:annoEse");
		query.setParameter("annoEse", new Short(annoEse));
		return (List<AnagAmminDemBO>)query.list();
/*		List<AnagAmminDemBO> list=query.list(); 
		List<AnagAmminDemTO> listaTO=new ArrayList<AnagAmminDemTO>();
		
		Iterator<AnagAmminDemBO> iter=list.iterator();
		AnagAmminDemTO to=null;
		AnagAmminDemBO bo=null;
		while (iter.hasNext()) {
			to=new AnagAmminDemTO();
			to.setId(new AnagAmminDemTOId());
			
			bo=(AnagAmminDemBO)iter.next(); 
			//TODO problemi col dozer Unknown property 'fkAnnoEse' on class 'class it.mef.bilancio.demdec.to.AnagCdrDemTO'
			to.getId().setFkAnnoEse(bo.getId().getFkAnnoEse());
			to.getId().setNumeApp(bo.getId().getNumeApp());
			to.getId().setNumeStp(bo.getId().getNumeStp());
			to.setDescAmm( bo.getDescAmm());
			
			listaTO.add(to);
		}
		
		return listaTO;
*/		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AnagAmminDemBO> getAmminDemByAnnoEseUtenteAndProfilo(String annoEse, String idUtente, String idProfilo) throws Throwable {
		
		/*Query query=createQuery("select amm FROM AnagAmminDemBO amm, UtenteProfiloBO utProf,  "
							  + " Where amm.id.fkAnnoEse=utProf.anagAmminDem.id.fkAnnoEse "
							 // + " and amm.id.numeStp=utProf.anagAmminDem.id.numeStp and amm.id.numeApp=utProf.anagAmminDem.id.numeApp "
							  + " and amm.id.fkAnnoEse =:annoEse  and utProf.id.sequIdUtente=:idUtente and utProf.profilo.id=:idProfilo ");*/
		
		Query query=createQuery(" select amm FROM AnagAmminDemBO amm, UtenteProfiloBO utProf, AnagAmminUfficiBO ammUffici "
							  + " where "
							 // + " amm.id.fkAnnoEse=utProf.anagAmminDem.id.fkAnnoEse "							 
							  + " amm.id.fkAnnoEse =:annoEse  and utProf.id.sequIdUtente=:idUtente and utProf.profilo.id=:idProfilo "					
							  + " and utProf.anagUffici.id=ammUffici.id.fkCodiUfficio "			                
			                  + " and ammUffici.id.fkNumeStp=amm.id.numeStp and ammUffici.id.fkNumeApp=amm.id.numeApp and ammUffici.id.fkAnnoEse=:annoEse ");
		
		query.setParameter("annoEse", new Short(annoEse));
		query.setParameter("idUtente", new BigDecimal(idUtente));
		query.setParameter("idProfilo", Integer.valueOf(idProfilo));
		
		List<AnagAmminDemBO> resultList=(List<AnagAmminDemBO>)query.list();
		
		return resultList;
		
/*		List<AnagAmminDemBO> list=query.list(); 
		List<AnagAmminDemTO> listaTO=new ArrayList<AnagAmminDemTO>();
		
		Iterator<AnagAmminDemBO> iter=list.iterator();
		AnagAmminDemTO to=null;
		AnagAmminDemBO bo=null;
		while (iter.hasNext()) {
			to=new AnagAmminDemTO();
			to.setId(new AnagAmminDemTOId());
			
			bo=(AnagAmminDemBO)iter.next(); 
			//TODO problemi col dozer Unknown property 'fkAnnoEse' on class 'class it.mef.bilancio.demdec.to.AnagCdrDemTO'
			to.getId().setFkAnnoEse(bo.getId().getFkAnnoEse());
			to.getId().setNumeApp(bo.getId().getNumeApp());
			to.getId().setNumeStp(bo.getId().getNumeStp());
			to.setDescAmm( bo.getDescAmm());
			
			listaTO.add(to);
		}
		
		return listaTO;
*/		
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AnagAmminDemBO> getAmminDemCentraliByAnnoEse(String annoEse) throws Throwable {
		
	//	Query query=createQuery("FROM AnagAmminDemBO a Where a.id.fkAnnoEse =:annoEse and a.id.numeApp=0 and a.id.numeStp>0  order by id.numeStp ");
		Query query=createQuery("FROM AnagAmminDemBO a Where a.id.fkAnnoEse =:annoEse and a.id.numeApp=0   order by id.numeStp ");
		query.setParameter("annoEse", new Short(annoEse));
		return (List<AnagAmminDemBO>)query.list();
	}
	
	
	@Override
	public List<AnagAmminDemTO> findAmministrazioniByIdFascicolo(Long idFascicolo) throws Throwable {
		
		/*Query query=createQuery("select amm FROM AnagAmminDemBO amm, FascicoliAmmBO fascicoliAmm "
							  + " where fascicoliAmm.fk_nume_id_fascicolo=:idFascicolo "							 
							  + " and amm.id.fkAnnoEse =:annoEse  and utProf.id.sequIdUtente=:idUtente and utProf.profilo.id=:idProfilo "					
							  + " and utProf.anagUffici.id=ammUffici.id.fkCodiUfficio "			                
			                  + " and fascicoliAmm.fkNumeStp=amm.id.numeStp and fascicoliAmm.fkNumeApp=amm.id.numeApp and fascicoliAmm.fkAnnoEse=amm.id.fkAnnoEse ");
		*/
		
		
		String q="select amm.desc_amm as descAmm, amm.fk_anno_ese as fkAnnoEse, amm.nume_stp as numeStp, amm.nume_app as numeApp, amm.desc_Amm_r as descAmmR, "
				+ "amm.desc_amm_firma as descAmmFirma "
				+ " from d_anag_ammin_dem amm, d_fascicoli_amm fascicoliAmm "
				  + " where fascicoliAmm.fk_nume_id_fascicolo=:idFascicolo "							 
                + " and fascicoliAmm.fk_nume_stp=amm.nume_stp and fascicoliAmm.fk_nume_app=amm.nume_app and fascicoliAmm.fk_anno_ese=amm.fk_anno_ese ";
		
		String q2="select amm.desc_amm as descAmm, amm.fk_anno_ese as fkAnnoEse, amm.nume_stp as numeStp, amm.nume_app as numeApp, amm.desc_Amm_r as descAmmR, " 
        +"amm.desc_amm_firma as descAmmFirma                  from d_anag_ammin_dem amm, d_fascicoli_amm fascicoliAmm "
          +" where fascicoliAmm.fk_nume_id_fascicolo=:idFascicolo "
        +" and fascicoliAmm.fk_nume_stp=amm.nume_stp "
		+" and fascicoliAmm.fk_nume_app=amm.nume_app and fascicoliAmm.fk_Anno_Ese=amm.fk_anno_ese ";
		
		
		
		
		 SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q2);
		
//		 query.addScalar("descAmm", Hibernate.STRING);
//		 query.addScalar("descAmmR", Hibernate.STRING);
//		 query.addScalar("id.numeStp", Hibernate.STRING);
//		 query.addScalar("id.numeApp", Hibernate.STRING);
//		 query.addScalar("id.fkAnnoEse", Hibernate.STRING);
//		 query.addScalar("descAmmFirma", Hibernate.STRING);
		 
//		 query.setLong("idFascicolo", idFascicolo);
//		 List<Object> lista=query.list();
//			List<AnagAmminDemBO> list=query.list(); 
//		 AnagAmminDemTO to=new AnagAmminDemTO();
//		 to.setDescAmm(descAmm);
		 
//		 lista
		 
	//	 List<AnagAmminDemTO> list = query.setResultTransformer(Transformers.aliasToBean(AnagAmminDemTO.class )).setCacheMode(CacheMode.GET).list();
		 
		 List<AnagAmminDemTO> listaRes=new ArrayList<AnagAmminDemTO>();
			Query que = createSQLQuery(q2);
			que.setLong("idFascicolo", idFascicolo);
			
			List<Object> listResQuery=(List<Object>)que.list();
			AnagAmminDemTOId toId=null;
			AnagAmminDemTO to=null;
			for (int i = 0; i < listResQuery.size(); i++) {
				
				toId=new AnagAmminDemTOId( new Short(( (Object[])listResQuery.get(i) )[1].toString()), new Integer( ((Object[])listResQuery.get(i) )[2].toString()), new Integer( ((Object[])listResQuery.get(i) )[3].toString())  );
				to=new AnagAmminDemTO(toId, null, (String)( (Object[])listResQuery.get(i) )[0],  (String) ( (Object[])listResQuery.get(i) )[4]);
				
				listaRes.add(to);
			}	
		   
		//	List<EmailUtenteTO> listaRes=(List<EmailUtenteTO>)q.setResultTransformer(Transformers.aliasToBean(EmailUtenteTO.class )).setCacheMode(CacheMode.GET).list();
			return listaRes;
		
	}

}
