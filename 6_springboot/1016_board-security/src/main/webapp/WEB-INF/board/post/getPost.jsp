<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container border py-3 mt-3">
	<div>
		<h3>${post.title}</h3>
	</div>
	<div>
		<p>${post.content}</p>
	</div>
	<div>
		<p>포스트 번호 : ${post.id}</p>
		<p>작성자 : ${post.user.username}</p>
	</div>
	<hr>
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<c:if test="${principal.username==post.user.username}">
<%-- 	<c:if test="${principal.id==post.user.id}"> --%>
		<a href="/post/updatePost/${post.id}" class="btn btn-warning">수정하기</a>
		<button id="btn-delete" class="btn btn-danger">삭제하기</button>
		<input type="hidden" id="id" value="${post.id}">
	</c:if>
	<br><br>
	<div class="container mt-3">
		<table class="table">
			<c:if test="${!empty post.replyList}">
				<thead>
					<tr>
						<th colspan="12"><h4>댓글 목록</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th class="col-9 col-sm-6">내용</th>
						<th class="col-1 col-sm-2">작성자</th>
						<th class="col-1 col-sm-2">수정</th>
						<th class="col-1 col-sm-2">삭제</th>
					</tr>
					<c:forEach items="${post.replyList}" var="reply">
						<tr>
							<td class="col-9 col-sm-6">
								<input class="form-control input-reply-update-${reply.id}" value="${reply.content}">
							</td>
							<td class="col-1 col-sm-2">
								<input class="form-control" value="${reply.user.username}" disabled>
							</td>
							<c:if test="${principal.id==reply.user.id}">
								<td class="col-1 col-sm-2">
									<button class="btn btn-warning btn-reply-update" data-replyId="${reply.id}">수정</button>
								</td>
								<td class="col-1 col-sm-2">
									<button class="btn btn-danger btn-reply-delete" data-replyId="${reply.id}">삭제</button>
								</td>
							</c:if>
						<tr>
					</c:forEach>
				</c:if>
				<tr align="right">
					<td  colspan="12">
						<textarea id="reply-content" rows="2" class="form-control"></textarea>
						<button id="btn-save-reply" class="btn btn-secondary mt-3">댓글 등록</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<script src="/js/post.js"></script>
<script src="/js/reply.js"></script>
<%@ include file="../layout/footer.jsp" %>