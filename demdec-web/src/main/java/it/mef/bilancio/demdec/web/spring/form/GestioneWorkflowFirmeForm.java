/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.form;

import it.almavivaitalia.web.sh.form.AbstractForm;

/**
 * @author Pietro
 *
 */
public class GestioneWorkflowFirmeForm extends AbstractForm {

	private String selectedModello;
	private String descIter;
	private String nuovoModello;
	private String anagFirmatario;
	private String selectedIterFirma;

	private String listaNuovoOrdineFirmatari;


	/* getters & setters */
	public String getSelectedModello() {
		return selectedModello;
	}

	public void setSelectedModello(String selectedModello) {
		this.selectedModello = selectedModello;
	}

	public String getNuovoModello() {
		return nuovoModello;
	}

	public void setNuovoModello(String nuovoModello) {
		this.nuovoModello = nuovoModello;
	}

	public String getAnagFirmatario() {
		return anagFirmatario;
	}

	public void setAnagFirmatario(String anagFirmatario) {
		this.anagFirmatario = anagFirmatario;
	}

	public String getDescIter() {
		return descIter;
	}

	public void setDescIter(String descIter) {
		this.descIter = descIter;
	}

	public String getListaNuovoOrdineFirmatari() {
		return listaNuovoOrdineFirmatari;
	}

	public void setListaNuovoOrdineFirmatari(String listaNuovoOrdineFirmatari) {
		this.listaNuovoOrdineFirmatari = listaNuovoOrdineFirmatari;
	}



	@Override
	public String toString() {
		return "GestioneWorkflowFirmeForm [selectedModello=" + selectedModello
				+ ", descIter=" + descIter + ", nuovoModello=" + nuovoModello
				+ ", anagFirmatario=" + anagFirmatario + "]";
	}

	public String getSelectedIterFirma() {
		return selectedIterFirma;
	}

	public void setSelectedIterFirma(String selectedIterFirma) {
		this.selectedIterFirma = selectedIterFirma;
	}

	public String getDescIterRetrieved() {
		return descIter;
	}
}
