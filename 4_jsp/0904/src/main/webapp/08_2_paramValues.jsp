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
	<%-- paramValues는 null이 되면 반복문 시키는 곳에서 에러 발생, 이거는 c:if로 감싸면 됨 자꾸 알아서 하라심ㅠㅋㅋㅋ --%>
	<c:forEach var="item" items="${paramValues.items}">
		<span>${item} </span>
	</c:forEach>
	
	<%-- c:forTokens --%>
	<c:forTokens items="" delims=""></c:forTokens>
</body>
</html>