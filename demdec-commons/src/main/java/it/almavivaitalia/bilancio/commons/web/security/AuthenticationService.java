package it.almavivaitalia.bilancio.commons.web.security;

import it.almavivaitalia.bilancio.commons.manager.ActionManager;
import it.almavivaitalia.bilancio.commons.manager.UtenteManager;
import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by IntelliJ IDEA.
 * User: tano
 * Date: 27-set-2011
 * Time: 17.35.18
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationService implements AuthenticationUserDetailsService {

     /* NON ELIMINARE SERVONO PER LE METRICHE */
    @SuppressWarnings("unused")
	private char LOCM1;
	@SuppressWarnings("unused")
	private char LOCM2;
	@SuppressWarnings("unused")
	private char LOCM3;
	@SuppressWarnings("unused")
	private char LOCM4;

    private static final Logger _LOG = Logger.getLogger(AuthenticationService.class);
    
    @Autowired
    private UtenteManager utenteManager;
    @Autowired
    private ActionManager actionManager;

 //   @Autowired
 //   private AmministrazioneComManager amministrazioneComManager;

 //   @Autowired
 //   private UtilityManager utilityManager;
 
 
    @Override
    public UserDetails loadUserDetails(Authentication authentication) throws UsernameNotFoundException {

        UtenteTO utente = null;
    	Utente user = (Utente) authentication.getPrincipal();
        
        try{

            utente =  utenteManager.loadByCodiUtente(user.getUsername());
            if (utente==null){
                _LOG.error("Utente non trovato con uid: " + user.getUsername());
                throw new UsernameNotFoundException("Utente non valido");
            }
            user.setUtente(utente);

         } catch (Exception be) {
             _LOG.error("Utente non trovato con uid: " + user.getUsername());
            throw new UsernameNotFoundException(be.getMessage());
        } catch (Throwable e) {
            _LOG.error("Utente non trovato con uid: " + user.getUsername());
           throw new UsernameNotFoundException(e.getMessage());
		}

        caricaAutority(user);

        return user;  
    }


    private void caricaAutority(Utente user){

        try {
            ProfiloTO profilo = user.getProfiloInUso();
            List<String> funzioniList = actionManager.findFunzioniByProfiloApp(profilo);

            Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>(funzioniList.size());

            for (String f : funzioniList) {
                auths.add(new GrantedAuthorityImpl(f));
            }

             user.setAuthorities(auths);
        } catch (Throwable e) {
            _LOG.error("Utente non trovato con uid: " + user.getUsername());
           throw new UsernameNotFoundException(e.getMessage());
       }
        
    }
}
