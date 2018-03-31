
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

<!-- PageName = documentiFad.jsp -->
<demdec:useAttribute id="paginator" 		name="<%=SessionAttributes.DOCUMENTI_FAD_PAGINATOR%>" />
<demdec:useAttribute id="listDocumenti" 	name="<%=SessionAttributes.LIST_DOCUMENTI_FAD %>" />
<demdec:useAttribute id="idFadAperto"	name="<%=WebConstants.ID_FAD_APERTO%>" />
<demdec:useAttribute id="fascicoloFad" name="<%=SessionAttributes.FASCICOLO_SELEZIONATO%>"/>
<tiles:useAttribute name="action" />

<tiles:insertAttribute name="modalVisualizzaDocumentiFad" flush="false"/>

<script type="application/javascript">
var jsonData;
</script>

<div class="overlay"></div>


	
	<div class="spacer_sm">&nbsp;</div>
<div class="center padd-bott_5 font_size_riep">
    <span>&#8226; Tipo: </span>
    <span class="col_char_user"><strong>${fascicoloFad.anagTipologiaDecreto.anagTipoDecreto.descSigla}</strong></span> 
  
    <span>&#8226; Numero:</span>
    <span class="col_char_user"><strong>${fascicoloFad.numeNumDecreto}</strong></span> 
   
    <span>&#8226; Anno:</span>
    <span class="col_char_user"><strong>${fascicoloFad.eserciziDem.id}</strong></span>    
  </div>
<div>
<form:form>
<div class="spacer_sm_10">&nbsp;</div>
	<c:if test="${not empty listDocumenti}">
		<demdec:displaytag-table skipDiv="true"  name="pageScope.listDocumenti" id="listDocumenti" >
			<display:caption>
				<span class="nascosto"><demdec:label labelKey="label.raccolteProvvisorie.documentiFascicolo" /></span>
			</display:caption>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.preView"  class="center">
			
 				<c:if test="${not empty listDocumenti.preView}">
					<a href="javascript: caricaModaleAnteprima('${listDocumenti_rowNum -1}','<%=SessionAttributes.LIST_DOCUMENTI_FAD %>'); " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_preview.png" alt="Visualizza Anteprima" title="Visualizza Anteprima">
					</a>			
				</c:if>
				
			</demdec:displaytag-column>
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.pdf" class="text-center">
				<c:if test="${listDocumenti.statConversione eq 'OK'}">
					<demdec:linkButton  action="${action}" imageKey="ico.download.pdf" parameter="scaricaPdfFad" title="${listDocumenti.descFilenameTrasf}" parameterValue="${listDocumenti_rowNum -1}" labelKey="label.raccolteProvvisorie.pdf" />
				</c:if>
				<c:if test="${listDocumenti.statConversione ne 'OK'}">
					<img  src="<%=request.getContextPath()%>/public/img/ico_pdf_conv.png" alt="vai">
				</c:if>
				
			</demdec:displaytag-column>
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.originale" class="text-center">
				<demdec:linkButton  action="${action}" imageKey="ico.download.originale" parameter="scaricaOrigFad" title="${listDocumenti.descFilename}" parameterValue="${listDocumenti_rowNum -1}" labelKey="label.raccolteProvvisorie.originale"/>
			</demdec:displaytag-column>

			<demdec:displaytag-column property="textDescrizione" titleKey="label.raccolteProvvisorie.nome" />
			<demdec:displaytag-column property="dataDocumento" format="{0,date,dd/MM/yyyy}" titleKey="label.raccolteProvvisorie.dataCreazione" />
			<demdec:displaytag-column property="dataAggiornamento" format="{0,date,dd/MM/yyyy}" titleKey="label.raccolteProvvisorie.dataModifica" />
			<demdec:displaytag-column property="fkCodiUtenteAgg" titleKey="label.raccolteProvvisorie.modificatoDa" />
				<demdec:displaytag-column property="descVisibilitaCdc01" titleKey="label.visibilitaCdc" />
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="text-center">
				<a href="javascript: visualizzaModaleMetadatiDocFad('contModalVis_0', '${listDocumenti_rowNum -1}'); " >
					<img  src="<c:url value="/public/img/ico_view_det.png"/>"  title="Visualizza Metadati ${listDocumenti.textDescrizione}" alt="Visualizza Metadati ${listDocumenti.textDescrizione}">
				</a>
			</demdec:displaytag-column>
		</demdec:displaytag-table>


	</c:if>

	<c:if test="${paginator ne null}">
		<div class="left">
        	<demdec:submit keyValue="button.load" controllerCode="refreshLista" titleKey="label.refresh" styleClass="subm_update posit-butt_up"  />
        </div>
		<div>&nbsp;</div>
		<div class="center color_grey">
			<demdec:paginator 	controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
								paginatorName="<%=Paginator.PAGINATOR_NAME%>"
								paginatorSessionName="<%=SessionAttributes.DOCUMENTI_FAD_PAGINATOR%>"
								controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
		</div>
	</c:if>

</div>

<div class="spacer_sm">&nbsp;</div>
<div class="row center">
	<demdec:submit keyValue="button.back" controllerCode="backToFadInitialPageFromFad?idFad=${idFadAperto}"/>
</div>
</form:form>

