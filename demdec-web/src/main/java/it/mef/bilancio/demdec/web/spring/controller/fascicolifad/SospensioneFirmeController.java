package it.mef.bilancio.demdec.web.spring.controller.fascicolifad;

import it.almavivaitalia.bilancio.commons.manager.UtenteManager;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.manager.InvioAlleFirmeManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.manager.MailManager;
import it.mef.bilancio.demdec.manager.RicercaRedManager;
import it.mef.bilancio.demdec.manager.SospensioneFirmeManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.SospensioneFirmeForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping(value = ConstantsRequestMapping.SOSPENSIONE_FIRME)
public class SospensioneFirmeController extends AbstractDemFormController implements WebConstants, SessionAttributes{
	
	private String startView;
	
	@Autowired
	private ListManager listManager;
	
	@Autowired
	private RicercaRedManager ricercaRedManager;
	
	@Autowired
	private SospensioneFirmeManager sospensioneFirmeManager;
	
	@Autowired
	private UtenteManager utenteManager;
	
	@Autowired
	private GestioneFadManager gestioneFadManager;
	

	
	@Autowired
	private MailManager mailManager;

	@Autowired
	private InvioAlleFirmeManager invioAlleFirmeManager;
	
	@Override
	public String startController(Context context) throws Throwable {
		
		context.setCurrentNode("DemDec.menu.SospFirma");
		
		List<AnagTipoDecretoTO> listaTipiDecreti=listManager.loadAnagTipoDecreto();
		context.setDataModel(WebConstants.LIST_TIPI_DECRETI, listaTipiDecreti );
	
		List<EserciziTO> listEsercizi=listManager.loadEserciziDemCG();
		context.setDataModel(WebConstants.LIST_ANNO_ESE, listEsercizi );
		
		return startView;
	}	
	
	
	public String pulisci(Context context) throws Throwable {
		
		SospensioneFirmeForm form= (SospensioneFirmeForm) context.getForm();
		
		form.setAnnoEse(null);
		form.setNumero(null);
		form.setTipoFlusso(null);
		
		List<AnagTipoDecretoTO> listaTipiDecreti=listManager.loadAnagTipoDecreto();
		context.setDataModel(WebConstants.LIST_TIPI_DECRETI, listaTipiDecreti );
	
		List<EserciziTO> listEsercizi=listManager.loadEserciziDemCG();
		context.setDataModel(WebConstants.LIST_ANNO_ESE, listEsercizi );
		
		return startView;
	}
	
	
//	public String  riapriFascicolo(Context context) throws Throwable{
//		
//		SospensioneFirmeForm form= (SospensioneFirmeForm) context.getForm();
//		
//		if(!form.isValid()){		
//			return startView;
//		}
//		
//		String tipoFlusso=form.getTipoFlusso();
//		String anno=form.getAnnoEse();
//		String numero=form.getNumero();
//	
//		//la presenza del validator mi assicura che non arriveranno campi vuoti o un numero decreto con valori non numerici 
//		FascicoliTO fascicoloTo=sospensioneFirmeManager.findFascicoloByAnnoTipoNum(Integer.valueOf(anno), Integer.valueOf(tipoFlusso), Integer.valueOf(numero) );
//		if(fascicoloTo==null ){
//			context.addWarning("info.noDataFound");
//			return startView;
//		}
//		
//		EsitoTO esitoTO = sospensioneFirmeManager.riaperturaFascicolo(fascicoloTo);
//		
//		if(esitoTO.getCodice().equals(DEMBILConstants.ESITO_OK)){
//			context.addInfo("info.update.success", "");	
//		}
//		else {
//			context.addError("error.generic", esitoTO.getDescrizione());	
//		}
//		
//		return startView;
//		
//	}
	
	public String  sospendiFirme(Context context) throws Throwable{
		
		SospensioneFirmeForm form= (SospensioneFirmeForm) context.getForm();
		
		if(!form.isValid()){		
			return startView;
		}
		
		String tipoFlusso=form.getTipoFlusso();
		String anno=form.getAnnoEse();
		String numero=form.getNumero();
	   
		//la presenza del validator mi assicura che non arriveranno campi vuoti o un numero decreto con valori non numerici 
		FascicoliTO fascicoloTo=sospensioneFirmeManager.findFascicoloByAnnoTipoNum(Integer.valueOf(anno), Integer.valueOf(tipoFlusso), Integer.valueOf(numero) );
		if(fascicoloTo==null ){
			context.addWarning("info.noDataFound");
			return startView;
		}
		
		
		Long numeIdFascicolo=fascicoloTo.getId();
		
		ResponseDEMBILClient responseChangeStatoFascicolo= invioAlleFirmeManager.wsChangeStatoFascicoloAttoDecreto(fascicoloTo.getCodiGuidFascicolo(), Constants.STATO_FAD_APERTO);
		if(!responseChangeStatoFascicolo.getEsitoTo().getCodice().equalsIgnoreCase(DEMBILConstants.ESITO_OK)){	
//			String errore = responseChangeStatoFascicolo.getEsitoTo().getDescrizione();
//			throw new Exception(errore);
			context.addError("error.generic", responseChangeStatoFascicolo.getEsitoTo().getDescrizione());;
			return startView;
		}else{
			IterFirmaDecretoTO  ifdTo= sospensioneFirmeManager.aggiornaStati(numeIdFascicolo,getUtenteInSessione().getUtente().getCodiUtente(), NomeFunzioneConstants.SOSPENSIONE_FIRME);
			
			
			
			/**invio e-mail**
			List<String> address = utenteManager.findEmailSignatoryNextByStatFirmaAndIdFascicolo(Constants.STATO_FIRMA_SOSPESA, numeIdFascicolo);
			String email = "";
			
			if(address != null && !address.isEmpty()){
				if(address.size() > 1){
					for (String string : address) {
						email=email+string.concat(",");
					}
					email= email.substring(0, email.length()-1);
				}else{
					email = address.get(0);
				}
			}
			
			MimeMessage message = null;
			
			if((ifdTo.getAnagFirmatari().getFlagPec01() == HAVE_PEC)){
				message = mailManager.invioPecDaFunzione(NomeFunzioneConstants.SOSPENSIONE_FIRME, getUtenteInSessione(), email, fascicoloTo.getDescSigla()+" - "+numero2+" - "+anno2 );
			}else{
				message = mailManager.invioPeoDaFunzione(NomeFunzioneConstants.SOSPENSIONE_FIRME, getUtenteInSessione(), email, fascicoloTo.getDescSigla()+" - "+numero2+" - "+anno2);
			}
			
						
			/**invio la mail a tutti i firmatari che hanno stato "2" sulla tabella d_iter_firma_decreto, per questo fascicolo**
			List<EmailUtenteTO> emailS= utenteManager.findEmailUserFlgPecStatIdFasc(Constants.STATO_FIRMA_FIRMATO, numeIdFascicolo);
			
			for (int i = 0; i < emailS.size(); i++) {
				if(emailS.get(i).getFlagEmailPec() == HAVE_PEC){
					message = mailManager.invioPecDaFunzione(NomeFunzioneConstants.SOSPENSIONE_FIRME, getUtenteInSessione(), emailS.get(i).getEmailUtente(), fascicoloTo.getDescSigla()+" - "+numero2+" - "+anno2 );
				}else{
					message = mailManager.invioPeoDaFunzione(NomeFunzioneConstants.SOSPENSIONE_FIRME, getUtenteInSessione(), emailS.get(i).getEmailUtente(), fascicoloTo.getDescSigla()+" - "+numero2+" - "+anno2);
				}
			}
			
			
			if(message != null){
				PecMessaggiInviatiTO messageToSave = mailManager.createMessageToSave(message, NomeFunzioneConstants.SOSPENSIONE_FIRME);
				context.valorizeAuditCreated(messageToSave, NomeFunzioneConstants.SOSPENSIONE_FIRME);
				context.valorizeAuditUpdated(messageToSave, NomeFunzioneConstants.SOSPENSIONE_FIRME);
				mailManager.salvaMessaggioInviato(messageToSave, getUtenteInSessione());
				context.addInfo("info.doc.signingSuspended.and.msg.sent",  email);
			}else{
				context.addInfo("info.doc.signingSuspended");
				context.addWarning("warning.email.sosp.not.sent", email);
			}
			fine invio mail 	*/
		
		}
		
		context.addInfo("info.doc.signingSuspended");
		
		return startView;
		
	}
	
	public void setStartView(String startView) {
		this.startView = startView;
	}
	
}