
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

<!-- PageName = documentiFadCdc.jsp -->


<demdec:useAttribute id="paginator" 		name="<%=SessionAttributes.DOCUMENTI_FAD_PAGINATOR%>" />
<demdec:useAttribute id="listDocumenti" 	name="<%=SessionAttributes.LIST_DOCUMENTI_FAD %>" />

<demdec:useAttribute id="tipoDocList"	name="<%=WebConstants.LIST_TIPO_DOC%>" />
<demdec:useAttribute id="ammList"	name="<%=WebConstants.LIST_AMMIN_DEM%>" />
<demdec:useAttribute id="fascicoloFad" name="<%=SessionAttributes.FASCICOLO_SELEZIONATO%>"/>
<demdec:useAttribute id="isHelp" name="isHelp"/>

<tiles:useAttribute name="action" />
<tiles:useAttribute name="isHelp" 	classname="java.lang.String"/>

<script type="application/javascript">
	var jsonData;
</script>

<script type="text/javascript">
	function confermaUpload(){
		return confirm('Nel caso in cui sia gi� presente un documento di tipo Atto Decreto Corte verr� sovrascritto. Procedere?');
	}
	
</script>

<!--**INIZIO INCLUDE MODALEmodaleMetadatiDocFadCdc.jsp -->	
	<%@include file="/private/jsp/modal/modaleMetadatiDocFadCdc.jsp" %>    
<!--END INCLUDE MODALE  modaleMetadatiDocFadCdc.jsp -->
 
<section id="lanci-servizi" class="margine-bottom">
	<div class="overlay"></div>
	<div class="spacer_sm">&nbsp;</div>
	<form:form enctype="multipart/form-data" modelAttribute="<%=SessionAttributes.FORM%>" id="multipartForm">
	 <c:if test='${isHelp eq "TRUE"}'> 
  		 <div class="right">
		       <demdec:submit styleClass="subm_help" keyValue="label.empty"  controllerCode="help" />
    	  </div>
  	 </c:if>
		<div class="spacer_sm">&nbsp;</div>
		<div class="center padd-bott_5 font_size_riep">
			<span>&#8226; Tipo: </span>
			<span class="col_char_user"><strong>${fascicoloFad.anagTipologiaDecreto.anagTipoDecreto.descSigla}</strong></span>
			
			<span>&#8226; Numero:</span>
			<span class="col_char_user"><strong>${fascicoloFad.numeNumDecreto}</strong></span>
			
			<span>&#8226; Anno:</span>
			<span class="col_char_user"><strong>${fascicoloFad.eserciziDem.id}</strong></span>
		</div>
		<div class="spacer_sm_10">&nbsp;</div>
		
		<div >
			<c:if test="${not empty listDocumenti}">
				<demdec:displaytag-table skipDiv="true" name="pageScope.listDocumenti" id="listDocumenti" class="lux tableDati width100">
					<display:caption>
						<span class="nascosto"><demdec:label labelKey="label.raccolteProvvisorie.documentiFascicolo" /></span>
					</display:caption>
					<%-- 	<demdec:displaytag-column titleKey="label.raccolteProvvisorie.pdf" class="center">
						<demdec:linkButton styleClass="padd_sx_logo" action="${action}" imageKey="ico.download.pdf" parameter="scaricaPdfFadCdc" parameterValue="${listDocumenti_rowNum }" />
					</demdec:displaytag-column> --%>
					
					<demdec:displaytag-column titleKey="label.raccolteProvvisorie.pdf" class="center">
						<c:if test="${listDocumenti.statConversione eq 'OK'}">
							<demdec:linkButton styleClass="padd_sx_logo" action="${action}" imageKey="ico.download.pdf" parameter="scaricaPdfFadCdc" parameterValue="${listDocumenti_rowNum}"  title="${listDocumenti.descFilenameTrasf}" labelKey="label.raccolteProvvisorie.pdf"/>
						</c:if>
						<c:if test="${listDocumenti.statConversione ne 'OK'}">
							<img class="padd_sx_logo" src="<%=request.getContextPath()%>/public/img/ico_pdf_conv.png" alt="vai">
						</c:if>
					</demdec:displaytag-column>
					
					<demdec:displaytag-column titleKey="label.raccolteProvvisorie.originale" class="center">
						<demdec:linkButton styleClass="padd_sx_logo" action="${action}" imageKey="ico.download.originale" parameter="scaricaOrigFadCdc" parameterValue="${listDocumenti_rowNum }" />
					</demdec:displaytag-column>
					
					<demdec:displaytag-column property="descFilename" titleKey="label.raccolteProvvisorie.nome" />
					
					<%-- 	<demdec:displaytag-column sortName="anagAmminDem.descAmm" property="anagAmminDem.descAmm" titleKey="label.raccolteProvvisorie.amministrazione" /> --%>
					
					<demdec:displaytag-column property="dataDocumento" format="{0,date,dd/MM/yyyy}" titleKey="label.raccolteProvvisorie.dataCreazione" />
					
					<demdec:displaytag-column property="dataAggiornamento" format="{0,date,dd/MM/yyyy}" titleKey="label.raccolteProvvisorie.dataModifica" />
					
					<%-- <demdec:displaytag-column property="fkCodiUtenteAgg" titleKey="label.raccolteProvvisorie.modificatoDa" /> --%>
					
					<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center" >
						<a href="javascript: caricaModaleMetadatiDocCdc('contModal_2', '${listDocumenti.id.numeIdDocumento}'); " >
							<img class="padd_sx_logo" src="<%=request.getContextPath()%>/public/img/ico_view_det.png" alt="vai">
						</a>
					</demdec:displaytag-column>
				</demdec:displaytag-table>
			</c:if>
			
			<c:if test="${paginator ne null}">
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
		
		<c:if test="${fascicoloFad.numeProtRegistrazioneCdc ne null }">
			<div class="large-12 columns">
				<div class="spacer_sm">&nbsp;</div>
				<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
				<fieldset>
					<legend>Upload</legend>
					
					<div class="row">
						<div class="small-10 columns">
							<form:input path="upFile" class="text_upload" type="file"/>
						</div>
					</div>

					<div class="row">
						<div class="small-10 columns">
							<demdec:submit keyValue="button.upload" controllerCode="uploadFile" onclick="return confermaUpload();" styleId="btnUpload"/>
						</div>
					</div>
				</fieldset>
			</div>
		</c:if>
		
		<div class="row center">
			<demdec:submit keyValue="button.back" controllerCode="backFromDocFad" />
		</div>
	</form:form>
</section>