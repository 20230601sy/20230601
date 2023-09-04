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
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		// 저번에 했던 파라미터 쿼리스트링으로는 다른 페이지를 방문했다가 여기 페이지를 다시 방문했을 때 정보를 빼올 수 없는데...
		// 세션이라서 로그인 정보가 유지가 되는 거임
		// 브라우저 끄면 지워지고....
		// 여기서 처리 하나 더 남으셨다는데... 로그인 유효 기간 얘기이려나??? 흐음...
		// 브라우저를 껐다가 로그인 페이지(02_3_loginSuccess.jsp)로 바로 들어갈 때 얘기였음ㄷㄷ
		if(name == null)
			response.sendRedirect("02_1_loginForm.jsp");
		// login을 시도했던 사람인지 아닌지 구분할 state 변수 같은 것도 session에 담아둬야 할 듯
	%>
	<h1><%=id%> 로그인 성공</h1>
	<h1><%=name%>님 환영합니다.</h1>
	
	<form action="02_4_logout.jsp">
		<input type="submit" value="로그아웃"> 
	</form>
</body>
</html>