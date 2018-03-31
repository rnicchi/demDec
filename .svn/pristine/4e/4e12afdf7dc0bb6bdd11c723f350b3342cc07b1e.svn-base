package it.almavivaitalia.web.sh.export.excel;

import it.almavivaitalia.web.sh.export.Column;
import it.almavivaitalia.web.sh.export.ColumnIterator;
import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.export.HeaderCell;
import it.almavivaitalia.web.sh.export.ReportFileExport;
import it.almavivaitalia.web.sh.export.Row;
import it.almavivaitalia.web.sh.utils.Util;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.*;
import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.*;
import static it.almavivaitalia.bsn.sh.utils.ReflectionUtilLev2.*;
import static it.almavivaitalia.bsn.sh.utils.ParseUtil.*;
import static it.almavivaitalia.bsn.sh.utils.DateUtil.*;
import static it.almavivaitalia.bsn.sh.utils.ValidationUtil.*;
import static it.almavivaitalia.bsn.sh.utils.Util.*;


public class XlsReportFileExport extends XlsReportParentFileExport{

    private int keyColumnSize;
    
	private int rowIndex=0;
	private int sheetIndex=0;
	
	private HSSFSheet sheet;
    private HSSFWorkbook wb;
    private HSSFRow row;
    
	private OutputStream out;
	
	private CellStyle smallStyle;
	private CellStyle boldStyle;
	private int columnsWidth[];
	
	private static final int firstAmountsColumn=1;
	
    private LinkedHashMap<String, List<HSSFCell>> keyCells=null;
	
    @Override
	protected void startDocument(OutputStream out) throws Throwable {
        wb = new HSSFWorkbook();
        this.out=out;

        smallStyle = wb.createCellStyle();
        Font smallFont = wb.createFont();
        smallFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
        smallStyle.setFont(smallFont);
        
		boldStyle = wb.createCellStyle();
        Font boldFont = wb.createFont();
        boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        boldStyle.setFont(boldFont);
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
		
		keyCells=new LinkedHashMap<String, List<HSSFCell>>();
        keyColumnSize = getCurrentPageModel().getNumberOfKeys();
        columnsWidth=new int[getCurrentPageModel().getNumberOfColumns()];
        
		startRow();
        generateHeader();
	}

	@Override
	protected void fillPage() throws Throwable{
        generateRows();
		wb.write(out);
	} 
	
	@Override
	protected void endPage() throws Throwable {
		// TODO Auto-generated method stub
	}

	@Override
	protected void endRowDetails() throws Throwable {
		// TODO Auto-generated method stub
	}

	@Override
	protected void generateHeader() throws Throwable {
		startRow();
		StringBuffer tab=new StringBuffer("");
		for (int i=0;i<getCurrentPageModel().getNumberOfColumns();i++){
			HSSFCell cell;
			String keyDescription=StringUtils.capitalize(getCurrentPageModel().getHeaderCellList().get(i).getTitle());
			if(i<keyColumnSize){
				cell=getCell(tab.toString()+keyDescription,0,0,i); tab.append("  ");
				if (keyColumnSize!=i+1)startRow();
			}else{
				cell=getCell(keyDescription,(i-keyColumnSize)+1,0,i);
			}
			setCellWidth(cell);
		}
		startRow();
	}

	@Override
	protected void renderChildTotals(LinkedHashMap<String, Object> keyValues,
			LinkedHashMap<String, List<BigDecimal>> keySums) throws Throwable {
		Set<Entry<String, Object>> entries = keyValues.entrySet();
		int j=0;
		for (Entry<String, Object> entry : entries){
			if (keyColumnSize>=j){
				List<HSSFCell> prevCells = keyCells.get(entry.getKey());
				List<BigDecimal> prevSums = keySums.get(entry.getKey());
				if (prevCells!=null&&prevSums!=null){
					for (int k=0; k<prevCells.size(); k++){
						HSSFCell cell = (HSSFCell) prevCells.get(k);
						FieldFormatter formatter =getCurrentPageModel().getHeaderCellList().get(0).getFieldFormatter();
						cell.setCellValue(getNumberFormat(prevSums.get(k),formatter.getDecimals()));
						if (k==0)setCellWidth(cell);
					}
				}
			}
			j++;
		}
	}

	@Override
	protected void renderKeyHeader(Object value,
			LinkedHashMap<String, Object> keyValues,
			LinkedHashMap<String, List<BigDecimal>> keySums, int level,
			HeaderCell current, int colspan) throws Throwable {
		
		startRow();
		StringBuffer tab=new StringBuffer("");
		for (int i=0;i<level;i++) tab.append("  ");
		HSSFCell keyDescriptionCell=getCell(tab.toString()+Util.blank(value),0,0,level);
		setCellWidth(keyDescriptionCell);

		List<HSSFCell> newCells = new ArrayList<HSSFCell>();
		int columnSize = getCurrentPageModel().getNumberOfColumns();
        if (level<keyColumnSize-1){
	        for(int i=0; i<(columnSize-keyColumnSize);i++){
				FieldFormatter formatter = getCurrentPageModel().getHeaderCellList().get(i).getFieldFormatter();
				HSSFCell cell = getCell("0",(firstAmountsColumn)+i,formatter.getType(),level); 
	        	newCells.add(cell);
			}
        }
        keyCells.put(current.getBeanPropertyName(), newCells);
		
	}
	
    private HSSFCell getCell(String value, int index, int type, int level) throws Throwable {
    	
        HSSFCell cell=row.createCell((short)index+1);	
        
        // Tipo 1 è importo
        if (type==1){
        	HSSFDataFormat format = wb.createDataFormat();
            short dateFormatCode = format.getFormat("#,##0.00");
            HSSFCellStyle dateCellStyle = wb.createCellStyle();
            dateCellStyle.setDataFormat(dateFormatCode);
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC); 
            cell.setCellStyle(dateCellStyle);  
            Double d = Double.parseDouble(value);
            cell.setCellStyle(getStyle(level));
        	cell.setCellValue(d.doubleValue());
        } else {
        	cell.setCellStyle(getStyle(level));
        	cell.setCellValue(value);
        }
    	
        return cell;
    }

    private void setCellWidth(HSSFCell cell){
    	String value=cell.getStringCellValue();
    	int index=cell.getColumnIndex();
    	if (value.length()>columnsWidth[index]){
			sheet.autoSizeColumn((short)index);
			columnsWidth[index]=value.length();
		}	
    }
    
    
	private CellStyle getStyle(int level){
		CellStyle cellStyle=null;
		switch(level){
			case -1:
				cellStyle=smallStyle;
				break;
			case 0:
				cellStyle=boldStyle;
				break;
			case 1:
				cellStyle=boldStyle;
				break;
			case 2:
				cellStyle=smallStyle;
				break;
			default:
				cellStyle=smallStyle;
				break;
		}
		return cellStyle;
	}
	
	@Override
	public String getMimeType() {
		return "application/vnd.ms-excel";
	}
	
	protected void startRow() throws Throwable {
 	    row = (HSSFRow)sheet.createRow((short)rowIndex);
 	    rowIndex++;
	}
	
	@Override
	protected void renderRowDetails(Row row, LinkedHashMap<String, List<BigDecimal>> keySums) throws Throwable {

        ColumnIterator columnIterator = row.getColumnIterator();
		int columnSize = getCurrentPageModel().getNumberOfColumns();
        for(int i=0;i<(columnSize-keyColumnSize);i++){	        	
    		Column column = columnIterator.get(i+keyColumnSize);
            BigDecimal value = (BigDecimal)column.getValue();
            if (value==null)value=new BigDecimal(0);
            FieldFormatter formatter = getCurrentPageModel().getHeaderCellList().get(i).getFieldFormatter();
            String valueAsString = getNumberFormat((Number)value,formatter.getDecimals());
	            for(int j=0; j<keyColumnSize-1; j++){
	            	HeaderCell current = getCurrentPageModel().getHeaderCellList().get(j);
	            	List<BigDecimal> sums = keySums.get(current.getBeanPropertyName());
	            	sums.set(i, sums.get(i).add(value));
	            }
            getCell(valueAsString,(firstAmountsColumn)+i,formatter.getType(),-1);
        }
		
	}

	

}
