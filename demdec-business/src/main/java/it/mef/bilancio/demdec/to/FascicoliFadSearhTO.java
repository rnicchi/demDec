package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bsn.sh.utils.DateUtil;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;

import java.util.Date;

public class FascicoliFadSearhTO {

	private Integer tipoDecreto;
	private Integer numeDecreto;
	private Short annoDecreto;
	private Integer tipologiaDecreto;
	private Integer numeStp;
	private Integer numeApp;
	private String ufficio;
	private Short cdr;
	private Short numePat;
	private Integer stato;
	private Date dataArrivoDa;
	private Date dataArrivoA;
	private Date dataRegistrazioneCdcDa;
	private Date dataRegistrazioneCdcA;
	private Integer flagVisibilitaCdc01;
	
	private String numeProtEntrataCdc;
	private Date dataProtEntrataCdc;
	private Date dataPresaInCaricoCdc;
	private String numeProtUscitaCdc;
	private Date dataProtUscitaCdc;
	
	


	public String getNumeProtEntrataCdc() {
		return numeProtEntrataCdc;
	}

	public void setNumeProtEntrataCdc(String numeProtEntrataCdc) {
		this.numeProtEntrataCdc = numeProtEntrataCdc;
	}

	public String getNumeProtUscitaCdc() {
		return numeProtUscitaCdc;
	}

	public void setNumeProtUscitaCdc(String numeProtUscitaCdc) {
		this.numeProtUscitaCdc = numeProtUscitaCdc;
	}

	public Date getDataProtEntrataCdc() {
		return dataProtEntrataCdc;
	}

	public void setDataProtEntrataCdc(Date dataProtEntrataCdc) {
		this.dataProtEntrataCdc = dataProtEntrataCdc;
	}
	
	public void setDataProtEntrataCdc(String dataProtEntrataCdc) {
		try{
			this.dataProtEntrataCdc = DateUtil.getDate(dataProtEntrataCdc);
		} catch(Exception e){
			
		}
	}

	public Date getDataPresaInCaricoCdc() {
		return dataPresaInCaricoCdc;
	}

	public void setDataPresaInCaricoCdc(Date dataPresaInCaricoCdc) {
		this.dataPresaInCaricoCdc = dataPresaInCaricoCdc;
	}
	public void setDataPresaInCaricoCdc(String dataPresaInCaricoCdc) {
		try{
			this.dataPresaInCaricoCdc = DateUtil.getDate(dataPresaInCaricoCdc);
		} catch(Exception e){
			
		}
	}
	



	public Date getDataProtUscitaCdc() {
		return dataProtUscitaCdc;
	}

	public void setDataProtUscitaCdc(Date dataProtUscitaCdc) {
		this.dataProtUscitaCdc = dataProtUscitaCdc;
	}
	
	public void setDataProtUscitaCdc(String dataProtUscitaCdc) {
		try{
			this.dataProtUscitaCdc = DateUtil.getDate(dataProtUscitaCdc);
		} catch(Exception e){
			
		}
	}

	public Integer getFlagVisibilitaCdc01() {
		return flagVisibilitaCdc01;
	}

	public void setFlagVisibilitaCdc01(Integer flagVisibilitaCdc01) {
		this.flagVisibilitaCdc01 = flagVisibilitaCdc01;
	}

	public Integer getTipoDecreto() {
		return tipoDecreto;
	}

	public void setTipoDecreto(Integer tipoDecreto) {
		this.tipoDecreto = tipoDecreto;
	}

	public void setTipoDecreto(String tipoDecreto) {
		try{
			this.tipoDecreto = ParseUtil.getInteger(tipoDecreto);
		}catch(Exception e){
			
		}
	}

	public Integer getNumeDecreto() {
		return numeDecreto;
	}

	public void setNumeDecreto(Integer numeDecreto) {
		this.numeDecreto = numeDecreto;
	}

	public void setNumeDecreto(String numeDecreto) {
		try{
			this.numeDecreto = ParseUtil.getInteger(numeDecreto);
		}catch(Exception e){
			
		}
	}

	public Short getAnnoDecreto() {
		return annoDecreto;
	}

	public void setAnnoDecreto(Short annoDecreto) {
		this.annoDecreto = annoDecreto;
	}

	public void setAnnoDecreto(String annoDecreto) {
		try{
			this.annoDecreto = ParseUtil.getShort(annoDecreto);
		}catch(Exception e){
			
		}
	}

	public Integer getTipologiaDecreto() {
		return tipologiaDecreto;
	}

	public void setTipologiaDecreto(Integer tipologiaDecreto) {
		this.tipologiaDecreto = tipologiaDecreto;
	}

	public void setTipologiaDecreto(String tipologiaDecreto) {
		try{
			this.tipologiaDecreto = ParseUtil.getInteger(tipologiaDecreto);
		}catch(Exception e){
			
		}
	}

	public Integer getNumeStp() {
		return numeStp;
	}

	public void setNumStp(Integer numeStp) {
		this.numeStp = numeStp;
	}

	public void setNumStp(String numeStp) {
		try{
			this.numeStp = ParseUtil.getInteger(numeStp);
		}catch(Exception e){
			
		}
	}

	public Integer getNumeApp() {
		return numeApp;
	}
	
	public void setNumeApp(Integer numeApp) {
		this.numeApp = numeApp;
	}
	
	public void setNumeApp(String numeApp) {
		try{
			this.numeApp = ParseUtil.getInteger(numeApp);
		}catch(Exception e){
			
		}
	}
	
	public void setAmmin(String ammin) {
		try{
			if(!StringUtil.isEmpty(ammin)){
				this.numeStp = ParseUtil.getInteger(ammin.substring(0, 2));
				this.numeApp = ParseUtil.getInteger(ammin.substring(2));
			}
		}catch(Exception e){
			
		}
	}
	
	public String getUfficio() {
		return ufficio;
	}
	
	public void setUfficio(String ufficio) {
		this.ufficio = StringUtil.isEmpty(ufficio)?null:ufficio;
	}
	
	public Short getCdr() {
		return cdr;
	}
	
	public void setCdr(Short cdr) {
		this.cdr = cdr;
	}
	
	public void setCdr(String cdr) {
		try{
			this.cdr = ParseUtil.getShort(cdr);
		}catch(Exception e){
			
		}
	}
	
	public Short getNumePat() {
		return numePat;
	}
	
	public void setNumePat(Short numePat) {
		this.numePat = numePat;
	}
	
	public void setNumePat(String numePat) {
		try{
			this.numePat = ParseUtil.getShort(numePat);
		}catch(Exception e){
			
		}
	}
	
	public Integer getStato() {
		return stato;
	}
	
	public void setStato(Integer stato) {
		this.stato = stato;
	}
	
	public void setStato(String stato) {
		try{
			this.stato = ParseUtil.getInteger(stato);
		}catch(Exception e){
			
		}
	}
	
	public Date getDataArrivoDa() {
		return dataArrivoDa;
	}
	
	public void setDataArrivoDa(Date dataArrivoDa) {
		this.dataArrivoDa = dataArrivoDa;
	}
	
	public void setDataArrivoDa(String dataArrivoDa) {
		try{
			this.dataArrivoDa = DateUtil.getDate(dataArrivoDa);
		} catch(Exception e){
			
		}
	}
	
	public Date getDataArrivoA() {
		return dataArrivoA;
	}
	
	public void setDataArrivoA(Date dataArrivoA) {
		this.dataArrivoA = dataArrivoA;
	}
	
	public void setDataArrivoA(String dataArrivoA) {
		try{
			this.dataArrivoA = DateUtil.getDate(dataArrivoA);
		} catch(Exception e){
			
		}
	}

	public Date getDataRegistrazioneCdcDa() {
		return dataRegistrazioneCdcDa;
	}

	public void setDataRegistrazioneCdcDa(Date dataRegistrazioneCdcDa) {
		this.dataRegistrazioneCdcDa = dataRegistrazioneCdcDa;
	}
	
	public void setDataRegistrazioneCdcDa(String dataRegistrazioneCdcDa) {
		try{
			this.dataRegistrazioneCdcDa = DateUtil.getDate(dataRegistrazioneCdcDa);
		} catch(Exception e){
			
		}
	}

	public Date getDataRegistrazioneCdcA() {
		return dataRegistrazioneCdcA;
	}

	public void setDataRegistrazioneCdcA(Date dataRegistrazioneCdcA) {
		this.dataRegistrazioneCdcA = dataRegistrazioneCdcA;
	}
	
	public void setDataRegistrazioneCdcA(String dataRegistrazioneCdcA) {
		try{
			this.dataRegistrazioneCdcA = DateUtil.getDate(dataRegistrazioneCdcA);
		} catch(Exception e){
			
		}
	}
	
}
