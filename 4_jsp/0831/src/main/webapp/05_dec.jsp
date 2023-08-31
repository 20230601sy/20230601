<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String str = "안녕하세요";
	int a = 5, b = -5;
	int global_cnt = 0;
	public int abs(int n) {
		return (n<0)? -n : n;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int local_cnt = 0;
		global_cnt++;
		local_cnt++;
		out.print("<h1>스크립트릿에 작성한 코드 결과</h1>");
		out.print("global : " + global_cnt + "<br>"); // 변경이 안 됐을 때, 브라우저 새로 고침하면 global_cnt는 계속 증가됨...서버 쪽에 만들어진 변수 개념...클래스 변수 개념이랑 똑같음
		out.print("local : " + local_cnt + "<br>");
		
		out.print(str + "<br>");
		out.print(a + "의 절대값 : " + abs(a) + "<br>");
		out.print(b + "의 절대값 : " + abs(b) + "<br>");
	%>
	<h1>html영역에 표현식으로 작성한 코드 결과</h1>
	<h1>global : <%=global_cnt %></h1>
	<h1>local : <%=local_cnt %></h1>
	<h1>5 + 10 = <%=5+10%></h1>
	<h1>abs함수 호출 결과 : <%=abs(-12)%></h1>
	<h1>함수 호출 결과 : <%="리턴해주는값이 없는 함수를 표현식 안에 호출하면 에러 발생, 이런 거 하지 맙시다"%></h1>
	<!-- html 주석은 개발자도구에서 볼 수 있엄 -->
	<%-- 이렇게 쓴 주석은 개발자도구에서 볼 수 없음! --%>
</body>
</html>