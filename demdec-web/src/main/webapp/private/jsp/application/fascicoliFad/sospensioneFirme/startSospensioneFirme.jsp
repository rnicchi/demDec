<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!-- PageName = startSospensioneFirme.jsp -->
<tiles:useAttribute name="action" classname="java.lang.String" />

<demdec:useAttribute id="listTipiDecr" name="<%=WebConstants.LIST_TIPI_DECRETI%>"/>  
<demdec:useAttribute id="listAnniEser" name="<%=WebConstants.LIST_ANNO_ESE%>"/> 
<script type="application/javascript">
var jsonData;
</script>

  <fieldset>
  	 <legend>${legend}   Decreti in firma - Ricerca</legend>

     <%@include file="/private/jsp/form/ricercaTipoNumeroAnno.jsp" %>  
          
		  <div class="row" >
		    <div class="small-10 columns">
		    	<button type="button"  class="button small" onclick="javascript:caricaPopup('contModal_0');" > <demdec:label  labelKey='label.title.ricercaRed'/></button>
		    	<demdec:submit keyValue="button.clean" controllerCode="pulisci"   styleClass="button small"/>
		    </div>
		  </div>
  </fieldset>
    
  <div>
    <!--**INIZIO INCLUDE MODALE modaleRicercaFascFadSosp.jsp -->		  
 	<%@include file="/private/jsp/modal/modaleRicercaFascFadSosp.jsp" %>  
 	<!-- END INCLUDE MODALE Selezione Decreto   modaleRicercaFascFadSosp.jsp --> 
</div>

 <div class="overlay"></div>
 <br>
   <div class="row">
      <div class="small-10 columns" id="sospButton">
      
      </div>
  </div>

