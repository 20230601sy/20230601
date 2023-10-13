$(document).ready(function() {
	$('#content').summernote({
		height: 500
	});
});

const postObject = {
	init: function() {
		$('#btn-insert').on('click', (e)=>{
			e.preventDefault();
			this.insertPost();
		})
		$('#btn-update').on('click', ()=>{
			this.updatePost();
		})
		$('#btn-delete').on('click', ()=>{
			this.deletePost();
		})
	},
	insertPost: function() {
//		alert('글작성 요청');
		let post = {
			title: $('#title').val(), 
			content: $('#content').val()
		};
		$.ajax({
			url: '/post/insertPost',
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(post)
		}).done(function(response){
			alert(response.data);
			if(response.status == 200)
				location = "/";
		}).fail(function(error){
			console.log(error);
		});
	},
	updatePost: function() {
		let post = {
			id: $('#id').val(), 
			title: $('#title').val(), 
			content: $('#content').val()
		};
		$.ajax({
			url: '/post',
			type: 'put',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(post)
		}).done(function(response){
			alert(response.data);
			if(response.status == 200)
				location = "/";
		}).fail(function(error){
			console.log(error);
		});
	},
	deletePost: function() {
		$.ajax({
			url: location.href,
			type: 'delete'
		}).done(function(response){
			alert(response.data);
			if(response.status == 200)
				location = "/";
		}).fail(function(error){
			console.log(error);
		});
	}
}

postObject.init();