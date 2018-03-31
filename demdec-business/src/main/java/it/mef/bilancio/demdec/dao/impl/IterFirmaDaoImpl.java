package it.mef.bilancio.demdec.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import it.almavivaitalia.bilancio.commons.bo.IterFirmaBO;
import it.mef.bilancio.demdec.dao.IterFirmaDao;

public class IterFirmaDaoImpl extends AbstractDemDaoImpl<IterFirmaBO> implements
		IterFirmaDao {

	@SuppressWarnings("unchecked")
	public List<IterFirmaBO> loadIterFirma() throws Throwable {

		String q="FROM IterFirmaBO";
		Query query = createQuery(q);
		return (List<IterFirmaBO>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<IterFirmaBO> loadByIdIter(short idIter) throws Throwable {

		Criteria cri = getSession().createCriteria(IterFirmaBO.class);
		cri.add(Restrictions.eq("id.fkSequIdIter", idIter));
		return (List<IterFirmaBO>) cri.list();
	}

	@Override
	public Integer generaId(Short fkSequIdIter) throws Throwable {

        Query q = createQuery("select nvl(max(id.numeOrdine),0) + 1 from IterFirmaBO where id.fkSequIdIter=:fkSequIdIter");
        q.setInteger("fkSequIdIter", fkSequIdIter);
        return (Integer) q.uniqueResult();

	}

	@Override
	public void deleteByIter(short idIter) throws Throwable {

        for (IterFirmaBO bo: loadByIdIter(idIter))
        	delete(bo);
	}

	@Override
	public void delete(short idIter, int numeroOrdine) throws Throwable {

        List<IterFirmaBO> listaIterFirmaBO = loadByIdIter(idIter);

        deleteByIter(idIter);

        int j = 1;
        for (IterFirmaBO bo: listaIterFirmaBO)
        	if (bo.getId().getNumeOrdine() != numeroOrdine ) {
	        	bo.getId().setNumeOrdine(j++);
	        	saveOrUpdate(bo);
        	}

	}

	@Override
	public void addAll(short idIter, List<IterFirmaBO> listaIterFirmaBO)
			throws Throwable {

        int j = 1;
        for (IterFirmaBO bo: listaIterFirmaBO) {
	        	bo.getId().setNumeOrdine(j++);
	        	saveOrUpdate(bo);
        }
	}
}
