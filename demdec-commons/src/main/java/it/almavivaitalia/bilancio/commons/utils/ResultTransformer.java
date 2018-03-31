package it.almavivaitalia.bilancio.commons.utils;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtil.setPropertyValue;

import java.util.List;
public class ResultTransformer implements org.hibernate.transform.ResultTransformer {
	
	/*METRICHE*/
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM1 = "LOCM"; 
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM2 = "LOCM";
	
	
	private static final long serialVersionUID = 1L;
	private Class<?> type;
	private RuntimeException re = null;
	
	public ResultTransformer(){}

	public ResultTransformer(Class<?> type) {
		this.type = type;
	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public List transformList(List collection) {
		if (re != null) {
			throw re;
		} else {
			return collection;
		}
	}
	
	protected void setRe(RuntimeException re) {
		this.re = re;
	}

	public Class<?> getType() {
		return type;
	}

	public RuntimeException getRe() {
		return re;
	}

	@Override
	public Object transformTuple(Object[] tuple, String[] aliases) {
		Object o = null;
		try {
			o = type.newInstance();
			for (int i = 0; i < aliases.length; i++) {
				setPropertyValue(aliases[i].replace("_", "."), o, tuple[i]);
			}
		} catch (Throwable e) {
			o = null;
			re = new RuntimeException(e);
			throw re;
		}
		return o;
	}

}
