
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!-- PageName = raccolteProvvisorie.jsp -->
 <tiles:useAttribute name="action" classname="java.lang.String" />
 <demdec:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/>
 
   <demdec:useAttribute id="listRaccolteProvvisorie" name="<%=SessionAttributes.LIST_RICERCA_RED%>"/>  
   <demdec:useAttribute id="listTipiDecr" name="<%=WebConstants.LIST_TIPI_DECRETI%>"/>  
   <demdec:useAttribute id="listAnniEser" name="<%=WebConstants.LIST_ANNO_ESE%>"/> 

<script type="application/javascript">
var jsonData;
</script>


 <!-- Sezione  -->


 
<div class="large-12 columns">

  <fieldset>
  <legend>FAD di destinazione - Selezione Decreto</legend>

     <%@include file="/private/jsp/form/ricercaTipoNumeroAnno.jsp" %>
          
          
           
		  <div class="row" >
		    <div class="small-10 columns">
		    
		    <button type="button"  class="button small" onclick="javascript:caricaPopup('contModal_0', 'modaleListaDecretiRaccProvv');" > <demdec:label  labelKey='label.title.ricercaRed'/></button>
		   <%-- <button type="submit" class="button small">Pulisci</button>--%>
		 <%--    <button type="button"  class="button small" onclick="javascript: pulisciRaccProvv();" > <demdec:label  labelKey="label.clean"/></button>--%>
		     <demdec:submit  keyValue="button.clean" controllerCode="pulisciRaccolteProvvisorie"   styleClass="button small"/> 
		    </div>
		  </div>
		  
		   </fieldset>
    

  
  
   
 
 <!--**INIZIO INCLUDE MODALE modaleRicercaFascicoliFAD.jsp -->	

 	<%@include file="/private/jsp/modal/modaleRicercaFascicoliFAD.jsp" %>  
	
<!-- END INCLUDE MODALE Selezione Decreto   modaleRicercaFascicoliFAD.jsp --> 



 <!--**INIZIO INCLUDE MODALE modaleDettaglioFascicolo.jsp -->	
	<%@include file="/private/jsp/modal/modaleDettaglioFascicolo.jsp" %>    
 <%--END INCLUDE MODALE  modaleDettaglioFascicolo.jsp --%>

    
     
    <div class="overlay"></div>
    
            <!--INI SCROLL-->
  

  <!--**INIZIO LISTA RACCOLTE-->

  <div>
	  
 
 <c:if test="${not empty listRaccolteProvvisorie}">

   <demdec:displaytag-table   name="pageScope.listRaccolteProvvisorie" id="listRaccolteProvvisorie"  class="lux tableDati width100" >
  		
  		<display:caption><span class="nascosto">Tabella fascicoli raccolte provvisorie</span></display:caption>
  		
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.preView"  class="center">
			
 				<c:if test="${not empty listRaccolteProvvisorie.preView}">
					<a href="javascript: caricaModaleAnteprima('${listRaccolteProvvisorie_rowNum - 1}','<%=SessionAttributes.LIST_RICERCA_RED%>'); " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_preview.png" alt="Visualizza Anteprima" title="Visualizza Anteprima">
					</a>			
				</c:if>
				
			</demdec:displaytag-column>
			<demdec:displaytag-column title="<span class='nascosto'>Visualizza cartella</span>">
<%-- 				<c:if test="${not empty listRaccolteProvvisorie.preView}">
					<demdec:submit data-toggle="tooltip" data-html="true" data-template="<img src="data:image/jpg;base64,<c:out value='${listRaccolteProvvisorie.preView}'/>" />" styleClass="subm_folder" keyValue="label.empty"  controllerCode="apriDocumentiFascicolo?idRed=${listRaccolteProvvisorie.idFascicoloRaccoltaProvvisoria}" />
				</c:if>
				<c:if test="${empty listRaccolteProvvisorie.preView}"> --%>
					<demdec:submit styleClass="subm_folder" keyValue="label.empty"  controllerCode="apriDocumentiFascicolo?idRed=${listRaccolteProvvisorie.idFascicoloRaccoltaProvvisoria}" />
<%-- 				</c:if> --%>
			</demdec:displaytag-column>
			<demdec:displaytag-column property="identificativoRaccoltaProvvisoria" titleKey="label.idRed"/>
			<demdec:displaytag-column titleKey="label.protocolloRed">
				 ${listRaccolteProvvisorie.protocollo.numeroProtocollo}/<fmt:formatDate pattern="yyyy"  value="${listRaccolteProvvisorie.protocollo.data}" /> 					
			</demdec:displaytag-column>
			
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.dataProtocolloIngr">
			 	 <fmt:formatDate pattern="dd/MM/yyyy"  value="${listRaccolteProvvisorie.protocollo.data}" />
			</demdec:displaytag-column>
			
			<demdec:displaytag-column property="descrizione" titleKey="label.raccolteProvvisorie.oggetto" />
			<demdec:displaytag-column sortName="amministrazione.code"  property="amministrazione.code" titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
			<%-- <demdec:displaytag-column property="statoFascicoloRaccoltaProvvisoria.description" titleKey="label.raccolteProvvisorie.statoFascicolo" />--%>
			<demdec:displaytag-column property="descStatoFascicoloDocumentale" titleKey="label.raccolteProvvisorie.statoLavorazione" />
			<%-- <demdec:displaytag-column property="dataCreazione" titleKey="label.raccolteProvvisorie.dataCreazione"/> --%>
			<%-- <demdec:displaytag-column property="ufficioCreatoreRED.description" titleKey="label.raccolteProvvisorie.ufficioAssociato"  /> --%>
			<%--   <demdec:displaytag-column property="protocollo.data" titleKey="label.raccolteProvvisorie.dataProtocollo"/>  --%>
			
			<%-- <demdec:displaytag-column property="utenteCreatore.description" titleKey="label.raccolteProvvisorie.utenteAssegnatario"  />  --%>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center" >
						
						
					<%-- <a href="javascript:alert('CCC'); caricaModaleDettFasc('contModal_Dett', ${listRaccolteProvvisorie.idFascicoloRaccoltaProvvisoria})" > --%>
<a href="javascript: caricaModaleDettFasc('contModal_2', '${listRaccolteProvvisorie.idFascicoloRaccoltaProvvisoria}'); " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_view_det.png" alt="Visualizza Metadati">
					</a>
			
			</demdec:displaytag-column>
	</demdec:displaytag-table>

	
	</c:if>
	

	<c:if test="${paginator ne null}">
		<div>&nbsp;</div>
		
      	
	     <div class="center color_grey">
      
	         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
	                         paginatorName="<%=Paginator.PAGINATOR_NAME%>"
	                         paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
	                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
	        <div class="right"> <demdec:submit keyValue="button.nuovaRicerca" controllerCode="pulisciRicercaRed"   styleClass="button small"/></div>
	     </div>                       
 	</c:if> 
 	
 </div>
<br>
   

 </div> 

 
	<%-- <div id="emptyList">
	<c:if test="${empty listRaccolteProvvisorie}">
		<spring:message code="info.noDataFound"></spring:message>
	</c:if>
	</div> --%>


  <!--**FINE LISTA RACCOLTE-->
        <!--END SCROLL-->

        <div class="spacer_sm">&nbsp;</div>

