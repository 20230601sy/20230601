<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</div>

			<div class="panel-body">
				<!-- <form role="form" action="/board/modify" method="post"> -->
				<form role="form" action="" method="">
					<div class="form-group">
						<label>No</label> <input class="form-control" name="bno" readonly value="${board.bno}">
					</div>
					
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title" value="${board.title}">
					</div>
	
					<div class="form-group">
						<label>Text Area</label>
						<textarea class="form-control" rows="3" name="content">${board.content}</textarea>
					</div>
	
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer" value="${board.writer}">
					</div>
					
					<%-- <button type="submit" class="btn btn-primary">수정</button>
					<button type="button" class="btn btn-danger" onclick='location.href="/board/remove?bno=${board.bno}"'>삭제</button> --%>
 					<button data-oper="modify" class="btn btn-primary">수정</button>
					<button data-oper="remove" class="btn btn-danger">삭제</button>
					<!-- <button type="button" class="btn btn-default" onclick='location.href="/board/list"'>목록</button> -->
					<button data-oper="list" type="button" class="btn btn-default">목록</button>
					
					<input name="pageNum" value="${paging.pageNum}" type="hidden">
					<input name="amount" value="${paging.amount}" type="hidden">
					<input name="type" value="${paging.type}" type="hidden">
					<input name="keyword" value="${paging.keyword}" type="hidden">
				</form>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">첨부 파일</div>
			<div class="panel-body">
				<div class="form-group uploadDiv">
					<input type="file" name="uploadFile" multiple>
				</div>
				<div class="uploadResult">
					<ul></ul>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$('button').on('click', function(e) { // legacy 는 버전이 낮아서 화살표 함수, 백틱...안된다심ㅋㅋㅋ
//	$('button').on('click', (e) => {
//		console.log(e.target.dataset["oper"]); // 되긴 하던데 뭔가 좋지 않다...
		const op = $(this).data('oper');
//		console.log(op);
		if(op == null)
			return false;
//		if(op == "list") {
//			location.href="/board/list";
//			return;
//		}
		
		e.preventDefault();
		const formTag = $('form');
		
		formTag.attr('action', '/board/' + op);
		if(op =="remove" || op =="list")
			formTag.attr('method', 'get');
		else if(op =="modify") {
			formTag.attr('method', 'post');
			let str = '';
			$('.uploadResult ul li').each(function(i, obj){
				let jobj = $(obj);
				str += '<input type="hidden" name="attachList[' + i + '].fileName" value="' + jobj.data('filename') + '">'; // fileName → filename데이터셋 이름에 대문자가 있는 건 다 소문자로 변하나봄... 
				str += '<input type="hidden" name="attachList[' + i + '].uuid" value="' + jobj.data('uuid') + '">'; 
				str += '<input type="hidden" name="attachList[' + i + '].uploadPath" value="' + jobj.data('path') + '">'; 
				str += '<input type="hidden" name="attachList[' + i + '].fileType" value="' + jobj.data('type') + '">'; 
			})
			formTag.append(str);
		}
		formTag.submit();
	});
</script>

<script>
	const bno = '<c:out value="${board.bno}"/>';
	$.getJSON('/board/getAttachList', {bno:bno}, function(attachList){
		let str = '';
		
		$(attachList).each(function(i, obj){
			let filePath = obj.uploadPath + '/' + obj.uuid + '_' + obj.fileName;
			filePath = encodeURIComponent(filePath);
			if(!obj.fileType){
				str += '<li data-path="' + obj.uploadPath + '" data-uuid="' + obj.uuid + '" data-fileName="' + obj.fileName + '" data-type="' + obj.fileType + '" >';
				str += '	<span>' + obj.fileName + '</span>';
				str += '	<button class="deleteBtn" data-file=\"' + filePath + '\" data-type="file">x</button><br>';
				str += '	<img src="/resources/img/attach.png">';
				str += '</li>';
			}
			else {
				let path = obj.uploadPath + '/s_' + obj.uuid + '_' + obj.fileName;
				path = encodeURIComponent(path);
				str += '<li data-path="' + obj.uploadPath + '" data-uuid="' + obj.uuid + '" data-fileName="' + obj.fileName + '" data-type="' + obj.fileType + '" >';
				str += '	<span>' + obj.fileName + '</span>';
				str += '	<button class="deleteBtn" data-file=\"' + path + '\" data-type="image">x</button><br>';
				str += '	<img src="/display?fileName=' + path + '">';
				str += '</li>';
			}
		})
		$('.uploadResult ul').append(str);
	})

	const regex = new RegExp('(.*?)\.(exe|zip|alz)$');
	const maxSize = 5242880;
	function checkFile(fileName, fileSize){
		if(fileSize > maxSize) {
			alert('파일 크기 초과');
			return false;
		}
		if(regex.test(fileName)) {
			alert('해당 확장자는 업로드 불가');
			return false;
		}
		return true;
	}
	function showUploadResult(uploadResultArr) {
		if(!uploadResultArr || uploadResultArr.length ==0)
			return;
		
		let uploadResult = $('.uploadResult ul');
		let str = '';
		
		$(uploadResultArr).each(function(i, obj){
			let filePath = obj.uploadPath + '/' + obj.uuid + '_' + obj.fileName;
			filePath = encodeURIComponent(filePath);
			if(!obj.image){
				str += '<li data-path="' + obj.uploadPath + '" data-uuid="' + obj.uuid + '" data-fileName="' + obj.fileName + '" data-type="' + obj.image + '" >';
				str += '	<span>' + obj.fileName + '</span>';
				str += '	<button class="deleteBtn" data-file=\"' + filePath + '\" data-type="file">x</button><br>';
				str += '	<img src="/resources/img/attach.png">';
				str += '</li>';
			}
			else {
				let path = obj.uploadPath + '/s_' + obj.uuid + '_' + obj.fileName;
				path = encodeURIComponent(path);
				str += '<li data-path="' + obj.uploadPath + '" data-uuid="' + obj.uuid + '" data-fileName="' + obj.fileName + '" data-type="' + obj.image + '" >';
				str += '	<span>' + obj.fileName + '</span>';
				str += '	<button class="deleteBtn" data-file=\"' + path + '\" data-type="image">x</button><br>';
				str += '	<img src="/display?fileName=' + path + '">';
				str += '</li>';
			}
		})
		uploadResult.append(str);
	}
	
	$('input[type="file"]').change(function(){
		let formData = new FormData();
		let inputFile = $('input[type="file"]');
		let files = inputFile[0].files;
		for(let i=0; i<files.length; i++){
			if(!checkFile(files[i].name, files[i].size))
				return false;
			formData.append('uploadFile', files[i]);
		}
		$.ajax({
			url: '/uploadAjax',
			processData: false,
			contentType: false,
			data: formData,
			type: 'post',
			
			success: function(result){
				showUploadResult(result);
			}
		})
	})

	$('.uploadResult').on('click', 'button', function(){
		if(confirm('정말로 삭제하시겠습니까?'))
			$(this).closest('li').remove();
		// 기존 add의 x는 서버에서 진짜 지워버리기 때문에...수정페이지에 들어갔다가 수정하지 않고 목록으로 갔다가 다시 해당 게시물을 조회할 경우 이미지가 없어서 깨지게 됨
		// 화면에서만 지워버림...
	})
</script>
<%@ include file="../includes/footer.jsp"%>