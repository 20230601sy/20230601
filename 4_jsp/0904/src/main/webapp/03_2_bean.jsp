<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8"); // post 방식이라서 요청에서 받는 거를 한글 깨지는 거 방지해줘야 함
	%>
	<jsp:useBean class="p03_sample.javabeans.C03_1_MemberBean" id="member" />
	<jsp:setProperty property="*" name="member"/>
	
	이름 	<jsp:getProperty property="name" name="member"/> 		<br>
	아이디	<jsp:getProperty property="userid" name="member"/> 		<br>
	별명 	<jsp:getProperty property="nickname" name="member"/> 	<br>
	비밀번호 	<jsp:getProperty property="pwd" name="member"/> 		<br>
	이메일 	<jsp:getProperty property="email" name="member"/> 		<br>
	전화번호 	<jsp:getProperty property="phone" name="member"/> 		<br>
</body>
</html>