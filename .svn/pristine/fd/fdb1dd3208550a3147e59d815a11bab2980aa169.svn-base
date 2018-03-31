package it.almavivaitalia.bsn.sh.paginator;

import java.util.ArrayList;
import java.util.List;

public class StaticPaginatorImpl extends AbstractPaginator implements Paginator{

	
	private List<?> list;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	/*END LOCM*/
	
	public StaticPaginatorImpl(List<?> list, String nameSessionList){
		super();
		this.list=list;
		super.setNameSessionList(nameSessionList);
	}
	

	public StaticPaginatorImpl(List<?> list, String nameSessionList, int pageSize){
		super(pageSize);
		this.list=list;
		super.setNameSessionList(nameSessionList);
	}
	
	
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}	
	
	@Override
	public List<?> update() throws Throwable {
		List<Object> page =null;
		if (	getNameSessionList() == null
				|| getNameSessionList().trim().length() == 0
			)
		{
			throw new RuntimeException("nameSessionList cannot be null or empty");		
		}
		else if (list!=null)
		{
			page = new ArrayList<Object>();
			
			checkValuePaginator(list); 
			
			int lastIndex = Math.min(getFirstResultIndex()+getPageSize(), list.size());
			for(int i=getFirstResultIndex(); i<lastIndex; i++){
				page.add(list.get(i));
			}
		}
		return page;
	}
	
	@Override
	public int getNumberOfElements() {
		if (list==null){
			return 0;
		}else {
			return list.size();
		}
	}
	
	/*@Override
	public void setNumberOfElements(int numberOfElements) {
		
	}*/
	
}
