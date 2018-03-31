<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display-el"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="sbsj"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
 
<div class="box">	
	<!-- PARAMETRI -->
	<tiles:insertAttribute name="commonPanelSearch" flush="true" ignore="true"/>
	<!-- PARAMETRI -->	

	<!-- TOTALI -->
	<tiles:insertAttribute name="commonTotali"  flush="true" ignore="true"/>
	<!-- TOTALI -->			
</div>	