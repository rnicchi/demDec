/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.form;

import java.util.ArrayList;

import it.almavivaitalia.web.sh.form.AbstractForm;

/**
 * @author utente
 *
 */
public class RicercaRedForm extends AbstractForm {
	
	private String idRed;
	private String protocolloRed;
	private String annoEse;
	private String amministrazione;
	private String stato;
	private String ufficioAssociatoRed;
	private String tipoFlusso;
	private String dataRedDa;
	private String dataRedA;
	private String dataArrivoDa;
	private String dataArrivoA;
	private String numero;
	private String tipoAllegati;
	private String rigaFasc;
	private String rigaDoc;
	private String tipoDownl;
	
	
	private String[] listaRedDaSospendere;
	private String[] listaRedSospesi;
	
	private String[] listaTipoAllegati;
	private String [] selezioniDocumentiFasc;
	
	private ArrayList<DocumentiRaccoltaProvvisorieForm> documentiRaccoltaProvvisorieList;


	


	public void clean() {

		setAmministrazione(null);
		setAnnoEse(null);
		setDataArrivoA(null);
		setDataArrivoDa(null);
		setDataRedA(null);
		setDataRedDa(null);
		setIdRed(null);
		setListaRedDaSospendere(null);
		setListaRedSospesi(null);
		setListaTipoAllegati(null);
		setNumero(null);
		setProtocolloRed(null);
		setRigaDoc(null);
		setRigaFasc(null);
		setSelezioniDocumentiFasc(null);
		setStato(null);
		setTipoAllegati(null);
		setTipoDownl(null);
		setTipoFlusso(null);
		setUfficioAssociatoRed(null);
		setValid(false);
	}


	//getters & setters
	public String[] getListaTipoAllegati() {
		return listaTipoAllegati;
	}
	public void setListaTipoAllegati(String[] listaTipoAllegati) {
		this.listaTipoAllegati = listaTipoAllegati;
	}
	public String[] getSelezioniDocumentiFasc() {
		return selezioniDocumentiFasc;
	}
	public void setSelezioniDocumentiFasc(String[] selezioniDocumentiFasc) {
		this.selezioniDocumentiFasc = selezioniDocumentiFasc;
	}
	
	
	public String getRigaFasc() {
		return rigaFasc;
	}
	public void setRigaFasc(String rigaFasc) {
		this.rigaFasc = rigaFasc;
	}
	public String getRigaDoc() {
		return rigaDoc;
	}
	public void setRigaDoc(String rigaDoc) {
		this.rigaDoc = rigaDoc;
	}
	public String getTipoDownl() {
		return tipoDownl;
	}
	public void setTipoDownl(String tipoDownl) {
		this.tipoDownl = tipoDownl;
	}
	public String getTipoAllegati() {
		return tipoAllegati;
	}
	public void setTipoAllegati(String tipoAllegati) {
		this.tipoAllegati = tipoAllegati;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDataRedDa() {
		return dataRedDa;
	}
	public void setDataRedDa(String dataRedDa) {
		this.dataRedDa = dataRedDa;
	}
	public String getDataRedA() {
		return dataRedA;
	}
	public void setDataRedA(String dataRedA) {
		this.dataRedA = dataRedA;
	}

	public String getDataArrivoDa() {
		return dataArrivoDa;
	}
	public void setDataArrivoDa(String dataArrivoDa) {
		this.dataArrivoDa = dataArrivoDa;
	}
	public String getDataArrivoA() {
		return dataArrivoA;
	}
	public void setDataArrivoA(String dataArrivoA) {
		this.dataArrivoA = dataArrivoA;
	}
	public String getIdRed() {
		return idRed;
	}
	public void setIdRed(String idRed) {
		this.idRed = idRed;
	}
	
	public String getProtocolloRed() {
		return protocolloRed;
	}
	public void setProtocolloRed(String protocolloRed) {
		this.protocolloRed = protocolloRed;
	}
	public String getAnnoEse() {
		return annoEse;
	}
	public void setAnnoEse(String annoEse) {
		this.annoEse = annoEse;
	}
	public String getAmministrazione() {
		return amministrazione;
	}
	public void setAmministrazione(String amministrazione) {
		this.amministrazione = amministrazione;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getUfficioAssociatoRed() {
		return ufficioAssociatoRed;
	}
	public void setUfficioAssociatoRed(String ufficioAssociatoRed) {
		this.ufficioAssociatoRed = ufficioAssociatoRed;
	}
	public String getTipoFlusso() {
		return tipoFlusso;
	}
	public void setTipoFlusso(String tipoFlusso) {
		this.tipoFlusso = tipoFlusso;
	}
	public String[] getListaRedDaSospendere() {
		return listaRedDaSospendere;
	}
	public void setListaRedDaSospendere(String[] listaRedDaSospendere) {
		this.listaRedDaSospendere = listaRedDaSospendere;
	}
	public String[] getListaRedSospesi() {
		return listaRedSospesi;
	}
	public void setListaRedSospesi(String[] listaRedSospesi) {
		this.listaRedSospesi = listaRedSospesi;
	}


	public ArrayList<DocumentiRaccoltaProvvisorieForm> getDocumentiRaccoltaProvvisorieList() {
		return documentiRaccoltaProvvisorieList;
	}


	public void setDocumentiRaccoltaProvvisorieList(
			ArrayList<DocumentiRaccoltaProvvisorieForm> documentiRaccoltaProvvisorieList) {
		this.documentiRaccoltaProvvisorieList = documentiRaccoltaProvvisorieList;
	}
	
}
