<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%> 
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- PageName = creazioneTipologiaDecreto -->
<nssb:useAttribute id="listaTipoDecreto" name="<%=SessionAttributes.LIST_TIPI_DECRETI%>"></nssb:useAttribute>
<nssb:useAttribute id="listaModelliIter" name="<%=SessionAttributes.LIST_ANAG_MODELLI_ITER%>"></nssb:useAttribute>


<div class="row">
	<div class="large-12 columns">
	</div>
	<div class="large-12 columns">
		<div class="spacer_sm">&nbsp;</div>
		<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
		<fieldset>
		<form:hidden path="selectedTipologia"/>
			<div class="row">  
				<div class="small-6 columns">
					<demdec:label path="descTipologia" labelKey="label.descr.tipologia.decreto.obb"></demdec:label> 
					<form:input path="descTipologia" maxlength="80"/>        
				</div>
			</div>
	
			<div class="row">
				<div class="small-3 columns">
				 	<demdec:label path="tipoDecreto"  labelKey="label.tipo.decreto.obb"/>
					<form:select path="tipoDecreto" >
						<form:option value="" >&nbsp;</form:option>
						<c:forEach var="msg" items="${listaTipoDecreto}">
							<form:option value="${msg.id}" >${msg.descSigla} </form:option>
						</c:forEach> 
					</form:select> 
				</div> 
			</div>
	
			<div class="row">
				<div class="small-5 columns">
			 		<demdec:label path="modelloIter"  labelKey="label.modello.iter.obb"/>
					<form:select path="modelloIter" >
						<form:option value="" >&nbsp;</form:option>
						<c:forEach var="msg" items="${listaModelliIter}">
							<form:option value="${msg.id}" >${msg.descIter} </form:option>
						</c:forEach> 
					</form:select> 
				</div> 
			</div>
	
			<div class="row">
				<div class="small-10 columns">
					<demdec:submit keyValue="label.confirm" controllerCode="confermaModificaDecreto" />
					<demdec:submit keyValue="label.back" controllerCode="back" />
				</div>
			</div>
		</fieldset>
	</div>
</div>
	