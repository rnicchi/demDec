package it.almavivaitalia.bilancio.commons.utils;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

/*
 * Classe di utility per le stringhe
 * 
 * Classe che contiene tutti i metodi 
 * statici utili per manipolare o trarre 
 * informazioni dalle stringhe
 * 
 * */

public class StringUtil {

	/**
	 * Trasforma una stringa che segue le regole del camel case nel nome di una
	 * costante. Es. esempioCamelCase --> ESEMPIO_CAMEL_CASE
	 * il metodo riconosce le sigle (due o più lettere maiuscole vicine). Es2.
	 * variareDSL --> VARIARE_DLS
	 * 
	 * @param camelCase
	 * @return
	 */
	public static String camelCaseTranslater(String camelCase) {
		String constants = camelCase.charAt(0) + "";

		for (int i = 1; i < camelCase.toCharArray().length; i++) {
			char c = camelCase.toCharArray()[i];
			if (Character.isUpperCase(c)) {
				constants += "_";
			}

			constants += c;

		}
		return constants.toUpperCase();
	}

	/**
	 * Decripta il valore del campo attraverso
	 * un'interfaccia.
	 * Data la chiave "fieldName" restituisce
	 * il valore di questa costante nell'interfaccia
	 * o nella classe "className" 
	 * 
	 * @param className
	 * @param fieldName
	 * @return
	 * @throws NoSuchFieldException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static String fieldValue(String className, String fieldName)
			throws NoSuchFieldException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {

		Class<?> c = Class.forName(className);
		String fieldValue = null;

		Field f = c.getField(fieldName);
		@SuppressWarnings("rawtypes")
		Class type = f.getType();
		@SuppressWarnings("unused")
		Field[] fields = c.getDeclaredFields();
		fieldValue = (String) f.get(type);

		return fieldValue;
	}

	/**
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return
	 */
	public static String leftPad(
			String str,
            int size,
            String padChar){
		if(str.equals("0")){
			return str;
		}else{
			return StringUtils.leftPad(str, size, padChar);
		}
	}
	
	/**
	 * Converte la stringa passata dal formato xxx_yyy_zzz ad xxxYyyZzz
	 * 
	 * @param s stringa nel formato xxx_yyy_zzz
	 * @return
	 */
	public static String toCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = parts[0];
		for (int i=1; i < parts.length; i++) {
			camelCaseString = camelCaseString + toProperCase(parts[i]);
		}
		return camelCaseString;
	}
	
	private static String toProperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}	
}
