<%@ page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@ page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display-el"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- <demdec:useAttribute id="fascList" name="<%=WebConstants.LIST_DECRETI_APERTI%>" /> --%>
<%-- <demdec:useAttribute id="fascListRielaborazione" name="<%=WebConstants.LIST_DECRETI_RIELABORAZIONE%>" /> --%>
<demdec:useAttribute id="annoDecList" name="<%=WebConstants.LIST_ANNO_ESE%>" />
<demdec:useAttribute id="tipoDecList"	name="<%=WebConstants.LIST_TIPO_DEC%>" />

	<div class="large-12 columns">
		<div class="spacer_sm">&nbsp;</div>
		<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
		<fieldset>
			
			<demdec:label path="idFascicolo" labelKey="label.rielabFascicolo.numDecreto" />	
			<div class="container_field"> 
				<div class="row">
					<div class="small-4 columns">
						<demdec:label path="tipoDecreto" labelKey="label.decreto.tipo.obb" />
						<form:select path="tipoDecreto" onChange="this.form.norm.value=0;">
								<form:option value="" label="-- Selezionare un tipo decreto --" />
								<c:forEach var="t" items="${tipoDecList}">
									<form:option value="${t.id}">${t.descSigla}</form:option>
								</c:forEach>
						</form:select>
					</div>
					<div class="small-3 columns">
						<demdec:label path="numDecreto" labelKey="label.decreto.numero.obb" />
						<form:input path="numDecreto" size="6"  maxlength="6" />
					</div>
					<div class="left">
						<demdec:label path="annoDecreto" labelKey="label.decreto.anno.obb" />
						<form:select path="annoDecreto">
							<form:option value="" label="-- Selezionare un anno --" />
							<c:forEach var="anno" items="${annoDecList}">
								<form:option value="${anno.id}">${anno.id}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			
			<div class="spacer_sm">&nbsp;</div>
	
					<div id="fascArrivo">
						<demdec:label path="idFascicoloArrivo" labelKey="label.rielabFascicolo.decretoArrivo" />	
						<div class="container_field" > 
							<div class="row">
								<div class="small-4 columns">
									<demdec:label path="tipoDecretoArrivo" labelKey="label.decreto.tipo.obb" />
									<form:select path="tipoDecretoArrivo" onChange="this.form.norm.value=0;">
											<form:option value="" label="-- Selezionare un tipo decreto --" />
											<c:forEach var="t" items="${tipoDecList}">
												<form:option value="${t.id}">${t.descSigla}</form:option>
											</c:forEach>
									</form:select>
								</div>
								<div class="small-3 columns">
									<demdec:label path="numDecretoArrivo" labelKey="label.decreto.numero.obb" />
									<form:input path="numDecretoArrivo" size="6"  maxlength="6" />
								</div>
								<div class="left">
									<demdec:label path="annoDecretoArrivo" labelKey="label.decreto.anno.obb" />
									<form:select path="annoDecretoArrivo">
										<form:option value="" label="-- Selezionare un anno --" />
										<c:forEach var="anno" items="${annoDecList}">
											<form:option value="${anno.id}">${anno.id}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
					</div>
					
					<div class="spacer_sm">&nbsp;</div>
			
			<div class="row">
				<div class="small-4 columns left">
					<demdec:label path="tipoElab" labelKey="label.rielabFascicolo.tipoElaborazione.obb"></demdec:label>
					<form:select path="tipoElab" onchange="checkElaborazione();">
						<form:option value="" label="-- Selezionare un valore --" />
						<form:option value="1" label="Riapertura Fascicolo" />
						<form:option value="2" label="Sospensione Fascicolo" />
						<form:option value="3" label="Revoca Sospensione Fascicolo" />
						<form:option value="4" label="Trasporto Variazioni Fascicolo" />
					</form:select>
				</div>
			</div>
			
			<div class="spacer_sm">&nbsp;</div>
			<div class="row">
				<div class="small-10 columns">
					<demdec:submit keyValue="button.elaboraFascicolo" controllerCode="eseguiRielaborazione"  onclick="return confermaOperazione();"/>
				</div>
			</div>
		</fieldset>
	</div>

<script>

$( document ).ready(function() {
	if ($("#tipoElab").val()!='4'){
		$("#fascArrivo").hide();
	}
});

function checkElaborazione(){
	
	if ($("#tipoElab").val()=='4'){
		$("#fascArrivo").show();
	}
	else {
		$("#fascArrivo").hide();
	}
}

	function confermaOperazione(){
		switch($("#tipoElab").val()) {
	    case '1':
	    	return confirm('Confermi la Riapertura Fascicolo?');
	       break;
	    case '2':
	    	return confirm('Confermi la Sospensione Fascicolo?');
	       break;
	    case '3':
	    	return confirm('Confermi la Revoca Sospensione Fascicolo?');
	        break;
	     case '4':
	    	 return confirm('Con il trasporto variazioni verrà cancellato l\'Atto Decreto. Procedere?');
	        break;
	    default:
	        return ;
	} 
	
}

</script>