
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <tiles:useAttribute name="action" classname="java.lang.String" /> 
 <demdec:useAttribute id="tipoDocList"	name="<%=WebConstants.LIST_TIPO_DOC%>" />
 <demdec:useAttribute id="ammList"	name="<%=WebConstants.LIST_AMMIN_DEM%>" />
  <demdec:useAttribute id="fascList"	name="<%=WebConstants.LIST_DOCUMENTI_FASCICOLO%>" />

<%-- <sbsj:useAttribute id="listTipoAtto" name="<%=WebConstants.LIST_TIPO_ATTO%>"/> --%>


<!-- <section id="lanci-servizi" class="margine-bottom"> -->
<div class="row">

 <div class="large-12 columns">
 <div class="spacer_sm">&nbsp;</div>
		<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
   <!--<h2>Newsletter</h2>-->
	<form:form enctype="multipart/form-data" modelAttribute="<%=SessionAttributes.FORM%>" id="multipartForm"> 
 <fieldset>
  
		

			<div class="row">
				<div class="small-4 columns">
					<demdec:label path="tipoDoc" labelKey="label.tipo.doc.obb" />

					<form:select path="tipoDoc">
						<form:option value="" label="-- Selezionare un tipo documento --" />

						<c:forEach var="t" items="${tipoDocList}">
							<form:option value="${t.id}">${t.descDescrizioneDoc}</form:option>
						</c:forEach>
					</form:select>

				</div>
			</div>
  
  

			<div class="row">
				<div class="small-4 columns">
					<demdec:label path="amm" labelKey="label.amministrazione.obb" />

					<form:select path="amm">
						<form:option value="" label="-- Selezionare un' amministrazione --" />

						<c:forEach var="amm" items="${ammList}" varStatus="st">
							<form:option value="${st.count}">${amm.amminWithDesc}</form:option>
						</c:forEach>
					</form:select>

				</div>
			</div>
			
			
			<div class="row">

				<div class="small-5 columns">
					<demdec:label path="desc" labelKey="label.descr.doc.obb" />
					<form:input path="desc" />
				</div>

			</div>
			
			
			
			<div class="row">
			
			   <div class="left">
            <demdec:submit keyValue="button.load" controllerCode="caricaFascicoli" titleKey="label.decreto.fascicolo.carica" styleClass="subm_update posit-butt_up"  />
            </div>
			
			
				<div class="small-5 columns">

					<demdec:label path="idFasc"
						labelKey="label.decreto.fascicolo.obb" />
					
						
						<form:select path="idFasc">
									<form:option value="" label="-- Selezionare un id fascicolo --" />
									<c:forEach var="fasc" items="${fascList}" >
										<form:option value="${fasc.id}">${fasc.eserciziDem.id}-${fasc.descSigla}-${fasc.numeNumDecreto}</form:option>
									</c:forEach>
								</form:select>
							
					
				</div>
			</div>
			
  <div class="row">
  
      <div class="small-10 columns">
          <demdec:label path="upFile" labelKey="label.uploadDec.obb"></demdec:label>
        <%--  <form:input path="upFile" class="text_upload" type="file"/>  --%>
         
          <input id="upFile" name="upFile" class="text_upload" type="file"  />
      </div>

  </div>
  

  <div class="row">
      <div class="small-10 columns">
      	<demdec:submit keyValue="button.upload" controllerCode="uploadFile" styleClass="button small"/>
		<demdec:submit keyValue="button.back"   controllerCode="back" styleClass="button small"/>
      
      </div>
  </div>
  
  
  
  
  
  </fieldset>
  </form:form>
 </div> 
 
 
 
 
</div>
