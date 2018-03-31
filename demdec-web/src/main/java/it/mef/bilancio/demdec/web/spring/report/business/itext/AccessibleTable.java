package it.mef.bilancio.demdec.web.spring.report.business.itext;


import com.itextpdf.text.pdf.PdfPTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public class AccessibleTable extends PdfPTable{

	 private List<AccessibleCell> cellList;

	    public AccessibleTable(float[] relativeWidths) {
	        super(relativeWidths);
	        this.cellList = new ArrayList<AccessibleCell>();
	    }

	    public List<AccessibleCell> getCellList() {
	        return cellList;
	    }

	    public void addCell(AccessibleCell cell) {
	        super.addCell(cell);
	        for (int i = 0; i < cell.getColspan(); i++) {
	            this.cellList.add(cell);
	        }
	    }
}
