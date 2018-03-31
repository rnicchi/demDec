package it.almavivaitalia.web.sh.taglib;


import java.util.Vector;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class UseAttributeTei extends TagExtraInfo{

	public UseAttributeTei() {
		super();
	}

	private Vector<VariableInfo> v = new Vector<VariableInfo>();
	
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
	
	private void addVariable(String variable, String type){
        /*  
        Variable scope
        NESTED (Default) Between the start tag and the end tag
		AT_BEGIN  From the start tag until the end of the page
		AT_END  After the end tag until the end of the page  In doEndTag  
        */
		if (variable!=null) {
			if (type==null){
				type="java.lang.Object";
			}
			v.add(new VariableInfo(
						variable,
						type,
						true,
						VariableInfo.AT_END));
		}
		
	}


	
	public VariableInfo[] getVariableInfo(TagData data) {
		
		VariableInfo[] variables=null;
		addVariable(data.getAttributeString("id"), data.getAttributeString("type"));
		if (v.size()>0){
			variables=new VariableInfo[v.size()];
			for (int i=0; i<v.size(); i++){
				variables[i]=v.elementAt(i);
			}
		}
		return variables;
	}

}
