// 브라우저 기본동작
// a 태그 기능이라든지, form tag submit 버튼이라든지
// 이벤트를 별도로 설정 안 했음에도 동작하는 것들을 기본동작이라고 함
// 마우스 드래그 같은 거까지
// 만들다보면... 기본 동작이 작동 안 했으면 좋겠을 경우도 종종 생긴다심...
// 기본동작을 막아주는 것을 하려나 봄
// 방법이 여러 가지가 있는데...
// 1. onclick="return false" 이건 html tag에 직접 심고 1번만 사용 가능?하다심
// 2. 태그 안에 핸들러를 넣는 것보다 주로 사용하게 될 방법은 이벤트 객체 사용하는 것
// 다른 방법도 있지만 굳이 볼 건 없다심...
document.querySelector('.input').addEventListener('click', (e)=>{
  console.log('실행되나?');
  // submit이 새로 고침되면서 콘솔 내용이 사라짐
  // 이벤트 객체 사용해서 기본동작 막아줍시다!
  e.preventDefault();
  // 통신 방식 중에도 새로 고침 안하고 전송하는 것도 있긴 하지만...
  // 새로고침 없이 서버로 데이터를 전송하는 코드 넣어둔다음, 이런 걸 ajax...?? 라고 한다심
  // js에서 submit해줄 수 있으니까...
  // 요즘 앱으로 만든 것이나 인스타?는 새로고침 없이 딱딱딱 스무th하게 넘어간다심 리액트로 구현한 거라심 이건 개념이 다른 거라심
});

// 이벤트
// click 콘솔창에 xxx, dbclick 알림창
// click이 무조건 실행됨
// event가 겹칠 수 있음
// 코드를 어떻게 작성하느냐에 따라 먼저 작동 되는 게 달라짐
// mouseup, mousedown
// 기본 순서 mousedown → mouseup → click 순으로 실행된다심
// 일반적으론 겹치게 많이 만들지는 않지만...
btn.onclick = function(e) {
  // alert('test'); // 현재는 어떤 키보드를 누른 상태에서 클릭해도 모두 alert
  if(e.altKey)
    alert('alt!');
  // if(e.ctrlKey)
  //   alert('ctrl!');
  // if(e.shiftKey)
  //   alert('shift!');
  // 조합도 가능~
  if(e.ctrlKey && e.shiftKey)
    alert('ctrl & shift !!');
};
document.querySelector('div').addEventListener('click', (e) => {
  // 클릭 위치도 가능하다심...
  // console.log(e);
  // document.body.appendChild
  console.log(`clientX : ${e.clientX} clientY : ${e.clientY}`)
  console.log(`pageX : ${e.pageX} pageY : ${e.pageY}`)
  // clientX : 167 clientY : 251 pageX : 167 pageY : 951
  // client는 화면상 좌표값, 스크롤이 어디 있든 상관 없음. page는 전체 페이지를 기준으로 좌표값
  // 스크롤이 없으면 동일한 값
  document.querySelector('div').insertAdjacentHTML('beforeend', '<span>.</span>')
});

document.querySelector('h1').addEventListener('dblclick', (e) => {
  e.preventDefault(); // text 선택(drag)되는 기본 동작은 preventDefault가 안 막히는데 이건 순서의 차이...이미 더블클릭하기 전에 선택이 되버림..
  alert('doubleclick');
});

document.querySelector('h1').addEventListener('mousedown', (e) => {
  e.preventDefault(); // 마우스 누르자마자 작동되게 하면 선택하지 않음, 복사 방지, drag 안됨
});

// 선택은 할 수 있는데 복사만 안되게 하는 거... 물론 개발자도구에서 복사할 수는 있지만...
document.querySelector('p').addEventListener('copy', (e) => { // 이벤트가 copy라는 게 있는 거!
  e.preventDefault();
  alert('복사 금지!');
});

// 우클릭 금지는 contextmenu...
document.querySelector('p').addEventListener('contextmenu', (e) => { // 이벤트가 copy라는 게 있는 거!
  e.preventDefault();
  alert('우클릭 금지!');
});

// 배운 거 복습, 서버에서 끌어오는 거, 정규식 정도 남았다심