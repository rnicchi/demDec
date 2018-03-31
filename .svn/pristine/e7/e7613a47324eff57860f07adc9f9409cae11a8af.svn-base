package it.almavivaitalia.bilancio.commons.web.utils;

import it.almavivaitalia.web.sh.datatype.DataType;

public class SelectorUtils {
	@SuppressWarnings("unchecked")
	public static DataType getDataType(String className, String typeName) throws ClassNotFoundException {
		@SuppressWarnings("rawtypes")
		final Class<Enum> clazz = (Class<Enum>) Class.forName(className);

		DataType type = (DataType) Enum.valueOf(clazz, typeName);

		return type;
	}
}
