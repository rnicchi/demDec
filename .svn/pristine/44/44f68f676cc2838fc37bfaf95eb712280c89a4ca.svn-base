package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.AnagCdrDemBO;
import it.mef.bilancio.demdec.dao.AnagCdrDemDao;

import java.util.List;

import org.hibernate.Query;

public class AnagCdrDemDaoImpl extends AbstractDemDaoImpl<AnagCdrDemBO> implements
		AnagCdrDemDao {

	AnagCdrDemDaoImpl() {
		super(AnagCdrDemBO.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnagCdrDemBO> anagCdrList(Short annoEse, Integer numeStp,
			Integer numeApp) throws Throwable {
		String queryString = " from AnagCdrDemBO where id.fkAnnoEse=:annoEse "
				+ "    and id.fkNumeStp = :numeStp "
				+ "    and id.fkNumeApp = :numeApp "
				+ "    order by id.numeCdr ";
		Query query = createQuery(queryString);
		query.setShort("annoEse", annoEse)
		.setInteger("numeStp", numeStp)
		.setInteger("numeApp", numeApp);
		return (List<AnagCdrDemBO>)query.list();
		
	}

	
	
/*	@Override
	public List<AnagCdrDemTO> getCdrDemByAnnoEseAmm(String annoEse, String stp, String app) throws Throwable {
		
		Query query=createQuery("FROM AnagCdrDemBO a Where a.id.fkAnnoEse =:annoEse and id.fkNumeStp=:stp and id.fkNumeApp=:app ");
		query.setParameter("annoEse",annoEse);
		query.setParameter("stp",stp);
		query.setParameter("app",app);
		
		List<AnagCdrDemBO> list=query.list(); 
		List<AnagCdrDemTO> listaTO=new ArrayList<AnagCdrDemTO>();
		
		Iterator<AnagCdrDemBO> iter=list.iterator();
		AnagCdrDemTO to=null;
		AnagCdrDemBO bo=null;
		while (iter.hasNext()) {
			to=new AnagCdrDemTO();
			to.setId(new AnagCdrDemTOId());
			
			bo=(AnagCdrDemBO)iter.next();
			to.getId().setFkNumeApp(bo.getId().getFkNumeApp());
			to.getId().setFkNumeStp(bo.getId().getFkNumeStp());
			to.setDescCdr(bo.getDescCdr());
			
			listaTO.add(to);
		}
		
		return listaTO;
	}

*/}
