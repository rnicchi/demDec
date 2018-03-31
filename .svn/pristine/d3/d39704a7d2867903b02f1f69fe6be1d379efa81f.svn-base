<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%-- <%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
 --%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- PageName = ricercaFAD.jsp -->
<!-- Controller  ConsultaFascicoloFadController-->

<demdec:useAttribute id="listAnniEser" name="<%=SessionAttributes.LIST_ANNO_ESE%>"/> 
<demdec:useAttribute id="tipoDecretoList" name="<%=SessionAttributes.LIST_TIPI_DECRETI%>" /> 
<demdec:useAttribute id="tipologiaDecretoLis" name="<%=SessionAttributes.LIST_TIPOLOGIA_DECRETO%>"/> 
<demdec:useAttribute id="amministrazioneList" name="<%=SessionAttributes.LIST_AMMIN_DEM%>"/>  
<demdec:useAttribute id="ufficioCapofilaListList" name="<%=SessionAttributes.LIST_ANAG_UFF%>"/>  
<demdec:useAttribute id="anagStatiFascList" name="<%=SessionAttributes.LIST_ANAG_STATI_FASC%>"/>  
<demdec:useAttribute id="cdrList" name="<%=SessionAttributes.LIST_ANAG_CDR_DEM%>"/>  

<fieldset>
  
	<div class="container_field"> 
		<div class="row"> 
			<div class="small-4 columns">
				<label for="tipoDecreto"><spring:message code="label.tipoDecreto"/></label>
				<form:select path="tipoDecreto">
					<form:option value="">&nbsp;</form:option>
					<c:forEach items="${tipoDecretoList}" var="item">
						<form:option value="${item.id}">${item.descSigla} </form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="small-4 columns">
				<label for="numeDecreto"><spring:message code="label.numeroDecreto"/></label>
				<form:input path="numeDecreto" maxlength="6"/>
			</div>
			<div class="small-4 columns">
				<label for="annoDecreto"><spring:message code="label.anno.dec"/></label>
				<form:select path="annoDecreto"   > 
					<c:forEach var="item" items="${listAnniEser}">		
						<form:option value="${item.id}" >${item.id} </form:option> 
					</c:forEach>    		
				</form:select>  
			</div>
		</div>		
	</div>
	
	<%-- <div class="row"> 
		<div class="small-4 columns">
			<demdec:label path="dataArrivoDa" labelKey="label.raccolteProvvisorie.dataCreazioneDa"/>
			<form:input path="dataArrivoDa" placeholder="gg/mm/aaaa" maxlength="10"/>
		</div>
		<div class="small-4 columns">
			<demdec:label path="dataArrivoA" labelKey="label.raccolteProvvisorie.dataCreazioneA"/>
			<form:input path="dataArrivoA" placeholder="gg/mm/aaaa" maxlength="10"/>
		</div>
		<div class="small-4 columns">
		</div>
	</div> --%>
	
	<div class="row"> 
		<div class="small-4 columns">
			<label for="numeProtEntrata"><spring:message code="label.consFadCdc.numeProtEntrata"/></label>
			<form:input path="numeProtEntrata"/>
		</div>
		<div class="small-4 columns">
			<label for="dataProtEntrata"><spring:message code="label.consFadCdc.dataProtEntrata"/></label>
			<form:input path="dataProtEntrata" placeholder="gg/mm/aaaa" maxlength="10"/>
		</div>
		<div class="small-4 columns">
		</div>
	</div>
	
	<div class="row"> 
		<div class="small-4 columns">
			<label for="dataPresaInCarico"><spring:message code="label.consFadCdc.dataPresaCarico"/></label>
			<form:input path="dataPresaInCarico" placeholder="gg/mm/aaaa" maxlength="10"/>
		</div>
	</div>
	
	<%-- <div class="row"> 
		<div class="small-4 columns">
			<demdec:label path="numeProtUscita" labelKey="label.consFadCdc.numeProtUscita"/>
			<form:input path="numeProtUscita" />
		</div>
		<div class="small-4 columns">
			<demdec:label path="dataProtUscita" labelKey="label.consFadCdc.dataProtUscita"/>
			<form:input path="dataProtUscita" placeholder="gg/mm/aaaa" maxlength="10" />
		</div>
		<div class="small-4 columns"></div>
	</div> --%>
	
	<br>
	<div class="row">
		<div class="small-10 columns">
			<demdec:submit keyValue="label.filtro.data" controllerCode="eseguiRicerca"/>
			&nbsp;
			<demdec:submit keyValue="label.clean" controllerCode="nuovaRicercaCdc"/>
		</div> 			
	</div>
		
</fieldset>

<%-- <div class="row">
	<div class="large-12 columns">
		<fieldset>
			<div class="row">
				<div class="small-3 columns">
					<demdec:label path="tipoDecreto" labelKey="label.tipoDecreto"/>
					<form:select path="tipoDecreto">
						<form:option value="">&nbsp;</form:option>
						<c:forEach items="${tipoDecretoList}" var="item">
							<form:option value="${item.id}">${item.descSigla} </form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row">
				<div class="small-3 columns">
					<demdec:label path="numeDecreto" labelKey="label.numeroDecreto"/>
					<form:input path="numeDecreto" maxlength="6"/>
				</div>
			</div>
			<div class="row">
				<div class="small-3 columns">
					<demdec:label path="annoDecreto" labelKey="label.anno.dec"/>
		       		 <form:select path="annoDecreto"   > 
		          		<c:forEach var="item" items="${listAnniEser}">		
							 <form:option value="${item.id}" >${item.id} </form:option> 
						</c:forEach>    		
		        	 </form:select>  
				</div>
			</div>
			
			
			
	
			<div class="row">
				<div class="small-3 columns">
					
					<demdec:label path="dataArrivoDa" labelKey="label.dataArrivoDa"/>
					<form:input path="dataArrivoDa" placeholder="gg/mm/aaaa" maxlength="10"/>
				</div>
			</div>		
			
			<div class="row">
				<div class="small-3 columns">
					
					<demdec:label path="dataArrivoA" labelKey="label.dataArrivoA"/>
					<form:input path="dataArrivoA" placeholder="gg/mm/aaaa" maxlength="10"/>
				</div>
			</div>
			
			
			<div class="row">
				<div class="small-3 columns">
					<demdec:label path="numeProtEntrata" labelKey="label.consFadCdc.numeProtEntrata"/>
					<form:input path="numeProtEntrata"/>
				</div>
			</div>
			<div class="row">
				<div class="small-3 columns">
					<demdec:label path="dataProtEntrata" labelKey="label.consFadCdc.dataProtEntrata"/>
					<form:input path="dataProtEntrata" placeholder="gg/mm/aaaa" maxlength="10"/>
				</div>
			</div>
			
			<div class="row">
				<div class="small-3 columns">
					<demdec:label path="dataPresaInCarico" labelKey="label.consFadCdc.dataPresaCarico"/>
					<form:input path="dataPresaInCarico" placeholder="gg/mm/aaaa" maxlength="10"/>
				</div>
			</div>
				<div class="row">
				<div class="small-3 columns">
					<demdec:label path="numeProtUscita" labelKey="label.consFadCdc.numeProtUscita"/>
					<form:input path="numeProtUscita" />
				</div>
			</div>
			<div class="row">
				<div class="small-3 columns">
					<demdec:label path="dataProtUscita" labelKey="label.consFadCdc.dataProtUscita"/>
					<form:input path="dataProtUscita" placeholder="gg/mm/aaaa" maxlength="10" />
				</div>
			</div>
						
			<br>
			<div class="row">
				<div class="small-10 columns">
					<demdec:submit keyValue="label.filtro.data" controllerCode="eseguiRicerca"/>
					&nbsp;
					<demdec:submit keyValue="label.clean" controllerCode="nuovaRicercaCdc"/>
				</div> 			
			</div>
			
			
			
	</fieldset>
	</div>
</div> --%>
