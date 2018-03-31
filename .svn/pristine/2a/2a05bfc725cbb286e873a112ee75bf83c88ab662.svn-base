package it.almavivaitalia.web.sh.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class InputParameterTag extends SimpleTagSupport {
	private String name;
	private String value;

	@Override
	public void doTag() throws JspException, IOException {
		ItemSelectorTag parent = (ItemSelectorTag) getParent();
		if (parent != null) {
			parent.addInputParameter(this);
		}
		super.doTag();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

}
