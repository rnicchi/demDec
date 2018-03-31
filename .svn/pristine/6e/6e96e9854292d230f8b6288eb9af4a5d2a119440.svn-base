<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%> 
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="it.mef.bilancio.demdec.utils.Constants"%>

<!-- PageName = creazioneWorkflowFirme -->
<nssb:useAttribute id="listaAnagFirmatari" name="<%=SessionAttributes.LIST_ANAG_FIRMATARI%>"></nssb:useAttribute>

<div class="spacer_sm">&nbsp;</div>
<div class="large-12 columns">
	<c:if test="${not empty listaAnagFirmatari}">
	
		<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
		<fieldset>
			<form:hidden path="selectedModello"/>
			<div class="row">  
				<div class="small-6 columns">
					<%-- <demdec:label path="nuovoModello" labelKey="label.workflow.firme.nuovo.modello.obb"></demdec:label>  --%>
					<label for="nuovoModello"><spring:message code="label.workflow.firme.nuovo.modello.obb"/></label>
					<%-- <form:input path="nuovoModello" maxlength="80"/> --%>
					<form:input path="nuovoModello" maxlength="<%=Constants.LUNGHEZZA_MASSIMA_DESCR_MODELLO_ITER.toString()%>"/>
				</div>
			</div>
			<div class="row">
				<div class="small-6 columns">
			 		<%-- <demdec:label path="anagFirmatario"  labelKey="label.workflow.firme.primo.anag.firmatario.obb"/> --%>
			 		<label for="anagFirmatario"><spring:message code="label.workflow.firme.primo.anag.firmatario.obb"/></label>
					<form:select path="anagFirmatario" >
						<form:option value="" >&nbsp;</form:option>
						<c:forEach var="msg" items="${listaAnagFirmatari}">
							<form:option value="${msg.id}" >${msg.descFirmatario} - ${msg.descTipoFirma} </form:option>
						</c:forEach> 
					</form:select> 
				</div> 
			</div>

			<br>

			<div class="row">
				<div class="small-10 columns">
					<demdec:submit keyValue="label.confirm" controllerCode="confermaModelloIter" />
					<demdec:submit keyValue="label.back" controllerCode="back" />
				</div>
			</div>

		</fieldset>
	</c:if>

<div class="spacer_sm">&nbsp;</div>
<div class="spacer_sm">&nbsp;</div>
</div>
