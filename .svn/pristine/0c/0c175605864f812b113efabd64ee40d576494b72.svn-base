<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display-el"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>

<%@page import="it.almavivaitalia.web.sh.export.FieldFormatter"%>

<demdec:useAttribute id="list" name="<%=SessionAttributes.LIST_SELECTOR_ITEM%>"/>
<demdec:useAttribute id="type" name="<%=SessionAttributes.FLAG_SELECTOR_TYPE%>"/>
<demdec:useAttribute id="selectedRows" name="<%=SessionAttributes.OBJECT_SELECTOR_ITEM_SELECTED_INDEXES%>" type="java.lang.String"/>
<demdec:useAttribute id="fieldFormatterMap" name="<%=SessionAttributes.OBJECT_FIELD_FORMATTER_MAP%>" type="java.util.LinkedHashMap"/>
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

<demdec:section titleKey="${title}">

<c:if test="${!empty list}">
	
	<c:set var="typeImporto" value="<%=FieldFormatter.TYPE_IMPORTO%>"/>
	
	<demdec:displaytag-table name="pageScope.list" selectedRow="${selectedRows}">
		<!-- sbfj:displaytag-column indexedColumn="true"/-->
		
			<c:forEach var="entry" items="${fieldFormatterMap}">
				<demdec:displaytag-column isImporto="${entry.value.type == 1}" class="${entry.value.cssClass} " titleKey="${entry.value.label}" property="${entry.key.value}" labelTitleKey="${entry.value.label}"/>		
			</c:forEach>
	
		<c:choose>
			<c:when test="${type eq '0'}">
				<demdec:displaytag-column-button action="itemSelector.do" labelKey="label.open" imageKey="ico.open" parameter="select"/>		
			</c:when>	
			<c:when test="${(type eq '1') || (type eq '2') || (type eq '3')}">
				<demdec:displaytag-column titleKey="label.blank" labelTitleKey="label.selection"><form:checkbox path="row" id="check_${row_rowNum}" value="${row_rowNum-1}" /></demdec:displaytag-column>
			</c:when>	
		</c:choose>
		<c:if test="${type eq '3'}">
			<demdec:displaytag-column-button action="itemSelector.do" labelKey="label.shiftUp" imageKey="ico.shiftUp" parameter="shiftUp"/>
			<demdec:displaytag-column-button action="itemSelector.do" labelKey="label.shiftDown" imageKey="ico.shiftDown" parameter="shiftDown"/>
		</c:if>	
		
		
	</demdec:displaytag-table>
</c:if>
	<demdec:buttons>
		<demdec:submit controllerCode="cancel" keyValue="label.exit"/>
		<c:if test="${!empty list}">
		<c:choose>
			<c:when test="${type eq '1'}">
				<demdec:submit controllerCode="multiSelect" keyValue="label.multiSelect"/>
				<demdec:submit controllerCode="selectAll" keyValue="label.selectAll"/>
			</c:when>	
			<c:when test="${(type eq '2') || (type eq '3')}">
				<demdec:submit controllerCode="removeItems" keyValue="label.multiDelete"/>
				<demdec:submit controllerCode="removeAll" keyValue="label.deleteAll"/>
			</c:when>	
		</c:choose>
		</c:if>

		
	</demdec:buttons>      
</demdec:section>	

</div>
