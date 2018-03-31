
<%@page import="org.apache.commons.httpclient.methods.GetMethod"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="it.mef.bilancio.demdec.servizi.to.DocumentTO"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- PageName = documentiFascicolo.jsp -->
 <demdec:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/>
 <demdec:useAttribute id="listTipiDecr" name="<%=WebConstants.LIST_TIPI_DECRETI%>"/>  
 <demdec:useAttribute id="tipoAllegatiList" name="<%=WebConstants.LIST_TIPO_ALLEGATI_RP01%>" /> 
 <demdec:useAttribute id="tipoAllegatiList2" name="<%=WebConstants.LIST_TIPO_ALLEGATI_RP02%>" /> 
 <demdec:useAttribute id="listDocumentiFascicolo" name="<%=SessionAttributes.LIST_DOCUMENTI_FASCICOLO%>" /> 
 <demdec:useAttribute id="listAnniEser" name="<%=WebConstants.LIST_ANNO_ESE%>"/> 
  <demdec:useAttribute id="numDataProtocollo" name="numDataProtocollo"/>
 
<tiles:insertAttribute name="modalFascDocRed" flush="false"/>

  <script type="application/javascript">

$(document).ready(function() {

    $("#btnInvioAFad").click(function() {

        $('body').css("cursor", "wait");

    });


    $("#btnInvAFad").click(function() {

        $('body').css("cursor", "wait");

    });

});

</script>

<%-- form> --%>
 <div class="large-12 columns">
 <div class="spacer_sm">&nbsp;</div>
<%--  <div class="row">   
	<input type="text" maxlength="50" value="Prot: ${numDataProtocollo}" class="label" readonly="true"/>
</div>  --%>

	<div class="center padd-bott_5 font_size_riep">
	    <span><strong>&#8226; Protocollo:</strong> </span>
	    <span class="col_char_user"><strong>${numDataProtocollo}</strong></span> 
	</div>
  
  
 <input type="hidden" name="origine" value="documentiFascicolo"/>

  <fieldset>
  <legend>FAD di destinazione - Selezione Decreto</legend>

 
        <div class="row" >
            <div class="small-3 columns left">
          		<demdec:label path="tipoFlusso"  labelKey="label.raccolteProvvisorie.tipo"/>
					       		 <form:select path="tipoFlusso"   id="tipoFlusso"> 
					       		    <form:option value="" >&nbsp;</form:option> 
					          		<c:forEach var="msg" items="${listTipiDecr}">		
										 <form:option value="${msg.id}" >${msg.descSigla} </form:option> 
									</c:forEach>    		
					        	 </form:select> 
            </div>
      
            <div class="small-3 columns left" >
              
               <demdec:label path="numero"  labelKey="label.numero"/> 
					           <form:input path="numero" maxlength="6"/> 
            </div>
            
             <div class="small-3 columns left">            
	             <demdec:label path="annoEse"  labelKey="label.anno"/>
	       		 <form:select path="annoEse"   > 
	       		 	<form:option value="" >&nbsp;</form:option>
	          		<c:forEach var="msg" items="${listAnniEser}">		
						 <form:option value="${msg.id}" >${msg.id} </form:option> 
					</c:forEach>    		
	        	 </form:select>  
     		</div>
     		 <div class="small-3 1columns left padd-top_17">
             <%--  <a href="javascript:sottometti()">Invia a FAD</a>--%>
               
              <%-- <demdec:submit styleClass="nascosto" styleId="apriInviaAFad" keyValue="label.empty" controllerCode="inviaAFad"/>
				<a href="javascript:this.document.getElementById('apriInviaAFad').click();">
              		<img src="<%=request.getContextPath()%>/public/img/ico_send.png" alt="Invia a FAD">
				</a> --%>
               <demdec:submit keyValue="button.Fad.invia" controllerCode="inviaAFad"   styleClass="button small" styleId="btnInvioAFad"/>
              
                          
            </div>
           </div>
          
           
		  <div class="row" >
		    <div class="small-10 columns">
		   		 <button type="button"  class="button small" onclick="javascript:caricaPopup('contModal_0', 'modaleListaDecretiRaccProvv');" ><demdec:label  labelKey="label.title.ricercaRed"/></button>
	        	 <%-- <button type="button"  class="button small" onclick="javascript: pulisci();" > <demdec:label  labelKey="label.clean"/></button>--%>	
	        	  <demdec:submit keyValue="button.clean" controllerCode="pulisciDocumentiFascicolo"   styleClass="button small"/> 
	        	  
		    </div>
		  </div>
		  
		   </fieldset>
    <%--/form--%>
<!--**INIZIO INCLUDE MODALE modaleRicercaFascicoliFAD.jsp -->	
<%@include file="/private/jsp/modal/modaleRicercaFascicoliFAD.jsp" %>  
<!-- END INCLUDE MODALE Selezione Decreto   modaleRicercaFascicoliFAD.jsp -->     

  
<div class="overlay"></div>


  <div>


	 <c:if test="${not empty listDocumentiFascicolo}">
	 	<table id="listDocumentiFascicolo"  class="lux tableDati width100" >
	 		<caption>
				<span class="nascosto">
					<spring:message code="label.raccolteProvvisorie.documentiFascicolo"/>
				</span>
			</caption>
			<thead>
				<tr>
					<th scope="col">
						<input type='checkbox' id='selectall' title='Seleziona tutti'/>
					</th>
					<th scope="col">
						<spring:message code="label.raccolteProvvisorie.preView"/>
					</th>
					<th scope="col">
						<spring:message code="label.raccolteProvvisorie.pdf"/>
					</th>
					<th scope="col">
						<spring:message code="label.raccolteProvvisorie.originale"/>
					</th>
					<th scope="col">
						<spring:message code="label.raccolteProvvisorie.tipoAllegati"/>
					</th>
					<th scope="col">
						<spring:message code="label.raccolteProvvisorie.amministrazione"/>
					</th>
					<th scope="col">
						<spring:message code="label.raccolteProvvisorie.dataCreazione"/>
					</th>
					<th scope="col">
						<spring:message code="label.raccolteProvvisorie.nome"/>
					</th>
					<th scope="col">
						<spring:message code="label.raccolteProvvisorie.associato"/>
					</th>
					<th scope="col">
						<spring:message code="label.raccolteProvvisorie.visualizzaMetadati"/>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listDocumentiFascicolo}" var="item" varStatus="varStatus">
					<tr class="${item.rowClassStyle}">
						<td class="center">
							<label for="selezioniDocumentiFasc${varStatus.count}"  ></label>
							<form:checkbox path="documentiRaccoltaProvvisorieList[${varStatus.count-1}].selezioniDocumentiFasc"  value="1" cssClass="checkPlut optim" /> 	
						</td>
						<td class="center">
			 				<c:if test="${not empty item.preView}">
								<a href="javascript: caricaModaleAnteprima('${varStatus.count -1}','<%=SessionAttributes.LIST_DOCUMENTI_FASCICOLO%>'); " >
									<img  src="<%=request.getContextPath()%>/public/img/ico_preview.png" alt="Visualizza Anteprima" title="Visualizza Anteprima">
								</a>			
							</c:if>
						</td>
						<td class="center">
							<c:if test="${item.idDocumento ne null}">
								<a href="<%=request.getContextPath()%>/private/ricercaRed.do?cmdGET___download=download&amp;tipoDownl=1&amp;idDocumento=${item.idDocumento} " >
									<img  src="<%=request.getContextPath()%>/public/img/ico_pdf.png" alt="Documento Pdf" title="${item.documentoFileOperazione.fileName}">
								</a>
							</c:if>
							<c:if test="${item.idDocumento eq null}">
								<img  src="<%=request.getContextPath()%>/public/img/ico_pdf_conv.png" alt="Documento Pdf">
							</c:if>
						</td>
						<td class="center">
							<a href="<%=request.getContextPath()%>/private/ricercaRed.do?cmdGET___download=download&amp;tipoDownl=2&amp;idDocumento=${item.idDocumentoRaccoltaProvvisoria}" >
								<img  src="<%=request.getContextPath()%>/public/img/ico_download.png" alt="Documento Originale" title="${item.documentoContent.fileName}">
							</a>
						</td>
						<td class="center">
							${item.tipoDocumento.description}
						</td>
						<td class="center">
							${item.amministrazione.code}
						</td>
						<td class="center">
							${item.dataCreazione}
						</td>
						<td class="center">
					 		<label for="tipoAllegati"/></label>
					 		<form:select path="documentiRaccoltaProvvisorieList[${varStatus.count-1}].tipoAllegati">
					 			<form:option value="" >&nbsp;</form:option>
								<c:choose>
									<c:when test="${item.tipoDocumento.code=='RP01'}">
										<c:forEach var="tipoAll" items="${tipoAllegatiList}">
											<form:option value="${tipoAll.id}-${tipoAll.textDescrizione}" >${tipoAll.textDescrizione}</form:option>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach var="tipoAll" items="${tipoAllegatiList2}">
											<form:option value="${tipoAll.id}-${tipoAll.textDescrizione}" >${tipoAll.textDescrizione}</form:option>
										</c:forEach>
									</c:otherwise>	
								</c:choose>
					 		</form:select>
						</td>
						<td class="center">
					 		<label for="read_${varStatus.count}00"  class="nascosto">Associazione a</label>
					 		<form:textarea path="documentiRaccoltaProvvisorieList[${varStatus.count-1}].fascicoliAssociati" cols="45" readonly="true"/>
						</td>
						<td class="center">
							<a href="javascript: caricaModaleMetadatiDocRed('contModal_2', '${varStatus.count}'); " >
								<img  src="<%=request.getContextPath()%>/public/img/ico_view_det.png" alt="Visualizza Metadati">
							</a>			
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<%-- 		<demdec:displaytag-table  name="pageScope.listDocumentiFascicolo" id="listDocumentiFascicolo"  class="lux tableDati width100" >
			<display:caption><span class="nascosto"><demdec:label  labelKey="label.raccolteProvvisorie.documentiFascicolo"/></span></display:caption>
			
			
		
			<demdec:displaytag-column titleKey="" title="<input type='checkbox' id='selectall' title='Seleziona tutti'/>" class="center">	
				 <label for="selezioniDocumentiFasc${listDocumentiFascicolo_rowNum}"  ></label>
				 <form:checkbox path="documentiRaccoltaProvvisorieList[${listDocumentiFascicolo_rowNum-1}].selezioniDocumentiFasc"  value="1" cssClass="checkPlut optim" /> 	
			</demdec:displaytag-column>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.preView"  class="center">
			
 				<c:if test="${not empty listDocumentiFascicolo.preView}">
					<a href="javascript: caricaModaleAnteprima('${listDocumentiFascicolo_rowNum -1}','<%=SessionAttributes.LIST_DOCUMENTI_FASCICOLO%>'); " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_preview.png" alt="Visualizza Anteprima" title="Visualizza Anteprima">
					</a>			
				</c:if>
				
			</demdec:displaytag-column>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.pdf"  class="center">
			
			<c:if test="${listDocumentiFascicolo.idDocumento ne null}">
				<a href="<%=request.getContextPath()%>/private/ricercaRed.do?cmdGET___download=download&amp;tipoDownl=1&amp;idDocumento=${listDocumentiFascicolo.idDocumento} " >
					<img  src="<%=request.getContextPath()%>/public/img/ico_pdf.png" alt="Documento Pdf" title="${listDocumentiFascicolo.documentoFileOperazione.fileName}">
				</a>
			</c:if>
			<c:if test="${listDocumentiFascicolo.idDocumento eq null}">
				<img  src="<%=request.getContextPath()%>/public/img/ico_pdf_conv.png" alt="Documento Pdf">
			</c:if>
				
			</demdec:displaytag-column>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.originale" class="center" >
					<a href="<%=request.getContextPath()%>/private/ricercaRed.do?cmdGET___download=download&amp;tipoDownl=2&amp;idDocumento=${listDocumentiFascicolo.idDocumentoRaccoltaProvvisoria}  " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_download.png" alt="Documento Originale" title="${listDocumentiFascicolo.documentoContent.fileName}">
					</a>
			</demdec:displaytag-column>
			
			<demdec:displaytag-column property="tipoDocumento.description"  titleKey="label.raccolteProvvisorie.tipoAllegati" />
			<demdec:displaytag-column sortName="amministrazione.code"  property="amministrazione.code" titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
			<demdec:displaytag-column property="dataCreazione" titleKey="label.raccolteProvvisorie.dataCreazione"  class="center"/> --%>
		<%-- 	<demdec:displaytag-column property="sistemaProduttore" titleKey="label.raccolteProvvisorie.origineCreazione"  /> --%>
		<%-- 	<demdec:displaytag-column   titleKey="label.raccolteProvvisorie.dataModifica" />
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.modificatoDa"  /> --%>
<%-- 			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.nome" class="center" >
			 		<label for="tipoAllegati"/></label>
			 		<form:select path="documentiRaccoltaProvvisorieList[${listDocumentiFascicolo_rowNum-1}].tipoAllegati">
			 			<form:option value="" >&nbsp;</form:option>
						<c:choose>
							<c:when test="${listDocumentiFascicolo.tipoDocumento.code=='RP01'}">
								<c:forEach var="tipoAll" items="${tipoAllegatiList}">
									<form:option value="${tipoAll.id}-${tipoAll.textDescrizione}" >${tipoAll.textDescrizione}</form:option>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="tipoAll" items="${tipoAllegatiList2}">
									<form:option value="${tipoAll.id}-${tipoAll.textDescrizione}" >${tipoAll.textDescrizione}</form:option>
								</c:forEach>
							</c:otherwise>	
						</c:choose>
			 		</form:select> --%>
<%-- 			        <select name="tipoAllegati${listDocumentiFascicolo.idDocumentoRaccoltaProvvisoria}"   >
						<option value="" >&nbsp;</option>		
						
						<c:choose>	
									<c:when test="${listDocumentiFascicolo.tipoDocumento.code=='RP01'}">
											<c:forEach var="msg" items="${tipoAllegatiList}">
													 		<c:set var="myVar" value="${msg.id}-${msg.textDescrizione}" />
															<c:choose>	
															  
															   <c:when test="${ listDocumentiFascicolo.descDocumento.code == myVar || listDocumentiFascicolo.descDocumento.code == msg.id  }">
																
															   	     <option value="${msg.id}-${msg.textDescrizione}" selected >${msg.textDescrizione}</option>	
																  </c:when>
																  <c:otherwise>
																 		 <option value="${msg.id}-${msg.textDescrizione}" >${msg.textDescrizione}</option>
																  </c:otherwise>	
															 </c:choose>				 
											</c:forEach> 				
									</c:when>
									<c:otherwise>
												<c:if test="${listDocumentiFascicolo.tipoDocumento.code=='RP02'}">
														<c:forEach var="msg" items="${tipoAllegatiList2}">
															<c:set var="myVar2" value="${msg.id}-${msg.textDescrizione}" />
															<c:choose>	
															      <c:when test="${ listDocumentiFascicolo.descDocumento.code == myVar2 || listDocumentiFascicolo.descDocumento.code == msg.id  }">
																	     <option value="${msg.id}-${msg.textDescrizione}"  selected>${msg.textDescrizione}</option>	
																  </c:when>
																  <c:otherwise>
																 		 <option value="${msg.id}-${msg.textDescrizione}" >${msg.textDescrizione}</option>
																  </c:otherwise>	
															 </c:choose>				 
														</c:forEach> 
												</c:if>
									</c:otherwise>	
						</c:choose>
										           
						<c:forEach var="msg" items="${tipoAllegatiList}">
							<c:choose>	
							      <c:when test="${listDocumentiFascicolo.descDocumento.code eq msg.id}">					
									     <option value="${msg.id}" selected>${msg.descDescrizioneDoc}</option>	
								  </c:when>
								  <c:otherwise>
								 		 <option value="${msg.id}" >${msg.descDescrizioneDoc}</option>
								  </c:otherwise>	
							 </c:choose>				 
						</c:forEach> 
						
						
			         </select>  --%>
<%-- 	      	</demdec:displaytag-column>									 
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.associato" class="center" >
						 		<label for="read_${listDocumentiFascicolo_rowNum}00"  class="nascosto">Associazione a</label>
						 		<form:textarea path="documentiRaccoltaProvvisorieList[${listDocumentiFascicolo_rowNum-1}].fascicoliAssociati" cols="45" readonly="true"/> --%>
<%-- 								<textarea cols="45" id="read_${listDocumentiFascicolo_rowNum}00" readonly>${listDocumentiFascicolo.fascicoliAssociati}</textarea> --%>								
<%-- 			</demdec:displaytag-column>

				
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center" >				
					<a href="javascript: caricaModaleMetadatiDocRed('contModal_2', '${listDocumentiFascicolo_rowNum}'); " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_view_det.png" alt="Visualizza Metadati">
					</a>			
			</demdec:displaytag-column>
		</demdec:displaytag-table> --%>
  		
	 </c:if>

	 <c:if test="${paginator ne null}">
		<div>&nbsp;</div>
	     <div class="center color_grey">
	         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
	                         paginatorName="<%=Paginator.PAGINATOR_NAME%>"
	                         paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
	                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
	     </div>    
	     <div>&nbsp;</div>
 	</c:if>  
	 
	<%-- <div id="emptyList">
	<c:if test="${empty listDocumentiFascicolo}">
		<spring:message code="info.noDataFound"></spring:message>
	</c:if>
	</div> --%>
	
</div>
			<%-- <div class="spacer_sm">&nbsp;</div>
		  <div class="row center" >
		 
			 <demdec:submit keyValue="button.Fad.invia" controllerCode="inviaAFad"   styleClass="button small"/>
		  <demdec:submit keyValue="button.ritornoLista" controllerCode="pulisciRaccolteProvvisorie"   styleClass="button small"/> 
		  </div>	 --%>

 <div class="clear_both">&nbsp;</div>
	<c:if test="${not empty listDocumentiFascicolo}">
    <div class="text-center">
    	<demdec:buttons>
    		 <demdec:submit keyValue="button.Fad.invia" controllerCode="inviaAFad"   styleClass="button small" styleId="btnInvAFad"/>
		  <demdec:submit keyValue="button.ritornoLista" controllerCode="pulisciRaccolteProvvisorie"   styleClass="button small"/> 
    	</demdec:buttons>
    </div>
    </c:if>
    
    
</div>  

