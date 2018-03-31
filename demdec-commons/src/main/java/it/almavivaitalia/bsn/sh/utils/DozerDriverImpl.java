package it.almavivaitalia.bsn.sh.utils;

import it.almavivaitalia.bsn.sh.paginator.Paginator;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class DozerDriverImpl extends AbstractDozerDriverImpl implements DozerDriver {

	private List<String> defaults;
	private String defaultPath;
	
	public void setDefaults(List<String> def) {
		defaults = def;
//		System.out.println(defaults);
	}

	public void setDefaultPath(String defPath) {
		defaultPath = defPath;
//		System.out.println(defaultPath);
	}

	
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	public <T extends Object, S extends Object> T map(S source,
			Class<T> destType, boolean excludeDefaults, String mappingFiles) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(createMappings(!excludeDefaults, mappingFiles));
		return (T) mapper.map(source, destType);
	}

	
//	public <T extends Object, S extends Object> T map(S source,
//			Class<T> destType, String mappingFiles) {
//		return map(source,destType, false,mappingFiles);
//	}

	// solo se i file sono identici
	/*
	public <T extends Object, S extends Object> void map(S source,
			T dest) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		 mapper.map(source, dest);
	}
	*/
	// solo se i file sono identici
	public <T extends Object, S extends Object> void map(S source,
			T dest, boolean excludeDefaults, String mappingFiles) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(createMappings(!excludeDefaults, mappingFiles)); 
		mapper.map(source, dest);
	}
//	// solo se i file sono identici
//	public <T extends Object, S extends Object> void map(S source,
//			T dest, String mappingFiles) {
//		map(source,dest, false, mappingFiles);
//	}

	

	// solo se i file sono identici
	/*
	public <T extends Object, S extends Object> T map(S source,
			Class<T> destType) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		return mapper.map(source, destType);
	}
*/
	public void init(){
		if (defaults!=null){
			for (int i=0; i<defaults.size(); i++) {
				defaults.set(i, defaultPath+defaults.get(i));
			}
		}
	}
	

	private List<String> createMappings(boolean includeDefaults, String... mappingFiles) {
		List<String> _mappingFiles=new ArrayList<String>();;
		if ((includeDefaults)&&(defaults!=null)){
			_mappingFiles.addAll(defaults);
		}
		
		if (mappingFiles.length > 0) {
			for (int i = 0; i < mappingFiles.length; i++) {
				_mappingFiles.add(defaultPath + mappingFiles[i] + ".xml");
			}
		}
		return _mappingFiles;
	}
	
	/* PATH DINAMICO */
	private List<String> createFullPathMappings(boolean includeDefaults,String path, String... mappingFiles) {
		List<String> _mappingFiles=new ArrayList<String>();;
		if ((includeDefaults)&&(defaults!=null)){
			_mappingFiles.addAll(defaults);
		}
		
		if (mappingFiles.length > 0) {
			for (int i = 0; i < mappingFiles.length; i++) {
				_mappingFiles.add(path + mappingFiles[i] + ".xml");
			}
		}
		return _mappingFiles;
	}

	public <T extends Object> List<T> mapList(List<? extends Object> sources,
			Class<T> destType, boolean excludeDefaults, String mappingFiles) {
		List<T> outputList = new ArrayList<T>();
		if ((sources != null) && (!sources.isEmpty())) {
			DozerBeanMapper mapper = new DozerBeanMapper();
			mapper.setMappingFiles(createMappings(!excludeDefaults, mappingFiles));
			for (Object source : sources) {
				outputList.add(mapper.map(source, destType));
			}
		}
		return outputList;
	}
	
	/* PATH DINAMICO */
	@Override
	public <T extends Object> List<T> mapList(List<? extends Object> sources,
			Class<T> destType, boolean excludeDefaults,String path, String mappingFiles) {
		List<T> outputList = new ArrayList<T>();
		if ((sources != null) && (!sources.isEmpty())) {
			DozerBeanMapper mapper = new DozerBeanMapper();
			mapper.setMappingFiles(createFullPathMappings(!excludeDefaults, path , mappingFiles));
			for (Object source : sources) {
				outputList.add(mapper.map(source, destType));
			}
		}
		return outputList;
	}
	/* PATH DINAMICO */
	@Override
	public <T extends Object, S extends Object> T map(S source,
			Class<T> destType, boolean excludeDefaults,String path, String mappingFiles) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(createFullPathMappings(!excludeDefaults,path, mappingFiles));
		return (T) mapper.map(source, destType);
	}
	
	/* MAPPAGGIO 1:1 */
//	@Override
//	public <T extends Object> List<T> mapList(List<? extends Object> sources,
//			Class<T> destType, boolean excludeDefaults) {
//		List<T> outputList = new ArrayList<T>();
//		if ((sources != null) && (!sources.isEmpty())) {
//			DozerBeanMapper mapper = new DozerBeanMapper();
//			for (Object source : sources) {
//				outputList.add(mapper.map(source, destType));
//			}
//		}
//		return outputList;
//	}
	/* MAPPAGGIO 1:1 */
//	@Override
//	public <T extends Object, S extends Object> T map(S source,
//			Class<T> destType, boolean excludeDefaults) {
//		DozerBeanMapper mapper = new DozerBeanMapper();
//		return (T) mapper.map(source, destType);
//	}
//
//	public <T extends Object> List<T> mapList(List<? extends Object> sources,
//			Class<T> destType, String mappingFiles) {
//		return mapList( sources, destType, false, mappingFiles);
//	}
	
	public <T extends Object> List<T> mapList(List<? extends Object> sources,
			Class<T> destType, boolean excludeDefaults, Paginator paginator, String mappingFiles) {
		List<T> outputList = new ArrayList<T>();
		if ((sources != null) && (!sources.isEmpty())) {
			paginator.setNumberOfElements(sources.size());
			DozerBeanMapper mapper = new DozerBeanMapper();
			mapper.setMappingFiles(createMappings(!excludeDefaults, mappingFiles));
			
			int lastIndex = Math.min(paginator.getFirstResultIndex()+paginator.getPageSize(), sources.size());
			for(int i=paginator.getFirstResultIndex(); i<lastIndex; i++){
				Object source = sources.get(i);
				outputList.add(mapper.map(source, destType));
			}
		}else {
			paginator.setNumberOfElements(0);
		}
		return outputList;
	}
	
//	public <T extends Object> List<T> mapList(List<? extends Object> sources,
//			Class<T> destType, Paginator paginator, String mappingFiles) {
//	
//		return mapList( sources, destType, false, paginator, mappingFiles);
//	}
	
}
