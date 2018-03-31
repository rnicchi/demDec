<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>



<nssb:useAttribute id="error" name="<%=SessionAttributes.OBJECT_DEVELOPER_ERROR%>"/>

<c:out value="${error}"/>