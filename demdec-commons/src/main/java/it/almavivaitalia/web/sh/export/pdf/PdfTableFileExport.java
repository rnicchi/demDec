

package it.almavivaitalia.web.sh.export.pdf;
 
import static it.almavivaitalia.bsn.sh.utils.ParseUtil.getNumberFormat;
import it.almavivaitalia.web.sh.export.Column;
import it.almavivaitalia.web.sh.export.ColumnIterator;
import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.export.HeaderCell;
import it.almavivaitalia.web.sh.export.Row;
import it.almavivaitalia.web.sh.export.RowIterator;
import it.almavivaitalia.web.sh.export.TableFileExport;

import java.awt.Color;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
 
 
 
 public class PdfTableFileExport extends TableFileExport {
 
 
     private Table tablePDF;
     private Document document;
     private Font smallFont;
     @SuppressWarnings("unused")
	private OutputStream out;
     
     /*LOCM*/
 	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
 	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
 	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
 	/*END LOCM*/
     
 
     public void startDocument(OutputStream out) throws Throwable {
         this.out = out;
    	 document = new Document(PageSize.A4.rotate(), 60, 60, 40, 40);
    	 
         document.addCreationDate();
         smallFont = FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, new Color(0, 0, 0));
         PdfWriter.getInstance(document, out);
        
     }
     public void startPage() throws Throwable {
    	 if (!document.isOpen()){
    		 document.open();
    	 }
    	 
    	 tablePDF = new Table(getCurrentPageModel().getNumberOfColumns());
//         tablePDF.setDefaultVerticalAlignment(Element.ALIGN_TOP);
         tablePDF.setCellsFitPage(true);
         tablePDF.setWidth(110);
         tablePDF.setPadding(2);
         tablePDF.setSpacing(0);
         
         FieldFormatter formatter; 
         float ampiezzaColonne[]=new float[getCurrentPageModel().getNumberOfColumns()];
         boolean existsWidthForAllColumns = true;
         for (int i=0;i<getCurrentPageModel().getNumberOfColumns();i++){
        	 formatter = getCurrentPageModel().getHeaderCellList().get(i).getFieldFormatter();
             if (formatter.getWidth()!=null){
            	 ampiezzaColonne[i] = formatter.getWidth().floatValue();
             }else {
            	 existsWidthForAllColumns=false;
            	 break;
             }
         }
         if (existsWidthForAllColumns){
        	 tablePDF.setWidths(ampiezzaColonne);
         }
        
         HeaderFooter footer = new HeaderFooter(new Phrase(getCurrentPageModel().getFooter()+" ", smallFont), true);
         footer.setBorder(Rectangle.NO_BORDER);
         footer.setAlignment(Element.ALIGN_CENTER);

         document.setFooter(footer);
     }
     public String getMimeType() {
         return "application/pdf";
     }
 
     @Override
     protected void fillPage() throws Throwable {
    	 /*
    	 HeaderFooter header = new HeaderFooter(new Phrase(getCurrentPageModel().getHeader()+" - ", smallFont), true);
    	 header.setBorder(Rectangle.NO_BORDER);
    	 header.setAlignment(Element.ALIGN_CENTER); 
    	 document.setHeader(header);
    	 */
    	 // PdfWriter.getInstance(document, out);
    	 
             generateHeaders();
         
         tablePDF.endHeaders();
         generateRows();
//         document.open();
         document.add(this.tablePDF);    
     }
 
     
     protected void endDocument(){
         document.close();
     }
     
 
 
     @Override
     protected void generateHeaders() throws Throwable {
    	 Cell titleCell = getTitleCell(getCurrentPageModel().getHeader());
    	 titleCell.setGrayFill(0.9f);
    	 titleCell.setHeader(true);
    	 
    	 tablePDF.addCell(titleCell);
    	 Iterator<HeaderCell> iterator = getCurrentPageModel().getHeaderCellList().iterator();
    	 while (iterator.hasNext()) {
             HeaderCell headerCell = (HeaderCell) iterator.next();
             String columnHeader = headerCell.getTitle();
             if (columnHeader == null) {
                 columnHeader = StringUtils.capitalize(headerCell.getBeanPropertyName());
             }
             Cell hdrCell = getCell(columnHeader);
             hdrCell.setGrayFill(0.9f);
             hdrCell.setHeader(true);
             tablePDF.addCell(hdrCell);
         }
     }
 
     @Override
     protected void generateRows() throws Throwable {
         // get the correct iterator (full or partial list according to the exportFull field)
         RowIterator rowIterator = getCurrentPageModel().getRowIterator();
         // iterator on rows
         while (rowIterator.hasNext()) {
             Row row = rowIterator.next();
             // iterator on columns
             ColumnIterator columnIterator = row.getColumnIterator();
             int i=0;
             while (columnIterator.hasNext()) {
                 Column column = columnIterator.nextColumn();
                 Object value = column.getValue();
                 FieldFormatter formatter =getCurrentPageModel().getHeaderCellList().get(i).getFieldFormatter(); 
                 
                 int type = formatter.getType();                 
                 
                 if ((value instanceof Number) && (type==FieldFormatter.TYPE_IMPORTO)){
                	 
                	 value = getNumberFormat((Number)value);
                 }
                 
                 Cell cell = getCell(ObjectUtils.toString(value));
                 
                 if ((type==FieldFormatter.TYPE_IMPORTO)||(type==FieldFormatter.TYPE_PERC)){
                	 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                 }
                 else if (type==FieldFormatter.TYPE_TESTO){
                	 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                 }else {                	 
                	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                 }        
                 tablePDF.addCell(cell);
                 i++;
             }
         }
     }
 
     private Cell getCell(String value) throws BadElementException {
         Cell cell = new Cell(new Chunk(StringUtils.trimToEmpty(value), smallFont));
         cell.setVerticalAlignment(Element.ALIGN_TOP);
         cell.setLeading(8);
         return cell;
     }
 
     private Cell getTitleCell(String value) throws BadElementException {
         Cell cell = new Cell(new Chunk(StringUtils.trimToEmpty(value), smallFont));
         cell.setVerticalAlignment(Element.ALIGN_TOP);
         cell.setLeading(8);
         cell.setColspan(getCurrentPageModel().getNumberOfColumns());
         return cell;
     }

 
 
 	public static void main(String[] args){
 		try {
 			
/* 			
 			TableModel tableModel=new TableModel(list);
 			
 			
 			PdfView pdfView = new PdfView();
 			
 			pdfView.setParameters(tableModel, true, true, false);
 			
 			pdfView.doExport(new FileOutputStream("C:\\provaPdfExportNSSB.pdf"));
 */			
 			
 		}catch (Throwable e) {
 			e.printStackTrace();
		}
 		
 	}
	@Override
	protected void endPage() throws Throwable {
		document.newPage();
	}

 
 
 
 
 }


