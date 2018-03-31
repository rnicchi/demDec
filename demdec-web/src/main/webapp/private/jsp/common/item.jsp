<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>

<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>

<tiles:useAttribute name="deepLevel" classname="java.lang.String"/>
<tiles:useAttribute name="item" classname="it.almavivaitalia.bsn.sh.to.ItemTO"/>
<nssb:useAttribute id="codiProfilo" name="<%=SessionAttributes.OBJECT_USER%>" property="profilo.codiProfilo"/>

<c:set var="className" value="menu${deepLevel}livello"/>


<ul class="<c:out value="${className}"/>">
<li>
	<%--INIZIO renderizzazione voce di menu in base al fatto che il campo action della voce
		di menu sia vuota o meno
	--%>
	<c:choose>
		<%--INIZIO Se item.action NON E' VUOTA si renderizza un link per l'attivazione della realativa action--%>
		<c:when test="${!empty item.action}">
			<c:choose>
				<c:when test="${item.action.flagActive eq '1'}">
					<c:choose>
						<c:when test="${not empty item.descItem}">
							<nssb:linkButton 
											label="${item.descItem}" 
												action="<%=ConstantsRequestMapping.MENU_SBFJ%>" 
													parameter="<%=WebConstants.PARAMETER_MENU_ACTION_SELECTED %>" 
														parameterValue="${item.action.codiAction}"/>						
						</c:when>
						<c:otherwise>
							<nssb:linkButton 
											labelKey="item.${item.codiItem}" 
												action="<%=ConstantsRequestMapping.MENU_SBFJ%>" 
													parameter="<%=WebConstants.PARAMETER_MENU_ACTION_SELECTED %>" 
														parameterValue="${item.action.codiAction}"/>							
						</c:otherwise>
					</c:choose>

				</c:when>	
				<c:when test="${item.action.flagActive eq '0'}">
					<c:choose>
						<c:when test="${not empty item.descItem}">
							<nssb:label 
								label="${item.descItem}" 
								styleClass="inactive"/>							
						</c:when>
						<c:otherwise>
							<nssb:label 
								labelKey="item.${item.codiItem}" 
								styleClass="inactive"/>							
						</c:otherwise>
					</c:choose>				
				</c:when>	
			</c:choose>
		</c:when>
		<%--FINE Se item.action NON E' VUOTA si renderizza un link per l'attivazione della realativa action--%>


		<%--INIZIO Se item.action E' VUOTA significa che l'item in analisi prevede voci di menu figlie: 
			gestione della visualizzazione o meno delle voci figlie
		--%>
		<c:otherwise>
		
			<c:if test="${!empty item.menu}">
				<c:choose>
					<c:when test="${not empty item.descItem}">
						<nssb:linkButton 
								label="${item.descItem}" 
								action="<%=ConstantsRequestMapping.MENU_SBFJ%>" 
								parameter="<%=WebConstants.PARAMETER_MENU_MENU_SELECTED %>" 
								parameterValue="${item.action.codiMenu}"/>					
					</c:when>
					<c:otherwise>
						<nssb:linkButton 
								labelKey="item.${item.codiItem}" 
								action="<%=ConstantsRequestMapping.MENU_SBFJ%>" 
								parameter="<%=WebConstants.PARAMETER_MENU_MENU_SELECTED %>" 
								parameterValue="${item.action.codiMenu}"/>						
					</c:otherwise>
				</c:choose>			
			</c:if>
			
			<c:if test="${empty item.menu} && ${empty item.action}">
				<spring:message code="item.${item.codiItem}" text="${item.descItem}"/>				
			</c:if>		
		
			<c:choose>
				<c:when test="${!empty item.itemList}">
				
					<c:choose>
						<c:when test="${not empty item.descItem}">
							<nssb:linkButton label="${item.descItem}" 
										action="<%=ConstantsRequestMapping.MENU_SBFJ%>" 
										parameter="<%=WebConstants.PARAMETER_MENU_SUB_ITEM_SELECTED%>" 
										parameterValue="${item.id}"/>				
						</c:when>
						<c:otherwise>
							<nssb:linkButton labelKey="item.${item.codiItem}" 
										action="<%=ConstantsRequestMapping.MENU_SBFJ%>" 
										parameter="<%=WebConstants.PARAMETER_MENU_SUB_ITEM_SELECTED%>" 
										parameterValue="${item.id}"/>					
						</c:otherwise>
					</c:choose>					

					<c:choose>
						<c:when test="${(!empty item.showChild) and (item.showChild) }">
							<c:forEach var="item2" items="${item.itemList}">	
								<!--  contains start -->
								<c:set var="contains" value="false" /> 
								<c:forEach var="profile" items="${item2.profiloList}"> 
							  		<c:if test="${profile.codiProfilo eq codiProfilo}"> 
							    		<c:set var="contains" value="true" /> 
							  		</c:if> 
								</c:forEach> 
								<!--  contains end -->
								<c:if test="${contains}">		
									<tiles:insertTemplate template="/jsp/common/item.jsp" flush="true">
										<tiles:putAttribute name="deepLevel" value="<%=String.valueOf(Integer.parseInt(deepLevel)+1)%>"/>
										<tiles:putAttribute name="item" value="${pageScope.item2}"/>
							        </tiles:insertTemplate>
							    </c:if>
							</c:forEach>							
						</c:when>	
					</c:choose>	
			    </c:when>
			    
		    </c:choose>
		</c:otherwise>
		<%--FINE Se item.action E' VUOTA significa che l'item in analisi prevede voci di menu figlie: 
			gestione della visualizzazione o meno delle voci figlie
		--%>	
		
	</c:choose>
	<%--FINE renderizzazione voce di menu in base al fatto che il campo action della voce
		di menu sia vuota o meno
	--%>
	
	
	

	

</li>
</ul>