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
<demdec:useAttribute id="anagStatiFascList" name="<%=SessionAttributes.LIST_ANAG_STATI_FASC%>"/>  
<demdec:useAttribute id="cdrList" name="<%=SessionAttributes.LIST_ANAG_CDR_DEM%>"/>
<demdec:useAttribute id="listFascicoliFad" name="<%=SessionAttributes.LIST_FASCICOLI_FAD%>"/>  



<tiles:useAttribute name="action"/>
<tiles:insertAttribute name="modalAmm" flush="false"/>

<div class="overlay"></div>

<div class="spacer_sm">&nbsp;</div>
<div>

	<c:if test="${not empty listFascicoliFad}">

		<demdec:displaytag-table class="lux tableDati width100" name="pageScope.listFascicoliFad" id="listFascicoliFad" >
				<display:caption>
					<span class="nascosto"><spring:message code="label.caption.table.fad"/></span>
				</display:caption>
				<%--			
				<demdec:displaytag-column title="">
					<form:radiobutton value="${listFascicoliFad_rowNum}"  path="radioButtonDecreti" class="center" />
			 		<demdec:submit styleClass="subm_folder" keyValue="label.empty" titleKey="alt.apri.fascicoloFad" controllerCode="apriFascicoloFad?idFad=${listFascicoliFad.id}"/>
			 </demdec:displaytag-column>
			--%>	
				<demdec:displaytag-column titleKey="label.raccolteProvvisorie.estremiStr" property="estremiStr">					
				</demdec:displaytag-column>
				<demdec:displaytag-column property="descDecreto" titleKey="label.raccolteProvvisorie.nome"/>					
				<demdec:displaytag-column titleKey="label.amministrazione" title="label.amministrazione" class="center">
				<c:choose>
				    <c:when test="${fn:length(listFascicoliFad.anagAmminDemList) eq 1}">
				    		${listFascicoliFad.amministrazione}
				    </c:when>
				    <c:otherwise>
				    		<a id="${listFascicoliFad_rowNum}" href="#" onclick="return caricaModaleListaAmministrazioni('contModal_01','${listFascicoliFad.id}');"><spring:message code="label.multiamministrazione"/></a>
				    </c:otherwise>
				</c:choose>
				</demdec:displaytag-column>
				
				<demdec:displaytag-column property="dataCreazioneFascicoloFormatted" titleKey="label.raccolteProvvisorie.dataModifica" />
				<demdec:displaytag-column property="ufficioCapofila.descUfficio" titleKey="label.raccolteProvvisorie.origineCreazione" />
				
	<%-- 			<demdec:displaytag-column titleKey="label.predLetterePreReg.visualizzaLettere" class="center color_grey">
					<demdec:linkButton imageKey="ico.modify" title="Personalizza Lettere" action="${action}" parameter="personalizza" parameterValue="${listFascicoliFad_rowNum-1}" />
				</demdec:displaytag-column> --%>
				
				<demdec:displaytag-column titleKey="label.predLetterePreReg.visualizzaLettere" class="center color_grey">
									<demdec:submit styleId="btnView${listFascicoliFad_rowNum}"   styleClass="subm_none_upd" keyValue="label.empty" title="Personalizza Lettera Decreto ${listFascicoliFad.estremiStr}" alt="Personalizza Lettera Decreto ${listFascicoliFad.estremiStr}" controllerCode="personalizza?${listFascicoliFad_rowNum-1}" />
				</demdec:displaytag-column>
				
				
				
		</demdec:displaytag-table>
				
				  <div class="row">			        	
		        		<demdec:submit keyValue="button.nuovaRicerca" controllerCode="nuovaRicerca" />
			     </div> 
			<c:if test="${paginator ne null}">
			     <div class="center color_grey">
			         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
			                         paginatorName="<%=Paginator.PAGINATOR_NAME%>"
			                         paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
			                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" 
			         />
			     </div>                       
			 </c:if>
			 
	</c:if>
</div>
