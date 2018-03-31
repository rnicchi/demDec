package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.dao.ControlliDao;
import it.almavivaitalia.bilancio.commons.to.ControlliTO;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

public class ControlliDaoImpl extends AbstractCommonDaoImpl implements ControlliDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ControlliTO> listaControlli(Integer attNumeTipo)
			throws Throwable {
		String queryString="" +
				  " select distinct a.nume_controllo as numeControllo, 					" +
				  "  a.desc_note as descNote, 											" +
				  "  a.flag_attivo_01 as flagAttivo01, 									" +
				  //"  decode(a.flag_attivo_01,0,'Disattivo','Attivo') as descFlagAttivo,	" +
				  "  a.nume_id as numeId,												" +
				  "  a.fk_Frm_Codi_Nome 							as fkFrmCodiNome    " +
				  " from d_controlli a 													" +
				  " where nvl(a.nume_controllo,0) > 0 									" +
				  " and ((:attNumeTipo = 22 and nvl(a.nume_controllo,0) > 100) or 		" +
				  " (:attNumeTipo = 29 and nvl(a.nume_controllo,0) <= 100))				" +
				  " and a.leg_anno_ese = 0 												" +
				  " and a.leg_att_nume_tipo = 0 										" +
				  " and a.leg_nume_num = 0 												" +
				  " and a.nume_art = 0 													" +
				  " and a.nume_sub_art = 0 												" +
				  " and a.nume_comma = 0 												" +
				  "	and a.nume_sub_comma = 0											" +
				  "	and a.codi_punto = 0												" +
				  "	and a.nume_sub_punto = 0											" +
				  "	and a.ese_anno_ese = 0												" +
				  "	and a.att_nume_tipo = 0												" +
				  "	and a.nume_num = 0 													" +
				  "	order by nume_controllo";
		

		List<ControlliTO> view = null;
		
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		query
		.addScalar("numeControllo", 	Hibernate.INTEGER)
		.addScalar("numeId", 			Hibernate.INTEGER)
		.addScalar("descNote", 			Hibernate.STRING)
		.addScalar("flagAttivo01", 		Hibernate.INTEGER)
		//.addScalar("descFlagAttivo", 	Hibernate.STRING)
		.addScalar("fkFrmCodiNome", 	Hibernate.STRING);
		query.setInteger("attNumeTipo", attNumeTipo);
		
		view = (List<ControlliTO>) query.setResultTransformer(Transformers.aliasToBean(ControlliTO.class)).setCacheMode(CacheMode.GET).list();	
		
		return view;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ControlliTO> listaControlliAutor(Integer numeControllo)
			throws Throwable {
		Query query=getNamedQuery("ControlliBO.listaControlliAutor");
		query.setInteger("numeControllo", numeControllo);
		
		return query.setResultTransformer(Transformers.aliasToBean(ControlliTO.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ControlliTO> listaControlliDecreti(Integer numeControllo)
			throws Throwable {
		Query query=getNamedQuery("ControlliBO.listaControlliDecreti");
		query.setInteger("numeControllo", numeControllo);
		
		return query.setResultTransformer(Transformers.aliasToBean(ControlliTO.class)).list();
	}


}
