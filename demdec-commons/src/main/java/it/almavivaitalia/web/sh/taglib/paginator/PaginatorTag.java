package it.almavivaitalia.web.sh.taglib.paginator;

import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.web.sh.taglib.BaseAlmavivaTag;
import it.almavivaitalia.web.sh.utils.WebConstants;

import javax.servlet.jsp.JspException;

public class PaginatorTag extends BaseAlmavivaTag{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cssPageClass;
	
	private String cssCurrentPageClass;
	
	private boolean buttons=true;
	
	private String controllerCode;
	
	private String paginatorName;
	
	private String paginatorSessionName;
	
	private String keyBackLabel;
	private String keyNextLabel;
	
	private String keyPagePrefixLabel;
	private String keyBackValue;
	private String keyNextValue;
	
	private String keyBackRangeLabel;
	private String keyNextRangeLabel;
	
	private String keyBackRangeValue;
	private String keyNextRangeValue;
	
	private String keyCurrentPagLabel;
	private String keyTotPagLabel;
	private String keyTotEleLabel;
	private String keyGoToLabel;
	
	private String controllerCodeEnableDisablePagin;
	private String keyEnablePaginValue;
	private String keyEnablePaginLabel;
	private String keyDisablePaginValue;
	private String keyDisablePaginLabel;	
	
	
	
	public String getControllerCodeEnableDisablePagin() {
		return controllerCodeEnableDisablePagin;
	}
	public void setControllerCodeEnableDisablePagin(
			String controllerCodeEnableDisablePagin) {
		this.controllerCodeEnableDisablePagin = controllerCodeEnableDisablePagin;
	}
	
	public String getKeyEnablePaginValue() {
		return keyEnablePaginValue;
	}
	public void setKeyEnablePaginValue(String keyEnablePaginValue) {
		this.keyEnablePaginValue = keyEnablePaginValue;
	}
	
	public String getKeyEnablePaginLabel() {
		return keyEnablePaginLabel;
	}
	public void setKeyEnablePaginLabel(String keyEnablePaginLabel) {
		this.keyEnablePaginLabel = keyEnablePaginLabel;
	}
	
	public String getKeyDisablePaginValue() {
		return keyDisablePaginValue;
	}
	public void setKeyDisablePaginValue(String keyDisablePaginValue) {
		this.keyDisablePaginValue = keyDisablePaginValue;
	}
	
	public String getKeyDisablePaginLabel() {
		return keyDisablePaginLabel;
	}
	public void setKeyDisablePaginLabel(String keyDisablePaginLabel) {
		this.keyDisablePaginLabel = keyDisablePaginLabel;
	}
	
	
	public String getKeyGoToLabel() {
		return keyGoToLabel;
	}
	public void setKeyGoToLabel(String keyGoToLabel) {
		this.keyGoToLabel = keyGoToLabel;
	}
	
	public String getKeyTotEleLabel() {
		return keyTotEleLabel;
	}
	public void setKeyTotEleLabel(String keyTotEleLabel) {
		this.keyTotEleLabel = keyTotEleLabel;
	}
	
	public String getKeyCurrentPagLabel() {
		return keyCurrentPagLabel;
	}
	public void setKeyCurrentPagLabel(String keyCurrentPagLabel) {
		this.keyCurrentPagLabel = keyCurrentPagLabel;
	}

	public String getKeyTotPagLabel() {
		return keyTotPagLabel;
	}
	public void setKeyTotPagLabel(String keyTotPagLabel) {
		this.keyTotPagLabel = keyTotPagLabel;
	}

	public String getKeyBackRangeLabel() {
		return keyBackRangeLabel;
	}

	public void setKeyBackRangeLabel(String keyBackRangeLabel) {
		this.keyBackRangeLabel = keyBackRangeLabel;
	}

	public String getKeyNextRangeLabel() {
		return keyNextRangeLabel;
	}

	public void setKeyNextRangeLabel(String keyNextRangeLabel) {
		this.keyNextRangeLabel = keyNextRangeLabel;
	}

	public String getKeyBackRangeValue() {
		return keyBackRangeValue;
	}

	public void setKeyBackRangeValue(String keyBackRangeValue) {
		this.keyBackRangeValue = keyBackRangeValue;
	}

	public String getKeyNextRangeValue() {
		return keyNextRangeValue;
	}

	public void setKeyNextRangeValue(String keyNextRangeValue) {
		this.keyNextRangeValue = keyNextRangeValue;
	}

	public String getKeyPagePrefixLabel() {
		return keyPagePrefixLabel;
	}

	public void setKeyPagePrefixLabel(String keyPagePrefixLabel) {
		this.keyPagePrefixLabel = keyPagePrefixLabel;
	}


	
	public String getKeyBackValue() {
		return keyBackValue;
	}

	public void setKeyBackValue(String keyBackValue) {
		this.keyBackValue = keyBackValue;
	}

	public String getKeyNextValue() {
		return keyNextValue;
	}

	public void setKeyNextValue(String keyNextValue) {
		this.keyNextValue = keyNextValue;
	}

	public String getKeyBackLabel() {
		return keyBackLabel;
	}

	public void setKeyBackLabel(String keyBackLabel) {
		this.keyBackLabel = keyBackLabel;
	}

	public String getKeyNextLabel() {
		return keyNextLabel;
	}

	public void setKeyNextLabel(String keyNextLabel) {
		this.keyNextLabel = keyNextLabel;
	}

	public String getCssPageClass() {
		return cssPageClass;
	}

	public void setCssPageClass(String cssPageClass) {
		this.cssPageClass = cssPageClass;
	}

	

	public String getCssCurrentPageClass() {
		return cssCurrentPageClass;
	}

	public void setCssCurrentPageClass(String cssCurrentPageClass) {
		this.cssCurrentPageClass = cssCurrentPageClass;
	}

	public boolean isButtons() {
		return buttons;
	}

	public void setButtons(boolean buttons) {
		this.buttons = buttons;
	}

	public String getControllerCode() {
		return controllerCode;
	}

	public void setControllerCode(String controllerCode) {
		this.controllerCode = controllerCode;
	}

	public String getPaginatorName() {
		return paginatorName;
	}

	public void setPaginatorName(String paginatorName) {
		this.paginatorName = paginatorName;
	}
	
	public String getPaginatorSessionName() {
		return paginatorSessionName;
	}
	
	public void setPaginatorSessionName(String paginatorSessionName) {
		this.paginatorSessionName = paginatorSessionName;
	}
	
	private String generatePageButton(String altLabel, String value, String ctrlCode){
		StringBuffer sb = new StringBuffer();
		sb.append("<input type=\"submit\" name=\"");
//		sb.append(COMMAND_BUTTON_PREFIX_POST+controllerCode);
		sb.append(COMMAND_BUTTON_PREFIX_POST+ctrlCode+WebConstants.P_INTERROGATIVO+paginatorSessionName);
		sb.append("\" value=\"");
		sb.append(value);
		sb.append("\" class=\"");
		sb.append(cssPageClass);
		sb.append("\" title=\"");
		sb.append(altLabel);
		sb.append("\"/>");
		return sb.toString();
	}
	
	private void initDefaults(){
		if (cssPageClass==null){
			cssPageClass="buttonPag border-radius";
		}
		if (cssCurrentPageClass==null){
			//modificata per demdec
			cssCurrentPageClass=null;
		}
		if (keyBackRangeLabel==null){
			keyBackRangeLabel="paginator.keyBackRangeLabel";
		}
		if (keyNextRangeLabel==null){
			keyNextRangeLabel="paginator.keyNextRangeLabel";
		}
		if (keyBackLabel==null){
			keyBackLabel="paginator.keyBackLabel";
		}
		if (keyNextLabel==null){
			keyNextLabel="paginator.keyNextLabel";
		}
		if (keyBackValue==null){
			keyBackValue="paginator.keyBackValue";
		}
		if (keyNextValue==null){
			keyNextValue="paginator.keyNextValue";
		}
		if (keyBackRangeValue==null){
			keyBackRangeValue="paginator.keyBackRangeValue";
		}
		if (keyNextRangeValue==null){
			keyNextRangeValue="paginator.keyNextRangeValue";
		}
		if (keyPagePrefixLabel==null){
			keyPagePrefixLabel="paginator.keyPagePrefixLabel";
		}
		if (keyCurrentPagLabel==null){
			keyCurrentPagLabel="paginator.keyCurrentPagLabel";
		}
		if (keyTotPagLabel==null){
			keyTotPagLabel="paginator.keyTotPagLabel";
		}
		if (keyTotEleLabel==null){
			keyTotEleLabel="paginator.keyTotEleLabel";
		}
		if (keyGoToLabel==null){
			keyGoToLabel="paginator.keyGoToLabel";
		}
		

		if (keyEnablePaginValue==null){
			keyEnablePaginValue="paginator.keyEnablePaginValue";
		}
		if (keyEnablePaginLabel==null){
			keyEnablePaginLabel="paginator.keyEnablePaginLabel";
		}	
		if (keyDisablePaginValue==null){
			keyDisablePaginValue="paginator.keyDisablePaginValue";
		}
		if (keyDisablePaginLabel==null){
			keyDisablePaginLabel="paginator.keyDisablePaginLabel";
		}		
		

	}
	
	
	private String generateNavButton(String keyLabel, String keyValue, String ctrlCode){
		StringBuffer sb = new StringBuffer();
		String label=getMessageSource().getMessage(keyLabel);
		String value=getMessageSource().getMessage(keyValue);
		sb.append(generatePageButton(label, value, ctrlCode));
		return sb.toString();
	}
	
	@Override
	public int doStartTag() throws JspException {
		
		try {
			initDefaults();
			
			StringBuffer sb = new StringBuffer();
			Paginator paginator = (Paginator)getAttribute(paginatorName);
			sb.append("<span>"); 
			sb.append(getMessageSource().getMessage(keyTotEleLabel));
			sb.append("</span>"); 
			
			sb.append("<span class=\"");
			sb.append("col_char_user");
			sb.append("\">");
			sb.append("<strong>");

			if (paginator.getNumberOfDummyElements() != 0)
			{	sb.append("&nbsp;"); 
				sb.append(paginator.getNumberOfElements() - paginator.getNumberOfDummyElements());
			}
			else
			{	sb.append("&nbsp;"); 
				sb.append(paginator.getNumberOfElements());
			}	
			sb.append("</strong>");
			sb.append("</span>");

			
			
			sb.append("<span>"); 
			sb.append("&nbsp;"); 
			sb.append(getMessageSource().getMessage(keyCurrentPagLabel));
			sb.append("&nbsp;"); 
			sb.append("<strong>"); 
			sb.append(String.valueOf(paginator.getCurrentPage() + 1));
			sb.append("</strong>");
			sb.append("&nbsp;"); 
			sb.append(getMessageSource().getMessage(keyTotPagLabel));
			sb.append("&nbsp;"); 
			sb.append("<strong>");
			sb.append(paginator.getNumberOfPages());
			sb.append("</strong>");
	
			if (paginator.getNumberOfPages()>1){
				sb.append("&nbsp;"); 
				sb.append(getMessageSource().getMessage(keyGoToLabel));
				
			}	
			
	
			
			int[] currentPageRange = paginator.getCurrentPageRange();
			
			// back range button
			if (currentPageRange[0]>0){
				sb.append("&nbsp;"); 
				sb.append(generateNavButton(keyBackRangeLabel, keyBackRangeValue, controllerCode));
			}
			
			// back button
			if (paginator.getCurrentPage()>0){
				sb.append("&nbsp;"); 
				sb.append(generateNavButton(keyBackLabel, keyBackValue, controllerCode));
			}
			sb.append("</span>");
			
			
			if(paginator.getNumberOfPages()>1){
				// page buttons start
				String label=getMessageSource().getMessage(keyPagePrefixLabel);
				
				for(int i=currentPageRange[0]; i<=currentPageRange[1];i++){
					if (i==paginator.getCurrentPage()){
						if (cssCurrentPageClass!=null){
							sb.append("&nbsp;"); 
							sb.append("<span class=\"");
							sb.append(cssCurrentPageClass);
							sb.append("\">");
							sb.append((i+1));
							sb.append("</span>");
						} else{
							sb.append("&nbsp;"); 
							sb.append("<span>");
							sb.append((i+1));
							sb.append("</span>");
						}
												
					}else {
						sb.append("&nbsp;"); 
						sb.append(generatePageButton(label+(i+1), ""+(i+1), controllerCode));
					}
				}
				// page buttons end
			}	

			// next button
			if (paginator.getCurrentPage()<paginator.getNumberOfPages()-1){
				sb.append("&nbsp;"); 
				sb.append(generateNavButton(keyNextLabel, keyNextValue, controllerCode));
			}
			// next button
			if (currentPageRange[1]<paginator.getNumberOfPages()-1){
				sb.append("&nbsp;"); 
				sb.append(generateNavButton(keyNextRangeLabel, keyNextRangeValue, controllerCode));
			}
			
			
			//Gestione tasto abilita/disabilita paginazione
			if (	controllerCodeEnableDisablePagin != null )
			{	//Vedere il significato di PaginationEnabled sulla classe AbstractPaginator
				//o interfaccia Paginator
				if (paginator.getPaginationEnabled().booleanValue())
				{
					if (paginator.getNumberOfElements() > paginator.getPageSize()){
						sb.append("&nbsp;"); 
						sb.append(generateNavButton(keyDisablePaginLabel, keyDisablePaginValue, controllerCodeEnableDisablePagin));
					}
				}	
				else
				{
					if (paginator.getNumberOfElements() > paginator.getBckInitialPageSize()){
						sb.append("&nbsp;"); 
						sb.append(generateNavButton(keyEnablePaginLabel, keyEnablePaginValue, controllerCodeEnableDisablePagin));
					}	
				}
			}
			
			write(sb.toString());
		}catch (Throwable e) {
			throw new JspException(e);
		}
		
		return super.doStartTag();
	}
	
	@Override
	public void release() {
		super.release();
		cssPageClass=null;
		cssCurrentPageClass=null;
		buttons=true;
		controllerCode=null;
		paginatorName=null;
		keyBackLabel=null;
		keyNextLabel=null;
		keyBackValue=null;
		keyNextValue=null;
		keyPagePrefixLabel=null;
		keyBackRangeLabel=null;
		keyNextRangeLabel=null;
		keyBackRangeValue=null;
		keyNextRangeValue=null;
		keyCurrentPagLabel=null;
		keyTotPagLabel=null;
		keyTotEleLabel=null;
		keyGoToLabel=null;
		controllerCodeEnableDisablePagin=null;
		keyEnablePaginValue=null;
		keyEnablePaginLabel=null;
		keyDisablePaginValue=null;
		keyDisablePaginLabel=null;
	}
	
	
}
