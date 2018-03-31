
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
 
function caricaModaleDettFascFad(toOpenDett, idFasc){

	size=$("#divErrore").length ;	
	if( size>0  ) {	
		$("#divErrore").empty();
	}

	size2=$("#title_modal_01").length ;
	if( size2>0  ) {	
		$("#title_modal_01").empty();
	}

	leng= this.document.getElementById("tabellaDettaglio3").rows.length;
 	
	if(leng>0){				
		$("#tabellaDettaglio3 tr").remove();		
	} 
	
	$("#divErrore").empty();	


	$.ajax({
		
		url: "<%=request.getContextPath()%>/private/modaliFad.do?cmdPOST___modalemetadatiFascicoloFad=modalemetadatiFascicoloFad&idFad="+idFasc ,
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
				$("#divErrore").append("<div class=rowD  align=center><strong>Errore nel recupero dei dati  </strong></div>");
			}else {
	
				trHTMLdettTit='<div id=title_modal_2 class=bg-tono0><strong>Fascicolo Atto Decreto</strong></div>';

		  		trHTMLdett ='<tr><td><strong>Tipo Decreto: </strong></td><td>' +(articleDett.descSigla==null?'':articleDett.descSigla) + '</td></tr>'+
					  		'<tr><td><strong>Numero Decreto: </strong></td><td>' +(articleDett.numeNumDecreto==null?'':articleDett.numeNumDecreto) + '</td></tr>'+
					  		'<tr><td><strong>Descrizione Decreto: </strong></td><td>' +(articleDett.descDecreto==null?'':articleDett.descDecreto) + '</td></tr>'+
					  		'<tr><td><strong>Numero decreto Patrimonio:  </strong></td><td>' +(articleDett.numePatrimonio==null?'':articleDett.numePatrimonio) + '</td></tr>'+
					  	   	'<tr><td><strong>Amministrazione: </strong></td><td>' +( articleDett.amministrazioneModale==null?'':articleDett.amministrazioneModale )+ '</td></tr>'+
					  	    '<tr><td><strong>UCB / RTS: </strong></td><td>' +(articleDett.ragioneriaModale==null?'': articleDett.ragioneriaModale)+ '</td></tr>'+
					  		'<tr><td><strong>Ufficio Creatore: </strong></td><td>' +( (articleDett.ufficioCreatore==null || articleDett.ufficioCreatore.descUfficio==null)?'':articleDett.ufficioCreatore.descUfficio) + '</td></tr>'+
					  		'<tr><td><strong>Data Creazione:  </strong></td><td>' +(articleDett.dataCreazioneFascicoloFormatted==null?'':articleDett.dataCreazioneFascicoloFormatted) + '</td></tr>'+
					  		'<tr><td><strong>Utente Creatore: </strong></td><td>' +(articleDett.descUtenteCreatore==null?'':articleDett.descUtenteCreatore )+ '</td></tr>'+
					  		'<tr><td><strong>Ufficio Capofila: </strong></td><td>' +( (articleDett.ufficioCapofila==null || articleDett.ufficioCapofila.descUfficio==null)?'':articleDett.ufficioCapofila.descUfficio )+ '</td></tr>'+
					  		'<tr><td><strong>Tipologia Decreto: </strong></td><td>' +( (articleDett.anagTipologiaDecreto==null || articleDett.anagTipologiaDecreto.descTipologia==null)?'':articleDett.anagTipologiaDecreto.descTipologia )+ '</td></tr>'+
					  		'<tr><td><strong>Stato Fascicolo: </strong></td><td>' + (articleDett.descStato==null ?'':articleDett.descStato )+ '</td></tr>'+
					  		'<tr><td><strong>Data Aggiornamento: </strong></td><td>' + (articleDett.dataModificaFascicolo==null ?'':convertDate(articleDett.dataModificaFascicolo) )+ '</td></tr>'+
					  		'<tr><td><strong>Utente Aggiornamento: </strong></td><td>' + (articleDett.descUtenteModifica==null ?'':articleDett.descUtenteModifica )+ '</td></tr>';
					  		
  				$("#title_modal_01").append(trHTMLdettTit);	
  				$("#tabellaDettaglio3").append(trHTMLdett);

  			
			}
	  		
	 
	  	});

	  	
	  	apriPopUpModale(toOpenDett);
		
	},

	
    error: function(){
    	
			$("#divErrore").append("<div class=rowD align=center><strong>Errore nel recupero dei dati</strong></div>");
			 
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
     <div id="contModal_01" class="box_meta" >
        
        <div id="title_modal_01"></div>
        
    	<div>
             
      	  <div id='divErrore'></div>
       
            <!--INI SCROLL-->
         	<div>          
                            <!-- MODAL TABLE-->             
	          <div class="width100">
	                 <table  class="marg_0px_auto width100" id="tabellaDettaglio3" > 
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
      

