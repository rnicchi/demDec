<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://almavivaitalia.web.sh/tags" prefix="nssb"%>
<%@page import="it.almavivaitalia.web.sh.utils.BaseSessionAttributes"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!-- index.jsp -->
<%-- <div id="boxAvatar">
	<div class="grip">
	
		<img src="<%=request.getContextPath()%>/private/avatar/img/icon_avatar.png" alt="Attiva l'Assistente Virtuale" title="Attiva l'Assistente Virtuale" id="icona" />
	</div>
	<div class="video">
		<div id="txtNonUdenti">L'applicativo Dem Dec, "Dematerializzazione Decreti" permette di gestire un'area web condivisa dalla Ragioneria Generale dello Stato e dagli altri attori istituzionali coinvolti, allo stato attuale la Corte dei Conti. Esso consente il trasferimento immediato della documentazione tra i vari
soggetti, gestisce le utenze abilitate secondo profili coerenti con le funzioni istituzionalmente assegnate agli utenti stessi. Inoltre l'applicativo consente la completa tracciabilit� del processo e integra al suo interno le funzioni d'archivio assicurando sicurezza e funzionalit� nella conservazione dell'atto, flessibilit� e facilit� nella consultazione.</div>
		<!--[if IE]>
	<object id="myFlashMovie" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="250" height="200">
		<param name="movie" value="avatar/video/demdec.swf" />
		<param name="quality" value="high" />
		<param name="wmode" value="transparent" />
		<param name="loop" value="true" />
		<param name="play" value="false" />
	</object>
<![endif]--> 
		<!--[if !IE]>-->
		<object name="myFlashMovie" type="application/x-shockwave-flash" data="<%=request.getContextPath()%>/private/avatar/video/demdec.swf" width="250" height="200">
			<param name="quality" value="high" />
			<param name="wmode" value="transparent" />
			<param name="loop" value="true" />
			<param name="play" value="false" />
		</object>
<!--<![endif]--> 
	</div>
	<div id="button">
		<button type="button" id="playstopbutton" onClick="javascript:PlayStopFlashMovie();" value="avvia"><img id="playstopimage" src="<%=request.getContextPath()%>/private/avatar/img/play.png" alt="Avvia/Pausa" title="Avvia/Pausa" /></button>&nbsp;<button type="button" onClick="javascript:FirstFrame();" value="riavvolgi"><img src="<%=request.getContextPath()%>/private/avatar/img/rewind.png" alt="Riavvolgi" title="Riavvolgi" /></button>
	</div>
	<div class="nonUdenti">
		<img id="icon_text" src="<%=request.getContextPath()%>/private/avatar/img/icon_text.png" title="Attiva la versione testuale" alt="Attiva la versione testuale" />
	</div>
<noscript><span id="txtNoScript" title="Per usufruire dell'assistente virtuale � necessario avere javascript attivato. In alternativa potete consultare il manuale utente o l'help online">Assistente virtuale</span></noscript>
</div> --%>
		<section id="slideshow-titoli" class="margine-bottom margine-top">
			<div class="row">
				<div class="large-12 columns">
					<div class="orbit-container orbit-stack-on-small">
						<!--<ul style="margin-left: -200%; width: 500%; height: 317px;" class="orbit-slides-container" data-orbit="" id="slideshow" data-options="timer_speed:3500; bullets:false; pause_on_hover: true; resume_on_mouseout: true;">-->
						<ul class="orbit-slides-container" data-orbit="" id="slideshow" data-options="timer_speed:3500; bullets:false; pause_on_hover: true; resume_on_mouseout: true;">
							<!--<li style="width: 20%;" data-orbit-slide=""><img src="img/try_3.jpg" alt=""/></li>-->
							<li style="width: 20%;" class=""><img src="<%=request.getContextPath()%>/public/img/try_1.jpg" alt=""></li>
							<li class="active" style="width: 20%;"><img src="<%=request.getContextPath()%>/public/img/try_2.jpg" alt=""></li>
							<!--<li class="" style="width: 20%;"><img src="img/try_3.jpg" alt=""></li>-->
							<!--<li style="width: 20%;" data-orbit-slide=""><img src="img/1_new.png" alt=""></li></ul><a href="#" class="orbit-prev">Prev <span></span></a><a href="#" class="orbit-next">Next <span></span></a><div class="orbit-slide-number"><span>2</span> of <span>3</span></div><div style="" class="orbit-timer paused"><span></span><div style="width: 44.8286%; overflow: hidden;" class="orbit-progress"></div></div></div>-->
							<!--<li style="width: 20%;" data-orbit-slide=""><img src="img/try_3.jpg" alt=""></li>-->
						</ul>
						<a href="#" class="orbit-prev">Prev <span></span></a><a href="#" class="orbit-next">Next <span></span></a>
						<div class="orbit-slide-number"><span>2</span> of <span>3</span></div>
						<div style="" class="orbit-timer paused">
							<span></span>
							<div style="width: 44.8286%; overflow: hidden;" class="orbit-progress"></div>
						</div>
					</div>
				</div><!-- Fine large-12 -->
			</div><!-- Fine row -->
		</section><!-- Fine section -->
		
		<!-- Sezione  -->
		<section id="promo" class="margine-bottom">
			<div class="row">
				<div class="large-12 columns">
					<h2>Tipologie sezioni</h2>
					<div style="" class="section-container accordion" data-section="accordion">
						<section style="" class="active">
							<p style="left: 0px;" class="title back-css" data-section-title=""><a href="#">Raccolte provvisorie</a></p>
							<div class="content" data-section-content="">
								<p>La sezione <strong>Raccolte provvisorie</strong> ... ipsum dolor sit amet, consectetur adipisicing elit, sed
								do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
							</div>
						</section>
						<section>
							<p style="left: 621px;" class="title back-php" data-section-title=""><a href="#">FAD</a></p>
							<div class="content" data-section-content="">
								<p>La sezione <strong>FAD</strong> ... ipsum dolor sit amet, consectetur adipisicing elit, sed
								do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
								ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
								aliquip ex ea commodo consequat. </p>
							</div>
						</section>
						<section>
							<p style="left: 1242px;" class="title back-javascript" data-section-title=""><a href="#">Workflow Firma</a></p>
							<div class="content" data-section-content="">
								<p>La sezione <strong>Workflow Firma</strong> ... ipsum dolor sit amet, consectetur adipisicing elit, sed
								do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
								ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
								aliquip ex ea commodo consequat. </p>
							</div>
						</section>
					</div>
				</div><!-- Fine large-12 -->
			</div><!-- Fine row -->
		</section><!-- Fine section -->
	
