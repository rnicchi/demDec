<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<!-- menu.jsp -->
<script src="<%=request.getContextPath()%>/private/js/jquery.js"></script>

 <nssb:useAttribute 
					id="codiProfilo" 	
					name="<%=BaseSessionAttributes.OBJECT_PROFILO%>" 				
					property="codiProfilo"/>
		
<nssb:useAttribute 
					id="selectedItemId" 	
					name="<%=BaseSessionAttributes.OBJECT_SELECTED_ITEM_ID%>"/>

<nssb:verticalMenuTag 
	styleClass="navigation"
	listStyleClass="menu"
	menuAttrName="<%=BaseSessionAttributes.OBJECT_MENU%>" 
	codiProfilo="${codiProfilo}" 
	selectedItemId="${selectedItemId}"/>
	 <!-- Navigazione: parte sinistra -->
