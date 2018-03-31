<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!-- PageName = selezionaAmm.jsp -->
<demdec:useAttribute id="amministrazioneList"	name="<%=WebConstants.LIST_AMMIN_DEM%>" />
<%-- <demdec:useAttribute id="rowsMap"	name="<%=WebConstants.LIST_ROWS%>" /> --%>

 
 
 <h2 class="nascosto">Tabella</h2>

 <div class="spacer_sm">&nbsp;</div>

<div class="title_doc">Selezione Amministrazione</div>


 <div class="spacer_sm_10">&nbsp;</div>





<form:hidden path="annoDec"/>
<form:hidden path="tipoDec"/>
<form:hidden path="numDec"/>
<form:hidden path="descDec"/>
<form:hidden path="tipologiaDec"/>
<form:hidden path="numPatr"/>
<form:hidden path="cdrRows"/>
<form:hidden path="ufficio"/>
<form:hidden path="flagNormativo"/>


			
		<demdec:displaytag-table name="pageScope.amministrazioneList" id="amministrazioneList" class="lux width100">	
				<display:caption>
						<span class="nascosto">Lista Amministrazioni</span>
				</display:caption>
				<demdec:displaytag-column titleKey="label.selection"  class="center">
						 <label for="ammRows${amministrazioneList_rowNum}"  ></label>
						 <form:checkbox   path="ammRows"	 value="${amministrazioneList_rowNum}"  cssClass="optim"  />  
				</demdec:displaytag-column>
				<demdec:displaytag-column property="id.ammin" titleKey="label.amministrazione" class="center" />
				<demdec:displaytag-column property="descAmm" titleKey="label.descrizione"   />
		</demdec:displaytag-table> 
		
		
<br />

<div class="center">

      	 <demdec:submit keyValue="label.confirm" controllerCode="backFromAmm" titleKey="label.conferma.amm"/>
      	 <demdec:submit keyValue="label.back" controllerCode="cancelFromAmm" titleKey="label.back" />
      	<%--  <a href="<%=request.getContextPath() %>/public/ricercaRed.do?cmdGET___recuperaDatiModale=recuperaDatiModale">lnk</a> --%>
      <%-- 	 <demdec:linkButton labelKey="label.exportExcel" imageKey="ico.exportExcel" action="/public/ricercaRed.do" parameter="recuperaDatiModale" parameterValue="__EXPORT_GENERIC_EXCEL__" /> --%>
		<%--<demdec:submit keyValue="button.back" controllerCode="back" /> --%>
        
          <!--  button type="submit">Cerca</button> -->
      </div>

	


