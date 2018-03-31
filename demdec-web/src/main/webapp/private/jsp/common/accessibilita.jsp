<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="it" ><![endif]-->
<!--[if gt IE 8]><!-->
<html style="" class=" js no-touch svg inlinesvg svgclippaths no-ie8compat" lang="it"><!--<![endif]-->

	<head>
	
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<title><spring:message code="label.applicationTitle"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Fogli di stile CSS -->
		<link rel="stylesheet" href="<c:url value="/public/css/normalize.css"/>"/>
		<link rel="stylesheet" href="<c:url value="/public/css/foundation.css"/>"/>
		<link rel="stylesheet" href="<c:url value="/public/css/style_a.css"/>"/>  

		<link rel="stylesheet" href="<c:url value="/public/css/firebugR.css"/>"/>
		
<!-- Modernizr -->
		<script src="custom.js"></script>
		<script>
			Modernizr.load(	{
				test: Modernizr.mq('only all'),
				nope:'<c:url value="/private/js/respond.min.js"/>'
				}
			);
		</script>
		
	</head>
	
	<body>
		<div class="nascosto"><a href="#contenuto">Vai direttamente al contenuto</a></div>
		
<!-- Header/navigazione top bar -->
		<header class="fixed">
			<jsp:include page="info.jsp"/>
			
			<jsp:include page="header.jsp"/>
			
			<jsp:include page="menu.jsp"/>
		</header>
		
<!-- Inizio griglia -->
<!-- Sezione titoli in evidenza con slideshow -->
		<div class="container">
			<div class="spacer">&nbsp;</div>
			
			<a id="contenuto"></a>
			
			<span class="nascosto">Ti trovi in:</span>
			<span class="path_N"><a href="<c:url value="/private/menu.do"/>">Home</a> &nbsp;&#8250;&nbsp; Accessibilità</span>
			
			<div class="spacer_sm">&nbsp;</div>
<!-- Fine section -->

<!-- Sezione help -->
			<section id="lanci-servizi" class="margine-bottom">
				<div class="row">
					<div class="large-12 columns">
						<h2>Accessibilità</h2>
						<p>
							L'applicazione è stata sviluppata in HTML5, riconosciuto recommendation dal W3C nell'ottobre 2014 e realizzata nel rispetto dei 12 requisiti e relativi punti di controllo della legge Stanca (Legge 4 del 9 gennaio 2004).
							<br/><br/>
							L'utilizzo delle più diffuse best practices in materia di usabilità ed accessibilità, lo rendono accessibile e fruibile da chiunque.
							<br/>
							Tutte le pagine sono costruite nel pieno rispetto delle grammatiche formali pubblicate.
							<br/><br/>
							L'utilizzo di CSS e l'assenza di tabelle di impaginazione garantiscono la completa separazione tra contenuto e presentazione
							rendendo l'applicazione flessibile ed indipendente dal dispositivo adottato dall'utente.
							<br/>
							Tutte le pagine dell'applicazione sono state esaminate tramite validatori automatici e sono conformi alla DTD (Document Type Definition)
							<br/>
							Non sono stati utilizzati al di fuori dei CSS gli attributi per definire le caratteristiche grafiche della pagina.
							<br/><br/>
							L'applicazione è stata testata su tutti i principali browser e sono stati effettuato test e verifiche con lo screen reader, per migliorare la navigazione accessibile delle pagine stesse.
							<br/>
							Sono stati introdotti attributi, visibili solo con gli screen reader, che permettono di saltare direttamente all' area principale facilitando così la navigazione anche ad utenti non vedenti evitando ripetizioni di collegamenti già percorsi .
							<br/><br/>
							La presenza del percorso di navigazione permette di comprendere sempre in che punto dell'applicazione ci si trovi.
							<br/><br/>
							I colori utilizzati nel layout non sono aggressivi e garantiscono un adeguato contrasto cromatico tra colore di sfondo e primo piano, rendendo completamente fruibili le informazioni anche a persone con difficoltà visive.
							<br/><br/>
							I caratteri possono essere ingranditi con il proprio browser senza che ciò determini perdita di informazioni.
							<br/>
							Le pagine non presentano sfarfallii, scritte od oggetti lampeggianti, in modo da non provocare alcun disturbo all'utente.
						</p>
					</div>
				</div>
			</section>
			
			<div>
				<!--<div class="spacer_sm">&nbsp;</div>-->
			</div>
<!-- Footer -->
			<jsp:include page="footer.jsp"/>
		</div>
		<script src="<c:url value="/private/js/jquery.js"/>"> </script>
	
		<script src="<c:url value="/private/js/foundation.js"/>"> </script>

		<script>
		 $(document).foundation();
		</script>

		<script type="text/javascript">
		 $(window).load(function() {
		  $('#slideshow').orbit();
		 });
		</script>
	</body>
</html>