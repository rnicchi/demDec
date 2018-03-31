<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@page import="it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes"%>

<!-- 		<div class="spacer">&nbsp;</div>
		<span class="nascosto">Ti trovi in:</span>
		<span class="path_N">Home</span>
 -->
<%-- <nssb:horizontalMenuTag 
	menuAttrName="<%=CommonSessionAttributes.LIST_MENU%>" 
	styleClass="F_trasv right padd_R_10" 
	/> --%>
<a id="contenuto"></a>
<demdec:navigator 
	navigatorAttrName="<%=CommonSessionAttributes.NAVIGATOR%>" 
	styleClass="spacer" 
	writeFullPath="true"/> 
	
	