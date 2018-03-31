package it.almavivaitalia.bsn.sh.utils;

public class QueryBuilder {

	
	private StringBuffer sb;
	
	public QueryBuilder(){
		sb=new StringBuffer();
	}
	
	public void append(String s){
		sb.append(s);
	}
	public void append(String s, boolean condition){
		if (condition){
			sb.append(s);
		}
	}
	public void append(String s, Object nullable){
		if ( (nullable!=null) && (!nullable.toString().trim().equals(""))){
			sb.append(s);
		}
	}
	@Override
	public String toString() {
		return sb.toString();
	}
	
}
