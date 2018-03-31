<!-- INIZIO MODALE INSERIMENTO PIN -->
<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <div class="overlay"></div>
    
    <div id="contModal_1_doc" class="box_pin">
        
        <div id="title_modal_1"><strong><spring:message code="label.title.modal"/></strong></div>
        
        <div>
        
            <!--INI SCROLL-->
            
            <!--END SCROLL-->

              <div class="spacer_sm">&nbsp;</div>


                      <div class="small-12 columns">
                              <label for="pin"><spring:message code="label.pin"/></label>
                             	<form:password path="pin" id="pin"  maxlength="8"/>
                      </div>
                      
                      <div class="spacer_sm">&nbsp;</div>
                      
                      <div class="small-12 columns">
                      	<demdec:buttons>
                      		<demdec:submit keyValue="button.conferma" controllerCode="digestTagVisibile" styleClass="button small " styleId="conferma"/>
                      		<button id="undo_pin" type="button" class="button small " onclick="javascript:close();"><spring:message code="button.annulla"/></button> 
                      	</demdec:buttons>
                      </div>
		</div>

              <div class="spacer_sm">&nbsp;</div>
              <p class="chiudi_pin"><spring:message code="label.chiudiPin"/></p>
              
	</div>
<!-- INIZIO MODALE INSERIMENTO PIN -->