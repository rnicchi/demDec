package it.almavivaitalia.bsn.sh.utils;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.getBeanPropertiesMap;
import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.getBeanPropertiesObject;
import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.getPropertyValue;
import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.setPropertyValue;
import static it.almavivaitalia.bsn.sh.utils.ReflectionUtilLev2.mergeSelectedTypes;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Util {

	// presuppone costruttore di default e oggetti della stessa classe
	// agisce sulle proprietà di bean (per cui esiste get e set)
	// il primo oggetto è prevalente
	public static Object mergeBeans(Object o1, Object o2) throws Exception {
		return mergeSelectedTypes(o1, o2, null);
	}

	// presuppone costruttore di default e oggetti della stessa classe
	// agisce sulle proprietà di bean (per cui devono esistere get e set)
	// il secondo oggetto è prevalente (vengono sovrascitte le proprietà del
	// primo oggetto sui types indicati)
	// il merge avviene solo sui tipi indicati in types
	public static Object overrideSelectedTypes(Object o1, Object o2,
			Class<?>[] types) throws Exception {
		Object o3 = o1.getClass().newInstance();
		if (o1 != null) {
			List<String> ps = getBeanPropertiesObject(o1);
			if (!isEmpty(ps)) {
				for (Iterator<String> iterator = ps.iterator(); iterator
						.hasNext();) {
					String pName = iterator.next();
					Object value = getPropertyValue(pName, o1);

					if (o2 != null) {
						Object value2 = getPropertyValue(pName, o2);
						if (types == null) {
							value = value2;
						} else {
							if (value != null) {
								if (isInArray(types, value.getClass())) {
									value = value2;
								}
							} else {
								if (value2 != null) {
									if (isInArray(types, value2.getClass())) {
										value = value2;
									}
								}
							}
						}
					}
					setPropertyValue(pName, o3, value);
				}
			}
		}
		return o3;
	}

	// presuppone costruttore di default e oggetti della stessa classe
	// agisce sulle proprietà di bean (per cui devono esistere get e set)
	// copia sul nuovo oggetto solo i tipi indicati
	public static Object copySelectedTypes(Object o, Class<?>[] types)
			throws Exception {
		Object o1 = o.getClass().newInstance();

		Map<String, Object> map = getBeanPropertiesMap(o);
		for (Iterator<String> keys = map.keySet().iterator(); keys.hasNext();) {
			String pName = keys.next();
			Object value = getPropertyValue(pName, o);
			if (value != null) {
				Class<?> type = value.getClass();
				boolean copyPermitted = false;
				if ((types == null) || (types.length == 0)) {
					copyPermitted = true;
				} else {
					copyPermitted = isInArray(types, type);
				}
				if (copyPermitted) {
					setPropertyValue(pName, o1, value);
				}
			}
		}
		return o1;
	}

	// presuppone costruttore di default e oggetti della stessa classe
	// agisce sulle proprietà di bean (per cui devono esistere get e set)
	// copia sul nuovo oggetto tutte le bean property
	public static Object copyBean(Object o) throws Exception {
		return copySelectedTypes(o, null);
	}

	public static String blank(Object s) {
		if (s == null) {
			return "";
		} else {
			return s.toString();
		}
	}

	public static String nullBlank(Object s) {
		if (isEmpty(s)) {
			return null;
		} else {
			return s.toString();
		}
	}

	public static <T extends Object> List<T> removeAll(
			List<T> listToRemoveFrom, List<T> itemsToRemove) {

		List<T> copyofListToRemoveFrom = new ArrayList<T>();
		copyofListToRemoveFrom.addAll(listToRemoveFrom);

		@SuppressWarnings("unused")
		boolean changed = copyofListToRemoveFrom.removeAll(itemsToRemove);
		return copyofListToRemoveFrom;
	}

	public static BigDecimal arrotondaMigliaiaEuro(
			BigDecimal valoreDaArrotondare) {

		BigDecimal impoVarcompEur = BigDecimal.ZERO.add(valoreDaArrotondare);
		int segno = impoVarcompEur.signum();
		int nCifreInt = new Integer(impoVarcompEur.abs().intValue()).toString()
				.length();

		if (nCifreInt > 3) {

			MathContext mc = new MathContext(nCifreInt - 3,
					RoundingMode.HALF_UP);
			BigDecimal migliaia = impoVarcompEur.divide(new BigDecimal(1000));
			BigDecimal arr = migliaia.abs().round(mc);
			impoVarcompEur = arr.multiply(new BigDecimal(1000)).multiply(
					new BigDecimal(segno));
		}

		else {

			if (impoVarcompEur.abs().intValue() >= 500) {
				impoVarcompEur = new BigDecimal(1000).multiply(new BigDecimal(
						segno));
			} else {
				impoVarcompEur = BigDecimal.ZERO;
			}
		}
		return impoVarcompEur;
	}

	public static void copyFileFromTo(String sourcePath, String destinationPath)
			throws Throwable {
		FileInputStream fis = new FileInputStream(sourcePath);
		FileOutputStream fos = new FileOutputStream(destinationPath);
		byte[] b = new byte[1024];
		int read = fis.read(b);
		while (read > 0) {
			fos.write(b, 0, read);
			read = fis.read(b);
		}
		fos.flush();
		fos.close();
		fis.close();
	}

	public static boolean isInArray(Object[] array, Object o) {
		boolean isIn = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(o)) {
				isIn = true;
				break;
			}
		}
		return isIn;
	}

	public static boolean isEmptyOrZero(String o){
		if (o==null){
			return true;
		}
		return o.isEmpty()||o.equals("0");
	}
	
}
