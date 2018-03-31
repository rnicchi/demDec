package it.mef.bilancio.demdec.web.spring.controller.funzionidiservizio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.AttivazioneMailManager;
import it.mef.bilancio.demdec.to.AnagFirmatariTO;
import it.mef.bilancio.demdec.utils.Constants;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;


@RequestMapping(value = ConstantsRequestMapping.ABILITA_MAIL)
public class AbilitaInvioMailController  extends AbstractDemFormController{
	
	private String startView;
	
	@Autowired
	private AttivazioneMailManager attivazioneMailManager;
	
	public String getStartView() {
		return startView;
	}

	public void setStartView(String startView) {
		this.startView = startView;
	}
	
	@Override
	public String startController(Context context) throws Throwable {
		context.setCurrentNode("DemDec.menu.Servizi.AbilitazioneMail");
		
		List<AnagFirmatariTO> list=attivazioneMailManager.loadDestinatariMail(Constants.HAVE_PEO);
		if (list.isEmpty()){
			context.addWarning("warning.empty.firmatari", "");
		}
		
		context.setDataModel(LIST_ANAG_FIRMATARI, list);
		return startView;
	}
	
	
	public String onAbilitaDestinatarioMail(Context context) throws Throwable{
		AnagFirmatariTO dest = null;
		String rowNum = context.getCommandParameter("abilitaDestinatarioMail");
		List<AnagFirmatariTO> list = context.getModel(LIST_ANAG_FIRMATARI);
		
		if(!list.isEmpty() && rowNum != null && rowNum != "" ){
			dest = list.get(Integer.parseInt(rowNum)-1);
		}
		
		attivazioneMailManager.modificaAbilitazioneMail(dest, Constants.DESTINATARIO_MAIL_ABILITATO);
		
		context.addInfo("info.abilitazionemail.abilita");
		
		return startController(context);
	
	}
	
	
	public String onDisabilitaDestinatarioMail(Context context) throws Throwable{
		AnagFirmatariTO dest = null;
		String rowNum = context.getCommandParameter("disabilitaDestinatarioMail");
		List<AnagFirmatariTO> list = context.getModel(LIST_ANAG_FIRMATARI);
		
		if(!list.isEmpty() && rowNum != null && rowNum != "" ){
			dest = list.get(Integer.parseInt(rowNum)-1);
		}
		
		attivazioneMailManager.modificaAbilitazioneMail(dest, Constants.DESTINATARIO_MAIL_DISABILITATO);
		
		context.addInfo("info.abilitazionemail.disabilita");
		
		return startController(context);
	
	}
	
	
}
