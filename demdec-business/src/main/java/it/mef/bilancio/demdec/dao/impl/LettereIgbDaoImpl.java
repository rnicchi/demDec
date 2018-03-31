package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.LettereIgbBO;
import it.almavivaitalia.bilancio.commons.bo.LettereTestiPersBO;
import it.mef.bilancio.demdec.dao.LettereIgbDao;
import it.mef.bilancio.demdec.to.FascicoliViewTO;

import java.math.BigDecimal;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.jdbc.object.SqlQuery;

public class LettereIgbDaoImpl extends AbstractDemDaoImpl<LettereIgbBO> implements LettereIgbDao{
	
	
//	List<LetteraPreRegBO> findLettereByIdDecreto(Long idDecreto)  throws Throwable {
//		
//		Criteria cri = getSession().createCriteria(LetteraPreRegBO.class);
//		addCreateEq(cri, "fascicolo.id", idDecreto);
//		List<LetteraPreRegBO> listLettere=cri.list();
//		
//		return listLettere;
//	}
	
	
/*

	    @Override
	    public List<Decreto> findByDecreto(Decreto decreto) {
	    	
			
//			String annoEse=decreto.getAnnoEsercizio();
//			Integer numero=decreto.getNumero();
//			Integer numeroProvvBil=decreto.getNumeroProvvisorioBil();
//			Integer numeroDefBil=decreto.getNumeroDefinitivoBil();
//			Integer numeroTitolo=null;
//			
//			if (decreto.getNumeroTitolo() != null && decreto.getNumeroTitolo() != NumeroTitolo.NO_VALORE)
//				 numeroTitolo=decreto.getNumeroTitolo().getOrdinal();
//			
//			Date data=decreto.getData();
//			Date dataDefBil=decreto.getDataDefinitivaBil();
	    	
	    	

	        String queryString = "select distinct dec from Decreto dec left join fetch dec.relDecretoAmministrazioni relAmm"
	                + " left join fetch relAmm.relDecretoAmmDecretoPg decPg";

	        QueryHelper<Decreto> qh = new QueryHelper<Decreto>(queryString, Decreto.class, getEntityManager());
	            //aggiunta condizione del flagCertificazione che indica se il decreto � per certificazioni
	        if(decreto.getFlagCertSn() != null){
	            qh.addCondition("dec.flagCertSn = ?",decreto.getFlagCertSn());
	        }
	        if (decreto.getNumero() != null)
	            qh.addCondition("dec.numero = ?", decreto.getNumero());

	        if (decreto.getAnnoEsercizio() != null)
	            qh.addCondition("dec.annoEsercizio = ?", decreto.getAnnoEsercizio());

	        if (decreto.getNumeroTitolo() != null && decreto.getNumeroTitolo() != NumeroTitolo.NO_VALORE)
	            qh.addCondition("dec.numeroTitolo = ?", decreto.getNumeroTitolo());
	        
	        if (decreto.getNumeroProvvisorioBil() != null)
	            qh.addCondition("dec.numeroProvvisorioBil = ?", decreto.getNumeroProvvisorioBil());
	        
	        if (decreto.getNumeroDefinitivoBil() != null)
	            qh.addCondition("dec.numeroDefinitivoBil = ?", decreto.getNumeroDefinitivoBil());
	        
	        if (decreto.getData() != null)
	            qh.addCondition("dec.data = ?", decreto.getData());
	        
	        if (decreto.getDataDefinitivaBil() != null)
	            qh.addCondition("dec.dataDefinitivaBil = ?", decreto.getDataDefinitivaBil());

	        
	        qh.addOrder("dec.numero", false);

	        return qh.getResultList();

	    }
	    
	    
	    
	    
	    
		@Override
		//public List<Decreto> findDecretiByAnnoEseTitNumPrelDataNumBilDataDef(String annoEse, String titolo, Long numPrel, Date data,Long numBil, Date dataDef) {
		public List<Decreto> findDecreti(Decreto filtro) {
			
									
					String annoEse=filtro.getAnnoEsercizio();
					Integer numero=filtro.getNumero();
					Integer numeroProvvBil=filtro.getNumeroProvvisorioBil();
					Integer numeroDefBil=filtro.getNumeroDefinitivoBil();
					Integer numeroTitolo=null;
					
					if (filtro.getNumeroTitolo() != null && filtro.getNumeroTitolo() != NumeroTitolo.NO_VALORE)
						 numeroTitolo=filtro.getNumeroTitolo().getOrdinal();
					
					Date data=filtro.getData();
					Date dataDefBil=filtro.getDataDefinitivaBil();
					
				
					String queryString = "select NUME_TITOLO, NUME_DECRETO, DATA_DECRETO, NUME_PROVVISORIO_BIL,NUME_DEFINITIVO_BIL, DATA_DEFINITIVA_BIL, sequ_id_decreto "+
										 "from d_orpp_decreti where 1=1 ";
							
					if(annoEse!=null)
						queryString+="and anno_ese_decreto =:annoEse ";
					if(numero!=null)
						queryString+="and nume_decreto=:numPrel ";				
					if(numeroTitolo!=null)
						queryString+="and nume_titolo=:titolo ";
					if(numeroProvvBil!=null)
						queryString+="and nume_provvisorio_bil=:numProvvBil ";
					if(numeroDefBil!=null)
						queryString+="and nume_definitivo_bil=:numDefBil ";
					if(data!=null)
						queryString+="and data_decreto=:data ";
					if(dataDefBil!=null)
						queryString+="and data_definitiva_bil=:dataDefBil ";
					
					
					queryString+= "order by 1,2 " ;
			
					
					 try{
							 Query query = getEntityManager().createNativeQuery(queryString);
							 				 
							if(annoEse!=null)
								query.setParameter("annoEse", new Integer(annoEse));
							if(numero!=null)
								query.setParameter("numPrel", new Integer(numero));		
							if(numeroTitolo!=null)
								query.setParameter("titolo", new Integer(numeroTitolo));		
							if(numeroProvvBil!=null)
								query.setParameter("numProvvBil", new Integer(numeroProvvBil));		
							if(numeroDefBil!=null)
								query.setParameter("numDefBil", new Integer(numeroDefBil));		
							if(data!=null)
								query.setParameter("data", data);		
							if(dataDefBil!=null)
								query.setParameter("dataDefBil", dataDefBil);		
				
					
							  List<Decreto> listaDecr=query.getResultList();
							  
							  Decreto decreto=null;
							  
							  for (int i=0; i<listaDecr.size(); i++){
								  decreto=new Decreto();
								  decreto.setAnnoEsercizio(listaDecr.get(i).getAnnoEsercizio());
								  decreto.setNumero(listaDecr.get(i).getNumero());
							  }
							  
							  return listaDecr;
						
					 } catch (NoResultException nre) {
				            return null;
				     }
				}
		
		
				 @Override
				 public List<DecretoAmministrazione> findAmministrazioniByIdDecreto(Long idDecreto) {
					
					 String queryString = "select a.sequ_id_decreto_amm, a.fk_sequ_id_amm, c.codi_stato_previsione, c.desc_amministrazione_01 "+
										  "from d_orpp_decreti_amm a "+ 
										  "inner join d_ogen_amministrazioni c on a.fk_sequ_id_amm = c.sequ_id_amministrazione "+
										  "where a.fk_sequ_id_decreto =:idDecreto "+
										  "order by c.codi_stato_previsione ";
					 try{
						 Query query = getEntityManager().createNativeQuery(queryString);
						 				 
						if(idDecreto!=null){
							query.setParameter("idDecreto", idDecreto);
						}
						
						
						List<Object> lista=query.getResultList();
						
						DecretoAmministrazione decrAmm=null;
						Amministrazione amm=null;
						List<DecretoAmministrazione> listaDecrAmm=new ArrayList<DecretoAmministrazione>();
						
						Iterator<Object>  iter=lista.iterator();
						while (iter.hasNext()) {
							
							Object[] arrayObject=(Object [] ) iter.next();
							decrAmm=new DecretoAmministrazione();
							amm=new Amministrazione();
							
							decrAmm.setNewId(new Long(arrayObject[0].toString()));
							amm.setNewId( new Long(  arrayObject[1].toString()));
							amm.setCodiAmministrazione((String)arrayObject[2]);
							amm.setDescrizione01((String)arrayObject[3]);
							decrAmm.setAmministrazione(amm);
							
							listaDecrAmm.add(decrAmm);
							
							
						}
						
						 return listaDecrAmm;
						
						
					 } catch (NoResultException nre) {
				            return null;
				     }
					
				 }
				 
				 
				 
				 
				 @Override
				 public List<String> getAnnoEseLettereIgb() {
					 
				 
					 String queryString = " select distinct decr.anno_ese_decreto from  d_orpp_lettere_igb lett, d_orpp_decreti decr "
					 					+ " where lett.fk_sequ_id_decreto=decr.sequ_id_decreto "
					 					+ " order by decr.anno_ese_decreto desc ";
											
					 try{
						 Query query = getEntityManager().createNativeQuery(queryString);
						 				 
						
						List<String> lista=query.getResultList();
						
//						query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().setResultTransformer(Transformers.TO_LIST);
//				        List<Object> lista =query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().list();
						
						
						
						return lista;
							 
							 
					} catch (NoResultException nre) {
					    return null;
					}
			}
				 
				 
				 
				 
				 @Override
				 public List<CentroResponsabilita> findCentriResponsabilita(Long idDecrAmm, Long annoEse) {
					 
				 
					 String queryString = " select f.nume_centro_resp, f.desc_centro_resp  "+
											"from d_orpp_decreti_pg d  "+
											"inner join d_obil_capitoli e on e.anno_ese_capitolo =:annoEse  "+
											"                           and e.fk_sequ_id_amm = d.fk_sequ_id_amm  "+
											"                           and e.nume_capitolo = d.nume_capitolo  "+
											"inner join d_obil_centri_resp f on f.anno_ese =:annoEse  "+  
											"                               and f.fk_sequ_id_amm = d.fk_sequ_id_amm  "+
											"                               and f.nume_centro_resp = e.nume_centro_resp  "+
											"where d.fk_sequ_id_decreto_amm =:idDecrAmm  "+
											"group by f.nume_centro_resp, f.desc_centro_resp "+
											"order by 1,2 ";
											
					 try{
						 Query query = getEntityManager().createNativeQuery(queryString);
						 				 
						if(idDecrAmm!=null){
							query.setParameter("idDecrAmm", idDecrAmm);
						}
						
						if(annoEse!=null){
							query.setParameter("annoEse", annoEse);
						}
						
						
					//	List<Object> lista=query.getResultList();
						
						query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().setResultTransformer(Transformers.TO_LIST);
				        List<Object> lista =query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().list();
						
						
						
						
						CentroResponsabilita cdr=null;
						CentroResponsabilitaPK cdrPk=null;
						
						List<CentroResponsabilita> listaCdr=new ArrayList<CentroResponsabilita>();
						
						Iterator<Object>  iter=lista.iterator();
						while (iter.hasNext()) {
							List<Object> listObject= (List) iter.next();
							cdr=new CentroResponsabilita();
							cdrPk=new CentroResponsabilitaPK();
							cdrPk.setNumeroCentroResp(new Integer(  listObject.get(0).toString()));
							cdr.setNewId(cdrPk);
							cdr.setDescrzioneCentroResp(listObject.get(1).toString());
							listaCdr.add(cdr);
						}
						
						
						return listaCdr;
							 
							 
					} catch (NoResultException nre) {
					    return null;
					}
			}
				 
				 
			@Override	 
			public Long[] findNumeriFascicoli(Long idDecreto) {
				
				        String queryString = "select distinct b.nume_fascicolo "+
											 "from d_orpp_reiscrizioni a "+   
											 "inner join d_orpp_fascicoli b on a.fk_sequ_id_fascicolo = b.sequ_id_fascicolo "+
											 "where a.fk_sequ_id_decreto =:idDecreto  "+
											 "order by 1 ";
									 
						
						try {
								Query query = getEntityManager().createNativeQuery(queryString);		 
								if(idDecreto!=null){
									query.setParameter("idDecreto", idDecreto);
								}

								//List<Object> lista=query.getResultList();
								query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().setResultTransformer(Transformers.TO_LIST);
						        List<Object> lista =query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().list();
								
								
								Long[] arrayNumFascicoli=new Long[lista.size()];
								
								Iterator<Object>  iter=lista.iterator();
								int i=0;
								while (iter.hasNext()) {
									BigDecimal numFascicolo=(BigDecimal  ) ( (List)iter.next()).get(0);					
									arrayNumFascicoli[i]=new Long( numFascicolo.toString());						
									i++;
								}
								
								return arrayNumFascicoli;
									 					 
						} catch (NoResultException nre) {
							return null;
						}
					
			}
			
			
			@Override
			public String[] getTestiLettere(String tipoLettera) {
				  	
				String queryString = "select a.text_contenuto "+
							 "from d_orpp_testi_lettere a "
							 + "where a.codi_tipo_lettera=?";   						 
							 
					 
					try {
							Query query = getEntityManager().createNativeQuery(queryString);		 
							if(tipoLettera!=null){
								query.setParameter(1, tipoLettera);
							}
						//	List<String> lista=query.getResultList();
							query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().setResultTransformer(Transformers.TO_LIST);
					        List<Object> lista =query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().list();
							
							
							String[] arrayTestiLettere=new String[lista.size()+1];
							
							Iterator<Object>  iter=lista.iterator();
							int i=1;
							while (iter.hasNext()) {
								//Object[] arrayObject=(Object [] ) iter.next();					
								arrayTestiLettere[i]=((List)iter.next()).get(0).toString();						
								i++;
							}
							
							return arrayTestiLettere;
								 					 
					} catch (NoResultException nre) {
						return null;
					}
				
			}
*/
	
	@Override
	public List<LettereIgbBO> findLettereByCodiUfficioAndStatus(String codiUfficio, String status ) throws Throwable {
		String queryString=
		          " select a from LettereIgbBO a, AnagAmminUfficiBO c "
		        + " where "
		        + " a.anagAmminDem.id.fkAnnoEse = c.id.fkAnnoEse and  "
		        + " a.anagAmminDem.id.numeStp=c.id.fkNumeStp and "
		        + " a.anagAmminDem.id.numeApp=c.id.fkNumeApp and "
		        + " c.id.fkCodiUfficio=:codiUfficio and "
		        + " a.statusLettera=:status "
		        + " order by a.dataLettera, a.anagAmminDem.descAmm "; 
		
		Query query= getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
		
		query.setParameter("codiUfficio", codiUfficio);
		query.setParameter("status", status);
		
		List<LettereIgbBO> listaBo=query.list();
		
//		List<LettereIgbBO> listaBoIgb=new ArrayList<LettereIgbBO>();
//		
//		for (int i = 0; i < listaBo.size(); i++) {
//			LettereIgbBO boIgb=(LettereIgbBO)listaBo.get(i)[0];
//			listaBoIgb.add(boIgb);
//		}
		
		
		return listaBo;
		
	}
	
	
	@Override
	public List<LettereIgbBO> findLettereByStatus(String status) throws Throwable {
		String queryString=
		          " select a from LettereIgbBO a "
		        + " where "
		        + " a.statusLettera=:status "
		        + " order by a.dataLettera, a.anagAmminDem.descAmm "; 
		
		Query query= getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
		
		query.setParameter("status", status);
		
		List<LettereIgbBO> listaBo=query.list();
		
		return listaBo;
		
	}
	
	
	
	
			@Override
			public List<LettereIgbBO> findByLettera(LettereIgbBO lettera) throws Throwable {
				
				       
//				String queryString=" select a.id ,  a.dataLettera , a.statusLettera, "+
//						" a.binaIntLettera,  c.descAmm , d.eserciziDem.id , d.numeNumDecreto "+
				String queryString=
				        " from LettereIgbBO a  , AnagAmminDemBO c, FascicoliBO d where (a.anagAmminDem.id.fkAnnoEse = c.id.fkAnnoEse and  "
				        + "a.anagAmminDem.id.numeStp=c.id.numeStp and a.anagAmminDem.id.numeApp=c.id.numeApp) "+ 
				        " and a.fascicoli.id = d.id " ;       
				
//				String queryString=" select a.sequ_id_lettere_igb as id, a.data_lettera as dataLettera, a.status_lettera as statusLettera, "
//					+ " a.bina_int_lettera as binaIntLettera,  c.desc_amm as descAmm, d.fk_anno_ese , d.nume_num_decreto "+
//				      "from d_lettere_igb a inner join d_anag_ammin_dem c on (a.fk_anno_ese = c.fk_anno_ese and  a.fk_nume_stp=c.nume_stp and a.fk_nume_app=c.nume_app) "+ 
//				      " inner join d_fascicoli d on a.fk_nume_id_fascicolo = d.nume_id_fascicolo " +       
//				      " where 1=1 ";
				       
				
				//TODO scommentare questi filtri
				if(lettera.getFascicoli().getEserciziDem().getId()!=null){
					queryString+=" and d.eserciziDem.id=:annoEse ";			
				}
				if(lettera.getAnagAmminDem()!=null && lettera.getAnagAmminDem().getId()!=null && lettera.getAnagAmminDem().getId().getFkAnnoEse()!=null 
						&& lettera.getAnagAmminDem().getId().getNumeStp()!=null && lettera.getAnagAmminDem().getId().getNumeApp()!=null) {
					queryString+=" and c.id.fkAnnoEse =:annoEse and c.id.numeStp=:numeStp and c.id.numeApp=:numeApp ";
				
				}
				if (lettera.getFascicoli()!=null && lettera.getFascicoli().getNumeNumDecreto()!=null) {
					queryString+=" and d.numeNumDecreto=:fasc ";
				}
				if(lettera.getDataLettera()!=null){
					queryString+=" and a.dataLettera=:dataLettera ";
				}
				if(lettera.getStatusLettera()!=null){
					queryString+=" and a.statusLettera=:statusLettera ";
				}
				
				queryString+=  "   order by a.dataLettera, d.eserciziDem.id, c.descAmm desc "; 
				
				// select a.id , a.dataLettera , a.statusLettera ,  a.binaIntLettera,   c.descAmm,  d.fkAnnoEse , d.numeNumDecreto     from it.almavivaitalia.bilancio.commons.bo.LettereIgbBO a  join AnagAmminDemBO c on (a.fkAnnoEse= c.fkAnnoEse and  a.fkNumeStp=c.numeStp and a.fkNumeApp=c.numeApp)  where 1=1 
//select ahc.id,  cbn.descAmm     from it.almavivaitalia.bilancio.commons.bo.LettereIgbBO ahc  join AnagAmminDemBO cbn on ahc.fascicoli.eserciziDem.id= cbn.id.fkAnnoEse  where 1=1
//select ahc.id, cbn.descAmm from it.almavivaitalia.bilancio.commons.bo.LettereIgbBO ahc join AnagAmminDemBO cbn on ahc.fascicoli.eserciziDem.id= cbn.id.fkAnnoEse
				Query query= getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
						
					if(lettera.getFascicoli().getEserciziDem().getId()!=null){
						query.setParameter("annoEse", lettera.getFascicoli().getEserciziDem().getId());
					}
					if(lettera.getAnagAmminDem()!=null && lettera.getAnagAmminDem().getId()!=null && lettera.getAnagAmminDem().getId().getFkAnnoEse()!=null 
							&& lettera.getAnagAmminDem().getId().getNumeStp()!=null && lettera.getAnagAmminDem().getId().getNumeApp()!=null){
						query.setParameter("annoEse", lettera.getAnagAmminDem().getId().getFkAnnoEse());
						query.setParameter("numeStp", lettera.getAnagAmminDem().getId().getNumeStp());
						query.setParameter("numeApp", lettera.getAnagAmminDem().getId().getNumeApp());
					}
					if(lettera.getFascicoli()!=null && lettera.getFascicoli().getNumeNumDecreto()!=null){
						query.setParameter("fasc", lettera.getFascicoli().getNumeNumDecreto());
					}
					if(lettera.getDataLettera()!=null){
						query.setParameter("dataLettera", lettera.getDataLettera());
					}
					if(lettera.getStatusLettera()!=null){
						query.setParameter("statusLettera", lettera.getStatusLettera());
					}
					
//					query.addScalar("id", Hibernate.BIG_DECIMAL)
//					  .addScalar("anagAmminDem.descAmm", Hibernate.STRING)
////					  .addScalar("fascicoli.eserciziDem.id", Hibernate.LONG)
////					   .addScalar("fascicoli.numeNumDecreto", Hibernate.LONG)
//					  
//					  .addScalar("dataLettera", Hibernate.DATE)
//					  .addScalar("statusLettera", Hibernate.STRING)
//					  .addScalar("binaIntLettera", Hibernate.BLOB);
					List<Object[]> listaBo=query.list();
					
					List<LettereIgbBO> listaBoIgb=new ArrayList<LettereIgbBO>();
					
					for (int i = 0; i < listaBo.size(); i++) {
						LettereIgbBO boIgb=(LettereIgbBO)listaBo.get(i)[0];
						listaBoIgb.add(boIgb);
					}
					
					
					return listaBoIgb;

						 					 
	}
			
			
			@Override
			public LettereIgbBO getLetteraById(Long idLettera) throws Throwable {
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				
				String queryString=" select a.*, c.desc_amm, d.fk_anno_ese, d.nume_num_decreto "+
				       //" from d_orpp_lettere_igb a inner join d_anag_ammin_dem c on a.fk_sequ_id_amm = c.sequ_id_amministrazione    "+ 
				      // " inner join d_fascicoli d on a.fk_sequ_id_fascicolo = d.nume_id_fascicolo " +       
						
  						" from d_lettere_igb a inner join d_anag_ammin_dem c on (a.fk_anno_ese = c.fk_anno_ese and  a.fk_nume_stp=c.nume_stp and a.fk_nume_app=c.nume_app) "+ 
  						" inner join d_fascicoli d on a.fk_nume_id_fascicolo = d.nume_id_fascicolo " +       
				        " where a.sequ_id_lettere_igb=? ";
				       
				
				
					Query query = createSQLQuery(queryString);
								
					query.setParameter(1, idLettera);
					LettereIgbBO letteraBo=(LettereIgbBO)query.uniqueResult();
					
					return letteraBo;
						 					 
	}


			@Override
			public Blob getBlobByIdLettera(BigDecimal idLettera) throws Throwable {
				
				String queryString=
				        "select a.binaIntLettera from LettereIgbBO a where a.id=:idLettera " ; 
				// " a.binaIntLettera from LettereIgbBO a " ; 
				//Query query= getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
				Query query= createQuery(queryString);
				
				if(idLettera!=null){
					query.setParameter("idLettera", idLettera);
				}
				
				Blob blobResult=(Blob)query.uniqueResult();
				
				
				return blobResult;
			}
			
			
			/*
			
			
			
			
			
//			public boolean existsLettera(Long idDecreto, Long idamm, Date dataLettera){
//				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//				String queryString = "select * from 
//			}
				
			
			
			@Override
			public List<LetteraIgb> findAllLettere() throws ParseException {
				
			  	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String queryString = "select a.* "+
							 "from d_orpp_lettere_igb a "						
							 + "order by a.data_lettera, a.anno_ese desc ";   		
				
				String queryString2="	select a.*, c.desc_amministrazione_01 "+
	        "    from d_orpp_lettere_igb a inner join d_ogen_amministrazioni c on a.fk_sequ_id_amm = c.sequ_id_amministrazione    "+                    
	         "   order by a.data_lettera, a.anno_ese, c.desc_amministrazione_01 desc ";
							 
					 
					try {
							Query query = getEntityManager().createNativeQuery(queryString2);		 
									
							List<String> lista=query.getResultList();
													
							List<LetteraIgb> listaLettere=new ArrayList<LetteraIgb>();
							
							Iterator  iter=lista.iterator();
							LetteraIgb letteraIgb=null;
							Object[] arrayObject=null;
							while (iter.hasNext()) {
								letteraIgb=new LetteraIgb();	
								letteraIgb.setAmministrazione(new Amministrazione());
								arrayObject=(Object[]) iter.next();
								
								letteraIgb.setNewId(new Long ( (  arrayObject)[0].toString()) );
							
								letteraIgb.setDataLettera(sdf.parse(     ((Timestamp) arrayObject[3] ).toString()  ));
							
								letteraIgb.setStatusLettera( arrayObject[5].toString());
								letteraIgb.getAmministrazione().setDescrizione01(arrayObject[13].toString());
								
								listaLettere.add(letteraIgb);						
								
							}
							
							return listaLettere;
								 					 
					} catch (NoResultException nre) {
						return null;
					}
				
			}




			@Override
			public boolean inserisciLettera(LetteraIgb lettera, PatUser user, String funzione) {
				
			//	PatUser user=new PatUser("ff");
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        	Date date = new Date();
				
	        	dateFormat.format(date);
				
			    boolean result=false;
				String queryString = "insert into d_orpp_lettere_igb (SEQU_ID_LETTERE_IGB, FK_SEQU_ID_DECRETO, FK_SEQU_ID_AMM, DATA_LETTERA, STATUS_LETTERA, BINA_INT_LETTERA, "+    
	 " ROW_CREATED_USER, ROW_CREATED_DTTM, ROW_UPDATED_FUNZ,  NUME_VERSIONE ) values  (S_ORPP_LETTERE_IGB.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
//						+ ""
//						+ ""
//						+ "(:annoEse, :idAmm, :dataLettera, :numeProgLettera, :statusLettera, :pdf, 'utente',"+new Date()+", 'utente', "
//						+ new Date()+", Predisposizione Lettere, "+1+")";   						 
			
						Query query = getEntityManager().createNativeQuery(queryString);	
						
						
						query.setParameter(1,  lettera.getDecreto().getNewId());

						query.setParameter(2, lettera.getAmministrazione().getId());
		
						query.setParameter(3, lettera.getDataLettera());

						query.setParameter(4, lettera.getStatusLettera());
		
						query.setParameter(5, lettera.getPdfLettera());
				
						query.setParameter(6, user.getNomeCompleto());
						
						query.setParameter(7, date);
						
						query.setParameter(8, funzione);
						
						query.setParameter(9, new Long(1));
						
						 
						int res=query.executeUpdate();
						result=res==1?true:false;
						
				
				
				return result;
			
			}
			
			@Override
			public Long getMaxProgressivoLettera(Long annoEse, Long idAmm, Date dataLettera){
				
				
			  
				String queryString ="select max(a.nume_prog_lettera) "+
									" from d_orpp_lettere_igb a inner join d_ogen_amministrazioni c on a.fk_sequ_id_amm = c.sequ_id_amministrazione " +
									" where 1=1  ";
				
				
				if(annoEse!=null){
					queryString+=" and a.anno_ese=:annoEse ";			
				}
				if( idAmm!=null){
					queryString+=" and c.SEQU_ID_AMMINISTRAZIONE =:amm ";
				}
				if(dataLettera!=null){
					queryString+=" and a.data_lettera=:dataLettera ";
				}
			
				
				Long res=null;
				
				
				try {
						Query query = getEntityManager().createNativeQuery(queryString);
						
						if(annoEse!=null){
							query.setParameter("annoEse",annoEse);
						}
						if( idAmm!=null){
							query.setParameter("amm", idAmm );
						}
						if(dataLettera!=null){
							query.setParameter("dataLettera", dataLettera);
						}
						
						Object result=query.getSingleResult();
						
						if(result!=null){
							res=new Long(result.toString());
						}			
			
				} catch (NoResultException nre) {
					return null;
				}
				
				return res;
				
			}
			
			
			
			   
			    //public List<Amministrazione> findAmmInDecByAnnoEse(String annoEse, String codiceAmministrazione, boolean isUCB) {
		    	 @Override
				 public List<Amministrazione> findAmmInDecByAnnoEse(String annoEse) {

			        String queryString = "select distinct amm from LetteraIgb lettIgb " +
			                " join lettIgb.amministrazione amm " +
			                " join lettIgb.decreto dec ";
			        QueryHelper<Amministrazione> queryHelper = new QueryHelper<Amministrazione>(queryString, Amministrazione.class, getEntityManager());

//			        if (isUCB) {
//			            queryHelper.addCondition("amm.codiAmministrazione = ?", codiceAmministrazione);
//			        }

			        queryHelper.addCondition("amm.annoDecorrenza <= ?", annoEse);
			        queryHelper.addCondition("amm.annoScadenza >= ?", annoEse);
			        queryHelper.addCondition("amm.codiAmministrazione <> ?", "00");
			       // queryHelper.addCondition("dec.annoEsercizio = ? and dec.numeroDefinitivoBil is not null", annoEse);
			        queryHelper.addCondition("dec.annoEsercizio = ?" , annoEse);
			        queryHelper.addOrder("amm.codiAmministrazione", false);


			        return queryHelper.getResultList();
			    }



	                                                                                  

				@Override
				public boolean modificaLettera(LetteraIgb lettera, PatUser user, String funzione) {
					boolean flag=false;
					
					
					 String queryString = "update d_orpp_lettere_igb set data_lettera=?, status_lettera=?, bina_int_lettera=?, row_updated_user=?, row_updated_funz=?, "
					 					+ "row_updated_dttm=sysdate  where fk_sequ_id_amm=? and fk_sequ_id_decreto=? ";
					 				

					Query query = getEntityManager().createNativeQuery(queryString);	
						
					query.setParameter(1, lettera.getDataLettera());
		
					query.setParameter(2, lettera.getStatusLettera());
		
					query.setParameter(3, lettera.getPdfLettera());
		
					query.setParameter(4, user.getNomeCompleto());
					
					query.setParameter(5, funzione);
					
					query.setParameter(6, lettera.getAmministrazione().getNewId());
					
					query.setParameter(7, lettera.getDecreto().getNewId());
					

					int res=query.executeUpdate();
					
					flag=(res>0?true:false);
					 
					return flag;
				}




				@Override
				public boolean existsLetteraByAmmDecr(Long idAmm, Long idDecr) {
					
							if(idAmm==null || idDecr==null){
								throw new NullPointerException();
							}
					
							boolean flag=false;
							
							String queryString=" select a.*  from d_orpp_lettere_igb a  where a.fk_sequ_id_amm =:amm and a.fk_sequ_id_decreto=:decr ";
							       
					
							try {
								Query query = getEntityManager().createNativeQuery(queryString);
		
								query.setParameter("amm", idAmm );
						
								query.setParameter("decr", idDecr );
						
							//	List<String> lista=query.getResultList();
								query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().setResultTransformer(Transformers.TO_LIST);
						        List<Object> lista =query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().list();
								
																									
								if (lista.size()>0) {
									flag=true;
								}
								
								return flag;
									 					 
						} catch (NoResultException nre) {
							return false;
						}
			
				}
				
				@Override
				public Long getIdLetteraByAmmDecr(Long idAmm, Long idDecr) {
					
							if(idAmm==null || idDecr==null){
								throw new NullPointerException();
							}
					
							Long res=null;
							
							String queryString=" select a.sequ_id_lettere_igb  from d_orpp_lettere_igb a  where a.fk_sequ_id_amm =:amm and a.fk_sequ_id_decreto=:decr ";
							       
					
							try {
								Query query = getEntityManager().createNativeQuery(queryString);
		
								query.setParameter("amm", idAmm );
						
								query.setParameter("decr", idDecr );
						
							    res=query.getSingleResult()!=null?(new Long(query.getSingleResult().toString())):null;
//								query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().setResultTransformer(Transformers.TO_LIST);
//						        List<Object> lista =query.unwrap(org.hibernate.ejb.QueryImpl.class).getHibernateQuery().list();
//							 					 
						} catch (NoResultException nre) {
							return null;
						}
							
						return res;
				}
				
			
	}
*/

			
	@Override
	public LettereIgbBO findByUK(Long fkNumeIdFascicolo, Short annoEse, Integer codiStp, Integer numeApp) {
		
		String q=
			     " FROM LettereIgbBO item  "+
			     " WHERE item.fascicoli.id = :fkNumeIdFascicolo " +
			     " AND item.anagAmminDem.id.fkAnnoEse = :annoEse " +
			     " AND item.anagAmminDem.id.numeStp = :numeStp " +
			     " AND item.anagAmminDem.id.numeApp = :numeApp ";
		
		Query query = createQuery(q);
		
		query.setParameter("fkNumeIdFascicolo", fkNumeIdFascicolo)
		.setParameter("annoEse", annoEse)
		.setParameter("numeStp", codiStp)
		.setParameter("numeApp", numeApp);
		
		return (LettereIgbBO) query.uniqueResult();
				
	}


	@Override
	public List<LettereIgbBO> findLettereByIdDecreto(Long idDecreto) throws Throwable {
		
		String q=
			     " FROM LettereIgbBO item  "+
			     " WHERE item.fascicoli.id = :fkNumeIdFascicolo " ;
		
		Query query = createQuery(q);
		
		query.setParameter("fkNumeIdFascicolo", idDecreto);
		
		return (List<LettereIgbBO>) query.list();
	}
	
	
	@Override
	public String findDestinatariMailPec(BigDecimal idLetteraIgb) throws Throwable {
	
		
		 String q=  " SELECT text_email "+
					" FROM d_unita_organizzativa a, d_amm_ucb_ipa b, d_lettere_igb c "+
					" where a.codi_ldap_ou = b.codi_ldap_ou "+ 
					" and b.codi_categoria_ipa = 'OU' "+
					" and b.nume_stp = c.fk_nume_stp "+
					" and b.nume_app = c.fk_nume_app "+ 
					" AND C.sequ_id_lettere_igb = :PARAM ";
		
		 SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);
		 
		 query.addScalar("text_email", Hibernate.STRING);
		 query.setParameter("PARAM", idLetteraIgb);
		  
		 return (String)query.uniqueResult();
	
	}


	@Override
	public String getFlagSemaforoIpa() throws Throwable {
		 String q=  " SELECT flag_manutenzione_sn "+
					" FROM d_semaforo ";
		
		 SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);
		 
		 query.addScalar("flag_manutenzione_sn", Hibernate.STRING);
		  
		 return (String)query.uniqueResult();
	
	}


	@Override
	public Integer aggiornaStatus(BigDecimal idLetteraIgb, String status)
			throws Throwable {
		
		 String q=  " UPDATE d_lettere_igb set status_lettera=:stato "+
					" where sequ_id_lettere_igb=:idLettera ";
		
		 SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(q);
		
		 query.setParameter("stato", status);
		 query.setParameter("idLettera", idLetteraIgb);
		  
		 return (Integer)query.executeUpdate();
	}
	
	
	
	
}
