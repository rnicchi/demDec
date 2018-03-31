package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.AnagUfficiBO;
import it.mef.bilancio.demdec.dao.AnagUfficiDao;

import java.util.List;

import org.hibernate.Query;

public class AnagUfficiDaoImpl extends AbstractDemDaoImpl<AnagUfficiBO> implements AnagUfficiDao {

	AnagUfficiDaoImpl() {
		super(AnagUfficiBO.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnagUfficiBO> loadAnagUffici() {
		String q="FROM AnagUfficiBO order by LPAD(id,2,'0') asc";
		Query query = createQuery(q);
		return (List<AnagUfficiBO>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AnagUfficiBO> loadAnagUfficiAttivi() {
		String q="FROM AnagUfficiBO where flagAttivo01=1  order by LPAD(id,2,'0') ";
		Query query = createQuery(q);
		return (List<AnagUfficiBO>) query.list();
	}

}
