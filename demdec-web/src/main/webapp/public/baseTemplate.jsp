<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="it" ><![endif]-->
<!--[if gt IE 8]><!-->
<!-- basetemplate.jsp -->
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%><!--  html xmlns="http://www.w3.org/1999/xhtml"-->
<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	response.setHeader("Pragma","no-cache");
%>
<%
	response.setHeader("Cache-Control","no-store");
%>
<%
	response.setDateHeader("Expires",-1);
%>
<html style="" class=" js no-touch svg inlinesvg svgclippaths no-ie8compat" lang="it"><!--<![endif]-->

<head>

<meta http-equiv="content-type" content="text/html; charset=windows-1252">

<!--<meta charset="utf-8">-->

 <meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Fogli di stile CSS -->
		<link rel="stylesheet" href="<c:url value="/public/css/normalize.css"/>"/>
		<link rel="stylesheet" href="<c:url value="/public/css/foundation.css"/>"/>
		<link rel="stylesheet" href="<c:url value="/public/css/style_a.css"/>"/>  
		<link rel="stylesheet" href="<c:url value="/public/css/firebugR.css"/>"/>

</head>
<%
	try{
%> 
<tiles:useAttribute name="title"/>

<!--<body style="padding-top: 45px;">-->
<body>
<!-- Header/navigazione top bar -->
<header class="fixed">

<div id="sf_eng">


  <div class="area_ris_eng">
    <ul class="menu">
    </ul>
  </div>
  
</div>


<div id="Cont_logo"><img class="padd_sx_logo" src="<c:url value="img/logo_DEMDEC.jpg"/>" alt="Vai alla home"></div>

</header>
<!-- Inizio griglia -->
<!-- Sezione titoli in evidenza con slideshow -->
<div class="container">
	<div class="spacer">&nbsp;</div>
	
	<section id="lanci-servizi" class="margine-bottom">
		<div class="row">
			<div class="large-12 columns">
				<h2><spring:message code="${title}"/></h2>
				<a id="<%=WebConstants.ANCHOR_START_TITOLO%>"></a>
			</div>
		</div>
		<div class="large-12 columns">
			<nssb:form modelAttribute="<%=SessionAttributes.FORM%>">
				<!--  tiles:insertAttribute name="info" flush="true"/-->
				<!--  tiles:insertAttribute name="navigator" flush="true"/-->
				<tiles:insertAttribute name="page" flush="true"/>
			</nssb:form>
		</div>
	</section>
	<!-- Footer -->
	<footer>
		<div class="row">
			<div class="large-12 columns">
				<p class="right">Copyright 2015 � RGS Ragioneria Generale dello Stato</p>
			</div>
		</div>
	</footer>
</div>

</body>
<%
	}catch(Throwable t){
	if ((t.getMessage()==null) || (!t.getMessage().contains("Broken pipe"))){	 
		ContextHelper.addError(request, "error.applicativo.dettaglio", t.getMessage());
		 it.almavivaitalia.bsn.sh.utils.TraceLogger.errorLog("errore nella jsp:", this.getClass(), t);
//		 request.getRequestDispatcher(it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping.PUBLIC_ERROR_URL).forward(request, response);
	}
}
%>
</html>