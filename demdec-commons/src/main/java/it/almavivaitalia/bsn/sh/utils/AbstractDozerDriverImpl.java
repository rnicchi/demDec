package it.almavivaitalia.bsn.sh.utils;

import it.almavivaitalia.bsn.sh.paginator.Paginator;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public abstract class AbstractDozerDriverImpl implements DozerDriver {


	public <T extends Object, S extends Object> T map(S source,
			Class<T> destType, String mappingFiles) {
		return map(source,destType, false,mappingFiles);
	}

	
	// solo se i file sono identici
	public <T extends Object, S extends Object> void map(S source,
			T dest, String mappingFiles) {
		map(source,dest, false, mappingFiles);
	}

	
	/* MAPPAGGIO 1:1 */
	@Override
	public <T extends Object> List<T> mapList(List<? extends Object> sources,
			Class<T> destType, boolean excludeDefaults) {
		List<T> outputList = new ArrayList<T>();
		if ((sources != null) && (!sources.isEmpty())) {
			DozerBeanMapper mapper = new DozerBeanMapper();
			for (Object source : sources) {
				outputList.add(mapper.map(source, destType));
			}
		}
		return outputList;
	}
	/* MAPPAGGIO 1:1 */
	@Override
	public <T extends Object, S extends Object> T map(S source,
			Class<T> destType, boolean excludeDefaults) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		return (T) mapper.map(source, destType);
	}

	public <T extends Object> List<T> mapList(List<? extends Object> sources,
			Class<T> destType, String mappingFiles) {
		return mapList( sources, destType, false, mappingFiles);
	}
	
	
	public <T extends Object> List<T> mapList(List<? extends Object> sources,
			Class<T> destType, Paginator paginator, String mappingFiles) {
	
		return mapList( sources, destType, false, paginator, mappingFiles);
	}
	
}
