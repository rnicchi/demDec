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
<!-- PageName = startRevSospFirme.jsp -->
<tiles:useAttribute name="action" classname="java.lang.String" />

   <demdec:useAttribute id="listTipiDecr" name="<%=WebConstants.LIST_TIPI_DECRETI%>"/>  
   <demdec:useAttribute id="listAnniEser" name="<%=WebConstants.LIST_ANNO_ESE%>"/> 
    <demdec:useAttribute id="buttonNascosto" name="buttonNascosto"/> 
<script type="application/javascript">
var jsonData;
</script>

 <%-- <form> --%>
  <fieldset>
  	<legend>${legend}   Decreti Sospesi - Ricerca</legend>

     <%@include file="/private/jsp/form/ricercaTipoNumeroAnno.jsp" %>  
		  <div class="row" >
		    <div class="small-10 columns">
		    	<button type="button"  class="button small" onclick="javascript:caricaPopup('contModal_0','modaleRevocaSospensioneFirme');" > <demdec:label  labelKey='label.title.ricercaRed'/></button>
		    	<demdec:submit keyValue="button.clean" controllerCode="pulisci"   styleClass="button small"/>
		    </div>
		  </div>
		  
	</fieldset>
    
 <%--     </form>  --%>
  <div>
 <!--**INIZIO INCLUDE MODALE modaleRicercaFascicoliFAD.jsp -->	
	<%--@include file="modaleRicercaFascicoliFAD.jsp" 
	--%>    
 	<%@include file="/private/jsp/modal/modaleRicercaFascFadRevSosp.jsp" %>  
</div>
<!-- END INCLUDE MODALE Selezione Decreto   modaleRicercaFascicoliFAD.jsp --> 
 <div class="overlay"></div>
 <br>
   <div class="row">
  	      <div class="small-10 columns" id="revSospButton" >
	    	<%--  <demdec:submit keyValue="button.revocaSospFirme" controllerCode="revocaSospensioneFirme"  styleClass="button small" />  --%>    
	      </div>
	  
  </div>

<script type="text/javascript">
	
	function confermaModificaUtente(){
		if ($("#listProfUfficiAmm").length==0 && $("#codiUtente").val()!="" && $("#persCognome").val()!="" && $("#persNome").val()!=""){
			return confirm('L\'operazione Riavvia Workflow comporta la cancellazione dell\'atto decreto firmato. Procedere?');
		}else{
			return;
		}
	}
	
</script>
