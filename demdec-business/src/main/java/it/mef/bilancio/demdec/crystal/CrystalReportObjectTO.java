package it.mef.bilancio.demdec.crystal;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;

import java.util.ArrayList;
import java.util.List;

public class CrystalReportObjectTO implements java.io.Serializable {//INIZIO METODO

	private String id;
	private int idCr;
	
	private String descrReport;
	private String codiReportCr;
	private String statTipoReport;
	private String dataEsecuzione;
	private String stato;
	private String descStato;
	private boolean showExportPdf;
	private boolean showExportExcel;
	private boolean showExportWord;
	/*
	 * lista di parametri con cui è stata effettuata la schedulazione
	 */
	private List<CodeDescriptionTO> properties;
	
//	private List<JStampeTO> stampeList = new ArrayList<JStampeTO>(0);
	private List<CodeDescriptionTO> exportFormat=new ArrayList<CodeDescriptionTO>();
	
	public CrystalReportObjectTO() {//INIZIO METODO
	}

	public CrystalReportObjectTO(String codiReportCr, String statTipoReport) {//INIZIO METODO
		this.codiReportCr = codiReportCr;
		this.statTipoReport = statTipoReport;
	}

	public CrystalReportObjectTO(String descrReport, String codiReportCr,
			String statTipoReport) {//INIZIO METODO
		this.descrReport = descrReport;
		this.codiReportCr = codiReportCr;
		this.statTipoReport = statTipoReport;
//		this.stampeList = stampeList;
	}

	public String getId() {//INIZIO METODO
		return this.id;
	}

	public void setId(String id) {//INIZIO METODO
		this.id = id;
	}

	public String getDescrReport() {//INIZIO METODO
		return this.descrReport;
	}

	public void setDescrReport(String descrReport) {//INIZIO METODO
		this.descrReport = descrReport;
	}

	public String getCodiReportCr() {//INIZIO METODO
		return this.codiReportCr;
	}

	public void setCodiReportCr(String codiReportCr) {//INIZIO METODO
		this.codiReportCr = codiReportCr;
	}

	public String getStatTipoReport() {//INIZIO METODO
		return this.statTipoReport;
	}

	public void setStatTipoReport(String statTipoReport) {//INIZIO METODO
		this.statTipoReport = statTipoReport;
	}

//	public List<JStampeTO> getStampeList() {//INIZIO METODO
//		return stampeList;
//	}
//
//	public void setStampeList(List<JStampeTO> stampeList) {//INIZIO METODO
//		this.stampeList = stampeList;
//	}
//	
	public String getDataEsecuzione() {//INIZIO METODO
		return dataEsecuzione;
	}

	public void setDataEsecuzione(String dataEsecuzione) {//INIZIO METODO
		this.dataEsecuzione = dataEsecuzione;
	}

	public List<CodeDescriptionTO> getExportFormat() {//INIZIO METODO
		return exportFormat;
	}

	public void setExportFormat(List<CodeDescriptionTO> exportFormat) {//INIZIO METODO
		this.exportFormat = exportFormat;
	}
	
	public List<CodeDescriptionTO> addExportFormat(CodeDescriptionTO cd) {//INIZIO METODO
		exportFormat.add(cd);
		return exportFormat;
	}
	
	public int getIdCr() {//INIZIO METODO
		return idCr;
	}

	public void setIdCr(int idCr) {//INIZIO METODO
		this.idCr = idCr;
	}
	
	public String getStato() {//INIZIO METODO
		return stato;
	}

	public void setStato(String stato) {//INIZIO METODO
		this.stato = stato;
	}

	public String getDescStato() {//INIZIO METODO
		return descStato;
	}

	public void setDescStato(String descStato) {//INIZIO METODO
		this.descStato = descStato;
	}

	public List<CodeDescriptionTO> getProperties() {//INIZIO METODO
		return properties;
	}

	public void setProperties(List<CodeDescriptionTO> properties) {//INIZIO METODO
		this.properties = properties;
	}

	public boolean isShowExportPdf() {
		return showExportPdf;
	}

	public void setShowExportPdf(boolean showExportPdf) {
		this.showExportPdf = showExportPdf;
	}

	public boolean isShowExportExcel() {
		return showExportExcel;
	}

	public void setShowExportExcel(boolean showExportExcel) {
		this.showExportExcel = showExportExcel;
	}

	public boolean isShowExportWord() {
		return showExportWord;
	}

	public void setShowExportWord(boolean showExportWord) {
		this.showExportWord = showExportWord;
	}



	// The following is extra code specified in the hbm.xml files
	private static final long serialVersionUID = 1L;
	// end of extra code specified in the hbm.xml files

}
