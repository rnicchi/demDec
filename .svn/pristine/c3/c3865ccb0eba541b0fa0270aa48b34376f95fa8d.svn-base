package it.mef.bilancio.demdec.dao.impl;

import org.hibernate.Query;


import it.almavivaitalia.bilancio.commons.bo.MailTestiBO;

import it.mef.bilancio.demdec.dao.MailTestiDao;

public class MailTestiDaoImpl extends AbstractDemDaoImpl<MailTestiBO> implements MailTestiDao {

	@Override
	public MailTestiBO findMailTestiByCodiFunzione(String codiFunzione){
		Query q = createQuery("from MailTestiBO mt where mt.codiFunzione = :codiFunzione");
		q.setParameter("codiFunzione", codiFunzione);
		MailTestiBO mailTesti = (MailTestiBO) q.uniqueResult();
		return mailTesti;
	}

}
