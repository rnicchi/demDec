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

<!-- PageName = creaFad.jsp -->
<demdec:useAttribute id="amministrazioniSelectedList"	name="<%=WebConstants.LIST_SELECTED_AMMS%>" />
<demdec:useAttribute id="indexesSelected"	name="<%=WebConstants.ROW_INDEX_SELECTED_AMMS%>" />
<demdec:useAttribute id="tipoDecList"	name="<%=WebConstants.LIST_TIPO_DEC%>" />
<demdec:useAttribute id="annoDecList"	name="<%=WebConstants.LIST_ANNO_DEC%>" />
<demdec:useAttribute id="tipologiaDecList"	name="<%=WebConstants.LIST_TIPOLOGIA_DEC%>" />
<demdec:useAttribute id="cdrSelectedList"	name="<%=WebConstants.LIST_SELECTED_CDRS%>" />	
<demdec:useAttribute id="ufficioList"	name="<%=WebConstants.LIST_ANAG_UFF%>" />
<demdec:useAttribute id="normativo"	name="<%=WebConstants.CHK_NORMATIVO%>" />	




	<div class="large-12 columns">
	<div class="spacer_sm">&nbsp;</div>
	
	<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message></div>
	
		
			
		<fieldset>
		
	

 		<div class="container_field"> 
			<div class="row">
				<div class="small-4 columns">
					<%-- <demdec:label path="tipoDec" labelKey="label.decreto.tipo.obb" /> --%>
					<label for="tipoDec"><spring:message code="label.decreto.tipo.obb"/></label>
					<form:select path="tipoDec" onChange="this.form.norm.value=0;">
					
						<c:if test="${normativo==1 }">
							<c:forEach var="t" items="${tipoDecList}">
								<c:if test="${t.id==22 }">
									<form:option value="${t.id}">${t.descSigla}</form:option>
								</c:if>
							</c:forEach>
						</c:if>
					
						<c:if test="${normativo!=1 }">
							<form:option value="" label="-- Selezionare un tipo decreto --" />
							<c:forEach var="t" items="${tipoDecList}">
								<form:option value="${t.id}">${t.descSigla}</form:option>
							</c:forEach>
						</c:if>
					</form:select>

				</div>
				
				<div class="small-3 columns">
					<%-- <demdec:label path="numDec" labelKey="label.decreto.numero.obb" /> --%>
					<label for="numDec"><spring:message code="label.decreto.numero.obb"/></label>
					<form:input path="numDec" size="6"  maxlength="6" />
				</div>
		
				<div class="left">
					<%-- <demdec:label path="annoDec" labelKey="label.decreto.anno.obb" /> --%>
					<label for="annoDec"><spring:message code="label.decreto.anno.obb"/></label>
					<form:select path="annoDec">
						<form:option value="" label="-- Selezionare un anno --" />

						<c:forEach var="anno" items="${annoDecList}">
							<form:option value="${anno.id}">${anno.id}</form:option>
						</c:forEach>
					</form:select>

				</div>
				
				
			</div>
		</div>
<div class="spacer_sm">&nbsp;</div>
			<div class="row">
			<form:hidden path="norm" />
			<div class="left" style="display: none;">
           		<demdec:submit styleId="settaTipologia" keyValue="button.load" controllerCode="caricaTipologia" titleKey="label.carica.tipologia" styleClass="subm_update posit-butt_up"  />
           	</div>
				<div class="small-2 columns">
					<%-- <demdec:label path="flagNormativo" labelKey="label.decreto.normativo" /> --%>
					<label for="flagNormativo"><spring:message code="label.decreto.normativo"/></label>
				</div> 
				<div class="left"> 
					<form:checkbox   path="flagNormativo"	id="flagNormativo" value="1"  onClick="this.form.norm.value=1; $('#settaTipologia').click(); "  />
				</div> 
			</div>
			<div class="row">

				<div class="small-12 columns">
					<%-- <demdec:label path="descDec" labelKey="label.decreto.descr.obb" /> --%>
					<label for="descDec"><spring:message code="label.decreto.descr.obb"/></label>
					<form:input path="descDec" maxlength="180" />
				</div>

			</div>
			
		
			


			<div class="row">
			
			   <div class="left">
            <demdec:submit  keyValue="button.load" controllerCode="caricaTipologia" titleKey="label.decreto.tipologia.carica" styleClass="subm_update posit-butt_up"  />
            </div>
			
			
				<div class="small-5 columns">

					<%-- <demdec:label path="tipologiaDec" labelKey="label.decreto.tipologia.obb" /> --%>
					<label for="tipologiaDec"><spring:message code="label.decreto.tipologia.obb"/></label>
						<c:if test="${normativo==1 }">
							<form:select path="tipologiaDec" >
											<c:forEach var="tipol" items="${tipologiaDecList}" >
												<c:if test="${tipol.id==4}">
													<form:option value="${tipol.id}">${tipol.descTipologia} </form:option>
												</c:if>
											</c:forEach>
							</form:select>
						</c:if>
						<c:if test="${normativo!=1 }">
							<form:select path="tipologiaDec" >
											<form:option value="" label="-- Selezionare una tipologia --" />
											<c:forEach var="tipol" items="${tipologiaDecList}" >
												<form:option value="${tipol.id}">${tipol.descTipologia} </form:option>
											</c:forEach>
							</form:select>
						</c:if>
									
							
					
				</div>
			</div>
			
			
			<div class="row">
				<div class="small-4 columns">

					<%-- <demdec:label path="ufficio" labelKey="label.ufficio.capofila.obb" /> --%>
					<label for="ufficio"><spring:message code="label.ufficio.capofila.obb"/></label>
						<form:select path="ufficio">
									<form:option value="" label="-- Selezionare un ufficio capofila --" />
									<c:forEach var="ufficio" items="${ufficioList}">
										<form:option value="${ufficio.id}">${ufficio.descUfficio} </form:option>
									</c:forEach>
								</form:select>
							<%-- <demdec:submit keyValue="button.load"
									controllerCode="caricaUffCapofila" titleKey="label.decreto.ufficio.capofila.carica"/> --%>
				</div>
			</div>

            <form:hidden path="numPatr" />
            <%-- Commentato 20/10/2015 
			<div class="row">

				<div class="small-3 columns">
					<demdec:label path="numPatr" labelKey="label.patrimonio.numero" />
					<form:input path="numPatr" size="3" maxlength="3" />
				</div>

			</div>
            --%>

			<div class="row">

				<div class="small-10 columns">
					<%-- <demdec:label path="ammRows" labelKey="label.amministrazione.obb" /> --%>
					<label for="ammRows"><spring:message code="label.amministrazione.obb"/></label>
					<c:choose>
							<c:when test="${ empty amministrazioniSelectedList}">
								<demdec:submit keyValue="label.sel.amm"
										controllerCode="caricaAmministrazioni"
										styleClass="buttonPag border-radius"  titleKey="label.sel.amm"/>
							</c:when>
						
							<c:otherwise>
	
									<demdec:displaytag-table
										name="pageScope.amministrazioniSelectedList" id="listAmmin" class="lux width100" >
										<display:caption>
											<span class="nascosto">Lista Amministrazioni Selezionate</span>
										</display:caption>
										
										<demdec:displaytag-column  titleKey="label.stp" class="center">
											<c:choose>
												<c:when test="${listAmmin.id.numeStpFormatted == 0}"> 
										    				0${listAmmin.id.numeStpFormatted}
											    </c:when>									    
											    <c:otherwise>
											    			${listAmmin.id.numeStpFormatted}
											    </c:otherwise>
											</c:choose> 
										</demdec:displaytag-column >

										<demdec:displaytag-column titleKey="label.app"
											property="id.numeApp"  class="center" />

										<demdec:displaytag-column titleKey="label.descrizione"
											property="descAmm"   />


										<%-- <demdec:displaytag-column class="w20px textAlignCenter"
											labelTitleKey="label.blank">

											<input title="Selezione Amministrazione" type="checkbox"
												name="ammRowsToDelete" value="${listAmmin_rowNum}" />

										</demdec:displaytag-column> --%>
					
									</demdec:displaytag-table>

									<%-- <demdec:submit keyValue="button.unselect"
										controllerCode="uncheckAmmin" titleKey="label.uncheck.amm" /> --%>
										<demdec:submit keyValue="label.mod.amm"
										controllerCode="caricaAmministrazioni"
										styleClass="buttonPag border-radius"  titleKey="label.mod.amm"/>
								</c:otherwise>
								</c:choose>
				
				</div>

			</div>

			

			<%-- <div class="row">

				<div class="small-10 columns">
					<demdec:label path="cdrRows" labelKey="label.cdr" />
				
				
					<c:choose>
						<c:when test="${ empty cdrSelectedList}">
					
							<demdec:submit keyValue="label.sel.cdr"
									controllerCode="caricaCdr"
									styleClass="buttonPag border-radius" titleKey="label.sel.cdr" />

						
						</c:when>
						
						<c:otherwise>
									<demdec:displaytag-table name="pageScope.cdrSelectedList"
										id="listCdr" class="lux width100" >
										<display:caption>
											<span class="nascosto">Lista Cdr</span>
										</display:caption>
										<demdec:displaytag-column titleKey="label.stp"
											property="id.fkNumeStp"  />

										<demdec:displaytag-column titleKey="label.app"
											property="id.fkNumeApp"  />

										<demdec:displaytag-column titleKey="label.numero"
											property="id.numeCdr" />

										<demdec:displaytag-column titleKey="label.descrizione"
											property="descCdr"  />
										   
										<demdec:displaytag-column class="w20px textAlignCenter"
											labelTitleKey="label.blank">

										 	<input title="Selezione Cdr" type="checkbox" 
												name="cdrRowsToDelete" value="${listCdr_rowNum}" /> 
												
										</demdec:displaytag-column>
					
									</demdec:displaytag-table>

									<demdec:submit keyValue="button.unselect"
										controllerCode="uncheckCdr" titleKey="label.uncheck.cdr"/>
									<demdec:submit keyValue="label.mod.cdr"
									controllerCode="caricaCdr"
									styleClass="buttonPag border-radius" titleKey="label.mod.cdr" />

								</c:otherwise>
								</c:choose>
					
				</div>

			</div>
 --%>

			<div class="spacer_sm">&nbsp;</div>

			<div class="row">
				<div class="small-10 columns">
					<demdec:submit keyValue="button.fad.crea"
						controllerCode="creaFad" titleKey="button.fad.crea" />
					<%--  <a href="<%=request.getContextPath() %>/public/ricercaRed.do?cmdGET___recuperaDatiModale=recuperaDatiModale">lnk</a> --%>
					<%-- 	 <demdec:linkButton labelKey="label.exportExcel" imageKey="ico.exportExcel" action="/public/ricercaRed.do" parameter="recuperaDatiModale" parameterValue="__EXPORT_GENERIC_EXCEL__" /> --%>
					<%--<demdec:submit keyValue="button.back" controllerCode="back" /> --%>

					<!--  button type="submit" >Cerca</button> -->
				</div>
			</div>

			<form:hidden path="ammRows" />
			<form:hidden path="cdrRows" />


		</fieldset>
	</div>

			

