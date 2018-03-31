package it.almavivaitalia.bsn.sh.utils;

import java.util.Collection;

public class StringUtil {

	public static String getString(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}

	public static String trimRight(String source, String toTrim)
			throws Throwable {
		if ((source != null) && (toTrim != null)) {
			String s = new String(source);
			while (s.endsWith(toTrim)) {
				s = s.substring(0, s.length() - toTrim.length());
			}
			return s;
		} else {
			return source;
		}
	}

	public static String trimLeft(String source, String toTrim)
			throws Throwable {
		if ((source != null) && (toTrim != null)) {
			String s = new String(source);
			while (s.startsWith(toTrim)) {
				s = s.substring(toTrim.length(), s.length());
			}
			return s;
		} else {
			return source;
		}
	}

	public static String trim(String source, String toTrim) throws Throwable {
		return trimRight(trimLeft(source, toTrim), toTrim);
	}

	/**date le due stringhe in ingresso input e suffix:
	 * --	se input e' pari a null o a stringa vuota si restituisce 
	 * 		input stessa;
	 * --	se input != null e termina diversamente da quanto
	 * 		espresso in suffix, il metodo aggiunge suffix
	 * 		stesso ad input e restituisce la nuova stringa cosi' 
	 * 		formata.
	 * Es: input = 'aaa'; suffix ='.rpt' ==> return 'aaa.rpt' 
	 * */
	public static String aggiungiSuffissoSeNonPresente(String input, String suffix) throws Throwable
	{	
		
		if(		input != null
				&& input.trim().length() > 0
			)
		{	input = input.trim();
			
			if (	input.lastIndexOf(suffix) == -1 
					&& input.lastIndexOf(suffix.toUpperCase()) == -1
				)
			{
				input = input + suffix;
			}	
				
		}

		return input;
    }

	public static String replaceString(java.lang.String inputStr,
			java.lang.String findStr, java.lang.String replaceStr) {
		String returnStr = new String(inputStr);
		int pos = returnStr.indexOf(findStr, 0);
		while (pos != -1) {
			returnStr = returnStr.substring(0, pos) + replaceStr
					+ returnStr.substring(pos + findStr.length());
			pos = returnStr.indexOf(findStr, pos + replaceStr.length());
		}
		return returnStr;
	}

	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		} else if (o instanceof Collection<?>) {
			return ((Collection<?>) o).isEmpty();
		} else {
			return o.toString().trim().equals("");
		}
	}
	
}
