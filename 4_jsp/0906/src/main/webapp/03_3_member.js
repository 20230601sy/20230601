function loginCheck() {
	if(document.frm.userid.value.length == 0){
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
		frm.pwd.focus();
		return false;
	}
	return true;
}

// 보통 중복창은 팝업창을 뜨게 하기도 하지만 ajax로... 새로고침 안되고 해당 화면에서 출력되도록 처리한다심
function idCheck() {
	if(document.frm.userid.value=="") {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	const url = "idcheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbar=yes, resizable=no, width=450, height=200"); 
}

function idok() {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	
	self.close();
}

// 애초에 이런 건 클라이언트에서 처리한다심 서버단에 넘기지 않는다심ㅋㅋㅋ 돈 아끼고 얼마나 좋음 ...
function joinCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
//	if (document.frm.reid.value != document.frm.userid.value) {
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	return true;
}