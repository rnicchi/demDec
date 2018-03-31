<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<%@taglib prefix="demdec" uri="http://almavivaitalia.web.sh/tags"%> 
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <script type="application/javascript">
	
	function confermaSigla(){
		
		var r = confirm('Confermi la sigla del documento?');
		
		if ( r == false ){
			return false;
		}
		else{
			return true;
		}

	}
	
	 	
</script>


<!-- PageName = siglaDocumenti.jsp -->
<demdec:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/> 

<demdec:useAttribute id="listaADToSign" name="<%=SessionAttributes.LIST_AD_TO_SIGN%>"/>

<demdec:useAttribute id="listSignedAD" name="<%=SessionAttributes.LIST_AD_SIGNED%>"/>
<tiles:useAttribute name="action"/>
<tiles:insertAttribute name="modalAmm" flush="false"/>

<div>&nbsp;</div>
<div class="text-right">
	<div class="row">
		<demdec:linkButton action="${action}" labelKey="label.my.AD.siglati" parameter="signedDocuments"/>
	</div>
</div>
<div>&nbsp;</div>
<div>&nbsp;</div>

<c:if test="${not empty pageScope.listaADToSign}">
<fieldset>
    <div class="title_doc"><spring:message code="label.title.list.AD.to.initial"></spring:message></div>
	<div class="spacer_sm">&nbsp;</div>
	<demdec:displaytag-table name="pageScope.listaADToSign" id="listaADToSign" class="lux width100">
		<display:caption><span class="nascosto"><spring:message code="label.caption.list.AD.to.sign"/></span></display:caption>
		<demdec:displaytag-column titleKey="" title="<input type='checkbox' id='selectall' title='Seleziona tutti' class='optim'/>" class="center">
			<form:checkbox path="selezioni" value="${listaADToSign.codiGuidDocumento}" cssClass="checkPlut optim"/>
		</demdec:displaytag-column>
		<demdec:displaytag-column titleKey="label.tipo.file.pdf" title="label.tipo.file.pdf" class="center">
			<demdec:linkButton styleClass="center" action="${action}" imageKey="ico.download.pdf" parameter="download" parameterValue="${listaADToSign_rowNum -1}" title="${listaADToSign.descNomeDocumento}"/>
		</demdec:displaytag-column>
		<demdec:displaytag-column property="decreto" titleKey="label.decreto" title="label.decreto" class="center"/>
		<demdec:displaytag-column property="fascicoli.descDecreto" titleKey="label.desc.decreto" title="label.desc.decreto" class="center"/>
		<demdec:displaytag-column property="fascicoli.anagTipologiaDecreto.descTipologia" titleKey="label.tipologiaDecreto" title="label.tipologiaDecreto" class="center"/>
		<demdec:displaytag-column titleKey="label.amministrazione" title="label.amministrazione" class="center">
		 <c:choose>
		    <c:when test="${fn:length(listaADToSign.fascicoli.anagAmminDemList) eq 1}">
		      	${listaADToSign.descAmm}
		    </c:when>
		    <c:otherwise>
		    		<a id="amm" href="#" onclick="return caricaModaleListaAmministrazioni('contModal_01','${listaADToSign.fascicoli.id}');"><spring:message code="label.multiamministrazione"/></a>
		    </c:otherwise>
		</c:choose> 
		</demdec:displaytag-column>
		<demdec:displaytag-column title="" titleKey="label.fad" class="center">
			<demdec:linkButton styleClass="center" action="/private/consultaFascicoloFAD.do" parameter="apriFascicoloFad&funzione=${action}&idFad" parameterValue="${listaADToSign.fascicoli.id}" imageKey="ico.fad.show"  labelKey="alt.apri.fascicoloFad"/>
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
   

    <div>&nbsp;</div>

 </c:if>    
    <div class="clear_both">&nbsp;</div>
	    <div class="text-center">
	    	<demdec:buttons>
	    		<demdec:submit keyValue="button.sigla" controllerCode="sigla" styleClass="button small" onclick="return confermaSigla()"/>
	    	 </demdec:buttons>
	    </div>
   </fieldset> 
   </c:if>
   
   <div>&nbsp;</div>
   <div>&nbsp;</div>
   <!-- SEZIONE DOCUMENTI FIRMATI -->
   <c:if test="${not empty listSignedAD}">
	<fieldset>
	    <div class="title_doc"><spring:message code="label.title.list.AD.siglati"></spring:message></div>
		<div class="spacer_sm">&nbsp;</div>
		<demdec:displaytag-table name="pageScope.listSignedAD" id="listSignedAD" class="lux width100">
			<display:caption><span class="nascosto"><spring:message code="label.caption.list.AD.bollinati"/></span></display:caption>
			<demdec:displaytag-column titleKey="label.tipo.file.pdf" title="label.tipo.file.pdf" class="center">
				<demdec:linkButton styleClass="center" action="${action}" imageKey="ico.download.pdf" parameter="downloadAD" parameterValue="${listSignedAD_rowNum -1}" title="${listSignedAD.descNomeDocumento}"/>
			</demdec:displaytag-column>
			<demdec:displaytag-column property="decreto" titleKey="label.decreto" title="label.decreto" class="center"/>
			<demdec:displaytag-column property="fascicoli.descDecreto" titleKey="label.desc.decreto" title="label.desc.decreto" class="center"/>
			<demdec:displaytag-column property="fascicoli.anagTipologiaDecreto.descTipologia" titleKey="label.tipologiaDecreto" title="label.tipologiaDecreto" class="center"/>
			<demdec:displaytag-column titleKey="label.amministrazione" title="label.amministrazione" class="center">
			<c:choose>
			    <c:when test="${fn:length(listSignedAD.fascicoli.anagAmminDemList) eq 1}">
			      	 ${listSignedAD.descAmm}
			    </c:when>
			    <c:otherwise>
			    		<a id="amm" href="#" onclick="return caricaModaleListaAmministrazioni('contModal_01','${listSignedAD.fascicoli.id}');"><spring:message code="label.multiamministrazione"/></a>
			    </c:otherwise>
			</c:choose>
			</demdec:displaytag-column>
		<demdec:displaytag-column title="" titleKey="label.fad" class="center">
			<demdec:linkButton styleClass="center" action="/private/consultaFascicoloFAD.do" parameter="apriFascicoloFad&funzione=${action}&idFad" parameterValue="${listSignedAD.fascicoli.id}" imageKey="ico.fad.show"  labelKey="alt.apri.fascicoloFad"/>
		</demdec:displaytag-column>
		</demdec:displaytag-table>
	</fieldset>
	</c:if>
   
  
