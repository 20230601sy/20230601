<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>채팅방 접속</h1>
	닉네임 : <input type="text" id="chatId">
	<button onclick="chatOpen()">접속</button>
	
	<script>
		function chatOpen() {
			const id = document.querySelector("#chatId");
			if(id.value=="") {
				alert('닉네임을 입력하세요');
				return;
			}
			window.open('02_2_chatWindow.jsp?chatId='+id.value, "", "width=400, height=600");
		}
	</script>
</body>
</html>