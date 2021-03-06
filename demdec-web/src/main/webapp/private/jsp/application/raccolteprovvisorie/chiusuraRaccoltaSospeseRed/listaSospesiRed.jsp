
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@taglib prefix="form2" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- PageName = listaSospesiRed -->
 <tiles:useAttribute name="action" classname="java.lang.String" />
 
	<demdec:useAttribute id="listRaccolteProvvisorie" name="<%=SessionAttributes.LIST_RICERCA_RED%>"/>  
	<demdec:useAttribute id="listaRedDaSospendere" name="<%=SessionAttributes.LIST_SOSPENDIBILI_RED%>"/>  
	<demdec:useAttribute id="listaRedSospesi" name="<%=SessionAttributes.LIST_SOSPESI_RED%>"/>  
	<demdec:useAttribute id="paginator"     name="<%=SessionAttributes.PAGINATOR_SOSPENDIBILI_RED%>"/>
	<demdec:useAttribute id="paginator2"     name="<%=SessionAttributes.PAGINATOR_SOSPESI_RED%>"/>

<script type="application/javascript">
var jsonData;
</script>

 <!--**INIZIO INCLUDE MODALE modaleDettaglioFascicolo.jsp -->	
	<%@include file="/private/jsp/modal/modaleDettFascicoloSospesi.jsp" %>   
	<%@include file="/private/jsp/modal/modaleDettFascicoloChiusura.jsp" %>    
 <!--END INCLUDE MODALE  modaleDettaglioFascicolo.jsp -->

     <div class="overlay"></div>
     
<div class="spacer_sm">&nbsp;</div>
<div class="spacer_sm">&nbsp;</div>
<!--**INIZIO LISTA RED DA SOSPENDERE-->
	<c:if test="${not empty listRaccolteProvvisorie}">

			<c:if test="${not empty listaRedDaSospendere}">

				<div class="title_doc"><spring:message code="label.title.lista.sospesi.red"></spring:message></div>
				<div class="spacer_sm_10">&nbsp;</div>
				<demdec:displaytag-table  class="lux width100" name="pageScope.listaRedDaSospendere" id="listaRedDaSospendere">

					<display:caption>
						<span class="nascosto">
							<strong> <spring:message code="label.title.lista.sospesi.red" ></spring:message></strong>
						</span>
					</display:caption>

					<demdec:displaytag-column title="<span class='nascosto'>Sel.</span>">
						<span class="nascosto">
						<%--  <form2:label path="listaRedDaSospendere${listaRedDaSospendere_rowNum}" > </form2:label> --%>
							
							 <label for="listaRedDaSospendere${listaRedDaSospendere_rowNum}" class="nascosto"> Sel.</label> 
						</span>
						<form2:checkbox path="listaRedDaSospendere" value="${listaRedDaSospendere_rowNum-1}" class="optim"/>
					<!--	<form2:checkbox path="listaRedDaSospendere" value="${listaRedDaSospendere.idFascicoloRaccoltaProvvisoria}"/>	-->
					<!--	<input id="check_${row_rowNum}" name="< %=SessionAttributes.ROW%>" value="${row_rowNum-1}" type="checkbox" /> -->
					</demdec:displaytag-column>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.preView"  class="center">
 				<c:if test="${not empty listaRedDaSospendere.preView}">
					<a href="javascript: caricaModaleAnteprima('${listaRedDaSospendere_rowNum - 1}','<%=SessionAttributes.LIST_SOSPENDIBILI_RED%>'); " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_preview.png" alt="Visualizza Anteprima" title="Visualizza Anteprima">
					</a>			
				</c:if>
			</demdec:displaytag-column>
					<demdec:displaytag-column title="<span class='nascosto'>Visualizza cartella</span>">
						<demdec:submit styleClass="subm_folder" keyValue="label.empty"  controllerCode="apriDocumentiFascicolo?idRed=${listaRedDaSospendere.idFascicoloRaccoltaProvvisoria}"/>
					</demdec:displaytag-column>
					<demdec:displaytag-column property="identificativoRaccoltaProvvisoria" titleKey="label.idRed"/>
					<demdec:displaytag-column titleKey="label.protocolloRed">
						 	${listaRedDaSospendere.protocollo.numeroProtocollo}/<fmt:formatDate pattern="yyyy"  value="${listaRedDaSospendere.protocollo.data}" />
					</demdec:displaytag-column>
					<demdec:displaytag-column titleKey="label.raccolteProvvisorie.dataProtocolloIngr">
					 	 <fmt:formatDate pattern="dd/MM/yyyy"  value="${listaRedDaSospendere.protocollo.data}" />
					</demdec:displaytag-column>
					<demdec:displaytag-column property="descrizione" titleKey="label.raccolteProvvisorie.oggetto" />
					<demdec:displaytag-column sortName="amministrazione.code"  property="amministrazione.code" titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
					<%--  <demdec:displaytag-column property="codiStatoFascicoloDocumentale" titleKey="label.raccolteProvvisorie.statoLavorazione" />--%>
					<%-- <demdec:displaytag-column property="dataCreazione" titleKey="label.raccolteProvvisorie.dataCreazione"  format="{0,date,dd/MM/yyyy}" /> --%>
					<%-- <demdec:displaytag-column property="ufficioCreatoreRED.description" titleKey="label.raccolteProvvisorie.ufficioAssociato"  />
					<demdec:displaytag-column property="dataAggiornamento" titleKey="label.raccolteProvvisorie.dataModifica"  format="{0,date,dd/MM/yyyy}" />
					<demdec:displaytag-column property="sistemaProduttore" titleKey="label.raccolteProvvisorie.modificatoDa" /> --%>
					<demdec:displaytag-column property="descStatoFascicoloDocumentale" titleKey="label.raccolteProvvisorie.statoLavorazione" />
					
					<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center">
						<a href="javascript: caricaModaleDettFascSosp('contModal_3', '${listaRedDaSospendere.idFascicoloRaccoltaProvvisoria}'); " >
							<img  src="<%=request.getContextPath()%>/public/img/ico_view_det.png" alt="Visualizza metadati prot. n. ${listaRedDaSospendere.protocollo.numeroProtocollo} - ${listaRedDaSospendere.descrizione}">
						</a>
					</demdec:displaytag-column>
				</demdec:displaytag-table>

				<br>
				<div class="left"> <demdec:submit keyValue="button.schedula.chiusura.sospesi" controllerCode="inserisciSospesiRed" /></div>
				<div class="small right">
					<div class="small-10 columns">
						<demdec:submit keyValue="button.nuovaRicerca" controllerCode="pulisciRicercaSospesiRed"   styleClass="button small"/>
							<!--  button type="submit" >Cerca</button> -->
					</div>
				</div>
			</c:if>
			<c:if test="${paginator ne null}">
				<div>&nbsp;</div>
								
					<div class="center color_grey">
										
				        <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
				        				 paginatorName= "paginator"
				                         paginatorSessionName="<%=SessionAttributes.PAGINATOR_SOSPENDIBILI_RED%>"
				                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" 
						/>
				</div>                       
			</c:if>   

        <div class="spacer_sm">&nbsp;</div>
	<!--**FINE LISTA RED DA SOSPENDERE-->


	<!--**INIZIO LISTA RED SOSPESI -->
		<div class="scroll_table_gen">
	  
			<c:if test="${not empty listaRedSospesi}">

				<div class="spacer_sm">&nbsp;</div>
				<div class="spacer_sm">&nbsp;</div>
				<div class="title_doc"><spring:message code="label.title.lista.schedulazioni.chiusure"></spring:message></div>
				<div class="spacer_sm_10">&nbsp;</div>

				<demdec:displaytag-table  class="lux width100" name="pageScope.listaRedSospesi" id="listaRedSospesi">

					<display:caption>
						<span class="nascosto"><strong> <spring:message code="label.title.lista.schedulazioni.chiusure"></spring:message> </strong></span>
					</display:caption>

					<demdec:displaytag-column title="<span class='nascosto'>Sel.</span>">
					<span class="nascosto">
						<%-- <demdec:label path="listaRedSospesi"></demdec:label> --%>
						 <label for="listaRedSospesi${listaRedSospesi_rowNum}" class="nascosto"> Sel.</label> 
					</span>
						<form2:checkbox path="listaRedSospesi" value="${listaRedSospesi.idFascicoloRaccoltaProvvisoria}" class="optim"/>
					</demdec:displaytag-column>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.preView"  class="center">
 				<c:if test="${not empty listaRedSospesi.preView}">
					<a href="javascript: caricaModaleAnteprima('${listaRedSospesi_rowNum - 1}','<%=SessionAttributes.LIST_SOSPESI_RED%>'); " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_preview.png" alt="Visualizza Anteprima" title="Visualizza Anteprima">
					</a>			
				</c:if>
			</demdec:displaytag-column>
					<demdec:displaytag-column title="<span class='nascosto'>Visualizza cartella</span>">
						<demdec:submit styleClass="subm_folder" keyValue="label.empty"  controllerCode="apriDocumentiFascicolo?idRed=${listaRedSospesi.idFascicoloRaccoltaProvvisoria}"/>
					</demdec:displaytag-column>
					<demdec:displaytag-column property="identificativoRaccoltaProvvisoria" titleKey="label.idRed"/>
					<demdec:displaytag-column titleKey="label.protocolloRed">
						 	${listaRedSospesi.protocollo.numeroProtocollo}/<fmt:formatDate pattern="yyyy"  value="${listaRedSospesi.protocollo.data}" />
					</demdec:displaytag-column>
					<demdec:displaytag-column titleKey="label.raccolteProvvisorie.dataProtocolloIngr">
					 	 <fmt:formatDate pattern="dd/MM/yyyy"  value="${listaRedSospesi.protocollo.data}" />
					</demdec:displaytag-column>
					<demdec:displaytag-column property="descrizione" titleKey="label.raccolteProvvisorie.oggetto" />
					<demdec:displaytag-column sortName="amministrazione.code"  property="amministrazione.code" titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
					<demdec:displaytag-column property="descStatoFascicoloDocumentale" titleKey="label.raccolteProvvisorie.statoLavorazione" />
					<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center" >
						<%-- <a href="javascript:alert('CCC'); caricaModaleDettFasc('contModal_Dett', ${listaRedSospesi.idFascicoloRaccoltaProvvisoria})" > --%>
						<a href="javascript: caricaModaleDettFascChius('contModal_3', '${listaRedSospesi.idFascicoloRaccoltaProvvisoria}'); " >
							<img  src="<%=request.getContextPath()%>/public/img/ico_view_det.png" alt="Visualizza metadati prot. n. ${listaRedSospesi.protocollo.numeroProtocollo} - ${listaRedSospesi.descrizione}">
						</a>
					</demdec:displaytag-column>
				</demdec:displaytag-table>

				<br>
					<div class="left"> <demdec:submit keyValue="button.revoca.schedulazione" controllerCode="ripristinaSospesiRed" /></div>
				
				<div class="small right">
					<div class="small-10 columns">
				 <demdec:submit keyValue="button.nuovaRicerca" controllerCode="pulisciRicercaSospesiRed"   styleClass="button small"/>
					
						<!--  button type="submit" >Cerca</button> -->
					</div>
				</div>
	
			</c:if>
			<c:if test="${paginator2 ne null}">
				<div>&nbsp;</div>
					<div class="center color_grey">
				        <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
				        				 paginatorName="paginator2"
				                         paginatorSessionName="<%=SessionAttributes.PAGINATOR_SOSPESI_RED%>"
				                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>"  
						/>
				</div>
			</c:if>
		</div>
	</c:if>
	<div id="emptyList">
		<c:if test="${empty listRaccolteProvvisorie}">
			<spring:message code="info.noDataFound"></spring:message>
		</c:if>
	</div>

<!--**FINE LISTA RED SOSPESI -->
