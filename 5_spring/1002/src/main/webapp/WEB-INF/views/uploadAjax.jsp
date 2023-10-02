<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .uploadResult {
      width: 100%;
      background-color: lightgray;
   }
   
   .uploadResult ul {
      display: flex;
      flex-flow: row;
      justify-content: center;
      align-items: center;
   }
   
   .uploadResult ul li {
      list-style: none;
      padding: 10px;
   }
   
   .uploadResult ul li img {
      width: 50px;
      height: 50px;
   }
   
   .bigPictureWrapper {
      position: absolute;
      display: none;
      justify-content: center;
      align-items: center;
      top: 0%;
      width: 100%;
      height: 100%;
      background-color: gray;
      z-index: 100;
      background: rgba(255, 255, 255, 0.5);
   }
   
   .bigPicture {
      position: relative;
      display: flex;
      justify-content: center;
      align-items: center;
   }
   
   .bigPicture img {
      width: 600px;
   }
</style>
</head>
<body>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	<button id="uploadBtn">전송</button>
	<div class="uploadResult">
		<ul></ul>
	</div>
	<div class="bigPictureWrapper">
		<div class="bigPicture"></div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
	const cloneDiv = $('.uploadDiv').clone();
	const regex = new RegExp('(.*?)\.(exe|sh|zip|alz)$'); // 압축파일에 암호 걸어두면 브라우저 자체 검사를 못함...그래서 그런 건 올리지 못하게 하는 작업을...
	const maxSize = 5242880; // 5mb
	const uploadResult = $('.uploadResult ul');
	
	function showImage(filePath) {
//		alert(filePath);
		$('.bigPictureWrapper').css('display', 'flex').show();
		$('.bigPicture').html('<img src="/display?fileName=' + encodeURI(filePath) + '">')
						.animate({width:'100%', height:'100%'}, 1000);
	}
	$('.bigPictureWrapper').on('click', function(){
		$('.bigPicture').animate({width:'0%', height:'0%'}, 1000);
		setTimeout(()=>{
			$(this).hide();
		}, 1000)
	})
	$('.uploadResult').on('click', 'span', function(){
		let path = $(this).data('file');
		let type = $(this).data('type');
		let li = $(this).parent();
		$.ajax({
			url: '/deleteFile',
			type: 'post',
			data: {
				fileName: path,
				type: type
			},
			success: function(result) {
				li.remove();
				alert(result);
			}
		})
	})
	function showUploadFile(uploadResultArr) {
		let str = '';
		$(uploadResultArr).each(function(i, obj){
			/* str += '<li>' + obj.fileName + '</li>'; */
			let filePath = obj.uploadPath + '/' + obj.uuid + '_' + obj.fileName;
			filePath = encodeURIComponent(filePath); // 위에 RegExp 대신에 이걸로 해도 됐음 ㅡ_ㅡ
//			let filePath = obj.uploadPath.replace(new RegExp(/\\/g), '/') + '/' + obj.uuid + '_' + obj.fileName;
			
			if(!obj.image){
				str += '<li>';
				str += '	<a href="/download?fileName=' + filePath + '">';
				str += '		<img src="resources/img/attach.png">' + obj.fileName;
				str += '	</a>';
				str += '<span data-file=\"' + filePath + '\" data-type="file">x</span>';
				str += '</li>';
			}
			else { // 요청을 날려서 이미지를 받아와야 함 ㄷㄷㄷ
				let path = obj.uploadPath + '/s_' + obj.uuid + '_' + obj.fileName;
//				console.log(path);
				path = encodeURIComponent(path);
				let oriPath = obj.uploadPath + '/' + obj.uuid + '_' + obj.fileName;
				oriPath = oriPath.replace(new RegExp(/\\/g), '/');
				str += '<li>';
				str += '	<a href=\'javascript:showImage(\"'+ oriPath + '\")\'>';
				str += '		<img src="/display?fileName=' + path + '">' + obj.fileName;
				str += '	</a>';
				str += '<span data-file=\"' + path + '\" data-type="image">x</span>';
				str += '</li>';
			}
		})
		uploadResult.append(str);
	}
	
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
	
	$('#uploadBtn').on('click', function(){
		let formData = new FormData();
		let inputFile = $('input');
//		console.log(inputFile);
		let files = inputFile[0].files;
//		console.log(files);
		for(let i=0; i<files.length; i++){
			if(!checkFile(files[i].name, files[i].size)){
				return false;
			}
			formData.append('uploadFile', files[i]);
		}
		
		$.ajax({
			url: 'uploadAjax',
			processData: false,
			contentType: false,
			data: formData,
			type: 'post',
			
			success: function(result){
//				console.log(result);
				alert('업로드 완료');
				$('.uploadDiv').html(cloneDiv.html());
				showUploadFile(result);
			}
		})
	})
</script>
</html>