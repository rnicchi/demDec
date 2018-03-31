package it.mef.bilancio.demdec.web.spring.form;

import it.almavivaitalia.web.sh.form.AbstractForm;

public class FirmaDocumentiForm extends AbstractForm{
	
	private String [] selezioni;
	private String pin;
	private String tipoFirma;
	
	private boolean check;

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String[] getSelezioni() {
		return selezioni;
	}

	public void setSelezioni(String[] selezioni) {
		this.selezioni = selezioni;
	}
	
	public String getTipoFirma() {
		return tipoFirma;
	}

	public void setTipoFirma(String tipoFirma) {
		this.tipoFirma = tipoFirma;
	}
	
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public void clear(){
		this.pin = null;
		this.selezioni = null;
		this.tipoFirma = null;
		this.check = false;
	}

	

}
