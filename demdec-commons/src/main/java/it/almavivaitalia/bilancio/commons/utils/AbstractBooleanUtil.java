package it.almavivaitalia.bilancio.commons.utils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public abstract class AbstractBooleanUtil {
	
	public static Object operatoreTernario(boolean test, Object ok, Object ko){
		return test ? ok : ko ;
	}
	
	public static boolean orCondition(boolean... b){
		
		for(boolean temp : b){
			if(temp) return true;
		}
		
		return false;
	}
	
	public static boolean andCondition(boolean... b){
		
		for(boolean temp : b){
			if(!temp) return false;
		}
		
		return true;
	}
	
	public static boolean isNotNull(Object n) {
		return n != null;
	}

	public static boolean isNull(Object n) {
		return n == null;
	}

    public static boolean isNotZero(BigDecimal other) {

        if(isNull(other)){
            return false;
        }

        String otherNumber=other.toString();
        
        boolean condition=false;
       
        condition=Pattern.matches("(^(0)+(\\.)?(0)*$){1}", otherNumber);

        return !condition;
    }

	public static boolean isZero(Integer n) {
		if (isNull(n)) {
			return false;
		}

		Integer zero = new Integer(0);

		return (zero).equals(n);
	}

}
