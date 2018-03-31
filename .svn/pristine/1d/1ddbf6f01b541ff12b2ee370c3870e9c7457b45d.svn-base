package it.almavivaitalia.bilancio.commons.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * Classe di utility per le date
 * 
 * Classe che contiene metodi statici per manipolare,
 * generare o formattare date e oggetti simili
 * */

public class DateUtil {
	
	
	/*
	 * restituisce una stringa con la data attuale in formato italiano
	 * (gg-mm-aaaa) con il separatore desiderato (separator)
	 */
	public static String getSysDate(String separator) {
		Calendar cal = GregorianCalendar.getInstance();
		String s = NumberUtil.normalizza(cal.get(Calendar.DAY_OF_MONTH) + "", 2)
				+ separator;
		s += NumberUtil.normalizza((cal.get(Calendar.MONTH)+1) + "", 2) + separator;
		s += cal.get(Calendar.YEAR);
		return s;
	}

	/*
	 * restituisce una stringa con la data attuale in formato americano
	 * (aaaa-mm-gg) con il separatore desiderato (separator)
	 */
	public static String getAmericanSysDate(String separator) {
		Calendar cal = GregorianCalendar.getInstance();
		String s = cal.get(Calendar.YEAR) + separator;
		s += NumberUtil.normalizza(cal.get(Calendar.MONTH) + "", 2) + separator;
		s += NumberUtil.normalizza(cal.get(Calendar.DAY_OF_MONTH) + "", 2);
		return s;
	}
}
