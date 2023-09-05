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
	<%-- <c:forTokens var="토큰을 저장할 변수명" items="토큰으로 나눌 하나의 문자열" delims="구분기호(여러 개 가능)">몸체</c:forTokens> --%>
	<c:forTokens var="city" items="서울,인천,대구,부산" delims=",">
		<span>${city}</span>
	</c:forTokens>
	<hr>
	<c:forTokens var="city" items="서울.인천,대구.부산" delims=",.">
		<span>${city}</span>
	</c:forTokens>
</body>
</html>