
  <!-- INIZIO MODALE Selezione Decreto -->
 <script type="application/javascript">

 var jsonData;

 function caricaPopup(toOpen, funct){

	    funz="<%=request.getContextPath() %>/private/revocaSospensioneFirmeModali.do?cmdPOST___modaleRevocaSospensioneFirme=modaleRevocaSospensioneFirme&tipoFlusso="+this.document.getElementById('tipoFlusso').value+"&numero="+this.document.getElementById('numero').value+"&annoEse="+this.document.getElementById('annoEse').value;

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



function confermaModale() {

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
				//	$("#revSospButton").append( "<demdec:submit keyValue='button.revocaSospFirme' controllerCode='revocaSospensioneFirme'  styleClass='button small' />");
					var buttonHTMLdett = '';
	
			  		buttonHTMLdett="<input type='submit' name='cmdPOST___revocaSospensioneFirme' value='Revoca Sospensione Workflow' class='button small'  /> ";

			  		var buttonHTML2 = '';	
			  		buttonHTML2="<input type='submit' name='cmdPOST___riapriFascicolo' value='Riavvia Workflow' class='button small'  onclick='return confermaModificaUtente();' /> ";

			 		$("#revSospButton").empty();
					$("#revSospButton").append(buttonHTMLdett);
					$("#revSospButton").append(buttonHTML2);
			  
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
							var buttonHTMLdett = '';
							
					  		buttonHTMLdett="<input type='submit' name='cmdPOST___revocaSospensioneFirme' value='Revoca Sospensione Workflow' class='button small'  /> ";

					  		var buttonHTML2 = '';	
					  		buttonHTML2="<input type='submit' name='cmdPOST___riapriFascicolo' value='Riavvia Workflow' class='button small'  onclick='return confermaModificaUtente();' /> ";

						 	$("#revSospButton").empty();
							$("#revSospButton").append(buttonHTMLdett);
							$("#revSospButton").append(buttonHTML2);
							
							break;
						}
					}
		
		    }

  }	
	  
	$('.overlay').fadeOut('fast');
    $('.box_30').hide();
	$('.box_meta').hide();

}

</script>
 
    <div>
    
    <!--<div class="overlay"></div>-->
    
    <div id="contModal_0" class="box_30 center" >
        
        <div id="title_modal"><strong>Decreti Sospesi - Ricerca</strong></div>
        
        <div>
        
        <div id='divErrore'></div>
       
            <!--INI SCROLL-->
           <div class="scroll_table_modal" >
                            <!-- MODAL TABLE-->             
               <div>
                    <table class="lux tableDati"  id="tabellaDecreti2" > 
                    
                    <caption><span class="nascosto">Tabella Decreti</span></caption>  
                    <tr>
	                    <th scope="col"><span class="nascosto">Selezione</span>Sel.</th>
	                    <th scope="col">Tipo</th>
	                    <th scope="col">Numero</th>
	                    <th scope="col">Anno</th>
	                    <th scope="col">Data apertura</th>
	                    <th scope="col">Descrizione</th>
                    </tr>
                                   
                    </table>            
      
               </div>
           </div>
        <!--END SCROLL-->

        <div class="spacer_sm">&nbsp;</div>

</div>

    <div class="text-center">
	     <button type="button" class="button small " onClick="javascript:confermaModale();">Conferma</button>
    </div>

 <p class="chiudi">Chiudi X</p>

 </div>
      
</div>
    
<!-- END MODALE Selezione Decreto--> 
      

