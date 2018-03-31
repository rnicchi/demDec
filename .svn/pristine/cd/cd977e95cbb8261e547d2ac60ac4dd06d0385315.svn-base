package it.almavivaitalia.web.sh.export;

import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;

import java.io.OutputStream;
import java.util.List;


public abstract class TableFileExport{

	private final static String EMPTY_STRING = "";

    private List<TableModel> model;
    
    
    
    private TableModel currentPageModel;
    protected TableModel getCurrentPageModel(){
    	return this.currentPageModel;
    }
    private ResourceBundleMessageSource messageSource;
	
	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}
	

	
	
	protected abstract void startDocument(OutputStream out) throws Throwable;
	protected abstract void endDocument() throws Throwable;
    protected abstract void fillPage() throws Throwable;
	
	protected abstract void startPage() throws Throwable;
	protected abstract void endPage() throws Throwable;
    

    
    protected abstract void generateRows() throws Throwable;
    protected abstract void generateHeaders() throws Throwable;
    	 
	
	

	
	public abstract String getMimeType();
	public void setParameters(List<TableModel> tableModel) {
        this.model = tableModel;
    }
	
    public void doExport(OutputStream out) throws Throwable {
        try {
        	startDocument(out);
            for (TableModel page : model) {
               
            	
	            	currentPageModel=page;
	                currentPageModel.setMessageSource(messageSource); 
	
	                currentPageModel.init();
	              if (page.getRowIterator()!=null){
	            	startPage();
	                fillPage();
	                endPage();
	              }
			}
            
            endDocument();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}