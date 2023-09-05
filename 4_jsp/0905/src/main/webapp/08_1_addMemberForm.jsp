<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="08_2_addMember.jsp" method="post">
		이름 <input type="text" name="name"> <br>
		아이디 <input type="text" name="userid"> <br>
		비밀번호 <input type="text" name="pwd"> <br>
		이메일 <input type="text" name="email"> <br>
		전화번호 <input type="text" name="phone"> <br>
		등급 <input type="radio" name="admin" value="1"> 관리자 
			<input type="radio" name="admin" value="0"> 일반회원 <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>