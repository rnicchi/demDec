package it.mef.bilancio.demdec.web.spring.form;

import it.almavivaitalia.web.sh.form.AbstractForm;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadDecForm extends AbstractForm {
	private CommonsMultipartFile upFile;
	private String amm;
	private String tipoDoc;
	private String desc;
	private String idFasc;

	public CommonsMultipartFile getUpFile() {
		return upFile;
	}

	public void setUpFile(CommonsMultipartFile upFile) {
		this.upFile = upFile;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getAmm() {
		return amm;
	}

	public void setAmm(String amm) {
		this.amm = amm;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIdFasc() {
		return idFasc;
	}

	public void setIdFasc(String idFasc) {
		this.idFasc = idFasc;
	}

	

}
