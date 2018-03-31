package it.almavivaitalia.bsn.sh.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ReflectionUtil {

	// map (chiave valore delle properties per cui esiste get e set)
	public static Map<String, Object> getBeanPropertiesMap(Object main)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (main != null) {
			Method[] ms = main.getClass().getDeclaredMethods();
			if (ms != null) {
				for (int i = 0; i < ms.length; i++) {
					String mName = ms[i].getName();
					if (mName.startsWith("get") || mName.startsWith("is")) {
						int prefixLen = 0;
						if (mName.startsWith("get")) {
							prefixLen = 3;
						} else {
							prefixLen = 2;
						}
						String pName = ("" + mName.charAt(prefixLen))
								.toLowerCase()
								+ mName.substring(prefixLen + 1, mName.length());
	
						String setterName = getSetterMethodName(pName);
						Class<?>[] args = new Class[1];
						args[0] = ms[i].getReturnType();
						Method mSet = null;
						try {
							mSet = main.getClass().getMethod(setterName, args);
						} catch (Exception e) {
	
						}
	
						if (mSet != null) {
							map.put(pName, getPropertyValue(pName, main));
						}
					}
				}
			}
		}
		return map;
	}

	// lista delle properties per cui esiste get e set
	public static List<String> getBeanPropertiesObject(Object main) {
		List<String> properties = new ArrayList<String>();
		if (main != null) {
			Method[] ms = main.getClass().getDeclaredMethods();
			if (ms != null) {
				for (int i = 0; i < ms.length; i++) {
					String mName = ms[i].getName();
					if (mName.startsWith("get") || mName.startsWith("is")) {
						int prefixLen = 0;
						if (mName.startsWith("get")) {
							prefixLen = 3;
						} else {
							prefixLen = 2;
						}
						String pName = ("" + mName.charAt(prefixLen))
								.toLowerCase()
								+ mName.substring(prefixLen + 1, mName.length());
	
						String setterName = getSetterMethodName(pName);
						Class<?>[] args = new Class<?>[1];
						args[0] = ms[i].getReturnType();
						Method mSet = null;
						try {
							mSet = main.getClass().getMethod(setterName, args);
						} catch (Exception e) {
	
						}
	
						if (mSet != null) {
							properties.add(pName);
						}
					}
				}
			}
		}
		return properties;
	}

	public static String getClassName(Object obj) {
		return obj.getClass().getName();
	}

	public static Object getConstantValue(String fullConstantName)
			throws Exception {
		String className = fullConstantName.substring(0,
				fullConstantName.lastIndexOf("."));
		String constantName = fullConstantName.substring(
				fullConstantName.lastIndexOf(".") + 1,
				fullConstantName.length());
		@SuppressWarnings("rawtypes")
		Class c = Class.forName(className);
		Field f = c.getField(constantName);
		return f.get(c.newInstance());
	}

	public static String getGetterMethodName(String property) {
		return getMethodName("get", property);
	}

	public static String getIsMethodName(String property) {
		return getMethodName("is", property);
	}

	private static String getMethodName(String methodType, String property) {
		StringBuffer methodName = new StringBuffer();
		methodName.append(methodType);
		methodName.append(property.substring(0, 1).toUpperCase());
		methodName.append(property.substring(1, property.length()));
		return methodName.toString();
	}

	public static Properties getPropertiesFromClasspath(String propFileName)
			throws IOException {
		InputStream inputStream = Util.class.getClassLoader()
				.getResourceAsStream(propFileName);
		if (inputStream == null) {
			throw new FileNotFoundException("property file '" + propFileName
					+ "' not found in the classpath");
		}
		Properties props = new Properties();
		props.load(inputStream);
		return props;
	}

	public static Object getPropertyValue(String property, Object main)
			throws Exception {
		Object o = null;
		String finalProperty = null;
		if (property.indexOf(".") > 0) {
			String firstProperty = property.substring(0, property.indexOf("."));
			finalProperty = property.substring(property.indexOf(".") + 1,
					property.length());
			o = getSinglePropertyValue(firstProperty, main);
			return getPropertyValue(finalProperty, o);
		} else {
			return getSinglePropertyValue(property, main);
		}
	}

	public static String getSetterMethodName(String property) {
		return getMethodName("set", property);
	}

	private static Object getSinglePropertyValue(String property, Object main)
			throws Exception {
		Object o = null;
	
		if ((main != null) && (property != null)) {
			Method method = null;
			try {
				method = main.getClass().getMethod(
						getGetterMethodName(property), new Class[] {});
			} catch (Exception e) {
				method = main.getClass().getMethod(getIsMethodName(property),
						new Class[] {});
			}
			o = method.invoke(main, new Object[] {});
		}
	
		return o;
	}

	public static void setPropertyValue(String property, Object main,
			Object value) throws Exception {
		if (property.indexOf(".") > 0) {
			String firstProperty = property.substring(0, property.indexOf("."));
			Method getMethod = main.getClass().getMethod(
					getGetterMethodName(firstProperty), new Class[] {});
			Object o = getMethod.invoke(main, new Object[] {});
			if (o == null) {
				o = getMethod.getReturnType().newInstance();
			}
			setSinglePropertyValue(firstProperty, main, o);
			String finalProperty = property.substring(
					property.indexOf(".") + 1, property.length());
			setPropertyValue(finalProperty, o, value);
		} else {
			setSinglePropertyValue(property, main, value);
		}
	}

	public static void setSinglePropertyValue(String property, Object main,
			Object value) throws Exception {
		Method getMethod = null;
		try {
			getMethod = main.getClass().getMethod(
					getGetterMethodName(property), new Class[] {});
		} catch (Exception e) {
			getMethod = main.getClass().getMethod(getIsMethodName(property),
					new Class[] {});
		}
		Method setMethod = main.getClass().getMethod(
				getSetterMethodName(property),
				new Class[] { getMethod.getReturnType() });
		setMethod.invoke(main, new Object[] { value });
	}
	
}
