package it.mef.bilancio.demdec.dao.impl;

import java.util.List;

import org.hibernate.Query;

import it.almavivaitalia.bilancio.commons.bo.AmminRagDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.mef.bilancio.demdec.dao.AnagRagionerieDemDao;

public class AnagRagionerieDemDaoImpl extends AbstractDemDaoImpl<AnagRagionerieDemBO> implements AnagRagionerieDemDao {


	public AnagRagionerieDemDaoImpl() {
		super(AnagRagionerieDemBO.class);
	}
	
	
	@Override
	public List<AnagRagionerieDemBO> findAnagRagDemByAnagAmminDem( AnagAmminDemTO anagAmminDemTo ) throws Throwable {
		String queryString = " select rag from AmminRagDemBO amminRag, "
							+ " AnagRagionerieDemBO rag "
							+ " where amminRag.id.annoEse=rag.id.fkAnnoEse "
							+ " and amminRag.id.numeRag=rag.id.numeRag "
							+ " and amminRag.id.annoEse=:annoEse "
							+ " and amminRag.id.numeStp = :numeStp "
							+ " and amminRag.id.numeApp = :numeApp "
							+ " order by rag.id.numeRag ";
		
		Query query = createQuery(queryString);
		query.setShort("annoEse", anagAmminDemTo.getId().getFkAnnoEse())
		.setInteger("numeStp", anagAmminDemTo.getId().getNumeStp())
		.setInteger("numeApp",  anagAmminDemTo.getId().getNumeApp());
		
		List<AnagRagionerieDemBO> listaRag=(List<AnagRagionerieDemBO>)query.list();
		
		return listaRag;
		
	}
}
