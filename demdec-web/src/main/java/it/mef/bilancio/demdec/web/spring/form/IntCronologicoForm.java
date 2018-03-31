package it.mef.bilancio.demdec.web.spring.form;										

import java.util.List;

import it.almavivaitalia.web.sh.form.AbstractForm;
import it.mef.bilancio.demdec.to.CodeDescriptionTitleTO;


public class IntCronologicoForm extends AbstractForm
{

	private String dataDa;
	private String dataA;
	private String oraDa;
	private String oraA;
	private String codiApplicazione;
	private String codiCategoria;
	private String codiFunzione;
	private String codiMenu;
	private String descApplicazione;
	private String descCategoria;
	private String descFunzione;
	private String utente;
	private String filtroCapPg;
	private String filtroAutorizzazione;
	private String filtroStrumento;                
	private String filtroSottoStrumento;
	private String filtroPl;
	private String filtroPartita;
	// TRANSAZIONE //
	private String traCodiCodice;
	//CapPg//
	private String capAnno;
	private String capStp;
	private String capApp;
	private String capEos;
	private String capNume;
	private String numePg;
	// Autor //
	private String autAnno;
	private String autDescTipo;
	private String autTipo;
	private String autNume;
	private String autArt;
	private String autSubArt;
	private String autDescSubArt;
	private String autComma;
	private String autSubComma;
	private String autDescSubComma;
	private String autPunto;
	private String autSubPunto;
	private String autDescSubPunto;
	// Strumento //
	private String strAnno;
	private String strNume;
	private String strDescTipo;
	private String strTipo;
	// Sotto Strumento //
	private String sstAnno;
	private String sstNume;
	private String sstDescTipo;
	private String sstTipo;
	// Partita //
	private String parEseAnnoEse;
	private String parAnno;	
	private String parNumero;
	// PL //
	private String plAnno;		        
	private String plNumero;
	
	public String getDataDa() {
		return dataDa;
	}
	public void setDataDa(String dataDa) {
		this.dataDa = dataDa;
	}
	public String getDataA() {
		return dataA;
	}
	public void setDataA(String dataA) {
		this.dataA = dataA;
	}
	public String getOraDa() {
		return oraDa;
	}
	public void setOraDa(String oraDa) {
		this.oraDa = oraDa;
	}
	public String getOraA() {
		return oraA;
	}
	public void setOraA(String oraA) {
		this.oraA = oraA;
	}
	public String getCodiApplicazione() {
		return codiApplicazione;
	}
	public void setCodiApplicazione(String codiApplicazione) {
		this.codiApplicazione = codiApplicazione;
	}
	public String getCodiCategoria() {
		return codiCategoria;
	}
	public void setCodiCategoria(String codiCategoria) {
		this.codiCategoria = codiCategoria;
	}
	public String getCodiFunzione() {
		return codiFunzione;
	}
	public void setCodiFunzione(String codiFunzione) {
		this.codiFunzione = codiFunzione;
	}
	public String getDescApplicazione() {
		return descApplicazione;
	}
	public void setDescApplicazione(String descApplicazione) {
		this.descApplicazione = descApplicazione;
	}
	public String getDescCategoria() {
		return descCategoria;
	}
	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}
	public String getDescFunzione() {
		return descFunzione;
	}
	public void setDescFunzione(String descFunzione) {
		this.descFunzione = descFunzione;
	}	
    public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	
    public String getFiltroCapPg() {
		return filtroCapPg;
	}
	public void setFiltroCapPg(String filtroCapPg) {
		this.filtroCapPg = filtroCapPg;
	}
	public String getFiltroAutorizzazione() {
		return filtroAutorizzazione;
	}
	public void setFiltroAutorizzazione(String filtroAutorizzazione) {
		this.filtroAutorizzazione = filtroAutorizzazione;
	}
	public String getFiltroStrumento() {
		return filtroStrumento;
	}
	public void setFiltroStrumento(String filtroStrumento) {
		this.filtroStrumento = filtroStrumento;
	}
	public String getFiltroSottoStrumento() {
		return filtroSottoStrumento;
	}
	public void setFiltroSottoStrumento(String filtroSottoStrumento) {
		this.filtroSottoStrumento = filtroSottoStrumento;
	}
	
	public String getCapAnno() {
		return capAnno;
	}
	public void setCapAnno(String capAnno) {
		this.capAnno = capAnno;
	}
	public String getCapStp() {
		return capStp;
	}
	public void setCapStp(String capStp) {
		this.capStp = capStp;
	}
	public String getCapApp() {
		return capApp;
	}
	public void setCapApp(String capApp) {
		this.capApp = capApp;
	}
	public String getCapEos() {
		return capEos;
	}
	public void setCapEos(String capEos) {
		this.capEos = capEos;
	}
	public String getCapNume() {
		return capNume;
	}
	public void setCapNume(String capNume) {
		this.capNume = capNume;
	}
	public String getNumePg() {
		return numePg;
	}
	public void setNumePg(String numePg) {
		this.numePg = numePg;
	}
	public String getAutAnno() {
		return autAnno;
	}
	public void setAutAnno(String autAnno) {
		this.autAnno = autAnno;
	}
	public String getAutDescTipo() {
		return autDescTipo;
	}
	public void setAutDescTipo(String autDescTipo) {
		this.autDescTipo = autDescTipo;
	}
	public String getAutTipo() {
		return autTipo;
	}
	public void setAutTipo(String autTipo) {
		this.autTipo = autTipo;
	}
	public String getAutNume() {
		return autNume;
	}
	public void setAutNume(String autNume) {
		this.autNume = autNume;
	}
	public String getAutArt() {
		return autArt;
	}
	public void setAutArt(String autArt) {
		this.autArt = autArt;
	}
	public String getAutSubArt() {
		return autSubArt;
	}
	public void setAutSubArt(String autSubArt) {
		this.autSubArt = autSubArt;
	}
	public String getAutDescSubArt() {
		return autDescSubArt;
	}
	public void setAutDescSubArt(String autDescSubArt) {
		this.autDescSubArt = autDescSubArt;
	}
	public String getAutComma() {
		return autComma;
	}
	public void setAutComma(String autComma) {
		this.autComma = autComma;
	}
	public String getAutSubComma() {
		return autSubComma;
	}
	public void setAutSubComma(String autSubComma) {
		this.autSubComma = autSubComma;
	}
	public String getAutDescSubComma() {
		return autDescSubComma;
	}
	public void setAutDescSubComma(String autDescSubComma) {
		this.autDescSubComma = autDescSubComma;
	}
	public String getAutPunto() {
		return autPunto;
	}
	public void setAutPunto(String autPunto) {
		this.autPunto = autPunto;
	}
	public String getAutSubPunto() {
		return autSubPunto;
	}
	public void setAutSubPunto(String autSubPunto) {
		this.autSubPunto = autSubPunto;
	}
	public String getAutDescSubPunto() {
		return autDescSubPunto;
	}
	public void setAutDescSubPunto(String autDescSubPunto) {
		this.autDescSubPunto = autDescSubPunto;
	}
	public String getStrAnno() {
		return strAnno;
	}
	public void setStrAnno(String strAnno) {
		this.strAnno = strAnno;
	}
	public String getStrNume() {
		return strNume;
	}
	public void setStrNume(String strNume) {
		this.strNume = strNume;
	}
	public String getStrDescTipo() {
		return strDescTipo;
	}
	public void setStrDescTipo(String strDescTipo) {
		this.strDescTipo = strDescTipo;
	}
	public String getStrTipo() {
		return strTipo;
	}
	public void setStrTipo(String strTipo) {
		this.strTipo = strTipo;
	}
	public String getSstAnno() {
		return sstAnno;
	}
	public void setSstAnno(String sstAnno) {
		this.sstAnno = sstAnno;
	}
	public String getSstNume() {
		return sstNume;
	}
	public void setSstNume(String sstNume) {
		this.sstNume = sstNume;
	}
	public String getSstDescTipo() {
		return sstDescTipo;
	}
	public void setSstDescTipo(String sstDescTipo) {
		this.sstDescTipo = sstDescTipo;
	}
	public String getSstTipo() {
		return sstTipo;
	}
	public void setSstTipo(String sstTipo) {
		this.sstTipo = sstTipo;
	}
	
	public String getCodiMenu() {
		return codiMenu;
	}
	public void setCodiMenu(String codiMenu) {
		this.codiMenu = codiMenu;
	}
	
	public String getParEseAnnoEse() {
		return parEseAnnoEse;
	}
	public void setParEseAnnoEse(String parEseAnnoEse) {
		this.parEseAnnoEse = parEseAnnoEse;
	}
	public String getParAnno() {
		return parAnno;
	}
	public void setParAnno(String parAnno) {
		this.parAnno = parAnno;
	}
	public String getParNumero() {
		return parNumero;
	}
	public void setParNumero(String parNumero) {
		this.parNumero = parNumero;
	}
	public String getPlAnno() {
		return plAnno;
	}
	public void setPlAnno(String plAnno) {
		this.plAnno = plAnno;
	}
	public String getPlNumero() {
		return plNumero;
	}
	public void setPlNumero(String plNumero) {
		this.plNumero = plNumero;
	}	
	public String getFiltroPl() {
		return filtroPl;
	}
	public void setFiltroPl(String filtroPl) {
		this.filtroPl = filtroPl;
	}
	public String getFiltroPartita() {
		return filtroPartita;
	}
	public void setFiltroPartita(String filtroPartita) {
		this.filtroPartita = filtroPartita;
	}
	public void reset(){
	  dataDa="";
	  dataA ="";
	  oraDa="";
	  oraA="";
	  codiApplicazione="";
	  codiCategoria="";
	  codiFunzione="";
	  descApplicazione="";
	  descCategoria="";
	  descFunzione="";
	  codiMenu="";
	  utente="";
	  filtroCapPg="";
	  filtroAutorizzazione="";
	  filtroStrumento="";                
	  filtroSottoStrumento="";
	  filtroPl="";
	  filtroPartita="";
	  // TRANSAZIONE //
	  traCodiCodice="";
	  //CapPg//
	  capAnno="";  capStp="";  capApp="";  capEos="";  capNume="";  numePg="";
	  // Autor //
	  autAnno="";  autDescTipo="";  autTipo="";  autNume="";  autArt="";  autSubArt="";
	  autDescSubArt="";  autComma="";  autSubComma="";  autDescSubComma="";  autPunto="";
	  autSubPunto="";  autDescSubPunto="";
	  // Strumento //
	  strAnno="";  strNume="";  strDescTipo="";  strTipo="";
	  // Sotto Strumento //
	  sstAnno="";  sstNume="";  sstDescTipo="";  sstTipo="";
  	  // Partita //
	  parEseAnnoEse=""; parAnno =""; parNumero="";
	  // PL //
	  plAnno=""; plNumero="";
    }	
	public void resetFiltri(){		  
		  //CapPg//
	  capAnno="";  capStp="";  capApp="";  capEos="";  capNume="";  numePg="";
	  // Autor //
	  autAnno="";  autDescTipo="";  autTipo="";  autNume="";  autArt="";  autSubArt="";
	  autDescSubArt="";  autComma="";  autSubComma="";  autDescSubComma=""; autPunto="";
	  autSubPunto="";  autDescSubPunto="";
	  // Strumento //
	  strAnno="";  strNume="";  strDescTipo="";  strTipo="";
	  // Sotto Strumento //
	  sstAnno="";  sstNume="";  sstDescTipo="";  sstTipo="";
	  // Partita //
	  parEseAnnoEse=""; parAnno =""; parNumero="";
	  // PL //
	  plAnno=""; plNumero="";
	}
	public boolean ctrCapitolo(){
		boolean exit = true;
		if (capAnno.isEmpty() && capStp.isEmpty() && capApp.isEmpty() && capEos.isEmpty() && capNume.isEmpty() && numePg.isEmpty()){
			exit = false;
		}       
		return exit;
	}
	public boolean ctrAutorizzazione(List<CodeDescriptionTitleTO> list){
		boolean exit = true;		
		if (autDescTipo.isEmpty() && 
			autNume.isEmpty()     && 
			autAnno.isEmpty()     && 
			autArt.isEmpty()      && 
			autComma.isEmpty()    && 
			autPunto.isEmpty()   &&
			autDescSubArt.equals("0") && 
			autDescSubComma.equals("0") && 
			autDescSubPunto.equals("0")){
			exit = false;			
		}       
		return exit;
	}
	public boolean ctrStrumento(){
		boolean exit = true;
		if (strDescTipo.isEmpty() && strNume.isEmpty() && strAnno.isEmpty()){
			exit = false;
		}       
		return exit;
	}
	public boolean ctrSottoStrumento(){
		boolean exit = true;
		if (sstDescTipo.isEmpty() && sstNume.isEmpty() && sstAnno.isEmpty()){
			exit = false;
		}  
		return exit;
	}
	public boolean ctrPartita(){
		boolean exit = true;
		if (parEseAnnoEse.isEmpty() && parAnno.isEmpty() && parNumero.isEmpty() ){
			exit = false;
		}       
		return exit;
	}
	public boolean ctrPl(){
		boolean exit = true;
		if (plAnno.isEmpty() && plNumero.isEmpty()){
			exit = false;
		}       
		return exit;
	}
	public String getTraCodiCodice() {
		return traCodiCodice;
	}
	public void setTraCodiCodice(String traCodiCodice) {
		this.traCodiCodice = traCodiCodice;
	}	
}
