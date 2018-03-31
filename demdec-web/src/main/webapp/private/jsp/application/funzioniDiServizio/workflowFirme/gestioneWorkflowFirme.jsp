<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%> 
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- PageName = gestioneWorkflowFirme -->
<nssb:useAttribute id="listaModelliIter" name="<%=SessionAttributes.LIST_ANAG_MODELLI_ITER%>"></nssb:useAttribute>
<tiles:insertAttribute name="modalDettModelloIter" flush="false"/>
<tiles:insertAttribute name="modalTipologieAssociate" flush="false"/>

 <div class="overlay"></div>
 
<div class="spacer_sm">&nbsp;</div>

<c:if test="${not empty listaModelliIter}">

		<div class="title_doc"><spring:message code="label.title.lista.modelli.iter"></spring:message></div>

		<nssb:displaytag-table name="pageScope.listaModelliIter" id="listaModelliIter" class="width100" >
			<display:caption>
				<span class="nascosto"> 
					<strong> <spring:message code="label.title.lista.modelli.iter"></spring:message></strong>
				</span>
			</display:caption>

			<nssb:displaytag-column property="descIter" titleKey="label.modello.iter"  class="width100"/>
			
			<demdec:displaytag-column titleKey="label.workflow.visualizza" class="center">
				<a href="javascript: caricaPopup('contModal_0', '${listaModelliIter.id}', 'modaleModelliWorkflow'); " >
					<img class="padd_sx_logo" src="<c:url value="/public/img/ico_view_det.png"/>" alt="vaiVis" title="Visualizzazione Workflow">
				</a>
			</demdec:displaytag-column>
			
			<demdec:displaytag-column titleKey="label.workflow.visualizza.tipologie" class="center">
				<a href="javascript: caricaTipologie('contModal_1', '${listaModelliIter_rowNum -1}'); " >
					<img class="padd_sx_logo" src="<c:url value="/public/img/ico_view_det.png"/>" alt="vaiVis" title="Visualizzazione Tipologie">
				</a>
			</demdec:displaytag-column>
			
			<demdec:displaytag-column titleKey="label.modify" class="center">
				<demdec:submit styleId="btnUpd${listaModelliIter_rowNum}" styleClass="subm_none_upd" keyValue="label.empty" titleKey="label.modify" controllerCode="modificaModelloIter?rowNum=${listaModelliIter_rowNum -1 }" />
			</demdec:displaytag-column>
			
			 <demdec:displaytag-column titleKey="label.delete" class="center">
				<demdec:submit styleId="btnDel${listaModelliIter_rowNum}" styleClass="subm_none_del" keyValue="label.empty" titleKey="label.delete" controllerCode="eliminaModelloIter?selectedModello=${listaModelliIter_rowNum -1}" onclick="javascript:return confirm('Conferma cancellazione');"/>
				<%-- <demdec:linkButton  action="${action}" imageKey="ico.document.delete" parameter="deleteDocFad" parameterValue="${listDocumenti_rowNum -1}" labelKey="label.delete"/> --%>
			</demdec:displaytag-column> 
			
		</nssb:displaytag-table>

	<div class="left small">
	   	 <demdec:submit keyValue="label.new" controllerCode="nuovoModelloIter" />
	   	 <div class="spacer_sm">&nbsp;</div>
	</div>
	
</c:if>
