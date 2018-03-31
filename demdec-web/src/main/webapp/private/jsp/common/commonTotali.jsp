<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="cons"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tiles:useAttribute name="labelTotali" 			classname="java.lang.String" ignore="true"/>
<tiles:useAttribute name="showModificheButton" 	classname="java.lang.String" ignore="true"/>
<tiles:useAttribute name="showSaveButton" 		classname="java.lang.String" ignore="true"/>

<cons:useAttribute id="f" name="<%=BaseSessionAttributes.FORM%>" />

<form:hidden path="warning"/>

<table class="paddingtop0">
	<tbody>
		<c:if test="${not empty labelTotali }">
			<tr>
				<td colspan="1" class="paddingtop5 testo11tit">
					<cons:label 
						styleClass="normal"
						labelKey="${labelTotali}"/>
				</td>
			</tr>			
		</c:if>
					
		<tr>					
			<td>
				<!-- TOTALI -->
				<tiles:insertAttribute name="totali" flush="true" ignore="false"/>
				<!-- TOTALI -->
			</td>
		</tr>			
	</tbody>
	<tfoot>
		<!-- BOTTONI -->
		<tr>
			<td colspan="4">

				<c:if test="${empty f.warning}">
					<c:if test="${showModificheButton eq 'true'}">
						<cons:submit keyValue="button.aggiorna" controllerCode="modifica"/>
					</c:if>
					<c:if test="${showSaveButton eq 'true'}">
						<cons:submit keyValue="button.salva"  controllerCode="salva"/>
					</c:if>				
				</c:if>
				<c:if test="${not empty f.warning}">
					<c:if test="${showModificheButton eq 'true'}">
						<cons:submit keyValue="button.annulla" controllerCode="eseguiRicerca"/>
					</c:if>
					<c:if test="${showSaveButton eq 'true'}">
						<cons:submit keyValue="button.conferma"  controllerCode="conferma"/>
					</c:if>				
				</c:if>				
			</td>
		</tr>
		<!-- END BOTTONI -->
	</tfoot>
</table>
<hr style="border: 1px solid #FFF;" />