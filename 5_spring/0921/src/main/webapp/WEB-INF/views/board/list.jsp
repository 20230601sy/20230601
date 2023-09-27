<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List Page
				<a href="/board/add" class="btn btn-xs btn-primary pull-right">글작성</a>
				<button id="addBtn" class="btn btn-xs btn-info pull-right">글작성</button>
			</div>

			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="board">
						<tr>
							<td>${board.bno}</td>
							<td>
								<%-- <a href="/board/get?bno=${board.bno}"> --%>
								<a class="move" href="${board.bno}">
									${board.title} [${board.replyCnt}]
								</a>
							</td>
							<td>${board.writer}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate}" /></td>
						</tr>
					</c:forEach>
				</table>
				
				<div id="myModal" class="modal fade" tabindex="-1" area-hidden="true" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
								<h5 class="modal-title">Modal title</h5>
							</div>
							<div class="modal-body">
								<p>Modal body text goes here.</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save changes</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<form id="searchForm" action="/board/list">
						<select name="type">
							<option value="T" ${pageInfo.paging.type=='T' ? 'selected' : ''}>제목</option>
							<option value="C" ${pageInfo.paging.type=='C' ? 'selected' : ''}>내용</option>
							<option value="W" ${pageInfo.paging.type=='W' ? 'selected' : ''}>작성자</option>
							<option value="TC" ${pageInfo.paging.type=='TC' ? 'selected' : ''}>제목, 내용</option>
							<option value="TW" ${pageInfo.paging.type=='TW' ? 'selected' : ''}>제목, 작성자</option>
							<option value="CW" ${pageInfo.paging.type=='CW' ? 'selected' : ''}>내용, 작성자</option>
							<option value="TCW" ${pageInfo.paging.type=='TCW' ? 'selected' : ''}>제목, 내용, 작성자</option>
						</select>
						<input name="keyword" value="${pageInfo.paging.keyword}">
						<input type="hidden" name="pageNum" value="${pageInfo.paging.pageNum}">
						<input type="hidden" name="amount" value="${pageInfo.paging.amount}">
						<button>검색</button>
					</form>
				</div>
			</div>
			
			<div class="pull-right">
				<ul class="pagination">
					<c:if test="${pageInfo.prev }">
						<li class="page-item">
							<a class="page-link" href="${pageInfo.startPage - 1}">Previous</a>
						</li>
					</c:if>
					<c:forEach begin="${pageInfo.startPage}" end="${pageInfo.endPage}" var="num">
						<li class="page-item ${pageInfo.paging.pageNum == num ? 'active' : ''}">
							<a class="page-link" href="${num}">${num}</a> <!-- 야매로 href 썼지만 dataset 쓰라심... -->
						</li>
					</c:forEach>
					<c:if test="${pageInfo.next}">
						<li class="page-item">
							<a class="page-link" href="${pageInfo.endPage + 1}">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>
<form id="actionForm" action="/board/list">
	<input name="pageNum" value="${pageInfo.paging.pageNum}" type="hidden">
	<input name="amount" value="${pageInfo.paging.amount}" type="hidden">
	<input name="type" value="${pageInfo.paging.type}" type="hidden">
	<input name="keyword" value="${pageInfo.paging.keyword}" type="hidden">
</form>
<script>
//	$(document).ready() // 문서가 읽혀지면 실행되는 함수
	$(document).ready(() => {
		const result = '<c:out value="${result}" />';
		// console.log('확인 : ' + result);
		if(result != '') {
			if(isNaN(result))
				$('.modal-body').html(result);
			else
				$('.modal-body').html(result + '번 게시글 등록 완료');
			$('#myModal').modal('show');
		}
	})
	$('#addBtn').on('click', () => self.location = '/board/add');
	
	const actionForm = $('#actionForm');
	$('.pagination > .page-item > .page-link').on('click', function(e){
		e.preventDefault();
		// console.log($(this).attr("href"));
		actionForm.find('input[name="pageNum"]').val($(this).attr("href"));
		actionForm.attr('action', '/board/list');
		actionForm.submit();	
	});
	
	$('.move').on('click', function(e){
		e.preventDefault();
		actionForm.append("<input type='hidden' name='bno' value='" + $(this).attr('href') + "'>");
		actionForm.attr('action', '/board/get');
		actionForm.submit();
	});
	
	const searchForm = $('#searchForm');
	$('#searchForm button').on('click', function(e){
		e.preventDefault();
		if(searchForm.find('input[name="keyword"]').val()=='') {
			alert('검색어를 입력하세요.');
			return;
		}
		searchForm.find('input[name="pageNum"]').val('1');
		searchForm.submit();
	});
</script>
<%@ include file="../includes/footer.jsp"%>