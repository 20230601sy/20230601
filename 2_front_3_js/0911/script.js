const joinBtn = document.querySelector(".join-btn");
const userName = document.querySelector(".name");
const userMail = document.querySelector(".email");
const userPwd = document.querySelector(".pwd");
const regexMail = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;

joinBtn.addEventListener("click", (e) => {
  e.preventDefault();

  if(userName.value==="" || userMail.value==="" || userPwd.value==="")
    alert("모든 필드를 입력하세요.");
  else if(!regexMail.test(userMail.value))
    alert("유효한 이메일 주소를 입력하세요.");
  else
    alert("회원가입 성공!");
});