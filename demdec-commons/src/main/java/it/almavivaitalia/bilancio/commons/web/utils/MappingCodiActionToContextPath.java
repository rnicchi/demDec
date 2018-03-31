package it.almavivaitalia.bilancio.commons.web.utils;

import java.util.HashMap;
import java.util.Map;

public final class MappingCodiActionToContextPath {
	private final static String SBSJ="SBSJ";
	
	public static final Map<String,String> FROM_CODI_ACTION_TO_URL=new HashMap<String,String>();
	public static final Map<String,String> FROM_CODI_ACTION_TO_CONTEXT_PATH=new HashMap<String,String>();
	static{
		//
		FROM_CODI_ACTION_TO_URL.put(SBSJ,CommonConstantsRequestMapping.REDIRECT_URL);
		
		//
		FROM_CODI_ACTION_TO_CONTEXT_PATH.put(SBSJ, "sbsj-web");
	}
}
