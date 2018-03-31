package it.almavivaitalia.web.sh.utils;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.web.sh.export.TableModel;
import it.almavivaitalia.web.sh.form.AbstractForm;

import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class ContextLev3 extends ContextLev2 {

	public ContextLev3(HttpServletRequest request,
			HttpServletResponse response, AbstractForm form,
			String controllerCode, String itemSelectorRequest) {
		super(request, response, form, controllerCode, itemSelectorRequest);
		
	}
	
	
	public String getQueryStringParameter(String key) {
		return getRequest().getParameter(key);
	}

	public String getCommandParameter(String key) {
		return getRequest().getParameter(COMMAND_BUTTON_PREFIX_GET + key);
	}

	/**
	 * Recupera l'oggetto selezionato dalla lista
	 * 
	 * @param commandParameter nome parametro
	 * @param commandList nome attributo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends AbstractCommonTO> T getSelectedItem(String commandParameter, String commandList){
		String selectedRow=getCommandParameter(commandParameter);
		
		if(StringUtils.isEmpty(selectedRow)){
			return null;
		}
		
		List<AbstractCommonTO> listObjects =getModel(commandList);
		
		return (T) listObjects.get(Integer.valueOf(selectedRow));
	}
	

	public void addError(String code, String... args) {
		ContextHelper.addError(getRequest(), code, args);
	}

	public void addWarning(String code, String... args) {
		ContextHelper.addWarning(getRequest(), code, args);
	}

	public void addInfo(String code, String... args) {
		ContextHelper.addInfo(getRequest(), code, args);
	}

	public boolean hasErrors() {
		return !ContextHelper.getPageMessages(getRequest()).getErrors().isEmpty();
	}

	public AbstractCommonTO valorizeAudit(AbstractCommonTO to, String codiAction) {
		
			to.setRowCreatedDttm(Calendar.getInstance().getTime());
			to.setRowCreatedForm(codiAction);
			to.setRowCreatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER, getRequest())).getCodiUtente());
			to.setRowUpdatedDttm(Calendar.getInstance().getTime());
			to.setRowUpdatedForm(codiAction);
			to.setRowUpdatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER, getRequest())).getCodiUtente());

		return to;
	}
	
/*	public AbstractCommonTO valorizeAudit(AbstractCommonTO to, String codiAction) {
		
		if (	to.getRowCreatedDttm() == null
				&& to.getRowCreatedForm() == null
				&& to.getRowCreatedUser() == null
			)
		{
			to.setRowCreatedDttm(Calendar.getInstance().getTime());
			to.setRowCreatedForm(codiAction);
			to.setRowCreatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER,
					getRequest())).getCodiUtente());
		}	
		else
		{	
			to.setRowUpdatedDttm(Calendar.getInstance().getTime());
			to.setRowUpdatedForm(codiAction);
			to.setRowUpdatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER,
					getRequest())).getCodiUtente());
		}	

		return to;
	}
	
*/	/*Valorizza i campi di audit riferiti all'aggiornamento di un record*/
	public AbstractCommonTO valorizeAuditUpdated(AbstractCommonTO to, String codiAction) {
		to.setRowUpdatedDttm(Calendar.getInstance().getTime());
		to.setRowUpdatedForm(codiAction);
		to.setRowUpdatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER,
				getRequest())).getCodiUtente());

		return to;
	}	
	
	/*Valorizza i campi di audit riferiti alla creazione di un record*/
	public AbstractCommonTO valorizeAuditCreated(AbstractCommonTO to, String codiAction) {
		to.setRowCreatedDttm(Calendar.getInstance().getTime());
		to.setRowCreatedForm(codiAction);
		to.setRowCreatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER,
				getRequest())).getCodiUtente());

		return to;
	}	
	



	public OutputStream getOutputStream() throws Throwable {
		return getResponse().getOutputStream();
	}

	
	//startExport(List<? extends TableModel> model, String type)
	//richiama startExport(List<? extends TableModel> model, String type, String nomeFile)
	public String startExport(List<? extends TableModel> model, String type) {
		return startExport(model, type, null);
	}
	
	
	//startExport(List<? extends TableModel> model, String type, String nomeFile),
	//richiamato nell'ambito di una richiesta di export, setta in sessione i
	//dati necessari all'export quali:
	//-- List<? extends TableModel> model, collection di oggetti ciascuno dei rappresenta
	//	 in genere una riga di una trabella da presentare sul file soggetto ad export;
	//-- String type, tipologia del file da esportare;
	//-- String nomeFile, nome da attribuire al file soggetto ad export 
	public String startExport(List<? extends TableModel> model, String type, String nomeFile) {
		setDataModel(LIST_FILE_EXPORT, model);
		setDataModel(OBJECT_FILE_EXPORT_TYPE, type);
		setDataModel(NAME_FILE_EXPORT, nomeFile);
		setDataModel(IGNORE_VIEW_CACHING, new Boolean(true));
		return "redirect:/fileExport.do";
	}	

/*	public void setCurrentNode(String absoluteNodeId, String... labelParams) {
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
	}
*/
}
