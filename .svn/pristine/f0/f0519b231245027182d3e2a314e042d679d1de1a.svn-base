package it.almavivaitalia.bsn.sh.utils;

import java.util.Map;

public class TableMap {
	private Map<Object,Object> map;

	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}

	@SuppressWarnings("unchecked")
	public <K extends Object, V extends Object> V getValue(K key){
		return (V)map.get(key);
	}

}
