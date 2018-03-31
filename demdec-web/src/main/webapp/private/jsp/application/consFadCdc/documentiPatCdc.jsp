
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- PageName = documentiPatCdc.jsp -->
<demdec:useAttribute id="paginator" name="<%=SessionAttributes.DOCUMENTI_PAT_PAGINATOR%>" />
<demdec:useAttribute id="listDocumentiFascicolo" name="<%=SessionAttributes.LIST_DOCUMENTI_PAT%>" />
<demdec:useAttribute id="fascicoloFad" name="<%=SessionAttributes.FASCICOLO_SELEZIONATO%>"/>

<tiles:useAttribute name="action"/>
<script type="application/javascript">
var jsonData;
</script>

  <!--**INIZIO INCLUDE MODALEmodaleMetadatiDocPatCdc.jsp -->	
	<%@include file="/private/jsp/modal/modaleMetadatiDocPatCdc.jsp" %>    
 <%--END INCLUDE MODALE  modaleMetadatiDocPatCdc.jsp --%>
 
<div class="overlay"></div>
<div class="spacer_sm">&nbsp;</div>
<%-- <div class="center padd-bott_5 font_size_riep">
	    <span><strong>&#8226;</strong> </span>
	    <span class="col_char_user"><strong>${fascicoloFad.estremiStr}</strong></span> 
	</div> --%>
  <div class="center padd-bott_5 font_size_riep">
    <span>&#8226; Tipo: </span>
    <span class="col_char_user"><strong>${fascicoloFad.anagTipologiaDecreto.anagTipoDecreto.descSigla}</strong></span> 
  
    <span>&#8226; Numero:</span>
    <span class="col_char_user"><strong>${fascicoloFad.numeNumDecreto}</strong></span> 
   
    <span>&#8226; Anno:</span>
    <span class="col_char_user"><strong>${fascicoloFad.eserciziDem.id}</strong></span>    
  </div>
<div>
	<c:if test="${not empty listDocumentiFascicolo}">
		<div class="spacer_sm">&nbsp;</div>
		<demdec:displaytag-table skipDiv="true" name="pageScope.listDocumentiFascicolo" id="listDocumentiFascicolo" class="lux tableDati width100">
			<display:caption>
				<span class="nascosto"><demdec:label labelKey="label.raccolteProvvisorie.documentiFascicolo" /></span>
			</display:caption>
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.pdf" class="center">
				
				<%-- <demdec:linkButton styleClass="padd_sx_logo" action="${action}" imageKey="ico.download.pdf" parameter="scaricaPdfPatCdc" parameterValue="${listDocumentiFascicolo_rowNum }"/>
 --%>
				<c:if test="${listDocumentiFascicolo.documentoFileOperazione ne null}">
					<demdec:linkButton styleClass="padd_sx_logo" action="${action}" imageKey="ico.download.pdf" parameter="scaricaPdfPatCdc"  title="${listDocumentiFascicolo.documentoFileOperazione.fileName}"  parameterValue="${listDocumentiFascicolo_rowNum}" labelKey="label.raccolteProvvisorie.pdf"/>
				</c:if>
				<c:if test="${listDocumentiFascicolo.documentoFileOperazione eq null}">
					<img class="padd_sx_logo" src="<%=request.getContextPath()%>/public/img/ico_pdf_conv.png" alt="vai">
				</c:if>
				
			</demdec:displaytag-column>
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.originale" class="center">
				<demdec:linkButton styleClass="padd_sx_logo" action="${action}" imageKey="ico.download.originale" parameter="scaricaOrigPatCdc" parameterValue="${listDocumentiFascicolo_rowNum }"/>
<%-- 				<a href="<%=request.getContextPath()%>/private/ricercaRed.do?cmdGET___download=download&amp;tipoDownl=2&amp;rigaDoc=${listDocumentiFascicolo_rowNum}  ">
					<img class="padd_sx_logo" src="<%=request.getContextPath()%>/public/img/ico_download.png" alt="vai">
				</a> --%>
			</demdec:displaytag-column>

			<demdec:displaytag-column property="tipoDocumento.description" titleKey="label.raccolteProvvisorie.nome" />
			<%-- <demdec:displaytag-column sortName="amministrazione.description" property="amministrazione.description" titleKey="label.raccolteProvvisorie.amministrazione" /> --%>
			<demdec:displaytag-column property="dataCreazione" format="{0,date,dd/MM/yyyy}" titleKey="label.raccolteProvvisorie.dataCreazione" />
			<%-- <demdec:displaytag-column property="sistemaProduttore" titleKey="label.raccolteProvvisorie.origineCreazione" /> --%>
			<demdec:displaytag-column property="dataDocumento" format="{0,date,dd/MM/yyyy}" titleKey="label.raccolteProvvisorie.dataModifica" />
		<%-- 	<demdec:displaytag-column titleKey="label.raccolteProvvisorie.modificatoDa" /> --%>
			
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center" >
					<a href="javascript: caricaModaleMetadatiDocPatCdc('contModal_6', '${listDocumentiFascicolo_rowNum}'); " >
						<img class="padd_sx_logo" src="<%=request.getContextPath()%>/public/img/ico_view_det.png" alt="vai">
					</a>		
			</demdec:displaytag-column>
		</demdec:displaytag-table>
	</c:if>
	

	<c:if test="${paginator ne null}">
		<div>&nbsp;</div>
		<div class="center color_grey">
			<demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
				paginatorName="<%=Paginator.PAGINATOR_NAME%>"
				paginatorSessionName="<%=SessionAttributes.DOCUMENTI_PAT_PAGINATOR%>"
				controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
		</div>
	</c:if>

</div>

<div class="spacer_sm">&nbsp;</div>

<div class="row center">
	<demdec:submit keyValue="button.ritornoLista" controllerCode="backFromDocPatr"/>
</div>

