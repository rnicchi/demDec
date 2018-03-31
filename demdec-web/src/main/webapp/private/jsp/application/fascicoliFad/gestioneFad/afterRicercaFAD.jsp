<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- PageName = afterRicercaFAD.jsp -->
<!-- Controller  ConsultaFascicoloFadController-->
<demdec:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/> 

<demdec:useAttribute id="listAnniEser" name="<%=SessionAttributes.LIST_ANNO_ESE%>"/> 
<demdec:useAttribute id="tipoDecretoList" name="<%=SessionAttributes.LIST_TIPI_DECRETI%>" /> 
<demdec:useAttribute id="tipologiaDecretoLis" name="<%=SessionAttributes.LIST_TIPOLOGIA_DECRETO%>"/> 
<demdec:useAttribute id="amministrazioneList" name="<%=SessionAttributes.LIST_AMMIN_DEM%>"/>  
<demdec:useAttribute id="ufficioCapofilaListList" name="<%=SessionAttributes.LIST_ANAG_UFF%>"/>  
<demdec:useAttribute id="anagStatiFascList" name="<%=SessionAttributes.LIST_ANAG_STATI_FASC_MODIFICA%>"/>  
<demdec:useAttribute id="cdrList" name="<%=SessionAttributes.LIST_ANAG_CDR_DEM%>"/>
<demdec:useAttribute id="listFascicoliFad" name="<%=SessionAttributes.LIST_FASCICOLI_FAD%>"/>

<script type="application/javascript">

var jsonData;

$(document).ready(function() {

    $("#apriFascicolo").click(function() {
        $('body').css("cursor", "wait");
    });
   
});
</script>

<tiles:useAttribute name="action"/>
<tiles:insertAttribute name="modalFascFad" flush="false"/>

<div class="overlay"></div>

<%-- <div class="row">
	<div class="large-12 columns">
		<fieldset>
 			<div class="row">
				<div class="small-10 columns">
					<demdec:submit keyValue="button.nuovaRicerca" controllerCode="nuovaRicerca" />
				</div>
			</div>
		</fieldset>
	</div>
</div> --%>

<div class="spacer_sm">&nbsp;</div>

	<c:if test="${not empty listFascicoliFad}">
		
		<demdec:displaytag-table class="lux tableDati" name="pageScope.listFascicoliFad" id="listFascicoliFad" >
			<display:caption>
				<span class="nascosto"><spring:message code="label.caption.table.fad"/></span>
			</display:caption>
			<demdec:displaytag-column  title="<span class='nascosto'>Fascicolo Fad</span>" >
				<demdec:submit styleClass="subm_folder"  keyValue="label.empty" titleKey="alt.apri.fascicoloFad" controllerCode="apriFascicoloFad?idFad=${listFascicoliFad.id}"/>
			</demdec:displaytag-column>
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.estremiStr" property="estremiStr">
				<%-- <demdec:submit styleClass="nascosto" styleId="apri${listFascicoliFad.id}" keyValue="label.empty" controllerCode="apriFascicoloFad?idFad=${listFascicoliFad.id}" /> --%>
				<%-- <a href="javascript:this.document.getElementById('apri${listFascicoliFad.id}').click();">
					${listFascicoliFad.estremiStr} </a> --%>
			</demdec:displaytag-column>
			<demdec:displaytag-column property="descDecreto" titleKey="label.raccolteProvvisorie.nome"/>
				
			<demdec:displaytag-column sortName="amministrazione"
				property="amministrazione"
				titleKey="label.raccolteProvvisorie.amministrazione" class="center" />
			<demdec:displaytag-column property="dataCreazioneFascicoloFormatted"
				titleKey="label.raccolteProvvisorie.dataModifica" />
			<demdec:displaytag-column property="ufficioCapofila.descUfficio"
				titleKey="label.raccolteProvvisorie.origineCreazione" />
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center">
			    <a href="javascript:caricaModaleDettFascFad('contModal_01','${listFascicoliFad_rowNum-1}');">
					<img  src="<c:url value="/public/img/ico_view_det.png"/>" alt="Visualizza metadati Decreto ${listFascicoliFad.estremiStr}" title="Visualizza metadati Decreto ${listFascicoliFad.estremiStr}">
				</a>
			</demdec:displaytag-column>
		</demdec:displaytag-table>
			<c:if test="${paginator ne null}">
				 <div>&nbsp;</div>
			     <div class="center color_grey">
			         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
			                         paginatorName="<%=Paginator.PAGINATOR_NAME%>"
			                         paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
			                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" 
			         />
			         <div class="right">
					 	<demdec:submit keyValue="button.nuovaRicerca" controllerCode="nuovaRicerca" />
					 </div>
			     </div>                       
			 </c:if>   
	</c:if>
</div>

