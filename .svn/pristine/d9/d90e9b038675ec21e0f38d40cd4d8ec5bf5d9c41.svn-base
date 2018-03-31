
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<%-- 
Questo file rappresenta un template per interfacce web con 2 tab, formendo
opportunamnete i 2 tab in questione.
Significato degli attributi:
--	tabLabelCode, deve essere una chiave presente in un opportuno file di 
	properties. Tale valore permette di volta in volta di individuare il
	tab attivo ed esso deve essere uguale ad uno dei valori assunti dagli
	attributi labelAction1 o labelAction2 a seconda che si
	voglia renedere attivo rispettivamente il tab associato a labelAction1
	(primo tab), labelAction2 (secondo tab);
--	labelAction1, deve essere una chiave presente in un opportuno file di 
	properties. il valore referenziato dalla suddetta chiave, rappresentera'
	l'etichetta visualizzata sul primo tab;	
--	labelAction2, deve essere una chiave presente in un opportuno file di 
	properties. il valore referenziato dalla suddetta chiave, rappresentera'
	l'etichetta visualizzata sul secondo tab;
--	action1, deve indicare l'uri associata al controller che formisce il 
	primo tab;
--	action2, deve indicare l'uri associata al controller che formisce il 
	secondo tab;
					 
--%>

<tiles:useAttribute name="tabLabelCode" classname="java.lang.String"/>
<tiles:useAttribute name="action1" classname="java.lang.String"/>
<tiles:useAttribute name="action2" classname="java.lang.String"/>
<tiles:useAttribute name="labelAction1" classname="java.lang.String"/>
<tiles:useAttribute name="labelAction2" classname="java.lang.String"/>


<div class="tab">
	<ul>
		<c:if test="${tabLabelCode eq labelAction1}">
			<li class="current">
				<a href="#">
					<span><spring:message code="${labelAction1}"/></span>
				</a>
			</li>
		</c:if>
		<c:if test="${not (tabLabelCode eq labelAction1)}">
			<li>
				<a href="<%=request.getContextPath()%>/${action1}">
					<span><spring:message code="${labelAction1}"/></span>
				</a>
			</li>
		</c:if>
		
		
		<c:if test="${tabLabelCode eq labelAction2}">
			<li class="current">
				<a href="#">
					<span><spring:message code="${labelAction2}"/></span>
				</a>
			</li>
		</c:if>
		<c:if test="${not (tabLabelCode eq labelAction2)}">
			<li>
				<a href="<%=request.getContextPath()%>/${action2}">
					<span><spring:message code="${labelAction2}"/></span>
				</a>
			</li>
		</c:if>	
		
							
	</ul>    
</div>