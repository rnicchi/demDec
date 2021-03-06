  <%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!-- PageName = listaFirmatari.jsp -->
 <tiles:useAttribute name="action" classname="java.lang.String" />
 
  <demdec:useAttribute id="listFirmatari" name="<%=WebConstants.LIST_FIRMATARI%>"/>  
  
  <demdec:useAttribute id="tipo" name="<%=WebConstants.TIPO %>"/> 
  <demdec:useAttribute id="numero" name="<%=WebConstants.NUMERO %>"/> 
  <demdec:useAttribute id="anno" name="<%=WebConstants.ANNO %>"/>  
  
  
<script type="application/javascript">

$(document).ready(function() {

    $("#btnRicercaFirmat").click(function() {

        $('body').css("cursor", "wait");

    });

});

</script>
  
  <div class="spacer_sm">&nbsp;</div>
  <div class="spacer_sm">&nbsp;</div>
  
  <div class="center padd-bott_5 font_size_riep">
    <span>&#8226; Tipo: </span>
    <span class="col_char_user"><strong>${tipo}</strong></span> 
  
    <span>&#8226; Numero:</span>
    <span class="col_char_user"><strong>${numero}</strong></span> 
   
    <span>&#8226; Anno:</span>
    <span class="col_char_user"><strong>${anno}</strong></span> 
    
  </div>
  
  <div>
	  
 
 <c:if test="${not empty listFirmatari}">
<div class="spacer_sm_10">&nbsp;</div>
   <demdec:displaytag-table   name="pageScope.listFirmatari" id="listFirmatari"   class="lux tableDati marg_0px_auto width100" >
  		
  		<display:caption><span class="nascosto">Tabella firmatari</span></display:caption>
   		
			
			<demdec:displaytag-column property="numeroOrdineFirma" titleKey="label.invioAlleFirme.numeroOrdineFirma"  headerClass="center" class="center" />
			<demdec:displaytag-column  titleKey="label.invioAlleFirme.firmatario" headerClass="center">
				<c:choose>
				    <c:when test="${listFirmatari.amministrazione == null}">
				    		 ${listFirmatari.descFirmatario}
				    </c:when>
				    <c:otherwise>
				   			<%--  ${listFirmatari.descFirmatario.concat(' - ').concat(listFirmatari.amministrazione)} --%>
				   			  ${listFirmatari.descFirmatario}  -  ${listFirmatari.amministrazione}
				    </c:otherwise>
				</c:choose>
			</demdec:displaytag-column>
			<demdec:displaytag-column property="tipoSegnatura" titleKey="label.invioAlleFirme.tipoSegnatura" headerClass="center" />
		   <%--  <demdec:displaytag-column sortName="amministrazione"  property="amministrazione" titleKey="label.raccolteProvvisorie.amministrazione" headerClass="center" />
			 --%> 
			<demdec:displaytag-column property="ufficio" titleKey="label.invioAlleFirme.ufficio" headerClass="center"   />
						
	
	</demdec:displaytag-table>
	<div class="spacer_sm">&nbsp;</div>
	<div class="spacer_sm">&nbsp;</div>
<div class="text-center">
     <%-- <button type="button" class="button small" onClick="javascript:apriPopUpModale('invio_a_firme_2.htm');">Generazione firme</button>--%>
      <demdec:submit keyValue="button.generazioneFirme" controllerCode="generazioneFirme"   styleClass="button small"  styleId="btnRicercaFirmat"/>
     <%--  <button type="button" class="button small" onclick="javascript: document.location = 'invio_a_firme.htm';">Indietro</button> --%>
       <demdec:submit keyValue="button.back" controllerCode="pulisci"   styleClass="button small"/>
</div>
	</c:if>

	<div id="emptyList">
	<c:if test="${empty listFirmatari}">
		<spring:message code="info.noDataFound"></spring:message>
	</c:if>
	</div> 
	
 </div>