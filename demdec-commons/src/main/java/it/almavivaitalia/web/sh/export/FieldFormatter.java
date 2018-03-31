package it.almavivaitalia.web.sh.export;


public class FieldFormatter implements FieldFormatterConstants{
	
		
	private Double width;
	private Integer type;
	private String label;
	private String labelFromCode;
	private String cssClass;
	private String abbr;
	private Integer decimals=2;

	public String getLabelFromCode() {
		return labelFromCode;
	}

	public void setLabelFromCode(String labelFromCode) {
		this.labelFromCode = labelFromCode;
	}
	
	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public Integer getDecimals() {
		return decimals;
	}

	public void setDecimals(Integer decimals) {
		this.decimals = decimals;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

//	public FieldFormatter(Double width,String label, Integer type){
//		this.width=width;
//		this.label=label;
//		this.type=type;
//	}
	
	public FieldFormatter(Double width,String label, Integer...typeDec){
		this.width=width;
		this.label=label;
		if(typeDec!=null && typeDec.length!=0){
			this.type=typeDec[0];
			if (typeDec.length!=1)
				this.decimals=typeDec[1];
		}
	}
	
//	public FieldFormatter(Double width,String label, Integer type, Integer decimals){
//		this.width=width;
//		this.label=label;
//		this.type=type;
//		this.decimals=decimals;
//	}
	
	public FieldFormatter(Double width,String label){
		this.width=width;
		this.label=label;
		this.type=TYPE_OBJECT;
	}
	public FieldFormatter(String label){
		this.label=label;
		this.type=TYPE_OBJECT;
	}

	public void setWidth(Double width) {this.width = width;}
	public void setType(Integer type) {this.type = type;}
	public void setLabel(String label) {this.label = label;}
	
	public Double getWidth() {return width;}
	public Integer getType() {return type;}
	public String getLabel() {return label;}
}
