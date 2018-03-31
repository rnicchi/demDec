<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%> 
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>




<!-- PageName = mieiDocumentiSiglati.jsp -->
<demdec:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/> 

<demdec:useAttribute id="listMySignedDocuments" name="<%=SessionAttributes.LIST_MY_SIGNED_AD%>"/>

<tiles:useAttribute name="action"/>
<tiles:insertAttribute name="modalAmm" flush="false"/>

<div>&nbsp;</div>
<c:if test="${not empty listMySignedDocuments}">
<fieldset>
    <div class="title_doc"><spring:message code="label.title.list.AD.siglati"></spring:message></div>
	<div class="spacer_sm">&nbsp;</div>
	<demdec:displaytag-table name="pageScope.listMySignedDocuments" id="listMySignedDocuments" class="lux width100">
		<display:caption><span class="nascosto"><spring:message code="label.caption.list.AD.bollinati"/></span></display:caption>
		<demdec:displaytag-column titleKey="label.tipo.file.pdf" title="label.tipo.file.pdf" class="center">
			<demdec:linkButton styleClass="center" action="${action}" imageKey="ico.download.pdf" parameter="downloadMyAD" parameterValue="${listMySignedDocuments_rowNum -1}" title="${listMySignedDocuments.descNomeDocumento}"/>
		</demdec:displaytag-column>
		<demdec:displaytag-column property="rowUpdatedDttm" format="{0,date,dd/MM/yyyy}" titleKey="label.data.sigla" title="label.data.sigla" class="center"/>
		<demdec:displaytag-column property="decreto" titleKey="label.decreto" title="label.decreto" class="center"/>
		<demdec:displaytag-column property="fascicoli.descDecreto" titleKey="label.desc.decreto" title="label.desc.decreto" class="center"/>
		<demdec:displaytag-column property="fascicoli.anagTipologiaDecreto.descTipologia" titleKey="label.tipologiaDecreto" title="label.tipologiaDecreto" class="center"/>
		<demdec:displaytag-column titleKey="label.amministrazione" title="label.amministrazione" class="center">
			<c:choose>
			    <c:when test="${fn:length(listMySignedDocuments.fascicoli.anagAmminDemList) eq 1}">
			      	 ${listMySignedDocuments.descAmm}
			    </c:when>
			    <c:otherwise>
			    	<a id="amm" href="#" onclick="return caricaModaleListaAmministrazioni('contModal_01','${listMySignedDocuments.fascicoli.id}');"><spring:message code="label.multiamministrazione"/></a>
			    </c:otherwise>
			</c:choose>
		</demdec:displaytag-column>
		<demdec:displaytag-column title="" titleKey="label.fad" class="center">
			<demdec:linkButton styleClass="center" action="/private/consultaFascicoloFAD.do" parameter="apriFascicoloFad&signed='S'&funzione=${action}&idFad" parameterValue="${listMySignedDocuments.fascicoli.id}" imageKey="ico.fad.show"  labelKey="alt.apri.fascicoloFad"/>
		</demdec:displaytag-column>
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
  </c:if>  
 </c:if>  

    <div>&nbsp;</div>

    
    <div class="clear_both">&nbsp;</div>
	    <div class="text-center">
	    	<demdec:buttons>
	    		<demdec:submit keyValue="button.back" controllerCode="back" styleClass="button small"/>
	    	 </demdec:buttons>
	    </div>
  </fieldset>  

   
