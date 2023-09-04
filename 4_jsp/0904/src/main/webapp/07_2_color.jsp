<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- core jstl if 조건문! else if 나 else 없음 계속 if로 써줘야 함 else가 없으니 choose가 있다심 여러모로 귀찮긴 하다심 --%>
	<c:if test="${param.color == 1}">
		<span style="color:red">빨강</span>
	</c:if>
	<c:if test="${param.color == 2}">
		<span style="color:green">초록</span>
	</c:if>
	<c:if test="${param.color == 3}">
		<span style="color:blue">파랑</span>
	</c:if>
	<hr>
	
	<%-- c:choose else 대신 otherwise가 쓰임 --%>
	<c:choose>
		<c:when test="${param.color == 1}">
			<span style="color:red">빨강</span>
		</c:when>
		<c:when test="${param.color == 2}">
			<span style="color:green">초록</span>
		</c:when>
		<c:otherwise>
			<span style="color:blue">파랑</span>
		</c:otherwise>
	</c:choose>
	<hr>
	
	<%-- c:forEach 반복문~ --%>
	<%-- <c:forEach [var="반복변수이름"] items="배열 같은 집합체"> 반복 실행 내용 </c:forEach> --%>
	<%
		String[] movieList = {"타이타닉", "시네마천국", "혹성탈출", "킹콩"};
		pageContext.setAttribute("movieList", movieList);
	%>
	<c:forEach var="movie" items="${movieList}">
		<span>${movie}</span><br>
	</c:forEach>
	<hr>
	<%-- varStatus라는 것을 만들면 그 안에 index(0부터 시작), count(반복횟수 1부터 시작) 값이 생성됨, 이거 말고도 더 있다심ㄷㄷㄷ --%>
	<%-- first, last 리턴은 true/false 반복이 처음인지 마지막인지 상태를 나타내주는 varStatus의 값 --%>
	<c:forEach var="movie" items="${movieList}" varStatus="status">
		<span>${status.count}. ${movie} first : ${status.first} / last : ${status.last} </span><br>
	</c:forEach>
	<hr>
	<%-- 배열이 없어도 몇부터 몇까지 몇씩 증가시키면서 반복시킬 것인지에 대한 반복문도 가능, var나 step은 선택사항 --%>
	<c:forEach var="cnt" begin="1" end="10" step="3">
		<span>${cnt} </span> 
	</c:forEach>
</body>
</html>