<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>

<%-- <%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
 --%>
 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- PageName = ricercaFAD.jsp -->
<!-- Controller  ConsultaFascicoloFadController-->

<demdec:useAttribute id="listAnniEser" name="<%=SessionAttributes.LIST_ANNO_ESE%>"/> 
<demdec:useAttribute id="tipoDecretoList" name="<%=SessionAttributes.LIST_TIPI_DECRETI%>" /> 
<demdec:useAttribute id="tipologiaDecretoLis" name="<%=SessionAttributes.LIST_TIPOLOGIA_DECRETO%>"/> 
<demdec:useAttribute id="ammList" name="<%=SessionAttributes.LIST_AMMIN_DEM%>"/>  
<demdec:useAttribute id="ufficioCapofilaListList" name="<%=SessionAttributes.LIST_ANAG_UFF%>"/>  
<demdec:useAttribute id="anagStatiFascList" name="<%=SessionAttributes.LIST_ANAG_STATI_FASC_MODIFICA%>"/>  
<demdec:useAttribute id="cdrList" name="<%=SessionAttributes.LIST_ANAG_CDR_DEM%>"/>  

<script type="application/javascript">


$(document).ready(function() {
    
    $("#btnRicerca").click(function() {
        $('body').css("cursor", "wait");
    });
});
</script>

<div class="overlay"></div>


<demdec:submit keyValue="label.filtro.data" controllerCode="eseguiRicerca" styleClass="button  nascosto"/>

<div class="spacer_sm">&nbsp;</div>
<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>

<fieldset>
  
	<div class="container_field"> 
		<div class="row"> 
			<div class="small-4 columns">
				<%-- <demdec:label path="tipoDecreto" labelKey="label.tipoDecreto"/> --%>
				<label for="tipoDecreto"><spring:message code="label.tipoDecreto"/></label>
				<form:select path="tipoDecreto">
					<form:option value="">&nbsp;</form:option>
					<c:forEach items="${tipoDecretoList}" var="item">
						<form:option value="${item.id}">${item.descSigla} </form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<div class="small-4 columns">
				<%-- <demdec:label path="numeDecreto" labelKey="label.numeroDecreto"/> --%>
				<label for="numeDecreto"><spring:message code="label.numeroDecreto"/></label>
				<form:input path="numeDecreto" maxlength="6"/>
			</div>
			
			<div class="small-4 columns">
				<%-- <demdec:label path="annoDecreto" labelKey="label.decreto.anno.obb"/> --%>
				<label for="annoDecreto"><spring:message code="label.decreto.anno.obb"/></label>
				<form:select path="annoDecreto"   > 
	          		<c:forEach var="item" items="${listAnniEser}">		
						 <form:option value="${item.id}" >${item.id} </form:option> 
					</c:forEach>    		
        	 	</form:select>  
			</div>
		</div>
	</div>
	
	<%-- <div class="row">
		<div class="left">
        	<demdec:submit keyValue="button.load" controllerCode="caricaTipologiaDecretoFadPage" titleKey="label.carica.tipologia" styleClass="subm_update posit-butt_up"  />
        </div>
		<div class="small-5 columns">
			<demdec:label path="tipologiaDecreto" labelKey="label.tipologiaDecreto" />
			<form:select path="tipologiaDecreto">
				<form:option value="" label="-- Selezionare una tipologia --" />
				<c:forEach var="item" items="${tipologiaDecretoLis}" >
					<form:option value="${item.id}">${item.descTipologia}</form:option>
				</c:forEach>
			</form:select>
		</div>
	</div> --%>
	
	<div class="row">
	    <div class="left">
		    <demdec:submit titleKey="label.carica.amm" keyValue="button.load" controllerCode="caricaAmministrazioni"  styleClass="subm_update posit-butt_up"/>
		</div>
	    <div class="small-9 columns">
		   <%--  <demdec:label path="amministrazione" labelKey="label.amministrazione"/> --%>
		    <label for="amministrazione"><spring:message code="label.amministrazione"/></label>
   			<form:select path="amministrazione" >
   				<form:option value="" label="-- Selezionare un'amministrazione --"/>
   				<c:forEach var="item" items="${ammList}" varStatus="st">
					<form:option value="${item.id.ammin}">${item.id.ammin} - ${item.descAmm}</form:option>
   				</c:forEach>
   				
   				</form:select>
   			
	    </div>
	</div>

	<div class="row">
		
		<div class="small-4 columns">
			<%-- <demdec:label path="ufficio" labelKey="label.ufficioCapofila"/> --%>
			 <label for="ufficio"><spring:message code="label.ufficioCapofila"/></label>
   			<form:select path="ufficio" >
   				<form:option value="" label="-- Selezionare un ufficio --"/>
   				<c:forEach var="item" items="${ufficioCapofilaListList}">
   					<form:option value="${item.id}" >${item.descUfficio}</form:option>
   				</c:forEach>
   			</form:select>
		</div>
		<%-- <div class="small-4 columns">
		</div>
	
		<div class="small-4 columns left">
			<demdec:label path="numePat" labelKey="label.numeroPatrimonio"/>
			<form:input path="numePat" maxlength="5" />
		</div> --%>
	</div>
	
	<div class="row">
		<div class="small-4 columns">
			<%-- <demdec:label path="dataRegistrazioneCdcDa" labelKey="label.invioPecPartecipazione.dataRegistrazioneCdcDa"/> --%>
			<label for="dataRegistrazioneCdcDa"><spring:message code="label.invioPecPartecipazione.dataRegistrazioneCdcDa"/></label>
			<form:input path="dataRegistrazioneCdcDa" type="text" placeholder="gg/mm/aaaa" maxlength="10"/>
		</div>
		<div class="small-4 columns">
			<%-- <demdec:label path="dataRegistrazioneCdcA" labelKey="label.invioPecPartecipazione.dataRegistrazioneCdcA"/> --%>
			<label for="dataRegistrazioneCdcA"><spring:message code="label.invioPecPartecipazione.dataRegistrazioneCdcA"/></label>
			<form:input path="dataRegistrazioneCdcA" type="text" placeholder="gg/mm/aaaa" maxlength="10"/>
		</div>
		<div class="small-4 columns">
		</div>
		<script src="/demdec-web/private/js/modernizr.js"></script>         
		<script>
			Modernizr.load({
			             test: Modernizr.inputtypes.date,
			             nope: "/demdec-web/private/js/jquery-ui.custom.js",
			             callback: function() {
			               $("input[type=date]").datepicker();
			             }
			});
		</script>
		<br>
	</div>
	
	<div class="row">
		<div class="small-10 columns">
			<demdec:submit keyValue="label.filtro.data" controllerCode="ricercaDecreti" styleId="btnRicerca" />
			&nbsp;
			<demdec:submit keyValue="label.clean" controllerCode="nuovaRicerca" />
		</div>
	</div>
	
</fieldset>

<%-- <c:if test='${decretoList != null}'>
    
        <tiles:insertAttribute name="predLettereListaDecreti"/> 
        
    
</c:if> --%>




   

