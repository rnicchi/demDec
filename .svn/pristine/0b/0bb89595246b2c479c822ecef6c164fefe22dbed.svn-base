<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<demdec:useAttribute id="utente" name="<%=SessionAttributes.OBJECT_USER%>"/>
<demdec:useAttribute id="profilo" name="<%=SessionAttributes.OBJECT_PROFILO%>"/>

<section id="lanci-servizi" class="margine-bottom">
	<div class="row">
		<div class="large-12 columns">
			<fieldset>
				<div class="row">
					<div class="small-6 columns">
						<fieldset>
							<legend>Profilo attuale: <span class="col_char_user">${profilo.descProfilo}</span></legend>
							
							<demdec:label path="codiProfilo" labelKey="label.nuovo.profilo"/>
<!-- 							<label for="Uff_Ass">Selezionare il nuovo profilo</label> -->
							<form:select path="codiProfilo">
								<form:option value="" >&nbsp;</form:option>
								<c:forEach items="${utente.utenteProfiloList}" var="profili">
									<form:option value="${profili.id.codiProfilo}">${profili.descProfilo}</form:option>
								</c:forEach>
							</form:select>
						</fieldset>
					</div>
				</div>
				
				<div class="row">
					<div class="small-10 columns">
						<demdec:submit keyValue="label.confirm" controllerCode="nuovoProfilo"/>
					</div>
				</div>
			</fieldset>
		</div>
	</div>
</section> 
