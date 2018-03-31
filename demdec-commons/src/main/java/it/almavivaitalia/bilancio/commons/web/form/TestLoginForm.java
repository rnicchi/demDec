package it.almavivaitalia.bilancio.commons.web.form;

import it.almavivaitalia.web.sh.form.AbstractForm;

public class TestLoginForm extends AbstractForm{

	
	/*METRICHE*/
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM1 = "LOCM"; 
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM2 = "LOCM";
	
	private String selectRuolo;
	private String textUtente;
	private String passUtente;


	public TestLoginForm(){}
	
	public String getSelectRuolo() {
		return selectRuolo;
	}
	public void setSelectRuolo(String selectRuolo) {
		this.selectRuolo = selectRuolo;
	}
	public String getTextUtente() {
		return textUtente;
	}
	public void setTextUtente(String textUtente) {
		this.textUtente = textUtente;
	}

	public String getPassUtente() {
		return passUtente;
	}

	public void setPassUtente(String passUtente) {
		this.passUtente = passUtente;
	}
	
}
