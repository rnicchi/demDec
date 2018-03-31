package it.mef.bilancio.demdec.web.spring.form;

import java.util.List;

import it.almavivaitalia.bilancio.commons.to.ProfiloTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.web.sh.form.AbstractForm;

public class GestioneProfiliForm extends AbstractForm {

	private Integer id;
	private String codiProfilo;
	private String descProfilo;
/*	private String persNome;
	private String indiEmail;
	private String codiUtenteNsbf;
	private String codiCodiceFiscale;
	private String codiCodiceFisFirma;
	private String codiPinFirma;
	private String profilo;
	private String annoEse;
	private String ufficio;
	private String amministrazione;
*/
//	private String selectedUtente;
	
	private String selectedProfilo;
	private String [] idActionProfilo;

	
	
	public String[] getIdActionProfilo() {
		return idActionProfilo;
	}
	public void setIdActionProfilo(String[] idActionProfilo) {
		this.idActionProfilo = idActionProfilo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
public String getCodiProfilo() {
		return codiProfilo;
	}
	public void setCodiProfilo(String codiProfilo) {
		this.codiProfilo = codiProfilo;
	}
	public String getDescProfilo() {
		return descProfilo;
	}
	public void setDescProfilo(String descProfilo) {
		this.descProfilo = descProfilo;
	}
	public String getSelectedProfilo() {
		return selectedProfilo;
	}
	public void setSelectedProfilo(String selectedProfilo) {
		this.selectedProfilo = selectedProfilo;
	}
	/*	
	public String getCodiUtente() {
		return codiUtente;
	}
	public void setCodiUtente(String codiUtente) {
		this.codiUtente = codiUtente;
	}
	public String getPersCognome() {
		return persCognome;
	}
	public void setPersCognome(String persCognome) {
		this.persCognome = persCognome;
	}
	public String getPersNome() {
		return persNome;
	}
	public void setPersNome(String persNome) {
		this.persNome = persNome;
	}
	public String getIndiEmail() {
		return indiEmail;
	}
	public void setIndiEmail(String indiEmail) {
		this.indiEmail = indiEmail;
	}
	public String getCodiUtenteNsbf() {
		return codiUtenteNsbf;
	}
	public void setCodiUtenteNsbf(String codiUtenteNsbf) {
		this.codiUtenteNsbf = codiUtenteNsbf;
	}
	public String getCodiCodiceFiscale() {
		return codiCodiceFiscale;
	}
	public void setCodiCodiceFiscale(String codiCodiceFiscale) {
		this.codiCodiceFiscale = codiCodiceFiscale;
	}
	public String getCodiCodiceFisFirma() {
		return codiCodiceFisFirma;
	}
	public void setCodiCodiceFisFirma(String codiCodiceFisFirma) {
		this.codiCodiceFisFirma = codiCodiceFisFirma;
	}
	public String getCodiPinFirma() {
		return codiPinFirma;
	}
	public void setCodiPinFirma(String codiPinFirma) {
		this.codiPinFirma = codiPinFirma;
	}
	public String getProfilo() {
		return profilo;
	}
	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}
	public String getAnnoEse() {
		return annoEse;
	}
	public void setAnnoEse(String annoEse) {
		this.annoEse = annoEse;
	}
	public String getUfficio() {
		return ufficio;
	}
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	public String getAmministrazione() {
		return amministrazione;
	}
	public void setAmministrazione(String amministrazione) {
		this.amministrazione = amministrazione;
	}


	public String getSelectedUtente() {
		return selectedUtente;
	}
	public void setSelectedUtente(String selectedUtente) {
		this.selectedUtente = selectedUtente;
	}
	public void clean() {
		setId(null);
		setCodiUtente("");
		setPersCognome("");
		setPersNome("");
		setIndiEmail("");
		setCodiUtenteNsbf("");
		setCodiCodiceFiscale("");
		setCodiCodiceFisFirma("");
		setCodiPinFirma("");
		setProfilo("");
		setAnnoEse("");
		setUfficio("");
		setAmministrazione("");
	}
*/	
	public void clean() {
		setId(null);
		setCodiProfilo("");
		setDescProfilo("");
		setIdActionProfilo(null);
	}


	public ProfiloTO getTransferObject() {

		ProfiloTO profiloTO = new ProfiloTO();
		
		profiloTO.setCodiProfilo(this.codiProfilo);
		profiloTO.setDescProfilo(this.descProfilo);
		
		profiloTO.setActionAssociate(idActionProfilo);

		return profiloTO;
	}

}
