package it.almavivaitalia.bsn.sh.utils;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.replaceString;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ParseUtil {

	public static BigDecimal getBigDecimal(Object s) throws Exception {
	
		if (!isEmpty(s)) {
			String s1 = s.toString().trim();
			s1 = replaceString(s1, ".", "");
			s1 = replaceString(s1, ",", ".");
			return new BigDecimal(s1);
		} else {
			return BigDecimal.ZERO;
		}
	}

	public static Byte getByte(Object s) throws Exception {
		if (!isEmpty(s)) {
			return new Byte(s.toString().trim());
		} else {
			return null;
		}
	}

	public static String getDataAsString(Date s) throws Exception {
		if (!isEmpty(s)) {
			return new SimpleDateFormat("dd/MM/yyyy").format(s);
		} else {
			return "";
		}
	}

	public static Double getDouble(Object s) throws Exception {
		if (!isEmpty(s)) {
			return new Double(s.toString().trim());
		} else {
			return null;
		}
	}

	public static String getHexString(byte[] b) throws Exception {
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}

	public static Integer getInteger(Object s) throws Exception {
		if (!isEmpty(s)) {
			return new Integer(s.toString().trim());
		} else {
			return null;
		}
	}

	public static Long getLong(Object s) throws Exception {
		if (!isEmpty(s)) {
			return new Long(s.toString().trim());
		} else {
			return null;
		}
	}

	public static String getNumberFormat(Number n) throws Exception {
		if (n != null) {
			return getFormatter().format(n);
		} else {
			return "";
		}
	}

	public static String getNumberFormat(Number n, Integer decimals)
			throws Exception {
		if (n != null) {
			return getFormatter(decimals).format(n);
		} else {
			return "";
		}
	}

	public static Short getShort(Object s) throws Exception {
		if (!isEmpty(s)) {
			return new Short(s.toString().trim());
		} else {
			return null;
		}
	}

	private static NumberFormat getFormatter() {
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALIAN);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
	
		return nf;
	}

	public static NumberFormat getFormatter(int decimals) {
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALIAN);
		nf.setMinimumFractionDigits(decimals);
		nf.setMaximumFractionDigits(decimals);
	
		return nf;
	}

	public static String getFormattedNumber(Number n, int fractionDigits) {
		String formattedNumber = "";
		if (n != null) {
			try {
				formattedNumber = getFormatter(fractionDigits).format(n);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return formattedNumber;
	}
	
}
