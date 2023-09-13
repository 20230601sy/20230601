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
		<div class="container text-center">
			<table class="table table-striped">
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
						<td>
							<a href="detail.do?no=${board.no}">${board.title}</a>
						</td>
						<td>${board.id}</td>
						<td>${board.postdate}</td>
						<td>${board.visitcount}</td>
					</tr>
				</c:forEach>
			</table>
			<c:forEach var="page" begin="1" end="${paging.totalPage}">
				<a class="btn btn${page== paging.page ? '' : '-outline'}-dark" href="boardlist.do?searchWord=${param.searchWord}&page=${page}&">${page}</a>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>