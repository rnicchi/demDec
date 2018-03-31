package it.almavivaitalia.web.sh.export.pdf;

import static it.almavivaitalia.bsn.sh.utils.ParseUtil.getNumberFormat;
import it.almavivaitalia.web.sh.export.Column;
import it.almavivaitalia.web.sh.export.ColumnIterator;
import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.export.HeaderCell;
import it.almavivaitalia.web.sh.export.ReportFileExport;
import it.almavivaitalia.web.sh.export.Row;
import it.almavivaitalia.web.sh.utils.Util;

import java.awt.Color;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReportFileExport  extends PdfReportParentFileExport{
    private PdfPTable tablePDF;
    private Document document;
    private Font smallFont;
    private Font boldFont;
    private Font italicFont;
    private Font italicBoldFont;
    private int keyColumnSize;
    
    /*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	/*END LOCM*/

    private List<PdfPCell> valueCells=new ArrayList<PdfPCell>();

    
    @SuppressWarnings("unused")
	private OutputStream out;
   
    private LinkedHashMap<String, List<PdfPCell>> keyPdfPCells=null ;
	@Override
	protected void startDocument(OutputStream out) throws Throwable {
        this.out = out;
      	 document = new Document(PageSize.A4.rotate(), 60, 60, 40, 40);
      	 
         document.addCreationDate();
         smallFont 		= FontFactory.getFont(FontFactory.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0));
         boldFont 		= FontFactory.getFont(FontFactory.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0));
         italicFont 	= FontFactory.getFont(FontFactory.HELVETICA, 6, Font.ITALIC, new Color(0, 0, 0));
         italicBoldFont = FontFactory.getFont(FontFactory.HELVETICA, 6, Font.BOLDITALIC, new Color(0, 0, 0));
         PdfWriter.getInstance(document, out);
         document.open();
		
	}
	
	@Override
	protected void startPage() throws Throwable {
		keyPdfPCells=new LinkedHashMap<String, List<PdfPCell>>();
        keyColumnSize = getCurrentPageModel().getNumberOfKeys();
        
		tablePDF=new PdfPTable(getCurrentPageModel().getNumberOfColumns()-(keyColumnSize-1));
		tablePDF.setWidthPercentage(110);

		HeaderFooter footer=new HeaderFooter(new Phrase(getCurrentPageModel().getFooter()+" ", smallFont), true);
		footer.setBorder(Rectangle.NO_BORDER);
		footer.setAlignment(Element.ALIGN_CENTER);
		document.setFooter(footer);
	
		FieldFormatter formatter; 
		float ampiezzaColonne[]=new float[getCurrentPageModel().getNumberOfColumns()-(keyColumnSize-1)];
		for (int i=0;i<getCurrentPageModel().getNumberOfColumns()-(keyColumnSize-1);i++){
			 formatter = getCurrentPageModel().getHeaderCellList().get(i+(keyColumnSize-1)).getFieldFormatter();
		   	 ampiezzaColonne[i]=(i==0)?31:formatter.getWidth().floatValue();
		}
		this.tablePDF.setWidths(ampiezzaColonne);
		this.tablePDF.setHeaderRows(2);
	}

	@Override
	protected void fillPage() throws Throwable {
			generateHeader();

        generateRows();
        
        for (Iterator<PdfPCell> iterator = valueCells.iterator(); iterator.hasNext();) {
        	PdfPCell cell = (PdfPCell) iterator.next();
        	this.tablePDF.addCell(cell);
		}
        valueCells.clear();
        document.add(this.tablePDF);  
	}

	protected void generateHeader() throws Throwable {
		PdfPCell titleCell = getTitleCell(getCurrentPageModel().getHeader());
		titleCell.setGrayFill(0.9f);
		titleCell.setColspan(getCurrentPageModel().getNumberOfColumns()-(keyColumnSize-1));
		this.tablePDF.addCell(titleCell);
		generateHeaders();
	}
	
	@Override
	protected void generateHeaders() throws Throwable {
		PdfPTable innerTable=new PdfPTable(1);StringBuffer tab=new StringBuffer("");
		for (int i=0;i<=keyColumnSize-1;i++){
			for (int j=0;j<=i;j++)tab.append("\t");
			PdfPCell innerCell=getCell(tab.toString()+StringUtils.capitalize(getCurrentPageModel().getHeaderCellList().get(i).getTitle()),false , getFont(i));
			innerCell.setBorder(0);
			innerTable.addCell(innerCell);
		}
		this.tablePDF.addCell(innerTable);
		
		int i=0;
		Iterator<HeaderCell> iter = getCurrentPageModel().getHeaderCellList().iterator();
		while (iter.hasNext()) {
			HeaderCell headerCell = (HeaderCell) iter.next();
			String columnHeader = headerCell.getTitle();
			if (columnHeader == null){
			    columnHeader = StringUtils.capitalize(headerCell.getBeanPropertyName());
			}
			PdfPCell hdrCell = getCell(columnHeader,true,getFont(1));
			hdrCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hdrCell.setHorizontalAlignment(Element.ALIGN_CENTER);			
			hdrCell.setGrayFill(0.9f);
			if (i>=keyColumnSize)this.tablePDF.addCell(hdrCell);
			i++;
		}
	}
	
	@Override	
	protected void renderChildTotals(LinkedHashMap<String, Object> keyValues, LinkedHashMap<String, List<BigDecimal>> keySums) throws Throwable{
		Set<Entry<String, Object>> entries = keyValues.entrySet();
		int j=0;
		for (Entry<String, Object> entry : entries){
			if (keyColumnSize>=j){
				List<PdfPCell> prevCells = keyPdfPCells.get(entry.getKey());
				List<BigDecimal> prevSums = keySums.get(entry.getKey());
				if ((prevCells!=null)&&(prevSums!=null)){
					for (int k=0; k<prevCells.size(); k++){
						PdfPCell pdfPCell = (PdfPCell) prevCells.get(k);
						FieldFormatter formatter =getCurrentPageModel().getHeaderCellList().get(0).getFieldFormatter(); 
						pdfPCell.setPhrase(new Phrase(new Chunk(getNumberFormat(prevSums.get(k),formatter.getDecimals()), getFont(j))));
						pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					}
				}		
			}
			j++;
		}
	}
	
	
	@Override
	protected void renderKeyHeader(Object value, LinkedHashMap<String, Object> keyValues, LinkedHashMap<String, List<BigDecimal>> keySums, int level, HeaderCell current, int colspan) throws Throwable {
		StringBuffer tab=new StringBuffer("");
		
		for(int i=0;i<level;i++)tab.append("\t");
		
		PdfPCell keyCell = getCell(tab.toString()+Util.blank(value),false,getFont(level));
		valueCells.add(keyCell);
		
        int columnSize = getCurrentPageModel().getNumberOfColumns();
        List<PdfPCell> newCells = new ArrayList<PdfPCell>();
        if (level<keyColumnSize-1)
	        for(int k=0; k<(columnSize-keyColumnSize);k++){
	        	PdfPCell cell = getCell("",false, getFont(level));
	        	valueCells.add(cell);
	        	newCells.add(cell);
			}
        keyPdfPCells.put(current.getBeanPropertyName(), newCells);
 
	}
	
	@Override
	protected void startRowDetails() throws Throwable {}

	@Override
	protected void renderRowDetails(Row row, LinkedHashMap<String, List<BigDecimal>> keySums) throws Throwable {
		int columnSize = getCurrentPageModel().getNumberOfColumns();
        ColumnIterator columnIterator = row.getColumnIterator();

        for(int i=0;i<columnSize-keyColumnSize;i++){	        	
    		Column column = columnIterator.get(i+keyColumnSize);
            BigDecimal value = (BigDecimal)column.getValue();
            if (value==null)value=new BigDecimal(0);
            FieldFormatter formatter =getCurrentPageModel().getHeaderCellList().get(i).getFieldFormatter();
            String valueAsString = getNumberFormat((Number)value,formatter.getDecimals());
            
            for(int j=0; j<keyColumnSize-1; j++){
            	HeaderCell current = getCurrentPageModel().getHeaderCellList().get(j);
            	List<BigDecimal> sums = keySums.get(current.getBeanPropertyName());
            	sums.set(i, sums.get(i).add(value));
            }
            
            PdfPCell cell=getCell(valueAsString,true,getFont(-1));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
           	valueCells.add(cell);
        }
	}
	
	@Override
	protected void endRowDetails() throws Throwable {}
	
	private Font getFont(int level){
		Font font=null;
		switch(level){
			case -1:
				font=smallFont;
				break;
			case 0:
				font=italicBoldFont;
				break;
			case 1:
				font=boldFont;
				break;
			case 2:
				font=italicFont;
				break;
			default:
				font=smallFont;
				break;
		}
		return font;
	}
	
    private PdfPCell getTitleCell(String value) throws Throwable {
    	Phrase p=new Phrase(new Chunk(StringUtils.trimToEmpty(value), smallFont));
    	PdfPCell cell = new PdfPCell(p);
        cell.setVerticalAlignment(Element.ALIGN_TOP);
        cell.setColspan(getCurrentPageModel().getNumberOfColumns()-(keyColumnSize-1));
        return cell;
    }

   

	@Override
	protected void endDocument() throws Throwable {
        document.close();
	}
	
	@Override
	protected void endPage() throws Throwable {
		document.newPage();
	}

}
