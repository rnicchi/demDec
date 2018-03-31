
 <!-- INIZIO MODALE Visualizzazione Metadati Documento Fad -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <script type="application/javascript">

 //conversione di una data dal formato Date nel formato dd/MM/yyyy
 function convertDate(inputFormat) {
	  function pad(s) { return (s < 10) ? '0' + s : s; }
	  var d = new Date(inputFormat);
	  return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
 }

 function visualizzaModaleMetadatiDocRed(toOpenDett, idRed){

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
		
		 
		url: "<%=request.getContextPath()%><%=ConstantsRequestMapping.MODALI_DOCUMENTI_RED%>?cmdPOST___modaleMetadatiDocumentiRed=modaleMetadatiDocumentiRed&idRed="+idRed ,
		
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
				trHTMLdettTit='<div class=bg-tono0 id=title_modal_2><strong>Allegato al Sottofascicolo IGB/RED</strong></div>';
		  	
 			    trHTMLdett= '<tr><td><strong>Tipo Documento:&nbsp;</strong></td><td>' + ( (articleDett.tipoDocumento==null || articleDett.tipoDocumento.descDescrizioneDoc==null)?'':articleDett.tipoDocumento.descDescrizioneDoc )+ '</td></tr>'+

		 			   		'<tr><td><strong>Descrizione:&nbsp;</strong></td><td>' + ( (articleDett.descDocumento==null || articleDett.descDocumento.textDescrizione==null)?'':articleDett.descDocumento.textDescrizione )+ '</td></tr>'+
		 			   		//'<tr><td><strong>Protocollo Ingresso:  </strong></td><td>' + ( articleDett.numeProtocollo==null?'':articleDett.numeProtocollo) + '</td></tr>'+
		 			   	 // '<tr><td><strong>Data Protocollo Ingresso:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.dataRed==null)?'':convertDate(articleDett.sottoFascicoliRed.dataRed) ) + '</td></tr>'+
		 			   	' <tr><td><strong>Protocollo :  </strong></td><td>' +   (  articleDett.numeProtocollo==null?'': (articleDett.numeProtocollo+' - '))
				 			   													  + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.dataRedFormatted==null)?'':articleDett.sottoFascicoliRed.dataRedFormatted )
				 			   													 
				 			   													 + '</td></tr>'+
				  		

		 					'<tr><td><strong>Amministrazione:  </strong></td><td>' + ( (articleDett.anagAmminDem==null || articleDett.anagAmminDem.descAmm==null)?'':articleDett.anagAmminDem.descAmm) + '</td></tr>'+		    		  	
									
							'<tr><td><strong>UCB / RTS: </strong></td><td>' + ( (articleDett.anagRagionerieDem==null || articleDett.anagRagionerieDem.descRag==null)?'':articleDett.anagRagionerieDem.descRag) + '</td></tr>'+		    		  	
									
						  /*  '<tr><td><strong>Utente Assegnatario:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.descUtenteAss==null)?'':articleDett.sottoFascicoliRed.descUtenteAss) + '</td></tr>'+
						    '<tr><td><strong>Ufficio Associato Red:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.descUfficioAss==null)?'':articleDett.sottoFascicoliRed.descUfficioAss) + '</td></tr>'+
				
						    '<tr><td><strong>Oggetto Red:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.descOggettoRed==null)?'':articleDett.sottoFascicoliRed.descOggettoRed) + '</td></tr>'+
				
						    '<tr><td><strong>Id Red:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.id==null
								    || articleDett.sottoFascicoliRed.id.codiIdRed==null)?'':articleDett.sottoFascicoliRed.id.codiIdRed) + '</td></tr>'+
				
							'<tr><td><strong>Esercizio Finanziario:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
									    || articleDett.sottoFascicoliRed.fascicoli.eserciziDem==null || articleDett.sottoFascicoliRed.fascicoli.eserciziDem.id==null)?'':
									    	 articleDett.sottoFascicoliRed.fascicoli.eserciziDem.id) + '</td></tr>'+
							*/
							'<tr><td><strong>Tipo flusso:  </strong></td><td>' + ( articleDett.descTipoFlusso==null?'':articleDett.descTipoFlusso) + '</td></tr>'+
				
						/* 	'<tr><td><strong>Ufficio Creatore:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
									    || articleDett.sottoFascicoliRed.fascicoli.ufficioCreatore==null || articleDett.sottoFascicoliRed.fascicoli.ufficioCreatore.descUfficio==null)?'':
									    	articleDett.sottoFascicoliRed.fascicoli.ufficioCreatore.descUfficio) + '</td></tr>'+
				
					    	'<tr><td><strong>Data Creazione FAD:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
								    || articleDett.sottoFascicoliRed.fascicoli.dataCreazioneFascicolo==null)?'':convertDate(articleDett.sottoFascicoliRed.fascicoli.dataCreazioneFascicolo) ) + '</td></tr>'+		    		  	
				
						    '<tr><td><strong>Utente Creatore FAD:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
								    || articleDett.sottoFascicoliRed.fascicoli.descUtenteCreatore==null)?'':articleDett.sottoFascicoliRed.fascicoli.descUtenteCreatore) + '</td></tr>'+		    		  	
				         */
				
							/*  '<tr><td><strong>Ufficio Capofila:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
									    || articleDett.sottoFascicoliRed.fascicoli.ufficioCapofila==null || articleDett.sottoFascicoliRed.fascicoli.ufficioCapofila.descUfficio==null)?'':
									    	articleDett.sottoFascicoliRed.fascicoli.ufficioCapofila.descUfficio) + '</td></tr>'+
				 
							'<tr><td><strong>Tipologia Decreto:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
									    || articleDett.sottoFascicoliRed.fascicoli.anagTipologiaDecreto==null || articleDett.sottoFascicoliRed.fascicoli.anagTipologiaDecreto.descTipologia==null)?'':
									    	articleDett.sottoFascicoliRed.fascicoli.anagTipologiaDecreto.descTipologia) + '</td></tr>'+
				
					    	 '<tr><td><strong>Tipo Decreto:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
									    || articleDett.sottoFascicoliRed.fascicoli.anagTipoDecreto==null || articleDett.sottoFascicoliRed.fascicoli.anagTipoDecreto.descTesto==null)?'':
									    	articleDett.sottoFascicoliRed.fascicoli.anagTipoDecreto.descTesto) + '</td></tr>'+
				
					    	'<tr><td><strong>Numero Decreto:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
								    || articleDett.sottoFascicoliRed.fascicoli.numeNumDecreto==null)?'':articleDett.sottoFascicoliRed.fascicoli.numeNumDecreto) + '</td></tr>'+		    		  	
								    
						    '<tr><td><strong>Stato documento:  </strong></td><td>' + ( articleDett.descStatoDocumento==null?'':articleDett.descStatoDocumento) + '</td></tr>'+
						   
						    '<tr><td><strong>Sistema:  </strong></td><td> &nbsp;</td></tr>'+
						    */
						    '<tr><td><strong>Data aggiornamento:  </strong></td><td>' + ( articleDett.dataAggiornamento==null?'':convertDate(articleDett.dataAggiornamento) ) + '</td></tr>'+
						  		
						    '<tr><td><strong>Aggiornato da:   </strong></td><td>' + ( articleDett.rowUpdatedUser==null?'':articleDett.rowUpdatedUser ) + '</td></tr>'+
							  	
						    '<tr><td><strong>VisibilitÓ CDC:  </strong></td><td>' + ( articleDett.descVisibilitaCdc01==null?'':articleDett.descVisibilitaCdc01) + '</td></tr>'+
				
						   /*  '<tr><td><strong>Data presa carico CDC:  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
								    || articleDett.sottoFascicoliRed.fascicoli.dataPresaCaricoCdc==null)?'':convertDate(articleDett.sottoFascicoliRed.fascicoli.dataPresaCaricoCdc) ) + '</td></tr>'+		    		  	
				
						    '<tr><td><strong>Protocollo ricezione CDC  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
								    || articleDett.sottoFascicoliRed.fascicoli.numeProtRicezioneCdc==null)?'':articleDett.sottoFascicoliRed.fascicoli.numeProtRicezioneCdc) + '</td></tr>'+		    		  	
				
							'<tr><td><strong>Data ricezione CDC  </strong></td><td>' + ( (articleDett.sottoFascicoliRed==null || articleDett.sottoFascicoliRed.fascicoli==null
										    || articleDett.sottoFascicoliRed.fascicoli.dataRicezioneCdc==null)?'':convertDate(articleDett.sottoFascicoliRed.fascicoli.dataRicezioneCdc) ) + '</td></tr>'+		    		  	
						     */
					  		'<tr><td><strong>Data Creazione:  </strong></td><td>' + ( articleDett.dataArrivoFormatted==null?'':articleDett.dataArrivoFormatted) + '</td></tr>'+
					  		/* '<tr><td><strong>Stato Conversione:   </strong></td><td>' + ( articleDett.statConversione==null?'':articleDett.statConversione) +  '</td></tr>'+
					  		'<tr><td><strong>Esito Conversione:   </strong></td><td>'  + ( articleDett.statEsitoConversione==null?'':articleDett.statEsitoConversione) +  '</td></tr>';
					  		 */		  		
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
      

