// 03_ex_alert.js
// function test() {
//   alert('hi');
// }

function show() {
  document.getElementById('msg').style.display = 'block';
}

function hide() { // 함수명 close로 했더니 안 되는 듯... ㄷㄷ
  document.getElementById('msg').style.display = 'none';
}

// 자바를 배웠으니까 매개변수 활용해서 함수 하나로 축약!
function showHide(dp) {
  document.getElementById('msg').style.display = dp;
}

// 알림창 내용 수정하고 싶다면. innerHTML ...
// const msgPath = document.getElementById('msg');
// function showHide2(msg) {
//   msgPath.style.display = 'block';
//   msgPath.innerHTML = msg; // HTML 내용을 다 없애기 때문에 x 버튼도 사라짐 ㄷㄷ
// }

// jQuery 문법으로 재탄생시켜봅시다.
const msg = $('#msg');
function showHide2(msg2) {
  msg.css('display', 'block');
  msg.html(msg2);
}
// jQuery 사용하게 되면 javascript랑 조합은 안된다심! 