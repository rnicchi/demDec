<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%-- <demdec:useAttribute id="listAnniEser" name="<%=WebConstants.LIST_ANNO_ESE%>"/> --%> 
<demdec:useAttribute id="listProfili" name="<%=WebConstants.LIST_PROFILI%>"/> 
<demdec:useAttribute id="listUffici"  name="<%=WebConstants.LIST_UFFICI%>"/> 
<demdec:useAttribute id="listAmm"  name="<%=WebConstants.LIST_AMMIN_DEM%>"/> 
<demdec:useAttribute id="listProfUfficiAmm"  name="<%=WebConstants.LIST_PROF_UFF_AMM%>"/> 
<demdec:useAttribute id="listProfiliAction"  name="<%=WebConstants.LIST_PROF_ACT%>"/> 

<demdec:useAttribute id="listAllAction"  name="<%=WebConstants.LIST_ALL_ACT%>"/> 
<demdec:useAttribute id="listAction"  name="<%=WebConstants.LIST_ACT%>"/> 
<demdec:useAttribute id="f" name="<%=BaseSessionAttributes.FORM%>" />
	


<div class="row">
 <div class="large-12 columns">
 
 <fieldset>
  
  <div class="row"> 
      <div class="small-3 columns">
      <c:if test="${empty f.selectedProfilo}">
        <%--  <demdec:label path="codiProfilo"  labelKey="label.codiProfilo"/> --%>
         <label for="codiProfilo"><spring:message code="label.codiProfilo"/></label>
         <form:input path="codiProfilo" maxlength="3" /> 
         <form:hidden path="id"/>
       </c:if>
       <c:if test="${not empty f.selectedProfilo}">
        <%--  <demdec:label path="codiProfilo"  labelKey="label.codiProfilo" /> --%>
         <label for="codiProfilo"><spring:message code="label.codiProfilo"/></label>
         <form:input path="codiProfilo" disabled="true"/> 
         		<form:hidden path="codiProfilo"/>
				<form:hidden path="selectedProfilo"/>
				<form:hidden path="id"/>
       </c:if>
      </div>
  </div>
  
  <div class="row"> 
      <div class="small-3 columns">
      <c:if test="${empty f.selectedProfilo}">
        <%--  <demdec:label path="descProfilo"  labelKey="label.descProfilo"/> --%>
          <label for="descProfilo"><spring:message code="label.descProfilo"/></label>
         <form:input path="descProfilo" maxlength="180" /> 
         </c:if>
         <c:if test="${not empty f.selectedProfilo}">
        <%--  <demdec:label path="descProfilo"  labelKey="label.descProfilo"/> --%>
          <label for="descProfilo"><spring:message code="label.descProfilo"/></label>
        <form:input path="descProfilo" disabled="true"/> 
         		<form:hidden path="descProfilo"/>
       </c:if>
      </div>
  </div>
 
</fieldset>

<!--  ${idActionProfilo} -->

		<c:if test="${empty f.selectedProfilo}">

				<demdec:displaytag-table name="pageScope.listAllAction" id="listAllAction" class="lux width100">
					<display:caption>
								<span class="nascosto"><strong> <spring:message code="label.title.gestioneProfili"></spring:message></strong></span>
					</display:caption>
					 
					<demdec:displaytag-column titleKey="" title="<input type='checkbox' id='selectall' title='Seleziona tutti' class='optim'/>" class="center">
						
					 <label for="idActionProfilo${listAllAction_rowNum}" class="nascosto">Seleziona</label>
					
					<form:checkbox path="idActionProfilo" value="${listAllAction.id}" cssClass="checkPlut optim"/> 
					</demdec:displaytag-column>
					
					<demdec:displaytag-column property="codiAction" titleKey="label.codiAction"/>
					
					<demdec:displaytag-column property="descAction" titleKey="label.descAction"/>
		
				</demdec:displaytag-table>
				
			
			<div class="spacer_sm">&nbsp;</div>
			
					<div class="center small">
				
				      	 <demdec:submit keyValue="button.salva" controllerCode="creaProfilo" />
				      	 
				      	 <demdec:submit keyValue="label.clean" controllerCode="pulisci" />
				      	 
				      	 <demdec:submit keyValue="label.back" controllerCode="tornaIndietroListaProfili" styleClass="button small"/>
				</div> 

		 
		</c:if>


<c:if test="${not empty f.selectedProfilo}">
	
		<demdec:displaytag-table name="pageScope.listAllAction" id="listAllAction" class="lux width100">
			
			<display:caption>
				<span class="nascosto"><strong> <spring:message code="label.title.gestioneProfili"></spring:message></strong></span>
			</display:caption>
			<demdec:displaytag-column titleKey="" title="<input type='checkbox' id='selectall' title='Seleziona tutti' class='optim'/>" class="center">
				<label for="radio_${listAllAction_rowNum}" class="nascosto">Seleziona</label>
				<form:checkbox path="idActionProfilo" value="${listAllAction.id}" cssClass="checkPlut optim"/> 
			</demdec:displaytag-column>
			<demdec:displaytag-column property="codiAction" titleKey="label.codiAction"/>
			<demdec:displaytag-column property="descAction" titleKey="label.descAction"/>

		</demdec:displaytag-table>
	
	<div class="spacer_sm">&nbsp;</div>
	<div class="spacer_sm">&nbsp;</div>
	
		<div class="center small">  	 
	   	 	<demdec:submit keyValue="label.modify" controllerCode="modificaProfilo" />
	   	 	<demdec:submit keyValue="label.back" controllerCode="tornaIndietroListaProfili" styleClass="button small"/>
		</div>

 	

 	</c:if>


         
      </div>
  	</div>
 	


