package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.to.EmailUtenteTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;


public class UtenteParentDaoImpl extends AbstractCommonDaoImpl {

	//TOLTO OVERRIDE se no fare class Abstract
	
	
	@SuppressWarnings("unchecked")
	public List<String> findEmailSignatoryNextByStatFirmaAndIdFascicolo(
			String statFirma, Long idFascicolo) {
		Query query=getNamedQuery("UtenteBO.findEmailSignatoryNext");
		query.setParameter("statFirma", statFirma);
		query.setParameter("numeIdFascicolo", idFascicolo);
		return query.list();
	}
	
//	@Override
//	public List<EmailUtenteTO> findEmailUserFlgPecStatIdFasc(String statFirma, Long idFascicolo) {
//		Query query=getNamedQuery("UtenteBO.findEmailUserFlgPecStatIdFasc");
//		query.setParameter("statoFirma", new Integer(statFirma));
//		query.setParameter("idFascicolo", idFascicolo);
//		List<EmailUtenteTO> listaUtentiEmail = query.setResultTransformer(Transformers.aliasToBean(EmailUtenteTO.class )).setCacheMode(CacheMode.GET).list();
//		
//		return listaUtentiEmail;
//		
//	}
//	
	
	
	
	
	public List<EmailUtenteTO> findEmailUserFlgPecStatIdFasc(String statFirma, Long idFascicolo) {
	 
		String queryString= " SELECT  a.indi_email as emailUtente, c.flag_pec_01 as flagEmailPec "+
		
							"  FROM d_j_utente a, d_j_utente_profilo b, d_anag_firmatari c, d_iter_firma_decreto d "+
								 
							"  where  "+
							"  a.sequ_id_utente = b.sequ_id_utente and  "+
							"  b.sequ_id_profilo = c.fk_sequ_id_profilo and "+
							"  c.codi_firmatario = d.fk_codi_firmatario and  "+
							"  ((b.fk_anno_ese = d.fk_anno_ese)  "+
							"  or (b.fk_anno_ese is null and d.fk_anno_ese is null))  "+
							"  and "+
							"   ((b.fk_nume_stp = d.fk_nume_stp)  "+
							"  or (b.fk_nume_stp is null and d.fk_nume_stp is null))  "+
							"   and  "+
							"   ((b.fk_nume_app = d.fk_nume_app)  "+
							"   or (b.fk_nume_app is null and d.fk_nume_app is null)) "+
							"   and "+
							"   ((b.fk_codi_ufficio = d.fk_codi_ufficio)  "+
							"   or (b.fk_codi_ufficio is null and d.fk_codi_ufficio is null)) "+
							"   and "+
							"   ((b.fk_nume_cdr = d.fk_nume_cdr)  "+
							" 	  or (b.fk_nume_cdr is null and d.fk_nume_cdr is null)) "+
							"   and  "+
							"   d.stat_firma = :statoFirma and  "+
							"   d.fk_nume_id_fascicolo = :idFascicolo ";
	
	
				List<EmailUtenteTO> listaRes=new ArrayList<EmailUtenteTO>();
				Query q = createSQLQuery(queryString);
				q.setInteger("statoFirma", new Integer(statFirma));
				q.setLong("idFascicolo", idFascicolo);
				
				List<Object> listResQuery=(List<Object>)q.list();
				EmailUtenteTO to=null;

				for (int i = 0; i < listResQuery.size(); i++) {
					to=new EmailUtenteTO( (String)( (Object[])listResQuery.get(i) )[0], new Integer( ((Object[])listResQuery.get(i) )[1].toString())  );
					listaRes.add(to);
				}	
			   
			//	List<EmailUtenteTO> listaRes=(List<EmailUtenteTO>)q.setResultTransformer(Transformers.aliasToBean(EmailUtenteTO.class )).setCacheMode(CacheMode.GET).list();
				return listaRes;
	
	}
	
	
	
	
	public List<EmailUtenteTO> findEmailUserPecRichSospensioneByIdFascicolo(Long idFascicolo) throws Throwable {
		Query query=getNamedQuery("UtenteBO.findEmailUserPecRichSospensione");		
		query.setParameter("numeIdFascicolo", idFascicolo);
		
		List<EmailUtenteTO> listUtenti = query.setResultTransformer(Transformers.aliasToBean(EmailUtenteTO.class )).setCacheMode(CacheMode.GET).list();
		
		return listUtenti;
//		return query.list();		
	}
	
	
	
	
	public String findDeencryptedPinbyId(Integer id ) throws Throwable {
			String queryString= "select   DBK_encrypto.decrypt_ssn("
												+ "(select ut.codi_pin_firma from d_j_utente"
												+ " ut where sequ_id_utente=:id  ) )"
									   + "from dual";
		 Query q = createSQLQuery(queryString);
		  q.setInteger("id", id);
		  return (String)q.uniqueResult();
		 
	}


}