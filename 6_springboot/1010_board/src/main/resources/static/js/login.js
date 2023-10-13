const loginObject = {
	init: function() {
		$('#btn-login').on('click', ()=>{
			this.login();
		})
	},
	login: function() {
//		alert('로그인 요청');
		let user = {
			username: $('#username').val(), 
			password: $('#password').val()
		}
		$.ajax({
			url: '/auth/login',
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(user)
		}).done(function(response){
//			alert(response.data);
			if(response.status == 200)
				location = "/";
		}).fail(function(error){
			console.log(error);
		})
	}
}

loginObject.init();