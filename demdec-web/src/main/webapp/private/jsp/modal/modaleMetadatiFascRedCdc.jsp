
  <!-- INIZIO MODALE DETT DOCUMENTO -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <script type="application/javascript">


function caricaModaleFascRedCdc(toOpenDett, idFasc){

	size=$("#divErroreRed").length ;	
	if( size>0  ) {	
		$("#divErroreRed").empty();
	}

	size2=$("#title_modal_02").length ;
	if( size2>0  ) {	
		$("#title_modal_02").empty();
	}

	leng= this.document.getElementById("tabellaDettaglio5").rows.length;
 	
	if(leng>0){				
		$("#tabellaDettaglio5 tr").remove();		
	} 
	
	$("#divErroreRed").empty();	


	$.ajax({
		
		url: "<%=request.getContextPath() %><%=ConstantsRequestMapping.CONSULTA_FASCICOLO_CDC_MODALI%>?cmdPOST___modaleMetadatiRedCdc=modaleMetadatiRedCdc&NumFasc="+idFasc ,
			
	    type: 'POST',
	    data: {
	        json: jsonData
	    },
	    success: function (response) { 
	        var trHTMLdett = '';
	        var trHTMLdettTit = '';
	  

	  	  $.each(response, function (i, articleDett) {

	  		if(articleDett.warningCode=='ERRORE'){
	  			 
	  			 trHTMLdett='';
	  			 trHTMLdettTit = '';
				$("#divErroreRed").append("<div class=rowD  align=center><strong>Errore nel recupero dei dati  </strong></div>");
			}else {
	
				trHTMLdettTit='<div id=title_modal_2 class=bg-tono0><strong>Sottofascicolo IGB/RED</strong></div>';
		  		
		  		trHTMLdett =  '<tr><td><strong>Tipo: </strong></td><td> Raccolta Provvisoria UCB-RED Pre Apertura Decreto </td></tr>'+
		  			' <tr><td><strong>Oggetto Red: </strong></td><td>' +articleDett.descrizione + '</td></tr>'+
			  		' <tr><td><strong>Amministrazione: </strong></td><td>' + articleDett.amministrazione.description + '</td></tr>'+
			  		/* ' <tr><td><strong>UCB / RTS: </strong></td><td>' + articleDett.ragioneria.description + '</td></tr>'+ */
			  		' <tr><td><strong>Utente Assegnatario: </strong></td><td>' + articleDett.utenteCreatore.description + '</td></tr>'+
			  		' <tr><td><strong>Ufficio Associato: </strong></td><td>' + articleDett.ufficioCreatoreRED.description + '</td></tr>'+
			  		'<tr><td><strong>Data Red:  </strong></td><td>' + articleDett.dataAggiornamento +'</td></tr>'+//è la data del protocollo
			  		//'<tr><td><strong>Data Red:  </strong></td><td>' + ' ' + '</td></tr>'+		  		
		  		     '<tr><td><strong>Id Red:  </strong></td><td>' +articleDett.identificativoRaccoltaProvvisoria + '</td></tr>'+
		  		   '<tr><td><strong>Protocollo Red:  </strong></td><td>' + articleDett.protocollo.numeroProtocollo + '</td></tr>'+
					 '<tr><td><strong>Data Arrivo:  </strong></td><td>' + articleDett.dataCreazione + '</td></tr>'+
	  				 '<tr><td><strong>Tipo Flusso:  </strong></td><td>' + articleDett.tipoFlusso + '</td></tr>';
	  				/*'<tr><td><strong>Stato Fascicolo Documentale: </strong></td><td>' + articleDett.codiStatoFascicoloDocumentale + '</td></tr>';*/
	  				
  				$("#title_modal_02").append(trHTMLdettTit);	
  				$("#tabellaDettaglio5").append(trHTMLdett);

  			
			}
	  		
	 
	  	});

	  	
	  	apriPopUpModale(toOpenDett);
		
	},

	
    error: function(){
    	
			$("#divErroreRed").append("<div class=rowD align=center><strong>Errore nel recupero dei dati</strong></div>");
			 
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

 <demdec:useAttribute id="titoloModaleDett" name="<%=WebConstants.TITOLO_MODALE_DETTAGLIO%>"/>
 
 <%--**INIZIO MODALE--%>
   <div>
     <div id="contModal_02" class="box_meta" >
        
        <div id="title_modal_02"></div>
        
    	<div>
             
      	  <div id='divErroreRed'></div>
       
            <!--INI SCROLL-->
         	<div>          
                            <!-- MODAL TABLE-->             
	          <div class="width100">
	                 <table  class="marg_0px_auto width100" id="tabellaDettaglio5" > 
	                  <caption><span class="nascosto">Tabella Dettaglio</span></caption>  
	                 
	                   		
	                 </table>            
	           </div>
       		 </div>
        <!--END SCROLL-->

        <div class="spacer_sm">&nbsp;</div>

    </div>

     <div class="text-center">
    
     <button type="button" class="button small " onClick="javascript:confermaModaleDett();">Torna alla lista</button>
	
    </div>

<p class="chiudi">Chiudi X</p>

</div>
      
</div>
    
    
<!-- END MODALE DETT FASCICOLO-->  
      

