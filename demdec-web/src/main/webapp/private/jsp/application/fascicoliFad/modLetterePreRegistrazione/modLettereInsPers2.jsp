<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<demdec:useAttribute id="testiPersList" name="<%=SessionAttributes.LIST_TESTI_PERS%>"/>
<demdec:useAttribute id="sottoFascicoliRedList" name="<%=SessionAttributes.LIST_SOTTO_FASCICOLI_RED%>"/>
<demdec:useAttribute id="f" name="<%=BaseSessionAttributes.FORM%>" />
<tiles:useAttribute name="action"/>



<div class="spacer_sm">&nbsp;</div>

	<c:set var="personalizzato" value="false"/>
	
	
	
	
	
		<!-- Sezione lanci-servizi -->
			<section id="lanci-servizi">
			<!-- Inzio large-12 columns -->
			<div class="large-12 columns">
            

<div>&nbsp;</div>



<div class="col_char_user obb_fields">I campi contrassegnati con il simbolo * sono obbligatori</div>
<fieldset>
                    
                    <div class="row"><strong class="color_grey_3">Personalizza lettera</strong></div>
                    <!--<div class="spacer_sm_10">&nbsp;</div>-->
            

                    <div class="spacer_sm">&nbsp;</div>
                    
                    
                     <!--INI PDF_base-->
                    <div id="PDF_base">
                    
                          
                          <div class="row">   
                          <div class="large-4 columns Lbl_Dest_1">                      
                            <label class="text-left"><span class="Cur_default color_black">${testiPersList[1].contenuto}</span></label><%--amministrazione destinataria--%>
                         </div>
                         
                         <div class="large-4 columns Lbl_Dest_2">                      
                            <label class="text-left"><span class="Cur_default color_black">${testiPersList[2].contenuto}</span></label><%--ufficio bilancio destinatario--%>
                         </div>
                         
                         <div class="large-3 columns Lbl_uff">                      
                            <label class="text-center"><strong class="Cur_default">${testiPersList[0].contenuto}</strong></label> <%--ufficio--%> 
                         </div>
                             <div class="large-3 columns Cbo_rif">  
		                           <label for="predLettereTestiFormList[3].contenuto"><strong>* Rif.Prot. Entrata N.</strong></label>
		                           <form:select path="predLettereTestiFormList[3].contenuto" onchange="showfield(this.options[this.selectedIndex].value)">
		                           		<form:option value="">Selezione</form:option>
										<c:forEach items="${sottoFascicoliRedList}" var="item">
											<form:option value="${item.numeProtocollo}">${item.numeProtocollo} </form:option>
										</c:forEach>
		                                <form:option value="Altro">Altro </form:option>
		                           </form:select>
		                     </div>
		                           <!-- div1 serve per javascript in caso di Altro -->
		                           <div class="small-4 columns Cbo_rif_2" id="div1">
		                           <c:if test="${f.predLettereTestiFormList[3].contenuto eq 'Altro'}">
		                           		<form:input path="altroProtocolloEntrata" id="altroProtocolloEntrata" />
		                           </c:if>
		                           </div>
	                          
                         </div>
                         
                          
                         <div class="large-7 columns txt_ogg">                      
                            <label for="predLettereTestiFormList[4].contenuto" id="ss"><strong>* Oggetto</strong></label>
							<form:textarea  rows="10" cols="400"     cssClass="height_ogg width_80_Re" path="predLettereTestiFormList[4].contenuto"  /> 
                         </div>
                          
                          
                         <div class="large-7 columns txt_testo">                      
                            <label for="predLettereTestiFormList[5].contenuto" ><strong>* Testo</strong></label>
							<form:textarea rows="20" cols="400"    cssClass="height_testo width_80_Re" path="predLettereTestiFormList[5].contenuto"  />  
                         </div>
                          
                          
                        <!--  <div class="large-7 columns txt_note">                      
                            <label for="note"><strong>Note</strong></label>
                            <textarea class="height_note width_80_Re" id="note" name="note" rows="10" cols="400" placeholder="Inserisci note"></textarea>  
                         </div> -->
                          <div class="large-7 columns txt_note">                      
                            <label for="predLettereTestiFormList[6].contenuto" ><strong>Note</strong></label>
							<form:textarea rows="20" cols="400"    cssClass="height_note width_80_Re" path="predLettereTestiFormList[6].contenuto"  />  
                         </div>
                      
                    </div>
                     <!--END PDF_base-->
            
            
              </fieldset>            
            
 
   <div>
     
      
</div>
    
    

            <div>
                
               <div class="row">
					<form:hidden path="idFascicolo"  />		        	
		       		<demdec:submit keyValue="button.salva" controllerCode="salvaPersonalizza" />
		       		
		       		<c:if test="${personalizzato }">
		       			&nbsp;
		       			<demdec:submit keyValue="button.fad.cancella" controllerCode="rimuoviPersonalizza" />
		       		</c:if>
		       		
		       		&nbsp;
		       		<demdec:submit keyValue="button.annulla" controllerCode="backFromPersonalizza" />
       	
     			</div>      			
                
            </div>
            
            
		
			</div>
			<!-- Fine large-12 columns -->
			</section>
		<!-- Fine Sezione lanci-servizi -->
	
	
	<script type="text/javascript">

function showfield(value){
	  if(value=='Altro')
	  	{
		  value='';
		 /* document.getElementById('div1').innerHTML='<br><input type="text" name="altroProtocolloEntrata" value="" />';*/
		  document.getElementById('div1').innerHTML='<form:input path="altroProtocolloEntrata" id="altroProtocolloEntrata" />';
	  	}
	  else 
		{
		  document.getElementById('div1').innerHTML='';
		}
	}


</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
				
	
