
  <!-- INIZIO MODALE DETT DOCUMENTO -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <script type="application/javascript">

 //conversione di una data dal formato Date nel formato dd/MM/yyyy
 function convertDate(inputFormat) {
	  function pad(s) { return (s < 10) ? '0' + s : s; }
	  var d = new Date(inputFormat);
	  return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
 }

function visualizzaModaleMetadatiDocPat(toOpenDett, idPat){

	
	size=$("#divErroreDett").length ;	
	if( size>0  ) {	
		$("#divErroreDett").empty();
	}

	size2=$("#title_modal_0").length ;
	if( size2>0  ) {	
		$("#title_modal_0").empty();
	}

	leng= this.document.getElementById("tabellaDettaglio2").rows.length;
 	
	if(leng>0){				
		$("#tabellaDettaglio2 tr").remove();		
	} 
	
	$("#divErroreDett").empty();	


	$.ajax({
		
		 
		url: "<%=request.getContextPath()%><%=ConstantsRequestMapping.MODALI_DOCUMENTI_PAT%>?cmdPOST___modaleMetadatiDocumentiPat=modaleMetadatiDocumentiPat&idPat="+idPat ,
		   
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
				   trHTMLdettTit='<div id=title_modal_1 class=bg-tono0><strong>Documento Patrimonio</strong></div>';
					
			  		trHTMLdett ='<tr><td><strong>Tipo Documento: </strong></td><td>Allegato SIPATR</td></tr>'+
					/**Esposto tipo documento nel campo descrizione per diverso trattamento del campo da parte del sistema sipatr**/
			  		'<tr><td><strong>Descrizione Documento: </strong></td><td>' + (  (articleDett.tipoDocumento==null || articleDett.tipoDocumento.description==null)?'':articleDett.tipoDocumento.description)+ '</td></tr>'+

			  		// '<tr><td><strong>Codice Fascicolo: </strong></td><td>' + (  articleDett.descrizione==null ?'':articleDett.descrizione)+ '</td></tr>'+
			  			' <tr><td><strong>Amministrazione: </strong></td><td>' + ( (articleDett.amministrazione==null || articleDett.amministrazione.description==null)?'':articleDett.amministrazione.description) + '</td></tr>'+ 
		  		 	 ' <tr><td><strong>UCB / RTS: </strong></td><td>' + ( (articleDett.ucbRts==null || articleDett.ucbRts.description==null)?'':articleDett.ucbRts.description) + '</td></tr>'+
		  		 	' <tr><td><strong>Titolo:  </strong></td><td>' + ( articleDett.titolo==null?'':articleDett.titolo) + '</td></tr>'+
		  		    ' <tr><td><strong>Data Chiusura:  </strong></td><td>' + ( articleDett.dataChiusura==null?'':articleDett.dataChiusura) + '</td></tr>'+
		  		    ' <tr><td><strong>Protocollo :  </strong></td><td>' + ( articleDett.protocollo==null ?'':articleDett.protocollo.tipo+ ' - '+articleDett.protocollo.numeroProtocollo+' - '+convertDate(articleDett.protocollo.data)) + '</td></tr>'+
			  		//  	' <tr><td><strong>Esercizio finanziario:  </strong></td><td>' + ( annoEse==null?'': annoEse) + '</td></tr>'+
		  		 	//' <tr><td><strong>Data Arrivo DEMBIL:  </strong></td><td>' + ( articleDett.dataCreazioneFormatted==null?'':articleDett.dataCreazioneFormatted) + '</td></tr>'+
		  			' <tr><td><strong>Nome File: </strong></td><td>' + ( (articleDett.documentoContent==null || articleDett.documentoContent.fileName==null)?'':articleDett.documentoContent.fileName) + '</td></tr>'+
		  			//' <tr><td><strong>Tipo flusso:  </strong></td><td>' +( articleDett.tipoFlusso==null?'':articleDett.tipoFlusso) + '</td></tr>'+
		  		//' <tr><td><strong>Ufficio Creatore:  </strong></td><td>' +( (articleDett.ufficioCreatore==null || articleDett.ufficioCreatore.description==null)?'':articleDett.ufficioCreatore.description) + '</td></tr>'+
		  			' <tr><td><strong>Data Creazione:  </strong></td><td>' +( articleDett.dataCreazione==null ?'':articleDett.dataCreazione) + '</td></tr>'+
		  		//	' <tr><td><strong>Creato da:  </strong></td><td>' +( articleDett.utenteCreatore==null ?'':articleDett.utenteCreatore) + '</td></tr>'+
		  			' <tr><td><strong>Tipo Operazione:&nbsp;</strong></td><td>' + (articleDett.tipoOperazione==null?'':articleDett.tipoOperazione) + '</td></tr>'+
		  			' <tr><td><strong>Esito Operazione:&nbsp;</strong></td><td>' + (articleDett.esitoOperazione==null?'':articleDett.esitoOperazione) + '</td></tr>'+
		  	/* 		' <tr><td><strong>Metodo firma:&nbsp;</strong></td><td>' + (articleDett.metodoFirma==null?'':articleDett.metodoFirma) + '</td></tr>'+
		  			' <tr><td><strong>Ufficio capofila:&nbsp;</strong></td><td>' + (articleDett.ufficioCapofila==null?'':articleDett.ufficioCapofila) + '</td></tr>'+
		  			//' <tr><td><strong>Tipo decreto:&nbsp;</strong></td><td>' + ( tipoDecreto==null?'': tipoDecreto)  + '</td></tr>'+
		  			//' <tr><td><strong>Numero decreto:&nbsp;</strong></td><td>' + ( numeroDecreto==null?'': numeroDecreto)  + '</td></tr>'+
		  			' <tr><td><strong>Stato documento:&nbsp;</strong></td><td>' + ( articleDett.statDocumento==null?'': articleDett.statDocumento)  + '</td></tr>'+ 
		  			' <tr><td><strong>Sistema:&nbsp;</strong></td><td>' + ( articleDett.sistemaProduttore==null?'': articleDett.sistemaProduttore)  + '</td></tr>'+ 
		  		/* 	' <tr><td><strong>Data aggiornamento:&nbsp;</strong></td><td>' + ( articleDett.dataAggiornamento==null?'': articleDett.dataAggiornamento)  + '</td></tr>'+ 
		  			' <tr><td><strong>Aggiornato da:&nbsp;</strong></td><td>' + ( articleDett.aggiornatoDa==null?'': articleDett.aggiornatoDa)  + '</td></tr>'+ 
		  		 */	//' <tr><td><strong>Visibilita Sipatr:&nbsp;</strong></td><td>' + ( articleDett.visSipatr==null?'': articleDett.visSipatr)  + '</td></tr>'+ 
		  			' <tr><td><strong>Visibilità Cdc:&nbsp;</strong></td><td>Visibile</td></tr>'; 
			  		//	' <tr><td><strong>Data presa in carico Cdc:&nbsp;</strong></td><td>' + ( articleDett.dataPresaCaricoCdc==null?'': articleDett.dataPresaCaricoCdc)  + '</td></tr>'+ 
		  			//' <tr><td><strong>Protocollo ricezione Cdc:&nbsp;</strong></td><td>' + ( articleDett.protRicezioneCdc==null?'': articleDett.protRicezioneCdc)  + '</td></tr>'+ 
		  			//' <tr><td><strong>Data ricezione Cdc:&nbsp;</strong></td><td>' + ( articleDett.dataRicezioneCdc==null?'': articleDett.dataRicezioneCdc)  + '</td></tr>';
				//   	' <tr><td><strong>Stato Conversione:  </strong></td><td>' + ( articleDett.statConversione==null?'':articleDett.statConversione) + '</td></tr>'+
				  //	' <tr><td><strong>Esito Conversione:  </strong></td><td>' + ( articleDett.statEsitoConversione==null?'':articleDett.statEsitoConversione) + '</td></tr>'+
				 // 	' <tr><td><strong>Metodo Firma:  </strong></td><td>' + ( (articleDett.anagMetodoFirma==null || articleDett.anagMetodoFirma.descMetodoFirma==null)?'':articleDett.anagMetodoFirma.descMetodoFirma) + '</td></tr>'+
				 // 	' <tr><td><strong>Ufficio Associato: </strong></td><td>' + ( articleDett.fascicoli.ufficioCreatore.descUfficio + '</td></tr>'+
			  //		' <tr><td><strong>Data Creazione:  </strong></td><td>' + ( articleDett.fascicoli.dataCreazioneFascicoloFormatted + '</td></tr>'+
			 // 		' <tr><td><strong>Utente Assegnatario: </strong></td><td>' + ( articleDett.fascicoli.descUtenteCreatore + '</td></tr>'; 
									  		   
  				$("#title_modal_0").append(trHTMLdettTit);	
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

 <demdec:useAttribute id="titoloModaleDett" name="<%=WebConstants.TITOLO_MODALE_DETTAGLIO%>"/>
 
 <%--**INIZIO MODALE--%>
   <div>
   
    <!--<div class="overlay"></div>-->
      
    <div id="contModalVis_0" class="box_meta" >
        
        <div id="title_modal_0"></div>
        
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
    
    
<!-- END MODALE DETT FASCICOLO-->  
      

