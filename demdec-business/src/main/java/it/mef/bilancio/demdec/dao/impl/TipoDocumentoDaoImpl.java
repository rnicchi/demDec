package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.TipoDocumentoBO;
import it.mef.bilancio.demdec.dao.TipoDocumentoDao;

import java.util.List;

import org.hibernate.Query;

public class TipoDocumentoDaoImpl extends AbstractDemDaoImpl<TipoDocumentoBO> implements TipoDocumentoDao {

	
	TipoDocumentoDaoImpl() {
		super(TipoDocumentoBO.class);
	}


		
		@Override
		public List<TipoDocumentoBO> loadTipoDocumentoIG(){
			Query query=createQuery("from TipoDocumentoBO where id like 'IG%' order by descDescrizioneDoc");
			
			@SuppressWarnings("unchecked")
			List<TipoDocumentoBO> list=query.list(); 
			
			return list;
		
		}
		
		@Override
		public List<TipoDocumentoBO> loadTipoDocumentoAD(){
			Query query=createQuery("from TipoDocumentoBO where id like 'AD%' order by descDescrizioneDoc");
			
			@SuppressWarnings("unchecked")
			List<TipoDocumentoBO> list=query.list(); 
			
			return list;
		
		}
	
		// la load by id non funziona
		@Override
		public TipoDocumentoBO loadbyTipoDocumento(String codi){
			Query query=createQuery("from TipoDocumentoBO where id=:codi  order by descDescrizioneDoc");
			query.setString("codi", codi);
			
			return (TipoDocumentoBO) query.uniqueResult();
			
			
		}
}
