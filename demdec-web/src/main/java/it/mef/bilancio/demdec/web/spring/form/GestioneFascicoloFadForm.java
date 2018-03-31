/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.form;

import it.almavivaitalia.bilancio.commons.to.DescDocumentoTO;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author utente
 *
 */
public class GestioneFascicoloFadForm extends ConsultaFascicoloFadForm {
	
	private String tipologiaDecretoMod;
	private String amministrazioneMod;
	private String ufficioMod;
	private String cdrMod;
	private String descrDecretoMod;
	private String numePatMod;
	
	private CommonsMultipartFile upFile;
	private String amm;
	private String tipoDoc;
	private String desc;
	private String descVisibilitaCdc;
	private String descVisibilitaCdcDisabled;
	private String tipoOperazione;
//	private String idFasc;
	
	// attributi per modifica modale
	private String modaleUpdFadAmm;
	private String modaleUpdFadTipoDoc;
	private String modaleUpdFadDesc;
	private String modaleUpdFadVisibilita;
	private List<DescDocumentoTO> listaDescDocumenti;
	
	// attributi per modifica modale RED
	private String modaleUpdRedVisibilitaCdc;
	private String modaleUpdRedVisibilitaCdcOrig;
	private String modaleUpdRedTipoDoc;
	private String modaleUpdRedTipoDocOrig;
	
	private String modaleUpdRedDescDoc;
	private String modaleUpdRedDescDocOrig;
	


	public String getModaleUpdRedDescDoc() {
		return modaleUpdRedDescDoc;
	}

	public void setModaleUpdRedDescDoc(String modaleUpdRedDescDoc) {
		this.modaleUpdRedDescDoc = modaleUpdRedDescDoc;
	}

	public String getModaleUpdRedDescDocOrig() {
		return modaleUpdRedDescDocOrig;
	}

	public void setModaleUpdRedDescDocOrig(String modaleUpdRedDescDocOrig) {
		this.modaleUpdRedDescDocOrig = modaleUpdRedDescDocOrig;
	}

	public String getModaleUpdRedTipoDocOrig() {
		return modaleUpdRedTipoDocOrig;
	}

	public void setModaleUpdRedTipoDocOrig(String modaleUpdRedTipoDocOrig) {
		this.modaleUpdRedTipoDocOrig = modaleUpdRedTipoDocOrig;
	}

	public String getModaleUpdRedVisibilitaCdc() {
		return modaleUpdRedVisibilitaCdc;
	}

	public void setModaleUpdRedVisibilitaCdc(String modaleUpdRedVisibilitaCdc) {
		this.modaleUpdRedVisibilitaCdc = modaleUpdRedVisibilitaCdc;
	}

	public String getModaleUpdRedTipoDoc() {
		return modaleUpdRedTipoDoc;
	}

	public void setModaleUpdRedTipoDoc(String modaleUpdRedTipoDoc) {
		this.modaleUpdRedTipoDoc = modaleUpdRedTipoDoc;
	}

	public String getTipologiaDecretoMod() {
		return tipologiaDecretoMod;
	}

	public void setTipologiaDecretoMod(String tipologiaDecretoMod) {
		this.tipologiaDecretoMod = tipologiaDecretoMod;
	}

	public String getAmministrazioneMod() {
		return amministrazioneMod;
	}

	public void setAmministrazioneMod(String amministrazioneMod) {
		this.amministrazioneMod = amministrazioneMod;
	}

	public String getUfficioMod() {
		return ufficioMod;
	}

	public void setUfficioMod(String ufficioMod) {
		this.ufficioMod = ufficioMod;
	}

	public String getCdrMod() {
		return cdrMod;
	}

	public void setCdrMod(String cdrMod) {
		this.cdrMod = cdrMod;
	}

	public String getDescrDecretoMod() {
		return descrDecretoMod;
	}

	public void setDescrDecretoMod(String descrDecretoMod) {
		this.descrDecretoMod = descrDecretoMod;
	}

	public String getNumePatMod() {
		return numePatMod;
	}

	public void setNumePatMod(String numePatMod) {
		this.numePatMod = numePatMod;
	}
	
	

	public CommonsMultipartFile getUpFile() {
		return upFile;
	}

	public void setUpFile(CommonsMultipartFile upFile) {
		this.upFile = upFile;
	}

	public String getAmm() {
		return amm;
	}

	public void setAmm(String amm) {
		this.amm = amm;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void reset(){
		super.reset();
		this.tipologiaDecretoMod = "";
		this.amministrazioneMod = "";
		this.ufficioMod = "";
		this.cdrMod = "";
		this.descrDecretoMod = "";
		this.numePatMod = "";
		this.modaleUpdFadAmm = "";
		this.modaleUpdFadTipoDoc = "";
		this.modaleUpdFadDesc = "";
		this.modaleUpdFadVisibilita = "";
		this.modaleUpdRedVisibilitaCdc = "";
		this.modaleUpdRedVisibilitaCdcOrig = "";
		this.modaleUpdRedTipoDoc = "";
		this.modaleUpdRedTipoDocOrig = "";
		this.modaleUpdRedDescDoc = "";
		this.modaleUpdRedDescDocOrig = "";
	}

	public String getDescVisibilitaCdc() {
		return descVisibilitaCdc;
	}

	public void setDescVisibilitaCdc(String descVisibilitaCdc) {
		this.descVisibilitaCdc = descVisibilitaCdc;
	}

	public String getModaleUpdFadAmm() {
		return modaleUpdFadAmm;
	}

	public void setModaleUpdFadAmm(String modaleUpdFadAmm) {
		this.modaleUpdFadAmm = modaleUpdFadAmm;
	}

	public String getModaleUpdFadTipoDoc() {
		return modaleUpdFadTipoDoc;
	}

	public void setModaleUpdFadTipoDoc(String modaleUpdFadTipoDoc) {
		this.modaleUpdFadTipoDoc = modaleUpdFadTipoDoc;
	}

	public String getModaleUpdFadDesc() {
		return modaleUpdFadDesc;
	}

	public void setModaleUpdFadDesc(String modaleUpdFadDesc) {
		this.modaleUpdFadDesc = modaleUpdFadDesc;
	}

	public String getModaleUpdFadVisibilita() {
		return modaleUpdFadVisibilita;
	}

	public void setModaleUpdFadVisibilita(String modaleUpdFadVisibilita) {
		this.modaleUpdFadVisibilita = modaleUpdFadVisibilita;
	}

	public String getModaleUpdRedVisibilitaCdcOrig() {
		return modaleUpdRedVisibilitaCdcOrig;
	}

	public void setModaleUpdRedVisibilitaCdcOrig(
			String modaleUpdRedVisibilitaCdcOrig) {
		this.modaleUpdRedVisibilitaCdcOrig = modaleUpdRedVisibilitaCdcOrig;
	}

	public List<DescDocumentoTO> getListaDescDocumenti() {
		return listaDescDocumenti;
	}

	public void setListaDescDocumenti(List<DescDocumentoTO> listaDescDocumenti) {
		this.listaDescDocumenti = listaDescDocumenti;
	}

	public String getTipoOperazione() {
		return tipoOperazione;
	}

	public void setTipoOperazione(String tipoOperazione) {
		this.tipoOperazione = tipoOperazione;
	}

	public String getDescVisibilitaCdcDisabled() {
		return descVisibilitaCdcDisabled;
	}

	public void setDescVisibilitaCdcDisabled(String descVisibilitaCdcDisabled) {
		this.descVisibilitaCdcDisabled = descVisibilitaCdcDisabled;
	}
	
	
	
}
