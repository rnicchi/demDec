package it.almavivaitalia.bsn.sh.utils;

import static it.almavivaitalia.bsn.sh.utils.ParseUtil.getBigDecimal;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.to.ItemTO;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

	/*
	 * Verifica che una stringa non contenga elementi differenti da caratteri
	 * alfabetici lettere accentate ed apostrofo (viene utilizzato perr i campi
	 * nome e cognome)
	 * 
	 * @return true se formalmente corretto
	 * 
	 * @param str
	 */
	public static boolean isAmount(String str) {
	
		// Pattern p =
		// Pattern.compile("(([0-9]{1,4})((\\,)([0-9]{0,2})){0,1})");
		Pattern p = Pattern
				.compile("(([0-9](\\.)?([0-9]{3,3}))|([0-9]{1,3}))((\\,)([0-9]{1,2}))?");
		Matcher m = p.matcher(str.trim());
		return m.matches();
	}

	/*
	 * Verifica che una stringa non contenga elementi differenti da caratteri
	 * alfabetici lettere accentate ed apostrofo (viene utilizzato perr i campi
	 * nome e cognome)
	 * 
	 * @return true se formalmente corretto
	 * 
	 * @param str
	 */
	public static boolean isAmount_3(String str) {
	
		// Pattern p =
		// Pattern.compile("(([0-9]{1,4})((\\,)([0-9]{0,3})){0,1})");
		Pattern p = Pattern
				.compile("(([0-9](\\.)?([0-9]{3,3}))|([0-9]{1,3}))((\\,)([0-9]{1,3}))?");
	
		Matcher m = p.matcher(str.trim());
	
		return m.matches();
	}

	public static boolean isDecimalNumber(Object s) {
		if (!isEmpty(s)) {
			String s1 = s.toString().trim();
			if (s1.indexOf(",") > 0) {
				return isNumber(s);
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public static boolean isEmail(String email) {
		return Pattern
				.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
				.matcher(email).matches();
	}

	public static boolean isIntegerNumber(Object s) {
		if (!isEmpty(s)) {
			String s1 = s.toString().trim();
			if (s1.indexOf(",") < 0) {
				return isNumber(s);
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public static boolean isItemVisible(Long seuqIdUtente, ItemTO item) {
		return true;
	}

	public static boolean isMinorThenZero(BigDecimal d) {
		if (d != null) {
			return d.compareTo(new BigDecimal("0")) < 0;
		} else {
			return false;
		}
	
	}

	public static Boolean isValidImporto(BigDecimal b, int cifre) {
		String importoLimite = "";
		for (int i = 0; i < cifre; i++) {
			importoLimite += "9";
		}
		BigDecimal b2 = new BigDecimal(importoLimite);
	
		int confronto = b.compareTo(b2);
	
		if (confronto <= 0) {
			return true;
		}
		return false;
	}

	public static Boolean isValidImporto(String value, String nCifreInt)
			throws Exception {
		Pattern p = Pattern.compile("(^[-,+]?\\d{1," + nCifreInt + "})+$");
		Matcher m = p.matcher(value);
		return m.matches();
	}

	public static Boolean isValidImporto(String value, String nCifreInt,
			String nCifreDec) throws Exception {
		value = value.replaceAll("\\.", "");
	
		Pattern p = Pattern.compile("(^[-,+]?\\d{1," + nCifreInt
				+ "})+(\\,\\d{1," + nCifreDec + "})?$");
		Matcher m = p.matcher(value);
		return m.matches();
	}

	/**
	 * Verifica che una stringa non contenga elementi differenti da caratteri
	 * alfabetici lettere accentate ed apostrofo (viene utilizzato perr i campi
	 * nome e cognome)
	 * 
	 * @return true se formalmente corretto
	 * @param str
	 */
	public static boolean isValidName(String str) {
		Pattern p = Pattern.compile("(([A-Z\\p{Lu}]+(\\')*)(\\s)*)*");
	
		Matcher m = p.matcher(str.trim());
	
		return m.matches();
	}

	public static boolean isNumber(Object s) {
		try {
			getBigDecimal(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isZero(BigDecimal d) {
		return d.compareTo(new BigDecimal("0")) == 0;
	}
	
}
