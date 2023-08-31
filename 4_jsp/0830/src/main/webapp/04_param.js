function check() {
	if(document.frm.id.value == '') {
		alert("아이디를 입력하세요");
		document.frm.id.focus(); // id 입력하게 작업
		return false; 
	} else if(document.frm.age.value == '') {
		alert("나이를 입력하세요");
		document.frm.age.focus();
		return false; 
	} else {
		return true;
	}
}