package it.almavivaitalia.web.sh.utils;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;
import it.almavivaitalia.web.sh.form.AbstractForm;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
public class ContextLev2 extends ContextLev1 {

	public ContextLev2(HttpServletRequest request,
			HttpServletResponse response, AbstractForm form,
			String controllerCode, String itemSelectorRequest) {
		super(request, response, form, controllerCode, itemSelectorRequest);
		
	}

	public void setResponseContentType(String contentType, String nomeFile) {
		getResponse().setContentType(contentType);
		getResponse().addHeader("Content-Disposition", "attachment; filename="
				+ nomeFile);
	}

	private void cacheForm() {
		setDataModel(FORM_CACHED, getForm());
	}

	
	public String startItemSelector(List<? extends Object> list,
			String backMethodName, String fieldFormatterFileName) {

		return startItemSelector(list, null, backMethodName,
				ITEM_SELECTOR_TYPE_SINGLE_SELECTOR, fieldFormatterFileName);
	}

	public String startMultiItemSelector(List<? extends Object> list,
			String backMethodName, String fieldFormatterFileName) {
		return startItemSelector(list, null, backMethodName,
				ITEM_SELECTOR_TYPE_MULTIPLE_SELECTOR, fieldFormatterFileName);
	}

	public String startMultiItemSelector(List<? extends Object> list,
			List<? extends Object> selectedItems, String backMethodName,
			String fieldFormatterFileName) {
		return startItemSelector(list, selectedItems, backMethodName,
				ITEM_SELECTOR_TYPE_MULTIPLE_SELECTOR, fieldFormatterFileName);
	}

	public String startMultiItemDeletor(List<? extends Object> list,
			String backMethodName, String fieldFormatterFileName) {
		return startItemSelector(list, null, backMethodName,
				ITEM_SELECTOR_TYPE_MULTIPLE_DELETOR, fieldFormatterFileName);
	}

	public String startMultiItemOrdinator(List<? extends Object> list,
			String backMethodName, String fieldFormatterFileName) {
		return startItemSelector(list, null, backMethodName,
				ITEM_SELECTOR_TYPE_MULTIPLE_ORDINATOR, fieldFormatterFileName);
	}

	private String startItemSelector(List<? extends Object> list, List<? extends Object> selectedItems, String backMethodName, String type, String fieldFormatterFileName) {
		setDataModel(OBJECT_FIELD_FORMATTER_MAP, getFieldFormatterMap(fieldFormatterFileName));
		
		removeDataModel(LIST_SELECTOR_ITEM_REMOVED);
		
		if (selectedItems != null) {
			setDataModel(LIST_SELECTOR_ITEM_SELECTED, selectedItems);
		} else {
			setDataModel(LIST_SELECTOR_ITEM_SELECTED, new ArrayList<Object>());
		}

		if(type.equals(ITEM_SELECTOR_TYPE_MULTIPLE_DELETOR) || type.equals(ITEM_SELECTOR_TYPE_MULTIPLE_ORDINATOR)) {
			setDataModel(LIST_SELECTOR_ITEM_REMOVED, new ArrayList<Object>());
		}
		setDataModel(FLAG_SELECTOR_TYPE, type);
		setDataModel(LIST_SELECTOR_ITEM, list);
		setDataModel(OBJECT_INCOMING_REQUEST_URI, getRequest().getRequestURI());
		setDataModel(OBJECT_SELECTOR_BACK_METHOD_NAME, backMethodName);
		
		PageMessages messages= ContextHelper.getPageMessages(getRequest());
		String labelForSummary="";
		String labelForCaption="";
		String ambiente=null;
		
		HttpSession session=getRequest().getSession();
		
		if(!StringUtils.isEmpty((String)session.getServletContext().getAttribute(BaseSessionAttributes.AMBIENTE))){
			ambiente=(String)getRequest().getSession().getServletContext().getAttribute(BaseSessionAttributes.AMBIENTE);
		}else{
			ambiente=AMBIENTE_COLL;
		}
		
		try {
			labelForSummary=SUMMARY_PREFIX+fieldFormatterFileName.replaceAll(FORMATTER_SUFFIX, "").toLowerCase();
			
			String summary=messages.getMessageFromBundle(labelForSummary, "");
			
			setDataModel(SUMMARY_SELECTOR_ITEM, summary);
			
		} catch (Exception e) {
			if(AMBIENTE_SVIL.equals(ambiente)){
				messages.addWarning(WarningCodeName.WARNING_EMPTY_SUMMARY, labelForSummary);
			}
			setDataModel(SUMMARY_SELECTOR_ITEM, fieldFormatterFileName.replaceAll(FORMATTER_SUFFIX, ""));
		}
		
		try {
			labelForCaption=CAPTION_PREFIX+fieldFormatterFileName.replaceAll(FORMATTER_SUFFIX, "").toLowerCase();
			
			String caption=messages.getMessageFromBundle(labelForCaption, "");
			
			setDataModel(CAPTION_SELECTOR_ITEM, caption);
		} catch (Exception e) {
			if(AMBIENTE_SVIL.equals(ambiente)){
				messages.addWarning(WarningCodeName.WARNING_EMPTY_CAPTION, labelForCaption);
			}			
			setDataModel(CAPTION_SELECTOR_ITEM, fieldFormatterFileName.replaceAll(FORMATTER_SUFFIX, ""));
		}
		
		cacheForm();
		return "redirect:/" + getItemSelectorRequest();
	}

	public String backItemSelector() {
		removeDataModel(OBJECT_FIELD_FORMATTER_MAP);

		String type = getModel(FLAG_SELECTOR_TYPE);
		if (type.equals(ITEM_SELECTOR_TYPE_MULTIPLE_ORDINATOR)) {
			setDataModel(LIST_SELECTOR_ITEM_SELECTED,
					getModel(LIST_SELECTOR_ITEM));
		}
		removeDataModel(FLAG_SELECTOR_TYPE);
		String requestURI = (String) getModel(OBJECT_INCOMING_REQUEST_URI);
		removeDataModel(OBJECT_INCOMING_REQUEST_URI);
		String methodName = (String) getModel(OBJECT_SELECTOR_BACK_METHOD_NAME);
		removeDataModel(OBJECT_SELECTOR_BACK_METHOD_NAME);
		String view = requestURI.substring(requestURI.lastIndexOf("/"),
				requestURI.length());

		Object anchorObject = getModel(OBJECT_ANCHOR);
		String anchor = "";
		if (!isEmpty(anchorObject)) {
			anchor = "#" + (String) anchorObject;
		}

		return "redirect:" + view + "?"
				+ COMMAND_BACK_SELECTOR_REQUEST_PARAMETER + "=" + methodName
				+ anchor;
	}

	public AbstractCommonTO getSelectedItem() {
		@SuppressWarnings("rawtypes")
		List list = (List) getModel(LIST_SELECTOR_ITEM_SELECTED);
		removeDataModel(LIST_SELECTOR_ITEM_SELECTED);
		if (isEmpty(list)) {
			return null;
		} else {
			return (AbstractCommonTO) list.get(0);
		}

	}

	@SuppressWarnings("unchecked")
	public List<? extends Object> getSelectedItems() {
		@SuppressWarnings("rawtypes")
		List list = (List) getModel(LIST_SELECTOR_ITEM_SELECTED);
		removeDataModel(LIST_SELECTOR_ITEM_SELECTED);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<? extends Object> getRemovedItems() {
		@SuppressWarnings("rawtypes")
		List list = (List) getModel(LIST_SELECTOR_ITEM_REMOVED);
		removeDataModel(LIST_SELECTOR_ITEM_REMOVED);
		return list;
	}
/*
	public String getQueryStringParameter(String key) {
		return request.getParameter(key);
	}

	public String getCommandParameter(String key) {
		return request.getParameter(COMMAND_BUTTON_PREFIX_GET + key);
	}

	public String getMethodParameter() {
		if (controllerCode != null) {
			if (request.getMethod().toUpperCase().equals("GET")) {
				return request.getParameter(COMMAND_BUTTON_PREFIX_GET
						+ controllerCode);
			} else {
				return request.getParameter(COMMAND_BUTTON_PREFIX_POST
						+ controllerCode);
			}
		} else {
			return null;
		}
	}

	public void addError(String code, String... args) {
		ContextHelper.addError(request, code, args);
	}

	public void addWarning(String code, String... args) {
		ContextHelper.addWarning(request, code, args);
	}

	public void addInfo(String code, String... args) {
		ContextHelper.addInfo(request, code, args);
	}

	public boolean hasErrors() {
		return !ContextHelper.getPageMessages(request).getErrors().isEmpty();
	}

	public AbstractTO valorizeAudit(AbstractTO to, String codiAction) {
		to.setRowCreatedDttm(Calendar.getInstance().getTime());
		to.setRowCreatedForm(codiAction);
		to.setRowCreatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER,
				request)).getCodiUtente());
		to.setRowUpdatedDttm(Calendar.getInstance().getTime());
		to.setRowUpdatedForm(codiAction);
		to.setRowUpdatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER,
				request)).getCodiUtente());

		return to;
	}

	public UtenteTO getUser() {
		Object o = ContextHelper.getModel(OBJECT_USER, request);
		UtenteTO utenteTO = null;
		if (o != null)
			utenteTO = (UtenteTO) ContextHelper.getModel(OBJECT_USER, request);
		return utenteTO;
	}

	public OutputStream getOutputStream() throws Throwable {
		return response.getOutputStream();
	}

	public String startExport(List<? extends TableModel> model, String type) {
		setDataModel(LIST_FILE_EXPORT, model);
		setDataModel(OBJECT_FILE_EXPORT_TYPE, type);
		setDataModel(IGNORE_VIEW_CACHING, new Boolean(true));
		return "redirect:/fileExport.do";
	}

	public void setCurrentNode(String absoluteNodeId, String... labelParams) {
		NTree navigator = (NTree) ContextHelper.getModel(NAVIGATOR, request);
		if (navigator != null) {
			NLink current = navigator.getNodeById(absoluteNodeId);
			if (current == null) {
				addError("error.invalidNavigationNode", absoluteNodeId,
						getBaseActionUrl());
			} else {
				current.setLabelParams(labelParams);
				request.getSession().setAttribute(NODE_NAVIGATOR_CURRENT,
						current);
			}
		}
	}

	public void setCurrentNodeWithUri(String absoluteNodeId, String uri,
			String... labelParams) {
		NTree navigator = (NTree) ContextHelper.getModel(NAVIGATOR, request);
		if (navigator != null) {
			NLink current = navigator.getNodeById(absoluteNodeId);
			if (current == null) {
				addError("error.invalidNavigationNode", absoluteNodeId,
						getBaseActionUrl());
			} else {
				current.setLabelParams(labelParams);
				current.setUri(uri);
				request.getSession().setAttribute(NODE_NAVIGATOR_CURRENT,
						current);
			}
		}
	}

	public void setRequestModel(String name, Object attribute) {
		ContextHelper.setRequestModel(name, attribute, request);
	}

	// NOTA: if relPath is a directory it must end with "/"
	public String getRealPath(String relPath) {
		String webINFPath = this.getClass().getClassLoader().getResource("").getPath();
		
		String separatorChar = "";
		if (webINFPath.indexOf("\\") != -1 )
		{
			separatorChar = "\\";
		}	
		else if (webINFPath.indexOf("/") != -1 )
		{
			separatorChar = "/";
		}	
		String webInfCla = separatorChar + "WEB-INF" + separatorChar + "classes" + separatorChar;
		String contextAbsolutePath = webINFPath.substring(0, webINFPath.indexOf(webInfCla));
		String out = contextAbsolutePath + relPath;

		File fileAppo = new File(out);
		if (	fileAppo.isDirectory()
				&& !out.endsWith(separatorChar) 
			)
		{	
			out = out + separatorChar;
		}	
		
		return (out!=null? out.trim() : out);
	}

	public String forwardToMethod(String url, String controllerCode,
			String anchor) {
		StringBuffer sb = new StringBuffer();
		sb.append("redirect:/" + url);
		if (controllerCode != null) {
			sb.append("?" + COMMAND_BUTTON_PREFIX_GET + controllerCode + "=1");
		}
		if (anchor != null) {
			sb.append("#" + anchor);
		}
		return sb.toString();
	}

	public String buildUri(String url, String controllerCode,
			String controllerCodeValue) {
		StringBuffer sb = new StringBuffer();
		sb.append(url);
		if (controllerCode != null) {
			sb.append("?" + COMMAND_BUTTON_PREFIX_GET + controllerCode + "="
					+ controllerCodeValue);
		}
		return sb.toString();
	}*/

}
