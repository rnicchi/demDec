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


    <div id="contModal_5_doc" class="box_pin">
        
        
    
        <div id="title_modal_1"><strong><spring:message code="label.consFadCdc.estremiRegistrazione"/></strong></div>
        
        <div>
        
            <!--INI SCROLL-->
            
            <!--END SCROLL-->

             		 <div class="spacer_sm">&nbsp;</div>


                      <!--<div class="spacer">&nbsp;</div>-->
                      <!--<div class="spacer_sm">&nbsp;</div>-->
        				<div class="row">
	                      <div class="small-12 columns">
	                              <label for="numeRegistrazioneCdc"><spring:message code="label.consFadCdc.numeRegistrazione"/></label>
	                             	<form:input path="numeRegistrazioneCdc"   maxlength="10" />
	                      </div>
                       </div>
                  
                      <div class="row">
						<div class="small-12 columns">
							<label for="dataRegistrazioneCdc"> <spring:message code="label.consFadCdc.dataRegistrazione"/></label>
							<form:input path="dataRegistrazioneCdc" placeholder="gg/mm/aaaa"  maxlength="10" />
						</div>
					 </div>
					 
					 <div class="row">
	                      <div class="small-12 columns">
	                              <label for="numeUfficioCdc"><spring:message code="label.consFadCdc.numeUfficio"/></label>
	                             	<form:input path="numeUfficioCdc"   maxlength="2" />
	                      </div>
                       </div>
                      
                      <div class="spacer_sm">&nbsp;</div>
                      
                      <div class="small-12 columns">
                      	<nssb:buttons>
                      		<demdec:submit keyValue="button.salva" controllerCode="salvaDatiRegistrazioneCdc" styleClass="button small "/>
                      		<button id="undo_pin" type="button" class="button small " onclick="javascript:chiudiModale();"><spring:message code="label.exit"/></button> 
                      	</nssb:buttons>
                      </div>
        
				</div>

              <div class="spacer_sm">&nbsp;</div>
             <p class="chiudi_pin"><spring:message code="label.chiudiPin"/></p>
              
              
	</div>
       
<!--</div>-->
<!-- END MODALE DOC--> 

  
