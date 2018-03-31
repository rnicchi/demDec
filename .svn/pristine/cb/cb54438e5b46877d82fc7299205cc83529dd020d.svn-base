package it.mef.bilancio.demdec.dao.impl;

import java.util.List;

import org.hibernate.Query;

import it.almavivaitalia.bilancio.commons.bo.DescDocumentoBO;
import it.mef.bilancio.demdec.dao.DescDocumentoDao;
import it.mef.bilancio.demdec.utils.Constants;


public class DescDocumentoDaoImpl extends AbstractDemDaoImpl<DescDocumentoBO> implements DescDocumentoDao {
	
	DescDocumentoDaoImpl(){
		super(DescDocumentoBO.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DescDocumentoBO> loadByTipoDocumento(String tipo) throws Throwable {
		
		Query query=createQuery("from DescDocumentoBO where codiTipoDocumento =:tipo and  id <> :codiCorte order by textDescrizione");
		query.setParameter("tipo", tipo);
		query.setString("codiCorte", Constants.DESC_DOC_CORTE);
	
		List<DescDocumentoBO> list=query.list(); 
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DescDocumentoBO> loadByTipoDocumentoDescrizione(String tipo,String descrizione) throws Throwable {
		
		Query query=createQuery("from DescDocumentoBO where codiTipoDocumento =:tipo and  textDescrizione = :textDescrizione order by textDescrizione");
		query.setParameter("tipo", tipo);
		query.setString("textDescrizione", descrizione);
		return (List<DescDocumentoBO>)query.list();
	}
	
}
