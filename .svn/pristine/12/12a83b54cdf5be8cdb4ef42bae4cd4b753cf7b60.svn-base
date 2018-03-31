package it.almavivaitalia.web.sh.taglib;

import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.datatype.DataType;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.WebConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ItemSelectorTag extends SimpleTagSupport implements DynamicAttributes {
	private DataType 							dataType;
	private String 								fieldFormatterFileName;
	private String 								backMethodName;
	private String 								beanAttributeName;
	private String[] 							beanProperties;
	private String[] 							beanPropertiesFilter;
	private String								controllerCodeValidator;
	private List<InputParameterTag>				inputParameters=new ArrayList<InputParameterTag>();
	private List<OverrideInputParameterTag>		overridedInputParameters=new ArrayList<OverrideInputParameterTag>();
	private List<OverrideOutputParameterTag>	outputParameters=new ArrayList<OverrideOutputParameterTag>();
	private boolean 							hide = false;
	private Map<String,String> 					tagAttrs = new HashMap<String,String>();

	@Override
	public void doTag() throws JspException, IOException {
		
		if(hide){
			return;
		}
		
		getJspBody().invoke(null);
		
		PageContext pageContext=(PageContext)getJspContext();
		
		JspWriter writer=pageContext.getOut();

		Input input =new Input(WebConstants.IMAGE, 
										WebConstants.COMMAND_BUTTON_PREFIX_POST + 
										WebConstants.PARAMETER_SELECTOR+
										WebConstants.P_INTERROGATIVO+
										WebConstants.ACTION + WebConstants.UGUALE+ dataType.getAction()+
										WebConstants.AMPERSAND_ENTITY+"dataType"+ WebConstants.UGUALE+dataType.getControllerCode()+
										WebConstants.AMPERSAND_ENTITY+"dataTypeClass"+ WebConstants.UGUALE+dataType.getClass()+
										WebConstants.AMPERSAND_ENTITY+"dataTypeName"+WebConstants.UGUALE+ dataType.toString()
										);
	
		input.addTagAttr(WebConstants.SRC, ((HttpServletRequest)pageContext.getRequest()).getContextPath()+"/img/puls_scelta.jpg");
		
		writer.print(input);
		
		//PARAMETRI INPUT SELECTOR
		for(InputParameterTag inputParameter:inputParameters){
			input =new Input(WebConstants.HIDDEN, inputParameter.getName());
			input.addTagAttr(WebConstants.VALUE, inputParameter.getValue());
			
			writer.print(input);
		}
		
		//PARAMETRI OVERRIDE INPUT SELECTOR
		for(OverrideInputParameterTag inputParameter:overridedInputParameters){
			input =new Input(WebConstants.HIDDEN, WebConstants.INPUT+dataType.name()+WebConstants.UNDERSCORE + inputParameter.getExpected());
			input.addTagAttr(WebConstants.VALUE, inputParameter.getProvided());
			
			writer.print(input);
		}		
		
		//PARAMETRI OVERRIDE OUTPUT SELECTOR
		for(OverrideOutputParameterTag outputParameter:outputParameters){
			input =new Input(WebConstants.HIDDEN, WebConstants.OUTPUT+dataType.name()+WebConstants.UNDERSCORE + outputParameter.getExpected());
			input.addTagAttr(WebConstants.VALUE, outputParameter.getProvided());
			
			writer.print(input);
		}		
		
		//forzo il salvataggio della view per il selector
		input =new Input(WebConstants.HIDDEN, BaseSessionAttributes.SAVE_VIEW_FOR_SELECTOR);
		input.addTagAttr(WebConstants.VALUE, "true");
		
		writer.print(input);
		
		if(beanAttributeName!=null&&!"".equals(beanAttributeName)){
			input =new Input("hidden",BaseSessionAttributes.BEAN_ATTRIBUTE_NAME);
			input.addTagAttr("value", beanAttributeName);
			
			writer.print(input);		
		}
		
		if(beanProperties!=null&&!(beanProperties.length==0)){
			for(String str:beanProperties){
				input =new Input("hidden",BaseSessionAttributes.BEAN_PROPERTIES_FOR_SELECTOR);
				input.addTagAttr("value", str);
				
				writer.print(input);					
			}
		}
		
		if(beanPropertiesFilter!=null&&!(beanPropertiesFilter.length==0)){
			for(String str:beanPropertiesFilter){
				input =new Input("hidden",BaseSessionAttributes.BEAN_PROPERTIES_FILTER_FOR_SELECTOR);
				input.addTagAttr("value", str);
				
				writer.print(input);					
			}
		}
		
		//FIELD FORMATTER FILE NAME
		if(!StringUtil.isEmpty(fieldFormatterFileName)){
			input =new Input("hidden", WebConstants.FIELD_FORMATTER_FILE_NAME);
			input.addTagAttr("value", fieldFormatterFileName);
			
			writer.print(input);		
		}
		
		//EVENTUALE METODO DI RITORNO
		if(!StringUtil.isEmpty(backMethodName)){
			input =new Input("hidden", WebConstants.PARAMETER_SELECTOR_BACK_METHOD_NAME);
			input.addTagAttr("value", backMethodName);
			
			writer.print(input);	
		}
		
		//VALIDAZIONE
		if(!StringUtil.isEmpty(controllerCodeValidator)){
			input =new Input("hidden", WebConstants.PARAMETER_SELECTOR_VALIDATOR_METHOD_NAME);
			input.addTagAttr("value", controllerCodeValidator);
			
			writer.print(input);	
		}		
		
		//SUMMARY_TABLE
		input =new Input("hidden", WebConstants.SUMMARY_SELECTOR_ITEM);
		input.addTagAttr("value", dataType.getSummaryTable());
		
		writer.print(input);
		
		//CAPTION_TABLE
		input =new Input("hidden", WebConstants.CAPTION_SELECTOR_ITEM);
		input.addTagAttr("value", dataType.getCaptionTable());
		
		writer.print(input);
	}

	@Override
	public void setDynamicAttribute(String uri, String name, Object value)
			throws JspException {
		tagAttrs.put(name, (String)value);		
	}
	
	class Input{
		
		private String type;
		private String name;		
		private Map<String,String> tagAttrs = new HashMap<String,String>();
		
		public Input(){
			
		}
		
		public Input(
				String type, 
				String name) {
			super();
			this.type = type;
			this.name = name;
		}
		
		public void addTagAttr(String key, String value){
			tagAttrs.put(key,value);
		}
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
		public void setTagAttrs(Map<String,String> tagAttrs){
			this.tagAttrs=tagAttrs;
		}
		
		//img/puls_scelta.jpg
		///sbfj-dls/img/puls_scelta.jpg
		public String toString(){
			StringBuffer sb=new StringBuffer();
			sb.append("<input type=\""+type+"\" ");
			sb.append("name=\""+name+"\" ");
			
			for(Map.Entry<String, String> entry:tagAttrs.entrySet()){
				sb.append(entry.getKey()+"=\""+entry.getValue()+"\" ");
			}
			
			sb.append(" /> ");
			
			return sb.toString();			
		}
	}
	
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	
	/**
	 * Il nome con cui il form è salvato nel context
	 * 
	 * @param beanAttributeName
	 */
	public void setBeanAttributeName(String beanAttributeName) {
		this.beanAttributeName = beanAttributeName;
	}

	public void setBeanProperties(String[] beanProperties) {
		this.beanProperties = beanProperties;
	}

	public void setBeanPropertiesFilter(String[] beanPropertiesFilter) {
		this.beanPropertiesFilter = beanPropertiesFilter;
	}

	public void setFieldFormatterFileName(String fieldFormatterFileName) {
		this.fieldFormatterFileName = fieldFormatterFileName;
	}

	public void setBackMethodName(String backMethodName) {
		this.backMethodName = backMethodName;
	}
	
	public void setControllerCodeValidator(String controllerCodeValidator) {
		this.controllerCodeValidator = controllerCodeValidator;
	}

	protected void addInputParameter(InputParameterTag input){
		inputParameters.add(input);
	}
	
	protected void addOutputParameter(OverrideOutputParameterTag output){
		outputParameters.add(output);
	}
	
	protected void addOverridedInputParameter(OverrideInputParameterTag input){
		overridedInputParameters.add(input);
	}
	
	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}	
	
}
