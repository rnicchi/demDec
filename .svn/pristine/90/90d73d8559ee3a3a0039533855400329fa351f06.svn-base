
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<%-- 
Questo file rappresenta un template per interfacce web con 1 solo tab.
Per un solo tab tale formione non ha molto senso, ma e' stata creata per
uniformare le interfacce.
Significato degli attributi:
--	labelAction1, deve essere una chiave presente in un opportuno file di 
	properties. il valore referenziato dalla suddetta chiave, rappresentera'
	l'etichetta visualizzata sul primo (ed unico) tab;	
--%>

<tiles:useAttribute name="labelAction1" classname="java.lang.String"/>

<div class="tab">
	<ul>
		<li class="current">
			<a href="#">
				<span><spring:message code="${labelAction1}"/></span>
			</a>
		</li>
	</ul>    
</div>