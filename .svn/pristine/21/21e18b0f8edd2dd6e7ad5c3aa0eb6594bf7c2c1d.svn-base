package it.almavivaitalia.web.sh.taglib.displaytable;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;

import java.util.List;

import javax.servlet.jsp.JspException;

public class ColumnTag extends ColumnParentTag{

	private static final long serialVersionUID = 1L;

	
	private boolean indexedColumn=false;

	private String labelTitleKey;
	
	private String getAbbrStart(){
		StringBuffer sb = new StringBuffer();
		if (!isEmpty(labelTitleKey)){
			String abbrTitle= getMessageSource().getMessage(labelTitleKey);
			sb.append("<abbr title=\"");
			sb.append(abbrTitle);
			sb.append("\">");
		}
		return sb.toString();
	}
	private String getAbbrEnd(){
		StringBuffer sb = new StringBuffer();
		if (!isEmpty(labelTitleKey)){
			sb.append("</abbr>");
		}
		return sb.toString();
	}
	
	public void release(){
		super.release();
		if (indexedColumn){
			setValue(null);
		}
		setTitleKey(null);
		setHeaderScope(null);
		indexedColumn=false;
		setClazz(null);
		setTableTag(null); 
		setIsImporto(false);
		setProperty(null);
	}		
	public int doStartTag() throws JspException {
		initDefaults();
		if (getTableTag().isExportFile()){
			renderForExport();
		}else {
			renderNormal();
		}
		return super.doStartTag();	
		
	}

	private void renderForExport(){
		if (!isEmpty(getTitleKey())){
			setTitle(getMessageSource().getMessage(getTitleKey()));
		}
	}
	private void renderNormal() throws JspException{
		if (!isEmpty(getTitleKey())){
			setTitle(getAbbrStart()+getMessageSource().getMessage(getTitleKey())+getAbbrEnd());
		}
		
		if (indexedColumn){
			setValue("");
			setValue("<abbr class=\"boldText\" title=\"\">"+(getCurrentRowIndex()+1)+"</abbr>");
			setClass("w5");
			setTitle("&nbsp;");
		}
	
		List<Integer> selectedRows=getTableTag().getSelectedRows();
		
	/*	
		if (!isEmpty(selectedRows)){
			if (selectedRows.contains(getCurrentRowIndex())){
				addStyleClass("selected");
			}else {
				addStyleClass("normal");
			}
		}else {
			addStyleClass("normal");
		}		
	*/
		
	}
	
	public int doEndTag() throws JspException {
		//release();
		return super.doEndTag();
	}

	
	
	private void addStyleClass(String styleClass){
		String actualClass= getClazz();
		if (actualClass==null){
			super.setClass(styleClass);
		}else {
			super.setClass(actualClass+" "+styleClass);
		}		
	}



	public void setIndexedColumn(boolean indexedColumn) {
		this.indexedColumn = indexedColumn;
	}



	public void setLabelTitleKey(String labelTitleKey) {
		this.labelTitleKey = labelTitleKey;
	}
	
	
}
