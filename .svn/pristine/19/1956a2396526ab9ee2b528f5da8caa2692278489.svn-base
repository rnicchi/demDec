package it.mef.bilancio.demdec.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import it.almavivaitalia.bilancio.commons.bo.SospesiRedBO;
import it.mef.bilancio.demdec.dao.SospesoRedDao;


public class SospesoRedDaoImpl extends AbstractDemDaoImpl<SospesiRedBO> implements SospesoRedDao{
	
	

	SospesoRedDaoImpl() {
		super(SospesiRedBO.class);
	}

	@Override
	public void saveSospesiRed(Collection<SospesiRedBO> listaSospesiRed) throws Throwable {

		for (SospesiRedBO bo: listaSospesiRed)
			saveOrUpdate(bo);

	}

	@SuppressWarnings("unchecked")
	public Collection<SospesiRedBO> getListaSospesiRed() throws Throwable {

		String query = "select CODI_GUID_RED, CODI_ID_RED, CODI_OPERAZIONE from D_SOSPESI_RED where STAT_ESITO is null order by CODI_GUID_RED";
		Query queryStm = createSQLQuery(query);
		List<SospesiRedBO> listaBO = new ArrayList<SospesiRedBO>();

		Iterator<Object> iter = queryStm.list().iterator();
		Object[] objArray=null;
		while (iter.hasNext()) {
			SospesiRedBO bo = new SospesiRedBO();
			objArray= (Object[])iter.next();
			bo.setId((String)objArray[0]);
			bo.setCodiIdRed((String)objArray[1]);
			bo.setCodiOperazione((String)objArray[2]);
			listaBO.add(bo);
		}

		return listaBO;
	}

}
