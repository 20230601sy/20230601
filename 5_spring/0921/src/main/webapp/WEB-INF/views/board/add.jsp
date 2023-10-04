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
				<form role="form" action="/board/add" method="post">
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title">
					</div>

					<div class="form-group">
						<label>Text Area</label>
						<textarea class="form-control" rows="3" name="content"></textarea>
					</div>

					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer">
					</div>

					<button type="submit" class="btn btn-default">Submit Button</button>
					<button type="reset" class="btn btn-default">Reset Button</button>

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
	let formObj = $('form');
	$('button[type="submit"]').on('click', function(e){
		e.preventDefault();
//		alert('submit');
		let str = '';
		$('.uploadResult ul li').each(function(i, obj){
			let jobj = $(obj);
			str += '<input type="hidden" name="attachList[' + i + '].fileName" value="' + jobj.data('filename') + '">'; // fileName → filename데이터셋 이름에 대문자가 있는 건 다 소문자로 변하나봄... 
			str += '<input type="hidden" name="attachList[' + i + '].uuid" value="' + jobj.data('uuid') + '">'; 
			str += '<input type="hidden" name="attachList[' + i + '].uploadPath" value="' + jobj.data('path') + '">'; 
			str += '<input type="hidden" name="attachList[' + i + '].fileType" value="' + jobj.data('type') + '">'; 
		})
		formObj.append(str).submit();
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

	const cloneDiv = $('.uploadDiv').clone();

	$('.uploadResult').on('click', 'button', function(){
		let path = $(this).data('file');
		let type = $(this).data('type');
		let li = $(this).closest('li'); //parent();
		$.ajax({
			url: '/deleteFile',
			type: 'post',
			data: {
				fileName: path,
				type: type
			},
			success: function(result) {
				li.remove();
			}
		})
	})

</script>

<%@ include file="../includes/footer.jsp"%>