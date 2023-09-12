<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
				<c:forEach items="${boardList}" var="board" varStatus="status">
					<c:if test="${status.count>(param.page-1)*10 && status.count<=param.page*10}">
						<tr>
							<td>${board.no}</td>
							<td>
								<a href="detail.do?no=${board.no}">${board.title}</a>
							</td>
							<td>${board.id}</td>
							<td>${board.postdate}</td>
							<td>${board.visitcount}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<div class="text-center">
				
				<c:forEach items="${boardList}" var="board" varStatus="status">
					<c:if test="${status.count%10==1}">
						<a href="boardlist.do?page=${(status.count-1)/10+1}">
							<fmt:formatNumber value="${(status.count-1)/10+1}" pattern="0"/>
						</a>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</c:if>
</body>
</html>