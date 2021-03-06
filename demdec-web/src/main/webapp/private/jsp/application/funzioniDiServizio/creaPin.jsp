<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!-- PageName = creaPin.jsp -->
<%-- 
<demdec:useAttribute id="amministrazioniSelectedList"	name="<%=WebConstants.LIST_SELECTED_AMMS%>" />
<demdec:useAttribute id="indexesSelected"	name="<%=WebConstants.ROW_INDEX_SELECTED_AMMS%>" />
<demdec:useAttribute id="tipoDecList"	name="<%=WebConstants.LIST_TIPO_DEC%>" />
<demdec:useAttribute id="annoDecList"	name="<%=WebConstants.LIST_ANNO_DEC%>" />
<demdec:useAttribute id="tipologiaDecList"	name="<%=WebConstants.LIST_TIPOLOGIA_DEC%>" />
<demdec:useAttribute id="cdrSelectedList"	name="<%=WebConstants.LIST_SELECTED_CDRS%>" />	
<demdec:useAttribute id="ufficioList"	name="<%=WebConstants.LIST_ANAG_UFF%>" />	 --%>
<demdec:useAttribute id="codiPinFirma"	name="<%=SessionAttributes.CODI_PIN_FIRMA%>" />	 
<demdec:useAttribute id="funzioneOrigine"	name="<%=SessionAttributes.FUNZIONE_ORIGINE%>" />

<div class="row">
		<fieldset>

			<div class="row">
				<div class="small-5 columns">
					<demdec:label path="codiPinFirma" labelKey="label.pin.criptato" />
					<form:input path="codiPinFirma" size="16"  disabled="true" />
				</div>
			</div>

			<div class="row">
				<c:choose>
					<c:when test="${codiPinFirma == null ||  codiPinFirma==''}">
						<div class="small-3 columns">
							<demdec:label path="pin" labelKey="label.pin" />
							<form:password path="pin"  size="6"    />
						</div>
					</c:when>
					<c:otherwise>
						<div class="small-3 columns">
							<demdec:label path="pin" labelKey="label.pin" />
							<form:password path="pin"  size="6"  disabled="true"  />
						</div>
					</c:otherwise>
				</c:choose>

			</div>

			<div class="row">
			<c:choose>
				<c:when test="${codiPinFirma == null ||  codiPinFirma==''}">
					<div class="small-10 columns">
						<demdec:submit keyValue="button.pin.crea"
							controllerCode="creaPin"  titleKey="button.pin.crea" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="small-10 columns">
						<demdec:submit keyValue="button.pin.revoca"
							controllerCode="revocaPin"  titleKey="button.pin.revoca" />
					</div>
				</c:otherwise>
			</c:choose>
			</div>

		    <c:if test="${requestScope.nomeFunzione ne null && requestScope.nomeFunzione ne '' }">
		      	 <div class="row center">
		    	 	<a class="linkbutton" href="<%=request.getContextPath()%>${nomeFunzione}"><spring:message code="button.ritornoLista"></spring:message> </a>
		      	 </div>
		    </c:if>
		  
		</fieldset>

</div>
