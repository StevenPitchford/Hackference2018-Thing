var stompClient = null;
var stompClient2 = null;

const speeds = [-50, -35, -20, -5, 10, 25, 40, 55, 70, 85]
const audio_sources = speeds.map( speed => new Audio("https://res.cloudinary.com/dhgfwvimc/video/upload/e_accelerate:" + speed + "/v1539462373/froggy/croak.mp3"))

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/toadcontrol', function (greeting) {
            //parseMessage(greeting);
            console.log( JSON.parse(greeting.body) );
//        	var tone = parseInt(JSON.parse(greeting.body).pitch);
            console.log("STOP USING THIS");

        });
    });

    var socket2 = new SockJS('/nexmo-socket');
    stompClient2 = Stomp.over(socket2);
    stompClient2.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/button', function (greeting) {
            parseMessage(greeting);
        });
    });
}

function parseMessage(greeting)
{
	// TODO - more complex message notation
	var tone = parseInt(JSON.parse(greeting.body).content);

	playTone(tone);
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function playTone(tone)
{
	showGreeting( "Frog Sings at pitch "+ tone )
    var audio = audio_sources[tone]

    console.log(audio)

    audio.play();
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    var frog = document.getElementById("frog")
    var why = document.getElementById("why")


    audio_sources.map( audio => audio.onplay = function(){ frog.style.opacity = 0; why.style.opacity = 1})
    audio_sources.map( audio => audio.onended = function(){ frog.style.opacity = 1; why.style.opacity = 0})


    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});