package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBO;
import it.mef.bilancio.demdec.dao.DocumentiRedDao;
import it.mef.bilancio.demdec.to.FascicoliViewTO;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

public class DocumentiRedDaoImpl  extends AbstractDemDaoImpl<DocumentiRedBO> implements DocumentiRedDao{

	DocumentiRedDaoImpl() {
		super(DocumentiRedBO.class);
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<FascicoliViewTO> findFascicoliAssociati(String guid) throws Throwable{
	
			String q="SELECT b.desc_sigla as descSigla, b.nume_num_decreto as numeNumDecreto, b.fk_anno_ese as annoEse "+
				    
			 " FROM d_documenti_red a, d_fascicoli b "+
			 " where a.codi_guid_doc_orig_prov = :param "+
			 " and a.fk_nume_id_fascicolo = b.nume_id_fascicolo ";
			  
			  
			  SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);
			  query.addScalar("descSigla", Hibernate.STRING);
			  query.addScalar("numeNumDecreto", Hibernate.STRING);
			  query.addScalar("annoEse", Hibernate.SHORT);
			  
			  query.setParameter("param", guid);
			  
			 // return (List<FascicoliBO>) query.list();
	  
	  return (List<FascicoliViewTO>)query.setResultTransformer(Transformers.aliasToBean(FascicoliViewTO.class )).setCacheMode(CacheMode.GET).list();
		
	}

//	@Override
//	public void updateFascicolo (DocumentiRedBO bo) throws Throwable{
//		saveOrUpdate(bo);
//	}
	
	
//	@Override
//	public Integer insertDocumentoRed(DocumentiRedBO bo ) throws Throwable{
//		getSessionFactory().getCurrentSession().persist(bo);
//		getSessionFactory().getCurrentSession().flush();
//	    Integer res=0;
//	    return res;
//	}



	@Override
	public void deleteByFascicolo(Long idFascicolo) throws Throwable {
		String queryString = "delete from D_DOCUMENTI_RED where FK_NUME_ID_FASCICOLO = :idFascicolo" ;
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		query.setLong("idFascicolo", idFascicolo);
		query.executeUpdate();
	}
	
	
	
	
	//@Override
/*	public Integer insertDocumentoRedOld(DocumentiRedBO bo ) throws Throwable{
	    Integer res=0;
		String q="Insert into U_NSBF_DEM.D_DOCUMENTI_RED "+
				"(ROW_CREATED_DTTM, ROW_CREATED_USER, ROW_CREATED_FORM, NUME_VERSION, CODI_ID_RED, FK_NUME_ID_FASCICOLO, CODI_GUID_DOCUMENTO, CODI_GUID_DOCUMENTO_ORIG,  "+
						"CODI_GUID_DOC_PROV, FK_CODI_TIPO_DOCUMENTO, STAT_DOCUMENTO, FK_ANNO_ESE, FK_NUME_STP, FK_NUME_APP, "+ 
						"CODI_PROTOCOLLO, FLAG_VISIBILITA_CDC_01, DATA_DOCUMENTO, DATA_AGGIORNAMENTO,  DESC_FILENAME, CODI_MIME_TYPE_ORIG, CODI_HASH) "+
		 
						
						" Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		 
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);
		 query.setDate(0, bo.getRowCreatedDttm());
		 query.setParameter(1, bo.getRowCreatedUser());
		 query.setParameter(2, bo.getRowCreatedForm());
		 query.setInteger(3, Integer.valueOf(bo.getNumeVersion()));
		 query.setParameter(4, bo.getSottoFascicoliRed().getId().getCodiIdRed());
		 query.setLong(5, bo.getSottoFascicoliRed().getId().getFkNumeIdFascicolo());
		 query.setParameter(6, bo.getId().getCodiGuidDocumento());
		 query.setParameter(7, bo.getCodiGuidDocumentoOrig());
		 query.setParameter(8, bo.getCodiGuidDocProv());
		 query.setParameter(9, bo.getTipoDocumento().getId());
		 query.setParameter(10, bo.getStatDocumento());
		 query.setInteger(11, Integer.valueOf(bo.getAnagAmminDem().getId().getFkAnnoEse()));
		 query.setInteger(12, bo.getAnagAmminDem().getId().getNumeStp());
		 query.setInteger(13, bo.getAnagAmminDem().getId().getNumeApp());	 
		 query.setParameter(14, bo.getCodiProtocollo());
		 query.setInteger(15, bo.getFlagVisibilitaCdc01());
		 query.setDate(16, bo.getDataDocumento());
		 query.setDate(17, bo.getDataAggiornamento());
		 query.setParameter(18, bo.getDescFilename());
		 query.setParameter(19, bo.getCodiMimeTypeOrig());
		 query.setParameter(20, bo.getCodiHash());
		
		 
		 
		 res=query.executeUpdate();
	    return res;
	}*/
}
