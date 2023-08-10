// 03_script.js
// 이벤트 클릭했을 때, 뭔가 변경됐을 때 모든 게 이벤트
// 더블클릭, 변경됐을 때, 마우스를 올렸을 때, 키보드를 눌렀을 때
// js에 쓰면 click...
// html에 쓰면 onclick 등 on 이 붙음, 대소문자구분하지 않음... 일반적으론 소문자만 씀, 리액트는 카멜케이스 써야 해서 onClick 요런 식으로 써야함
// js 이벤트 종류
// click - 클릭했을 경우
// contextmenu - 우클릭
// mouseover - 마우스 올렸을 때
// mouseout - 마우스 올려놨다가 빠져나갈 때
// mouseup - 마우스 버튼 눌렀다가 뗐을 때
// mousedown - 마우스 버튼 눌렀을 때
// mousemove - 움직였을 때

// input 관련한 요소
// submit - input 전송됐을 때
// focus - 마우스나 탭키 이용 커서 깜박거리는 거 획득했을 때
// keyup - 키보드 눌렀다가 뗐을 때
// keydown - 키보드 눌렀을 때

// 스크롤업, 다운 등 이것저것 더 많다심 필요한게 생기면 그때그때 "js 이벤트 종류" 검색 ㄱㄱ 하라심

// 클릭했을 때 작동하는 함수들을 이벤트 핸들러라고 한다심
function handler() {
  alert('hello');
}

// 이벤트를 js에서 직접 지정하는 거도 할 수 있음
btn.onclick = function(){ // id로 바로 contact 가능... btn. ...
  alert('두번째 hi');
}

// 이벤트 중복 지정 안됨 마지막에 넣은 걸로만 작동됨, 2번 alert하지 않음
bye.onclick = function(){
  alert('bye');
}

// 주의사항1
btn4.onclick = handler; // 함수명만 넣고 괄호 넣지 않음 유의할 것!, function() 괄호가 있다는 것은 함수 호출을 의미함!

// 주의사항2
// btn5.setAttribute('onclick', `function(){ alert('bye'); }`); // setAttribute 속성값은 문자열로 인식하기 때문에 function 직접 집어 넣는 것은 안됨... 문자열로 넣어도 안됨
btn5.setAttribute('onclick', "alert('bnt5')"); // 이런 건 되는 듯...
// btn5.setAttribute('onclick', 'handler()'); // 이것도 되는 듯...

// btn.addEventListner(이벤트, handler) 매개변수 세번째꺼도 있는데 그건 나중에 본다심...
document.querySelector('.a').addEventListener('click', handler); // 함수를 이미 만들어놨을 때
document.querySelector('.a2').addEventListener('click', function(){ alert('이벤트리스너 작업함');}); // 익명함수 넣기
document.querySelector('.a3').addEventListener('click', ()=>{ alert('화살표 함수를 더 많이 쓴다심... 아마도??ㅋㅋㅋ');}); // 헷갈릴까봐 function 형태로 보여주고 있다심...
// addEventListner로 작업하면 동일 click alert도 여러번 들어감... 기존 거에 새로운 거 추가가 됨
const fn2 = ()=>{ alert('2번 나오게 해보자!'); };
document.querySelector('.a').addEventListener('click', fn2); // 이건 추가로 작동함
document.querySelector('.a').addEventListener('click', handler); // 동일한 거 또 넣으면 작동은 안하는 듯

// 이벤트 제거도 가능함... 근데 익명함수로 추가한 거는 동일 익명함수로 인식하지 못하기 때문에 별도의 함수로 저장해놓고 써야 삭제 가능함
document.querySelector('.a4').addEventListener('click', handler);
document.querySelector('.a4').removeEventListener('click', handler);

// 이벤트 객체에 대해서 알아봅시다
document.querySelector('.b')
        .addEventListener('click', (event)=>{ // 대체적으로 event로 쓰거나 e로 쓰는 이것은.. 자바스크립트가 자체로 보내주는 것으로 이벤트가 발생된 정보를 담고 있음
          console.log(event); // clickX, Y 클릭한 좌표값, target 값 태그
          console.log(event.type +' 이벤트가 ' + event.target + '에서 발생'); // 객체로 저장되어 있기 때문에 . 찍으면 다 출력가능
          console.log('좌표값 : ' + event.clientX + ', ' + event.clientY);
          // console.log(event);
        });

