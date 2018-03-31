
  <!-- INIZIO MODALE DETT DOCUMENTO -->
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

function caricaModaleMetadatiDocRed(toOpenDett, rowNum){

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
		
		url: "<%=request.getContextPath() %>/private/ricercaSospesiRedModali.do?cmdPOST___modaleDettaglioDocumentoSosp=modaleDettaglioDocumentoSosp&idRigaDoc="+rowNum ,
		
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
				trHTMLdettTit='<div class=bg-tono0 id=title_modal_2><strong>Documento Raccolta Sospesa</strong></div>';
		  		/* trHTMLdettTit='<table class="lux tableDati" border="0">'+
		  					  '<tr><td><div id=title_modal_2 class=bg-tono0><strong>Documentos:</strong> </td>'+
		  					  '<td><strong>'+ (articleDett.descrizione==null?'':articleDett.descrizione) + '</strong></div></td></tr>'+
		  					  '</table>'; */
		  		
		  		trHTMLdett =
		  		  //  '<div class=bg-tono0><strong>Documento: '+ (articleDett.descrizione==null?'':articleDett.descrizione) + '</strong></div>'+
			  		//'<div class=rowD><strong>Esercizio Finanziario: </strong></td><td>' + (articleDett.anagAmminDem.eserciziDem.id==null?'':articleDett.anagAmminDem.eserciziDem.id)  + '</div>'+		
			  		'<tr><td><strong>Tipo Documento:&nbsp;</strong></td><td>' + (articleDett.tipoDocumento.description==null?'':articleDett.tipoDocumento.description) + '</td></tr>'+	
			  		//'<tr><td><strong>Protocollo Ingresso:&nbsp;</strong></td><td>' + ( (articleDett.protocollo==null || articleDett.protocollo.numeroProtocollo==null)?'':articleDett.protocollo.numeroProtocollo) + '</td></tr>'+			  		
			  		//'<tr><td><strong>Data Protocollo Ingresso:&nbsp;</strong></td><td>' + ( (articleDett.protocollo==null || articleDett.protocollo.data==null)?'':convertDate(articleDett.protocollo.data) ) + '</td></tr>'+			  		
			  		' <tr><td><strong>Protocollo :  </strong></td><td>' + ( articleDett.protocollo==null ?'':articleDett.protocollo.tipo+ ' - '+articleDett.protocollo.numeroProtocollo+' - '+convertDate(articleDett.protocollo.data)) + '</td></tr>'+
			  		'<tr><td><strong>Nome file:&nbsp;</strong></td><td>' + (articleDett.documentoContent.fileName==null?'':articleDett.documentoContent.fileName) + '</td></tr>'+		  		
			  		'<tr><td><strong>Amministrazione:&nbsp;</strong></td><td>' + (articleDett.amministrazione.description==null?'':articleDett.amministrazione.description) + '</td></tr>'+	
			  		'<tr><td><strong>UCB / RTS:&nbsp;</strong></td><td>' + ( (articleDett.ucbRts==null || articleDett.ucbRts.description==null)?'':articleDett.ucbRts.description) + '</td></tr>'+	
			  		'<tr><td><strong>Data Creazione:&nbsp;</strong></td><td>' + (articleDett.dataCreazione==null?'':articleDett.dataCreazione) + '</td></tr>'+				 
			  		'<tr><td><strong>Data Documento:&nbsp;</strong></td><td>' + (articleDett.dataDocumento==null?'':articleDett.dataDocumento) + '</td></tr>'+
			  		'<tr><td><strong>Tipo Operazione:&nbsp;</strong></td><td>' + (articleDett.tipoOperazione==null?'':articleDett.tipoOperazione) + '</td></tr>'+	
					'<tr><td><strong>Esito Operazione:&nbsp;</strong></td><td>' + (articleDett.esitoOperazione==null?'':articleDett.esitoOperazione) + '</td></tr>';	


					  	// 	'<tr><td><strong>Descr. Documento:&nbsp;</strong></td><td>'+(articleDett.descDocumento==null?'':articleDett.descDocumento.description )+  '</td></tr>';	 
									  		   
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
	$('.box_meta_35').hide();
}

</script>

 <demdec:useAttribute id="titoloModaleDett" name="<%=WebConstants.TITOLO_MODALE_DETTAGLIO%>"/>
 
 <%--**INIZIO MODALE--%>
   <div>
   
    <!--<div class="overlay"></div>-->
      
    <div id="contModal_2" class="box_meta_35" >
        
        <div id="title_modal_0"></div>
        
    <div>
             
        <div id='divErroreDett'></div>
       
            <!--INI SCROLL-->
             <div class="scroll_table_gen" >          
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
      

