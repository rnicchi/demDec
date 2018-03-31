
 <!-- INIZIO MODALE Visualizzazione Metadati Documento Fad -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <script type="application/javascript">

function caricaModaleMetadatiDocPatCdc(toOpenDett, rowNum){

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
		
		 
		url: "<%=request.getContextPath() %>/private/consultaFascicoloCdcModali.do?cmdPOST___modaleDocumentiPatCdc=modaleDocumentiPatCdc&rowNum="+rowNum ,
		
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

				trHTMLdettTit='<div id=title_modal_2 class=bg-tono0><strong>Documento: '+ (articleDett.descrizione==null?'':articleDett.descrizione) + '</strong></div>';
		  		
		  		trHTMLdett = 
			  		'<tr><td><strong>Amministrazione: </strong></td><td>' + (articleDett.amministrazione==null?'':articleDett.amministrazione.description) + '</td></tr>'+	
			  		'<tr><td><strong>Protocollo: </strong></td><td>' + (articleDett.protocollo==null?'':articleDett.protocollo.numeroProtocollo) + '</td></tr>'+			  		
			  		/* '<tr><td><strong>Ucb/Rts: </strong></td><td>' + (articleDett.ucbRts==null?'':articleDett.ucbRts.description) + '</td></tr>'+ */
			  		'<tr><td><strong>Data Documento: </strong></td><td>' + (articleDett.dataDocumento==null?'':articleDett.dataDocumento) + '</td></tr>'+
				  	'<tr><td><strong>Tipo Documento: </strong></td><td>' +(articleDett.tipoDocumento==null?'':articleDett.tipoDocumento.description) + '</td></tr>'+	
			  	 	'<tr><td><strong>Descrizione Documento:  </strong></td><td>'+(articleDett.descDocumento==null?'':articleDett.descDocumento.description )+  '</td></tr>';	 
				
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
      
    <div id="contModal_6" class="box_meta" >
        
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
      

