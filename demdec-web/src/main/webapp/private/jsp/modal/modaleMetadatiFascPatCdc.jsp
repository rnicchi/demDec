
  <!-- INIZIO MODALE DETT DOCUMENTO -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <script type="application/javascript">


function caricaModaleDettFascPatCdc(toOpenDett, idFasc){

	size=$("#divErrorePat").length ;	
	if( size>0  ) {	
		$("#divErrorePat").empty();
	}

	size2=$("#title_modal_03").length ;
	if( size2>0  ) {	
		$("#title_modal_03").empty();
	}

	leng= this.document.getElementById("tabellaDettaglio6").rows.length;
 	
	if(leng>0){				
		$("#tabellaDettaglio6 tr").remove();		
	} 
	
	$("#divErrorePat").empty();	


	$.ajax({
		
		url: "<%=request.getContextPath() %><%=ConstantsRequestMapping.CONSULTA_FASCICOLO_CDC_MODALI%>?cmdPOST___modaleMetadatiPatCdc=modaleMetadatiPatCdc&rowNum="+idFasc ,
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
				$("#divErrorePat").append("<div class=rowD  align=center><strong>Errore nel recupero dei dati  </strong></div>");
			}else {
	
				trHTMLdettTit='<div id=title_modal_2 class=bg-tono0><strong>Sottofascicolo Patrimonio </strong></div>';
				
				trHTMLdett =  '<tr><td><strong>Tipo: </strong></td><td> Sottofascicolo Patrimonio associato a Decreto </td></tr>'+
							'<tr><td><strong>Amministrazione: </strong></td><td>' + articleDett.amministrazione.description + '</td></tr>'+
							/* '<tr><td><strong>UCB / RTS: </strong></td><td>' + articleDett.ragioneria.description + '</td></tr>'+ */
							'<tr><td><strong>Descrizione: </strong></td><td>' +articleDett.descrizione + '</td></tr>'+
							'<tr><td><strong>Data Creazione:  </strong></td><td>' + articleDett.dataCreazione + '</td></tr>'+
							'<tr><td><strong>Id SIPATR:  </strong></td><td>' +articleDett.identificativoSIPATR + '</td></tr>'+
							'<tr><td><strong>Titolo:  </strong></td><td>' + articleDett.titolo + '</td></tr>';
							/*' <tr><td><strong>Stato Fascicolo Documentale: </strong></td><td>' + articleDett.statoFascicoloDocumentale + '</td></tr>'+
							'<tr><td><strong>Stato Fascicolo Patrimonio: </strong></td><td>' + articleDett.statoFascicoloSIPATR + '</td></tr>'+
							'<tr><td><strong>Sistema:  </strong></td><td>' + articleDett.sistemaProduttore + '</td></tr>'; */
							
  				$("#title_modal_03").append(trHTMLdettTit);	
  				$("#tabellaDettaglio6").append(trHTMLdett);

  			
			}
	  		
	 
	  	});

	  	
	  	apriPopUpModale(toOpenDett);
		
	},

	
    error: function(){
    	
			$("#divErrorePat").append("<div class=rowD align=center><strong>Errore nel recupero dei dati</strong></div>");
			 
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
     <div id="contModal_03" class="box_meta" >
        
        <div id="title_modal_03"></div>
        
    	<div>
             
      	  <div id='divErrorePat'></div>
       
            <!--INI SCROLL-->
         	<div>          
                            <!-- MODAL TABLE-->             
	          <div class="width100">
	                 <table  class="marg_0px_auto width100" id="tabellaDettaglio6" > 
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
      

