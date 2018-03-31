<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- PageName = fascicoloFADIO.jsp -->
<demdec:useAttribute id="pagFascicoliRed"     name="<%=SessionAttributes.SOTTO_FASCICOLI_RED_PAGINATOR%>"/> 
<demdec:useAttribute id="listFascicoliRed" name="<%=SessionAttributes.LIST_SOTTO_FASCICOLI_RED%>"/>
<demdec:useAttribute id="pagFascicoliPat"     name="<%=SessionAttributes.SOTTO_FASCICOLI_PAT_PAGINATOR%>"/> 
<demdec:useAttribute id="listFascicoliPat" name="<%=SessionAttributes.LIST_SOTTO_FASCICOLI_PAT%>"/>
<demdec:useAttribute id="fascicoloFad" name="<%=SessionAttributes.FASCICOLO_SELEZIONATO%>"/>
<demdec:useAttribute id="listFascicoliFad" name="<%=SessionAttributes.LIST_SOTTO_FASCICOLI_FAD%>"/>
<demdec:useAttribute id="pagFascicoliFad" name="<%=SessionAttributes.SOTTO_FASCICOLI_FAD_PAGINATOR%>"/>
<!-- per i campi modificabili -->
<demdec:useAttribute id="chkModifica"	name="<%=WebConstants.CHK_MODIFICA_FAD%>" />
<demdec:useAttribute id="tipologiaDecretoLis" name="<%=SessionAttributes.LIST_TIPOLOGIA_DECRETO%>"/> 
<demdec:useAttribute id="amministrazioneList" name="<%=SessionAttributes.LIST_AMMIN_DEM%>"/>  
<demdec:useAttribute id="currentAmmList" name="<%=SessionAttributes.CURRENT_LIST_AMMIN_DEM%>"/>  
<demdec:useAttribute id="ufficioCapofilaListList" name="<%=SessionAttributes.LIST_ANAG_UFF%>"/>
<demdec:useAttribute id="cdrList" name="<%=SessionAttributes.LIST_ANAG_CDR_DEM%>"/>  
<demdec:useAttribute id="amministrazioniSelectedList"	name="<%=WebConstants.LIST_SELECTED_AMMS%>" />
<demdec:useAttribute id="indexesSelected"	name="<%=WebConstants.ROW_INDEX_SELECTED_AMMS%>" />
<demdec:useAttribute id="idFadAperto"	name="<%=WebConstants.ID_FAD_APERTO%>" />
<demdec:useAttribute id="tipoDocRedList"         name="<%=WebConstants.LIST_TIPO_DOC_RED%>" /> 
<!--  per riaprire i nodi giusti  -->
<demdec:useAttribute id="openDettFad" name="<%=SessionAttributes.OPEN_DETT_FAD%>"/> 
<demdec:useAttribute id="openDettRed" name="<%=SessionAttributes.OPEN_DETT_RED%>"/> 
<demdec:useAttribute id="openDettPatr" name="<%=SessionAttributes.OPEN_DETT_PATR%>"/> 



<script type="application/javascript">

var jsonData;

$(document).ready(function() {

    $("#btnApriDoc").click(function() {
        $('body').css("cursor", "wait");
    });
   
});

</script>

<%--<tiles:insertAttribute name="modalFascFad" flush="false"/>--%>
<tiles:insertAttribute name="modalFascRed" flush="false"/>
<tiles:insertAttribute name="modalFascPat" flush="false"/> 
<%-- <tiles:insertAttribute name="modalSottoFasc" flush="false"/> con lo use attribute non parte --%> 

 <%@include file="/private/jsp/modal/modaleMetadatiSottoFascicoloAD.jsp" %> 
<!-- PageName = fascicoloFAD.jsp Gestione-->
<!-- Controller  ConsultaFascicoloFadController-->
<form:hidden path="tipoDecreto"/>
<form:hidden path="stato"/>

<div class="overlay"></div>

<div class="spacer_sm">&nbsp;</div>
<%-- 
<div class="row">
	<div class="small-10 columns">
		<demdec:submit 
			keyValue="button.fad.cancellaDocumento"
			controllerCode="eliminaDocumentoFascicoloAttoDecreto" 
			 
			titleKey="button.fad.cancellaDocumento" />	
		<demdec:submit 
			keyValue="button.fad.cancellaAllegato"
			controllerCode="eliminaAllegatoFascicoloAttoDecreto" 
			 
			titleKey="button.fad.cancellaAllegato" />					
	</div>
</div>
	
<div class="spacer_sm">&nbsp;</div>
--%>



<%-- <div class="center padd-bott_5 font_size_riep">
	    <span>&#8226; </span>
	    <span class="col_char_user"><strong>${fascicoloFad.estremiStr}</strong></span> 
</div> --%>
	   
  <div class="center padd-bott_5 font_size_riep">
    <span>&#8226; Tipo: </span>
    <span class="col_char_user"><strong>${fascicoloFad.anagTipologiaDecreto.anagTipoDecreto.descSigla}</strong></span> 
  
    <span>&#8226; Numero:</span>
    <span class="col_char_user"><strong>${fascicoloFad.numeNumDecreto}</strong></span> 
   
    <span>&#8226; Anno:</span>
    <span class="col_char_user"><strong>${fascicoloFad.eserciziDem.id}</strong></span>    
  </div>
	   
<div class="spacer_sm">&nbsp;</div>

<c:if test="${!empty chkModifica}">

        <form:hidden path="annoDecreto"/>
        <form:hidden path="descDecreto"/>
		<form:hidden path="tipologiaDecreto"/>
		<form:hidden path="ufficio"/>
		
	<div class="titoloST" onclick="initAll('det0','imgDet0');" style="cursor: pointer;" >
		<img id="imgDet0" class="left" src="<c:url value="/public/img/meno.png"/>" alt="Nascondi Dettaglio" title="Nascondi Dettaglio">
	</div>
	&nbsp;<strong class="color_blu font_09"><spring:message code="label.modify.metadati"/></strong>
	<div class="dettaglioST" style="display:block;" id="det0">
        
		<div class="row">
			<div class="large-12 columns">
				<fieldset>
					<div class="row">
						<div class="small-3 columns">
							<label ><spring:message code="label.metadatiModificabili"/></label>
						</div>
					</div>
					<div class="spacer_sm">&nbsp;</div>
					<div class="row">   
		                <div class="small-10 columns">
							<label for="descrDecretoMod" ><spring:message code="label.raccolteProvvisorie.nome"/></label>
							<form:input path="descrDecretoMod" maxlength="80" />
						</div>
					</div>
					<div class="row">
					    <div class="left">
							    <c:if test="${fascicoloFad.flagNormativo01 ne '1'}">
							          <demdec:submit keyValue="button.load" controllerCode="caricaTipologiaDecretoFadPage" titleKey="label.carica.tipologia" styleClass="subm_update posit-butt_up"  />
							    </c:if>
									  
		            	</div>
						<div class="small-5 columns">
							<label for="tipologiaDecretoMod" ><spring:message code="label.tipologiaDecreto"/></label>
							 <c:choose>
									    <c:when test="${fascicoloFad.flagNormativo01 eq '1'}">
										         <form:select path="tipologiaDecretoMod" disabled="true">
													<c:forEach var="item" items="${tipologiaDecretoLis}" >
														<form:option value="${item.id}" >${item.descTipologia}</form:option>
													</c:forEach>
												</form:select>
									    </c:when>
									    <c:otherwise>
									    		<form:select path="tipologiaDecretoMod">
													<c:forEach var="item" items="${tipologiaDecretoLis}" >
														<form:option value="${item.id}" >${item.descTipologia}</form:option>
													</c:forEach>
												</form:select>
									    </c:otherwise>
									</c:choose>   
						</div>
					</div>
					<div class="row">
						<div class="small-10 columns">
							<label for="ammRows" ><spring:message code="label.amministrazione.obb"/></label>
							<c:choose>
									
									<c:when test="${ empty amministrazioniSelectedList}">
										<demdec:submit keyValue="label.sel.amm"
												controllerCode="caricaAmministrazioniMod"
												styleClass="buttonPag border-radius"  titleKey="label.sel.amm"/>
									</c:when>
								
									<c:otherwise>
			
											<demdec:displaytag-table
												name="pageScope.amministrazioniSelectedList" id="listAmmin" class="lux  width100" 	>
												<display:caption>
													<span class="nascosto">Lista Amministrazioni Selezionate</span>
												</display:caption>
													
													<demdec:displaytag-column  titleKey="label.stp" class="center">
														<c:choose>
															<c:when test="${listAmmin.id.numeStpFormatted == 0}"> 
													    				0${listAmmin.id.numeStpFormatted}
														    </c:when>									    
														    <c:otherwise>
														    			${listAmmin.id.numeStpFormatted}
														    </c:otherwise>
														</c:choose> 
													</demdec:displaytag-column >
													
		
												<demdec:displaytag-column titleKey="label.app"
													property="id.numeApp"  />
		
												<demdec:displaytag-column titleKey="label.descrizione"
													property="descAmm"  />
		
		
												<%-- <demdec:displaytag-column class="w20px textAlignCenter"
													labelTitleKey="label.blank">
		
													<input title="Selezione Amministrazione" type="checkbox"
														name="ammRowsToDelete" value="${listAmmin_rowNum}" />
		
												</demdec:displaytag-column> --%>
							
											</demdec:displaytag-table>
											
											
		
											<%-- <demdec:submit keyValue="button.unselect"
												controllerCode="uncheckAmmin" titleKey="label.uncheck.amm" /> --%>
												<demdec:submit keyValue="label.mod.amm"
												controllerCode="caricaAmministrazioniMod"
												styleClass="buttonPag border-radius"  titleKey="label.mod.amm"/>
										</c:otherwise>
										</c:choose>
						
						</div>
		
					</div>
		
					
					<div class="row">
					    <div class="left">
		            		<demdec:submit keyValue="button.load" controllerCode="caricaUfficio" titleKey="label.carica.ufficio" styleClass="subm_update posit-butt_up"  />
		            	</div>
						<div class="small-4 columns">
						    <label for="ufficioMod"><spring:message code="label.ufficioCapofila"/></label>
			    			<form:select path="ufficioMod" >
			    				<%-- <form:option value="" label="-- Selezionare un ufficio --"/> --%>
			    				<c:forEach var="item" items="${ufficioCapofilaListList}">
			    					<form:option value="${item.id}" >${item.descUfficio}</form:option>
			    				</c:forEach>
			    			</form:select>
					    </div>
		            </div>
					<form:hidden path="numePatMod" />
            		<%-- Commentato 20/10/2015 
					<div class="row">   
		                <div class="small-3 columns">
							<demdec:label path="numePatMod" labelKey="label.numeroPatrimonio"/>
							<form:input path="numePatMod" maxlength="5" />
						</div>
					</div>
					--%>
					
					<div class="row">
						<div class="small-2 columns">
							<label for="flagNormativo"><spring:message code="label.decreto.normativo"/></label>
						</div> 
						<div class="left"> 
						
					<c:choose>
					    <c:when test="${fascicoloFad.flagNormativo01 eq '1'}">
					            <form:checkbox   path="flagNormativo"	id="flagNormativo" value="1" disabled="true" />
					    </c:when>
					    <c:otherwise>
					        	<form:checkbox   path="flagNormativo"	id="flagNormativo" value="1"  /> 
					    </c:otherwise>
					</c:choose>   
						
						</div> 
					</div>
					
					<div class="spacer_sm">&nbsp;</div>
					<div class="row">
						<div class="small-10 columns">
							<demdec:submit keyValue="button.salva" controllerCode="salvaMetadati" />
							&nbsp;
							<demdec:submit keyValue="button.clean" controllerCode="pulisciMetadati?idFad=${idFadAperto}" />
							&nbsp;
							<demdec:submit keyValue="button.back" controllerCode="backToFadInitialPage?idFad=${idFadAperto}" />
						</div>
					</div>
					<%-- 
					<div class="row">	
					    <div class="left">
						  	<demdec:submit titleKey="label.carica.cdr" keyValue="button.load" controllerCode="caricaCdr" styleClass="subm_update posit-butt_up"/>
						 </div>
						 <div class="small-10 columns">
						   	<demdec:label path="cdr" labelKey="label.cdr" />
			    			<form:select path="cdr" >
			    				<form:option value="" label="-- Selezionare un CDR --"/>
			    				<c:forEach var="item" items="${cdrList}">
			    					<form:option value="${item.id.numeCdr}" >${item.descCdr}</form:option>
			    				</c:forEach>
			   				</form:select>
					    </div>
					</div> --%>
				</fieldset>
			</div>
		</div>
	</div>
</c:if>
	
<c:if test="${empty chkModifica}">

	<form:hidden path="descrDecretoMod"/>
	<form:hidden path="tipologiaDecretoMod"/>
	<form:hidden path="ufficioMod"/>
	<form:hidden path="numePatMod"/>
	<div class="titoloST" onclick="initAll('det0','imgDet0');" style="cursor: pointer;">
		<img id="imgDet0" class="left" src="<c:url value="/public/img/piu.png"/>" alt="Visualizza Dettaglio" title="Visualizza Dettaglio"> 
	</div>
	&nbsp;<strong class="color_blu  font_09"><spring:message code="label.show.metadati"/></strong>
	<div class="dettaglioST" style="display:none;" id="det0">
        
        <fieldset>
	        <div class="row"> 
				<div class="small-4 columns">
					<label ><spring:message code="label.metadatiFascicolo"/></label>
				</div>      	
	      	</div>
        	<div class="spacer_sm">&nbsp;</div>
        
			<div class="container_field">				
	        	
	        	<div class="row">
	        		<div class="small-4 columns">
	        			<label for="decTipoDecreto"><spring:message code="label.tipoDecreto"/></label>
						<form:input path="decTipoDecreto" maxlength="5" readonly="true" />
	        		</div>
	        		<div class="small-4 columns">
	        			<label for="numeDecreto"><spring:message code="label.numeroDecreto"/></label>
						<form:input path="numeDecreto" maxlength="5" readonly="true"/>
					</div>
					<div class="small-4 columns">
						<label for="annoDecreto"><spring:message code="label.anno.dec"/></label>
			       		<form:input path="annoDecreto" maxlength="4" readonly="true"/>
			       	</div> 
	        	</div>
	        </div>
	        
	        <div class="row">
	        	<div class="small-10 columns">
					<label for="descDecreto"><spring:message code="label.raccolteProvvisorie.nome"/></label>
		       		<form:input path="descDecreto" maxlength="180" readonly="true"/> 
				</div>
	        </div>
	        
	        <div class="row">
	        	<div class="small-10 columns">
	        		<label for="amministrazione"><spring:message code="label.raccolteProvvisorie.amministrazione"/></label>
					<form:input path="amministrazione" maxlength="50" readonly="true"/>
	        	</div>
	        </div>
	        
	        <div class="row">
	        	<div class="small-4 columns">
					<label for="tipologiaDecreto"><spring:message code="label.tipologiaDecreto"/></label>
					<input type="text" maxlength="50" value="${tipologiaDecretoLis[0].descTipologia}" readonly="readonly"/>
				</div>
	        </div>
	        
	         <div class="row">
	        	<div class="small-4 columns">
	        		<label for="numePat"><spring:message code="label.numeroPatrimonio"/></label>
					<form:input path="numePat" maxlength="3" readonly="true"/>
				</div>
			</div>
			
			<div class="row">
				<div class="small-4 columns">
					<label for="ufficio"><spring:message code="label.ufficioCapofila"/></label>
				    <input type="text" maxlength="50" value="${ufficioCapofilaListList[0].descUfficio}" readonly="readonly"/>
				</div>
				<div class="small-4 columns">
					<label for="descStato"><spring:message code="label.stato"/></label>
					<form:input path="descStato" maxlength="50" readonly="true"/>
				</div>
				<div class="small-4 columns">
				</div>
			</div>
			
			<div class="row">
	        	<div class="small-4 columns">
	        		<label for="ufficioCreatore"><spring:message code="label.ufficioCreatore"/></label>
					<form:input path="ufficioCreatore" maxlength="50" readonly="true"/>
				</div>
			</div>
			
			<div class="row">
				<div class="small-4 columns">
					<label for="dataCreazione"><spring:message code="label.raccolteProvvisorie.dataCreazione"/></label>
					<form:input path="dataCreazione" maxlength="50" readonly="true" />
				</div>
				<div class="small-4 columns">
					<label for="creatoDa"><spring:message code="label.creatoDa"/></label>
					<form:input path="creatoDa" maxlength="50" readonly="true"/>
				</div>
				<div class="small-4 columns">
				</div>
			</div>
			
			<div class="row">
				<div class="small-4 columns">
					<label for="dataModifica"><spring:message code="label.raccolteProvvisorie.dataModifica"/></label>
					<form:input path="dataModifica" maxlength="50" readonly="true"/>
				</div>
				<div class="small-4 columns">
					<label for="modificatoDa"><spring:message code="label.raccolteProvvisorie.modificatoDa"/></label>
					<form:input path="modificatoDa" maxlength="50" readonly="true"/>
				</div>
				<div class="small-4 columns">
				</div>
			</div>
			
			<div class="row">
				<div class="small-2 columns">
					<label for="flagNormativo"><spring:message code="label.decreto.normativo"/></label>
				</div> 
				<div class="left"> 
					<form:checkbox   path="flagNormativo"	id="flagNormativo" value="1"   disabled="true" />
				</div> 
			</div>
			
			<div class="spacer_sm">&nbsp;</div>
			<div class="row">
				<div class="small-10 columns">
					<demdec:submit keyValue="button.fad.modificaMetadati"
								   controllerCode="modificaFad" 
								   titleKey="button.fad.modificaMetadati" />
					<demdec:submit keyValue="button.fad.cancella"
								   controllerCode="eliminaFad" 
								   titleKey="button.fad.cancella"
								   onclick="return confermaElimina();" />
				</div>
			</div>
			
        </fieldset>
        
        
		<%-- <div class="row">
			<div class="large-12 columns">
				<fieldset>
					<div class="row">
						<div class="small-3 columns">
							<demdec:label labelKey="label.metadatiFascicolo"/>
						</div>
					</div>
					<div class="spacer_sm">&nbsp;</div>
					<div class="row">
						<div class="small-3 columns">
							<demdec:label path="decTipoDecreto" labelKey="label.tipoDecreto"/>
							<form:input path="decTipoDecreto" maxlength="5" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="small-3 columns">
							<demdec:label path="numeDecreto" labelKey="label.numeroDecreto"/>
							<form:input path="numeDecreto" maxlength="5" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="small-3 columns">
							<demdec:label path="annoDecreto" labelKey="label.anno.dec"/>
				       		<form:input path="annoDecreto" maxlength="4" readonly="true"/> 
						</div>
					</div>
					<div class="row">
						<div class="small-10 columns">
							<demdec:label path="descDecreto" labelKey="label.raccolteProvvisorie.nome"/>
				       		<form:input path="descDecreto" maxlength="180" readonly="true"/> 
						</div>
					</div>
					<div class="row">
						<div class="small-3 columns">
							<demdec:label path="numePat" labelKey="label.numeroPatrimonio"/>
							<form:input path="numePat" maxlength="3" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="small-3 columns">
							<demdec:label path="descStato" labelKey="label.stato"/>
							<form:input path="descStato" maxlength="50" readonly="true"/>
						</div> 
					</div>
					<div class="row">
						<div class="small-10 columns">
							<demdec:label path="amministrazione" labelKey="label.raccolteProvvisorie.amministrazione" />
							<form:input path="amministrazione" maxlength="50" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="small-5 columns">
							<demdec:label path="tipologiaDecreto" labelKey="label.tipologiaDecreto" />
							<input type="text" maxlength="50" value="${tipologiaDecretoLis[0].descTipologia}" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="small-4 columns">
						    <demdec:label path="ufficio" labelKey="label.ufficioCapofila"/>
						    <input type="text" maxlength="50" value="${ufficioCapofilaListList[0].descUfficio}" readonly="true"/>
			    		</div>
					</div>
					<div class="row">
						<div class="small-4 columns">
							< path="ufficioCreatore" labelKey="label.ufficioCreatore" />
							<form:input path="ufficioCreatore" maxlength="50" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="small-3 columns">
							<demdec:label path="dataCreazione" labelKey="label.raccolteProvvisorie.dataCreazione" />
							<form:input path="dataCreazione" maxlength="50" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="small-5 columns">
							<demdec:label path="creatoDa" labelKey="label.creatoDa" />
							<form:input path="creatoDa" maxlength="50" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="small-3 columns">
							<demdec:label path="dataModifica" labelKey="label.raccolteProvvisorie.dataModifica" />
							<form:input path="dataModifica" maxlength="50" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="small-5 columns">
							<demdec:label path="modificatoDa" labelKey="label.raccolteProvvisorie.modificatoDa" />
							<form:input path="modificatoDa" maxlength="50" readonly="true"/>
						</div>
					</div>
				</fieldset>
			</div>
		</div>
	
		<div class="spacer_sm">&nbsp;</div>
		<div class="row">
			<div class="small-10 columns">
				<demdec:submit 
					keyValue="button.fad.modificaMetadati"
					controllerCode="modificaFad" 
					titleKey="button.fad.modificaMetadati" />
				<demdec:submit 
					keyValue="button.fad.cancella"
					controllerCode="eliminaFad" 
					titleKey="button.fad.cancella"
					onclick="return confermaElimina();" />
			</div>
		</div>
	 --%>
	</div>
    
</c:if>



<div class="spacer_sm">&nbsp;</div>


<div class="titoloST" onclick="initAll_2('det1','imgDet1');" style="cursor: pointer;">
	<c:if test="${empty openDettFad}">
		<img id="imgDet1"  class="left" src="<c:url value="/public/img/piu_3.png"/>" alt="Visualizza Dettaglio" title="Visualizza Dettaglio"/>
	</c:if>
	<c:if test="${not empty openDettFad}">
		<img id="imgDet1"  class="left" src="<c:url value="/public/img/meno_3.png"/>" alt="Nascondi Dettaglio" title="Nascondi Dettaglio"/>
	</c:if>
</div>
&nbsp;<strong class="color_blu  font_09"><spring:message code="label.sottofascicoli.fad"/></strong>

<c:if test="${empty openDettFad}">
	<div class="dettaglioST" style="display:none" id="det1">
	 
		 <c:if test="${not empty listFascicoliFad}">
		
			<demdec:displaytag-table class="lux tableDati width100" name="pageScope.listFascicoliFad" id="listFascicoliFad" >
				<display:caption>
					<span class="nascosto"><spring:message code="label.caption.table.fad"/></span>
				</display:caption>
				<demdec:displaytag-column title="<span class='nascosto'>Visualizza cartella</span>">
					<demdec:submit styleClass="subm_folder" keyValue="label.empty" titleKey="alt.apri.fascicoloFad" controllerCode="apriDocumentiFad?idFad=${listFascicoliFad.id}" styleId="btnApriDoc"/>
				</demdec:displaytag-column>
				
				<demdec:displaytag-column titleKey="label.raccolteProvvisorie.estremiStr" property="estremiStr">
					<%-- <demdec:submit styleClass="nascosto" styleId="apri${listFascicoliFad.id}" keyValue="label.empty" controllerCode="apriDocumentiFad?idFad=${listFascicoliFad.id}"/>
					<a href="javascript:this.document.getElementById('apri${listFascicoliFad.id}').click();">
						${listFascicoliFad.estremiStr} </a> --%>
				</demdec:displaytag-column>
				
				<demdec:displaytag-column property="descDecreto" titleKey="label.raccolteProvvisorie.nome" />
				
				<demdec:displaytag-column sortName="amministrazione"
					property="amministrazione"
					titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
				<demdec:displaytag-column property="dataCreazioneFascicoloFormatted"
					titleKey="label.raccolteProvvisorie.dataModifica"  class="center" />
				<demdec:displaytag-column property="ufficioCapofila.descUfficio"
					titleKey="label.raccolteProvvisorie.origineCreazione" />
				<demdec:displaytag-column titleKey="label.raccolteProvvisorie.visualizzaMetadati"   class="center"  >
					<a href="javascript:caricaModaleDettSottoFascFad('contModal_01', '${listFascicoliFad_rowNum}');">
						<img  src="<c:url value="/public/img/ico_view_det.png"/>" title="Visualizza metadati Decreto ${listFascicoliFad.estremiStr}" alt="Visualizza metadati Decreto ${listFascicoliFad.estremiStr}">
					</a>
				</demdec:displaytag-column>
			</demdec:displaytag-table>
	    </c:if>
	    
		<c:if test="${empty listFascicoliFad}">
			<div class="warning_field">
				&nbsp;&nbsp;&nbsp;Nessun Fascicolo Atto Decreto 
		 	</div>
		</c:if>
		
	</div>
</c:if>
<c:if test="${not empty openDettFad}">
	<div class="dettaglioST" style="display:block" id="det1">
	 
		 <c:if test="${not empty listFascicoliFad}">
		
			<demdec:displaytag-table class="lux tableDati width100" name="pageScope.listFascicoliFad" id="listFascicoliFad" >
				<display:caption>
					<span class="nascosto"><spring:message code="label.caption.table.fad"/></span>
				</display:caption>
				<demdec:displaytag-column title="<span class='nascosto'>Visualizza cartella</span>">
					<demdec:submit styleClass="subm_folder" keyValue="label.empty" titleKey="alt.apri.fascicoloFad" controllerCode="apriDocumentiFad?idFad=${listFascicoliFad.id}"/>
				</demdec:displaytag-column>
				
				<demdec:displaytag-column titleKey="label.raccolteProvvisorie.estremiStr"  property="estremiStr"/>
					<%-- <demdec:submit styleClass="nascosto" styleId="apri${listFascicoliFad.id}" keyValue="label.empty" controllerCode="apriDocumentiFad?idFad=${listFascicoliFad.id}"/>
					<a href="javascript:this.document.getElementById('apri${listFascicoliFad.id}').click();">
						${listFascicoliFad.estremiStr} </a>
				</demdec:displaytag-column> --%>
				
				<demdec:displaytag-column property="descDecreto" titleKey="label.raccolteProvvisorie.nome" />			
				
				<demdec:displaytag-column sortName="amministrazione"
					property="amministrazione"
					titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
				<demdec:displaytag-column property="dataCreazioneFascicoloFormatted"
					titleKey="label.raccolteProvvisorie.dataModifica"  class="center" />
				<demdec:displaytag-column property="ufficioCapofila.descUfficio"
					titleKey="label.raccolteProvvisorie.origineCreazione" />
				<demdec:displaytag-column titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center">
					<a href="javascript:caricaModaleDettSottoFascFad('contModal_01', '${listFascicoliFad_rowNum}');">
						<img  src="<c:url value="/public/img/ico_view_det.png"/>" title="Visualizza metadati Decreto ${listFascicoliFad.estremiStr}" alt="Visualizza metadati Decreto ${listFascicoliFad.estremiStr}">
					</a>
				</demdec:displaytag-column>
			</demdec:displaytag-table>
	    </c:if>
	    
		<c:if test="${empty listFascicoliFad}">
			<div class="warning_field">
				&nbsp;&nbsp;&nbsp;Nessun Fascicolo Atto Decreto 
		 	</div>
		</c:if>
		
	</div>
</c:if>

<div class="spacer_sm">&nbsp;</div>


<div class="titoloST" onclick="initAll_2('det2','imgDet2');" style="cursor: pointer;">
	<c:if test="${empty openDettRed}">
		<img id="imgDet2"  class="left" src="<c:url value="/public/img/piu_3.png"/>" alt="Visualizza Dettaglio" title="Visualizza Dettaglio"/>
	</c:if>
	<c:if test="${not empty openDettRed}">
		<img id="imgDet2"  class="left" src="<c:url value="/public/img/meno_3.png"/>" alt="Nascondi Dettaglio" title="Nascondi Dettaglio"/>
	</c:if>
</div>


<c:choose>
	<c:when test="${not empty listFascicoliRed}">
		&nbsp;<strong class="color_blu  font_09"><spring:message code="label.sottofascicoli.red"/></strong>
	</c:when>
	<c:otherwise>
		&nbsp;<strong class="color_grey_2 font_09"><spring:message code="label.sottofascicoli.red"/></strong>
	</c:otherwise>
</c:choose>

<c:if test="${empty openDettRed}">
	<div class="dettaglioST" style="display:none" id="det2">
	 
		 <c:if test="${not empty listFascicoliRed}">
		
		   <demdec:displaytag-table   name="pageScope.listFascicoliRed" id="listFascicoliRed"  class="lux tableDati width100" >
		  		
		  		<display:caption><span class="nascosto">Tabella fascicoli raccolte provvisorie</span></display:caption>
		   		<demdec:displaytag-column title="<span class='nascosto'>Visualizza cartella</span>" >
							
						<demdec:submit styleClass="subm_folder" keyValue="label.empty" titleKey="alt.apri.sottoFascicoloRed" controllerCode="apriDocumentiFascicoloRed?rowNum=${listFascicoliRed_rowNum -1}"/>
		
					</demdec:displaytag-column>
					
					<demdec:displaytag-column titleKey="label.idRed">
						${listFascicoliRed.id.codiIdRed} 
					</demdec:displaytag-column>
					
					<demdec:displaytag-column titleKey="label.protocolloRed">
						<%-- <demdec:submit styleClass="nascosto" styleId="apri${listFascicoliRed.id.codiIdRed}" keyValue="label.empty" controllerCode="apriDocumentiFascicoloRed?rowNum=${listFascicoliRed_rowNum -1}"/>
						<a href="javascript:this.document.getElementById('apri${listFascicoliRed.id.codiIdRed}').click();"> --%>
								${listFascicoliRed.numeProtocollo}/<fmt:formatDate pattern="yyyy"  value="${listFascicoliRed.dataProtocollo}" />
						<!-- </a> -->
					</demdec:displaytag-column>
					<demdec:displaytag-column  property="descOggettoRed" titleKey="label.raccolteProvvisorie.oggettoRed" />
					<%-- 
					<demdec:displaytag-column   titleKey="label.raccolteProvvisorie.nome" >
						<demdec:submit styleClass="nascosto" styleId="apri${listFascicoliRed.id.codiIdRed}" keyValue="label.empty" controllerCode="apriDocumentiFascicoloRed?rowNum=${listFascicoliRed_rowNum -1}"/>
						<a href="javascript:this.document.getElementById('apri${listFascicoliRed.id.codiIdRed}').click();">
								${listFascicoliRed.descOggettoRed}
							</a>
					</demdec:displaytag-column>
					--%>			
					<%-- <demdec:displaytag-column sortName="amministrazione.descAmm"  property="anagAmminDem.descAmm" titleKey="label.raccolteProvvisorie.amministrazione" /> --%>
					<demdec:displaytag-column titleKey="label.raccolteProvvisorie.amministrazione" class="center">
					0${listFascicoliRed.anagAmminDem.id.numeStp}${listFascicoliRed.anagAmminDem.id.numeApp}
					</demdec:displaytag-column>
					
					<%-- <demdec:displaytag-column property="statStato" titleKey="label.raccolteProvvisorie.statoLavorazione" /> --%>
					<%-- <demdec:displaytag-column property="descStato" titleKey="label.raccolteProvvisorie.statoLavorazione" /> --%>
					<demdec:displaytag-column property="dataArrivoFormatted" titleKey="label.raccolteProvvisorie.dataCreazione"  class="center" />
					<demdec:displaytag-column property="descUfficioAss" titleKey="label.raccolteProvvisorie.origineCreazione"  />
					<demdec:displaytag-column property="dataAggiornamentoFormatted" titleKey="label.raccolteProvvisorie.dataModifica"  class="center" />
	<%-- 				<demdec:displaytag-column property="sistemaProduttore" titleKey="label.raccolteProvvisorie.modificatoDa"  /> --%>
					<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati"  class="center">
							<a href="javascript: caricaModaleDettFascRed('contModal_7', '${listFascicoliRed_rowNum -1}'); " >
								<img  src="<c:url value="/public/img/ico_view_det.png"/>" title="Visualizza metadati Id Red ${listFascicoliRed.id.codiIdRed}" alt="Visualizza metadati Id Red ${listFascicoliRed.id.codiIdRed}">
							</a>
					</demdec:displaytag-column>
			</demdec:displaytag-table>
			<c:if test="${pagFascicoliRed ne null}">
				<div>&nbsp;</div>
			     <div class="center color_grey">
			         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
			                         paginatorName="pagFascicoliRed"
			                         paginatorSessionName="<%=SessionAttributes.SOTTO_FASCICOLI_RED_PAGINATOR%>"
			                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
			     </div>                       
		 	</c:if>  
		</c:if>
	
		<c:if test="${empty listFascicoliRed}">
	  <div class="warning_field">
			&nbsp;&nbsp;&nbsp;Nessun fascicolo IGB/RED &egrave; stato associato al fascicolo Atto Decreto 
	 </div>
		</c:if>
			
	</div>
</c:if>
<c:if test="${not empty openDettRed}">
	<div class="dettaglioST" style="display:block" id="det2">
	 
		 <c:if test="${not empty listFascicoliRed}">
		
		   <demdec:displaytag-table   name="pageScope.listFascicoliRed" id="listFascicoliRed"  class="lux tableDati width100" >
		  		
		  		<display:caption><span class="nascosto">Tabella fascicoli raccolte provvisorie</span></display:caption>
		   		<demdec:displaytag-column title="<span class='nascosto'>Visualizza cartella</span>" >
							
						<demdec:submit styleClass="subm_folder" keyValue="label.empty" titleKey="alt.apri.sottoFascicoloRed" controllerCode="apriDocumentiFascicoloRed?rowNum=${listFascicoliRed_rowNum -1}"/>
		
					</demdec:displaytag-column>
					
					<demdec:displaytag-column titleKey="label.idRed">
						${listFascicoliRed.id.codiIdRed} 
					</demdec:displaytag-column>
				
					<demdec:displaytag-column titleKey="label.protocolloRed">
					<%-- 	<demdec:submit styleClass="nascosto" styleId="apri${listFascicoliRed.id.codiIdRed}" keyValue="label.empty" controllerCode="apriDocumentiFascicoloRed?rowNum=${listFascicoliRed_rowNum -1}"/> --%>
						<%-- <a href="javascript:this.document.getElementById('apri${listFascicoliRed.id.codiIdRed}').click();"> --%>
								${listFascicoliRed.numeProtocollo}/<fmt:formatDate pattern="yyyy"  value="${listFascicoliRed.dataProtocollo}" />
						<!-- </a> -->
					</demdec:displaytag-column>
					<demdec:displaytag-column  property="descOggettoRed" titleKey="label.raccolteProvvisorie.oggettoRed" />
					<%-- 
					<demdec:displaytag-column   titleKey="label.raccolteProvvisorie.nome" >
						<demdec:submit styleClass="nascosto" styleId="apri${listFascicoliRed.id.codiIdRed}" keyValue="label.empty" controllerCode="apriDocumentiFascicoloRed?rowNum=${listFascicoliRed_rowNum -1}"/>
						<a href="javascript:this.document.getElementById('apri${listFascicoliRed.id.codiIdRed}').click();">
								${listFascicoliRed.descOggettoRed}
							</a>
					</demdec:displaytag-column>
					--%>			
					<%-- <demdec:displaytag-column sortName="amministrazione.descAmm"  property="anagAmminDem.descAmm" titleKey="label.raccolteProvvisorie.amministrazione" /> --%>
					<demdec:displaytag-column titleKey="label.raccolteProvvisorie.amministrazione" class="center">
					0${listFascicoliRed.anagAmminDem.id.numeStp}${listFascicoliRed.anagAmminDem.id.numeApp}
					</demdec:displaytag-column>
					
					<%-- <demdec:displaytag-column property="statStato" titleKey="label.raccolteProvvisorie.statoLavorazione" /> --%>
				<%-- 	<demdec:displaytag-column property="descStato" titleKey="label.raccolteProvvisorie.statoLavorazione" /> --%>
					<demdec:displaytag-column property="dataArrivoFormatted" titleKey="label.raccolteProvvisorie.dataCreazione"  class="center" />
					<demdec:displaytag-column property="descUfficioAss" titleKey="label.raccolteProvvisorie.origineCreazione"  />
					<demdec:displaytag-column property="dataAggiornamentoFormatted" titleKey="label.raccolteProvvisorie.dataModifica"  class="center" />
	<%-- 				<demdec:displaytag-column property="sistemaProduttore" titleKey="label.raccolteProvvisorie.modificatoDa"  /> --%>
					<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center" >
							<a href="javascript: caricaModaleDettFascRed('contModal_7', '${listFascicoliRed_rowNum -1}'); " >
								<img  src="<c:url value="/public/img/ico_view_det.png"/>" title="Visualizza metadati Id Red ${listFascicoliRed.id.codiIdRed}" alt="Visualizza metadati Id Red ${listFascicoliRed.id.codiIdRed}">
							</a>
					</demdec:displaytag-column>
			</demdec:displaytag-table>
			<c:if test="${pagFascicoliRed ne null}">
				<div>&nbsp;</div>
			     <div class="center color_grey">
			         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
			                         paginatorName="pagFascicoliRed"
			                         paginatorSessionName="<%=SessionAttributes.SOTTO_FASCICOLI_RED_PAGINATOR%>"
			                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
			     </div>                       
		 	</c:if>  
		</c:if>
	
		<c:if test="${empty listFascicoliRed}">
	  <div class="warning_field">
			&nbsp;&nbsp;&nbsp;Nessun fascicolo IGB/RED &egrave; stato associato al fascicolo Atto Decreto 
	 </div>
		</c:if>
			
	</div>
</c:if>
<div class="spacer_sm">&nbsp;</div>


<div class="titoloST" onclick="initAll_2('det3','imgDet3');" style="cursor: pointer;">
	<c:if test="${empty openDettPatr}">
		<img id="imgDet3" class="left" src="<c:url value="/public/img/piu_3.png"/>" alt="Visualizza Dettaglio" title="Visualizza Dettaglio">
	</c:if>
	<c:if test="${not empty openDettPatr}">
		<img id="imgDet3"  class="left" src="<c:url value="/public/img/meno_3.png"/>" alt="Nascondi Dettaglio" title="Nascondi Dettaglio"/>
	</c:if>
</div>

<c:choose>
	<c:when test="${not empty listFascicoliPat}">
		&nbsp;<strong class="color_blu font_09">Sottofascicoli Patrimonio</strong>
	</c:when>
	<c:otherwise>
		&nbsp;<strong class="color_grey_2 font_09">Sottofascicoli Patrimonio</strong>
	</c:otherwise>
</c:choose>

<c:if test="${empty openDettPatr}">
	<div class="dettaglioST" style="display:none" id="det3">
	 
		  
	 
		 <c:if test="${not empty listFascicoliPat}">
		  <div>
		
		   <demdec:displaytag-table   name="pageScope.listFascicoliPat" id="listFascicoliPat"  class="lux tableDati width100" >
		  		
		  		<display:caption><span class="nascosto">Tabella fascicoli raccolte provvisorie</span></display:caption>
		   		<demdec:displaytag-column title="<span class='nascosto'>Visualizza cartella</span>" >
							
						<demdec:submit styleClass="subm_folder" keyValue="label.empty" titleKey="alt.apri.sottoFascicoloPat" controllerCode="apriDocumentiFascicoloPat?rowNum=${listFascicoliPat_rowNum - 1}"/>
		
					</demdec:displaytag-column>
					<demdec:displaytag-column   property="identificativoSIPATR" titleKey="label.codiceFascicolo" class="center" />	
					<demdec:displaytag-column   titleKey="label.raccolteProvvisorie.nome" property="descrizione"/>
						<%-- <demdec:submit styleClass="nascosto" styleId="apri${listFascicoliPat.idFascicoloSipatr}" keyValue="label.empty" controllerCode="apriDocumentiFascicoloPat?rowNum=${listFascicoliPat_rowNum - 1}"/>
						<a href="javascript:this.document.getElementById('apri${listFascicoliPat.idFascicoloSipatr}').click();">
								${listFascicoliPat.descrizione}
							</a>
					</demdec:displaytag-column> --%>
					<demdec:displaytag-column   titleKey="label.patrimonio.numero" class="center" >	
						${fascicoloFad.numePatrimonio}
					</demdec:displaytag-column>
					<demdec:displaytag-column sortName="amministrazione.description"  property="amministrazione.code" titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
					<%-- <demdec:displaytag-column property="statoFascicoloDocumentale" titleKey="label.raccolteProvvisorie.statoLavorazione" /> --%>
					<demdec:displaytag-column sortName="ragioneria.description"  property="ragioneria.code" titleKey="label.ragioneria" class="center" />
					<demdec:displaytag-column property="titolo" titleKey="label.titolo"/>
					<demdec:displaytag-column property="dataCreazione" titleKey="label.raccolteProvvisorie.dataCreazione"  class="center" />
	<%-- 				<demdec:displaytag-column property="ufficioCreatoreRED.description" titleKey="label.raccolteProvvisorie.origineCreazione"  /> --%>
					<%-- <demdec:displaytag-column property="dataAggiornamento" titleKey="label.raccolteProvvisorie.dataModifica" />
					<demdec:displaytag-column property="sistemaProduttore" titleKey="label.raccolteProvvisorie.modificatoDa"  /> --%>
					<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center">
						<a href="javascript: caricaModaleDettFascPat('contModal_8', '${listFascicoliPat_rowNum-1}'); " >
							<img  src="<c:url value="/public/img/ico_view_det.png"/>" title="Visualizza metadati ${listFascicoliPat.descrizione}" alt="Visualizza metadati ${listFascicoliPat.descrizione}">
						</a>
					</demdec:displaytag-column>
			</demdec:displaytag-table>
			<c:if test="${pagFascicoliPat ne null}">
				<div>&nbsp;</div>
			     <div class="center color_grey">
			         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
			                         paginatorName="pagFascicoliPat"
			                         paginatorSessionName="<%=SessionAttributes.SOTTO_FASCICOLI_PAT_PAGINATOR%>"
			                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
			     </div>                       
		 	</c:if>  
		 	</div>
		</c:if>
	
		<c:if test="${empty listFascicoliPat}">
		    <div class="warning_field">
				&nbsp;&nbsp;&nbsp;Nessun fascicolo Patrimonio &egrave; stato associato al fascicolo Atto Decreto 
			</div>
		</c:if>
		
	</div>
</c:if>
<c:if test="${not empty openDettPatr}">
	<div class="dettaglioST" style="display:block" id="det3">
	  
		  
	 
		 <c:if test="${not empty listFascicoliPat}">
		  <div>
		
		   <demdec:displaytag-table   name="pageScope.listFascicoliPat" id="listFascicoliPat"  class="lux tableDati width100" >
		  		
		  		<display:caption><span class="nascosto">Tabella fascicoli raccolte provvisorie</span></display:caption>
		   		<demdec:displaytag-column title="<span class='nascosto'>Visualizza cartella</span>" >
							
						<demdec:submit styleClass="subm_folder" keyValue="label.empty" titleKey="alt.apri.sottoFascicoloPat" controllerCode="apriDocumentiFascicoloPat?rowNum=${listFascicoliPat_rowNum - 1}"/>
		
					</demdec:displaytag-column>
					<demdec:displaytag-column   property="identificativoSIPATR" titleKey="label.codiceFascicolo" class="center" />	
					<demdec:displaytag-column   titleKey="label.raccolteProvvisorie.nome"  property="descrizione" />
						<%-- <demdec:submit styleClass="nascosto" styleId="apri${listFascicoliPat.idFascicoloSipatr}" keyValue="label.empty" controllerCode="apriDocumentiFascicoloPat?rowNum=${listFascicoliPat_rowNum - 1}"/>
						<a href="javascript:this.document.getElementById('apri${listFascicoliPat.idFascicoloSipatr}').click();">
								${listFascicoliPat.descrizione}
							</a>
					</demdec:displaytag-column> --%>
					<demdec:displaytag-column   titleKey="label.patrimonio.numero" class="center" >	
						${fascicoloFad.numePatrimonio}
					</demdec:displaytag-column>
					<demdec:displaytag-column sortName="amministrazione.description"  property="amministrazione.code" titleKey="label.raccolteProvvisorie.amministrazione" class="center" />
					<demdec:displaytag-column sortName="ragioneria.description"  property="ragioneria.code" titleKey="label.ragioneria" class="center" />
					<demdec:displaytag-column property="titolo" titleKey="label.titolo"/>
					<%-- <demdec:displaytag-column property="statoFascicoloDocumentale" titleKey="label.raccolteProvvisorie.statoLavorazione" /> --%>
					<demdec:displaytag-column property="dataCreazione" titleKey="label.raccolteProvvisorie.dataCreazione" class="center" />
	<%-- 				<demdec:displaytag-column property="ufficioCreatoreRED.description" titleKey="label.raccolteProvvisorie.origineCreazione"  /> --%>
					<%-- <demdec:displaytag-column property="dataAggiornamento" titleKey="label.raccolteProvvisorie.dataModifica"/>
					<demdec:displaytag-column property="sistemaProduttore" titleKey="label.raccolteProvvisorie.modificatoDa"  /> --%>
					<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center" >
						<a href="javascript: caricaModaleDettFascPat('contModal_8', '${listFascicoliPat_rowNum-1}'); " >
							<img  src="<c:url value="/public/img/ico_view_det.png"/>" title="Visualizza metadati ${listFascicoliPat.descrizione}" alt="Visualizza metadati ${listFascicoliPat.descrizione}">
						</a>
					</demdec:displaytag-column>
			</demdec:displaytag-table>
			<c:if test="${pagFascicoliPat ne null}">
				<div>&nbsp;</div>
			     <div class="center color_grey">
			         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
			                         paginatorName="pagFascicoliPat"
			                         paginatorSessionName="<%=SessionAttributes.SOTTO_FASCICOLI_PAT_PAGINATOR%>"
			                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
			     </div>                       
		 	</c:if> 
		  </div> 
		</c:if>
	 
		<c:if test="${empty listFascicoliPat}">
			<div class="warning_field">
				&nbsp;&nbsp;&nbsp;Nessun fascicolo Patrimonio &egrave; stato associato al fascicolo Atto Decreto 
			</div>
		</c:if>
		
		
	
	</div>
</c:if>
<div class="spacer_sm">&nbsp;</div>
<div class="spacer_sm">&nbsp;</div>


<div class="row center" >
	<demdec:submit keyValue="button.ritornoLista" controllerCode="backToFadSearch"/>
</div>	

 <script> 
	function initAll(idTogle,idImg){
		$('.dettaglioST').each(function(index) {
			if ($(this).attr("id") == idTogle) {
				$(this).toggle();
				if ($(this).is(":hidden")) {
					$('#' + idImg).attr({
						src : "../public/img/piu.png",
						title : "Visualizza dettaglio",
						alt : "Visualizza dettaglio"
					});
				} else {
					$('#' + idImg).attr({
						src : "../public/img/meno.png",
						title : "Nascondi dettaglio",
						alt : "Nascondi dettaglio"
					});
				}
			}
		});

	}
		function initAll_2(idTogle,idImg){
			$('.dettaglioST').each(function(index) {
				if ($(this).attr("id") == idTogle) {
					$(this).toggle();
					if ($(this).is(":hidden")) {
						$('#' + idImg).attr({
							src : "../public/img/piu_3.png",
							title : "Visualizza dettaglio",
							alt : "Visualizza dettaglio"
						});
					} else {
						$('#' + idImg).attr({
							src : "../public/img/meno_3.png",
							title : "Nascondi dettaglio",
							alt : "Nascondi dettaglio"
						});
					}
				}
			});
<%--
 	     $('.titoloST').find('img').attr( {src:"../public/img/piu.png", title:"Visualizza dettaglio", alt:"Visualizza dettaglio" });
 	     $('.dettaglioST').each(function(index) {
	          if ($(this).attr("id") == idTogle) {
	               $(this).toggle();
	               if ($(this).is(":hidden")){
	            	   $('#'+idImg).attr( {src:"../public/img/piu.png", title:"Visualizza dettaglio", alt:"Visualizza dettaglio" });
	               }else {
	            	   $('#'+idImg).attr( {src:"../public/img/meno.png", title:"Visualizza dettaglio", alt:"Visualizza dettaglio" });
	               }
	          }
	          else {
	               $(this).hide();
	          }
	     });
	     --%>
 	}

	function confermaElimina(){
		
		var r = confirm('Confermi la cancellazione del Fascicolo e di tutti i suoi documenti?');
		
		if ( r == false ){
			return false;
		}
		else{
			return true;
		}

	}

</script>
 