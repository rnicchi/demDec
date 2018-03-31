package it.almavivaitalia.bilancio.commons.web.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtilLev2.getInputStreamFromClasspath;
import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonWebConstants;
import it.almavivaitalia.bilancio.commons.web.utils.SelectorUtils;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.datatype.DataType;
import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.almavivaitalia.web.sh.utils.PropertyKey;
import it.almavivaitalia.web.sh.utils.Util;
import it.almavivaitalia.web.sh.utils.WebConstants;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class SelectorController extends AbstractCommonFormController {

	private final static String FIELD_FORMATTER_PATH = "it/almavivaitalia/bilancio/commons/web/export/";
	
	private AbstractCommonTO getSelectedItem(Context context) {
		@SuppressWarnings("rawtypes")
		List list = (List) context.getModel(LIST_SELECTOR_ITEM_SELECTED);

		if (isEmpty(list)) {
			return null;
		} else {
			return (AbstractCommonTO) list.get(0);
		}
	}
	
	private void updateForm(Context context) throws Exception{
		String backMethodName=context.getModel(PARAMETER_SELECTOR_BACK_METHOD_NAME);
		Object selected=null;
		
		//AGGIORNO FORM
		if(!StringUtil.isEmpty(backMethodName)){
			selected=getSelectedItem(context);
		}else{
			selected=context.getSelectedItem();
		}
		
		if(selected!=null){
			DataType type=SelectorUtils.getDataType((String)context.getModel("dataTypeClass"), (String)context.getModel("dataTypeName"));
			
			for(String fieldName:type.getOutputFields()){
				String fieldNameDest=(String)context.getModel(WebConstants.OUTPUT+ type.name() + WebConstants.UNDERSCORE+ fieldName);
				
				if(fieldNameDest==null){
					fieldNameDest=fieldName;
					
					context.removeDataModel(WebConstants.OUTPUT+ type.name() + WebConstants.UNDERSCORE+ fieldName);
				}
				
				updateField(selected, getBeanObject(context), fieldName, fieldNameDest);
			}
		}		
	}
	
	public String backToView(Context context) throws Throwable{
		String requestURI = context.getModel(OBJECT_INCOMING_REQUEST_URI_FOR_SELECTOR);
		String backMethodName=context.getModel(PARAMETER_SELECTOR_BACK_METHOD_NAME);
		
		updateForm(context);
		
		Map<String, LinkedHashMap<PropertyKey, FieldFormatter>> fieldFormatterMap=context.getModel(MAP_FIELD_FORMATTER_MAPS);
		
		DataType type=SelectorUtils.getDataType((String)context.getModel("dataTypeClass"), (String)context.getModel("dataTypeName"));
		
		fieldFormatterMap.remove(type.getFieldFormatterFileName());
		
		context.removeDataModel(FIELD_FORMATTER_FILE_NAME);
		context.removeDataModel("dataTypeName");
		context.removeDataModel("dataTypeClass");
		context.removeDataModel(OBJECT_INCOMING_REQUEST_URI_FOR_SELECTOR);
		context.removeDataModel(OBJECT_SELECTOR_BACK_METHOD_NAME_FOR_SELECTOR);
		context.removeDataModel(PARAMETER_SELECTOR_BACK_METHOD_NAME);
		context.removeDataModel(PARAMETER_SELECTOR_BACK_METHOD_NAME);
		
		context.setDataModel(VIEW_CACHED, 		context.getModel(PREV_VIEW_FOR_SELECTOR));
		ContextHelper.setSessionModel(BACK_FROM_SELECTOR, Boolean.TRUE, context.getRequest());
		
		String view = requestURI.substring(requestURI.lastIndexOf(CommonConstantsRequestMapping.SLASH),	requestURI.length());
		
		if(!StringUtil.isEmpty(backMethodName)){
			context.getRequest().getSession().removeAttribute(BACK_FROM_SELECTOR);
			view=view+="?"+BaseSessionAttributes.COMMAND_BACK_SELECTOR_REQUEST_PARAMETER+"="+backMethodName;
		}
		
		Object form = context.getModel(FORM);
		
		if (form != null) {
			context.setDataModel(BaseSessionAttributes.FORM_CACHED, form);
		}
		
		return "redirect:" + view; 

	}
	
	@Override
	public String startController(Context context) throws Throwable {
		String methodName = context.getModel("dataType");// selectorNumeTipo

		methodName = CommonWebConstants.PREFIX_METHOD_NAME
				+ String.valueOf(methodName.toCharArray()[0]).toUpperCase()
				+ methodName.substring(1);
		context.setDataModel(OBJECT_INCOMING_REQUEST_URI_FOR_SELECTOR, context.getModel(OBJECT_INCOMING_REQUEST_URI));
		context.setDataModel(OBJECT_SELECTOR_BACK_METHOD_NAME_FOR_SELECTOR, methodName);
		//context.setDataModel(PREV_VIEW_FOR_SELECTOR, getPreviousView(context));
		context.setDataModel(BEAN_ATTRIBUTE_NAME, context.getRequest().getParameter(BEAN_ATTRIBUTE_NAME));
		context.setDataModel(BEAN_PROPERTIES_FOR_SELECTOR, context.getRequest().getParameter(BEAN_PROPERTIES_FOR_SELECTOR));
		context.setDataModel(BEAN_PROPERTIES_FILTER_FOR_SELECTOR, context.getRequest().getParameter(BEAN_PROPERTIES_FILTER_FOR_SELECTOR));
		context.setDataModel(BACK_VIEW_FOR_SELECTOR, context.getRequest().getParameter(BACK_VIEW_FOR_SELECTOR));
		context.setDataModel(PARAMETER_SELECTOR_BACK_METHOD_NAME, context.getRequest().getParameter(PARAMETER_SELECTOR_BACK_METHOD_NAME));
		context.setDataModel(WebConstants.SUMMARY_SELECTOR_ITEM, context.getRequest().getParameter(SUMMARY_SELECTOR_ITEM));
		context.setDataModel(WebConstants.CAPTION_SELECTOR_ITEM, context.getRequest().getParameter(CAPTION_SELECTOR_ITEM));
				
		if(!isEmpty(context.getRequest().getParameter(FIELD_FORMATTER_FILE_NAME))){
			context.setDataModel(FIELD_FORMATTER_FILE_NAME, context.getRequest().getParameter(FIELD_FORMATTER_FILE_NAME));
		}else{
			DataType type=SelectorUtils.getDataType((String)context.getModel("dataTypeClass"), (String)context.getModel("dataTypeName"));
			
			String fieldFormatterFileName=type.getFieldFormatterFileName();
			
			Map<String, LinkedHashMap<PropertyKey, FieldFormatter>> fieldFormatterMap=context.getModel(MAP_FIELD_FORMATTER_MAPS);
			fieldFormatterMap.put(fieldFormatterFileName, getFieldFormatterMap(fieldFormatterFileName));
			
			context.setDataModel(FIELD_FORMATTER_FILE_NAME, fieldFormatterFileName);
		}
		
		String view = executeActionMethod(methodName, context.getRequest(), context);

		return view;
	}

	private String executeActionMethod(String methodName,HttpServletRequest request, Context context) throws Throwable {
		Method method = null;
		try {
			method = getClass().getMethod(methodName,new Class[] { Context.class });
		} catch (Exception e) {
			throw new Exception("No method found with name " + methodName);
		}
		String res = null;
		try {
			res = (String) method.invoke(this, new Object[] { context });
		} catch (InvocationTargetException e) {
			throw (e.getTargetException());
		}

		return res;
	}

	protected Object getBeanObject(Context context) {
		String beanAttributeName = context.getModel(BEAN_ATTRIBUTE_NAME);
		Object bean = null;
		if (!isEmpty(beanAttributeName)) {
			bean = context.getModel(beanAttributeName);
		}
		if (bean == null) {
			bean = context.getModel(FORM);
		}

		context.setDataModel(FORM_CACHED, bean);

		return bean;
	}

	private String getFieldValue(Object src, String fieldName)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Class<?> c = src.getClass();
		Field f = c.getDeclaredField(fieldName);
		f.setAccessible(true);
		return String.valueOf(f.get(src));
	}

	protected void updateField(Object src, Object dest, String fieldSrcName, String fieldDestName)
			throws IllegalArgumentException, IllegalAccessException,
			SecurityException, NoSuchFieldException {
		
		if (src != null && dest != null) {
			Class<?> c = dest.getClass();
			
			Field f = getField(c, fieldDestName);
			if(f!=null){
				f.setAccessible(true);
				f.set(dest, getFieldValue(src, fieldSrcName));
			}
		}
		
	}
	
	protected static Field getField(Class<?> type, String fieldDestName) {
		Field f=null;

		try {
			f = type.getDeclaredField(fieldDestName);
		} catch (Exception e1) {

		}
		
        while(((type=type.getSuperclass()) != null)&&f==null) {
            try {
				f=type.getDeclaredField(fieldDestName);
			} catch (Exception e) {
				
			}
        }			

        return f;
    }
	
	private static LinkedHashMap<PropertyKey, FieldFormatter> getFieldFormatterMap(
			String xmlName) throws Throwable {
		return Util.unMarshallFieldFormatterMap(getInputStreamFromClasspath(FIELD_FORMATTER_PATH + xmlName + ".xml"));
	}

}
