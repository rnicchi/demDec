
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
 
   <demdec:useAttribute id="listaLettere" name="<%=SessionAttributes.LIST_LETTERE_PRE_REG%>"/>  
   <demdec:useAttribute id="listTipiDecr" name="<%=WebConstants.LIST_TIPI_DECRETI%>"/>  
   <demdec:useAttribute id="listAnniEser" name="<%=WebConstants.LIST_ANNO_ESE%>"/> 

<script type="application/javascript">
var jsonData;
</script>


 <!-- Sezione  -->


 


  <div>
	  
 <div class="spacer_sm">&nbsp;</div>	  
 <div class="spacer_sm">&nbsp;</div>
 <c:if test="${not empty listaLettere}">

   <demdec:displaytag-table   name="pageScope.listaLettere" id="listaLettere"  class="lux tableDati width100" >
  		
  		<display:caption><span class="nascosto">Tabella lista lettere di preregistrazione</span></display:caption>
  		
			<demdec:displaytag-column property="fascicoli.estremiStr" titleKey="label.raccolteProvvisorie.estremiStr" class="center"/> 
		 	<%-- <demdec:displaytag-column property="fascicoli.eserciziDem.id" titleKey="label.annoEsercizio" class="center"/> 
			<demdec:displaytag-column property="fascicoli.numeNumDecreto" titleKey="label.numeroDecreto" class="center" /> --%>
			
		 	<demdec:displaytag-column titleKey="label.predLetterePreReg.dataLettera" class="center">
			 	 <fmt:formatDate pattern="dd/MM/yyyy"  value="${listaLettere.dataLettera}" />
			</demdec:displaytag-column> 
			
		 	<demdec:displaytag-column sortName="anagAmminDem.descAmm"  property="anagAmminDem.descAmm" titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
		 	<%-- <demdec:displaytag-column property="sletteratatoFascicoloRaccoltaProvvisoria.description" titleKey="label.raccolteProvvisorie.statoFascicolo" />--%>
		<%-- 	<demdec:displaytag-column property="statusLettera" titleKey="label.raccolteProvvisorie.statoLavorazione" class="center"/> --%>
			
			<demdec:displaytag-column  titleKey="label.predLetterePreReg.lettera" class="center" >
				<demdec:linkButton  action="${action}" imageKey="ico.download.pdf" parameter="apriLettera" title="Documento in formato PDF"  parameterValue="${listaLettere_rowNum-1}" />
			</demdec:displaytag-column>
			
			<%-- <demdec:displaytag-column  titleKey="label.predLetterePreReg.deleteLettera" class="center" >
				<demdec:linkButton styleClass="padd_sx_logo" action="${action}" imageKey="ico.document.delete" parameter="deleteLetteraDecreto" title="Cancella Lettera" parameterValue="${listaLettere_rowNum-1}"    />
			</demdec:displaytag-column> --%>
			
			
			<demdec:displaytag-column titleKey="label.predLetterePreReg.personalizzaLettera" class="center color_grey">
					<demdec:submit styleId="btnView${listaLettere_rowNum}"   styleClass="subm_none_upd" keyValue="label.empty" title="Personalizza Lettera Decreto ${listaLettere.fascicoli.estremiStr}" alt="Personalizza Lettera Decreto ${listaLettere.fascicoli.estremiStr}" controllerCode="personalizza?${listaLettere_rowNum-1}" />
			</demdec:displaytag-column>
			
			
			<demdec:displaytag-column  titleKey="label.allegato" class="center" >
				<demdec:linkButton  action="${action}" imageKey="ico.download.pdf" parameter="apriAllegatoLettera" title="Documento in formato PDF"  parameterValue="${listaLettere_rowNum-1}" />
			</demdec:displaytag-column>
			
			<%--  <demdec:displaytag-column titleKey="label.delete" class="center">
					<demdec:submit styleId="btnDel${listaLettere_rowNum}" styleClass="subm_none_del" keyValue="label.empty" titleKey="label.delete" controllerCode="deleteLetteraDecreto?selectedLettera=${listaLettere_rowNum-1}" onclick="javascript:return confirm('Confermi cancellazione?');"/>
			</demdec:displaytag-column> --%>
			
		
			
	</demdec:displaytag-table>

	
	</c:if>
</div>

	<c:if test="${paginator ne null}">
		
	     <div class="center color_grey">
       
	         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
	                         paginatorName="<%=Paginator.PAGINATOR_NAME%>"
	                         paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
	                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
	       
	     </div>                       
 	</c:if> 
 	<div class="left"> <demdec:submit keyValue="button.back" controllerCode="backFromLettere"   styleClass="button small"/></div>

<br>
   
  		<div class="spacer_sm">&nbsp;</div>
        <div class="spacer_sm">&nbsp;</div>

 
        <!--END SCROLL-->

      
