<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<demdec:useAttribute id="testiPersList" name="<%=SessionAttributes.LIST_TESTI_PERS%>"/>

<tiles:useAttribute name="action"/>
<tiles:insertAttribute name="modalAmm" flush="false"/>

<div class="overlay"></div>


<div class="spacer_sm">&nbsp;</div>
<div>

	<c:set var="personalizzato" value="false"/>
	<demdec:displaytag-table class="lux tableDati" name="pageScope.testiPersList" id="testoPers" >
				<display:caption>
					<span class="nascosto"><spring:message code="label.caption.table.testi.pers"/></span>
				</display:caption>
								
				<%-- <demdec:displaytag-column titleKey="label.testiPers.numRiga" class="center">
					${testoPers_rowNum}
				</demdec:displaytag-column>
				--%>
				<demdec:displaytag-column titleKey="label.testiPers.sez" class="center nowrap">
					${testoPers.codiSezione}
					<c:if test="${testoPers.personalizzato eq 'S'}">
						<c:set var="personalizzato" value="true"/>
					</c:if>
				</demdec:displaytag-column>
				
				<demdec:displaytag-column titleKey="label.testiPers.numParagrafo" class="center">
					${testoPers.numeRiga}
				</demdec:displaytag-column>
				
				<demdec:displaytag-column titleKey="label.testiPers.testo">
					<label class="nascosto" for="textContenuto"><spring:message code="label.testiPers.modTesto"/></label>
					<form:textarea path="textContenuto" rows="4" cols="120" cssClass="textarea_pers"></form:textarea> 
				</demdec:displaytag-column>
				
	</demdec:displaytag-table>
	
	<div class="row">
			<form:hidden path="idFascicolo"  />		        	
       		<demdec:submit keyValue="button.salva" controllerCode="salvaPersonalizza" />
       		
       		<c:if test="${personalizzato }">
       			&nbsp;
       			<demdec:submit keyValue="button.fad.cancella" controllerCode="rimuoviPersonalizza" />
       		</c:if>
       		
       		&nbsp;
       		<demdec:submit keyValue="button.annulla" controllerCode="backFromLettere" />
       	
     </div>      			
	
</div>