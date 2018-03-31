package it.almavivaitalia.web.sh.export;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.getPropertyValue;
import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.web.sh.utils.PropertyKey;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;




public class TableModel {

	private ResourceBundleMessageSource messageSource;
	
	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	private String header;
	private String footer;

	private String[] headerParams;
	private String[] footerParams;
	
	private String headerKey;
	private String footerKey;
	
	private List<HeaderCell> headerCellList;
	private List<?> list;
	private LinkedHashMap<PropertyKey, FieldFormatter> propertyMap;
	
	private RowIterator rowIterator;

	private int numberOfKeys;
	
	public int getNumberOfColumns(){
		return propertyMap.size();
	}


	public void addHeaderCell(HeaderCell hc){
		headerCellList.add(hc);
	}

	public List<HeaderCell> getHeaderCellList(){
		return headerCellList;
	}

	
	 public String getHeader() {
		return header;
	}

	
	public String getFooter() {
		return footer;
	}

	

	public TableModel(List<?> list, LinkedHashMap<PropertyKey, FieldFormatter> propertyMap) throws Throwable{
		super();
		this.list=list;
		this.propertyMap=propertyMap;
		
	}
	public TableModel(List<?> list, LinkedHashMap<PropertyKey, FieldFormatter> propertyMap, String headerKey, String footerKey) throws Throwable{
		super();
		this.list=list;
		this.headerKey=headerKey;
		this.footerKey=footerKey;
		this.propertyMap=propertyMap;
		
	}
	
	public TableModel(List<?> list,
			LinkedHashMap<PropertyKey, FieldFormatter> propertyMap,
			String headerKey, String[] headerParams, String footerKey,
			String[] footerParams) {
		super();
		
		this.list=list;
		this.headerKey=headerKey;
		this.headerParams=headerParams;
		this.footerKey=footerKey;
		this.footerParams=footerParams;
		this.propertyMap=propertyMap;
		
	}


	public void init() throws Throwable{
		if ((list!=null)&&(!list.isEmpty())){
			initRowIterator();
			initHeaderCellList();
//			initHeaderFooter();
			
			if(headerParams!=null){
				header=messageSource.getMessage(headerKey, headerParams);
			}else{
				header=messageSource.getMessage(headerKey);
			}
			
			if(footerParams!=null){
				footer=messageSource.getMessage(footerKey, footerParams);
			}else{
				footer=messageSource.getMessage(footerKey);
			}
			
//			initHeaderFooter end 
		}
	}
	
	private void initRowIterator() throws Throwable{
		
			List<Row> rows = new ArrayList<Row>();
			for (Object el : list) {
				List<Column> columns = new ArrayList<Column>();
				Set<Entry<PropertyKey, FieldFormatter>> entries = propertyMap.entrySet();
				for (Entry<PropertyKey, FieldFormatter> entry : entries) {
					PropertyKey property = entry.getKey();
					//String keyLabel = entry.getValue();
					Object value = getPropertyValue(property.getValue(), el);
					Column col = null;
					
					if (property.getDescValue()==null  || property.getDescValue().isEmpty()
							 		||property.getDescValue().equals(" ")){
						
						col = new Column(value);
					}
					else{
						Object descValue = getPropertyValue(property.getDescValue(), el);
						col = new Column(value, descValue);
					}
					
					columns.add(col);
				}
				Row row = new Row(new ColumnIterator(columns));
				rows.add(row);
			}
			this.rowIterator=new RowIterator(rows);
		
	}
	 
	private void initHeaderCellList() throws Throwable{
		headerCellList=new ArrayList<HeaderCell>();
		Set<Entry<PropertyKey, FieldFormatter>> entries = propertyMap.entrySet();
		for (Entry<PropertyKey, FieldFormatter> entry : entries) {
			PropertyKey property = entry.getKey();
			FieldFormatter formatter= this.propertyMap.get(property);
			
			String keyLabel = formatter.getLabel();//entry.getValue().toString();
			HeaderCell hc = new HeaderCell();
			hc.setBeanPropertyName(property.getValue());
			hc.setBeanPropertyDescName(property.getDescValue());
			hc.setTitle(formatter.getLabelFromCode()!=null?formatter.getLabelFromCode():messageSource.getMessage(keyLabel));
			hc.setFieldFormatter(formatter);
			hc.setKey(property.isKey());
			if(hc.isKey())numberOfKeys++;
			headerCellList.add(hc);
		}
	}
	 
	
	 
//	private void initHeaderFooter() throws Throwable{
//		
//		if(headerParams!=null){
//			header=messageSource.getMessage(headerKey, headerParams);
//		}else{
//			header=messageSource.getMessage(headerKey);
//		}
//		
//		if(footerParams!=null){
//			footer=messageSource.getMessage(footerKey, footerParams);
//		}else{
//			footer=messageSource.getMessage(footerKey);
//		}
//	}
	
	public RowIterator getRowIterator(){
		 return this.rowIterator;
	 }

	public int getNumberOfKeys(){
		return numberOfKeys;
	}
	
	
}

