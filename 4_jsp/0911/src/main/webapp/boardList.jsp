<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${! empty boardList}">	
		<div class="container">
			<table class="table table-striped text-center">
				<thead class="table-dark">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					<tr>
				</thead>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.no}</td>
						<td>${board.title}</td>
						<td>${board.id}</td>
						<td>${board.postdate}</td>
						<td>${board.visitcount}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>