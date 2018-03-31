<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.utils.Constants"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="sbfj"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- info.jsp --%>
<sbfj:useAttribute id="actualAction" name="<%=SessionAttributes.OBJECT_INCOMING_REQUEST_URI%>" type="java.lang.String"/>
<sbfj:useAttribute id="utente" name="<%=SessionAttributes.OBJECT_USER%>"/>
<sbfj:useAttribute id="profilo" name="<%=SessionAttributes.OBJECT_PROFILO%>"/>

<div id="sf_eng">


  <div class="area_ris_eng">
    <ul class="menu">
        <li>
        	<img src="<c:url value="/public/img/ico_user.png"/>" alt="" class="inline" />
        	<span class="col_char_user">${utente.persCognome} ${utente.persNome}&nbsp;&#8226;&nbsp;${profilo.descProfilo}&nbsp;&nbsp;&nbsp;</span>
        </li>
        <c:if test="${utente.multiProfilo }">
	      	<li>
	        	<img src="<c:url value="/public/img/ico_ch_user.png"/>" alt="" class="inline hidd" />
	        	<a href="<c:url value="/private/cambioProfilo.do"/>" title="Cambio profilo">Cambio profilo</a>
	        </li>
        </c:if>
        <li>
        	<img src="<c:url value="/public/img/ico_uscita.png"/>" alt="" class="inline hidd" />
        	<a href="<c:url value="/public/uscita.do"/>" title="Esci">Esci</a>
        </li>
    </ul>
  </div>
  
</div>
