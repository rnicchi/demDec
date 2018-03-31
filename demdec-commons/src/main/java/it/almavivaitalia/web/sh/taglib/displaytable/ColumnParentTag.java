package it.almavivaitalia.web.sh.taglib.displaytable;

public class ColumnParentTag extends BaseColumnTag {

	private String titleKey;
	private String headerScope;
	private String clazz;
	private TableTag tableTag;
	

	private String property;
	private boolean isImporto = false;
	private boolean isImportoIntero = false;

	protected String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
		super.setProperty(property);
	}

	@Override
	public void setClass(String value) {
		this.clazz = value;
		super.setClass(value);
	}

	protected String getClazz() {
		return this.clazz;
	}

	public void setHeaderScope(String headerScope) {
		this.headerScope = headerScope;
	}

	public void setIsImportoIntero(boolean isImportoIntero) {
		this.isImportoIntero = isImportoIntero;
	}

	public void setIsImporto(boolean isImporto) {
		this.isImporto = isImporto;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public String getHeaderScope() {
		return headerScope;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	protected void initDefaults() {
		if (headerScope == null) {
			setHeaderScope("col");
			super.setHeaderScope(headerScope);
		}
		tableTag = getTableTag();

		if (isImporto) {
			setDecorator("it.almavivaitalia.web.sh.taglib.displaytable.ImportoDecorator");
			setClass("importoAlign nowrap");

		} else if (isImportoIntero) {
			setDecorator("it.almavivaitalia.web.sh.taglib.displaytable.IntegerAmountDecorator");
			setClass("importoAlign nowrap");
		} else {
			setDecorator("");
		}

		/*
		 * if (clazz==null){ setClass("normal"); }
		 */

		super.setTitleKey(null);
	}

	public void setTableTag(TableTag tableTag){
		this.tableTag=tableTag;
	}
	
	public TableTag getTableTag() {
		return ((TableTag) super.getTableTag());
	}
}
