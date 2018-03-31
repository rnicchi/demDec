
  <!-- INIZIO MODALE Selezione Decreto -->

  <%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
  <demdec:useAttribute id="titoloModaleDecreti"     name="titoloModaleDecreti"/>
    

 <script type="application/javascript">


 var jsonData;


 function caricaPopup(toOpen, funct){  
	
	 $("#title_modal").empty();

	 var titoloPag = '';
	 titoloPag="<strong>FAD di destinazione - Selezione Decreto</strong>";
	
	if(funct=='modaleListaDecretiRaccProvv'){
		 funz="<%=request.getContextPath() %>/private/ricercaRedModali.do?cmdPOST___modaleListaDecreti=modaleListaDecreti&tipoFlusso="+this.document.getElementById('tipoFlusso').value+"&numero="+this.document.getElementById('numero').value+"&annoEse="+this.document.getElementById('annoEse').value;
	}else if(funct=='modaleInvioAFirme'){
		titoloPag="<strong>Decreti da inviare alla Firma - Ricerca</strong>";
		 funz="<%=request.getContextPath() %>/private/invioAlleFirmeModali.do?cmdPOST___modaleInvioAFirme=modaleInvioAFirme&tipoFlusso="+this.document.getElementById('tipoFlusso').value+"&numero="+this.document.getElementById('numero').value+"&annoEse="+this.document.getElementById('annoEse').value;
	}else if(funct=='modaleSospensioneFirme'){
		 funz="<%=request.getContextPath() %>/private/sospensioneFirmeModali.do?cmdPOST___modaleSospensioneFirme=modaleSospensioneFirme&tipoFlusso="+this.document.getElementById('tipoFlusso').value+"&numero="+this.document.getElementById('numero').value+"&annoEse="+this.document.getElementById('annoEse').value;
	}else if(funct=='modaleRevocaSospensioneFirme'){
		 funz="<%=request.getContextPath() %>/private/revocaSospensioneFirmeModali.do?cmdPOST___modaleRevocaSospensioneFirme=modaleRevocaSospensioneFirme&tipoFlusso="+this.document.getElementById('tipoFlusso').value+"&numero="+this.document.getElementById('numero').value+"&annoEse="+this.document.getElementById('annoEse').value;
	}
	$("#title_modal").append(titoloPag);

	 	leng= this.document.getElementById("tabellaDecreti2").rows.length;
	 	
		if(leng>0){				
			$("#tabellaDecreti2 tr").remove();		
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
		  
		      var radio="";
		      var trHTML = '';
		      var hiddenAnno="";

	    	  trHTML='<tr><th scope=col><span class=nascosto>Selezione</span>Sel.</th><th scope=col>Tipo</th><th scope=col>Numero</th><th scope=col>Anno</th><th scope=col>Data apertura</th><th scope=col>Descrizione</th></tr>';
	     	  $("#tabellaDecreti2").append(trHTML);
	  
		  	  $.each(response, function (i, article) {
			  	
		  		if(article.descSigla=='ERRORE'){
		  			trHTML='';
					$("#divErrore").append("<br><br><label><strong>Errore nel recupero dei dati</strong></label>");
				}else if (article.descSigla=='ERRORE NUM DECRETO'){
					$("#tabellaDecreti2").empty();
		  			trHTML='';
					$("#divErrore").append("</br></br></br></br></br><label><strong>"+article.numeNumDecreto+"</br></br>&nbsp;&nbsp;&nbsp; Il campo numero decreto deve essere numerico&nbsp;&nbsp;&nbsp;</strong></label>");
				}else if (article.descSigla=='ERRORE STATO FASCICOLO'){
					$("#tabellaDecreti2").empty();
		  			trHTML='';
					$("#divErrore").append("</br></br><label><strong></br></br>&nbsp;&nbsp;&nbsp;Operazione non consentita, il fascicolo di destinazione <b>"+article.numeNumDecreto+"</b>&nbsp;&nbsp;&nbsp;</br> � in stato <b>"+article.descStato+"</b>&nbsp;&nbsp;&nbsp;</strong></label>");
				}else if (article.descSigla=='NO RECORD'){
					$("#tabellaDecreti2").empty();
		  			trHTML='';
					$("#divErrore").append("</br></br><label><strong></br></br>&nbsp;&nbsp;&nbsp;Nessun risultato per i criteri di ricerca selezionati&nbsp;&nbsp;&nbsp;</strong></label>");
				}
		  		else {
			  		hiddenTipoFlusso="<input type=hidden id=hiddenTipoFlusso"+i+" value="+ article.numeTipoDecreto+" />";
			  		hiddenAnno="<input type=hidden id=hiddenAnno"+i+" value="+ article.annoEse+" />";
			  		hiddenNumero="<input type=hidden id=hiddenNumero"+i+" value="+ article.numeNumDecreto+" />";
			  		radio="<td><label for=radioButton class=nascosto>Seleziona Decreto</label><input id=radioButton name=radioButton type=radio value="+i+"  /></td>";
			  		
			  		 trHTML ='<tr>'+hiddenTipoFlusso+ ' '+hiddenNumero+ ' '+hiddenAnno+' '+radio+'<td>' + article.descSigla + '</td><td>' + article.numeNumDecreto + '</td><td>' + article.annoEse + '</td><td>' + article.dataCreazione + '</td><td  class=text-center>' + article.descDecreto + '</td></tr>';
			  		 $("#tabellaDecreti2").append(trHTML);
		  		}
		  	});
	    
	  	apriPopUpModale(toOpen);

	    },

	     error: function(){
		
	 			$("#divErrore").append("<br><br><label><strong>Errore nel recuperare i dati</strong></label>");
	 			 
	 			apriPopUpModale(toOpen);
	    } 
	    
	    
	});

	}



/*function confermaModale() {

	if(typeof this.document.getElementById('radioButton')== 'undefined' || typeof this.document.getElementById('radioButton').length == 'undefined'  ){
		
		$('.overlay').fadeOut('fast');
	    $('.box').hide();
		$('.box_meta_35').hide();
	}


		
	for (j = 0; j <len; j++) {
		
		
		if (this.document.getElementById('radioButton'+j).checked) {	
			selezionato = this.document.getElementById('radioButton'+j).value;		
			var indiceTipoFlusso='hiddenTipoFlusso'+selezionato;
			var indiceAnno='hiddenAnno'+selezionato;
			var indiceNumero='hiddenNumero'+selezionato;

			this.document.getElementById('__FORM__').tipoFlusso.value=this.document.getElementById(indiceTipoFlusso).value;
			this.document.getElementById('__FORM__').annoEse.value=this.document.getElementById(indiceAnno).value;
			this.document.getElementById('__FORM__').numero.value=this.document.getElementById(indiceNumero).value;
			
			$('.overlay').fadeOut('fast');
		    $('.box').hide();
			$('.box_meta_35').hide();
			break;
		}
	}
}*/





function confermaModale() {
/*	if(typeof this.document.documentoForm.radioButton== "undefined" || typeof this.document.documentoForm.radioButton.length == "undefined"  ){
		
		$('.overlay').fadeOut('fast');
	    $('.box').hide();
		$('.box_meta_35').hide();
	}*/


  if(typeof this.document.getElementById('__FORM__').radioButton!="undefined") {
			
			var selezionato =-1;
			var len=this.document.getElementById('__FORM__').radioButton.length;
		
			if(typeof this.document.getElementById('__FORM__').radioButton!="undefined" & typeof this.document.getElementById('__FORM__').radioButton.length=="undefined"){
				
				if (this.document.getElementById('__FORM__').radioButton.checked) {
					selezionato = this.document.getElementById('__FORM__').radioButton.value;		
					
					var indiceTipoFlusso='hiddenTipoFlusso'+selezionato;
					var indiceAnno='hiddenAnno'+selezionato;
					var indiceNumero='hiddenNumero'+selezionato;
			
					this.document.getElementById('__FORM__').tipoFlusso.value=this.document.getElementById(indiceTipoFlusso).value;
					this.document.getElementById('__FORM__').annoEse.value=this.document.getElementById(indiceAnno).value;
					this.document.getElementById('__FORM__').numero.value=this.document.getElementById(indiceNumero).value;		


					if($("#invFirmeButton")!=null){
						var buttonHTML = '';	
				  		buttonHTML="<input type='submit' name='cmdPOST___ricercaFirmatari' value='Conferma' class='button small'  /> ";
				  		
				 		$("#invFirmeButton").empty();
						$("#invFirmeButton").append(buttonHTML);	
					}

		

				}	
		    }else {
			
					for (j = 0; j <len; j++) {
						
						if (this.document.getElementById('__FORM__').radioButton[j].checked) {	
							selezionato = this.document.getElementById('__FORM__').radioButton[j].value;		
							var indiceTipoFlusso='hiddenTipoFlusso'+selezionato;
							var indiceAnno='hiddenAnno'+selezionato;
							var indiceNumero='hiddenNumero'+selezionato;
				
							this.document.getElementById('__FORM__').tipoFlusso.value=this.document.getElementById(indiceTipoFlusso).value;
							this.document.getElementById('__FORM__').annoEse.value=this.document.getElementById(indiceAnno).value;
							this.document.getElementById('__FORM__').numero.value=this.document.getElementById(indiceNumero).value;

							if($("#invFirmeButton")!=null){
								var buttonHTML = '';	
						  		buttonHTML="<input type='submit' name='cmdPOST___ricercaFirmatari' value='Conferma' class='button small'  /> ";
						  		
						 		$("#invFirmeButton").empty();
								$("#invFirmeButton").append(buttonHTML);	
							}
									
						
							break;
						}
					}
		
		    }

  }	
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
          <%--     <form id="documentoForm" method="post" action="#" name="documentoForm">   --%>
          <div>
                    <table class="lux tableDati" border="1" id="tabellaDecreti2" > 
                    
                    <caption><span class="nascosto">Tabella Decreti</span></caption>  
                    <tr>
	                    <th scope="col"><span class="nascosto">Selezione</span>Sel.</th>
	                    <th scope="col">Tipo</th>
	                    <th scope="col">Numero</th>
	                    <th scope="col">Anno</th>
	                    <th scope="col">Data apertura</th>
	                    <th scope="col">Descrizione</th>
                    </tr>
                    <!-- <tr>
                    <td><label for="chk_1_mod" class="nascosto">Seleziona Decreto</label><input  name="radioButton" type="radio" /></td>
                    <td>DMT</td>
                    <td>14211</td>
                    <td>2015</td>
                    <td>26/02/2015</td>
                    <td class="text-left">DIM DI ISTITUZIONE CAP. 1243 PG 25 - DIPARTIM. AFFARI INTERNI E TERRITORIALI - MIN. INTERNO</td>
                    </tr> -->
                  
                  
                  
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
     <button type="button" class="button small " onClick="javascript:confermaModale();">Conferma</button>
	<!--<input type="button" class="button small" value="Conferma" onClick="javascript: document.location = '2_add_element_schermo_2.htm';" />-->
    <!--<button type="submit" class="button small">Pulisci</button>-->
    </div>

<p class="chiudi">Chiudi X</p>

</div>
      
    </div>
    
    
<!-- END MODALE Selezione Decreto--> 
      

