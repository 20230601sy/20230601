const url = "ws://localhost:8181/0919/chatServer";
//const url = "ws://172.30.1.86:8181/chat/chatingServer"; // 강사님 자리로 접속

let webSocket = new WebSocket(url);
let chatWindow = document.querySelector("#chatWindow");
let msg = document.querySelector("#msg");
let chatId = document.querySelector("#chatId");

function sendMsg() {
	chatWindow.innerHTML += '<div class="myMsg">나 : ' + msg.value + '</div>';
	webSocket.send(chatId.value + ":" + msg.value);
	msg.value = '';
	chatWindow.scrollTop = chatWindow.scrollHeight;
}

function enterKey() {
	if(window.event.keyCode == 13) {
		sendMsg();
	}
}

function disconnect() {
	webSocket.close();
}

webSocket.onopen = ()=>{
	chatWindow.innerHTML += '<div class="myMsg">채팅방에 접속하셨습니다.</div>';
};

webSocket.onclose = ()=>{
	chatWindow.innerHTML += '<div class="myMsg">채팅방을 나가셨습니다.</div>';
};

webSocket.onerror = ()=>{
	chatWindow.innerHTML += '<div class="myMsg">채팅서버 에러!</div>';
};

webSocket.onmessage = (e) => {
//	console.log(e);
//	chatWindow.innerHTML += '<div>' + e.data + '</div>';
	let rMsg = e.data.split(':');
	let sender = rMsg[0];
	let content = rMsg[1];
	
	if(content != '') {
		// DM 기능 추가
		if(content.match('/')){
			if(content.match('/' + chatId.value))
				chatWindow.innerHTML += '<div class="dmMsg">[DM] ' + sender + " : " + content.replace('/'+chatId.value+' ','') + '</div>';
		} else
			chatWindow.innerHTML += '<div>' + sender + " : " + content + '</div>';
	}
}