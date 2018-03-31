function getFlashMovieObject(movieName) {
	if (window.document[movieName]) {
		return window.document[movieName];
	}
	if (navigator.appName.indexOf("Microsoft Internet") == -1) {
		if (document.embeds && document.embeds[movieName])
			return document.embeds[movieName];
	} else // if (navigator.appName.indexOf("Microsoft Internet")!=-1)
	{
		return document.getElementById(movieName);
	}
}

function StopFlashMovie() {
	var flashMovie = getFlashMovieObject("myFlashMovie");
	flashMovie.StopPlay();
}

function PlayFlashMovie() {
	var flashMovie = getFlashMovieObject("myFlashMovie");
	flashMovie.Play();
}

function FirstFrame() {
	var button = $("#playstopbutton");
	var buttonValue = button.attr("value");
	var flashMovie = getFlashMovieObject("myFlashMovie");
	var buttonImg = $("#playstopimage");
	buttonImg.attr('src','avatar/img/play.png');
	button.val('avvia');
	StopFlashMovie();
	var html = $('#boxAvatar').html();
	$('#boxAvatar').html(html);
	addGripBehaviour();
	nonUdentifunc();
}



function PlayStopFlashMovie() {
	var button = $("#playstopbutton");
	var buttonValue = button.attr("value");
	if (buttonValue == 'avvia') {
		var buttonImg = $("#playstopimage");
		buttonImg.attr('src','avatar/img/pause.png');
		button.val('pausa');
		PlayFlashMovie();
	} else {
		var buttonImg = $("#playstopimage");
		buttonImg.attr('src','avatar/img/play.png');
		button.val('avvia');
		StopFlashMovie();
	}
}

// gestione cambio immagine box avatar

flashMovie = null;

$(document).ready(function() 
{
	addGripBehaviour();
	nonUdentifunc();
});

function addGripBehaviour() {
		$(".grip").click(function(){
		if($(this).parent().css("right")=="-273px") {
			$(this).parent().animate({'right':'0px'},400);
			$("#icona").attr("src","avatar/img/icon_avatarOff.png");
			$("#icona").attr("title","Chiudi l'Assistente Virtuale");
			$("#icona").attr("alt","Chiudi l'Assistente Virtuale");
			$('#player').fadeIn(0);			
		}
		else {
			$(this).parent().animate({'right':'-273px'},400);
			$("#icona").attr("src","avatar/img/icon_avatar.png");
			$("#icona").attr("title","Attiva l'Assistente Virtuale");
			$("#icona").attr("alt","Attiva l'Assistente Virtuale");
			$('#player').fadeOut(400);
		}
	});
}

// gestione versione testuale

function nonUdentifunc() {
			$(".nonUdenti").click(function(){
		if($("#txtNonUdenti").css("right")=="-270px") {
			$("#txtNonUdenti").animate({'right':'9px'},400);
			$("#icon_text").attr("title","Disattiva la versione testuale");
			$("#icon_text").attr("alt","Disattiva la versione testuale");
			$("#icon_text").attr("src","avatar/img/icon_movie.png");
		}
		else {
			$("#txtNonUdenti").animate({'right':'-270'},400);			
			$("#icon_text").attr("title","Attiva la versione testuale");
			$("#icon_text").attr("alt","Attiva la versione testuale");
			$("#icon_text").attr("src","avatar/img/icon_text.png");
		}
	});
}