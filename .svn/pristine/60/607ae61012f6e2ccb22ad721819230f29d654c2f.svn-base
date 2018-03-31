<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- PageName = selezionaCdr.jsp -->
<demdec:useAttribute id="amministrazioniSelectedList"	name="<%=WebConstants.LIST_SELECTED_AMMS%>" />
<demdec:useAttribute id="cdrList"	name="<%=WebConstants.LIST_CDR%>" />



 <h2 class="nascosto">Tabella</h2>

 <div class="spacer_sm">&nbsp;</div>

<div class="title_doc">Selezione Cdr</div>


 <div class="spacer_sm">&nbsp;</div>

  <fieldset>
		
<form:hidden path="annoDec"/>
<form:hidden path="tipoDec"/>
<form:hidden path="numDec"/>
<form:hidden path="descDec"/>
<form:hidden path="tipologiaDec"/>
<form:hidden path="numPatr"/>
<form:hidden path="ammRows"/>
<form:hidden path="ufficio"/>

<div class="large-12 columns">

  
  
    <div class="row">
      <div class="small-4 columns">


      
       <demdec:label path="ammForCdr" labelKey="label.amm.list" />
          <form:select path="ammForCdr" > 
          <form:option value="" label="-- Selezionare un' amministrazione --"/>
               	<c:forEach var="amm" items="${amministrazioniSelectedList}" varStatus="status">
					 <form:option value="${status.count}" >${amm.id.numeStpFormatted} - ${amm.id.numeApp }</form:option> 
				</c:forEach> 
        </form:select> 
        
         <demdec:submit keyValue="button.cdr" styleClass="buttonPag border-radius" controllerCode="caricaCdrFromAmm" titleKey="button.cdr" />
        
  </div>
   </div>
    </div>

<div class="row">
     
      <div class="small-10 columns">
      
             
                


   <c:if test="${not empty cdrList}">
   
  		<demdec:displaytag-table name="pageScope.cdrList" id="cdrList" class="lux width100">	
  			<display:caption><span class="nascosto">Lista Cdr</span>
										</display:caption>
				<demdec:displaytag-column titleKey="label.selection" >
						 <form:checkbox   path="cdrRows"	 value="${cdrList_rowNum}"    />  
				</demdec:displaytag-column>
				<demdec:displaytag-column property="id.fkAnnoEse" titleKey="label.anno" />
				<demdec:displaytag-column property="id.ammin" titleKey="label.amministrazione" />
				<demdec:displaytag-column property="id.numeCdr" titleKey="label.numero" />
				<demdec:displaytag-column property="descCdr" titleKey="label.descrizione" />
				
		</demdec:displaytag-table> 
		
		</c:if>
		
		  </div> 
		
          </div> 
      
      <br />
       <div class="spacer_sm">&nbsp;</div>

<div style="text-align:center">
			
   <div class="row">
      <div class="small-10 columns">
      	 <demdec:submit keyValue="label.confirm" controllerCode="backFromCdr" titleKey="label.conferma.cdr"/>
      	 <demdec:submit keyValue="label.back" controllerCode="cancelFromCdr" titleKey="label.back"/>
      	<%--  <a href="<%=request.getContextPath() %>/public/ricercaRed.do?cmdGET___recuperaDatiModale=recuperaDatiModale">lnk</a> --%>
      <%-- 	 <demdec:linkButton labelKey="label.exportExcel" imageKey="ico.exportExcel" action="/public/ricercaRed.do" parameter="recuperaDatiModale" parameterValue="__EXPORT_GENERIC_EXCEL__" /> --%>
		<%--<demdec:submit keyValue="button.back" controllerCode="back" /> --%>
        
          <!--  button type="submit">Cerca</button> -->
      </div>
  </div>

	
	</div>




</fieldset>
