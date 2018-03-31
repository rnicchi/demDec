package it.almavivaitalia.bsn.sh.utils;

import it.almavivaitalia.bsn.sh.paginator.Paginator;

import java.util.List;

public interface DozerDriver {
	
	//public final static String DEFAULT_PATH="it/mef/bilancio/nssb/manager/dozer/";
	

	//public <T extends Object, S extends Object> T map(S source, Class<T> destType, String... mappingFiles);
	public <T extends Object, S extends Object> T map(S source, Class<T> destType, String mappingFiles);
	public <T extends Object, S extends Object> T map(S source, Class<T> destType, boolean excludeDefaults, String mappingFiles);
	
	// solo se i file sono identici
	//public <T extends Object, S extends Object> T map(S source, Class<T> destType);

	
	//public <T extends Object> List<T> mapList(List<? extends Object> sources, Class<T> destType, String... mappingFiles);
	public <T extends Object> List<T> mapList(List<? extends Object> sources, Class<T> destType, String mappingFiles);
	public <T extends Object> List<T> mapList(List<? extends Object> sources, Class<T> destType,  boolean excludeDefaults, String mappingFiles);
	
	public <T extends Object> List<T> mapList(List<? extends Object> sources, Class<T> destType, Paginator paginator, String mappingFiles);
	public <T extends Object> List<T> mapList(List<? extends Object> sources, Class<T> destType,  boolean excludeDefaults, Paginator paginator,String mappingFiles);
	
	
	//public <T extends Object, S extends Object> void map(S source,T dest);

	
	
	//public <T extends Object, S extends Object> void map(S source, T dest, String... mappingFiles);
	public <T extends Object, S extends Object> void map(S source, T dest, String mappingFiles);
	public <T extends Object, S extends Object> void map(S source, T dest,  boolean excludeDefaults, String mappingFiles);
	
	/* PATH DINAMICO */
	public <T extends Object> List<T> mapList(List<? extends Object> sources,
			Class<T> destType, boolean excludeDefaults,String path, String mappingFiles);
	/* PATH DINAMICO */
	public <T extends Object, S extends Object> T map(S source,
			Class<T> destType, boolean excludeDefaults,String path, String mappingFiles);
	
	/* MAPPAGGIO 1:1 */
	public <T extends Object> List<T> mapList(List<? extends Object> sources,
			Class<T> destType, boolean excludeDefaults);
	/* MAPPAGGIO 1:1 */
	public <T extends Object, S extends Object> T map(S source,
			Class<T> destType, boolean excludeDefaults);
}
