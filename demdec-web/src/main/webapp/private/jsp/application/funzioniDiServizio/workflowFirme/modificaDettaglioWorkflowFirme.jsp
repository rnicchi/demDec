<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%> 
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="it.mef.bilancio.demdec.utils.Constants"%>

<!-- PageName = modificaDettaglioWorkflowFirme -->
<nssb:useAttribute id="listaIterFirma" name="<%=SessionAttributes.LIST_ITER_FIRMA%>"></nssb:useAttribute>
<nssb:useAttribute id="listaAnagFirmatari" name="<%=SessionAttributes.LIST_ANAG_FIRMATARI%>"></nssb:useAttribute>

<script type="text/javascript">

	function rowUp(){
    	
    	var selectedRadio = $('input[name="selectedIterFirma"]:checked');
    	var current = selectedRadio.closest('tr');
    	var previous = current.prev('tr');

    	if(previous.length !== 0){
	    	var currentNrOrdine = selectedRadio.closest('td').next('td');
	    	previous.children().eq(1).text(currentNrOrdine.text());
	    	currentNrOrdine.text(currentNrOrdine.text()-1);

		    current.insertBefore(previous);
    	}
    }
    function rowDown(){

    	var selectedRadio = $('input[name="selectedIterFirma"]:checked');
    	var current = selectedRadio.closest('tr');
    	var next = current.next('tr');

    	if(next.length !== 0){
        	var currentNrOrdine = selectedRadio.closest('td').next('td');
        	var nextNrOrdine = next.children().eq(1).text();
	    	next.children().eq(1).text(currentNrOrdine.text());
	    	//currentNrOrdine.text(currentNrOrdine.text()+1);	//aggiunge stringa
	    	currentNrOrdine.text(nextNrOrdine);

	    	current.insertAfter(next);
    	}
    }



    function recuperaListaOrdine() {
    	var radios = $('form input[name="selectedIterFirma"]:radio');	//input radio
    	//var radios = $('form input[name="selectedIterFirma"]:radio').parent().next('td');	//Numero ordine
    	//var radios = $('form input[name="selectedIterFirma"]:radio').parent().next('td').next();	//firmatario
    	//var radios = $('form input[name="selectedIterFirma"]:radio').parent().next('td').next().next();	//Tipo firma
    	//visualizzaInfoDomElement(radios);

    	var listaRadioValues = [];
		for (index=0; index<radios.length; index++)
			listaRadioValues.push(radios.get(index).getAttribute("value"));
		document.getElementById('firmatari').value = listaRadioValues;
		return true;
	}

    function checkEffectivelyChanges() {
    	if (anagFirmatario.value == '' && descIter.value == descIterRetrieved.value)
    		return false;
		return true;
    }
</script>



<div class="row">
	<div class="large-12 columns">
		 <!--<h2>Ricerca</h2>-->
	</div>
<c:if test="${not empty listaIterFirma}">
	<div class="large-12 columns">
		<fieldset>
			<div class="row">
				<div class="small-5 columns">
					<%-- <demdec:label path="modello" labelKey="label.modello.iter"/> --%>
					<label for="modello"><spring:message code="label.modello.iter"/></label>
					<demdec:input-text path="descIter" maxlength="<%=Constants.LUNGHEZZA_MASSIMA_DESCR_MODELLO_ITER.toString()%>"/>
					<form:hidden path="descIterRetrieved"/>
					<form:hidden path="selectedModello"/>
					<form:hidden path="listaNuovoOrdineFirmatari" id='firmatari'/>
				</div> 
			</div>
			
			<div class="row">
				
				<div class="small-5 columns left ">
					<%-- <demdec:label path="anagFirmatario"  labelKey="label.workflow.firme.aggiungi.firmatario"/> --%>
					<label for="anagFirmatario"><spring:message code="label.workflow.firme.aggiungi.firmatario"/></label>
					<form:select path="anagFirmatario" >
						<form:option value="" >&nbsp;</form:option>
						<c:forEach var="msg" items="${listaAnagFirmatari}">
							<form:option value="${msg.id}" >${msg.descFirmatario} - ${msg.descTipoFirma}</form:option>
						</c:forEach> 
					</form:select> 
				</div> 
				<div class="small-2 columns left bottom">
				  
					<demdec:submit	keyValue="label.confirm" controllerCode="confermaIterFirma" 
									onclick="javascript:return checkEffectivelyChanges();" styleClass="button small marg_top_10"/>
									
				</div> 
			</div>
		
			<div class="spacer_sm">&nbsp;</div>
				<div class="title_doc"><spring:message code="label.title.lista.iter.firma"></spring:message></div>
				<div class="spacer_sm_10">&nbsp;</div>
				<nssb:displaytag-table name="pageScope.listaIterFirma" id="listaIterFirma" class="width100" >
					<display:caption>
						<span class="nascosto">
							<strong> <spring:message code="label.title.lista.iter.firma"></spring:message></strong>
						</span>
					</display:caption>

					<nssb:displaytag-column title="<span class=nascosto>Selezione</span>" class="center"> <!--  headerClass="nascosto" title="Selezione" class="center" >  -->
						<label for="radio_${listaIterFirma_rowNum}" class="nascosto">Seleziona</label>
						<input type="radio" name="selectedIterFirma" value="${listaIterFirma.id.numeOrdine}" id="radio_${listaIterFirma_rowNum}" class="optim" />
					</nssb:displaytag-column>
					<nssb:displaytag-column property="id.numeOrdine" titleKey="label.workflow.firme.numero.ordine" class="center" />
					<nssb:displaytag-column property="anagFirmatari.descFirmatario" titleKey="label.workflow.firme.firmatario"/>
					<nssb:displaytag-column property="anagFirmatari.descTipoFirma" titleKey="label.workflow.firme.tipofirma"/>

				</nssb:displaytag-table>
				<div class="left padd-top_10 color_blu">
					<a href="javascript: rowUp(); "><img src="<%=request.getContextPath()%>/public/img/arrow_up_rec.png" alt="Sposta verso l'alto" title="Sposta verso l'alto"></a>
					<a href="javascript: rowDown(); "><img src="<%=request.getContextPath()%>/public/img/arrow_down_rec.png" alt="Sposta verso il basso" title="Sposta verso il basso"></a>
					 Utilizzare le frecce per modificare il numero d'ordine
				</div>
			</div>
			
		</fieldset>

		<div class="center small">
		   	 <demdec:submit keyValue="label.save.ordine.firma" controllerCode="salvaOrderIterFirma" 
		   	 				onclick="javascript:return recuperaListaOrdine();"/>
		   	 <demdec:submit keyValue="label.delete.firmatario" controllerCode="eliminaIterFirma" 
							onclick="javascript:return confirm('Conferma cancellazione');"/>
		   	 <demdec:submit keyValue="label.back" controllerCode="back" />
		</div>
	</div>
</c:if>

</div>
