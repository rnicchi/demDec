package it.almavivaitalia.bilancio.commons.web.security;


import it.almavivaitalia.bilancio.commons.bo.UtenteBO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

/**
 * Cancellata non appena concluso il processo di integrazione nuova gestione
 * sicurezza.
 * 
 * @deprecated Non utilizzata; Mantenuta nel progetto perchè
 *             applicationContext-security di tutte le applicazioni ne
 *             contengono un riferimento.
 * 
 */
@Deprecated
public class CustomAuthenticationProvider implements AuthenticationProvider {


	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return authentication;

	}

	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	@SuppressWarnings("unused")
	private List<GrantedAuthority> getAuthorities(UtenteBO user) throws SecurityException {

		// mi prendo il profilo associato all'utente
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		// List<Funzione> profilo = user.getFunzioni();
		//Set<ProfileOccurrence> profilo = user.getFunzioniAssociate();
		//Assert.notNull(profilo);
		// for (Funzione f : profilo) {
		// authList.add(new GrantedAuthorityImpl("ROLE_" + f.getFunzId()));
		// }
		/*for (ProfileOccurrence po : profilo) {
			authList.add(new GrantedAuthorityImpl("ROLE_" + po.getFunzione().getFunzId()));
		}*/

		if (authList.size() == 0) {
			// imposto di default un profilo generico per chi si è autenticato
			// ma non
			// dispone di profilo
			throw new SecurityException(
					"Log in non corretto - l'utente è stato autenticato dal Sistema Ldap ma non possiede un ProfileOccurrence Assegnato - E' necessario"
							+ "creare sul db delle Utenze l'associazione tra l'utente "
							+ user.getCodiUtente()
							+ " ed un profilo applicativo");
		}

		return authList;
	}


}
