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

<!-- PageName = gestioneListaUtenti -->
<nssb:useAttribute id="paginator" name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/>
<nssb:useAttribute id="listaUtenti" name="<%=SessionAttributes.LIST_UTENTI%>"></nssb:useAttribute>
<tiles:insertAttribute name="modalProfiliUtente" flush="false"/>

 <script type="application/javascript">
 var jsonData;
 </script>
<div class="overlay"></div>
<div class="spacer_sm">&nbsp;</div>
<c:if test="${not empty listaUtenti}">

<%-- <span class="nascosto">	
<div class="title_doc"><spring:message code="label.title.gestioneUtenti"></spring:message></div>
	<div class="spacer_sm_10">&nbsp;</div>

	<div class="center small">
	   	 <demdec:submit keyValue="label.new" controllerCode="gestioneNuovoUtente" />
	   	 <demdec:submit keyValue="label.modify" controllerCode="gestioneModificaUtente" />
	   	 <demdec:submit keyValue="label.delete" controllerCode="eliminaUtente"  onclick="javascript:return confirm('Conferma cancellazione');"/>
	</div>
</span> --%>
<div class="spacer_sm">&nbsp;</div>
		<nssb:displaytag-table name="pageScope.listaUtenti" id="listaUtenti" class="width100" >
			<display:caption>
						<span class="nascosto"><strong> <spring:message code="label.title.gestioneUtenti"></spring:message></strong></span>
			</display:caption>

			<%-- <nssb:displaytag-column class="center" title="<span class='nascosto'>Selezione</span>">
				<label for="radio_${listaUtenti_rowNum}" class="nascosto">Seleziona</label>
				<input type="radio" name="selectedCodiUtente" value="${listaUtenti.id}" id="radio_${listaUtenti_rowNum}" class="optim" />
			</nssb:displaytag-column> --%>
			<nssb:displaytag-column property="codiUtente" titleKey="label.oam" />
			<nssb:displaytag-column property="persCognome" titleKey="label.persCognome" />
			<nssb:displaytag-column property="persNome" titleKey="label.persNome" />

			<demdec:displaytag-column titleKey="label.utenti.visualizza.profili" class="center">
				<a href="javascript: caricaProfiliUtente('contModal_0', '${listaUtenti.id}'); " >
					<img class="padd_sx_logo" src="<c:url value="/public/img/ico_view_det.png"/>" alt="vaiVis" title="Visualizzazione Tipologie">
				</a>
			</demdec:displaytag-column>
			
			<demdec:displaytag-column titleKey="label.modify" class="center">
				<demdec:submit styleId="btnUpd${listaUtenti_rowNum}" styleClass="subm_none_upd" keyValue="label.empty" titleKey="label.modify" controllerCode="gestioneModificaUtente?selectedCodiUtente=${listaUtenti.id }" />
			</demdec:displaytag-column>
			
			 <demdec:displaytag-column titleKey="label.delete" class="center">
				<demdec:submit styleId="btnDel${listaUtenti_rowNum}" styleClass="subm_none_del" keyValue="label.empty" titleKey="label.delete" controllerCode="eliminaUtente?selectedCodiUtente=${listaUtenti.id}" onclick="javascript:return confirm('Conferma cancellazione');"/>
			</demdec:displaytag-column> 

		</nssb:displaytag-table>
	

	<div class="left small">
	   	 <demdec:submit keyValue="label.new" controllerCode="gestioneNuovoUtente" />
	   	<%--  <demdec:submit keyValue="label.modify" controllerCode="gestioneModificaUtente" />
	   	 <demdec:submit keyValue="label.delete" controllerCode="eliminaUtente"  onclick="javascript:return confirm('Conferma cancellazione');"/> --%>
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
