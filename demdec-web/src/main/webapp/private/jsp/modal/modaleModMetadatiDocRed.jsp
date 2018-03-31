
  <!-- INIZIO MODALE Metadati Documento Red -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%-- <demdec:useAttribute id="descDocRedList"         name="<%=WebConstants.LIST_DESC_DOCUMENTI%>" /> --%>
<demdec:useAttribute id="tipoDocRedList"         name="<%=WebConstants.LIST_TIPO_DOC_RED%>" /> 
<demdec:useAttribute id="visibilitaCdc"         name="<%=WebConstants.LIST_VISIBILITA_CDC%>" /> 
<demdec:useAttribute id="modVisibilita"	    name="<%=WebConstants.CHK_MODIFICA_VISIBILITA%>" />

 <script type="application/javascript">

 function myFunction(y) {
		
	    document.getElementById("visibilita").value = y;
	    
	   <% if (!"true".equalsIgnoreCase(modVisibilita.toString())) { %>
	    <%-- per passare la visibilit� in caso di select impostata a disabled==true --%>
	    document.getElementById("visibilitaHidden").value = y;
	   <% } %>
	    
	}

function modificaModaleMetadatiDocRed(toOpenDett, idRed){
 	size=$("#metadatiFascicoloFad").length ;	
	if( size>0  ) {	
		$("#metadatiFascicoloFad").empty();
	}
 

	//$("#divErrore").empty();	
	
	$.ajax({
		
		url: "<%=request.getContextPath()%><%=ConstantsRequestMapping.MODALI_DOCUMENTI_RED%>?cmdPOST___modaleModMetadatiDocumentiRed=modaleModMetadatiDocumentiRed&idRed="+idRed ,
		
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
				$("#metadatiFascicoloRed").append("<div class=rowD  align=center><strong>Errore nel recupero dei dati  </strong></div>");
			}else {

				size2=$("#title_modal_0").length;
				if( size2>0  ) {	
					$("#title_modal_0").empty();
				}
				
 		  	    trHTMLdettTit='<div id=title_modal_1 class=bg-tono0><strong>Documento Red: '+ (articleDett.descFilename==null?'': articleDett.descFilename) + '</strong></div>';
		  		
  				 $("#title_modal_0").append(trHTMLdettTit);
				
				comboHTML = '<strong>Descrizione: </strong><form:select path="modaleUpdRedDescDoc" id="mySelect">'
		 		  	
	 		  		for(var index = 0; index < articleDett.listaDescDocumenti.length; index++){
	 		  			comboHTML += '<form:option value="'+ articleDett.listaDescDocumenti[index].id  + '" onClick="myFunction('+ articleDett.listaDescDocumenti[index].flagVisibilitaCdc+')">' + articleDett.listaDescDocumenti[index].textDescrizione + '</form:option>';
	 		  		}
		 		  	
		 		  	comboHTML += '</form:select>';
		 		  	$('#comboDescRed').empty();
		 		  	$('#comboDescRed').append(comboHTML);
		 		  	$('#modaleUpdRedDescDoc').val(articleDett.descDocumento.id + articleDett.descDocumento.flagVisibilitaCdc);<%-- + articleDett.descDocumento.flagVisibilitaCdc --%>
				
		 		  	document.getElementById("mySelect").value =articleDett.descDocumento.id;
			 		document.getElementById("visibilita").value =articleDett.flagVisibilitaCdc01;	
		 		   <% if (!"true".equalsIgnoreCase(modVisibilita.toString())) { %>
	 	 		   		document.getElementById("visibilitaHidden").value =articleDett.flagVisibilitaCdc01;
	 	 		   <% } %>
			 		
			
			}
					
				$("#modaleUpdRedVisibilitaCdc").val(articleDett.flagVisibilitaCdc01);
				$("#modaleUpdRedVisibilitaCdcOrig").val(articleDett.flagVisibilitaCdc01);
				<%--alert($("#modaleUpdRedVisibilitaCdcOrig").val());--%>
	  	});

	  	apriPopUpModale(toOpenDett);
		
	},

    error: function(){
 			$("#metadatiFascicoloRed").append("<div class=rowD align=center><strong>Errore nel recuperare i dati</strong></div>");
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
 
 <%--**INIZIO MODALE --%>
 <div>
	<div id="contModalMod_0" class="box_meta">
		<div  id="title_modal_0" > </div>
		
		<div>
			<!-- MODAL TABLE-->
			<div id="contentD">
				<div class="portletContentD" id="metadatiFascicoloRed">
					
					<%-- <div class="rowD">
		  				<strong>Tipo: </strong> Metadati Documento RED 
		  			</div>
		  		    
		  		    <form:hidden path="modaleUpdRedDescDocOrig"/>
		  		    <div class="rowD">
		  		    	<strong>Tipo Documento: </strong>
		  		    	<form:select path="modaleUpdRedTipoDoc" disabled="true">
		  					<c:forEach var="item" items="${tipoDocRedList}" >
								<form:option value="${item.id}">${item.id} - ${item.descDescrizioneDoc}</form:option>
							</c:forEach>
						</form:select>
					</div>
					 --%>
					
					<div class="rowD" id="comboDescRed">
					
					</div>
				    
					<c:if test="${modVisibilita}">
						<div class="rowD">
							<strong>Visibilit� Corte dei conti: </strong>
							<form:select path="modaleUpdRedVisibilitaCdc" id="visibilita">
			  					<c:forEach var="vis" items="${visibilitaCdc}" >
									<form:option value="${vis.code}">${vis.description}</form:option>
								</c:forEach>
							</form:select>
						</div>
						
					</c:if>					
                    <c:if test="${!modVisibilita}">
						<div class="rowD">
							<strong>Visibilit� Corte dei conti: </strong>
							<form:select path="modaleUpdRedVisibilitaCdc" disabled="true" id="visibilita">
			  					<c:forEach var="vis" items="${visibilitaCdc}" >
									<form:option value="${vis.code}">${vis.description}</form:option>
								</c:forEach>
							</form:select>
							<form:hidden path="modaleUpdRedVisibilitaCdc" id="visibilitaHidden"/>
					</div>
					</c:if>	
				</div>
			</div>
			
			<div class="spacer_sm">&nbsp;</div>
		</div>
		
		<div class="text-center">
			<demdec:submit 
					keyValue="button.fad.modificaMetadati"
					controllerCode="modificaMetadatiDocRed" 
					titleKey="button.fad.modificaMetadati" />
			<button type="button" class="button small " onClick="javascript:confermaModaleDett();">Torna alla lista</button>
		</div>
		
		<p class="chiudi">Chiudi X</p>
	</div>
</div>
    
<!-- END MODALE Mod Metadati documenti Red-->  
      
