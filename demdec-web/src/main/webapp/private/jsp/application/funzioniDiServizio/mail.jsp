<%@page import="it.almavivaitalia.web.sh.utils.ContextHelper"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%> 

<!-- PageName = mail.jsp -->
	<div class="row">
		<div class="spacer_sm">&nbsp;</div>
		<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
			<fieldset>
				<legend><img src="<%=request.getContextPath()%>/public/img/ico_mail.png" alt=""></legend>
					 <div class="row">
					 	<div class="small-4 columns">
					 		<demdec:label path="recipientTo" labelKey="label.destinatari.TO"></demdec:label>
					 		<form:input path="recipientTo" placeholder="Inserire indirizzi separati da virgola"/>
					 	</div>
					 </div>
					 <div class="row">
					 	<div class="small-4 columns">
					 		<demdec:label path="recipientCc" labelKey="label.destinatari.Cc"></demdec:label>
					 		<form:input path="recipientCc" placeholder="Inserire indirizzi separati da virgola"/>
					 	</div>
					 </div>
					 <div class="row">
					 	<div class="small-4 columns">
					 		<demdec:label path="oggetto" labelKey="label.oggetto"></demdec:label>
					 		<form:input path="oggetto"/>
						</div>
					 </div>
					 
					 <div class="row">
					 	<div class="small-6 columns">
					 		<demdec:label path="message" labelKey="label.messaggio"></demdec:label>
					 		<form:textarea path="message" cssClass="height_100"/>
						</div>
					 </div>
					 <div class="row">
        				<div class="small-10 columns">
        					<nssb:buttons>
								<nssb:submit controllerCode="PecDaForm" keyValue="label.invio.pec.da.form" />
								<nssb:submit controllerCode="StandardMailDaForm" keyValue="label.invio.standardMail.da.form" />
							</nssb:buttons>
        				</div>
        			 </div>
			
			</fieldset>
		
	</div>
