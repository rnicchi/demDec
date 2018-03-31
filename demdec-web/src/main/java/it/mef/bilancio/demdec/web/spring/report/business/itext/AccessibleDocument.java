package it.mef.bilancio.demdec.web.spring.report.business.itext;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
//import it.consip.fgen.core.report.business.itext.util.ReportITextConstants;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public class AccessibleDocument implements IAccessibleDocument {

	 protected Rectangle pageSize;
	    protected String title;
	    protected String headerFirstPart;
	    protected String headerSecondPart;
	    protected float[] relativeColumnWidths;
	    protected String note;
	    protected Map<String, Float> documentMargins;
	    protected float minHeightHeaderCell;
	    protected float minHeightCommonCell;
	    protected double tickUnit;
	    protected List<AccessibleTable> tables = new ArrayList<AccessibleTable>();
	    protected String pathImage;
	    
	    

	    public String getPathImage() {
			return pathImage;
		}

		public void setPathImage(String pathImage) {
			this.pathImage = pathImage;
		}

		public Rectangle getPageSize() {
	        return pageSize;
	    }

	    public void setPageSize(Rectangle pageSize) {
	        this.pageSize = pageSize;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
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

	    public float[] getRelativeColumnWidths() {
	        return relativeColumnWidths;
	    }

	    public void setRelativeColumnWidths(float[] relativeColumnWidths) {
	        this.relativeColumnWidths = relativeColumnWidths;
	    }

	    public String getNote() {
	        return note;
	    }

	    public void setNote(String note) {
	        this.note = note;
	    }

	    public Map<String, Float> getDocumentMargins() {
	        return documentMargins;
	    }

	    public void setDocumentMargins(Map<String, Float> documentMargins) {
	        this.documentMargins = documentMargins;
	    }

	    public float getMinHeightHeaderCell() {
	        return minHeightHeaderCell;
	    }

	    public void setMinHeightHeaderCell(float minHeightHeaderCell) {
	        this.minHeightHeaderCell = minHeightHeaderCell;
	    }

	    public float getMinHeightCommonCell() {
	        return minHeightCommonCell;
	    }

	    public void setMinHeightCommonCell(float minHeightCommonCell) {
	        this.minHeightCommonCell = minHeightCommonCell;
	    }

	    public double getTickUnit() {
	        return tickUnit;
	    }

	    public void setTickUnit(double tickUnit) {
	        this.tickUnit = tickUnit;
	    }

	    public List<AccessibleTable> getTables() {
	        return tables;
	    }

	    public void setTables(List<AccessibleTable> tables) {
	        this.tables = tables;
	    }

	    public float writeHeader(PdfContentByte cb, PdfStructureElement parentElement) {
	        final float initialYPos = pageSize.getTop() - documentMargins.get(ReportITextConstants.TOP_MARGIN_KEY);
	        if ((headerFirstPart == null || headerFirstPart.trim().isEmpty()) && (headerSecondPart == null || headerSecondPart.trim().isEmpty())) {
	            return initialYPos;
	        }
	        final float upperLeftX = pageSize.getLeft() + documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY);

	        PdfStructureElement headerElement = new PdfStructureElement(parentElement, PdfName.H);
	        PdfStructureElement spanElement = new PdfStructureElement(headerElement, PdfName.SPAN);

	        PdfPTable table = new PdfPTable(new float[]{1});
	        table.setTotalWidth(pageSize.getWidth() - documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY) - documentMargins.get(ReportITextConstants.RIGHT_MARGIN_KEY));
	        table.getDefaultCell().setBorder(0);
	        Phrase header = new Phrase(title + " - " + headerFirstPart, ReportITextConstants.BIG_BOLD_BLACK);
	        header.add(new Phrase(ReportITextConstants.HEADER_BREAK + headerSecondPart, ReportITextConstants.BIG_NORMAL_BLACK));
	        table.addCell(header);

	        cb.beginMarkedContentSequence(spanElement);
	        float yPos = table.writeSelectedRows(0, 1, upperLeftX, initialYPos, cb);
	        cb.endMarkedContentSequence();
	        return yPos - 15f;
	    }

	    public float writeRow(AccessibleTable table, PdfContentByte cb, PdfStructureElement parentElement, boolean isHeader, int rowIndex, float initialYPos) {

	        float yPos = initialYPos;
	        float xPos = pageSize.getLeft() + documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY);

	        AccessibleCell firstCellOfTheRow = table.getCellList().get(rowIndex * table.getNumberOfColumns());
	        /*
	        23/10/2013
	        modifica nella gestione di alcuni colspan
	        esempio tavola 20:
	        - le righe Beni Immobili Patrimoniali e Beni Immobili Demaniali non devono essere taggate;
	        - le diciture 'Beni Immobili Patrimoniali' e 'Beni Immobili Demaniali' devono essere anteposte alle relative categorie
	         */
	        if (firstCellOfTheRow.getRowType().startsWith(ReportITextConstants.COLSPAN_PREFIX) && firstCellOfTheRow.getRowType().endsWith(ReportITextConstants.NO_TAG)) {
	            parentElement.clear();
	            yPos = table.writeSelectedRows(rowIndex, rowIndex + 1, xPos, yPos, cb);
	        } else if (firstCellOfTheRow.getRowType().startsWith(ReportITextConstants.COLSPAN_PREFIX)) {
	            yPos = writeColspanCell(table, firstCellOfTheRow, cb, new PdfStructureElement(parentElement, isHeader ? PdfName.TH : PdfName.TD), rowIndex, xPos, yPos);
	        } else {
	            for (int columnIndex = 0; columnIndex < table.getNumberOfColumns(); columnIndex++) {

	                if ((columnIndex + 1) == table.getNumberOfColumns())
	                    yPos = writeCell(table, cb, new PdfStructureElement(parentElement, isHeader ? PdfName.TH : PdfName.TD), rowIndex, columnIndex, xPos, yPos);
	                else {
	                    writeCell(table, cb, new PdfStructureElement(parentElement, isHeader ? PdfName.TH : PdfName.TD), rowIndex, columnIndex, xPos, yPos);
	                    xPos += table.getAbsoluteWidths()[columnIndex];
	                }
	            }
	        }
	        return yPos;
	    }

	    public float writeCell(AccessibleTable table, PdfContentByte cb, PdfStructureElement parentElement, int rowIndex, int columnIndex, float initialXPos, float initialYPos) {

	        AccessibleCell currentCell = table.getCellList().get((rowIndex * table.getNumberOfColumns()) + columnIndex);

	        PdfStructureElement spanElement = new PdfStructureElement(parentElement, PdfName.SPAN);

	        cb.beginMarkedContentSequence(spanElement);

	        if (currentCell.getAlternativeText() == null) {
	            initialYPos = table.writeSelectedRows(columnIndex, columnIndex + 1, rowIndex, rowIndex + 1, initialXPos, initialYPos, cb);

	        } else {
	            PdfDictionary dict = new PdfDictionary();
	            dict.put(PdfName.ALT, new PdfString(currentCell.getAlternativeText()));
	            cb.beginMarkedContentSequence(PdfName.SPAN, dict, true);

	            initialYPos = table.writeSelectedRows(columnIndex, columnIndex + 1, rowIndex, rowIndex + 1, initialXPos, initialYPos, cb);

	            cb.endMarkedContentSequence();

	        }

	        cb.endMarkedContentSequence();

	        return initialYPos;
	    }

	    public float writeColspanCell(AccessibleTable table, AccessibleCell currentCell, PdfContentByte cb, PdfStructureElement parentElement, int rowIndex, float initialXPos, float initialYPos) {

	        PdfStructureElement spanElement = new PdfStructureElement(parentElement, PdfName.SPAN);

	        cb.beginMarkedContentSequence(spanElement);

	        if (currentCell.getAlternativeText() == null) {
	            initialYPos = table.writeSelectedRows(rowIndex, rowIndex + 1, initialXPos, initialYPos, cb);

	        } else {
	            PdfDictionary dict = new PdfDictionary();
	            dict.put(PdfName.ALT, new PdfString(currentCell.getAlternativeText()));
	            cb.beginMarkedContentSequence(PdfName.SPAN, dict, true);

	            initialYPos = table.writeSelectedRows(rowIndex, rowIndex + 1, initialXPos, initialYPos, cb);

	            cb.endMarkedContentSequence();

	        }

	        cb.endMarkedContentSequence();

	        return initialYPos;
	    }

	    public float writeNote(PdfContentByte cb, PdfStructureElement parentElement, float initialYPos) {
	        if (note == null || note.trim().isEmpty()) {
	            return initialYPos;
	        }

	        final float upperLeftX = pageSize.getLeft() + documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY);

	        PdfStructureElement noteElement = new PdfStructureElement(parentElement, PdfName.NOTE);
	        PdfStructureElement spanElement = new PdfStructureElement(noteElement, PdfName.SPAN);

	        PdfPTable table = new PdfPTable(new float[]{1});
	        table.setTotalWidth(pageSize.getWidth() - documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY) - documentMargins.get(ReportITextConstants.RIGHT_MARGIN_KEY));
	        table.getDefaultCell().setBorder(0);
	        table.addCell(new Phrase(note, ReportITextConstants.BIG_BOLD_BLACK));

	        cb.beginMarkedContentSequence(spanElement);
	        float yPos = table.writeSelectedRows(0, 1, 0, 1, upperLeftX, initialYPos, cb);
	        cb.endMarkedContentSequence();
	        return yPos;
	    }

		@Override
		public void generateTable(ITextReportDTO dto) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public float writeTable(Document document, PdfContentByte cb, PdfStructureElement parentElement,
				float initialYPos) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float duplicateDocumentHeaderAndTableHeader(AccessibleTable table, PdfContentByte cb) {
			// TODO Auto-generated method stub
			return 0;
		}

	/*	@Override
		public void generateTable(ITextReportTagliatellaDTO dto)
				throws BadElementException, MalformedURLException, IOException {
			// TODO Auto-generated method stub
			
		}*/

	
}
