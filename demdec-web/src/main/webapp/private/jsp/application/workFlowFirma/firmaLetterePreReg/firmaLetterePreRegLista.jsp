<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- PageName = firmaLetterePreRegLista.jsp -->
<demdec:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/> 

<demdec:useAttribute id="listaLettereToSign" name="<%=SessionAttributes.LIST_LETTERE_TO_SIGN%>"/>
<demdec:useAttribute id="listSignedLettere" name="<%=SessionAttributes.LIST_LETTERE_SIGNED%>"/>

<tiles:useAttribute name="action"/>
<%-- <tiles:insertAttribute name="modalAmm" flush="false"/> --%>
<!-- INI MODALE DOC--> 
    <div class="overlay"></div>
    <div id="contModal_1_doc" class="box_pin">
        <div id="title_modal_1"><strong><spring:message code="label.title.modal"/></strong></div>
        <div>
              <div class="spacer_sm">&nbsp;</div>
                      <div class="small-12 columns">
                              <label for="pin"><spring:message code="label.pin"/></label>
                             	<form:password path="pin" id="pin"  maxlength="8"/>
                      </div>
                      <div class="spacer_sm">&nbsp;</div>
                      <div class="small-12 columns">
                      	<demdec:buttons>
                      		<demdec:submit keyValue="button.conferma" controllerCode="firma" styleClass="button small " styleId="conferma"/>
                      		<button id="undo_pin" type="button" class="button small " onclick="javascript:close();"><spring:message code="button.annulla"/></button> 
                      	</demdec:buttons>
                      </div>
		</div>
              <div class="spacer_sm">&nbsp;</div>
              <p class="chiudi_pin"><spring:message code="label.chiudiPin"/></p>
	</div>
<!-- END MODALE DOC--> 

<div>&nbsp;</div>

<c:if test="${not empty listaLettereToSign}">
<fieldset>
	<div class="title_doc"><spring:message code="label.title.list.lettere.to.sign"></spring:message></div>
	<div class="spacer_sm_10">&nbsp;</div>
	<demdec:displaytag-table name="pageScope.listaLettereToSign" id="listaLettereToSign" class="width100">
		<display:caption><span class="nascosto"><spring:message code="label.caption.list.AD.to.sign"/></span></display:caption>
		<demdec:displaytag-column titleKey="" title="<input type='checkbox' id='selectall' title='Seleziona tutti' class='optim'/>" class="center">
			<label for="selezioni" class="nascosto">Seleziona</label>
			<form:checkbox path="selezioni" value="${listaLettereToSign.id}" cssClass="checkPlut optim"/>
		</demdec:displaytag-column>
		<%-- <demdec:displaytag-column titleKey="label.tipo.file.pdf" title="label.tipo.file.pdf" class="center">
			<demdec:linkButton styleClass="center" action="${action}" imageKey="ico.download.pdf" parameter="download" parameterValue="${listaLettereToSign_rowNum -1}" title="${listaLettereToSign.descNomeDocumento}" label="Documento PDF"/>
		</demdec:displaytag-column> --%>
		
		<demdec:displaytag-column property="fascicoli.estremiStr" titleKey="label.raccolteProvvisorie.estremiStr" class="center"/> 
	 	<demdec:displaytag-column titleKey="label.predLetterePreReg.dataLettera" class="center">
		 	 <fmt:formatDate pattern="dd/MM/yyyy"  value="${listaLettereToSign.dataLettera}" />
		</demdec:displaytag-column> 
		<demdec:displaytag-column property="fascicoli.descDecreto" titleKey="label.desc.decreto" title="label.desc.decreto" class="center"/>
	<%-- 	<demdec:displaytag-column property="fascicoli.anagTipologiaDecreto.descTipologia" titleKey="label.tipologiaDecreto" title="label.tipologiaDecreto" class="center"/> --%>
		
		<demdec:displaytag-column sortName="anagAmminDem.descAmm"  property="anagAmminDem.descAmm" titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
		
		
		<demdec:displaytag-column  titleKey="label.predLetterePreReg.lettera" class="center" >
				<demdec:linkButton  action="${action}" imageKey="ico.download.pdf"  parameter="apriLettera&amp;tipo=toSign&amp;rowNum" title="Documento in formato PDF"  parameterValue="${listaLettereToSign_rowNum-1}" />
		</demdec:displaytag-column>
		
		<demdec:displaytag-column titleKey="label.firmaLetterePreReg.reinviaAPredisp" class="center">
					<demdec:submit styleId="btnDel${listaLettereToSign_rowNum}" styleClass="subm_send_sign" keyValue="label.empty" titleKey="label.delete" controllerCode="reinviaAPredisposizione?selectedLettera=${listaLettereToSign_rowNum-1}" />
		</demdec:displaytag-column> 
		
		<demdec:displaytag-column titleKey="label.delete" class="center">
					<demdec:submit styleId="btnDel${listaLettereToSign_rowNum}" styleClass="subm_none_del" keyValue="label.empty" titleKey="label.delete" controllerCode="deleteLetteraDecreto?selectedLettera=${listaLettereToSign_rowNum-1}" onclick="javascript:return confirm('Confermi cancellazione?');"/>
		</demdec:displaytag-column> 
		
			
	<%-- 	<demdec:displaytag-column title="" titleKey="label.fad" class="center">
			<demdec:linkButton styleClass="center" action="/private/consultaFascicoloFAD.do" parameter="apriFascicoloFad&funzione=${action}&idFad" parameterValue="${listaLettereToSign.fascicoli.id}" imageKey="ico.fad.show"  labelKey="alt.apri.fascicoloFad"/>
		</demdec:displaytag-column> --%>
	</demdec:displaytag-table>


 <c:if test="${paginator ne null}">
	 <div>&nbsp;</div>
     <div class="center color_grey">
         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
         				 paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
                         paginatorName="<%=Paginator.PAGINATOR_NAME%>"
                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" 
         />
     </div>                       
    <div>&nbsp;</div>
 </c:if>   
    <div class="clear_both">&nbsp;</div>
	
    <div class="text-center">
		    	<demdec:buttons>
		    		<demdec:submit keyValue="button.firma" controllerCode="" styleClass="button small" onclick="return apriPopUpModale('contModal_1_doc');"/>
		    	</demdec:buttons>
    </div>
</fieldset>    
</c:if>
 
 <div>&nbsp;</div>
   <div>&nbsp;</div>
   <!-- SEZIONE DOCUMENTI FIRMATI -->
   <c:if test="${not empty listSignedLettere}">
	<fieldset>
	    <div class="title_doc"><spring:message code="label.title.list.lettere.signed"></spring:message></div>
		<div class="spacer_sm_10">&nbsp;</div>
		<demdec:displaytag-table name="pageScope.listSignedLettere" id="listSignedLettere" class="lux width100">
			<display:caption><span class="nascosto"><spring:message code="label.caption.list.AD.bollinati"/></span></display:caption>
			
			<demdec:displaytag-column property="fascicoli.estremiStr" titleKey="label.raccolteProvvisorie.estremiStr" class="center"/> 
	 		<demdec:displaytag-column titleKey="label.predLetterePreReg.dataLettera" class="center">
		 	 	<fmt:formatDate pattern="dd/MM/yyyy"  value="${listSignedLettere.dataLettera}" />
			</demdec:displaytag-column> 
			<demdec:displaytag-column property="fascicoli.descDecreto" titleKey="label.desc.decreto" title="label.desc.decreto" class="center"/>
			<%-- <demdec:displaytag-column property="fascicoli.anagTipologiaDecreto.descTipologia" titleKey="label.tipologiaDecreto" title="label.tipologiaDecreto" class="center"/> --%>
		
			<demdec:displaytag-column sortName="anagAmminDem.descAmm"  property="anagAmminDem.descAmm" titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
			<demdec:displaytag-column  titleKey="label.predLetterePreReg.lettera" class="center" >
					<demdec:linkButton  action="${action}" imageKey="ico.download.pdf" parameter="apriLettera&amp;tipo=signed&amp;rowNum" title="Documento in formato PDF"  parameterValue="${listSignedLettere_rowNum-1}" />
			</demdec:displaytag-column>
			
		</demdec:displaytag-table>
	
	
  <div class="clear_both">&nbsp;</div>
	
    <div class="text-center">
    	<demdec:buttons>
    		<demdec:submit keyValue="label.invio.pec" controllerCode="invioPec" styleClass="button small" />
    	</demdec:buttons>
    </div>
    </fieldset>
</c:if>