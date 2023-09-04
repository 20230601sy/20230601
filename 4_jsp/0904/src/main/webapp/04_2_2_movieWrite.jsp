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
		request.setCharacterEncoding("utf-8");
	%>
	
	<jsp:useBean id="movie" class="p04_2_com.mission.javabeans.MovieBean"/>
	<jsp:setProperty property="*" name="movie"/>
	
	<h1>입력 완료된 정보</h1>
	<table>
		<tr>
			<td>제목</td>
			<td><jsp:getProperty property="title" name="movie"/></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><jsp:getProperty property="price" name="movie"/>원</td>
		</tr>
		<tr>
			<td>감독</td>
			<td><jsp:getProperty property="director" name="movie"/></td>
		</tr>
		<tr>
			<td>출연배우</td>
			<td><jsp:getProperty property="actor" name="movie"/></td>
		</tr>
		<tr>
			<td>시놉시스</td>
			<td><jsp:getProperty property="synopsis" name="movie"/></td>
		</tr>
		<tr>
			<td>장르</td>
			<td><jsp:getProperty property="genre" name="movie"/></td>
		</tr>
	</table>
	
	<%
		String title = request.getParameter("title");
	%>
	<%=title %>
	<%-- 표현 언어를 쓰면 위에 4줄이 1줄로 바뀜, 비교하는 것도 equals 안 써도 됨! param은 내장 객체! paramValues도 배열형태로 받아올 수 있는 내장 객체 --%>
	${param.title}
	${param["title"]}
	${param.title == "abc"}
</body>
</html>