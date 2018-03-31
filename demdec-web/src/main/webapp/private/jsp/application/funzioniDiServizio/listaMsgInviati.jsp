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

<!-- PageName = listaMsgInviati -->

<nssb:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/>
<nssb:useAttribute id="listaMessaggi" name="<%=SessionAttributes.LIST_SENT_MSG%>"></nssb:useAttribute>


	<fieldset>
		<legend><spring:message code="label.find.list.sentMsg"></spring:message></legend>
			 <div class="row">
			      <div class="small-3 columns">
					<demdec:label path="filterDate" labelKey="label.data.invio.da"></demdec:label>
					<form:input path="filterDate" placeholder="gg/mm/aaaa" maxlength="10"/>
			      </div>
			 </div>
 
			<div class="row">
				<div class="small-10 columns">
					<nssb:buttons>
						<nssb:submit keyValue="label.filtro.data" controllerCode="listByDate" />
					</nssb:buttons>
				</div>
			</div>
	</fieldset>

<div class="large-12 columns">
<c:if test="${not empty listaMessaggi}">
	<div class="title_doc"><spring:message code="label.title.tabel.list.sentMsg"></spring:message></div>
	
	<nssb:displaytag-table name="pageScope.listaMessaggi" id="listaMessaggi" class="lux width100">
		<display:caption><span class="nascosto"><spring:message code="label.caption.sentMsg"></spring:message></span></display:caption>
		<nssb:displaytag-column property="dataInvio" titleKey="label.data.invio" title="label.data.invio" format="{0,date,dd/MM/yyyy}" class="center"/>
		<nssb:displaytag-column property="textMessaggio" titleKey="label.text" title="label.text" class="center"/>
		
		
	</nssb:displaytag-table>
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

</div>
