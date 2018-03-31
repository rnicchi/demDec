package it.almavivaitalia.bilancio.commons.utils;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

public abstract class BeanUtils extends org.springframework.beans.BeanUtils{
	private static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}	
	
	public static void copyProperties(Object source, Object target, boolean ignoreNullProperties) throws BeansException {
		if(ignoreNullProperties){
			BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
		}else{
			BeanUtils.copyProperties(source, target);
		}
		
	}
	
	public static void updateField(String fieldName, String fieldValue, Object dest) throws IllegalArgumentException, IllegalAccessException,SecurityException, NoSuchFieldException, SQLException {
		Class<?> c = dest.getClass();
		
		Field f = getField(c, fieldName);
		
		if(f!=null){
			f.setAccessible(true);
			f.set(dest, fieldValue);
		}
	}
	
	private static Field getField(Class<?> type, String fieldDestName) {
		Field f=null;

		try {
			f = type.getDeclaredField(fieldDestName);
		} catch (Exception e1) {

		}
		
        while(((type=type.getSuperclass()) != null)&&f==null) {
            try {
				f=type.getDeclaredField(fieldDestName);
			} catch (Exception e) {
				
			}
        }			

        return f;
    }
}
