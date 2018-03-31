package it.almavivaitalia.web.sh.taglib;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class URITag extends SimpleTagSupport {
	private String name;
	private String codiAction;
	private String className;
	 /* LOCM */
    @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM4 = 80L;
    @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM2 = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM3 = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM = 80L;
	 @SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM1 = 80L;
    /* end LOCM */

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodiAction() {
		return codiAction;
	}

	public void setCodiAction(String codiAction) {
		this.codiAction = codiAction;
	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			
			if(codiAction!=null&&!"".equals(codiAction)){
				String uri = fieldValue(className, camelCaseTranslater(codiAction));						
				getJspContext().setAttribute(name, uri);
			}
		} catch (Throwable e) {
			throw new JspException(e.getMessage());
		}

	}

	private String camelCaseTranslater(String camelCase) {
		String constants = camelCase.charAt(0) + "";

		for (int i = 1; i < camelCase.toCharArray().length; i++) {
			char c = camelCase.toCharArray()[i];
			if (Character.isUpperCase(c)) {
				constants += "_";
			}

			constants += c;

		}
		
		return constants.toUpperCase();
	}

	private String fieldValue(String className, String fieldName)
			throws NoSuchFieldException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {

		Class<?> c = Class.forName(className);
		String fieldValue = null;

		Field f = c.getField(fieldName);
		@SuppressWarnings("rawtypes")
		Class type = f.getType();
		fieldValue = (String) f.get(type);

		return fieldValue;
	}

}
