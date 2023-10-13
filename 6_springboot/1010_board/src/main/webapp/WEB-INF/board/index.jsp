<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp" %>

<div class="container mt-3">
	<div class="card">
		<c:if test="${!empty postList}">
<%-- 			<c:forEach items="${postList}" var="post"> --%>
<!-- 			페이징 후 postList 출력해보기~ -->
<%-- 			<h1>${postList}</h1> --%>
<!-- 			Page 1 of 2 containing com.example.board.domain.Post instances 로 출력됨... -->
			<c:forEach items="${postList.content}" var="post">
				<div class="card-body">
					<h4 class="card-title">${post.title}</h4>
					<a href="/post/${post.id}" class="btn btn-secondary">상세보기</a>
				</div>
			</c:forEach>
			<br>
			<ul class="pagination justify-content-around">
				<li class="page-item ${postList.first? 'disabled' : ''}">
					<a class="page-link" href="?page=${postList.number-1}">이전</a>
				</li>
				<li class="page-item ${postList.last? 'disabled' : ''}">
					<a class="page-link" href="?page=${postList.number+1}">다음</a>
				</li>
			</ul>
		</c:if>
	</div>
</div>

<%@ include file="./layout/footer.jsp" %>