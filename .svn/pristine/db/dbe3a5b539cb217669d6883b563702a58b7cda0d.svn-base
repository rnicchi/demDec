<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>

<nssb:useAttribute id="items" name="<%=SessionAttributes.LIST_MENU_ITEM%>"/>
<nssb:useAttribute id="codiProfilo" name="<%=SessionAttributes.OBJECT_USER%>" property="profilo.codiProfilo"/>



   <!-- CONTENUTO PAGINA -->
        <div class="main">
           <div class="imghome"> 
        	<c:if test="${!empty items}">
    	  		<div class="basesottomenu">
            	<br />
               <div class="sottomenu">
						<c:forEach var="item" items="${items}">	
							
							<!--  contains start -->
							<c:set var="contains" value="false" /> 
							<c:forEach var="profile" items="${item.profiloList}"> 
						  		<c:if test="${profile.codiProfilo eq codiProfilo}"> 
						    		<c:set var="contains" value="true" /> 
						  		</c:if> 
							</c:forEach> 
							<!--  contains end -->
							<c:if test="${contains}">
								<tiles:insertTemplate template="/jsp/common/item.jsp" flush="true">
									<tiles:putAttribute name="deepLevel" value="2"/>
									<tiles:putAttribute name="item" value="${pageScope.item}"/>
						        </tiles:insertTemplate>
					        </c:if>
						</c:forEach>
                 </div>
                </div>
         	</c:if>          
         </div>
        </div>
    <!-- fine CONTENUTO PAGINA -->    