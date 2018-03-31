package it.almavivaitalia.web.sh.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OverrideInputParameterTag extends SimpleTagSupport {
	private String expected;
	private String provided;

	@Override
	public void doTag() throws JspException, IOException {
		ItemSelectorTag parent = (ItemSelectorTag) getParent();
		if (parent != null) {
			parent.addOverridedInputParameter(this);
		}
		super.doTag();
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public String getProvided() {
		return provided;
	}

	public void setProvided(String provided) {
		this.provided = provided;
	}

}
