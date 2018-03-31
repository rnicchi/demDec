package it.almavivaitalia.bilancio.commons.web.spring.controller;

import it.almavivaitalia.bilancio.commons.manager.ActionManager;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.bilancio.commons.web.form.CambioProfiloForm;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.web.sh.utils.Context;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = CommonConstantsRequestMapping.CAMBIO_PROFILO_URL)
public class CambioProfiloController extends AbstractCommonFormController {

    @Autowired
    private ActionManager actionManager;

	@Override
	public String onSubmit(Context sbfjContext) throws Throwable {
		CambioProfiloForm form = (CambioProfiloForm) sbfjContext.getForm();
        sbfjContext.getRequest().getSession().getServletContext().setAttribute(AMBIENTE,AMBIENTE_SVIL);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Utente user = getUtenteInSessione();

        if(!user.getUtenteProfiloInUso().getId().getCodiProfilo().equals(form.getCodiProfilo())){

        	UtenteProfiloTO utProfilo = user.getUtente().getUtenteProfilo(form.getCodiProfilo());
        	user.setUtenteProfiloInUso(utProfilo);
            ProfiloTO profilo = utProfilo.getProfilo();

            user.setProfiloInUso(profilo);

            List<String> funzioniList = actionManager.findFunzioniByProfiloApp(profilo);

            Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>(funzioniList.size());

            for (String f : funzioniList) {
                auths.add(new GrantedAuthorityImpl(f));
            }

             user.setAuthorities(auths);

            PreAuthenticatedAuthenticationToken securityToken =
                    new PreAuthenticatedAuthenticationToken(user, securityContext.getAuthentication().getCredentials(), auths);

            securityContext.setAuthentication(securityToken);

        }


        return CommonConstantsRequestMapping.REDIRECT
				+ prepareUrl();
	}

	@Override
	public String startController(Context context) throws Throwable {
		context.setCurrentNode("DemDec.menu");
		CambioProfiloForm form = context.getForm();
		Utente utente = getUtenteInSessione();
		form.setCodiProfilo(utente.getUtenteProfiloInUso().getId().getCodiProfilo());
		return "cambioProfiloView";
	}

	private String prepareUrl() throws Throwable {
		@SuppressWarnings("unused")
		String sProtocolloWeb = "http";
		@SuppressWarnings("unused")
		String sServerWeb = "localhost:8080";
		@SuppressWarnings("unused")
		String sContextWeb = "demdec-web";
		String sPageWeb =  "private/login.do";// CommonConstantsRequestMapping.LOGIN_URL;

		StringBuffer url = new StringBuffer();
//		String utenteSb = generalResources.getMessage("sb.user", null, null);
//		
//		String pswdSb = generalResources.getMessage("sb.password", null, null);

		try {
			url.append(CommonConstantsRequestMapping.SLASH + sPageWeb);
			// url.append(sProtocolloWeb+"://"+sServerWeb+"/"+sContextWeb+sPageWeb);
			//url.append(CommonSessionAttributes.P_INTERROGATIVO);
//			url.append(CommonSessionAttributes.P_INTERROGATIVO + "oam-user" + CommonSessionAttributes.UGUALE + user);
			// byte [] key = ConstantsSecurity.UTENTE.getBytes("UTF-8");
//			Date data = new Date();
//			Format formatter = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER);
//			String formattedDate = formatter.format(data);
//			url.append(ConstantsSecurity.DATE_COLL + CommonSessionAttributes.UGUALE + formattedDate);
//			Format formatterKey = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER_KEY);
//			String formattedKey = formatterKey.format(data);
//
//			Boolean bCifratura = new Boolean(generalResources.getMessage("sec.cipher", null, null));
//			if (bCifratura) {
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE + CommonSessionAttributes.UGUALE + UtilParameter.encode(user, formattedKey));
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE_SB + CommonSessionAttributes.UGUALE + UtilParameter.encode(utenteSb, formattedKey));
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.PSWD_SB + CommonSessionAttributes.UGUALE + UtilParameter.encode(pswdSb, formattedKey));
//			} else {
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE + CommonSessionAttributes.UGUALE + user);
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.UTENTE_SB + CommonSessionAttributes.UGUALE + utenteSb);
//				url.append(CommonSessionAttributes.E_COMMERCIALE + ConstantsSecurity.PSWD_SB + CommonSessionAttributes.UGUALE + pswdSb);
//			}
//
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return url.toString();
	}

}
