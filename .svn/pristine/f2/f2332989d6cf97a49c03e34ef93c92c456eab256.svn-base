<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display-el"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>

<%@page import="it.almavivaitalia.web.sh.export.FieldFormatter"%>
<nssb:useAttribute id="list" name="<%=BaseSessionAttributes.LIST_SELECTOR_ITEM%>"/>
<nssb:useAttribute id="type" name="<%=BaseSessionAttributes.FLAG_SELECTOR_TYPE%>"/>
<nssb:useAttribute id="selectedRows" name="<%=BaseSessionAttributes.OBJECT_SELECTOR_ITEM_SELECTED_INDEXES%>" type="java.lang.String"/>
<nssb:useAttribute id="fieldFormatterMap" name="<%=BaseSessionAttributes.OBJECT_FIELD_FORMATTER_MAP%>" type="java.util.LinkedHashMap"/>

<c:if test="${empty selectedRows}">
	<c:set var="selectedRows" value="-1"/>
</c:if>


	
<c:choose>
	<c:when test="${type eq '0'}">
		<c:set var="title" value="label.titoloSelector"/>		
	</c:when>	
	<c:when test="${type eq '1'}">
		<c:set var="title" value="label.titoloMultiSelector"/>
	</c:when>	
	<c:when test="${type eq '2'}">
		<c:set var="title" value="label.titoloMultiDeletor"/>
	</c:when>	
	<c:when test="${type eq '3'}">
		<c:set var="title" value="label.titoloMultiOrdinator"/>
	</c:when>	
</c:choose>



<div class="boxFull">

<nssb:section titleKey="${title}">

<c:if test="${!empty list}">
	
	<c:set var="typeImporto" value="<%=FieldFormatter.TYPE_IMPORTO%>"/>
	
	<nssb:displaytag-table name="pageScope.list" selectedRow="${selectedRows}">
		<!-- nssb:displaytag-column indexedColumn="true"/-->
		
		<c:if test="${empty fieldFormatterMap}">
			<c:forEach var="entry" items="${list[0].propertyLabelKeyMap}">
				<nssb:displaytag-column titleKey="${entry.value}" property="${entry.key}" labelTitleKey="${entry.value}"/>
			</c:forEach>
		</c:if>
		<c:if test="${! empty fieldFormatterMap}">
			<c:forEach var="entry" items="${fieldFormatterMap}">
				<nssb:displaytag-column isImporto="${entry.value.type == 1}" class="${entry.value.cssClass}" titleKey="${entry.value.label}" property="${entry.key.value}" labelTitleKey="${entry.value.label}"/>		
			</c:forEach>
		</c:if>
		<c:choose>
			<c:when test="${type eq '0'}">
				<nssb:displaytag-column-button action="itemSelector.do" labelKey="label.open" imageKey="ico.open" parameter="select"/>		
			</c:when>	
			<c:when test="${(type eq '1') || (type eq '2') || (type eq '3')}">
				<nssb:displaytag-column titleKey="label.selection" labelTitleKey="label.selection"><input id="check_${row_rowNum}" name="<%=SessionAttributes.ROW%>" value="${row_rowNum-1}" type="checkbox" /></nssb:displaytag-column>
			</c:when>	
		</c:choose>
		<c:if test="${type eq '3'}">
			<nssb:displaytag-column-button action="itemSelector.do" labelKey="label.shiftUp" imageKey="ico.shiftUp" parameter="shiftUp"/>
			<nssb:displaytag-column-button action="itemSelector.do" labelKey="label.shiftDown" imageKey="ico.shiftDown" parameter="shiftDown"/>
		</c:if>	
		
		
	</nssb:displaytag-table>
</c:if>

		
		
		
		<nssb:buttons>
			<nssb:submit controllerCode="cancel" keyValue="label.exit"/>
			<c:if test="${!empty list}">
				<nssb:submit controllerCode="multiSelect" keyValue="label.multiSelect"/>
				<nssb:submit controllerCode="selectAll" keyValue="label.selectAll"/>
			</c:if>
		</nssb:buttons>      
		
		
		</nssb:section>

</div>
