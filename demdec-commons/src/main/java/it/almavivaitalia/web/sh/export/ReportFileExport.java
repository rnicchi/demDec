package it.almavivaitalia.web.sh.export;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public abstract class ReportFileExport extends TableFileExport{
	
	@Override
	protected void endDocument() throws Throwable {
		// TODO Auto-generated method stub
	}
	
	protected abstract void renderKeyHeader(Object value, LinkedHashMap<String, Object> keyValues, LinkedHashMap<String, List<BigDecimal>> keySums, int level, HeaderCell current, int colspan) throws Throwable ;
	protected abstract void renderRowDetails(Row row, LinkedHashMap<String, List<BigDecimal>> keySums) throws Throwable;
	protected abstract void startRowDetails() throws Throwable;
	protected abstract void endRowDetails() throws Throwable;
	protected abstract void endPage() throws Throwable;
	protected abstract void fillPage() throws Throwable;
	protected abstract void renderChildTotals(LinkedHashMap<String, Object> keyValues, LinkedHashMap<String, List<BigDecimal>> keySums) throws Throwable;
	protected abstract void generateHeader() throws Throwable;

	private void deleteChildKey(LinkedHashMap<String, Object> keyValues, LinkedHashMap<String, List<BigDecimal>> keySums, int i) throws Throwable{			
		int j=0; List<String> list=new ArrayList<String>();
		for (Entry<String, Object> entry : keyValues.entrySet()){
			if (j>i)list.add(entry.getKey());
			j++;
		}
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String key = iterator.next();
			keyValues.remove(key);
			keySums.remove(key);
		}
	}
	
	@Override
	protected void generateRows() throws Throwable {
        // get the correct iterator (full or partial list according to the exportFull field)
        RowIterator rowIterator = getCurrentPageModel().getRowIterator();
        LinkedHashMap<String, Object> keyValues=new LinkedHashMap<String, Object>();
        LinkedHashMap<String, List<BigDecimal>> keySums=new LinkedHashMap<String, List<BigDecimal>>();
        boolean isNewDetails=true;
        int columnSize=getCurrentPageModel().getNumberOfColumns();
        int keyColumnSize=getCurrentPageModel().getNumberOfKeys();
        int rowNum=0;
        // iterator on rows
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // iterator on columns
            ColumnIterator columnIterator = row.getColumnIterator();
            
            int i=0;
            while (columnIterator.hasNext()) {
                Column column = columnIterator.nextColumn();
                Object value = column.getValue();
                Object descValue = column.getDescValue();
                HeaderCell current = getCurrentPageModel().getHeaderCellList().get(i);
                
                if (current.isKey()){
                	Object prevValue = keyValues.get(current.getBeanPropertyName());  
                	if ((prevValue==null)||!prevValue.equals(value)){
                		
                		renderChildTotals(keyValues, keySums);
                		renderKeyHeader(descValue, keyValues, keySums, i, current, columnSize);
                		
                		keyValues.put(current.getBeanPropertyName(), value);
                		
                		List<BigDecimal> sums = new ArrayList<BigDecimal>();
                		if (i<(keyColumnSize-1)){
	                		for(int k=0; k<(columnSize-keyColumnSize);k++){
	                			sums.add(new BigDecimal(0));
	                		}
	                		keySums.put(current.getBeanPropertyName(), sums);
	                		deleteChildKey(keyValues, keySums, i);
	                		isNewDetails=true;
                		}
                	}
                	i++;
                }else {
                	break;
                }
            }
            if (isNewDetails){
            	if (rowNum>0){
            		endRowDetails();
            	}
            	startRowDetails();
            	isNewDetails=false;
            }
            renderRowDetails(row, keySums);
            rowNum++;
        }
        endRowDetails();
        renderChildTotals(keyValues, keySums);    
	}
}
