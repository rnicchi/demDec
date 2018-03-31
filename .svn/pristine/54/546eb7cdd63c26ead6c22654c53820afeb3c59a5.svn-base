package it.almavivaitalia.web.sh.taglib;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.InputTag;

public class InputTextTag extends InputTag{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public int doEndTag() throws JspException {
		try {
			Object panelCellTagObj = findAncestorWithClass(this, PanelCellTag.class);
			if (panelCellTagObj!=null){
				PanelCellTag panelCellTag=(PanelCellTag)panelCellTagObj;
				String labelFor = panelCellTag.getLabelFor();
				if ((labelFor!=null)&&labelFor.contains(getPath())&&(panelCellTag.getTitle()!=null)){
					pageContext.getOut().write("<label class=\"nascosto\" for=\""+getPath()+"\">"+panelCellTag.getTitle()+"</label>");
				}
			}
		}catch (Exception e) {
			throw new JspException(e);
		}
		
		return super.doEndTag();
	}
}
