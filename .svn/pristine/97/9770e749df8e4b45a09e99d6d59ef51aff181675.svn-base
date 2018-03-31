package it.almavivaitalia.bsn.sh.utils.dbp.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Procedure extends AbstractPLSQL {

	private static final String CALL_STRING = "{ call ";
	
	public static String getCallString() {
		return CALL_STRING;
	}

	/* COSTRUTTORI SENZA NOME DEL PACKAGE */
	public Procedure(String name) {
		super(name);
	}

	/* COSTRUTTORI CON NOME DEL PACKAGE */
	public Procedure(String pkgName, String name) {
		super(pkgName, name);
	}

	public Procedure(Connection connection, String pkgName, String name){
		super(connection, pkgName, name);
	}	
	
	public Object[] call(Connection c) throws SQLException {
		CallableStatement stmt = c.prepareCall(makeProcedureCall(CALL_STRING));
		setObjectParameter(stmt);
		stmt.executeQuery();
		return getReturnObject(stmt);
	}
	
	public Object[] call() throws SQLException {
		CallableStatement stmt = getConnection().prepareCall(makeProcedureCall(CALL_STRING));
		setObjectParameter(stmt);
		stmt.executeQuery();
		return getReturnObject(stmt);
	}
	
	private void setObjectParameter(CallableStatement stmt) throws SQLException{
		for (int i = 0; i < getParams().size(); i++) {
			Parameter p = getParams().get(i);

			if (p.getParamType() ==Parameter.getOut()) {
				stmt.registerOutParameter(i + 1, getParams().get(i).getType());
			}else{
				if(p.getParamType()==Parameter.getInout()){
					stmt.registerOutParameter(i + 1, getParams().get(i).getType());
				}
				stmt.setObject(i + 1, p.getValue().toString());
			}
		}
	}
	
	/*private void setObjectParameter(CallableStatement stmt) throws SQLException{
		for (int i = 0; i < getParams().size(); i++) {
			Parameter p = getParams().get(i);
			stmt.setObject(i + 1, p.getValue().toString());
			if (getParams().get(i).isOutParameter()) {
				stmt.registerOutParameter(i + 1, getParams().get(i).getType());
			}
		}
	}*/
	
	private Object[] getReturnObject(CallableStatement stmt) throws SQLException{
		Object[] result = new Object[countOutParam()];
		
		int count = 0;
		
		for (int i = 0; i < getParams().size(); i++) {
			if (getParams().get(i).isOutParameter()) {
				result[count++] = stmt.getObject(i + 1);
			}
		}
		
		return result;
	}

	public Procedure addParameter(Parameter p) {
		getParams().add(new Parameter(p.getValue(), p.getType(), p.getParamType()));
		return this;
	}

	public Procedure addParameter(Object value, int type) {
		getParams().add(new Parameter(value, type));
		return this;
	}

	public Procedure addOutParameter(int type) {
		getParams().add(new Parameter("", type, Parameter.getOut()));
		return this;
	}

	public Procedure addInOutParameter(Object value, int type) {
		getParams().add(new Parameter(value, type, Parameter.getInout()));
		return this;
	}

}
