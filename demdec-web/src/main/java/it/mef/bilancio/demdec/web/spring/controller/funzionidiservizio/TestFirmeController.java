package it.mef.bilancio.demdec.web.spring.controller.funzionidiservizio;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import it.almavivaitalia.bsn.sh.manager.exception.ObjectNotFoundException;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.manager.TestFirmeManager;
import it.mef.bilancio.demdec.servizi.pkbox.SignerParameter;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.mef.bilancio.demdec.web.spring.form.FirmaDocumentiForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;

@RequestMapping(value = ConstantsRequestMapping.TEST_FIRME)
public class TestFirmeController extends AbstractDemFormController {
	
	@Autowired
	TestFirmeManager testFirmeManager;
	
	private String startView;
	
	
	public void setStartView(String startView) {
		this.startView = startView;
	}

	public String getStartView() {
		return startView;
	}

	@Override
	public String startController(Context context) throws Throwable {
		context.setCurrentNode("DemDec.menu.TestFirme");
		return startView;
	}
	
	public String onDigestTagVisibile(Context context) throws Throwable {
		FirmaDocumentiForm form = (FirmaDocumentiForm)context.getForm();
		try {
			if(form.isValid()){
				SignerParameter signerParameter = testFirmeManager.firma(form.getPin(), getUtenteInSessione(), context.getRequest(), context.getResponse());
				
				context.getResponse().setContentType("application/pdf");
				context.getResponse().setHeader("Content-Disposition","attachment;filename=TestFirme.pdf");
				
				ServletOutputStream so;
				so=context.getResponse().getOutputStream();
				so.write(signerParameter.getSignedFile());
				so.flush();
				so.close();
				return null;
			}
		} catch (ObjectNotFoundException onfe) {
			context.addError("error.pkbox", onfe.getObject().toString());
		}
		return startView;
		
	}
	
	public String onAutomaticaTagVisibile(Context context) throws Throwable {
		try {
			if(havePin(context)){
				SignerParameter signerParameter = testFirmeManager.bollina(null, getUtenteInSessione(), context.getRequest(), context.getResponse());
				context.getResponse().setContentType("application/pdf");
				context.getResponse().setHeader("Content-Disposition","attachment;filename=TestFirme.pdf");
				
				ServletOutputStream so;
				so=context.getResponse().getOutputStream();
				so.write(signerParameter.getSignedFile());
				so.flush();
				so.close();
				return null;
			}
		
		} catch (ObjectNotFoundException onfe) {
			context.addError("error.pkbox", onfe.getObject().toString());
		}
		return startView;
	}

	
	
	public String onAutomaticaTagInvisibile(Context context) throws Throwable {
		
		try {
			
			if(havePin(context)){
				SignerParameter signerParameter = testFirmeManager.sigla(null, getUtenteInSessione(), context.getRequest(), context.getResponse());
				context.getResponse().setContentType("application/pdf");
				context.getResponse().setHeader("Content-Disposition","attachment;filename=TestFirme.pdf");
				
				ServletOutputStream so;
				so=context.getResponse().getOutputStream();
				so.write(signerParameter.getSignedFile());
				so.flush();
				so.close();
				return null;
			}
		
		} catch (ObjectNotFoundException onfe) {
			context.addError("error.pkbox", onfe.getObject().toString());
		}
		return startView;
	}
	
	
	private Boolean havePin(Context context){
		if(getUtenteInSessione().getUtente().getCodiPinFirma() == null || getUtenteInSessione().getUtente().getCodiPinFirma().equals("")){
			context.addError("error.no.pinencrypted");
			return false;
		}
		return true;
	}
	
}
