package it.mef.bilancio.demdec.web.spring.controller;

import it.almavivaitalia.bsn.sh.manager.exception.ObjectNotFoundException;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.UploadDecManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.web.spring.form.RielaborazioneFascicoloForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping (value=ConstantsRequestMapping.RIELABORAZIONE_FASCICOLO)
public class RielaborazioneFascicoloController extends AbstractDemFormController implements WebConstants,SessionAttributes{

	private String startView;
	
	public String getStartView() {
		return startView;
	}

	public void setStartView(String startView) {
		this.startView = startView;
	}

	@Autowired
	private ListManager listManager;
	
	@Autowired
	private UploadDecManager uploadManager;
	
	@Autowired
	private GestioneFadManager gestioneFadManager;
	
	@Override
	public String startController(Context context) throws Throwable {

		context.setCurrentNode("DemDec.menu.RielaborazioneFascicolo");
		
	//	List<FascicoliTO> listaFascicoli = uploadManager.findFascicoliFadStatusZero();
		context.setDataModel(WebConstants.LIST_ANNO_ESE, listManager.loadEserciziDemCG());
		 context.setDataModel(WebConstants.LIST_TIPO_DEC, listManager.loadAnagTipoDecreto());
//		 context.setDataModel(WebConstants.LIST_ANNO_DEC, listManager.loadEserciziDemCG());
		
	//	context.setDataModel(WebConstants.LIST_DECRETI_APERTI, listaFascicoli);
		return startView;
	}
	
	public String onLoadListaDecreti(Context context) throws Throwable {
		
		RielaborazioneFascicoloForm form = (RielaborazioneFascicoloForm)context.getForm();
		context.setDataModel(WebConstants.LIST_DECRETI_RIELABORAZIONE, gestioneFadManager.findFascicoliFadByAnno(form.getAnnoDecreto()));
		
		return startView;
	}
	
	public String onEseguiRielaborazione(Context context) throws Throwable {
		
		RielaborazioneFascicoloForm form = (RielaborazioneFascicoloForm)context.getForm();
		
		if (form.isValid()){
			FascicoliTO srcTO = null;
			FascicoliTO destTO = null;
			
			try{
			 srcTO=gestioneFadManager.findFascicoloByAnnoTipoNum(Integer.parseInt(form.getAnnoDecreto()), Integer.parseInt(form.getTipoDecreto()), Integer.parseInt(form.getNumDecreto().trim()));
			}catch(ObjectNotFoundException exc){
				context.addWarning("info.rielab.fascicolo.notFound");	
				return startView;
			}
			
//			String idFascicoloSel = form.getIdFascicolo();
//			srcTO = uploadManager.findFascicoliById(new Long(idFascicoloSel));
			
			// Se tipo eleborazione TRASPORTO, viene caricato anche il fascicolo di arrivo
			if("4".equals(form.getTipoElab())) {
//				String idFascicoloArrivoSel = form.getIdFascicoloArrivo();
//				destTO = uploadManager.findFascicoliById(new Long(idFascicoloArrivoSel));
				try {
					destTO=gestioneFadManager.findFascicoloByAnnoTipoNum(Integer.parseInt(form.getAnnoDecretoArrivo()), Integer.parseInt(form.getTipoDecretoArrivo()), Integer.parseInt(form.getNumDecretoArrivo().trim()));
				}catch(ObjectNotFoundException exc){
					context.addWarning("info.rielab.fascicolo.arrivo.notFound");
					return startView;
				}	
			}
			
			EsitoTO esitoTO = gestioneFadManager.rielaborazioneFascicolo(srcTO, destTO, new Integer(form.getTipoElab()));
			
			if(esitoTO.getCodice().equals(DEMBILConstants.ESITO_OK)){
				switch (Integer.parseInt(form.getTipoElab())) {
						case 1 :
							context.addInfo("info.rielab.riapertura.success", "");	
							break;
						case 2 :
							context.addInfo("info.rielab.sosp.success", "");	
							break;
						case 3 :
							context.addInfo("info.rielab.revsosp.success", "");	
							break;
						case 4 :
							context.addInfo("info.rielab.trasporto.success", "");	
							break;
						default:
							context.addError("error.generic", esitoTO.getDescrizione());
							break;
				}
				
			}
			else {
				context.addError("error.generic", esitoTO.getDescrizione());	
			}
			
		}
		
		return startView;
	}

}
