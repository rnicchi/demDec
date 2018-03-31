
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
<demdec:useAttribute id="tipoDocList"		name="<%=WebConstants.LIST_TIPO_DOC%>" />
<demdec:useAttribute id="ammList"			name="<%=WebConstants.LIST_AMMIN_DEM%>" />
<demdec:useAttribute id="modVisibilita"		name="<%=WebConstants.CHK_MODIFICA_VISIBILITA%>" />
<demdec:useAttribute id="idFadAperto" 		name="<%=WebConstants.ID_FAD_APERTO%>" />
<demdec:useAttribute id="fascicoloFad" 		name="<%=SessionAttributes.FASCICOLO_SELEZIONATO%>"/>
<demdec:useAttribute id="listDescDocumenti" name="<%=WebConstants.LIST_DESC_DOCUMENTI%>"/>
<demdec:useAttribute id="listOperazione" 	name="<%=WebConstants.LIST_TIPO_OPERAZIONE%>"/>

<tiles:useAttribute name="action" />
<tiles:useAttribute name="isHelp" 	classname="java.lang.String"/>
 
<script type="application/javascript">
var jsonData;

/* $(document).ready(function(){
	//$(this).css({'cursor' : 'wait'});
	$('body').css({'cursor':'wait'} );
}); */
$(document).ready(function() {
    $("#btnUpload").click(function() {
        $('body').css("cursor", "wait");
    });
   /*  $("#btnDel").click(function() {
        $('body').css("cursor", "wait");
    }); */
    $("#btnIndietro").click(function() {
        $('body').css("cursor", "wait");
    });
});
</script>

<div class="overlay"></div>



<form:form enctype="multipart/form-data" modelAttribute="<%=SessionAttributes.FORM%>" id="multipartForm">
	 <c:if test='${isHelp eq "TRUE"}'> 
  		  <div class="right">
		       <demdec:submit styleClass="subm_help" keyValue="label.empty"  controllerCode="help" />
    	  </div>
  	 </c:if> 
<tiles:insertAttribute name="modalModificaDocumentiFad" flush="false"/>
<tiles:insertAttribute name="modalVisualizzaDocumentiFad" flush="false"/>


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
<div>
 	<c:if test="${not empty listDocumenti}">
 	<div class="scroll_table_gen">
		<demdec:displaytag-table skipDiv="true" name="pageScope.listDocumenti" id="listDocumenti" class="width100" >
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
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.pdf" class="center">
				<c:if test="${listDocumenti.statConversione eq 'OK'}">
					<demdec:linkButton  action="${action}" imageKey="ico.download.pdf" parameter="scaricaPdfFad" parameterValue="${listDocumenti_rowNum -1}"  title="${listDocumenti.descFilenameTrasf}" />
				</c:if>
				<c:if test="${listDocumenti.statConversione ne 'OK'}">
					<img  src="<%=request.getContextPath()%>/public/img/ico_pdf_conv.png" alt="vai">
				</c:if>
			</demdec:displaytag-column>
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.originale" class="center">
				
				<%-- Controllo per variazione icona in base allo stato 
					 della conversione del documento --%>
				<%-- <c:if test="${listDocumenti.statConversione eq '1'}">
					<demdec:linkButton  action="${action}" imageKey="ico.download.pdf" parameter="scaricaPdfFad" parameterValue="${listDocumenti_rowNum -1}" />
				</c:if> --%>
				
				<demdec:linkButton  action="${action}" imageKey="ico.download.originale" parameter="scaricaOrigFad" parameterValue="${listDocumenti_rowNum -1}" title="${listDocumenti.descFilename}" />
		
<%-- 					<a href="<%=request.getContextPath()%>/private/ricercaRed.do?cmdGET___download=download&amp;tipoDownl=2&amp;rigaDoc=${listDocumenti_rowNum}  " >
						<img class="padd_sx_logo" src="<%=request.getContextPath()%>/public/img/ico_download.png" alt="vai">
					</a>
 --%>
			</demdec:displaytag-column>

			<demdec:displaytag-column property="textDescrizione" titleKey="label.raccolteProvvisorie.nome" />
			<%-- <demdec:displaytag-column sortName="anagAmminDem.descAmm" property="anagAmminDem.descAmm" titleKey="label.raccolteProvvisorie.amministrazione" /> --%>
			<demdec:displaytag-column property="dataDocumento" format="{0,date,dd/MM/yyyy}" titleKey="label.raccolteProvvisorie.dataCreazione" class="center" />
			<demdec:displaytag-column property="dataAggiornamento" format="{0,date,dd/MM/yyyy}" titleKey="label.raccolteProvvisorie.dataModifica" class="center"/>
			<demdec:displaytag-column property="fkCodiUtenteAgg" titleKey="label.raccolteProvvisorie.modificatoDa" />
			<%-- <demdec:displaytag-column titleKey="label.modify" class="center">
				<demdec:linkButton  action="${action}" imageKey="ico.document.modify" parameter="updateDocFad" parameterValue="${listDocumenti_rowNum }" />
			</demdec:displaytag-column> --%>
			<demdec:displaytag-column property="descVisibilitaCdc01" titleKey="label.visibilitaCdc" />
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center">
				<a href="javascript: visualizzaModaleMetadatiDocFad('contModalVis_0', '${listDocumenti_rowNum -1}'); " >
					<img  src="<c:url value="/public/img/ico_view_det.png"/>" alt="vaiVis" title="Visualizzazione">
				</a>
			</demdec:displaytag-column>
			
			<demdec:displaytag-column titleKey="label.modify" class="center">
			
			<c:if test="${listDocumenti.descDocumento.codiTipoDocumento ne 'AD01' }" >
				<a href="javascript: modificaModaleMetadatiDocFad('contModal_0', '${listDocumenti_rowNum -1}'); " >
					<img  src="<c:url value="/public/img/upd.png"/>" alt="vai" title="Modifica">
				</a>
			</c:if>
			</demdec:displaytag-column>
			
			<demdec:displaytag-column titleKey="label.delete" class="center">
				<demdec:submit styleId="btnDel${listDocumenti_rowNum}" styleClass="subm_none_del" keyValue="label.empty" titleKey="label.delete" controllerCode="deleteDocFad?deleteDocFadRiga=${listDocumenti_rowNum -1}" onclick="return confermaElimina();"/>
				<%-- 
				<demdec:linkButton  action="${action}" imageKey="ico.document.delete" parameter="deleteDocFad" parameterValue="${listDocumenti_rowNum -1}" labelKey="label.delete"/>
				--%>
			</demdec:displaytag-column>
						
		</demdec:displaytag-table>
	</div>

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


<div class="large-12 columns">
<div class="spacer_sm">&nbsp;</div>
<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>

	<fieldset>
		<legend>Upload</legend>
  
		
			
		<div class="row">
			<div class="large-12 columns">
		
				<div class="row">
					<div class="small-4 columns">
						<demdec:label path="tipoDoc" labelKey="label.tipo.doc.obb" />
	
						<form:select path="tipoDoc" onchange="changeTipoDocumento();">
							<form:option value="" label="-- Selezionare un tipo documento --" />
	
							<c:forEach var="t" items="${tipoDocList}">
								<form:option value="${t.id}">${t.descDescrizioneDoc}</form:option>
							</c:forEach>
						</form:select>
	
					</div>
				</div>
			</div>
		</div>
  
  
	   <%-- <div class="row">
			<div class="large-12 columns">
		
	
				<div class="row">
					<div class="small-4 columns">
						<demdec:label path="amm" labelKey="label.amministrazione" />
	
						<form:select path="amm">
							<form:option value="" label="-- Selezionare un' amministrazione --" />
	
							<c:forEach var="amm" items="${ammList}" varStatus="st">
								<form:option value="${st.count}">${amm.amminWithDesc}</form:option>
							</c:forEach>
						</form:select>
	
					</div>
				</div>
			</div>
		</div> --%>
			
			
		<div class="row">
			<div class="left" style="display: none;">
           		<demdec:submit styleId="caricaDesc" keyValue="button.load" controllerCode="caricaDescrizioneDocumenti" titleKey="label.carica.tipologia" styleClass="subm_update posit-butt_up"  />
           	</div>
			<div class="large-6 columns">
				<demdec:label path="desc" labelKey="label.descr.doc.obb" />
				<%-- <form:input path="desc" /> --%>
				<form:select path="desc" id="desc" onchange="changeVisibilitaDocumento();">
					<form:option value="" label="-- Selezionare una descrizione --" />

					<c:forEach var="descDoc" items="${listDescDocumenti}" varStatus="st">
						<form:option value="${descDoc.id}">${descDoc.textDescrizione}</form:option>
					</c:forEach>
				</form:select>
			</div>
			
		</div>
				
		<c:if test="${modVisibilita eq true}"  >
		
		<div class="row">
		
			<div class="left" style="display: none;">
           		<demdec:submit styleId="caricaVisibilita" keyValue="button.load" controllerCode="caricaVisibilitaDocumenti" titleKey="label.carica.visibilita" styleClass="subm_update posit-butt_up"  />
           	</div>
			<div class="small-3 columns left">
					<demdec:label path="descVisibilitaCdc" labelKey="label.visibilita.doc.cdc.obb"/>
		       		 <form:select path="descVisibilitaCdc">
		       		 <c:forEach var="vista" items="${listVisibilita}" >
						<form:option value="${vista.codiItem}">${vista.descItem}</form:option>
					</c:forEach>
		       		 	
		        	 </form:select>  
			</div>
		</div>
		</c:if>
		
		<c:if test="${modVisibilita ne true}"  >
		
				<div class="row">
				
					<div class="left" style="display: none;">
		           		<demdec:submit styleId="caricaVisibilita" keyValue="button.load" controllerCode="caricaVisibilitaDocumenti" titleKey="label.carica.visibilita" styleClass="subm_update posit-butt_up"  />
		           	</div>
					<div class="small-3 columns left">
							<demdec:label path="descVisibilitaCdcDisabled" labelKey="label.visibilita.doc.cdc.obb"/>
				       		 <form:select path="descVisibilitaCdcDisabled" disabled="true">
				       				<c:forEach var="vista" items="${listVisibilita}" >
										<form:option value="${vista.codiItem}">${vista.descItem}</form:option>
									</c:forEach>
				        	 </form:select>
				        	<form:hidden path="descVisibilitaCdc"/>
					</div>
				</div>
		
		</c:if>
		
		
		<div class="row">
			<div class="large-6 columns">
				<demdec:label path="tipoOperazione" labelKey="label.upload.operazione.obb" />
				
				<form:select path="tipoOperazione">
					
					<c:forEach var="oper" items="${listOperazione}" >
						<form:option value="${oper.codiItem}">${oper.descItem}</form:option>
					</c:forEach>		
				</form:select>
			</div>
		
		</div>
		
		<div class="row">
			<div class="small-5 columns">
        			
        			<form:input path="upFile" class="text_upload" type="file"/> 
        			
			</div>
		</div>
			
		<%--  <div class="row">
      		<div class="small-10 columns">
      	 		<demdec:submit keyValue="button.upload" controllerCode="uploadFile" onclick="return confermaUpload();" styleId="btnUpload"/>      	 		
      	 	</div>
		</div>  --%>
		<%--inserito questo pulsante al posto del precedente per risolvere il problema della clessidra attiva sul pulsante annulla del confirm javascript--%>
		<div class="row">
			<div class="small-10 columns">
			 		<demdec:submit styleClass="nascosto" styleId="btnUpload" keyValue="label.empty" controllerCode="uploadFile"/>
					 <a href="javascript:this.document.getElementById('btnUpload').click();" onclick="return confermaUpload();" class="button small">
						<spring:message code="button.upload"></spring:message> </a> 
			</div>
		</div>
		
	</fieldset>
</div>

		
<div class="row center">
	<demdec:submit keyValue="button.back" controllerCode="backToFadInitialPageFromFad?idFad=${idFadAperto}" styleId="btnIndietro"/>
 <%--	<demdec:submit keyValue="button.back" controllerCode="back?idFad=${idFadAperto}" styleId="btnIndietro"/>  --%>
</div>

<script type="text/javascript">
	function confermaUpload(){
		
		if(document.getElementById('tipoDoc').value == 'AD01'){
			var r = confirm('Nel caso in cui sia gi� presente un documento di tipo Atto Decreto verr� sovrascritto. Procedere?');
			
			if ( r == false ){
				return false;
			}
			else{
				return true;
			}
		}

	}
	
	function confermaElimina(){
		
		var r = confirm('Confermi la cancellazione del documento?');
		
		if ( r == false ){
			return false;
		}
		else{
			return true;
		}

	}
	
	function changeTipoDocumento(){
		$("#caricaDesc").click();
		
	}
	
	function changeVisibilitaDocumento(){
		$("#caricaVisibilita").click();
		
	}
	
	
	
	
</script>

</form:form>
