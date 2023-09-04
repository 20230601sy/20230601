<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean class="p03_sample.javabeans.C03_1_MemberBean" id="member"></jsp:useBean>
	<%-- member라는 빈 객체가 생성됨... 그리고 scope="page" 이기 때문에 다른 페이지에서 못 봄 session 같은 거에 담으면 (MemberBean) session.getAttribute("member") 로 빼서 사용 가능 --%>
	
	<%
		member.setName("고길동");
		member.setNickname("검성");
	%>
	<h1>자바 코드로 작업한 결과</h1>
	<h1><%=member.getName() %> (<%=member.getNickname() %>)</h1>
	<hr>
	<h1>액션 태그로 작업한 결과</h1>
	<jsp:setProperty property="name" name="member" value="홍길동"/>
	<jsp:setProperty property="nickname" name="member" value="hong"/>
	<h1>
		<jsp:getProperty property="name" name="member"/>
		(<jsp:getProperty property="nickname" name="member"/>)
	</h1>
</body>
</html>