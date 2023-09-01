<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1>
	<%
		// response.sendRedirect("http://www.google.com");

		// 보통 리다이렉트는 서블릿으로 작업이 된다심 
		// jsp에는 버튼 같은 거 만들고 서블릿으로 넘어가도록 구현하고, 서블릿에서 sendRedirect 처리를 한다심
		// 지금 단계에서는 단순해서 걍 바로 링크해도 될 것 같지만 나중에 선처리할 것들이 생기면 그것도 다 처리를 하려고 징검다리 역할을 하도록 하게 하는 거라심...
		// 예를 들어 로그인의 경우 사용자들이 버튼은 같은 걸 눌렀지만 로그인 성공했을 경우 다음으로 넘어 가고 로그인 실패했을 경우 로그인 실패 페이지가 나오게 해야 하는 그런...
	%>
	<form action="03_2_sendRedirect.jsp">
		<input type="number" name="id">
		<input type="submit" value="이동">
	</form>
</body>
</html>