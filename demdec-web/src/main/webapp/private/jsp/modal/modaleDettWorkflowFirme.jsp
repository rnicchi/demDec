
  <!-- INIZIO MODALE Dettaglio Workflow -->

  <%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    

 <script type="application/javascript">
 var jsonData;
 
 function caricaPopup(toOpen, id, funct){  
	 $("#title_modal").empty();

	 var titoloPag = '';
	 titoloPag="<strong>Tabella Workflow Firma</strong>";

	 if(funct=='modaleModelliWorkflow'){
		 funz="<%=request.getContextPath() %>/private/gestWorkflowFirmeModali.do?cmdPOST___modaleDettaglioModelloIter=modaleDettaglioModelloIter&selectedModello="+id;

	 }else if(funct=='modaleGestTipologiaDecr'){
		 funz="<%=request.getContextPath() %>/private/gestTipologiaDecretoModali.do?cmdPOST___modaleDettaglioModelloIter=modaleDettaglioModelloIter&selectedTipologia="+id;

	 }
	
		 <%-- funz="<%=request.getContextPath() %>/private/gestWorkflowFirmeModali.do?cmdPOST___modaleDettaglioModelloIter=modaleDettaglioModelloIter&selectedModello="+id; --%>

		 $("#title_modal").append(titoloPag);

	 	leng= this.document.getElementById("tabellaDettaglio").rows.length;
	 	
		if(leng>0){				
			$("#tabellaDettaglio tr").remove();		
		} 

		$("#divErrore").empty();		
		
		$.ajax({
			
		url: funz,
		
	    type: 'POST',
	    data: {
	        json: jsonData
	    },
	    
	    success: function (response) {
		      var trHTML = '';
		      var flagDett=false;
		  
	    	  trHTML='<tr><th scope=col>Numero ordine</th><th scope=col>Firmatario</th><th scope=col>Tipo firma</th></tr>';
	     	  $("#tabellaDettaglio").append(trHTML);
	     	 
		  	  $.each(response, function (i, article) {
		  		flagDett=true;
			  		if(article.warningCode=='ERRORE'){
			  			trHTML='';
						$("#divErrore").append("<br><br><label><strong>Errore nel recupero dei dati</strong></label>");
					}
			  		else {
			  			
				  		trHTML ='<tr><td>' + article.id.numeOrdine + '</td><td>' + article.anagFirmatari.descFirmatario + '</td><td>' + article.anagFirmatari.descTipoFirma + '</td></tr>';
					  	$("#tabellaDettaglio").append(trHTML);
			  		}
		  	});
	  	    if(flagDett==false){
		    	$("#tabellaDettaglio").append("<tr><td><br><label><strong>Nessun elemento trovato</strong></label></td></tr>");
			}
	  	apriPopUpModale(toOpen);

	    },

	     error: function(){
	 			$("#divErrore").append("<br><br><label><strong>Errore nel recuperare i dati</strong></label>");
	 			apriPopUpModale(toOpen);
	    } 
	    
	});

	}

function confermaModale() {
	$('.overlay').fadeOut('fast');
    $('.box_30').hide();
	$('.box_meta_35').hide();
}

</script>
 
    <div>
    <!--<div class="overlay"></div>-->
    <div id="contModal_0" class="box_30 center" >
			<div id="title_modal"></div>
        <div>
        	<div id='divErrore'></div>
            <!--INI SCROLL-->
            <div class="scroll_table_modal" >
           
                            <!-- MODAL TABLE-->             
         	 <div>
                    <table class="lux tableDati" border="1" id="tabellaDettaglio" > 
	                    <caption><span class="nascosto">Tabella Dettaglio</span></caption>  
	                    <tr>
		                    <th scope="col">Numero ordine</th>
		                    <th scope="col">Firmatario</th>
		                    <th scope="col">Tipo firma</th>
	                    </tr>
                    </table>            
           </div>
        </div>
        <!--END SCROLL-->
        <div class="spacer_sm">&nbsp;</div>
 </div>

    <div class="text-center">
     <button type="button" class="button small " onClick="javascript:confermaModale();">Torna alla lista</button>
    </div>

<p class="chiudi">Chiudi X</p>

 </div>
</div>
    
<!-- END MODALE Dettaglio Workflow--> 
