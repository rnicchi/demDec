package it.almavivaitalia.web.sh.utils;

import it.almavivaitalia.web.sh.form.AbstractForm;
import it.almavivaitalia.web.sh.utils.navigator.NLink;
import it.almavivaitalia.web.sh.utils.navigator.NTree;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context extends ContextLev3 {

	public Context(HttpServletRequest request,
			HttpServletResponse response, AbstractForm form,
			String controllerCode, String itemSelectorRequest) {
		super(request, response, form, controllerCode, itemSelectorRequest);
		
	}
	
	public String getMethodParameter() {
		if (getControllerCode() != null) {
			if (getRequest().getMethod().toUpperCase().equals("GET")) {
				return getRequest().getParameter(COMMAND_BUTTON_PREFIX_GET
						+ getControllerCode());
			} else {
				return getRequest().getParameter(COMMAND_BUTTON_PREFIX_POST
						+ getControllerCode());
			}
		} else {
			return null;
		}
	}


	public void setCurrentNode(String absoluteNodeId, String... labelParams) {
		NTree navigator = (NTree) ContextHelper.getModel(NAVIGATOR, getRequest());
		if (navigator != null) {
			NLink current = navigator.getNodeById(absoluteNodeId)==null?navigator.getNodeByLastToken(absoluteNodeId):navigator.getNodeById(absoluteNodeId);
			
			if (current == null) {
				addError("error.invalidNavigationNode", absoluteNodeId,
						getBaseActionUrl());
			} else {
				current.setLabelParams(labelParams);
				getRequest().getSession().setAttribute(NODE_NAVIGATOR_CURRENT, current);
			}
		}
	}

	public void setCurrentNodeWithUri(String absoluteNodeId, String uri,
			String... labelParams) {
		NTree navigator = (NTree) ContextHelper.getModel(NAVIGATOR, getRequest());
		if (navigator != null) {
			NLink current = navigator.getNodeById(absoluteNodeId);
			if (current == null) {
				addError("error.invalidNavigationNode", absoluteNodeId,
						getBaseActionUrl());
			} else {
				current.setLabelParams(labelParams);
				current.setUri(uri);
				getRequest().getSession().setAttribute(NODE_NAVIGATOR_CURRENT,
						current);
			}
		}
	}

	public void setRequestModel(String name, Object attribute) {
		ContextHelper.setRequestModel(name, attribute, getRequest());
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
	}
	

	//20120405: A seguito dell'introduzione del metodo 
	//startExport(List<? extends TableModel> model, String type, String nomeFile)
	//sulla classe ContextLev3, il metodo getUser() e' stato spostato in questa classe
	//per rientrare nel limite del numero massimo di metodi ammessi dalle metriche
	//per una classe
/*	public UtenteTO getUser() {
		Object o = ContextHelper.getModel(OBJECT_USER, getRequest());
		UtenteTO utenteTO = null;
		if (o != null)
			utenteTO = (UtenteTO) ContextHelper.getModel(OBJECT_USER, getRequest());
		return utenteTO;
	}	*/

}
