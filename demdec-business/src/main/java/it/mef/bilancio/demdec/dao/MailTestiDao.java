package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.bo.MailTestiBO;


public interface MailTestiDao extends AbstractDemDao<MailTestiBO> {
	
	public MailTestiBO findMailTestiByCodiFunzione(String codiFunzione) throws Throwable;

}
