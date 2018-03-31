
 <!-- INIZIO MODALE Visualizzazione Metadati Documento Fad -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <script type="application/javascript">

function visualizzaModaleMetadatiDocFad(toOpenDett, idFad){

	size=$("#divErroreDett").length ;	
	if( size>0  ) {	
		$("#divErroreDett").empty();
	}

	size2=$("#title_modal_3").length ;
	if( size2>0  ) {	
		$("#title_modal_3").empty();
	}

	leng= this.document.getElementById("tabellaDettaglio2").rows.length;
 	
	if(leng>0){				
		$("#tabellaDettaglio2 tr").remove();		
	} 
	
	$("#divErroreDett").empty();	


	$.ajax({
		
		 
		url: "<%=request.getContextPath()%><%=ConstantsRequestMapping.MODALI_DOCUMENTI_FAD%>?cmdPOST___modaleMetadatiDocumentiFad=modaleMetadatiDocumentiFad&idFad="+idFad ,
		
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
				$("#divErroreDett").append("<div class=rowD  align=center><strong>Errore nel recupero dei dati  </strong></div>");
			}else {
				trHTMLdettTit='<div class=bg-tono0 id=title_modal_2><strong>Allegato al Sottofascicolo Atto Decreto</strong></div>';
		  	
  trHTMLdett =  '<tr><td><strong>Tipo Documento:&nbsp;</strong></td><td>' + ( (articleDett.tipoDocumento==null || articleDett.tipoDocumento.descDescrizioneDoc==null)?'':articleDett.tipoDocumento.descDescrizioneDoc)+ '</td></tr>'+
		  		'<tr><td><strong>Descrizione documento: </strong></td><td>' + ( (articleDett.descDocumento == null || articleDett.descDocumento.textDescrizione == null)?'': articleDett.descDocumento.textDescrizione) + '</td></tr>'+
		  		'<tr><td><strong>Amministrazione: </strong></td><td>' +( (articleDett.fascicoli==null || articleDett.fascicoli.amministrazioneModale==null)?'':articleDett.fascicoli.amministrazioneModale) + '</td></tr>'+
				'<tr><td><strong>UCB / RTS: </strong></td><td>' +( (articleDett.fascicoli==null || articleDett.fascicoli.ragioneriaModale==null)?'':articleDett.fascicoli.ragioneriaModale) + '</td></tr>'+
		  	   // '<tr><td><strong>Titolo:  </strong></td><td>' + ( articleDett.numeTitolo==null?'':articleDett.numeTitolo) + '</td></tr>'+
		//		'<tr><td><strong>Tipo flusso:  </strong></td><td>' + ( articleDett.descTipoFlusso==null?'':articleDett.descTipoFlusso) + '</td></tr>'+
			   // 	'<tr><td><strong>Metodo firma: </strong></td><td>' + ( (articleDett.anagMetodoFirma == null || articleDett.anagMetodoFirma.descMetodoFirma == null)?'': articleDett.anagMetodoFirma.descMetodoFirma) + '</td></tr>'+
			  	'<tr><td><strong>Ufficio Creatore: </strong></td><td>' + ( (articleDett.fascicoli == null || articleDett.fascicoli.ufficioCreatore == null || articleDett.fascicoli.ufficioCreatore.descUfficio==null)?'':articleDett.fascicoli.ufficioCreatore.descUfficio) + '</td></tr>'+
			  	'<tr><td><strong>Utente Creatore: </strong></td><td>' + ( (articleDett.fascicoli == null || articleDett.fascicoli.descUtenteCreatore == null)?'': articleDett.fascicoli.descUtenteCreatore) + '</td></tr>'+
			  	'<tr><td><strong>Data Creazione:  </strong></td><td>' + ( articleDett.dataArrivoFormatted==null?'':articleDett.dataArrivoFormatted) + '</td></tr>'+
		  		//'<tr><td><strong>Ufficio capofila: </strong></td><td>' + ( (articleDett.fascicoli == null || articleDett.fascicoli.ufficioCapofila == null || articleDett.fascicoli.ufficioCapofila.descUfficio == null)?'': articleDett.fascicoli.ufficioCapofila.descUfficio) + '</td></tr>'+
		  		/* '<tr><td><strong>Tipo decreto: </strong></td><td>' + ( (articleDett.fascicoli == null || articleDett.fascicoli.anagTipoDecreto == null ||  articleDett.fascicoli.anagTipoDecreto.descSigla == null)?'': articleDett.fascicoli.anagTipoDecreto.descSigla) + '</td></tr>'+
		  		'<tr><td><strong>Numero decreto: </strong></td><td>' + ( (articleDett.fascicoli == null || articleDett.fascicoli.numeNumDecreto == null)?'':articleDett.fascicoli.numeNumDecreto) + '</td></tr>'+
		  		'<tr><td><strong>Tipologia decreto: </strong></td><td>' + ( (articleDett.fascicoli == null || articleDett.fascicoli.anagTipologiaDecreto == null ||  articleDett.fascicoli.anagTipologiaDecreto.descTipologia == null)?'': articleDett.fascicoli.anagTipologiaDecreto.descTipologia) + '</td></tr>'+
*/				 '<tr><td><strong>Utente modifica: </strong></td><td>' + (articleDett.fkCodiUtenteAgg == null ?'': articleDett.fkCodiUtenteAgg) +'</td></tr>'+
	           '<tr><td><strong>Data modifica documeto: </strong></td><td>' + (articleDett.dataAggiornamento == null ? '':convertDate(articleDett.dataAggiornamento ) )+ '</td></tr>'+
		  		//'<tr><td><strong>Modificato Da: </strong></td><td>' + ((articleDett.fascicoli == null || articleDett.fascicoli.descUtenteModifica == null)?'': articleDett.fascicoli.descUtenteModifica) +'</td></tr>'+
				'<tr><td><strong>Stato Documento:  </strong</td><td>' + ( articleDett.descStatDocumento==null?'':articleDett.descStatDocumento) + '</td></tr>'+
		  		'<tr><td><strong>Stato Conversione:  </strong></td><td>' + ( articleDett.statConversione==null?'':articleDett.statConversione) + '</td></tr>'+
			  	'<tr><td><strong>Esito Conversione:  </strong</td><td>' + ( articleDett.statEsitoConversione==null?'':articleDett.statEsitoConversione) + '</td></tr>';
			

				  	/* 	'<tr><td><strong>Visibilità Cdc: </strong></td><td>' + (articleDett.flagVisibilitaCdc01 == null ?'': articleDett.flagVisibilitaCdc01) +'</td></tr>'+
		  		'<tr><td><strong>Data presa in carico Cdc:  </strong></td><td>' + ( (articleDett.fascicoli == null || articleDett.fascicoli.dataPresaCaricoCdc == null)?'': articleDett.fascicoli.dataPresaCaricoCdc) + '</td></tr>' +
		  		'<tr><td><strong>Protocollo ricezione Cdc:  </strong></td><td>' + ( (articleDett.fascicoli == null || articleDett.fascicoli.numeProtRicezioneCdc == null)?'': articleDett.fascicoli.numeProtRicezioneCdc) + '</td></tr>' +
		  		'<tr><td><strong>Data ricezione Cdc:  </strong></td><td>' + ( (articleDett.fascicoli == null || articleDett.fascicoli.dataRicezioneCdc == null)?'': articleDett.fascicoli.dataRicezioneCdc) + '</td></tr>';
				 */
		  		
		  		<%--' <div class=rowD><strong>Utente Assegnatario: </strong>' + ( articleDett.fascicoli.descUtenteCreatore==null?'':articleDett.fascicoli.descUtenteCreatore) + '</div>';--%>		  		
		  		
				
  				$("#title_modal_3").append(trHTMLdettTit);	
  				$("#tabellaDettaglio2").append(trHTMLdett);
			}
	  		
	 
	  	});

	  	apriPopUpModale(toOpenDett);
		
	},

	
    error: function(){
    	
			$("#divErroreDett").append("<div class=rowD align=center><strong>Errore nel recupero dei dati</strong></div>");
			 
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
   
    <!--<div class="overlay"></div>-->
      
    <div id="contModalVis_0" class="box_meta" >
        
        <div id="title_modal_3"></div>
        
    <div>
             
        <div id='divErroreDett'></div>
       
            <!--INI SCROLL-->
             <div class="scroll_table_modal_400" >          
                            <!-- MODAL TABLE-->             
          <div class="width100">
                 <table  class="marg_0px_auto width100" id="tabellaDettaglio2" > 
                 
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
    
    
<!-- END MODALE Metadati Fascicolo Fad--> 
      

