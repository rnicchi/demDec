package it.almavivaitalia.bsn.sh.utils;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import static it.almavivaitalia.bsn.sh.utils.Util.isInArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class ReflectionUtilLev2 extends ReflectionUtil {

	/**
	 * Verifica l'esistenza di un metodo su un oggetto
	 * 
	 * @param o
	 *            L'oggetto su cui eseguire il metodo
	 * @param m
	 *            Il nome del metodo da verificare
	 * @param param
	 *            Array contenente i parametri da passare al metodo nell'ordine
	 *            corretto
	 * @return True se in metodo esiste, altrimenti false
	 */
	public static boolean existsMethod(Object o, String m, Object[] param) {
	
		try {
			Class<?>[] classi = new Class[param.length];
			for (int i = 0; i < param.length; i++) {
				classi[i] = param[i].getClass();
			}
	
			o.getClass().getMethod(m, classi);
	
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static InputStream getInputStreamFromClasspath(String name)
			throws IOException {
		return Util.class.getClassLoader().getResourceAsStream(name);
	}

	// presuppone costruttore di default e oggetti della stessa classe
	// agisce sulle proprietà di bean (per cui esiste get e set)
	// il primo oggetto è prevalente (NON vengono sovrascitte le proprietà se
	// diverse da null)
	// il merge avviene solo sui tipi indicati in types
	public static Object mergeSelectedTypes(Object o1, Object o2,
			Class<?>[] types) throws Exception {
		Object o3 = o1.getClass().newInstance();
		if (o1 != null) {
			List<String> ps = getBeanPropertiesObject(o1);
			if (!isEmpty(ps)) {
				for (Iterator<String> iterator = ps.iterator(); iterator
						.hasNext();) {
					String pName = iterator.next();
					Object value = getPropertyValue(pName, o1);
					if ((o2 != null) && (isEmpty(value))) {
						Object value2 = getPropertyValue(pName, o2);
						if (!isEmpty(value2)) {
							if (types == null) {
								value = value2;
							} else {
								if (isInArray(types, value.getClass())) {
									value = value2;
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

}
