package it.almavivaitalia.web.sh.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class BaseContextHelper implements BaseSessionAttributes{

	private static Map<String, Object> createDataTable(HttpServletRequest request){
		HashMap<String, Object> dataTable=new HashMap<String, Object>();
		request.getSession(true).setAttribute(DATA_TABLE, dataTable);
		return dataTable;
	}	
	
	@SuppressWarnings("unchecked")
	private static Map<String, Object> getDataTable(HttpServletRequest request){
		Object oDataTable = request.getSession(true).getAttribute(DATA_TABLE);
		if (oDataTable==null){
			return createDataTable(request);
		}else {
			return (HashMap<String, Object>)oDataTable;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static Map<String, Object> getKeepDataTable(HttpServletRequest request){
		Object oDataTable = request.getSession(true).getAttribute(KEEP_DATA_TABLE);
		if (oDataTable==null){
			HashMap<String, Object> dataTable=new HashMap<String, Object>();
			request.getSession(true).setAttribute(KEEP_DATA_TABLE, dataTable);
			return dataTable;
		}else {
			return (HashMap<String, Object>)oDataTable;
		}
	}
	
	private static Object getDataModel(String key, HttpServletRequest request){
		return getDataTable(request).get(key);
	}

	
	public static void setDataModel(String key, Object o, HttpServletRequest request){
		getDataTable(request).put(key, o);
	}
	
	public static void setDataModel(String key, Object o, boolean keep, HttpServletRequest request){
		getDataTable(request).put(key, o);
		
		if(keep){
			getKeepDataTable(request).put(key, o);
		}
	}
	
	public static Object removeDataModel(String key, HttpServletRequest request){
		return getDataTable(request).remove(key);
	}

	@SuppressWarnings("unchecked")
	public static void clearDataTable(HttpServletRequest request){
		getDataTable(request).clear();
		
		Object keepDataTable = request.getSession(true).getAttribute(KEEP_DATA_TABLE);
		
		if (keepDataTable!=null){
			getDataTable(request).putAll((Map<String, Object>)keepDataTable);
		}
	}
	
	public static void clearKeepDataTable(HttpServletRequest request){
		getKeepDataTable(request).clear();
	}	
	
	private static Object getRequestModel(String key, HttpServletRequest request){
		return request.getAttribute(key);
	}
	
	public static void setRequestModel(String key, Object o, HttpServletRequest request){
		request.setAttribute(key, o);
	}
	public static void setSessionModel(String key, Object o, HttpServletRequest request){
		request.getSession().setAttribute(key, o);
	}
	
	public static Object getModel(String key, HttpServletRequest request){
		Object model = getRequestModel(key, request);
		if (model==null){
			model=getDataModel(key, request);
			if (model==null){
				model=request.getSession(true).getAttribute(key);
				if (model==null){
					model=request.getSession(true).getServletContext().getAttribute(key);
				}
			}
		}
		return model;
	}
}
