<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp" %>    

	
	<div class="container mt-3">
		<c:if test="${!empty postList}">
			<c:forEach items="${postList.content}" var="post">
			      <div class="card">
			         <div class="card-body">
			            <h4 class="card-title">${post.title}</h4>
			            <a href="/post/${post.id}" class="btn btn-secondary">상세보기</a>
			         </div>
			      </div>
	      	</c:forEach>
	      		
	      	 <br>
			 <ul class="pagination justify-content-between">
			   	<li class="page-item ${postList.first ? 'disabled' : ''}">
			       <a class="page-link" href="?page=${postList.number - 1}">이전</a>
			    </li>
			    <li class="page-item ${postList.last ? 'disabled' : ''}">
			       <a class="page-link" href="?page=${postList.number + 1}">다음</a>
			    </li>
			</ul>
			
	    </c:if>
    </div>
	
<%@ include file="./layout/footer.jsp" %>