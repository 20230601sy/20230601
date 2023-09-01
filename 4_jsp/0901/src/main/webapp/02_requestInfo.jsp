<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	컨택스트 패스 	: <%=request.getContextPath() %><br>
	요청방식		: <%=request.getMethod() %><br>
	요청 URL		: <%=request.getRequestURL() %><br>
	요청 ULI		: <%=request.getRequestURI() %><br>
	서버이름		: <%=request.getServerName() %><br>
	프로토콜		: <%=request.getProtocol() %><br>
	
	<!-- 
		컨택스트 패스 : /0901
		요청방식 : GET
		요청 URL : http://localhost:8181/0901/02_requestInfo.jsp
		요청 ULI : /0901/02_requestInfo.jsp
		서버이름 : localhost
		프로토콜 : HTTP/1.1
		프로토콜 요즘은 HTTPS이긴 한데 그거 지금 다루면 더 힘들어지니껜...
	 -->
</body>
</html>