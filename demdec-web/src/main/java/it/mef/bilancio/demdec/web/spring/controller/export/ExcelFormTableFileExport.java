package it.mef.bilancio.demdec.web.spring.controller.export;

import it.almavivaitalia.web.sh.export.Column;
import it.almavivaitalia.web.sh.export.ColumnIterator;
import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.export.HeaderCell;
import it.almavivaitalia.web.sh.export.Row;
import it.almavivaitalia.web.sh.export.RowIterator;
import it.almavivaitalia.web.sh.export.TableFileExport;

import java.io.OutputStream;
import java.util.Iterator;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.*;
import static it.almavivaitalia.bsn.sh.utils.ParseUtil.*;

public class ExcelFormTableFileExport extends TableFileExport {
	 private int rowIndex=0;
	 private int sheetIndex=0;
	 private Sheet sheet;
	 private CreationHelper createHelper;
    private Workbook wb;
    private OutputStream out;
    
    /* LOCM */
    @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM4 = 80L;
    @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM2 = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM3 = 80L;
    /* end LOCM */

    @Override
    protected void startDocument(OutputStream out) throws Throwable {
        wb = new HSSFWorkbook();
        this.out=out;
        createHelper = wb.getCreationHelper();                             
    }


    @Override
    protected void fillPage() throws Throwable {
        
        generateHeaders();
        generateRows();
        
        wb.write(out);
    }

    @Override
    protected void generateHeaders() throws Throwable {
        org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowIndex++);
        int columnIndex=0;
        String columnHeader = getCurrentPageModel().getHeader();
        Cell cell = row.createCell(columnIndex++);
        cell.setCellValue(createHelper.createRichTextString(columnHeader));

        Iterator<HeaderCell> iterator = getCurrentPageModel().getHeaderCellList().iterator();
        row = sheet.createRow(rowIndex++);
        columnIndex=0;
        while (iterator.hasNext()) {
            HeaderCell headerCell = (HeaderCell) iterator.next();
            columnHeader = headerCell.getTitle();
            if (columnHeader == null){
                columnHeader = StringUtils.capitalize(headerCell.getBeanPropertyName());
            }
            cell = row.createCell(columnIndex++);
            cell.setCellValue(createHelper.createRichTextString(columnHeader));
        }
    }

    @Override
    protected void generateRows() throws Throwable{
        RowIterator rowIterator = getCurrentPageModel().getRowIterator();
        HSSFDataFormat format = (HSSFDataFormat) wb.createDataFormat();
        short dateFormatCode = format.getFormat("#,##0.00");
        HSSFCellStyle dateCellStyle = (HSSFCellStyle) wb.createCellStyle();
        dateCellStyle.setDataFormat(dateFormatCode);
        // iterator on rows
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            org.apache.poi.ss.usermodel.Row xlsRow = sheet.createRow(rowIndex++);
            ColumnIterator columnIterator = row.getColumnIterator();
            int columnIndex=0;
            while (columnIterator.hasNext()){
           	 
                FieldFormatter formatter =getCurrentPageModel().getHeaderCellList().get(columnIndex).getFieldFormatter(); 
                
                Column column = columnIterator.nextColumn();
                Object value = column.getValue();
                Cell cell = xlsRow.createCell(columnIndex++);
                
                int type = formatter.getType();     

                if (value!=null){
	                 if ((type==FieldFormatter.TYPE_OBJECT)||(type==FieldFormatter.TYPE_TESTO)){
	                	 cell.setCellValue(createHelper.createRichTextString(ObjectUtils.toString(value)));  
	                 }else{ 
	                     if (type==FieldFormatter.TYPE_IMPORTO){
                   	 	cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC); 
                           cell.setCellStyle(dateCellStyle);  
                           cell.setCellValue(Double.valueOf(String.valueOf(value)));
	                     } else {
			                cell.setCellType(Cell.CELL_TYPE_BLANK);
			                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			                cell.setCellValue(getDouble(getString(value)));
	                     }
	                 }
                }else{
	                 cell.setCellType(Cell.CELL_TYPE_BLANK);
	                 cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                 cell.setCellValue(0);
                }
            }
        }
    }

  

  



	public static void main(String[] args){
		try {
			

			
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
	}


	@Override
	protected void endDocument() throws Throwable {
		
	}


	@Override
	public String getMimeType() {
		return "application/vnd.ms-excel";
	}


	@Override
	protected void endPage() throws Throwable {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void startPage() throws Throwable {
       String name = getCurrentPageModel().getHeader();
		if (sheet!=null){
       	if (sheet.getSheetName().equals(name)){
       		name=sheet.getSheetName()+" #"+sheetIndex;
       	}
       }
		if ((name==null)||name.trim().equals("")){
			name="sheet 1";
		}
		sheet = wb.createSheet(name);
		sheetIndex++;
	}





}


