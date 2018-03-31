package it.mef.bilancio.demdec.web.spring.report.business.itext;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
//import it.consip.fgen.core.report.business.itext.dto.ITextReportDTO;
//import it.consip.fgen.core.report.business.itext.factory.CellFactory;
//import it.consip.fgen.core.report.business.itext.util.ReportITextConstants;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public class AccessibleDocumentType01 extends AccessibleDocument{

	private float heightSixthColumnOfFirstHeaderRow;
    private float heightSecondHeaderRow;
    
    private String pathImage;
   
  

    /*
    AccessibleDocumentType05 -> utilizzato in tutti i casi in cui la 6a colonna della prima riga intestazione ha colspan 4

    esempi:
    * tavola 42
    documento a tabella unica (10 colonne) ma con intestazione con colspan e rowspan come riprodotto sotto

    | 0 | 1 | 2 | 3 | 4 | ______5______ | 6 |
    | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
     */
    //@Override
    //@SuppressWarnings("null")
	public void generateTable(ITextReportDTO dto) /*throws BadElementException, MalformedURLException, IOException*/ {
    	/*
        if (dto.getResultSet() == null || dto.getResultSet().isEmpty()) {
            return;
        }*/
    	
    	ITextReportTagliatellaDTO dtoTaglia = (ITextReportTagliatellaDTO)dto;
		
    	
    	float[] col = {100};
        AccessibleTable table = new AccessibleTable(col);//relativeColumnWidths
        table.setTotalWidth(pageSize.getWidth() - documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY) - documentMargins.get(ReportITextConstants.RIGHT_MARGIN_KEY));
        table.setHeaderRows(2);
       // table.set

        /*
        cominciamo dalla generazione dell'intestazione
        prima riga intestazione
         */
       // List<Map<String, Object>> resultSet = dto.getResultSet();
        Map<String, Object> record = null;
        pathImage = dtoTaglia.getPathImage();
        		
        		//getPathImages();
        
	   /*     if(pathImages.contains("%20"))
	        {
	        	pathImages = pathImages.replace("%20", " ");
	        }
	        
	           String path = pathImages+"logo_RGS.jpg";
	     */
	           
	           Image logo = null;
			try {
				logo = Image.getInstance(pathImage);//path
			} catch (BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	 	    logo.scalePercent(80);
	 	 	    
	 	
      //  Phrase titolo = new Phrase("Ispettorato Generale del Bilancio");
      //  Phrase ufficio = new Phrase(dtoTaglia.getFascicolo().getUfficioCapofila().getDescUfficio());
        String titolo = "Ispettorato Generale del Bilancio";
	 	String ufficio = dtoTaglia.getFascicolo().getUfficioCapofila().getDescUfficio();
	 /*	 	    
        record.put("Logo Rgs", logo);
        record.put("Ispettorato Generale del Bilancio", "Ispettorato Generale del Bilancio");       
        record.put("Descrizione Ufficio", ufficio);
	 */ 	   
        		//resultSet.get(0);
      //  int columnIndex;
   /*     AccessibleCell cell = null;
        cell = CellFactory.getCell(ReportITextConstants.HEADER_01, logo, true);
        cell.setAlternativeText(path);
     */   
        
        
        //.addElement(logo);
          //  cell.setMinimumHeight(minHeightHeaderCell);
            
         
            AccessibleCell cell1 = null;
            cell1 = CellFactory.getCell(ReportITextConstants.HEADER_01.toString(), titolo, true);
            cell1.setAlternativeText(titolo.toString());

            
            AccessibleCell cell2 = null;
            cell2= CellFactory.getCell(ReportITextConstants.COMMON_01.toString(), ufficio, true);
            cell2.setAlternativeText(ufficio.toString());
         //   table.addCell(cell);
            table.addCell(cell1);
            table.addCell(cell2);
            
    //    }
        
     //   heightSixthColumnOfFirstHeaderRow = Math.max(table.getRow(0).getCells()[5].getHeight(), minHeightHeaderCell);
        
        tables.add(table);
        
        
        float[] colTab1 = {50,50};
        AccessibleTable table1 = new AccessibleTable(colTab1);//relativeColumnWidths
        table.setTotalWidth(pageSize.getWidth() - documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY) - documentMargins.get(ReportITextConstants.RIGHT_MARGIN_KEY));
        table.setHeaderRows(2);
        
        
        
        AccessibleCell cell1Tab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, "LEGGE", false);
        AccessibleCell cell1BisTab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, dtoTaglia.getTestoLegge(), false);
        
        
        
        String testoDescProvv = "";
     	
     	if(!dtoTaglia.getFascicolo().getDescDecreto().equals(dtoTaglia.getForm().getDescDecreto()))
     	{
     		testoDescProvv = dtoTaglia.getForm().getDescDecreto();
     	}
     	else
     	{
     		testoDescProvv = dtoTaglia.getFascicolo().getDescDecreto();
     	}
     	
     	AccessibleCell cell2Tab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, "DESCRIZIONE PROVVEDIMENTO", false);
        AccessibleCell cell2BisTab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, testoDescProvv, false);
        
        
        
        String testoDescMinistero = "";// = fascicolo.getAnagAmminDemList().get(0).getDescAmm();
     	
     	
     	for (int i=0; i<dtoTaglia.getFascicolo().getAnagAmminDemList().size(); i++) {
     		
     		if(i > 0)
     		{
     			testoDescMinistero = testoDescMinistero + ", ";
     			
     		}
     		
     		testoDescMinistero = dtoTaglia.getFascicolo().getAnagAmminDemList().get(i).getDescAmm();
     	}
        
        AccessibleCell cell3Tab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, "MINISTERO/I", false);
        AccessibleCell cell3BisTab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, testoDescMinistero, false);
        
        
        String testoImpPrelFondo = "ancora non si sa quale prendere";
        
        AccessibleCell cell4Tab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, "IMPORTO PRELEVATO DA FONDO", false);
        AccessibleCell cell4BisTab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, testoImpPrelFondo, false);
        
        
     	String descTipo = "";
     	
     	if(dtoTaglia.getForm().getTipologiaDecreto().equals("Altro"))
     	{
     		descTipo = dtoTaglia.getForm().getAltraTipologiaDecreto();
     	}
     	else
     	{
     		descTipo = dtoTaglia.getForm().getTipologiaDecreto();
     	}
        
        AccessibleCell cell5Tab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, "TIPO", false);
        AccessibleCell cell5BisTab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, descTipo, false);
        
        
        String descImpInd = "";
     	
     	if(dtoTaglia.getForm().getImpattoIndebitamento().equals("1"))
     	{
     		descImpInd = "Si";	
     	}
     	else
     	{
     		descImpInd = "No";
     	}
        
        AccessibleCell cell6Tab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, "IMPATTO SU INDEBITAMENTO P.A.GIA' DEFINITO", false);
        AccessibleCell cell6BisTab1 = CellFactory.getCell(ReportITextConstants.ROW_TYPE_KEY, descImpInd, false);
        
        
        
        table1.addCell(cell1Tab1);
        table1.addCell(cell1BisTab1);
        table1.addCell(cell2Tab1);
        table1.addCell(cell2BisTab1);
        table1.addCell(cell3Tab1);
        table1.addCell(cell3BisTab1);
        table1.addCell(cell4Tab1);
        table1.addCell(cell4BisTab1);
        table1.addCell(cell5Tab1);
        table1.addCell(cell5BisTab1);
        table1.addCell(cell6Tab1);
        table1.addCell(cell6BisTab1);
        
        tables.add(table1);
        
     /*   
        float[] colTab2 = {50,50};
        AccessibleTable table2 = new AccessibleTable(colTab2);//relativeColumnWidths
        table.setTotalWidth(pageSize.getWidth() - documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY) - documentMargins.get(ReportITextConstants.RIGHT_MARGIN_KEY));
        table.setHeaderRows(2);
      */  
        
        

    }


    public float writeTable(Document document, PdfContentByte cb, PdfStructureElement parentElement, float initialYPos) {

        float yPos = initialYPos;
        
        AccessibleTable table0 = tables.get(0);
        
        PdfStructureElement tableElement = new PdfStructureElement(parentElement, PdfName.TABLE);
        PdfStructureElement theadElement = new PdfStructureElement(tableElement, PdfName.THEAD);
        PdfStructureElement tbodyElement = new PdfStructureElement(tableElement, PdfName.TBODY);
        PdfStructureElement trElement = new PdfStructureElement(theadElement, PdfName.TABLEROW);
        
        int rowIndex = 0;
        int columnIndex = 0;

        float xPos = pageSize.getLeft() + documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY);
        
        yPos =  writeCell(table0, cb, new PdfStructureElement(trElement, PdfName.TH), 0, 0, xPos, yPos);
        xPos += table0.getAbsoluteWidths()[columnIndex];
        

    /* yPos =   writeCell(table0, cb, new PdfStructureElement(trElement, PdfName.TH), 1, 0, xPos, yPos);
        xPos += table0.getAbsoluteWidths()[columnIndex];
     */
        
        yPos = writeRow(table0, cb, new PdfStructureElement(tbodyElement, PdfName.TABLEROW), false, 1, yPos);
        
        
    //    writeCell(table0, cb, new PdfStructureElement(trElement, PdfName.TH), 2, 0, xPos, yPos);
      //  xPos += table0.getAbsoluteWidths()[columnIndex];
       
        return yPos;
    }
    
    
    
    

    public float duplicateDocumentHeaderAndTableHeader(AccessibleTable table, PdfContentByte cb) {
        float initialYPos = pageSize.getTop() - documentMargins.get(ReportITextConstants.TOP_MARGIN_KEY);
        float xPos = pageSize.getLeft() + documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY);
        int rowIndex = 0;
        /*
       header documento
        */
        PdfPTable headerTable = new PdfPTable(new float[]{1});
        headerTable.setTotalWidth(pageSize.getWidth() - documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY) - documentMargins.get(ReportITextConstants.RIGHT_MARGIN_KEY));
        headerTable.getDefaultCell().setBorder(0);
        Phrase header = new Phrase(title + " - " + headerFirstPart, ReportITextConstants.BIG_BOLD_BLACK);
        header.add(new Phrase(ReportITextConstants.HEADER_BREAK + headerSecondPart, ReportITextConstants.BIG_NORMAL_BLACK));
        headerTable.addCell(header);

        float yPos = headerTable.writeSelectedRows(rowIndex, rowIndex + 1, xPos, initialYPos, cb) - 15f;

        /*
       prima riga
        */
        table.writeSelectedRows(rowIndex, ++rowIndex, xPos, yPos, cb);
        /*
        seconda riga
         */
        xPos = pageSize.getLeft() + documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY);
        for (int columnIndex = 0; columnIndex <= 8; columnIndex++) {
            if (columnIndex >= 5) {
                table.writeSelectedRows(columnIndex, columnIndex + 1, rowIndex, rowIndex + 1, xPos, yPos - heightSixthColumnOfFirstHeaderRow, cb);
            }
            xPos += table.getAbsoluteWidths()[columnIndex];
        }

        return yPos - heightSixthColumnOfFirstHeaderRow - heightSecondHeaderRow;
    }
	
}
