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

<!-- PageName = gestioneTipologiaDecreto -->
<nssb:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/>
<nssb:useAttribute id="listaTipologiaDecreto" name="<%=SessionAttributes.LIST_ANAG_TIPOLOGIA_DECRETO%>"></nssb:useAttribute>
<tiles:insertAttribute name="modalDettModelloIter" flush="false"/>

<div class="spacer_sm">&nbsp;</div>

 <div class="overlay"></div>
<c:if test="${not empty listaTipologiaDecreto}">

	<div class="title_doc"><spring:message code="label.title.lista.tipologia.decreto"></spring:message></div>
	<div class="spacer_sm_10">&nbsp;</div>

		<nssb:displaytag-table name="pageScope.listaTipologiaDecreto" id="listaTipologiaDecreto" class="width100 lux" >
			<display:caption>
						<span class="nascosto"><strong> <spring:message code="label.title.lista.tipologia.decreto"></spring:message></strong></span>
			</display:caption>

		<%-- 	<nssb:displaytag-column headerClass="nascosto" title="Selezione" >
				<label for="radio_${listaTipologiaDecreto_rowNum}" class="nascosto">Seleziona</label>
				<input type="radio" name="selectedTipologia" value="${listaTipologiaDecreto.id}" id="radio_${listaTipologiaDecreto_rowNum}" />
			</nssb:displaytag-column> --%>
			
			<nssb:displaytag-column property="descTipologia" titleKey="label.tipologia.decreto" />
			<nssb:displaytag-column property="anagModelliIter.descIter" titleKey="label.modello.iter.workflow"  />
			
			<demdec:displaytag-column titleKey="label.workflow.visualizza" class="center ">
				<a href="javascript: caricaPopup('contModal_0', '${listaTipologiaDecreto.anagModelliIter.id}', 'modaleGestTipologiaDecr'); " >
					<img class="padd_sx_logo" src="<c:url value="/public/img/ico_view_det.png"/>" alt="vaiVis" title="Visualizzazione Workflow">
				</a>
			</demdec:displaytag-column>
			
			<demdec:displaytag-column titleKey="label.modify" class="center">
				<demdec:submit styleId="btnUpd${listaTipologiaDecreto_rowNum}" styleClass="subm_none_upd" keyValue="label.empty" titleKey="label.modify" controllerCode="modificaDecreto?rowNum=${listaTipologiaDecreto_rowNum-1}" />
			</demdec:displaytag-column>
			
			 <demdec:displaytag-column titleKey="label.delete" class="center">
				<demdec:submit styleId="btnDel${listaTipologiaDecreto_rowNum}" styleClass="subm_none_del" keyValue="label.empty" titleKey="label.delete" controllerCode="eliminaDecreto?selectedTipologia=${listaTipologiaDecreto.id}" onclick="javascript:return confirm('Conferma cancellazione');"/>
			</demdec:displaytag-column> 

		</nssb:displaytag-table>

	<div class="left small">
	   	 <demdec:submit keyValue="label.new" controllerCode="gestioneCreazioneDecreto" />
	</div>

</c:if>
	

<c:if test="${paginator ne null}">
	 <div>&nbsp;</div>
     <div class="center color_grey">
         <nssb:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
         				 paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
                         paginatorName="<%=Paginator.PAGINATOR_NAME%>"
                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" 
         />
	</div>                       
</c:if>
