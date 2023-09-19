<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#chatWindow {
		border: 1px solid black;
		width: 286px;
		height: 500px;
		overflow: scroll;
		margin: 5px 0px;
	}
	.myMsg {
		color: blue;
	}
	.dmMsg {
		color: lightgrey;
	}
</style>
</head>
<body>
	<div>
		닉네임 : <input value="${param.chatId}" id="chatId" readonly>
		<button id="exitBtn" onclick="disconnect()">종료</button>
	</div>
	<div id="chatWindow"></div>
	<div>
		메세지 : <input id="msg" onkeyup="enterKey()">
		<button id="sendBtn" onclick="sendMsg()">전송</button>
	</div>
	<script src="02_3_chat.js"></script>
</body>
</html>