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
		// MVC1 패턴은 컨트롤러 자바 코드를 한 곳에 몰아 넣음
		int num = Integer.parseInt(request.getParameter("num"));
		// http://localhost:8181/0831/03_mvc1.jsp?num=10
		String result;
		if(num%2 == 0) {
			result = "짝수";
		} else {
			result = "홀수";
		}
		// 모델은 result라고 생각하면 된다심
	%>
	<h1><%=result%>입니다. 여기가 뷰단</h1>
</body>
</html>