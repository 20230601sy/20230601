const userObject = {
	init: function() {
		$('#btn-save').on('click', (e)=>{
			e.preventDefault();
			this.insertUser();
		})
	},
	insertUser: function() {
//		alert('회원가입요청');
		let user = {
			username: $('#username').val(), 
			password: $('#password').val(), 
			email: $('#email').val() 
		}
		$.ajax({
			url: '/auth/insertUser',
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(user)
		}).done(function(response){
//			console.log(response);
			// 위 코드 동작 확인 후 완료 후 다른 페이지로 이동하는 코드 필요
			alert(response.data);
			if(response.status == 200)
				location = "/";
		}).fail(function(error){
			console.log(error);
		})
	}
}

userObject.init();