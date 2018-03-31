package it.mef.bilancio.demdec.dao.impl;

import java.util.List;

import org.hibernate.Query;

import it.almavivaitalia.bilancio.commons.bo.AnagTipoFlussoBO;

import it.mef.bilancio.demdec.dao.AnagTipoFlussoDao;

public class AnagTipoFlussoDaoImpl extends AbstractDemDaoImpl<AnagTipoFlussoBO> implements AnagTipoFlussoDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AnagTipoFlussoBO> loadAnagTipoFlusso() {
		String q="FROM AnagTipoFlussoBO "
				+ " where id in ('AUTOMATICO', 'MANUALE') "
				+ " order by id asc";
		Query query = createQuery(q);
		return (List<AnagTipoFlussoBO>) query.list();
	}

}
