<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>

 <%--**INIZIO MODALE ANTEPRIMA --%>
 <script type="application/javascript">

function caricaModaleAnteprima(index, listName){
	size=$("#anteprima").length ;	
	if( size>0  ) {	
		$("#anteprima").empty();
	}

	
	$.ajax({
		
		 
		url: "<%=request.getContextPath() %>/private/modaliAnteprimaDocumenti.do?cmdPOST___modaleAnteprimaDocumenti=modaleAnteprimaDocumenti&index="+index+"&listName="+listName ,
		
	    type: 'POST',
	    data: {
	        json: jsonData
	    },
	    success: function (response) { 
	        var trHTMLdett = '';
	
	  	  $.each(response, function (i, articleDett) {
		  		trHTMLdett = '<img id="imgPreView" alt="Anteprima documento" src="data:image/jpg;base64,'+articleDett+'">'
  				$("#anteprima").append(trHTMLdett);
	  	});

		apriPopUpModale("modale_anteprima");
		
	},

	
    error: function(){
    	
			
    } 

	});


}


function confermaModalePreView() {

	$('.overlay').fadeOut('fast');
    $('.box').hide();
}

</script>

 <demdec:useAttribute id="titoloModaleDett" name="<%=WebConstants.TITOLO_MODALE_DETTAGLIO%>"/>
 
   <div>
   
    <!--<div class="overlay"></div>-->
      
    <div id="modale_anteprima" class="box" >
        
        
         <div class="spacer_sm">&nbsp;</div>
    <div id="anteprima">
    
    	
             
        <!--END SCROLL-->


    </div>

        <div class="spacer_sm">&nbsp;</div>
     <div class="text-center">
    
     <button type="button" class="button small " onClick="javascript:confermaModalePreView();">Torna alla lista</button>
	
    </div>

<p class="chiudi">Chiudi X</p>

</div>
      
    </div>
    
    
<!-- END MODALE ANTEPRIMA-->  

