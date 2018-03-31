package it.mef.bilancio.demdec.web.spring.controller.funzionidiservizio;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTOId;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.GestioneUtentiManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.GestioneUtentiForm;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//@RequestMapping(value = ConstantsRequestMapping.GESTIONE_UTENTI)
public abstract class GestioneUtentiLiv2Controller extends AbstractDemFormController {

public String getUtenteView() {
		return utenteView;
	}


	@Autowired
	protected ListManager listManager;
	
	@Autowired
	private GestioneUtentiManager gestioneUtentiManager;
	
	private String startView;
	private String utenteView;
	
	public void setStartView(String startView) {
		this.startView = startView;
	}
	public void setUtenteView(String utenteView) {
		this.utenteView = utenteView;
	}
	
	public String getStartView() {
		return startView;
	}
	public ListManager getListManager() {
		return listManager;
	}
	public GestioneUtentiManager getGestioneUtentiManager() {
		return gestioneUtentiManager;
	}
	protected boolean isProfileChange(Context context, List<UtenteProfiloTO> listaProfili, Integer newProfilo) throws Exception {
		boolean esito = false;
	
		if (newProfilo == null) throw new Exception("Profilo null");	//impossibile!!! Il validator controlla prima
		if (listaProfili == null || listaProfili.size() == 0) return false;
	/*	if (!listaProfili.get(0).getProfilo().getId().equals(newProfilo)) {
			esito = true;
			context.addError("errore.profilo.utente.cambio");
		}
	 */
		return esito;
	}
	
	//funzione che confronta due amministrazioni
	private boolean amministrazioniUguali(AnagAmminDemTO amm1, AnagAmminDemTO amm2){
		boolean flagAmm=false;
		if(amm1==null && amm2==null){
			flagAmm= true;
		}
		if(amm1!=null && amm2!=null) {
			if (   amm1.getId().getFkAnnoEse().shortValue() == amm2.getId().getFkAnnoEse().shortValue()
			    && amm1.getId().getNumeApp().intValue() == amm2.getId().getNumeApp().intValue() 
			    && amm1.getId().getNumeStp().intValue() == amm2.getId().getNumeStp().intValue()){
				
				flagAmm= true;
			}
		}
		
		return flagAmm;
	}
	
	protected boolean isProfiloGiaIncluso(UtenteProfiloTO utProfTo, List<UtenteProfiloTO> listProfiliUfficiAmm) {
		boolean flagGiaIncluso=false;
		if (listProfiliUfficiAmm.contains(utProfTo)) 
			return true;	//cattura elementi uguali nella stessa operazione
		
		boolean flag=false;
		for(UtenteProfiloTO profUffEsistente : listProfiliUfficiAmm) {
			flag=false;
			if( utProfTo.getProfilo().getId().intValue()==profUffEsistente.getProfilo().getId().intValue() ){
				flag=true;
				//verifico se una delle due amm è not null
				if(profUffEsistente.getAnagAmminDem()!=null  || utProfTo.getAnagAmminDem()!=null) {
					//verifico se le due amm sono uguali
					if(amministrazioniUguali(profUffEsistente.getAnagAmminDem(), utProfTo.getAnagAmminDem() ) ) {
						//amministraz
						flagGiaIncluso=true;//Esci e non inserisci
						break;
					}else {
						flagGiaIncluso=false;//Esci e inserisci
					}
				//le due amm sono entrambe null quindi verifico se uno dei due  uffici è not null
				}else if(profUffEsistente.getAnagUffici()!=null  || utProfTo.getAnagUffici()!=null){
					if (profUffEsistente.getAnagUffici()!=null && utProfTo.getAnagUffici()!=null && profUffEsistente.getAnagUffici().getId().equalsIgnoreCase(utProfTo.getAnagUffici().getId() ) ) {
						flagGiaIncluso=true;//Esci e non inserisci
						break;
					}else{
						flagGiaIncluso=false;//Esci e inserisci
					}
				//i due uffici sono entrambi null
				}else {
					flagGiaIncluso=true;//Esci e non inserisci
					break;
				}
				
			}
		}
		
		if(flag==false){//Id profili non uguali
			flagGiaIncluso=false;//Esci e inserisci
		}
		
		return flagGiaIncluso;
		
	}
	
	
	protected boolean isProfiloGiaIncluso_old(UtenteProfiloTO utProfTo, List<UtenteProfiloTO> listProfiliUfficiAmm) {
		if (listProfiliUfficiAmm.contains(utProfTo)) return true;	//cattura elementi uguali nella stessa operazione
		for (UtenteProfiloTO to: listProfiliUfficiAmm) {
			String idAnagUffici = to.getAnagUffici() == null ? null: to.getAnagUffici().getId();
			AnagAmminDemTOId idAnagAmmin = to.getAnagAmminDem() == null ? null: to.getAnagAmminDem().getId();
		
			
			for(UtenteProfiloTO profUffEsistente : listProfiliUfficiAmm)
			{
				if(profUffEsistente.getAnagAmminDem() != null){
					if(profUffEsistente.getProfilo().getId().equals(utProfTo.getProfilo().getId())  
							
							&& ( profUffEsistente.getAnagAmminDem().getDescAmm().equals(utProfTo.getAnagAmminDem().getDescAmm()) 
									
							//	|| !profUffEsistente.getAnagAmminDem().getDescAmm().equals(utProfTo.getAnagAmminDem().getDescAmm() ) 
								)
								
							)
					{
						return true;
					}
				}
				
					
					if( (profUffEsistente.getProfilo().getId().equals(utProfTo.getProfilo().getId()) &&  profUffEsistente.getAnagUffici() == null && profUffEsistente.getAnagAmminDem()==null)
							||
							( profUffEsistente.getAnagUffici()!=null && utProfTo.getAnagUffici()!=null &&  profUffEsistente.getProfilo().getId().equals(utProfTo.getProfilo().getId()) && 
							profUffEsistente.getAnagUffici().getId().equals(utProfTo.getAnagUffici().getId()) )
					  )		 
					{
						
						return true;
					}
				
			}
			
			
			if (idAnagAmmin != null && utProfTo.getAnagAmminDem() != null && idAnagAmmin.equals(utProfTo.getAnagAmminDem().getId()))
					return true;
		}
		return false;
	}
	
	
	public String onAssociaProfilo(Context context) throws Throwable {
		GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
		if(!form.isValid()){
			return utenteView;
		}
		context.setDataModel(WebConstants.ASSOCIA_PROFILO, true);
		
		return utenteView;
	}
	
		
	public String onConfermaProfilo(Context context) throws Throwable {
	
			GestioneUtentiForm form = (GestioneUtentiForm) context.getForm();
			List<UtenteProfiloTO> listProfiliUfficiAmm = context.getModel(WebConstants.LIST_PROF_UFF_AMM);
	
			if (form.isValid() && !isProfileChange(context, listProfiliUfficiAmm, Integer.valueOf(form.getProfilo().split("-")[0]))){
	
				UtenteProfiloTO utProfTo = new UtenteProfiloTO();
				utProfTo.setFlagDelega01(0);
	
				String[] token = null;
				if (form.getProfilo() != null && !form.getProfilo().equals("")) {
					token = form.getProfilo().split("-");
	
					ProfiloTO profTo = new ProfiloTO();
					profTo.setId(Integer.valueOf(token[0]));
					profTo.setDescProfilo(token[1]);
					utProfTo.setProfilo(profTo);
				}
	
				if (form.getUfficio() != null && !form.getUfficio().equals("")) {
					token = form.getUfficio().split("-");
	
					AnagUfficiTO uffTo = new AnagUfficiTO();
					uffTo.setId(token[0]);
					uffTo.setDescUfficio(token[1]);
					utProfTo.setAnagUffici(uffTo);
				}
	
				if (form.getAmministrazione() != null && !form.getAmministrazione().equals("")) {
					token = form.getAmministrazione().split("-");
	
					AnagAmminDemTO ammTo = new AnagAmminDemTO();
					AnagAmminDemTOId ammId = new AnagAmminDemTOId();
	
					ammId.setFkAnnoEse(Short.valueOf(token[0]));
					ammId.setNumeStp(Integer.valueOf(token[1]));
					ammId.setNumeApp(Integer.valueOf(token[2]));
					ammTo.setId(ammId);
					ammTo.setDescAmm(token[3]);
					utProfTo.setAnagAmminDem(ammTo);
	
				}
				
				
				if (!isProfiloGiaIncluso(utProfTo, listProfiliUfficiAmm)){
					
						//utProfTo.setIdCheckBox(0);
						if(listProfiliUfficiAmm!=null && listProfiliUfficiAmm.size()==0){
							utProfTo.setFlagDefault01(1);
						}
						listProfiliUfficiAmm.add(utProfTo);
						
						int y = 1;
						
						for(int i=0; i<listProfiliUfficiAmm.size();i++)
						{
							
							
							listProfiliUfficiAmm.get(i).setIdCheckBox(y++);
							
						}
				}
				else
					context.addError("warning.utente.profilo.exists");
				setDefaultCampiAmministrazione(context, form);
				context.setDataModel(WebConstants.LIST_PROF_UFF_AMM, listProfiliUfficiAmm);
				
				
			}
	
			return utenteView;
		}

	protected void setDefaultCampiAmministrazione(Context context, GestioneUtentiForm form) throws Throwable {
		form.setProfilo("");
		form.setUfficio("");
		form.setAnnoEse("");
		form.setAmministrazione("");
		List<AnagAmminDemTO> listAmm = getListaAmministrazioniUltimoAnno();
		context.setDataModel(WebConstants.LIST_AMMIN_DEM, listAmm);
	}
	
	protected List<AnagAmminDemTO> getListaAmministrazioniUltimoAnno() throws Throwable {
		List<EserciziTO> listaEsercizi = listManager.loadEserciziDemCG();	//order by id (AnnoEse)
		int dimensioneLista = listaEsercizi.size();
		EserciziTO ultimoEsercizio = listaEsercizi.get(dimensioneLista-1);
		return listManager.getAmminDemByAnnoEse(ultimoEsercizio.getId().toString());
	}
	
}
