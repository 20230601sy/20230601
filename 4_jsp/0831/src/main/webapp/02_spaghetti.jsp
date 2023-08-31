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
		int num = Integer.parseInt(request.getParameter("num"));
		// http://localhost:8181/0831/02_spaghetti.jsp?num=10 같은 걸로 접속해야 함
		if(num%2 == 0) {
		// 태그는 스크립트릿 안에 넣을 수는 없으니... 바깥
	%>
			<h1>짝수입니다.</h1>
	<%
		} else {
	%>		
			<h1>홀수입니다.</h1>
	<%
		}
		// 블럭 닫겠다고 스크립트릿을 또 써야 하다니 화가 난다!!! 이런 게 맛없는 스파게티 코드 우웩 
	%>
</body>
</html>