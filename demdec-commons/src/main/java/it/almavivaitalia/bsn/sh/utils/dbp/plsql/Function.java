package it.almavivaitalia.bsn.sh.utils.dbp.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Function extends AbstractPLSQL {
	private static final String CALL_STRING = "{ ? =  call ";
	private int returnType;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	/* COSTRUTTORI SENZA NOME DEL PACKAGE */
	public Function(String name, int returnType) {
		super(name);
		this.returnType = returnType;
	}

	/* COSTRUTTORI CON NOME DEL PACKAGE */
	public Function(String pkgName, String name, int returnType) {
		super(pkgName,name);
		this.returnType = returnType;
	}
	
	public Function(Connection connection, String pkgName, String name, int returnType) {
		super(connection, pkgName, name);
		this.returnType = returnType;
	}
	
	public Object call(Connection c) throws SQLException {
		CallableStatement stmt = c.prepareCall(makeProcedureCall(CALL_STRING));
		
		stmt.registerOutParameter(1, returnType);
		
		int x=2;		
        
		for(Parameter obj:getParams()){
	      stmt.setObject(x++, obj.getValue());
        }	
		stmt.executeQuery();
		
		return stmt.getString(1);

	}
	public Object call() throws SQLException {
		CallableStatement stmt = getConnection().prepareCall(makeProcedureCall(CALL_STRING));
		
		stmt.registerOutParameter(1, returnType);
		
		int x=2;		
        
		for(Parameter obj:getParams()){
	      stmt.setObject(x++, obj.getValue());
        }	
		
		stmt.executeQuery();
		
		return stmt.getString(1);

	}
	public Function addParameter(Object value, int type) {
		getParams().add(new Parameter(value, type));
		return this;
	}

	public Function addParameter(Parameter p) {
		getParams().add(p);
		return this;
	}

	public static String getCallString() {
		return CALL_STRING;
	}

}
