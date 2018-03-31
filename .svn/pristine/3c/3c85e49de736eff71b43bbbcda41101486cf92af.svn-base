<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>

<%-- <%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
 --%>
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
				<label for="tipoDecreto"><spring:message code="label.tipoDecreto"/></label>
				<form:select path="tipoDecreto">
					<form:option value="">&nbsp;</form:option>
					<c:forEach items="${tipoDecretoList}" var="item">
						<form:option value="${item.id}">${item.descSigla} </form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<div class="small-4 columns">
				<label for="numeDecreto"><spring:message code="label.numeroDecreto"/></label>
				<form:input path="numeDecreto" maxlength="6"/>
			</div>
			
			<div class="small-4 columns">
				<label for="annoDecreto"><spring:message code="label.decreto.anno.obb"/></label>
				<form:select path="annoDecreto"   > 
	          		<c:forEach var="item" items="${listAnniEser}">		
						 <form:option value="${item.id}" >${item.id} </form:option> 
					</c:forEach>    		
        	 	</form:select>  
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="left">
        	<demdec:submit keyValue="button.load" controllerCode="caricaTipologiaDecreto" titleKey="label.carica.tipologia" styleClass="subm_update posit-butt_up"  />
        </div>
		
		<div class="small-5 columns">
			<label for="tipologiaDecreto"><spring:message code="label.tipologiaDecreto"/></label>
			<form:select path="tipologiaDecreto">
				<form:option value="" label="-- Selezionare una tipologia --" />
				<c:forEach var="item" items="${tipologiaDecretoLis}" >
					<form:option value="${item.id}">${item.descTipologia}</form:option>
				</c:forEach>
			</form:select>
		</div>
	</div>
	
	<div class="row">
	    <div class="left">
		    <demdec:submit titleKey="label.carica.amm" keyValue="button.load" controllerCode="caricaAmministrazioni"  styleClass="subm_update posit-butt_up"/>
		</div>
	    <div class="small-10 columns">
		    <label for="amministrazione"><spring:message code="label.amministrazione"/></label>
   			<form:select path="amministrazione" >
   				<form:option value="" label="-- Selezionare un'amministrazione --"/>
   				<c:forEach var="item" items="${ammList}" varStatus="st">
					<form:option value="${item.id.ammin}">${item.id.ammin} - ${item.descAmm}</form:option>
   				</c:forEach>
   				<%-- <c:forEach var="item" items="${amministrazioneList}">
   					<form:option value="${item.id.ammin}" >${item.id.ammin} - ${item.descAmm}</form:option>
   				</c:forEach> --%>
   			</form:select>
				    
	    </div>
	</div>

	<div class="row">
		
		<div class="small-4 columns">
			 <label for="ufficio"><spring:message code="label.ufficioCapofila"/></label>
   			<form:select path="ufficio" >
   				<form:option value="" label="-- Selezionare un ufficio --"/>
   				<c:forEach var="item" items="${ufficioCapofilaListList}">
   					<form:option value="${item.id}" >${item.descUfficio}</form:option>
   				</c:forEach>
   			</form:select>
		</div>
		<div class="small-4 columns">
			<label for="stato"><spring:message code="label.stato"/></label>
			<form:select path="stato" >
				<form:option value="" label="-- Selezionare uno stato --"/>
				<c:forEach var="item" items="${anagStatiFascList}">
					<form:option value="${item.statStato}" >${item.descStato} </form:option>
				</c:forEach>
			</form:select>
		</div>
		<div class="small-4 columns">
		</div>
	</div>
	
	<div class="row">
		<div class="small-4 columns">
			<label for="numePat"><spring:message code="label.numeroPatrimonio"/></label>
			<form:input path="numePat" maxlength="5" />
		</div>
	</div>
	
	<div class="row">
		<div class="small-4 columns">
			<label for="dataArrivoDa"><spring:message code="label.raccolteProvvisorie.dataCreazioneDa"/></label>
			<form:input path="dataArrivoDa" type="text" placeholder="gg/mm/aaaa" maxlength="10"/>
		</div>
		<div class="small-4 columns">
			<label for="dataArrivoA"><spring:message code="label.raccolteProvvisorie.dataCreazioneA"/></label>
			<form:input path="dataArrivoA" type="text" placeholder="gg/mm/aaaa" maxlength="10"/>
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
			<demdec:submit keyValue="label.filtro.data" controllerCode="eseguiRicerca" styleId="btnRicerca" />
			&nbsp;
			<demdec:submit keyValue="label.clean" controllerCode="nuovaRicerca" />
		</div>
	</div>
	
</fieldset>



