$(document).ready(function() {
  $('#content').summernote({
	  height: 300
  });
});

const postObject = {
	init : function() {
		$('#btn-insert').on('click', (e) => {
			e.preventDefault();
			this.insertPost();
		})
		
		$('#btn-update').on('click', (e) => {
			e.preventDefault();
			this.updatePost();
		})
		
		$('#btn-delete').on('click', (e) => {
			e.preventDefault();
			this.deletePost();
		})
	},
	
	insertPost: function() {
		alert('글작성 요청');
		let post = {
			title: $('#title').val(),
			content: $('#content').val()
		}
		
		$.ajax({
			url: '/post',
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(post)
		}).done(function(response) {
			
			if(response.status == 200)
				location = '/';
			else {
				let msg = '';
				
				if(response.data.title != null) {
					msg += response.data.title + '\n';
				}
				if(response.data.content != null) {
					msg += response.data.content + '\n';
				}
				
				alert(msg);
			}
		}).fail(function(error) {
			console.log(error);
		})
	},
	
	updatePost: function() {
		alert('글수정 요청');
		let post = {
			id: $('#id').val(),
			title: $('#title').val(),
			content: $('#content').val()
		}
		
		$.ajax({
			url: '/post',
			type: 'put',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(post)
		}).done(function(response) {
			alert(response.data);
			
			location = '/';
		}).fail(function(error) {
			console.log(error);
		})
	},
	
	deletePost: function() {
		alert('글삭제 요청');
		let id = $('#id').val();
		
		$.ajax({
			url: '/post/' + id,
			type: 'delete',
		}).done(function(response) {
			alert(response.data);
			
			location = '/';
		}).fail(function(error) {
			console.log(error);
		})
	}
}

postObject.init();