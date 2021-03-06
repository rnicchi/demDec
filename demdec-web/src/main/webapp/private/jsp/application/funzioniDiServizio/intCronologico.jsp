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
<!-- PageName = intCronologico.jsp -->
<!-- Controller  IntCronologicoController-->

<demdec:useAttribute id="showCapPg" name="<%=SessionAttributes.SHOW_CAP_PG%>"/>
<demdec:useAttribute id="showAutor" name="<%=SessionAttributes.SHOW_AUTOR%>"/>
<demdec:useAttribute id="showStrumento" name="<%=SessionAttributes.SHOW_STRUMENTO%>"/>
<demdec:useAttribute id="showPl" name="<%=SessionAttributes.SHOW_PL%>"/>
<demdec:useAttribute id="showPartita" name="<%=SessionAttributes.SHOW_PARTITA%>"/>
<demdec:useAttribute id="showSottoStrumento" name="<%=SessionAttributes.SHOW_SOTTO_STRUMENTO%>"/>
<demdec:useAttribute id="showBtnFiltri" name="<%=SessionAttributes.SHOW_BUTTON_FILTRI%>"/>
<demdec:useAttribute id="showLblFiltri" name="<%=SessionAttributes.SHOW_LABEL_FILTRI%>"/>
<demdec:useAttribute id="list" 		name="<%=SessionAttributes.CRONOLOGICO_VIEW_LIST%>"/>
<demdec:useAttribute id="listValori" 		name="<%=SessionAttributes.LIST_VALORI%>"/>
<demdec:useAttribute id="paginator" 	name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/>
<demdec:useAttribute id="selRow" 	name="<%=SessionAttributes.INT_SEL_ROW%>"/>
<demdec:useAttribute id="listTipoSubAut" 	name="<%=SessionAttributes.LIST_TIPO_SUB_AUT%>" />
<demdec:useAttribute id="listUtenti" 	name="<%=SessionAttributes.LIST_UTENTI%>" />
<demdec:useAttribute id="listOp" 	name="<%=SessionAttributes.LIST_FUNZIONI%>" />
<demdec:useAttribute id="paramDett" 	name="<%=WebConstants.DETTAGLIO_CRONOLOGICO%>" />
<tiles:useAttribute name="action" classname="java.lang.String"/>

<form:hidden path="codiApplicazione"/>
<form:hidden path="codiCategoria"/>
<form:hidden path="codiFunzione"/>
<form:hidden path="codiMenu"/>
<form:hidden path="autTipo"/>	  
<form:hidden path="autSubArt"/>
<form:hidden path="autSubComma"/>
<form:hidden path="autSubPunto"/>
<form:hidden path="strTipo"/>
<form:hidden path="sstTipo"/>	

<div class="row">
	<div class="large-12 columns">
		<div class="spacer_sm">&nbsp;</div>
		<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
		<fieldset>
			<!--  DATA E ORA  -->	
			<div class="row">
				<div class="small-3 columns left">
					<%-- <demdec:label labelKey="label.cronologicoDataDa"></demdec:label> --%>
					<label for="dataDa"><strong><spring:message code="label.cronologicoDataDa"/></strong></label>
					<form:input  path="dataDa" size="10" placeholder="gg/mm/aaaa" maxlength="10"/>&nbsp;
				</div>
				<div class="small-3 columns left">
					<%-- <demdec:label labelKey="label.cronologicoA"></demdec:label> --%>
					<label for="dataA"><strong><spring:message code="label.cronologicoA"/></strong></label>
					<form:input  path="dataA" size="10" placeholder="gg/mm/aaaa" maxlength="10"/>&nbsp;
				</div>
			</div>
			<div class="row">
				<div class="small-3 columns left">
					<%-- <demdec:label labelKey="label.cronologicoOraDa"></demdec:label> --%>
					<label for="oraDa"><strong><spring:message code="label.cronologicoOraDa"/></strong></label>
					<form:input path="oraDa" size="5" placeholder="HH:MM" maxlength="5"/>&nbsp;
				</div>
				<div class="small-3 columns left">
					<%-- <demdec:label labelKey="label.cronologicoOraA"></demdec:label> --%>
					<label for="oraA"><strong><spring:message code="label.cronologicoA"/></strong></label>
					<form:input path="oraA" size="5" placeholder="HH:MM" maxlength="5"/>&nbsp;
				</div>
			</div>
			<!--  UTENTE  -->	
			<div class="row">
				<div class="small-3 columns left">
					<%-- <demdec:label path="utente" labelKey="label.cronologicoUtente"/> --%>
					<label for="utente"><strong><spring:message code="label.cronologicoUtente"/></strong></label>
					<form:select path="utente">
						<form:option value="">&nbsp;</form:option>
						<c:forEach items="${listUtenti}" var="item">
							<form:option value="${item.codiUtente}">${item.codiUtente} </form:option>
						</c:forEach>
					</form:select>
				</div>
			<!-- OPERAZIONE -->
				<div class="small-3 columns left">
					<%-- <demdec:label path="traCodiCodice" labelKey="label.operazione"/> --%>
					<label for="traCodiCodice"><strong><spring:message code="label.operazione"/></strong></label>
					<form:select path="traCodiCodice">
						<form:option value="">&nbsp;</form:option>
						<c:forEach items="${listOp}" var="operazione">
							<form:option value="${operazione.id}">${operazione.descDescr} </form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="small-10 columns">
					<demdec:submit keyValue="button.eseguiRicerca" controllerCode="eseguiRicercaCrono" />
					&nbsp;
					<demdec:submit keyValue="button.nuovaRicerca" controllerCode="nuovaRicerca" />
				</div>
			</div>
		</fieldset>
	</div>
</div>
<!-- RISULTATI DELLA RICERCA -->
<div class="scroll_table_gen large-12 columns">
	<c:if test="${not empty pageScope.list }">
		<demdec:displaytag-table class="lux width100" name="pageScope.list" id="crono" >
			<display:caption>
				<span class="nascosto"><spring:message code="label.cronologico.transazioni"/></span>
			</display:caption>
			<demdec:displaytag-column title="<span class='nascosto'>Dettaglio</span>" >
				<demdec:submit styleClass="subm_folder" keyValue="label.empty" titleKey="label.apriDettaglio" controllerCode="apriDettaglioCrono?${paramDett}${crono_rowNum-1}"/>
			</demdec:displaytag-column>
			<demdec:displaytag-column property="codiNome" titleKey="label.cronologicoFunzione" />
			<demdec:displaytag-column property="descDescr" titleKey="label.descrizione" />
			<demdec:displaytag-column property="dataOprazFormatted" titleKey="label.cronologicoData" />
			<demdec:displaytag-column property="orarOperazFormatted" titleKey="label.cronologicoOra" />
			<demdec:displaytag-column property="descUtente" titleKey="label.cronologicoUtente" />								
			<demdec:displaytag-column property="descDescrTrans" titleKey="label.operazione" />
		</demdec:displaytag-table>
					
		<c:if test="${paginator ne null}">
			<div class="center">
				<demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>" 
								paginatorName="<%=Paginator.PAGINATOR_NAME%>"
								paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
								controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>"
				/>
			</div>						
		</c:if>	
		<div class="divtabella indications paginazione">
			<demdec:linkButton labelKey="label.exportExcel"  imageKey="ico.download.excel" action="${action}"
		                     parameter="exportExcel" /> <demdec:label	labelKey="label.exportExcel"></demdec:label>
		    <demdec:linkButton labelKey="label.exportPdf" imageKey="ico.download.pdf" action="${action}" 
		                     parameter="exportPdf" /> <demdec:label labelKey="label.exportPdf"></demdec:label>
		</div>
	</c:if>
</div>
<!-- DETTAGLI DELLA RICERCA -->

<div class="large-12 columns">	
	<c:if test="${not empty pageScope.listValori }">
		<div class="spacer_sm">&nbsp;</div> 
		<demdec:displaytag-table class="lux width100" name="pageScope.listValori" id="dettCrono" >
			<display:caption>
				<span class="nascosto"><spring:message code="label.cronologico.dettTransazioni"/></span>
			</display:caption>
			<demdec:displaytag-column property="campo" titleKey="label.campo"/>
			<demdec:displaytag-column property="textOldVal" titleKey="label.oldVal"/>
			<demdec:displaytag-column property="textNewVal" titleKey="label.newVal"/>
			<demdec:displaytag-column property="modificato" titleKey="label.modificato" style="text-align: center;"/>
		</demdec:displaytag-table>
	</c:if>
</div>

<%-- OLD --%>
<%--
<div class="boxFull">
	<demdec:panel	maxCellsNum="11" styleClass="paddingtop0">
	<!--  DATA E ORA  -->	
	<demdec:panel-section	titleKey="label.cronologicoDataOra" useSeparator="false" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>
				<demdec:label labelKey="label.cronologicoDataDa"></demdec:label><demdec:input-text path="dataDa" size="10"/>&nbsp;
				<demdec:label labelKey="label.cronologicoA"></demdec:label><demdec:input-text path="dataA"  size="10"/>&nbsp;&nbsp;&nbsp;
				<demdec:label labelKey="label.cronologicoOraDa"></demdec:label><demdec:input-text path="oraDa"  size="5"/>&nbsp;
				<demdec:label labelKey="label.cronologicoA"></demdec:label><demdec:input-text path="oraA"   size="5"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				
				<demdec:label labelKey="label.cronologicoUtente"></demdec:label><demdec:input-text path="utente" size="20" readonly="true"/>
				<demdec:selector-button controllerCode="selectorUtente" altPrefix="label.imgSubmit.prefix" altSuffix="label.cronologicoUtente"/>
				<br/><br/>
		 </demdec:panel-cell>
		</demdec:panel-row>						
	</demdec:panel-section>
	<!-- Funzione  -->
	<demdec:panel-section	titleKey="label.cronologicoApplCatFun" useSeparator="false" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>
				<demdec:label labelKey="label.cronologicoApplicazione"></demdec:label><demdec:input-text path="descApplicazione" size="20" readonly="true"/>
				<demdec:selector-button controllerCode="selectorApplicazione" altPrefix="label.imgSubmit.prefix" altSuffix="label.cronologicoApplicazione"/>   	
				<demdec:label labelKey="label.cronologicoCategoria"></demdec:label><demdec:input-text path="descCategoria" size="20" readonly="true"/>
				<demdec:selector-button controllerCode="selectorCategoria" altPrefix="label.imgSubmit.prefix" altSuffix="label.cronologicoCategoria"/>
				<demdec:label labelKey="label.cronologicoFunzione"></demdec:label><demdec:input-text path="descFunzione" size="50" readonly="true"/>
				<demdec:selector-button controllerCode="selectorFunzione" altPrefix="label.imgSubmit.prefix" altSuffix="label.cronologicoFunzione"/>
				<br/><br/>
		 </demdec:panel-cell>
		</demdec:panel-row>						
	</demdec:panel-section>
	<!-- Filtri -->
	<demdec:panel-section	titleKey="label.cronologicoFiltri" useSeparator="false" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>
		        <form:checkbox path="filtroCapPg"  value="1" />
				<demdec:label labelKey="label.cronologico.filtro.cappg"></demdec:label>
				<form:checkbox path="filtroAutorizzazione"  value="1" />                
                <demdec:label labelKey="label.cronologico.filtro.autorizzazione"></demdec:label>
                <form:checkbox path="filtroStrumento"  value="1" />                
                <demdec:label labelKey="label.cronologico.filtro.strumento"></demdec:label>
                <form:checkbox path="filtroSottoStrumento"  value="1" />            
                <demdec:label labelKey="label.cronologico.filtro.sottostrumento"></demdec:label>
                <form:checkbox path="filtroPartita"  value="1" />            
                <demdec:label labelKey="label.cronologico.filtro.partita"></demdec:label>
                <form:checkbox path="filtroPl"  value="1" />            
                <demdec:label labelKey="label.cronologico.filtro.pl"></demdec:label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;               
                <demdec:submit keyValue="button.impostaFiltri" controllerCode="apriFiltri"/>
                <demdec:submit keyValue="button.eliminaFiltri" controllerCode="eliminaFiltri"/>
                <br/><br/>                
		 </demdec:panel-cell>
		</demdec:panel-row>								
		<c:if test="${showLblFiltri ne ''}">
		 <demdec:panel-row>
		   <demdec:panel-cell>
             <b><span class="testo11">${showLblFiltri}</span></b>
           </demdec:panel-cell>
         </demdec:panel-row>
        </c:if>
	</demdec:panel-section>
	<!--  CAPITOLO PG -->
	<c:if test="${showCapPg}">
	<demdec:panel-section	titleKey="label.cronologico.filtro.cappg" useSeparator="true" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>
		        <demdec:label labelKey="label.esercizio"></demdec:label><demdec:input-text path="capAnno" size="4"/>
		        <demdec:label labelKey="label.stp"></demdec:label><demdec:input-text path="capStp" size="2"/>
		        <demdec:label labelKey="label.app"></demdec:label><demdec:input-text path="capApp" size="1"/>
		        <demdec:label labelKey="label.eos"></demdec:label><demdec:input-text path="capEos" size="1"/>
				<demdec:selector-button controllerCode="selectorCapitolo" altPrefix="label.imgSubmit.prefix" altSuffix="label.cronologicoApplicazione"/>
				<demdec:label labelKey="label.capitolo"></demdec:label><demdec:input-text path="capNume" size="4"/>
				<demdec:label labelKey="label.pg"></demdec:label><demdec:input-text path="numePg" size="2"/>
		 </demdec:panel-cell>
		</demdec:panel-row>						
	</demdec:panel-section>
	</c:if>
	<!--  Autor -->
	<c:if test="${showAutor}">
	<demdec:panel-section	titleKey="label.cronologico.filtro.autorizzazione" useSeparator="true" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>
		        <demdec:label labelKey="label.tipo"></demdec:label><demdec:input-text path="autDescTipo" size="4" readonly="true" />
		        <demdec:selector-button controllerCode="selectorTipoAut" altPrefix="label.imgSubmit.prefix" altSuffix="label.cronologicoApplicazione"/>
		        <demdec:label labelKey="label.numero"></demdec:label><demdec:input-text path="autNume" size="6"/>		  
		        <demdec:label labelKey="label.anno"></demdec:label><demdec:input-text path="autAnno" size="4"/>		        
		        <demdec:label labelKey="label.articolo"></demdec:label><demdec:input-text path="autArt" size="4"/>
		        <form:select path="autDescSubArt" id="autDescSubArt">
				  <c:forEach items="${listTipoSubAut}" var="tipoSubArt">
					<form:option value="${tipoSubArt.code}" title="${tipoSubArt.title}">
						<c:out value="${tipoSubArt.description}" />
					</form:option>
				  </c:forEach>
				</form:select>		        
		        <demdec:label labelKey="label.comma"></demdec:label><demdec:input-text path="autComma" size="4"/>
		        <form:select path="autDescSubComma" id="autDescSubComma">
				  <c:forEach items="${listTipoSubAut}" var="tipoSubComma">
					<form:option value="${tipoSubComma.code}" title="${tipoSubComma.title}">
						<c:out value="${tipoSubComma.description}" />
					</form:option>
				  </c:forEach>
				</form:select>		        
		        <demdec:label labelKey="label.punto"></demdec:label><demdec:input-text path="autPunto" size="4"/>
		        <form:select path="autDescSubPunto" id="autDescSubPunto">
				  <c:forEach items="${listTipoSubAut}" var="tipoSubPunto">
					<form:option value="${tipoSubPunto.code}" title="${tipoSubPunto.title}">
						<c:out value="${tipoSubPunto.description}" />
					</form:option>
				  </c:forEach>
				</form:select>		        				
		 </demdec:panel-cell>
		</demdec:panel-row>						
	</demdec:panel-section>
	</c:if>
	<!--  Strumento -->
	<c:if test="${showStrumento}">
	<demdec:panel-section	titleKey="label.cronologico.filtro.strumento" useSeparator="true" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>	
		        <demdec:label labelKey="label.anno"></demdec:label><demdec:input-text path="strAnno" size="4"/>
		        <demdec:label labelKey="label.tipo"></demdec:label><demdec:input-text path="strDescTipo" size="4" readonly="true"/>
		        <demdec:selector-button controllerCode="selectorTipoStr" altPrefix="label.imgSubmit.prefix" altSuffix="label.cronologicoApplicazione"/>
		        <demdec:label labelKey="label.numero"></demdec:label><demdec:input-text path="strNume" size="6"/>		        		        				
		 </demdec:panel-cell>
		</demdec:panel-row>						
	</demdec:panel-section>
	</c:if>
	<!--  Sotto Strumento -->
	<c:if test="${showSottoStrumento}">
	<demdec:panel-section	titleKey="label.cronologico.filtro.sottostrumento" useSeparator="true" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>	
		        <demdec:label labelKey="label.anno"></demdec:label><demdec:input-text path="sstAnno" size="4"/>
		        <demdec:label labelKey="label.tipo"></demdec:label><demdec:input-text path="sstDescTipo" size="4" readonly="true"/>
		        <demdec:selector-button controllerCode="selectorTipoSst" altPrefix="label.imgSubmit.prefix" altSuffix="label.cronologicoApplicazione"/>
		        <demdec:label labelKey="label.numero"></demdec:label><demdec:input-text path="sstNume" size="6"/>		        		        				
		 </demdec:panel-cell>
		</demdec:panel-row>						
	</demdec:panel-section>
	</c:if>	
	<!--  Partita -->
	<c:if test="${showPartita}">
	<demdec:panel-section	titleKey="label.cronologico.filtro.partita" useSeparator="true" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>	
		        <demdec:label labelKey="label.esercizio"></demdec:label><demdec:input-text path="parEseAnnoEse" size="4"/>
		        <demdec:label labelKey="label.anno"></demdec:label><demdec:input-text path="parAnno" size="4"/>		        
		        <demdec:label labelKey="label.numero"></demdec:label><demdec:input-text path="parNumero" size="6"/>		        		        				
		 </demdec:panel-cell>
		</demdec:panel-row>						
	</demdec:panel-section>
	</c:if>
	<!--  PL -->
	<c:if test="${showPl}">
	<demdec:panel-section	titleKey="label.cronologico.filtro.pl" useSeparator="true" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>		        
		        <demdec:label labelKey="label.anno"></demdec:label><demdec:input-text path="plAnno" size="4"/>		        
		        <demdec:label labelKey="label.numero"></demdec:label><demdec:input-text path="plNumero" size="6"/>		        		        				
		 </demdec:panel-cell>
		</demdec:panel-row>						
	</demdec:panel-section>
	</c:if>
	<!--  BOTTONI -->
	<c:if test="${showBtnFiltri}">
	<demdec:panel-section	useSeparator="true" styleClass="testo11tit">	
		<demdec:panel-row>			
		  <demdec:panel-cell>	
		      <demdec:submit keyValue="button.salvaFiltri" controllerCode="salvaFiltri"/>
		      <demdec:submit keyValue="button.chiudiFiltri"  controllerCode="chiudiFiltri"/>  		        		        				
		 </demdec:panel-cell>
		</demdec:panel-row>						
	</demdec:panel-section>
	</c:if>
	<demdec:panel-section	useSeparator="true" styleClass="testo11tit">
	<demdec:panel-row>
			<demdec:panel-cell>
		      <demdec:submit keyValue="button.eseguiRicerca" controllerCode="eseguiRicercaCrono"/>
		      <demdec:submit keyValue="button.nuovaRicerca"  controllerCode="nuovaRicerca"/>		    
		    </demdec:panel-cell>
	</demdec:panel-row>
    </demdec:panel-section>
			
		<c:if test="${not empty pageScope.list }">
			
			<demdec:panel-section titleKey="label.cronologico.transazioni"	useSeparator="true" styleClass="testo11tit">
				<demdec:panel-row>
					<demdec:panel-cell>
							<demdec:displaytag-table name="pageScope.list" id="report" selectedRow="${selRow}">							    
								<demdec:displaytag-column property="codiNome" titleKey="label.cronologicoFunzione" labelTitleKey="label.cronologicoFunzione" style="width : 100px;"/>
								<demdec:displaytag-column property="descDescr" titleKey="label.descrizione" labelTitleKey="label.descrizione"/>
								<demdec:displaytag-column property="dataOprazFormatted" titleKey="label.cronologicoData" labelTitleKey="label.cronologicoData" style="width : 100px; text-align: center; "/>
								<demdec:displaytag-column property="orarOperazFormatted" titleKey="label.cronologicoOra" labelTitleKey="label.cronologicoOra" style="width : 80px; text-align: center;"/>
								<demdec:displaytag-column property="descUtente" titleKey="label.cronologicoUtente" labelTitleKey="label.cronologicoUtente" style="width : 150px;"/>								
								<demdec:displaytag-column property="descDescrTrans" titleKey="label.operazione" labelTitleKey="label.operazione"/>
								<!-- APRI -->									
								<demdec:displaytag-column-button 
									action="${action}" 
									labelKey="label.apriDettaglio" 
									imageKey="ico.open" 
									parameter="<%=WebConstants.DETTAGLIO_CRONOLOGICO%>"
								/>									
								<!-- APRI -->	
							</demdec:displaytag-table>			
							<c:if test="${paginator ne null}">
								<div class="divtabella indications paginazione">
									<demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>" 
													paginatorName="<%=Paginator.PAGINATOR_NAME%>"
													paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
													controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>"
									/>
								</div>						
							</c:if>	
							<div class="divtabella indications paginazione">
							<demdec:linkButton labelKey="label.exportExcel"  imageKey="ico.exportExcel" action="${action}"
						                     parameter="exportExcel" /> <demdec:label	labelKey="label.exportExcel"></demdec:label>
						    <demdec:linkButton labelKey="label.exportPdf" imageKey="ico.exportPdf" action="${action}" 
						                     parameter="exportPdf" /> <demdec:label labelKey="label.exportPdf"></demdec:label>
 					        </div>
					</demdec:panel-cell>
				</demdec:panel-row>	
			</demdec:panel-section>
		</c:if>
	
	<c:if test="${not empty pageScope.listValori }">
		<demdec:panel-section	titleKey="label.cronologico.dettTransazioni" useSeparator="true" styleClass="testo11tit">
		<demdec:panel-row>
			<demdec:panel-cell>
				<demdec:displaytag-table name="pageScope.listValori" id="report">
					<demdec:displaytag-column property="campo" titleKey="label.campo" labelTitleKey="label.campo"/>
					<demdec:displaytag-column property="textOldVal" titleKey="label.oldVal" labelTitleKey="label.oldVal"/>
					<demdec:displaytag-column property="textNewVal" titleKey="label.newVal" labelTitleKey="label.newVal"/>
					<demdec:displaytag-column property="modificato" titleKey="label.modificato" labelTitleKey="label.modificato" style="text-align: center;"/>
    			</demdec:displaytag-table>			
			</demdec:panel-cell>
			</demdec:panel-row>	
		</demdec:panel-section>
	</c:if>
	</demdec:panel>
</div>	
--%>