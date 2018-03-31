package it.mef.bilancio.demdec.web.spring.report.business.itext;

//import it.consip.pat.common.model.ReportBollettino;

import java.util.List;
import java.util.Map;


/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public class ITextReportDTO {

	 private String documentType;
	    private String documentMargins;
	 //   private ReportBollettino.FlagOV layout;
	    private String numeroTavola;
	    private String headerFirstPart;
	    private String headerSecondPart;
	    private String relativeColumnWidths;
	    private List<Map<String, Object>> resultSet;
	    private String note;
	    private Integer minHeightHeaderCell;
	    private Integer minHeightCommonCell;
	    private String annoEsercizioConsuntivo;
	    private Long tickUnit;
	    private String pathImage;
	    
	    

	    public String getPathImage() {
			return pathImage;
		}

		public void setPathImage(String pathImage) {
			this.pathImage = pathImage;
		}

		public String getDocumentType() {
	        return documentType;
	    }

	    public void setDocumentType(String documentType) {
	        this.documentType = documentType;
	    }

	    public String getDocumentMargins() {
	        return documentMargins;
	    }

	    public void setDocumentMargins(String documentMargins) {
	        this.documentMargins = documentMargins;
	    }
/*
	    public ReportBollettino.FlagOV getLayout() {
	        return layout;
	    }

	    public void setLayout(ReportBollettino.FlagOV layout) {
	        this.layout = layout;
	    }
*/
	    public String getNumeroTavola() {
	        return numeroTavola;
	    }

	    public void setNumeroTavola(String numeroTavola) {
	        this.numeroTavola = numeroTavola;
	    }

	    public String getHeaderFirstPart() {
	        return headerFirstPart;
	    }

	    public void setHeaderFirstPart(String headerFirstPart) {
	        this.headerFirstPart = headerFirstPart;
	    }

	    public String getHeaderSecondPart() {
	        return headerSecondPart;
	    }

	    public void setHeaderSecondPart(String headerSecondPart) {
	        this.headerSecondPart = headerSecondPart;
	    }

	    public String getRelativeColumnWidths() {
	        return relativeColumnWidths;
	    }

	    public void setRelativeColumnWidths(String relativeColumnWidths) {
	        this.relativeColumnWidths = relativeColumnWidths;
	    }

	    public List<Map<String, Object>> getResultSet() {
	        return resultSet;
	    }

	    public void setResultSet(List<Map<String, Object>> resultSet) {
	        this.resultSet = resultSet;
	    }

	    public String getNote() {
	        return note;
	    }

	    public void setNote(String note) {
	        this.note = note;
	    }

	    public Integer getMinHeightHeaderCell() {
	        return minHeightHeaderCell;
	    }

	    public void setMinHeightHeaderCell(Integer minHeightHeaderCell) {
	        this.minHeightHeaderCell = minHeightHeaderCell;
	    }

	    public Integer getMinHeightCommonCell() {
	        return minHeightCommonCell;
	    }

	    public void setMinHeightCommonCell(Integer minHeightCommonCell) {
	        this.minHeightCommonCell = minHeightCommonCell;
	    }

	    public String getAnnoEsercizioConsuntivo() {
	        return annoEsercizioConsuntivo;
	    }

	    public void setAnnoEsercizioConsuntivo(String annoEsercizioConsuntivo) {
	        this.annoEsercizioConsuntivo = annoEsercizioConsuntivo;
	    }

	    public Long getTickUnit() {
	        return tickUnit;
	    }

	    public void setTickUnit(Long tickUnit) {
	        this.tickUnit = tickUnit;
	    }
}
