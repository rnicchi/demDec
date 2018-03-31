
  <!-- INIZIO MODALE Modifica Metadati Documento Fad -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<demdec:useAttribute id="tipoDocList"	name="<%=WebConstants.LIST_TIPO_DOC%>" />
<demdec:useAttribute id="ammList"	    name="<%=WebConstants.LIST_AMMIN_DEM%>" />
<demdec:useAttribute id="modVisibilita"	name="<%=WebConstants.CHK_MODIFICA_VISIBILITA%>" />
<demdec:useAttribute id="descDocumenti" name="<%=WebConstants.LIST_DESC_DOCUMENTI%>"/>
<demdec:useAttribute id="visibilitaCdc" name="<%=WebConstants.LIST_VISIBILITA_CDC%>" /> 

 <script type="application/javascript">


 function myFunction(y) {
	
	    document.getElementById("visibilita").value = y;
	   
  <% if (!"true".equalsIgnoreCase(modVisibilita.toString())) { %>
	  <%-- per passare la visibilità in caso di select impostata a disabled==true --%>
	  document.getElementById("visibilitaHidden").value = y;
	<% } %>
	   }
 
function modificaModaleMetadatiDocFad(toOpenDett, idFad){
	$("#divErrore").empty();	
	
	$.ajax({
		
		url: "<%=request.getContextPath()%><%=ConstantsRequestMapping.MODALI_DOCUMENTI_FAD%>?cmdPOST___modaleMetadatiDocumentiFad=modaleMetadatiDocumentiFad&idFad="+idFad ,
		
	    type: 'POST',
	    data: {
	        json: jsonData
	    },
	    success: function (response) { 
	        var trHTMLdett = '';
	        var trHTMLdettTit = '';
	    	 
	        var comboHTML = '';
	    	   
	  	  $.each(response, function (i, articleDett) {
	  		if(articleDett.title=='ERRORE'){
		  	
	  			 trHTMLdett='';
	  			 trHTMLdettTit = '';
				$("#metadatiFascicoloFad").append("<div class=rowD  align=center><strong>Errore nel recupero dei dati  </strong></div>");
			}else {

				size2=$("#title_modal_0").length;
				if( size2>0  ) {	
					$("#title_modal_0").empty();
				}

 		  	    trHTMLdettTit='<div id=title_modal_1 class=bg-tono0><strong>Documento Fad: '+ articleDett.descFilename + '</strong></div>';
 		  	    
 		  	    $("#title_modal_0").append(trHTMLdettTit);
	 		  		 		  	
	 		  	comboHTML = '<strong>Descrizione: </strong><form:select path="modaleUpdFadDesc" id="mySelect" ><form:option value="" label="-- Selezionare una descrizione --" />'
	 		  	
 		  		for(var index = 0; index < articleDett.listaDescDocumenti.length; index++){
 		  			comboHTML += '<form:option value="'+ articleDett.listaDescDocumenti[index].id  + '" onClick="myFunction('+articleDett.listaDescDocumenti[index].flagVisibilitaCdc+')">' + articleDett.listaDescDocumenti[index].textDescrizione + '</form:option>';
 		  		}
	 		  	
	 		  	comboHTML += '</form:select>';
	 		  	$('#comboDesc').empty();
	 		  	$('#comboDesc').append(comboHTML);
	 		  	
	 		   document.getElementById("mySelect").value =articleDett.descDocumento.id;
	 		   document.getElementById("visibilita").value =articleDett.flagVisibilitaCdc01;
	 		   <% if (!"true".equalsIgnoreCase(modVisibilita.toString())) { %>
 	 		   		document.getElementById("visibilitaHidden").value =articleDett.flagVisibilitaCdc01;
 	 		   <% } %>

			}
	  		
	 
	  	});


	  	apriPopUpModale(toOpenDett);
		
	},

	
    error: function(){
    	
 			$("#metadatiFascicoloFad").append("<div class=rowD align=center><strong>Errore nel recuperare i dati</strong></div>");
			 
			apriPopUpModale(toOpenDett);
    } 

	});


}



function confermaModaleDett() {

	$('.overlay').fadeOut('fast');
    $('.box').hide();
	$('.box_meta').hide();
}



</script>

 
 <%--**INIZIO MODALE--%>
 <div>
	<div id="contModal_0" class="box_meta">
		<div  id="title_modal_0" > </div>
		
		<div>
			<!-- MODAL TABLE-->
			<div id="contentD">
			    <div class="portletContentD" id="metadatiFascicoloFad">

					<%-- descrizione --%>				
					<div class="rowD" id="comboDesc">
<		  		    	
	  		    	</div>
	  		    	
	  		    	<%-- visibilita --%>
					<c:if test="${modVisibilita}">
						<div class="rowD">
			  		    	<strong>Visibilità Corte dei conti: </strong>
							<form:select path="modaleUpdFadVisibilita" id="visibilita">
			  					<c:forEach var="vis" items="${visibilitaCdc}" >
									<form:option value="${vis.code}">${vis.description}</form:option>
								</c:forEach>
							</form:select>
<%-- 			  		    	<form:select path="modaleUpdFadVisibilita" id="visibilita">
			  		    		<form:option value="0" label="Non visibile" />
			  		    		<form:option value="1" label="Visibile" />
			  		    	</form:select>				 --%>
						</div>
					</c:if>			
					
					<c:if test="${modVisibilita ne true}">
						<div class="rowD">
						<%-- <form:hidden path="modaleUpdFadVisibilita"/> --%>
			  		    	<strong>Visibilità Corte dei conti: </strong>
							<form:select path="modaleUpdFadVisibilita" id="visibilita" disabled="true">
			  					<c:forEach var="vis" items="${visibilitaCdc}" >
									<form:option value="${vis.code}">${vis.description}</form:option>
								</c:forEach>
							</form:select>
<%-- 			  		    	<form:select path="modaleUpdFadVisibilita" disabled="true" id="visibilita"> 
			  		    		<form:option value="0" label="Non visibile" />
			  		    		<form:option value="1" label="Visibile" />
			  		    	</form:select> --%>
			  		     <form:hidden path="modaleUpdFadVisibilita" id="visibilitaHidden"/>
						</div>							
					</c:if>		
					
				</div>
			</div>
			
			<div class="spacer_sm">&nbsp;</div>
		</div>
		
		<div class="text-center">
			<demdec:submit 
					keyValue="button.fad.modificaMetadati" 
					controllerCode="modificaMetadatiDocFad"/>
			<button type="button" class="button small " onClick="javascript:confermaModaleDett();">Torna alla lista</button>
		</div>
		
		<p class="chiudi">Chiudi X</p>
	</div>
</div>
    
<!-- END MODALE Metadati Fascicolo Fad-->  
      