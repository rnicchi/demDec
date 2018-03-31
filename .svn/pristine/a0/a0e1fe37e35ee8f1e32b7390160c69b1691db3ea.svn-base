package it.almavivaitalia.bilancio.commons.web.security;

import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Utente implements UserDetails, Serializable {

	private String username;
	
	private UtenteTO utente;
	
	private ProfiloTO profiloInUso;
	
	private UtenteProfiloTO utenteProfiloInUso;
	
	public Utente(String username){
		this.username = username;
	}

    public UtenteTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteTO utente) {
		this.utente = utente;
	}


	public ProfiloTO getProfiloInUso() {
		if (profiloInUso==null){
			profiloInUso = getUtenteProfiloInUso().getProfilo();
		}
		return profiloInUso;
	}

	public void setProfiloInUso(ProfiloTO profiloInUso) {
		this.profiloInUso = profiloInUso;
	}


	public UtenteProfiloTO getUtenteProfiloInUso() {
		if (utenteProfiloInUso==null){
			utenteProfiloInUso = utente.getUtenteProfiloPrincipale();
		}
		return utenteProfiloInUso;
	}

	public void setUtenteProfiloInUso(UtenteProfiloTO utenteProfiloInUso) {
		this.utenteProfiloInUso = utenteProfiloInUso;
	}


	private Collection<GrantedAuthority> authorities;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}


	@Override
	public String getPassword() {
		return null;
	}


	@Override
	public String getUsername() {
		return username;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
