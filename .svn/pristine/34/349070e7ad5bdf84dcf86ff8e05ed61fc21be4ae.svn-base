package it.almavivaitalia.bilancio.commons.utils;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.setPropertyValue;


public class SqlResultTransformer extends ResultTransformer implements org.hibernate.transform.ResultTransformer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SqlResultTransformer(Class<?> type){
		super(type);
	}
	
	
	// può ricevere nomi di tabella o di campo scritti in uppercase o lowercase indifferentemente
	private static String getHibernatePropertyNameFromFieldName(String strToConvert){
		String res=strToConvert;
		res= res.toLowerCase();
		char[] charTable = res.toCharArray();
		for (int index= 0 ; index<charTable.length; index++) {
			if (charTable[index]=='_'){
				charTable[index+1]=Character.toUpperCase(charTable[index+1]);
			}
		}
		res= new String(charTable);
		res= res.replace("_", "");
		return res;	
	}

	@Override
	public Object transformTuple(Object[] tuple, String[] aliases){
		Object o=null;
		try {
			o = getType().newInstance();
			for(int i=0; i<aliases.length; i++){
				String property = getHibernatePropertyNameFromFieldName(aliases[i].replace("#", "."));
				setPropertyValue(property, o, tuple[i]);
			}
		}catch (Throwable e) {
			o=null;
			setRe(new RuntimeException(e));
			throw getRe();
		}
		return o;
	}

}
