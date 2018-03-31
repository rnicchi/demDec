<%@page import="it.mef.bilancio.demdec.web.spring.utils.SessionAttributes"%>
<%@page import="it.almavivaitalia.bsn.sh.paginator.Paginator"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://almavivaitalia.web.sh/tags" prefix="demdec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<!-- PageName = afterRicercaFAD.jsp -->
<!-- Controller  ConsultaFascicoloFadController-->
<demdec:useAttribute id="paginator"     name="<%=SessionAttributes.OBJECT_PAGINATOR%>"/> 
<demdec:useAttribute id="listTipologiaTaglia" name="<%=SessionAttributes.LIST_TIPOLOGIA_TAGLIA%>"/> 


<demdec:useAttribute id="fascicoloPerTagliatella" name="<%=SessionAttributes.FASCICOLO_PER_TAGLIATELLA%>"/> 



<tiles:useAttribute name="action"/>


<div class="overlay"></div>



<div class="spacer_sm">&nbsp;</div>
<div>

<div class="spacer_sm">&nbsp;</div>
<div class="center padd-bott_5 font_size_riep">
    <span>&#8226; Tipo: </span>
    <span class="col_char_user"><strong>${fascicoloPerTagliatella.anagTipologiaDecreto.anagTipoDecreto.descSigla}</strong></span> 
  
    <span>&#8226; Numero:</span>
    <span class="col_char_user"><strong>${fascicoloPerTagliatella.numeNumDecreto}</strong></span> 
   
    <span>&#8226; Anno:</span>
    <span class="col_char_user"><strong>${fascicoloPerTagliatella.eserciziDem.id}</strong></span>    
</div>

<div class="row">
<div class="large-12 columns">
<br>

<div class="spacer_sm">&nbsp;</div>
<div class="col_char_user obb_fields"><spring:message code="label.required.fields"></spring:message>
</div>
<fieldset>
 
  
<div class="spacer_sm">&nbsp;</div>

	<c:if test="${not empty fascicoloPerTagliatella}">

		  <div class="row"> 
		      <div class="small-10 columns left">
		         <demdec:label path="descDecreto"  labelKey="label.decreto.descr.obb"/>
		         <form:input path="descDecreto" size="300" maxlength="300" /> 
		      </div>
		  </div>
<!--  	  
		  <div class="row"> 
		      <div class="small-3 columns">
		         <demdec:label path="tipologiaDecreto" labelKey="label.decreto.tipologia"> ${fascicoloPerTagliatella.anagTipologiaDecreto.descTipologia}</demdec:label>
		      </div>
		  </div>
		  <br>
	  
		  	<div class="row">
				<div class="small-4 columns left">
					<demdec:label path="tipologiaDecreto" labelKey="label.decreto.tipologia"/>
		       		 <form:select path="tipologiaDecreto" >
		       		 	<form:option value="" label="-- Selezionare Tipologia Decreto --" />
		          	  <c:forEach var="item" items="${listAnniEser}">		
							 <form:option value="${item.id}" >${item.id} </form:option> 
						</c:forEach>    	
		        	 </form:select>  
				</div>
			</div>
-->				
			
			
			<div class="row">
				<div class="small-4 columns left">
					<demdec:label path="tipologiaDecreto" labelKey="label.decreto.tipo.obb"/>
		       		 <form:select path="tipologiaDecreto" id="tipologiaDecreto" onchange="showfield(this.options[this.selectedIndex].value)" style="height: 26px;">
		       		 	<form:option value="" label="" />
		          		  <c:forEach var="item" items="${listTipologiaTaglia}">		
		          		  
							 <form:option value="${item.descTipoRiepilogo}" >${item.descTipoRiepilogo} </form:option> 
						</c:forEach>    		
		        	 </form:select> 
				</div>
				
				<!-- div1 serve per javascript in caso di Altro -->
				<div class="small-6 columns left" id="div1"></div>
				
			</div>
		  
		  
		  
		  	<div class="row">
				<div class="small-4 columns left">
					<demdec:label path="impattoIndebitamento" labelKey="label.decreto.impatto.indebitamento.obb"/>
		       		 <form:select path="impattoIndebitamento" style="height: 26px;">
		       		 	<form:option value="" label="" />
 						<form:option value="Si" label="Si" />
 						<form:option value="No" label="No" />
		        	 </form:select>  
				</div>
			</div>
					
	
		</c:if>	
</fieldset>			
			
			</div>
	</div>		
			
			
				<div class="small-10 columns">
				  <div class="row">
			        	<demdec:submit keyValue="button.predTagliatella.crea" controllerCode="stampa" />
			    <!--    	<demdec:submit keyValue="button.predTagliatella.salva" controllerCode="salva" />  -->
		        		<demdec:submit keyValue="button.back" controllerCode="back" />
			     </div> 
			    </div>
	
	
</div>

<script type="text/javascript">

function showfield(value){
	  if(value=='Altro')
	  	{
		  value='';
		  document.getElementById('div1').innerHTML='<br><input type="text" name="altraTipologiaDecreto" value="" />';
	  	}
	  else 
		{
		  document.getElementById('div1').innerHTML='';
		}
	}


</script>

