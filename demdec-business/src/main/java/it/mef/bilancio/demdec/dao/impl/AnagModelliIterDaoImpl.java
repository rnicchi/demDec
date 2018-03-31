package it.mef.bilancio.demdec.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import it.almavivaitalia.bilancio.commons.bo.AnagModelliIterBO;
import it.mef.bilancio.demdec.dao.AnagModelliIterDao;

public class AnagModelliIterDaoImpl extends AbstractDemDaoImpl<AnagModelliIterBO> implements AnagModelliIterDao {

	AnagModelliIterDaoImpl() {
		super(AnagModelliIterBO.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnagModelliIterBO> loadAnagModelliIter() throws Throwable {
		String q = "FROM AnagModelliIterBO";
		Query query = createQuery(q);
		return(List<AnagModelliIterBO>)query.list();
	}

	@Override
	public AnagModelliIterBO loadById(short id)  throws Throwable {

		Criteria cri = getSession().createCriteria(AnagModelliIterBO.class);
		cri.add(Restrictions.eq("id", id));
		return (AnagModelliIterBO) cri.uniqueResult();
	}
	
}
