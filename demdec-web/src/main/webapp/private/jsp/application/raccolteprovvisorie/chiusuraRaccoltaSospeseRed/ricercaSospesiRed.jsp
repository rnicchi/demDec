<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- PageName = ricercaSospesiRed -->
<tiles:useAttribute name="action" classname="java.lang.String" />

<demdec:useAttribute id="listAnniEser" name="<%=WebConstants.LIST_ANNO_ESE%>"/> 
<demdec:useAttribute id="amministrazioneList" name="<%=WebConstants.LIST_AMMIN_DEM%>"/>  
<demdec:useAttribute id="anagUfficiList" name="<%=WebConstants.LIST_ANAG_UFF%>"/>  
<demdec:useAttribute id="anagStatiFascList" name="<%=WebConstants.LIST_ANAG_STATI_FASC%>"/>  
<demdec:useAttribute id="anagTipoFlussoList" name="<%=WebConstants.LIST_ANAG_TIPO_FLUSSO%>"/>  


 <div class="large-12 columns">
 
 <fieldset>
   <div class="container_field"> 
	  <div class="row">
	      <div class="small-3 columns">
	         <demdec:label path="protocolloRed"  labelKey="label.protocolloRed"/>
	         <form:input path="protocolloRed" /> 
	      </div>
	      <div class="small-3 columns">
	         <demdec:label path="dataRedDa" labelKey="label.dataProtocolloRedDa"/>
	         <form:input path="dataRedDa" placeholder="gg/mm/aaaa"  maxlength="10" />        
	      </div>
	 
	      <div class="small-3 columns left">
	         <demdec:label path="dataRedA" labelKey="label.dataProtocolloRedA"></demdec:label> 
	         <form:input path="dataRedA" placeholder="gg/mm/aaaa"  maxlength="10"/>        
	      </div>
	  </div>
  </div>
  
 <div class="row">
  
      <div class="small-6 columns">
          <demdec:label path="idRed"  labelKey="label.idRed"/>
         <form:input path="idRed" /> 
      </div>

  </div>

   
  <div class="container_field">  
    <div class="row">
  
		     <div class="small-3 columns">
		            
		             <demdec:label path="annoEse"  labelKey="label.anno"/>
		       		 <form:select path="annoEse"   > 
		       		    <form:option value="" >&nbsp;</form:option>
		          		<c:forEach var="msg" items="${listAnniEser}">		
							 <form:option value="${msg.id}" >${msg.id} </form:option> 
						</c:forEach>    		
		        	 </form:select>  
		     </div>
		      <div class="left">
		               <demdec:submit keyValue="button.load" controllerCode="caricaAmministrazioni" styleClass="subm_update posit-butt_up"  title="Aggiorna Amministrazione"/>
		      </div>
		      <div class="small-5 columns">
		         <demdec:label path="amministrazione"  labelKey="label.raccolteProvvisorie.amministrazione"/>
		              <form:select path="amministrazione" >
								<form:option value="" label="-- Selezionare un'amministrazione --"/>
								           
								<c:forEach var="msg" items="${amministrazioneList}">	
								<c:choose> 
										   <c:when test="${msg.id.numeStp<10}"> 
										 			
										     <form:option value="0${msg.id.numeStp}${msg.id.numeApp}" >0${msg.id.numeStp}${msg.id.numeApp} - ${msg.descAmm}</form:option> 
										  </c:when>
										  <c:otherwise>
										     <form:option value="${msg.id.numeStp}${msg.id.numeApp}" >${msg.id.numeStp}${msg.id.numeApp} - ${msg.descAmm}</form:option>
										  </c:otherwise>
								</c:choose>   
								</c:forEach> 
					         </form:select>
		      </div>
    </div>
   </div>

<div class="spacer_sm">&nbsp;</div>
  <div class="row">
      <div class="small-4 columns">
       <demdec:label path="ufficioAssociatoRed"  labelKey="label.ufficioAssociatoRed"/>
          <form:select path="ufficioAssociatoRed" > 
          <form:option value="" label="-- Selezionare un ufficio --"/>
                <c:forEach var="msg" items="${anagUfficiList}">		
					 <form:option value="${msg.id}-${msg.descUfficio}" >${msg.descUfficio} </form:option> 
				</c:forEach> 
        </form:select> 
      </div> 
  </div>
  
  <%--  <div class="row">  
      <div class="small-3 columns">
         <demdec:label path="dataArrivoDa" labelKey="label.dataArrivoDa"/> 
         <form:input path="dataArrivoDa" placeholder="gg/mm/aaaa"  maxlength="10" />        
      </div>
   
      <div class="small-3 columns left">
         <demdec:label path="dataArrivoA" labelKey="label.dataArrivoA"></demdec:label>
         <form:input path="dataArrivoA" placeholder="gg/mm/aaaa"  maxlength="10"/>          
      </div>
  </div> --%>

	<input id="stato" name="stato" type="hidden" value="Aperto"/> 
  <br>

 <div class="row">
      <div class="small-4 columns">      
         <demdec:label path="tipoFlusso" labelKey="label.tipoFlusso"/> 
         <form:select path="tipoFlusso" > 
          <form:option value="" label="-- Selezionare un tipo flusso --"/>
                <c:forEach var="msg" items="${anagTipoFlussoList}">		
					 <form:option value="${msg.id}" >${msg.descTipoFlusso} </form:option> 
				</c:forEach> 
        </form:select> 
      </div> 
  </div>
 
 <br>
   <div class="row">
      <div class="small-10 columns">
      	 <demdec:submit keyValue="label.filtro.data" controllerCode="ricercaSospesiRed" />
         <demdec:submit keyValue="label.clean" controllerCode="pulisciRicercaSospesiRed" />
      </div>
  </div>
  
  </fieldset>
 
 </div> 
 
