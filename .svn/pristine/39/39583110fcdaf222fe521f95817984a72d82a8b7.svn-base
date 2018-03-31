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

<!-- PageName = gestioneListaProfili -->
<nssb:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/>
<nssb:useAttribute id="listaProfili" name="<%=SessionAttributes.LIST_PROFILI%>"></nssb:useAttribute>

<div class="spacer_sm">&nbsp;</div>

<c:if test="${not empty listaProfili}">
<%-- <span class="nascosto">	
	<div class="title_doc"><spring:message code="label.title.gestioneProfili"></spring:message></div>
	<div class="spacer_sm">&nbsp;</div>
	<div class="spacer_sm">&nbsp;</div>

	<div class="center small">
	   	 <demdec:submit keyValue="label.new" controllerCode="gestioneProfilo" />
	   	 <demdec:submit keyValue="label.modify" controllerCode="gestioneModificaProfilo" />
	   	 <demdec:submit keyValue="label.delete" controllerCode="eliminaProfilo"  onclick="javascript:return confirm('Conferma cancellazione');"/>
	</div>
</span>	 --%>	
		<nssb:displaytag-table name="pageScope.listaProfili" id="listaProfili" class="width100" >
			<display:caption>
						<span class="nascosto"><strong> <spring:message code="label.title.gestioneProfili"></spring:message></strong></span>
			</display:caption>

			<%-- <nssb:displaytag-column class="center" title="<span class='nascosto'>Selezione</span>">
				<label for="radio_${listaProfili_rowNum}" class="nascosto">Seleziona</label>
				<input type="radio" name="selectedProfilo" value="${listaProfili.id}" id="radio_${listaProfili_rowNum}" class="optim" />
			</nssb:displaytag-column> --%>
			<nssb:displaytag-column property="codiProfilo" titleKey="label.codiProfilo" class="center"/>
			<nssb:displaytag-column property="descProfilo" titleKey="label.descProfilo"/>


 			<demdec:displaytag-column titleKey="label.modify" class="center">
				<demdec:submit styleId="btnUpd${listaProfili_rowNum}" styleClass="subm_none_upd" keyValue="label.empty" titleKey="label.modify" controllerCode="gestioneModificaProfilo?selectedCodiProfilo=${listaProfili.id }" />
			</demdec:displaytag-column>
			
			 <demdec:displaytag-column titleKey="label.delete" class="center">
				<demdec:submit styleId="btnDel${listaProfili_rowNum}" styleClass="subm_none_del" keyValue="label.empty" titleKey="label.delete" controllerCode="eliminaProfilo?selectedCodiProfilo=${listaProfili.id}" onclick="javascript:return confirm('Conferma cancellazione');"/>
			</demdec:displaytag-column>
			
		</nssb:displaytag-table>
	
	<div class="left small">
	   	 <demdec:submit keyValue="label.new" controllerCode="gestioneProfilo" />
	   	 <%-- <demdec:submit keyValue="label.modify" controllerCode="gestioneModificaProfilo" />
	   	 <demdec:submit keyValue="label.delete" controllerCode="eliminaProfilo"  onclick="javascript:return confirm('Conferma cancellazione');"/> --%>
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
