<%@ page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@ page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display-el"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<demdec:useAttribute id="listAnniEser" name="<%=SessionAttributes.LIST_ANNO_ESE%>"/> 
<demdec:useAttribute id="tipoDecretoList" name="<%=SessionAttributes.LIST_TIPI_DECRETI%>" />
<demdec:useAttribute id="statiFascList" name="<%=SessionAttributes.LIST_ANAG_STATI_FASC%>" />
<demdec:useAttribute id="firmatariList" name="<%=SessionAttributes.LIST_ANAG_FIRMATARI%>" />

<script type="application/javascript">


$(document).ready(function() {
    
    $("#btnRicerca").click(function() {
        $('body').css("cursor", "wait");
    });
});
</script>


<div class="row">

	<div class="large-12 columns">
		<div class="spacer_sm">&nbsp;</div>
		<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
	</div>
	
</div>

<fieldset>
	<div class="container_field"> 
		<div class="row"> 
			<div class="small-4 columns">
				<demdec:label path="tipoDecreto" labelKey="label.tipoDecreto"/>
				<form:select path="tipoDecreto">
					<form:option value="">&nbsp;</form:option>
					<c:forEach items="${tipoDecretoList}" var="item">
						<form:option value="${item.id}">${item.descSigla} </form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<div class="small-4 columns">
				<demdec:label path="numeDecreto" labelKey="label.numeroDecreto"/>
				<form:input path="numeDecreto" maxlength="6"/>
			</div>
			
			<div class="small-4 columns">
				<demdec:label path="annoDecreto" labelKey="label.decreto.anno.obb"/>
				<form:select path="annoDecreto"   > 
	          		<c:forEach var="item" items="${listAnniEser}">		
						 <form:option value="${item.id}" >${item.id} </form:option> 
					</c:forEach>    		
	       	 	</form:select>  
			</div>
		</div>
	</div>

	<div class="row">
		<div class="small-4 columns">
			<demdec:label path="allaFirma" labelKey="label.monitoraggioFirma.allaAttenzioneDi"/>
			<form:select path="allaFirma"   > 
				<form:option value="">---Seleziona un Firmatario---</form:option>
	       		<c:forEach var="item" items="${firmatariList}">		
			 		<form:option value="${item.descFirmatario}" >${item.descFirmatario} </form:option> 
				</c:forEach>    		
	   	 	</form:select>
		</div>
		<div class="small-4 columns">
			<demdec:label path="firmato" labelKey="label.monitoraggioFirma.approvatoDa"/>
			<form:select path="firmato"   >
				<form:option value="">---Seleziona un Firmatario---</form:option>
	       		<c:forEach var="item" items="${firmatariList}">		
			 		<form:option value="${item.descFirmatario}" >${item.descFirmatario} </form:option> 
				</c:forEach>    		
	   	 	</form:select>
		</div>
		<div class="small-4 columns">
			<demdec:label path="statoFascicolo" labelKey="label.monitoraggioFirma.statoFascicolo"/>
			<form:select path="statoFascicolo"   >
				<form:option value="">---Seleziona uno Stato---</form:option>
	       		<c:forEach var="item" items="${statiFascList}">		
			 		<form:option value="${item.statStato}" >${item.descStato} </form:option> 
				</c:forEach>    		
	   	 	</form:select>
		</div>
		
	</div>
	
	<div class="row">
		<div class="small-10 columns">
			<demdec:submit keyValue="label.filtro.data" controllerCode="eseguiRicerca" styleId="btnRicerca" />
			&nbsp;
			<demdec:submit keyValue="label.clean" controllerCode="pulisci" />
		</div>
	</div>
	
</fieldset>