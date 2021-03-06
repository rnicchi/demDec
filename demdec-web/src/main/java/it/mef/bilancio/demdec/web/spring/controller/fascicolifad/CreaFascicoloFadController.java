/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.VBilDecretiManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.to.AnagCdrDemTO;
import it.mef.bilancio.demdec.to.GestioneFadTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.CreaFadForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;



//@RequestMapping(value = ConstantsRequestMapping.CREA_FASCICOLO_F_A_D)
@RequestMapping(value = ConstantsRequestMapping.CREA_FASCICOLO_F_A_D)
public class CreaFascicoloFadController extends AbstractDemFormController
implements WebConstants, SessionAttributes{
	
	private String startView;
	private String selezioneAmmFadView;
	private String selezioneCdrFadView;
	

	@Autowired
	private GestioneFadManager gestioneFadManager;
	
	@Autowired
	private ListManager listManager;
	
	@Autowired
	private VBilDecretiManager vBilDecretiManager; 

	public void setSelezioneAmmFadView(String selezioneAmmFadView) {
		this.selezioneAmmFadView = selezioneAmmFadView;
	}

	public void setStartView(String startView) {
		this.startView = startView;
	}
	public void setSelezioneCdrFadView(String selezioneCdrFadView) {
		this.selezioneCdrFadView = selezioneCdrFadView;
	}
	
	
	@Override
	public String startController(Context context) throws Throwable {
		context.setCurrentNode("DemDec.menu.Fad.CreaFAD");
		CreaFadForm form= (CreaFadForm) context.getForm();
		 context.setDataModel(WebConstants.LIST_TIPO_DEC, listManager.loadAnagTipoDecreto());
		 context.setDataModel(WebConstants.LIST_ANNO_DEC, listManager.loadEserciziDemCG());
		 context.setDataModel(WebConstants.LIST_ANAG_UFF, listManager.loadAnagUfficiAttivi());
		 context.removeDataModel(WebConstants.LIST_ROWS);
		 context.removeDataModel(WebConstants.LIST_AMMIN_DEM);
		 context.removeDataModel(WebConstants.LIST_SELECTED_AMMS);
		 context.removeDataModel(WebConstants.INDEXES_SELECTED_CDR);
		 context.removeDataModel(WebConstants.AMM_PRECEDENTE);
		 context.removeDataModel(WebConstants.LIST_AMMIN_DEM);
		 
		
		return startView;
		
	}
	
	public String onCaricaAmministrazioni(Context context) throws Throwable {
		CreaFadForm form= (CreaFadForm) context.getForm();
		if (!form.isValid()) {
			return startView;
		}
		
		String annoEsercizio=form.getAnnoDec();
		
		List<AnagAmminDemTO> listaAmm=listManager.getAmminDemCentraliByAnnoEse(annoEsercizio);

		context.setDataModel(WebConstants.LIST_AMMIN_DEM, listaAmm);
		String[] indexes=context.getModel(WebConstants.LIST_ROWS);

		form.setAmmRows(indexes);
		
		return selezioneAmmFadView;
	}
	
	public String onBackFromAmm(Context context) throws Throwable {
		
		CreaFadForm form= (CreaFadForm) context.getForm();
		
		String [] indexes = form.getAmmRows();
		// hidden non conserva gli string[] 
		context.setDataModel(WebConstants.LIST_ROWS, indexes);
		
		List<AnagAmminDemTO> listaAmmSelected=null;
		
		if (indexes!=null&&indexes.length>0) {
			
			listaAmmSelected=new ArrayList<AnagAmminDemTO>();
			String annoEsercizio=form.getAnnoDec();
			List<AnagAmminDemTO> listaAmm=listManager.getAmminDemCentraliByAnnoEse(annoEsercizio);

			// aggiungo al TO la lista dell indice di riga originale 
			for (String stringIndex : indexes) {
				int i= Integer.parseInt(stringIndex);
				AnagAmminDemTO elem=listaAmm.get(i-1);
				elem.setRowIndex(i); // parte da 1 
				listaAmmSelected.add(elem);
			}
			
			// devo tener conto delle amm da cancellare per aggiornare la lista cdr
			List<AnagAmminDemTO> listaAmmSelectedOld=context.getModel(WebConstants.LIST_SELECTED_AMMS);
			
		//  potrei fare ammSelectedToUncheck= lista amm de prima remove all lista amm dopo e me rimangono quelle da cancellare
		//	faccio la differenza con quelle nuove e trovo le amm da cnacellare
			
			if (listaAmmSelectedOld!=null){
			
			listaAmmSelectedOld.removeAll(listaAmmSelected);
				
				// rimuovo gli indici selezionati da deselezionare
				Map<String,String[]> cdrSelected=context.getModel(WebConstants.INDEXES_SELECTED_CDR);
				
			        List<String> indexesList=new ArrayList<String>(Arrays.asList(indexes));
			        List<String>  toDelList= new ArrayList<String>();
			        for (AnagAmminDemTO elem : listaAmmSelectedOld) {
			        	toDelList.add(elem.getRowIndex().toString());
			        	
			        	 // rimuovo i CDR delle amm deselezionate
			        	if (cdrSelected!=null){
			        	cdrSelected.remove(elem.getId().getAmmin());
			        	}
					}
			        
			       indexesList.removeAll(toDelList);
			        
			       String[] sample= new String[]{""};
			       String[] newArray =indexesList.isEmpty()?null:indexesList.toArray(sample);
			       context.setDataModel(WebConstants.LIST_ROWS, newArray);
			       context.setDataModel(WebConstants.LIST_SELECTED_CDRS,generateToList(listaAmmSelected, cdrSelected)); 
			}
			
			context.setDataModel(WebConstants.LIST_SELECTED_AMMS, listaAmmSelected);
		}
		// se deseleziono tutte le amm cancello sia lista amm che cdr
		else{
			context.setDataModel(WebConstants.LIST_SELECTED_AMMS, null);
			context.setDataModel(WebConstants.LIST_SELECTED_CDRS,null); 
			context.setDataModel(WebConstants.INDEXES_SELECTED_CDR,null);
		}
		
		return startView;
		
	}
	public String onCancelFromAmm(Context context) throws Throwable { 
		return startView;
	}
	
	public String onCancelFromCdr(Context context) throws Throwable { 
		return startView;
	}
	
	
//	public String onUncheckAmmin(Context context) throws Throwable { 
//		CreaFadForm form= (CreaFadForm) context.getForm();
//		String[]indexesToDelete=form.getAmmRowsToDelete();
//		
//		String annoEsercizio=form.getAnnoDec();
//		List<AnagAmminDemTO> listaAmm=listManager.getAmminDemCentraliByAnnoEse(annoEsercizio);
//		List<AnagAmminDemTO> ammSelected	=(List<AnagAmminDemTO>) context.getModel(WebConstants.LIST_SELECTED_AMMS);
//		List<AnagAmminDemTO> ammSelectedToUncheck= new ArrayList<AnagAmminDemTO>();
//		
//		
//		if (indexesToDelete!=null&&indexesToDelete.length>0){
//			
//			// rimuovo dalla lista di amm selezionate
//			for (String idx : indexesToDelete) {
//				ammSelectedToUncheck.add(ammSelected.get(Integer.parseInt(idx)-1));			
//			}
//			ammSelected.removeAll(ammSelectedToUncheck);
//			
//			
//			// rimuovo gli indici selezionati da deselezionare
//			String[] indexes=context.getModel(WebConstants.LIST_ROWS);
//			Map<String,String[]> cdrSelected=context.getModel(WebConstants.INDEXES_SELECTED_CDR);
//			
//			
//		        List<String> indexesList=new ArrayList<String>(Arrays.asList(indexes));
//		        List<String>  toDelList= new ArrayList<String>();
//		        for (AnagAmminDemTO elem : ammSelectedToUncheck) {
//		        	toDelList.add(elem.getRowIndex().toString());
//		        	
//		        	 // rimuovo i CDR delle amm deselezionate
//		        	if (cdrSelected!=null){
//		        	cdrSelected.remove(elem.getId().getAmmin());
//		        	}
//				}
//		        
//		       indexesList.removeAll(toDelList);
//		        
//		       String[] sample= new String[]{""};
//		       String[] newArray =indexesList.isEmpty()?null:indexesList.toArray(sample);
//		       context.setDataModel(WebConstants.LIST_ROWS, newArray);
//		       
//		       context.setDataModel(WebConstants.LIST_SELECTED_CDRS,generateToList(ammSelected, cdrSelected)); 
//		     
//		}
//		
//		return startView;
//	}
//	
	
	
	public String onCaricaCdr(Context context) throws Throwable {
		CreaFadForm form= (CreaFadForm) context.getForm();
		if (!form.isValid()) {
			return startView;
		}
		context.removeDataModel( WebConstants.LIST_CDR);
		return selezioneCdrFadView;
	}
	
	@SuppressWarnings("unchecked")
	public String onCaricaCdrFromAmm(Context context) throws Throwable {
		CreaFadForm form= (CreaFadForm) context.getForm();
		if (!form.isValid()) {
			context.removeDataModel(WebConstants.LIST_CDR);
			return selezioneCdrFadView;
		}
		
		List<AnagAmminDemTO> ammSelected	=(List<AnagAmminDemTO>) context.getModel(WebConstants.LIST_SELECTED_AMMS);
		Integer annoEsercizio=Integer.parseInt(form.getAnnoDec());
		String ammIdx= form.getAmmForCdr();
		AnagAmminDemTO amm=ammSelected.get(Integer.parseInt(ammIdx)-1);
		
		List<AnagCdrDemTO>cdrList = listManager.getCdrByAdmin(amm.getId());
		if (cdrList==null) {
			 context.addWarning("warning.no.Cdr", "");
			 return selezioneCdrFadView;
		}
		
		 Map<String,String[]> cdrSelected=context.getModel(WebConstants.INDEXES_SELECTED_CDR);
		 
//		 gestione selected cdr sar� una mappa 
		  if (cdrSelected==null){
			  cdrSelected=new HashMap<String, String[]>();
			  context.setDataModel(WebConstants.INDEXES_SELECTED_CDR,cdrSelected);
		  }
		  
		  // salvo la selezione dei cdr sull amm precednete 
		  if (context.getModel(WebConstants.AMM_PRECEDENTE) !=null&&context.getModel( WebConstants.LIST_CDR)!=null/* altrimenti se rientro dalla pagina principale perde la selezione*/ ){
		  cdrSelected.put(/*amm.getId().getAmmin()*/(String)context.getModel(WebConstants.AMM_PRECEDENTE ), form.getCdrRows());
		 
		  }
		  
		  // il primo giro va a vuoto , ma non � preso in considerazione dall algoritmo ,scrivilo lo stesso
		  context.setDataModel(WebConstants.AMM_PRECEDENTE,amm.getId().getAmmin() );
		  
//		  ripristino la selezione sull amm corrente e la prospetto in pagina
		  if (cdrSelected.get(amm.getId().getAmmin())!=null){
			  form.setCdrRows(cdrSelected.get(amm.getId().getAmmin()));
		  }
		  else{
			  form.setCdrRows(null);
		  }
		 
//		  lo setto qui altrimenti interferisce con l 'if dei cdrselected
		 context.setDataModel(WebConstants.LIST_CDR, cdrList);
		return selezioneCdrFadView;
	}
	
	@SuppressWarnings("unchecked")
	public String onBackFromCdr(Context context) throws Throwable {
		CreaFadForm form= (CreaFadForm) context.getForm();
		String ammIdx= form.getAmmForCdr();
		 Map<String,String[]> cdrSelected=context.getModel(WebConstants.INDEXES_SELECTED_CDR);
		  if (cdrSelected==null){
			  cdrSelected=new HashMap<String, String[]>();
			  context.setDataModel(WebConstants.INDEXES_SELECTED_CDR,cdrSelected);
		  }
		  
		  List<AnagAmminDemTO> ammSelected	=(List<AnagAmminDemTO>) context.getModel(WebConstants.LIST_SELECTED_AMMS); 
		  
		  int ammIntIdx= Integer.parseInt(ammIdx);
		  AnagAmminDemTO selectedAmm= ammSelected.get(ammIntIdx-1);
		// salvo l ultima selezione prima del click 
		  cdrSelected.put(selectedAmm.getId().getAmmin(), form.getCdrRows());
		
		context.setDataModel(WebConstants.LIST_SELECTED_CDRS, generateToList(ammSelected, cdrSelected));
		
		return startView;
	}
	
	// creo la lista di CDR oggetti a partire dalla mappa degli indici
	private List<AnagCdrDemTO> generateToList(List<AnagAmminDemTO> ammSelected, Map<String,String[]> cdrSelected) throws Throwable{
		
		List<AnagCdrDemTO> cdrList= new ArrayList<AnagCdrDemTO>();
		if (cdrSelected==null) {
			return cdrList;
		}
		AnagCdrDemTO elem=null;
		for (AnagAmminDemTO amm : ammSelected) {
			
			String[] indexes=cdrSelected.get(amm.getId().getAmmin());
			
			
			if (indexes!=null&&indexes.length>0) {
				
				List<AnagCdrDemTO> listacdr=listManager.getCdrByAdmin(amm.getId());
	
				// aggiungo al TO la lista dell indice di riga originale 
				for (String stringIndex : indexes) {
					int i= Integer.parseInt(stringIndex);
					 elem=listacdr.get(i-1);
					 elem.setRowIndex(i); // mi ricordo la riga dell indice della checkbox 
					cdrList.add(elem);
				}
				
			}
			
		}
		
		return cdrList;
		
	}
	
	
	public String onCaricaTipologia(Context context) throws Throwable {
		CreaFadForm form= (CreaFadForm) context.getForm();
		if(form.getFlagNormativo()!=null && form.getFlagNormativo().equals("1")){
			context.setDataModel(WebConstants.LIST_TIPOLOGIA_DEC, listManager.tipologiaDecretoList(22));
			form.setTipologiaDec("4");
			form.setTipoDec(String.valueOf("22"));
			context.setDataModel(WebConstants.CHK_NORMATIVO, 1);
		}else
		if (form.isValid()) {
			 context.setDataModel(WebConstants.LIST_TIPOLOGIA_DEC, listManager.tipologiaDecretoList(Integer.parseInt(form.getTipoDec())));
			 form.setTipologiaDec("");
			 String norm=form.getNorm();
			 //controllo se ho cliccato il checbox normativo
			 if(norm!=null && norm.equals("1")){
				 form.setTipoDec("");
				 context.setDataModel(WebConstants.LIST_TIPOLOGIA_DEC, null);
			 }
			 context.setDataModel(WebConstants.CHK_NORMATIVO, 0);
		}
		
		
		
		return startView;
	}
	
//	
//	public String onUncheckCdr(Context context) throws Throwable { 
//		CreaFadForm form= (CreaFadForm) context.getForm();
//		String[]indexesToDelete=form.getCdrRowsToDelete();
//		
//		List<AnagCdrDemTO> cdrSelectedList= context.getModel(WebConstants.LIST_SELECTED_CDRS);
//		
//		if (indexesToDelete!=null&&indexesToDelete.length>0){
//			
//			List<AnagCdrDemTO> cdrSelectedToUnchecList= new ArrayList<AnagCdrDemTO>();
//			// rimuovo dalla lista dei cdr selezionati
//			for (String idx : indexesToDelete) {
//				cdrSelectedToUnchecList.add(cdrSelectedList.get(Integer.parseInt(idx)-1));
//			}
//			cdrSelectedList.removeAll(cdrSelectedToUnchecList);
//
//			// ricostruisco la mappa degli indici dei cdr da salvare in sessione per la jsp
//			Map<String,List<String>> mapTmp = new HashMap<String, List<String>>();	
//			List<String> values=null;
//			
//			for (int i=0;i<cdrSelectedList.size();i++) {
////				rilevo il cambio amministrazione tra i cdr
//				if (i!=0&&cdrSelectedList.get(i-1).getAnagAmminDem().getId().equals(cdrSelectedList.get(i).getAnagAmminDem().getId())){
//					values=mapTmp.get(cdrSelectedList.get(i).getAnagAmminDem().getId().getAmmin() );
//					values.add(cdrSelectedList.get(i).getRowIndex().toString());
////					map.put(cdrSelectedList.get(i).getAnagAmminDem().getId().getAmmin(), values); // potrebbe essere superfluo
//				}
//				else{
//					values= new ArrayList<String>();
//					values.add(cdrSelectedList.get(i).getRowIndex().toString());
//					mapTmp.put(cdrSelectedList.get(i).getAnagAmminDem().getId().getAmmin(),values );
//				}
//				
//			}
////			trasformo la mappa di List<String> in un una mappa di String[]
//			Map<String,String[]> indexesMap = new HashMap<String, String[]>();	
//		       String[] sampleArray= new String[]{""};
//		       
//			for (String string : mapTmp.keySet()) {
//				List<String> elem= mapTmp.get(string);
//				indexesMap.put(string, elem.isEmpty()?null:elem.toArray(sampleArray));
//								
//			}
//			context.setDataModel(WebConstants.INDEXES_SELECTED_CDR,indexesMap);
//		     
//		}
//		
//		return startView;
//	}
	
	
	
	public String onCreaFad(Context context) throws Throwable {
			
		CreaFadForm form= (CreaFadForm) context.getForm();
		if (!form.isValid()){
			return startView;
		}
		
		if (form.getNumPatr()!=null&&!form.getNumPatr().isEmpty()){
			String guidPatr=vBilDecretiManager.findGuidSiPatrBynumPatr(Integer.parseInt(form.getNumPatr()),Integer.parseInt(form.getAnnoDec()));
			
			if(guidPatr == null||guidPatr.isEmpty()){
					context.addError("err.decreto.patrimonio.not.exists", "");
					return  startView;
			}
		}
		
		GestioneFadTO to = new GestioneFadTO();
		to.setChiamante(Constants.CREAZIONE_GESTIONE_FAD_CHIAMANTE_DEMDEC);
		to.setTipoDec(Integer.parseInt(form.getTipoDec()));
		to.setNumeroDec(Integer.parseInt(form.getNumDec().trim()));
		to.setAnnoDec(Integer.parseInt(form.getAnnoDec()));
		to.setDescDec(form.getDescDec());
		to.setTipologiaDec(Integer.parseInt(form.getTipologiaDec()));
		
		to.setUfficio(form.getUfficio());
		to.setNumPatr(form.getNumPatr()==null||form.getNumPatr().isEmpty()?null:Integer.parseInt(form.getNumPatr()));
		to.setFlagNormativo(form.getFlagNormativo()!=null?Integer.valueOf(form.getFlagNormativo()):null);
			
		List<AnagCdrDemTO> cdrSelectedList = context.getModel(WebConstants.LIST_SELECTED_CDRS);
		List<AnagAmminDemTO> ammSelected =context.getModel(WebConstants.LIST_SELECTED_AMMS); 
		to.setAmmList(ammSelected);
		to.setCdrList(cdrSelectedList);
	
		Utente u= getUtenteInSessione();
		to.setCodiUtente(u.getUtente().getCodiUtente());
		AnagUfficiTO uffCreatore= u.getUtente().getUtenteProfilo(u.getProfiloInUso().getCodiProfilo()).getAnagUffici();
		to.setUfficioCreatore(uffCreatore!=null?uffCreatore.getId():"0");
		
		context.valorizeAudit(to, NomeFunzioneConstants.CREA_FASCICOLO);
		
		EsitoTO	esito = gestioneFadManager.creaFAD(to);
		
		if (esito!=null&&esito.getCodice().equals(DEMBILConstants.ESITO_OK)){
			context.addInfo("info.crea.fad.success","");
		}
		else if (esito!=null&&esito.getCodice().equals(DEMBILConstants.ESITO_KO_ERR)){
			context.addError(esito.getDescrizione(),"");
		}
//		else if (esito!=null&&esito.getCodice().equals(DEMBILConstants.ESITO_KO)){
//			context.addError("error.generic", esito.getDescrizione());
//		}
		else{
			context.addError("error.generic", esito.getDescrizione());
		}
		
		return startView;
	}
	

}