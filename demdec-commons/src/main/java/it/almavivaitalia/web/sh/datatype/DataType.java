package it.almavivaitalia.web.sh.datatype;

public interface DataType {
	public String getAction();

	public String getControllerCode();

	public String name();

	public String[] getInputParameters();

	public String[] getRequiredParameters();

	public String[] getOutputFields();

	public String getSummaryTable();

	public String getCaptionTable();

	public String getFieldFormatterFileName();
}
