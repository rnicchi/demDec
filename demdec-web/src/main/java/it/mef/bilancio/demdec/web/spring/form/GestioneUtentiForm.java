package it.mef.bilancio.demdec.web.spring.form;

import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.web.sh.form.AbstractForm;

public class GestioneUtentiForm extends AbstractForm {

	private Integer id;
	private String codiUtente;
	private String persCognome;
	private String persNome;
	private String indiEmail;
	private String codiUtenteNsbf;
	private String codiCodiceFiscale;
	private String codiCodiceFisFirma;
	private String codiPinFirma;
	private String profilo;
	private String annoEse;
	private String ufficio;
	private String amministrazione;
	private String selectedCodiUtente;
	private Integer [] idProfiloDaEliminare;
	private String radioButtonProfili;
	
	private Integer rigaProfiloDaEliminare;


	public Integer getRigaProfiloDaEliminare() {
		return rigaProfiloDaEliminare;
	}
	public void setRigaProfiloDaEliminare(Integer rigaProfiloDaEliminare) {
		this.rigaProfiloDaEliminare = rigaProfiloDaEliminare;
	}
	
	public Integer getId() {
		return id;
	}
	public Integer[] getIdProfiloDaEliminare() {
		return idProfiloDaEliminare;
	}
	public void setIdProfiloDaEliminare(Integer[] idProfiloDaEliminare) {
		this.idProfiloDaEliminare = idProfiloDaEliminare;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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


	public String getSelectedCodiUtente() {
		return selectedCodiUtente;
	}
	public void setSelectedCodiUtente(String selectedCodiUtente) {
		this.selectedCodiUtente = selectedCodiUtente;
	}
	
	
	
	public String getRadioButtonProfili() {
		return radioButtonProfili;
	}
	public void setRadioButtonProfili(String radioButtonProfili) {
		this.radioButtonProfili = radioButtonProfili;
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
		setSelectedCodiUtente("");
	}


	public UtenteTO getTransferObject() {

		UtenteTO utenteTO = new UtenteTO();

		utenteTO.setCodiUtente(this.getCodiUtente());
		utenteTO.setPersCognome(this.getPersCognome());	
		utenteTO.setPersNome(this.getPersNome());
		utenteTO.setIndiEmail(this.getIndiEmail());
		utenteTO.setCodiUtenteNsbf(this.getCodiUtenteNsbf());
		utenteTO.setCodiCodiceFiscale(this.getCodiCodiceFiscale());
		utenteTO.setCodiCodiceFisFirma(this.getCodiCodiceFisFirma());
		utenteTO.setCodiPinFirma(this.getCodiPinFirma());
		utenteTO.setCodiUtenteNsbf(this.getCodiUtenteNsbf());

		return utenteTO;
	}

}
