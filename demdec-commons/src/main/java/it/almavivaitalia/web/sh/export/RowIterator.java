package it.almavivaitalia.web.sh.export;

import java.util.List;



public class RowIterator{

	private List<Row> rows;
	private int index=0;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM7 = 0L;
	/*END LOCM*/
	
	public RowIterator(List<Row> rows) {
		super();
		this.rows = rows;
	}


	public boolean hasNext() {
		return index<rows.size();
	}


	public Row next() {
		return rows.get(index++);
	}


}
