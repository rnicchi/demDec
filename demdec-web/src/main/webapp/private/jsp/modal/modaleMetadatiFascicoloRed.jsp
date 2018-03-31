
  <!-- INIZIO MODALE DETT DOCUMENTO -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <script type="application/javascript">


function caricaModaleDettFascRed(toOpenDett, idFasc){

	size=$("#divErroreRed").length ;	
	if( size>0  ) {	
		$("#divErroreRed").empty();
	}

	size2=$("#title_modal_7").length ;
	if( size2>0  ) {	
		$("#title_modal_7").empty();
	}

	leng= this.document.getElementById("tabellaDettaglio7").rows.length;
 	
	if(leng>0){				
		$("#tabellaDettaglio7 tr").remove();		
	} 
	
	$("#divErroreRed").empty();	


	$.ajax({
		
		url: "<%=request.getContextPath() %><%=ConstantsRequestMapping.MODALI_FAD%>?cmdPOST___modalemetadatiFascicoloRed=modalemetadatiFascicoloRed&NumFasc="+idFasc ,
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
				trHTMLdett =  
							/* '<tr><td><strong>Protocollo Ingresso:  </strong></td><td>' + (articleDett.numeProtocollo==null?'':articleDett.numeProtocollo) + '</td></tr>'+
							'<tr><td><strong>Data Protocollo Ingresso:  </strong></td><td>' + (articleDett.dataRedFormatted==null?'':articleDett.dataRedFormatted) + '</td></tr>'+
 */
							' <tr><td><strong>Protocollo :  </strong></td><td>' +  ( (articleDett.descTipoProtocollo==null?'':(articleDett.descTipoProtocollo+ ' - ') )+articleDett.numeProtocollo+' - '+ (articleDett.dataRedFormatted==null?'':articleDett.dataRedFormatted) ) + '</td></tr>'+
					  		
							'<tr><td><strong>Id Red:  </strong></td><td>' +(articleDett.id.codiIdRed==null?'':articleDett.id.codiIdRed) + '</td></tr>'+
							//'<tr><td><strong>Tipo: </strong></td><td> Sottofascicolo UCB-RED associato a Decreto </div>'+
							'<tr><td><strong>Oggetto Red: </strong></td><td>' +(articleDett.descOggettoRed==null?'':articleDett.descOggettoRed) + '</td></tr>'+
							'<tr><td><strong>Amministrazione: </strong></td><td>' + (articleDett.anagAmminDem.descAmm==null?'':articleDett.anagAmminDem.descAmm) + '</td></tr>'+
							'<tr><td><strong>UCB / RTS: </strong></td><td>' + ( (articleDett.anagRagionerieDem.descRag==null || articleDett.anagRagionerieDem.id.numeRag==9999)?'':articleDett.anagRagionerieDem.descRag) + '</td></tr>'+
							'<tr><td><strong>Utente Assegnatario: </strong></td><td>' + (articleDett.descUtenteAss==null?'':articleDett.descUtenteAss) + '</td></tr>'+
							'<tr><td><strong>Ufficio Associato: </strong></td><td>' + (articleDett.descUfficioAss==null?'':articleDett.descUfficioAss) + '</td></tr>'+
							'<tr><td><strong>Data Creazione:  </strong></td><td>' + (articleDett.dataArrivoFormatted==null?'':articleDett.dataArrivoFormatted) + '</td></tr>'+
							'<tr><td><strong>Tipo Flusso:  </strong></td><td>' + (articleDett.descTipoFlusso==null?'':articleDett.descTipoFlusso) + '</td></tr>'+
							//'<tr><td><strong>Stato Fascicolo Documentale: </strong></td><td>' + (articleDett.descStato==null?'':articleDett.descStato) + '</td></tr>'+
							/* '<tr><td><strong>Sistema:  </strong></td><td>' + ( articleDett.sistemaProduttore==null?'':articleDett.sistemaProduttore) + '</td></tr>'+ */
							'<tr><td><strong>Data Aggiornamento:  </strong></td><td>' + ( articleDett.dataAggiornamento==null?'':convertDate(articleDett.dataAggiornamento) ) + '</td></tr>'+
							'<tr><td><strong>Aggiornato da:  </strong></td><td>' + ( articleDett.rowUpdatedUser==null?'':articleDett.rowUpdatedUser) + '</td></tr>';
		 
  				$("#title_modal_7").append(trHTMLdettTit);	
  				$("#tabellaDettaglio7").append(trHTMLdett);

  			
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
     <div id="contModal_7" class="box_meta" >
        
        <div id="title_modal_7"></div>
        
    	<div>
             
      	  <div id='divErroreRed'></div>
       
            <!--INI SCROLL-->
         	<div>          
                            <!-- MODAL TABLE-->             
	          <div class="width100">
	                 <table  class="marg_0px_auto width100" id="tabellaDettaglio7" > 
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
      

