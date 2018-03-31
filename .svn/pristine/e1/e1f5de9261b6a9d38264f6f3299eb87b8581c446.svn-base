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
<!-- PageName = selezionaAmm.jsp -->
<demdec:useAttribute id="firmatariList"	name="<%=SessionAttributes.LIST_ANAG_FIRMATARI%>" />
<%-- <demdec:useAttribute id="rowsMap"	name="<%=WebConstants.LIST_ROWS%>" /> --%>
<tiles:useAttribute name="action" />
 
 <h2 class="nascosto">Tabella</h2>

 <div class="spacer_sm">&nbsp;</div>
<c:if test="${ not empty firmatariList}">
        <div class="title_doc">Abilita ricezione mail</div>
        <div class="spacer_sm_10">&nbsp;</div>
		<demdec:displaytag-table name="pageScope.firmatariList" id="firmatariElement" class="lux width100">	
			<display:caption>
						<span class="nascosto">Lista Destinatari Mail</span>
			</display:caption>
					<%-- <c:if test="${firmatariElement.id != 'DIR'}"> --%>
							<demdec:displaytag-column property="descFirmatario" titleKey="label.abilitaInvioMail.descFirmatario"  />
							<%-- <demdec:displaytag-column property="codiTagFirma" titleKey="label.descrizione"   /> --%>
							<demdec:displaytag-column property="descTipoFirma" titleKey="label.abilitaInvioMail.descTipoFirma"   />
							<%-- <demdec:displaytag-column property="descPec" titleKey="label.abilitaInvioMail.tipoMail"   /> --%>
							<demdec:displaytag-column property="descStato" titleKey="label.abilitaInvioMail.stato"   />
							<demdec:displaytag-column titleKey="label.abilitaInvioMail.ricezione"  class="center">
								<c:choose>
									<c:when test="${firmatariElement.flagAbilitaMail01 eq 1}">
										<demdec:linkButton  labelKey="label.disabilitaInvioMail" action="${action}" imageKey="ico.document.delete"  parameter="disabilitaDestinatarioMail" parameterValue="${firmatariElement_rowNum }" />
				 					</c:when>	
				 					<c:otherwise>
										<demdec:linkButton  labelKey="label.abilitaInvioMail" action="${action}" imageKey="ico.document.modify"  parameter="abilitaDestinatarioMail" parameterValue="${firmatariElement_rowNum }" />
									</c:otherwise>
			 					</c:choose>
							</demdec:displaytag-column>
		</demdec:displaytag-table> 
		</c:if>
		
<br />
