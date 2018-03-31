<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%> 
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


<script type="application/javascript">
function chiudiModale() {

	$('.overlay').fadeOut('fast');
    $('.box').hide();
	$('.box_pin').hide();
}
</script>




<!-- PageName = firmaDocumenti.jsp -->
<nssb:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/> 

<nssb:useAttribute id="listaADToSign" name="<%=SessionAttributes.LIST_AD_TO_SIGN%>"/>
<!-- INI MODALE DOC--> 
<!--<div>-->


  
    
    <div id="contModal_2_doc" class="box_pin">
        
        <div id="title_modal_2"><strong><spring:message code="label.consFadCdc.datiProtocolloUscita"/></strong></div>
        
        <div>
        
            <!--INI SCROLL-->
            
            <!--END SCROLL-->

              <div class="spacer_sm">&nbsp;</div>


                      <!--<div class="spacer">&nbsp;</div>-->
                      <!--<div class="spacer_sm">&nbsp;</div>-->
        				<div class="row">
	                      <div class="small-12 columns">
	                              <label for="numeProtUscitaMod"><spring:message code="label.consFadCdc.numeProtUscita"/></label>
	                             	<form:input path="numeProtUscitaMod"   maxlength="50" />
	                      </div>
                       </div>
                      <div class="spacer_sm">&nbsp;</div>
                      <div class="row">
						<div class="small-12 columns">
							<label for="dataProtUscitaMod"> <spring:message code="label.consFadCdc.dataProtUscita"/></label>
							<form:input path="dataProtUscitaMod" placeholder="gg/mm/aaaa"  maxlength="10" />
						</div>
					 </div>
                      
                      <div class="spacer_sm">&nbsp;</div>
                      
                      <div class="small-12 columns">
                      	<nssb:buttons>
                      		<demdec:submit keyValue="button.salva" controllerCode="salvaDatiProtUscitaCdc" styleClass="button small "/>
                      		<%-- <demdec:submit styleId="undo_pin" keyValue="button.annulla" controllerCode="" styleClass="button small " onclick="return close();"/>--%> 
                      		<button id="undo_pin" type="button" class="button small " onclick="javascript:chiudiModale();"><spring:message code="label.exit"/></button> 
                      	</nssb:buttons>
                      </div>
        
				</div>

              <div class="spacer_sm">&nbsp;</div>
             
              <p class="chiudi_pin"><spring:message code="label.chiudiPin"/></p>
              
              
	</div>
       
<!--</div>-->
<!-- END MODALE DOC--> 

  
