package it.almavivaitalia.web.sh.taglib.displaytable;

import it.almavivaitalia.web.sh.taglib.displaytable.extraheader.WriteOnlyDataRowsHtmlTableWriter;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.WarningCodeName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
public class TableTag extends BaseTableTag{

	
	private String divContainerClass;
	private String clazz;
	private String cellpadding;
	private String cellspacing;
	private String id;
	private String selectedRow;
	private boolean writeOnlyDataRows=false;
	private boolean skipDiv;
	private String numberRowToShow;				
	private boolean isExportFile=false;
	private String name;
	private String summary;
	//style="width:100%" id="row"
	
	public boolean isSkipDiv() {
		return skipDiv;
	}

	public void setSkipDiv(boolean skipDiv) {
		this.skipDiv = skipDiv;
	}

	public String getNumberRowToShow() {
		return numberRowToShow;
	}

	public void setNumberRowToShow(String numberRowToShow) {
		this.numberRowToShow = numberRowToShow;
	}	
	
	
	public void setWriteOnlyDataRows(String writeOnlyDataRows) {
		this.writeOnlyDataRows = (writeOnlyDataRows!=null)&&(writeOnlyDataRows.equals("true"));
	}
	protected boolean isWriteOnlyDataRows() {
		return writeOnlyDataRows;
	}	
	
	public void setIsExportFile(String isExportFile) {
		this.isExportFile = (isExportFile!=null)&&(isExportFile.equals("true"));
	}

	protected boolean isExportFile(){
		return isExportFile;
	}
	private List<Integer> selectedRows;
	
	protected List<Integer> getSelectedRows() {
		return selectedRows;
	}
	
	public void setName(String name) {
		this.name = name;
		super.setName(name);
	}

	public void setSelectedRow(String selectedRow) {
		this.selectedRow = selectedRow;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void setDivContainerClass(String divContainerClass) {
		this.divContainerClass = divContainerClass;
	}

	public void setClass(String clazz) {
		this.clazz = clazz;
	}

	public void setCellpadding(String cellpadding) {
		this.cellpadding = cellpadding;
	}

	public void setCellspacing(String cellspacing) {
		this.cellspacing = cellspacing;
	}



	public void setId(String id) {
		this.id = id;
	}

	private void initDefaults(){
		if (divContainerClass==null){
			setDivContainerClass("scroll_table_gen");
		}
		if (clazz==null){
			setClass("lux tableDati marg_0px_auto");
		}	
		super.setClass(clazz);
			
/*		if (cellpadding==null){
			setCellpadding("1");
			super.setCellpadding(cellpadding);
		}
		if (cellspacing==null){
			setCellspacing("1");
			super.setCellspacing(cellspacing);
		}

		if (style==null){
			setStyle("width:100%");
			super.setStyle(style);
		}*/
		if (id==null){
			setId("row");
		} 

		super.setId(id+Calendar.getInstance().getTimeInMillis());
		super.setUid(id);
		
		selectedRows = new ArrayList<Integer>();
		if (selectedRow!=null){
			for(StringTokenizer stz = new StringTokenizer(selectedRow, ",");stz.hasMoreTokens();){
				selectedRows.add(new Integer(stz.nextToken()));
			}
		}

	}
	
	public void release(){
		super.release();
		divContainerClass=null;
		selectedRow=null;
		selectedRows = null;
		isExportFile=false;
		writeOnlyDataRows=false;
	}
	
	@Override
	public int doStartTag() throws JspException {
		
		initDefaults();
		
		/**
		 * BEGIN
		 */
		if(numberRowToShow!=null&&!"".equals(numberRowToShow)){
			setOffset(Integer.valueOf(numberRowToShow)+1);
			setLength(1);
		}else{
			setOffset(-1);
			setLength(-1);
		}		
		
		/**
		 * END
		 */
		
		try {
			String objectName=name;
			int index = objectName.lastIndexOf(".");
			if (index>=0){
				objectName=objectName.substring(index+1, objectName.length());
			}
			
			Object o = getAttribute(objectName);
			if (!(o instanceof java.util.Collection<?>)) {
				List<Object> list = new ArrayList<Object>();
				list.add(o);
				pageContext.setAttribute(objectName, list);
			}else {
				@SuppressWarnings("rawtypes")
				int size = ((java.util.Collection)o).size();
				int maxNoScrollSize = Integer.parseInt(getMessageSource().getMessage("MAX_TABLE_NO_SCROLL_SIZE"));
				if (size>maxNoScrollSize){
					divContainerClass+=" scrollDivTableHeight";
				}
			}			
			
			if(!skipDiv){
				if (!isExportFile){
					pageContext.getOut().write("<div class=\""+divContainerClass+"\">");
				}
			}						
			
		}catch (Exception e) {
			throw new JspException(e);
		}
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		HttpSession session=((HttpServletRequest)pageContext.getRequest()).getSession();
		String ambiente=null;
		
		if(!StringUtils.isEmpty((String)session.getServletContext().getAttribute(BaseSessionAttributes.AMBIENTE))){
			ambiente=(String)getRequest().getSession().getServletContext().getAttribute(BaseSessionAttributes.AMBIENTE);
		}else{
			ambiente=AMBIENTE_COLL;
		}
		
		if(AMBIENTE_SVIL.equals(ambiente)&&(getCaptionTag()==null)){
			try {
				pageContext.getOut().write("<div class=\"tabella\">");
				pageContext.getOut().write(getMessageSource().getMessage(WarningCodeName.WARNING_EMPTY_CAPTION_GENERIC));
				pageContext.getOut().write("</div>");
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		int res = super.doEndTag();
		
		if(!skipDiv){
			if (!isExportFile){
				try {
					pageContext.getOut().write("</div>");	
				}catch (Exception e) {
					throw new JspException(e);
				}
			}
		}				
		
		return res;
	}
	
	@Override
	protected void writeHTMLData() throws JspException {
		  if (isWriteOnlyDataRows()){
			  JspWriter out = pageContext.getOut();
	
			        String css = getProperties().getCssTable();
			        if (StringUtils.isNotBlank(css))
			        {
			            this.addClass(css);
			        }
			        
			       int pagesize =0;
			       if ((getTableModel()!=null) && (getTableModel().getRowListPage()!=null) ){
			    	   pagesize = getTableModel().getRowListPage().size();
			       }
			        	
			        
			        // use HtmlTableWriter to write table
			        new WriteOnlyDataRowsHtmlTableWriter(
			        		getTableModel(),
			        		getProperties(),
			        		getBaseHref(),
			        		isExportFile,
			        		out,
			        		getCaptionTag(),
			            null,
			            null,
			            pagesize,
			            getAttributeMap(),
			            getUid()
			            
			        ).writeTable(getTableModel(), getUid());
	
			        if (getVarTotals() != null)
			        {
			            pageContext.setAttribute(getVarTotals(), getTotals());
			        }
			        
		  }else {
			  super.writeHTMLData();
		  }
	}
	
	@Override
    public void setSummary(String value){
		super.setSummary(null);
        this.summary = null;
    }

}
