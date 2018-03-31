package it.almavivaitalia.bsn.sh.utils.dbp.plsql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public abstract class AbstractPLSQL {
	
	private Connection connection;
	private String pkgName;
	private String name;
	private List<Parameter> params = new ArrayList<Parameter>();

	public AbstractPLSQL(){}
	
	public AbstractPLSQL(String name){
		this.name=name;
	}
	
	public AbstractPLSQL(String pkgName, String name){
		this.pkgName=pkgName;
		this.name=name;
	}
	
	public AbstractPLSQL(Connection connection, String pkgName, String name){
		this.connection=connection;
		this.pkgName=pkgName;
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Parameter> getParams() {
		return params;
	}

	public void setParams(List<Parameter> params) {
		this.params = params;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public String getPkgName() {
		return pkgName;
	}

	protected int countOutParam() {
		int result = 0;

		for (Parameter param : getParams()) {
			if (param.isOutParameter()) {
				result++;
			}
		}

		return result;
	}

	protected Connection getConnection(){
		return connection;
	}
	
	// prepara la chiamata per la procedura
	protected String makeProcedureCall(String call) {

		Object[] parameters = new Object[getParams().size()];

		for (int i = 0; i < getParams().size(); i++) {
			parameters[i] = ((Parameter) getParams().get(i)).getValue();
		}

		StringBuilder prepareCall = new StringBuilder();
		StringBuilder placeHolders = new StringBuilder();

		// prepara la stringa con i place holders
		for (@SuppressWarnings("unused") Object obj : parameters) {
			if (placeHolders.length() != 0) {
				placeHolders.append(", ");
			}
			placeHolders.append("?");
		}

		prepareCall.append(call);

		if (!StringUtils.isEmpty(pkgName)) {
			prepareCall.append(pkgName + ".");
		}

		prepareCall.append(name + "(" + placeHolders + ") }");

		String merda=prepareCall.toString();
		
		System.out.println(merda);
		
		return merda;
	}

	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
}
