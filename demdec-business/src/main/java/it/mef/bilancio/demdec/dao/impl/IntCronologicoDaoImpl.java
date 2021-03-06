package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.dao.impl.AbstractCommonDaoImpl;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.dao.IntCronologicoDao;
import it.mef.bilancio.demdec.to.CronologicoSearchTO;
import it.mef.bilancio.demdec.to.CronologicoTO;
import it.mef.bilancio.demdec.to.CronologicoTransExcelTO;
import it.mef.bilancio.demdec.to.CronologicoTransTO;
import it.mef.bilancio.demdec.to.CronologicoValoriTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

public class IntCronologicoDaoImpl extends AbstractCommonDaoImpl implements IntCronologicoDao {
    // UTENTE //
	@SuppressWarnings("unchecked")
	public List<CodeDescriptionTO> loadUtente() throws Throwable {
		String queryString="" +
		  " SELECT DISTINCT CRT.DESC_UTENTE as code, " +
		  "        crt.desc_utente          as description " +		
          "   FROM D_CRO_DATI CRT " +
          "  ORDER BY CRT.DESC_UTENTE";  
		  
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
        query.addScalar("code",    	   Hibernate.STRING)
             .addScalar("description", Hibernate.STRING);
        List<CodeDescriptionTO> view = (List<CodeDescriptionTO>)
				query.setResultTransformer(Transformers.aliasToBean(CodeDescriptionTO.class ))
				.setCacheMode(CacheMode.GET).list();
		
		return view;
	}
	// APPLICATION //
	public List<CronologicoSearchTO> loadApplication() throws Throwable {
		String queryString="" +
				  " SELECT a.sequ_id_application as sequIdApplication, " +
				  "        a.codi_application    as codiApplication, " +
                  "        a.desc_application    as descApplication  " +
                  "   FROM d_application a " +
                  "   ORDER BY 3";
				  
				SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		        query.addScalar("sequIdApplication",  Hibernate.INTEGER)
		             .addScalar("codiApplication",    Hibernate.STRING)
		             .addScalar("descApplication",    Hibernate.STRING);
		        @SuppressWarnings("unchecked")
				List<CronologicoSearchTO> view = (List<CronologicoSearchTO>)
						query.setResultTransformer(Transformers.aliasToBean(CronologicoSearchTO.class ))
						.setCacheMode(CacheMode.GET).list();				
				return view;
	} 
	// CATEGORIA //
	public List<CronologicoSearchTO> loadCategoria(Integer idAppl) throws Throwable {
		String queryString="" +
		" SELECT a.sequ_id_help_categoria as sequIdHelpCategoria, " +
		"        a.codi_help_categoria    as codiHelpCategoria " +	    
	    "   FROM d_help_categoria a " +
		"  WHERE a.fk_sequ_id_application = :idAppl " +
	    "   ORDER BY a.sequ_id_help_categoria";
					  
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		query.addScalar("sequIdHelpCategoria",  Hibernate.INTEGER)
		     .addScalar("codiHelpCategoria",    Hibernate.STRING);
	    query.setInteger("idAppl", idAppl);
		@SuppressWarnings("unchecked")
		List<CronologicoSearchTO> view = (List<CronologicoSearchTO>)
		query.setResultTransformer(Transformers.aliasToBean(CronologicoSearchTO.class ))
		   	 .setCacheMode(CacheMode.GET).list();				
		return view;
	} 
	// FUNZIONE //
	public List<CronologicoSearchTO> loadFunzione(Integer idAppl,Integer idCat) throws Throwable {
			String queryString="" +
			" SELECT a.codi_Nome  as codiNome,  " +
			"        a.desc_descr as descDescr, " +
			"        a.codi_menu as codiMenu    " +
		    "   FROM d_form_help a " +
			"  WHERE a.sequ_id_application = :idAppl " +
		    "    AND a.sequ_id_help_categoria = :idCat  " +
		    "   ORDER BY a.somma_cat_fu";
						  
			SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
			query.addScalar("codiNome",  Hibernate.STRING)
			     .addScalar("descDescr", Hibernate.STRING)
			     .addScalar("codiMenu", Hibernate.STRING);
		    query.setInteger("idAppl", idAppl);
		    query.setInteger("idCat", idCat);
			@SuppressWarnings("unchecked")
			List<CronologicoSearchTO> view = (List<CronologicoSearchTO>)
			query.setResultTransformer(Transformers.aliasToBean(CronologicoSearchTO.class ))
			   	 .setCacheMode(CacheMode.GET).list();				
			return view;
	} 
	// LOV CAPTIOLI //
	public List<CronologicoTO> loadCapitoli (Short annoCap) throws Throwable{
		String queryString="" +
				" SELECT AMM.ESE_ANNO_ESE annoEseCap, " +
                "        lpad(AMM.NUME_STP,2,'0') numeStpCap, " +
                "        AMM.NUME_APP numeAppCap, " +
                "        AMM.DESC_AMM descAmm " +
                "   FROM D_AMMIN AMM ";
		        if (!(annoCap == null)){
		        	queryString = queryString+"  WHERE amm.ese_anno_ese = :annoCap ";	
		        }
		        queryString = queryString+"  ORDER BY 1,2,3";
       

							  
				SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
				query.addScalar("annoEseCap",  Hibernate.SHORT)
				     .addScalar("numeStpCap", Hibernate.INTEGER)
				     .addScalar("numeAppCap", Hibernate.INTEGER)
				     .addScalar("descAmm", Hibernate.STRING);
				if (!(annoCap == null)){
			       query.setShort("annoCap", annoCap);
				}
				@SuppressWarnings("unchecked")
				List<CronologicoTO> view = (List<CronologicoTO>)
				query.setResultTransformer(Transformers.aliasToBean(CronologicoTO.class ))
				   	 .setCacheMode(CacheMode.GET).list();				
				return view;
	}
	// LOV STRUMENTO//
	public List<CronologicoTO> loadStrumento () throws Throwable{
		String queryString="" +
				" SELECT DISTINCT A.NUME_TIPO_STR as numeTipoStr, " +
                "        ATT.DESC_SIGLA  as descStrumento, " +
                "        ATT.DESC_TESTO  as descStrumentoTesto " + 
                "   FROM D_ATTI ATT, D_CRO_DATI A " +
                "  WHERE ATT.FLAG_LEGGE_01 = 1 " +
                "    AND a.nume_tipo_str = att.nume_tipo " +
                "  ORDER BY 2 ";
       

							  
				SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
				query.addScalar("numeTipoStr",  Hibernate.INTEGER)
				     .addScalar("descStrumento", Hibernate.STRING)
				     .addScalar("descStrumentoTesto", Hibernate.STRING);				
				@SuppressWarnings("unchecked")
				List<CronologicoTO> view = (List<CronologicoTO>)
				query.setResultTransformer(Transformers.aliasToBean(CronologicoTO.class ))
				   	 .setCacheMode(CacheMode.GET).list();				
				return view;
	}
	// LOV SOTTO STRUMENTO//
	public List<CronologicoTO> loadSottoStrumento () throws Throwable{
		String queryString="" +
			" SELECT DISTINCT A.NUME_TIPO_SST as numeTipoSst, " +
	        "        ATT.DESC_SIGLA  as descStrumento, " +
	        "        ATT.DESC_TESTO  as descStrumentoTesto " + 
	        "   FROM D_ATTI ATT, D_CRO_DATI A,d_sottostrumenti_plb sst " +
	        "  WHERE ATT.FLAG_LEGGE_01 = 1 " +
	        "    AND a.nume_tipo_sst = att.nume_tipo " +
	        "    AND a.nume_tipo_sst = sst.att_nume_tipo " +
	        "  ORDER BY 2 ";
	       

	   	   SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
					query.addScalar("numeTipoSst",  Hibernate.INTEGER)
					     .addScalar("descSottoStrumento", Hibernate.STRING)
					     .addScalar("descStrumentoTesto", Hibernate.STRING);				
			@SuppressWarnings("unchecked")
			List<CronologicoTO> view = (List<CronologicoTO>)
			query.setResultTransformer(Transformers.aliasToBean(CronologicoTO.class ))
			  	 .setCacheMode(CacheMode.GET).list();				
			return view;
	}
	// LOV TIPO AUTOR //
	public List<CronologicoTO> loadAutor () throws Throwable{
		String queryString="" +
			" SELECT DISTINCT ATT.NUME_TIPO as numeTipoAut, " +
	        "        ATT.DESC_SIGLA  as descAutor, " +
	        "        ATT.DESC_TESTO  as descAutorTesto " + 
	        "   FROM D_ATTI ATT " +
	        "  WHERE ATT.FLAG_LEGGE_01 = 0 " +	        
	        "  ORDER BY 2";
	       

	   	   SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
					query.addScalar("numeTipoAut",    Hibernate.INTEGER)
					     .addScalar("descAutor",      Hibernate.STRING)
					     .addScalar("descAutorTesto", Hibernate.STRING);				
			@SuppressWarnings("unchecked")
			List<CronologicoTO> view = (List<CronologicoTO>)
			query.setResultTransformer(Transformers.aliasToBean(CronologicoTO.class ))
			  	 .setCacheMode(CacheMode.GET).list();				
			return view;
	}
	public List<CronologicoTransTO> caricaRisultati(CronologicoTO to,Date dataA,String oraDa,String oraA) throws Throwable{
		String queryString="" +
	       " SELECT distinct a.codi_id as codiId,      " +
	       "        b.desc_descr        as codiNome,    " +
	       "        b.desc_descr       as descDescr,   " +
	       "        a.data_operaz      as dataOpraz,   " +
	       "        to_char(a.orar_operaz,'hh24:mm') as orarOperaz,  " +
	       "        a.desc_utente      as descUtente,  " +
	       "        a.desc_utente      as codiUtente,  " +
	       "        b.codi_codice  	   as codiTrans,  " +
	       "        b.desc_descr       as descDescrTrans    " +
	       "   FROM d_cro_dati a,D_CRO_TRANS b " +
	       "  WHERE b.codi_codice = a.tra_codi_codice " +
	       "    AND a.data_operaz BETWEEN TO_DATE(nvl(to_char(:dataDa,'DD/MM/YYYY'),'01/01/1900')||'00:00', 'dd/mm/yyyy hh24:mi') " +  
	       "    AND TO_DATE(nvl(to_char(:dataA,'DD/MM/YYYY'),'31/12/4096')||'23:59', 'dd/mm/yyyy hh24:mi') " +  
	       "    AND to_number(to_char(a.orar_operaz,'hh24mi')) BETWEEN nvl(to_number(to_char(TO_DATE(:oraDa,'HH24:MI'),'hh24mi')),0) " +
           "    AND nvl(to_number(to_char(TO_DATE(:oraA,'HH24:MI'),'hh24mi')),9999)";
		
		   // Utente //
	       if (!(to.getDescUtente().equals(""))){
	    	   queryString = queryString+ " AND a.desc_utente = nvl(:utente,a.desc_utente)";
	       }
	       // Funzione //
	       if (to.getTraCodiCodice() != null){
	    	   queryString = queryString+ " AND b.codi_codice = nvl(:traCodiCodice,b.codi_codice)";   
	       }
	       // Strumento //
	       /* TODO
	       if (to.getAnnoEseStr() != null){
	    	   queryString = queryString+ " AND (:annoStr is null or a.anno_ese_str = :annoStr)";
	       }
	       if (to.getNumeTipoStr() != null){
	    	   queryString = queryString+ " AND (:tipoStr is null or a.nume_tipo_str = :tipoStr)";
	       }
	       if (to.getNumeNumStr() != null){
	    	   queryString = queryString+ " AND (:numeStr is null or a.nume_num_str  = :numeStr)";
	       }
	       */
	       queryString = queryString+ " ORDER BY 4,5,8,7";
           
	       SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
			query.addScalar("codiId",  Hibernate.INTEGER)
			     .addScalar("codiNome", Hibernate.STRING)
			     .addScalar("descDescr", Hibernate.STRING)
			     .addScalar("dataOpraz", Hibernate.DATE)
			     .addScalar("orarOperaz", Hibernate.STRING)
			     .addScalar("descUtente", Hibernate.STRING)
			     .addScalar("codiUtente", Hibernate.STRING)
			     .addScalar("codiTrans",  Hibernate.INTEGER)
			     .addScalar("descDescrTrans", Hibernate.STRING);		       
			query.setDate("dataDa", to.getDataOperaz());
			query.setDate("dataA", dataA);
			query.setString("oraDa", oraDa);
			query.setString("oraA", oraA);
			
			// Utente //
			if (!(to.getDescUtente().equals(""))){
				query.setString("utente",to.getDescUtente());
		    }
		    
			// Funzione //
			if (to.getTraCodiCodice() != null){
				query.setInteger("traCodiCodice",to.getTraCodiCodice());	
			}

			// Strumento //
			/* TODO
		    if (to.getAnnoEseStr() != null){
		    	query.setInteger("annoStr",to.getAnnoEseStr());		        
		    }
		    if (to.getNumeTipoStr() != null){
		    	query.setInteger("tipoStr",to.getNumeTipoStr());		        
		    }
		    if (to.getNumeNumStr() != null){
		    	query.setInteger("numeStr",to.getNumeNumStr());		       
		    }
		    */
			@SuppressWarnings("unchecked")
			List<CronologicoTransTO> view = (List<CronologicoTransTO>)
			query.setResultTransformer(Transformers.aliasToBean(CronologicoTransTO.class ))
			   	 .setCacheMode(CacheMode.GET).list();				
			return view;
	}
	
	public BigDecimal loadCodiId(String menu,String funzione) throws Throwable{
		String queryString="" +
			       " SELECT a.codi_id " + 
	               "   FROM D_VOCI_MENU a " +
	               "  WHERE a.men_codi_nome = :menu " +
	               "   AND a.frm_codi_nome = :funzione ";			       
		 SQLQuery query= getHibernateTemplate().getSessionFactory().
		 		getCurrentSession().
				createSQLQuery(queryString);

         query.setString("menu",menu);
         query.setString("funzione",funzione);
         return (BigDecimal)query.uniqueResult();			
	}	
	public List<CronologicoValoriTO> loadValori (BigDecimal code,BigDecimal trans) throws Throwable{
		String queryString="" +
				" SELECT b.desc_descr as campo, " +
                "        a.text_old_val as textOldVal, " +
                "        a.text_new_val as textNewVal, " +
                "        CASE WHEN (NVL(a.text_old_val,'zzz') != nvl(a.text_new_val,'zzz')) THEN 'X' " + 
                "        WHEN (a.text_old_val = a.text_new_val)  THEN '' " +
                "        END AS modificato " +      
                "   FROM D_CRO_VALORI a,D_CRO_CODICI B " +
                "   WHERE a.ccr_codi_codice = b.codi_codice " +
                "     AND a.CRT_CODI_ID = :code " + 
                "     AND a.CRT_TRA_CODI_CODICE = :trans " +
                " ORDER BY a.crt_codi_id, a.nume_ordi_visu";
		       

		   	   SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
						query.addScalar("campo",  Hibernate.STRING)
						     .addScalar("textOldVal", Hibernate.STRING)
						     .addScalar("textNewVal", Hibernate.STRING)
						     .addScalar("modificato", Hibernate.STRING);
					    query.setBigDecimal("code", code);
					    query.setBigDecimal("trans", trans);
				@SuppressWarnings("unchecked")
				List<CronologicoValoriTO> view = (List<CronologicoValoriTO>)
				query.setResultTransformer(Transformers.aliasToBean(CronologicoValoriTO.class ))
				  	 .setCacheMode(CacheMode.GET).list();				
				return view;
	}
	public List<CronologicoTransExcelTO> caricaExcel(CronologicoTO to,Date dataA,String oraDa,String oraA) throws Throwable{
		String queryString="" +
	       " SELECT distinct a.codi_id as codiId,      " +
	       "        a.data_operaz      as dataOpraz,   " +
	       "        to_char(a.orar_operaz,'hh24:mm') as orarOperaz,  " +
	       "        a.desc_utente      as descUtente,  " +
	       "        d.codi_codice      as codiUtente,  " +
	       "        d.desc_descr       as descDescrTrans,    " +
	       "        e.nume_ordi_visu   as ordVisu, " +
	       "        f.desc_descr       as campo, " +
	       "        e.text_old_val     as textOldVal, " +
	       "        e.text_new_val     as textNewVal, " +
	       "        DECODE(CASE WHEN (NVL(e.text_old_val,'zzz') != nvl(e.text_new_val,'zzz')) THEN 'X' " +
	       "        WHEN (e.text_old_val = e.text_new_val)  THEN '_' " + 
	       "        END,'X','X','.')                AS modificato " +
	       "   FROM d_cro_dati a,D_CRO_TRANS d,D_CRO_VALORI e,D_CRO_CODICI f " +
	       "  WHERE d.codi_codice = a.tra_codi_codice " +
	       "    AND e.ccr_codi_codice = f.codi_codice " +
	       "    AND e.CRT_CODI_ID = a.codi_id " +
	       "    AND e.CRT_TRA_CODI_CODICE = a.tra_codi_codice " +
	       "    AND a.data_operaz BETWEEN TO_DATE(nvl(to_char(:dataDa,'DD/MM/YYYY'),'01/01/1900')||'00:00', 'dd/mm/yyyy hh24:mi') " +  
	       "    AND TO_DATE(nvl(to_char(:dataA,'DD/MM/YYYY'),'31/12/4096')||'23:59', 'dd/mm/yyyy hh24:mi') " +  
	       "    AND to_number(to_char(a.orar_operaz,'hh24mi')) BETWEEN nvl(to_number(to_char(TO_DATE(:oraDa,'HH24:MI'),'hh24mi')),0) " +
           "    AND nvl(to_number(to_char(TO_DATE(:oraA,'HH24:MI'),'hh24mi')),9999)";
	       // Funzione //
	       if (to.getTraCodiCodice() != null){
	    	   queryString = queryString+ " AND d.codi_codice = nvl(:traCodiCodice,d.codi_codice)";   
	       }
	       // Utente //
	       if (!(to.getDescUtente().equals(""))){
	    	   queryString = queryString+ " AND a.desc_utente = nvl(:utente,a.desc_utente)";
	       }
	       queryString = queryString+ " ORDER BY 1,4,5,ordVisu";
           
	       SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
			query.addScalar("codiId",  Hibernate.INTEGER)
			     .addScalar("dataOpraz", Hibernate.DATE)
			     .addScalar("orarOperaz", Hibernate.STRING)
			     .addScalar("descUtente", Hibernate.STRING)
			     .addScalar("codiUtente", Hibernate.STRING)
			     .addScalar("descDescrTrans", Hibernate.STRING)
			     .addScalar("ordVisu", Hibernate.STRING)
			     .addScalar("campo", Hibernate.STRING)
			     .addScalar("textOldVal", Hibernate.STRING)
			     .addScalar("textNewVal", Hibernate.STRING)
			     .addScalar("modificato", Hibernate.STRING);			     
			query.setDate("dataDa", to.getDataOperaz());
			query.setDate("dataA", dataA);
			query.setString("oraDa", oraDa);
			query.setString("oraA", oraA);
			// Funzione //
			if (to.getTraCodiCodice() != null){
				query.setInteger("traCodiCodice",to.getTraCodiCodice());	
			}
			//Utente
			if (!(to.getDescUtente().equals(""))){
				query.setString("utente",to.getDescUtente());
		    }
			@SuppressWarnings("unchecked")
			List<CronologicoTransExcelTO> view = (List<CronologicoTransExcelTO>)
			query.setResultTransformer(Transformers.aliasToBean(CronologicoTransExcelTO.class ))
			   	 .setCacheMode(CacheMode.GET).list();				
			return view;
	}
	
}
