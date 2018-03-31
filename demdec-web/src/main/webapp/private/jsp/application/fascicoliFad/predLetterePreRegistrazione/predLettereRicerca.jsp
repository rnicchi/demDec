<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<div id="D_Cont_80">
<form:form action="int_lettere" commandName="filtro" method="post">
<tiles:insertAttribute name="pageMessage"/>

<table cellpadding="0" cellspacing="2" class="table_w100">
          <tr>
            <td class="left"><span class="testo11-nero"><strong>&#8226;</strong> Estremi di ricerca - * (Campo obbligatorio)</span></td>
        </tr>
</table>

<table cellpadding="5" cellspacing="6" class="sf_tab_1 table_w100 border_col_1">

 <tr>
   <%-- <td class="width15 right"><form:label path="lettera.annoEsercizio"><span class="testo11-nero"><strong>Anno Esercizio:</strong></span></form:label></td>
    <td class="width15 left"><form:input path="lettera.annoEsercizio" size="4" maxlength="4" /></td> --%>
  <%--    <tr>
    	<td  class="width15 right" align="right"><span class="testo11-nero"><strong><form:label path="lettera.numeroDecreto"> Numero Decreto: </form:label></strong></span></td>
   	 	<td  class="width15 left" align="left"><form:input path="lettera.numeroDecreto" size="10" maxlength="10" /></td>
    </tr> --%>
    
    	<%--  <tr>
            <td  class="right" ">
		       <span class="testo11-nero">* <strong><form:label path="annoEsercizio">Anno Esercizio </form:label></strong></span>
		       
		    </td>
		    <td class="left">
		       <form:select path="annoEsercizio" disabled="${filtro.disablingSet.annoEsercizioDisabled}"  >
		           <form:option value="" label="-- Selezionare l'esercizio finanziario --" />
		           <c:forEach items="${filtro.annoEseList}" var="anno">
		                <form:option value="${anno}" label="${anno}" />
		           </c:forEach>
		       </form:select>
		       
		       <c:if test="${filtro.disablingSet.annoEsercizioDisabled}">
		                <form:hidden path="annoEsercizio"  />
		                <form:hidden path="disablingSet.annoEsercizioDisabled" />
		       </c:if>
     		</td>

  		  </tr>--%>
  	<tr>
  	
	    <td class="right">
	         <span class="testo11-nero">*<strong><form:label path="annoEsercizio">Anno Esercizio  </form:label></strong></span>
	    </td>
    	<td class="left">
        	 
         	<form:select path="annoEsercizio" disabled="${filtro.disablingSet.annoEsercizioDisabled}">
				<form:option value="" label="-- Selezionare l'esercizio finanziario --"/>
			          
				<c:forEach var="anno" items="${filtro.annoEseList}" >
					<form:option value="${anno}" label="${anno}"/>
				</c:forEach>
         	</form:select>
	          
	        <c:if test="${filtro.disablingSet.annoEsercizioDisabled}" >
              <form:hidden path="annoEsercizio" id="annoEsercizioHidden"/>
          </c:if>
	         
     	 </td> 
    
  </tr>
   <%--  <tr>
    	<td  class="width15 right" align="right"><span class="testo11-nero"><strong><form:label path="annoEsercizio">* Anno Esercizio: </form:label></strong></span></td>
   		 <td  class="width15 left" align="left"><form:input path="annoEsercizio" size="4" maxlength="4" disabled="${filtro.disablingSet.annoEsercizioDisabled}"/></td>
   		<c:if test="${filtro.disablingSet.annoEsercizioDisabled}">
			<form:hidden path="annoEsercizio" id="annoEsercizioHidden"/>
    	</c:if>
  </tr>  --%>
  <tr>
	    <td class="right">
	         <span class="testo11-nero"><strong><form:label path="idAmm">Amministrazione: </form:label></strong></span>
	    </td>
    	<td class="left">
        	 <input type="submit" value="..." name="loadAmministrazioni" title="Filtra Amministrazioni"/>
         	<form:select path="idAmm" disabled="${filtro.disablingSet.amministrazioneDisabled}">
				<form:option value="" label="-- Selezionare un'amministrazione --"/>
			          
				<c:forEach var="amm" items="${filtro.amministrazioneList}" varStatus="rowCounter">
					<form:option value="${amm.id}" label="${amm.codiAmministrazione} - ${amm.descrizione02}"/>
				</c:forEach>
         	</form:select>
	          
	        <c:if test="${filtro.disablingSet.amministrazioneDisabled}" >
              <form:hidden path="idAmm" id="idAmmHidden"/>
          </c:if>
	         
     	 </td> 
     	 <td  class="width15 right" align="right"><span class="testo11-nero"><strong> Numero Decreto: </strong></span></td>
   	 	<td  class="width15 left" align="left"><form:input path="numeroDecreto" size="10" maxlength="10" /></td>
   
    
  </tr>
   <tr>
   
      <td class="width10 right" align="right" > 
    		<form:label path="data">
            <span class="testo11-nero"><strong>Data Lettera: </strong></span></form:label>
      </td>
      <td class="width15 left"  align="left">
           
           <form:label path="data">
             <span class="testo11-nero">(gg/mm/aaaa) </span></form:label>
           <form:input path="data" size="10" maxlength="10" />
    </td>
   <%--   <td class="right"><form:label path="lettera.amministrazione.descrizione01"><span class="testo11-nero"><strong>Amministrazione:</strong></span></form:label></td>
    <td class="left"><form:input path="lettera.amministrazione.descrizione01" size="65" maxlength="65" /></td> --%>
   
    <td class="right"><form:label path="lettera.statusLettera"><span class="testo11-nero"><strong>Stato Lettera:</strong></span></form:label></td>
   <td class="left"> <form:input path="lettera.statusLettera" size="20" maxlength="20" />

  </tr>
</table>


 <div id="contPuls">

  <input name="ricercaLettere" type="submit" class="puls" value="Ricerca Lettere" title="Ricerca Lettere" />
  <input name="pulisciRicLettere" type="submit" class="puls" value="Pulisci" title="Pulisci" />
 
  
</div>



<c:if test='${listaLettere != null}'>
    
        <tiles:insertAttribute name="predLettereListaLettere"/> 

</c:if>
    
</form:form>
 </div>
<!-- End D_Cont-->
  