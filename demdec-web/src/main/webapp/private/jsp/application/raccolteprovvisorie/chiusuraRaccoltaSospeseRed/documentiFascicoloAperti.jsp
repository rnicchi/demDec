<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>


<!-- PageName = documentiFascicoloAperti -->
<demdec:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/>
<demdec:useAttribute id="listTipiDecr" name="<%=WebConstants.LIST_TIPI_DECRETI%>"/>  
<demdec:useAttribute id="tipoAllegatiList" name="<%=WebConstants.LIST_TIPO_ALLEGATI%>" /> 
<demdec:useAttribute id="listDocumentiFascicolo" name="<%=SessionAttributes.LIST_DOCUMENTI_FASCICOLO_SOSP%>" /> 
<demdec:useAttribute id="listAnniEser" name="<%=WebConstants.LIST_ANNO_ESE%>"/> 
 <demdec:useAttribute id="numDataProtocollo" name="numDataProtocollo"/>

<tiles:insertAttribute name="modalFascDocRedSosp" flush="false"/>
 
 <script type="application/javascript">

function pulisci(){
	this.document.getElementById('__FORM__').action='<%=request.getContextPath()%>/private/ricercaRed.do?cmdPOST___pulisciDocumentiFascicolo=pulisciDocumentiFascicolo';
	this.document.getElementById('__FORM__').submit();
}

</script>

<script type="application/javascript">
var jsonData;


$(document).ready(function() {

    $("#ritLista").click(function() {

        $('body').css("cursor", "wait");

    });

});
</script>

  
<div class="overlay"></div>


  <div>


	 <c:if test="${not empty listDocumentiFascicolo}">

		<div class="spacer_sm">&nbsp;</div>
		<div class="spacer_sm">&nbsp;</div>
		<%-- <div class="title_doc"><spring:message code="label.raccolteProvvisorie.documentiFascicolo"></spring:message></div>--%>
		 
		<div class="center padd-bott_5 font_size_riep">
		    <span><strong>&#8226; Protocollo:</strong> </span>
		    <span class="col_char_user"><strong>${numDataProtocollo}</strong></span> 
		</div>
	
		<div class="spacer_sm_10">&nbsp;</div>

		<demdec:displaytag-table  class="width100"  name="pageScope.listDocumentiFascicolo" id="listDocumentiFascicolo" summary="label.raccolteProvvisorie.documentiFascicolo"   >
			<display:caption><span class="nascosto"><demdec:label  labelKey="label.raccolteProvvisorie.documentiFascicolo"/></span></display:caption>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.preView"  class="center">
			
 				<c:if test="${not empty listDocumentiFascicolo.preView}">
					<a href="javascript: caricaModaleAnteprima('${listDocumentiFascicolo_rowNum - 1}','<%=SessionAttributes.LIST_DOCUMENTI_FASCICOLO_SOSP%>'); " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_preview.png" alt="Visualizza Anteprima" title="Visualizza Anteprima">
					</a>			
				</c:if>
				
			</demdec:displaytag-column>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.pdf" class="center" >
					
					<c:if test="${listDocumentiFascicolo.idDocumento ne null}">
						<a href="<%=request.getContextPath()%>/private/ricercaSospesiRed.do?cmdGET___download=download&amp;tipoDownl=1&amp;idDocumento=${listDocumentiFascicolo.idDocumento} " >
						<img  title="Documento in formato PDF " src="<%=request.getContextPath()%>/public/img/ico_pdf.png" alt="Documento in formato PDF">
						</a>
					</c:if>
					
					<c:if test="${listDocumentiFascicolo.idDocumento eq null}">
						<img  src="<%=request.getContextPath()%>/public/img/ico_pdf_conv.png" alt="PDF da convertire" title="PDF da convertire">
					</c:if>
					
			</demdec:displaytag-column>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.originale" class="center" >
					<a href="<%=request.getContextPath()%>/private/ricercaSospesiRed.do?cmdGET___download=download&amp;tipoDownl=2&amp;idDocumento=${listDocumentiFascicolo.idDocumentoRaccoltaProvvisoria}  " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_download.png" alt="Scarica originale" title="Scarica originale">
					</a>
			</demdec:displaytag-column>
			
			<demdec:displaytag-column property="tipoDocumento.description"  titleKey="label.raccolteProvvisorie.tipoAllegati" />
			
			<demdec:displaytag-column sortName="amministrazione.code"  property="amministrazione.code" titleKey="label.raccolteProvvisorie.amministrazione" class="center"/>
			<demdec:displaytag-column property="dataCreazione" titleKey="label.raccolteProvvisorie.dataCreazione"  class="center"/>
			<demdec:displaytag-column property="descrizione"  titleKey="label.raccolteProvvisorie.nome" />
		<%-- 	<demdec:displaytag-column property="sistemaProduttore" titleKey="label.raccolteProvvisorie.origineCreazione"  />
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.dataModifica" />
			<demdec:displaytag-column titleKey="label.raccolteProvvisorie.modificatoDa"  /> --%>
			<demdec:displaytag-column  titleKey="label.raccolteProvvisorie.visualizzaMetadati" class="center" >				
					<a href="javascript: caricaModaleMetadatiDocRed('contModal_2', '${listDocumentiFascicolo_rowNum}'); " >
						<img  src="<%=request.getContextPath()%>/public/img/ico_view_det.png" alt="Visualizza Metadati">
					</a>			
			</demdec:displaytag-column>
		</demdec:displaytag-table>

	 </c:if>

	 <c:if test="${paginator ne null}">
		<div>&nbsp;</div>
	     <div class="center color_grey">
	         <demdec:paginator controllerCode="<%=Paginator.PARAMETER_PAGINATOR%>"
	         				 paginatorName="<%=Paginator.PAGINATOR_NAME%>"
	                         paginatorSessionName="<%=SessionAttributes.OBJECT_PAGINATOR%>"
	                         controllerCodeEnableDisablePagin="<%=Paginator.PARAMETER_ENABLE_DISABLE_PAGIN%>" />
	     </div>                       
 	</c:if>  

</div>

<div class="spacer_sm">&nbsp;</div>
<div class="row center" >
	<demdec:submit keyValue="button.ritornoLista" controllerCode="backToList"   styleClass="button small" styleId="ritLista"/>
</div>	
