package it.almavivaitalia.web.sh.utils;

import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.form.AbstractForm;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Backup della classe Context Originale

public class ContextLev1 implements BaseSessionAttributes {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private AbstractForm form;

	private String controllerCode;
	private String itemSelectorRequest;

	public String getControllerCode() {
		return controllerCode;
	}

	public String getItemSelectorRequest() {
		return itemSelectorRequest;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void clearDataTable() {
		ContextHelper.clearDataTable(request);
	}

	public String getBaseActionUrl() {
		String url = request.getRequestURL().toString();
		return url.substring(url.lastIndexOf("/") + 1, url.length());
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractForm> T getForm() {
		return (T) form;
	}

	

	public ContextLev1(HttpServletRequest request, HttpServletResponse response,
			AbstractForm form, String controllerCode, String itemSelectorRequest) {
		super();
		this.request = request;
		this.response = response;
		this.form = form;
		this.controllerCode = controllerCode;
		this.itemSelectorRequest = itemSelectorRequest;
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", -1);
	}

	public void setDataModel(String name, Object attribute) {
		ContextHelper.setDataModel(name, attribute, request);
	}

	public void setDataModel(String name, Object attribute, boolean keep) {
		ContextHelper.setDataModel(name, attribute, keep, request);
	}
	
	public void removeDataModel(String name) {
		ContextHelper.removeDataModel(name, request);
	}

	@SuppressWarnings("unchecked")
	public <T extends Object> T getModel(String name) {
		return (T) ContextHelper.getModel(name, request);
	}

	public void ignoreValidationForNextRequest() {
		setDataModel(FLAG_IGNORE_VALIDATION, new Boolean(true));
	}

	public LinkedHashMap<PropertyKey, FieldFormatter> getFieldFormatterMap(
			String fieldFormatterFileName) {
		LinkedHashMap<PropertyKey, FieldFormatter> formatterMap = null;
		Map<String, LinkedHashMap<PropertyKey, FieldFormatter>> map = null;
		try {
			map = getModel(MAP_FIELD_FORMATTER_MAPS);
		} catch (Exception e) {
			throw new RuntimeException("field formatter maps non impostate");
		}
		try {
			formatterMap = map.get(fieldFormatterFileName);
		} catch (Exception e) {
			throw new RuntimeException("field formatter map per "
					+ fieldFormatterFileName + " non impostata");
		}
		return formatterMap;
	}

	/*
	 * public String startItemSelector(List<? extends ItemSelectorElement> list,
	 * String backMethodName){ return startItemSelector(list, null,
	 * backMethodName, ITEM_SELECTOR_TYPE_SINGLE_SELECTOR); }
	 */
//	 public String startItemSelector(List<? extends Object> list,
//			String backMethodName, String fieldFormatterFileName) {
//
//		return startItemSelector(list, null, backMethodName,
//				ITEM_SELECTOR_TYPE_SINGLE_SELECTOR, fieldFormatterFileName);
//	}
//
//	public String startMultiItemSelector(List<? extends Object> list,
//			String backMethodName, String fieldFormatterFileName) {
//		return startItemSelector(list, null, backMethodName,
//				ITEM_SELECTOR_TYPE_MULTIPLE_SELECTOR, fieldFormatterFileName);
//	}
//
//	public String startMultiItemSelector(List<? extends Object> list,
//			List<? extends Object> selectedItems, String backMethodName,
//			String fieldFormatterFileName) {
//		return startItemSelector(list, selectedItems, backMethodName,
//				ITEM_SELECTOR_TYPE_MULTIPLE_SELECTOR, fieldFormatterFileName);
//	}
//
//	public String startMultiItemDeletor(List<? extends Object> list,
//			String backMethodName, String fieldFormatterFileName) {
//		return startItemSelector(list, null, backMethodName,
//				ITEM_SELECTOR_TYPE_MULTIPLE_DELETOR, fieldFormatterFileName);
//	}
//
//	public String startMultiItemOrdinator(List<? extends Object> list,
//			String backMethodName, String fieldFormatterFileName) {
//		return startItemSelector(list, null, backMethodName,
//				ITEM_SELECTOR_TYPE_MULTIPLE_ORDINATOR, fieldFormatterFileName);
//	}
//
//	private String startItemSelector(List<? extends Object> list,
//			List<? extends Object> selectedItems, String backMethodName,
//			String type, String fieldFormatterFileName) {
//		setDataModel(OBJECT_FIELD_FORMATTER_MAP,
//				getFieldFormatterMap(fieldFormatterFileName));
//		removeDataModel(LIST_SELECTOR_ITEM_REMOVED);
//		if (selectedItems != null) {
//			setDataModel(LIST_SELECTOR_ITEM_SELECTED, selectedItems);
//		} else {
//			setDataModel(LIST_SELECTOR_ITEM_SELECTED, new ArrayList<Object>());
//		}
//
//		if (type.equals(ITEM_SELECTOR_TYPE_MULTIPLE_DELETOR)
//				|| type.equals(ITEM_SELECTOR_TYPE_MULTIPLE_ORDINATOR)) {
//			setDataModel(LIST_SELECTOR_ITEM_REMOVED, new ArrayList<Object>());
//		}
//		setDataModel(FLAG_SELECTOR_TYPE, type);
//		setDataModel(LIST_SELECTOR_ITEM, list);
//		setDataModel(OBJECT_INCOMING_REQUEST_URI, request.getRequestURI());
//		setDataModel(OBJECT_SELECTOR_BACK_METHOD_NAME, backMethodName);
//		cacheForm();
//		return "redirect:/" + itemSelectorRequest;
//	}
//
//	public String backItemSelector() {
//		removeDataModel(OBJECT_FIELD_FORMATTER_MAP);
//
//		String type = getModel(FLAG_SELECTOR_TYPE);
//		if (type.equals(ITEM_SELECTOR_TYPE_MULTIPLE_ORDINATOR)) {
//			setDataModel(LIST_SELECTOR_ITEM_SELECTED,
//					getModel(LIST_SELECTOR_ITEM));
//		}
//		removeDataModel(FLAG_SELECTOR_TYPE);
//		String requestURI = (String) getModel(OBJECT_INCOMING_REQUEST_URI);
//		removeDataModel(OBJECT_INCOMING_REQUEST_URI);
//		String methodName = (String) getModel(OBJECT_SELECTOR_BACK_METHOD_NAME);
//		removeDataModel(OBJECT_SELECTOR_BACK_METHOD_NAME);
//		String view = requestURI.substring(requestURI.lastIndexOf("/"),
//				requestURI.length());
//
//		Object anchorObject = getModel(OBJECT_ANCHOR);
//		String anchor = "";
//		if (!Util.isEmpty(anchorObject)) {
//			anchor = "#" + (String) anchorObject;
//		}
//
//		return "redirect:" + view + "?"
//				+ COMMAND_BACK_SELECTOR_REQUEST_PARAMETER + "=" + methodName
//				+ anchor;
//	}
//
//	public AbstractTO getSelectedItem() {
//		@SuppressWarnings("rawtypes")
//		List list = (List) getModel(LIST_SELECTOR_ITEM_SELECTED);
//		removeDataModel(LIST_SELECTOR_ITEM_SELECTED);
//		if (Util.isEmpty(list)) {
//			return null;
//		} else {
//			return (AbstractTO) list.get(0);
//		}
//
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<? extends Object> getSelectedItems() {
//		@SuppressWarnings("rawtypes")
//		List list = (List) getModel(LIST_SELECTOR_ITEM_SELECTED);
//		removeDataModel(LIST_SELECTOR_ITEM_SELECTED);
//		return list;
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<? extends Object> getRemovedItems() {
//		@SuppressWarnings("rawtypes")
//		List list = (List) getModel(LIST_SELECTOR_ITEM_REMOVED);
//		removeDataModel(LIST_SELECTOR_ITEM_REMOVED);
//		return list;
//	}
//
//	public String getQueryStringParameter(String key) {
//		return request.getParameter(key);
//	}
//
//	public String getCommandParameter(String key) {
//		return request.getParameter(COMMAND_BUTTON_PREFIX_GET + key);
//	}
//
//	public String getMethodParameter() {
//		if (controllerCode != null) {
//			if (request.getMethod().toUpperCase().equals("GET")) {
//				return request.getParameter(COMMAND_BUTTON_PREFIX_GET
//						+ controllerCode);
//			} else {
//				return request.getParameter(COMMAND_BUTTON_PREFIX_POST
//						+ controllerCode);
//			}
//		} else {
//			return null;
//		}
//	}
//
//	public void addError(String code, String... args) {
//		ContextHelper.addError(request, code, args);
//	}
//
//	public void addWarning(String code, String... args) {
//		ContextHelper.addWarning(request, code, args);
//	}
//
//	public void addInfo(String code, String... args) {
//		ContextHelper.addInfo(request, code, args);
//	}
//
//	public boolean hasErrors() {
//		return !ContextHelper.getPageMessages(request).getErrors().isEmpty();
//	}
//
//	public AbstractTO valorizeAudit(AbstractTO to, String codiAction) {
//		to.setRowCreatedDttm(Calendar.getInstance().getTime());
//		to.setRowCreatedForm(codiAction);
//		to.setRowCreatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER,
//				request)).getCodiUtente());
//		to.setRowUpdatedDttm(Calendar.getInstance().getTime());
//		to.setRowUpdatedForm(codiAction);
//		to.setRowUpdatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER,
//				request)).getCodiUtente());
//
//		return to;
//	}
//
//	public UtenteTO getUser() {
//		Object o = ContextHelper.getModel(OBJECT_USER, request);
//		UtenteTO utenteTO = null;
//		if (o != null)
//			utenteTO = (UtenteTO) ContextHelper.getModel(OBJECT_USER, request);
//		return utenteTO;
//	}
//
//	public OutputStream getOutputStream() throws Throwable {
//		return response.getOutputStream();
//	}
//
//	public String startExport(List<? extends TableModel> model, String type) {
//		setDataModel(LIST_FILE_EXPORT, model);
//		setDataModel(OBJECT_FILE_EXPORT_TYPE, type);
//		setDataModel(IGNORE_VIEW_CACHING, new Boolean(true));
//		return "redirect:/fileExport.do";
//	}
//
//	public void setCurrentNode(String absoluteNodeId, String... labelParams) {
//		NTree navigator = (NTree) ContextHelper.getModel(NAVIGATOR, request);
//		if (navigator != null) {
//			NLink current = navigator.getNodeById(absoluteNodeId);
//			if (current == null) {
//				addError("error.invalidNavigationNode", absoluteNodeId,
//						getBaseActionUrl());
//			} else {
//				current.setLabelParams(labelParams);
//				request.getSession().setAttribute(NODE_NAVIGATOR_CURRENT,
//						current);
//			}
//		}
//	}
//
//	public void setCurrentNodeWithUri(String absoluteNodeId, String uri,
//			String... labelParams) {
//		NTree navigator = (NTree) ContextHelper.getModel(NAVIGATOR, request);
//		if (navigator != null) {
//			NLink current = navigator.getNodeById(absoluteNodeId);
//			if (current == null) {
//				addError("error.invalidNavigationNode", absoluteNodeId,
//						getBaseActionUrl());
//			} else {
//				current.setLabelParams(labelParams);
//				current.setUri(uri);
//				request.getSession().setAttribute(NODE_NAVIGATOR_CURRENT,
//						current);
//			}
//		}
//	}
//
//	public void setRequestModel(String name, Object attribute) {
//		ContextHelper.setRequestModel(name, attribute, request);
//	}
//
//	// NOTA: if relPath is a directory it must end with "/"
//	public String getRealPath(String relPath) {
//		String webINFPath = this.getClass().getClassLoader().getResource("").getPath();
//		
//		String separatorChar = "";
//		if (webINFPath.indexOf("\\") != -1 )
//		{
//			separatorChar = "\\";
//		}	
//		else if (webINFPath.indexOf("/") != -1 )
//		{
//			separatorChar = "/";
//		}	
//		String webInfCla = separatorChar + "WEB-INF" + separatorChar + "classes" + separatorChar;
//		String contextAbsolutePath = webINFPath.substring(0, webINFPath.indexOf(webInfCla));
//		String out = contextAbsolutePath + relPath;
//
//		File fileAppo = new File(out);
//		if (	fileAppo.isDirectory()
//				&& !out.endsWith(separatorChar) 
//			)
//		{	
//			out = out + separatorChar;
//		}	
//		
//		return (out!=null? out.trim() : out);
//	}
//
//	public String forwardToMethod(String url, String controllerCode,
//			String anchor) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("redirect:/" + url);
//		if (controllerCode != null) {
//			sb.append("?" + COMMAND_BUTTON_PREFIX_GET + controllerCode + "=1");
//		}
//		if (anchor != null) {
//			sb.append("#" + anchor);
//		}
//		return sb.toString();
//	}
//
//	public String buildUri(String url, String controllerCode,
//			String controllerCodeValue) {
//		StringBuffer sb = new StringBuffer();
//		sb.append(url);
//		if (controllerCode != null) {
//			sb.append("?" + COMMAND_BUTTON_PREFIX_GET + controllerCode + "="
//					+ controllerCodeValue);
//		}
//		return sb.toString();
//	}

}
