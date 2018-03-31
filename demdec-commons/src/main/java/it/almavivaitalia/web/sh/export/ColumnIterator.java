package it.almavivaitalia.web.sh.export;

import java.util.List;


public class ColumnIterator{
	
	
	private List<Column> columns;
	private int index=0;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM7 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM8 = 1L;
	/*END LOCM*/

	public boolean hasNext() {
		return index<columns.size();
	}

	
	public Column nextColumn(){
		return columns.get(index++);
	}
	
	public Column get(int index){
		return columns.get(index);
	}

	public ColumnIterator(List<Column> columns) {
		super();
		this.columns=columns;
	}
	
	

}
