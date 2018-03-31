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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<demdec:useAttribute id="paginator" name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/>
<demdec:useAttribute id="listDecretiMonitoraggio" name="<%=SessionAttributes.LIST_DECRETI_MONITORAGGIO_FIRMA%>"/>
<demdec:useAttribute id="listIterFirma" name="<%=SessionAttributes.LIST_ITER_FIRMA_DECRETO%>"/>

<demdec:useAttribute id="fascicoloSel" name="<%=SessionAttributes.FASCICOLO_SELEZIONATO%>"/>


<tiles:useAttribute name="action"/>


<script type="application/javascript">


$(document).ready(function() {
    
    $("#btnIndietro").click(function() {
        $('body').css("cursor", "wait");
    });
});
</script>

<div class="overlay"></div>
<div class="spacer_sm">&nbsp;</div>
<div class="center padd-bott_5 font_size_riep">
    <span>&#8226; Tipo: </span>
    <span class="col_char_user"><strong>${fascicoloSel.anagTipologiaDecreto.anagTipoDecreto.descSigla}</strong></span> 
  
    <span>&#8226; Numero:</span>
    <span class="col_char_user"><strong>${fascicoloSel.numeNumDecreto}</strong></span> 
   
    <span>&#8226; Anno:</span>
	<span class="col_char_user"><strong>${fascicoloSel.eserciziDem.id}</strong></span>    
</div>


<!-- <div class="scroll_table_gen"> -->

	
	<c:if test="${not empty listIterFirma}">

		<demdec:displaytag-table class="lux tableDati width100" name="pageScope.listIterFirma" id="listIter" >
		
			<display:caption>
				<span class="nascosto"><spring:message code="label.monitoraggioFirma.caption.table"/></span>
			</display:caption>
			
			<demdec:displaytag-column titleKey="label.dettaglioFirma.table.ordine" property="numeOrdineIter" class="center"/>
			<%-- <demdec:displaytag-column titleKey="label.dettaglioFirma.table.segnatura">
			
				<c:if test="${listIter.codiTipoFirma eq 'F'}">Firma</c:if>
				<c:if test="${listIter.codiTipoFirma eq 'S'}">Sigla</c:if>
				<c:if test="${listIter.codiTipoFirma eq 'B'}">Bollinatura</c:if>
				<c:if test="${listIter.codiTipoFirma eq 'V'}">Verifica</c:if>
			
			</demdec:displaytag-column> --%>
			<%-- <demdec:displaytag-column titleKey="label.dettaglioFirma.table.firmatario" property="anagFirmatari.descFirmatario" /> --%>
			<demdec:displaytag-column titleKey="label.dettaglioFirma.table.firmatario">
				
				<%-- <c:if test="${listIter.fascicoli.ufficioCapofila eq null}"> --%>
				<c:if test="${listIter.anagFirmatari.id eq 'UFF'}">
						${listIter.anagFirmatari.descFirmatario} - ${listIter.anagUffici.descUfficio}
				</c:if> 
				 <c:if test="${listIter.anagFirmatari.id ne 'UFF'}">
					<c:choose>
						<c:when test="${listIter.anagFirmatari.id eq 'MIN'}">
						     <c:if test="${listIter.anagAmminDem.id.numeStp<10}">
								${listIter.anagFirmatari.descFirmatario} - 0${listIter.anagAmminDem.id.numeStp}${listIter.anagAmminDem.id.numeApp}
							</c:if>
							<c:if test="${listIter.anagAmminDem.id.numeStp>=10}">
								${listIter.anagFirmatari.descFirmatario} - ${listIter.anagAmminDem.id.numeStp}${listIter.anagAmminDem.id.numeApp}
							</c:if>
						</c:when> 
						<c:otherwise>
								${listIter.anagFirmatari.descFirmatario}
						</c:otherwise>
					</c:choose>
				</c:if>  
				<%-- <c:if test="${listIter.fascicoli.ufficioCapofila ne null}">${listIter.anagFirmatari.descFirmatario} - ${listIter.fascicoli.ufficioCapofila.descUfficio}</c:if>		
			 --%>
			</demdec:displaytag-column>
			
			<demdec:displaytag-column titleKey="label.dettaglioFirma.table.stato" >
			 	 <c:if test="${listIter.statFirma eq '0'}">Da Firmare</c:if>
				 <c:if test="${listIter.statFirma eq '1'}">In firma</c:if>
				 <c:if test="${listIter.statFirma eq '2'}">
					<c:if test="${listIter.codiTipoFirma eq 'F'}">Firmato</c:if>
					<c:if test="${listIter.codiTipoFirma eq 'S'}">Siglato</c:if>
					<c:if test="${listIter.codiTipoFirma eq 'B'}">Bollinato</c:if>
					<c:if test="${listIter.codiTipoFirma eq 'V'}">Verificato</c:if>
				</c:if>  
				<c:if test="${listIter.statFirma eq '3'}">Sospeso</c:if>
			</demdec:displaytag-column>		
			
			<demdec:displaytag-column titleKey="label.dettaglioFirma.table.data" class="center">
			 	<fmt:formatDate pattern="dd/MM/yyyy"  value="${listIter.rowUpdatedDttm}" />
			</demdec:displaytag-column>		
		
		</demdec:displaytag-table>
	</c:if>

	
	<div class="row center">
		<demdec:submit keyValue="button.back" controllerCode="indietroLista" styleId="btnIndietro"/>
	</div>

<!-- </div> -->