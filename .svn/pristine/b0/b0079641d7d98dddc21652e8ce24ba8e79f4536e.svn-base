package it.almavivaitalia.bsn.sh.paginator;

import java.util.List;


public abstract class AbstractParentPaginator implements Paginator{
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	
	private int currentPage;
	private int pageRange;
	private int numberOfElements;
	
	//Campo che prevede il nome della var di sessione sfruttata per memorizzare
	//la lista degli elementi visualizzati sull'interfaccia web
	private String nameSessionList;
	
	
	public AbstractParentPaginator(){
		pageRange = PAGE_RANGE_10;
	}

	
	public int getNumberOfPages(){
		if (getPageSize()>0){
			return (int)Math.ceil(((double)getNumberOfElements())/((double)getPageSize()));
		}else {
			return 0;
		}
	}


	public void setNextPageRange() throws Throwable{
		int[] currentPageRange=getCurrentPageRange();
		if (currentPageRange[1]<getNumberOfPages()-1){
			setCurrentPage(currentPageRange[1]+1);
		}
	}
	public void setPrevPageRange() throws Throwable{
		int[] currentPageRange=getCurrentPageRange();
		if (currentPageRange[0]>0){
			setCurrentPage(currentPageRange[0]-1);
		}
	}
	
	public abstract List<?> update() throws Throwable;
	
	
	public int getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}


	public int getPageRange() {
		return pageRange;
	}

	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String getNameSessionList() {
		return nameSessionList;
	}
	public void setNameSessionList(String nameSessionList) {
		this.nameSessionList = nameSessionList;
	}
	
	

	
	




	
}	
