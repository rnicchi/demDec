<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>

<%-- <%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
 --%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- PageName = ricercaFAD.jsp -->
<!-- Controller  ConsultaFascicoloFadController-->



<div class="overlay"></div>


<div class="spacer_sm">&nbsp;</div>

	
	<div class="row">
		<div class="small-10 columns">
			
			<form:hidden path="conferma"/>
			<form:hidden path="radioButtonDecreti" />
			<demdec:submit keyValue="button.conferma" controllerCode="stampa"  />
			&nbsp;
			<demdec:submit keyValue="button.annulla" controllerCode="backFromLettere"   />
		</div>
	</div>
	


