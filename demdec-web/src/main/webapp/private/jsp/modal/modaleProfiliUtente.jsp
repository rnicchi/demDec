
  <!-- INIZIO MODALE Dettaglio Workflow -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping"%>
  <%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    

 <script type="application/javascript">
 var jsonData;
 
 function caricaProfiliUtente(toOpen, id){  
	 $("#title_modal").empty();

	 var titoloPag = '';
	 titoloPag="<strong>Tabella Profili Utente</strong>";

		 funz="<%=request.getContextPath() %><%=ConstantsRequestMapping.MODALI_GESTIONE_UTENTI%>?cmdPOST___modaleProfiliUtente=modaleProfiliUtente&selectedCodiUtente="+id;
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
		      var radio='<input type=radio name=profPrinc disabled=true/>';
		      var radioChecked='<input type=radio name=profPrinc checked=true disabled=true/>';
		  
	    	  trHTML='<tr><th scope=col>Profilo</th><th scope=col>Ufficio</th><th scope=col>Amministrazione</th><th scope=col>Profilo Principale</th></tr>';
	     	  $("#tabellaDettaglio").append(trHTML);
	     	 
		  	  $.each(response, function (i, article) {
			  		flagDett=true;
			  		if(article.warningCode=='ERRORE'){
			  			trHTML='';
			  			$("#tabellaDettaglio").empty();	
						$("#divErrore").append("<br><br><label><strong>&nbsp;&nbsp;&nbsp;Errore nel recupero dei dati&nbsp;&nbsp;&nbsp;</strong></label>");
					}
			  		else {
				  		trHTML ='<tr><td>' + article.descProfilo + '</td><td>' + article.descUfficio + '</td><td>' + article.descAmministrazione + '</td><td>' + (article.flagDefault01==1?radioChecked:radio) + '</td></tr>';
					  	$("#tabellaDettaglio").append(trHTML);
			  		}
		  	});
	  	    if(flagDett==false){
	  	    	$("#tabellaDettaglio").empty();
		    	$("#divErrore").append("<tr><td></br></br></br><label><strong>&nbsp;&nbsp;&nbsp;Nessun elemento trovato&nbsp;&nbsp;&nbsp;</strong></label></td></tr>");
			}
	  	apriPopUpModale(toOpen);

	    },

	     error: function(){
	    	    $("#divErrore").empty();	
	 			$("#divErrore").append("<br><br><label><strong>&nbsp;Errore nel recuperare i dati&nbsp;</strong></label>");
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
		                    <th scope="col">Profilo</th>
		                    <th scope="col">Ufficio</th>
		                    <th scope="col">Amministrazione</th>
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
