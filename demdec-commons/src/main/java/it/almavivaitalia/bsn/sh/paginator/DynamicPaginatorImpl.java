package it.almavivaitalia.bsn.sh.paginator;

import java.lang.reflect.Method;
import java.util.List;

public class DynamicPaginatorImpl extends AbstractPaginator implements Paginator {

	
	private Object queryManager;
	private Object[] queryParams;
	private Class<?>[] queryTypes;
	private String queryMethodName;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	/*END LOCM*/
	
	public DynamicPaginatorImpl(
			Object queryManager,
			String queryMethodName,
			Class<?>[] queryTypes,
			Object[] queryParams,
			String nameSessionList){
		super();
		this.queryManager=queryManager;
		this.queryMethodName=queryMethodName;
		setQueryTypes(queryTypes);
		setQueryParams(queryParams);
		super.setNameSessionList(nameSessionList);
	}
	
	
	public DynamicPaginatorImpl(	Object queryManager,
									String queryMethodName,
									Class<?>[] queryTypes,
									Object[] queryParams,
									String nameSessionList, 
									int pageSize){
		super(pageSize);
		this.queryManager=queryManager;
		this.queryMethodName=queryMethodName;
		setQueryTypes(queryTypes);
		setQueryParams(queryParams);
		super.setNameSessionList(nameSessionList);
	}	
	
	
	
	private void setQueryTypes( Class<?>[] queryTypes) {
		if (queryTypes==null){
			this.queryTypes = new Class<?>[1];
		}else {
			this.queryTypes = new Class<?>[queryTypes.length+1];
			for(int i=0; i<queryTypes.length;i++){
				this.queryTypes[i]=queryTypes[i];
			}
		}
		this.queryTypes[this.queryTypes.length-1]=Paginator.class;
	}

	private void setQueryParams(Object[] queryParams) {
		if (queryParams==null){
			this.queryParams = new Object[1];
		}else {
			this.queryParams = new Object[queryParams.length+1];
			for(int i=0; i<queryParams.length;i++){
				this.queryParams[i]=queryParams[i];
			}
		}
		
		this.queryParams[this.queryParams.length-1]=this;
	}
	
	public List<?> update() throws Throwable{
		List<?> list = null;
		if (queryManager==null){
			throw new RuntimeException("manager cannot be null");
		}else if ((queryMethodName==null) || (queryMethodName.trim().equals(""))){
			throw new RuntimeException("methodName cannot be empty");
		} else if (
				(	(queryTypes==null) && (queryParams!=null)) ||
				((queryTypes!=null) && (queryParams==null)) ||
				(queryTypes.length != queryParams.length)
				){
				throw new RuntimeException("queryTypes do not match queryParams");
		} else if (
					getNameSessionList() == null
					|| getNameSessionList().trim().length() == 0
				){
				throw new RuntimeException("nameSessionList cannot be null or empty");		
		} else {
			
			Method method = queryManager.getClass().getMethod(queryMethodName, queryTypes);
			list =( List<?> )method.invoke(queryManager, queryParams);
			
			checkValuePaginator(list);
			
		}
		return list;
	}
	
	
	public static void main(String[] args){
		try {
			
			
					
			
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}
	


}
