package it.mef.bilancio.demdec.web.spring.report.business.itext;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public class AccessibleCell extends PdfPCell{

	 private String alternativeText;
	    private String rowType;

	    public AccessibleCell(Phrase phrase, String alternativeText) {
	        super(phrase);
	        this.alternativeText = alternativeText;
	    }

	    public String getAlternativeText() {
	        return alternativeText;
	    }

	    public void setAlternativeText(String alternativeText) {
	        this.alternativeText = alternativeText;
	    }

	    public String getRowType() {
	        return rowType;
	    }

	    public void setRowType(String rowType) {
	        this.rowType = rowType;
	    }
}
