<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@page import="it.mef.bilancio.demdec.web.spring.utils.WebConstants"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


<%-- <demdec:useAttribute id="listAnniEser" name="<%=WebConstants.LIST_ANNO_ESE%>"/> --%> 
<demdec:useAttribute id="listProfili" name="<%=WebConstants.LIST_PROFILI%>"/> 
<demdec:useAttribute id="listUffici"  name="<%=WebConstants.LIST_UFFICI%>"/> 
<demdec:useAttribute id="listAmm"  name="<%=WebConstants.LIST_AMMIN_DEM%>"/> 
<demdec:useAttribute id="listProfUfficiAmm"  name="<%=WebConstants.LIST_PROF_UFF_AMM%>"/> 
<demdec:useAttribute id="f" name="<%=BaseSessionAttributes.FORM%>" />
<demdec:useAttribute id="associaProfilo" name="<%=WebConstants.ASSOCIA_PROFILO %>" />


<div class="row">
<div class="large-12 columns">
<br>
 <div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
<fieldset>

	<div class="row"> 
		<div class="small-3 columns">
			<c:if test="${empty f.selectedCodiUtente}">
				<strong><demdec:label path="codiUtente" labelKey="label.oam.obb"/></strong>
				<form:input path="codiUtente" maxlength="50" /> 
			</c:if>
			<c:if test="${not empty f.selectedCodiUtente}">
				<%-- <demdec:label path="codiUtente" labelKey="label.oam.obb" labelParam="${f.codiUtente}"/> --%>
				<strong><demdec:label path="codiUtente" labelKey="label.oam.obb"/></strong>
				<form:input path="codiUtente" maxlength="50" readonly="true"/> 
				<%-- <form:hidden path="codiUtente"/> --%>
				<form:hidden path="selectedCodiUtente"/>
			</c:if> 
		</div>
	</div>
	<div class="spacer_sm">&nbsp;</div>
	<div class="row"> 
		<div class="small-3 columns">
			<demdec:label path="persCognome"  labelKey="label.persCognome.obb"/>
			<form:input path="persCognome" maxlength="50"/> 
		</div>
	</div>
	<div class="row"> 
		<div class="small-3 columns">
			<demdec:label path="persNome"  labelKey="label.persNome.obb"/>
			<form:input path="persNome" maxlength="50" /> 
		</div>
	</div>
   
  <div class="row"> 
      <div class="small-3 columns">
         <demdec:label path="indiEmail"  labelKey="label.indiEmail"/>
         <form:input path="indiEmail" maxlength="50" /> 
      </div>
  </div>
  <div class="row"> 
	       <div class="small-3 columns">
	         <demdec:label path="codiUtenteNsbf"  labelKey="label.codiNsbf"/>
	         <form:input path="codiUtenteNsbf" maxlength="50" /> 
	      </div>
	      <c:if test="${associaProfilo eq false}">
	      	<div class="small-7 columns">
					<demdec:submit	keyValue="label.associa.profilo" controllerCode="associaProfilo"/>
			</div> 
		  </c:if>
  </div>
 
 
</fieldset>


<c:if test="${associaProfilo eq true}">
<fieldset>
        <div class="row" >
            <div class="small-3 columns left">          		
           		<demdec:label path="profilo"  labelKey="label.profilo.obb"/>
           			
           		
					       		 <form:select path="profilo" id="profilo" onchange="changeTipoAmministrazione()"> 
					       		    <form:option value="" >&nbsp;</form:option> 
					          		<c:forEach var="msg" items="${listProfili}">
										 <form:option value="${msg.id}-${msg.descProfilo}" >${msg.descProfilo} </form:option> 
									</c:forEach>    		
					        	 </form:select> 
            </div>
			<div class="small-7 columns">
				<demdec:submit	keyValue="label.aggiungi.profilo" controllerCode="confermaProfilo"/>
			</div> 
        </div>
        <div class="row" >
            <div class="small-3 columns left">          		
           		<demdec:label path="ufficio"  labelKey="label.ufficio"/>
					       		 <form:select path="ufficio"   id="ufficio"> 
					       		    <form:option value="" >&nbsp;</form:option> 
					          		<c:forEach var="msg" items="${listUffici}">		
										 <form:option value="${msg.id}-${msg.descUfficio}" >${msg.descUfficio} </form:option>
									</c:forEach>
					        	 </form:select>
            </div>
        </div>
<%--   
		<div class="row">
			<div class="small-3 columns">
			       
				<demdec:label path="annoEse"  labelKey="label.annoEsercizio"/>
				<form:select path="annoEse"   > 
					<form:option value="" >&nbsp;</form:option>
					<c:forEach var="msg" items="${listAnniEser}">		
						<form:option value="${msg.id}" >${msg.id} </form:option> 
					</c:forEach>    		
				</form:select>  
			</div>
		</div>
 --%>
		<div class="row">
<%-- 			<div class="left">
				<demdec:submit keyValue="button.load" controllerCode="caricaAmministrazioni" styleClass="subm_update posit-butt_up"  title="Aggiorna Amministrazione"/>
			</div> --%>
			<div class="left" style="display: none;">
           		<demdec:submit styleId="caricaAmm" keyValue="button.load" controllerCode="caricaAmministrazioniProfili" titleKey="label.carica.tipologia" styleClass="subm_update posit-butt_up"  />
           	</div>
			<div class="small-5 columns">
				<demdec:label path="amministrazione"  labelKey="label.raccolteProvvisorie.amministrazione"/>
				<form:select path="amministrazione" >
					<form:option value="" label="-- Selezionare un'amministrazione --"/>

					<c:forEach var="msg" items="${listAmm}">	
						<c:choose> 
							<c:when test="${msg.id.numeStp<10}"> 
								<form:option value="${msg.id.fkAnnoEse}-0${msg.id.numeStp}-${msg.id.numeApp}-${msg.descAmm}" >0${msg.id.numeStp}${msg.id.numeApp} - ${msg.descAmm}</form:option> 
							</c:when>
							<c:otherwise>
								<form:option value="${msg.id.fkAnnoEse}-${msg.id.numeStp}-${msg.id.numeApp}-${msg.descAmm}" >${msg.id.numeStp}${msg.id.numeApp} - ${msg.descAmm}</form:option>
							</c:otherwise>
						</c:choose>   
					</c:forEach> 
				</form:select>
			</div>
		</div>

</fieldset>
         <c:if test="${not empty listProfUfficiAmm}">
        				<div class="row">

								<div class="small-12 columns">
								<!--  <demdec:label path="ammRows" labelKey="label.profilo.obb" />  -->	

      							    <demdec:displaytag-table
										name="pageScope.listProfUfficiAmm" id="listProfUfficiAmm" class="lux width100" >
										<display:caption>
											<span class="nascosto">Lista Valori Selezionati</span>
										</display:caption>
										
										<%-- <demdec:displaytag-column titleKey="" title="<input type='checkbox' id='selectall' title='Seleziona tutti' class='optim'/>" class="center">
														
										 <label for="radio_${listProfUfficiAmm_rowNum}" class="nascosto">Seleziona</label>
										
										<c:set var="idCheck" value="1"/>
										
										<form:checkbox path="idProfiloDaEliminare" value="${listProfUfficiAmm_rowNum}" cssClass="checkPlut optim"/> 
										</demdec:displaytag-column> --%>
										
										<demdec:displaytag-column titleKey="label.profilo" property="profilo.descProfilo" class="center" />
										<demdec:displaytag-column titleKey="label.ufficio" property="anagUffici.descUfficio"  class="center" />
										<demdec:displaytag-column titleKey="label.amministrazione" property="anagAmminDem.descAmm"   />
										<demdec:displaytag-column titleKey="label.profilo.principale"  class="center" >
												<c:choose >
											  	  	 <%-- <c:when test="${listProfUfficiAmm_rowNum==1}"> --%>
											  	  	 <c:when test="${listProfUfficiAmm.flagDefault01==1}">
											      		<form:radiobutton value="${listProfUfficiAmm_rowNum}"  path="radioButtonProfili" class="center" checked="checked"/>
											      	 </c:when>
											      	 <c:otherwise>
											      		 <form:radiobutton value="${listProfUfficiAmm_rowNum}"  path="radioButtonProfili" class="center" />
											      	 </c:otherwise>
											    </c:choose>
												<%-- <form:radiobutton value="${listProfUfficiAmm_rowNum}"  path="radioButtonProfili" class="center" /> --%>
										</demdec:displaytag-column>
										
										 <demdec:displaytag-column titleKey="label.delete" class="center">
											<demdec:submit styleId="btnDel${listProfUfficiAmm_rowNum}" styleClass="subm_none_del" keyValue="label.empty" titleKey="label.delete" controllerCode="onEliminaProfili?rigaProfiloDaEliminare=${listProfUfficiAmm_rowNum}" onclick="javascript:return confirm('Conferma cancellazione');"/>
										</demdec:displaytag-column> 
										
									</demdec:displaytag-table>
							<!--  	<div class="small-7 columns">   -->	
										    <br>
								<%-- 	<demdec:submit	keyValue="label.elimina.profili.selezionati" controllerCode="onEliminaProfili"/> --%>
							<!--		</div> -->	
<%-- 									<demdec:submit keyValue="label.mod.amm"
										controllerCode="caricaProfiloUfficioAmm"
										styleClass="buttonPag border-radius"  titleKey="label.mod.amm"/> --%>
  								</div>
						</div>
	</c:if>					
						
</c:if>
 
   <div class="row">
      <div class="small-10 columns">
		<c:if test="${empty f.selectedCodiUtente}">
			 <demdec:submit keyValue="button.salva" controllerCode="creaUtente" onclick="return confermaNuovoUtente();" />
		</c:if>
		<c:if test="${not empty f.selectedCodiUtente}">
		      	 <demdec:submit keyValue="button.conferma" controllerCode="modificaUtente" />
		</c:if>
        <!--   <demdec:submit keyValue="label.clean" controllerCode="pulisci" />  -->
         <demdec:submit keyValue="label.back" controllerCode="back" styleClass="button small"/>
      </div>
  </div>
  
 </div> 
 
</div>


<script type="text/javascript">
		
	function changeTipoAmministrazione(){
		$("#caricaAmm").click();
	}
	
	function confermaNuovoUtente(){
		if ($("#listProfUfficiAmm").length==0 && $("#codiUtente").val()!="" && $("#persCognome").val()!="" && $("#persNome").val()!=""){
			return confirm('L\'utente verr� creato senza nessun profilo associato. Procedere?');
		}else{
			return;
		}
	}
	
</script>