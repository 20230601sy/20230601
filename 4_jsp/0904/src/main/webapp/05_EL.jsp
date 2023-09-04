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
		// http://localhost:8181/0904/05_EL.jsp?id=abc&num1=100&num2=200
		String id = request.getParameter("id");
	%>
	<hr>
	1. <%=id=="abc"%> <br>
	2. <%=id.equals("abc") %> <br>
	3. ${param.id=="abc"} <br>
	<hr>

	<%-- 자동 형변환 알아서 됨 ㄷㄷ parseInt 같은 거도 할 필요 없음... --%>
	${param.num1} + ${param.num2} = ${param.num1 + param.num2}
	<hr>
	
	<%
		pageContext.setAttribute("name", "page scope");
		request.setAttribute("name", "request scope");
		session.setAttribute("name", "session scope");
		application.setAttribute("name", "application scope");
	%>
	${name} ← 명시하지 않으면 가장 협소한 scope의 것을 출력<br>
	${pageScope.name} <br>
	${requestScope.name} <br>
	${sessionScope.name} <br>
	${applicationScope.name} <br>
</body>
</html>