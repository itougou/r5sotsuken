var stompClient = null;

function setConnected(connected) {	//接続・切断状態に伴う画面の変更処理
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

function connect() {	//サーバーへの接続処理
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        
        //2023.10.4 ito
        stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()+"さんが" , 'message': "接続しました!! " }));

        stompClient.subscribe('/topic/greetings', function (greeting) {	//サーバーからのデータを受信
            showGreeting(JSON.parse(greeting.body).content);	//画面へ受信データを表示
        });
    });
}

function disconnect() {	//サーバーとの切断処理
    if (stompClient !== null) {
		
		//2023.10.4 ito
        stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()+"さんが"  , 'message': "切断しました!!!" }));

        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {	//サーバーへデータを送信する処理
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(),'message': $("#message").val()}));
    $("#message").val('');
}

function showGreeting(message) {	//サーバーから受信したメッセージを表示する処理
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {	//初期処理（イベントハンドラーの登録等）
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
});

//setTimeout("connect()", 3000);
//connect();