package it.almavivaitalia.bilancio.commons.utils;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

public class BooleanUtil extends AbstractBooleanUtil{

	/*public static Object operatoreTernario(boolean test, Object ok, Object ko){
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
	}*/
	
    public static boolean isZero(BigDecimal other) {

        if(isNull(other)){
            return false;
        }

        String otherNumber=other.toString();
      
        return Pattern.matches("(^(0)+(\\.)?(0)*$){1}", otherNumber);
    }

	public static boolean isNegative(BigDecimal n) {
		return !isNull(n) && (n.compareTo(new BigDecimal(0))) == -1;
	}

	public static boolean isGreaterThan(BigDecimal a, BigDecimal b) {
		return (a.abs().compareTo(b.abs()) == 1);
	}

	public static boolean isNegative(Integer n) {
		return !isNull(n) && (n.compareTo(new Integer(0))) == -1;
	}

	public static boolean testANDCondition(boolean... operands) {

		boolean cnd = true;

		for (boolean operand : operands) {
			if (!operand) {
				return false;
			}
		}

		return cnd;
	}

	public static boolean testORCondition(boolean... operands) {
		boolean cnd = false;

		for (boolean operand : operands) {
			if (operand) {
				return true;
			}
		}

		return cnd;
	}

	public static boolean isEmptyList(List<?> list) {
		return (list == null || list.isEmpty());
	}

}
