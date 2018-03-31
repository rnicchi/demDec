package it.mef.bilancio.demdec.utils;

import java.math.BigDecimal;

import it.almavivaitalia.bsn.sh.utils.ParseUtil;

public class NumberUtil extends ParseUtil {
    @SuppressWarnings("unused")	
    private final static String securityMetricaLOCM1 = "LOCM";

    public static String getFormattedNumber(Object n) {
		return getFormattedNumber(n, 0);
	}
	public static String getFormattedNumber(Object n, int fractionDigits) {
		String formattedNumber = "";
		try {
			if (n != null) {
				if (n instanceof Number) {
					formattedNumber = getFormattedNumber((Number) n, fractionDigits);
				} else if (n instanceof String) {
					formattedNumber = getFormattedNumber(getFormatter(fractionDigits).parse(n.toString()), fractionDigits);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formattedNumber;
	}
	
	public static BigDecimal calcoloDeltaAcca(BigDecimal impoOld, BigDecimal impoNew){
		BigDecimal result = BigDecimal.ZERO;
		if ((impoOld.compareTo(BigDecimal.ZERO) >= 0) && (impoNew.compareTo(BigDecimal.ZERO) < 0 )){ 
			result = impoNew;	
		}
		if ((impoOld.compareTo(BigDecimal.ZERO) < 0) && (impoNew.compareTo(BigDecimal.ZERO) == 0 )){ 
			result = impoOld.negate();	
		}
		if ((impoOld.compareTo(BigDecimal.ZERO) < 0) && (impoNew.compareTo(BigDecimal.ZERO) < 0 )){
			result = impoNew.subtract(impoOld);
		} 

		return result;
	}
	
	public static BigDecimal calcoloDeltaSpese(BigDecimal impoOld, BigDecimal impoNew){
		BigDecimal result = BigDecimal.ZERO;
/*		  IF importo_old > 0 AND importo_new > 0 THEN
		    DELTA_OUT := 0;
		  END IF;*/
		if (impoOld.doubleValue()>=0 && impoNew.doubleValue()<0){
			result = BigDecimal.ZERO.subtract(impoNew);
		}
/*		  IF importo_old = 0 AND importo_new < 0 THEN
		    DELTA_OUT := importo_old - (importo_new);
		  END IF;
		  IF importo_old > 0 AND importo_new < 0 THEN
		    DELTA_OUT := 0 - (importo_new);
		  END IF;*/
		if (impoOld.doubleValue()<0 && impoNew.doubleValue()<0){
			result = impoOld.subtract(impoNew);
		}
/*		  IF importo_old < 0 AND importo_new < 0 THEN
		    DELTA_OUT := importo_old - (importo_new);
		  END IF;*/
		if (impoOld.doubleValue()<0 && impoNew.doubleValue()>=0){
			result = impoOld;
		}
/*		  IF importo_old < 0 AND importo_new >= 0 THEN
			DELTA_OUT := importo_old;
		  END IF;*/
		return result;
	}
	
}
