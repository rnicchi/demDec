
  <!-- INIZIO MODALE Tipologie associate -->

  <%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
  <demdec:useAttribute id="titoloModaleDecreti"     name="titoloModaleDecreti"/>
    

 <script type="application/javascript">
 var jsonData;

 function caricaTipologie(toOpen, rowNum){  
	 $("#title_modal_1").empty();

	 var titoloPag = '';
	 titoloPag="<strong>Tipologie Associate</strong>";
	
		 funz="<%=request.getContextPath() %>/private/gestWorkflowFirmeModali.do?cmdPOST___modaleTipologieAssociate=modaleTipologieAssociate&selectedModello="+rowNum;

		 $("#title_modal_1").append(titoloPag);

	 	leng= this.document.getElementById("tabellaTipologie").rows.length;
	 	
		if(leng>0){				
			$("#tabellaTipologie tr").remove();		
		} 

		$("#divErrore1").empty();		
		
		$.ajax({
			
		url: funz,
		
	    type: 'POST',
	    data: {
	        json: jsonData
	    },
	    
	    success: function (response) {
		      var trHTML = '';
		      var flag=false;

	    	 // trHTML='<tr><th scope=col><span class=nascosto>Selezione</span>Descrizione Tipologia</th></tr>';
	     	  $("#tabellaTipologie").append(trHTML);
	     	 	
		  	  $.each(response, function (i, article) {
		  		flag=true;
		  		if(article.descTipologia=='ERRORE'){
		  			trHTML='';
					$("#divErrore1").append("<br><br><label><strong>Errore nel recupero dei dati</strong></label>");
				}
		  		else {
			  
			  		 trHTML ='<tr><td>' + article.descTipologia + '</td></tr>';
					  	
				  		 $("#tabellaTipologie").append(trHTML);
		  		}
		  	});
	    if(flag==false){
	    	$("#tabellaTipologie").append("<tr><td class=center><br><label><strong>Nessun elemento trovato</strong></label></td></tr>");
		}
	  	apriPopUpModale(toOpen);

	    },

	     error: function(){
		
	 			$("#divErrore1").append("<br><br><label><strong>Errore nel recuperare i dati</strong></label>");
	 			 
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
  
    <div id="contModal_1" class="box_meta_35 left" >
			<div id="title_modal_1" class="center"></div>
        <div>
        
        <div id='divErrore1'  class="box_meta"></div>
            <!--INI SCROLL-->
            <div class="scroll_table_modal" >
           
                            <!-- MODAL TABLE-->             
          <%--     <form id="documentoForm" method="post" action="#" name="documentoForm">   --%>
          <div>
                    <table class="lux tableDati width100" border="1" id="tabellaTipologie" > 
                    
                    <caption><span class="nascosto">Tabella Tipologie</span></caption>  
                    <tr>
	                    <th scope="col">Descrizione Tipologia</th>
                    </tr>
                  
                    </table>            
        <%--   </form>  --%>
           </div>
        </div>
        <!--END SCROLL-->

        <div class="spacer_sm">&nbsp;</div>

</div>


<!--<div class="invia_FAD"><img src="img/ico_send.png" alt=""><a href="#">Invia a Gestione Fascicoli FAD</a></div>-->

    <div class="text-center">
    <%--  <button type="button" class="button small" onClick="javascript: document.location = '2_add_element_schermo_2.htm';">Conferma</button>--%>
     <button type="button" class="button small " onClick="javascript:confermaModale();">Torna alla lista</button>
	<!--<input type="button" class="button small" value="Conferma" onClick="javascript: document.location = '2_add_element_schermo_2.htm';" />-->
    <!--<button type="submit" class="button small">Pulisci</button>-->
    </div>

<p class="chiudi">Chiudi X</p>

</div>
      
    </div>
    
    
<!-- END MODALE Tipologie associate--> 
      

