package it.almavivaitalia.bilancio.commons.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.AbstractCommonBO;
import it.almavivaitalia.bilancio.commons.bo.CroCodiciBO;
import it.almavivaitalia.bilancio.commons.bo.CroDatiBO;
import it.almavivaitalia.bilancio.commons.bo.CroDatiBOId;
import it.almavivaitalia.bilancio.commons.bo.CroTransBO;
import it.almavivaitalia.bilancio.commons.bo.CroValoriBO;
import it.almavivaitalia.bilancio.commons.bo.CroValoriBOId;
import it.almavivaitalia.bilancio.commons.dao.ActionDao;
import it.almavivaitalia.bilancio.commons.dao.CroCodiciDao;
import it.almavivaitalia.bilancio.commons.dao.CroDatiDao;
import it.almavivaitalia.bilancio.commons.dao.CroFunzCampiDao;
import it.almavivaitalia.bilancio.commons.dao.CroTransDao;
import it.almavivaitalia.bilancio.commons.dao.CroValoriDao;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.bilancio.commons.to.CroFunzCampiTO;
import it.almavivaitalia.bilancio.commons.to.CronoValoriReturnTO;
import it.almavivaitalia.bilancio.commons.to.CronoValoriTO;
import it.almavivaitalia.bilancio.commons.utils.StringUtil;
import it.almavivaitalia.bsn.sh.utils.ReflectionUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Hibernate;

public class CronologicoManagerImpl extends AbstractCommonManagerImpl implements CronologicoManager {
	
	private CroFunzCampiDao croFunzCampiDao;
	private CroValoriDao croValoriDao;
	private CroDatiDao  croDatiDao;
	private CroCodiciDao croCodiciDao;
	private CroTransDao croTransDao;
	private ActionDao actionDao;
	
	public void salvaCronologico(
			AbstractCommonBO vecchio,
			AbstractCommonBO nuovo,
			CroDatiBO croDatiBO,
			List<CronoValoriTO> listCronoValori,
			Short codiceTransazione,
			String nomeFunzione, 
			String codiUtente
	) throws Throwable{
/*		try {
			INIZIALIZZAZIONI
			@SuppressWarnings("unchecked")
			Class<? extends AbstractCommonBO> persistentClass=vecchio==null?Hibernate.getClass(nuovo):Hibernate.getClass(vecchio);
			
			Set<CronoValoriTO> cronoValori = new HashSet<CronoValoriTO>();
			
			CREO CRO_DATI
			if(croDatiBO==null){
				croDatiBO = new CroDatiBO();
			}
			
			CREO LA LISTA DEI CRONO VALORI
			if(listCronoValori==null){
				listCronoValori=new ArrayList<CronoValoriTO>();
			}
			
			//recupero dalla tabella d_cro_funz_campi i campi da gestire
			List<CroFunzCampiTO> croAssoc= croFunzCampiDao.loadListByNomeFunzioneTableNameCroTrans(
																nomeFunzione, 
																croFunzCampiDao.getTableNameByClass(persistentClass), 
																codiceTransazione.toString());

			Map<String,CroFunzCampiTO> property=new LinkedHashMap<String, CroFunzCampiTO>();
			
			if(croAssoc!=null && croAssoc.size() > 0){
				
				//altre colonne da gestire
				for(CroFunzCampiTO assoc:croAssoc){
					property.put(assoc.getFieldName(), assoc);
				}
				
				if(property.size()>0){
					gestisciCronologico(vecchio, nuovo, croDatiBO, cronoValori, property);
				}			
			}
			
			listCronoValori.addAll(cronoValori);
			
			salvaCronologico(
					croDatiBO,
					listCronoValori,
					codiceTransazione,
					nomeFunzione, 
					codiUtente);
		} catch (Throwable e) {
			e.printStackTrace();
		}		*/
		
	}	
	
	public void salvaCronologico(
			CroDatiBO croDatiBO,
			List<CronoValoriTO> listCronoValori,
			Short codiceTransazione,
			String nomeFunzione, 
			String codiUtente
	) throws Throwable{
		
/*		BEGIN CODICE TRANSAZIONE
		croDatiBO.setCroTrans(croTransDao.loadById(CroTransBO.class, codiceTransazione));
		END CODICE TRANSAZIONE
		BEGIN MENU 
		croDatiBO.setAction(actionDao.loadByCodiAction(nomeFunzione));
		END MENU
		 BEGIN AUDIT 
		croDatiBO.setDescUtente(codiUtente);
		croDatiBO.setDataOperaz(Calendar.getInstance().getTime());
		croDatiBO.setOrarOperaz(Calendar.getInstance().getTime());
		croDatiBO.setRowCreatedDttm(Calendar.getInstance().getTime());
		croDatiBO.setRowCreatedForm(nomeFunzione);
		croDatiBO.setRowCreatedUser(codiUtente);
		croDatiBO.setRowUpdatedDttm(Calendar.getInstance().getTime());
		croDatiBO.setRowUpdatedForm(nomeFunzione);
		croDatiBO.setRowUpdatedUser(codiUtente);
		 END AUDIT 
			
		ADD AUDIT TO VALORI
		for(CronoValoriTO v:listCronoValori){
			copyAllAudit(croDatiBO, v);
		}
		
		ADD AUDIT TO VALORI
		inserisciCro(croDatiBO, listCronoValori);*/
	}
	
	
	
	
	
/*	private CronoValoriReturnTO inserisciCro(CroDatiBO croDatiBO, List<CronoValoriTO> list) throws Throwable{
		CronoValoriReturnTO rt = new CronoValoriReturnTO();
		// Imposto Valori Di Default Per il Ritorno
		rt.setCodice(0);
		rt.setMessage("");
		// Controllo esistenza codice transazione		
		CroTransBO bo = croTransDao.existsCroTrans(croDatiBO.getCroTrans().getId());
		
		if (bo==null){
			// Errore codice Transazione
		  rt.setCodice(1);
		  rt.setMessage("Attenzione il codice transazione per il cronologico non e valido."+""+croDatiBO.getCroTrans().getId());
		}else{
			Integer idCroDati = null;
			
			// Ok codice Transazione
			if(croDatiBO.getId()==null){
				idCroDati = croDatiDao.getNextSequenceVal();
				CroDatiBOId id = new CroDatiBOId(); 
				id.setCodiId(idCroDati);
				id.setTraCodiCodice(croDatiBO.getCroTrans().getId());
				croDatiBO.setId(id);
			}else{
				idCroDati=croDatiBO.getId().getCodiId();
			}

			croDatiDao.saveOrUpdate(croDatiBO);
			
			// Inserimento Valori ...
			Short j = 0;
			for (CronoValoriTO elem : list){
				// controllo esistenza Cro Codici
				j++;
				CroCodiciBO codiciBO = croCodiciDao.existsCodici(elem.getCodice());
				if (codiciBO == null){
					rt.setCodice(1);
					rt.setMessage("Attenzione il codice valore per il cronologico non e valido."+""+elem.getCodice());
				}else{
					//verifico esistenza del valore
					CroValoriBOId valoriBOId = new CroValoriBOId();
					valoriBOId.setCrtTraCodiCodice(croDatiBO.getCroTrans().getId());
					valoriBOId.setCrtCodiId(idCroDati);					
					valoriBOId.setCcrCodiCodice((short) elem.getCodice());	
					valoriBOId.setNumeOrdiVisu(elem.getNumeOrdiVisu());
					
					CroValoriBO valoriBO=croValoriDao.loadById(CroValoriBO.class, valoriBOId);
					
					if(valoriBO==null){
						valoriBO = new CroValoriBO();
						valoriBO.setId(valoriBOId);
					}
					
					valoriBO.setTextOldVal(elem.getOldValue());
					valoriBO.setTextNewVal(elem.getNewValue());
					
					 audit 
					copyAllAudit(elem, valoriBO);
					 audit 
					croValoriDao.saveOrUpdate(valoriBO);
				} // controllo esistenza Cro Dati					
			}	// Chiusura FOR	
		} 	  // Controllo esistenza codice transazione //		
		return rt;
	} // Chiusura Metodo	
*/
	private void gestisciCronologico(AbstractCommonBO vecchio, AbstractCommonBO nuovo, CroDatiBO croDatiBO, Set<CronoValoriTO> cronoValori,  Map<String,CroFunzCampiTO> property) throws Throwable{
		
/*		String oldRaggruppamento="";
		String newRaggruppamento="";
		
		CroFunzCampiTO previousLine=null;
		
		//confronto le chiavi
		for(Map.Entry<String, CroFunzCampiTO> c:property.entrySet()){
			Object old=vecchio!=null?ReflectionUtil.getPropertyValue(c.getKey(), vecchio):"";
			Object _new=nuovo!=null?ReflectionUtil.getPropertyValue(c.getKey(), nuovo):"";
			
			//cro_dati
			if(!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(c.getValue().getColumnCroDati())){
				ReflectionUtil.setPropertyValue(
												StringUtil.toCamelCase(c.getValue().getColumnCroDati().toLowerCase()), 
												croDatiBO, 
												it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(_new)?old:_new
												);
			}
			
			//decodifica
			if(!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(c.getValue().getSqlQueryDecode())){
				
				String paramName=c.getKey().replace("id.", "").replace(".id", "");
				
				if(!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(old)){
					old=croFunzCampiDao.decode(
											c.getValue().getSqlQueryDecode(), 
											paramName, 
											old.toString());
				}
				if(!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(_new)){
					_new=croFunzCampiDao.decode(
											c.getValue().getSqlQueryDecode(), 
											paramName, 
											_new.toString());					
				}
			}
			
			if(c.getValue().getGruppo()==null){
				
				//verifico se ho un precedente gruppo
				if(previousLine!=null&&previousLine.getGruppo()!=null){
					//inserisco il gruppo
					addCronoValoriToList(
							cronoValori,
						    Integer.valueOf(previousLine.getFkCroCodici()), 
						    previousLine.getNumeOrdiVisu(),
						    oldRaggruppamento, 
						    newRaggruppamento, 
						    previousLine.getCheckEquality().equals("1"));								
				}
				
				//inserisco il valore corrente
				addCronoValoriToList(
						cronoValori,
					    Integer.valueOf(c.getValue().getFkCroCodici()), 
					    c.getValue().getNumeOrdiVisu(),
					    old, 
					    _new, 
					    c.getValue().getCheckEquality().equals("1"));	
				
				oldRaggruppamento="";
				newRaggruppamento="";						
			}else{
				
				//verifico se ho un precedente gruppo e se sono nel medesimo gruppo
				if(previousLine!=null&&previousLine.getGruppo()!=null&&previousLine.getGruppo().intValue()!=c.getValue().getGruppo().intValue()){
					//inserisco il gruppo
					addCronoValoriToList(
							cronoValori,
						    Integer.valueOf(previousLine.getFkCroCodici()), 
						    previousLine.getNumeOrdiVisu(),
						    oldRaggruppamento, 
						    newRaggruppamento, 
						    previousLine.getCheckEquality().equals("1"));
					
					oldRaggruppamento="";
					newRaggruppamento="";						
				}		
				
				if(!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(old)){
					if(it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(oldRaggruppamento)){
						oldRaggruppamento=c.getValue().getPatternGroup();
					}
				}
				if(!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(_new)){
					if(it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(newRaggruppamento)){
						newRaggruppamento=c.getValue().getPatternGroup();
					}	
				}
				
				//devo comporre i valori da inserire nel cronologico secondo il pattern_group
				//es. ATT_NUME_TIPO,NUME_NUM,ESE_ANNO_ESE
				if(!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(old)){
					oldRaggruppamento=oldRaggruppamento.replaceAll(StringUtil.camelCaseTranslater(c.getKey().startsWith("id.")?c.getKey().replaceFirst("id.", ""):c.getKey()), old.toString());
				}
				if(!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(_new)){
					newRaggruppamento=newRaggruppamento.replaceAll(StringUtil.camelCaseTranslater(c.getKey().startsWith("id.")?c.getKey().replaceFirst("id.", ""):c.getKey()), _new.toString());
				}
			}
			
			previousLine=c.getValue();
		}
		
		if(previousLine!=null&&previousLine.getGruppo()!=null&&(!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(oldRaggruppamento)||!it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty(newRaggruppamento))){
			//inserisco il gruppo
			addCronoValoriToList(
					cronoValori,
				    Integer.valueOf(previousLine.getFkCroCodici()), 
				    previousLine.getNumeOrdiVisu(),
				    oldRaggruppamento, 
				    newRaggruppamento, 
				    previousLine.getCheckEquality().equals("1"));						
		}				*/
	}
	
	
	/**
	 * 
	 * @param listCronoValori 	Lista su cui verrà inserito l'eventuale CronoValoriTO
	 * @param codiCodice		codice da passare per la costruzione di CronoValoriTO
	 * @param numeOrdiVisu      ordine di visualizzazione da passare a CronoValoriTO
	 * @param old				vecchio valore
	 * @param _new				nuovo valore
	 * @param checkEquality		se true verifica se vecchio e nuovo sono uguali e in caso affermativo non lo inserisce in lista
	 * @return					true o false come da chiamata Set.add()
	 */
	public boolean addCronoValoriToList(
			Set<CronoValoriTO> listCronoValori,
			int codiCodice, 
			short numeOrdiVisu, 
			Object old, 
			Object _new,
			boolean checkEquality){
		
/*		String strOld="";
		String strNew="";
		Pattern p = Pattern.compile("[-+]?[0-9]*,?[0-9]*");
		
		if(_new==null){
			if(old!=null){//cerco di verificare se la sua rappresentazione testuale è un numero
				Matcher m=p.matcher(old.toString().replaceAll(".", ""));
				if(m.matches()){
					strNew="0";
				}
			}
		}else{
			strNew=_new.toString().replace(".", "");
			strNew=strNew.replace(",00", "");
		}
		
		if(old==null){
			if(_new!=null){//cerco di verificare se la sua rappresentazione testuale è un numero
				Matcher m=p.matcher(_new.toString().replaceAll(".", ""));
				if(m.matches()){
					strOld="0";
				}
			}
		}else{
			strOld=old.toString();
			strOld=strOld.toString().replace(".", "");
			strOld=strOld.replace(",00", "");
		}		
		
		if(checkEquality&&strOld.equals(strNew)){
			return false;
		}
		
		boolean added=false;	
		
		CronoValoriTO cronoValoriTO =new CronoValoriTO(codiCodice,numeOrdiVisu++);
		cronoValoriTO.setNewValue(_new==null?"":_new.toString());
		cronoValoriTO.setOldValue(old==null?"":old.toString());		
		
		added=listCronoValori.add(cronoValoriTO);
		
		return added;*/
		return false;
	}	
	
	/**
	 * 
	 * @param listCronoValori 	Lista su cui verrà inserito l'eventuale CronoValoriTO
	 * @param codiCodice		codice da passare per la costruzione di CronoValoriTO
	 * @param numeOrdiVisu      ordine di visualizzazione da passare a CronoValoriTO
	 * @param old				vecchio valore
	 * @param _new				nuovo valore
	 * @param checkEquality		se true verifica se vecchio e nuovo sono uguali e in caso affermativo non lo inserisce in lista
	 * @param insert		    se true continua l'elaborazione
	 * @return					true o false come da chiamata Set.add()
	 */
	public boolean addCronoValoriToList(
			Set<CronoValoriTO> listCronoValori,
			int codiCodice, 
			short numeOrdiVisu, 
			Object old, 
			Object _new,
			boolean checkEquality,
			boolean insert){
		
		if(insert){
			return addCronoValoriToList(listCronoValori, codiCodice, numeOrdiVisu, old, _new, checkEquality);
		}else{
			return false;
		}
	}		


	public String makeValue(String ... tokens){
		StringBuilder sb =  new StringBuilder();
		for(String token:tokens){
			sb.append(token);
		}
		return sb.toString();
	}

	public void setCroFunzCampiDao(CroFunzCampiDao croFunzCampiDao) {
		this.croFunzCampiDao = croFunzCampiDao;
	}

	public void setCroValoriDao(CroValoriDao croValoriDao) {
		this.croValoriDao = croValoriDao;
	}

	public void setCroDatiDao(CroDatiDao croDatiDao) {
		this.croDatiDao = croDatiDao;
	}

	public void setCroCodiciDao(CroCodiciDao croCodiciDao) {
		this.croCodiciDao = croCodiciDao;
	}

	public void setCroTransDao(CroTransDao croTransDao) {
		this.croTransDao = croTransDao;
	}

	public void setActionDao(ActionDao actionDao) {
		this.actionDao = actionDao;
	}


	
	
}