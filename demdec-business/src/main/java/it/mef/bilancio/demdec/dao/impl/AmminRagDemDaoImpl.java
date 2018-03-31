package it.mef.bilancio.demdec.dao.impl;

import org.hibernate.Query;

import it.almavivaitalia.bilancio.commons.bo.AmminRagDemBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.mef.bilancio.demdec.dao.AmminRagDemDao;

public class AmminRagDemDaoImpl extends AbstractDemDaoImpl<AmminRagDemBO> implements	AmminRagDemDao {

	@Override
	public AmminRagDemBO findAmminRagDemByAnagAmminDemTO(
			AnagAmminDemTO anagAmminDemTo) throws Throwable {
		String queryString = " from AmminRagDemBO where id.annoEse=:annoEse "
				+ "    and id.numeStp = :numeStp "
				+ "    and id.numeApp = :numeApp "
				+ "    order by id.numeRag ";
		Query query = createQuery(queryString);
		query.setShort("annoEse", anagAmminDemTo.getId().getFkAnnoEse())
		.setInteger("numeStp", anagAmminDemTo.getId().getNumeStp())
		.setInteger("numeApp",  anagAmminDemTo.getId().getNumeApp());
		return (AmminRagDemBO)query.uniqueResult();
		
	}
}
