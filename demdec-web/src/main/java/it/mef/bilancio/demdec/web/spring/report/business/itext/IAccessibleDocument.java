package it.mef.bilancio.demdec.web.spring.report.business.itext;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStructureElement;
//import it.consip.fgen.core.report.business.itext.dto.*;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public interface IAccessibleDocument {


    void generateTable(ITextReportDTO dto);
    float writeHeader(PdfContentByte cb, PdfStructureElement parentElement);
    float writeTable(Document document, PdfContentByte cb, PdfStructureElement parentElement, float initialYPos);
    float duplicateDocumentHeaderAndTableHeader(AccessibleTable table, PdfContentByte cb);
    float writeRow(AccessibleTable table, PdfContentByte cb, PdfStructureElement parentElement, boolean isHeader, int rowIndex, float initialYPos);
    float writeCell(AccessibleTable table, PdfContentByte cb, PdfStructureElement parentElement, int rowIndex, int columnIndex, float initialXPos, float initialYPos);
    float writeColspanCell(AccessibleTable table, AccessibleCell currentCell, PdfContentByte cb, PdfStructureElement parentElement, int rowIndex, float initialXPos, float initialYPos);
    float writeNote(PdfContentByte cb, PdfStructureElement parentElement, float initialYPos);
	/*void generateTable(ITextReportTagliatellaDTO dto) throws BadElementException, MalformedURLException, IOException;*/
	
}
