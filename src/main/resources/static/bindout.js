var stompClient = null;

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

    var socket = new SockJS('/internal-nexmo-socket');

    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/toadcontrol', function (toadControl) {
            parseMessage(toadControl);
        });
    });
}

function parseMessage(toadControl)
{
	// TODO - more complex message notation
	var pitch = parseInt(JSON.parse(toadControl.body).pitch);

	playTone(pitch);
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function playTone(pitch)
{
	showGreeting( "Frog Sings at pitch "+ pitch )
    var audio = audio_sources[pitch]

    console.log(audio)

    audio.play();
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    var frog = document.getElementById("frog")
    var why = document.getElementById("why")


    audio_sources.map( audio => audio.onplay = function(){ frog.style.opacity = "0"; why.style.opacity = "1"})
    audio_sources.map( audio => audio.onended = function(){ frog.style.opacity = "1"; why.style.opacity = "0"})


    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});